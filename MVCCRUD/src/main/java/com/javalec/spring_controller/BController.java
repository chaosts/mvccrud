package com.javalec.spring_controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javalec.spring_command.BCommand;
import com.javalec.spring_command.BCommandContent;
import com.javalec.spring_command.BCommandDelete;
import com.javalec.spring_command.BCommandList;
import com.javalec.spring_command.BCommandModify;
import com.javalec.spring_command.BCommandModifyView;
import com.javalec.spring_command.BCommandReply;
import com.javalec.spring_command.BCommandReply_View;
import com.javalec.spring_command.BCommandWrite;

@Controller
public class BController {

	BCommand command;

	@RequestMapping("/list")
	public String list(Model model) {
		System.out.println("list() Start");
		command = new BCommandList();
		command.execute(model);

		return "list";
	}

	@RequestMapping("/write_view")
	public String write_view(Model model) {
		System.out.println("write_view() Start");
		return "write_view";
	}

	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {
		System.out.println("write() Start");
		model.addAttribute("request", request);
		command = new BCommandWrite();
		command.execute(model);
		return "redirect:list";
	}

	@RequestMapping("/content_view")
	public String content_view(HttpServletRequest request, Model model) {
		System.out.println("content_view() Start");
		model.addAttribute("request", request);
		command = new BCommandContent();
		command.execute(model);
		return "content_view";
	}

	@RequestMapping("/modify_view")
	public String modify_view(HttpServletRequest request, Model model) {
		System.out.println("modify_view() Start");
		model.addAttribute("request", request);
		command = new BCommandModifyView();
		command.execute(model);
		return "modify_view";
	}

	@RequestMapping("/modify")
	public String modify(HttpServletRequest request, Model model) {
		System.out.println("modify() Start");
		model.addAttribute("request", request);
		command = new BCommandModify();
		command.execute(model);
		return "redirect:list";
	}

	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		System.out.println("delete() Start");
		model.addAttribute("request", request);
		command = new BCommandDelete();
		command.execute(model);

		return "redirect:list";
	}

	@RequestMapping("/reply_view")
	public String reply_view(HttpServletRequest request, Model model) {
		System.out.println("reply_view() Start");
		model.addAttribute("request", request);
		command = new BCommandReply_View();
		command.execute(model);
		return "reply_view";
	}

	@RequestMapping("/reply")
	public String reply(HttpServletRequest request, Model model) {
		System.out.println("reply() Start");
		model.addAttribute("request", request);
		command = new BCommandReply();
		command.execute(model);
		return "redirect:list";
	}
}
