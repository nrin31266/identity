package com.rin.identity.service;

import com.rin.identity.dto.request.RoleRequest;
import com.rin.identity.dto.response.RoleResponse;
import com.rin.identity.mapper.RoleMapper;
import com.rin.identity.repository.PermissionRepository;
import com.rin.identity.repository.RoleRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class RoleService {
    RoleRepository roleRepository;

    RoleMapper roleMapper;

    PermissionRepository permissionRepository;

    public RoleResponse create(RoleRequest request) {
//        System.err.println(request.getName());
//        System.err.println(request.getDescription());
//        System.err.println(request.getPermissions());

        var role = roleMapper.toRole(request);

        var permissions = permissionRepository.findAllById(request.getPermissions());
        role.setPermissions(new HashSet<>(permissions));

        role = roleRepository.save(role);
        return roleMapper.toRoleResponse(role);
    }

    public List<RoleResponse> getAll(){
        return roleRepository.findAll()
                .stream()
                .map(roleMapper::toRoleResponse)
                .toList();
    }

    public void delete(String role){
        roleRepository.deleteById(role);
    }
}
