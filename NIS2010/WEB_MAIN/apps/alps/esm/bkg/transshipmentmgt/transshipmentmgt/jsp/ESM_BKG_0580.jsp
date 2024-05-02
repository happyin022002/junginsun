<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0580.jsp
*@FileTitle : VVD Discharging Yard
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.18
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.05.18 최영희
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.event.EsmBkg0580Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0580Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.TransshipmentMgt.TransshipmentMgt");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmBkg0580Event)request.getAttribute("Event");
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
<title>VVD Discharging Yard</title>
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
<form name="form" onkeyup="ComKeyEnter('lengthnextfocus');">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="vps_port_cds">
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
			<table class="search"> 
	       	<tr><td class="bg">
			
					<!--  biz_1  (S) -->
					<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="50">Port CD</td>
						<td width="110"><input type="text" style="width:80;" class="input1" value="" name="vps_port_cd" dataformat="engup" maxlength="5"></td>
						<td width="110">Other(s) Port CD</td>
						<td width="170"><input type="text" style="width:80;" class="input" value="" name="vps_oher_port_cd" dataformat="engup" maxlength="5"></td>
						<td width="90">ETB Duration</td>
						<td width=""><input type="text" style="width:80"  class="input1" name="vps_etb_dt" dataformat="ymd">&nbsp;&nbsp;~&nbsp;&nbsp;<input type="text" style="width:88"  class="input1" name="vps_etd_dt" dataformat="ymd">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar"></td>
					</tr>
					</table>
					<!--  biz_1   (E) -->
				
					<!--  biz_2  (S) -->
					<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="50">Carrier</td>
						<td width="110"><input type="text" style="width:80;" class="input" value="" name="crr_cd" dataformat="engup" maxlength="3"></td>
						<td width="30">VVD</td>
						<td width="135"><input type="text" style="width:80;" class="input" value="" name="vvd" dataformat="engup" maxlength="9"></td>
						<td width="40">Lane</td>
						<td width=""><input type="text" style="width:60;" class="input" value="" name="lane" dataformat="engup" maxlength="3"></td>
					</tr>
					</table>
					<!--  biz_2   (E) -->
							
				
					</td></tr>
				</table>
				<table class="height_8"><tr><td colspan="8"></td></tr></table>
	
			<!-- Grid BG Box  (S) -->
	     	<table class="search" id="mainTable" border="0"> 
	       	<tr><td class="bg">
					
					<!-- Grid_frame (S) -->
					<table class="search" border="0" style="width:979;"> 
					<tr>
						<td width="550" valign="top">
							<!-- Grid_2  (S) -->
						<table width="100%"  id="mainTable">
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet1');</script>
								</td>
							</tr>
						</table>
							<!-- Grid_2 (E) -->
						</td>
						<td width="19">&nbsp;</td>
						<td width="410">
							<!-- Grid_1  (S) -->
						<table width="100%"  id="mainTable">
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet2');</script>
								</td>
							</tr>
						</table>
							<!-- Grid_1 (E) -->
						</td>					
						</tr>
						</table>
						<!-- Grid_frame (E) -->
						
				
				</td></tr>
			</table>
			<!-- Grid BG Box  (E) -->
		
		<!--Button (S) -->
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
	       	<tr><td class="btn1_bg">
			    <table border="0" cellpadding="0" cellspacing="0">
			    <tr>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
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
					<td class="btn1_line"></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_save">Save</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_saveAs">Save&nbsp;As</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
					<td class="btn1_line"></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_yardPaste">Yard&nbsp;Paste</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
				</tr>
				</table>
			</td></tr>
			</table>
	    <!--Button (E) -->
		<table class="height_10"><tr><td colspan="8"></td></tr></table>
		<!--biz page (E)-->
		
		</td></tr>
			</table>
	 

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>