package personal.flying.mj.data;

public class MJ {
	public static final byte MJ_TYPE_TIAO = 0;
	public static final byte MJ_TYPE_TONG = 1;
	public static final byte MJ_TYPE_WAN = 2;
	public static final byte MJ_TYPE_Other = 3;
	
	private byte type;
	private byte value;
	
	public byte getType() {
		return type;
	}
	public void setType(byte type) {
		this.type = type;
	}
	public byte getValue() {
		return value;
	}
	public void setValue(byte value) {
		this.value = value;
	}
	
	

}
