<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_MAS_0060.jsp
*@FileTitle : 점소 Weekly 비정형 실적 분석 RPT 조회1
*Open Issues :
*@LastModifyDate : 2010.05.28
*@LastModifier : 송호진
*@LastVersion : 1.0
*=========================================================
* History
* 2008.02.22 박은주 N200802220016 MAS 조회 기간 관련 수정 요청
*                  2007년 7월 이전, 2007년 27주 이전 data 조회시 조회 불가 및 Error Message 보여줌
* 2008.02.15 박은주 N200801154874 주간 대상항차 기준 변경 관련 요청
*                  Year, Month, Week관련 화면변경
* 2008.02.28 박은주 N200802250022 MAS_RD 관련 수정 요청
*                  화면에 Excluding SOC 항목 추가
* 2008.03.21 박은주 N200802280015 MAS_Report 관련 수정 요청_1, 2번항목
*                  2. Inquiry by Customized Condition[060]
*                  - Cost 수식 수정 : Cost = G.RPB + DEM/DET - CMB
*                  - C.S.REP 수정 (현재 L.REP 정보를 보여주고 있음)
*                  - L.REP 추가
*                  - CN CD + CUST CD에 해당하는 SHPR NM과 B/L SHPR NM으로 이원화
* 2008.03.21 박은주 R200803125390 P/L 화면 보완 요청_1, 2번항목
*                  Week선택시에 Month, Week를 입력할수 있도록 변경[060, 062, 070]
* 2008.04.07 박은주 N200804020018 MAS Report 수정 요청
*                  1. Inquiry by Customized Condition
*                   - Pop-up 화면에 연결된 table 변경 : data 조회 가능하도록 변경
*                      (첨부파일 참조)
*                   - 화면 하단에 아래 메세지 수정 및 추가
*                      ▶ Please reset the report form - in the event that an error occurs.
*                      ▶ If you want to check all costs related to the booking, please include
*                          the BKG number when retrieving the data and double click it.
*                  2. Office Report vs QTA
*                   - 기간 표시 (타화면 참조)
*                  3. Inquiry by BKG
*                   - Cost Detail 조회시 TP/SZ를 선택하고 조회할 경우 Error 발생  : 수정 요망
* 2008.05.07 박은주 R200804296325 css 파일 참조 확인 및 수정 요청
* 2008.06.30 박은주 N200806127354 MAS_조회권한 관련 요청
* 2008.08.29 박상희 N200807298360 Expense Detail로 테이블 변경하면서 화면단 모두 변경[060]
* 2009.02.04 김태윤 N200901210016 - MAS_조직개편 관련 기능 수정
* 2009.03.16 김종열 N200903100130 - VVD Code에 영문 외 숫자도 입력가능하게 수정
* 2009.03.24 배진환 N200903130001 - Key Account 조회 조건 변경
* 2009.04.03 김태윤 N200903170123 - MAS_Multi-dimension report 조회권한 변경, 디자인 수정
* 2009.05.18 배진환 N200905130071 - MAS_조회 조건 입력 관련 수정
* 2009.05.14 배진환 N200905120702 param9에 f_ofc_cd 값셋팅 추가 ofc selectBox selected위해
* 2009.10.23 김기대 New FrameWork 적용
* 2009.12.03 윤진영 CHM-200901273 Inquiry by Customized Condition 검색조건 추가 및 라이크 검색 가능하도록 기능 변경
* 2010.05.28 송호진 [Legacy전환] UI 표준안 적용 요청 관련 수정 :
*	               CHM-200901714, CHM-200901715, CHM-200901716, CHM-200901717, CHM-200901718, CHM-200901719
* 2010.09.01 김기종 CSR No. CHM-201004982-01 MAS Architecture 위배사항 수정 (CommonSC)
* 2010.09.01 김기종 CSR No. CHM-201005370-01 Inquiry by customized condition 기능 개선
* 2010.09.27 장영석 CSR No. CHM-201005937    Inquiry by customized condition 기능추가
* 2011.03.18 김상수 [CHM-201109282-01] Split 04-ALPS의 Location 조회불가건 수정 보완 요청
*                                      - Location에 해당하는 input이나 sheet에 영문대문자와 숫자까지 입력되게 수정
* 2011.04.15 최성민 [CHM-201110234-01] Key Account / Strategic Account Check Mark 추가하여, Key Account와 Strategic group에 
									  해당하는  BKG들만 모아서 모두 조회할 수 있는 기능추가
* 2011.05.13 김민아 [CHM-201110694-01] MAS Report 화면 combo box validation 추가 - 자리수, 영문대문자, 숫자 입력 제한
* 2011.06.22 김민아 [CHM-201111640-01] Reefer Core Account 조회조건 추가 - Combobox, Checkbox 추가
* 2012.08.29 이석준[CHM-201219872]   Inquiry by customized condition_MT Pick up Location 등 메뉴 추가
* 2012.10.23 최성민 [CHM-201220825] [MAS] CAM 조직 변경에 따른 MAS 반영
* 2012.11.13  원종규 [CHM-201221335]	[MAS] Inquiry by customized condition 기능 관련: SELCDA일 경우 BKG_No 헤더 선택 시 제한 조건을 적용하지 않도록 변경
* 2013.01.21  성미영 [CHM-201322531]	[MAS] Inquiry by Customized Condition 버튼 수정: GA, RA check Box 추가
* 2013.05.29 김수정[CHM-201324876]   [MAS] MAS Report내 "IAS Region " / "Bound2" 추가
* 2013.11.13 김수정 [CHM-201327494] [MAS] 2013년 하반기 통합로그 결함 복구
* 2014.01.15 김수정 [CHM-201428428] [MAS] Inquiry by Customized Condition 조회조건 제한
* 2014.01.20 김수정[CHM-201428552] [MAS] Inquiry by Customized Condition Shipper / Contract Customer View 선택 추가
* 2015.05.15 손진환[CHM-201535424] [MAS] COA 상 Fixed Rate 반영
* 2015.05.27 손진환[CHM-201536029] [MAS] COA 상 Fixed Rate 반영 요청 CSR
*=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.apps.alps.esm.mas.common.Utils"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.apps.alps.esm.mas.multidimensionrpt.salesrpt.event.EsmMas0060Event"%>
<%@ page import="com.hanjin.framework.component.util.io.HttpUtil"%>
<%
    EsmMas0060Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    GeneralEventResponse eventResponse = null;  //RDTO(Data Transfer Object including DB ResultSet)
    Exception serverException = null;
    String strErrMsg= "";
    String userId   = "";
    String ofc_cd   = "";
    String ofc_lvl  = "";
    String selGroup = "";
    String prevWeek = "";

    String col_desc = Utils.iif(request.getParameter("col_desc")==null, "", request.getParameter("col_desc"));
    String col_nm   = Utils.iif(request.getParameter("col_nm")==null, "", request.getParameter("col_nm"));

    String userName = "";
    String xml = "";
    try {
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);


        //추가----------------------------------------------------------------------------------------- START
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        userId    = account.getUsr_id();        
        //userAuth=account.getAuth();
        userName  = account.getUsr_nm();
        ofc_cd	= account.getOfc_cd();

        event = (EsmMas0060Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        xml = HttpUtil.makeXML(request, response);
        xml = xml.replaceAll("\"", "'");

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
    }catch(Exception e) {
        out.println(e.toString());
    }

%>
<html>
<head>
<title>Inquiry by Customized Condition</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	var usr_ofc_cd = "<%=ofc_cd%>";	
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        var col_desc = document.form.f_header.value;
        var col_nm = document.form.f_headernm.value;
        
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if

        loadPage(col_desc, col_nm);
    }
</script>
</head>
<iframe height="0" width="0" name="frmHidden"></iframe>
<iframe height="0" width="0" name="frmHidden2" id="frmHidden2"></iframe>
<body onload="javascript:setupPage();">
<form method="post" name="form" onKeyDown="ComKeyEnter();">
<input type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="chkGubun">
<input type="hidden" name="f_header"  value="<%=col_desc%>">
<input type="hidden" name="f_headernm" value="<%=col_nm%>">
<input type="hidden" name="userId" value="<%=userId %>">
<input type="hidden" name="ofc_cd" value="">
<input type="hidden" name="ofc_lvl" value="">
<input type="hidden" name="f_shipper">
<input type="hidden" name="sXml" value="<%=xml%>">
<input type="hidden" name="f_excel"> <!-- Excel Down 여부  -->
<input type="hidden" name="backendjob_key">
<input type="hidden" name="f_savename">


<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
  <tr>
    <td>
      <!-- TABLE '#D' : ( Page Title, Historical Tail Navigation) (S) -->
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
        <tr>
          <td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td>
        </tr>
        <tr>
          <td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td>
        </tr>
      </table>
      <!-- TABLE '#D' : ( Page Title, Historical Tail Navigation) (E) -->

      <!-- TABLE '#D' : ( Button : Main) (S) -->
      <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
        <tr>
          <td class="btn1_bg">
            <table border="0" cellpadding="0" cellspacing="0">
              <tr>
                <!-- Repeat Pattern -->
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" id="btn_Retrieve" name="btn_Retrieve">Retrieve</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" id="btn_Downexcel" name="btn_Downexcel">Down Excel</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" id="btn_ExcelFile" name="btn_ExcelFile">Excel File Download</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <!-- Repeat Pattern -->
              </tr>
            </table>
          </td>
        </tr>
      </table>
      <!-- TABLE '#D' : ( Button : Main) (E) -->


      <!-- TABLE '#D' : ( Search Options) (S) -->
      <table class="search">
        <tr>
          <td class="bg">

            <!-- : ( Year) (S) -->
            <table class="search_in" border="0">
              <tr class="h23">
                <td colspan="3"><script language="javascript">masPeriod3_ofc();</script><!-- FormControl.js --></td></tr>
              <tr class="h23">
                <td width="11%"></td>
                <td width="11%"></td>
                <td class="gray_tit" style="color:#4361b6" style="font-size:8pt;">
                   [ by Mon - effective from July(2007) &nbsp;&nbsp;
                    by Week - effective from 27WK(2007) ]
                </td>
              </tr>
            </table>
            <!-- : ( Year) (E) -->

            <!-- : ( By View) (S) -->
            <table class="search_in" border="0">
              <tr><td class="line_bluedot" style="height:11;"></td></tr>
            </table>

            <table class="search_in" border="0"><tr class="h23">
                <td width="10%" class="gray_tit">
                  <img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">By View
                </td>
                <td width="11%">Profit View</td>
                <td width="13%" style="padding-left:2px;">
                	<script language="javascript">ComComboObject('f_pro_vw', 1, 115, 1)</script>
                </td>
                <td width="11%">Office View</td>
                <td width="12%"  style="padding-left:2px;">
                	<script language="javascript">ComComboObject('f_ofc_vw', 1, 80, 1)</script>
                </td>
                <td>Profit Level</td>
                <td colspan="3" style="padding-left:2px">
                	<script language="javascript">ComComboObject('f_pro_lvl', 1, 80, 1)</script>
                </td>
              </tr>
              
              <tr><td colspan="9" class="line_bluedot" style="height:11;"></td></tr>
              
              <tr class="h23">
                <td width="10%" class="gray_tit">
                  <img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">By Office
                </td>
                <td width="11%">Office Level</td>
                <td width="13%" style="padding-left:2px">
                	<script language="javascript">ComComboObject('f_rhq_cd', 1, 115, 1)</script>
                </td>
                <td width="11%">Office</td>
                <td width="12%" style="padding-left:2px">
                	<script language="javascript">ComComboObject('f_sls_ofc_cd', 1, 80, 0)</script>
                </td>
                <td colspan="4">
                  <input type="checkbox" class="trans" name="f_excl_sts" value="Y">Exclude Sub
                </td>
              </tr>
              <tr>
                <td colspan="9" class="line_bluedot" style="height:11;"></td>
              </tr>
              <tr class="h23">
                <td width="10%" class="gray_tit">
                  <img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">By Route</td>
                <td width="11%">
                  Trade
                </td>
                <td width="13%" style="padding-left:2px">
                	<script language="javascript">ComComboObject('f_trd_cd', 1, 80, 0)</script>
                </td>
                <td width="11%">Sub Trade</td>
                <td width="12%" style="padding-left:2px">
                	<script language="javascript">ComComboObject('f_sub_trd_cd', 1, 80, 0)</script>
                </td>
                <td width="11%">IAS Region</td>
                <td width="12%" style="padding-left:2px">
                	<script language="javascript">ComComboObject('f_ias_rgn_cd', 1, 80, 0)</script>
                </td>
                <td width="9%"></td>
                <td></td>
              </tr>
              <tr class="h23">
                <td class="gray_tit"></td>
                <td width="11%">Lane</td>
                <td width="12%" style="padding-left:2px">
                	<script language="javascript">ComComboObject('f_rlane_cd', 1, 80, 0)</script>
                </td>
                <td width="13%">Bound</td>
                <td width="10%" style="padding-left:2px">
                	<script language="javascript">ComComboObject('f_skd_dir_cd', 1, 80, 0)</script>
                </td>
                <td width="13%">Trade Dir.</td>
                <td width="10%" style="padding-left:2px">
                	<script language="javascript">ComComboObject('f_hul_bnd_cd', 1, 80, 0)</script>
                </td>
                <td>VVD</td>
                <td >
                  <input type="text" style="width:42;ime-mode:disabled;" maxlength="4" name="f_vsl_cd" onKeyPress="ComKeyOnlyAlphabet('uppernum');" onKeyUp="ComKeyEnter('f_skd_voy_no');">
                  <input type="text" style="width:42;ime-mode:disabled;" maxlength="4" name="f_skd_voy_no" onKeyPress="ComKeyOnlyNumber(window);" onKeyUp="ComKeyEnter('f_dir_cd');">
                  <input type="text" style="width:23;ime-mode:disabled;" maxlength="1" name="f_dir_cd" onKeyPress="ComKeyOnlyAlphabet('upper');">
                </td>
              </tr>

              <tr class="h23">
                <td class="gray_tit"></td>
                <td>POR</td>
                <td>
                  <input type="text" name="f_bkg_por_cd" maxlength="5" style="width:80;ime-mode:disabled;" onKeyPress="ComKeyOnlyAlphabet('uppernum');" onKeyUp="ComKeyEnter(this, f_rev_pol_cd);">
                </td>
                <td>REV POL</td>
                <td>
                  <input type="text" name="f_rev_pol_cd" maxlength="5" style="width:80;ime-mode:disabled;" onKeyPress="ComKeyOnlyAlphabet('uppernum');" onKeyUp="ComKeyEnter(this, f_rev_pod_cd);">
                </td>
                <td>REV POD</td>
                <td>
                  <input type="text" name="f_rev_pod_cd" maxlength="5" style="width:80;ime-mode:disabled;" onKeyPress="ComKeyOnlyAlphabet('uppernum');" onKeyUp="ComKeyEnter(this, f_bkg_del_cd);">
                </td>
                <td>DEL</td>
                <td>
                  <input type="text" name="f_bkg_del_cd" maxlength="5" style="width:115;ime-mode:disabled;" onKeyPress="ComKeyOnlyAlphabet('uppernum');">
                </td>
              </tr>

              <tr class="h23">
                <td class="gray_tit"></td>
                <td>IAS SUB</td>
                <td style="padding-left:2px">
                	<script language="javascript">ComComboObject('f_ias_sub_grp_cd', 1, 115, 0)</script>
                </td>
                <td>BKG POL</td>
                <td><input type="text" name="f_bkg_pol_cd" maxlength="5" style="width:80;ime-mode:disabled;" onKeyPress="ComKeyOnlyAlphabet('uppernum');" onKeyUp="moveTab(this, f_bkg_pod_cd);"></td>
                <td>BKG POD</td>
                <td><input type="text" name="f_bkg_pod_cd" maxlength="5" style="width:80;ime-mode:disabled;" onKeyPress="ComKeyOnlyAlphabet('uppernum');"></td>
               <!-- 
                <td colspan="2">
                	<table with="100%" border="0">
                		<tr class="h23">
                			<td>MT Pick up</td>
                			<td style="padding-left:4px"><input type="text" name="f_mt_pu_cd" maxlength="5" style="width:50;ime-mode:disabled;" onKeyPress="ComKeyOnlyAlphabet('uppernum');"></td>
                			<td style="padding-left:1px"><script language="javascript">ComComboObject('f_mt_pu_yd_cd', 1, 43, 0)</script></td>
                		</tr>          
                	</table>
                </td>
                 --> 
                 
                <td>MT Pick up</td>
                <td>
                	<table with="100%" border="0">
                		<tr class="h23">
                			<td><input type="text" name="f_mt_pu_cd" maxlength="5" style="width:60;ime-mode:disabled;" onKeyPress="ComKeyOnlyAlphabet('uppernum');"></td>
                			<td style="padding-left:1px"><select name="f_mt_pu_yd_cd" style="width:51;"></select></td>
                		</tr>          
                	</table>
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
                  <input type="text" maxlength="8" name="txtShipper" style="width:80;ime-mode:disabled;" maxlegnth="8" onFocusOut="shprChk(this);" onKeyPress="ComKeyOnlyAlphabet('uppernum');">
                  <img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" onClick="ShipperPopUp();">
                </td>
                <td>Service Contract</td>
                <td>
                  <input type="text" maxlength="20" name="f_sc_no" style="width:80;ime-mode:disabled;" onKeyPress="ComKeyOnlyAlphabet('uppernum');">
                  <img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" onClick="comPopupLoc(1, document.form.f_sc_no.value);">
                </td>
                <td>RFA</td>
                <td><input type="text" maxlength="11" name="f_rfa_no" style="width:80;ime-mode:disabled;" onKeyPress="ComKeyOnlyAlphabet('uppernum');"></td>
                <td>TAA</td>
                <td><input type="text" maxlength="11" name="f_taa_no" style="width:115;ime-mode:disabled;" onKeyPress="ComKeyOnlyAlphabet('uppernum');"></td>
              </tr>

              <tr class="h23">
                <td></td>
                <td>Core Customer</td>
                <td colspan="3" style="padding-left:2px;">
                  <script language="javascript">ComComboObject('f_key_acct_group_cd', 1, 316, 1)</script>
                </td>
                <td>H/O Team</td>
                <td style="padding-left:2px;">
                  <script language="javascript">ComComboObject('f_ofc_team_cd', 1, 80, 0)</script>
                </td>
                <td colspan="2">
	                <input type="radio" class="trans" name="f_cust_tp" value="S">Shipper&nbsp;
                </td>
              <!--            
                <td>RF Core Acct</td>
                <td style="padding-left:2px;">
                  <script language="javascript">ComComboObject('f_rf_core_acct_cd', 2, 115, 0)</script>
                </td>
                -->
              </tr>
              <!-- 
               <tr class="h23">
                <td></td>
                <td>GA(Group)</td>
                <td colspan="3" style="padding-left:2px;">
                  <script language="javascript">ComComboObject('f_sa_trd_group_cd', 1, 316, 1)</script>
                </td>
                <td>GA(individual)</td>
                <td style="padding-left:2px;">
                  <script language="javascript">ComComboObject('f_sa_trd_indvl_cd', 2, 80, 0)</script>
                </td>
              </tr>
               -->
              
               <tr class="h23">
                <td colspan=2 align="right">
                Regional Customer&nbsp;&nbsp;&nbsp;</td>
                <td colspan="3" style="padding-left:2px;">
                  <script language="javascript">ComComboObject('f_ra_acct_group_cd', 1, 316, 1)</script>
                </td>
                <td>RHQ Team</td>
                <td style="padding-left:2px;">
                  <script language="javascript">ComComboObject('f_cust_rhq_cd', 1, 80, 0)</script>
                </td>
                <td colspan="2">
	                <input type="radio" class="trans" name="f_cust_tp" value="C" checked>Contract Customer&nbsp;
                </td>
              </tr>   
                         
              <tr>
                <td colspan="9" class="line_bluedot" style="height:11;"></td>
              </tr>
              <tr class="h23">
                <td class="gray_tit">
                  <img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">By Others
                </td>
                <td>Rep. Commodity</td>
                <td style="padding-left:2px;">
                  <script language="javascript">ComComboObject('f_cmdt_cd', 2, 80, 0, 0, 0); </script>
                </td>
                <td>US Mode</td>
                <td style="padding-left:2px;">
                	<script language="javascript">ComComboObject('f_usa_bkg_mod_cd', 1, 80, 1)</script>
                </td>
                <td>Surcharge</td>
                <td style="padding-left:2px;">
                	<script language="javascript">ComComboObject('f_mdm_charge_cd', 1, 80, 0)</script>
                </td>
                <td>S.REP</td>
                <td><input type="text" maxlength="5" name="f_srep_cd" style="width:80;ime-mode:disabled;" onKeyPress="ComKeyOnlyAlphabet('uppernum');"></td>
                </tr>

              	<tr class="h23">
                <td class="gray_tit"></td>
                <td>Type/Size</td>
                <td colspan="3">
                  <table border="0" style="height:15; width:300;">
                    <tr>
                      <td class="sm" style="padding-left:2px;">
                        <script language="javascript">ComComboObject('f_cntr_tpsz_cd', 1, 80, 0, 0, 2);</script>&nbsp;
                        <img src="img/btns_multisearch.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <input type="radio" class="trans" name="f_view_tpsz" value="BOX"  onClick="javascript:changeType();">BOX&nbsp;
                        <input type="radio" class="trans" name="f_view_tpsz" value="TEU" checked onClick="javascript:changeType();">TEU
                      </td>
                    </tr>
                  </table>
                </td>

                <td>Surcharge Type</td>
                <td style="padding-left:2px;">
                	<script language="javascript">ComComboObject('f_mdm_charge_type_cd', 1, 80, 1)</script>
                </td>

              </tr>


              <tr height="2"><td></td></tr>
              <tr class="h23">
                <td></td>
                <td>Booking</td>
                <td>
                  <input type="text" style="width:115;ime-mode:disabled;" name="f_bkg_no" maxlength="13" onKeyPress="ComKeyOnlyAlphabet('uppernum');">
                </td>
                <td colspan="6">
                
                	<table class="search">
                		<tr class="h23">
                			<td width="28%"><input type="checkbox" class="trans" name="f_bkg_sts" value="Y">&nbsp;Waiting Booking Include</td>
                			<td width="22%"><input type="checkbox" class="trans" name="f_dir_sts" value="Y" onClick="viewBound();">&nbsp;Bound Display</td>
                			<td width="22%"><input type="checkbox" class="trans" name="f_wk_sts" value="Y" onClick="viewWeek();">&nbsp;Week Display</td>
                			<td><input type="checkbox" class="trans" name="f_soc_sts" value="Y">&nbsp;Excluding S.O.C</td>
                		</tr>
                	</table>
                <!-- 
                  <input type="checkbox" class="trans" name="f_bkg_sts" value="Y">&nbsp;Waiting Booking Include&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  <input type="checkbox" class="trans" name="f_dir_sts" value="Y" onClick="viewBound();">&nbsp;Bound Display&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  <input type="checkbox" class="trans" name="f_wk_sts" value="Y" onClick="viewWeek();">&nbsp;Week Display&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  <input type="checkbox" class="trans" name="f_soc_sts" value="Y">&nbsp;Excluding S.O.C
                   -->
                </td>
              </tr>
              
              <tr class="h23">
                <td></td>
                <td></td>
                <td></td>
                <td colspan="6">
                	<table class="search">
                		<tr class="h23">
                			<td width="28%"><input type="checkbox" class="trans" name="f_otr_key_acct" value="Y">&nbsp;Core Customer</td>
                			<!-- <td width="22%"><input type="checkbox" class="trans" name="f_otr_global_acct" value="Y">&nbsp;Global Account</td> -->
                			<td width="22%"><input type="checkbox" class="trans" name="f_otr_regional_acct" value="Y">&nbsp;Regional Customer</td>
                			<td width="22%"><input type="checkbox" class="trans" name="f_local_acct" value="Y">&nbsp;Local Customer</td>
                			<!-- <td colspan="2"><input type="checkbox" class="trans" name="f_otr_rf_core_acct" value="Y">&nbsp;Reefer Core Account</td> -->
							<td><input type="checkbox" class="trans" name="f_include_ts" value="Y">Include T/S</td>
							<td><input type="checkbox" class="trans" name="f_fixed_rate" value="Y">F_Index</td>
                		</tr>
                	</table>
                </td>
              </tr>



            </table>
            <!-- : ( By View) (E) -->
          </td>
        </tr>
      </table>
      <!-- TABLE '#D' : ( Search Options) (E) -->

      <table class="height_10"><tr><td></td></tr></table>

      <!-- TABLE '#D' : ( Search Options) (S) -->
      <table class="search">
        <tr>
          <td class="bg">


            <table class="search" border="0">
              <tr class="h23">
                <td width="205">&nbsp;&nbsp;Select Customized RPT Form</td>
                <td style="padding-left:2px;">
                	<script language="javascript">ComComboObject('f_selgroup', 1, 120, 0)</script>
                </td>
                <td width="300" class="gray">
                  <img class="cursor" src="/hanjin/img/alps/ico_newwin.gif" width="11" height="12" align="absmiddle" hspace="5">
                  <a href="javascript:ComOpenWindowCenter('ESM_MAS_0178.do', 'ESM_MAS_0178', 500, 480, true, 'yes');" class="purple"> Set IAS Sub</a>
                  <img class="cursor" src="/hanjin/img/alps/ico_newwin.gif" width="11" height="12" align="absmiddle" hspace="5">
                  <a href="javascript:openRPTFormPopUp();" class="purple"> Set Customized RPT Form</a>
                </td>
              </tr>
              <tr><td class="height_2"></td></tr>
            </table>


            <!-- : ( Trade) (S) -->
            <table width="100%" id="mainTable">
              <tr>
                <td>
                  <script language="javascript">ComSheetObject('sheet1');</script>
                </td>
              </tr>
            </table>
            <!-- : ( Trade) (E) -->


            <table class="search" border="0">
              <tr class="h23">
                <td class="gray_tit" style="padding-left:0px;"><img src="/hanjin/img/ico_star.gif">&nbsp;<strong>Remark</strong></td>
              </tr>
              <tr class="h23">
                <td class="gray_tit" colspan="2" style="padding-left:10px;">
                  <img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">
                       Please reset the report form - in the event that an error occurs.<br>
                  <img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">
                      If you want to check all costs related to the booking, please include the BKG number when retrieving the data and double click it.
                </td>
              </tr>
            </table>


          </td>
        </tr>
      </table>
      <!-- ####### TABLE '#D' ::: 'RIGHT' FRAME (END) ####### -->


    </td>
  </tr>
</table>
<!-- Outer Table (E)-->



</form>
</body>
</html>
