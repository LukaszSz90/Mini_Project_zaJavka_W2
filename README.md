# Mini_Project_zaJavka_W2
Projekt z warsztatu 2, kursu "zaJavka".

**Example of an input sequence:**
ADD PERSON(Tomasz_Romański)
ADD PERSON(Rafał_Adamczuk)
ADD PERSON(Tomasz_Romański)
ADD PERSON(Mariusz_Wilczek)
ADD PERSON(Zbigniew_Ratownik)
PROCESS
LEAVE PERSON(Tomasz_Romański_2)
LEAVE PERSON(Mariusz_Wilczek)
PROCESS
PROCESS
PROCESS

**Example of what can be printed on the screen:**
ADD PERSON(Tomasz_Romański)
Tomasz_Romański_1 came to the queue: true
Queue: [Tomasz_Romański_1]

ADD PERSON(Rafał_Adamczuk)
Rafał_Adamczuk_1 came to the queue: true
Queue: [Tomasz_Romański_1, Rafał_Adamczuk_1]

ADD PERSON(Tomasz_Romański)
Tomasz_Romański_2 came to the queue: true
Queue: [Tomasz_Romański_1, Rafał_Adamczuk_1, Tomasz_Romański_2]

ADD PERSON(Mariusz_Wilczek)
Mariusz_Wilczek_1 came to the queue: true
Queue: [Tomasz_Romański_1, Rafał_Adamczuk_1, Tomasz_Romański_2, Mariusz_Wilczek_1]

ADD PERSON(Zbigniew_Ratownik)
Zbigniew_Ratownik_1 came to the queue: true
Queue: [Tomasz_Romański_1, Rafał_Adamczuk_1, Tomasz_Romański_2, Mariusz_Wilczek_1, Zbigniew_Ratownik_1]

PROCESS
Processing queue: Tomasz_Romański_1 arrived at the store
Queue: [Rafał_Adamczuk_1, Tomasz_Romański_2, Mariusz_Wilczek_1, Zbigniew_Ratownik_1]

LEAVE PERSON(Tomasz_Romański_2)
Leaving queue: Tomasz_Romański_2
Queue: [Rafał_Adamczuk_1, Mariusz_Wilczek_1, Zbigniew_Ratownik_1]

PROCESS
Processing queue: Rafał_Adamczuk_1 arrived at the store
Queue: [Mariusz_Wilczek_1, Zbigniew_Ratownik_1]

PROCESS
Processing queue: Mariusz_Wilczek_1 arrived at the store
Queue: [Zbigniew_Ratownik_1]

PROCESS
Processing queue: Zbigniew_Ratownik_1 arrived at the store
Queue: []
