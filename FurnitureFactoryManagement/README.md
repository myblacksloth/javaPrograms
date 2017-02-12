# Strutture avanzate: Mappe  e Liste

## Traccia del Programma

Un mobilificio vuole informatizzare la gestione dei clienti e dei preventivi.
I dati relativi ai clienti sono memorizzati nel file **clienti.dat** organizzato come segue:

| Tipo di dato | Dato |
| ---: | :--- |
|Codice Fiscale | CCCNNN96A19J123A |
| Nome | Nanana |
| Cognome | Cecece |
| Indirizzo | Via delle Pigotte, 123, Napoli (NA) |

I preventivi sono memorizzati nel file **preventivi.dat** strutturato nel seguente modo:

| Tipo di dato | Dato |
| ---: | :--- |
| Numero identificativo del preventivo | 1 |
| Data | 12/02/2017 |
| Codice fiscale del richiedente | CCCNNN96A19J123A |
| Sconto applicato | 30 |
| Mobile | Tavolo |
| Tipo di mobile | Lusso |
| Quantità mobile | 1 |
| Prezzo del mobile | 800 |
| Mobile | Sedia |
| Tipo di mobile | Rustico |
| Quantità mobile | 1 |
| Prezzo del mobile | 120 |
| Altri mobili inclusi nel preventivo | ..... |
|Chiusura del preventivo | # |
| Prevenivo successivo | ...... |

### Istruzioni per lo sviluppo

Scrivere un programma che:

- implementi le classi necessarie per la gestione dei preventivi
- stampi tutti i prezzi dei preventivi prima e dopo che lo sconto fosse applicato
- dati nome e cognome del richiedente stampi tutti i preventivi richiesti da tale cliente con relativo prezzo prima e dopo l'applicazione dello sconto

#### Note di sviluppo

Viene utilizzato il programma *IntelliJ Idea*.

[© Antonio Maulucci 2017](http://www.antomau.com)
