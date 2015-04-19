package model.gameMap;


import model.entity.Entity;

public class Tile extends MapObject{
	private AreaEffect areaEffect;
    private Terrain terrain;
    private Item item;
    private Entity entity;

    public Tile(Location location,Terrain terrian){
        super(location);
        this.terrain=terrian;
    }
	public Tile(Location location, AreaEffect aoe, Terrain terrain, Item item, Entity entity){
        super(location);
        this.areaEffect = aoe;
        this.terrain = terrain;
        this.item = item;
        this.entity = entity;
	}

    public AreaEffect getAreaEffect(){
        return this.areaEffect;
    }
    public Terrain getTerrain(){
        return this.terrain;
    }
    public Item getItem(){
        return this.item;
    }
    public Entity getEntity(){
        return this.entity;
    }
    public void setAreaEffect(AreaEffect aoe){
        this.areaEffect = aoe;
    }
    public void setTerrain(Terrain terrain){
        this.terrain = terrain;
    }
    public void setItem(Item item){
        this.item = item;
    }
    public void setEntity(Entity entity){
        this.entity = entity;
    }

	public String toString() {
		String result = "";
		result += "Tile:" + this.location.getX() + "," + this.location.getY();
		return result;
	}
	
	
}
