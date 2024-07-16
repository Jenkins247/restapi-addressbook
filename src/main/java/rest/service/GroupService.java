package rest.service;

import jakarta.persistence.criteria.CriteriaBuilder;
import rest.dto.GroupDTO;

import java.util.List;
import java.util.Optional;

public interface GroupService {

    /**
     * Добавление новой группы
     *
     * @param groupDto - группа для добавления
     */
    GroupDTO add(GroupDTO groupDto);

    /**
     * Возвращает группу по заданному ID
     *
     * @param id - ID группы
     * @return - объект группы с заданным ID
     */
    Optional<GroupDTO> findById(Integer id);

    /**
     * Получает список всех групп
     *
     * @return список групп
     */
    List<GroupDTO> findAll();

    /**
     * Удаляет группу по заданному id
     *
     * @param id - id группы
     */
    void delete(Integer id);

    /**
     * Обновляет группу с заданным ид
     *
     * @param id - id группы
     * @param groupDTO -
     * @return -
     */
    GroupDTO update(Integer id, GroupDTO groupDTO);
}
