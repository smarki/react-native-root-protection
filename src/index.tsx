import { NativeModules, Platform } from 'react-native';

const LINKING_ERROR =
  `The package 'react-native-root-protection' doesn't seem to be linked. Make sure: \n\n` +
  Platform.select({ ios: "- You have run 'pod install'\n", default: '' }) +
  '- You rebuilt the app after installing the package\n' +
  '- You are not using Expo managed workflow\n';

const RootProtection = NativeModules.RootProtection
  ? NativeModules.RootProtection
  : new Proxy(
      {},
      {
        get() {
          throw new Error(LINKING_ERROR);
        },
      }
    );

export function isRooted(): boolean {
  return RootProtection.isRooted();
}

export function isEmulator(): boolean {
  return RootProtection.isEmulator();
}
