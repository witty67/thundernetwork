package network.thunder.core.communication.objects.messages.impl.message.gossip;

import com.google.common.base.Preconditions;
import network.thunder.core.communication.objects.messages.impl.message.gossip.objects.ChannelStatusObject;
import network.thunder.core.communication.objects.messages.impl.message.gossip.objects.P2PDataObject;
import network.thunder.core.communication.objects.messages.impl.message.gossip.objects.PubkeyChannelObject;
import network.thunder.core.communication.objects.messages.impl.message.gossip.objects.PubkeyIPObject;
import network.thunder.core.communication.objects.messages.interfaces.message.gossip.Gossip;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by matsjerratsch on 30/11/2015.
 */
public class GossipSendMessage implements Gossip {
    public List<PubkeyIPObject> pubkeyIPList;
    public List<PubkeyChannelObject> pubkeyChannelList;
    public List<ChannelStatusObject> channelStatusList;

    public GossipSendMessage (List<P2PDataObject> dataObjects) {
        pubkeyIPList = new ArrayList<>();
        pubkeyChannelList = new ArrayList<>();
        channelStatusList = new ArrayList<>();

        for (P2PDataObject obj : dataObjects) {
            if (obj instanceof PubkeyIPObject) {
                pubkeyIPList.add((PubkeyIPObject) obj);

            } else if (obj instanceof PubkeyChannelObject) {
                pubkeyChannelList.add((PubkeyChannelObject) obj);

            } else if (obj instanceof ChannelStatusObject) {
                channelStatusList.add((ChannelStatusObject) obj);

            }
        }
    }

    public List<P2PDataObject> getDataList () {
        List<P2PDataObject> dataList = new ArrayList<>();
        dataList.addAll(pubkeyChannelList);
        dataList.addAll(pubkeyIPList);
        dataList.addAll(channelStatusList);
        return dataList;
    }

    @Override
    public void verify () {
        Preconditions.checkNotNull(pubkeyIPList);
        Preconditions.checkNotNull(pubkeyChannelList);
        Preconditions.checkNotNull(channelStatusList);
    }

    @Override
    public String toString () {
        return "GossipSendMessage{" +
                "pubkeyIPList=" + pubkeyIPList +
                ", pubkeyChannelList=" + pubkeyChannelList +
                ", channelStatusList=" + channelStatusList +
                '}';
    }
}
