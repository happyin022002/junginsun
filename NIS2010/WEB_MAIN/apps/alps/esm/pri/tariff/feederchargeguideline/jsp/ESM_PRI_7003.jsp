<%
/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : ESM_PRI_7003.jsp
 *@FileTitle : Feeder/IHC Tariff Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.05.07
 *@LastModifier : 이은섭
 *@LastVersion : 1.0
 =========================================================
 * History                                      
 * 2012.11.05 서미진 [CHM-201220395] Add-on management T/F Project                                          
 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.tariff.feederchargeguideline.event.EsmPri7003Event"%>

<%
	EsmPri7003Event event = null;
	Exception serverException = null;
	String strErrMsg = "";
	int rowCount = 0;

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.hanjin.apps.SCGuideline.SCGuidelineMain");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmPri7003Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>EUR Add-on / IHC Inquiry</title>
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

<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="cd">
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
					<td width="">Point</td>
					<td width=""><nobr>
					<input type="text" name="pnt_loc_cd" style="width:90;text-align:left;ime-mode:disabled" class="input1" required="required" caption="Point" minlength="2" onKeyPress="ComKeyOnlyAlphabet('upper','44')" onpaste="DoPaste()" ><img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_pnt_loc_cd">
	                </nobr></td>
					<td width="">In/Out</td>
					<td width=""><script language="javascript">ComComboObject('org_dest_tp_cd', 1, 90, 1, 1, 0, false);</script></td>
					<td width="">Service Scope</td>
					<td width=""><script language="javascript">ComComboObject("svc_scp_cd", 2, 65, 0, 1, 0, false);</script></td>								
					<td width="">Access Date</td>
					<td width=""><input type="text" style="width:80;text-align:center;" class="input1" maxlength="10" dataformat="ymd" name="acc_dt" ><img src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" name="btn_calendar"></td>					
					<td width="">Base Port</td>
					<td width=""><nobr>
	                <input type="text" name="bse_port_loc_cd" style="width:55;text-align:left;ime-mode:disabled" class="input" caption="Base Port" minlength="5" maxlength="5" onKeyPress="ComKeyOnlyAlphabet('upper')"><img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_bse_port_loc_cd"></nobr></td>			
					<td width="">SVC Type</td>
					<td width=""><script language="javascript">ComComboObject("svc_tp_cd", 1, 80, 0, 0, 0, false);</script></td>					
				</tr>
			</table>	
			<!--  biz_1   (E) -->
			</td></tr>
		</table>
	<!--  biz_1   (E) -->
	
	<!-- Tab ) (S) -->
   	<table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%>
     		<tr><td width="100%">
				<script language="javascript">ComTabObject('tab1')</script>
		</td></tr>
	</table>
	<!-- Tab ) (E) -->
	
	<!-- iFrame (S) -->
        <div id="tabLayer" style="display:none">
        <iframe name="t1frame" id="t1frame" frameborder="0" scrolling="no" width="100%" height="500" src="about:blank"></iframe>
        </div>
        <div id="tabLayer" style="display:none">
        <iframe name="t2frame" id="t2frame" frameborder="0" scrolling="no" width="100%" height="500" src="about:blank"></iframe>
        </div>
	<!-- iFrame (E) --> 
	
	<table class="height_10"><tr><td colspan="8"></td></tr></table>
	</td></tr>
</table>	
<div id="flagLayer1" style="display:none"> 
	<table width="979"  id="mainTable">
		<tr>
			<td width="100%">
				<script language="javascript">ComSheetObject('sheet1');</script>
			</td>
		</tr>
	</table>
</div>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>