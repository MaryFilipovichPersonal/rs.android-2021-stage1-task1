package subtask2

class BillCounter {

    fun calculateFairlySplit(bill: IntArray, k: Int, b: Int): String {
        val list = bill.filterIndexed { index, _ -> index != k }
        val cost = list.sum()/2
        return if (cost == b) "bon appetit" else (b - cost).toString()
    }
}
