package ca.sheridancollege.ca.controllers;

import java.io.FileWriter;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridancollege.ca.database.DatabaseAccess;

@Controller
public class DrinkController {
	
	@Autowired

	private DatabaseAccess da;
	
	@GetMapping("/")
	public String goHome()
	{
		
		
		
		
		
		return "home.html";
	}
	
	@GetMapping("/test1")
	public String goHomeTest1(Model model, HttpSession session, @RequestParam int id,
			@RequestParam String name, @RequestParam String ticket,  @RequestParam int nots,
			 @RequestParam String movie,  @RequestParam String date,  @RequestParam String time,
			 @RequestParam int row,  @RequestParam int column, @RequestParam String user) throws Exception
	{
		double price=0.0;
		
		if(ticket.equalsIgnoreCase("General Admission"))
			price=15.00;
		if(ticket.equalsIgnoreCase("Sheridan College Student"))
			price=10.00;
		if(ticket.equalsIgnoreCase("PROG 32758 Student"))
			price=8.00;
		if(ticket.equalsIgnoreCase("Senior Citizen and Children"))
			price=5.00;
		
		price= price*nots;
		if(user.equalsIgnoreCase("yes"))
			price= price-(0.20*price);
		int seats[][] = {{1, 1, 1, 1, 1},
	                	{1, 1, 1, 1, 1},
	                	{1, 1, 1, 1, 1},
	                	{0, 0, 1, 1, 1},
	                	{0, 0, 1, 1, 1}};
		//da.bookseat(row, column, name);
		
		
		
		FileWriter fileWriter = new FileWriter("C:\\Users\\akash\\file.txt");
		  
	    fileWriter.write("name = "+name);
	    fileWriter.write("\n ID = "+id);
	    fileWriter.write("\n Type of ticket purchased = "+ticket);
	    fileWriter.write("\n Number of tickets bought = "+nots);
	    fileWriter.write("\n Name of the movie = "+movie);
	    fileWriter.write("\n date for the movie = "+date);
	    fileWriter.write("\n Time for the movie = "+time);
	    fileWriter.write("\n Seat: row = "+row+" seat no = "+column);
	    fileWriter.write("\n Total amount paid = "+price);
	    fileWriter.close();
		
		model.addAttribute("id",id);
		model.addAttribute("name",name);
		model.addAttribute("ticket",ticket);
		model.addAttribute("price", price);
		model.addAttribute("nots",nots);
		model.addAttribute("movie",movie);
		model.addAttribute("date",date);
		model.addAttribute("time",time);
		model.addAttribute("row",row);
		model.addAttribute("column",column);
		model.addAttribute("user",user);
		return "selection.html";
	}
	
	@GetMapping("/end")
	public String endSession(HttpSession session)
	{
		session.invalidate();
		return "home.html";
	}
	
	@GetMapping("/registers")
	public String register(@RequestParam String firstname, @RequestParam String lastName, 
			@RequestParam String email, @RequestParam String phone, @RequestParam String pass)
	{
		
	return "home.html";
	}
	

}
