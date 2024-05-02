<%
/*========================================================= 
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CGM_1158.jsp
*@FileTitle : Long Staying Chassis Management
*Open Issues :
*Change history :
*@LastModifyDate : 2015-04-07
*@LastModifier : Yulkyu Lee
*@LastVersion : v1.0
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.cgm.chassisreport.chassislongstayingreport.event.EesCgm1158Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.io.HttpUtil"%>

<%
	EesCgm1158Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지

	String strUsr_id		= "";
	String strUsr_nm		= "";	
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		//strUsr_id =	account.getUsr_id();
		//strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EesCgm1158Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
		
	//String fm_dt = JSPUtil.getKST("yyyy-MM-dd");
	//String lt_dt = JSPUtil.getKST("yyyy-MM-dd");
	//String lt_dt = DateTime.addDays(expDt, -10, "yyyy-MM-dd");
%>
<html>
<head>
<title>Performance by S/C NO</title>
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

<input type="hidden" name="inquiryLevel" value=""> 
<input type="hidden" name="location" value=""> 

<!-- scc 입력값 검증에 사용하는 공통 mnr코드 -->
<input type="hidden" name="eq_orz_cht_chktype">
<input type="hidden" name="eq_orz_cht_scc_cd"> 

<!-- 개발자 작업 -->
<input type="hidden" name="eq_knd_cd" value="U">

<!-- Summary Tab의 VOL(box) 값 클릭 시 Detail 조회하기 위한 Hiddenform -->
<input type="hidden" name="hdn_pop_yn" value="N">
<input type="hidden" name="hdn_org_yd_cd">
<input type="hidden" name="hdn_fcntr_flg">
<input type="hidden" name="hdn_finished">
<input type="hidden" name="hdn_fm_sts_cd">
<input type="hidden" name="hdn_lt_sts_cd">
<input type="hidden" name="hdn_cntr_tpsz_cd">
<input type="hidden" name="hdn_mvmt_sts_cd">


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
					<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
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
					<td class="btn1" name="btn_downexcel">Down&nbsp;Excel</td>
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
			<table class="search" border="0" style="width:100%;"> 
			<tr class="h23">				
				<td width="70">Location </td>
				<td width="250"><select style="width:60;" class="input" name="loc_cd">
					<option value="R" >RCC</option>
					<option value="L"  selected>LCC</option>
					<option value="E" >ECC</option>
					<option value="S" >SCC</option>
					<option value="Y" >Yard</option>
					</select>&nbsp;<input type="text" name="loc_list" style="width:140;" class="input" dataformat="engup">&nbsp;<img src="img/btns_multisearch.gif" name="loc_no_multi" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
				</td>					
				<td width="70">MVMT Date</td>
				<td width="230">
					<input name="fm_dt" dataformat="ymd" type="text" maxlength="8" caption="Date"  cofield="lt_dt" class="input" style="ime-mode:disabled; width:80px; text-align:center;" value="">
					&nbsp;~&nbsp;
					<input name="lt_dt" dataformat="ymd" type="text" maxlength="8" caption="Date"  cofield="fm_dt" class="input" style="ime-mode:disabled; width:80px; text-align:center;" value="">&nbsp;<img class="cursor" name="btn_calendar" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">
				</td>
				<td width="70">Bound</td>
				<td width="230"><select style="width:60;" class="input" name="bound_cd">
					<option value=""  selected >All</option>
					<option value="N" >In</option>
					<option value="Y" >Out</option>
				</td>
			</tr> 
			<tr class="h23">				
				<td width="60">TP/SZ </td>
				<td width="250">&nbsp;<script language="javascript">ComComboObject('cntr_tpsz_cd', 1, 150 ,0);</script>		
					<div style="display: none;"><input type="text" name="chk_cntr_tpsz_cd" style="width:150" value="" class="input" readonly></div>			</td>					
				<td width="80">Staying Days</td>
				<td width="230"><input type="text" name="staying_days"  style="width:65;text-align:right;ime-mode:disabled" class="input" value="" dataformat="int" maxlength="6"> or over</td>
				<td width="95">Beyond F.Days</td>
				<td width="200"><input type="text" name="beyond_fdays"  style="width:65;text-align:right;ime-mode:disabled" class="input" value="" dataformat="int" maxlength="6"> or over</td>
			</tr> 
			<tr class="h23">				
				<td width="90">MVMT Status </td>
				<td width="250">&nbsp;<script language="javascript">ComComboObject('mvmt_sts_cd', 1, 150, 0, 0, 1, true);</script></td>
				<td width="70">T.VVD</td>
				<td width="230"><input type="text" name="vvd_no" style="width:140;" class="input" dataformat="engup" >&nbsp;<img src="img/btns_multisearch.gif" name="vvd_no_multi" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>	
			</tr> 
			<tr class="h23">				
				<td width="60">BKG No </td>
				<td width="250"><input type="text" name="bkg_no" style="width:140;" class="input" dataformat="engup">&nbsp;<img src="img/btns_multisearch.gif" name="bkg_no_multi" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>					
				<td width="70">S/C No</td>
				<td width="230"><input type="text" name="sc_no" style="width:140;" class="input" dataformat="engup">&nbsp;<img src="img/btns_multisearch.gif" name="sc_no_multi" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
				<td width="55">CNTR No</td>
				<td width="200"><input type="text" name="cntr_no" style="width:140;" class="input" dataformat="engup">&nbsp;<img src="img/btns_multisearch.gif" name="cntr_no_multi" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
			</tr> 
			

			</table>
			<!--  biz_1   (E) -->
			
			</td></tr>
		</table>
			

		<table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%> 
			<tr><td width="100%">
				<script language="javascript">ComSheetObject('sheet1')</script>
				<!-- img src="img/sub_tab.gif" alt="" width="998" height="23" border="0" -->
			</td></tr>
		</table>

<table class="height_10"><tr><td colspan="8"></td></tr></table>

	</td></tr>
</table>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>