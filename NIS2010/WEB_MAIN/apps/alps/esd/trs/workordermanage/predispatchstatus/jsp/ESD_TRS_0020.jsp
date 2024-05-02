<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0020.jsp
*@FileTitle : Pre-Dispatch Status Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.27
*@LastModifier : 최 선
*@LastVersion : 1.2
* 2006.12.13 kim_sang_geun
* 1.0 최초 생성
*-----------------------------------------------------------
* History
* 2010.10.19  최종혁	1.1 [CHM-201006633] pre-dispatch 조회오류 수정
* 2010.10.27  최 선	1.2 [] pre-dispatch UI 에서, Sent History 및 Preview UI 이동 시, 조회 오류 수정
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.trs.workordermanage.predispatchstatus.event.EsdTrs0020Event"%>
<%
	SignOnUserAccount account = null;
	EsdTrs0020Event  event = null;	//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null; //서버에서 발생한 에러
	DBRowSet rowSet	= null; //DB ResultSet
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String queryParam = JSPUtil.getNull(request.getParameter("queryParam"));
	try {
		account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		event = (EsdTrs0020Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Pre-Dispatch Status Inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>
<script language="javascript">
	var lvParam = "<%=queryParam%>";
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if

		loadPage();
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH, "03");
	}
</script>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input	type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="hid_frmdate" value="">
<input type="hidden" name="hid_todate" value="">
<input type="hidden" name="queryParam" value="">
<input type="hidden" name="ctrl_ofc_cd" value="<%=account.getOfc_cd()%>">
<input type="hidden" name="ctrl_user_id" value="<%=account.getUsr_id()%>">
<input type="hidden" name="rtv_flg" value="">

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>



		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->


		<!-- TABLE '#D' : ( Button : Main ) (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
	       	<tr><td class="btn1_bg">

				<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<!-- Repeat Pattern -->
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" id="btn_retrieve" name="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" id="btn_new" name="btn_new">New</td><td class="btn1_right"></td></tr></table></td>

					<td class="btn1_line"></td>

					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" id="btn_minimize" name="btn_minimize">Minimize</td><td class="btn1_right"></td></tr></table></td>
					<!-- Repeat Pattern -->

				</tr></table>

			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Button : Main ) (E) -->

	 	<div id="showMin" style="display:inline">

		<!-- TABLE '#D' : ( Search Options ) (S) -->
		<table class="search">
			<tr>
				<td class="bg">
				<table class="search_in" border="0">
				<tr class="h23">
				<td width="112">Date</td>
				<td width="578">
					<table border="0" style="height:25; width:507; background-color: #E9E9E9;">
						<tr><td class="sm" width="291" style="padding-left:15;">
								<input type="radio" name="rad_wonotic" class="trans" value="W" checked>Work Order Issue
								<input type="radio" name="rad_wonotic" class="trans" value="L">List Sent
								<input type="radio" name="rad_wonotic" class="trans" value="N">Notice Sent </span>
							</td>
							<td><input name="frm_plandate" type="text" maxlength="8" style="width:75" onFocus="javascript:delHypen(this);" onBlur="javascript:getHypen(this);">&nbsp;~&nbsp;
							    <input name="to_plandate" type="text" maxlength="8" style="width:75" onFocus="javascript:delHypen(this);" onBlur="javascript:getHypen(this);" onKeyup="javascript:doSearchEnter();">
							    <img src="" width="2" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar">
							</td>
						</tr>
					</table>
				</td>
				<td width="270" colspan=2>&nbsp;</td>
				<!-- <td width="58">Status</td>
				<td><select name="select8" onChange="" style="width:208;"><option value="0" selected></option></select></td> -->
			</tr>
		</table>
		<table class="search_in" border="0">
			<tr class="h23">
				<td width="110">Reference No. </td>
				<td width="280"><input name="reference_no" type="text" style="width:215;"></td>
				<td width="120">Work Order No.</td>
				<td><input name="wo_no" type="text" style="width:107;" value=""><img src="" width="2" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle" name="btns_multiwrk"></td>

			</tr>
		</table>

		<table class="search_in" border="0">
			<tr class="h23">
				<td width="110">Booking No.</td>
				<td width="280"><input name="bkg_no" type="text" style="width:190;" value=""><img src="" width="2" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle" name="btns_multibkg"></td>
				<td width="120">Bill Of Lading No.</td>
				<td width="180"><input name="bill_no" type="text" style="width:107;" value=""><img src="" width="2" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle" name="btns_multibl"> </td>
				<td width="150">Container No. </td>
				<td align="right">
					<input name="cntr_no" type="text" style="width:109;" value="" onChange="javascript:this.value=cntrCheckDigit(this.value);"><img src="" width="2" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle" name="btns_multicntr"></td>
			</tr>
		</table>
		<table class="search_in" border="0">
			<tr class="h23">
				<td width="110">Service Provider</td>
				<td width="580"><!-- script language="javascript">ComComboObject('combo_svc_provider', 2, 70, 0)</script -->
					<input name="combo_svc_provider" type="text" style="width:73;" value="" maxlength="6" onBlur="vender_blur();"><img src="" width="2" height="1" border="0"><input type="text" name="trsp_so_vndr_no" style="width:432;" readonly value="" class="input2"><img src="" width="2" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_vender"></td>
				<td width="148">Work Order Issue Office</td>
				<td align="right">
					<input name="wo_iss_ofc_cd" maxlength="5" type="text" style="width:109;" onkeyup="upper(this)"><img src="" width="2" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_woissoffice"></td>

			</tr>
		</table>


			</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->

		<table class="height_10"><tr><td></td></tr></table>

		</div>

		<!-- TABLE '#D' : ( Gird BG Box ) (S) -->
		<table class="search" border="0">
			<tr>
				<td class="bg">

					<table class="height_10"><tr><td></td></tr></table>

					<!-- 'HEAD1-BGCOLOR : 203 240 169' , 'HEAD2-BGCOLOR : 222 251 248' , 'BORDER 1-outside : 88 152 164' ,'BORDER 2-inside : 202 226 233' , 'HEAD-FONT : 39 95 101' , 'SELETED ROW BG : 252 255 233' -->

					<!-- : ( From Location ) (S) -->
					<table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet1');</script>
                        </td></tr>
		            </table>
					<!-- : ( From Location ) (E) -->

					<!-- : ( Grid ) (E) -->
					<!-- : ( Button_ Sub ) (S) -->
					<table width="100%" class="button">
				       	<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>

							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_downexcel" name="btng_downexcel">Down Excel</td><td class="btn2_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_senthistory" name="btng_senthistory">Sent History</td><td class="btn2_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_preview" name="btng_preview">Preview</td><td class="btn2_right"></td></tr></table></td>
							<!-- Repeat Pattern -->


						</tr></table>
					</td></tr>
					</table>
					<!-- : ( Button_ Sub ) (E) -->


				</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Grid BG Box ) (E) -->


</td></tr>
</table>
<!-- Outer Table (E)-->


</form>
<form method="post" name="formRd">
	<input type="hidden" name="ref_no" value="">
	<input type="hidden" name="vndr_seq" value="">
	<input type="hidden" name="so_ofc_cty_cd" value="">
	<input type="hidden" name="so_seq" value="">
	<input type="hidden" name="wo_ofc_cty_cd" value="">
	<input type="hidden" name="wo_seq" value="">
	<input type="hidden" name="ddl" value="">
	<input type="hidden" name="can" value="">
	<input type="hidden" name="loc_date" value="">
	<input type="hidden" name="tit_date" value="">
</form>
</body>
</html>