<%
/*
*Copyright(c) 2006 CyberLogitec 
*@FileName       : ESM_MAS_0035.jsp
*@FileTitle      : Inquire by Srouce Data
*Open Issues     :
*Change history  :
*@LastModifyDate : 2006-12-07
*@LastModifier   : Kim Jong Beom
*@LastVersion    : 1.0
* 2006-12-07 Kim Jong Beom
*  1.0 최초 생성
*=========================================================
* History :
* 2008.02.15 PEJ N200801154874 주간 대상항차 기준 변경 관련 요청
*    변경사항 : Year, Month, Week관련 화면변경
* 2008.03.21 PEJ R200803125390 P/L 화면 보완 요청_1, 2번항목
*                Week선택시에 Month, Week를 입력할수 있도록 변경
* 2008.05.02 임옥영 R200804296327 CSS파일 경로 변경
* 2008.07.15 박은주 N200806270002 Inquiry by Source Data 화면의 Misc 컬럼 제거 Total만 남겨둠[035]
* 2008.08.29 박은주 CSR No. N200807290002 Expense Detail로 테이블 변경하면서 화면단 모두 변경[035]
* 2008.08.24 박상희 N200808278919 Inquiry by Source Data : cntr_tpsz_cd 로 변경
* 2008.10.10 박상희 N200808228859 Special CNTR 분리운영
* 2008.10.14 박상희 Shipper 검색조건으로 조회가 가능하도록 수정
* 2008.11.24 박상희 N200811060006 check box 위치 변경
* 2009.02.02 임옥영 N200901190016 Office구조 변경 관련 적용
* 2009.03.16 김종열 N200903100130 - VVD Code에 영문 외 숫자도 입력가능하게 수정
* 2009.04.03 배진환 N200903170122 - MAS_Multi-dimension report 조회권한 변경
* 2009.05.14 배진환 N200905120702 param9에 f_ofc_cd 값셋팅 추가 ofc selectBox selected위해
* 2009.05.18 배진환 N200905130071 - MAS_조회 조건 입력 관련 수정
* 2009.10.12 김기식 Alps전환작업
* 2010.12.01 김기종 CSR No. CHM-201004982-01 MAS Architecture 위배사항 수정 (CommonSC)
* 2011.03.17 최성민 CHM-201109506-01 Inquiry by Source data Void제거 기능추가
* 2011.03.18 김상수 [CHM-201109282-01] Split 04-ALPS의 Location 조회불가건 수정 보완 요청
*                                      - Location에 해당하는 input이나 sheet에 영문대문자와 숫자까지 입력되게 수정
* 2011.05.11 최윤성 [CHM-201110694-01] MAS Report 화면 combo box validation 추가
* 2011.07.26 김상수 [CHM-201112106-01] Retrieve, File Download 기능을 Back end job 으로 기능 수정
* 2013.11.13 김수정 [CHM-201327494] [MAS] 2013년 하반기 통합로그 결함 복구
* 2013.11.18 박찬민 [CHM-201327153] [MAS] Inquiry by Source Data 화면의 주차 연장 등 추가 사항 
* 2015.05.15 손진환 [CHM-201535424] [MAS] COA 상 Fixed Rate 반영
* 2015.05.27 손진환 [CHM-201536029] [MAS] COA 상 Fixed Rate 반영 요청 CSR 
* 2015.07.20 손진환 [CHM-201536959] [MAS] Inquiry by Source Data에서 Sub Trade 구분자 삽입 요청 CSR
* 2016.06.01 김동호 Send To Mail 버튼 추가(개발자용)
* 2017.07.28 김동호 [CSR #1661] Login Office가 BA, BB 인 경우 해당 OFC_CD의 내역만 조회(하위 포함)
*=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.framework.component.util.io.HttpUtil"%>
<%
	GeneralEventResponse eventResponse = null;
	Exception serverException = null;
	String strErrMsg = "";
	Logger log = Logger.getLogger("com.hanjin.apps.alps.esm.mas.multidimensionrpt.sales.jsp.ESM_MAS_035");

	String userId  = "";
    String usr_ofc_cd  = "";
    String usr_ofc_lvl = "";
	String xml = "";
	String strTpsz = "";
	try {
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		} else {
			eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");
			SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
			userId = account.getUsr_id();
			usr_ofc_cd = account.getOfc_cd();  //.getUserOffice2();
			usr_ofc_lvl = account.getUsr_auth_tp_cd();  //.getUserLevel();

			strTpsz = eventResponse.getETCData("strTpsz");
			xml = HttpUtil.makeXML(request, response);
	        xml = xml.replaceAll("\"", "'");

		} //end of if

	} catch(Exception e) {
		log.error("JSP Exception : " + e.toString());
	}
%>

<html>
<head>
<title>Inquiry by Source Data </title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	var strTpsz = "<%= strTpsz %>";
	function setupPage() {
		var errMessage = "<%=strErrMsg%>";
		var formObj = document.form;

		if (errMessage.length>= 1) {
			ComShowMessage(errMessage);
		} // end if

		loadPage();
	}
</script>
</head>


<body onload="javascript:setupPage();">
<form method="post" name="form"  onKeyDown="ComKeyEnter();">
<input type="hidden" name="f_cmd">
<input type="hidden" name="iPage">

<input type="hidden" name="userId"  value="<%=userId%>">
<input type="hidden" name="f_usr_ofc_cd"  value="<%=usr_ofc_cd%>">
<input type="hidden" name="f_usr_lgn_ofc_cd"  value="<%=usr_ofc_cd%>">
<input type="hidden" name="f_usr_ofc_lvl" value="<%=usr_ofc_lvl%>">
<input type="hidden" name="f_usr_lgn_ofc_lvl" value="1">
<input type="hidden" name="f_usr_ofc_tp_cd" value="XX">
<input type="hidden" name="f_excel">
<input type="hidden" name="f_shpr_cd">
<input type="hidden" name="sXml" value="<%=xml%>">
<input type="hidden" name="backendjob_key">

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>


		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation) (S) -->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation) (E) -->

        <!-- TABLE '#D' : ( Button : Main) (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
	       	<tr><td class="btn1_bg">

				<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<!-- Repeat Pattern -->
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" id="btn_retrieve" name="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" id="btn_downexcel" name="btn_downexcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" id="btn_filedownload" name="btn_filedownload">File Download</td><td class="btn1_right"></td></tr></table></td>
					<%
			            // 매주 올라오는 SR처리하려고 Hidden 버튼 만듦. 이거 눌러놓고 메일오면 FTP로 다운로드 받으면 됨..
			            if( "20910006".equals(userId) || "21702016".equals(userId) || "21702011".equals(userId) || "9500144".equals(userId)) {
			        %>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn1_left"></td><td class="btn1" id="btn_sendmail" name="btn_sendmail">Send to Mail</td><td class="btn1_right"></td></tr></table></td>
                    <%
			            }
                    %>
					<!-- Repeat Pattern -->

				</tr></table>

			</td></tr>
		</table>
        <!-- TABLE '#D' : ( Button : Main) (E) -->

<!-- TABLE '#D' : ( Search Options) (S) -->
<table class="search">
<tr>
	<td class="bg">

		<!-- : ( Year) (S) -->
		<table class="search_in" border="0">
		<tr class="h23">
			<td colspan="3"><script language="javascript">masPeriod2_ofc();</script><!-- FormControl.js --></td>
		</tr>
        <tr class="h23">
            <td width="11%"></td>
            <td width="11%"></td>
        	<td class="gray_tit" style="color:#4361b6" style="font-size:8pt;">
        	   [ by Mon - effective from July(2007) &nbsp;&nbsp;
        	    by Week - effective from 27WK(2007) ]
      	    </td>
        </tr>

		</table>

		<table class="search_in" border="0">
		<tr><td class="line_bluedot" style="height:11;"></td></tr>
		</table>

		<table class="search_in" border="0">
		<tr class="h23">
			<td width="10%" class="gray_tit">
				<img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">By View
			</td>
			<td width="11%">Profit View</td>
			<td width="16%">
				<script language="javascript">ComComboObject('f_pro_vw', 1, 131, 1)</script>
			</td>
			<td width="11%">Office View</td>
			<td width="11%">
				<script language="javascript">ComComboObject('f_ofc_vw', 1, 80, 1)</script>
			</td>
			<td width="11%">Profit Level</td>
			<td>
				<script language="javascript">ComComboObject('f_pro_lvl', 1, 80, 1)</script>
			</td>
		</tr>
		</table>

		<table class="search_in" border="0">
		<tr><td class="line_bluedot" style="height:11;"></td></tr>
		</table>

		<table class="search_in" border="0">
		<tr class="h23">
			<td class="gray_tit"><img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">By Office</td>
			<td>Office Level</td>
			<td>
				<script language="javascript">ComComboObject('f_ofc_lvl', 1, 131, 1)</script>
			</td>
			<td>Office</td>
			<td>
				<script language="javascript">ComComboObject('f_ofc_cd', 1, 80, 0)</script>
			</td>
			<td colspan="2"><input type="checkbox" class="trans" name="f_excl_sts" value="Y">Exclude Sub</td>
			
		</tr>
    <tr>
      <td colspan="9" class="line_bluedot" style="height:11;"></td>
    </tr>
		<tr class="h23">
			<td width="10%" class="gray_tit">
				<img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">By Route</td>
			<td width="11%">Trade</td>
			<td width="16%" style="padding-left:2;">
				<script language="javascript">ComComboObject('f_trd_cd', 1, 80, 0)</script>
			</td>
			<td width="11%">Sub Trade</td>
			<td width="16%" style="padding-left:2;">
				<script language="javascript">ComComboObject('f_sub_trd_cd', 1, 80, 0)</script>
			</td>
			<td width="11%">Lane</td>
			<td width="11%" style="padding-left:2;">
				<script language="javascript">ComComboObject('f_rlane_cd', 1, 80, 0)</script>
			</td>
			<td width="5%">Bound</td>
			<td style="padding-left:2;">
				<script language="javascript">ComComboObject('f_dir_cd', 1, 80, 0)</script>
			</td>
		</tr>
		<tr class="h23">
			<td class="gray_tit"></td>
			<td>POR</td>
			<td>
				<input type="text" name="f_bkg_por_cd" style="width:80;ime-mode:disabled;" maxlength="5" onKeyPress="ComKeyOnlyAlphabet('uppernum');" onKeyUp="ComKeyEnter('LengthNextFocus');" onFocus="this.select();">
			</td>
			<td>Revenue POL</td>
			<td>
				<input type="text" name="f_rev_pol_cd" style="width:80;ime-mode:disabled;" maxlength="5" onKeyPress="ComKeyOnlyAlphabet('uppernum');" onKeyUp="ComKeyEnter('LengthNextFocus');" onFocus="this.select();">
			</td>
			<td>Revenue POD</td>
			<td>
				<input type="text" name="f_rev_pod_cd" style="width:80;ime-mode:disabled;" maxlength="5" onKeyPress="ComKeyOnlyAlphabet('uppernum');" onKeyUp="ComKeyEnter('LengthNextFocus');" onFocus="this.select();">
			</td>
			<td>DEL</td>
			<td>
				<input type="text" name="f_bkg_del_cd" style="width:80;ime-mode:disabled;" maxlength="5" onKeyPress="ComKeyOnlyAlphabet('uppernum');" onKeyUp="ComKeyEnter('LengthNextFocus');" onFocus="this.select();">
			</td>
		</tr>
		<tr class="h23">
		<td></td>
		<td>VVD</td>
			<td ><input type="text" name="f_vsl_cd" style="width:50;text-align:center;ime-mode:disabled;" maxlength="4"
				       onKeyPress="ComKeyOnlyAlphabet('uppernum');" onKeyUp="ComKeyEnter('LengthNextFocus');"
				       onFocus="this.select();">
				<input type="text" name="f_skd_voy_no" style="width:50;text-align:center;" maxlength="4"
				       onKeyPress="ComKeyOnlyNumber(this);" onKeyUp="ComKeyEnter('LengthNextFocus');"
				       onFocus="this.select();">
				<input type="text" name="f_skd_dir_cd"    style="width:20;text-align:center;ime-mode:disabled;" maxlength="1"
				       onKeyPress="ComKeyOnlyAlphabet('upper');" onKeyUp="ComKeyEnter('LengthNextFocus');"
				       onFocus="this.select();">
			</td>
			<td>IOC</td>
			<td style="padding-left:2;">
				<script language="javascript">ComComboObject('f_ioc_cd', 1, 80, 0)</script>
			</td>
			<td>Trade Dir.</td>
			<td style="padding-left:2;">
				<script language="javascript">ComComboObject('f_hul_bnd_cd', 1, 80, 0)</script>
			</td>
		</tr>
    <tr>
      <td colspan="9" class="line_bluedot" style="height:11;"></td>
    </tr>
		<tr class="h23">
			<td class="gray_tit">
				<img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">By Customer
			</td>
			<td>Shipper</td>
			<td>
				<input type="text" name="txtShipper" style="width:57;ime-mode:disabled;" maxlength="8" onKeyPress="ComKeyOnlyAlphabet('uppernum');" onFocusOut="chkFormat(this);" onFocus="this.select();">
				<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"  onClick="shipperPopUp();">
			</td>
			<td>Service Contract</td>
			<td>
				<input type="text" name="f_sc_no" style="width:57;ime-mode:disabled;" maxlength="9" onKeyPress="ComKeyOnlyAlphabet('uppernum');" onFocus="this.select();">
				<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" onClick="comPopupLoc(1);">
			</td>
			<td>RFA</td>
			<td>
				<input type="text" name="f_rfa_no" style="width:80;ime-mode:disabled;" maxlength="11" onKeyPress="ComKeyOnlyAlphabet('uppernum');" onFocus="this.select();">
				<!-- <img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" onClick="comPopupLoc(2);">  -->
			</td>
      <td>TAA</td>
      <td><input type="text" maxlength="11" name="f_taa_no" style="width:80;ime-mode:disabled;"  onKeyPress="ComKeyOnlyAlphabet('uppernum');"></td>

		</tr>
    <tr>
      <td colspan="9" class="line_bluedot" style="height:11;"></td>
    </tr>
		<tr class="h23">
			<td class="gray_tit">
				<img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">By Others
			</td>
			<td>Rep. Commodity</td>
			<td style="padding-left:2;">
				<script language="javascript">ComComboObject('f_rep_cmdt_cd', 2, 80, 0)
			</script></td>
			<td>Service Mode</td>
			<td>
				<script language="javascript">ComComboObject('f_usa_bkg_mod_cd', 1, 80, 1)</script>
			</td>
			<td>RPT Form</td>
			<td><select name="RPTForm" style="width:80;" onChange="rPTFormOnChange(this);">
				<option value="ACCT" selected>Account</option>
				<option value="TPSZ">TP/SZ</option>
				</select>
			</td>
			<td colspan="2"></td>
		</tr>

		<!--
		<tr>
	      <td colspan="9" class="line_bluedot" style="height:11;"></td>
	    </tr>
	    -->
		<tr class="h23">
			<td class="gray_tit">&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td colspan="2" style="padding-left:-6;"><input type="checkbox" class="trans" name="f_bkg_sts" value="Y">Waiting Booking Include</td>
			<td><input type="checkbox" class="trans" name="f_include_ts" value="Y">Include T/S</td>
			<td><input type="checkbox" class="trans" name="f_cntr_tpsz_cd" value="Y">Without Void</td>
			<td colspan="2"><input type="checkbox" class="trans" name="f_fixed_rate" value="Y">F_Index</td>
		</tr>



		</table>
		<!-- : ( Year) (E) -->

	</td>
</tr>
</table>

<!-- TABLE '#D' : ( Search Options) (E) -->
<table class="height_10"><tr><td></td></tr></table>

<!-- TABLE '#D' : ( Search Options) (S) -->
<table class="search">
<tr><td class="bg">

		<!-- : ( POR) (S) -->
		<table width="100%">
		<tr>
			<td width="100%">
<div id="tabLayer1" style="display:inline">
				<table width="100%" id="mainTable1">
				<tr><td align="right">
						<div id="div_zoom_in1" style="display:inline">
						<img class="cursor" src="/hanjin/img/bu_prev01.gif" width="20" height="11" border="0" name="bu_zoom_in1" alt="Zoom in(+)">
						</div>
						<div id="div_zoom_out1" style="display:none">
						<img class="cursor" src="/hanjin/img/bu_next01.gif" width="20" height="11" border="0" name="bu_zoom_out1" alt="Zoom out(-)">
						</div>
					</td>
				</tr>
				<tr><td><script language="javascript">ComSheetObject('sheet1');</script></td></tr>
				</table>
</div>
<div id="tabLayer2" style="display:inline">
				<table width="100%" id="mainTable2">
				<tr><td align="right">
						<div id="div_zoom_in2" style="display:inline">
						<img class="cursor" src="/hanjin/img/bu_prev01.gif" width="20" height="11" border="0" name="bu_zoom_in2" alt="Zoom in(+)">
						</div>
						<div id="div_zoom_out2" style="display:none">
						<img class="cursor" src="/hanjin/img/bu_next01.gif" width="20" height="11" border="0" name="bu_zoom_out2" alt="Zoom out(-)">
						</div>
					</td>
				</tr>
				<tr><td><script language="javascript">ComSheetObject('sheet2');</script></td></tr>
				</table>
</div>
			</td>
		</tr>
		</table>
		<!-- : ( POR) (E) -->

	</td>
</tr>
</table>
<!-- TABLE '#D' : ( Search Options) (E) -->


</td></tr>
</table>
<!-- Outer Table (E)-->

</form>
</body>
</html>
