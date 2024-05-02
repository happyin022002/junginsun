<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_vsk_0044.jsp
*@FileTitle : Vessel Code Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.12
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.05.19 유혁
* 1.0 Creation
*
* History
* 2011.04.11 진마리아 CHM-201109577-01 Delete Vessel Code에 대한 조회 로직 보완
* 2012.04.02 진마리아 CHM-201217105-01 Local Vessel name 칼럼 추가 요청건
* 2012.04.12 진마리아 CHM-201217105-01 MDM Vessel Delete 여부를 조회조건 및 결과에 추가 및 paging처리
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.event.VopVsk0044Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopVsk0044Event event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
//	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.vskCommon.vskcodefinder");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (VopVsk0044Event)request.getAttribute("Event");
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
<title>Vessel Code Inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">

    function setupPage(){  

	    loadPage();
    }

</script>
</head>

<body  onLoad="setupPage();"> 

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows" value="500">
<input type="hidden" name="page_no" value="1">

<input type="hidden" name="tmp_vsl_cd" value="">
<input type="hidden" name="tmp_crr_cd" value="">
<!-- <input type="hidden" name="inc_del_vsl" value="Y"> -->

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
					<td width="80">Vessel Code</td>
					<td width="70"><input type="text" style="width:50;ime-mode:disabled" class="input" name="vsl_cd" value="" maxlength="4" tabindex="1"><!--&nbsp;<img class="cursor" src="img/btns_search.gif" name="btn_popup_vsl_cd" width="19" height="20" border="0" align="absmiddle"> --></td>
					<td width="80">Vessel Name</td>
					<td width="280"><input type="text" style="width:260;ime-mode:disabled" class="input" name="vsl_eng_nm" maxlength="50" value="" tabindex="2"></td>
					<td width="80">China Name</td>
					<td width="170"><input type="text" style="width:150;ime-mode:disabled" class="input" name="vsl_locl_nm" maxlength="15" value="" tabindex="2"></td>
					<td width="">
						<table border="0" style="width:200;" class="search_sm2"> 
						<tr class="h23"><td><input type="radio" value="A" name='fdr_div_cd' class="trans" tabindex="3" checked> All &nbsp;&nbsp;<input type="radio" value="T" name='fdr_div_cd' class="trans" tabindex="4"> Trunk&nbsp;&nbsp;<input type="radio" value="O" name='fdr_div_cd' class="trans" tabindex="5"> Feeder </td>	
						</tr></table></td>
				</tr>
				</table>
				<table class="search" border="0" style="width:979;">
				<tr class="h23">
					<td width="80">Carrier Code</td>
					<td width="90"><input type="text" style="width:50;ime-mode:disabled" class="input" name="crr_cd" maxlength="3" tabindex="6">&nbsp;<img class="cursor" src="img/btns_search.gif" name="btn_popup_crr_cd" width="19" height="20" border="0" align="absmiddle"></td>
					<td width="60">Call Sign</td>
					<td width="300"><input type="text" style="width:150;ime-mode:disabled" class="input" name="call_sgn_no" value="" maxlength="15"></td>
					<td width="60">IMO No.</td>
					<td width="249"><input type="text" style="width:150;ime-mode:disabled" class="input" name="lloyd_no" value="" maxlength="20"></td>
					<td width="50">Delete</td>
					<td width="90">
						<select style="width:60;" name="inc_del_vsl">
							<option value="D">Y</option>
							<option value="" selected>N</option>
							<option value="Y">All</option>
						</select>
					</td>
				</tr>
				</table>
				<!--  biz_1   (E) -->
				<table class="line_bluedot"><tr><td></td></tr></table>
				<!--  biz_2  (S) -->
				
				<!-- Grid  (S) -->
					<table width="100%" id="mainTable"> 
						<tr>
							<td width="100%">
								<!--시트-->
								<script language="javascript">ComSheetObject('sheet1');</script>
							</td>
						</tr>
					</table> 
				<!-- Grid (E) -->
						
				</td></tr>
			</table>
	
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
			</tr>
			</table>
		</td></tr>
		</table>		
    <!--Button (E) -->
    
</td></tr>
</table>

</form>			
</body>
</html>