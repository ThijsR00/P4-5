package hibernate;

public interface ReizigerDAO {
	public void save(Reiziger r);
	public void update(Reiziger r);
	public void delete(Reiziger r);
	public Reiziger get(int i);
	
}
