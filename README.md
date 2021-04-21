# Top Three Hero Finder

#### README

This Spring boot application interacts with the DOTA2 API (https://docs.opendota.com/#section/Introduction) and gets the top 3 most played hero characters for a specific Account ID.

To run this Spring boot Application, download this repository as zip, then open Eclipse and import the project as an existing maven project. Wait for all the dependencies to get resolved. Then, run the project as a Java Application.


Once the Application gets initialized, use the Chrome browser or Postman to interact with the API.


### Use the following URLs as test case.

localhost:8080/dota2/top3heroes/211511642
localhost:8080/dota2/top3heroes/0
localhost:8080/dota2/top3heroes/1
localhost:8080/dota2/top3heroes/-1
localhost:8080/dota2/top3heroes/abcd
