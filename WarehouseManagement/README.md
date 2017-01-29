# Strutture avanzate
## Traccia del programma
Un'azienda di articoli sportivi gestisce la dislocazione dei propri prodotti su più magazzini.

Un file  denominato **magazzino.dat** contiene le informazioni relative alla localizzazione dei magazzini, come segue:
| tipo di dato | dato |
| ---: | :--- |
| codice magazzino | ENG07F12 |
| indirizzo | via magno, 7 |
| città | Roma |
| nazione | Italia |
| numero di telefono | ++3906xxxxxx |
| fax | ++3906xxxxxxxx|

Un secondo file, denominato **prodotti.dat**, contiene le informazioni relative ai prodotti:
| tipo di dato | dato |
| ---: | :--- |
| codice prodotto | SCP22LK |
| descrizione | cellulare smartphone |
| prezzo | 729 |


Un terzo file denominato **giacenze.dat** contiene le disponibilità nei vari magazzini:
| tipo di dato | dato |
| ---: | :--- |
| codice magazzino | ENG07F12 |
| codice prodotto | SCP22LK |
| quantità | 20 |
## Nota per lo sviluppo
Ogni tripla denota che il prodotto con *codice prodotto* indicato è disponibile nel magazzino *codice magazzino* indicato nella quantità *quantità*.
> Esempio:
> La tripla indicata denota che il magazzino d Roma contiene 20 cellulare smartphone
## Istruzioni per lo sviluppo
Scrivere un programma che include tutte le necessarie classi, ed implementi alcune funzionalità, come ad esempio, dato un codice di prodotto, restituire l'elenco di tutti i magazzini che lo contengono.
### Struttura del report

**Descrizione prodotto:** cellulare smartphone
**Prezzo:** 729
| Nazione | Città | Indirizzo | Quantità |
| --- | --- | --- | --- |
| Italia | Roma | via magno, 7 | 20 |
### Info
Per realizzare questo programma viene utilizzato l'editor (IDE) *IntelliJ Idea*

<!-- this is a readme file -->
<!-- it's written in markdown language -->
<!-- it can be converted to html language -->
<!-- Use following online tools to manage/edit markdown files -->
<!-- https://stackedit.io -->
<!-- http://dillinger.io/ -->
<!-- https://github.com/adam-p/markdown-here/wiki/Markdown-Cheatsheet -->
