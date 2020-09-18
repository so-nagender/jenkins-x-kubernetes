// Evaluates env tag.
def parseEnv(String bN){
    def tE
    def isKB = (bN ==~ /.*\/kahani\/.*/)
    def isTB = (bN ==~ /group\/.*/)
    if(isKB)
        tE = bN.replaceFirst(/\/.*/,"")
        return tE
    } else if(isTB) {
        tE = bN.replace("group/","")
        return tE
    } else if(bN == "master") {
        return "master-jack"
    }else if(bN == "qa") {
        return "qa"
    }else if(bN == "staging") {
        return  bN
    } else {
        tE = bN.replace("/","-")
        return tE
   }
}
println "${parseEnv(args[0])}";