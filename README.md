# react-native-root-protection

Add root and emulator protection to your React Native app

## Installation

```sh
npm install react-native-root-protection
```

## Usage

```js
import { isRooted, isEmulator } from 'react-native-root-protection';

// ...

const isCompromised = isRooted() || isEmulator();
```

## Tested with

- Android Studio emulators
- Genymotion
- BlueMotion
- MeMU
- LD Player

## Contributing

See the [contributing guide](CONTRIBUTING.md) to learn how to contribute to the repository and the development workflow.

## License

MIT
