# Produk API

## Create Produk
Endpoint: POST /api/produk

request body:
``` json
{
    "nama":"produk a",
    "harga":"23000",
    "deskripsi":"produk a produk terbaik"
}
```

response body (success):
```json
{
    "msg":"produk berhasil ditambahkan",
}

response body (failed):
```json
{
    "msg":"produk gagal ditambahkan",
}