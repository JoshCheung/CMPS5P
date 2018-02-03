#!/bin/bash
student_path=$1
expected_text=$2
cd $student_path
for py_file in $(find . -name '*.py'); do
  student_name=$(basename $(dirname $py_file))
  echo "testing $py_file ($student_name)"
  echo "5" | python ${py_file} > /tmp/output.txt
  diff ${expected_text} /tmp/output.txt
  if [[ $? == 0 ]]; then
      echo "SUCCESS: $py_file"
  else
      echo "FAILED: $py_file"
  fi
done