<%--
/*=========================================================
'주  시 스 템 : alps
'서브  시스템 : Office Report-by Daily BKG Creation
'프로그램 ID  : apps/alps/esm/mas/multidimensionrpt/sales/jsp/ESM_MAS_078.jsp
'프로그램 명  : Office Report-by Daily BKG Creation
'프로그램개요 : 
'작   성   자 : Nam Sangwook
'작   성   일 : 2006.11.24
'수   정   자 : Park Eun Ju
'수   정   일 : 2007.02.22
'==========================================================
' History :
' 2008.02.15 PEJ N200801154874 주간 대상항차 기준 변경 관련 요청
'                Year, Month, Week관련 화면변경
' 2008.04.04 PEJ N200803240008 MAS Report 관련 수정(Daily BKG Creation 화면)[078]
'                1. Sales Office 선택시, 최대 7일 검색 가능하나
'                   월이 변경될 경우 7일 이상으로 인식
'                   ex) 2008-1-30~20088-2-1 으로 조회시,
'                        7일 이상 불가 메세지가 보임
'                2. BKG CNFM Only -> Firm BKG Only로 표기 변경
'                3. Branch View 오류 수정
'                 - 조회 해당 Office의 STP Revenue 및 Oth Activity Cost, Net STP Income
'                   ex) A Office 조회시, 해당 기간 동안 생성된 BKG 중
'                       Contract Office<>A & Conduct Office = A BKG에 대하여 발생한
'                       A Office의 STP Revenue 및 Oth Activity Cost, Net STP Income
'                4. S.Rep Option 추가 (첨부파일 참조 바람)　
'                 - S.Rep 입력란 삽입  
'                 - Office View가 Contract 일 경우, S.Rep을 Contract S.Rep 정보와 연결하여 해당 Data 보여줌
'                   Office View가 Loading 일 경우, S.Rep을 Loading S.Rep 정보와 연결하여 해당 Data 보여줌
'                5. Data Grid 에 아래항목 추가
'                 - Trade/Lane/BD/VVD/ Office / S.REP code/ Customer(shipper)....
'                 : Trade/Lane/BD/VVD, S.REP Code, Shipper를 각 check option으로
'                  (첨부파일 참조 바람)
'                6. Branch View 위치 변경 (아래쪽) 및 버튼 누를 경우 data 볼 수 있도록 수정
'                7. 기타 : File Download 시 Item 명 중 CM 아래 공란 삭제, BKG No를 한 칸으로해서 Split 까지 함께 기재
'               = 추가 요청사항 =
'               1. CM Cost가 맞지 않는다.
'               2. BKG가 있을경우 Double Click 시 Inquiry by BKG 화면 Open시에 자동 조회 되도록 요청
'               3. BKG가 있을경우 Double Click 시 Inquiry by BKG 화면 조회시 검색 조건 Profit View, Level도 넣어 줌
'               4. Inquiry by Customized Condition의 Remark처럼 하단에 Remark 처리 요청
'                  "If you want to check all costs related to the BKG, 
'                   please mark on the "BKG Display" when retrieving the data and double click the BKG No."
'               5. Branch View의 그리드의 타이틀 중  "Oth Vol Activity" 를 "Oth Vol Activity Cost" 로 변경 요청
'               6. Branch View에 나오는 Office랑  S.Rep은 항상 Contract Office랑 Contract S.Rep이죠?
'                  그럼 Contract Office랑 C.S.Rep으로 바꿔 주실수 있으세요?
' 2008.05.07 PEJ R200804296325 css 파일 참조 확인 및 수정 요청
' 2008.07.15 PSH N200806277654 Office-Report by Daily BKG Creation Report 관련 수정 
                1. S/C No, RFA No 조회조건 추가
                2. Check Box 사용하여 Field 추가
                   - Route : BKG POR, BKG POL, BKG POD, BKG DEL
                   - CMDT : CMDT, CMDT NM
                   - SC/RFA : S/C No, RFA No
                3. Office View에 따라 Field 이름이 다르게 보이도록 수정
                   - Contract View : C.Office, C.S.Rep
                   - Loading View : L.Office, L.Rep
' 2008.10.21 박상희 N200810200009 Expense Detail로 테이블 변경하면서 sales 디렉토리로 소스분리 [078] 
' 2009.02.04 김태윤 N200901210016 - MAS_조직개편 관련 기능 수정
' 2009.03.16 김종열 N200903100130 - VVD Code에 영문 외 숫자도 입력가능하게 수정   
' 2009.04.03 배진환 N200903170122 MAS_Multi-dimension report 조회권한 변경           
' 2009.12.18 윤진영 CHM-200901902 Split 01-Daily BKG Creation 보완
' 2010.04.06 윤진영 VVD Code 가운데 back space 입력 가능하도록 수정
' 2010.04.20 윤진영 Bound Combo 연동 개발 (vvd period , loading port와)
' 2010.05.28 송호진 [Legacy전환] UI 표준안 적용 요청 관련 수정 : 
                   CHM-200901714, CHM-200901715, CHM-200901716, CHM-200901717, CHM-200901718, CHM-200901719
' 2010.12.01 김기종 Ticket ID:CHM-201006305-01 MAS Architecture 위배사항 수정
' 2011.05.11 최윤성 [CHM-201110694-01] MAS Report 화면 combo box validation 추가
' 2011.06.23 최성민 [CHM-201111639-01] [MAS]CNEE 조회 기능 추가_Office Report by Daily BKG Creation 
=========================================================*/ 
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.apps.alps.esm.mas.common.Utils"%>
<%@ page import="com.hanjin.framework.component.util.io.HttpUtil"%> 
<%
    Exception serverException = null;
    String strErrMsg= "";
    String userId   = "";
    String ofc_cd   = "";
    String ofc_lvl  = "";
    String strOfc_cd = "";
    String selGroup = "";
    String col_desc = Utils.iif(request.getParameter("col_desc")==null, "", request.getParameter("col_desc"));
    String col_nm   = Utils.iif(request.getParameter("col_nm")==null, "", request.getParameter("col_nm"));
    String xml = "";
    try {
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
        	strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        } else {
        	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        	userId = account.getUsr_id();
	        ofc_cd = account.getOfc_cd();  //.getUserOffice2();
	        ofc_lvl = account.getUsr_auth_tp_cd();  //.getUserLevel();
	        strOfc_cd = account.getOfc_cd();
	        xml = HttpUtil.makeXML(request,response); 
	        xml = xml.replaceAll("\"", "'");
        }
//    	N200903120100 처리를 위해 ofc_cd, ofc_lvl을 무조껀 SELHO.  1로 바꿔준다
    	ofc_cd = !"SELHO".equals(ofc_cd)?"SELHO":ofc_cd;
    	ofc_lvl = !"1".equals(ofc_cd)?"1":ofc_lvl;
    	
	}catch(Exception e) {
		out.println(e.toString());
	}


%>
<html>
<head>
<title>Office Report-by Daily BKG Creation</title>
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
<iframe height="0" width="0" name="frmHidden"></iframe>
<body onload="javascript:setupPage();">
<form method="post" name="form" onKeyDown="ComKeyEnter();">
<input type="hidden" name="f_cmd"> 
<input type="hidden" name="iPage">
<input type="hidden" name="chkGubun">
<input type="hidden" name="header"   value="<%=col_desc%>">
<input type="hidden" name="headerNM" value="<%=col_nm%>">
<input type="hidden" name="f_usr_lgn_ofc_cd"  value="<%=strOfc_cd%>">
<input type="hidden" name="userId"   value="<%=userId %>">
<input type="hidden" name="f_ofc_cd"   value="<%=ofc_cd %>">
<input type="hidden" name="f_ofc_lvl"  value="<%=ofc_lvl %>">
<input type="hidden" name="sXml" value="<%=xml%>"> 
<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding" >
  <tr>
    <td>
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
   	    <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
      </table>
      <!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->
      <!--Button_L (S) -->
      <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
        <tr>
          <td class="btn1_bg">
            <table border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" id="btn_retrieve" name="btn_retrieve">Retrieve</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" id="btn_downexcel" name="btn_downexcel">Down Excel</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
<!--
                <td><img class="cursor" src="/hanjin/img/button/btn_retrieve.gif" width="66" height="20" border="0" name="btn_retrieve"></td>
                <td><img class="cursor" src="/hanjin/img/button/btn_downexcel.gif" width="84" height="20" border="0" name="btn_downexcel"></td> 
-->
              </tr>
            </table>
          </td>
        </tr>
      </table>
      <!-- TABLE '#D' : ( Button : Main ) (E) -->
      <!-- TABLE '#D' : ( Search Options ) (S) -->
      <table class="search">
        <tr>
          <td class="bg" valign="top">
          <!-- : ( Year ) (S) -->
            <table class="search_in" border="0">
              <tr class="h23">
                <td width="14%" class="gray_tit"><img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">Period</td>
                <td>
                  <input type="text" class="input1" style="width:75;text-align:center;" name="f_fm_date" maxlength="8" dataformat="ymd" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)" onKeyPress="ComKeyOnlyNumber(this)" onKeyUp="ComKeyEnter('LengthNextFocus');" onBlur="f_rhq_cd_OnChange(document.form.f_rhq_cd);">&nbsp;<img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar1">&nbsp;&nbsp;~&nbsp;&nbsp;
                  <input type="text" class="input1" style="width:75;text-align:center;" name="f_to_date" maxlength="8" dataformat="ymd" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)" onKeyPress="ComKeyOnlyNumber(this)" onKeyUp="ComKeyEnter('LengthNextFocus');" onBlur="f_rlane_cd_OnChange();">&nbsp;<img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar2">
                </td>
                <td>Option</td>
                <td>
                	<input type="radio" name="f_prd_cd" value="B" class="trans" onClick="f_prd_cd_OnClick();" checked> BKG Period
                	<input type="radio" name="f_prd_cd" value="V" class="trans" onClick="f_prd_cd_OnClick();"> T.VVD Period
                </td>
              </tr>
            </table>
            <!-- : ( Year ) (E) -->
            <table class="search_in"><tr><td class="line_bluedot"></td></tr></table>
            <table class="search_in" border="0">
              <tr class="h23">
                <td width="14%" class="gray_tit"><img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">By View</td>
                <td width="6%"> Profit View</td>
                <td width="16%">
                	<script language="javascript">ComComboObject('f_pro_vw',1, 130 , 1 )</script>
                </td>
                <td width="6%">Office View</td>
                <td width="15%">
                	<script language="javascript">ComComboObject('f_ofc_vw',1, 80 , 1 )</script>
                </td>
                <td width="6%">Profit Level</td>
                <td >
                	<script language="javascript">ComComboObject('f_pro_lvl',1, 80 , 1 )</script>
                </td>
              </tr>
            </table>
            <table class="search_in"><tr><td class="line_bluedot"></td></tr></table>
            <!-- : ( By Office ) (S) -->
            <table class="search_in" border="0">
              <tr class="h23">
                <td width="14%" class="gray_tit"><img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">By Office</td>
                <td width="6%">OFC Level</td>
                <td width="16%">
                	<script language="javascript">ComComboObject('f_rhq_cd',1, 130 , 1 )</script>
                </td>
                <td width="6%">OFC</td>
                <td width="15%">
                	<script language="javascript">ComComboObject('f_sls_ofc_cd',1, 80 , 0 )</script>
                </td>            
                <td width="6%">S.Rep</td> 
                <!--20090615 text-transform:uppercase;  스타일만 먹이면 값이 소문자로 넘어가서 문제 발생 -->
                <td width="14%"><input type="text" style="width:80;" name="f_srep_cd" style="ime-mode:disabled" maxlength="5" onKeyPress="ComKeyOnlyAlphabet('uppernum');"></td>
                <td ><input type="checkbox" class="trans" name="f_excl_sts" value="Y">Excl. Sub</td>
              </tr>
            </table>
            <table class="search_in"><tr><td class="line_bluedot"></td></tr></table>
            <table class="search_in" border="0">
              <tr class="h23">
                <td width="14%" class="gray_tit" rowspan="2" valign="top" style="padding-top:5;"><img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">By Route</td>
                <td width="6%">Trade</td>
                <td width="16%">
                	<script language="javascript">ComComboObject('f_trd_cd',1, 90 , 0 )</script>
                </td>
                <td width="6%">Lane</td>
                <td width="15%">
                	<script language="javascript">ComComboObject('f_rlane_cd',1, 90 , 0 )</script>
                </td>
                <td width="6%">Dir.</td>
                <td width="14%">
                	<script language="javascript">ComComboObject('f_skd_dir_cd',1, 80 , 0 )</script>
                </td>
                <td width="6%">VVD</td>
                <td width="17%">
                    <input type="text" style="width:40;" maxlength="4" name="f_vsl_cd" onKeyPress="ComKeyOnlyAlphabet('uppernum')" onKeyUp="ComKeyEnter('LengthNextFocus');" style="ime-mode:disabled">
                    <input type="text" style="width:40;" maxlength="4" name="f_skd_voy_no" onKeyPress="ComKeyOnlyNumber(this);" onKeyUp="ComKeyEnter('LengthNextFocus');" style="ime-mode:disabled">
                    <input type="text" style="width:20;" maxlength="1" name="f_dir_cd" onKeyPress="ComKeyOnlyAlphabet('upper')" style="ime-mode:disabled">
                </td>
              </tr>
              <tr class="h23" id="tr_route2" style="display:none">
                <!-- td width="14%" class="gray_tit" rowspan="2" valign="top" style="padding-top:5;"><img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">By Route</td  -->
                <td width="6%">REV POL</td>
                <td width="16%"><input type="text" style="width:80;" name="f_rev_pol_cd" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum');" maxlength="5" ></td>
                <td width="6%">Loading Port</td>
                <td width="14%">
                	<div id="div_loading_port">
                		<script language="javascript">ComComboObject('f_loc_cd',1, 90 , 0 )</script>
                	</div>
                </td>
                <td width="6%"> </td>
                <td width="6%"> </td>
                <td width="6%">Period VVD</td>
                <td width="15%">
                	<div id="div_prd_vvd">
                		<script language="javascript">ComComboObject('f_vvd_cd',1, 100 , 0 )</script>
                	</div>
                </td>
              </tr>
            </table>
            <table class="search_in"><tr><td class="line_bluedot"></td></tr></table>
            <table class="search_in" border="0">
              <tr class="h23">
                <td width="14%" class="gray_tit"><img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">By Customer</td>
                <td width="6%"><b>S/C</b></td>
                <td width="16%">
                    <input type="text" maxlength="20" name="f_sc_no" style="width:80;" onKeyPress="onlyEngNumber();" style="ime-mode:disabled">
                    <img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" onClick="comPopupLoc(1, document.form.f_sc_no.value);">
                </td>
                <td width="6%"><b>RFA</b></td>
                <td width="11%">
                    <input type="text" maxlength="11" name="f_rfa" style="width:80;"  onKeyPress="onlyEngNumber();" style="ime-mode:disabled">
                    <!-- <img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" onClick="comPopupLoc(2, document.form.f_rfa.value);"> -->
                </td>
                <td width="8%"><input type="checkbox" class="trans" name="f_issc" value="Y" onClick="display();">SC/RFA</td>
                <td width="10%"><input type="checkbox" class="trans" name="f_iscnee" value="Y" onClick="display();">CNEE</td>
                <td width="11%"><input type="checkbox" class="trans" name="f_isshpr" value="Y" onClick="display();">SHPR</td>
                <td width="8%"><input type="checkbox" class="trans" name="f_istpsz" value="Y" onClick="display();">TPSZ</td>
                <td width="8%">Type/Size</td>
          		<td class="sm">
          			<script language="javascript">ComComboObject('f_cntr_tpsz_cd',1, 80 , 0 )</script>
	    	    </td>
              </tr>
            </table>
            <table class="search_in" border="0">
              <tr class="h23">
                <td width="14%"></td>
                <td width="19%"><input type="checkbox" class="trans" name="f_bkg_sts" value="Y" onClick="display();" checked>Waiting BKG Include</td>
                <td width="17%"><input type="checkbox" class="trans" name="f_isweek" value="Y" onClick="display();">Target VVD Week</td>
                <td width="7%"><input type="checkbox" class="trans" name="f_isvvd" value="Y" onClick="display();">VVD</td>
                <td width="9%"><input type="checkbox" class="trans" name="f_isroute" value="Y" onClick="display();">Route</td>
                <td width="10%"><input type="checkbox" class="trans" name="f_issrep" value="Y" onClick="display();">S.Rep</td>
                <td width="7%"><input type="checkbox" class="trans" name="f_iscmdt" value="Y" onClick="display();">CMDT</td>
                <td width="17%"><input type="checkbox" class="trans" name="f_isbkg" value="Y"  onClick="display();">BKG Display</td>
              </tr>
            </table>
            <!-- : ( By Customer ) (E) -->                    
  		    <!--table class="search_in" border="0">
                <tr><td class="line_bluedot" style="height:11;"></td></tr>
        	</table-->
            <!-- : ( By Others ) (S) -->                    
            <!--table class="search_in" border="0">                        
                <tr class="h23">
                    <td width="14%" class="gray_tit"><img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">By Others</td>
      	            <td width="8%"><input type="checkbox" class="trans" name="f_istpsz" value="Y" onClick="display();">TPSZ</td>
                    <td width="8%">Type/Size</td>
            		<td width="70%" class="sm"-->
			    	    <!--<script language="javascript">ComComboObject('f_cntr_tpsz_cd',1, 80 , 0 )</script> -->
                        <!--input type="text" style="width:23;" name="f_bkg_no_split" maxlength="2" onKeyPress="ComKeyOnlyAlphabet('uppernum');" style="ime-mode:disabled"></td-->
            	<!--/tr-->  
            <!-- TABLE '#D' : ( Search Options ) (E) -->
            <table class="height_10"><tr><td></td></tr></table>
            <!-- TABLE '#D' : ( Search Options ) (S) -->
            <table class="search">
              <tr>
                <td class="bg">
                  <table class="search" border="0">
                    <tr>
                      <td class="title_h"></td>
                      <td class="title_s">BKG View</td>
                      <td class="gray" style="text-align:right;"><div id="subTitle" style="text-align:right;">Firm BKG Only</div></td>
                    </tr>
                    <tr><td height="3"  colspan="3"></td></tr>
                  </table>
                  <table class="search" border="0">
                    <tr><td class="height_5" colspan="3">&nbsp;  At the booking time, revenue is estimated by G.RPB of latest 4 weeks and then actual rate is automatically updated later on. </td></tr>
                    <tr><td class="height_5" colspan="3"></td></tr>
                    <tr>
                      <td colspan="3">
                      <!-- : ( Trade ) (S) -->
                        <table width="100%" id="mainTable1">
                          <tr>
                            <td>
                              <script language="javascript">ComSheetObject('sheet1');</script>
                            </td>
                          </tr>
                        </table>
                      <!-- : ( Trade ) (E) -->
                      </td>
                    </tr>
                    <tr>
                    	<td class="height_10" colspan="3" id="btn_branch" >
    									  <!--  Button_Sub (S) -->
    									  <table width="100%" class="button">
    								     	<tr>
    								     	  <td class="btn2_bg">
    										      <table border="0" cellpadding="0" cellspacing="0">
            										<tr>
    		      									<!-- Repeat Pattern -->
    					        						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
    									      		<tr><td class="btn2_left"></td><td class="btn2" id="btn_branchView" name="btn_branchView">Branch View</td><td class="btn2_right"></td></tr></table></td>
          											<!-- Repeat Pattern -->
            										</tr></table>
    		      							</td>
    		      					  </tr>
    									  </table>
    							    	<!-- Button_Sub (E) -->
                     	</td>
                    </tr>
                    <tr>
                      <td class="line_bluedot"></td>
                    </tr>
                    <tr>
                      <td colspan="3" id="td_branch">
                        <table class="search" border="0">
                          <tr>
                            <td class="title_h"></td>
                            <td class="title_s">Branch View</td>
                          </tr>
                          <tr><td class="height_5" colspan="2"></td></tr>
                          <tr>
                            <td colspan="2">
                                <!-- : ( Trade ) (S) -->
                                <table width="100%" id="mainTable2">
                                    <tr>
                                        <td>
                                            <script language="javascript">ComSheetObject('sheet2');</script>
                                        </td>
                                    </tr>
                                </table>
                                <!-- : ( Trade ) (E) -->
                            </td>
                          </tr>
                          <tr><td class="height_2" colspan="2"></td></tr>
                        </table>
                        <table class="search" border="0" >
                          <tr>
                            <td class="title_s" style="text-align:right;" colspan="2" >Branch CM  <input type="text" name="branch_cm" style="width:100;text-align:right;" readOnly></td>
                          </tr>
                        </table>
                      </td>
                    </tr>
                  </table>
                  <table class="search" border="0">
                    <tr class="h23">
                      <td class="gray_tit">
                        <img src="/hanjin/img/ico_star.gif"> <strong>Remark</strong> <br>
                        <img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">
                        If you want to check all costs related to the BKG,
                        please mark on the "BKG Display" when retrieving the data and double click the BKG No. <br>
                        <img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">
                        BKG Period : This is based on BKG Creation Date. <br>       
                        <img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">
                        T.VVD Period : This is based on port calling schedule by VVD. 
                        When you select T.VVD Period option, "REV POL", "Loading Port", "Period VVD" window will be appeared.
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
      <!-- TABLE '#B' : 'Left + Right Body' Table (E)nd -->
      <!-- ################# TABLE '#B' ::: 'LEFT + RIGHT' FRAME (END) ################## -->
    </td>
  </tr>
</table>
</form>
</body>
</html>
