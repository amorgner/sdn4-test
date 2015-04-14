# Simple test project to play with Spring Data Neo4j (SDN) 4

1. Setup a Neo4j server and load the products from the Northwind dataset with this Cypher statement:

	LOAD CSV WITH HEADERS FROM "http://data.neo4j.com/northwind/products.csv" AS row
	CREATE (n:Product)
	SET n = row,
	  n.unitPrice = toFloat(row.unitPrice),
	  n.unitsInStock = toInt(row.unitsInStock), n.unitsOnOrder = toInt(row.unitsOnOrder),
	  n.reorderLevel = toInt(row.reorderLevel), n.discontinued = (row.discontinued <> "0")

2. Configure host and port in

    org.structr.spring.sdn.AppContext

	public static final String NEO4J_HOST = "http://localhost:";
	public static final int    NEO4J_PORT = 7474;

If you're running against a 2.2 database, set username and password:

	public SessionFactory getSessionFactory() {
		System.setProperty("username", "neo4j");
		System.setProperty("password", "neo4j");


3. Clone the repo and build with

    mvn clean install


3. Run test app with

	mvn exec:java -Dexec.mainClass=org.structr.spring.sdn.Run

The result is a list of the product names from the Northwind dataset.