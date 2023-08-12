package com.dsa.assignment1;

import java.util.ArrayList;
import java.util.List;

class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

public class FindPairInBST {
    Node root;

    public void insert(int key) {
        root = insertRec(root, key);
    }

    private Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        return root;
    }

    public List<Integer> inOrderTraversal(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root != null) {
            result.addAll(inOrderTraversal(root.left));
            result.add(root.key);
            result.addAll(inOrderTraversal(root.right));
        }
        return result;
    }

    public boolean findPairWithSum(Node root, int targetSum) {
        List<Integer> sortedList = inOrderTraversal(root);
        int left = 0;
        int right = sortedList.size() - 1;

        while (left < right) {
            int sum = sortedList.get(left) + sortedList.get(right);

            if (sum == targetSum) {
                System.out.println("Pair with sum " + targetSum + " found: (" + sortedList.get(left) + ", " + sortedList.get(right) + ")");
                return true;
            } else if (sum < targetSum) {
                left++;
            } else {
                right--;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        FindPairInBST tree = new FindPairInBST();
        tree.insert(4);
        tree.insert(2);
        tree.insert(6);
        tree.insert(1);
        tree.insert(3);
        tree.insert(5);
        tree.insert(7);

        int targetSum = 130;
        if (!tree.findPairWithSum(tree.root, targetSum)) {
            System.out.println("No pair with sum " + targetSum + " found in the BST.");
        }
    }
}
