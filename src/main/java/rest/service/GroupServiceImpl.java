package rest.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rest.dto.GroupDTO;
import rest.exceptions.GroupNotFoundException;
import rest.model.GroupEntity;
import rest.repository.DbRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GroupServiceImpl implements IGroupService {

    @Autowired
    private DbRepository dbRepository;

    @Override
    public GroupDTO add(GroupDTO groupDto) {
        groupDto.setId(null);
        GroupEntity group = new ModelMapper().map(groupDto, GroupEntity.class);

        group = dbRepository.save(group);
        groupDto.setId(group.getId());
        return groupDto;
    }

    @Override
    public Optional<GroupDTO> findById(Integer id) {
        Optional<GroupEntity> group = dbRepository.findById(id);
        if(group.isEmpty()){
            throw new GroupNotFoundException("Not found group with id = " + id);
        }
        GroupDTO dto = new ModelMapper().map(group.get(), GroupDTO.class);
        return Optional.of(dto);
    }

    @Override
    public List<GroupDTO> findAll() {
        List<GroupEntity> groups = dbRepository.findAll();
        return groups.stream()
                .map(group -> new ModelMapper().map(group, GroupDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        Optional<GroupEntity> group = dbRepository.findById(id);

        if(group.isEmpty()){
            throw new GroupNotFoundException("Not found group with id = " + id);
        }
        dbRepository.deleteById(id);
    }

    @Override
    public GroupDTO update(Integer id, GroupDTO groupDTO) {
        groupDTO.setId(id);
        ModelMapper mapper = new ModelMapper();
        GroupEntity group = mapper.map(groupDTO, GroupEntity.class);
        dbRepository.save(group);
        return groupDTO;
    }
}
