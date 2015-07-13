package subside.plugins.koth.events;

import java.util.List;

import lombok.Getter;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import subside.plugins.koth.adapter.KothDummy;
import subside.plugins.koth.area.Area;

public class KothCapEvent extends Event implements IEvent, Cancellable {
    private String nextCapper;
    private @Getter List<Player> playersInArea;
    private boolean isCancelled;
    private @Getter KothDummy koth;
    
    public KothCapEvent(Area koth, List<Player> playersInArea, String nextCapper){
        this.koth = new KothDummy(koth);
        this.playersInArea = playersInArea;
        this.nextCapper = nextCapper;
    }
    
    public String getNextPlayerCapping(){
        return nextCapper;
    }
    
    public void setNextPlayerCapping(String nextCapper){
        this.nextCapper = nextCapper;
    }

    @Override
    public boolean isCancelled() {
        return isCancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        isCancelled = cancel;
    }
    

    private static final HandlerList handlers = new HandlerList();

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
    
    public static HandlerList getHandlerList() {
        return handlers;
    }
}
