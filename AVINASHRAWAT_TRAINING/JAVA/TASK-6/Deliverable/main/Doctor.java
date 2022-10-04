package com.doctor.main;

public class Doctor {
	String docName;
	int docId;
	String Speciality;
	double fee;
	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Doctor(String docName, int docId, String speciality, double fee) {
		super();
		this.docName = docName;
		this.docId = docId;
		Speciality = speciality;
		this.fee = fee;
	}
	public String getDocName() {
		return docName;
	}
	@Override
	public String toString() {
		return "Doctor [docName=" + docName + ", docId=" + docId + ", Speciality=" + Speciality + ", fee=" + fee + "]";
	}
	public void setDocName(String docName) {
		this.docName = docName;
	}
	public int getDocId() {
		return docId;
	}
	public void setDocId(int docId) {
		this.docId = docId;
	}
	public String getSpeciality() {
		return Speciality;
	}
	public void setSpeciality(String speciality) {
		Speciality = speciality;
	}
	public double getFee() {
		return fee;
	}
	public void setFee(double fee) {
		this.fee = fee;
	}
	
}
