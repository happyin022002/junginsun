<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_MAS_0061.jsp
*@FileTitle : Inquiry By BKG
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.28
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2009.08.28 송호진
* 1.0 Creation
/*=========================================================
'주  시 스 템 : ENIS
'서브  시스템 : 점소 Weekly 비정형 실적 분석 RPT 조회2
'프로그램 ID  : apps/enis/esm/mas/multidimensionrpt/sales/jsp/ESM_MAS_061.jsp
'프로그램 명  : 점소 Weekly 비정형 실적 분석 RPT 조회2
'프로그램개요 : 점소 Weekly 비정형 실적 분석 RPT 조회2
'작   성   자 : Nam Sangwook
'작   성   일 : 2007.11.24
=========================================================
' History :
' 2008.05.07 PEJ    R200804296325 css 파일 참조 확인 및 수정 요청
' 2008.06.16 PEJ    N200805307021 Split 02-MAS_화면 개발 및 수정
' 2008.08.29 박상희 N200807298360 Expense Detail로 테이블 변경하면서 화면단 모두 변경[061]
' 2008.09.22 김태윤 N200808278919 Spilt 01-MAS_Report내 수정사항 (searchBKG061List, searchBkgAbcstp156List 쿼리수정)
' 2008.09.26 전윤주 N200808260005 SPCL CGO 체크박스 위치 변경, 같은 항목 반복 오류 수정
' 2008.10.22 박상희 Special CGO 화면배치 수정 (html 수정)
' 2008.11.24 박상희 N200811060006 Weight 추가
' 2008.12.17 박상희 N200812100006 MAS_Inquiry by BKG 화면 수정 : R.Mon/S.Mon 모두 보여줌
' 2008.12.22 박상희 border 수정
' 2009.03.10 김태윤 CSR No.N200903040144 Remark 팝업 추가.
' 2009.09.08 송호진 ALPS F/W 적용
' 2010.09.09 최성민 [CHM-201005892-01] Inquiry by BKG 에러 수정요청
* 2010.12.01 김기종 Ticket ID:CHM-201006305-01 MAS Architecture 위배사항 수정
* 2011.05.13 김민아 [CHM-201110694-01] MAS Report 화면 combo box validation 추가 - 자리수, 영문대문자, 숫자 입력 제한
* 2012.03.12 김종준 [CHM-201216637-01] Inquiry by BKG 화면에 Bill Type Indicator 추가
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.framework.core.view.template.Screen"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
//	EsmMas0061Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";

    String pro_vw   = "";
    String pro_lvl  = "";
    String s_bkg_no  = "";
    
    String screen_name = "";
    String popup_flag = "N";    
	Logger log = Logger.getLogger("com.hanjin.apps.MultiDimensionRPT.SalesRPT");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		
 
//		event = (EsmMas0061Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		screen_name = ((Screen)(request.getAttribute("com.hanjin.framework.core.comm.CURRENT_SCREEN"))).getName();
		
		if( screen_name.indexOf("POP") > 0){
			popup_flag = "Y";	
		}
		
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		pro_vw = request.getParameter("f_pro_vw");
		pro_lvl = request.getParameter("f_pro_lvl");
		s_bkg_no = request.getParameter("f_s_bkg_no");
								
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
//		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(NullPointerException ne){
		log.error("not exist");
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Inquiry By BKG</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
var	popup_flag = "<%=popup_flag%>";
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
	
	
</script>
</head>
<!-- 개발자 작업	-->

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;" onKeyDown="ComKeyEnter();">
<input type="hidden" name="f_cmd">
<input type="hidden" name="f_rd_flg">
<input type="hidden" name="userId" value="<%=strUsr_id %>">
<input type="hidden" name="f_ofc_cd" value="">
<input type="hidden" name="f_ofc_lvl" value="">
<input type="hidden" name="f_rout_no" value="">
<input type="hidden" name="f_pctl_no" value="">
<input type="hidden" name="iPage">
<input type="hidden" name="s_pro_vw" value="<%=JSPUtil.getNull(pro_vw)%>">
<input type="hidden" name="s_pro_lvl" value="<%=JSPUtil.getNull(pro_lvl)%>">
<input type="hidden" name="f_usr_lgn_ofc_cd"  value="<%=strOfc_cd%>">


<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>




		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif"  id="navigation_icon_popup_hidden" align="absmiddle"><span id="navigation"></span></td></tr>
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

					<td class="btn1_line"></td>

					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" id="btn_downexcel" name="btn_downexcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>
					<!-- Repeat Pattern -->

				</tr></table>

			</td></tr>
		</table>
		<!--Button_L (E) -->


		<!-- TABLE '#D' : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg">
				<!-- : ( BKG ) (S) -->
				<table class="search_in" border="0">
				<tr class="h23">
					<td width="90">Booking</td>
					<td width="293"> <!-- onKeyUp="moveTab(this, f_bkg_no_split);"  -->
						<input type="text" style="width:130; ime-mode:disabled;" class="input1" name="f_bkg_no"  value="<%=JSPUtil.getNull(s_bkg_no)%>" onKeyPress="ComKeyOnlyAlphabet('uppernum');" maxlength="13" >
						<!--input type="text" style="width:25" class="input1" name="f_bkg_no_split" value="" maxlength="2"--></td>
		            <td width="90" class="gray_tit"><img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">By View</td>
                    <td width="74"> Profit View</td>
                    <td width="151">
                    	<script language="javascript">ComComboObject('f_pro_vw',1, 100 , 1 )</script>
                    </td>
                    <td width="80">Profit Level</td>
                    <td>
                    	<script language="javascript">ComComboObject('f_pro_lvl',1, 94 , 1 )</script>
                    </td>
				</tr>
				</table>
				<!-- : ( BKG ) (E) -->
			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->

		<table class="height_10"><tr><td></td></tr></table>

		<!-- TABLE '#D' : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg">

				<!-- : ( Year ) (S) -->
				<table class="search_in" border="0">
                      <tr class="h23">
                        <td width="90">Booking No.</td>
                        <td width="115"><input type="text" style="width:100" name="f_bkg_split" value=""  disabled class="input2"></td>
                        <td width="193" >Contract Office&nbsp;&nbsp;<input type="text" style="width:80" name="f_clt_ofc_cd" disabled class="input2"></td>
                        <td width="280">Sales Office&nbsp;
                        <input type="text" style="width:61" name="f_ofc" value="" disabled class="input2">&nbsp;&nbsp;
                        Shipper&nbsp;
                        <input type="text" style="width:70" name="f_shipper" disabled class="input2"></td>
                        <td width="165" class="stm" align="left"><div style = "padding: 0 0 0 6px" id="div_shipper"></div></td>
                        <td align="left">
                        	<b>Bill Type</b>&nbsp;<input type="text" style="width:82" name="rt_bl_tp_nm" value=""  disabled class="input2">
                        </td>
                      </tr>
                </table>
                <table class="search_in" border="0">
                      <tr class="h23">
                        <td width="90">IOC</td>
                        <td width="30"><input type="text" style="width:20;text-align:center;" name="f_ioc" value="" disabled class="input2"></td>
                        <td width="48">R/Lane</td>
                        <td width="107"><input type="text" style="width:48" name="f_rlane" value="" disabled class="input2"></td>
                        <td width="30">VVD</td>
                        <td width="93"><input type="text" style="width:78" name="f_vvd" value="" disabled class="input2"></td>
                        <td width="50">R/Term</td>
                        <td width="50"><input type="text" style="width:20;text-align:center;" name="f_rterm" value="" disabled class="input2"></td>
                        <td width="56">D/Term</td>
                        <td width="40"><input type="text" style="width:20;text-align:center;" name="f_dterm" value="" disabled class="input2"></td>
                        <td width="104">R/Mon</td>
                        <td width="85"><input type="text" style="width:70" name="f_cost_yrmon" disabled class="input2"></td>
                        <td width="50">S/Mon</td>
                        <td width="80" class="stm"><input type="text" style="width:69" name="f_sls_yrmon" disabled class="input2"></td>
                        <td width="43">Week</td>
                        <td><input type="text" style="width:20" name="f_cost_wk" disabled class="input2"></td>
                      </tr>
                </table>
                <table class="search_in" border="0">
                      <tr class="h23">
						<td width="90">Special Cargo</td>
						<td width="183" class="sm">

								<table border="0" style="height:15; width:135; background-color: #E9E9E9;">
			                        <tr><td class="sm" style="padding-left:0;">
				                            <input type="checkbox" class="trans" name="f_spcl_dg" value="Y" disabled>&nbsp;DG&nbsp;
											<input type="checkbox" class="trans" name="f_spcl_rf" value="Y" disabled>&nbsp;RF&nbsp;
											<input type="checkbox" class="trans" name="f_spcl_ak" value="Y" disabled>&nbsp;AK&nbsp;
											<input type="checkbox" class="trans" name="f_spcl_bb" value="Y" disabled>&nbsp;BB</td></tr>
								</table>
						</td>
						<td width="80">Revenue MT</td>
						<td width="45">
							<input type="checkbox" class="trans" name="f_mt_rev" disabled>&nbsp;&nbsp;
						</td>
						<td width="45">S.O.C</td>
						<td width="55">
							<input type="checkbox" class="trans" name="f_soc_flg" value="Y" disabled>
						</td>
						<td width="56">BKG STS</td>
						<td width="40"><input type="text" style="width:20;text-align:center;" name="bkg_sts" disabled class="input2" colspan = "2"></td>
                        <td width="105">Rep. Commodity</td>
                        <td width=84><input type="text" style="width:70" name="f_rcmdt" value="" disabled class="input2"></td>
						<td width=50>Weight</td>
						<td>
							 <input type="text" style="width:99;text-align:right;" name="f_bkg_cgo_wgt" disabled class="input2" dataformat="float" >
							 <input type="text" style="width:41" name="f_bkg_wgt_tp_cd" disabled class="input2">
						 </td>
                      </tr>
                    </table>
                    <table class="line_bluedot"><tr><td></td></tr></table>
				<!-- : ( Year ) (E) -->


				<table width="100%" id="mainTable1">
				<tr><td><script language="javascript">ComSheetObject('sheet1');</script></td></tr>
				</table>

				<!-- : ( POR ) (S) -->
				<table width="100%" id="mainTable2">
			    <tr><td><script language="javascript">ComSheetObject('sheet2');</script></td></tr>
				</table>
				<!-- : ( POR ) (E) -->



				<!--  Button_Sub (S) -->
				<table width="100%" class="button">
			       	<tr><td class="btn2_bg">
					<table border="0" cellpadding="0" cellspacing="0">
					<tr>

						<!-- Repeat Pattern -->
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td><td class="btn2" id="btng_costdetail" name="btng_costdetail">Cost Inquiry</td><td class="btn2_right"></td></tr></table></td>
						<!-- Repeat Pattern -->

					</tr></table>
				</td></tr>
				</table>
		    	<!-- Button_Sub (E) -->


			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->

		<table class="height_10"><tr><td></td></tr></table>

		<!-- TABLE '#D' : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg">
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Performance Inquiry</td></tr>
				<tr><td class="height_5"></td></tr>
				</table>

				<table class="search" border="0">
				<tr class="h23">
				<td width="7%"><img class="nostar">Type/Size</td>
					<td width="10%">
						<script language="javascript">ComComboObject('f_cntr_tpsz_cd',1, 80 , 0 )</script>
					</td>
					<td width="82%"class="gray" align="right">(USD) &nbsp;</td>
				    <td valign="bottom" align="right" style="padding-right:2;">
						<div id="div_zoom_in" style="display:inline">
						<img class="cursor" src="/hanjin/img/bu_prev01.gif" width="20" height="11" border="0" name="bu_zoom_in" alt="Zoom in(+)">
						</div>
						<div id="div_zoom_out" style="display:none">
						<img class="cursor" src="/hanjin/img/bu_next01.gif" width="20" height="11" border="0" name="bu_zoom_out" alt="Zoom out(-)">
						</div>
					</td>
				</tr>
				<tr><td class="height_2" colspan="2"></td></tr>
				</table>

				<!-- : ( Node / Link ) (S) -->
				<table width="100%" id="mainTable3">
			    <tr><td><script language="javascript">ComSheetObject('sheet3');</script></td></tr>
				</table>
				<!-- : ( Node / Link ) (E) -->

		    	
				<!--  Button_Sub, Remark (S) -->
				<table width="100%" class="button">
				    <tr><td><img src="/hanjin/img/ico_star.gif" border=0> <strong>Remark</strong></td>
				        <td class="btn2_bg">
							<table border="0" cellpadding="0" cellspacing="0">
							<tr>
		
								<!-- Repeat Pattern -->
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" id="btns_remarks" name="btns_remarks">Cost Detail</td><td class="btn2_right"></td></tr></table></td>
		
								<!-- <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" onClick="openABCSTPinquiry(sheetObjects[0],document.form,'');">ABC/STP</td><td class="btn2_right"></td></tr></table></td> -->
								<!-- Repeat Pattern -->		
							</tr>
							</table>
				        </td>
				    </tr>
					<tr><td class="sm">
						<img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0" vspace="4">
						<font color="#0000FF"><b>If costs are marked in Blue, please contact each RHQ(NOG, UOG, AOG, WOG) and ask for more accurate costs. </b></font><br>
						</td>
						<td>&nbsp;</td>
					</tr>
				</table>
				<!--  Button_Sub, Remark (E) -->
				
				
			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (S) -->


	</td>
	</tr>
</table>
<!-- Outer Table (E)-->


<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
<iframe id=myiframe src="" width=0 height=0></iframe>