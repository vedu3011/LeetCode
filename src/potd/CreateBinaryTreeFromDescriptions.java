package potd;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import common.BinaryTreeUtil;
import common.TreeNode;

public class CreateBinaryTreeFromDescriptions {

    public static void main(String[] args) {

        CreateBinaryTreeFromDescriptions solution =
                new CreateBinaryTreeFromDescriptions();

        int[][] descriptions = {
                {20, 15, 1},
                {20, 17, 0},
                {15, 10, 1}
        };

        TreeNode root = solution.createBinaryTree(descriptions);

        System.out.println("Root Node: " + root.val);

        System.out.print("PreOrder: ");
        BinaryTreeUtil.preOrder(root);

        System.out.println();

        System.out.print("InOrder: ");
        BinaryTreeUtil.inOrder(root);

        System.out.println();

        System.out.print("PostOrder: ");
        BinaryTreeUtil.postOrder(root);
    }

    public TreeNode createBinaryTree(int[][] descriptions) {

        Map<Integer, TreeNode> nodeMap = new HashMap<>();
        Set<Integer> childNodes = new HashSet<>();

        for (int[] description : descriptions) {

            int parent = description[0];
            int child = description[1];
            boolean isLeft = description[2] == 1;

            TreeNode parentNode =
                    nodeMap.computeIfAbsent(parent, TreeNode::new);

            TreeNode childNode =
                    nodeMap.computeIfAbsent(child, TreeNode::new);

            if (isLeft) {
                parentNode.left = childNode;
            } else {
                parentNode.right = childNode;
            }

            childNodes.add(child);
        }

        for (Integer node : nodeMap.keySet()) {
            if (!childNodes.contains(node)) {
                return nodeMap.get(node);
            }
        }

        return null;
    }
}