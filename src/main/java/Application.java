import bfc.BreadthFirstSearchService;
import bfc.Node;
import lombok.extern.java.Log;

import java.util.*;

@Log
public class Application {

    public static void main(String[] args) {

        var kim = new Node("Kim");
        var claire = new Node("Claire");
        var alice = new Node("Alice");
        var bob = new Node("Bob");
        var tom = new Node("Tom");
        var jhonny = new Node("Jhonny");
        var peggy = new Node("Peggy");

        kim.setConnectedNodes(List.of(claire, alice, bob));
        claire.setConnectedNodes(List.of(tom, jhonny));
        bob.setConnectedNodes(List.of(peggy));
        peggy.setConnectedNodes(List.of(alice));

        var graf = List.of(kim, jhonny, peggy);

        var bfs = new BreadthFirstSearchService();
        var path = bfs.search(kim, tom, graf);
        log.info(path.toString());
    }


}
