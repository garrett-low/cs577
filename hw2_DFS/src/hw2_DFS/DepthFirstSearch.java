package hw2_DFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

public class DepthFirstSearch {

  private static class DfsNode<T> {
    private T value;
    private DfsNode<T> next;

    public DfsNode(T value) {
      this.value = value;
      this.next = null;
    }

    public T getValue() {
      return value;
    }

    public DfsNode<T> getNext() {
      return next;
    }

    public void setNext(DfsNode<T> next) {
      this.next = next;
    }  
    
  }

  private static class DfsLinkedList<T> {
    private DfsNode<T> head;

    public DfsLinkedList() {
      head = null;
    }

    public DfsNode<T> getHead() {
      return head;
    }

    public void add(T newObject) {
      DfsNode<T> newNode = new DfsNode<T>(newObject);
      
      if (head == null) { // empty list
        head = newNode;
      } else {
        DfsNode<T> current = head;
        while (current.getNext() != null) { // stop at last element
          current = current.getNext();
        }
        current.setNext(newNode);
      }
    }   
  }

  public static void main(String[] args) {

    Scanner scnr = new Scanner(System.in);
    int numGraphs = scnr.nextInt();
    scnr.nextLine(); // move past line break
    // System.out.print("numGraphs: " + numGraphs);

    for (int i = 0; i < numGraphs; i++) {
      int numNodes = scnr.nextInt();
      scnr.nextLine(); // move past line break
      // System.out.println("numNodes: " + numNodes);
      
      ArrayList<DfsLinkedList<String>> adjacencyList = new ArrayList<>();
      for (int j = 0; j < numNodes; j++) {
        String neighborString = scnr.nextLine();
        // String[] neighborArray = new String[numNodes];
        // neighborArray = neighborList.split(" ");
        ArrayList<String> neighborList = new ArrayList<>();
        Collections.addAll(neighborList, neighborString.split(" "));
        DfsLinkedList<String> neighborDfsLinkedList = new DfsLinkedList<>();
        
        for (int k = 0; k < neighborList.size(); k++) {
          neighborDfsLinkedList.add(neighborList.get(k));          
        }
        
        adjacencyList.add(neighborDfsLinkedList);
        
        
//        adjacencyList.add(neighborList);

        // System.out.println(neighborArray);


        // System.out.println(adjacencyList);
        // adjacencyList.add(adjacencyListString.split(" "));
        // System.out.println("adjacencyList: " + adjacencyList);

      }

      dfsRecursive(adjacencyList);


    }


    scnr.close();
  }

  private static String dfsRecursive(ArrayList<DfsLinkedList<String>> adjacencyList) {
    Set<String> visitedSet = new HashSet<>();
    
    for (int i = 0; i < adjacencyList.size(); i++) {
      if (visitedSet.contains(adjacencyList.get(i).getHead().getValue())) {
        continue;
      }
      DfsNode<String> root = adjacencyList.get(i).getHead();
      dfsRecursiveInternal(root, visitedSet);  
    }
    
    return null;
  }

  private static void dfsRecursiveInternal(DfsNode<String> current, Set<String> visitedSet) {
    if (current != null) {
      System.out.print(current.getValue() + " ");
      visitedSet.add(current.getValue());
      while(current.getNext() != null && !visitedSet.contains(current.getNext().getValue())) {
        current = current.getNext();
        dfsRecursiveInternal(current, visitedSet);           
      }
    }
    
  }

}
