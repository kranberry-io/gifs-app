### BITRISE COMMANDS ###
change-file-permission:
	chmod +x scripts/ci/set-java-11.sh

install-java-11: change-file-permission
	scripts/ci/set-java-11.sh

### BUILD ####
buildDebug:
	./gradlew assembleDebug

buildAndroidTestDebug:
	./gradlew assembleDebugAndroidTest

### INSTALL ###
installDebug:
	adb install app/build/outputs/apk/debug/app-debug.apk

installAndroidTestDebug:
	adb install app/build/outputs/apk/androidTest/debug/app-debug-androidTest.apk

buildInstallDebug: buildDebug installDebug

### TEST ###
testDebug:
	./gradlew testDebug

testFileDebug:
	./gradlew testDebug --tests $(file)

androidTestDebug:
	./gradlew connectedDebugAndroidTest

androidTestDebugModule:
	./gradlew :$(module):connectedDebugAndroidTest

androidTestFileDebugModule:
	./gradlew :$(module):connectedDebugAndroidTest -Pandroid.testInstrumentationRunnerArguments.class=$(file)

### RUN UI TESTS ###
# before run tests make sure to call: buildDebug buildAndroidTestDebug installDebug installAndroidTestDebug
test: buildDebug buildAndroidTestDebug installDebug installAndroidTestDebug
	@adb logcat *:S KRANBERRY_LOG:V & LOGCAT_PID=$$!; \
	TERM=dumb adb shell am instrument -w -e package com.angelicao.gifapp.giflist com.angelicao.gifapp.test/androidx.test.runner.AndroidJUnitRunner ; \
	RESULT=$$?; \
	if [ -n "$$LOGCAT_PID" ]; then kill $$LOGCAT_PID; fi; \
	exit $$RESULT