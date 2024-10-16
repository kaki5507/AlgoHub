import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
		StringTokenizer str = new StringTokenizer(input," ");
		int a = Integer.parseInt(str.nextToken());
		int b = Integer.parseInt(str.nextToken());
		
		for(int i=a; i<=b; i++){
			if(sosu(i)){ // 1보다 큰 값 나오면 소수 @ 소수아니면 return 0으로 보내줄 것.
				System.out.println(i);
			};
		}
    }
	
	public static boolean sosu(int n){
		if(n < 2){return false;}
		
		for(int i=2; i * i<=n; i++){
			if(n % i == 0){
				return false;
			}
		}
		return true;
	}
}