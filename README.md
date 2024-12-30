<h3> Шагающий робот</h3>

<b>Описание</b><br>
Известная задача по многопоточному программированию про шагающего робота<br>

Жми ★ если понравилось.<br><br>

<b>Условие задачи, которое я слышал</b><br>
Каждой ногой робота управляет свой поток.<br>
Нужно синхронизировать потоки таким образом, чтобы в консоли мы увидели,<br>
как робот правильно шагает: правая нога, левая, правая, левая <br>

<b>Варианты решения</b><br>
Простой классический вариант решения с использованием wait() и notify()<br>
<a href="/src/main/java/org/example/Robot1.java">Robot1.java</a> <br>
Другой вариант решения, с помощью ReentrantLock<br>
<a href="/src/main/java/org/example/Robot2.java">Robot2.java</a> <br>

<b>Задания для тех, кто хочет больше</b><br>
~ Более простое задание - добейтесь, чтобы каждый шаг в  Robot1.java<br> 
был равномерным<br>
~ Более сложное задание - сделайте Робота с 3 ногами