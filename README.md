# Kuppi-EJB
Resources for session on Enterprise Java Beans

# 3-tire architecture
    client -> business logic -> data

# Enterprise Java Bean introduction
1. What is Enterprise Java Bean?
2. When to use?
	- scalable/distributable
	- transaction support
	- portable
	- security
	- verity of clients
	- pooling
3. Session bean and Message driven bean
4. Stateful session bean
    - lifecycle (create -> di -> post construct)
    - example
    - only one conversational session (cannot be a web service)
5. Stateless session bean
    - lifecycle
    - example
6. Singleton session bean
    - lifecycle
    - example
    - timers (persistence)
7. Message driven bean
    - lifecycle
    - example
8. @EJB injection
    - example
9. JNDI
    - example using client
    - java:global/<app-name>/<module-name>/<EJB-name>!<interface>
    - java:app/<module-name>/<EJB-name>!<interface>
    - java:module/<EJB-name>!<interface>

10. Local or Remote?


Discussion Q & A
