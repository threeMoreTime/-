import request from '@/utils/request'

// 查询业绩管理列表
export function listPerformance(query) {
  return request({
    url: '/system/performance/list',
    method: 'get',
    params: query
  })
}

// 查询业绩管理详细
export function getPerformance(id) {
  return request({
    url: '/system/performance/' + id,
    method: 'get'
  })
}

// 新增业绩管理
export function addPerformance(data) {
  return request({
    url: '/system/performance',
    method: 'post',
    data: data
  })
}

// 修改业绩管理
export function updatePerformance(data) {
  return request({
    url: '/system/performance',
    method: 'put',
    data: data
  })
}

// 删除业绩管理
export function delPerformance(id) {
  return request({
    url: '/system/performance/' + id,
    method: 'delete'
  })
}
