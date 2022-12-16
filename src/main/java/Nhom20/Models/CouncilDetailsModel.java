package Nhom20.Models;

public class CouncilDetailsModel {
	private int id;
	private int councilId;
	private int teacherId;
	private Boolean leader;
	private float Scores;
	private String teacherName;
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public CouncilDetailsModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CouncilDetailsModel(int id, int councilId, int teacherId, Boolean leader, float scores, String teacherName) {
		super();
		this.id = id;
		this.councilId = councilId;
		this.teacherId = teacherId;
		this.leader = leader;
		Scores = scores;
		this.teacherName = teacherName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCouncilId() {
		return councilId;
	}
	public void setCouncilId(int councilId) {
		this.councilId = councilId;
	}
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public Boolean getLeader() {
		return leader;
	}
	public void setLeader(Boolean leader) {
		this.leader = leader;
	}
	public float getScores() {
		return Scores;
	}
	public void setScores(float scores) {
		Scores = scores;
	}
	
}
