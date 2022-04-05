# PAO_Food_Delivery
Pentru acest proiect am realizat schema unei firme de livrare de mancare. Pentru a incepe sa utilizezi aplicatia, trebuie mai intai sa se adauge macar un client si un curier. Apoi se poate da o comanda. Pentru a da o coamnda trebuie selectat user-ul care vrea sa dea comanda, apoi curierul care sa i-o livreze. Dupa trebuie sa selecteze restaurantul si produsele cu tot cu numarul de bucati pe care il doreste. Odata ce un curier are asignata o comanda, aceasta nu va mai putea fi utilizat si in alte comenzi.

Cele 8 tipuri de obiecte sunt:

User - acesta este clasa de baza pentru un utilizator

Customer - acesta clasa reprezinta clientii

Courier - aceasat calsa reprezinta curierii

Administrator - aceasta clasa reprezinta administratorii aplicatiei

Order - aceasta clasa reprezinta comanda pe care o vor da clientii

CustomerAddress - aceasta clasa reprezinta adresa unui client

Restaurant - aceasta clasa reprezinta un restaurant

MenuRestaurant - aceasta clasa contine produsele unui restaurant

Pentru aproape fiecare clasa am si un serviciu, unde se afla operatiile claselor. AdministratorService este clasa in care sunt cele mai multe operatii si de unde se gestioneaza majoritatea proiectului. 

Interogarile care se pot utiliza sunt si in clasa Manage in metoda Options. Acestea sunt:

Crearea unui Restaurant - aceasat functie se apeleaza la inceput pentru a ne asigura ca exista cateva restaurante inainte de a incepe aplicatia.

Crearea unui Client.

Crearea unui Curier.

Crearea unui Administrator.

Adaugarea unui Restaurant.

Afisarea tuturor Clientilor.

Afisarea tuturor Curierilor.

Afisarea tuturor Restaurantelor.

Afisarea tuturor Comenzilor.

Crearea unei comenzi noi.

Schimbarea parolei unui Client - aceasta este posibila si pentru Curier si Administrator dar nu le-am mai inclus in meniu.

Stergerea unui Client.

Stergerea unui Restaurant.
