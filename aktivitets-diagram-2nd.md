\## Aktivitetsdiagram



Herunder ses flowet for oprettelse og gennemførelse af et projekt med delprojekter og opgaver:



```mermaid

flowchart TD

&#x20;   Start(\[Start]) --> OpretProjekt\[Projektleder opretter projekt]

&#x20;   OpretProjekt --> HarDelprojekter{Skal projektet have delprojekter?}



&#x20;   HarDelprojekter -->|Ja| OpretDelprojekt\[Opret delprojekt]

&#x20;   OpretDelprojekt --> OpretOpgaveUnder\[Opret opgave under delprojekt]

&#x20;   HarDelprojekter -->|Nej| OpretOpgaveDirekte\[Opret opgave direkte på projektet]



&#x20;   OpretOpgaveUnder --> FlereOpgaverUnder{Flere opgaver eller delprojekter?}

&#x20;   FlereOpgaverUnder -->|Flere opgaver| OpretOpgaveUnder

&#x20;   FlereOpgaverUnder -->|Nyt delprojekt| OpretDelprojekt

&#x20;   FlereOpgaverUnder -->|Nej| UdfoerOpgaver\[Udfør og opdater opgaver]



&#x20;   OpretOpgaveDirekte --> FlereOpgaverDirekte{Flere opgaver på projektet?}

&#x20;   FlereOpgaverDirekte -->|Ja| OpretOpgaveDirekte

&#x20;   FlereOpgaverDirekte -->|Nej| UdfoerOpgaver



&#x20;   UdfoerOpgaver --> AlleFaerdige{Er alle opgaver færdige?}

&#x20;   AlleFaerdige -->|Nej| UdfoerOpgaver

&#x20;   AlleFaerdige -->|Ja| AfslutProjekt\[Afslut projekt]

&#x20;   AfslutProjekt --> Slut(\[Slut])

```

