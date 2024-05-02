<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ui_bkg_0492.jsp
*@FileTitle : Sri Lanka Customs Manifest_Customs Response
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.03
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.05.27 임재택
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String sr_sts_cd    	= "";
	String vsl_auth_no		= "";
	String rgst_dt			= "";
	String rjct_dt			= "";
	String decl_bl_qty	    = "";
	String sr_sts_desc 		= "";
	String sr_cmt_desc		= "";
	 
	Logger log = Logger.getLogger("com.hanjin.apps.CustomsDeclaration.ManifestListDownload");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		sr_sts_cd = request.getParameter("sr_sts_cd")==null?"":request.getParameter("sr_sts_cd");
		vsl_auth_no = request.getParameter("vsl_auth_no")==null?"":request.getParameter("vsl_auth_no");
		rgst_dt = request.getParameter("rgst_dt")==null?"":request.getParameter("rgst_dt");
		rjct_dt = request.getParameter("rjct_dt")==null?"":request.getParameter("rjct_dt");
		decl_bl_qty = request.getParameter("decl_bl_qty")==null?"":request.getParameter("decl_bl_qty");
		sr_sts_desc = request.getParameter("sr_sts_desc")==null?"":request.getParameter("sr_sts_desc");
		 
		sr_cmt_desc = request.getParameter("sr_cmt_desc")==null?"":request.getParameter("sr_cmt_desc");
		 
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		//GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		 //http//127.0.0.1:7001/hanjin/nis2010Main.screen?pgmNo=ESM_BKG_M001&url=^hanjin^ESM_BKG_0013.do&id=ESM_BKG_0013 						 

	}catch(Exception e) {
		out.println(e.toString());
	}
	
%>
<html>
<head>
<title>Sri Lanka Customs Manifest_Customs Response</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body class="popup_bg" onLoad="setupPage();">
<form name="form" method="post">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pgNo">
<input type="hidden" name="pagerows">
<input type="hidden" name="frm_attr_ctnt2">
<input type="hidden" name="vsl_cd"> 
<input type="hidden" name="skd_voy_no"> 
<input type="hidden" name="skd_dir_cd">
<input type="hidden" name="vvd_nm">
<input type="hidden" name="sr_sts_cd">
<input type="hidden" name="rgst_dt">
<input type="hidden" name="rjct_dt">
<input type="hidden" name="vsl_auth_no">
<input type="hidden" name="sr_sts_desc">
<input type="hidden" name="sr_cmt_desc">
<input type="hidden" name="decl_bl_qty">
<!-- 개발자 작업	-->

<table width="100%" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"> Sri Lanka Customs Manifest_Customs Response</td></tr>
		</table>	
		<!-- : ( Title ) (E) -->

		<!--biz page (S)-->
		<table class="search" id="mainTable">
       		<tr><td class="bg">


				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">View  Sri  Lanka  Customs  Response</td></tr>
				<tr><td class="height_5"></td></tr>
				</table>

				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:100%;">
				<tr class="h23">
					<td width="130">Status</td>
					<td><input type="text" style="width:230;" class="input" value="<%=sr_sts_cd%>" readonly></td></tr>
				<tr class="h23">
					<td>Vessel Auth No.</td>
					<td><input type="text" style="width:230;" class="input" value="<%=vsl_auth_no%>" readonly></td></tr>
				<tr class="h23">
					<td>Registered Date</td>
					<td><input type="text" style="width:230;" class="input" value="<%=rgst_dt%>" readonly></td></tr>
				<tr class="h23">
					<td>Rejected Date</td>
					<td><input type="text" style="width:230;" class="input" value="<%=rjct_dt%>" readonly></td></tr>
				<tr class="h23">
					<td>B/L Count</td>
					<td><input type="text" style="width:80; text-align:right;" class="input" value="<%=decl_bl_qty%>" readonly></td></tr>
				<tr><td colspan="2" height="8"></td></tr>
				<tr class="h23">
					<td>Status Description</td>
					<td><textarea style="width:230; height:50;" readonly><%=sr_sts_desc%></textarea></td></tr>
				<tr class="h23">
					<td>Comment</td>
					<td><textarea style="width:230; height:50;" readonly><%=sr_cmt_desc%></textarea></td></tr>
				</table>
				<!--  biz_1   (E) -->


		</td></tr></table>
		<!--biz page (E)-->

<table class="height_5"><tr><td></td></tr></table>

</td></tr></table>

<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr> 				 
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Close">Close</td>
					<td class="btn1_right"></td>
				</tr></table></td>
			</tr>
		</table></td>
			</tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table>   	 
<!-- : ( Button : pop ) (E) -->

</form>
</body>
</html>