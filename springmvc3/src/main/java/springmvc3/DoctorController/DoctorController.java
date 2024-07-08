package springmvc3.DoctorController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import springmvc3.DoctorDao.DoctorDao;
import springmvc3.DoctorDto.DoctorDto;

@Controller
public class DoctorController 
{
   @Autowired
   DoctorDao doctordao;
   
   @RequestMapping("/insert")
   @ResponseBody
   public String insert(@ModelAttribute DoctorDto dto)
   {
	   doctordao.insert(dto);
	return "data inserted successfully";
   }
   
   @RequestMapping("/deletebyid")
   @ResponseBody
   public String delete(@RequestParam int id)
   {
	   System.out.println(id);
	   String dto=doctordao.deletebyid(id);
	   return dto;
   }
   @RequestMapping("/fetchall")
   @ResponseBody
   public ModelAndView fetchAll()
   {
	 List<DoctorDto> list=doctordao.fetchall();
	 ModelAndView view=new ModelAndView("fetchall.jsp");
	 view.addObject("object",list);
	 return view;
   }
   
   @RequestMapping("/fetchbyid")
   @ResponseBody
   public ModelAndView fetchbyid(@RequestParam int id)
   {
	   System.out.println(id);
	   DoctorDto dto=doctordao.fetchbyid(id);
	   System.out.println(dto);
	   
	   ModelAndView modelAndView=new ModelAndView("fetchbyid.jsp");
	   modelAndView.addObject("obj", dto);    // this obj is a key name and this name is same as in fetchbyid.jsp file ${obj}
	   return modelAndView;
   }
   
   @RequestMapping("/deleteall")
   @ResponseBody
   public String deleteall()
   {
	  DoctorDao dao=new DoctorDao();
	   String msg=dao.deleteall();
	   return msg;
   }
   @RequestMapping("/update")
   @ResponseBody
   public String update(@ModelAttribute DoctorDto doctorDto)
   {
	   doctordao.updateData(doctorDto);
	   return "data updated successfully";
   }
}
