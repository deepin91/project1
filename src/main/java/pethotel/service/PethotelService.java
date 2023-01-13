package pethotel.service;

import java.util.List;

import pethotel.dto.PethotelCompanyDto;
import pethotel.dto.PethotelReviewDto;

public interface PethotelService {
	public List<PethotelCompanyDto> selectPethotelDetail() throws Exception;
	public List<PethotelCompanyDto> selectPethotelReviewList()throws Exception;
	public void insertPethotelReview(PethotelReviewDto pethotelReviewDto)throws Exception;
	
}
