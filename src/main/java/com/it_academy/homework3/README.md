1. Модифицировать калькулятор, чтобы его было удобно покрыть юнит-тестами.
   Для этого всю логику работы, включая парсинг строк, в числа необходимо вынести из main
   в другие методы. Например, double calculate(double number1, double number2) ...
   В самом main может оставаться только чтение ввода пользователя и вызов других методов.
   Также логику можно разбить на несколько методов по своему усмотрению.

[Homework 3](https://github.com/ukamo/Test-Automation-Group-4/tree/main/src/main/java/com/it_academy/homework3/calculator)

2. Написать юнит-тесты для методов получившегося приложения. Критерием оценки будет близость к
   100% покрытию всех команд и ветвей этих методов.
   Для написания тестов использовать JUnit5 или TestNG

[CalculatorNewTest.java](https://github.com/ukamo/Test-Automation-Group-4/blob/main/src/test/java/com/it_academy/homework3/calculator/CalculatorNewTest.java)

3. Для максимальной оценки добавить к работе сгенерированный html репорт с результатом выполнения тестов.

[HTML репорт](JUnit5Assertions%20Report.html)