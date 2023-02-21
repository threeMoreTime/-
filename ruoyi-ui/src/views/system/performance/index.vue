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
      <el-form-item label="交易日期" prop="date">
        <el-date-picker clearable
          v-model="queryParams.date"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择交易日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="销售额" prop="sales">
        <el-input
          v-model="queryParams.sales"
          placeholder="请输入销售额"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="成本" prop="expenses">
        <el-input
          v-model="queryParams.expenses"
          placeholder="请输入成本"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="总收入" prop="revenue">
        <el-input
          v-model="queryParams.revenue"
          placeholder="请输入总收入"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="纯利润" prop="profit">
        <el-input
          v-model="queryParams.profit"
          placeholder="请输入纯利润"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="产品名称" prop="productId">
        <el-input
          v-model="queryParams.productId"
          placeholder="请输入产品名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="销售地区" prop="region">
        <el-input
          v-model="queryParams.region"
          placeholder="请输入销售地区"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="销售渠道" prop="channel">
        <el-input
          v-model="queryParams.channel"
          placeholder="请输入销售渠道"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="详细数量" prop="salesQuantity">
        <el-input
          v-model="queryParams.salesQuantity"
          placeholder="请输入详细数量"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="税费" prop="taxes">
        <el-input
          v-model="queryParams.taxes"
          placeholder="请输入税费"
          clearable
          @keyup.enter.native="handleQuery"
        />
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
          v-hasPermi="['system:performance:add']"
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
          v-hasPermi="['system:performance:edit']"
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
          v-hasPermi="['system:performance:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:performance:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="performanceList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="业绩编号" align="center" prop="id" />
      <el-table-column label="员工名称" align="center" prop="employeeId" />
      <el-table-column label="交易日期" align="center" prop="date" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.date, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="销售额" align="center" prop="sales" />
      <el-table-column label="成本" align="center" prop="expenses" />
      <el-table-column label="总收入" align="center" prop="revenue" />
      <el-table-column label="纯利润" align="center" prop="profit" />
      <el-table-column label="产品名称" align="center" prop="productId" />
      <el-table-column label="销售地区" align="center" prop="region" />
      <el-table-column label="销售渠道" align="center" prop="channel" />
      <el-table-column label="详细数量" align="center" prop="salesQuantity" />
      <el-table-column label="成本的具体说明" align="center" prop="expensesDetail" />
      <el-table-column label="税费" align="center" prop="taxes" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:performance:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:performance:remove']"
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

    <!-- 添加或修改业绩管理对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="员工名称" prop="employeeId">
          <el-input v-model="form.employeeId" placeholder="请输入员工名称" />
        </el-form-item>
        <el-form-item label="交易日期" prop="date">
          <el-date-picker clearable
            v-model="form.date"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择交易日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="销售额" prop="sales">
          <el-input v-model="form.sales" placeholder="请输入销售额" />
        </el-form-item>
        <el-form-item label="成本" prop="expenses">
          <el-input v-model="form.expenses" placeholder="请输入成本" />
        </el-form-item>
        <el-form-item label="总收入" prop="revenue">
          <el-input v-model="form.revenue" placeholder="请输入总收入" />
        </el-form-item>
        <el-form-item label="纯利润" prop="profit">
          <el-input v-model="form.profit" placeholder="请输入纯利润" />
        </el-form-item>
        <el-form-item label="产品名称" prop="productId">
          <el-input v-model="form.productId" placeholder="请输入产品名称" />
        </el-form-item>
        <el-form-item label="销售地区" prop="region">
          <el-input v-model="form.region" placeholder="请输入销售地区" />
        </el-form-item>
        <el-form-item label="销售渠道" prop="channel">
          <el-input v-model="form.channel" placeholder="请输入销售渠道" />
        </el-form-item>
        <el-form-item label="详细数量" prop="salesQuantity">
          <el-input v-model="form.salesQuantity" placeholder="请输入详细数量" />
        </el-form-item>
        <el-form-item label="成本的具体说明" prop="expensesDetail">
          <el-input v-model="form.expensesDetail" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="税费" prop="taxes">
          <el-input v-model="form.taxes" placeholder="请输入税费" />
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
import { listPerformance, getPerformance, delPerformance, addPerformance, updatePerformance } from "@/api/system/performance";

export default {
  name: "Performance",
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
      // 业绩管理表格数据
      performanceList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        employeeId: null,
        date: null,
        sales: null,
        expenses: null,
        revenue: null,
        profit: null,
        productId: null,
        region: null,
        channel: null,
        salesQuantity: null,
        expensesDetail: null,
        taxes: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询业绩管理列表 */
    getList() {
      this.loading = true;
      listPerformance(this.queryParams).then(response => {
        this.performanceList = response.rows;
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
        date: null,
        sales: null,
        expenses: null,
        revenue: null,
        profit: null,
        productId: null,
        region: null,
        channel: null,
        salesQuantity: null,
        expensesDetail: null,
        taxes: null
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
      this.title = "添加业绩管理";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getPerformance(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改业绩管理";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updatePerformance(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addPerformance(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除业绩管理编号为"' + ids + '"的数据项？').then(function() {
        return delPerformance(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/performance/export', {
        ...this.queryParams
      }, `performance_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
