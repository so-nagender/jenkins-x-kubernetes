#!/bin/bash

echo "eval tag script....."
branchName="mav/story/oncehub-12345"
branchName="team/hurricanes"
teamBranchReg="team\/.*"
storyBranchReg=".*\/story\/.*"
if [[ $branchName =~ $teamBranchReg ]]; then
  tag=$(echo $branchName | sed 's/team\//''/g' )
elif [[ $branchName =~ $storyBranchReg ]]; then
  echo "story $branchName"
  tag=$(echo $branchName | sed 's/\/.*/''/g' )
elif [[ $branchName == "master" ]]; then
  tag="prod"
elif [[ $branchName == "qa" || $branchName == "staging-app2" ]]; then
  tag=$branchName
else
  echo "random branch...."
  tag="${branchName//\//'-'}"
fi
echo "target................... $tag"
echo $tag > tag

