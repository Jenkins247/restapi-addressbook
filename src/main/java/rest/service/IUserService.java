package rest.service;

import rest.dto.GroupDTO;
import rest.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    /**
     * Добавление нового пользователя
     *
     * @param userDTO - пользователь для добавления
     */
    UserDTO add(UserDTO userDTO);

    /**
     * Возвращает группу по заданному ID
     *
     * @param id - ID группы
     * @return - объект группы с заданным ID
     */
    Optional<UserDTO> findById(Integer id);

    /**
     * Удаляет пользователя по заданному id
     *
     * @param id - id пользователя
     */
    void delete(Integer id);

    /**
     * Обновляет пользователя с заданным ид
     *
     * @param id - id пользователя
     * @param userDTO -
     * @return -
     */
    UserDTO update(Integer id, UserDTO userDTO);
}
