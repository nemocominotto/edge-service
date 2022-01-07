# edge-service

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