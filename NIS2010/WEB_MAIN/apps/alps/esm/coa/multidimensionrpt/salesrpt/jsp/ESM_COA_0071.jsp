<%--
=========================================================================
'주  시 스 템 : ENIS
'서브  시스템 : Weekly Sales Report By Office 2
 2
'프로그램 ID  : apps/enis/esm/coa/multidimensionrpt/sales/jsp/ESM_COA_0071.jsp
'프로그램 명  : Weekly Sales Report By Office 2
'프로그램개요 : Weekly Sales Report By Office 2
'작   성   자 : Park Eun Ju
'작   성   일 : 2006.11.29
=========================================================================
' History :
' 2008.02.22 박은주 N200802220016 COA 조회 기간 관련 수정 요청
'                  2007년 7월 이전, 2007년 27주 이전 data 조회시 조회 불가 및 Error Message 보여줌
' 2008.02.15 박은주 N200801154874 주간 대상항차 기준 변경 관련 요청
'                  Year, Month, Week관련 화면변경
' 2008.05.07 박은주 R200804296325 css 파일 참조 확인 및 수정 요청
' 2008.08.29 박상희 CSR No. N200807298360 Expense Detail로 테이블 변경하면서 화면단 모두 변경[071]
' 2008.09.08 박상희 CSR No. N200808210017 Trade, Sub-Trade, Lane 옵션추가함
' 2009.02.04 김태윤 N200901210016 - COA_조직개편 관련 기능 수정
' 2009.04.03 배진환 N200903170122 COA_Multi-dimension report 조회권한 변경
' 2009.05.14 배진환 N200905120702 param9에 f_ofc_cd 값셋팅 추가 ofc selectBox selected위해
' 2009.05.18 배진환 N200905130071 - COA_조회 조건 입력 관련 수정
* 2009.10.21 김기식 Alps전환작업
* 2010.12.01 김기종 Ticket ID:CHM-201006305-01 COA Architecture 위배사항 수정
* 2011.05.11 최윤성 [CHM-201110694-01] COA Report 화면 combo box validation 추가
=========================================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%
	//ESM_COA_071EventResponse eventResponse = null;	//RDTO(Data Transfer Object including DB ResultSet)
	Exception serverException   = null;					//서버에서 발생한 에러
	String strErrMsg 	= "";							//에러메세지
	String cboOffice1 	= "";
	String cboOffice2 	= "";
    String ofc_cd   = "";
    String ofc_lvl  = "";
    String prevWeek = "";
	//String successFlag 	= "";

	try {
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}else{
			SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	        ofc_cd = account.getOfc_cd();  //.getUserOffice2();
	        ofc_lvl = account.getUsr_auth_tp_cd();  //.getUserLevel();	        
		} // end else
//		N200903120100 처리를 위해 ofc_cd, ofc_lvl을 무조껀 SELHO.  1로 바꿔준다
		ofc_cd = !"SELHO".equals(ofc_cd)?"SELHO":ofc_cd;
		ofc_lvl = !"1".equals(ofc_cd)?"1":ofc_lvl;

	}catch(Exception e) {
		out.println(e.toString());
	}

%>

<html>
<head>
<title>Office Report-Graph</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		var formObj = document.form;

		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if

		loadPage();
	}
</script>
</head>
<body  onload="javascript:setupPage();">
<form method="post" name="form" onKeyDown="ComKeyEnter();">
<input type="hidden" name="f_cmd">
<input type="hidden" name="param_size">

<input type="hidden" name="v_ofc_cd" value="<%=ofc_cd %>">
<input type="hidden" name="v_ofc_lvl" value="<%=ofc_lvl %>">

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
						<tr><td class="btn1_left"></td><td class="btn1" id="btn_retrieve" name="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" id="btn_new" name="btn_new">New</td><td class="btn1_right"></td></tr></table></td>
					<!-- Repeat Pattern -->

				</tr></table>

			</td></tr>
		</table>
		<!--Button_L (E) -->


						<!-- TABLE '#D' : ( Search Options ) (S) -->
						<table class="search">
							<tr>
								<td class="bg">

									<!-- : ( Year ) (S) -->
									<table class="search_in" border="0">
										<tr class="h23">
											<td colspan="3"><script language="javascript">coaPeriod1_ofc();</script></td>
										</tr>
                                        <tr class="h23">
                                            <td width="5%"></td>
                                            <td width="9%"></td>
                                        	<td class="gray_tit" style="color:#4361b6" style="font-size:8pt;">
								        	   [ by Mon - effective from July(2007) &nbsp;&nbsp;
								        	    by Week - effective from 27WK(2007) ]
                                      	    </td>
                                        </tr>
									</table>
									<!-- : ( Year ) (E) -->

									<table class="search_in" border="0">
									<tr><td class="line_bluedot" style="height:11;"></td></tr>
									</table>

				                    <table class="search_in" border="0">
				                        <tr class="h23">
				                            <td width="10%" class="gray_tit"><img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">By View</td>
				                            <td width="9%"> Profit View</td>
				                            <td width="19%">
				                            	<script language="javascript">ComComboObject('f_pro_vw',1, 140 , 1 )</script>
				                            </td>
				                            <td width="9%">Office View</td>
				                            <td>
				                            	<script language="javascript">ComComboObject('f_ofc_vw',1, 100 , 1 )</script>
				                            </td>
				                        </tr>
				                    </table>


									<table class="search_in" border="0">
									<tr><td class="line_bluedot" style="height:11;"></td></tr>
									</table>



									<!-- : ( By Office ) (S) -->
									<table class="search_in" border="0">
										<tr class="h23">
											<td class="gray_tit"><img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">By Office</td>
											<td>Office Level</td>
											<td style="padding-left:1;">
												<script language="javascript">ComComboObject('f_ofc_lvl',1, 140 , 1 )</script>
											</td>
											<td>Office</td>
											<td style="padding-left:1;">
												<script language="javascript">ComComboObject('f_ofc_cd',1, 100 , 0 )</script>
											</td>
											<td colspan="4">
												<input type="checkbox" class="trans" name="f_excl_sts" value="Y">Exclude Sub&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												<input type="checkbox" class="trans" name="f_bkg_sts" value="Y">Waiting Booking Include</td>
										</tr>
				                        <tr class="h23">
				                        	<td width="10%" class="gray_tit"><img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">By Route</td>
											<td width="9%">Trade</td>
											<td width="19%" style="padding-left:1;">
												<script language="javascript">ComComboObject('f_cob_trade',1, 140 , 0 )</script>
											</td>
											<td width="9%">Sub Trade</td>
											<td width="15%" style="padding-left:1;">
												<script language="javascript">ComComboObject('f_cob_subtrade',1, 100 , 0 )</script>
											</td>
											<td width="7%" style="padding-left:23;">Lane</td>
											<td width="16%">
												<script language="javascript">ComComboObject('f_cob_lane',1, 100 , 0 )</script>
											</td>
											<td width="6%">Bound</td>
											<td>
												<script language="javascript">ComComboObject('f_cob_bound',1, 80 , 0 )</script>
											</td>
				                        </tr>
				                    </table>
				                    <!-- : ( By Office ) (E) -->


								</td>
							</tr>
						</table>
						<!-- TABLE '#D' : ( Search Options ) (E) -->

						<table class="height_10"><tr><td></td></tr></table>

						<!-- TABLE '#D' : ( Search Options ) (S) -->
						<table class="search">
							<tr>
								<td class="bg">

									<table class="search" border="0">
										<tr>
											<td class="title_h"></td>
											<td class="title_s">1. Summary : Recent Sales Performance Trend</td>
											<!-- td class="gray">By HAMBB</td -->
											<td class="gray">&nbsp;</td>
										</tr>
										<tr><td height="5"></td></tr>
									</table>

									<!-- TABLE '#E' : ( Graph BG ) (S) -->
									<table class="search_in" border="0">
										<tr>
											<td class="bg_b2">

												<table width="100%" height="600">
													<tr>
														<td>
														<script language="javascript">comTChartObject();comRdObject('Rdviewer');</script>
														</td>
													</tr>
												</table>
											</td>
										</tr>
									</table>
									<!-- TABLE '#E' : ( Graph BG ) (E) -->

								</td>
							</tr>
						</table>
						<!-- TABLE '#D' : ( Search Options ) (E) -->

</td></tr>
</table>
<!-- Outer Table (E)-->
<br>

<!-- : ( Grid ) (S) -->
<table width="100%" id="mainTable">
	<tr>
		<td>
		<script language="javascript">ComSheetObject('sheet1');</script>
		</td>
	</tr>
</table>
<!-- : ( Grid ) (E) -->


</body>
</html>
