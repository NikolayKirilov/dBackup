package info.dbackup.data;

//TODO: are you aware of existence of File.java class, which is way better abstraction of file system thatn your class?
public interface DataFile {
	public String getName();

	public void rename(String newName);

}
