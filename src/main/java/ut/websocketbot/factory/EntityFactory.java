package ut.websocketbot.factory;

import ut.websocketbot.exception.AppException;

import java.util.List;
import java.util.stream.Collectors;

public interface EntityFactory<VO, DTO> {

    VO createVO(DTO dto);

    DTO createDTO(VO vo);

    default List<DTO> createDTOList(List<VO> voList) {
        return voList.stream().map(this::createDTO).collect(Collectors.toList());
    }

    default List<VO> createVOList(List<DTO> dtoList) {
        return dtoList.stream().map(this::createVO).collect(Collectors.toList());
    }

    default VO copy(VO vo) {
        throw new AppException("Copy method was not implemented");
    }
}

