<%
/*=========================================================
*Copyright(c) 2007 CyberLogitec
*@FileName : ESM_COA_0139.jsp
*@FileTitle : Feeder Term
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.24
*@LastModifier : HoIk_Lee
*@LastVersion : 1.0
* 2007-05-22 HoIk_Lee
* 1.0 최초 생성
*=========================================================
* History :
* 2008.04.29 전성진 R200804296328 css 파일 참조 확인 및 수정 요청
* 2009.07.24 장영석 New Framework 적용
* 2010.06.10 송호진 [Legacy전환] UI 표준안 적용 요청 관련 수정 :
*	               CHM-200901714, CHM-200901715, CHM-200901716, CHM-200901717, CHM-200901718, CHM-200901719
* 2011.03.18 김상수 [CHM-201109282-01] Split 04-ALPS의 Location 조회불가건 수정 보완 요청
*                                      - Location에 해당하는 input이나 sheet에 영문대문자와 숫자까지 입력되게 수정
* 2015.07.07 이윤정 [CHM-201536740] COA 내 화면의 조회 기능 (Retrieve, Down Excel)을 뺀 나머지 버튼들을 비활성화 요청 CSR
*=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.coa.stdunitcost.coststructure.event.EsmCoa0139Event"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmCoa0139Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.STDUnitCost.CostStructure");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmCoa0139Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}


	}catch(Exception e) {
        log.error("Exception : " + e.toString());
	}
%>
<html>
<head>
<title>Feeder Term Inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
		btn_Retrieve.focus();
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form" onKeyDown="ComKeyEnter();">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

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
								<tr><td class="btn1_left"></td><td class="btn1" id="btn_Retrieve" name="btn_Retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>

							<td class="btn1_line"></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" id="btn_Reset" name="btn_Reset">Reset</td><td class="btn1_right"></td></tr></table></td>
							<!--  
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" id="btn_Save" name="btn_Save">Save</td><td class="btn1_right"></td></tr></table></td>
							-->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" id="btn_DownExcel" name="btn_DownExcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>
							<!--  
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" id="btn_LoadExcel" name="btn_LoadExcel">Load Excel</td><td class="btn1_right"></td></tr></table></td>
							-->
							<!-- Repeat Pattern -->

						</tr></table>

					</td></tr>
				</table>
              <!-- TABLE '#D' : ( Button : Main ) (E) -->
              <!-- TABLE '#D' : ( Search Options ) (S) -->
              <table class="search">
                <tr>
                  <td class="bg">
                    <!-- : ( Year ) (S) -->
                    <table class="search_in" border="0">
                      <tr class="h23">
						<td width="4%">Origin</td>
						<td width="15%">
							<input type="text" style="width:88" name="f_por" style="ime-mode:disabled;" maxlength="5" onKeyUp="ComKeyEnter('LengthNextFocus');" onKeyPress="ComKeyOnlyAlphabet('uppernum')">
							<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_ficonsearch1" onClick="openLocationCode('getFPor');">
						</td>
						<td width="7%">Destination</td>
						<td width="15%">
							<input type="text" style="width:88" name="f_del" style="ime-mode:disabled;" maxlength="5" onKeyPress="ComKeyOnlyAlphabet('uppernum')">
							<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_ficonsearch2" onClick="openLocationCode('getFDel');">
						</td>
						<td width="50%" align="right"><img class="cursor" src="/hanjin/img/alps/ico_newwin.gif" width="11" height="12" align="absmiddle" hspace="5"><a href="javascript:ComOpenWindow2('ESM_COA_0140.do?f_calc_term_cd=&f_wtr_term_cd=&sysCommUiTitle=Feeder Term Ratio','', 'width=900,height=500,menubar=no,scrollbars=no, resizable=yes')" class="purple">Feeder Term Ratio Inquiry</a></td>
						<td width="1%"></td>
                      </tr>
                    </table>
                    <!-- : ( Year ) (E) -->
                  </td>
                </tr>
              </table>
              <!-- TABLE '#D' : ( Search Options ) (E) -->
              <table class="height_10">
                <tr>
                  <td></td>
                </tr>
              </table>


              <!-- TABLE '#D' : ( Search Options ) (S) -->
              <table class="search">
                <tr>
                  <td class="bg">


                    <table width="100%" id="mainTable">
                      <tr>
                        <td colspan="2">
                          <script language="javascript">ComSheetObject('sheet1');</script>
                        </td>
                      </tr>
					  <tr>
						  <td class="sm">
							  <img src="/hanjin/img/ico_star.gif" border="0" hspace="5">DoubleClick the Org / Dest Loc. to retrieve the RCV / DEL Ratio.
						  </td>
						<td>

								<!-- : ( Button : Grid ) (S) -->
								<table width="100%" class="button">
							       	<tr><td class="btn2_bg">
									<table border="0" cellpadding="0" cellspacing="0">
									<tr>

										<!-- Repeat Pattern -->
										<!--  
										<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn2_left"></td><td class="btn2" id="btng_RowAdd" name="btng_RowAdd">Row Add</td><td class="btn2_right"></td></tr></table></td>

										<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn2_left"></td><td class="btn2" id="btng_RowDel" name="btng_RowDel">Row Del.</td><td class="btn2_right"></td></tr></table></td>
										-->
										<!-- Repeat Pattern -->


									</tr></table>
								</td></tr>
								</table>
						    	<!-- : ( Button : Grid ) (E) -->

						  </tr>
					   </tr>
                    </table>

              </td></tr></table>
              <!-- TABLE '#D' : ( Search Options ) (S) -->

</td></tr>
</table>
<!-- Outer Table (E)-->

</form>
</body>
</html>