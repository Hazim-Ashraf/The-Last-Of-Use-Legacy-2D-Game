package model.characters;

import exceptions.InvalidTargetException;
import exceptions.NotEnoughActionsException;

public class Fighter extends Hero {

	public Fighter(String name, int maxHp, int attackDamage, int maxActions) {
		super(name, maxHp, attackDamage, maxActions);
	}
	
	public static void main(String args[]) throws NotEnoughActionsException, InvalidTargetException
	{
		Fighter f=new Fighter("joe",45,5,5);
		f.attack();
		}

}
