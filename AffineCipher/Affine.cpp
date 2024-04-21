#include <iostream>
#include <string>

using namespace std;

bool areCoprime(int a, int m) {
    for (int i = 2; i <= a && i <= m; i++) {
        if (a % i == 0 && m % i == 0)
            return false;
    }
    return true;
}

string encrypt(string text, int a, int b) {
    if (!areCoprime(a, 26)) {
        cerr << "Error: a and 26 are not coprime. Please choose a different 'a' value.\n";
        return "";
    }

    string ciphertext = "";

    for (char& c : text) {
        if (isalpha(c)) {
            char offset = isupper(c) ? 'A' : 'a';
            c = static_cast<char>(((a * (c - offset) + b) % 26) + offset);
        }
        ciphertext += c;
    }

    return ciphertext;
}

string decrypt(string ciphertext, int a, int b) {
    string plaintext = "";
    int a_inv = 0;
    int flag = 0;

    for (int i = 0; i < 26; i++) {
        flag = (a * i) % 26;
        if (flag == 1) {
            a_inv = i;
        }
    }

    for (char& c : ciphertext) {
        if (isalpha(c)) {
            char offset = isupper(c) ? 'A' : 'a';
            c = static_cast<char>(((a_inv * ((c - offset) - b + 26)) % 26) + offset);
        }
        plaintext += c;
    }

    return plaintext;
}

int main() {
    string text;
    int a, b;

    cout << "Enter text: ";
    getline(cin, text);

    cout << "Enter key a (should be coprime with 26): ";
    cin >> a;

    cout << "Enter key b: ";
    cin >> b;

    string encrypted = encrypt(text, a, b);
    cout << "Encrypted: " << encrypted << endl;

    string decrypted = decrypt(encrypted, a, b);
    cout << "Decrypted: " << decrypted << endl;

    return 0;
}