<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_COA_0063.jsp
*@FileTitle : EQ 회송기여도 RPT 조회1 
*Open Issues :
*Change history : sheet1, sheet2 통합으로 sheet2 관련부분 삭제
                : CSR No. N200801154876 주간 대상항차 기준 변경 관련 요청
                  (PFMC by Office 화면) 전윤주
                : CSR No. R200804296329 내부 경로 변경
*@LastModifyDate : 2008-02-28
*                : 2008-05-06
*@LastModifier : Okyoung Im
               : yunju jeon
*@LastVersion : 1.0
* 2006-11-28 Chilseo_Park
* 2008-05-06 전윤주
* 1.0 최초 생성
* =========================================================
* History
* 2008.09.22 김태윤 N200808278919 Spilt 01-COA_Report내 수정사항 (메뉴명과 윈도우 타이틀명 일치.)
* 2009.02.04 김태윤 N200901210016 - COA_조직개편 관련 기능 수정
* 2009.03.13 김태윤 N200903110001 - VVD Code에 영문 외 숫자도 입력가능하게 수정
* 2009.04.03 김종열 N200903170124 - COA_Multi-dimension report 조회권한 변경. 디자인 수정
* 2009.09.16 김기식 Alps전환작업 [ESM_COA_063] 
* 2010.12.01 김기종 Ticket ID:CHM-201006305-01 COA Architecture 위배사항 수정
* 2013.11.13 김수정 [CHM-201327494] [COA] 2013년 하반기 통합로그 결함 복구
=========================================================*/
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.framework.component.util.io.HttpUtil"%> 
<%
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg= "";
    String userId   = "";
    String ofc_cd   = "";
    String ofc_lvl  = "";
    String prevWeek = "";
    String xml = "";
    try {
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
        	strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        } else {
        	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        	
	        userId = account.getUsr_id();
	        ofc_cd = account.getOfc_cd(); //getUserOffice2();
	        ofc_lvl = account.getUsr_auth_tp_cd(); //getUserLevel();
	        
	        ofc_cd = !"SELHO".equals(ofc_cd)?"SELHO":ofc_cd;
	    	ofc_lvl = !"1".equals(ofc_cd)?"1":ofc_lvl;
	    	
	        xml = HttpUtil.makeXML(request,response); 
	        xml = xml.replaceAll("\"", "'");
        }
	}catch(Exception e) {
		out.println(e.toString());
	}
	
%>
<html>
<head>
<title>PFMC by Office</title>
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
<iframe height="0" width="0" name="frmHidden2" id="frmHidden2"></iframe>
<body onLoad="javascript:setupPage();">
<form method="post" name="form" onKeyDown="ComKeyEnter();">
  <input type="hidden" name="f_cmd">
  <input type="hidden" name="iPage">
<input type="hidden" name="f_ofc_cd" value="<%=ofc_cd %>">
<input type="hidden" name="f_ofc_lvl" value="<%=ofc_lvl %>">
<input type="hidden" name="f_shipper">

<!-- 상세조회시 충돌피하기위해 추가함  -->
<input type="hidden" name="f_trd_cd">
<input type="hidden" name="f_skd_dir_cd">
<input type="hidden" name="f_cntr_tpsz_cd">
<input type="hidden" name="f_rlane_cd">
<input type="hidden" name="sXml" value="<%=xml%>"> 

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
						<tr><td class="btn1_left"></td><td class="btn1" id="btn_retrieve" name="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" id="btn_downexcel" name="btn_downexcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>
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
                        <td colspan="10"><script language="javascript">coaPeriod1_ofc();</script></td>
                        <td width="33%">
                          <div id="div_period"></div>
                        </td>
                      </tr>
                    </table>
                    <!-- : ( Year ) (E) -->

					<table class="search_in" border="0">
					<tr><td class="line_bluedot" style="height:11;"></td></tr>
					</table>

                    <!-- : ( By Office ) (S) -->
                    <table class="search_in" border="0">
                      <tr class="h23">
                        <td class="gray_tit"><img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">By Office</td>
                        <td>Office Level</td>
                        <td>
                        	<script language="javascript">ComComboObject('f_rhq_cd',1, 131 , 0 )</script>
                        </td>
                        <td>Office</td>
                        <td colspan="5">
                        	<script language="javascript">ComComboObject('f_sls_ofc_cd',1, 80 , 0 )</script>
                        </td>
                      </tr>
                      <tr class="h23">
                        <td width="10%" class="gray_tit"><img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">By Lane</td>
                        <td width="11%">Trade</td>
                        <td width="17%">
                        	<script language="javascript">ComComboObject('f_trd_cd_s',1, 80 , 0 )</script>
                        </td>
                        <td width="11%">Lane</td>
                        <td width="15%">
                        	<script language="javascript">ComComboObject('f_rlane_cd_s',1, 80 , 0 )</script>
                        </td>
                        <td width="8%">Direction</td>
                        <td width="13%">
                        	<script language="javascript">ComComboObject('f_skd_dir_cd_s',1, 80 , 0 )</script>
                        </td>
                        <td width="3%">VVD</td>
                        <td align="right">
                          <input name="f_vvd1" type="text" style="width:42;" value="" maxlength="4" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum')" onKeyUp="upper(this);ComKeyEnter('LengthNextFocus');" >
                          <input name="f_vvd2" type="text" style="width:42;" value="" maxlength="4" onKeyPress="ComKeyOnlyNumber(this);" onKeyUp="upper(this);ComKeyEnter('LengthNextFocus');">
                          <input name="f_vvd3" type="text" style="width:23;" value="" maxlength="1" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet();" onKeyUp="upper(this);ComKeyEnter('LengthNextFocus');"></td>
                      </tr>
                      <tr class="h23">
                        <td class="gray_tit"><img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">By Customer</td>
                        <td>Shipper</td>
                        <td><input type="text" name="txtShipper" style="width:80" maxlength="8" onKeyUp="upper(this);" onFocusOut="chkFormat(this);">
                          	<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" onClick="shipperPopUp();"></td>
                        <td>Service Contract</td>
                        <td><input name="f_sc" type="text" style="width:80" onKeyUp="upper(this);">
                          	<img src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" class="cursor" onClick="comPopupLoc(1)"></td>
                        <td>RFA</td>
                        <td colspan="2">
                        	<input name="f_rfa" type="text" style="width:80" onKeyUp="upper(this);">
                          	<!-- img src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" class="cursor" onClick="comPopupLoc(2)"--></td>
						<td></td>
                      </tr>
                      <tr class="h23">
                        <td class="gray_tit"><img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">By Others</td>
                        <td>Rep. Commodity</td>
                        <td style="padding-left:2;">
                        	<script language="javascript">ComComboObject("f_r_cmdt", 3, 80 , 0 )  </script>
                        </td>
                        <td>US Mode</td>
                        <td>
                        	<script language="javascript">ComComboObject('f_usa_mode',1, 80 , 0 )</script>
                        </td>
                        <td>Type/Size</td>
                        <td colspan="3">
                        	<script language="javascript">ComComboObject('f_cntr_tpsz_cd_s', 1, 80, 1, 0, 2);</script>&nbsp;
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
              <tr><td class="bg">

                   	 <!-- : ( PFMC ) (S) -->
                     <table class="search" border="0" style="width:100%;">
                      <tr class="h23">
                        <td width="8%"><img class="nostar">Performance</td>
                        <td width="92%" class="stm">
                          <input type="radio" value="1" class="trans" name="code" onClick="layerView(1)" checked>&nbsp;Amount&nbsp;&nbsp;&nbsp;&nbsp;
                          <input type="radio" value="2" class="trans" name="code" onClick="layerView(2)" >&nbsp;Unit Cost
                        </td>
                      </tr>
                      <tr><td class="height_10"></td></tr>
                    </table>
                    <!-- : ( PFMC ) (E) -->

                  	<!-- amt -->
                    <table class="search" border="0">
                      <tr>
                        <td class="title_h"></td>
                        <td class="title_s">Performance Inquiry By AMT</td>
                      </tr>
                    </table>
                    <!-- : ( Trade ) (S) -->
                    <table width="100%" id="mainTable">
                      <tr>
                        <td>
                          <script language="javascript">ComSheetObject('sheet1');</script>
                        </td>
                      </tr>
                    </table>
                    <!-- : ( Trade ) (E) -->

					<!--  Button_Sub (S) -->
					<table width="100%" class="button">
				       	<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>

							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_routedetail" name="btng_routedetail">Route Detail</td><td class="btn2_right"></td></tr></table></td>
							<!-- Repeat Pattern -->

						</tr></table>
					</td></tr>
					</table>
			    	<!-- Button_Sub (E) -->

                    <table class="line_bluedot">
                      <tr>
                        <td></td>
                      </tr>
                    </table>
                    <table class="search" border="0"> 
                      <tr>
                        <td class="title_h"></td>
                        <td class="title_s">Route Detail Inquiry</td>
                      </tr>
                      <tr>
                        <td class="height_5"></td>
                      </tr>
                    </table>
                    <!-- : ( POR ) (S) -->
                    <table width="100%" id="mainTable">
                      <tr>
                        <td>
                          <script language="javascript">ComSheetObject('sheet2');</script>
                        </td>
                      </tr>
                    </table>
                    <!-- : ( POR ) (E) -->

					<!--  Button_Sub (S) -->
					<table width="100%" class="button">
				       	<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>

							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_downexcel" name="btng_downexcel">Down Excel</td><td class="btn2_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btng_bkgdetail" name="btng_bkgdetail">BKG Detail</td><td class="btn2_right"></td></tr></table></td>
							<!-- Repeat Pattern -->

						</tr></table>
					</td></tr>
					</table>
			    	<!-- Button_Sub (E) -->
			    	
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
