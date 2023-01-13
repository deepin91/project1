package pethotel.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import pethotel.dto.PethotelCompanyDto;
import pethotel.dto.PethotelReviewDto;

@Mapper
public interface PethotelMapper {
List<PethotelCompanyDto> selectPethotelDetail()throws Exception;
//public List<PethotelCompanyDto> selectPethotelReviewList()throws Exception;
void insertPethotelReview(PethotelReviewDto pethotelReviewDto)throws Exception;
List<PethotelCompanyDto> selectReviewList()throws Exception;
}
