<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_OPF_2069.jsp
*@FileTitle : TDR Details
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.03
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2009.09.03 김종옥
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.event.VopOpf2069Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>
<%
	VopOpf2069Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	String rhq = StringUtil.xssFilter(request.getParameter("rhq"));
	String port = StringUtil.xssFilter(request.getParameter("port"));
	String yard = StringUtil.xssFilter(request.getParameter("yard"));
	String lane = StringUtil.xssFilter(request.getParameter("lane"));
	String group_by = StringUtil.xssFilter(request.getParameter("group_by"));
	String from_date = StringUtil.xssFilter(request.getParameter("from_date"));
	String to_date = StringUtil.xssFilter(request.getParameter("to_date"));
	String tml_prod_rpt_rsn_cd = StringUtil.xssFilter(request.getParameter("tml_prod_rpt_rsn_cd"));
	String carr_cd = StringUtil.xssFilter(request.getParameter("carr_cd"));
	String target_lanes = StringUtil.xssFilter(request.getParameter("target_lanes"));
	String target_ports = StringUtil.xssFilter(request.getParameter("target_ports"));

	Logger log = Logger.getLogger("com.hanjin.apps.CargoLoadingResultMgt.TerminalDepartureReport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopOpf2069Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>TDR Details</title>
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
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<input type="hidden" name="rhq" value="<%=rhq%>">
<input type="hidden" name="loc_cd" value="<%=port%>">
<input type="hidden" name="yd_cd" value="<%=yard%>">
<input type="hidden" name="slan_cd" value="<%=lane%>">
<input type="hidden" name="group_by" value="<%=group_by%>">
<input type="hidden" name="from_date" value="<%=from_date%>">
<input type="hidden" name="to_date" value="<%=to_date%>">
<input type="hidden" name="tml_prod_rpt_rsn_cd" value="<%=tml_prod_rpt_rsn_cd%>">
<input type="hidden" name="carr_cd" value="<%=carr_cd%>">
<input type="hidden" name="target_lanes" value="<%=target_lanes%>">
<input type="hidden" name="target_ports" value="<%=target_ports%>">

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr>
	<td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp; TDR Details </td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- Grid BG Box  (S) -->
	   	<table class="search" id="mainTable"> 
	    <tr>
	    	<td class="bg">
	
				<!-- Grid (S) -->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				<!-- Grid (E) -->

				<!-- table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="112">Average per TDR</td>
					<td width=""><input type="text" style="width:88;" class="input" value=" 00000000">&nbsp;<input type="text" style="width:90;" class="input" value=" 00000000">&nbsp;<input type="text" style="width:88;" class="input" value=" 00000000">&nbsp;<input type="text" style="width:88;" class="input" value=" 00000000">&nbsp;<input type="text" style="width:88;" class="input" value=" 00000000">&nbsp;<input type="text" style="width:90;" class="input" value=" 00000000">
					</td>
				</tr>
				</table -->
			
			</td>
		</tr>
		</table>
		<!-- Grid BG Box  (S) -->
		
		<table class="height_5"><tr><td></td></tr></table>
	</td>
</tr>
</table>
			
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr>
	<td height="71" class="popup">
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr>
       		<td class="btn3_bg">
		    	<table border="0" cellpadding="0" cellspacing="0">
		    	<tr>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_Excel">Down Excel</td>
						<td class="btn1_right"></td>
						</tr>
						</table>
					</td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_close">Close</td>
						<td class="btn1_right"></td>
						</tr>
						</table>
					</td>
				</tr>
				</table>
			</td>
		</tr>
		</table>
	</td>
</tr>
</table>	
<!-- : ( Button : pop ) (E) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>