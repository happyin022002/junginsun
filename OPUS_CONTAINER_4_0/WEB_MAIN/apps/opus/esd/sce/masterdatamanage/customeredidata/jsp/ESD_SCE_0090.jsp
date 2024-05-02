<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_SCE_0090.jsp
*@FileTitle  : Vessel Estimation Accunt 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.event.EsdSce0090Event"%>
<%@ page import="com.clt.apps.opus.esd.sce.common.util.basic.CodeUtilBC" %>
<%@ page import="com.clt.apps.opus.esd.sce.common.util.basic.CodeUtilBCImpl" %>

<%
	CodeUtilBC codeUtil = new CodeUtilBCImpl() ;
    EsdSce0090Event  event = null;                			//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;            			//Error on server side.

	String strErrMsg = "";                                  //Error Message
	DBRowSet rowSet      = null;                            //DB ResultSet
	int rowCount     = 0;                                   //DB ResultSet List count

	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	String userId=account.getUsr_id();
	
    try {

    	serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }else{
        	event = (EsdSce0090Event)request.getAttribute("Event");
            
        }//if
    }catch(Exception e) {
        out.println(e.toString());
    }
%>

<script  type="text/javascript">

	function setupPage(){
        loadPage();
        var formObject = document.form ;
    }
</script>

<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="f_user_id" value=<%=userId%>>
<input type="hidden" name="f_group_id">
<input type="hidden" name="f_tp_id">
<input type="hidden" name="f_group_name">
<input type="hidden" name="f_cnt">
<input type="hidden" name="f_cnt1">

<!-- page(S) -->
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	
	<!-- page_title(S) -->
    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
	</div>
	<!-- opus_design_btn(E) -->

   	<!-- page_location(S) -->
   	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
        <span id="navigation"></span>
   	</div>
   	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	
	
	<div class="opus_design_grid">
	<div><h3 class="title_design">My Customer</h3></div>
		<!-- opus_grid_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btng_add1" id="btng_add1">Add</button><!-- 
			--><button type="button" class="btn_normal" name="btn_delete1" id="btn_delete1">Delete</button><!-- 
			--><button type="button" class="btn_normal" name="btn_save1" id="btn_save1">Save</button>
		</div>
		
		<!-- opus_grid_btn(E) -->
		<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <script  type="text/javascript">ComSheetObject('t0sheet');</script>
	    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
	<!-- opus_design_grid(E) -->
	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<div><h3 class="title_design">My Performance Report</h3></div>
		<!-- opus_grid_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btng_add2" id="btng_add2">Add</button><!-- 
			--><button type="button" class="btn_normal" name="btn_delete2" id="btn_delete2">Delete</button><!-- 
			--><button type="button" class="btn_normal" name="btn_save2" id="btn_save2">Save</button>
		</div>
		<!-- opus_grid_btn(E) -->
		
		<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <script  type="text/javascript">ComSheetObject('t1sheet');</script>
	    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
	<!-- opus_design_grid(E) -->
	
	<!-- page(E) -->
</div>
</form>
