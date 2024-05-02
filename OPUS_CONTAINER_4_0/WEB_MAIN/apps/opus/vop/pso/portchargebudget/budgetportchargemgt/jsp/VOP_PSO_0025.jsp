<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   VOP_PSO_0025.jsp
*@FileTitle  : Budget vs Actual
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/22
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.event.VopPso0025Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopPso0025Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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


		event = (VopPso0025Event)request.getAttribute("Event");
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
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form" >
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		
		<!-- page_title(S) -->
	    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->
	
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button>
			<button type="button" class="btn_normal" name="btn_New" id="btn_New">New</button>
			<button type="button" class="btn_normal" name="btn_Detail" id="btn_Detail">Detail</button>			
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
	<!-- wrap_search(S) -->
	<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
		<!--  MiniLayer (S) -->
		<table>
			<colgroup>
	            <col width="45px" />
	            <col width="195px" />
	            <col width="35px" />
	            <col width="75px" />
	            <col width="65px" />	            
	            <col width="80px" />
	            <col width="30px" />
	            <col width="160px" />
	            <col width="90px" />
	            <col width="90px" />
	            <col width="65px" />
	            <col width="60px" />
	            <col width="" />
			</colgroup>
			<tbody>
				<tr>	
					<th>Rev. Month</th>
					<td>
						<input id="cre_dt_fr"  name="cre_dt_fr" type="text" required dataformat="ym" style="width:60px;ime-mode:disabled;text-align:center;" class="input1" maxlength="6" value="" type="text"><!-- 
						 --><button type="button" id="btns_Calendar1" name="btns_Calendar1" class="calendar ir"></button>~
						<input type="text" id="cre_dt_to"  name="cre_dt_to" dataformat="ym" maxlength="6" style="width:60px;ime-mode:disabled;text-align:center;" class="input1" value="" type="text"><!-- 
						 --><button type="button" id="btns_Calendar2" name="btns_Calendar2" class="calendar ir"></button>
					</td>
					<th>Group</th>
					<td>
						<select id="gubun" name="gubun" style="width:65px;">
							<option value="0" selected>Port</option>
							<option value="1">Lane</option>
						</select>	
					</td>
					<th>Lane Code</th>
					<td>
						<input type="text" id="vsl_slan_cd" name="vsl_slan_cd" dataformat="engup" style="width:40px;text-align:center;" class="input" value="" size="3" maxlength="3" ><!-- 
						 --><button type="button" id="btn_vsl_slan_cd" name="btn_vsl_slan_cd" class="input_seach_btn"></button>
					</td>
					<th>Port</th>
					<td>
						<input id="port_cd"  name="port_cd" type="text" dataformat="engup" style="width:50px;text-align:center;" class="input" value="" size="5" maxlength="5" ><!-- 
						 --><button type="button" id="btn_port_cd" name="btn_port_cd" class="input_seach_btn"></button><!-- 
						  --><script language="javascript">ComComboObject('term_code',2, 60, 1);</script>
					</td>
					<th>Account Code</th>
					<td>
						<script language="javascript">ComComboObject('combo1',2,70,1);</script>
					</td>
					<th>VSL Class</th>
					<td>
						<script language="javascript">ComComboObject('combo2',1,60,1);</script>
					</td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</div>
	</div>
	<!-- wrap_search(E) -->
	<!-- wrap_result(S) -->
	<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <script language="javascript">ComSheetObject('sheet1');</script>
	    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
	<!-- opus_design_grid(E) -->
	</div>
	<!-- wrap_result(E) -->
</form>