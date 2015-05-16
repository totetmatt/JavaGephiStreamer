package org.webcom.gephistream;

import java.util.Date;

import junit.framework.TestCase;

import org.junit.Test;
import org.webcom.gephistream.action.StreamAction;
import org.webcom.gephistream.action.StreamAction.Action;
import org.webcom.gephistream.entity.NodeEntity;

public class GephiStreamerTest extends TestCase {

    @Test
    public void test01() throws Exception {
           NodeEntity node = new NodeEntity("test-node"+ new Date());
           StreamAction action = node.createAction(Action.ADD_NODE);
           
           SimpleGephiStreamer streamer = new SimpleGephiStreamer();
           streamer.sendAction(action);
           
           assertTrue(true);
    }
}
