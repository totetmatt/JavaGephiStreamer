# GephiStreamer
```java
NodeEntity node01 = new NodeEntity("test-node-01");
NodeEntity node02 = new NodeEntity("test-node-02");
EdgeEntity edge = new EdgeEntity(node01, node02);
   
StreamAction action01 = node01.createAction(Action.ADD_NODE);
StreamAction action02 = node02.createAction(Action.ADD_NODE);
StreamAction action03 = edge.createAction(Action.ADD_EDGE);
  
SimpleGephiStreamer streamer = new SimpleGephiStreamer();
streamer.sendAction(action01);
streamer.sendAction(action02);
streamer.sendAction(action03);
```