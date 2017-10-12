#ifndef CRYPTLIB_AES_HELPER_H
#define CRYPTLIB_AES_HELPER_H

#include <string>

#define KEYCODELENGTH 16

class CAesHelper {
public:
    CAesHelper(void);

    ~CAesHelper(void);

    // PKCS5Padding: aaa(0x61,0x61,0x61) -> (0x61,0x61,0x61,0x0d,0x0d,0x0d,0x0d,0x0d,0x0d,0x0d,0x0d,0x0d,0x0d,0x0d,0x0d,0x0d)      add hex(16 - n)
    // PKCS7Padding: aaa(0x61,0x61,0x61) -> (0x61,0x61,0x61,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00)	   add 0
    // these two functions only work for ECB mode, PKCS5Padding, 128 bit
    std::string Encrypt(std::string strSrc, std::string strKey);

    std::string Decrypt(std::string strSrc, std::string strKey);

private:
    void StringToHex(const char *pSrc, unsigned char *pDest);

    void Padding(unsigned char *pSrc, int nSrcLen);
};

#endif //CRYPTLIB_AES_HELPER_H