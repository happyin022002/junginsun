<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0271.jsp
*@FileTitle : Onsite Inspection Result Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.21
*@LastModifier : 이율규
*@LastVersion : 1.0
* 2015.07.21 이율규
* 1.0 Creation
=========================================================*/
%>

<%@ include file="/bizcommon/include/common_alps.jsp" %>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.mnr.generalmanage.onsiteinspectionresultmgt.event.EesMnr0271Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	EesMnr0271Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd        = "";
	String rhqOfcCd         = "";
	
	Logger log = Logger.getLogger("com.hanjin.apps.test.test");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		rhqOfcCd  = account.getRhq_ofc_cd();
		
		event = (EesMnr0271Event)request.getAttribute("Event");
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
<title><span id="title"></span></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!--MNR 공용 사용  -->       
<script language="javascript">   
	var currOfcCd = '<%=strOfc_cd %>';
	var rhqOfcCd  = '<%=rhqOfcCd %>';
	
	parent.window.moveTo(0,0);
	var screen_width = (window.screen.width)-100;
	var screen_height = (window.screen.height)-30;
	
	parent.window.resizeTo(screen_width,screen_height);
	
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
<input type="hidden" name="key_value">  
<input type="hidden" name="insp_ofc_cd" value="<%=strOfc_cd %>">
<input type="hidden" name="rhq_ofc_cd" value="">
<input type="hidden" name="usr_id" value="<%=strUsr_id %>">
<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">

	<tr><td valign="top">
        <!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		    <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table> 
		<!--Page Title, Historical (E)-->        

		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
       	<tr><td class="btn1_bg">
		
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				</tr>
			</table>
		</td></tr>
		</table>
    	<!--Button (E) -->
	
		<!--biz page (S)-->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
			
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="88">Regional HQ</td>
					<td width="100"><script language="javascript">ComComboObject('combo1',2, 90 , 0);</script></td>
					<td width="110">Operation Office</td>
					<td width="90"><script language="javascript">ComComboObject('combo2',2, 80 , 0,'','',0,'');</script></td>
					<td width="60">Year</td>
					<td width="200">
					<input type="text" maxlength="4" style="width:40;text-align:center;ime-mode:disabled;" class="input1" name="insp_yr" onKeyPress="javascript:ComKeyOnlyNumber(this);" value="<%=JSPUtil.getKST("yyyy")%>" required fullfill caption="Plan Year">
                  <img name ="btn_fr_yy" src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
					<!-- <input name="insp_yr" type="text" style="width:60;" class="input" maxlength="6" dataformat="engup"> --></td>
					<td width="40">S/P</td>
					<td width=""><input name="vndr_seq" type="text" style="width:60;" class="input" maxlength="6" dataformat="engup">&nbsp;<img name="sProvider" src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">&nbsp;<input name="vndr_lgl_eng_nm" type="text" style="width:200;"  class="input2" readOnly="true"></td>
				</tr> 
				
				</table>				
				<!--  biz_1   (E) -->
			
		</td></tr></table>
		<table class="height_8"><tr><td></td></tr></table>
        <table class="tab" border="0" cellpadding="0" cellspacing="0" width="100%"> 
       		<tr><td width="100%">
				<script language="javascript">ComTabObject('tab1')</script>
		    </td></tr>
		</table>
<div id="tabLayer" style="display:inline">
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">	

			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t1sheet1');</script>
						</td>
					</tr>
				</table>
			<!-- Grid (E) -->	
			
			<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
				<tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button" >
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_Detail">Detail(s)</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_DownExcel">Down Excel</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
			
			</td></tr>
		</table>
		<!--biz page (E)-->
</div>
<div id="tabLayer" style="display:none">
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">	

			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t2sheet1');</script>
						</td>
					</tr>
				</table>
			<!-- Grid (E) -->	
			
			<!--  Button_Sub (S) -->
 			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
				<tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn2_DownExcel">Down Excel</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					</tr></table>
			</td></tr>
			</table> 
	    	<!-- Button_Sub (E) -->
			
			</td></tr>
		</table>
		<!--biz page (E)-->
</div>

	</td></tr>
		</table>  

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>