package com.javalec.spring_command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.javalec.spring_dao.BDao;
import com.javalec.spring_dto.BDto;

public class BCommandList implements BCommand {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub

	   BDao dao = new BDao();
	   ArrayList<BDto> dtos = dao.list();
	   
	   model.addAttribute("list", dtos);
		
	}

}
