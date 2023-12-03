public interface AbleToCalculatePension {

    double calculatePension();

    enum GenderType {
        MALE,
        FEMALE,
    }
}
/*
БОЛЬШОЙ ПРОЕКТ
Подготовка:
1) Выделите все классы проекта про пенсионный фонд в отдельный проект
(у кого чего-то нет, то за основу можете взять мою версию проекта - https://github.com/Daniil1380/homework)
2) Создайте Файл со списком популярных имен людей (можно сделать самому или найти в интернете).
3) Создайте Файл со списком популярных пенсионных фондов в вашей стране проживания
(можно сделать самому или найти в интернете или придумать).
Разработка:
4) Создайте класс-генератор людей. Сгенерируйте 10 тысяч человек.
Каждому из них сгенерируйте имя, минимальную зарплату,
максимальную зарплату, пол. Запишите все это в файл.
Пример формата записи (можно сделать по другому): name minSalary maxSalary Gender
Пример с реальными значениями:
Даниил 500 1000 MALE
5) Создайте генератор пенсионных фондов.
Сгенерируйте 100 пенсионных фондов. Сгенерируйте поля имя, state. Все это запишите в файл.
Формат записи может быть такой:
Пенсионный фонд Хогвартса, true
6) Создайте класс, который будет считывать файл, сгенерированый в
пункте 4 и создавать объекты класса Worker.
7) Создайте класс, который будет считывать файл, сгенерированый в
пункте 5 и создавать объекты класса PernsionFund. Не забудьте добавить
каждому пенсионному фонду случайно выбранных людей из пункта 6 в
список вложенцев (поле persons).
Если хотите по-сложнее, то делайте это не случайно, а генерируйте каждому
человеку один или несколько фондов в пункте 4.
9) Дополнительно: сделайте выбор функций подсчета через работу с консолью
10) Дополнительно v2: сделать генерацию других сложных полей (рабочие
дни, день создания пенс. фонда и другие)
 */

