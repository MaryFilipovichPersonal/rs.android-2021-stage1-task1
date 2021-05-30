package subtask3

class StringParser {

    fun getResult(inputString: String): Array<String> {
        val substrings: ArrayList<String> = ArrayList()
        for ((index, value) in inputString.withIndex()) {
            var substring: String? = null
            when (value) {
                '<' -> substring = parseSubstring(inputString, '<', '>', index)
                '[' ->
                    substring = parseSubstring(inputString, '[', ']', index)
                '(' -> substring = parseSubstring(inputString, '(', ')', index)
            }
            if (substring != null) {
                substrings.add(substring)
            }

        }
        return substrings.toTypedArray()
//        println("Subs: ${valid(inputString)}")
    }

    private fun parseSubstring(inputString: String, open: Char, close: Char, startIndex: Int): String? {
        var level = 0
        for (index in startIndex..inputString.lastIndex) {
            when (inputString[index]) {
                open -> level++
                close -> if (level > 1) level-- else return inputString.substring(startIndex + 1, index)
            }
        }
        return null
    }

    fun valid(inputStr: String): ArrayList<String> {
        val s = mutableListOf<Int>()
        val chars = inputStr.toCharArray()
        val subs = ArrayList<String>()
        for (i in chars.indices) {
            val char = chars[i]
            if (char == '(' || char == '<' || char == '[') {
                s.add(i)
            } else {
                when (char) {
                    ')' -> {
                        val top = s.findLast { chars[it] == '('}
                        top?.let {
                            subs.add(inputStr.substring(it+1, i))
                            s.remove(top)
                        }
                    }
                    '>' -> {
                        val top = s.findLast { el -> chars[el] == '<'}
                        top?.let {
                            subs.add(inputStr.substring(it+1, i))
                            s.remove(top)
                        }
                    }
                    ']' -> {
                        val top = s.findLast { el -> chars[el] == '['}
                        top?.let {
                            subs.add(inputStr.substring(it+1, i))
                            s.remove(top)
                        }
                    }
                    else -> {}
                }
            }
        }
        return subs
    }
}
