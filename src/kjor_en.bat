for %%s in (1 2 3 4) do java ex4.VentLitt && start kjor_to.bat %1 %2 %3 %%s
@echo Kj�r test case %3, lukk alle servere og trykk en tast n�r du vil g� videre til neste case.
@pause
