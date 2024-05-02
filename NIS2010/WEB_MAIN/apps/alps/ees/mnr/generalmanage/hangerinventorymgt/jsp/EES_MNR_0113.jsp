<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0113.jsp
*@FileTitle : Hanger Bar Inventory
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.28
*@LastModifier : 박정민
*@LastVersion : 1.0
* 2015.01.28 박정민
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
<%@ page import="com.hanjin.apps.alps.ees.mnr.generalmanage.hangerinventorymgt.event.EesMnr0113Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	EesMnr0113Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd        = "";
	String strRhq_ofc_cd         = "";
	Logger log = Logger.getLogger("com.hanjin.apps.test.test");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		strRhq_ofc_cd  = account.getRhq_ofc_cd();
		
		event = (EesMnr0113Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		
		// SELSC > SELIB, TYOSC > TYOIB 로 변경
		strOfc_cd = "SELSC".equals(strOfc_cd) ? "SELIB" : strOfc_cd;
		strOfc_cd = "TYOSC".equals(strOfc_cd) ? "TYOIB" : strOfc_cd;

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
	var rhqOfcCd  = '<%=strRhq_ofc_cd %>';
	
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
<input type="hidden" name="usr" value="<%=strUsr_id %>">
<input type="hidden" name="ar_hd_qtr_ofc_cd">
<input type="hidden" name="ofc_cd">
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
					<td class="btn1" name="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>				
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_downexcel">Down&nbsp;Excel</td>
					<td class="btn1_right"></td>
					</tr>
					</table></td>				
				<td></td>
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
					<td width="80">Regional HQ</td>
					<td width="200"><script language="javascript">ComComboObject('combo1',2, 180 ,0,1)</script></td>
					<td width="80">Year-Month</td>
					<td width="120">
						<input type="text" maxlength="6" style="width:70px;text-align:center;ime-mode:disabled;" class="input1" name="month" onKeyPress="javascript:ComKeyOnlyNumber(this);" value="<%=JSPUtil.getKST("yyyy-MM")%>" dataformat="ym" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)" required fullfill caption="Year Month">
						<img name ="btn_year_month" src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
					</td>
					<td width="100">Show All Office</td>
					<td width="">
						<input  name="check_show_all" type="checkbox" class="trans">
					</td>
				</tr>
				</table>				
				<!--  biz_1   (E) -->
			
		</td></tr></table>
		<table class="height_8"><tr><td></td></tr></table>	

		<table class="search" id="mainTable"> 
       		<tr><td class="bg">	
		
			<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Hanger Bar Inventory</td></tr>
				</table>
			<!-- Grid  (S) -->
			<table width="100%"  id="mainTable">
				<tr>
					<td width="100%">
					<script language="javascript">ComSheetObject('sheet1');</script>
					</td>
				</tr>
			</table>
			<!-- Grid (E) -->	
			<!-- Grid (E) -->	
		<!--biz page (E)-->

		</td></tr>
		</table>
	
	</td></tr>
		</table>
	
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
