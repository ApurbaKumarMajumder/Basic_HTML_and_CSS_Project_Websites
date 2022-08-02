import java.io.*;
import java.util.*;

public class intro {

    static class Node {

        int data;
        Node left;
        Node right;

        Node (int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static class BinaryTree {
        static int idx = -1;
        public static Node buildTree(int nodes[]) {
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }
    }

    public static void preOrder(Node root) {

        // root left and right
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(Node root) {

        // left, root and right
        if (root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static void postOrder(Node root) {

        // left, right and root
        if (root == null) {
            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    public static void levelOrder(Node root) {

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            Node currNode = q.remove();
            if (currNode == null) {
                System.out.println();
                if (!q.isEmpty()) {
                    q.add(null);
                } else {
                    break;
                }
            } else {
                System.out.print(currNode.data + " ");
                if (currNode.left != null) {
                    q.add(currNode.left);
                }
                if (currNode.right != null) {
                    q.add(currNode.right);
                }
            }
        }
    }

    public static int countOfNodes(Node root) {

        if (root == null) {
            return 0;
        }

        int leftNodes = countOfNodes(root.left);
        int rightNodes = countOfNodes(root.right);

        return leftNodes + rightNodes + 1;
    }

    public static int sumOfNodes(Node root) {

        if (root == null) {
            return 0;
        }

        int leftSum = sumOfNodes(root.left);
        int rightSum = sumOfNodes(root.right);

        return leftSum + rightSum + root.data;
    }

    public static int height(Node root) {

        if (root == null) {
            return 0;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        int myHeight = Math.max(leftHeight, rightHeight) + 1;
        
        return myHeight;
    }

    public static int diameter(Node root) {

        if (root == null) {
            return 0;
        }

        int diameter1 = diameter(root.left);
        int diameter2 = diameter(root.right);
        int diameter3 = height(root.left) + height(root.right) + 1;

        return Math.max(diameter3, Math.max(diameter1, diameter2));
    }

    static class TreeInfo {

        int height;
        int diameter;

        TreeInfo(int height, int diameter) {
            this.height = height;
            this.diameter = diameter;
        }
    }

    public static TreeInfo diameter2(Node root) {

        if (root == null) {
            return new TreeInfo(0, 0);
        }

        TreeInfo left = diameter2(root.left);
        TreeInfo right = diameter2(root.right);

        int myHeight = Math.max(left.height, right.height) + 1;

        int diam1 = left.diameter;
        int diam2 = right.diameter;
        int diam3 = left.height + right.height + 1;

        int myDiameter = Math.max(Math.max(diam1, diam2), diam3);

        TreeInfo myInfo = new TreeInfo(myHeight, myDiameter);
        return myInfo;
    }


    public static void main(String[] args) {
        
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        Node root = intro.BinaryTree.buildTree(nodes);
        // System.out.println(root.data);

        levelOrder(root);

        System.out.println("count of nodes in the tree: " + countOfNodes(root));
        
        System.out.println("sum of nodes in the tree: " + sumOfNodes(root));

        System.out.println("Height of nodes in the tree: " + height(root));

        System.out.println("Diameter of the tree: " + diameter(root));

        System.out.println("Diameter of the tree: " + diameter2(root).diameter);
    }
}
