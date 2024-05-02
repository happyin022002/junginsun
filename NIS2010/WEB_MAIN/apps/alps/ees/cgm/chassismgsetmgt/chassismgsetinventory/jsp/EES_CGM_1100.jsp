<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CGM_1100.jsp
*@FileTitle : Inventory by On-Hire Year
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.30
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2009.07.30 조재성
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
<%@ page import="com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetinventory.event.EesCgm1100Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.io.HttpUtil"%>

<%
	EesCgm1100Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.ChassisMgsetMgt.ChassisMgsetInventory");

	String xml = HttpUtil.makeXML(request,response);
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesCgm1100Event)request.getAttribute("Event");
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
<title>Inventory by On-Hire Year</title>
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
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<input type="hidden" name="eq_knd_cd">
<input type="hidden" name="intg_cd_id">
<input type="hidden" name="yd_cd">
<input type="hidden" name="loc_cd">
<input type="hidden" name="eq_orz_cht_chktype">
<input type="hidden" name="eq_orz_cht_rcc_cd">
<input type="hidden" name="eq_orz_cht_lcc_cd">
<input type="hidden" name="eq_orz_cht_scc_cd">

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
					<td width="70">Location </td>
					<td width="52"><script language="javascript">ComComboObject('location', 1, 50, 0, 1, 1, true);</script></td>
					<td width="118"><input type="text" name="crnt_loc_cd" dataformat="engup" maxlength="5" style="width:68;ime-mode:disabled" class="input1" value="">&nbsp;<img name="btns_crnt_loc_cd" class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>					
					<td width="30">Yard </td>
					<td width="200"><input type="text" name="crnt_yd_cd" dataformat="engup" style="width:163;ime-mode:disabled" class="input" value="">&nbsp;<img name="btns_crnt_yd_cd" class="cursor" src="img/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle"></td>
					<td width="">&nbsp;</td>
				</tr>
			</table>
			<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="70">Active St.</td>
					<td width="418"><script language="javascript">ComComboObject('aciac_div_cd', 1, 145, 0, 0, 1, true);</script></td>
					<td width="224">Include 'NP'<input type="checkbox" name="include_np" value="" class="trans"></td>
					<td width="87">On-hire Year</td>
					<td width="" class="stm"><input type="text" name="onh_dt" dataformat="int"  maxlength="4"  style="width:50;text-align:center;" class="input" value=" 0">&nbsp;or Older</td>
				</tr>
				<tr class="h23" border="0" style="width:979;">
					<td width="70">Group By</td>
					<td width=""><script language="javascript">ComComboObject('group1', 1, 145, 0, 0, 1, true);</script></td>
				</tr>
				</table>
			<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="70">Type/Size</td>
					<td width="170" style="padding-left:0;"><script language="javascript">ComComboObject('eq_tpsz_cd', 1, 145, 0, 0, 1, true);</script>&nbsp;<!--img class="cursor" src="img/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle"--></td>
					<td width="75">Lease Term</td>
					<td width="172"><script language="javascript">ComComboObject('agmt_lstm_cd', 1, 143, 0, 0, 1, true);</script>&nbsp;<!--img class="cursor" src="img/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle"--></td>
					<td width="45">Lessor</td>
					<td width="180"><input type="text" name="vndr_seq" dataformat="eng" style="width:121;ime-mode:disabled" class="input" value="">&nbsp;<img name="btns_vndr" class="cursor" src="img/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle"></td>
					<td width="89">MVMT Status</td>
					<td width=""><script language="javascript">ComComboObject('chss_mvmt_sts_cd', 1, 145, 0, 0, 1, true);</script><!--img class="cursor" src="img/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle"--></td>
				</tr>
				</table>
				<!--  biz_1  (E) -->
		</td></tr>
		</table>
			
		<table class="height_8"><tr><td></td></tr></table>
		<table class="search" id="mainTable"> 
       	<tr><td class="bg">
			<!--  biz_2  (S)  -->
			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
			<!-- Grid (E) -->
			<!--  biz_2  (E)  -->
			</td></tr>
		</table>
				
		</td></tr>
		</table>	
			
			
	<!--biz page (E)-->
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:0;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve" id="btn_Retrieve">Retrieve</td>
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
					<td class="btn1" name="btn_downexcel">Down&nbsp;Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>