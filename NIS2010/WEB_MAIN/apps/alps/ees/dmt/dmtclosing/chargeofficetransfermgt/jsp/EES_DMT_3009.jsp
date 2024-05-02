<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_3009.jsp
*@FileTitle : Office Transfer History
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.07.14 황효근
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
<%@ page import="com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeofficetransfermgt.event.EesDmt3009Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesDmt3009Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_ofc		= "";
	String strRhq_ofc_cd	= "";
	Logger log = Logger.getLogger("com.hanjin.apps.DMTClosing.ChargeOfficeTransferMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id		= account.getUsr_id();
		strUsr_nm		= account.getUsr_nm();
		strUsr_ofc		= account.getOfc_cd();
		strRhq_ofc_cd	= account.getRhq_ofc_cd();
		//if(strRhq_ofc_cd.equals("SELHO")) strRhq_ofc_cd = "SHARC";

		event = (EesDmt3009Event)request.getAttribute("Event");
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
<title>Office Transfer History</title>
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


<!-- 개발자 작업	-->
<input type="hidden" name="usr_ofc_cd"	value="<%=strUsr_ofc%>">
<input type="hidden" name="rhq_ofc_cd"	value="<%=strRhq_ofc_cd%>">
<input type="hidden" name="ofc_cd">
<input type="hidden" name="fm_ofc_cd">
<input type="hidden" name="to_ofc_cd">
<input type="hidden" name="dmdt_trf_cd">
<input type="hidden" name="fm_rhq"		value="<%=strRhq_ofc_cd%>">
<input type="hidden" name="to_rhq"		value="<%=strRhq_ofc_cd%>">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
	<!--Page Title, Historical (E)-->
	
	<table class="search"> 
       		<tr><td class="bg">
				<!--  biz_1  (S) -->
				
				<table class="search_sm" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="">
						
				<table class="search" border="0" style="width:960;"> 
					<tr class="h23">
						<td width="70"><input type="radio" name="cond_type" value="date" class="trans"checked>Date</td>
						<td width="55" class="stm" id="OTDate">O/T Date</td>
						<td width="225">
							<input type="text" name="fm_cre_dt" maxlength="8" dataformat="ymd"  caption="O/T From Date" style="width:80;" class="input1">&nbsp;~&nbsp;
							<input type="text" name="to_cre_dt" maxlength="8" dataformat="ymd"  caption="O/T To Date"   style="width:80;" class="input1">&nbsp;<img src="img/btns_calendar.gif" name="btns_calendar" 
							width="19"height="20"alt=""border="0"align="absmiddle"class="cursor"></td>
						<td width="70" class="stm">From Office</td>
						<td width="146" class="stm" style="padding-left:2;"><script language="javascript">ComComboObject('fm_ofc', 1, 70, 0, 0, 0, true);</script></td>
						<td width="64" class="stm">To Office</td>
						<td width="150" class="stm" style="padding-left:0;"><script language="javascript">ComComboObject('to_ofc', 1, 70, 0, 0, 0, true);</script></td>
						<td width="35" class="stm">Tariff</td>
						<td width=""><script language="javascript">ComComboObject('tariff_type', 2, 70, 1, 0);</script>&nbsp;<img src="img/btns_multisearch.gif"width="19"height="20"alt=""border="0"align="absmiddle"class="cursor"></td>
					</tr>
				</table>
				
				<table class="search" border="0" style="width:960;"> 
					<tr class="h23">
						<td width="70"><input type="radio" name="cond_type" value="cntr" class="trans">CNTR</td>
						<td width="55" class="stm">BKG No.</td>
						<td width="225" class="sm"><input type="text" name="bkg_no" dataformat="engup2" style="width:100;" class="input">&nbsp;<img src="img/btns_multisearch.gif" 
							name="btns_multisearch1" width="19"height="20"alt=""border="0"align="absmiddle" class="cursor" onClick="doProcessPopup('m_bkg_no')"></td>
						<td width="70" class="stm">B/L No.</td>
						<td width="150" class="stm"><input type="text" name="bl_no" dataformat="engup2" style="width:110;" class="input">&nbsp;<img src="img/btns_multisearch.gif" 
							name="btns_multisearch2" width="19"height="20"alt=""border="0"align="absmiddle"class="cursor" onClick="doProcessPopup('m_bl_no')"></td>
						<td width="60" class="stm">CNTR No.</td>
						<td width="" class="stm"><input type="text" name="cntr_no" dataformat="engup2" style="width:110;" class="input">&nbsp;<img src="img/btns_multisearch.gif" 
							name="btns_multisearch3" width="19"height="20"alt=""border="0"align="absmiddle"class="cursor" onClick="doProcessPopup('m_cntr_no')"></td>
					</tr>
				</table>
				
				
				
					</td></tr>
				</table>
				
				
				
				
				
				<!--  biz_1  (E) -->
				
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				
				<!-- Grid  (S) -->
				
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>				

				<!-- Grid  (e) -->
			</td></tr>
		</table>
		
<!-- : ( Search Options ) (E) -->
			
			</td></tr>
		</table>
	<!-- Tab BG Box  (S) -->
	<!--biz page (E)-->
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_ByBKG">by BKG</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_ByCNTR">by CNTR</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_DownExcel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
		</td></tr>
		</table>
    <!--Button (E) -->
	</td></tr>
</table>
	</td></tr>
</table>
<div id="topdeck" style="position:absolute;visibility:hidden;z-index:200;"></div>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>