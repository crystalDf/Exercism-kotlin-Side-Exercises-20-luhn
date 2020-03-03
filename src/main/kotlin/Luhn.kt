object Luhn {

    fun isValid(candidate: String): Boolean {

        val spacesStripped = candidate.replace(" ", "")

        if ((spacesStripped.length <= 1) || (spacesStripped.any { !it.isDigit() })) {
            return false
        }

        return spacesStripped.mapIndexed{ index, char ->

            var digit = char.toString().toInt()

            digit = if ((spacesStripped.length - index) % 2 == 0) digit * 2 else digit
            digit = if (digit > 9) digit - 9 else digit

            digit
        }.sum() % 10 == 0

    }
}
