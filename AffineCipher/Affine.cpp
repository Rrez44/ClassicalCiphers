#include <iostream> 

#include <string> 

 using namespace std; 

  

int modInverse(int a, int m) { 

    for (int x = 1; x < m; x++) { 

        if (((a % m) * (x % m)) % m == 1) { 

            return x; 

        } 

    } 

    return -1; 

} 

 char encryptChar(char c, int a, int b) { 

    if (isalpha(c)) { 

        char base = isupper(c) ? 'A' : 'a'; 

        return (char)((((a * (c - base)) + b) % 26) + base); 

    } 

    return c; 

} 

 char decryptChar(char c, int a, int b) { 

    if (isalpha(c)) { 

        char base = isupper(c) ? 'A' : 'a'; 

        int inverse = modInverse(a, 26); 

        if (inverse != -1) { 

            return (char)(((inverse * ((c - base) - b + 26)) % 26) + base); 

        } 

    } 

    return c; 

} 

 string encrypt(string message, int a, int b) { 

    string encryptedMessage = ""; 

    for (char c : message) { 

        encryptedMessage += encryptChar(c, a, b); 

    } 

    return encryptedMessage; 

} 

 string decrypt(string message, int a, int b) { 

    string decryptedMessage = ""; 

    for (char c : message) { 

        decryptedMessage += decryptChar(c, a, b); 

    } 

    return decryptedMessage; 

} 

  

int main() { 

    string message; 

    int keyA, keyB; 

  

    cout << "Enter the message: "; 

    getline(cin, message); 

    cout << "Enter key A: "; 

    cin >> keyA; 

    cout << "Enter key B: "; 

    cin >> keyB; 

  

    string encryptedMessage = encrypt(message, keyA, keyB); 

    cout << "Encrypted message: " << encryptedMessage << endl; 

  

    string decryptedMessage = decrypt(encryptedMessage, keyA, keyB); 

    cout << "Decrypted message: " << decryptedMessage << endl; 

  

    return 0; 

} 