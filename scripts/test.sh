#!/bin/sh
set -eu
cd "$(dirname "$0")/.."
sh scripts/build.sh
mkdir -p build/test-classes
javac --release 20 -encoding UTF-8 -cp build/classes -d build/test-classes tests/PersistenceSmokeTest.java
test_home=$(mktemp -d)
java -Duser.home="$test_home" -cp build/classes:build/test-classes PersistenceSmokeTest
# Laisser le dossier de test en cas d'échec pour pouvoir l'inspecter.
rm -- "$test_home/palimpseste.dat"
rmdir -- "$test_home"
