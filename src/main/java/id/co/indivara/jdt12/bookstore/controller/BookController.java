package id.co.indivara.jdt12.bookstore.controller;

import id.co.indivara.jdt12.bookstore.entity.Book;
import id.co.indivara.jdt12.bookstore.entity.BukuMahal;
import id.co.indivara.jdt12.bookstore.entity.BukuMurah;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class BookController {
    @GetMapping("/book/{isbn}/{judul}/{pengarang}")
    public Book tampilkanBuku(@PathVariable("isbn") String isbn,
                              @PathVariable("judul") String judul,
                              @PathVariable("pengarang") String pengarang){
        return new Book(isbn, judul, pengarang);
    }
    @PostMapping("/simpan")
    public BukuMahal simpanBuku(@RequestBody Book jsonData){
        Book b = jsonData;
        BukuMahal bm = new BukuMahal();
        bm.setIsbn(b.getIsbn());
        bm.setJudul(b.getJudul());
        bm.setPengarang(b.getPengarang());
        bm.setCover("besi");
        bm.setKemasan("Kotak kayu");
        return bm;
    }
    @GetMapping("/all")
    public ArrayList<Book> findAllBook(){
        ArrayList<Book> list = new ArrayList<>();
        list.add(new Book("111", "Cara Terbang", "Agus"));
        list.add(new Book("222", "Cara Renang", "Budi"));
        list.add(new Book("333", "Cara Lari", "Charlie"));
        return list;
    }
    @PostMapping("/termurah")
    public BukuMurah findBukuTermurah(@RequestBody ArrayList<BukuMurah> list){
        BukuMurah buku = list.get(1);//ambil element pertama yang akan kita bandingkan
        for (BukuMurah b : list){
            if (b.getHarga()<buku.getHarga()){
                buku = b;
            }
        }
        return buku;
    }
//    @GetMapping("/book")
//    public Book bookGet(@RequestParam(value = "isbn", defaultValue = "000") String isbn,
//                        @RequestParam(value = "judul", defaultValue = "Ini Judul") String judul,
//                        @RequestParam(value = "pengarang", defaultValue = "null") String pengarang){
//        return new Book("001", "Dilan tarkan", "Pidi Jahat GET");
//    }
//    @PutMapping("/book")
//    public Book bookPut(@RequestParam(value = "isbn", defaultValue = "000") String isbn,
//                        @RequestParam(value = "judul", defaultValue = "Ini Judul") String judul,
//                        @RequestParam(value = "pengarang", defaultValue = "null") String pengarang){
//        return new Book("002", "Dilan tarkan", "Pidi Jahat PUT");
//    }
//    @PostMapping("/book")
//    public Book bookPost(@RequestParam(value = "isbn", defaultValue = "000") String isbn,
//                         @RequestParam(value = "judul", defaultValue = "Ini Judul") String judul,
//                         @RequestParam(value = "pengarang", defaultValue = "null") String pengarang){
//        return new Book("003", "Dilan tarkan", "Pidi Jahat POST");
//    }
//    @PatchMapping("/book")
//    public Book bookPatch(@RequestParam(value = "isbn", defaultValue = "000") String isbn,
//                          @RequestParam(value = "judul", defaultValue = "Ini Judul") String judul,
//                          @RequestParam(value = "pengarang", defaultValue = "null") String pengarang){
//        return new Book("004", "Dilan tarkan", "Pidi Jahat PATCH");
//    }
//    @DeleteMapping("/book")
//    public Book bookDelete(@RequestParam(value = "isbn", defaultValue = "000") String isbn,
//                           @RequestParam(value = "judul", defaultValue = "Ini Judul") String judul,
//                           @RequestParam(value = "pengarang", defaultValue = "null") String pengarang){
//        return new Book("005", "Dilan tarkan", "Pidi Jahat DELETE");
//    }
}
