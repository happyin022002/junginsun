<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CGM_1142.jsp
*@FileTitle : Pool Chassis Comparison Detailed
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.cgm.movementmnrhistory.poolchassishistory.event.EesCgm1142Event"%>
<%@ page import="com.clt.framework.component.util.StringUtil" %>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesCgm1142Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.MovementMnrHistory.PoolChassisHistory");
	
	String mvmt_dt         = "";
	String chss_pool_cd    = "";
	String chss_ownr_co_cd = "";
	String cntr_ownr_co_cd = "";
	String gubun           = "";
    String chss_pool_nm    = "";
    String pool_mgmt_co_nm = "";
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesCgm1142Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		mvmt_dt          = StringUtil.xssFilter(request.getParameter("mvmt_dt"));
		chss_pool_cd     = StringUtil.xssFilter(request.getParameter("chss_pool_cd"));
		chss_ownr_co_cd  = StringUtil.xssFilter(request.getParameter("chss_ownr_co_cd"));
		cntr_ownr_co_cd  = StringUtil.xssFilter(request.getParameter("cntr_ownr_co_cd"));
		gubun            = StringUtil.xssFilter(request.getParameter("gubun"));
		chss_pool_nm     = StringUtil.xssFilter(request.getParameter("chss_pool_nm"));
		pool_mgmt_co_nm  = StringUtil.xssFilter(request.getParameter("pool_mgmt_co_nm"));
		
		if(chss_pool_cd == null){
			chss_pool_cd = "";
		}
		
		if(mvmt_dt == null){
			mvmt_dt = "";
		}

		// adding logic to get data from server when first loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
 
%>

<head>
<title>Pool Chassis Comparision Detail</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="chss_ownr_co_cd" value="<%=chss_ownr_co_cd %>">
<input type="hidden" name="cntr_ownr_co_cd" value="<%=cntr_ownr_co_cd %>">
<input type="hidden" name="gubun" value="<%=gubun %>">
<!-- developer working -->
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title" style="padding-left: 0px;"><span>Pool Chassis Comparison Detail</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button class="btn_normal" name="btn_downexcel" id="btn_downexcel" type="button">Down Excel</button>
			<button class="btn_normal" name="btn_close" id="btn_close" type="button">Close</button>
		</div>
		<!-- opus_design_btn (E) -->
	</div>
</div>

<div class="layer_popup_contents">
	<div class= "wrap_search">
		<div class= "opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="50" />
					<col width="350" />
					<col width="60" />
					<col width="70" />
					<col width="50" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr>
						<th>Pool</th>
						<td><input type="text" style="width:80px" class="input1" name="chss_pool_cd" value="<%=chss_pool_cd %>" readonly="readonly">&nbsp; 
					                <input type="text" style="width:260px" class="input2" name="chss_pool_nm" value="<%=chss_pool_nm %>" readonly="readonly"></td>
						<th>MGMT</th>
						<td><input type="text" style="width:230px" class="input2" name="pool_mgmt_co_nm" value="<%=pool_mgmt_co_nm %>" readonly="readonly"></td>
						<th>Month</th>
						<td><input type="text" style="width:80px" class="input1" name="mvmt_dt" value="<%=mvmt_dt%>" readonly="readonly"></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<div class="wrap_result">
		<div class="opus_design_grid clear" id="mainTable" >
			<table class="height_8"><tr><td></td></tr></table>
			<script language="javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>

</div>
<!-- developer working end -->
</form>
</body>
