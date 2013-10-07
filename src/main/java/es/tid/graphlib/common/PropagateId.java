package es.tid.graphlib.common;

import java.io.IOException;

import org.apache.giraph.graph.AbstractComputation;
import org.apache.giraph.graph.Vertex;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.WritableComparable;

/**
 * This computation is used simply to propagate the ID of a vertex to all its
 * neighbors. This is typically used as an initial step to convert an undirected
 * graph to a directed one by letting a vertex know what other vertices point to
 * it. 
 * @author dl
 *
 * @param <I>
 * @param <V>
 * @param <E>
 * @param <M1>
 */
public class PropagateId<I extends WritableComparable, 
  V extends Writable, E extends Writable, M1 extends Writable> 
  extends AbstractComputation<I,V,E,M1,I> {

  @Override
  public void compute(Vertex<I,V,E> vertex, 
      Iterable<M1> messages) throws IOException {
    sendMessageToAllEdges(vertex, vertex.getId());
  }
}