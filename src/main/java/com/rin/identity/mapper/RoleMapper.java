package com.rin.identity.mapper;

import com.rin.identity.dto.request.PermissionRequest;
import com.rin.identity.dto.request.RoleRequest;
import com.rin.identity.dto.response.PermissionResponse;
import com.rin.identity.dto.response.RoleResponse;
import com.rin.identity.entity.Permission;
import com.rin.identity.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    @Mapping(target = "permissions", ignore = true)
    Role toRole(RoleRequest request);

    RoleResponse toRoleResponse(Role role);
}
