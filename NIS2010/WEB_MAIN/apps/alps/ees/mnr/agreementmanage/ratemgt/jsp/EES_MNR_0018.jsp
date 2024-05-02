<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0018.jsp
*@FileTitle : M&R Agreement List
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.01
*@LastModifier : 함형석
*@LastVersion : 1.0
* 2009.07.01 함형석
* 1.0 Creation
* 2014-03-21 Ticket No : CHM-201429420 Title : ALPS MNR-Agreement-Tariff-Agreement List에 Expiry Date 추가 요청 TD : Jonghee HAN DEV : JongHee HAN ->Text Alignment Adjustment
=========================================================*/   
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.mnr.agreementmanage.ratemgt.event.EesMnr0018Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMnr0018Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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
	String strVndr_seq		= "";
	String strVndr_nm		= "";	
	String strAccess_system		= "";	
	
	Logger log = Logger.getLogger("com.hanjin.apps.test.test");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		rhqOfcCd  = account.getRhq_ofc_cd();
		strVndr_seq = account.getOfc_eng_nm();
		strVndr_nm 	= account.getOfc_krn_nm();		
		strAccess_system = account.getAccess_system();
		
		event = (EesMnr0018Event)request.getAttribute("Event");
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
<title><span id="title"></span></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

<!--MNR 공용 사용  -->       
<script language="javascript">   
	var currOfcCd = '<%=strOfc_cd %>';
	var rhqOfcCd  = '<%=rhqOfcCd %>';
	function setupPage(){    
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>


<body  onLoad="setupPage();"> 

<form name="form"> 
<input type="hidden" name="f_cmd">
<input type="hidden" name="agmt_eq_type">
<input type="hidden" name="ofc_cd" value="<%=strOfc_cd%>">
<input type="hidden" name="ar_hd_qtr_cd">
<input type="hidden" name="cost_ofc_cd">
<input type="hidden" name="agmt_ofc_cd">
<input type="hidden" name="strAccess_system" value="<%= strAccess_system%>"> 
<input type="hidden" name="strVndr_seq" value="<%= strVndr_seq%>"> 
<input type="hidden" name="strVndr_nm" value="<%= strVndr_nm%>"> 
<!-- OUTER - POPUP (S)tart -->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		    <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!-- : ( Title ) (E) -->

		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
       	<tr><td class="btn1_bg">
		
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td></tr>
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
					<td width="80">EQ Type</td>
					<td width="130"><script language="javascript">ComComboObject('combo1',1, 90 , 1,1)</script></td>
					<td width="115">Agreement Period</td>
					<td width="250">
						<input type="text" style="width:80;text-align:center" class="input1" name="agmt_fm_dt" dataformat="ymd" maxlength="8" cofield="agmt_to_dt">&nbsp;~
						<input type="text" style="width:80;text-align:center" class="input1" name="agmt_to_dt" dataformat="ymd" maxlength="8" cofield="agmt_fm_dt">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="cre_dt_cal"></td>
					<td width="105">Service Provider</td>
					<td width=""><input type="text" style="width:70;text-align:center" class="input" name="vndr_seq" value=""  maxlength="6" dataformat="engup">&nbsp;<img src="img/btns_search.gif" width="19" height="20" class="cursor" alt="" border="0" align="absmiddle"  name="btn_popup">&nbsp;<input type="text" style="width:140;" class="input2" readOnly name="vndr_lgl_eng_nm" ></td>
					
				</tr>
				<tr class="h23">
					<td width="">Regional HQ</td>
					<td width=""><script language="javascript">ComComboObject('combo2',2, 90 , 0);</script></td>
					<td width="">Agreement Office</td>
					<td width="" style="padding-left:2"><script language="javascript">ComComboObject('combo3',2, 80 , 0,'','',0,'');</script></td>
					<td width="">Cost CTRL Office</td>
					<td width="" style="padding-left:2"><script language="javascript">ComComboObject('combo4',2, 94 , 0);</script></td>
					</tr>
				</table>				
				<!--  biz_1   (E) -->
			
		</td></tr></table>
		
		<table class="height_8"><tr><td></td></tr></table>	
		
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
				<table width="100%" class="button"> 
		       	<tr><td class="btn2_bg">
					<table border="0" cellpadding="0" cellspacing="0">
					<tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_detail">Detail(s)</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_downexcel">Down&nbsp;Excel</td>
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
</td></tr></table>
</form>
</body>
</html>

		