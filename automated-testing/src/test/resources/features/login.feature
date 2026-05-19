# language: id
Fitur: Manajemen Login Pengguna
  Sebagai pengguna swag labs
  Aku ingin bisa masuk ke dalam sistem menggunakan akunku
  Agar aku bisa melihat daftar produk yang dijual

  Latar Belakang:
    Dengan User berada pada halaman login Sauce Demo

  @Positive
  Skenario: Login dengan akun yang valid dan aktif
    Ketika user memasukkan username "standard_user" dan password "secret_sauce"
    Dan user klik button login
    Maka user harus directed ke halaman inventory

  @Negative
  Skenario: Login dengan akun yang diblokir
    Ketika user memasukkan username "locked_out_user" dan password "secret_sauce"
    Dan user klik button login
    Maka user harus melihat pesan yang mengandung "Sorry"