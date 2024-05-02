<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CGM_1143.jsp
*@FileTitle : Pool Chassis Expense Trend
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.12
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.08.12 최민회
* 1.0 Creation
*--------------------------------------------------
* History
* 2015.04.28 Chang Young Kim [CHM-201534113] 2015년 1월 소스 보안 결함 건 조치 요청
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.cgm.movementmnrhistory.poolchassishistory.event.EesCgm1143Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@page import="com.hanjin.framework.component.util.io.HttpUtil"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil"%>

<%
	EesCgm1143Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String chss_pool        = "";
	String mvmt_dt          = "";
	String prgId            = "";
	Logger log = Logger.getLogger("com.hanjin.apps.MovementMnrHistory.PoolChassisHistory");
	String xml = HttpUtil.makeXML(request,response);
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesCgm1143Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		prgId        = StringUtil.xssFilter(request.getParameter("prgId"));
		chss_pool    = StringUtil.xssFilter(request.getParameter("chss_pool"));
		mvmt_dt      = StringUtil.xssFilter(request.getParameter("mvmt_dt"));
		if(prgId == null){
			prgId ="";
		}
		
		if(mvmt_dt == null){
			mvmt_dt ="";
		}
		
		if(chss_pool == null){
			chss_pool ="";
		}

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
<title>Pool Chassis Expense Trend</title>
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
<form name="form2">
<input type="hidden" name="sXml" value="<%=xml.replace("\"","'")%>">
</form>
<form name="form" onkeyup="ComKeyEnter('search');">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="prgId" value="<%=prgId%>">
<input type="hidden" name="chss_pool" value="<%=chss_pool%>">
<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->
	
		
	
		<!--biz page (S)-->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
			
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="37">Pool</td>
					<td width="230"><script language="javascript">ComComboObject('chss_pool_cd', 1, 190, 1, 1, 1, true);</script></td>
					<td width="45">Month</td>
					<td width=""><input type="text" style="width:70;text-align:center;ime-mode:disabled" dataformat="ym" name='mvmt_dt_fr' class="input1" value="<%=mvmt_dt%>" maxlength='6'>
					                <img name="btns_Calendar1" class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">
                                    ~
                                    <input type="text" style="width:70;text-align:center;ime-mode:disabled" dataformat="ym" name='mvmt_dt_to'class="input1" value="<%=mvmt_dt%>" maxlength='6'>
                                    <img name="btns_Calendar2" class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"></td>
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
			
			
			
			</td></tr>
		</table>
		<!--biz page (E)-->

	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:0;"> 
       	<tr><td class="btn1_bg">
		
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve"  ID ="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_downexcel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				</tr>
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