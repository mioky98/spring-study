package hello.array;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

public class array01 {

	@Test
	void Test(){

		// 선언
		int[] arr1;
		int arr2[];
		int[] arr3 = new int[5];

		// 선언과 초기화 동시
		int[] arr4 = new int[]{1,2,3,4,5};

		int[] arr5 = {1,2,3,4,5};
//		int[] arr6 = new int[5]{1,2,3,4,5}; //오류

		// 선언 후 초기화

		int[] arr7;
//		arr7 = {1,2,3,4,5};	// 오류

		int[] arr8;
//		arr8 = new int[]{1,2,3,4,5}; // 성공

		// 배열 사용
		arr3[2] = 10; //배열 세 번째 요소에 값 10 저장

		int temp = arr3[2]; //변수에 배열 값 저장
	}

	public class Book{
		private String bookName;
		private String author;

		public Book() {}

		public Book(String bookName, String author){
			this.bookName = bookName;
			this.author = author;
		}

		public void showBookInfo(){
			System.out.println(bookName + "," + author);
		}

		public String getBookName() {
			return bookName;
		}

		public void setBookName(String bookName) {
			this.bookName = bookName;
		}

		public String getAuthor() {
			return author;
		}

		public void setAuthor(String author) {
			this.author = author;
		}
	}

	@Test
	void test2(){
		Book[] library = new Book[5];

		for (Book book : library) {
			System.out.println(book);
		}
	}
	
	@Test
	void test3(){
		Book[] library = new Book[5];

		library[0] = new Book("태백산맥", "조정래");
		library[1] = new Book("데미안", "헤르만 헤세");
		library[2] = new Book("어떻게 살 것인가", "유시민");
		library[3] = new Book("토지", "방경리");
		library[4] = new Book("어린왕자", "생텍쥐페리");

		for (Book book : library) {
			book.showBookInfo();
		}

		for (Book book : library) {
			System.out.println(book);
		}
	}

	@Test
	void test4(){
		int[] array1 = {10,20,30,40,50};
		int[] array2 = {1,2,3,4,5};

		System.arraycopy(array1, 0, array2, 1, 4);
		//복사할 배열, 복사할 첫 위치, 대상 배열, 붙여 넣을 첫 위치, 복사할 요소 개수

		for (int i : array2) {
			System.out.println(i);
		}
	}

	@Test
	void test5(){
		Book[] library1 = new Book[3];
		Book[] library2 = new Book[3];

		library1[0] = new Book("태백산맥", "조정래");
		library1[1] = new Book("데미안", "헤르만 헤세");
		library1[2] = new Book("어떻게 살 것인가", "유시민");
		System.arraycopy(library1, 0, library2, 0, 3);

		for(Book book : library2){
			book.showBookInfo();
		}
	}

	@Test
	void test6(){
		Book[] library1 = new Book[3];
		Book[] library2 = new Book[3];

		library1[0] = new Book("태백산맥", "조정래");
		library1[1] = new Book("데미안", "헤르만 헤세");
		library1[2] = new Book("어떻게 살 것인가", "유시민");
		System.arraycopy(library1, 0, library2, 0, 3);

		library1[0].setAuthor("박완서");
		library1[0].setBookName("나목");

		System.out.println("====== library1 ==========");
		for(Book book : library1){
			book.showBookInfo();
		}

		System.out.println("====== library2 ==========");
		for(Book book : library2){
			book.showBookInfo();
		}

	}

	@Test
	void test7(){
		Book[] library1 = new Book[3];
		Book[] library2 = new Book[3];

		library1[0] = new Book("태백산맥", "조정래");
		library1[1] = new Book("데미안", "헤르만 헤세");
		library1[2] = new Book("어떻게 살 것인가", "유시민");
		//System.arraycopy(library1, 0, library2, 0, 3);

		library2[0] = new Book();
		library2[1] = new Book();
		library2[2] = new Book();

		for(int i=0; i< library1.length; i++){
			library2[i].setBookName(library1[i].getBookName());
			library2[i].setBookName(library1[i].getBookName());
		}

		System.out.println("====== library2 ==========");
		for(Book book : library2){
			book.showBookInfo();
		}

		library1[0].setAuthor("박완서");
		library1[0].setBookName("나목");

		System.out.println("====== library1 ==========");
		for(Book book : library1){
			book.showBookInfo();
		}

		System.out.println("====== library2 ==========");
		for(Book book : library2){
			book.showBookInfo();
		}
	}

	@Test
	void test8(){
		int[][] arr = {{1,2,3},{4,5,6}};

		System.out.println("=== 이차원 배열 ===");
		for (int[] temp : arr) {
			for (int value : temp) {
				System.out.print(value + " ");
			}
			System.out.println();
		}

		int [][][] arr2 = {{{1,2},{3,4}},{{5,6},{7,8}}};

		System.out.println("=== 삼차원 배열 ===");
		for (int[][] temp1 : arr2) {
			for (int[] temp2 : temp1) {
				for (int value : temp2) {
					System.out.println(value + " ");
				}
				System.out.println();
			}
			System.out.println();
		}
	}

	@Test
	void test9(){
		ArrayList<Book> library = new ArrayList<>();

		library.add(new Book("태백산맥", "조정래"));
		library.add(new Book("데미안", "헤르만 헤세"));
		library.add(new Book("어떻게 살 것인가", "유시민"));
		library.add(new Book("토지", "방경리"));
		library.add(new Book("어린왕자", "생텍쥐페리"));

		for(int i=0; i<library.size(); i++){
			Book book = library.get(i);
			book.showBookInfo();
		}
		System.out.println();

		library.remove(2);
		System.out.println("=== Enhanced for문 사용 ===");

		if(!library.isEmpty()) {
			for (Book book : library) {
				book.showBookInfo();
			}
		}

	}

	@Test
	void test10(){
		float[] ch = new float[]{0.0f};
		System.out.println(ch[0]+"@@@@@@");
	}
}
