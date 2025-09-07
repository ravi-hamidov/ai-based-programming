# Advanced Java Concepts

## ArrayList

### ArrayList nedir ? Array'den ferqi

| Xususiyyet        | Array                                                                                                                  | ArrayList                                                                                                                                 |
| :---------------- | :--------------------------------------------------------------------------------------------------------------------- | :---------------------------------------------------------------------------------------------------------------------------------------- |
| **Olcu (Size)**   | **Sabitdir (Fixed).** Yaradilarken olcusu verilir ve deyisdirile bilmez.                                               | **Dinamikdir (Resizable).** Element elave edib sildikce olcusu avtomatik boyuyub-kicilir.                                                 |
| **Tip (Type)**    | **Primitiv** (`int`, `char`) ve **Obyekt** (`String`) tiplerini saxlaya biler.                                         | Yalniz **Obyekt** tiplerini saxlaya biler. Primitivler ucun `Wrapper Class` istifade olunur (`Integer`, `Character`).                     |
| **Performans**    | **Yuksekdir.** Elementlere birbasa (index ile) muraciet olundugu ucun cox suretlidir.                                  | **Bir az asagidir.** Element elave edib silerken (xususile olcu deyisende) arxa planda elave emeliyyatlar aparilir.                       |
| **Funksionalliq** | **Mehduddur.** Yalniz `length` xususiyyeti var. Elave etme, silme kimi emeliyyatlar ucun oz alqoritmlerini yazmalisan. | **Zengindir.** Collections Framework-un bir parcasidir. `add()`, `remove()`, `size()`, `get()`, `contains()` kimi coxlu hazir metodu var. |
| **Generics**      | Generics desteklemir.                                                                                                  | **Generics destekleyir.** Bu, tip tehlukesizliyini (type safety) temin edir (`ArrayList<String>`).                                        |

### ArrayList istifadesi

```java
// ArrayList sinfini istifade etmek ucun onu import edirik
import java.util.ArrayList;
import java.util.Collections; // Sort etmek ucun

public class ArrayListExample {
    public static void main(String[] args) {
        // 1. ArrayList'in yaradilmasi (String tipli elementler saxlayacaq)
        ArrayList<String> seherler = new ArrayList<>();

        // 2. Elementlerin elave edilmesi (.add() metodu)
        seherler.add("Baki");
        seherler.add("Gence");
        seherler.add("Sumqayit");
        seherler.add("Lenkeran");

        // Ilkin siyahini cap edek
        System.out.println("Ilkin siyahi: " + seherler);

        // 3. Elementlerin sayini elde etmek (.size() metodu)
        System.out.println("Siyahidaki elementlerin sayi: " + seherler.size());

        // 4. Spesifik bir elemente muraciet (.get(index) metodu)
        // Indeksler 0-dan baslayir
        String ikinciSeher = seherler.get(1); // 1-ci indeksdeki element (Gence)
        System.out.println("Ikinci seher: " + ikinciSeher);

        // 5. Elementin deyisdirilmesi (.set(index, yeniElement) metodu)
        seherler.set(0, "Susa"); // 0-ci indeksdeki "Baki" elementini "Susa" ile evez edir
        System.out.println("Deyisdirilmis siyahi: " + seherler);

        // 6. Siyahi uzre iterasiya (butun elementleri bir-bir gezmek)
        System.out.println("\n--- Siyahidaki butun seherler ---");
        for (String seher : seherler) {
            System.out.println(seher);
        }

        // 7. Elementin silinmesi (.remove() metodu)
        seherler.remove("Sumqayit"); // Dəyərə görə silmə
        // seherler.remove(1); // İndeksə görə silmə də mümkündür
        System.out.println("\n'Sumqayit' silindikden sonraki siyahi: " + seherler);

        // 8. Elementin movcud olub-olmadigini yoxlamaq (.contains() metodu)
        boolean susaVarmi = seherler.contains("Susa");
        System.out.println("\nSiyahida 'Susa' varmi? " + susaVarmi); // true

        // 9. Siyahini siralamag (sort etmek)
        Collections.sort(seherler);
        System.out.println("\nSiralanmis siyahi: " + seherler);

        // 10. Siyahini tam temizlemek (.clear() metodu)
        seherler.clear();
        System.out.println("\nTemizlenmis siyahi: " + seherler);
        System.out.println("Siyahi bosdurmu? " + seherler.isEmpty()); // true
    }
}
```

## Exception & Exception Handling

> Exception Java programin programin normal axisini pozan xetalarin diger sozle istisnalarin nece idare olunacaqini izah edir, Error'dan ferqi odurki `Exception` programda qarsilasib hell oluncaq problemdir qarsisi alina bilinecek ancaq `Error` programin hell ede bilmeyeceyi ciddi problemler (meselen yaddasin dolmasi kimi)

### Addım 1: `try-catch` Bloku

Xəta baş verə biləcək kod `try` blokunun daxilinə yazılır. Əgər bu blokda bir istisna yaranarsa, proqram dərhal `catch` blokuna keçir və orada olan kodları icra edir.

```Java
try {
// İstisna yarada biləcək kod
} catch (ExceptionType e) {
// İstisna baş verdikdə icra olunacaq kod
}
```

Example: 0'a bolme xetasi

```Java
public class Main {
    public static void main(String[] args) {
        try {
            int result = 10 / 0; // Bu sətir xəta yaradacaq
            System.out.println("Nəticə: " + result); // Bu sətir icra olunmayacaq
        } catch (ArithmeticException e) {
            System.out.println("Xəta baş verdi: Sıfıra bölmək olmaz!");
        }
        System.out.println("Proqram davam edir...");
    }
}
```

### Addım 2: `finally` Bloku

```Java
try {
    // Kod
} catch (ExceptionType e) {
    // Xətanın idarə olunması
} finally {
    // Hər zaman icra olunacaq kod
}
```

Example:

```Java
public class Main {
    public static void main(String[] args) {
        try {
            int[] numbers = {1, 2, 3};
            System.out.println(numbers[1]); // Xəta yoxdur
        } catch (Exception e) {
            System.out.println("Bir xəta baş verdi.");
        } finally {
            System.out.println("'finally' bloku həmişə işləyir.");
        }
    }
}
```

### Addim 3: `throw` Acar sozu

`throw` acar sozu ile ozumuz istisna yarada biler ve onu ata bilerik, bu esasen program mentiqine uygun olmayan hallar uchun istifade olunur.

```Java
public class Main {
    public static void checkAge(int age) {
        if (age < 18) {
            throw new ArithmeticException("Giriş qadağandır - yaşınız 18-dən azdır.");
        } else {
            System.out.println("Girişə icazə verildi.");
        }
    }

    public static void main(String[] args) {
        try {
            checkAge(15);
        } catch (ArithmeticException e) {
            System.out.println("Xəta tutuldu: " + e.getMessage());
        }
    }
}
```

### Addim 4: `throws` Acar sozu

`throws` bir metodun imzasında istifadə olunan və həmin metodun hansı növ istisnaları (exceptions) ata biləcəyini, lakin özünün idarə etməyəcəyini bildirən bir açar sözdür.

```Java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ThrowsExample {

    public static String readFirstLineFromFile(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            return reader.readLine();
        }
    }

    public static void main(String[] args) {
        String faylYolu = "sample.txt";

        try {
            String ilkSetir = readFirstLineFromFile(faylYolu);
            System.out.println("Faylın ilk sətri: " + ilkSetir);
        } catch (IOException e) {
            System.err.println("Xəta baş verdi: Fayl oxuna bilmədi. Səbəb: " + e.getMessage());
        }
    }
}
```

### Addim 5: `throwable` Acar sozu

`Throwable`, proqramda baş verə biləcək bütün problemlərin (`Error` və `Exception`) ümumi tipidir.

## Java Memory Allocation: Heap and Stack

Java'nin yaddasi nece idare etdiyini anlamaq ve effektiv xetasiz programlar yazmaq uchun vacibdir, Java'da 2 esas yaddash tipi var Stack ve Heap, bunlar ferqli meqsedlere xidmet edirler, bu movzu Java'nin yaddashi nece ayirdiqini, deyishenlerin nece saxlandgini ve JVM'in programlarinizi problemsiz islemesi uchun yaddashi nece idare etdiyini anlamaq'da komek edecek

Bir Java programi ishe dushduk'de JVM onun uchun bir neche ferqli sahede yaddash ayirir:

- `Method area` - class'lari, method'lari ve Literal'lari _constant pool_-da saxlayir
- `Heap` - Object'leri ve Array'leri saxlyr
- `Stack` - Local deyishenleri ve Method call info'sunu saxlyr
- `PC register` - cari emrin adress'ini saxlyr
- `Native Method Stacks` - Native metod call'lari uchun use olunur

### Stack & Heap nedir ?

> Stack nedir ?

    Stack yaddashin *Last in First Out* prinsipi ile calishan bir hisse'sidir
    - Stack'e yerleshdirilen son element, ordan ilk goturulen olur
    - Sabit bir olchuye malik'dir
    - Java'da her thread'in oz stack'i olur

> Stack'de ne saxlanilir ?

    - Primitiv value'ler example: float, boolean, int etc.
    - Method cagrilanda stack'de yeni bir frame yaranir
    - Local variables - which is called inside method
    - Referance variables - heap'deki object'lere isare eden gostericiler
    - Hemini Partial results

> Stack Frame ( Method bitende stack frame silinir )

    - Method Local Variables
    - Method'a oturulen parametrler
    - Method bitdikden sonra icranin hardan davam edceyi
    - Call eden metodun stack frame'sine referans

> Heap Memory

    - JVM ishe dusende yaradilir
    - Programin icrasi zamani olcusu deyise bilir
    - bir programin thread'lari arasinda paylanir
    - Heap'de esasen Array'ler, Object'ler, Instance variables, String pool

> Memory Errors

- Stack Overflow
  - Stack yaddas'dan daha cox istifade etdikde adaten derin veya cox tekrarlanan rekursiyada bas verir
- Out of Memory
  - Heap'de obyekt yaratmaqa yer qalmadiqi halda bas verir
- Memory leaks
  - Artiq ehtiyac olmayan obyekt'lerin sirf referan olduqlari uchun garbage collector terefinden temizlene bilmemesi

> Graphic for better UnderStanding

| Xususiyyet                | Stack                                                                                  | Heap                                                                                   |
| :------------------------ | :------------------------------------------------------------------------------------- | :------------------------------------------------------------------------------------- |
| **Esas Vezifesi**         | Metod cagirislarini ve lokal deyisenleri idare etmek.                                  | Proqramin isleme aninda yaradilan obyektleri ve massivleri saxlamaq.                   |
| **Melumat Novleri**       | Primitiv tipler (int, double, boolean...) ve obyekt referanslari (unvanlar).           | Obyektlerin ozu (`new Person()`), massivler (`new int[10]`) ve nusxe deyisenleri.      |
| **Yaddas Idareetmesi**    | Avtomatik (LIFO - Son Giren Ilk Cixar). Metod bitdikde onun cercivesi (frame) silinir. | Avtomatik (Garbage Collector - Zibil Toplayici terefinden idare olunur).               |
| **Olcu**                  | Sabit ve daha kicik. JVM terefinden baslangicda teyin edilir.                          | Dinamik ve daha boyuk. Proqram isleyerken boyuyub kicile biler.                        |
| **Muraciet Sureti**       | Cox Suretli. Sade bir gosterici (pointer) ile idare olunur.                            | Daha Yavas. Daha murekkeb bir yaddas idareetmesi teleb edir.                           |
| **Heyat Muddeti**         | Qisa omurlu. Aid oldugu metod islediyi muddetce yasayir.                               | Uzun omurlu. Zibil Toplayici silene qeder yasamaga davam edir.                         |
| **Thread (Proses Axini)** | Her thread-in ozune mexsus bir Stek-i var.                                             | Butun thread-ler terefinden ortaq istifade edilir.                                     |
| **Qarsilasilan Xeta**     | **StackOverflowError:** Cox sayda metod cagrisi (derin rekursiya) ile Stek dolur.      | **OutOfMemoryError:** Heap-de yeni obyekt ucun kifayet qeder yer qalmadiqda bas verir. |

<div style="text-align:center" >

![Heap & Stack](../Storage/HeapAndStack.png)

</div>

## Java Input/Output streams

Umumen Java'da giris cixis emeliyyatlari stream(axin) vasitesi ile heyata kecirilir

> File sinifi

- `exists()`: Faylin ve ya qovlugun movcud olub-olmadigini yoxlayir (`boolean` qaytarir).
- `createNewFile()`: Yeni, bos bir fayl yaradir.
- `mkdir()`: Yeni bir qovluq yaradir.
- `mkdirs()`: Lazim gelerse, butun ust qovluqlarla birlikde yeni bir qovluq yaradir.
- `getName()`: Faylin ve ya qovlugun adini qaytarir.
- `getAbsolutePath()`: Faylin tam yolunu qaytarir.
- `length()`: Faylin olcusunu baytla qaytarir.
- `isDirectory()`: Obyektin qovluq olub-olmadigini yoxlayir.
- `isFile()`: Obyektin fayl olub-olmadigini yoxlayir.
- `listFiles()`: Qovlugun icindeki butun fayl ve qovluqlari `File` obyektleri massivi seklinde qaytarir.
- `delete()`: Fayli ve ya qovlugu silir

> FileReader, FileWriter ve BufferedWriter, BufferedReader

| Xususiyyet     | "Buffersiz" (`FileReader`/`FileWriter`) | "Bufferli" (`BufferedReader`/`BufferedWriter`)  |
| :------------- | :-------------------------------------- | :---------------------------------------------- |
| **Performans** | Yavas                                   | Cox Suretli                                     |
| **Emeliyyat**  | Her kicik data ucun bir disk emeliyyati | Datalari yigib bir defeye boyuk disk emeliyyati |
| **Prinsip**    | Bir-bir islemek                         | Toplu sekilde islemek                           |

> Byte stream / Character stream

| Xüsusiyyət        | Byte Stream (Bayt Axını)                 | Character Stream (Simvol Axını)                 |
| :---------------- | :--------------------------------------- | :---------------------------------------------- |
| **Əsas Vahid**    | **Bayt** (8 bit)                         | **Simvol** (`char`, adətən 16 bit)              |
| **Məqsəd**        | Hər növ fayl (şəkil, səs, video, mətn)   | **Yalnız mətn** faylları                        |
| **Kodlaşdırma**   | Simvol kodlaşdırmasından **xəbərsizdir** | Simvol kodlaşdırmasını **avtomatik idarə edir** |
| **Əsas Siniflər** | `InputStream` / `OutputStream`           | `Reader` / `Writer`                             |
