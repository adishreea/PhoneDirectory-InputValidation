# PhoneDirectory-InputValidation
Implement whitelisting technique using regular expressions to validate user input to add and delete into a database.

---------------------------------------------------------------------
Instruction manual for executing the program
---------------------------------------------------------------------
(Internet connection needed)

Extract the InputValidation file
Import in Eclipse
'File' > 'Import'
Under 'General' tab, select 'Existing Projects into Workspace'
Select root directory by clicking on 'Browse'
Then click on 'Finish'

(takes time to load the project into the workspace)

Files run on Eclipse:
CommandArg.java	--- contains the main function
ConnectMySQLJava.java --- to establish a JDBC connection
Person.java --- has the mutator(set) and accessor(get) methods 
Regex.java --- has the regular expression patterns for input validation

Optional file for testing if the input data is VALID or not:
MainProgram.java

Running command-line arguments in Eclipse:
go to 'Run' > 'Run Configurations'
go to 'Arguments' tab
List the arguments in the 'Program Arguments' field
