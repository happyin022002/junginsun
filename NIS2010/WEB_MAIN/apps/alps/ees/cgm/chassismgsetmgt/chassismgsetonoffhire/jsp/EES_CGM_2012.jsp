<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_cgm_2012.jsp
*@FileTitle : On & Off-Hire Status Summary Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.02
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.06.02 최민회
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
<%@ page import="com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.event.EesCgm2012Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@page import="com.hanjin.framework.component.util.io.HttpUtil"%>
<%
	EesCgm2012Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id   = "";
	String strUsr_nm   = "";
    String strOfc_id   = "";
	   
	Logger log = Logger.getLogger("com.hanjin.apps.ChassisMgsetMgt.ChassisMgsetOnOffhire");
	String xml = HttpUtil.makeXML(request,response);
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_id = account.getOfc_cd();


		event = (EesCgm2012Event)request.getAttribute("Event");
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
<title>On & Off-Hire Status Summary Inquiry</title>
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

<body  onLoad="setupPage();" onkeyup="ComKeyEnter('search');">
<form name="form2">
<input type="hidden" name="sXml" value="<%=xml.replace("\"","'")%>">
</form>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="yd_cd">
<input type="hidden" name="ofc_cd">
<INPUT TYPE="HIDDEN" NAME="intg_cd_id">
<INPUT TYPE="HIDDEN" NAME="loc_cd">
<input type="hidden" name="s_usr_id" value="<%=strUsr_id %>" >
<input type="hidden" name="s_ofc_id" value="<%=strOfc_id %>" >
<input type="hidden" name="eq_orz_cht_chktype">
<input type="hidden" name="eq_orz_cht_rcc_cd">
<input type="hidden" name="eq_orz_cht_lcc_cd">
<input type="hidden" name="eq_orz_cht_scc_cd">
<input type="hidden" name="chk_ver" value="ver2">

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
		
		
		<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="60">Period</td>
					<td width="330"><input type="text" name="evnt_dt_str" style="width:80;ime-mode:disabled" dataformat="ymd"    class="input1"  maxlength='8'>&nbsp;~&nbsp;
					                <input type="text" name="evnt_dt_end" style="width:80;ime-mode:disabled" dataformat="ymd"    class="input1"  maxlength='8'>&nbsp;<img name="btns_Calendar2" class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"></td>
					<td width="85">On & Off-Hire</td>
					<td width=""style="padding-left:2"><select style="width:95;" class="input1" name="eq_aset_sts_cd">
						<option value="LSO" selected>Off-Hire</option>
					    <option value="LSI" >On-Hire</option>
		                 </select></td>
					<td width="198" align="right" colspan="2"><table border="0" style="width:100%;"class="search_sm2">
					 		<tr  class="h23">
								<TD><input type="radio" value="S"class="trans" name="str_gubun" checked onclick="javascript:chk(1)">&nbsp;Summary&nbsp;&nbsp;<input type="radio"  name="str_gubun" value="D"class="trans" onclick="javascript:chk(2)">&nbsp;Detailed</TD>
							</td></tr></table>
					</td>
					</tr> 
				<tr class="h23">
					<td width="">Location</td>
					<td width="" style="padding-left:2"><script language="javascript">ComComboObject('location', 1, 51, 1, 1, 0, true);</script>
					&nbsp;<input type="text" style="width:65;ime-mode:disabled" dataformat="engup" name="scc_cd"  class="input1"value="" maxlength='5'>&nbsp;<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" id="btn_popup" name="ComOpenPopupWithTarget2"></td>
					<td width="">Yard</td>
					<td width="" style="padding-left:2"><input type="text" dataformat="eng" style="width:70;ime-mode:disabled" maxlength="7" name="sts_evnt_yd_cd"  class="input"value="">&nbsp;<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" id="btn_popup" name="ComOpenPopupWithTargetYard"></td>
					<td width="70">Lease Term</td>
					<td width="" style="padding-left:2"><script language="javascript">ComComboObject('agmt_lstm_cd', 1, 110, 0, 0, 1, true);</script></td>
					</tr> 
					<tr class="h23">
					<td width="">Kind</td>
					<td width="" colspan="4">
					    <select style="width:120;" class="input" name='kind'>
						<option value="L" selected>Lessor</option>
					    <option value="A">Agreement No.</option>
					    </select>&nbsp;<input type="text" style="width:195;" class="input" name="vndr_seq" value="">&nbsp;<img class="cursor" src="img/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle"   id="btn_popup" name="ComOpenPopupWithTargetKind"></td>
				   </tr> 
				</table>
				
				
				</td></tr>
			</table>
			<table class="height_10"><tr><td colspan="8"></td></tr></table>
		<!-- Tab BG Box  (S) -->
     <table class="search"> 
      <tr><td class="bg">
		<div id="tabLayer" style="display:inline">
			<table width="100%"  id="mainTable" border="0" cellpadding="0" cellspacing="0"> 
				<tr>
					<td width="100%">
					<!--시트-->
						<script language="javascript">ComSheetObject('sheet1');</script>
					</td>
				</tr>
			</table>
		</div>
		<div id="tabLayer" style="display:none">
			<table width="100%"  id="mainTable" border="0" cellpadding="0" cellspacing="0"> 
				<tr>
					<td width="100%">
					<!--시트-->
						<script language="javascript">ComSheetObject('sheet2');</script>
					</td>
				</tr>
			</table>
		</div>
	<!-- Tab BG Box  (S) -->
	<!--biz page (E)-->
	
	
	
	</td></tr>
</table>

<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
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
					<td class="btn1" name="btn_downexcel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_print">Print</td>
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