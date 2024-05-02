<%
/*=========================================================
* Copyright(c) 2006 CyberLogitec
* @FileName : ESM_COA_0120.jsp
* @FileTitle : Seasonal SMU Cost (RA)
* Open Issues :
* Change history :
* @LastModifyDate : 2012-05-29
* @LastModifier : SHKIM
* @LastVersion : 1.0
*  1.0 최초 생성
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.coa.weeklypfmc.weeklycm.event.EsmCoa0120Event"%>
<%@ page import="com.hanjin.framework.component.util.io.HttpUtil"%> 
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>

<%
	EsmCoa0120Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	String xml = "";
	Logger log = Logger.getLogger("com.hanjin.apps.WeeklyPFMC.WeeklyCM");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();


		event = (EsmCoa0120Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		xml = HttpUtil.makeXML(request,response); 
        xml = xml.replaceAll("\"", "'");
        
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}


	}catch(Exception e) {
		log.error("Exception : " + e.toString());
	}
%>
<html>
<head>
<title>Seasonal SMU Cost (RA) </title>
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
<iframe height="0" width="0" name="frmHidden" id="frmHidden"></iframe>
<form method="post" name="form" onKeyDown="ComKeyEnter();">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<input type="hidden" name="iPage">
<input type="hidden" name="sXml" value="<%=xml%>"> 

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>


		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->

		<!--Button_L (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
	       	<tr><td class="btn1_bg">

				<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<!-- Repeat Pattern -->
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" id="btn_Retrieve" name="btn_Retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>

					<td class="btn1_line"></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" id="btn_DownExcel" name="btn_DownExcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>
					<!-- Repeat Pattern -->

				</tr></table>

			</td></tr>
		</table>
		<!--Button_L (E) -->

		<!-- TABLE '#D' : ( Search Options ) (S) -->
		<table class="search">
		<tr>
			<td class="bg">

				<table class="search_in" border="0">
				<tr class="h23">
					<td width="7%">YYYY-MM</td>
					<td width="12%">
						<input type="text" class="input1" name="f_cost_yrmon" style="width:70;text-align:center;" maxlength="7" onKeyPress="ComKeyOnlyNumber(window)" onFocus="this.value=ComReplaceStr(this.value, '-', '');" onBlur="addDash(this , 4);"  ></td>
					<td width="5%">Trade</td>
					<td width="15%">
						<script language="javascript">ComComboObject('f_trd_cd',1, 80 , 0 )</script>
					</td>
					<td width="8%">Sub Trade</td>
					<td width="15%">
						<script language="javascript">ComComboObject('f_sub_trd_cd',1, 80 , 0 )</script>
					</td>
					<td width="4%">Lane</td>
					<td width="15%">
						<script language="javascript">ComComboObject('f_rlane_cd',1, 80 , 0 )</script>
					</td>
					<td width="6%">Bound</td>
					<td width="7%">
						<%//=JSPUtil.getCodeCombo("f_dir_cd","","style='width:80' ","CD01089",0,"").trim()%>
						<script language="javascript">ComComboObject('f_dir_cd',1, 80 , 0 )</script>
					<td>&nbsp;</td>
				</tr>
				</table>
			</td>
		</tr>
		</table>

		<!-- TABLE '#D' : ( Search Options ) (E) -->
		<table class="height_10"><tr><td></td></tr></table>

		<!-- TABLE '#D' : ( Search Options ) (S) -->
		<table class="search">
		<tr><td class="bg">

				<table class="search" border="0">
					<tr>
						<td class="title_h"></td>
						<td class="title_s">Seasonal SMU Cost (RA)</td>
						<td class="height_5" colspan="2"></td>
						<td align="right" valign="bottom">
							<div id="div_zoom_in" style="display:inline">
								<img class="cursor" src="/hanjin/img/bu_prev01.gif" height="11" border="0" name="bu_zoom_in" alt="Zoom in(+)">
							</div>
							<div id="div_zoom_out" style="display:none">
								<img class="cursor" src="/hanjin/img/bu_next01.gif" height="11" border="0" name="bu_zoom_out" alt="Zoom out(-)">
							</div>
						</td>
					</tr>
				</table>

				<!-- : ( POR ) (S) -->
				<table width="100%">
				<tr>
					<td width="100%">
						<table width="100%" id="mainTable">
						<tr><td><script language="javascript">ComSheetObject('sheet1');</script></td></tr>
						</table>
					</td>
				</tr>
				</table>
				<!-- : ( POR ) (E) -->

				<!-- : ( Button : Sub ) (S) -->
    			<table width="100%" class="button">
					<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<!-- Repeat Pattern -->
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" name="btn_popup" id="" alt="Alt+M">Bound Switch</td><td class="btn2_right"></td></tr></table></td>								
								<!-- Repeat Pattern -->
							</tr>
						</table>
					</td></tr>
				</table>
				
				


			</td>
		</tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->


</td></tr>
</table>
<!-- Outer Table (E)-->

</form>
</body>
</html>