
<%
	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : ESM_BKG_0649.jsp
	 *@FileTitle : Cancel Issue Release
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2009.07.20
	 *@LastModifier : 이진서
	 *@LastVersion : 1.0
	 * 2009.07.20 이진서
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event.EsmBkg0059Event"%>

<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg0059Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String strOfc_cd = "";
	Logger log = Logger.getLogger("com.hanjin.apps.OutboundBLMgt.BLIssuance");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

		event = (EsmBkg0059Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Doc Requirement</title>
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

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd"> 
<input type="hidden" name="pagerows"> 
<input type="hidden" name="strUsr_id" value="<%=strUsr_id%>">
<input type="hidden" name="strOfc_cd" value="<%=strOfc_cd%>"> 
 <!-- 개발자 작업	--> 
 <input type="hidden" name="bkg_no" value='<%=JSPUtil.getParameter(request, "bkg_no")%>'> 
 <input type="hidden" name="bl_no" value='<%=JSPUtil.getParameter(request, "bl_no")%>'>
 <!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0">
	<tr>
		<td class="top"></td>
	</tr>
	<tr>
		<td valign="top"><!-- : ( Title ) (S) -->
		<table width="100%" border="0">
			<tr>
				<td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Documentation Requirement</td>
			</tr>
		</table>
		<!-- : ( Title ) (E) --> <!--biz page (S)-->
		<table class="search" id="mainTable">
			<tr>
				<td class="bg"><!--  biz_1  (S) -->
				<table border="0" style="width: 100%;" class="search_sm2">
					<tr class="h23">
						<td width="80" rowspan=2>&nbsp;B/L Type</td>
						<td width="" class="stm"><label for="bl_tp_cd1"><input type="radio" value="W" name="bl_tp_cd" id='bl_tp_cd1' class="trans">&nbsp;&nbsp; Sea Waybill &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label> <label for="bl_tp_cd2"><input type="radio" value="O" name="bl_tp_cd" id='bl_tp_cd2' class="trans">&nbsp;&nbsp; O.B/L (<label for="bl_tp_cd3">
                        <input type="checkbox" value="S" onClick="checkOption()" name="bl_tp_cd" id='bl_tp_cd3' class="trans">&nbsp;&nbsp;B/L Surrender</label>)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label></td>
						<input type="hidden" name="frm_sheet1_rqst_bl_tp_cd">
					</tr>
					<tr class="h23">
						<td width="" class="stm"><label for="bl_tp_cd4"><input type="radio" value="I" name="bl_tp_cd" id='bl_tp_cd4' class="trans">&nbsp;&nbsp; Web. O.B/L &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label> </td>
					</tr>
				</table>
				<table class="height_2">
					<tr>
						<td></td>
					</tr>
				</table>
				<table border="0" style="width: 100%;" class="search_sm2">
					<tr class="h23">
						<td width="100%" colspan="4">
						<table class="search" border="0">
							<tr>
								<td class="title_h"></td>
								<td class="title_s">No. of Document to Print</td>
								<td width=190>&nbsp;</td>
								<td>
								<table width="80" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr>
									<td class="btn1_left"></td>
									<td class="btn1" name="btn_pre_set" id="btn_pre_set">Pre Set</td>
									<td class="btn1_right"></td>
									</tr>
								</table>
								</td>
							</tr>
							<tr>
								<td class="height_2"></td>
							</tr>
						</table>
						</td>

					</tr>
					<tr class="h23">
						<td width="" colspan="4">
						<table border="0" style="width: 440; background-color: white;" class="grid2">
							<tr>
								<td width="20%" class="tr_head"></td>
								<td width="23%" class="tr_head2">Rated</td>
								<td width="23%" class="tr_head2">Unrated</td>
								<td width="" class="tr_head3">Total</td>
							</tr>

							<tr>
								<td width="" class="tr_head">Original B/L</td>
								<td width="" class="noinput"><input type="text" style="width: 100%;" class="input" maxlength="8" dataformat="int" style="ime-mode:disabled" value="" name="frm_sheet1_obl_rt_incl_knt"></td>
								<td width="" class="noinput"><input type="text" style="width: 100%;" class="input" maxlength="8" dataformat="int" style="ime-mode:disabled" value="" name="frm_sheet1_obl_rt_xcld_knt"></td>
								<td width="" class="noinput"><input type="text" style="width: 100%;" class="input" value="" name="frm_sheet1_obl_ttl_knt" readonly></td>
							</tr>

							<tr>
								<td width="" class="tr_head">N/N Copy</td>
								<td width="" class="noinput"><input type="text" style="width: 100%;" class="input" maxlength="8" dataformat="int" style="ime-mode:disabled" value="" name="frm_sheet1_non_nego_rt_incl_knt"></td>
								<td width="" class="noinput"><input type="text" style="width: 100%;" class="input" maxlength="8" dataformat="int" style="ime-mode:disabled" value="" name="frm_sheet1_non_nego_rt_xcld_knt"></td>
								<td width="" class="noinput"><input type="text" style="width: 100%;" class="input" value="" name="frm_sheet1_cpy_ttl_knt" readonly></td>
							</tr>
							<tr>
								<td width="" class="tr_head">SWB</td>
								<td width="" class="noinput" colspan=3>&nbsp;<input type="checkbox" name="chk_rate" value="Y" class="trans" onClick="checkOptionForSwb()" >&nbsp;<b>Rated</b>
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="checkbox" name="chk_unrate" value="Y" class="trans" onClick="checkOptionForSwb()">&nbsp;<b>Unrated</b>
								<input type="hidden" name="frm_sheet1_wbl_rt_tp_cd"></td>
							</tr>
						</table>
						</td>
					</tr>
				</table>
				<table class="height_2">
					<tr>
						<td></td>
					</tr>
				</table>

				<table border="0" style="width: 100%;" class="search">
					<tr class="h23">
						<td width="20%">&nbsp;&nbsp;Email</td>
						<td width=""><input type="text" style="width: 335;" class="input" value="" name="frm_sheet1_wbl_eml"></td>
					</tr>
					<tr class="h23">
						<td width="20%">&nbsp;&nbsp;Issue Place</td>
						<td width=""><input type="text" style="width: 165;" class="input" value="" maxlength="100" dataformat="uppernum" style="ime-mode:disabled" name="frm_sheet1_rqst_iss_plc_nm">&nbsp; <input type="text" style="width: 160;" class="input2" value="" name="frm_sheet1_loc_nm" readonly></td>
					</tr>
					<tr class="h23">
						<td width="">&nbsp;&nbsp;Issue Date</td>
						<td width=""><input type="text" style="width: 165;" class="input" maxlength="10" dataformat="ymd" style="ime-mode:disabled" value="" name="frm_sheet1_rqst_iss_dt"></td>
					</tr>
				</table>
				<table class="height_2">
					<tr>
						<td></td>
					</tr>
				</table>
				<table border="0" style="width: 100%;" class="search_sm2">
					<tr class="h23">
						<td width="80">&nbsp;Deliver To</td>
						<td class="stm"><label for="bl_de_to_cd1"><input type="radio" value="S" name="bl_de_to_cd" id="bl_de_to_cd1" class="trans">Shipper&nbsp;&nbsp;&nbsp;</label> <label for="bl_de_to_cd2"><input type="radio" value="F" name="bl_de_to_cd" id="bl_de_to_cd2" class="trans">FWDR</label></td>
						<input type="hidden" name="frm_sheet1_bl_de_to_cd">
					</tr>
				</table>
				<table class="height_2">
					<tr>
						<td></td>
					</tr>
				</table>
				<table border="0" style="width: 100%;" class="search_sm2">
					<tr class="h23">
						<td width="80">&nbsp;&nbsp;Method</td>
						<td class="stm"><label for="bl_de_mzd_cd1"><input type="radio" value="E" name="bl_de_mzd_cd" id="bl_de_mzd_cd1" class="trans">Express Mail&nbsp;&nbsp;</label> <label for="bl_de_mzd_cd2"><input type="radio" value="R" name="bl_de_mzd_cd" id="bl_de_mzd_cd2" class="trans">Regular Mail&nbsp;&nbsp;</label> <label for="bl_de_mzd_cd3"><input type="radio" value="P" name="bl_de_mzd_cd" id="bl_de_mzd_cd3" class="trans">Pick Up</label></td>
						<input type="hidden" name="frm_sheet1_bl_de_mzd_cd">
					</tr>
				</table>
				<table class="height_2">
					<tr>
						<td></td>
					</tr>
				</table>
				<table border="0" style="width: 100%;" class="search">
					<tr class="h23">
						<td width="20%">&nbsp;&nbsp;Remark(s)</td>
						<td width=""><textarea rows="5" style="width: 99%;" name="frm_sheet1_bl_doc_rqst_rmk">
						 </textarea></td>
					</tr>
					<!--  biz_1   (E) -->
				</table>
				<!--biz page (E)--></td>
			</tr>
		</table>


		</td>
	</tr>
</table>

<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
	<tr>
		<td height="71" class="popup"><!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">
			<tr>
				<td class="btn3_bg">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_confirm">Confirm</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td class="btn1_line"></td>
						<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr>
										<td class="btn1_left"></td>
										<td class="btn1" name="btn_close">Close</td>
										<td class="btn1_right"></td>
									</tr>
								</table>
								</td>

							</tr>
						</table>
						</td>
					</tr>
				</table>
				<!--Button (E) --></td>
			</tr>
		</table>
	
<div style="display: none;" id="mainTable"><script language="javascript">ComSheetObject('sheet1');</script></div>
		<!-- : ( Button : pop ) (E) --> <!-- 개발자 작업  끝 -->
</form>
</body>
</html>