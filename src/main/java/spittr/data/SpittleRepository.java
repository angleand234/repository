package spittr.data;

import java.util.List;

import spittr.Spittle;

public interface SpittleRepository {
	public List<Spittle> findSpittles(long max,int count);

	public Spittle findOne(long spittleId);

	public void save(Spittle spittle);
}
