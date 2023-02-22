import request from '@/utils/request'

// 查询用户详细信息列表
export function listProfile(query) {
  return request({
    url: '/system/profile/list',
    method: 'get',
    params: query
  })
}

// 查询用户详细信息详细
export function getProfile(id) {
  return request({
    url: '/system/profile/' + id,
    method: 'get'
  })
}

// 新增用户详细信息
export function addProfile(data) {
  return request({
    url: '/system/profile',
    method: 'post',
    data: data
  })
}

// 修改用户详细信息
export function updateProfile(data) {
  return request({
    url: '/system/profile',
    method: 'put',
    data: data
  })
}

// 删除用户详细信息
export function delProfile(id) {
  return request({
    url: '/system/profile/' + id,
    method: 'delete'
  })
}
