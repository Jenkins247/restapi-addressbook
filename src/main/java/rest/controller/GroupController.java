package rest.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rest.dto.GroupDTO;
import rest.exceptions.GroupNotFoundException;
import rest.request.GroupRequest;
import rest.response.GroupResponse;
import rest.service.GroupService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/groups")
public class GroupController {
    private final GroupService groupService;
    private final ModelMapper mapper = new ModelMapper();

    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<GroupResponse> add(@RequestBody GroupRequest groupRequest) {
        GroupDTO groupDTO = mapper.map(groupRequest, GroupDTO.class);
        groupDTO = groupService.add(groupDTO);
        return new ResponseEntity<>(mapper.map(groupDTO, GroupResponse.class), HttpStatus.CREATED);
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<GroupResponse>> findAll() {
        List<GroupDTO> groups = groupService.findAll();
        List<GroupResponse> response = groups.stream()
                .map(GroupDTO -> mapper.map(GroupDTO, GroupResponse.class))
                .toList();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/group")
    @ResponseBody
    public ResponseEntity<Optional<GroupResponse>> findById(@RequestParam(value = "id") Integer id) {
        Optional<GroupDTO> dto = groupService.findById(id);
        GroupResponse group = new ModelMapper().map(dto.get(), GroupResponse.class);
        return new ResponseEntity<>(Optional.of(group), HttpStatus.OK);
    }

    @DeleteMapping("/group")
    @ResponseBody
    public ResponseEntity<?> delete(@RequestParam(value = "id") Integer id){
        groupService.delete(id);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/group")
    @ResponseBody
    public ResponseEntity<GroupResponse> update(@RequestParam(value = "id") Integer id,
                                                @RequestBody GroupRequest groupRequest){
        GroupDTO groupDTO = mapper.map(groupRequest, GroupDTO.class);
        groupDTO = groupService.update(id, groupDTO);
        return new ResponseEntity<>(mapper.map(groupDTO, GroupResponse.class), HttpStatus.OK);
    }
}
