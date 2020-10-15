---
## Tutorial 1
### What I have learned today
### Github
1. Apa itu Issue Tracker? Apa saja masalah yang dapat diselesaikan dengan Issue Tracker?
 Issue Tracker adalah sebuah tool yang digunakan untuk mencatat issue-issue yang terjadi pada github kita yang berguna untuk mengetahui kapan dan issue-issue apa saja yang telah terjadi sebelumnya. Issue tracker juga men-tracking sejauh mana masalah-masalah yang telah kita selesaikan sampai saat ini.
Masalah yang dapat diselesaikan dengan Issue Tracker adalah masalah-masalah yang pernah terjadi sebelumnya.
2. Apa perbedaan dari git merge dan git merge --squash?
Sesuai dengan informasi yang saya dapatkan dari google, perbedaan git merge dan git merge --squash adalah git merge masih memerlukan commit dan git merge --squash tidak memerlukan commit berikutnya (single commit). merge --squash tidak bisa melakukan commit selanjutnya karena squash akan selalu menolak atas commit yang dilakukan. merge --squash menghubungkan cabang ke master dengan langsung menghapus cabangnya (tidak menyentuh cabang) sedangkan merge menghubungkan cabang ke master lalu cabang tersebut akan dihapus setelah melakukan merge.
intinya: squash tidak menyentuh cabang sumber anda dan membuat komit tunggal dimana anda inginkan
3. Apa keunggulan menggunakan Version Control System seperti Git dalam pengembangan suatu
aplikasi?
Keunggulan Version Control System (VCS) seperti git adalah untuk menghindari kebingungan developer dalam memakai tool yang disediakan. Git juga mengrecord perubahan file setiap waktu, jadi kita bisa recall codingan sebelumnya ketika kita membutuhkannya
Dengan adanya VCS developer dapat dengan mudah mengganti codingan baru yang masih error ke kodingan awal yang benar (revert).
### Spring
4. Apa itu library & dependency?
libary & dependency adalah sebuah module yang terintegrasi satu dengan yang lainnya dan akan sangat berguna dalam pengembangan sistem. Semua dependency memiliki fungsi dan kegunaannya masing-masing dalam membangun sebuah sistem. Contoh: Kita memiliki roda, mesin dll tetapi mesin toyota kita rusak. kita bisa langsung menggantikan mesin toyota tersebut dengan mesin yang kita punya.
Dependency yang kita pakai pada project kali ini adalah Spring Web, Spring Boot, dan thymeleaf. #Maaf kalau masih belum ngerti, sulit menjelaskannya.
5. Mengapa kita menggunakan Maven? Apakah ada alternatif dari Maven?
Maven adalah sebuah Java Build Tools yang menggunakan konsep Project Object Model (POM). POM sendiri memiliki konfigurasi yang digunakan untuk membuat sebuah project. Keunggulan maven ini adalah membuat structure project sendiri sehingga kita dapat membuka project kita di IDE yang berbeda dan Maven juga dapat memanage Dependency semakin lebih mudah.
Masih ada alternatif lain seperti gradle, ant, dll.
6. Selain untuk pengembangan web, apa saja yang bisa dikembangkan dengan Spring framework?
Spring masih bisa digunakan untuk enterprise, databases, dll.
7. Apa perbedaan dari @RequestParam dan @PathVariable? Kapan sebaiknya menggunakan
@RequestParam atau @PathVariable?
RequestParam digunakan untuk mengakses parameter nilai query dari request yang diberikan sedangkan PathVariable untuk mengambil data dan mengetahui pattern yang digunakan dalam URI untuk request selanjutnya.
RequestParam digunakan saat website anda memiliki data pada parameter yang telah ditentukan sedangkan PathVariable digunakan ketika pada link terdapat sebuah pola yang sudah pasti (seperti lab tutorial kali ini yaitu height dan weight) 
### What I did not understand
1. Saya masih tidak mengerti apa manfaat mata kuliah APAP
2. Saya masih bingung terhadap tool-tool yang kita gunakan untuk mata kuliah ini karena terlalu banyak dan membingungkan
3. Saya masih tidak terlalu mengerti mengenai penerapan Dependency Injection pada tutorial kali ini
4. Saya masih tidak terlalu mengerti manfaat dari masing-masing framework yang ada
dan masih banyak lagi.

# Section 2
1. Cobalah untuk menambahkan sebuah Hotel dengan mengakses link berikut:
http://localhost:8080/hotel/add?idHotel=1&namaHotel=Papa%20APAP&alamat=Quanta%20Fasilkom
&noTelepon=081xxx. Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi
- Yang terjadi adalah data hotel yang ada pada link telah disimpan dan layar akan mereturn halaman html yang dituju.
2. Menurut kamu anotasi @Autowired pada class Controller tersebut merupakan
implementasi dari konsep apa? Dan jelaskan secara singkat cara kerja @Autowired tersebut dalam
konteks service dan controller yang telah kamu buat
- Sepemahaman saya, @Autowired pada class Controller merupakan implementasi dari konsep OOP (antar class dengan class). Dengan adanya Autowired kita tidak perlu lagi menggunakan configuration dan setter getter, Autowired adalah sebuah setter method yang digunakan dalam element in XML configuration file.
3. Cobalah untuk menambahkan sebuah Hotel dengan mengakses link berikut:
http://localhost:8080/hotel/add?idHotel=1&namaHotel=Papa%20APAP&alamat=Quanta%20Fasilkom
Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi
- Yang terjadi adalah error karena addhotel pada class HotelController telah ditulis bahwa semua data required (dibutuhkan) dan tidak boleh kosong.
4. Jika Papa APAP ingin melihat Hotel dengan nama Papa APAP, link apa yang harus
diakses?
- untuk saat ini tidak bisa karena belum saya programkan fitur, mungkin untuk liat hotel yang terdaftar bisa akses http://localhost:8080/hotel/viewall/
5. Tambahkan 1 contoh Hotel lainnya sesukamu. Lalu cobalah untuk mengakses
http://localhost:8080/hotel/viewall , apa yang akan ditampilkan? Sertakan juga bukti screenshotmu.
- Yang akan ditampilkan adalah seluruh nama hotel yang telah terdaftar sebelumnya.
<img src="/traveloke/screenshot.JPG" alt="Foto Task 5">
Kalau ga kelihatan bisa buka folder traveloke, terdapat file screenshot.jpg

# Section 3
1. Pada class KamarDb, terdapat method findAllByHotelId, apakah kegunaan dari method tersebut?
- Method tersebut beguna untuk mencari semua kamar yang memiliki id hotel yang sesuai dengan parameter yang diberikan. Hasil dari findAllByHotelId adalah mengembalikkan isi list semua objek kamar yang terdapat pada id hotel tersebut.
2. Pada class HotelController, jelaskan perbedaan method addHotelFormPage dan addHotelSubmit?
- Pada method addHotelFormPage akan dilakukan penampilan form-add-hotel.html yang tujuannya untuk mengisi dan melakukan aksi berupa penambahan hotel. Sedangkan pada addHotelSubmit adalah method yang melakukan penambahan hotel yang telah didaftar sebelumnya (addHotelFormPage) ke hotelservice yang akan dikirimkan ke database
3. Jelaskan kegunaan dari JPA Repository!
- JPA Repository adalah sebuah interface yang berguna untuk mengakses database melalui JPA. Dengan adanya JPA Repository kita akan lebih mudah menquery/mengambil data yang terdapat di database. Salah satu contoh penerapan pada tutorial kali ini adalah method findAllByOrderByIdDesc yang memudahkan kita untuk menampilkan semua hotel dalam keadaan terurut dari id hotel yang terakhir ditambahkan tanpa perlu melakukan iterasi atau apapun itu.
4. Sebutkan dan jelaskan di bagian kode mana sebuah relasi antara HotelModel dan KamarModel dibuat?
Kedua relasi tersebut berada pada bagian 
<img src="/traveloke/screenshot1.JPG" alt="Foto Task 4"> <img src="/traveloke/screenshot2.JPG" alt="Foto Task 4">
- Dibagian Many-to-One dan One-to-Many relasi HotelModel berelasi dengan KamarModel, hal tersebut sesuai dengan gambar EERD yang telah diberikan pada soal.
5. Jelaskan kegunaan FetchType.LAZY, CascadeType.ALL, dan FetchType.EAGER!
-	1.FetchType.Lazy= sebuah JPA yang berfungsi untuk menquery data secara spesifik (mengambil data sendiri/yang diinginkan)
	2.FetchType.Eager= sebuah JPA yang berfungsi untuk menquery data secara menyeluruh 
	3.CascadeType.All= salah satu cascadetype dari JPA yang memiliki operasi yang sangat lengkap dan CascadeType.All berguna untuk melakukan operasi-operasi yang diinginkan kepada entitas seperti: Persist, Merge, Request, Remove, Detach.