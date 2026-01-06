# Poket Click 🎮💕

Un gioco clicker in stile idle game realizzato in Java con grafica a tema Pokémon. Clicca sul tuo Pokémon preferito per guadagnare punti "amore" e acquista upgrade per aumentare automaticamente i tuoi guadagni!

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Swing](https://img.shields.io/badge/Swing-GUI-blue?style=for-the-badge)

## 📋 Descrizione

Poket Click è un gioco incrementale dove i giocatori possono:
- Cliccare su un Pokémon per guadagnare punti "amore"
- Acquistare upgrade che aumentano i punti passivi guadagnati al secondo
- Vedere i propri progressi con un display in tempo reale
- Resettare il gioco in qualsiasi momento

## ✨ Caratteristiche

- **Sistema di Click**: Clicca sul Pokémon per guadagnare punti immediati
- **Upgrade System**: 4 livelli di upgrade con costi e benefici crescenti:
  - +10% love/sec (costo: 10 punti)
  - +25% love/sec (costo: 50 punti)
  - +50% love/sec (costo: 200 punti)
  - Doppio love/sec (costo: 1000 punti)
- **Guadagno Passivo**: Accumula punti automaticamente con gli upgrade
- **Display in Tempo Reale**: Visualizza il punteggio e i punti al secondo
- **Sistema di Reset**: Ricomincia da capo quando vuoi
- **Grafica Personalizzata**: Design con immagini Pokémon

## 🛠️ Requisiti

- **Java Development Kit (JDK)** versione 8 o superiore
- **IDE Java** (consigliato Eclipse, ma funziona anche con IntelliJ IDEA o NetBeans)
- Sistema operativo: Windows, macOS o Linux

## 🚀 Come Eseguire il Gioco

### Opzione 1: Da Eclipse (Consigliato)

1. **Importa il progetto**:
   - Apri Eclipse
   - File → Import → Existing Projects into Workspace
   - Seleziona la cartella `Poket_Click`
   - Click su "Finish"

2. **Esegui il gioco**:
   - Naviga a `src/com/gioco/poket_click/PoketClickFrame.java`
   - Click destro sul file → Run As → Java Application

### Opzione 2: Da Linea di Comando

1. **Compila il progetto**:
```bash
cd Poket_Click/src
javac com/gioco/poket_click/*.java
```

2. **Esegui il gioco**:
```bash
java com.gioco.poket_click.PoketClickFrame
```

### Opzione 3: Creare un JAR Eseguibile

1. In Eclipse:
   - File → Export → Java → Runnable JAR file
   - Seleziona `PoketClickFrame - Poket_Click` come Launch configuration
   - Scegli la destinazione del file JAR
   - Click su "Finish"

2. Esegui il JAR:
```bash
java -jar PoketClick.jar
```

## 🎮 Come Giocare

1. **Inizia a Cliccare**: Clicca sul Pokémon centrale per guadagnare punti amore
2. **Acquista Upgrade**: Usa i pulsanti sulla destra per comprare upgrade quando hai abbastanza punti
3. **Guarda Crescere i Tuoi Punti**: Gli upgrade aumentano automaticamente i tuoi punti al secondo
4. **Reset**: Clicca sul pulsante RESET in basso per ricominciare

## 📁 Struttura del Progetto

```
Poket_Click/
├── src/
│   ├── com/gioco/poket_click/
│   │   ├── PoketClickFrame.java      # Finestra principale
│   │   ├── Game.java                 # Logica centrale del gioco
│   │   ├── GamePanel.java            # Pannello di rendering
│   │   ├── GameState.java            # Gestione stato (Singleton)
│   │   ├── GameObject.java           # Classe base per oggetti
│   │   ├── ClickableObject.java      # Oggetti cliccabili
│   │   ├── ButtonObject.java         # Pulsanti di upgrade
│   │   ├── TextObject.java           # Display di testo
│   │   ├── ScoreDisplay.java         # Display punteggio
│   │   ├── LovePerSecondDisplay.java # Display love/sec
│   │   ├── ClickEvent.java           # Gestione eventi click
│   │   ├── PokeClickEvent.java       # Click sul Pokémon
│   │   ├── UpgradeClickEvent.java    # Click su upgrade
│   │   ├── UpgradeConfig.java        # Configurazione upgrade
│   │   └── DynamicTextObject.java    # Testo dinamico
│   └── images/
│       ├── baylees.png               # Immagine Pokémon principale
│       ├── celebi.png                # Immagine alternativa
│       ├── button.png                # Immagine pulsante
│       └── window_icon.jpg           # Icona finestra
├── bin/                              # File compilati (.class)
└── README.md                         # Questo file
```

## 🏗️ Architettura del Codice

### Pattern Utilizzati

- **Singleton Pattern**: `GameState` per gestire lo stato globale del gioco
- **Event-Driven Architecture**: Sistema di eventi per gestire le interazioni
- **Inheritance**: Gerarchia di oggetti di gioco (`GameObject` → `ClickableObject`, `ButtonObject`, etc.)

### Classi Principali

- **PoketClickFrame**: Entry point, gestisce la finestra JFrame
- **Game**: Controller principale, inizializza e gestisce il game loop
- **GamePanel**: Pannello custom per il rendering degli oggetti
- **GameState**: Singleton che mantiene punteggio e statistiche
- **GameObject**: Classe base astratta per tutti gli oggetti visualizzabili

## 🎨 Personalizzazione

Vuoi personalizzare il gioco? Ecco alcuni suggerimenti:

1. **Cambia il Pokémon**: Sostituisci `baylees.png` con il tuo Pokémon preferito
2. **Modifica i Costi degli Upgrade**: Cambia i valori in `Game.createUpgradeButtons()`
3. **Aggiungi Nuovi Upgrade**: Aggiungi nuove istanze di `UpgradeConfig`
4. **Cambia i Colori**: Modifica i colori in `PoketClickFrame` e nei vari display

## 🐛 Risoluzione Problemi

### Il gioco non si avvia
- Verifica di avere JDK 8+ installato: `java -version`
- Controlla che tutte le immagini siano nella cartella `src/images/`

### Le immagini non vengono caricate
- Assicurati che le immagini siano nella cartella `src/images/`
- Verifica che i nomi dei file corrispondano esattamente a quelli nel codice

### Eclipse non trova le classi
- Prova a fare: Project → Clean → Clean all projects
- Verifica che la cartella `src` sia nel build path

## 👨‍💻 Autore

Creato da **@lixii33**

## 📝 Licenza

Questo progetto è stato creato a scopo educativo e personale. Le immagini dei Pokémon sono proprietà di Nintendo/Game Freak/The Pokémon Company.

## 🎯 Roadmap Futura

Possibili miglioramenti futuri:
- [ ] Salvataggio/caricamento del progresso
- [ ] Meccanica di sblocco upgrade a livelli
- [ ] Più Pokémon da sbloccare
- [ ] Effetti sonori
- [ ] Achievement system
- [ ] Moltiplicatori temporanei
- [ ] Temi grafici personalizzabili

---

**Divertiti a giocare! 💕✨**
