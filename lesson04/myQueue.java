/* Реализуйте очередь с помощью LinkedList со следующими методами:
enqueue() - помещает элемент в конец очереди,
dequeue() - возвращает первый элемент из очереди и удаляет его,
first() - возвращает первый элемент из очереди, не удаляя. */

// Решение.
// Создан класс newQueue на базе LinkedList
// помимо трёх заданных методов реализован метод print(), выводящий очередь в виде строки


package lesson04;

import java.util.LinkedList;

class newQueue {
    private LinkedList<Integer> list = new LinkedList<>();

    // Добавление элемента в конец очереди
    public void enqueue(int element) {
        this.list.add(element);
    }

    // Возвращает первый элемент из очереди и удаляет его
    public int dequeue() {
        return this.list.removeFirst();
    }

    // Возвращает первый элемент из очереди и не удаляет его
    public int first() {
        return this.list.get(0);
        // возможен вариант с использованием getFirst()
    }

    // Вывод седржимого очереди в виде строки
    public String print(){
        StringBuilder ans = new StringBuilder("");
        for(int i = 0; i < this.list.size(); i++) ans.append(list.get(i) + " ");
        return ans.toString();
    }

}


public class myQueue {
    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);
        newQueue queue = new newQueue();

        // Заполняем очередь элементами - новый элемент в конец очереди с использованием enqueue()
        for(int i = 0; i < 10; i++){
            queue.enqueue((int) (Math.random() * 100));
            System.out.println(queue.print());          // пошагово проверяем корректное добавление в конец очереди
        }

        // Получаем первый элемент очереди, удаляя его из неё, используем dequeue()
        System.out.println(queue.dequeue());  
        // И проверяем, что элемент из очереди ушёл
        System.out.println(queue.print());
    
        queue.enqueue((int) (Math.random() * 100));
        queue.enqueue((int) (Math.random() * 100));

        // Получаем первый элемент из очереди без удаления, используем first()
        System.out.println(queue.first());  
        // И проверяем, что элемент из очереди не ушёл
        System.out.println(queue.print());

    }
   
}
