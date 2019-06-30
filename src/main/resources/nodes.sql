MATCH (n) DETACH DELETE n;

CREATE 
 (BallPen:Product {name: 'ball-pen', productId: 'a8e47a8c-2904-4a12-a886-f6d397a9d9a4'}),
 (ToBPencil:Product {name: '2b-pencil', productId: 'a79c134f-a035-4bc8-92fe-cca7b4ab4a5a'}),
 (HBPencil:Product {name: 'hb-pencil', productId: '6b616af9-1eca-4ae8-ba0e-61e48269702e'}),
 (DomsCrans:Product {name: 'doms-crans', productId: '63cd536a-6e0f-4350-bbb5-63f718558c98'}),
 (Crayons:Product {name: 'Crayons', productId: '38df8e32-8141-4e44-851c-72b947466f19'}),
 (Classmate:Product {name: 'Classmate', productId: '2695aa9a-677b-4ee5-82d7-5001d8351600'}),
 
 (Sundar:User {name: 'Sundar', age: 25}),
 (Alex:User {name: 'Alex', age: 23}),
 (Bob:User {name: 'Bob', age: 12}),
 (Anal:User {name: 'Anal', age: 46}),
 (Sanjib:User {name: 'Sanjib', age: 47}),
 (Partha:User {name: 'Partha', age: 25}),

 (BallPen)-[:REVIEWED {rating: 4, review: 'This is a good product'}]->(Sundar),
 (ToBPencil)-[:REVIEWED {rating: 9, review: 'This is an excellent pencil'}]->(Sundar),
 (HBPencil)-[:REVIEWED {rating: 10, review: 'This was awasome tool'}]->(Sundar),
 (DomsCrans)-[:REVIEWED {rating: 3, review: 'Not Satisfied'}]->(Sundar),
 (DomsCrans)-[:REVIEWED {rating: 4, review: 'Average product'}]->(Alex),
 (DomsCrans)-[:REVIEWED {rating: 1, review: 'Very bad'}]->(Anal),
 (Crayons)-[:REVIEWED {rating: 1, review: 'Good one'}]->(Anal),
 (Classmate)-[:REVIEWED {rating: 10, review: 'Very Good'}]->(Sanjib),
 (HBPencil)-[:REVIEWED {rating: 8, review: 'Good tool'}]->(Bob),
 (ToBPencil)-[:REVIEWED {rating: 5, review: 'Avegage tool'}]->(Partha),
 (ToBPencil)-[:REVIEWED {rating: 7, review: 'Good One'}]->(Alex),
 (ToBPencil)-[:REVIEWED {rating: 9, review: 'Best for ever'}]->(Sanjib),
 (Crayons)-[:REVIEWED {rating: 5, review: 'Average'}]->(Sanjib),
 (Classmate)-[:REVIEWED {rating: 5, review: 'Average Product'}]->(Anal)
;