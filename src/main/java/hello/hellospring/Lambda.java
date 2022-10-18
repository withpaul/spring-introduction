package hello.hellospring;

public class Lambda {
    public static void main(String[] args) {
        // 1. Object 객체에는 sum이 없어 컴파일에러
//        Object objectSumFunction = new SumFunction() {
//            @Override
//            public int sum(int a, int b) {
//                return 0;
//            }
//        };
//        objectSumFunction.sum(1, 2); //

        // 2. (1)번을 해결하기 위해 익명클래스 사용
        SumFunction sumFunction = new SumFunction() {
            @Override
            public int sum(int a, int b) {
                return a+b;
            }
        };
        int result = sumFunction.sum(1,2);
        System.out.println(result);

        // 3. (2)번보다 더 코드가 간결한 Lambda 방식
        SumFunction lambdaFunction = (a, b) -> a+b;
        lambdaFunction.sum(1,2);
        System.out.println(result);
    }
}

//@FunctionalInterface // 함수형 인터페이스는 단 하나의 추상 메서드만 가져야함
interface SumFunction {
    int sum(int a, int b);
};