package algorithm;

import java.util.HashMap;

class LRUCache {
    class Node {
        int value;
        public Node(int v) {
            value = v;
        }
        Node next = null;
        Node prev = null;
    }
    
    int available = 0;
    HashMap<Integer, Node> map = new HashMap<Integer, Node>();
    Node head, tail;
    
    
    public LRUCache(int capacity) {
        available = capacity;
        Node head = new Node(0);
        Node tail = new Node(0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        Node value = map.get(key);
        if (value == null)
            return -1;
        moveToHead(value);    
        return value.value;
    }
    private void deleteNode(Node node){
            //delete the node 
            Node prev = node.prev;
            Node next = node.next;
            prev.next = next;
            next.prev = prev;
    }
    private void insertNodeToHead(Node node){
            Node next = head.next;
            head.next = node;
            node.prev = head;
            node.next = next;
            next.prev = node;
   }

    private void moveToHead(Node node){
        if (node.prev != head) {
            //delete the node 
            deleteNode(node);
            //and insert it to the head
            insertNodeToHead(node);
        }
    }
    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            //the node has been here, update the value, and move to head
        	node.value = value;
            moveToHead(node);
            return;
        }
        //delete the tail
        if (available == 0) {
            Node prev = tail.prev;
            if (prev != head) {
                deleteNode(prev);
            }
            available ++;            
        }
        //put the new node to the head
        node = new Node(value);
        map.put(key, node);
        insertNodeToHead(node);
        available --;
    }
}