import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

import tn.esprit.pidev.Entities.Mission;
import tn.esprit.pidev.Service.Impl.MissionService;

@ManagedBean(name="MissionBean")
@SessionScoped
public class MissionBean implements Serializable{
    private int idmiss;
	public int getIdmiss() {
		return idmiss;
	}
	public void setIdmiss(int idmiss) {
		this.idmiss = idmiss;
	}

	private String startDate;
	private String endDate;
	private static List<Mission> miss;
	private String emplacement;
	@EJB
	MissionService mserv;
	private boolean state;
	public MissionService getMserv() {
		return mserv;
	}
	public void setMserv(MissionService mserv) {
		this.mserv = mserv;
	}
	public List<Mission> getMiss() {
		return miss;
	}
	public void setMiss(List<Mission> miss) {
		this.miss = miss;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getEmplacement() {
		return emplacement;
	}
	public void setEmplacement(String emplacement) {
		this.emplacement = emplacement;
	}
	public boolean isState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}
	public String goMiss() {
		return "/Pages/Collaborator/MissionList?faces-redirect=true";
	}

	Mission mm=new Mission();
	

	public Mission getMm() {
		return mm;
	}
	public void setMm(Mission mm) {
		this.mm = mm;
	}
	
	public String doRem(int idmiss) {
		mserv.removeMission(idmiss);
		return "removed";
	}
 public void rem(int id) {
	 mserv.removeMission(id);
 }
	
	
	public void getMlist(){
		miss=mserv.findAllMission();
		
	}

	
	public String goMission() {
		getMlist();
		return "/Pages/admin/Mission?faces-redirect=true";
		
	}
	public String createM() {
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		Mission m = new Mission();
		m.setStartDate(startDate);
		m.setEndDate(endDate);
		m.setEmplacement(emplacement);
		
		mserv.createMission(m);
		getMlist();
		return "/Pages/admin/Mission?faces-redirect=true";
	
	}
	
	public String goMission2() {
		
		miss=mserv.affConf();
		System.out.println(miss);
		
		return "/Pages/admin/Mission2?faces-redirect=true";
	}

}
	


