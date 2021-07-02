if __name__ == '__main__':
    while True:
        print("Enter ur text -> ")

        lowercaseWords = {
            "а": "a",
            "б": "d",
            "в": "ß",
            "г": "r",
            "д": "g",
            "е": "e",
            "ё": "é",
            "ж": "w",
            "з": "h",
            "и": "u",
            "й": "ü",
            "к": "k",
            "л": "n",
            "м": "m",
            "н": "ń",
            "о": "o",
            "п": "b",
            "р": "p",
            "с": "c",
            "т": "t",
            "у": "y",
            "ф": "♫",
            "х": "x",
            "ц": "ę",
            "ч": "z",
            "ш": "s",
            "щ": "q",
            "ъ": "ź",
            "ы": "ńl",
            "ь": "ń",
            "э": "ć",
            "ю": "v",
            "я": "ä"
        }

        uppercaseWords = {
            "А": "A",
            "Б": "D",
            "В": "B",
            "Г": "L",
            "Д": "Z",
            "Е": "E",
            "Ё": "É",
            "Ж": "V",
            "З": "3",
            "И": "N",
            "Й": "Ń",
            "К": "K",
            "Л": "S",
            "М": "M",
            "Н": "H",
            "О": "O",
            "П": "U",
            "Р": "P",
            "С": "C",
            "Т": "T",
            "У": "Q",
            "Ф": "Y",
            "Х": "X",
            "Ц": "ẞ",
            "Ч": "J",
            "Ш": "W",
            "Щ": "Ę",
            "Ъ": "Ż",
            "Ы": "FI",
            "Ь": "F",
            "Э": "G",
            "Ю": "Ź",
            "Я": "R",
        }

        word = input()

        for item in lowercaseWords:
            word = word.replace(item, lowercaseWords[item])

        for item in uppercaseWords:
            word = word.replace(item, uppercaseWords[item])

        print(word)
