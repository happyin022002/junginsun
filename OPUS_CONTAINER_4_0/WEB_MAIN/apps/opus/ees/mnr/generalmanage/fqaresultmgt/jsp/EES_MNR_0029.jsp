<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_0029.jsp
*@FileTitle  : FQA Result Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/21
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.mnr.generalmanage.fqaresultmgt.event.EesMnr0029Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	EesMnr0029Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Occurred error from server
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//Row count of retrieved database data

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd        = "";
	Logger log = Logger.getLogger("com.clt.apps.test.test");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

		event = (EesMnr0029Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		//Extracting retrieved data from server on load screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<title><span id="title"></span></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!--Use a common at MNR  -->
<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
<!-- <body  onLoad="setupPage();"> -->
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="key_value" id="key_value">
<input type="hidden" name="ofc_cd" id="ofc_cd" value="<%=strOfc_cd %>">
<input type="hidden" name="usr" id="usr" value="<%=strUsr_id %>">
<!-- Developer's task	-->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title">
		<button type="button"><span id="title"></span></button>
	</h2>
<!-- page_title(E) -->
<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button>
		<button type="button" class="btn_normal" name="btn_New" id="btn_New">New</button>
		<button type="button" class="btn_normal" name="btn_Save" id="btn_Save">Save</button>
		<button type="button" class="btn_normal" name="btn_Delete" id="btn_Delete">Delete</button>
	</div>
<!-- opus_design_btn(E) -->
<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_location(E) -->
<div class= "wrap_search">
<!-- opus_design_inquiry(S) -->
	<div class= "opus_design_inquiry wFit">
	<table>
		<tbody>
			<colgroup>
				<col width="1px"/>	
				<col width="1px"/>
				<col width="50px"/>
				<col width="1px"/>
				<col width="103px"/>
				<col width="1px"/>
				<col width="1px"/>
				<col width="125px"/>
				<col width="1px"/>
				<col width="1px"/>
				<col width="*" />
			</colgroup>
				<tr>
				<th>S/Provider</th>
				<td><input type="text" style="width:60px;" class="input1" name="vndr_seq" id="vndr_seq" value="" required maxlength="6" dataformat="num"><!--
					--><button type="button" class="input_seach_btn" name="btn_vndr" id="btn_vndr"></button><!--
					--><input type="text" style="width:200px;" class="input2" readOnly name="vndr_lgl_eng_nm" id="vndr_lgl_eng_nm" ></td>
				<th>Yard</th>
				<td></td>
			    <td><input type="text" style="width:60px;" class="input1" name="yd_cd" id="yd_cd" value="" required fullfill type="text"  dataformat="engup" maxlength="7"><!--
			    	--><button type="button" class="input_seach_btn" name="btn_yd" id="btn_yd"></button>
		    	</td>
				<th>Audit Date</th>
				<td></td>
				<td><input type="text" style="width:80px;" class="input1" name="fld_aud_dt" required dataformat="ymd" maxlength="10"><!--
					--><button type="button" class="calendar ir" name="calendar" id="calendar"></button>
				</td>
				<th>Audit  Result History</th>
				<td></td>
				<td><script type="text/javascript">ComComboObject('aud_rslt_his',2, 80 ,1,1,1)</script></td>
				</tr>
		</tbody>
	</table>
</div>
</div>
<div class="wrap_result">
<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear" >
	<h3 style="margin-bottom:0" class="title_design mar_btm_8"> Field Quality Audit Result</h3>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
<!-- opus_design_grid(E) -->
<div style="width: 37.5%;float: left"> 
<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear" >
	<div class="opus_design_btn">		
			<button type="button" class="btn_normal" name="btn_RowAdd" id="btn_RowAdd">Row Add</button>
			<button type="button" class="btn_normal" name="btn_RowDel" id="btn_RowDel">Row Delete</button>
	</div>
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
<!-- opus_design_grid(E) -->
</div>
<div style="width:300px;float: right"> 
<div style="height: 5px;">&nbsp;</div>	
	<div class="opus_design_data">
	<table>
		<tbody>
			<colgroup>
				<col width="*"/>	
				<col width="20px"/>		
				
			</colgroup>
				<tr>
				<th>Total Performance Score by 100% Point</th>
				<td><input type="text" style="width:40px; text-align:right;" class="input2" readOnly name="total" id="total" value=""></td>
				</tr>
		</tbody>
	</table>
</div>
</div>
</div>
<div style="display:none">
	<script type="text/javascript">ComUploadObject('upload1', '<%=session.getId()%>');</script>
</div>
</form>
