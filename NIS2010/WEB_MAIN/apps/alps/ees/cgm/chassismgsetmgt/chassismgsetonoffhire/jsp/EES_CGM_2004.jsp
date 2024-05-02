<%
	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : ees_cgm_2004.jsp
	 *@FileTitle : Own M.G.Set Master Creation
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2013.07.09
	 *@LastModifier : 조경완
	 *@LastVersion : 1.0
	 * 2009.06.23 박의수
	 * 1.0 Creation
	 *--------------------------------------------------
	 * History
	 * 2013.07.09 조경완 [CHM-201325340-01] Role Hard Coding 제거 및 대체 기능 개발
	 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.event.EesCgm2004Event"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@ page import="com.hanjin.framework.component.util.io.HttpUtil"%>
<%@ page import="com.hanjin.syscommon.common.util.UserRoleUtil" %>
<%@ page import="com.hanjin.syscommon.common.table.ComUsrRoleVO" %>

<%
	EesCgm2004Event event     = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg          = ""; //에러메세지
	int rowCount              = 0; //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList    = "";
	String pageRows    = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String strOfc_cd = "";
	String tRole = ""; //Transaction Role //chungpa 20100304 transaction role apply
	
	Logger log       = Logger.getLogger("com.hanjin.apps.ChassisMgsetMgt.ChassisMgsetOnOffhire");
	String xml = HttpUtil.makeXML(request,response);
	
	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

		event = (EesCgm2004Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        
		//2013-07-09 조경완 Rold Code 하드코딩 대체 
		// if("SELCOE".equals(strOfc_cd)||"NYCNA".equals(strOfc_cd)||"ATLSC".equals(strOfc_cd)||"PHXSC".equals(strOfc_cd)){
		// 2015 조직코드개편 Chang-Young Kim
		if("SELCON".equals(strOfc_cd)||"NYCRA".equals(strOfc_cd)||"ATLSA".equals(strOfc_cd)||"PHXSA".equals(strOfc_cd)){
			tRole = "Authenticated";
		}else{
			tRole = "Not Authenticated";
		}
	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Own M.G.Set Master Creation</title>
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

<body onLoad="setupPage();">
<form name="form2">
<input type="hidden" name="sXml" value="<%=xml.replace("\"","'")%>">
</form>
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="trole" value="<%=tRole%>">

<!-- 개발자 작업	-->

<input type="hidden" class="input2" style="width:50;text-align:center"  name="eq_knd_cd" value="G">
<input type="hidden" class="input2" style="width:50;text-align:center"  name="page_status">
<input type="hidden" class="input2" style="width:120;text-align:center" name="eq_lot_no_tmp">
<input type="hidden" class="input2" style="width:130;text-align:center" name="eq_spec_no_tmp">
<input type="hidden" class="input2" style="width:50;text-align:center"  name="agmt_ver_no">
<input type="hidden" class="input2" style="width:50;text-align:center"  name="agmt_ofc_cty_cd">
<input type="hidden" class="input2" style="width:50;text-align:center"  name="agmt_seq">
<input type="hidden" class="input2" style="width:100;text-align:center"  name="agmt_no">
<input type="hidden" name="vndr_seq_agree"><!-- chungpa 20090805 Financing No remove req by KSJ.  -->
<input type="hidden" name="eq_tpsz_cd">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2; padding-left:5;">
	<tr>
		<td valign="top">
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
            <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
            <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>

		<!--biz page (S)-->
		<table class="search">
			<tr>
				<td class="bg">
				<table class="search" border="0" style="width: 979;">
					<tr class="h23">
						<td width="150">M.G.Set Serial Range</td>
						<td width="">
							<script language="javascript">ComComboObject('mgset_range', 1, 220, 1, 0, 1, true);</script>
							<!--
							<select style="width: 200;" class="input1">
								<option value="0"></option>
							</select>
							-->
						</td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
		<table class="height_10">
			<tr>
				<td colspan="8"></td>
			</tr>
		</table>
		<table class="search">
			<tr>
				<td class="bg">
				<table class="search" border="0" style="width: 979;">
					<tr class="h23">
						<td width="100">Serial Range</td>
						<td width="" class="sm">
							<input type="text" style="width:50;ime-mode:disabled; text-align: center" class="input"  dataformat="engup" maxlength="4" name="eq_pfx_cd">&nbsp;
							<input type="text" style="width:60;ime-mode:disabled; text-align: center" class="input"  dataformat="isnum" maxlength="6" name="fm_ser_no">&nbsp;-&nbsp;&nbsp;
							<input type="text" style="width:60;ime-mode:disabled; text-align: center" class="input"  dataformat="isnum" maxlength="6" name="to_ser_no">&nbsp;
							<input type="text" style="width:70;ime-mode:disabled; text-align: center" class="input2" name="units" readonly>&nbsp;&nbsp;Unit(s)
						</td>
					</tr>
					<tr class="h23">
						<td width="">Model No.</td>
						<td width="" style="padding-left:2">
							<script language="javascript">ComComboObject('eq_spec_no', 1, 368, 1, 1, 1, true);</script>
							<!--
							<select style="width: 266;" class="input1" name="eq_spec_no">
								<option value="0"></option>
							</select>
							-->
						</td>
					</tr>
					<tr class="h23">
						<td width="">Maker</td>
						<td width="">
							<input type="text" style="width: 368; text-align: left" class="input2" name="vndr_lgl_eng_nm_eqspec" readonly>
						</td>
					</tr>
					<tr class="h23">
						<td width="">Voltage</td>
						<td width="" class="sm">
							<input type="text" style="width: 60; text-align: center" class="input2" name="mgst_vltg_capa" readonly>&nbsp;&nbsp;Volt
						</td>
					</tr>
					<tr class="h23">
						<td width="">Fuel Capacity</td>
						<td width="" class="sm">
							<input type="text" style="width: 60; text-align: center" class="input2" name="mgst_fuel_capa" readonly>&nbsp;&nbsp;ltrs
						</td>
					</tr>
					<tr class="h23">
						<td width="">Delivery Month</td>
						<td width="" class="sm">
							<input type="text" name="de_yrmon" style="width:100; ime-mode:disabled; text-align:center;" dataformat="ym" onfocus="domFunFocusDel(this)" class="input1"  maxlength="6">
							<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_Calendar_b">
						</td>
					</tr>
				</table>
				<table class="line_bluedot">
					<tr>
						<td colspan="6"></td>
					</tr>
				</table>
				<table class="search" border="0" style="width: 979;">
					<tr class="h23">
						<td width="100">Agreement No.</td>
						<td width="" class="sm">
							<input type="text" style="width:100;ime-mode:disabled" dataformat="engup" class="input1" name="agreement_no" maxlength="9">
							<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" id="btn_popup" name="btn_ComOpenPopupWithTargetAgree">
						</td>
					</tr>
					<tr class="h23">
						<td width="">Lease Term</td>
						<td width="">
							<input type="text" style="width: 100; text-align: center" class="input2" name="agmt_lstm_cd" readonly>
						</td>
					</tr>
					<tr class="h23">
						<td width="">Office</td>
						<td width="">
							<input type="text" style="width: 100;text-align: center" class="input2" name="agmt_iss_ofc_cd" readonly>
						</td>
					</tr>
					<tr class="h23">
						<td width="">Date</td>
						<td width="">
							<input type="text" name="cre_dt" style="width:100;text-align: center;ime-mode:disabled; text-align:center;" dataformat="ymd" onfocus="domFunFocusDel(this)" class="input2"  maxlength="8" readonly>
							<!--  
							<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_Calendar">
							-->

						</td>
					</tr>
					<!-- chungpa 20090805 Financing No remove req by KSJ.
					<tr class="h23">
						<td width="">Financing No</td>
						<td width="">
							<input type="text" style="width: 100;text-align: center" class="input2" name="vndr_seq_agree" readonly>
						</td>
					</tr>
					 -->
					
					<tr class="h23">
						<td width="">Financier</td>
						<td width="" style="padding-left:2">
							<script language="javascript">ComComboObject('financier', 1, 368, 1, 0, 1, true);</script>
							<!--
							<select style="width: 267;" class="input" name="vndr_lgl_eng_nm_agree">
								<option value="0"></option>
							</select>
							-->
						</td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
		<!--biz page (E)-->

		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">
			<tr>
				<td class="btn1_bg">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_Retrieve">Retrieve</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td>
						<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_New">New</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td class="btn1_line"></td>
						<td>
						<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_Save">Save</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td>
						<table width="72" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_FA I/F">FA I/F</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
		<!--Button (E) -->
		</td>
	</tr>
</table>

<div id="tabLayer" style="display:none">
<!-- div style="display:none;" -->
	<!-- Grid  (S) -->
		<table width="100%"  id="mainTable"> 
			<tr>
				<td width="100%">
					<script language="javascript">ComSheetObject('sheet1');</script>
				</td>
			</tr>
		</table>
	<!-- Grid  (E) -->
<!-- /div -->

<!-- div style="display:none;" -->
	<!-- Grid  (S) -->
		<table width="100%" id="mainTable" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td width="100%">
					<script language="javascript">ComSheetObject('sheet2');</script>
				</td>
			</tr>
		</table>
<!-- Grid (E) -->
<!-- /div -->
</div>
<!-- 개발자 작업  끝 -->

</form>
</body>
</html>
