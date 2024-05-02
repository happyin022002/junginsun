<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1032.jsp
*@FileTitle : ESM_BKG_5020
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.20
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2009.07.20 경종윤
* 1.0 Creation
---------------------------------------------------------
history
 2011.02.28 김영철 [] Transmit History (ESM_BKG_1032) 화면에서 조건 추가 ( VVD )
 * 2014.12.29 [CHM-201432728] [IE 세관] 시스템 추가 보완 요청 사항
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.eur.event.EsmBkg1032Event"%>

<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg1032Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.CustomsDeclaration.ManifestListDownload");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
		event = (EsmBkg1032Event)request.getAttribute("Event");
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
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){

		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} 
		
		loadPage();
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr>
		<td valign="top">
			<!--Page Title, Historical (S)-->
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
			</table>
			<!--Page Title, Historical (E)-->

			<!--biz page (S)-->
			<table class="search">
				<tr>
					<td class="bg">
						<!--  biz_1  (S) -->
						<table class="search" border="0" style="width:979;">
							<tr class="h23">
								<td width="50">&nbsp;&nbsp;Type</td>
								<td width="200">
									<script language="javascript">ComComboObject('p_type', 1, 100, 1, '');</script>
								</td>
								<td width="800"></td>
							</tr>
						</table>
						<!--  biz_1  (E) -->
						
						<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
						
						<!--  biz_2  (S) -->
						<table class="search" border="0" style="width: 979;">
							<tr class="h23">
								<td width="120">Acknowledge Date</td>
								<td width=""><input type="text"
									style="width: 90; ime-mode: disabled" class="input" maxlength="10"
									dataformat="ymd" name="s_vps_eta_dt" caption="ETA" cofield="e_vps_eta_dt">
									&nbsp;~&nbsp; <input type="text"
									style="width: 90; ime-mode: disabled" class="input" maxlength="10"
									dataformat="ymd" name="e_vps_eta_dt" caption="ETA" cofield="s_vps_eta_dt">
								<img src="img/btns_calendar.gif" width="19" height="20" alt=""
									border="0" align="absmiddle" class="cursor" name="btn_calendar">
								</td>
							</tr>
						</table>
						<!--  biz_2  (E) -->
						
						<!-- Default - ALL -->
						<div id="allView" style="display:inline">
					
							<table class="search" border="0" style="width: 979;">
								<tr class="h23">
									<td width="40">VVD</td>
									<td width="140">
										<input type="text" style="width:80; ime-mode:disabled" name="vvd"  
										class="input" dataformat="eng" maxlength="9"  caption="VVD">
									</td>
									<td width="50">BL No.</td>
									<td width="140">
										<input type="text" style="width:100; ime-mode:disabled" name="bl_no"  
										class="input" dataformat="eng" maxlength="12" fullfill caption="BL No">
									</td>
									<td width="95">Container No.</td>
									<td width="">
										<input type="text" style="width:110; ime-mode:disabled" name="cntr_no"
										class="input" dataformat="eng" maxlength="14" caption="Container No">
									</td>
											<td width="105">
										FR Ack&nbsp;<input type="checkbox" value="" class="trans" name="fr_ack">&nbsp;
									</td>
									<td width="85">VVD for FR.</td>
									<td width="">
										<input type="text" style="width:110; ime-mode:disabled" name="vvd_for_fr" readOnly
										class="input" dataformat="eng" maxlength="14" caption="VVD for FR">
									</td>
								</tr>
							</table>
						</div>
						<!-- Default (E) -->
						<!-- IE Manifest (S) -->
						<div id="ieView" style="display:inline">
							<table class="search" border="0" style="width: 979;">
								<tr class="h23">
									<td width="40">VVD</td>
									<td width="140">
										<input type="text" style="width:80; ime-mode:disabled" name="ie_vvd"  id="ie_vvd"
										class="input" dataformat="eng" maxlength="9" caption="VVD">
									</td>
									<td width="40">Mode</td>
									<td width="150"><SELECT name="io_bnd_cd">
											<option value="">ALL</option>
											<option value="I">InBound</option>
											<option value="O">OutBound</option>
											</SELECT>
									</td>
									<td width="40">Port</td>
									<td width="" >
										<input type="text" style="width:60;ime-mode: disabled;" value="" class="input"  name="port_cd" id="port_cd"
										dataformat="eng" maxlength="5" caption="POD">
									</td>
								</tr>
							</table>
						</div>
						<!-- IE Manifest (E) -->
					</td>
				</tr>	
			</table>			
<!-- 				<tr> -->
<!-- 					<td class="bg"> -->
						
<!-- 					</td> -->
<!-- 				</tr> -->
		
			<table class="height_8"><tr><td></td></tr></table>
		
			<!-- Grid BG Box  (S) -->
	     	<table width="100%" class="search" id="mainTable">
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
				
		    	<!-- Button_Sub (E) -->	
					
				</td></tr>
			</table>
			<!-- Grid BG Box  (S) -->
	
	<!--biz page (E)-->
	
	
	
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>			
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_exceldown">Down Excel</td>
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
