public class Node {
	private Object o;
	private Node next;
	
	/**
	 * Create a new Node with str value and nxt point to the next value
	 * @param str - string which is save in the node, nxt - the next node
	 */
	public Node(Object obj, Node nxt) {
		o=obj;
		next=nxt;
	}
	
	/**
	 * Retourne la valeur de la chaine de caractères
	 * que contient le Node.
	 * @return la valeur du String contenu dans le Node
	 */
	public Object getValue() {
		return o;
	}
	
	/**
	 * Retourne le prochain Node dans la liste.
	 * @return le Node suivant le Node courant
	 */
	public Node getNext() {
		return next;
	}
	
	

}
