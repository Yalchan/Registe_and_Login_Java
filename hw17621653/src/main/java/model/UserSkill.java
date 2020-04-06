package model;

import java.io.Serializable;

import model.enums.SkillType;

public class UserSkill implements Serializable {
	private String skillName;
	private SkillType skillType;
	private int skillLevel;
	
	public UserSkill() {
		super();
		this.skillName = null;
		this.skillType = null;
		this.skillLevel = 0;
	}

	public String getSkillName() {
		return skillName;
	}
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}
	public SkillType getSkillType() {
		return skillType;
	}
	public void setSkillType(SkillType skillType) {
		this.skillType = skillType;
	}
	public int getSkillLevel() {
		return skillLevel;
	}
	public void setSkillLevel(int skillLevel) {
		this.skillLevel = skillLevel;
	}
	@Override
	public String toString() {
		return "UserSkill [skillName=" + skillName + ", skillType=" + skillType + ", skillLevel=" + skillLevel + "]";
	}
	
	
	

}
