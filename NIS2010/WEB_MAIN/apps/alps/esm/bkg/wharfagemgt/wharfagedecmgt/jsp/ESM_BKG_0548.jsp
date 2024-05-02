
<%
	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : ui_bkg_0548.jsp
	 *@FileTitle : Wharfage Vessel Information
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2009.05.25
	 *@LastModifier : 정재엽
	 *@LastVersion : 1.0
	 * 2009.04.24 정재엽
	 * 1.0 Creation
	 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page
	import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page
	import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page
	import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page
	import="com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.event.EsmBkg0548Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg0548Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";
	
	String sBound = "";

	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger
			.getLogger("com.hanjin.apps.wharfagemgt.wharfagedecmgt");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0548Event) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException)
					.loadPopupMessage();
		}
		
		sBound = (request.getParameter("bound")==null) ? "" : request.getParameter("bound");
		// Inbound / Outbound 메뉴가 다르기 때문
			String sPgmNo = (request.getParameter("pgmNo")==null) ? "" : request.getParameter("pgmNo");
		if ("".equals(sBound)) {
			if (sPgmNo.length() == 12) {
				sBound = "I";
			} else {
				sBound = "O";
			}
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request
				.getAttribute("EventResponse");

	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Ancs ACI: Vessel Arrival Manifest (A6)</title>
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
<input type="hidden" name="frm_attr_ctnt2">
<input type="hidden" name="vsl_nm">  

<!-- 개발자 작업	--> <%
 	String keyAddr = (request.getParameter("keyAddr") == null) ? ""
 			: request.getParameter("keyAddr");
 %> <!-- OUTER - POPUP (S)tart -->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">

	
	<tr><td valign="top"><!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0"
			class="title">
			<tr>
				<td class="history"><img src="img/icon_history_dot.gif"
					align="absmiddle"><span id="navigation"></span></td>
			</tr>
			<tr>
				<td class="title"><img src="img/icon_title_dot.gif"
					align="absmiddle"><span id="title">Wharfage Vessel
				Information</span></td>
			</tr>
		</table>
		<!--Page Title, Historical (E)--> <!--biz page (S)--> <!--  biz_1  (S) -->


		<!--  biz_1   (E) --> <!-- Tab ) (S) --> <!-- Tab ) (E) --> <!-- Grid BG Box  (S) -->
		<table class="search" id="mainTable">
			<tr>
				<td class="bg"><!--  biz_2  (S) -->

				<table border="0" style="width: 979;" class="search">
					<tr class="h23">
						<td width="30">VVD</td>
						<td width="110"><input type="text"
							style="width: 77; ime-mode: disabled" class="input1" name="vvd"
							id="vvd" dataformat="ennum" maxlength="9" tabindex="1"></td>
						<td width="35">Port</td>
						<td width="90"><input type="text" style="width:49;ime-mode:disabled"
							class="input1" name="vps_port_cd" id="vps_port_cd"
							dataformat="engupnum" maxlength="5" tabindex="2"> <input
							type="hidden" style="width: 49;ime-mode: disabled" class="input1" name="port_cd"
							id="port_cd" dataformat="engup" maxlength="5"></td>
						<td width="35">Bound</td>
						<td width="150"><select style="width: 100;" class="input1"
							name="io_bnd_cd" id="io_bnd_cd" tabindex="3">							
							<option value="II" <%if("I".equals(sBound)) out.println("selected");%>>Inbound</option>
							<option value="OO" <%if("O".equals(sBound)) out.println("selected");%>>Outbound</option>
						</select></td>
						<input type="hidden" style="width: 49;" class="input1"
							name="whf_bnd_cd" dataformat="ennup" maxlength="5">
						<td width="54">MRN No.</td>
						<td width="160"><input type="text" style="width: 110;"
							class="input2" name="mrn_no" maxlength="22" readonly="readonly"
							tabindex="-1"></td>
						<td width="74">Sailing Date</td>
						<td width=""><input type="text" style="width: 80;"
							class="input2" name="vps_dt" maxlength="10" dataformat="ymd"
							readonly="readonly" tabindex="-1"></td>
					</tr>
				</table>
				<!--  biz_2  (E) --> <!--  Button_Sub (S) -->
				<table class="line_bluedot">
					<tr>
						<td colspan="8"></td>
					</tr>
				</table>
				<!-- Button_Sub (E) -->


				<table border="0" style="width: 979;" class="search">
					<tr class="h23">
						<td width="87">호출부호</td>
						<td width="340"><input type="text" style="width: 107;ime-mode:disabled"
							class="input" name="vsl_call_sgn_cd" maxlength="10"
							dataformat="ennum" tabindex="4"></td>
						<td width="97">하역회사</td>
						<td width=""><input type="text" style="width: 30;ime-mode:disabled"
							class="input" name="unld_agn_cd1" maxlength="2"
							dataformat="ennum" tabindex="10">&nbsp;-&nbsp; <input
							type="text" style="width: 20;ime-mode:disabled" class="input" name="unld_agn_cd2"
							maxlength="1" dataformat="ennum" tabindex="11">&nbsp;-&nbsp;
						<input type="text" style="width: 50;ime-mode:disabled" class="input"
							name="unld_agn_cd3" maxlength="4" dataformat="ennum"
							tabindex="12"></td>
					</tr>
					<tr class="h23">
						<td width="">항코드</td>
						<td width=""><input type="text" style="width: 107;ime-mode:disabled"
							class="input" name="tml_cd" maxlength="3" tabindex="5"></td>
						<td width="">WHF 적용률</td>
						<td width=""><input type="text"
							style="width: 126; text-align: right;ime-mode:disabled" class="input" name="whf_rt"
							maxlength="8" dataformat="float" tabindex="13"></td>
					</tr>
					<tr class="h23">
						<td width="">입항 횟수</td>
						<td width=""><input type="text" style="width: 47;ime-mode:disabled"
							class="input" name="arr_yr" maxlength="4" dataformat="ennum"
							tabindex="6">&nbsp;-&nbsp; <input type="text"
							style="width: 47;ime-mode:disabled" class="input" name="arr_tms_no" maxlength="3"
							dataformat="num" tabindex="7"></td>
						<td width="">하역구분</td>
						<td width="" class="stm"><input type="radio" class="trans"
							name="unld_tp_cd" value="1" checked="checked" tabindex="14">&nbsp;&nbsp;일반&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" class="trans" name="unld_tp_cd" value="2"
							tabindex="15">&nbsp;&nbsp;기계</td>
					</tr>
					<tr class="h23">
						<td width="">반출입 부두</td>
						<td width="" style="padding-left: 2"><script
							language="javascript">ComComboObject('io_port_cd', 1, 140, 1, 0, 0, false, 8)</script></td>
						<td width="">납기일자</td>
						<td width=""><input type="text" style="width: 127;"
							class="input" name="whf_pay_dt" dataformat="ymd" maxlength="10"
							tabindex="16"></td>
					</tr>
					<tr class="h23">
						<td width="">할인률</td>
						<td width="" class="sm"><select style="width: 109;ime-mode:disabled"
							name="whf_vol_dc_cd" tabindex="9">
							<option value="0" selected="selected">0%</option>
							<option value="1">20%</option>
							<option value="2">50%</option>
							<option value="8">70%</option>
							<option value="3">80%</option>
							<option value="4">100%</option>
							<option value="7">30%</option>
						</select> <!-- input type="text" style="width:60;" class="input" name="whf_vol_dc_cd" dataformat="ennum"-->&nbsp;1.20%&nbsp;&nbsp;&nbsp;2.50%&nbsp;&nbsp;&nbsp;3.70%&nbsp;&nbsp;&nbsp;4.80%&nbsp;&nbsp;&nbsp;5.100%&nbsp;&nbsp;7.30%
						할인</td>
						<td width="">항만</td>
						<td width=""><input type="text" style="width: 127;"
							class="input2" name="port_nm" readonly="readonly" maxlength="100"
							tabindex="17"></td>
					</tr>
				</table>
				<!--  biz_2  (S) --> <script language="javascript">ComSheetObject('sheet1');</script>
				<!--  Button_Sub (S) -->
				<table width="100%" class="button">
					<tr>
						<td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<td width="">
							<table width="100%" border="0" cellpadding="0" cellspacing="0"
								class="button">
								<tr>
									<td class="btn2_left"></td>
									<td class="btn2" name="btn_LocationCode">Location Code</td>
									<td class="btn2_right"></td>
								</tr>
							</table>
							</td>
							<td width="">
							<table width="100%" border="0" cellpadding="0" cellspacing="0"
								class="button">
								<tr>
									<td class="btn2_left"></td>
									<td class="btn2" name="btn_DataIF">Data I/F</td>
									<td class="btn2_right"></td>
								</tr>
							</table>
							</td>
						</table>
						</td>
					</tr>
				</table>
				<!-- Button_Sub (E) --></td>
			</tr>
		</table>

		<!-- Grid BG Box  (S) --> <!--biz page (E)--> <!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0"
			cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">
			<tr>
				<td>
					<table border="0" style="width: 300" class="search" >
						<tr class="h23">
							<td>LAST UPDATE:</td>
							<td><input type="text" style="width: 80;"
							class="input2" name="upd_id" readonly="readonly"></td>
							<td><input type="text" style="width: 110;"
							class="input2" name="upd_dt" readonly="readonly"></td>
						</tr>
					</table>
				</td>
				<td class="btn1_bg">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td>
						<table width="" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td>
						<table width="72" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_new">New</td>
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
		<!--Button (E) --></td>
	</tr>
</table>
<!-- : ( Button : pop ) (E) --> <!-- 개발자 작업  끝 --></form>
</body>
</html>