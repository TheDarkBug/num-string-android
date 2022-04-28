ANDROID_NDK_HOME = $(HOME)/Android/Sdk/ndk
GENERATED = target/aarch64-linux-android/debug/libnum_string.so

build:
	ANDROID_NDK_HOME=$(ANDROID_NDK_HOME) cargo +nightly ndk -t arm64-v8a build -Zbuild-std
	rm -r ../app/src/main/jniLibs
	mkdir -p ../app/src/main/jniLibs/{arm64-v8a,armeabi-v7a,x86}
	cp $(GENERATED) ../app/src/main/jniLibs/arm64-v8a
	cp $(GENERATED) ../app/src/main/jniLibs/armeabi-v7a
	cp $(GENERATED) ../app/src/main/jniLibs/x86


