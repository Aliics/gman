#!/usr/bin/env bash

BIN_DIR=/usr/bin
GMAN_BIN_DIR=/usr/share/gman
GMAN_WRAPPER=gman.sh

pushd src/main/scripts/ > /dev/null || exit

echo "Creating gman bin dir in ${GMAN_BIN_DIR}"
if [ -d ${GMAN_BIN_DIR} ]; then
    echo "Directory ${GMAN_BIN_DIR} already exists."
else
    mkdir -p ${GMAN_BIN_DIR}
fi

cp ../../../build/libs/gman.jar ${GMAN_BIN_DIR}

echo "Cloning gman wrapper into ${BIN_DIR}"
cp ${GMAN_WRAPPER} ${BIN_DIR}/gman

popd > /dev/null || exit

echo "Done!"
