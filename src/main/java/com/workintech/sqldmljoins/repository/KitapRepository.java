package com.workintech.sqldmljoins.repository;

import com.workintech.sqldmljoins.entity.Kitap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface KitapRepository extends JpaRepository<Kitap, Long> {

    // Dram ve Hikaye türündeki kitapları listeleyin (JOIN kullanmadan)
    @Query("SELECT k FROM Kitap k WHERE k.tur.ad IN ('Dram', 'Hikaye')")
    List<Kitap> findBooksByType();

    // Kitapların puanlarının ortalamasını al
    String QUESTION_10 = "select avg(k.puan) from kitap k;";
    @Query(value = QUESTION_10, nativeQuery = true)
    Double findAvgPointOfBooks();
}
