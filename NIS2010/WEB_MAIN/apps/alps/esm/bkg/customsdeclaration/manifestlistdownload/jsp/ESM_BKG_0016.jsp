<%/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ui_bkg_0016.jsp
 *@FileTitle : ACI_Vessel Information
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.24
 *@LastModifier : 김민정
 *@LastVersion : 1.0
 * 2009.04.24 김민정
 * 1.0 Creation
=========================================================*/%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.event.EsmBkg0016Event"%>
<%@ page import="org.apache.log4j.Logger"%>
<%
	EsmBkg0016Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.hanjin.apps.CustomsDeclaration.ManifestListDownload");

	try
	{
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0016Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null)
		{
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}
	catch (Exception e)
	{
		out.println(e.toString());
	}
	String office = "CA";
	if (!"ESM_BKG_0016".equals(request.getParameter("pgmNo")))
	{
		office = "Origin";
	}
%>
<html>
<head>
<title>Canada ACI: Vessel Information Set-Up</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body onLoad="setupPage();">
<form name="form" method="post">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows"> 
<input type="hidden" name="office" value="<%=office%>"> 
<!-- 개발자 작업	-->

<table width="100%" border="0" cellpadding="0" cellspacing="0"
	style="padding-top: 2; padding-left: 5;">
	<tr>
		<td valign="top"><!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0"
			class="title">
			<tr>
				<td class="history"><img src="img/icon_history_dot.gif"
					align="absmiddle"><span id="navigation"></span></td>
			</tr> 
			<tr>
				<td class="title"><img src="img/icon_title_dot.gif"
					align="absmiddle"><span id="title"></span></td>
			</tr>
		</table> 
		<!--Page Title, Historical (E)--> <!--biz page (S)-->

		<table class="search" id="mainTable">
			<tr> 
				<td class="bg">
				<table class="search" border="0" style="width: 979;">
					<tr class="h23">
						<td width="90">&nbsp;&nbsp;Vessel Code</td>
						<td width=""><input type="text"
							style="width: 50; ime-mode: disabled" class="input1"
							required minLength="4" maxLength="4" dataformat="engup" 
				 			name="frm_vsl_cd" caption="Vessel Code"></td>
					</tr>
				</table>

				<table class="line_bluedot">
					<tr>
						<td colspan="6"></td>
					</tr> 
				</table>

				<table border="0" style="width: 800; background-color: white;"
					class="grid2">
					<tr class="h23" align="center">
						<td width="117" class="tr2_head">Lloyd No.</td>
						<td width="130" class="noinput2"><input type="text"
							style="width: 100%; text-align: center" class="noinput2"
							readOnly="true" name="frm_lloyd_no"></td>
						<td width="113" class="tr2_head">Country</td>
						<td width="130" class="noinput2"><input type="text"
							style="width: 100%; text-align: center" class="noinput2"
							readOnly="true" name="frm_vsl_rgst_cnt_cd"></td>
						<td width="110" class="tr2_head">Name</td>
						<td width="" class="noinput2"><input type="text"
							style="width: 100%; text-align: center" class="noinput2"
							readOnly="true" name="frm_vsl_eng_nm"></td>
					</tr>
				</table>

				<table class="height_5"><tr><td></td></tr></table>

				<table border="0" style="width: 800; background-color: white;"
					class="grid2">
					<tr class="h23" align="center">
						<td width="117" class="tr2_head">Registry Port</td>
						<td width="130" class="noinput2"><input type="text"
							style="width: 100%; text-align: center" class="noinput2"
							readOnly="true" name="frm_rgst_port_cd"></td>
						<td width="113" class="tr2_head">Registry Official No.</td>
						<td width="130" class="noinput2"><input type="text"
							style="width: 100%;text-align:center" class="noinput2" readOnly="true"
							name="frm_rgst_no"></td>
						<td width="110" class="tr2_head">Registry Date</td>
						<td width="" class="noinput2"><input type="text"
							style="width: 100%; text-align: center" class="noinput2"
							readOnly="true" name="frm_rgst_dt"></td>
					</tr>
					<tr class="h23" align="center">
						<td width="110" class="tr2_head">Gross Weight</td>
						<td width="130" class="noinput2"><input type="text"
							style="width: 100%; text-align: right" class="noinput2"
							readOnly="true" name="frm_grs_rgst_tong_wgt"></td>
						<td width="110" class="tr2_head">Net Weight</td>
						<td width="130" class="noinput2"><input type="text"
							style="width: 100%; text-align: right" class="noinput2"
							readOnly="true" name="frm_net_rgst_tong_wgt"></td>
						<td width="110" class="tr2_head">Dead Weight</td>
						<td width="" class="noinput2"><input type="text"
							style="width: 100%; text-align: right" class="noinput2"
							readOnly="true" name="frm_dwt_wgt"></td>
					</tr>
					<tr class="h23" align="center">
						<td width="117" class="tr2_head">Crew</td>
						<td width="130" class="noinput2"><input type="text"
							style="width: 100%; text-align: right" class="noinput2"
							readOnly="true" name="frm_crw_knt"></td>
						<td width="110" class="tr2_head">Call Sign</td>
						<td width="130" class="noinput2"><input type="text"
							style="width: 100%; text-align: center" class="noinput2"
							readOnly="true" name="frm_call_sgn_no"></td>
						<td width="110" class="tr2_head">L.O.A.</td>
						<td width="" class="noinput2"><input type="text"
							style="width: 100%; text-align: right" class="noinput2"
							readOnly="true" name="frm_loa_len"></td>
					</tr>
				</table>

				<table class="line_bluedot">
					<tr>
						<td colspan="6"></td>
					</tr>
				</table>

				<table border="0" style="width: 800; background-color: white;"
					class="grid2">
					<tr class="h23" align="center">
						<td width="117" class="tr2_head">Safety Construction</td>
						<td width="130"><input type="text"
							style="width: 100%; text-align: center; ime-mode: disabled"
							class="noinput" name="frm_vsl_sft_cstru_certi_exp_dt" dataformat="ymd" caption="Safety Construction" maxlength="10"></td>
						<td width="113" class="tr2_head">Safety Radio</td>
						<td width="130"><input type="text"
							style="width: 100%; text-align: center; ime-mode: disabled" class="noinput"
							name="frm_vsl_sft_rdo_certi_exp_dt" dataformat="ymd" caption="Safety Radio" maxlength="10"></td>
						<td width="110" class="tr2_head">Safety Equipment</td>
						<td width=""><input type="text"
							style="width: 100%; text-align: center; ime-mode: disabled" maxlength="10"
							class="noinput" name="frm_vsl_sft_eq_certi_exp_dt" dataformat="ymd" caption="Safety Equipment"></td>
					</tr>
					<tr class="h23" align="center">
						<td width="117" class="tr2_head">Loadline</td>
						<td width="130"><input type="text"
							style="width: 100%; text-align: center; ime-mode: disabled" class="noinput" maxlength="10"
							name="frm_vsl_lod_line_certi_exp_dt" dataformat="ymd" caption="Loadline"></td>
						<td width="113" class="tr2_head">Derat</td>
						<td width="130"><input type="text"
							style="width: 100%; text-align: center; ime-mode: disabled" maxlength="10"
							class="noinput" name="frm_vsl_derat_certi_exp_dt" dataformat="ymd" caption="Derat"></td>
						<td width="110" class="tr2_head">Carrier Code</td>
						<td width="" class="noinput2"><input type="text"
							style="width: 100%; text-align: center" class="noinput2"
							readOnly="true" name="frm_crr_cd"></td>
					</tr>
				</table>
				</td>
			</tr>
		</table>

		<div style="display: none">
			<script language="javascript">ComSheetObject('sheet1');</script>
		</div>

		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0"
			cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">
			<tr>
				<td class="btn1_bg">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td class="btn1_line"></td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_save">Save</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
		<!--Button (E) --> <!-- 본문끝 --></td>
	</tr>
</table>
<!-- 본문끝 --> 
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>