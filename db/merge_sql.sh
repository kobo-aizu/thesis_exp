#!/usr/bin/env bash
if [ -e ./initializeDB.sql ]; then
  rm ./initializeDB.sql
fi

cat ./makemodel.sql ./seeds.sql  > ./initializeDB.sql