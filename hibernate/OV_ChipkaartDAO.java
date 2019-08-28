package hibernate;

import java.io.Serializable;

public interface OV_ChipkaartDAO {
	public void save(OV_Chipkaart ov);
	public void delete(OV_Chipkaart ov);
	public void update(OV_Chipkaart ov);
	public OV_Chipkaart get(int nummer);
}
