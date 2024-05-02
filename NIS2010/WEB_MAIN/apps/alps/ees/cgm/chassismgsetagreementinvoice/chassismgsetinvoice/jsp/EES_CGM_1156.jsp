<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName 		: EES_CGM_1156.jsp
*@FileTitle 	: Performance by Pool
*Open Issues 	:
*Change history :
*@LastModifyDate: 2014.03.03
*@LastModifier 	: 신용찬
*@LastVersion 	: 1.0
* 2014.03.03 신용찬
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
<%@ page import="com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.event.EesCgm1156Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.io.HttpUtil"%>

<%
	EesCgm1156Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지

	String strUsr_id		= "";
	String strUsr_nm		= "";	
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		//strUsr_id =	account.getUsr_id();
		//strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EesCgm1156Event)request.getAttribute("Event");
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
<title>Performance by S/C NO</title>
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

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<input type="hidden" name="inquiryLevel" value=""> 
<input type="hidden" name="location" value=""> 

<!-- scc 입력값 검증에 사용하는 공통 mnr코드 -->
<input type="hidden" name="eq_orz_cht_chktype">
<input type="hidden" name="eq_orz_cht_scc_cd"> 

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
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_downexcel">Down&nbsp;Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
	
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
				
					<td width="48">Period</td>
					<td width="220">
						<input type="text" name="from_bse_dt" required maxlength="6" style="width:60;" dataformat="ym"  class="input1"  value="">&nbsp;<img class="cursor" name="btns_Calendar1" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">
						&nbsp;~&nbsp;
						<input type="text" name="to_bse_dt" style="width:60;" required maxlength="6" dataformat="ym"  class="input1" value="">&nbsp;<img class="cursor" name="btns_Calendar2" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">
					</td>

                    <td width="10"></td>
					<td width="50">S/C No</td>
					<td width="180"><input type="text" name="search_sc_no" style="width:140;" class="input" dataformat="engup">&nbsp;<img src="img/btns_multisearch.gif" name="sc_no_multi" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
					
					<td width="5"></td>
					<td width="30">Yard </td>
					<td width="200"><input type="text" name="search_yd_cd" dataformat="engup" style="width:161;ime-mode:disabled" class="input" value="">&nbsp;<img name="btns_crnt_yd_cd" class="cursor" src="img/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle"></td>
					

					<td width="5">&nbsp;</td>
                  	<td align=right><input type="checkbox" name="data_merge" value="" class="trans" checked>Data Merge</td>
                  	
                  	

					
				</tr> 
				

				</table>
				<!--  biz_1   (E) -->
				
				</td></tr>
			</table>
			<table class="height_10"><tr><td colspan="8"></td></tr></table>


							<!-- : ( Grid ) (S) -->
							<!-- 'HEAD1-BGCOLOR : 203 240 169' , 'HEAD2-BGCOLOR : 222 251 248' , 'BORDER 1-outside : 88 152 164' ,'BORDER 2-inside : 202 226 233' , 'HEAD-FONT : 39 95 101' , 'SELETED ROW BG : 252 255 233' -->
		        	        <table width="100%" id="mainTable" >
		        				<tr><td >
			        				   <script language="javascript">ComSheetObject('t1sheet1');</script>
			        			</td></tr>
		        			</table>
							<!-- : ( Grid ) (E) -->
		        			<!-- : Space (S) -->
		        			<!-- : Space (E) -->
							<!-- TABLE '#D' : ( Button : Sub ) (S) -->
					    	<!-- TABLE '#D' : ( Button : Sub ) (E) -->


<table class="height_10"><tr><td colspan="8"></td></tr></table>

	</td></tr>
</table>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>