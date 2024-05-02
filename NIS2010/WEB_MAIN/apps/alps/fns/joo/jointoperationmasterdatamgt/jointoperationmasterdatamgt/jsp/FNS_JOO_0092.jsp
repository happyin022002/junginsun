<%
/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FNS_JOO_0092.jsp
*@FileTitle : BSA Information Entry History
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.30
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.12.30 김영오
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.event.FnsJoo0092Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	FnsJoo0092Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String vvdPort = StringUtil.xssFilter(request.getParameter("vvdPort"));

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.JointOperationMasterDataMgt.JointOperationMasterDataMgt");
	String crrCdList = "";
	String trdCdList = "";
	String ofcCdList = "";
	String joSrcList = "";
	String joSrcNmList = "";
	String joBkgTpList = "";
	String joBkgTpNmList = "";
	String trdLaneCrrList = "";
	String direction = "";
	String strToyyyyMMdd = "";
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (FnsJoo0092Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		crrCdList      = eventResponse.getETCData("CRR_CD_LIST");
		trdCdList      = eventResponse.getETCData("TRD_CD_LIST");
		ofcCdList	   = eventResponse.getETCData("OFC_CD");
		joSrcList      = eventResponse.getETCData("JO_SRC_CD");
		joSrcNmList    = eventResponse.getETCData("JO_SRC_NM");
		joBkgTpList    = eventResponse.getETCData("JO_BKG_TP_CD");
		joBkgTpNmList  = eventResponse.getETCData("JO_BKG_TP_NM");
		trdLaneCrrList = eventResponse.getETCData("TRD_LANE_CRR_LIST");
		strToyyyyMMdd = DateTime.getFormatDate(JSPUtil.getKST("yyyyMMdd"), "yyyyMMdd", "yyyy-MM-dd");
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Basic Information for Loading Summary</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
var gUsrId = "<%=strUsr_id%>";
var gUsrNm = "<%=strUsr_nm%>";
var gCrrCd = "<%=crrCdList%>";
var gTrdCd = "<%=trdCdList%>";
var gOfcCd = "<%=ofcCdList%>";
var nJoSrcCd = "";
var gJoSrcCd = ("<%=joSrcList%>").split("|");
var gJoSrcNm = ("<%=joSrcNmList%>").split("|");
var gJoBkgTpCd = ("<%=joBkgTpList%>").split("|");
var gJoBkgTpNm = ("<%=joBkgTpNmList%>").split("|");
var gTrdLaneCrr = "<%=trdLaneCrrList%>";
//alert("<%=direction%>");
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<input type="hidden" name="vvd_port" value="<%=vvdPort%>">
<!-- 개발자 작업	-->
<table width="100%" class="popup" cellpadding="10" border="0">
	<tr>
		
		
		<td valign="top"><!-- : ( Title ) (S) -->
		<table width="100%" border="0">
			<tr>
				<td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp; BSA Information Entry History</td>
			</tr>
		</table>
	
		<!-- Tab BG Box  (S) -->
     	<table class="search"> 
       	<tr><td class="bg">
			<!-- Grid  (S) --> 
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table> 	
			<!-- Grid (E) -->
			</td></tr>
		</table>
	<!-- Tab BG Box  (S) -->
	
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_downexcel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_close">Close</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
		</table>
    <!--Button (E) -->
	</td></tr>
</table></td></tr></table>
<!-- Copyright (S) -->
<!-- 개발자 작업  끝 -->
</form>
</body>
</html> 