package org.api.dto;

import lombok.*;
import org.common.entity.BaseEntity;

/**
 * @author mayerjohnson
 * @Description
 * @created 2024-09-15 23:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true)
public class UserDTO extends BaseEntity {

    private String username;

    private String email;

}
