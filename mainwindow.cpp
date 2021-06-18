#include "mainwindow.h"
#include "./ui_mainwindow.h"

using namespace std;

MainWindow::MainWindow(QWidget *parent)
        : QMainWindow(parent), ui(new Ui::MainWindow) {

    ui->setupUi(this);

    connect(ui->btnReplace, SIGNAL(clicked(bool)), this, SLOT(replaceTextFromInput()));

}

MainWindow::~MainWindow() {
    delete ui;
}

void MainWindow::replaceTextFromInput() {

    vector<pair<QString, QString>> lowerCaseWords{
            {"а", "a"},
            {"б", "d"},
            {"в", "ß"},
            {"г", "r"},
            {"д", "g"},
            {"е", "e"},
            {"ё", "é"},
            {"ж", "w"},
            {"з", "h"},
            {"и", "u"},
            {"й", "ü"},
            {"к", "k"},
            {"л", "n"},
            {"м", "m"},
            {"н", "ń"},
            {"о", "o"},
            {"п", "b"},
            {"р", "p"},
            {"с", "c"},
            {"т", "t"},
            {"у", "y"},
            {"ф", "♫"},
            {"х", "x"},
            {"ц", "ę"},
            {"ч", "z"},
            {"ш", "s"},
            {"щ", "q"},
            {"ъ", "ź"},
            {"ы", "ńl"},
            {"ь", "ń"},
            {"э", "ć"},
            {"ю", "v"},
            {"я", "ä"}
    };

    vector<pair<QString, QString>> upperCaseWords {
            {"А", "A"},
            {"Б", "D"},
            {"В", "B"},
            {"Г", "L"},
            {"Д", "Z"},
            {"Е", "E"},
            {"Ё", "É"},
            {"Ж", "V"},
            {"З", "3"},
            {"И", "N"},
            {"Й", "Ń"},
            {"К", "K"},
            {"Л", "S"},
            {"М", "M"},
            {"Н", "H"},
            {"О", "O"},
            {"П", "U"},
            {"Р", "P"},
            {"С", "C"},
            {"Т", "T"},
            {"У", "Q"},
            {"Ф", "Y"},
            {"Х", "X"},
            {"Ц", "ẞ"},
            {"Ч", "J"},
            {"Ш", "W"},
            {"Щ", "Ę"},
            {"Ъ", "Ż"},
            {"Ы", "FI"},
            {"Ь", "F"},
            {"Э", "G"},
            {"Ю", "Ź"},
            {"Я", "R"},
    };

    QString text = ui->inputText->toPlainText();

    for (auto const &w : lowerCaseWords) {
            text.replace(w.first, w.second);
    }

    for (auto const &w : upperCaseWords) {
            text.replace(w.first, w.second);
    }

    ui->ouputText->setText(text);
}

