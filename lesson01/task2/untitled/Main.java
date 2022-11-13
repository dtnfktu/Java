// Вывести все простые числа от 1 до 1000 

public class Main
{
    public static void main(String[] args) {
        int n = 1_000;
        System.out.print("2");                      //единственное чётное простое число - сама двойка

        for(int i = 3; i <= n; i += 2) {            // начинаем с 3, шаг = 2 чтобы чётные числа не проверять - они все составные
            if (isSimpleNum(i)) System.out.print(" " + i);
        }

    }

    // Определяет является ли число N простым
    static boolean isSimpleNum(int N) {
        boolean ans = true;                         // изначально полагаем, что число простое
        for(int i = 2; i < Math.sqrt(N);i++) {	// проверять дальше корня из числа смысла нет - делителей нет
            if (N % i == 0) {
                ans = false;                        // нашли хотя бы один делитель - число составное
                break;                              // дальше искать не имеет смысла
            }
        }
        return ans;
    }

}