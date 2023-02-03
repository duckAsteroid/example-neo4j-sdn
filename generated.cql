CREATE (`(Person-ID-4746`:Person {id: 4746 , name:'David Smith', height: 0.42474602572620457 , sex:'FEMALE'})
CREATE (`(Person-ID-4747`:Person {id: 4747 , name:'Chris Senior', height: 0.6960883352999847 , sex:'MALE'})
CREATE (`(Class-ID-0`:Class {name:'React for beginners', code:'REA101', level: 0.1820765841802935 , open: false , full:'TRUE'})
CREATE (`(Class-ID-1`:Class {name:'Neo4J for dummies', code:'NEODUM', level: 0.9816779405675836 , open: true , full:'TRUE'})
CREATE 
	(`(Person-ID-4746`)-[:ATTENDS{likes: 0.5544844533687188 }]->(`(Class-ID-0`),
	(`(Person-ID-4746`)-[:ATTENDS{likes: 0.31318997034823204 }]->(`(Class-ID-1`),
	(`(Person-ID-4747`)-[:ATTENDS{likes: 0.5686500515361852 }]->(`(Class-ID-0`)
