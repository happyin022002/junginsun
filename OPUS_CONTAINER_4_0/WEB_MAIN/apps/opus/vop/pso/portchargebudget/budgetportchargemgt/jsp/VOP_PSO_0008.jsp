<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_PSO_0008.jsp
*@FileTitle  : Budget Creation 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.event.VopPso0008Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopPso0008Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.PortChargeBudget.BudgetPortChargeMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopPso0008Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="year" />

<!-- page(S) -->
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	
	<!-- page_title(S) -->
    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--  
		--><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!--  
		--><button type="button" class="btn_normal" name="btn_down_excel" id="btn_down_excel">Down Excel</button><!--  
		--><button type="button" class="btn_normal" name="btn_creation" id="btn_creation">Creation</td>
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

<!-- opus_design_inquiry(S) -->
<div class="wrap_search">
<div class="opus_design_inquiry wFit">
	<!--  MiniLayer (S) -->
	<table>
		<colgroup>
            <col width="90" />
            <col width="" />
		</colgroup>
		<tbody>
			<tr class="h23">
                <th width="95">Budget Period</th>
				<td width="210">
					<input type="text" name="txtsDate" dataformat="ym" maxlength="6" size="10" style="width:60;" class="input1" value="" type="text"><!-- 
					 --><button type="button" class="calendar ir" name="btns_calendar_s" id="btns_calendar_s"></button><!-- 
					 --><input type="text" name="txteDate" dataformat="ym" maxlength="6" size="10" style="width:60;" class="input1" value="" type="text"><!-- 
					--><button type="button" class="calendar ir" name="btns_calendar_e" id="btns_calendar_e"></button>
				</td>
				<th width="47">Status</th>
				<td width=""><input type="text" name="status" class="input2" readonly/></td>
            </tr>
		</tbody>
	</table>
	<!-- 조회영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
</div>
</div>
<!-- opus_design_inquiry(E) -->

<!-- opus_design_grid(S) -->
<div class="wrap_result">
	<div class="layout_wrap">		
		<div class="layout_vertical_2 pad_rgt_8" style="width:60%">
			<div class="opus_design_grid">
				<!-- opus_grid_btn(S) -->
				<div class="opus_design_btn">
					<button type="button" class="btn_normal" name="btn_upload_excel" id="btn_upload_excel">Upload Excel</button>
				</div>
				<!-- opus_grid_btn(E) -->
			
				<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
			    <script language="javascript">ComSheetObject('sheet1');</script>
			    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
			</div>
	    </div>
	    
	    <div class="layout_vertical_2 pad_rgt_8" style="width:40%">
			<div class="opus_design_grid">
				<!-- opus_grid_btn(S) -->
				<div class="opus_design_btn">
					<button type="button" class="btn_normal" name="btn_upload_excel2" id="btn_upload_excel2">Upload Excel</button>
				</div>
				<!-- opus_grid_btn(E) -->
			
				<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
			    <script language="javascript">ComSheetObject('sheet2');</script>
			    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
			</div>
	    </div>
	</div>
</div>
<!-- opus_design_grid(E) -->
<!-- page(E) -->

</form>