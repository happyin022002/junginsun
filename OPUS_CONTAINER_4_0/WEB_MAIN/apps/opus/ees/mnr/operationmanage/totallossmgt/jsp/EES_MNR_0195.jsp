<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_0195.jsp
*@FileTitle  : Total Loss No Inquiry_Pop Up
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/24
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.mnr.operationmanage.totallossmgt.event.EesMnr0195Event"%>
<%@ page import="com.clt.framework.component.util.StringUtil" %>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMnr0195Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Occurred error from server
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//Row count of retrieved database data

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	if(request.getParameter("ofc_cd")!=null && !request.getParameter("ofc_cd").equals("")) {
		strOfc_cd = StringUtil.xssFilter(request.getParameter("ofc_cd"));
	}

	Logger log = Logger.getLogger("com.clt.apps.AgreementManage.TariffMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

		if(strOfc_cd.equals("")||strOfc_cd==null) {
			strOfc_cd = account.getOfc_cd();
		}

		event = (EesMnr0195Event)request.getAttribute("Event");
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



<script type="text/javascript">
	var rqstOfcCd = "<%= strOfc_cd%>";
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
<input type="hidden" name="work_type" id="work_type" />
<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><span>Total Loss No Inquiry</span></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" 	id="btbtn_Retrieven1_Retrieve">Retrieve</button><!--  
		--><button type="button" class="btn_normal" name="btn_New" 	id="btn_New">New</button><!--  
		--><button type="button" class="btn_normal" name="btn_OK" 	id="btn_OK">OK</button><!-- 
		--><button type="button" class="btn_normal" name="btn_Close" 	id="btn_Close">Close</button><!--  
	--></div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->
<div class= "wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="70" />
				<col width="90" />
				<col width="100" />
				<col width="20" />
				<col width="65" />
				<col width="*" />
			</colgroup>
			<tbody>
				<tr>
					<th>Office</th>
					<td><input type="text" name="rqst_ofc_cd" style="width:50px;" class="input2" readonly="true" id="rqst_ofc_cd" /> </td>
					<th>Creation Period</th>
					<td><input type="text" name="rqst_dt_fr" style="width:75px;text-align:center" class="input" caption="from date" dataformat="ymd" maxlength="10" cofield="rqst_dt_to" id="rqst_dt_fr" />~ <input type="text" name="rqst_dt_to" style="width:75px;;text-align:center" class="input" caption="to date" requred="" dataformat="ymd" maxlength="10" cofield="rqst_dt_fr" id="rqst_dt_to" /><button type="button" id="rqst_dt_cal" name="rqst_dt_cal" class="calendar ir"></button></td>
					<th>EQ No.</th>
					<td><input type="text" name="rqst_eq_no" style="width:100px;" class="input" required dataformat="engup" id="rqst_eq_no" /> </td>
				</tr>
			</tbody>
		</table>
		<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
	</div>
</div>			
<div class="wrap_result">
	<div class="opus_design_grid clear" id="mainTable">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>	
</form>


<%@include file="/bizcommon/include/common_opus.jsp" %>