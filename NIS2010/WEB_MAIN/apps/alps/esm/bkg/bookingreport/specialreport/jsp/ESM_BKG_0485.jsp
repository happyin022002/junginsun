<%
	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : ESM_BKG_0485.jsp
	 *@FileTitle : Special Cargo Manifest
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2009.08.20
	 *@LastModifier : 이일민
	 *@LastVersion : 1.0
	 * 2009.08.20 이일민
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
<%@ page import="org.apache.log4j.Logger"%>
<%
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수
	String successFlag = "";
	String codeList = "";
	String pageRows = "100";
	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.hanjin.apps.BookingReport.SpecialReport");
	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
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
<title>Special cargo summary information</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>
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
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="usr_nm" value="<%=strUsr_nm%>">

<!-- 개발자 작업	-->
<input type="hidden" name="in_out">
<input type="hidden" name="com_mrdPath">
<input type="hidden" name="com_mrdArguments">
<input type="hidden" name="com_mrdSaveDialogDir" value="<%=System.getProperty("user.home")+System.getProperty("file.separator")%>">
<input type="hidden" name="com_mrdSaveDialogFileName">
<input type="hidden" name="com_mrdSaveDialogFileExt" value="pdf">
<input type="hidden" name="com_mrdSaveDialogFileExtLimit" value="xls@pdf@bmp@tif">
<input type="hidden" name="com_mrdTitle">
<input type="hidden" name="com_mrdDisableToolbar" value="3">
<input type="hidden" name="com_mrdBodyTitle">
<input type="hidden" name="com_zoomIn">
<input type="hidden" name="com_isBatch" value="N">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
    <tr><td valign="top">
    <!--Page Title, Historical (S)-->
    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
        <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
    </table>
    <!--Page Title, Historical (E)-->
    </td>
    </tr>
	<tr>
		<td valign="top">

<!--biz page (S)-->
		<table class="search" id="mainTable">
			<tr>
				<td class="bg">
<!--  biz_1  (S) -->
				<table class="search" border="0">
					<tr>
						<td class="title_h"></td>
						<td class="title_s">Special Cargo Manifest Type</td>
					</tr>
				</table>
				<table class="search_sm" border="0" style="width: 100%;">
					<tr class="h23">
						<td width="">
							<input name="rdo_manifest_type1" type="checkbox" class="trans" id="rdo1_1" checked><label for="rdo1_1">Danger</label>&nbsp;&nbsp;&nbsp;&nbsp;
							<input name="rdo_manifest_type2" type="checkbox" class="trans" id="rdo1_2" checked><label for="rdo1_2">Awkward</label>&nbsp;&nbsp;&nbsp;&nbsp;
							<input name="rdo_manifest_type3" type="checkbox" class="trans" id="rdo1_3" checked><label for="rdo1_3">Break Bulk</label>&nbsp;&nbsp;&nbsp;&nbsp;
							<input name="rdo_manifest_type4" type="checkbox" class="trans" id="rdo1_4" checked><label for="rdo1_4">Reefer</label>&nbsp;&nbsp;&nbsp;&nbsp;
							<input name="rdo_manifest_type5" type="checkbox" class="trans" id="rdo1_5" checked><label for="rdo1_5">Special Stowage</label>&nbsp;&nbsp;&nbsp;&nbsp;
							<input name="rdo_manifest_type6" type="checkbox" class="trans" id="rdo1_6"><label for="rdo1_6">Precaution</label>&nbsp;&nbsp;&nbsp;&nbsp;
						</td>
					</tr>
				</table>
<!--  biz_1   (E) -->

				<table class="height_10"><tr><td></td></tr></table>

				<table class="search" border="0" style="width:100%">
					<tr class="h23">
						<td width="49%" valign="top">
						<table class="search" border="0">
							<tr>
								<td class="title_h"></td>
								<td class="title_s">VVD & POL / POD</td>
							</tr>
						</table>
						<table class="search_sm" border="0" style="width:100%">
							<tr class="h23">
								<td width="" colspan="4">
									<input name="rdo_in_out" type="radio" value="IN" class="trans" id="rdo2_1" checked><label for="rdo2_1">Inbound</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input name="rdo_in_out" type="radio" value="OUT" class="trans" id="rdo2_2"><label for="rdo2_2">Outbound</label>
								</td>
							</tr>
							<tr class="h23">
								<td width="50">&nbsp;&nbsp;VVD</td>
								<td width="" colspan="3">
                                    <input type="text" name="vvd_cd" value="" minLength="9" maxlength="9" class="input1" required dataformat="engupnum" style="width:110;ime-mode:disabled">&nbsp;
									<input type="radio" name="rdo_local_ts" value="ALL" class="trans" id="rdo3_0" checked>&nbsp;<label for="rdo3_0">All</label>&nbsp;&nbsp;&nbsp;
									<input type="radio" name="rdo_local_ts" value="LOCAL" class="trans" id="rdo3_1">&nbsp;<label for="rdo3_1">Local</label>&nbsp;&nbsp;&nbsp;
									<input type="radio" name="rdo_local_ts" value="TS" class="trans" id="rdo3_2">&nbsp;<label for="rdo3_2">T/S</label>
								</td>
							</tr>
							<tr class="h23">
								<td width="50">&nbsp;&nbsp;POL</td>
								<td width="120">
									<input type="text" name="vvd_pol" value="" maxlength="5" class="input" dataformat="engup" style="width:60;ime-mode:disabled">
									<input type="text" name="pol_yd_cd" value="" maxlength="2" class="input" dataformat="engupnum" style="width:30;ime-mode:disabled">
								</td>
								<td width="30">POD</td>
								<td width="">
									<input type="text" name="vvd_pod" value="" maxlength="5" class="input1" dataformat="engup" style="width:60;ime-mode:disabled" required>
									<input type="text" name="pod_yd_cd" value="" maxlength="2" class="input" dataformat="engupnum" style="width:30;ime-mode:disabled">
								</td>
							</tr>
						</table>
						</td>
						<td width="1%"></td>
						<td width="50%" valign="top">
						<table class="search" border="0">
							<tr>
								<td class="title_h"></td>
								<td class="title_s">Booking Route</td>
							</tr>
						</table>

						<table class="search_sm" border="0" style="width:100%; height: 83;">
							<tr class="h23">
								<td width="30">POR</td>
								<td width="100"><input name="por_cd" type="text" maxlength="5" style="width:60;ime-mode:disabled" class="input" dataformat="engup" value=""></td>
								<td width="30">POL</td>
								<td width=""><input name="pol_cd" type="text" maxlength="5" style="width:60;ime-mode:disabled" class="input" dataformat="engup" value=""></td>
							</tr>
							<tr class="h23">
								<td width="30">POD</td>
								<td width="100"><input name="pod_cd" type="text" maxlength="5" style="width:60;ime-mode:disabled" class="input" dataformat="engup" value=""></td>
								<td width="30">DEL</td>
								<td width=""><input name="del_cd" type="text" maxlength="5" style="width:60;ime-mode:disabled" class="input" dataformat="engup" value=""></td>
							</tr>
						</table>

						</td>
					</tr>
				</table>

				</td>
			</tr>
		</table>
<!--biz page (E)-->
		</td>
	</tr>
</table>

<!--Button (S) -->
<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
    <tr><td class="btn1_bg">
    <table border="0" cellpadding="0" cellspacing="0">
    <tr>
    <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
      <tr><td class="btn1_left"></td>
      <td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
      <td class="btn1_right"></td>
      </tr>
    </table></td>
    </tr>
    </table>
    </td>
    </tr>
</table>
<!--Button (E) -->

<table>
    <tr><td height="0" width="0">
        <script language="javascript">comRdObject('report1');</script>
    </td></tr>
</table>

<table width="100%" class="search"  id="mainTable">
    <tr><td width="100%"><script language="javascript">ComSheetObject('sheet1');</script></td></tr>
</table>
<!-- 개발자 작업  끝 -->

</form>

<form name="form2">
	<input type="hidden" name="f_cmd">
	<input type="hidden" name="vsl_cd">
	<input type="hidden" name="skd_voy_no">
	<input type="hidden" name="skd_dir_cd">
	<input type="hidden" name="vvd_pol">
	<input type="hidden" name="vvd_pod">
	<input type="hidden" name="por_cd">
	<input type="hidden" name="pol_cd">
	<input type="hidden" name="pod_cd">
	<input type="hidden" name="del_cd">
	<input type="hidden" name="pol_yd_cd">
	<input type="hidden" name="pod_yd_cd">
	<input type="hidden" name="rdo_in_out">
	<input type="hidden" name="rdo_local_ts">
	<input type="hidden" name="dg">
	<input type="hidden" name="awk">
	<input type="hidden" name="bb">
	<input type="hidden" name="rf">
	<input type="hidden" name="stwg">
</form>

</body>
</html>
