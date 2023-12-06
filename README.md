                                                  Sprawozdanie z laboratorium 5 
                                              Metodyki Wytwarzania Oprogramowania 
                                                      Dawid Dobosz 319034 
                                                          05.12.2023r.
1. Aplikacja MVC napisana w Spring + Thymeleaf 
 
  Napisałem prostą aplikację CRUD w Spring + Thymeleaf [Java], przeprowadzająca operacje dodawnia, usuwania, wyświetlania I edycji dowolnych produktów na stronie. 
  Thymeleaf to template engine, który odpowiada za renderowanie html oraz za możliwość 	wstrzykiwania kodu Javy(tj. Obiektów) do naszych plików HTML. 

2. Widoki aplikacji:
  ![image](https://github.com/briocky/mwolabgit/assets/69260736/f35f41df-6b5f-4321-a013-672d8ce27a2e)
  ![image](https://github.com/briocky/mwolabgit/assets/69260736/7c34bd53-641f-4b41-a173-cc83eaa097a9)
  ![Screenshot from 2023-12-06 18-15-20](https://github.com/briocky/mwolabgit/assets/69260736/9ac634e3-03b1-4d9d-98c9-fb9e8c8cece4)
  ![Screenshot from 2023-12-06 18-16-16](https://github.com/briocky/mwolabgit/assets/69260736/a7d13efa-3c4a-440e-b050-bb7711c3568c)

3. Testy UI w Selenium (Java) 

	W celu przeprowadzanie testów UI użyłem Selenium, który korzysta z driver’a(w moim przypadku Firefox) do przeprowadzenia interakcji z aplikacją.
  Przykład jednego z nich:
  ![Screenshot from 2023-12-05 23-06-36](https://github.com/briocky/mwolabgit/assets/69260736/b430d346-823d-4c9a-b528-4f6b3a439dff)

4. Włącznie ochrony dla gałęzi master - wymuszanie PR oraz pomyślnego builda przed zmergowaniem
  ![Screenshot from 2023-12-06 18-23-20](https://github.com/briocky/mwolabgit/assets/69260736/2e3267cc-bfda-46c1-aaaf-756ca135415e)
  ![image](https://github.com/briocky/mwolabgit/assets/69260736/7221483a-2ad9-4949-b069-b43ed7c99af4)

5. Pipeline do automatycznego budowania przy PR
   Moja aplikacja zostałą napisana w Javie dlatego używam odpowiednich akcji githuba stosownych do tego języka.
  ![image](https://github.com/briocky/mwolabgit/assets/69260736/5c64c425-1f89-40bc-b881-f614ec00bb77)

6. Integracja z Azure DevOps w celu zgłaszania błędów podczas testowania
   W celu integracji na stronie Azure DevOps utworzyłem nową organizacje oraz nowy projekt dla tego zadania. Po wejściu w ustawienia mogłem wygenerować Osobisty klucz dostępu do tego projektu.
  ![image](https://github.com/briocky/mwolabgit/assets/69260736/0d6d06b0-bb77-40cf-a456-bf118d9a99d7)
  Wygenrowany klucz skopiowałem do sekretów akcji na GitHub, a następnie używam go pipelinie do wywołania endpointu tworzącego zadanie typu Issue.
  ![image](https://github.com/briocky/mwolabgit/assets/69260736/e64e49a1-9431-4774-8d8a-f6d7847a5290)
  W tym momencie, gdy nasz test na PR nie przejdzie, to zostanie zgłoszone zadanie na Azure DevOps.

7. Test czy integracja z Azure DevOps działa
  Przygotowuje commit z testem, który nie przechodzi(próba pobrania elementu o id, które nie istnieje na stronie).
  ![image](https://github.com/briocky/mwolabgit/assets/69260736/852ef0e2-f0c5-4ae5-b7e6-ab1834afa672)
  Podczas tworzenia PR, zostaje wywołany build wraz z testami, które nie przechodzą wobec tego na stronie DevOps powinno wygenerować się zadanie.
  ![image](https://github.com/briocky/mwolabgit/assets/69260736/7cac8155-1332-4cb1-955a-97939b5d9574)
  Wygenerowane zadanie:
  ![image](https://github.com/briocky/mwolabgit/assets/69260736/f644709b-344a-4853-82bf-79b0d5351460)




