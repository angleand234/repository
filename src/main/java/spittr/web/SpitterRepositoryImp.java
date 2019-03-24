package spittr.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import spittr.Spitter;
import spittr.data.SpitterRepository;

@Component
public class SpitterRepositoryImp implements SpitterRepository{
	private List<Spitter> list = new ArrayList<Spitter>();
	@Override
	public Spitter save(Spitter unsaved) {
		// TODO Auto-generated method stub
		list.add(unsaved);
		return null;
	}

	@Override
	public Spitter findByUsername(String username) {
		// TODO Auto-generated method stub
		if(list!=null&&list.size()>0) {
			for (Spitter spitter : list) {
				if(username.equals(spitter.getUsername())) {
					return spitter;
				}
			}
		}
		return null;
	}

}
