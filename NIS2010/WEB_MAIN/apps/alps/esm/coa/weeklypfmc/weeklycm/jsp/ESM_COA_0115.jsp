<%/*=========================================================
 * Copyright(c) 2006 CyberLogitec
 * @FileName : ESM_COA_0115.jsp
 * @FileTitle : EMU Cost (RA)
 * Open Issues :
 * Change history :
 * @LastModifyDate : 2006-12-07
 *                 : 2008-05-06
 *                 : 2008-08-12
 : 2009-09-11
 * @LastModifier : Ari 
 *               : 전윤주
 : 박수훈
 * @LastVersion : 1.0
 *  2006-12-07 Kim Jong Beom
 *  2008-05-06 전윤주
 *  1.0 최초 생성
 *
 * Change history : 2008.08.12 전윤주
 *                  CSR NO. N200807170013 EMU 단가 조회 화면 변경
 *                  - POD 조회 조건 추가 포함
 * 2008.09.22 김태윤 N200808278919 Spilt 01-COA_Report내 수정사항 (메뉴명과 윈도우 타이틀명 일치.)
 * 2009.09.11 박수훈 0115 화면 New FrameWork 적용
 * 2010.09.01 김기종 Ticket ID:CHM-201004982-01 COA Architecture 위배사항 수정
 * 2012.03.22 김종준 [CHM-201217091-01] EMU 관련 로직 보완/변경 검토 요청의 건 -EMU(RA) Origin Credit Ratio 추가
 * 2012.09.12 이석준 [CHM-201220073-01] EMU Cost (RA) 에 Month Copy 기능 추가
 * 2013.09.04 김수정 [CHM-201326480] EMU_RA 화면 MB Data 없는 경우 Pre Simulation 화면과 동일 조건으로 Data 조회하도록 변경
 * 2013.09.26 김수정 [CHM-201326654] EMU 로직 보완_Trunk 구간 평균단가 제외 및 BKG DEL 기준에서 MT Return CY 기준으로 변경
 =========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.coa.weeklypfmc.weeklycm.event.EsmCoa0115Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmCoa0115Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String strOfc_cd = "";

	Logger log = Logger
			.getLogger("com.hanjin.apps.WeeklyPFMC.WeeklyCM");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

		event = (EsmCoa0115Event) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException)
					.loadPopupMessage();
		}

	} catch (Exception e) {
		log.error("Exception : " + e.toString());
	}
%>
<html>
<head>
<title>EMU Cost (RA)</title>
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

<body  onload="javascript:setupPage();">
<form method="post" name="form" onKeyDown="changeSearchSheet();">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<input type="hidden" name="iPage">
<input type="hidden" name="f_cost_loc_grp_cd" value="E">
<input type="hidden" name="v_ofc_cd" value="<%=strOfc_cd %>"> 

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>


		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->

		<!--Button_L (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
	       	<tr><td class="btn1_bg">

				<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<!-- Repeat Pattern -->
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" id="btn_Retrieve" name="btn_Retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>

					<td class="btn1_line"></td>
					<!-- 
	                <td>
	                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
	                    <tr>
	                      <td class="btn1_left"></td>
	                      <td class="btn1" id="btn_Month_Copy" name="btn_Month_Copy">Month Copy</td>
	                      <td class="btn1_right"></td>
	                    </tr>
	                  </table>
	                </td>
	                 -->
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" id="btn_DownExcel" name="btn_DownExcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>
					<!-- Repeat Pattern -->

				</tr></table>

			</td></tr>
		</table>
		<!--Button_L (E) -->


<!-- TABLE '#D' : ( Search Options ) (S) -->
<table class="search">
<tr>
	<td class="bg">

		<table class="search_in" border="0">
		<tr class="h23">
			<td width="7%">YYYY-MM</td>
			<td width="10%">
				<input type="text" name="f_cost_yrmon" class="input1" style="width:60" value="" maxlength="6" style='ime-mode:disabled' onKeyPress='ComKeyOnlyNumber(window);' onKeyUp="ComKeyEnter('LengthNextFocus')" onBlur="addDash(this , 4);" onFocus="this.value=ComReplaceStr(this.value, '-', '');" ></td>
			<td width="7%">Type/Size</td>
			<td width="10%">
				<script language="javascript">ComComboObject('f_cntr_tpsz_cd', 1, 60 , 0, 1 )</script>
			</td>
			<td width="3%"></td>
			<td width="20%">OP ECC&nbsp;&nbsp;&nbsp;
				<script language="javascript">ComComboObject('f_from_ecc_cd', 1, 70 , 0, 1 )</script>

			</td>
			<td width="20%">
				POD ECC&nbsp;&nbsp;&nbsp;
				<script language="javascript">ComComboObject('f_pod_ecc_cd', 1, 70 , 0, 0 )</script>

			</td>
			<td width="25%">
				MT RTN ECC (DEL ECC)&nbsp;&nbsp;&nbsp;
				<script language="javascript">ComComboObject('f_to_ecc_cd', 1, 70 , 0, 0 )</script>
			</td>
			<td>&nbsp;</td>
		</tr>
		</table>

	</td>
</tr>
</table>

<!-- TABLE '#D' : ( Search Options ) (E) -->
<table class="height_10"><tr><td></td></tr></table>

<!-- TABLE '#D' : ( Search Options ) (S) -->
<table class="search">
<tr><td class="bg">

		<table class="search" border="0">
		<tr>
			<td class="title_h"></td>
			<td class="title_s">EMU Cost Inquiry(RA)</td>
			<td align="right"><a href="javascript:ComOpenPopup('/hanjin/COM_ENS_051.do', 775, 490,	'', '1,0,1,1,1,1,1,1,1,1,1,1', true);" class="purple">Location</a>&nbsp;</td>
		</tr>
		</table>

		<!-- : ( POR ) (S) -->
		<div id="ecc_sheet" style="display:inline">
		<table width="100%">
		<tr>
			<td width="100%">
				<table width="100%" id="mainTable">
				<tr><td><script language="javascript">ComSheetObject('sheet1');</script></td></tr>
				</table>
			</td>
		</tr>
		</table>
		</div>

		<div id="lcc_sheet" style="display:none">
		<table width="100%">
		<tr>
			<td width="100%">
				<table width="100%" id="mainTable">
				<tr><td><script language="javascript">ComSheetObject('sheet2');</script></td></tr>
				</table>
			</td>
		</tr>
		</table>
		</div>
		<div id="rcc_sheet" style="display:none">
		<table width="100%">
		<tr>
			<td width="100%">
				<table width="100%" id="mainTable">
				<tr><td><script language="javascript">ComSheetObject('sheet3');</script></td></tr>
				</table>
			</td>
		</tr>
		</table>
		</div>
		<!-- : ( POR ) (E) -->
		
		
		<table class="search" border="0">
		<tr><td height="18"><img src="/hanjin/img/ico_star.gif" border="0" hspace="3" align="absmiddle"><strong>Remark</strong></td></tr>
		<tr><td style="padding-left:11;" class="sm">
			<img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0" vspace="3">
			EMU Cost = OP Cost + DEL Cost<br>
			<img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0" vspace="3">
			EMU Credit = (OP Credit Amount x  OP Ratio % + POD Credit Amount ) x DEL Ratio %<BR>
			<img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0" vspace="3">
			Figures in red : Manually inserted cost<BR>
			<img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0" vspace="3">
			DEL ECC actually means <font color="#FF0000"><b>MT RTN ECC</b></font>.<BR>
			&nbsp;&nbsp;&nbsp;&nbsp;EMU cost & credit will be distributed based on the <font color="#FF0000"><b>MT RTN ECC</b></font> information. <BR>
			<!-- 
		       &nbsp;&nbsp;1) If OP RCC is <font color="#FF0000"><b>DEHAM</b></font> and Cargo Type is Dry :<BR> 
		            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;EMU Credit =  (OP Credit Amount x  OP Ratio % + POD Credit Amount ) x DEL Ratio %<BR> 
		       &nbsp;&nbsp;2) Other than No 1)  : <BR> 
		            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;EMU Credit = (OP Credit Amount  + POD Credit Amount ) x DEL Ratio %<BR> 
		     -->
</td></tr>
		</table>
		

	</td>
</tr>
</table>
<!-- TABLE '#D' : ( Search Options ) (E) -->


</td></tr>
</table>
<!-- Outer Table (E)-->

</form>
</body>
</html>