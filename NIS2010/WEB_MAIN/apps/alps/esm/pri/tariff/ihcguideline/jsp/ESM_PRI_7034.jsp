<%
/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : ESM_PRI_7034.jsp
 *@FileTitle : Inland add-on inquiry in local currency (TRO)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.11.19
 *@LastModifier : 서미진
 *@LastVersion : 1.0
 =========================================================
 * History   
 * 2013.03.20 전윤주 [CHM-201323687] sheet 하단에 문구 추가
 =========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.event.EsmPri7034Event"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.common.PRIUtil"%>
<%@ page import="java.util.List"%>
<%
	EsmPri7034Event event = null;
	Exception serverException = null;
	String strErrMsg = "";
	int rowCount = 0;

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.hanjin.apps.SCGuideline.SCGuidelineMain");

	String[] prcTrspModCd = null;
	String[] termCd = null;

	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmPri7034Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		prcTrspModCd 	= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("PRC_TRSP_MOD_CD"), false);
		termCd 	= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("RCV_DE_TERM_CD"), false);
	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Inland add-on inquiry in local currency (TRO)</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	var prcTrspModCdValue = " |<%=prcTrspModCd[0]%>";
	var prcTrspModCdText = " |<%=prcTrspModCd[1]%>";

	var termCdValue = " |<%=termCd[0]%>";
	var termCdText = " |<%=termCd[1]%>";

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		}
		loadPage();
	}
</script>
</head>

<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="cd" value="NYCRA">
<input type="hidden" name="etc1">

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
					<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
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
					<td class="btn1" name="btn_down_excel">Down Excel</td>
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
			
			<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="">In/Out</td>
					<td width=""><script language="javascript">ComComboObject('org_dest_tp_cd', 1, 90, 1, 1, 0, false);</script></td>
					<td width="">Service Scope</td>
					<td width=""><script language="javascript">ComComboObject("svc_scp_cd", 2, 70, 0, 1, 0, false);</script></td>
					<td width="">Access Date</td>
					<td width=""><input type="text" style="width:100;text-align:center;" class="input1" maxlength="10" dataformat="ymd" name="acc_dt" >
					<img src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" name="btn_calendar"></td>										
					<td width="">Point</td>
					<td width="">
						<nobr>
	                    	<input type="text" name="pnt_loc_cd" style="width:70;text-align:left;ime-mode:disabled" class="input"  caption="Point" minlength="5" maxlength="5" onKeyPress="ComKeyOnlyAlphabet('upper')"><img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_pnt_loc_cd">
	                    </nobr>
					</td>
					<td width="">Base Port</td>
					<td width="">
						<nobr>
	                    	<input type="text" name="bse_port_loc_cd" style="width:70;text-align:left;ime-mode:disabled" class="input" caption="Base Port" minlength="5" maxlength="5" onKeyPress="ComKeyOnlyAlphabet('upper')"><img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_bse_port_loc_cd">
	                    </nobr>					
					</td>
					<td width="">Term</td>
					<td width=""><script language="javascript">ComComboObject('rcv_de_term_cd', 1, 70, 1, 0, 0, false);</script></td>
				</tr>
			</table>	
			<!--  biz_1   (E) -->
			<table class="line_bluedot"><tr><td></td></tr></table>
			<!-- Grid  (S) -->								
			<table width="100%"  id="mainTable">
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet1');</script>
					</td>
				</tr>
			</table>
			<!-- Grid (E) -->	
			
			<table class="search" border="0">
				<tr><td height="18"><img src="/hanjin/img/ico_star.gif" border="0" hspace="3" align="absmiddle">
				If the tariff amounts is "0", please contact each RHQ and ask for more accurate amounts.
				</td></tr>		
		    </table>	
			
			</td></tr>
		</table>
	<!--  biz_1   (E) -->	
	</td></tr>
</table>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>