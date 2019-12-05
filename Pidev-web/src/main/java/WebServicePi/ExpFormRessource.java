package WebServicePi;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import WebServiceEntity.Tr;
import tn.esprit.pidev.Entities.ExpenseForm;
import tn.esprit.pidev.Service.Impl.ExpenseFormService;
@Path("ExpCreate")
@RequestScoped
public class ExpFormRessource {
    @EJB
    ExpenseFormService Ex;
    
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/add")
    public Response AddExpForm(Tr t ) {
		ExpenseForm a1=new ExpenseForm();
		a1.setAmount(t.getAmount());
		a1.setDescription(t.getDescription());
		a1.setJustification(t.getJustification());
        a1.getDate();
		System.out.println(t.getDescription());
		Ex.createExpForm(a1);
		return Response.ok().build();
	}
	private static List<ExpenseForm> List;

	public List getE() {
		return List;
	}
	public void setE(List<ExpenseForm> e) {
		this.List = List;
	}
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getEform")
    public Response getEform( ) {
		ExpenseForm a1=new ExpenseForm();
		
		System.out.println("aaaaaaaaaabbbb");
		List=Ex.findAllExpenseForms();
		return Response.ok(List).build();
	}
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	
	@Path("{id}")
    public Response delEform(@PathParam(value="id") int id)  {
		ExpenseForm a1=new ExpenseForm();
		
		System.out.println("aaaaaaaaaabbbb");
		Ex.removeMreq(id);
		return Response.ok().build();
	}
}
