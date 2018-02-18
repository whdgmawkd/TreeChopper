package treechopper.common.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.util.IThreadListener;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import treechopper.common.config.ConfigurationHandler;

public class ClientSettingsMessage implements IMessage {

    private boolean m_ReverseShift;
    private boolean m_DisableShift;
    private boolean m_DamageAxe;

    public ClientSettingsMessage() {
    }

    public ClientSettingsMessage(boolean reverseShift, boolean disableShift, boolean damageAxe) {
        m_ReverseShift = reverseShift;
        m_DisableShift = disableShift;
        m_DamageAxe = damageAxe;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        m_ReverseShift = buf.readBoolean();
        m_DisableShift = buf.readBoolean();
        m_DamageAxe = buf.readBoolean();
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeBoolean(m_ReverseShift);
        buf.writeBoolean(m_DisableShift);
        buf.writeBoolean(m_DamageAxe);
    }

    public static class MsgHandler implements IMessageHandler<ClientSettingsMessage, IMessage> {

        @Override
        public IMessage onMessage(ClientSettingsMessage message, MessageContext ctx) {
            IThreadListener mainThread = ctx.getServerHandler().player.getServerWorld();
            mainThread.addScheduledTask(new Runnable() {
                @Override
                public void run() {
                    ConfigurationHandler.reverseShift = message.m_ReverseShift;
                    ConfigurationHandler.disableShift = message.m_DisableShift;
                    ConfigurationHandler.damageAxe = message.m_DamageAxe;
                }
            });
            return null;
        }
    }
}
