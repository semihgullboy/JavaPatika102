public class MyList <T> {
    public int capacity=10;

    T[] array= (T[]) new Object[10]; //Varsayılan Boyutu
    
    public MyList() {
        T[] array = (T[]) new Object[10];
    }//Birinici Constructor - Boş contructor kullanılırsa dizinin başlangıç boyutu 10 olmalıdır.

    public MyList(int capacity) {
        this.capacity = capacity;
        T[] array= (T[]) new Object[capacity];
    }//İkinci Constructor - Dizinin başlangıç değeri capacity parametresinden alınmalıdır.

    public int size(){
        int count=0;
        for (int i = 0; i < array.length ; i++) {
            if(array[i]!=null){
                count++;
            }
        }
        return count;
    }//dizideki eleman sayısını verir

    public int getCapacity(){
        return this.capacity;
    }//dizinin kapasite değerini verir.

    public void add(T data){

        if(this.size()==this.getCapacity())
        {
            this.capacity=capacity*2;
            T [] newArray= (T[]) new Object[capacity];
            for (int i = 0; i < array.length ; i++) {
                newArray[i]=array[i];
            }
            newArray[(array.length)]=data;
            this.array=newArray;

        }
        else{
            array[this.size()]=data;
        }
    }//sınıfa ait diziye eleman eklemek için kullanılmalıdır. Eğer dizide yeteri kadar yer yok ise, dizi boyutu 2 katına çıkartılmalıdır.

    public T get(int index){
        return this.array[index];
    }// verilen indisteki değeri döndürür. Geçersiz indis girilerse null döndürür.

    public T remove(int index){

        this.array[index]=null;
        T removed=this.array[index];
        if(index>this.getCapacity()&&index<0){
            return null;
        }
        for (int i = index; i <this.size() ; i++) {
            this.array[i+1]=this.array[i];
            //1,2,null,3,4,5
            this.array[i]=removed;

        }
        return removed;
    }//verilen indisteki veriyi silmeli ve silinen indis sonrasında ki verileri sol doğru kaydırmalı. Geçersiz indis girilerse null döndürür.

    public T set(int index,T data){
        this.array[index]=data;
        T set =this.array[index];
        return set;
    }//verilen indisteki veriyi yenisi ile değiştirme işlemini yapmalıdır. Geçersiz indis girilerse null döndürür.

    @Override
    public String toString(){
        String str="";
        for (int i = 0; i <this.array.length ; i++) {
            if(array[i]!=null){

                str=str+this.array[i]+",";
            }

        }
        return str;
    }//Sınıfa ait dizideki elemanları listeleyen bir metot.

    public int indexOf(T data){
        for (int i = 0; i <this.array.length ; i++) {
            if(array[i]==data){
                return i;
            }
        }
        return -1;
    }//Parametrede verilen nesnenin listedeki indeksini verir. Nesne listede yoksa -1 değerini verir.

    public int lastIndexOf(T data){
        for (int i = this.array.length-1; i>=0; i--) {
            if(array[i]==data){
                return i;

            }
        }
        return -1;
    }//Belirtilen öğenin listedeki son indeksini söyler. Nesne listede yoksa -1 değerini verir.


    public boolean isEmpty(){
        int count =0;
        for (int i = 0; i < array.length ; i++) {
            if(array[i]==null){
                count++;
            }

        }if(count==array.length){
            return true;
        }

        else{
            return false;
        }
    }//Listenin boş olup olmadığını söyler.

    public T []toArray(){
        T [] newlist= (T[]) new Object[getCapacity()];
        for (int i = 0; i <this.array.length ; i++) {
            newlist[i]=this.array[i];
        }
        return newlist;
    }//Listedeki öğeleri, aynı sırayla bir array haline getirir.

    public void clear(){
        for (int i = 0; i <this.array.length ; i++) {
            this.array[i]=null;
        }
    }// Listedeki bütün öğeleri siler, boş liste haline getirir.

    public MyList <T> sublist(int start,int finish){
        int size=finish+1-start;
        MyList <T> myNewList =new MyList<>(size);
        int j=0;
        for (int i = start; i <=finish ; i++) {
            myNewList.add(array[i]);
        }
        return myNewList;
    }// Parametrede verilen indeks aralığına ait bir liste döner.

    public boolean contains(T data){
        if(lastIndexOf(data)!=-1&&indexOf(data)!=-1){

            return true;
        }
        else{
            return false;
        }
    }//Parametrede verilen değerin dizide olup olmadığını söyler.
}
