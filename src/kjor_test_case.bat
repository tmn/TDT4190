javac ex4/*.java
del %2\output*.*
rmic ex4/ServerImpl
rmic ex4/RegistryProxyImpl
start java ex4/StartRegistry %1
FOR %%c IN (A B C D E F G H I J) DO call kjor_en.bat %1 %2 %%c
cd %2
date /t > final_results.txt
time /t >> final_results.txt
for %%c in (A B C D E F G H I J) do for %%s in (1 2 3 4) do @echo --- >> final_results.txt && @echo output_test_case_%%c_server_%%s.txt >> final_results.txt && @type output_test_case_%%c_server_%%s.txt >> final_results.txt
cd ..
@echo Testen er ferdig kj�rt, samlet output ligger i fila final_results.txt.