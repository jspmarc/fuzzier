package com.mituuz.fuzzier

class FuzzyGrepCaseInsensitiveWithRegex : FuzzyGrep() {
    override var popupTitle: String = "Fuzzy Grep (Case Insensitive with Regex)"
    override var dimensionKey = "FuzzyGrepCaseInsensitiveWithRegexPopup"

    override fun runCommand(commands: List<String>, projectBasePath: String): String? {
        val modifiedCommands = commands.toMutableList()
        if (isWindows) {
            // Customize findstr for case insensitivity
            modifiedCommands.add("/I")
        } else {
            // Customize grep and ripgrep for case insensitivity
            modifiedCommands.add(1, "--smart-case")
        }
        return super.runCommand(modifiedCommands, projectBasePath)
    }
}
