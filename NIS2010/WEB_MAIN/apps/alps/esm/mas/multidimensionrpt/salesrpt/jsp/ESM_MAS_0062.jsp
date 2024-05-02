<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_MAS_0062.jsp
*@FileTitle : Inquiry By Lane
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.08
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2009.09.08 송호진
* 1.0 Creation
*=========================================================
* History
* 2008.02.22 박은주 N200802220016 MAS 조회 기간 관련 수정 요청
*                  2007년 7월 이전, 2007년 27주 이전 data 조회시 조회 불가 및 Error Message 보여줌
* 2008.02.15 박은주 N200801154874 주간 대상항차 기준 변경 관련 요청
*                  Year, Month, Week관련 화면변경
* 2008.02.28 박은주 N200802250022 MAS_RD 관련 수정 요청
*                  화면에 Excluding SOC 항목 추가
* 2008.03.21 박은주 R200803125390 P/L 화면 보완 요청_1, 2번항목
*                  Week선택시에 Month, Week를 입력할수 있도록 변경[060, 062, 070]
* 2008.05.07 박은주 R200804296325 css 파일 참조 확인 및 수정 요청
* 2008.06.30 박상희 N200806127354 MAS_조회권한 관련 요청
* 2008.08.29 박상희 CSR No. N200807298360 Expense Detail로 테이블 변경하면서 화면단 모두 변경[062]
* 2008.11.24 박상희 CSR No. N200811060006 Week Display Option 추가
* 2009.02.04 김태윤 N200901210016 - MAS_조직개편 관련 기능 수정
* 2009.03.16 김종열 N200903100130 - VVD Code에 영문 외 숫자도 입력가능하게 수정
* 2009.03.24 배진환 N200903130001 - Key Account 조회 조건 변경
* 2009.04.02 임옥영 N200903120100 - MAS_Multi-dimension report 조회권한 변경, 디자인 수정
* 2009.05.14 배진환 N200905120702 param9에 f_ofc_cd 값셋팅 추가 ofc selectBox selected위해
* 2009.05.18 배진환 N200905130071 - MAS_조회 조건 입력 관련 수정
* 2009.09.15 송호진 ALPS F/W 적용
* 2009.10.12 송호진 f_skd_voy_no onKeyDown -> onKeyPress 수정
* 2009.10.14 송호진 initPeriod3_ofc -> masPeriod3 수정
* 2010.12.01 김기종 Ticket ID:CHM-201006305-01 MAS Architecture 위배사항 수정
* 2011.03.18 김상수 [CHM-201109282-01] Split 04-ALPS의 Location 조회불가건 수정 보완 요청
*                                      - Location에 해당하는 input이나 sheet에 영문대문자와 숫자까지 입력되게 수정
* 2011.04.15 최성민 [CHM-201110234-01] Key Account / Strategic Account Check Mark 추가하여, Key Account와 Strategic group에 
									   해당하는  BKG들만 모아서 모두 조회할 수 있는 기능추가
* 2011.05.13 김민아 [CHM-201110694-01] MAS Report 화면 combo box validation 추가 - 자리수, 영문대문자, 숫자 입력 제한
* 2013.11.13 김수정 [CHM-201327494] [MAS] 2013년 하반기 통합로그 결함 복구
*=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.mas.multidimensionrpt.salesrpt.event.EsmMas0062Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.apps.alps.esm.mas.common.Utils"%>
<%@ page import="com.hanjin.framework.component.util.io.HttpUtil"%>

<%
//	EsmMas0062Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.MultiDimensionRPT.SalesRPT");

    String prevWeek = "";
    String col_desc = Utils.iif(request.getParameter("col_desc")==null, "", request.getParameter("col_desc"));
    String col_nm   = Utils.iif(request.getParameter("col_nm")==null, "", request.getParameter("col_nm"));

    Utils utils = new Utils();
    String xml = "";
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

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
<title>Inquiry By Lane</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		var col_desc = document.form.header.value;
        var col_nm = document.form.headerNM.value;

		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if

        loadPage(col_desc, col_nm);
	}

</script>
</head>

<!-- 개발자 작업	-->
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;" onKeyDown="ComKeyEnter();">
<input type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="param_size">   <!-- month   |   콤보의 width  -->
<input type="hidden" name="chkGubun">
<input type="hidden" name="header"   value="<%=col_desc%>">
<input type="hidden" name="headerNM" value="<%=col_nm%>">
<input type="hidden" name="userId"   value="<%=strUsr_id %>">
<input type="hidden" name="f_shpr">     <!-- Shipper -->
<input type="hidden" name="f_ofc_cd"   value="">
<input type="hidden" name="f_ofc_lvl"  value="">
<input type="hidden" name="f_usr_lgn_ofc_cd"  value="<%=strOfc_cd%>">
<input type="hidden" name="sXml" value="<%=xml%>">

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>


		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation) (S) -->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation) (E) -->
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
        <!-- TABLE '#D' : ( Search Options) (S) -->
        <table class="search">
            <tr>
                <td class="bg">
                    <!-- : ( Year) (S) -->
                    <table class="search_in" border="0">
                        <tr class="h23"><td colspan="10"><script language="javascript">masPeriod3_ofc();</script></td></tr>
                        <tr class="h23">
                            <td colspan="2"  width="22%"></td>
                        	  <td colspan="8" class="gray_tit" style="color:#4361b6" style="font-size:8pt;">
        				        	   [ by Mon  - effective from July(2007) &nbsp;&nbsp;
				                  	   by Week - effective from 27WK(2007) ]
                      	    </td>
                        </tr>
                    </table>
                    <!-- : ( Year) (E) -->
        					  <table class="search_in" border="0">
        					    <tr><td class="line_bluedot" style="height:11;"></td></tr>
        					  </table>
                    <table class="search_in" border="0">
                        <tr class="h23">
                            <td width="9%" class="gray_tit"><img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">By View</td>
                            <td width="11%" style="padding-left:2;">Profit View</td>
                            <td width="14%" style="padding-left:1;">
                            	<script language="javascript">ComComboObject('f_pro_vw', 1, 131, 1)</script>
                            </td>
                            <td width="8%">Office View</td>
                            <td width="11%">
                            	<script language="javascript">ComComboObject('f_ofc_vw', 1, 80, 1)</script>
                            </td>
                            <td width="13%">Profit Level</td>
                            <td>
                            	<script language="javascript">ComComboObject('f_pro_lvl', 1, 80, 1)</script>
                            &nbsp;</td>
                        </tr>
                    </table>
        					  <table class="search_in" border="0">
        					  <tr><td class="line_bluedot" style="height:11;"></td></tr>
        					  </table>
                    <!-- : ( By Office) (S) -->
                    <table class="search_in" border="0">
                        <tr class="h23">
                            <td width="9%" class="gray_tit"><img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">By Office</td>
                            <td width="11%" style="padding-left:2;">Office Level</td>
                            <td width="14%" style="padding-left:1;">
                            	<script language="javascript">ComComboObject('f_rhq_cd', 1, 131, 1)</script>
                            </td>
                            <td width="8%">Office</td>
                            <td width="11%">
                            	<script language="javascript">ComComboObject('f_sls_ofc_cd', 1, 70, 0)</script>
                            </td>
                            <td colspan="4"><input type = "checkbox" class="trans" name ="f_excl_sub" value ="Y">Exclude Sub</td>
                        </tr>
                    </table>
                    <!-- : ( By Office) (E) -->
        					  <table class="search_in" border="0">
        					  <tr><td class="line_bluedot" style="height:11;"></td></tr>
        					  </table>
                    <!-- : ( By Route) (S) -->
                    <table class="search_in" border="0">
                        <tr class="h23">
                            <td width="9%" class="gray_tit"><img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">By Route</td>
                            <td width="5%">Trade</td>
                            <td width="10%">
                            	<script language="javascript">ComComboObject('f_trd_cd', 1, 80, 0)</script>
                            </td>
                            <td width="11%">Lane</td>
                            <td width="10%">
                            	<script language="javascript">ComComboObject('f_rlane_cd', 1, 80, 0)</script>
                            </td>
                            <td width="10%">Direction</td>
                            <td width="10%">
                            	<script language="javascript">ComComboObject('f_skd_dir_cd', 1, 80, 0)</script>
                            </td>
                            <td width="8%">Trade Dir</td>
                            <td width="10%">
                            	<script language="javascript">ComComboObject('f_trd_dir_cd', 1, 80, 0)</script>
                            </td>
                            <td width="3%">VVD</td>
                            <td align="left">
                                <input type="text" style="width:42;ime-mode:disabled;" maxlength="4" name="f_vsl_cd" onKeyPress="ComKeyOnlyAlphabet('uppernum');" onKeyUp="moveTab(this, f_skd_voy_no);">
                                <input type="text" style="width:42;ime-mode:disabled;" maxlength="4" name="f_skd_voy_no" onKeyPress="ComKeyOnlyNumber(this);" onKeyUp="moveTab(this, f_dir_cd);">
                                <input type="text" style="width:23;ime-mode:disabled;" maxlength="1" name="f_dir_cd" onKeyPress="ComKeyOnlyAlphabet('upper');">
                            </td>
                        </tr>
                        <tr class="h23">
							              <td class="gray_tit"></td>
                            <td>POR</td>
                            <td><input type="text" name="f_bkg_por_cd" maxlength="5" style="width:80;ime-mode:disabled;" onKeyPress="ComKeyOnlyAlphabet('uppernum');" onKeyUp="moveTab(this, f_rev_pol_cd);"></td>
                            <td>Revenue POL</td>
                            <td><input type="text" name="f_rev_pol_cd" maxlength="5" style="width:80;ime-mode:disabled;" onKeyPress="ComKeyOnlyAlphabet('uppernum');" onKeyUp="moveTab(this, f_rev_pod_cd);"></td>
                            <td>Revenue POD</td>
                            <td><input type="text" name="f_rev_pod_cd" maxlength="5" style="width:80;ime-mode:disabled;" onKeyPress="ComKeyOnlyAlphabet('uppernum');" onKeyUp="moveTab(this, f_bkg_del_cd);"></td>
                            <td>DEL</td>
                            <td><input type="text" name="f_bkg_del_cd" maxlength="5" style="width:80;ime-mode:disabled;" onKeyPress="ComKeyOnlyAlphabet('uppernum');"></td>

                        </tr>
                    </table>
                    <!-- : ( By Route) (E) -->
        					  <table class="search_in" border="0">
            					  <tr><td class="line_bluedot" style="height:11;"></td></tr>
        					  </table>
                    <!-- : ( By Customer) (S) -->
                    <table class="search_in" border="0">
                        <tr class="h23">
                            <td width="9%" class="gray_tit"><img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">By Customer</td>
                            <td width="11%">Shipper</td>
                            <td width="14%"><input type="text" maxlength="8" name="txtShipper" style="width:80;ime-mode:disabled;" maxlength="8" onFocusOut="chkFormat(this);" onKeyPress="ComKeyOnlyAlphabet('uppernum');">
                                <img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"  onClick="ShipperPopUp();">
                            </td>
                            <td width="8%">SC</td>
                            <td width="11%"><input type="text" maxlength="20" name="f_sc_no" style="width:80;ime-mode:disabled;" onKeyPress="ComKeyOnlyAlphabet('uppernum');">
                                <img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" onClick="comPopupLoc(1, document.form.f_sc_no.value);">
                            </td>
                            <td width="13%">RFA</td>
                            <td width="18%"><input type="text" maxlength="11" name="f_rfa_no" style="width:80;ime-mode:disabled;" onKeyPress="ComKeyOnlyAlphabet('uppernum');"></td>
                            <td width="3%">TAA</td>
                            <td><input type="text" maxlength="11" name="f_taa_no" style="width:80;ime-mode:disabled;" onKeyPress="ComKeyOnlyAlphabet('uppernum');"></td>
                        </tr>
      			            <tr class="h23">
	              				<td></td>
        						<td>Key Acct(Group)</td>
       							 <td colspan="3" style="padding-left:2;">
       							 	<script language="javascript">ComComboObject('f_key_acct_group_cd', 3, 300, 1)</script>
       							 </td>
       							 <td>Key Acct(individual)</td>
       							 <td style="padding-left:2;">
       							 	<script language="javascript">ComComboObject('f_key_acct_indvl_cd', 3, 80, 0)</script>
       							 </td>
			                  </tr>
                    <!-- : ( By Customer) (E) -->
        					  <table class="search_in" border="0">
            					  <tr><td class="line_bluedot" style="height:11;"></td></tr>
        					  </table>
                    <!-- : ( By Others) (S) -->
                    <table class="search_in" border="0">
                        <tr class="h23">
                            <td width="9%" class="gray_tit"><img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">By Others</td>
                            <td width="11%">Rep. Commodity</td>
                            <td width="14%" style="padding-left:2;">
                            	<script language="javascript">ComComboObject('f_cmdt_cd', 3, 80, 0)</script>
                            </td>
                            <td width="8%">US Mode</td>
                            <td width="11%">
                            	<script language="javascript">ComComboObject('f_usa_bkg_mod_cd', 1, 80, 1)</script>
                            </td>
                            <td width="13%">Type/Size</td>
             				<td width="18%" class="sm">
             					<script language="javascript">ComComboObject('f_cntr_tpsz_cd', 1, 80, 0, 0, 2);</script>&nbsp;
               					<input type="radio" class="trans" name="f_view_tpsz" value="box" onClick="javascript:changeType();">BOX&nbsp;
			                    <input type="radio" class="trans" name="f_view_tpsz" value="teu" checked onClick="javascript:changeType();">TEU</td>
                            <td width="3%">BKG</td>
      	                    <td><input type="text" style="width:120;ime-mode:disabled;" name="f_bkg_no" maxlength="13" onKeyPress="ComKeyOnlyAlphabet('uppernum');">
                            <!--input type="text" style="width:23;ime-mode:disabled;" name="f_bkg_no_split" maxlength="2" onKeyPress="ComKeyOnlyAlphabet('uppernum');"--></td>
            						</tr>

                   	<tr class="h23">
                    	<td></td>
	                    <td colspan="8">
	                    	<table class="search">
		                		<tr class="h23">
		                			<td width="16%"><input type="checkbox" class="trans" name="f_bkg_disp" value="Y" onClick="viewBkgNo();">&nbsp;Booking Display</td>
		                			<td width="20%"><input type="checkbox" class="trans" name="f_bkg_sts" value="Y">&nbsp;Waiting Booking Include</td>
		                			<td width="14%"><input type="checkbox" class="trans" name="f_dir_sts" value="Y" onClick="viewBound();">&nbsp;Bound Display</td>
		                			<td width="16%"><input type="checkbox" class="trans" name="f_trd_sts" value="Y" onClick="viewTrdDir();">&nbsp;Trade Dir Display</td>
		                			<td width="14%"><input type="checkbox" class="trans" name="f_soc_sts" value="Y">&nbsp;Excluding S.O.C</td>
		                			<td><input type="checkbox" class="trans" name="f_wk_sts" value="Y" onClick="viewWeek();">&nbsp;Week Display</td>		                			
		                		</tr>
		                		<tr class="h23">
		                			<td colspan="5"><input type="checkbox" class="trans" name="f_otr_key_acct" value="Y">&nbsp;Key Account</td>
		                		</tr>
		                	</table>
		                	<!-- 
							<input type="checkbox" class="trans" name="f_bkg_disp" value="Y" onClick="viewBkgNo();">&nbsp;Booking Display&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					        <input type="checkbox" class="trans" name="f_bkg_sts" value="Y">&nbsp;Waiting Booking Include&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					        <input type="checkbox" class="trans" name="f_dir_sts" value="Y" onClick="viewBound();">&nbsp;Bound Display&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					        <input type="checkbox" class="trans" name="f_soc_sts" value="Y">&nbsp;Excluding S.O.C&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					        <input type="checkbox" class="trans" name="f_wk_sts" value="Y" onClick="viewWeek();">&nbsp;Week Display</td>
                   	 		-->
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
       	<tr><td class="bg">

				<table class="search" border="0">
				<tr><td class="height_2"></td></tr>
				</table>

				<!-- : ( Trade) (S) -->
				<table width="100%" id="mainTable">
			         <tr><td>
			             <script language="javascript">ComSheetObject('sheet1');</script>
			         </td></tr>
				</table>
				<!-- : ( Trade) (E) -->


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


			</td></tr>
		</table>
     	<!-- TABLE '#D' : ( Search Options) (END) ####### -->




</td></tr>
</table>
<!-- Outer Table (E)-->


<!-- 개발자 작업  끝 -->
</form>
</body>
</html>