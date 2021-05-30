package subtask1

class HappyArray {

    fun convertToHappy(sadArray: IntArray): IntArray {
        val list = sadArray.toMutableList()
        var index = 0
        while (index < list.size) {
            if (index == 0 ||
                index == list.size - 1 ||
                (index in 1 until list.size - 1 && list[index - 1] + list[index + 1] > list[index])
            ) {
                index++
                continue
            } else {
                list.removeAt(index)
                index--
            }
        }
        return list.toIntArray()
    }

}
