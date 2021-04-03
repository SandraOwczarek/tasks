#!/usr/bin/env bash

start_runcrud() {
  echo "Welcome!"
   ./runcrud.sh
}

fail() {
   echo "There were errors"
}

if start_runcrud; then
  /usr/bin/open -a Safari http://localhost:8080/crud/v1/task/getTasks
else
   fail
fi