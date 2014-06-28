package robomuss.rc.netty;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.world.World;
import robomuss.rc.block.RCBlocks;
import robomuss.rc.block.te.TileEntityTrack;

public class messageTrackBuilder implements IMessage, IMessageHandler<messageTrackBuilder, IMessage>
{
    public int x, y, z, id, direction;
    public byte world;

    public messageTrackBuilder() {}

    public messageTrackBuilder(int x, int y, int z, int id, int direction)
    {
        this.x = x;
        this.y = y;
        this.z = z;
        this.id = id;
        this.direction = direction;
    }

    @Override
    public void fromBytes(ByteBuf buf)
    {
        this.x = buf.readInt();
        this.y = buf.readInt();
        this.z = buf.readInt();
        this.id = buf.readInt();
        this.direction = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
        buf.writeInt(x);
        buf.writeInt(y);
        buf.writeInt(z);
        buf.writeInt(id);
        buf.writeInt(direction);
    }

    @Override
    public IMessage onMessage(messageTrackBuilder message, MessageContext ctx)
    {
        World world = ctx.getServerHandler().playerEntity.worldObj;

        if(id == 0) {
            world.setBlock(x, y, z, RCBlocks.flat_track);
            TileEntityTrack track = (TileEntityTrack) world.getTileEntity(x, y, z);
            track.direction = direction;
            world.markBlockForUpdate(x, y, z);
            if(direction == 0) {
                z += 1;
            }
            else if(direction == 1) {
                x += 1;
            }
            else if(direction == 2) {
                z -= 1;
            }
            else if(direction == 3) {
                x -= 1;
            }
        }

        if(id == 1 || id == 2 || id == 3) {
            world.setBlock(x, y, z, (id == 1 ? RCBlocks.transition_track : id == 2 ? RCBlocks.sloped_track : RCBlocks.transition_track_2));
            TileEntityTrack track = (TileEntityTrack) world.getTileEntity(x, y, z);
            track.direction = direction;
            world.markBlockForUpdate(x, y, z);
            if(direction == 0) {
                z += 1;
                y += 1;
            }
            else if(direction == 1) {
                x -= 1;
                y += id > 3 ? -1 : 1;
            }
            else if(direction == 2) {
                z -= 1;
                y += id > 3 ? -1 : 1;
            }
            else if(direction == 3) {
                x -= 1;
                y += id > 3 ? -1 : 1;
            }
        }

        if(id == 4 || id == 5 || id == 6) {
            if(id == 6) {
                y -= 1;
            }
            world.setBlock(x, y, z, (id == 4 ? RCBlocks.transition_track : id == 5 ? RCBlocks.sloped_track : RCBlocks.transition_track_2));
            TileEntityTrack track = (TileEntityTrack) world.getTileEntity(x, y, z);
            track.direction = direction;
            world.markBlockForUpdate(x, y, z);
            if(direction == 0) {
                z += 1;
                y += 1;
            }
            else if(direction == 1) {
                x -= 1;
                y += id > 3 ? -1 : 1;
            }
            else if(direction == 2) {
                z += 1;
                y += id > 3 ? -1 : 1;
            }
            else if(direction == 3) {
                x -= 1;
                y += id > 3 ? -1 : 1;
            }
            if(id == 4) {
                y += 1;
            }
        }

        if(id == 7) {
            world.setBlock(x, y, z, RCBlocks.curved_track);
            TileEntityTrack track = (TileEntityTrack) world.getTileEntity(x, y, z);
            track.direction = direction;
            world.markBlockForUpdate(x, y, z);
            if(direction == 0) {
                x -= 1;
                direction = 3;
            }
            else if(direction == 1) {
                direction = 2;
                z -= 1;
            }
            else if(direction == 2) {
                x += 1;
                direction = 1;
            }
            else if(direction == 3) {
                z += 1;
                direction = 0;
            }
        }

        if(id == 8) {
            world.setBlock(x, y, z, RCBlocks.loop);
            TileEntityTrack track = (TileEntityTrack) world.getTileEntity(x, y, z);
            track.direction = direction;
            world.markBlockForUpdate(x, y, z);

            x -= 1;
            z += 1;
        }

        if(id == 9) {
            if(direction == 3) {
                direction = 0;
            }
            else {
                direction += 1;
            }
        }

        return null;
    }

    @Override
    public String toString()
    {
        return String.format("MessageTrackBuilder - x:%s, y:%s, z:%s, id:%s", x, y, z, id);
    }
}
