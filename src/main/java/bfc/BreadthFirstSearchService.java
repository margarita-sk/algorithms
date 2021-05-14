package bfc;

import lombok.extern.java.Log;

import java.util.*;
import java.util.stream.Collectors;

@Log
public class BreadthFirstSearchService {

    public ArrayList<Node> search(Node startNode, Node endNode, List<Node> graf) {
        var queue = new ArrayDeque<Node>();
        var checkedArray = new ArrayList<Node>();
        var resultPath = new ArrayList<Node>();

        if (!graf.contains(startNode) || !graf.contains(endNode)) {
            log.warning("There are no searched nodes");
            return new ArrayList<>();
        }

        do {
            startNode.getConnectedNodes().forEach(node -> {
                if (!checkedArray.contains(node)) {
                    queue.offer((Node) node);
                }
            });
            resultPath.add(startNode);
            startNode = queue.poll();
            checkedArray.add(startNode);
        } while (!queue.isEmpty() && !startNode.equals(endNode));
        resultPath.add(startNode);

        return clearPath(resultPath);
    }

    private ArrayList<Node> clearPath(ArrayList<Node> path) {
        var clearedPath = new ArrayList<Node>();
        var endIndex = path.size() - 1;
        var endNode = path.get(endIndex);
        clearedPath.add(endNode);

        while (endIndex - 1 >= 0) {

            var previousNode = path.get(endIndex - 1);
            if (previousNode.getConnectedNodes().contains(endNode)) {
                clearedPath.add(previousNode);
                endIndex--;
                endNode = path.get(endIndex);
            } else {
                endIndex--;
            }
        }
        Collections.reverse(clearedPath);
        return clearedPath;
    }
}
