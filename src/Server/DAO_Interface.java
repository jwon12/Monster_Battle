package Server;

public interface DAO_Interface {
	public boolean insert(Object o);
	public void delete(Object o);
	public void update(Object o);
	public Object selAll();
}
