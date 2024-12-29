public class LinkedStack {
    private Node tail; // ссылка на последний добавленный узел (обёртку)
    private int size; // размер стека, т.е. количество элементов в нём

    public void push(int value) {
        Node node = new Node(value); // создаём новый узел
        if (tail != null) { // если в стеке уже есть элементы
            node.setPrev(tail); // связываем новый узел с последним
        }
        tail = node; // назначаем новый узел последним узлом
        size++; // увеличиваем счётчик элементов
    }

    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Стек пустой");
        }
        int value = tail.getValue(); // берем значение из последнего узла
        tail = tail.getPrev(); // назначаем предыдущий узел последним узлом
        size--; // уменьшаем счётчик элементов
        return value; // возвращаем значение
    }

    public int getSize() {
        return size; // возвращаем размер стека
    }

    public boolean isEmpty() {
        return size == 0; // возвращаем ответ на вопрос, не пустой ли стек
    }

    public String toString() {
        if (isEmpty()) {
            return "EMPTY"; // если стек пустой
        }

        StringBuilder sb = new StringBuilder();
        Node current = tail;

        while (current != null) {
            sb.append(current.getValue());
            if (current.getPrev() != null) {
                sb.append(" -> "); // добавляем стрелки между элементами
            }
            current = current.getPrev(); // переходим к предыдущему узлу
        }

        return sb.toString(); // возвращаем строку с элементами стека
    }
}