package spittr.data;

import spittr.Spitter;

public interface SpitterRepository {

	public Spitter save(Spitter unsaved);

	public Spitter findByUsername(String username);

}
