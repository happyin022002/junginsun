<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_SPC_0081.jsp
*@FileTitle  : Loading by POL/POD
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/22
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.event.EsmSpc0081Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmSpc0081Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.Spacecontrolinquiry.Spacecontrolinquiry");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	
		event = (EsmSpc0081Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		//out.println(e.toString());
		out.println("<!--"+e.toString()+"-->");
	}
	
%>
<title>RDR Detail Data</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="uiname" value="ESM_SPC_0081" id="uiname" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_retrieve" id="btn_retrieve" type="button" title="Alt+R">Retrieve</button><!--
		--><button class="btn_normal" name="btn_new" id="btn_new" type="button" title="Alt+N">New</button><!--
		--><button class="btn_normal" name="btn_downexcel" id="btn_downexcel" type="button">Down Excel</button><!--
		--><button class="btn_normal" name="btn_bsa" id="btn_bsa" type="button" title="Alt+B">BSA Input</button><!--
		--></div>
	<!-- opus_design_btn (E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="70" />				
				<col width="150" />				
				<col width="70" />				
				<col width="100" />				
				<col width="70" />	
				<col width="100" />	
				<col width="70" />	
				<col width="100" />
				<col width="70" />	
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
		   			<th>Start Week</th>
					<td><!-- 
					--><select class="input1" name="year" id="year" style="width:65px;" onchange="checkWeek();"></select><!-- 
					--><select class="input1" name="week" id="week" style="width:55px;"></select><!-- 
					--></td>
					<th>Duration</th>
					<td><!-- 
					--><select class="input1" name="duration" id="duration" size="1"></select><!-- 
					--></td>
					<th>Trade</th>
					<td><script type="text/javascript">ComComboObject("trade", 2, 60, 0, 1);</script></td>
					<th>Sub Trade</th>
					<td><script type="text/javascript">ComComboObject("subtrade", 3, 60, 0, 0);</script></td>
					<th>Lane</th>
					<td><script type="text/javascript">ComComboObject("rlane_cd", 4, 70, 0, 0);</script></td>
		   		</tr>
		   </tbody>
		</table>
		<table>
			<colgroup>
				<col width="70" />				
				<col width="150" />				
				<col width="70" />				
				<col width="100" />				
				<col width="70" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
		   			<th>RHQ</th>
					<td><!-- 
					--><select class="input1" name="rhq" id="rhq"><!-- 
						--><option value=""></option><!-- 
						--><option value="A">SHAAS, SINWA</option><!-- 
						--><option value="M">NYCNA</option><!-- 
						--><option value="E">HAMUR</option><!-- 
						--><option value="F">AFRICA</option><!-- 
						--><option value="O">OTHER</option><!-- 
					--></select><!-- 
					--></td>
					<th>Bound</th>
					<td><select name="bound" id="bound"></select></td>
					<th>Carrier</th>
					<td><script type="text/javascript">ComComboObject('operator',1,60,0);</script></td>
		   		</tr>
		   </tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<table>
			<colgroup>
				<col width="*" />
			</colgroup>
			<tbody>
				<tr>
					<td style="text-align: right" class="pad_btm_4 pad_rgt_4">Unit : TEU</td>
				</tr>
			</tbody>
		</table>
		<script type="text/javascript">ComSheetObject('sheet1');</script>		
	</div>
	<!-- opus_design_grid(E) -->
</div>

</form>