<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="员工名称" prop="employeeId">
        <el-input
          v-model="queryParams.employeeId"
          placeholder="请输入员工名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="基本工资金额" prop="salary">
        <el-input
          v-model="queryParams.salary"
          placeholder="请输入基本工资金额"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="奖金" prop="bonus">
        <el-input
          v-model="queryParams.bonus"
          placeholder="请输入奖金"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="罚款" prop="deduction">
        <el-input
          v-model="queryParams.deduction"
          placeholder="请输入罚款"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="缴纳社保金额" prop="insurance">
        <el-input
          v-model="queryParams.insurance"
          placeholder="请输入缴纳社保金额"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="个人所得税金额" prop="tax">
        <el-input
          v-model="queryParams.tax"
          placeholder="请输入个人所得税金额"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="实际支付金额" prop="payment">
        <el-input
          v-model="queryParams.payment"
          placeholder="请输入实际支付金额"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="发薪日期" prop="paymentDate">
        <el-date-picker clearable
          v-model="queryParams.paymentDate"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择发薪日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['system:payroll:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:payroll:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['system:payroll:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:payroll:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="payrollList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="薪资编号" align="center" prop="id" />
      <el-table-column label="员工名称" align="center" prop="employeeId" />
      <el-table-column label="基本工资金额" align="center" prop="salary" />
      <el-table-column label="奖金" align="center" prop="bonus" />
      <el-table-column label="罚款" align="center" prop="deduction" />
      <el-table-column label="缴纳社保金额" align="center" prop="insurance" />
      <el-table-column label="个人所得税金额" align="center" prop="tax" />
      <el-table-column label="实际支付金额" align="center" prop="payment" />
      <el-table-column label="发薪日期" align="center" prop="paymentDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.paymentDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:payroll:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:payroll:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改薪资管理对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="员工名称" prop="employeeId">
          <el-input v-model="form.employeeId" placeholder="请输入员工名称" />
        </el-form-item>
        <el-form-item label="基本工资金额" prop="salary">
          <el-input v-model="form.salary" placeholder="请输入基本工资金额" />
        </el-form-item>
        <el-form-item label="奖金" prop="bonus">
          <el-input v-model="form.bonus" placeholder="请输入奖金" />
        </el-form-item>
        <el-form-item label="罚款" prop="deduction">
          <el-input v-model="form.deduction" placeholder="请输入罚款" />
        </el-form-item>
        <el-form-item label="缴纳社保金额" prop="insurance">
          <el-input v-model="form.insurance" placeholder="请输入缴纳社保金额" />
        </el-form-item>
        <el-form-item label="个人所得税金额" prop="tax">
          <el-input v-model="form.tax" placeholder="请输入个人所得税金额" />
        </el-form-item>
        <el-form-item label="实际支付金额" prop="payment">
          <el-input v-model="form.payment" placeholder="请输入实际支付金额" />
        </el-form-item>
        <el-form-item label="发薪日期" prop="paymentDate">
          <el-date-picker clearable
            v-model="form.paymentDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择发薪日期">
          </el-date-picker>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listPayroll, getPayroll, delPayroll, addPayroll, updatePayroll } from "@/api/system/payroll";

export default {
  name: "Payroll",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 薪资管理表格数据
      payrollList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        employeeId: null,
        salary: null,
        bonus: null,
        deduction: null,
        insurance: null,
        tax: null,
        payment: null,
        paymentDate: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        employeeId: [
          { required: true, message: "员工名称不能为空", trigger: "blur" }
        ],
        salary: [
          { required: true, message: "基本工资金额不能为空", trigger: "blur" }
        ],
        paymentDate: [
          { required: true, message: "发薪日期不能为空", trigger: "blur" }
        ]
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询薪资管理列表 */
    getList() {
      this.loading = true;
      listPayroll(this.queryParams).then(response => {
        this.payrollList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        employeeId: null,
        salary: null,
        bonus: null,
        deduction: null,
        insurance: null,
        tax: null,
        payment: null,
        paymentDate: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加薪资管理";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getPayroll(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改薪资管理";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updatePayroll(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addPayroll(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除薪资管理编号为"' + ids + '"的数据项？').then(function() {
        return delPayroll(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/payroll/export', {
        ...this.queryParams
      }, `payroll_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
