<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_JOO_0053.jsp
*@FileTitle : Other VVD Check
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.23
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2009.09.23 박희동
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
<%@ page import="com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.event.FnsJoo0053Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	FnsJoo0053Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.JointOperationAgreementSettlement.CarrierSettlementProcess");

	String vslCd    = "";
	String skdVoyNo = "";
	String skdDirCd = "";
	String revDirCd = "";
	String reDivrCd = "";
	String joCrrCd  = "";
	String rlaneCd  = "";
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (FnsJoo0053Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		vslCd    = request.getParameter("vslCd")    == null ? ""  : StringUtil.xssFilter(request.getParameter("vslCd"));
		skdVoyNo = request.getParameter("skdVoyNo") == null ? ""  : StringUtil.xssFilter(request.getParameter("skdVoyNo"));		
		skdDirCd = request.getParameter("skdDirCd") == null ? ""  : StringUtil.xssFilter(request.getParameter("skdDirCd"));		
		revDirCd = request.getParameter("revDirCd") == null ? ""  : StringUtil.xssFilter(request.getParameter("revDirCd"));		
		reDivrCd = request.getParameter("reDivrCd") == null ? ""  : StringUtil.xssFilter(request.getParameter("reDivrCd"));		
		joCrrCd  = request.getParameter("joCrrCd")  == null ? ""  : StringUtil.xssFilter(request.getParameter("joCrrCd"));		
		rlaneCd  = request.getParameter("rlaneCd")  == null ? ""  : StringUtil.xssFilter(request.getParameter("rlaneCd"));		
		
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
<title>Other VVD Check</title>
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
<input type="hidden" name="vsl_cd"     value="<%=vslCd%>">
<input type="hidden" name="skd_voy_no" value="<%=skdVoyNo%>">
<input type="hidden" name="skd_dir_cd" value="<%=skdDirCd%>">
<input type="hidden" name="rev_dir_cd" value="<%=revDirCd%>">
<input type="hidden" name="re_divr_cd" value="<%=reDivrCd%>">
<input type="hidden" name="jo_crr_cd"  value="<%=joCrrCd%>">
<input type="hidden" name="rlane_cd"   value="<%=rlaneCd%>">
<!-- 개발자 작업	-->
<!-- OUTER - POPUP (S)tart -->
<table width="600" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Manual Settlement </td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">VVD Check</td></tr>
				</table>
			
				<!-- : ( Grid ) (S) -->
					<table width="100%"  id="mainTable">
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet1');</script>
							</td>
						</tr>
					</table>
				<!-- : ( Grid ) (E) -->	
				<!--  biz_1   (E) -->
			</table>
		<table class="height_5"><tr><td></td></tr></table>
	</td></tr>
</table>


	
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td width="72"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close">Close</td>
					<td class="btn1_right"></td>
			</tr>
			</table></td>
			
		</tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table>
</td></tr></table>
<!-- : ( Button : pop ) (E) -->
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>