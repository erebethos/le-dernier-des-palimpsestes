#!/bin/sh
set -eu
cd "$(dirname "$0")/.."
mkdir -p build/classes dist
find src -type f -name '*.java' | sort > build/sources.txt
javac --release 20 -encoding UTF-8 -d build/classes @build/sources.txt
jar --create --file dist/le_dernier_des_palimpsestes.jar \
    --main-class le_dernier_des_palimpsestes.Main -C build/classes .
printf '%s\n' 'Build OK: java -jar dist/le_dernier_des_palimpsestes.jar'
