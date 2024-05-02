<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_TOT_0031.jsp
*@FileTitle : TOT
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.22
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.11.22 김영오
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="java.util.Collection" %>
<%@ page import="com.hanjin.framework.component.util.code.CodeInfo" %>
<%@ page import="com.hanjin.bizcommon.util.BizComUtil" %>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>
<%@ page import="com.hanjin.framework.component.util.DateTime" %>
<%@ page import="com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.event.FnsTot0031Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	FnsTot0031Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";

	String stl_yrmon	= "";
	String stl_yr	= "";
	String stl_mn	= "";
	String trd_cd	= "";
	String vsl_cd	= "";
	String modify_yn	= "";
	String stlClzFlg		= "";
	int last_day = 0;
	Logger log = Logger.getLogger("com.hanjin.apps.TonnageTaxOutput.TonnageTaxOutputMasterDataMgt");

	if(request.getParameter("stl_yrmon")!=null) {
		stl_yrmon 	= JSPUtil.replaceForHTML(request.getParameter("stl_yrmon"));
		stl_yr = stl_yrmon.substring(0,4);
		stl_mn = stl_yrmon.substring(5,7);
	}	
	
	last_day = DateTime.lastDay( Integer.parseInt(stl_yr), Integer.parseInt(stl_mn));
	
	if(request.getParameter("trd_cd")!=null) {
		trd_cd 	= JSPUtil.replaceForHTML(request.getParameter("trd_cd"));
	}	

	if(request.getParameter("vsl_cd")!=null) {
		vsl_cd 	= JSPUtil.replaceForHTML(request.getParameter("vsl_cd"));
	}	
	
	if(request.getParameter("modify_yn")!=null) {
		//modify_yn 	= request.getParameter("modify_yn");
	}	

	
	// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
	GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	
	stlClzFlg = eventResponse.getETCData("stlClzFlg" );

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (FnsTot0031Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
	             strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}


	}catch(Exception e) {
		out.println(e.toString());
	}


%>
<html>
<head>
<title>TOT</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
	
		loadPage("<%=stlClzFlg%>");
	}
	function closePage(){

		unloadPage();
	}
</script>
</head>

<body class="popup_bg" onLoad="setupPage();"  onunLoad="closePage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="stl_yrmon" value ="<%=stl_yrmon%>">
<input type="hidden" name="stl_yr" value ="<%=stl_yr%>">
<input type="hidden" name="last_day" value ="<%=last_day%>">
<input type="hidden" name="trd_cd" value ="<%=trd_cd%>">
<input type="hidden" name="vsl_cd" value ="<%=vsl_cd%>">
<input type="hidden" name="modify_yn" value ="<%=modify_yn%>">
<!-- 개발자 작업	-->

	<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Inquiry VSL Owner/Charter by Detail</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
	
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
				
			<!-- Grid  (S) -->
			
			<div id="tabLayer" style="display:inline">	
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>

			</div>		

			<!-- Grid (E) -->

			<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_Down_Excel">Down Excel</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
					</tr></table>
			</td></tr>
			</table>
	    		<!-- Button_Sub (E) -->
			</td></tr>
		</table>
		<table class="height_5"><tr><td></td></tr></table>
<!-- : ( Search Options ) (E) -->
</td></tr>
</table> 


	
	    	<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

    	<!--Button (S) -->	
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
	    	
	<!-- Tab BG Box  (S) -->
	<!--biz page (E)-->

<!-- 개발자 작업  끝 -->
</form>

</body>
<%@include file="/bizcommon/include/common_nis2010.jsp"%>
</html>
