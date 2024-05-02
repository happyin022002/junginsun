<%
/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ees_cgm_1003.jsp
 *@FileTitle : Chassis Master Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.11.20
 *@LastModifier : 조재성
 *@LastVersion : 1.0
 * 2009.11.20 조재성
 * 1.0 Creation
 *--------------------------------------------------
 * History
 * 2015.04.28 Chang Young Kim [CHM-201534113] 2015년 1월 소스 보안 결함 건 조치 요청
 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.event.EesCgm1003Event"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil"%>

<%
    EesCgm1003Event event = null; //PDTO(Data Transfer Object including Parameters)
    Exception serverException = null; //서버에서 발생한 에러
    String strErrMsg = ""; //에러메세지
    int rowCount = 0; //DB ResultSet 리스트의 건수

    String successFlag = "";
    String codeList = "";
    String pageRows = "100";

    String strUsr_id = "";
    String strUsr_nm = "";
    String eqNo      = "";
    
    String strOfc_id = "";
    
    Logger log = Logger.getLogger("com.hanjin.apps.ChassisMgsetMgt.ChassisMgsetOnOffhire");

    try {
        SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        strOfc_id = account.getOfc_cd();
        
        event = (EesCgm1003Event) request.getAttribute("Event");
        serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        eqNo        = StringUtil.xssFilter(request.getParameter("eq_no"));
        if(eqNo == null){
            eqNo="";
        }
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

    } catch (Exception e) {
        out.println(e.toString());
    }
%>
<html>
<head>
<title>Chassis Master Inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            showErrMessage(errMessage);
        } // end if
        loadPage();
    }
</script>
</head>

<body onLoad="setupPage();">
<form name="form" onkeyup="ComKeyEnter('search');">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="s_usr_id" value="<%=strUsr_id %>" >
<input type="hidden" name="s_ofc_id" value="<%=strOfc_id %>" >

<!-- 개발자 작업 -->

<input name="eq_knd_cd" type="hidden" style="width: 60; text-align: center; ime-mode:disabled" class="input2" maxlength="1" readonly value="Z">
<input name="page_status" type="hidden" style="width: 60; text-align: center; ime-mode:disabled" class="input2" maxlength="1" readonly>

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr>
		<td valign="top"><!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
            <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
            <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)--> <!--biz page (S)-->
        <table class="search"> 
        <tr><td class="bg">
                <!--  biz_1  (S) -->
                <table class="search" border="0" style="width:979;"> 
                <tr class="h23">
                    <tr class="h23">
                    <td width="110">Chassis No.</td>
                    <td width="135"><input type="text" style="ime-mode:disabled;width:100;text-align:center;" class="input1" value="<%=eqNo%>" name="eq_no" maxlength="10" dataformat="engup"></td>
                    <td width="70">Type/Size</td>
                    <td width=""><input type="text" style="width:60;;text-align:center;" class="input2" name="eq_tpsz_cd" readonly></td>
                </tr> 
                </table>
                <table class="search" border="0" style="width:979;"> 
                <tr class="h23">
                    <tr class="h23">
                    <td width="110">Specification No.</td>
                    <td width="310"><input type="text" style="text-align:left;width:265;" class="input2" name="eq_spec_no" readonly></td>
                    <td width="90">Manufacture</td>
                    <td width="145"><input type="text" style="text-align:center;width:80;" class="input2" name="mft_dt" readonly></td>
                    <td width="90">Tare&nbsp;Weight</td> 
                    <td width="" class="stm">
                    	<input type="text" style="width:75;text-align:right;" class="input2" name="chss_tare_wgt" readonly>&nbsp;lbs&nbsp;
                    	<input type="text" style="width:75;text-align:right;" class="input2" name="chss_tare_wgt_kgs" readonly>&nbsp;KG
                    </td>
                    </tr> 
                </table>
                <!--  biz_1   (E) -->
                
                <table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
                
                
                <table class="search" border="0">
                <tr><td class="title_h"></td>
                    <td class="title_s">Current Status</td></tr>
                </table>
                
                
                <table class="search" border="0" style="width:979;"> 
                <tr class="h23">
                    <td width="110">Status</td>
                    <td width="140"><input type="text" style="width:100;text-align:center;color:red;" class="input2" name="aciac_div_cd" readonly></td>
                    <td  width="45">Pool</td>
                    <td width="125"><input type="text" style="width:80;text-align:center;" class="input2" name="chss_pool_cd" readonly></td>
                    <td width="90">On-hire Date</td> 
                    <td width="145"><input type="text" style="width:80;text-align:center;" class="input2" name="onh_dt" readonly></td>
                    <td width="90">On-hire Office</td> 
                    <td width=""><input type="text" style="width:75;text-align:center;" class="input2" name="onh_ofc_cd" readonly></td>
                </tr>
                </table>
                
                <table class="search" border="0" style="width:979;"> 
                <tr class="h23">
                    <td width="110">Movement Status</td>
                    <td width="140"><input type="text" style="width:100;text-align:center;" class="input2" name="chss_mvmt_sts_cd" readonly></td>
                    <td width="45">Yard</td>
                    <td width="125"><input type="text" style="width:80;text-align:center;" class="input2" name="crnt_yd_cd" readonly></td>
                    <td width="90">Event Date</td> 
                    <td width=""><input type="text" style="width:120;text-align:center;" class="input2" name="chss_mvmt_dt" readonly></td>
                </tr> 
                </table>
                <table class="height_2"><tr><td colspan="8"></td></tr></table>
                <table border="0" style="width:900;" class="search_sm2">
                        <tr class="h23">
                        <td width="200"><input type="checkbox" value="" class="trans" name="cntr_chk"> CNTR&nbsp;&nbsp;  
                        <input type="text" name="atch_cntr" style="width:90;text-align:center;" class="input2" readonly></td>
                        <td width="200"><input type="checkbox" value="" class="trans" name="mgset_chk"> M.G.Set&nbsp;&nbsp;
                        <input type="text" name="atch_mgs" style="width:80;text-align:center;" class="input2" readonly></td>
                        <td width="90"><input type="checkbox" value="" class="trans" name="bare_chk"> Bare </td>
                        <td width="100"><input type="checkbox" value="" class="trans" name="damage_chk"> Damage </td>
                        <td width="100"><input type="checkbox" value="" class="trans" name="disp_flg"> Disposal </td>
                        <td width=""><input type="checkbox" value="" class="trans" name="lstay_chk"> L/Stay more than 30 Days
                </td></tr>
                </table>
                <table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
                
                <!--  biz_1  (S) -->
                
                <table class="search" border="0">
                <tr><td class="title_h"></td>
                    <td class="title_s">Agreement</td></tr>
                </table>
                
                <table class="search" border="0" style="width:979;"> 
                <tr class="h23">
                    
                    <td width="110">Agreement No.</td>
                    <td width="140"><input type="text" style="width:100;text-align:center;" class="input2" name="agreement_no" readonly></td>
                    <td width="45">Term</td>
                    <td width="130"><input type="text" style="width:80;text-align:center;color:blue;" class="input2" name="agmt_lstm_cd" readonly></td>
                    <td width="90">Actual On-hire</td> 
                    <td width="145"><input type="text" style="width:80;text-align:center;" class="input2" name="act_onh_dt" readonly></td>
                    <td width="65">Alias No.1</td> 
                    <td width=""><input type="text" style="width:100;text-align:center;" class="input2" name="chss_als_no" readonly></td>
                </tr> 
                
                <tr class="h23">
                    <tr class="h23">
                    <td>Reference No.</td>
                    <td><input type="text" style="width:100;text-align:center;" class="input2" name="agmt_ref_no" readonly></td>
                    <td>Lessor</td>
                    <td colspan="3"><input type="text" style="width:80;text-align:center;" class="input2" name="vndr_abbr_nm" readonly></td>
                    <td>Alias No.2</td> 
                    <td width=""><input type="text" style="width:100;text-align:center;" class="input2" name="n2nd_chss_als_no" readonly></td>
                    
                    </tr> 
                </table>
                
                <table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
                
                <table class="search" border="0">
                <tr><td class="title_h"></td>
                    <td class="title_s">Registration</td></tr>
                </table>
                
                <table class="search" border="0" style="width:979;"> 
                
                <tr class="h23">
                    <td width="110">Registered State</td>
                    <td width="140"><input type="text" style="width:100;text-align:center;" class="input2" name="chss_rgst_ste_cd" readonly></td>
                    <td width="60">Reg. Year</td>
                    <td width="115"><input type="text" style="width:65;text-align:center;" class="input2" name="chss_rgst_yr" readonly></td>
                    <td rowspan="2">
                        <table border="0" style="width:407;" class="search_sm2">
                         <tr class="h23">
                            <td width="86">License No.</td> 
                            <td><input type="text" style="width:120;text-align:center;" class="input2" name="chss_rgst_lic_no" readonly></td>
                         </tr>
                         <tr class="h23">
                            <td width="">Expiry</td>
                            <td width="" class="stm">
                            <input type="radio" value="" class="trans" name="chss_rgst_prd_cd" value="PMNT"> PMNT 
                            <input type="radio" value="" class="trans" name="chss_rgst_prd_cd" value="fixed">Fixed&nbsp;&nbsp;
                            <input type="text" style="width:80;text-align:center;" class="input2" name="chss_rgst_exp_dt" readonly></td>

                        </tr></table>
                    </td>
                </tr> 
                
                <tr class="h23">
                    <td>Vehicle ID No.</td>
                    <td colspan="3"><input type="text" style="width:150;text-align:center;" class="input2" name="chss_veh_id_no" readonly></td>
                    <td>
                    
                    </td>
                    
                    </tr> 
                </table>
                
                <table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
                
                <table class="search" border="0" style="width:979;"> 
                    <tr class="h23">
                    <td width="110">Created Date</td>
                    <td width="105"><input type="text" style="width:80;text-align:center;" class="input2" name="chss_rgst_upd_dt" readonly></td>
                    <td width="15" class="stm">By</td>
                    <td width="195"><input type="text" style="width:120;text-align:center;" class="input2" name="chss_rgst_upd_id" readonly></td>
                    <td width="90">Updated Date</td>
                    <td width="105"><input type="text" style="width:80;text-align:center;" class="input2" name="upd_dt" readonly></td>
                    <td width="15" class="stm">By</td>
                    <td width=""><input type="text" style="width:120;text-align:center;" class="input2" name="upd_usr_id" readonly></td>
                    </tr> 
                </table>
                <!--  biz_1   (E) -->
                
                </td></tr>
            </table>
    <!-- Tab BG Box  (S) -->
    <!--biz page (E)-->
    
    
    <!--Button (S) -->
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
        <tr><td class="btn1_bg">
            <table border="0" cellpadding="0" cellspacing="0">
            <tr>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_retrieve"  id="btn_retrieve">Retrieve</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                <td class="btn1_line"></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_mvmt">MVMT</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
        
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_status">Status</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
            
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_spec">Spec.</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                    <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_mr">M&R</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                <td class="btn1_line"></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_print">Print</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
        </td></tr>
        </table></td>
        </td></tr>
        </table>
    <!--Button (E) -->
    </td></tr>
</table>

<div style="display:none;">
    <!-- Grid  (S) -->
        <table width="100%"  id="mainTable"> 
            <tr>
                <td width="100%">
                    <script language="javascript">ComSheetObject('sheet1');</script>
                </td>
            </tr>
        </table>
    <!-- Grid  (E) -->
</div>

<!-- 개발자 작업  끝 -->

</form>
</body>
</html>