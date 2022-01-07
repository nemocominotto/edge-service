# edge-service

## Endpoints

### GET
- /route/{routeCode}
- /review/route/{routeCode}/auteur/{auteur}
- /gemeente/route/{postcode}
- /route/gemeente/{postcode}/reviews/{routeCode}

### POST
/add/route
- name
- img_url
- routeCode
- postcode

/add/review
- auteur
- titel
- content
- routeCode

### PUT
/update/route
- name
- img_url
- postcode

### DELETE
/delete/route/{routeCode}