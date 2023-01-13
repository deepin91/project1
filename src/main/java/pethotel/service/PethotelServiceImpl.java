package pethotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pethotel.dto.PethotelCompanyDto;
import pethotel.dto.PethotelReviewDto;
import pethotel.mapper.PethotelMapper;

@Service
@Transactional
public class PethotelServiceImpl implements PethotelService {

	@Autowired
	private PethotelMapper pethotelMapper;
	
	@Override
	public List <PethotelCompanyDto> selectPethotelDetail() throws Exception{
		return pethotelMapper.selectPethotelDetail();
	
}
	@Override
	public void insertPethotelReview(PethotelReviewDto pethotelReviewDto) throws Exception{
		pethotelMapper.insertPethotelReview(pethotelReviewDto);
	}
	@Override
	public List<PethotelCompanyDto> selectPethotelReviewList() throws Exception {
		return pethotelMapper.selectReviewList();
	}
}