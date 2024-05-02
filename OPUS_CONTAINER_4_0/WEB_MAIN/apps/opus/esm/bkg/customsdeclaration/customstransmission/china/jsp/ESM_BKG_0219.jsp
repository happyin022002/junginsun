<%/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_0219.jsp
 *@FileTitle : Inbound Domestic T/S Manifest
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2013-11-01
 *@LastModifier : 민정호
 *@LastVersion : 1.1
 * 2013-11-01 김상수
 * 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.io.HttpUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.event.EsmBkg0219Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0219Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String pageRows    = "100";

	String strUsr_id   = "";
	String strUsr_nm   = "";
	String strCnt_cd   = "";
	String strOfc_cd   = "";

	Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.Customstransmission");

	try {
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strCnt_cd = account.getCnt_cd();
		strOfc_cd = account.getOfc_cd();

		event = (EsmBkg0219Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	} catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Inbound Domestic T/S Manifest</title>
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
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->


<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding:2px 0px 0px 5px;">
	<tr>
		<td valign="top">


			<!-- Page Title, Historical (S) -->
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
			</table>
			<!-- Page Title, Historical (E) -->


			<!--biz page (S)-->
			<table class="search">
				<tr>
					<td class="bg">

						<table class="search" border="0" style="width:979px;">
							<tr class="h23">
								<td width="50">B/L No.</td>
								<td><input type="text" name="bkg_no" class="input1"  style="width:110px; ime-mode:disabled;" dataformat="eng" maxlength="12" required caption="B/L No."></td>
								<td>CNTR Owner&nbsp;
									<input type="text" name="cntr_owner" class="input2" style="width:60px; text-align:center;" readOnly value="COM"></td>
								<td>POR&nbsp;
									<input type="text" name="por_cd" class="input2" style="width:60px; text-align:center;" readOnly></td>
								<td>POL&nbsp;
									<input type="text" name="pol_cd" class="input2" style="width:60px; text-align:center;" readOnly></td>
								<td>T/S Port&nbsp;
									<input type="text" name="pod_cd" class="input2" style="width:60px; text-align:center;" readOnly readOnly value="CNSHA"></td>
								<td>DEL&nbsp;
									<input type="text" name="del_cd" class="input2" style="width:60px; text-align:center;" readOnly></td>
							</tr>
						</table>

						<table class="line_bluedot"><tr><td></td></tr></table>

						<table class="search" border="0" style="width:979px;">
							<tr class="h23">
								<td>Trunk VVD Name&nbsp;
									<input type="text" name="vsl_eng_nm" class="input2"  style="width:100px; text-align:center;" readOnly></td>
								<td>Voyage&nbsp;
									<input type="text" name="skd_voy_no" class="input" style="width:100px; ime-mode:disabled;" dataformat="engnum" maxlength="50"></td>
								<td>Barge Operator&nbsp;
									<input type="text" name="brg_opr" class="input" style="width:100px; ime-mode:disabled;" dataformat="engnum" maxlength="50"></td>
								<td>Terminal&nbsp;
									<input type="text" name="yd_cd" class="input2" style="width:140px; text-align:center;"></td>
							</tr>
						</table>

						<table><tr class="height_5"><td></td></tr></table>

						<table class="search" border="0" style="width:979px;">
							<tr class="h23">
								<td width="60">POD ETA&nbsp;</td>
								<td><input type="text" name="vps_eta_dt" class="input2"  style="width:100px;" readOnly></td>
								<td align="right">&nbsp;English CMDT Name&nbsp;</td>
								<td><input type="text" name="cmdt_nm" class="input2" style="width:200px;" readOnly></td>
								<td align="right">TTL PKG(PKG)&nbsp;</td>
								<td><input type="text" name="pck_qty" class="input2" style="width:100px; text-align:right;" readOnly></td>
							</tr>
							<tr class="h23">
								<td colspan="2" rowspan="4">Marks</br><textarea name="mk_desc" class="textarea1" rows="6" style="width:162px; background-color:#E8E7EC;" readOnly></textarea></td>
								<td align="right">Chinese CMDT Name&nbsp;</td>
								<td><input type="text" name="cmdt_chn_nm" class="input" style="width:200px;" maxlength="50"></td>
								<td align="right">TG.WGT:KGS&nbsp;</td>
								<td><input type="text" name="act_wgt" class="input2" style="width:100px; text-align:right;" readOnly></td>
							</tr>
							<tr class="h23">
								<td align="center" colspan="2" rowspan="3"><div style="width:296px; text-align:left;">Cargo Description</div><textarea name="cmdt_desc" rows="4" style="width:296px; background-color:#E8E7EC;" readOnly></textarea></td>
								<td align="right" class="sm" style="vertical-align:top;">(under 1B/L)</td>
								<td></td>
							</tr>
							<tr class="h23">
								<td align="right">TTL Measure (CBM)&nbsp;</td>
								<td><input type="text" name="meas_qty" class="input2" style="width:100px; text-align:right;" readOnly></td>
							</tr>
							<tr class="h23">
								<td>&nbsp;</td>
								<td>&nbsp;</td>
							</tr>
						</table>

					</td>
				</tr>
			</table>
			<table class="height_8"><tr><td></td></tr></table>


			<!-- Tab (S) -->
			<table class="tab" border="0" cellpadding="0" cellspacing="0" width="100%">
				<tr>
					<td><script language="javascript">ComTabObject("tab1")</script></td>
				</tr>
			</table>
			<!-- Tab (E) -->


			<!-- (TAB) Container Info (S) -->
			<div id="tabLayer" style="display:inline">
				<table class="search">
					<tr>
						<td class="bg">
							<!-- Grid  (S) -->
							<table width="100%"  id="mainTable">
								<tr>
									<td width="100%">
										<script language="javascript">ComSheetObject("sheet1");</script>
									</td>
								</tr>
							</table>
							<!-- Grid (E) -->
						</td>
					</tr>
				</table>
			</div>
			<!-- (TAB) Container Info (E) -->


			<!-- (TAB) Customer Info(S) -->
			<div id="tabLayer" style="display:none">
				<table class="search">
					<tr>
						<td class="bg" height="256px" valign="top">
							<table width="100%" class="grid2">
								<tr>
									<td rowspan="2" class="tr2_head" width="15%">Shipper</td>
									<td><input type="text" name="shpr_nm" style="width:100%;" class="noinput" readOnly></td>
								</tr>
								<tr>
									<td><input type="text" name="shpr_addr" style="width:100%;" class="noinput" readOnly></td>
								</tr>
								<tr>
									<td rowspan="2" class="tr2_head">Consignee</td>
									<td><input type="text" name="cnee_nm" style="width:100%;" class="noinput" readOnly></td>
								</tr>
								<tr>
									<td><input type="text" name="cnee_addr" style="width:100%;" class="noinput" readOnly></td>
								</tr>
								<tr>
									<td rowspan="2" class="tr2_head">Notify</td>
									<td><input type="text" name="ntfy_nm" style="width:100%;" class="noinput" readOnly></td>
								</tr>
								<tr>
									<td><input type="text" name="ntfy_addr" style="width:100%;" class="noinput" readOnly></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>

			</div>
			<!-- (TAB) Customer Info (E) -->


			<!-- (TAB) Special Cargo Detail (S) -->
			<div id="tabLayer" style="display:none">
				<table class="search">
					<tr>
						<td class="bg" height="256px" align="center" valign="top">
							<table width="50%" class="grid2">
								<tr>
									<td colspan="2" class="tr2_head" width="40%">Celsius / Fahrenheit</td>
									<td><select name="tmp_div" style="width:100%;" class="input">
											<option value="" selected></option>
											<option value="C">&nbsp;&nbsp;&nbsp;(C) Celsius</option>
											<option value="F">&nbsp;&nbsp;&nbsp;(F) Fahrenheit</option>
										</select></td>
								</tr>
								<tr>
									<td colspan="2" class="tr2_head">RF Cargo Initial Temp(F/C)</td>
									<td><input type="text" name="rf_tmp" style="width:100%; ime-mode:disabled; text-align:right;" class="input" dataformat="engnum"></td>
								</tr>
								<tr>
									<td colspan="2" class="tr2_head">Final Temp(F/C)</td>
									<td><input type="text" name="fnl_tmp" style="width:100%; ime-mode:disabled; text-align:right;" class="input" dataformat="engnum"></td>
								</tr>
								<tr>
									<td colspan="2" class="tr2_head">DG Cargo Class</td>
									<td><input type="text" name="dg_cls" style="width:100%; ime-mode:disabled;" class="input" dataformat="engnum"></td>
								</tr>
								<tr>
									<td colspan="2" class="tr2_head">DG UN No.</td>
									<td><input type="text" name="dg_un" style="width:100%; ime-mode:disabled;" class="input" dataformat="engnum"></td>
								</tr>
								<tr>
									<td rowspan="5" class="tr2_head">AK Over Dimension</td>
									<td class="tr2_head">Front</td>
									<td><input type="text" name="over_frnt" style="width:100%; ime-mode:disabled; text-align:right;" class="input" dataformat="float"></td>
								</tr>
								<tr>
									<td class="tr2_head">Rear</td>
									<td><input type="text" name="over_rear" style="width:100%; ime-mode:disabled; text-align:right;" class="input" dataformat="float"></td>
								</tr>
								<tr>
									<td class="tr2_head">Height</td>
									<td><input type="text" name="over_hght" style="width:100%; ime-mode:disabled; text-align:right;" class="input" dataformat="float"></td>
								</tr>
								<tr>
									<td class="tr2_head">Left</td>
									<td><input type="text" name="over_left" style="width:100%; ime-mode:disabled; text-align:right;" class="input" dataformat="float"></td>
								</tr>
								<tr>
									<td class="tr2_head">Right</td>
									<td><input type="text" name="over_rght" style="width:100%; ime-mode:disabled; text-align:right;" class="input" dataformat="float"></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</div>
			<!-- (TAB)  Special Cargo Detail  (E) -->


			<!-- : (Button) (S) -->
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:13;">
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
								 <td class="btn1_line"></td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_Downexcel">Down Excel</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<!-- : (Button : pop) (E) -->


			<!-- Hidden Grid (S) -->
			<table width="100%" id="mainTable">
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject("sheet2");</script>
					</td>
				</tr>
			</table>
			<!-- Hidden Grid (E) -->


		</td>
	</tr>
</table>
<!-- 본문끝 -->


<!-- 개발자 작업  끝 -->
</form>
</body>
</html>