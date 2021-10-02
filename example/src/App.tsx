import * as React from 'react';

import { StyleSheet, View, Text } from 'react-native';
import { isEmulator, isRooted } from 'react-native-root-protection';

export default function App() {
  const [result, setResult] = React.useState<
    { isRooted: boolean; isEmulator: boolean } | undefined
  >();

  React.useEffect(() => {
    setResult({
      isEmulator: isEmulator(),
      isRooted: isRooted(),
    });
  }, []);

  return (
    <View style={styles.container}>
      <Text>Is emulator: {String(result?.isEmulator)}</Text>
      <Text>Is rooted: {String(result?.isRooted)}</Text>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
  box: {
    width: 60,
    height: 60,
    marginVertical: 20,
  },
});
