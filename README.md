# edge-service

Onze applicatie gaat over fietsroutes. Een fietsroute behoort tot een gemeente en in een gemeente kunnen meerdere routes zijn. Ook kunnen fietsers een geschreven review met naam achterlaten bij een route. Een route kan dan ook meerdere reviews hebben. Er zijn get endpoints om makkelijk een review te zien + gemeente op basis van postcode en reviews op basis van routecode. Dit wordt via de workflow allemaal getest, naar Sonarcloud gestuurd op te checken en tot slot naar Docker hub geüpload. Tot slot worden de containers gedeployed naar Oktetocloud

![image](https://user-images.githubusercontent.com/57801327/148607794-d1505b1c-9aab-4b88-b994-f7d215186e10.png)
- https://github.com/nemocominotto/review-service
- https://github.com/JulianKoppens/cycling-route-service
- https://github.com/JetzeJanssens/gemeente-service

## OktetoCloud
![image](https://user-images.githubusercontent.com/57801327/148607308-ea02418e-fd07-4f33-815a-d534a376bd46.png)
![image](https://user-images.githubusercontent.com/57801327/148607444-2cb4feaa-fdd4-4178-85c7-cb221382955a.png)

## SonarCloud
![image](https://user-images.githubusercontent.com/57801327/148608932-f0f868ea-76c9-4443-8aea-81c58f1d74b5.png)
![image](https://user-images.githubusercontent.com/57801327/148608942-d3450617-cf85-4661-8b90-db2e0d7de3ae.png)
![image](https://user-images.githubusercontent.com/57801327/148608946-cfbeb285-16ba-4058-9d08-58485103c59e.png)
![image](https://user-images.githubusercontent.com/57801327/148608984-a3cd1770-1473-4579-a737-44736410da9d.png)


## Docker
![image](https://user-images.githubusercontent.com/57801327/148608009-43ec9f81-1e5b-461a-987f-fd4789d65eb5.png)


## Endpoints

### GET
- /route/{routeCode}
![img.png](img.png)
- /review/route/{routeCode}/auteur/{auteur}
![img_1.png](img_1.png)
- /gemeente/route/{postcode}
![img_2.png](img_2.png)
- /route/gemeente/{postcode}/reviews/{routeCode}
![img_3.png](img_3.png)

### POST
/add/route
- name
- img_url
- routeCode
- postcode
![img_4.png](img_4.png)

/add/review
- auteur
- titel
- content
- routeCode
![img_5.png](img_5.png)

/add/gemeente
- name
- postcode
![img_6.png](img_6.png)

### PUT
/update/route
- name
- img_url
- postcode
- routeCode
![img_8.png](img_8.png)

/update/gemeente
- name
![img_7.png](img_7.png)

### DELETE
/delete/route/{routeCode}
![img_9.png](img_9.png)

/delete/gemeente/{postcode}
![img_10.png](img_10.png)
