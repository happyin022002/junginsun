<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ESD_EAS_0222.jsp
*@FileTitle : EAC Rejection Notice History
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.15
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2014.12.15 백형인
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
<%@ page import="com.hanjin.apps.alps.esd.eas.eac.eacmgt.event.EsdEas0222Event"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>

<%
	EsdEas0222Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지

	String pageRows  = "100";

	// SignOnUserAccount Info
	String usr_id 					= "";
	String strUsr_nm				= "";
	String ofc_cd					= "";
	String eac_no				= StringUtil.xssFilter(request.getParameter("EAC_NO"))!=null&&!StringUtil.xssFilter(request.getParameter("EAC_NO")).equals("")?StringUtil.xssFilter(request.getParameter("EAC_NO")):""; 
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_nm 			= account.getUsr_nm();
		usr_id       		= account.getUsr_id();      
		ofc_cd      		= account.getOfc_cd();    


		event = (EsdEas0222Event)request.getAttribute("Event");
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
<title>EAC Rejection Notice History</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>
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

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="eac_no" 		    value = "<%=eac_no%>">
<input type="hidden" name="usr_id" 		    value = "<%=usr_id%>">
<input type="hidden" name="ofc_cd" 		    value = "<%=ofc_cd%>">

<!-- 개발자 작업	-->
<table width="100%" class="popup" cellpadding="10">
	<tr><td class="top"></td></tr>
	<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;EAC Rejection Notice History</td></tr>
		</table>
		<!-- : ( Title ) (E) -->

			
		<!--Button (S) -->
	    <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top: 0; padding-bottom: 2;">
		<tr>
			<td class="btn1_bg">
				<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1" name="btng_print" >Print</td>
							<td class="btn1_right"></td>
						</tr>
						</table>
					</td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1" name="btng_close">Close</td>
							<td class="btn1_right"></td>
						</tr>
						</table>
					</td>

				</tr>
				</table>
			</td>
		</tr>
		</table>
		<!--Button (E) -->
		 
		<!--biz page (S)-->
		<table class="search" > 
       	<tr><td class="bg">		
			<!-- biz_1  (S) -->
			<table class="search" border="0" style="width: 979;">
				<tr class="h23">
					
					<td width="100">No. of notice</td>
					<td width="70">
						<script language="javascript">ComComboObject('s_ntc_knt_cd',1,100,1,0,0);</script>
					</td>
					<td width="809"></td>
				</tr>
			</table>
			</td>
		</tr>
	</table>

	<!-- TABLE '#D' : ( Search Options ) (S) -->
			<table class="search"><tr><td class="height_10"></td></tr></table>
    	<table class="search">
      	<tr><td class="bg">


			<!-- TABLE '#E' : ( Graph BG ) (S) -->
	     	<table border="1" style="width:100%;text-align:center;" height="520" class="grid" >
	       	<tr><td>
				<script language='javascript'>comRdObject('report1');</script>
				</td></tr>
			</table>
			<!-- TABLE '#E' : ( Graph BG ) (E) -->

			<!-- : ( Seq. ) (S) -->
             <table width="100%" id="mainTable">
                <tr><td>
                     <script language="javascript">ComSheetObject('sheet1');</script>
                </td></tr>
             </table>
			<!-- : ( Seq. ) (E) -->

		</td></tr>
	</table>
	<!-- TABLE '#D' : ( Search Options ) (E) -->

<!-- 개발자 작업  끝 -->
			</td>
		</tr>
	</table>
</form>
</body>
</html>