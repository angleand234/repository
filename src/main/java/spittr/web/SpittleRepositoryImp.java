package spittr.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import spittr.Spittle;
import spittr.data.SpittleRepository;

@Component
public class SpittleRepositoryImp implements SpittleRepository{

	@Override
	public List<Spittle> findSpittles(long max, int count) {
		// TODO Auto-generated method stub
		List<Spittle> expectedSpittles = createSpittlesList(count);
		return expectedSpittles;
	}
	
	private List<Spittle> createSpittlesList(int count) {
		// TODO Auto-generated method stub
		List<Spittle> spittles = new ArrayList<Spittle>();
		for (int i = 0; i < count; i++) {
			spittles.add(new Spittle("Spittle "+ i,new Date()));
		}
		return spittles;
	}

	@Override
	public Spittle findOne(long i) {
		// TODO Auto-generated method stub
		if(i==999) {
			return null;
		}
		return new Spittle("Hello Spittr",new Date());
	}

}
