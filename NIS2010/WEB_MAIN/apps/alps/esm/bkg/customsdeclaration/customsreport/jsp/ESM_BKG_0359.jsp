<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0359.jsp
*@FileTitle : MI Transmit History  for IE
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.13
*@LastModifier : 김도완
*@LastVersion : 1.0
* 2009.05.13 김도완
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.usa.event.EsmBkg0359Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0359Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String vsl_cd		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.BookingCommon.BookingUtil");
	
	String vvdCd = "";
	String polCd = "";
	String podCd = "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmBkg0359Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		//vsl_cd =  JSPUtil.getParameter(request, "searcheKeyOpener");
		
		vvdCd  = JSPUtil.getParameter(request, "vvd_cd");
		polCd  = JSPUtil.getParameter(request, "pol_cd");
		podCd  = JSPUtil.getParameter(request, "pod_cd");
	
		//log.debug("vsl_cd"+vsl_cd);
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title></title>
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

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;padding-right:5;">
	
	
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
	</table>
	<!--Page Title, Historical (E)-->

	
	
		<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
				
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="550">
						<table class="search_sm2" border="0" style="width:95%;"> 
						<tr class="h23">
						 <td width="160"><input type="radio" name="trunkfirst" value="T" class="trans" checked>&nbsp;Trunk&nbsp;&nbsp;<input type="radio" name="trunkfirst" value="S" class="trans">&nbsp;First</td>
					   <td width="35" class="stm">VVD</td>
					   <td width="100"><input type="text" name="vvd" style="width:80;" class="input1" dataformat="eng" maxlength="9" required value="<%=vvdCd%>"></td>
					   <td width="26" class="stm">POL</td>
					   <td width="80"><input type="text" name="pol" style="width:50;" class="input" dataformat="eng" maxlength="5"  value="<%=polCd%>"></td>
					   <td width="26" class="stm">ETA</td>
					   <td width=""><input type="text" name="eta" style="width:95;" class="input2" value="" readonly></td>
					  </tr>
					  </table>
					</td>
					<td width="26">T.POD</td>
					<td width="92"><input type="text" name="pod" style="width:50;" class="input" dataformat="eng" maxlength="5" value="<%=podCd%>"></td>
					<td width="58">B.OFC</td>
					<td width="120">&nbsp;<input type="text" name="bofc" style="width:50;" class="input" dataformat="eng" maxlength="5"></td>
					<td width="55">MF STS</td>
					<td width=""><select style="width:100;" name="blmi">
						<option value="Sent By MI">Sent By MI</option>
						<option value="Added By AI">Added By AI</option>
						<option value="Un-Manifested">Un-Manifested</option>
						<option value="Manifested">Manifested</option>
						<option value="" selected >All</option>
						</select></td>
				</tr></table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="715" align="right">Run Time&nbsp;</td>
					<td width="120"><input type="text" name="runtime" style="width:95;" class="input" value="" readonly></td>
					<td width="">
						<table class="search_sm2" border="0" style="width:100%;"> 
						<tr class="h23">
						<td class="stm"><input type="radio" name="allerror" value="ALL" class="trans" checked>&nbsp;All&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="allerror" value="ERR" class="trans">Error</td></tr>
						</table>
					</td>
				</tr>
				</table>
				<!--  biz_1   (E) -->
				
				</td></tr>
			</table>
			<table class="height_8"><tr><td colspan="8"></td></tr></table>
		
			<!-- Tab (S) -->
     	<table class="tab" border="0" cellpadding="0" cellspacing="0"> 
       	<tr><td><script language="javascript">ComTabObject('tab1')</script></td></tr>
		</table>
		<!-- Tab (E) -->

<!--TAB Manifest Status (S) -->
<div id="tabLayer" style="display:inline">
		
		<!-- Grid BG Box  (S) -->
     	<table class="search" id="mainTable">
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
			<!--  Button_Sub (S) -->
			<table width="100%" class="button"table border="0"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2"  name="btn_Print1">Print</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
				</tr>
				</table>
				
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
			<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="120"><input type="text" name="manifestTotal" style="width:120;" class="input" value=" Manifest TTL [ ]" readonly></td>
					<td width="164">&nbsp;&nbsp;=&nbsp;&nbsp;<input type="text" name="sentByMiCount" style="width:120;" class="input" value=" Sent by MI [ ]" readonly>&nbsp;+</td>
					<td width=""><input type="text" name="addedByAiCount" style="width:120;" class="input" value=" Added by AI [ ]" readonly></td>
				</tr>
				<tr class="h23">
					<td width="120"><input type="text" name="targetTotal" style="width:120;" class="input" value=" Target   TTL [ ]" readonly></td>
					<td width="164">&nbsp;</td>
					<td width=""><input type="text" name="unManifestCount" style="width:120;color:#ff0000;" class="input" value=" Un-Manifest [ ]" readonly></td>
				</tr></table>
			<!--  Button_Sub (S) -->
			
	    	<!-- Button_Sub (E) -->	
				
			</td></tr>
		</table>
</div>
<!--TAB Manifest Status (E) -->

<!--TAB B/L to be deleted (S) -->
<div id="tabLayer" style="display:none">
		<!-- Grid BG Box  (S) -->
     	<table class="search" id="mainTable">
       	<tr><td class="bg">
			
				<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table>
				<!--  Button_Sub (S) -->
			<table width="100%" class="button"table border="0"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_Print2">Print</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
				</tr>
				</table>
				
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->			
			</td></tr>
		</table>
</div>
<!--TAB B/L to be deleted (E) -->

	<!-- Grid BG Box  (S) -->
	<!--biz page (E)-->
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Downexcel">Down&nbsp;Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_BL_Inquiry">B/L Inquiry</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
	</td></tr>
</table>
	

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
