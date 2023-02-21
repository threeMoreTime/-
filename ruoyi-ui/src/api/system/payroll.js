import request from '@/utils/request'

// 查询薪资管理列表
export function listPayroll(query) {
  return request({
    url: '/system/payroll/list',
    method: 'get',
    params: query
  })
}

// 查询薪资管理详细
export function getPayroll(id) {
  return request({
    url: '/system/payroll/' + id,
    method: 'get'
  })
}

// 新增薪资管理
export function addPayroll(data) {
  return request({
    url: '/system/payroll',
    method: 'post',
    data: data
  })
}

// 修改薪资管理
export function updatePayroll(data) {
  return request({
    url: '/system/payroll',
    method: 'put',
    data: data
  })
}

// 删除薪资管理
export function delPayroll(id) {
  return request({
    url: '/system/payroll/' + id,
    method: 'delete'
  })
}
