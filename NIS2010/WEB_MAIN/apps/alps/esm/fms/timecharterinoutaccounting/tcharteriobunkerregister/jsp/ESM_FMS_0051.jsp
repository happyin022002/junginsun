<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_FMS_0051.jsp
*@FileTitle : BOD, BOR Monthly Interface
*Open Issues :
*Change history :
*@LastModifyDate : 2009.03.26
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.03.26 정윤태
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
<%@ page import="com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.event.EsmFms0051Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmFms0051Event event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지

	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.hanjin.apps.TimeCharterInOutAccounting.TCharterIOBunkerRegister");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
		event = (EsmFms0051Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		//초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		//GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
	} catch(Exception ex) {
		log.error("err " + ex.toString(), ex);
	}
%>
<html>
<head>
<title>BOD, BOR Monthly Interface</title>
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
<input type="hidden" name="ibflag">
<input type="hidden" name="pagerows">
<input type="hidden" name="eff_dt">
<input type="hidden" name="exp_dt">
<input type="hidden" name="vndr_seq">
<input type="hidden" name="bnk_yrmon">


<form name="form">  
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">


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
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">BOD / BOR Monthly Interface / Master</td></tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="90">Target Month</td>   
					<td><input type="text" style="width:60;text-align:center;" class="input1" value="" name ="ori_bnk_yrmon" maxlength="6" dataformat="ym" required fullfill caption="Target Month">&nbsp;<img class="cursor" src="img/btns_calendar.gif" name="tar_mon" width="19" height="20" alt="" border="0" align="absmiddle"></td>
					
					</tr>
				
				</table>
				<!--  biz_1   (E) -->
				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table> 
				<!--  biz_2  (S) -->
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">BOD / BOR Monthly Interface / Grid</td></tr>
				</table>
				<!-- Grid  (S) -->
					<table width="100%" class="search" id="mainTable"> 
						<tr>
							<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
							</td>
					</table>
				<!-- Grid (E) -->
						
				<!--  biz_2   (E) -->
				</td></tr>
			</table>
		</td></tr>
	</table>
	<!--biz page (E)-->
	
	
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left">
					<td class="btn1" name="btn_retrieve">Retrieve</td>
					<td class="btn1_right">
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left">
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right">
					</tr>
				</table></td>
				
				<td class="btn1_line"></td>
				<!-- 
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				-->
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Interface">Interface To P.O.Module</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_savetofile">Down&nbsp;Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<!-- RD 
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_print">Print</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				-->
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