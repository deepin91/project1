package pethotel.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;
import pethotel.dto.PethotelCompanyDto;
import pethotel.dto.PethotelReviewDto;
import pethotel.service.PethotelService;

@Slf4j
@Controller
public class PethotelCompanyController {

	//private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private PethotelService pethotelService;
	
	@GetMapping("/pethotel/openPethotelDetail.do")
	public ModelAndView openPethotelDetail() throws Exception{
		ModelAndView mv =  new ModelAndView("/pethotel/pethotelDetail");
		
		log.trace("TRACE ...");
		log.debug("DEBUG ...");
		log.info("INFO ...");
		log.warn("WARN ...");
		log.error("ERROR ...");
		
		List <PethotelCompanyDto> detail =  pethotelService.selectPethotelDetail();
		mv.addObject("detail", detail);
		
		List <PethotelCompanyDto> reviewList =  pethotelService.selectPethotelReviewList();
		mv.addObject("reviewList", reviewList);
		
		return mv;
		
	}
	
	@PostMapping("/pethotel/insertPethotelCompanyReview.do")
	public String insertPethotelReview(PethotelReviewDto pethotelReviewDto) throws Exception {
		pethotelService.insertPethotelReview(pethotelReviewDto);
		return "redirect:/pethotel/openPethotelCompany.do";
	}
	
}
	
