package com.javalec.spring_command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.javalec.spring_dao.BDao;
import com.javalec.spring_dto.BDto;

public class BCommandModifyView implements BCommand {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub

		Map<String,Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		String bId = request.getParameter("bId");
		
		BDao dao = new BDao();
		BDto dto = dao.modify_view(bId);
		
		model.addAttribute("modify_view", dto);
		
	}

}
