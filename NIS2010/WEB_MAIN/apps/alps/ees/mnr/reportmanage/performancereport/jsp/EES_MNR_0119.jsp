<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0119.jsp
*@FileTitle : PFMC by CEDEX Code
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.13
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2009.10.13 민정호
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
<%@ page import="com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.event.EesMnr0119Event"%>
<%@ page import="org.apache.log4j.Logger" %>
 
<%
	EesMnr0119Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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


		event = (EesMnr0119Event)request.getAttribute("Event");
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

	    loadPage();
    }

</script>


<body  onLoad="setupPage();">

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
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
			
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="60">Period</td>
					<td width="102"><script language="javascript">ComComboObject('report_period_type',2, 100 , 1,1)</script></td>
					<td width="223">
					<input required type="text" name="fm_dt" dataformat="ymd"    caption="from date"        maxlength="8"  style="width:80;"  cofield="to_dt" value="" class="input1">   
                              	~ <input required type="text" name="to_dt" dataformat="ymd"    caption="to date"        maxlength="8"  style="width:80;"  cofield="fm_dt" class="input1">&nbsp;<img name="btn_calendar" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" class="cursor">
					
					</td>
					<!-- td width="50">Top 10</td>
					<td width="120"><script language="javascript">ComComboObject('top10',2, 80, 0, 0);</script></td-->
					<td width="60">USD Only</td>
					<td width="110"><input type="checkbox" name="currency_ck" class="trans"><input type="hidden" name="currency"></td>
					<td width="60">QTY Only</td>
					<td width=""><input type="checkbox" name="qty_ck" class="trans"><input type="hidden" name="qty"></td>
					
				</tr> 
				</table>				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="60">EQ Type</td>
					<td width="145"><script language="javascript">ComComboObject('eq_type',2, 102, 1, 0, 2,false,1);</script></td>
					<td width="80">Regional HQ</td>
					<td width="100"><script language="javascript">ComComboObject('rhq',2, 80, 0, 0);</script></td>
					<td width="50">Office</td>
					<td width="120"><script language="javascript">ComComboObject('ofc_cd',2, 80 ,0, 0,'',0,'');</script></td>
					<td width="110">Service Provider</td>
					<td width="">
					<input type="text" name="vndr_seq" caption="Service Provider" style="width:57;text-align:left;" class="input" value="" dataformat="engup" maxlength="6">&nbsp;<img class="cursor" src="img/btns_search.gif" name="btn_provider_popup" width="19" height="20" border="0" align="absmiddle">&nbsp;<input type="text" name="vndr_lgl_eng_nm" caption="Service Provider" style="width:152;" class="input2" value="" readonly>
				</tr> 
				</table>				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="58">Location</td>
					<td width="147"><input required type="text" name="location_cd" dataformat="engup" style="width:85;" class="input" >&nbsp;<img src="img/btns_search.gif" name="btn_location" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
					<td width="80">Component</td>
					<td width="100"><script language="javascript">ComComboObject('component', 2, 80, 0, 0);</script></td>
					<td width="50">Repair</td>
					<td width="120"><script language="javascript">ComComboObject('repair', 2, 80, 0, 0);</script></td>
					<td width="45">Division</td>
					<td width="150"><script language="javascript">ComComboObject('division', 2, 80, 0, 0);</script></td>
					
					<td width="55">Damage</td>
					<td width=""><script language="javascript">ComComboObject('damage', 2, 80, 0, 0);</script></td>
					</tr> 
				</table>				
				<!--  biz_1   (E) -->
			
		</td></tr></table>
		<table class="height_8"><tr><td></td></tr></table>	
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">	
			
			<!-- Title -->
			<table class="search" border="0">
			<tr><td class="title_h"></td>
				<td class="title_s">M &amp; R Performance Detail</td></tr>
			<tr><td class="height_5"></td></tr>
			</table>
			<!-- Title -->
			
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
					<td>
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_DownExcel">Down Excel</td>
					<td class="btn2_right"></td>
					</tr>
					</table>
					</td>
					<td>
					<div id="btn_DetailInformation">
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_DetailInformation">Detail Information</td>
					<td class="btn2_right"></td>
					</tr>
					</table>
					</div>
					</td>
					
						
				</tr>
				</table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
			
			
			</td></tr>
		</table>
		<!--biz page (E)-->
	
	
	</td></tr>
		</table>
	

</form>
</body>
</html>