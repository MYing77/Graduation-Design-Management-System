<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>高校毕业设计管理系统</title>
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/materialdesignicons.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/style.min.css" rel="stylesheet">
</head>
<body>
<div class="lyear-layout-web">
  <div class="lyear-layout-container">
    <!--左侧导航-->
    <aside class="lyear-layout-sidebar">
      

      <div id="logo" style="height:68px">
        
      </div>
      <div class="lyear-layout-sidebar-scroll"> 
        
        <nav class="sidebar-main">
          <ul class="nav nav-drawer">
            <li class="nav-item active"> <a href="javascript:void(0)" onclick="location.reload()"><i class="mdi mdi-home"></i> 首页</a> </li>
            <li class="nav-item nav-item-has-subnav">
              <a href="javascript:void(0)"><i class="mdi mdi-bank"></i> 选题管理</a>
              <ul class="nav nav-subnav">
                <li> <a href="lyear_ui_buttons.html">选题申报</a> </li>
                <li> <a href="lyear_ui_cards.html">我的选题</a> </li>
              </ul>
            </li>
            <li class="nav-item nav-item-has-subnav">
              <a href="javascript:void(0)"><i class="mdi mdi-file-outline"></i> 开题报告管理</a>
              <ul class="nav nav-subnav">
                <li> <a href="lyear_forms_elements.html">开题报告 (学生)</a> </li>
              </ul>
            </li>
            <li class="nav-item nav-item-has-subnav">
              <a href="javascript:void(0)"><i class="mdi mdi-file-outline"></i> 任务书管理</a>
              <ul class="nav nav-subnav">
                <li> <a href="lyear_pages_doc.html">任务书</a> </li>
              </ul>
            </li>
            <li class="nav-item nav-item-has-subnav">
              <a href="javascript:void(0)"><i class="mdi mdi-tab"></i> 中期检查</a>
              <ul class="nav nav-subnav">
                <li> <a href="lyear_js_datepicker.html">中期检查</a> </li>
              </ul>
            </li>
            <li class="nav-item nav-item-has-subnav">
              <a href="javascript:void(0)"><i class="mdi mdi-file-document"></i> 论文管理</a>
              <ul class="nav nav-subnav">
                <li> <a href="lyear_js_datepicker.html">学生论文 (在线提交)</a> </li>
              </ul>
            </li>
            <li class="nav-item nav-item-has-subnav">
              <a href="javascript:void(0)"><i class="mdi mdi-attachment"></i> 附件</a>
              <ul class="nav nav-subnav">
                <li> <a href="lyear_js_datepicker.html">附件上传 (学生)</a> </li>
              </ul>
            </li>
            <li class="nav-item nav-item-has-subnav">
              <a href="javascript:void(0)"><i class="mdi mdi-bookmark-outline"></i> 答辩管理</a>
              <ul class="nav nav-subnav">
                <li> <a href="lyear_js_datepicker.html">我的答辩组</a> </li>
              </ul>
            </li>
            <li class="nav-item nav-item-has-subnav">
              <a href="javascript:void(0)"><i class="mdi mdi-scale-balance"></i> 总评</a>
              <ul class="nav nav-subnav">
                <li> <a href="lyear_js_datepicker.html">成绩总评 (学生)</a> </li>
              </ul>
            </li>
          </ul>
        </nav>
        
        <div class="sidebar-footer">
          
        </div>
      </div>
      
    </aside>
    <!--End 左侧导航-->
    
    <!--头部信息-->
    <header class="lyear-layout-header">
      
      <nav class="navbar navbar-default">
        <div class="topbar">
          
          <div class="topbar-left">
            <div class="lyear-aside-toggler">
              <span class="lyear-toggler-bar"></span>
              <span class="lyear-toggler-bar"></span>
              <span class="lyear-toggler-bar"></span>
            </div>
            <span class="navbar-page-title"> 首页 </span>
          </div>
          
          <ul class="topbar-right">
            <li class="dropdown dropdown-profile">
              <a href="javascript:void(0)" data-toggle="dropdown">
                <span style="color:black">${USER.user_name} <span class="caret"></span></span>
              </a>
              <ul class="dropdown-menu dropdown-menu-right">
                <li> <a href="${pageContext.request.contextPath }/topersonInfo.action"><i class="mdi mdi-account"></i> 个人信息</a> </li>
                <li> <a href="lyear_pages_edit_pwd.html"><i class="mdi mdi-lock-outline"></i> 修改密码</a> </li>
                <li> <a href="javascript:void(0)"><i class="mdi mdi-delete"></i> 清空缓存</a></li>
                <li class="divider"></li>
                <li> <a href="${pageContext.request.contextPath }/logout.action"><i class="mdi mdi-logout-variant"></i> 退出登录</a> </li>
              </ul>
            </li>
           
          </ul>
          
        </div>
      </nav>
      
    </header>
    <!--End 头部信息-->
    
    <!--页面主要内容-->
    <main class="lyear-layout-content">
      
      <div class="container-fluid">
        
        <div class="row">
          <div class="col-sm-6 col-lg-3">
            <div class="card bg-primary">
              <div class="card-body clearfix">
                <div class="pull-right">
                  <p class="h6 text-white m-t-0">今日收入</p>
                  <p class="h3 text-white m-b-0">102,125.00</p>
                </div>
                <div class="pull-left"> <span class="img-avatar img-avatar-48 bg-translucent"><i class="mdi mdi-currency-cny fa-1-5x"></i></span> </div>
              </div>
            </div>
          </div>
          
          <div class="col-sm-6 col-lg-3">
            <div class="card bg-danger">
              <div class="card-body clearfix">
                <div class="pull-right">
                  <p class="h6 text-white m-t-0">用户总数</p>
                  <p class="h3 text-white m-b-0">920,000</p>
                </div>
                <div class="pull-left"> <span class="img-avatar img-avatar-48 bg-translucent"><i class="mdi mdi-account fa-1-5x"></i></span> </div>
              </div>
            </div>
          </div>
          
          <div class="col-sm-6 col-lg-3">
            <div class="card bg-success">
              <div class="card-body clearfix">
                <div class="pull-right">
                  <p class="h6 text-white m-t-0">下载总量</p>
                  <p class="h3 text-white m-b-0">34,005,000</p>
                </div>
                <div class="pull-left"> <span class="img-avatar img-avatar-48 bg-translucent"><i class="mdi mdi-arrow-down-bold fa-1-5x"></i></span> </div>
              </div>
            </div>
          </div>
          
          <div class="col-sm-6 col-lg-3">
            <div class="card bg-purple">
              <div class="card-body clearfix">
                <div class="pull-right">
                  <p class="h6 text-white m-t-0">新增留言</p>
                  <p class="h3 text-white m-b-0">153 条</p>
                </div>
                <div class="pull-left"> <span class="img-avatar img-avatar-48 bg-translucent"><i class="mdi mdi-comment-outline fa-1-5x"></i></span> </div>
              </div>
            </div>
          </div>
        </div>
        
        <div class="row">
          
          <div class="col-lg-6"> 
            <div class="card">
              <div class="card-header">
                <h4>每周用户</h4>
              </div>
              <div class="card-body">
                <canvas class="js-chartjs-bars"></canvas>
              </div>
            </div>
          </div>
          
          <div class="col-lg-6"> 
            <div class="card">
              <div class="card-header">
                <h4>交易历史记录</h4>
              </div>
              <div class="card-body">
                <canvas class="js-chartjs-lines"></canvas>
              </div>
            </div>
          </div>
           
        </div>
        
        <div class="row">
          
          <div class="col-lg-12">
            <div class="card">
              <div class="card-header">
                <h4>项目信息</h4>
              </div>
              <div class="card-body">
                <div class="table-responsive">
                  <table class="table table-hover">
                    <thead>
                      <tr>
                        <th>#</th>
                        <th>项目名称</th>
                        <th>开始日期</th>
                        <th>截止日期</th>
                        <th>状态</th>
                        <th>进度</th>
                      </tr>
                    </thead>
                    <tbody>
                      <tr>
                        <td>1</td>
                        <td>设计新主题</td>
                        <td>10/02/2019</td>
                        <td>12/05/2019</td>
                        <td><span class="label label-warning">待定</span></td>
                        <td>
                          <div class="progress progress-striped progress-sm">
                            <div class="progress-bar progress-bar-warning" style="width: 45%;"></div>
                          </div>
                        </td>
                      </tr>
                      <tr>
                        <td>2</td>
                        <td>网站重新设计</td>
                        <td>01/03/2019</td>
                       <td>12/04/2019</td>
                        <td><span class="label label-success">进行中</span></td>
                        <td>
                          <div class="progress progress-striped progress-sm">
                            <div class="progress-bar progress-bar-success" style="width: 30%;"></div>
                          </div>
                        </td>
                      </tr>
                      <tr>
                        <td>3</td>
                        <td>模型设计</td>
                         <td>10/10/2019</td>
                         <td>12/11/2019</td>
                        <td><span class="label label-warning">待定</span></td>
                        <td>
                          <div class="progress progress-striped progress-sm">
                            <div class="progress-bar progress-bar-warning" style="width: 25%;"></div>
                          </div>
                        </td>
                      </tr>
                      <tr>
                        <td>4</td>
                        <td>后台管理系统模板设计</td>
                        <td>25/01/2019</td>
                        <td>09/05/2019</td>
                        <td><span class="label label-success">进行中</span></td>
                        <td>
                          <div class="progress progress-striped progress-sm">
                            <div class="progress-bar progress-bar-success" style="width: 55%;"></div>
                          </div>
                        </td>
                      </tr>
                      <tr>
                        <td>5</td>
                        <td>前端设计</td>
                        <td>10/10/2019</td>
                        <td>12/12/2019</td>
                        <td><span class="label label-danger">未开始</span></td>
                        <td>
                          <div class="progress progress-striped progress-sm">
                            <div class="progress-bar progress-bar-danger" style="width: 0%;"></div>
                          </div>
                        </td>
                      </tr>
                      <tr>
                        <td>6</td>
                        <td>桌面软件测试</td>
                        <td>10/01/2019</td>
                        <td>29/03/2019</td>
                        <td><span class="label label-success">进行中</span></td>
                        <td>
                          <div class="progress progress-striped progress-sm">
                            <div class="progress-bar progress-bar-success" style="width: 75%;"></div>
                          </div>
                        </td>
                      </tr>
                      <tr>
                        <td>7</td>
                        <td>APP改版开发</td>
                        <td>25/02/2019</td>
                        <td>12/05/2019</td>
                        <td><span class="label label-danger">暂停</span></td>
                        <td>
                          <div class="progress progress-striped progress-sm">
                            <div class="progress-bar progress-bar-danger" style="width: 15%;"></div>
                          </div>
                        </td>
                      </tr>
                      <tr>
                        <td>8</td>
                        <td>Logo设计</td>
                        <td>10/02/2019</td>
                        <td>01/03/2019</td>
                        <td><span class="label label-warning">完成</span></td>
                        <td>
                          <div class="progress progress-striped progress-sm">
                            <div class="progress-bar progress-bar-success" style="width: 100%;"></div>
                          </div>
                        </td>
                      </tr>
                    </tbody>
                  </table>
                </div>
              </div>
            </div>
          </div>
          
        </div>
        
      </div>
      
    </main>
    <!--End 页面主要内容-->
  </div>
</div>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/perfect-scrollbar.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/main.min.js"></script>

<!--图表插件-->
<script type="text/javascript" src="js/Chart.js"></script>
<script type="text/javascript">
$(document).ready(function(e) {
    var $dashChartBarsCnt  = jQuery( '.js-chartjs-bars' )[0].getContext( '2d' ),
        $dashChartLinesCnt = jQuery( '.js-chartjs-lines' )[0].getContext( '2d' );
    
    var $dashChartBarsData = {
		labels: ['周一', '周二', '周三', '周四', '周五', '周六', '周日'],
		datasets: [
			{
				label: '注册用户',
                borderWidth: 1,
                borderColor: 'rgba(0,0,0,0)',
				backgroundColor: 'rgba(51,202,185,0.5)',
                hoverBackgroundColor: "rgba(51,202,185,0.7)",
                hoverBorderColor: "rgba(0,0,0,0)",
				data: [2500, 1500, 1200, 3200, 4800, 3500, 1500]
			}
		]
	};
    var $dashChartLinesData = {
		labels: ['2003', '2004', '2005', '2006', '2007', '2008', '2009', '2010', '2011', '2012', '2013', '2014'],
		datasets: [
			{
				label: '交易资金',
				data: [20, 25, 40, 30, 45, 40, 55, 40, 48, 40, 42, 50],
				borderColor: '#358ed7',
				backgroundColor: 'rgba(53, 142, 215, 0.175)',
                borderWidth: 1,
                fill: false,
                lineTension: 0.5
			}
		]
	};
    
    new Chart($dashChartBarsCnt, {
        type: 'bar',
        data: $dashChartBarsData
    });
    
    var myLineChart = new Chart($dashChartLinesCnt, {
        type: 'line',
        data: $dashChartLinesData,
    });
});
</script>
</body>
</html>