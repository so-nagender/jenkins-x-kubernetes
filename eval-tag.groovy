// Evaluates tag for a base branch.
def parseTargetEnvironment(String branchName){
    def targetEnv
    def isStoryBranch = (branchName ==~ /.*\/story\/.*/)
    def isTeamBranch = (branchName ==~ /team\/.*/)
    if(isStoryBranch) {
        targetEnv = branchName.replaceFirst(/\/.*/,"")
        return targetEnv
    } else if(isTeamBranch) {
        targetEnv = branchName.replace("team/","")
        return targetEnv
    } else if(branchName == "master") {
        return "prod"
    }else if(branchName == "qa") {
        return "qa"
    }else if(branchName == "staging-app2") {
        return  branchName
    } else {
        targetEnv = branchName.replace("/","-")
        return targetEnv
   }
}
println "${parseTargetEnvironment(args[0])}";