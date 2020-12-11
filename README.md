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

# Section 4
1. Jelaskan perbedaan th:include dan th:replace!
- th:include berfungsi untuk memasukkan fragment yang ditentukan sebagai body tag host-nya tetapi mengecualikan fragment tag. Sedangkan th:replace berfungsi untuk mensubsitusi secara langsung tag dimana ada th:replace fragment beserta tag.
2. Jelaskan apa fungsi dari th:object!
- th:object berfungsi untuk membuat form dan menanggani command object (menampung sebuah object yang terdapat pada controller). Dengan th:object kita bisa mengetahui model attribute apa yang dibutuhkan dari perintah yang ingin kita lakukan.
3. Jelaskan perbedaan dari * dan $ pada saat penggunaan th:object! Kapan harus dipakai?
- * itu berfungsi untuk mengekspresikan variabel yang lebih spesifik sehingga tidak semua isi dari variable tersebut akan diambil sedangkan $ berfungsi untuk mengekspresikan variabel yang lebih umum (semua isi variabel diambil). Keduanya memiliki peran yang sama yaitu sebagai variable expression tetapi akan berbeda apabila objek yang diambil lebih spesifik. * digunakan apabila suatu variabel memiliki objek yang lebih spesifik contohnya yaitu *{kamar.nokamar}. Sedangkan $ digunakan ketika variabel memiliki cakupan yang lebih luas misalkan ${hotel} yang dimiliki oleh banyak komponen yaitu id, alamat, no telp.
4. Bagaimana kamu menyelesaikan latihan nomor 3?
- Saya menerapkan th:text="${currentPageName}" untuk mengevaluasi value expressionnya. Lalu ditiap halaman saya me-replace value expression tersebut sesuai dengan halaman yang sedang diakses sekarang.

# Section 5
1. Apa itu Postman? Apa kegunaannya?
- Postman adalah sebuah aplikasi yang berfungsi sebagai REST Client. Postman biasanya digunakan untuk melakukan uji coba terhadap REST API yang telah kita buat sebelumnya.
2. Jelaskan fungsi dari anotasi @JsonIgnoreProperties dan @JsonProperty.
- @JsonProperty biasanya digunakan untuk memberikan spesifikasi list atribut dari sebuah class yang akan diabaikan ketika menjalankan serialization dan deserialization JSON. Jika kita tidak menggunakan annotation tsb maka terjadi error saat menjalankan serialization dan deserialization ketika Java Object tidak memiliki field yang dimiliki oleh JSON.
3. Apa kegunaan atribut WebClient?
- Web client digunakan untuk menghubungkan komputer dalam sebuah jaringan internet yang meminta informasi. Untuk dapat mengakses web server maka diperlukan sebuah web client untuk menggunakan aplikasi yang disebut Web Browser.
4. Apa itu ResponseEntity dan BindingResult? Apa kegunaannya?
- ResponseEntity adalah sebuah class yang merepresentasikan HTTP Response termaksud status code, headers, dan body secara keseluruha sedangkan BindingResult adalah sebuah validator object yang terdapat pada Controller.
Kegunaan ResponseEntity: ResponseEntity dapat digunakan dalam memanipulasi HTTP Response.
Kegunaan BindingResult: BindingREsult dapat digunakan dalam menyimpan hasil validasi dan binding serta berisi error-error yang mungkin terjadi. BindingResult harus muncul setelah object telah divalidasi.

# Section 6
1. Jelaskan secara singkat perbedaan Otentikasi dan Otorisasi! Di bagian mana (dalam kode yang telah anda buat) konsep tersebut diimplementasi?
	- Otentikasi adalah proses melakuka verifikasi terhadap seseorang, apakah user memiliki hak untuk login kedalam website. Otentikasi dapat berupa username atau password. Pada tutorial kali ini, otentikasi terdapat pada bagian WebConfig.

```
public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailsService).passwordEncoder(encoder());
    }
```

	- Otorisasi adalah proses pengecekan yang dilakukan setelah user telah mendapatkan otentikasi. Hal ini berguna untuk mengecek apakah user telah diberikan hak akses untuk melakukan perubahan pada website. Pada tutorial ini, otorisasi terdapat pada bagian WebConfig.

```
http
                .authorizeRequests()
                .antMatchers("/css/**").permitAll()
                .antMatchers("/js/**").permitAll()
                .antMatchers("/hotel/**").hasAuthority("RECEPTIONIST")
                .anyRequest().authenticated()
```

2. Apa itu BCryptPasswordEncoder? Jelaskan secara singkat cara kerja dan tujuannya.
	- BCryptPasswordEncoder adalah sebuah teknik hashing yang digunakan untuk password yang telah diinput oleh user. Sebelum password diinput ke dalam database, password tersebut akan dihashing menjadi code yang sulit dimengerti oleh manusia. Kegunaan dari BCryptPasswordEncoder adalah menjaga password dari user/hacker yang telah mendapatkan hak akses ke dalam database.
3. Jelaskan secara singkat apa itu UUID beserta penggunaannya!
	- UUID adalah sebuah hex digit yang terdiri dari 32 digit random character yang digunakan dalam class UserModel dengan tujuan untuk menambah keamanan user karena id user akan digenerate menjadi 32 random character sehingga user/hacker tidak dapat mengambil userid dengan mudah.
4. Apa kegunaan class UserDetailsServiceImpl.java? Mengapa harus ada class tersebut padahal kita sudah
memiliki class UserRoleServiceImpl.java?
	- UserDetailsImpl berguna untuk mereturn userauthorities ketika melakukan login. Class ini berguna untuk memberikan otorisasi kepada user yang melakukan login. Kalau Class UserRoleServiceImpl berguna untuk mengecek hak akses user dan memberikan otentikasi kepada user berdasarkan role yang telah ditetapkan pada database.

# Section 7
1. Jelaskan apa yang Anda lakukan di latihan dalam satu paragraf per-soal. Berikan screenshot sebagai ilustrasi
dari apa yang Anda jelaskan.
	- Pada latihan no 1 saya menambahkan validasi checked dan berikut adalah code yang telah saya implementasikan:
```
type={checked ? "checkbox" : "hidden"}
```
	- Pada latihan no 2 saya menambahkan sebuah method setstate favorit = [] (list kosong). Berikut adalah code yang telah saya implementasikan:
```
deleteOnClick=()=>{
    this.setState(
      this.state.favItems=[]
    );
  };
```
	- Pada latihan no 3 saya menambahkan sebuah method HandleFavClick (code sesuai HandleItemClick sebelum saya edit) khusus untuk menghandle Fav dan menghilangkan condition else pada HandleItemClick.
	- Pada latihan no 4 saya menambahkan checkbox dan method toogle untuk menvalidasi apakah checkbox sedang ON/OFF. berikut adalah code yang telah saya implementasikan:
```
 toggleButton = () => {
    this.setState(currentState => ({
      boolean: !currentState.boolean
    }));
  };
```
	- Pada latihan no 5 saya menambahkan file baru yang terdapat pada folder EmptyState yang isinya adalah code untuk menghandle MyFavorite apabila listnya kosong.
2. Menurut pemahaman kamu selama pengerjaan tutorial ini, apa perbedaan antara state dan props?
	- Menurut pemahaman saya, props atau property adalah sebuah component yang digunakan pada AppFunc dan component ini bisa dipanggil dimana saja. Sedangkan State adalah private component yang tidak bisa sembarang akses oleh component lain.
3. Apa keuntungan menggunakan component (e.g. List, Item) di React? Berikan contohnya!
	- Kelebihan menggunakan component dalam react adalah kita dapat memisahkan codingan menjadi beberapa bagian sehingga kegunaan components semakin spesifik. Contoh: Pada bagian List kita menghandle semua list movie, sedangkan pada bagian item kita menghandle bagian informasi mengenai movie.
4. Menurut kamu, apa saja kelebihan menggunakan React dalam pengembangan web?
	- Banyak kelebihan react dalam menggunakan pengembangan web yaitu: Componentnya dirakit sesuai dengan keiinginan kita, component yang bisa digunakan kembali/reuseable dan mudah dipelajari.
5. Menurut kamu, apa saja kekurangan menggunakan React dalam pengembangan web?
	- Kekurangan React dalam pengembangan web yaitu: Dokumentasi yang buruk, JSX yang sangat kompleks sehingga menyusahkan developer.
source: https://www.konsepkoding.com/2020/08/1-pengenalan-reactjs-kekurangan-dan.html

# Section 8
1. Ceritakan langkah - langkah yang kalian lakukan untuk solve LATIHAN no.1, dan mengapa kalian
melakukan langkah - langkah tersebut?
- Saya hanya menambahkan this.setState pada method handleSubmitAddHotel sehingga default value pada kolom input tersebut akan selalu kosong ketika user ingin menambahkan hotel.

``
 this.setState(
                {
                    namaHotel:'',
                    alamat:'',
                    nomorTelepon:'',
                }
``

2. Jelaskan fungsi dari async dan await!
- async: menandakan bahwa fungsi tersebut bersifat non-blocking (asynchronous)
- await: membuat fungsi yang sedang dieksekusi harus berjalan hingga selesai sebelum code setelah await dieksekusi.

3. Masukkan jawaban dari Screenshot yang diperintahkan di halaman 7 pada Component Lifecycle pada pertanyaan ini.
- <img src="/frontend-traveloke/1.png" alt="Foto">
<img src="/frontend-traveloke/2.jpg" alt="Foto">
<img src="/frontend-traveloke/3.JPG" alt="Foto">
<img src="/frontend-traveloke/4.JPG" alt="Foto">
<img src="/frontend-traveloke/5.jpg" alt="Foto">

4. Jelaskan fungsi dari componentDidMount, shouldComponentUpdate, componentDidUpdate, componentWillReceiveProps, componentWillUnmount. 
Notes : Penjelasan harus mencantumkan “kapan fungsi dipanggil” dan “use case apa saja yang biasanya menggunakan lifecycle method tersebut”
- componentDidMount: Fungsi ini dipanggil setelah component telah selesai dirender untuk melakukan fetching data.
- shouldComponentUpdate: Fungsi ini dipanggil sebelum component melakukan render terhadap perubahan.
- componentDidUpdate: Fungsi ini dipanggil setelah component telah dirender ulang dan sudah selesai di render. componentDidUpdate digunakan saat melakukan interaksi dengan environment non-React seperti HTTP Request.
- componentWillReceiveProps: Fungsi ini dipanggil sebelum component melakukan props yang baru telah diupdate. Dengan begitu kita dapat membandingkan props yang lama dengan yang baru dan memeriksa apakah terdapat perubahan terhadap props tersebut. 
- componentWillUnmount: Fungsi ini dipanggil sebelum component di hapus dari DOM. Biasanya pada lifecycle ini, kita akan melakukan cleanup seperti membatalkan network request dan menghilangkan event listener.