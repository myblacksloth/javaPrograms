# Struttre avanzate: Le mappe

## Traccia del programma

Una catena di alberghi possiede un archivio dei propri alberghi.
Nel file **alberghi.dat** sono memorizzate le informazioni relative alla localizzazione degli alberghi, come segue:

| tipo di dato | dato |
| ---: | :--- |
| codice albergo | ALB1 |
| nome albergo | Hotel Dell'Alba |
| indirizzo | via Roma, 15 |
| città | Milano |
| nazione | Italia |
| telefono | +39xxxxxx |
| fax | +39kkkkkk |

Un secondo file denominato **stanze.dat** contiene le informazioni relative alle stanze presenti in ciascun albergo. Infatti, ciascun albergo ha stanze che si differenziano per la tipologia. Ogni tipologia offre servizi differenti.
L'elenco delle tipologie di un albergo viene separato dall'elenco delle tipologie di un altro albergo mediante il carattere *#*
Il file è strutturato come segue:

| tipo di dato | dato |
| ---: | :--- |
| codice albergo | ALB1 |
| numero di stanze tip.1 | 12 |
| prezzo tip.1 | 30 |
| tv tip.1 | si |
| condizionatore tip.1 | no |
| frigo tip.1 | si |
| internet tip.1 | no |
| numero di stanzw rip.2 | 7 |
| prezzo tip.2 | 90 |
| ..... | ..... |
| # | |
| ... altro albergo ... | |

Inserire tutti i dati nel modo come visto sopra e aggiungere nuove tipologie di stanze.

## Istruzioni per lo sviluppo

Scrivere un programma che implementi tutte le classi ed i relativi metodi per la gestione dell'archivio, e permetta di effettuare interrogazioni su più attributi come:

 - trovare alberghi che costano meno di 40 euro
 - trovare alberghi che costano tra 40 e 90 euro
 - trovare alberghi con tv e accesso a internet
 - trovare alberghi che hanno un costo <50€ ed offrono aria condizionata

### Info
Non vi sono note sull'IDE di sviluppo

[My WebSite](http://www.antomau.com)

© Antonio Maulucci 2017
