
import java.time.LocalDateTime;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.ejb.EJB;

import tn.esprit.pidev.Entities.ExpenseForm;
import tn.esprit.pidev.Entities.FixedFee;
import tn.esprit.pidev.Entities.Mission;
import tn.esprit.pidev.Service.Impl.FixedFeeService;

public class FixedFeeBean {
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Mission getMiss() {
		return miss;
	}
	public void setMiss(Mission miss) {
		this.miss = miss;
	}
	public float getWithdraw() {
		return withdraw;
	}
	public void setWithdraw(float withdraw) {
		this.withdraw = withdraw;
	}


	private int id;
	private float daily_consumption;
	private float amount;
	private Mission miss;
	@EJB
	FixedFeeService ff;
	private float withdraw;
	public float getDaily_consumption() {
		return daily_consumption;
	}
	public void setDaily_consumption(float daily_consumption) {
		this.daily_consumption = daily_consumption;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public FixedFeeService getFf() {
		return ff;
	}
	public void checkFee(float withdraw) {
		
		LocalDateTime hier = LocalDateTime.now().minusHours(24);
		LocalDateTime mnt=LocalDateTime.now();
		
		for(LocalDateTime i=hier ;i.isBefore(mnt);i.plusHours(1)) {
			if((daily_consumption+withdraw)<amount) {
				ff.Withdraw(id, withdraw);
			}

		}
		Timer timer = new Timer ();
		TimerTask t = new TimerTask () {
		    @Override
		    public void run () {
		        ff.Withdraw(id, -daily_consumption);
		    }
		};

		timer.schedule (t, 0l, 1000*60*60*24);}
		
	
	public void setFf(FixedFeeService ff) {
		this.ff = ff;
	}
	FixedFee e =new FixedFee();
	
	
	
 public FixedFee getE() {
		return e;
	}
	public void setE(FixedFee e) {
		this.e = e;
	}
	
public int setFF()
 {
	
	e.setDaily_fee((float)amount);

             return ff.createFfee(e);

		}
 public List<FixedFee> DoAffiche(){
	 List<FixedFee> d=ff.findAllFixedFee();
	 return  d;
	 
 }
	public String DoBlock() {
		ff.removeFfee(e.getId());
		return("Blocked fee");
	}
}
