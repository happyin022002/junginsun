<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0118.jsp
*@FileTitle : MNR PFMC by EQ
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.12
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2009.10.12 민정호
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
<%@ page import="com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.event.EesMnr0118Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMnr0118Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.ReportManage.PerformanceReport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesMnr0118Event)request.getAttribute("Event");
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
<input type="hidden" name="curr_cd">
<input type="hidden" name="mnr_warr_flg">
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
					<td width="50">Report Type</td>
					<td width="170">&nbsp;<script language="javascript">ComComboObject('report_type',1, 140 , 1,1)</script></td>
					<td width="50">Period</td>  
					<td width="340">&nbsp;<script language="javascript">ComComboObject('report_period_type',2, 110 , 1,1)</script>
							&nbsp;<input required type="text" name="fm_dt" dataformat="ymd"  maxlength="8"  size="10"  cofield="to_dt" value="" class="input1">   
                              	~ <input required type="text" name="to_dt" dataformat="ymd"  maxlength="8"  size="10"  cofield="fm_dt" class="input1">&nbsp;<img name="btn_calendar" class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">									
					</td>
					<td width="60">EQ Type</td>  	
					<td width="170">&nbsp;<script language="javascript">ComComboObject('eq_type',2, 140, 1, 0, 2,false,1);</script></td>
					<td width="50">TP/SZ</td>
					<td width="">&nbsp;<script language="javascript">ComComboObject('tp_sz_cd', 2, 100 ,0);</script></td>
				</tr> 	
				</table>					
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23"> 	
					<td width="90">Regional HQ</td> 
					<td width="130">&nbsp;<script language="javascript">ComComboObject('rhq',2, 100, 0, 0);</script></td>
					<td width="49">Office</td>	
					<td width="136">&nbsp;<script language="javascript">ComComboObject('ofc_cd',2, 100 ,0, 0,'',0,'');</script></td>					
					<td width="110">Service Provider</td>	
					<td width="312"><input type="text" name="vndr_seq" caption="Service Provider" style="width:57;text-align:left;" class="input" value="" dataformat="engup" maxlength="6">&nbsp;<img class="cursor" src="img/btns_search.gif" name="btn_provider_popup" width="19" height="20" border="0" align="absmiddle">&nbsp;<input type="text" name="vndr_lgl_eng_nm" caption="Service Provider" style="width:200;" class="input2" value="" readonly></td> 
					<td width="">USD Only&nbsp;<input name="check_usd_only" type="checkbox" class="trans"></td>
				</tr>  				
				<table class="search" border="0" style="width:979;"> 				
				<tr class="h23"> 
					<td width="160">EQ Manufacturing Period</td>
					<td width="210">
					<input type="text" name="manu_yr_fr" style="width:50;text-align:center" class="input" maxlength="4" dataformat="yyyy">&nbsp;<img src="img/btns_calendar.gif" class="cursor" name="manu_yr_fr_cal" width="19" height="20" alt="" border="0" align="absmiddle">&nbsp;~
					<input type="text" name="manu_yr_to" style="width:50;text-align:center" class="input" maxlength="4" dataformat="yyyy">&nbsp;<img src="img/btns_calendar.gif" class="cursor" name="manu_yr_to_cal" width="19" height="20" alt="" border="0" align="absmiddle">
					</td>
					<td width="52">EQ Term</td>	  	
					<td width="170">&nbsp;<script language="javascript">ComComboObject('lstm_cd',2, 140,0);</script></td>
					<td width="100">Warranty&nbsp;<input name="check_warranty" type="checkbox" class="trans"></td>
					<td width="200">&nbsp;</td>   
					<td width=""></td>	
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
				<tr>
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
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>