<%
	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : ees_cgm_2001.jsp
	 *@FileTitle : M.G.Set Model Creation
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2013.07.09
	 *@LastModifier : 조경완
	 *@LastVersion : 1.0
	 * 2009.05.26 박의수
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
<%@ page import="com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.event.EesCgm2001Event"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@ page import="com.hanjin.framework.component.util.io.HttpUtil"%>
<%@ page import="com.hanjin.syscommon.common.util.UserRoleUtil" %>
<%@ page import="com.hanjin.syscommon.common.table.ComUsrRoleVO" %>

<%
	EesCgm2001Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String strOfc_cd = "";
	String tRole = ""; //Transaction Role //chungpa 20100304 transaction role apply
	
	Logger log = Logger.getLogger("com.hanjin.apps.ChassisMgsetMgt.ChassisMgsetOnOffhire");
	String xml = HttpUtil.makeXML(request,response);
	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

		event = (EesCgm2001Event) request.getAttribute("Event");
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
<title>M.G.Set Model Creation</title>
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
<input type="hidden" name="eq_spec_no_dup">
<input type="hidden" name="trole" value="<%=tRole%>">

<!-- 개발자 작업	-->

<input type="hidden" style="width: 60; text-align: center; ime-mode:disabled" class="input2" maxlength="1" readonly name="eq_knd_cd" value="G">
<input type="hidden" style="width: 60; text-align: center; ime-mode:disabled" class="input2" maxlength="1" readonly name="page_status">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top: 2; padding-left: 5;">
	<tr>
		<td valign="top">
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
            <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
            <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->

		<table class="search">
			<tr>
				<td class="bg">
				<table class="search" border="0" style="width: 979;">
					<tr class="h23">
						<td width="70">Model No.</td>
						<td width="">
							<script language="javascript">ComComboObject('eq_spec_no', 1, 360, 1, 1, 1, true);</script>
							<!-- 
								<select style="width: 128;" class="input1">
								<option value="0">1998-NJG234X-005</option>
								<option value="1"></option>
								</select>
							-->
						</td>
					</tr>
				</table>
				<table class="line_bluedot">
					<tr>
						<td colspan="6"></td>
					</tr>
				</table>
				<table class="search" border="0">
					<tr>
						<td class="title_h"></td>
						<td class="title_s">M.G.Set No.</td>
					</tr>
				</table>

				<!-- Grid  (S) -->
				<table width="430" id="mainTable" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				<!-- Grid (E) -->

				<table class="search" border="0" style="width: 979;">
					<tr class="h23">
						<td width="40">Maker</td>
						<td width="">
							<script language="javascript">ComComboObject('vndr_seq', 1, 390, 1, 1, 0, true);</script>
							<!--
								<select style="width: 200;" class="">
									<option value="0">Carrier Transicold</option>
									<option value="1"></option>
									<option value="2"></option>
									<option value="3"></option>
								</select>
							-->
						</td>
					</tr>
					<tr class="h23">
						<td>Type</td>
						<td width="">
							<script language="javascript">ComComboObject('eq_tpsz_cd', 1, 80, 1, 1, 0, true);</script>
							<!--
								<select style="width: 80;" class="">
									<option value="0">UMG</option>
									<option value="1">CLG</option>
									<option value="2"></option>
									<option value="3"></option>
								</select>
							-->
						</td>
					</tr>
				</table>

				<table class="line_bluedot">
					<tr>
						<td colspan="6"></td>
					</tr>
				</table>

				<table class="search" border="0" style="width: 979;"  class="search_sm">
					<tr class="h23">
						<td width="200">
						<table border="0" style="width: 400;" class="search_sm">
							<tr class="h23">
								<td>Voltage</td>
								<td width="" class="sm" style="font-size: 12;">
									<input type="radio" class="trans" name="mgst_vltg_capa"> 220
									<input type="radio" class="trans" name="mgst_vltg_capa"> 440
								</td>
								<td width="88">Fuel Capacity</td>
								<td width="" class="stm">
									<input type="text" style="width: 60; text-align: right; ime-mode:disabled" class="input" name="mgst_fuel_capa" maxlength="15" dataformat="int">&nbsp;ltrs
								</td>
							</tr>
						</table>
						</td>
					</tr>
				</table>
				<table class="search" border="0" style="width: 979;"  class="search_sm">
					<tr class="h23">
						<td width="360">
							<table border="0" style="width: 400;" class="search_sm">
								<tr class="h23">
									<td width="90">Tare&nbsp;Weight</td>
									<td width="" class="sm" style="font-size: 12;">
										<input type="text" style="text-align:right;width: 70;" maxlength="6" class="input" name="chss_tare_wgtlb" style="ime-mode:disabled" dataformat="int">&nbsp;lbs&nbsp;
										<input type="text" style="text-align:right;width: 70;" maxlength="6" name="chss_tare_wgt" style="ime-mode:disabled" dataformat="int">&nbsp;KG
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
				<!--  Grid_button (S) -->
				<!--  Button_Sub (S) -->
				</td>
			</tr>
		</table>
		<!-- Button_Sub (E) -->

		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">
			<tr>
				<td class="btn1_bg">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
					    <!-- chungpa 20090817 EES_CGM_2001 Retrieve 버튼을 삭제처리하고 Model No 콤보의 값을 선택할때 마다 자동으로 Retrieve를 실행하도록 해주세요 >RollBack됨 --> 
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="Retrieve">Retrieve</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<!-- -->
						<td>
						<table width="72" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="New">New</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td class="btn1_line"></td>
						<td>
						<table width="72" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="Save">Save</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="Delete">Delete</td>
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

<div style="display:none;">
	<!-- Grid  (S) -->
		<table width="100%" id="mainTable" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td width="100%">
					<script language="javascript">ComSheetObject('sheet2');</script>
				</td>
			</tr>
		</table>
<!-- Grid (E) -->
</div>

<!-- 개발자 작업  끝 -->
		
</form>
</body>
</html>
