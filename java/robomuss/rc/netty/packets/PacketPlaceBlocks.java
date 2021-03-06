package robomuss.rc.netty.packets;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import robomuss.rc.block.RCBlocks;
import robomuss.rc.block.te.TileEntityTrack;
import robomuss.rc.netty.AbstractPacket;

public class PacketPlaceBlocks extends AbstractPacket {

    int	x, y, z;

    int id;
    int direction;




    public PacketPlaceBlocks(int posX, int posY, int posZ, int Id, int Direction) {
        this.x = posX;
        this.y = posY;
        this.z = posZ;
        id = Id;
        direction = Direction;
    }

    @Override
    public void encodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
        buffer.writeInt(x);
        buffer.writeInt(y);
        buffer.writeInt(z);
        buffer.writeInt(id);
        buffer.writeInt(direction);
    }

    @Override
    public void decodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
        this.x = buffer.readInt();
        this.y = buffer.readInt();
        this.z = buffer.readInt();
        this.id = buffer.readInt();
        this.direction = buffer.readInt();
    }

    @Override
    public void handleClientSide(EntityPlayer player) {
         placeBlock(player);
    }

    @Override
    public void handleServerSide(EntityPlayer player) {
        placeBlock(player);
    }


    public void placeBlock(EntityPlayer player)
    {
        System.out.println("hi");
        World world = player.worldObj;

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


    }


}
