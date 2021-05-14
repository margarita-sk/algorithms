package bfc;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@RequiredArgsConstructor
public class Node<T> {

    @NonNull
    private T node;

    @ToString.Exclude
    private List<Node> connectedNodes = new ArrayList<>();
}
