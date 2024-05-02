<%
/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESM_SPC_0049.jsp
*@FileTitle : Inquiry by Customized Condition
*Open Issues :
*Change history :
*@LastModifyDate : 2011.08.25
*@LastModifier : 김종준
*@LastVersion : 1.0
* 2011.08.25 김종준
* 1.0 Creation
=========================================================
* History
* 2011.08.25 김종준 [CHM-201113071] control by HO/RHQ 화면과 COA 링크 팝업 추가
* 2011.09.14 이행지 [CHM-201113449-01] COA 링크 화면 보완 - REV POL, REV POD 명칭변경(POL,POD)
* 2012.03.19 김성훈 [CHM-201216752-01] COA Report 화면과 동일하게 구성 - 해당 항차, Load Office, POL/POD 조건에 맞는 실적정보 조회
* 2013.01.23 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
* 2013.04.25 진마리아 [CHM-201324211] 프로젝트 안정화 및 HELP DESK - TTL 라인 COA 팝업 연결
* 2014.02.04 [CHM-201428383-01] RFA 로직 추가
* 2014.07.04 Arie Im [CHM-201431038] SPC기능보완요청 - COA pop 및 가이드 존재시 Alloc셀 활성화
* 2014.11.05 [CHM-201432345] SMP Report 신규 생성(요건 변경으로 FCST&PFMC Status by ACCT탭 수정 sheet11) 
				- call_ui추가, VVD lenth체크추가
* 2015.08.11 ESM_COA_0059->MAS로 변경
=========================================================
*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.apps.alps.esm.coa.common.Utils"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.event.EsmSpc0049Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmSpc0049Event  event = null;              //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //서버에서 발생한 에러
    String strErrMsg = "";                      //에러메세지
    int rowCount     = 0;                       //DB ResultSet 리스트의 건수

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    Logger log = Logger.getLogger("com.hanjin.apps.spaceallocationmanage.spaceallocationmanage");

    String year       = "";
    String week       = "";
    String trade      = "";
    String subtrade   = "";
    String lane       = "";
    String bound      = "";
    String vvd        = "";
    String vsl_cd     = "";
    String skd_voy_no = "";
    String skd_dir_cd = "";

    String sls_rhq_cd = "";
    String sls_ofc_cd = "";
    String pol_cd = "";
    String pod_cd = "";
    String ioc_cd = "";
    String ofc_lvl = ""; // Office Level
    String srep_cd = ""; // S.Rep Code
    String cust_cd = ""; // Customer Code
    String sc_no   = ""; // S/C No
    String rfa_no  = ""; // RFA No
    String cust_ctrl = ""; // Customer Category

    String dest_loc_tp = "";
    String bkg_del_cd = "";
    String bkg_pod_cd = "";
    String usa_bkg_mod_cd = "";
    
    String col_desc = Utils.iif(request.getParameter("col_desc")==null, "", request.getParameter("col_desc"));
    String col_nm   = Utils.iif(request.getParameter("col_nm")==null, "", request.getParameter("col_nm"));
    
    String call_ui = "";

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();

        event = (EsmSpc0049Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");


        year       = JSPUtil.getParameter(request, "year",     "");
        week       = JSPUtil.getParameter(request, "week",     "");        
        trade      = JSPUtil.getParameter(request, "trade",    "");
        subtrade   = JSPUtil.getParameter(request, "subtrade", "");
        lane       = JSPUtil.getParameter(request, "lane",     "");
        bound      = JSPUtil.getParameter(request, "bound",    "");
        vvd        = JSPUtil.getParameter(request, "vvd",      "");
        ioc_cd     = JSPUtil.getParameter(request, "ioc_cd",   "");
        
        if( vvd.length()>=9 ) {
	        vsl_cd     = vvd.substring(0,4);
	        skd_voy_no = vvd.substring(4,8);
	        skd_dir_cd = vvd.substring(8);
        }

        sls_rhq_cd = JSPUtil.getParameter(request, "sls_area_cd", "");
        sls_ofc_cd = JSPUtil.getParameter(request, "sls_ofc_cd",  "");
        pol_cd     = JSPUtil.getParameter(request, "pol_cd",      "");
        if ( pol_cd.equals("-1")  || pol_cd.equals("1")  || pol_cd.equals("0") || pol_cd.equals("-")) {
        	pol_cd= "";
        }
        pod_cd     = JSPUtil.getParameter(request, "pod_cd",      "");
        if ( pod_cd.equals("-1")  || pod_cd.equals("1")  || pod_cd.equals("0") || pod_cd.equals("-")) {
        	pod_cd= "";
        }
        ofc_lvl     = JSPUtil.getParameter(request, "ofc_lvl",      "");
        if (ofc_lvl.equals("")) {
        	ofc_lvl= "5";
        }
        srep_cd     = JSPUtil.getParameter(request, "srep_cd",      "");
        cust_cd     = JSPUtil.getParameter(request, "cust_cd",      "");
        sc_no       = JSPUtil.getParameter(request, "sc_no",        "");
        rfa_no      = JSPUtil.getParameter(request, "rfa_no",       "");
        cust_ctrl   = JSPUtil.getParameter(request, "cust_ctrl",    "");
        if ( cust_ctrl.equals("1")  || cust_ctrl.equals("0") || cust_ctrl.equals("-")) {
        	cust_ctrl = "";
        }

        dest_loc_tp     = JSPUtil.getParameter(request, "dest_loc_tp",   "");
        bkg_del_cd     = JSPUtil.getParameter(request, "bkg_del_cd",   "");
        bkg_pod_cd     = JSPUtil.getParameter(request, "bkg_pod_cd",   "");
        usa_bkg_mod_cd     = JSPUtil.getParameter(request, "usa_bkg_mod_cd",   "");
        
        
        call_ui = JSPUtil.getParameter(request, "call_ui",   "");
        
    } catch(Exception e) {
        out.println(e.toString());
    }
%>
<html>
<head>
<title>Inquiry by Customized Condition</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
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

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="f_year"     value="<%= year %>">
<input type="hidden" name="f_fm_wk"     value="<%= week %>">
<input type="hidden" name="f_to_wk"     value="<%= week %>">
<input type="hidden" name="trade"    value="<%= trade %>">
<input type="hidden" name="subtrade" value="<%= subtrade %>">
<input type="hidden" name="f_sub_trd_cd" value="<%= subtrade %>">
<input type="hidden" name="lane"     value="<%= lane %>">
<input type="hidden" name="bound"    value="<%= bound %>">
<input type="hidden" name="vvd"      value="<%= vvd %>">
<input type="hidden" name="f_vsl_cd"      value="<%= vsl_cd %>">
<input type="hidden" name="f_skd_voy_no"  value="<%= skd_voy_no %>">
<input type="hidden" name="f_skd_dir_cd"  value="<%= skd_dir_cd %>">

<input type="hidden" name="f_ofc_vw"  value="L">	<!-- Office View -->
<input type="hidden" name="f_pro_lvl"  value="O">	<!-- Profit View -->
<input type="hidden" name="f_ofc_lvl"  value="<%=ofc_lvl%>">	<!-- Office Level -->
<input type="hidden" name="f_header"  value="<%=col_desc%>">
<input type="hidden" name="f_headernm" value="<%=col_nm%>">
<input type="hidden" name="f_ioc_cd"  value="<%= ioc_cd %>">
<input type="hidden" name="f_rhq_cd"  value="<%= sls_rhq_cd %>">
<input type="hidden" name="f_dest_loc_tp"  value="<%= dest_loc_tp %>">
<input type="hidden" name="f_bkg_del_cd"  value="<%= bkg_del_cd %>">
<input type="hidden" name="f_bkg_pod_cd"  value="<%= bkg_pod_cd %>">
<input type="hidden" name="f_usa_bkg_mod_cd"  value="<%= usa_bkg_mod_cd %>">
<input type="hidden" name="f_call_ui"  value="<%= call_ui %>">
<!-- 개발자 작업 -->

<!-- OUTER - POPUP (S)tart -->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
  <tr>
    <td valign="top">

      <!-- : ( Title ) (S) -->
	  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		   <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Inquiry by Customized Condition</td></tr>
	  </table>      
      <!-- : ( Title ) (E) -->
      
      <!-- TABLE '#D' : ( Button : Main ) (S) -->
      <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
        <tr><td class="btn1_bg">
          <table border="0" cellpadding="0" cellspacing="0">
            <tr>
              <!-- Repeat Pattern -->
              <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                  <tr>
                    <td class="btn1_left"></td>
                    <td class="btn1" name="btn_retrieve" id="btn_retrieve" alt="Alt+R">Retrieve</td>
                    <td class="btn1_right"></td>
                  </tr></table>
              </td>
              <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                  <tr>
                    <td class="btn1_left"></td>
                    <td class="btn1" name="btn_downexcel" id="btn_downexcel" alt="Alt+R">Down Excel</td>
                    <td class="btn1_right"></td>
                  </tr></table>
              </td>
              <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                  <tr>
                    <td class="btn1_left"></td>
                    <td class="btn1" name="btn_close" id="btn_close">Close</td>
                    <td class="btn1_right"></td>
                  </tr></table>
              </td>
              <!-- Repeat Pattern -->
            </tr>
          </table>
        </td></tr>
      </table>
      <!-- TABLE '#D' : ( Button : Main ) (E) -->
      <table style="width:100%;" class="search">
        <tr><td class="bg">
            <table border="0">
              <tr><td>
                  <table border="0">          
		          <tr class="h23">
		            <td width="45"><img class="nostar">Trade</td>
		            <td width="70"><input type="input" style="text-align:center;" class="input2" name="f_trd_cd" size="3" maxlength="3" style="ime-mode:disabled;" value="<%= trade %>"></td>
		            <td width="75"><img class="nostar">Sub Trade</td>
		            <td width="90"><input type="input" style="text-align:center;" class="input2" name="sub_trd_cd" size="2" maxlength="2" style="ime-mode:disabled;" value="<%= subtrade %>"></td>
		            <td width="60"><img class="nostar">Lane</td>
		            <td width="80"><input type="input" style="text-align:center;" class="input2" name="f_rlane_cd" size="5" maxlength="5" style="ime-mode:disabled;" value="<%= lane %>"></td>
		            <td width="65"><img class="nostar">Bound</td>
		            <td width="60"><input type="input" style="text-align:center;" class="input2" name="f_dir_cd" size="1" maxlength="1" style="ime-mode:disabled;" value="<%= bound %>"></td>
		            <!-- input type="hidden" name="f_pro_vw"  value="P" -->
		            <td width="85"><img class="nostar">Profit View</td>
		            <td>
		            	<%=JSPUtil.getCodeCombo("f_pro_vw","","style='width:90' onChange='f_pro_vw_OnChange();'","CD00939",0,"").trim()%>
		            </td>
		            <td colspan="2"></td>
		          </tr>
		          <tr class="h23">
		            <td><img class="nostar">Week</td>
		            <td><input type="text" style="text-align:center;" class="input2"  name="yrwk" size="8" maxlength="8" style="ime-mode:disabled;" value="<%= year + week %>"></td>
		            <td><img class="nostar">VVD</td>
		            <td><input type="input" style="text-align:center;" class="input2" name="vvd" size="12" maxlength="9" style="ime-mode:disabled;" value="<%= vvd %>"></td>
		            <td><img class="nostar">L.Office</td>
		            <td><input type="input" style="text-align:center;" class="input2" name="f_sls_ofc_cd" size="7" maxlength="9" style="ime-mode:disabled;" value="<%= sls_ofc_cd %>"></td>
		            <td><img class="nostar">POL</td>
		            <td><input type="input" style="text-align:center;" class="input2" name="f_rev_pol_cd" size="7" maxlength="9" style="ime-mode:disabled;" value="<%= pol_cd %>"></td>
		            <td><img class="nostar">POD</td>
		            <td><input type="input" style="text-align:center;" class="input2" name="f_rev_pod_cd" size="7" maxlength="9" style="ime-mode:disabled;" value="<%= pod_cd %>"></td>
	                <td><img class="nostar">Type/Size</td>
	                <td>
	                  <table border="0" style="height:15">
	                    <tr>
	                      <td class="sm" style="padding-left:2px;">
	                        <script language="javascript">ComComboObject('f_cntr_tpsz_cd', 1, 60, 0, 0, 2);</script>&nbsp;
	                        <img src="img/btns_multisearch.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
	                        &nbsp;&nbsp;
	                        <input type="radio" class="trans" name="f_view_tpsz" value="BOX"  onClick="javascript:changeType();">BOX
	                        <input type="radio" class="trans" name="f_view_tpsz" value="TEU" checked onClick="javascript:changeType();">TEU
	                      </td>
	                    </tr>
	                  </table>
	                </td>
		          </tr>
		          <tr class="h23">
		            <td><img class="nostar">S.Rep</td>
		            <td><input type="input" style="text-align:center;" class="input2" name="f_srep_cd" size="7" maxlength="5" style="ime-mode:disabled;" value="<%= srep_cd %>"></td>
		            <td><img class="nostar">Customer</td>
		            <td><input type="input" style="text-align:center;" class="input2" name="f_cust_cnt_cd" size="10" maxlength="8" style="ime-mode:disabled;" value="<%= cust_cd %>"></td>
		            <td><img class="nostar">S/C No</td>
		            <td><input type="input" style="text-align:center;" class="input2" name="f_sc_no" size="13" maxlength="15" style="ime-mode:disabled;" value="<%= sc_no %>"></td>
		            <td><img class="nostar">Category</td>
		            <td><input type="input" style="text-align:center;" class="input2" name="f_cust_ctrl" size="1" maxlength="1" style="ime-mode:disabled;" value="<%= cust_ctrl %>"></td>
		            <td><img class="nostar">RFA No</td>
		            <td><input type="input" style="text-align:center;" class="input2" name="f_rfa_no" size="13" maxlength="15" style="ime-mode:disabled;" value="<%= rfa_no %>"></td>
		            <td colspan="2"></td>
		          </tr>

                  </table>
              </td></tr>

            </table>
        </td></tr>
      </table>
      <table class="height_10"><tr><td></td></tr></table>
      <!-- TABLE '#D' : ( Search Options ) (S) -->

     <table class="height_5"><tr><td></td></tr></table>

      <!-- TABLE '#D' : ( Search Options : Speed ) (S) -->
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
                  <a href="javascript:ComOpenWindow2('ESM_MAS_0059.do', '', 'width=600, height=440, menubar=0, status=1, scrollbars=0, resizable=0');" class="purple"> Set Customized RPT Form</a>
                </td>
              </tr>
              <tr><td class="height_2"></td></tr>
            </table>

            <!-- : ( Speed ) (S) -->
            <table width="100%" id="mainTable">
              <tr>
                <td><script language="javascript">ComSheetObject('sheet1');</script></td>
              </tr>
            </table>
            <!-- : ( Speed ) (E) -->
          </td>
        </tr>
      </table>
      <!-- TABLE '#D' : ( Search Options : Speed ) (E) -->
    </td>
  </tr>
</table>

<!-- OUTER - POPUP (E)nd -->

<!-- : ( Button : Sub ) (S) -->
<!-- <table width="100%" class="sbutton">
  <tr>
    <td height="71" class="popup">
      <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
        <tr>
          <td class="btn3_bg">
            <table border="0" cellpadding="0" cellspacing="0">
              <tr>
                <!-- Repeat Pattern ->
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_save" id="btn_save">Save</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_close" id="btn_close">Close</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <!-- Repeat Pattern ->
              </tr>
            </table>
          </td>
        </tr>
      </table>
    </td>
  </tr>
</table> -->
<!-- : ( Button : Sub ) (E) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>