package it.unibo.generics.graph;

import it.unibo.generics.graph.api.Graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 *
 */
public final class UseGraph<N> implements Graph<N>{

    private UseGraph() {        
    }

    final Set<N> nodeGraph = new HashSet<>();
    final Map<N, Set<N>> edgesGraph = new HashMap<>();

    /* Adds a node: nothing happens if node is null or already there. */
    public void addNode(N node) {
        nodeGraph.add(node);
    }

    /* Adds an edge: nothing happens if source or target are null. */
    public void addEdge(N source, N target) {
        Set<N> s = edgesGraph.get(source);
        if(s == null) {
            s = new HashSet<>();
        }
        s.add(target);
        edgesGraph.put(source, s);
    }
    
    /* Returns all the nodes */
    public Set<N> nodeSet() {
        return nodeGraph;
    }

    /* Returns all the nodes directly targeted from a node. */
    public Set<N> linkedNodes(N node) {
        return edgesGraph.get(node);
    }

    /*Gets one sequence of nodes connecting source to target. */
    public List<N> getPath(N source, N target) {
        if(isConnected(source, target)){
            return new LinkedList<>();
        }else{
            return null;
        }
    }

    private boolean isConnected(N source, N node){
        return edgesGraph.get(source).contains(node);
    }

    /**
     * @param args
     *            ignored
     */
    public static void main(final String... args) {
        /*
         * Test your graph implementation(s) by calling testGraph
         */
        testGraph(new UseGraph<String>());
    }

    private static void testGraph(final Graph<String> graph) {
        graph.addNode("a");
        graph.addNode("b");
        graph.addNode("c");
        graph.addNode("d");
        graph.addNode("e");
        graph.addEdge("a", "b");
        graph.addEdge("b", "c");
        graph.addEdge("c", "d");
        graph.addEdge("d", "e");
        graph.addEdge("c", "a");
        graph.addEdge("e", "a");
        /*
         * Should be ["a","b","c","d","e"], in any order
         */
        assertIsAnyOf(graph.nodeSet(), Set.of(splitOnWhiteSpace("a b c d e")));
        /*
         * ["d","a"], in any order
         */
        assertIsAnyOf(graph.linkedNodes("c"), Set.of(splitOnWhiteSpace("a d")));
        /*
         * Either the path b,c,a or b,c,d,e,a
         */
        assertIsAnyOf(
            graph.getPath("b", "a"),
            Arrays.asList(splitOnWhiteSpace("b c a")),
            Arrays.asList(splitOnWhiteSpace("b c d e a"))
        );
    }

    private static void assertIsAnyOf(final Object actual, final Object... valid) {
        for (final var target: Objects.requireNonNull(valid)) {
            if (Objects.equals(target, actual)) {
                System.out.println("OK: " + actual + " matches " + target); // NOPMD
                return;
            }
        }
        throw new AssertionError("None of " + Arrays.asList(valid) + " matches " + actual);
    }

    private static String[] splitOnWhiteSpace(final String target) {
        return target.split("\\s+");
    }
}
