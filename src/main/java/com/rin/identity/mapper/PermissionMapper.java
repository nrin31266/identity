package com.rin.identity.mapper;

import com.rin.identity.dto.request.PermissionRequest;
import com.rin.identity.dto.request.UserCreationRequest;
import com.rin.identity.dto.request.UserUpdateRequest;
import com.rin.identity.dto.response.PermissionResponse;
import com.rin.identity.dto.response.UserResponse;
import com.rin.identity.entity.Permission;
import com.rin.identity.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PermissionMapper {
    Permission toPermission(PermissionRequest request);
    PermissionResponse toPermissionResponse(Permission permission);
}
