<%/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : BCM_CCD_0008.jsp
*@FileTitle  : Container Vessel 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/09
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.bcm.ccd.commoncode.asset.event.BcmCcd0008Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    BcmCcd0008Event  event = null;              //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //Error from server
    String strErrMsg = "";                      //Error message
    int rowCount     = 0;                       //Count of DB resultSet list
    
    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    Logger log = Logger.getLogger("com.hanjin.apps.alps.bcm.ccd.commoncode.asset");
    String mainPage 		= "";
    mainPage = request.getParameter("main_page");
    // 승인처리용 정보
    String rqstNo       = JSPUtil.getParameter(request, "rqst_no");
    String procTpCd     = JSPUtil.getParameter(request, "proc_tp_cd");
    String rqstUsrChk   = JSPUtil.getParameter(request, "rqst_usr_chk");
    String rqstOfcCd    = JSPUtil.getParameter(request, "rqst_ofc_cd");
    
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        
        event = (BcmCcd0008Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
        
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        
    }catch(Exception e) {
        out.println(e.toString());
    }
    
%>
<script type="text/javascript">
    var G_MDAA_CHK;
    var G_AHTU_TP_CD;
    
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if
        loadPage();
    }
</script>
<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="mdm_yn" value="Y" id="mdm_yn" />
<input type="hidden" name="creflag" value="Y" id="creflag" />
<input type="hidden" name="mst_dat_subj_cd" value="VESL" id="mst_dat_subj_cd" />
<input type="hidden" name="rqst_no" value="<%=rqstNo%>" id="rqst_no" />
<input type="hidden" name="proc_tp_cd" value="<%=procTpCd%>" id="proc_tp_cd" />
<input type="hidden" name="rqst_usr_chk" value="<%=rqstUsrChk%>" id="rqst_usr_chk" />
<input type="hidden" name="rqst_ofc_cd" value="<%=rqstOfcCd%>" id="rqst_ofc_cd" />
<input type="hidden" name="ibflag" id="ibflag" value="I" />
<input type="hidden" name="onchange_flag" id="onchange_flag" />
<input type="hidden" name="co_cd" value="H" />

<%-- <%if (!("true").equals(mainPage)){%>
<div class="layer_popup_contents">
<div class="layer_popup_title">
<%} %>	 --%>

<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
<%--     <h2 class="page_title">
    <%if (("true").equals(mainPage)){%>
		<button type="button">
		<span id="title"></span></button></h2>
	<%}else{%>
		<span id="title1">Vessel Particular</span></h2>
	<%} %>	 --%>
    <!-- page_title(E) -->
    <!-- opus_design_btn(S) -->
    
  	<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
   	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation">Vessel Particular</span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
	</table>
	<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->
    <!-- page_location(S) -->
   <%if (("true").equals(mainPage)){%>
	<div class="location">	
		<span id="navigation"></span>
	</div>
   <%}else{%>
	</div>
   <%}%>
</div>
        <!--biz page (S)-->
        <table class="search">
		<tr>
			<td class="bg">
			
				<table class="search" border="0" style="width:979">
				<tr class="h23">
                    <td width="80">Vessel Code</td>
                    <td width="100">
                    	<input type="text" style="width:50px; text-align:center; ime-mode:disabled;" class="input1" dataformat="engup" name="vsl_cd" maxlength="4" id="vsl_cd" "/>
						<img src="img/btns_search.gif" name="btns_search1" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
					</td>
                    <td width="70">Ownership</td>
                    <td width="100"><script type="text/javascript">ComComboObject('vsl_own_ind_cd', 2, 100, 0, 1, 1, false)</script></td>
                    <td width="120" align="right">Feeder Division</td>
		            <td><script type="text/javascript">ComComboObject('fdr_div_cd', 2, 160, 0, 1, 1, false)</script></td>
                    <!-- 컬럼 존재하지 않음 -->
                    <td width="150" style="display:none;">VIP Code (NYK Code)</td>
                    <td width="170" style="display:none;"><input id="modi_vsl_cd" type="text" style="width:150px" class="input1" dataformat="engup" id="modi_vsl_cd" name="modi_vsl_cd" maxlength="3" "></td>
                    <td width="110" style="display:none;">VIP Ope. Kind</td>
                    <td style="display:none;"><script type="text/javascript">ComComboObject('modi_vsl_opr_tp_cd', 2, 150, 0, 0, 0, false)</script></td> 
                </tr>
                </table>
                <!--  biz_1   (E) -->
            </td>
        </tr>
        </table>
        
        <table class="height_8">
        <tr><td colspan="8"></td></tr>
        </table>
        
         <!-- Grid BG Box  (S) -->
        <table class="search" id="mainTable">
        <tr>
            <td class="bg">
                <!--  biz_1  (S) -->
                <table class="search" border="0" style="width:979">
                <tr class="h23">
                    <td>
                        <table class="search" border="0" style="width:979">
                        <tr class="h23">
		                    <td width="115" style="text-align:right;">Vessel Name(ENG)</td>
		                    <td width="350"><input type="text" style="width:340px;text-align:left;ime-mode:disabled;" class="input1" dataformat="engupspace" otderchar="()_\-,. " name="vsl_eng_nm" maxlength="50" id="vsl_eng_nm" /></td>
		                    <td width="160" style="text-align:right;">Vessel Name(Local)</td>
		                    <td width="350"><input type="text" style="width:340px;text-align:left;"  class="input" name="vsl_locl_nm" maxlength="50" id="vsl_locl_nm" /></td>
	                	</tr>
	                	</table>
	                	<table class="search" border="0" style="width:979"> 
              			<tr class="h23">
		                    <td width="40">Carrier</td>
		                    <td width="100"><input type="text" style="width:50px;text-align:center;ime-mode:disabled;" class="input1" dataformat="engup" name="crr_cd" maxlength="3" id="crr_cd" />
		                    <img src="img/btns_search.gif" name="btns_search2" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
		                    <td width="80" style="text-align:right;">New Built</td>
		                    <td width="100"><script type="text/javascript">ComComboObject('vsl_bld_cd', 2, 60, 0, 0, 1, false)</script></td>
		                    <td width="60" style="text-align:right;">Builder</td>
		                    <td width="120"><input type="text" style="width:100px;" class="input"   name="vsl_bldr_nm" maxlength="50" id="vsl_bldr_nm" /> </td>
<!-- 		                    <td width="60" style="text-align:right;">Company</td>
		                    <td width="80"><input type="text" style="width:50PX;ime-mode:disabled;" class="input" dataformat="engup" name="co_cd" maxlength="1"></td> -->
		                    <td width="125" style="text-align:right;">Build Area Name</td>
		                    <td><input type="text" style="width:100px;text-align:left;" class="input"  name="vsl_bld_area_nm" maxlength="500" id="vsl_bld_area_nm" /> </td>
		                </tr>   
		                </table>
		                <table class="line_bluedot"><tr><td colspan="6"></td></tr></table>

		                <!--  biz_3  (S) -->
                		<table class="search" border="0" style="width:979;">
		                <tr class="h23">
		                    <td width="60">Call Sign</td>
		                    <td width="200"><input type="text" style="width:100px;ime-mode:disabled;" class="input1" dataformat="engup" name="call_sgn_no" maxlength="15" id="call_sgn_no" /> </td>
		                    <td width="40">Flag</td>
		                    <td width="140"><input type="text" style="width:50px;text-align:center;ime-mode:disabled;" class="input1" dataformat="engup" name="vsl_rgst_cnt_cd" maxlength="2" id="vsl_rgst_cnt_cd" />
		                    <img src="img/btns_search.gif" name="btns_search3" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
		                    <td width="100">Port Of Registry</td>
		                    <td width="170"><input type="text" style="width:70px;text-align:center;ime-mode:disabled;" class="input" dataformat="engup" name="rgst_port_cd" maxlength="5" id="rgst_port_cd" />
		                    <img src="img/btns_search.gif" name="btns_search4" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
		                    <td width="40">Class</td>
		                    <td><!-- <input type="text" style="width:100px;text-align:left;"  class="input" name="clss_no_rgst_area_nm" maxlength="50" /></td> -->
		                    <td swidth="100"><script type="text/javascript">ComComboObject('clss_no_rgst_area_nm', 2, 120, 0, 1, 0, false)</script></td> 
		                </tr>
		                </table>
		                <table class="search" border="0" style="width:979"> 
		                <tr class="h23">
		                    <td width="60">Class No</td>
		                    <td width="120"><input type="text" style="width:100px;text-align:left;ime-mode:disabled;" class="input" dataformat="eng" name="vsl_clss_no" maxlength="10" id="vsl_clss_no" /> </td>
		                    <td width="120">IMO No(LLOYD No)</td>
		                    <td width="180"><input type="text" style="width:130px;text-align:left;ime-mode:disabled;" class="input1" dataformat="eng" name="lloyd_no" maxlength="20" id="lloyd_no" /> </td>
		                    <td width="60">Hull No</td>
		                    <td width="130"><input type="text" style="width:100px;text-align:left;ime-mode:disabled;" class="input" dataformat="eng" name="vsl_hl_no" maxlength="15" id="vsl_hl_no" /> </td>
		                    <td width="80">Crew Count</td>
		                    <td colspan="3"><input type="text" style="width:120px;text-align:right;ime-mode:disabled;" class="input" dataformat="float" name="crw_knt" maxlength="5" id="crw_knt" /> </td>
		                </tr>   
		                </table>
		                <table class="search" border="0" style="width:979"> 
		                <tr class="h23">
		                    <td width="60">P&amp;I CLUB</td>
		                    <td width="120"><input type="text" style="width:100px;" class="input" name="piclb_desc"  maxlength="100" id="piclb_desc" /> </td> 
		                    <td width="120">EDI Vessel Name</td>
		                    <td width="180"><input type="text" style="width:130px;text-align:left;ime-mode:disabled;" class="input" dataformat="eng" otderchar=" "  name="vsl_edi_nm" maxlength="50" id="vsl_edi_nm" /> </td>
		                    <td width="60">Tel No</td>
		                    <td><input type="text" style="width:100px;text-align:left;ime-mode:disabled;" class="input" dataformat="saupja" name="phn_no" maxlength="20" id="phn_no" /> </td>
		                    <td>Fax</td>
		                    <td><input type="text" style="width:120px;text-align:left;ime-mode:disabled;" class="input" dataformat="saupja" name="fax_no" maxlength="20" id="fax_no" /> </td>
		                    <td>TLX</td>
		                    <td><input type="text" style="width:116px;text-align:left;ime-mode:disabled;" class="input" dataformat="saupja" name="tlx_no" maxlength="20" id="tlx_no" /> </td>
		                </tr>   
		                <table class="search" border="0" style="width:979"> 
		                <tr class="h23">
		                    <td width="40">E-Mail</td>
		                    <td colspan="2"><input type="text" style="width:190px;ime-mode:disabled;" class="input" name="vsl_eml" maxlength="50" id="vsl_eml" /> </td>
		                    <td width="90" style="text-align:right;">Official No</td>
		                    <td colspan="2"><input type="text" style="width:180px;text-align:left;ime-mode:disabled;" dataformat="eng" class="input" name="rgst_no" maxlength="15" id="rgst_no" /> </td>

		                    <td>Common Vessel</td>
		                    <td>
		                        <select style="width:85px;" class="input" name="vsl_clss_flg" id="vsl_clss_flg">
		                            <option value="Y">Y</option>
		                            <option value="N" selected>N</option>
		                        </select>
		                    </td>
		                </tr>   
		                </table>
		                <table class="search" border="0" style="width:979"> 
		                 <tr class="h23">
		                    <td width="100">Keel Laid Date</td>
		                    <td><input type="text" style="width:85px;text-align:center;ime-mode:disabled;" class="input" caption="Keel Laid Date" dataformat="ymd" name="vsl_kel_ly_dt" maxlength="8" id="vsl_kel_ly_dt" />
		                    <img class="cursor" src="img/btns_calendar.gif" name="btns_vsl_kel_ly_dt" width="19" height="20" alt="" border="0" align="absmiddle" ></td>
		                    <td>Built Date</td>
		                    <td><input type="text" style="width:85px;text-align:center;ime-mode:disabled;" class="input" caption="Launched Date" dataformat="ymd" name="vsl_lnch_dt" maxlength="8" id="vsl_lnch_dt" />
		                    <img class="cursor" src="img/btns_calendar.gif" name="btns_vsl_lnch_dt" width="19" height="20" alt="" border="0" align="absmiddle" ></td>
		                    <td>Delivered Date</td>
		                    <td><input type="text" style="width:85px;text-align:center;ime-mode:disabled;" class="input" caption="Delivered Date" dataformat="ymd" name="vsl_de_dt" maxlength="8" id="vsl_de_dt" />
		                    <img class="cursor" src="img/btns_calendar.gif" name="btns_vsl_de_dt" width="19" height="20" alt="" border="0" align="absmiddle" ></td>
		                    <td>Registered Date</td>
		                    <td><input type="text" style="width:85px;text-align:center;ime-mode:disabled;" class="input" caption="Registered Date" dataformat="ymd" name="rgst_dt" maxlength="8" id="rgst_dt" />
		                    <img class="cursor" src="img/btns_calendar.gif" name="btns_rgst_dt" width="19" height="20" alt="" border="0" align="absmiddle" ></td>
		                    <td>Close Date</td>
		                    <td><input type="text" style="width:85px;text-align:center;ime-mode:disabled;" class="input" caption="Close Date" dataformat="ymd" name="vsl_clz_dt" maxlength="8" id="vsl_clz_dt" />
		                	<img class="cursor" src="img/btns_calendar.gif" name="btns_vsl_clz_dt" width="19" height="20" alt="" border="0" align="absmiddle" ></td>
		                </tr>
		                </table> 
		                <table class="search" border="0" style="width:979">   
		                <tr class="h23">
		                    <td width="100">Vessel Remark</td>
		                    <td><input type="text" style="width:840px;text-align:left;" class="input" ddataformat="eng" otderchar=" " name="vsl_rmk" maxlength="1000" id="vsl_rmk" /> </td>
		                </tr>
		                </table>
		        </table>
		        <table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				<!--  biz_4  (S) -->
				<table class="search" border="0" style="width:979">
                	<tr class="h23">
                    <td width="40">CNTR Capacity</td>
                    <td style="text-align:right">Design</td>
                    <td><input type="text" style="width:100px;text-align:right;ime-mode:disabled;" class="input" caption="Design" dataformat="float" name="cntr_dzn_capa" maxlength="8"  id="cntr_dzn_capa" /> </td>
                    <td width="160" style="text-align:right">Operation</td>
                    <td width="80px"><input type="text" style="width:100px;text-align:right;ime-mode:disabled;" class="input" caption="Operation" dataformat="float" name="cntr_op_capa" maxlength="8"  id="cntr_op_capa" /> </td>
                    <td width="130px" style="text-align:right">Panama</td>
                    <td width="80px"><input type="text" style="width:100px;text-align:right;ime-mode:disabled;" class="input" caption="Panama" dataformat="float" name="cntr_pnm_capa" maxlength="7"  id="cntr_pnm_capa" /> </td>
                    <td width="300px" style="text-align:right">OPER(R/F)</td>
                    <td width="80px"><input type="text" style="width:100px;text-align:right;ime-mode:disabled;" class="input" dataformat="float" name="rf_rcpt_knt" maxlength="5" id="rf_rcpt_knt" /> </td>
                    <td width="200px" style="text-align:right">Max(R/F)</td>
                    <td><input type="text" style="width:70px;text-align:right;ime-mode:disabled;" class="input" dataformat="float" name="rf_rcpt_max_knt" maxlength="5"  id="rf_rcpt_max_knt" /> </td>
                </tr>   
                <tr class="h23">
                    <td>(TEU)</td>
                    <td style="text-align:right; width:300px;">Vessel Class</td>
                    <td><input type="text" style="width:100px;text-align:right;ime-mode:disabled;" class="input1" caption="Vessel Class" dataformat="float" name="cntr_vsl_clss_capa" maxlength="13"  id="cntr_vsl_clss_capa" /> </td>
                    <td style="text-align:right">Total</td>
                    <td><input type="text" style="width:100px;text-align:right;ime-mode:disabled;" class="input" caption="Total" dataformat="float" name="ttl_teu_knt" maxlength="13"  id="ttl_teu_knt" /> </td>
                    <td style="text-align:right">Hatch CNT</td>
                    <td><input type="text" style="width:100px;text-align:right;ime-mode:disabled;" class="input" dataformat="float" name="vsl_htch_knt" maxlength="5" id="vsl_htch_knt" /> </td>
                    <td style="text-align:right">Hold CNT</td>
                    <td colspan="3"><input type="text" style="width:100px;text-align:right;ime-mode:disabled;" class="input" dataformat="float" name="vsl_hld_knt" maxlength="5" id="vsl_hld_knt" /> </td>
                </tr>
                </table>
                <table>
                <tr><td><table class="line_bluedot"><tr><td></td></tr></table></tr>
                
                <tr class="h23">
                	<td width="300" colspan="6" style="color: #050099">Dimension & Speed & Other</td>
                </tr>
                <tr class="h23">
                    <td width="100">Dimension(M)</td>
                    <td style="text-align:right" >L.O.A</td>
                    <td><input type="text" style="width:100px;text-align:right;ime-mode:disabled;" class="input" caption="L.O.A(M)" dataformat="float" name="loa_len" maxlength="6" id="loa_len" /> </td>
                    <td style="text-align:right" width="90">L.B.P</td>
                    <td><input type="text" style="width:80px;text-align:right;ime-mode:disabled;" class="input" caption="L.B.P (M)" dataformat="float" name="lbp_len" maxlength="6" id="lbp_len" /> </td>
                    <td style="text-align:right" width="70">Breadth</td>
                    <td><input type="text" style="width:100px;text-align:right;ime-mode:disabled;" class="input" caption="Breadtd(M)" dataformat="float" name="vsl_wdt" maxlength="6"  id="vsl_wdt" /> </td>
                    <td style="text-align:right" width="50">Depth</td>
                    <td><input type="text" style="width:100px;text-align:right;ime-mode:disabled;" class="input" caption="Deptd (M)" dataformat="float" name="vsl_dpth" maxlength="3"" id="vsl_dpth" /> </td>
                    <td style="text-align:right" width="50">Height</td>
                    <td><input type="text" style="width:70px;text-align:right;ime-mode:disabled;" class="input" caption="Height (M)" dataformat="float" name="vsl_hgt" maxlength="6"  id="vsl_hgt" /> </td>
                </tr>
                <tr class="h23">
                    <td></td>
                    <td style="text-align:right">Summer Draft</td>
                    <td><input type="text" style="width:100px;text-align:right;ime-mode:disabled;" class="input" caption="Summer Draft (M)" dataformat="float" name="smr_drft_hgt" maxlength="6"  id="smr_drft_hgt" /> </td>
                    <td style="text-align:right">Freeboard</td>
                    <td colspan="7"><input type="text" style="width:80px;text-align:right;ime-mode:disabled;" class="input" caption="Freeboard (M)" dataformat="float" name="fbd_capa" maxlength="6"  id="fbd_capa" /> </td>
                </tr>   
                <tr class="h23">
                    <td>Speed(Knots)</td>
                    <td style="text-align:right">Economy</td>
                    <td><input type="text" style="width:100px;text-align:right;ime-mode:disabled;" class="input" caption="Economy/Speed(Knots)" dataformat="float" name="ecn_spd" maxlength="4" id="ecn_spd" pointcount="1"/> </td>
                    <td style="text-align:right">Service</td>
                    <td><input type="text" style="width:80px;text-align:right;ime-mode:disabled;" class="input1" caption="Service/Speed(Knots)" dataformat="float" name="vsl_svc_spd" maxlength="4" id="vsl_svc_spd" pointcount="1"/> </td>
                    <td style="text-align:right">Max</td>
                    <td colspan="5"><input type="text" style="width:100px;text-align:right;ime-mode:disabled;" class="input" caption="Max/Speed (Knots)" dataformat="float" name="max_spd" maxlength="4" id="max_spd" pointcount="1"/> </td>
                </tr>
                <tr class="h23">
                    <td>Otders(MT)</td>
                    <td style="text-align:right">Displacement</td>
                    <td><input type="text" style="width:100px;text-align:right;ime-mode:disabled;" class="input" caption="Displacement(MT)" dataformat="float" name="dpl_capa" maxlength="13" id="dpl_capa" /> </td>
                    <td style="text-align:right">Dead Weight</td>
                    <td><input type="text" style="width:80px;text-align:right;ime-mode:disabled;" class="input" caption="Dead Weight (MT)" dataformat="float" name="dwt_wgt" maxlength="8"  id="dwt_wgt" /> </td>
                    <td style="text-align:right">Light Ship</td>
                    <td colspan="5"><input type="text" style="width:100px;text-align:right;ime-mode:disabled;" caption="Light Ship (MT)" class="input" dataformat="float" name="lgt_shp_tong_wgt" maxlength="7"  id="lgt_shp_tong_wgt" /> </td>
                </tr>
                <tr><td><table class="line_bluedot"><tr><td></td></tr></table></tr>
                </table>
                <table>
                <tr class="h23">
                    <td>Tonnage</td>
                    <td style="text-align:right" width="200">International Gross Ton</td>
                    <td><input type="text" style="width:80px;text-align:right;ime-mode:disabled;" class="input1" caption="International Gross Ton" dataformat="float" name="grs_rgst_tong_wgt" maxlength="8" id="grs_rgst_tong_wgt" /> </td>
                    <td style="text-align:right" width="200">International Net Ton</td>
                    <td colspan="6"><input type="text" style="width:80px;text-align:right;ime-mode:disabled;" class="input1" caption="International Net Ton" dataformat="float" name="net_rgst_tong_wgt" maxlength="8"  id="net_rgst_tong_wgt" /> </td>
                </tr>   
                <tr class="h23">
                    <td></td>
                    <td style="text-align:right">Panama Gross Ton</td>
                    <td><input type="text" style="width:80px;text-align:right;ime-mode:disabled;" class="input" caption="Panama Gross Ton" dataformat="float" name="pnm_gt_wgt" maxlength="8"  id="pnm_gt_wgt" /> </td>
                    <td style="text-align:right">Panama Net Ton</td>
                    <td colspan="6"><input type="text" style="width:80px;text-align:right;ime-mode:disabled;" class="input" caption="Panama Net Ton" dataformat="float" name="pnm_net_tong_wgt" maxlength="8"  id="pnm_net_tong_wgt" /> </td>
                </tr>
                <tr class="h23">
                    <td></td>
                    <td style="text-align:right">Suez Gross Ton</td>
                    <td><input type="text" style="width:80px;text-align:right;ime-mode:disabled;" class="input" caption="Suez Gross Ton" dataformat="float" name="suz_gt_wgt" maxlength="8" id="suz_gt_wgt" /> </td>
                    <td style="text-align:right">Suez Net Ton</td>
                    <td width="80px"><input type="text" style="width:80px;text-align:right;ime-mode:disabled;" class="input" caption="Suez Net Ton" dataformat="float" name="suz_net_tong_wgt" maxlength="8"  id="suz_net_tong_wgt" /> </td>

                </tr>  
                </table>
                <table> 
                <tr class="h23">
                    <td></td>
                    <td style="text-align:right" width="252">ITC</td>
                    <td>
                        <select style="width:60px;" class="input" name="intl_tong_certi_flg" id="intl_tong_certi_flg">
                            <option value=""></option>
                            <option value="Y">Y</option>
                            <option value="N">N</option>
                        </select>
                    </td>
                    <td width="220" style="text-align:right;">Suez Net Ton (Maiden Voyage)</td>
                    <td width="90px"><input type="text" style="width:90px;text-align:right;ime-mode:disabled;" class="input" caption="Suez Net Ton (Maidan Voyage)" dataformat="float" name="madn_voy_suz_net_tong_wgt" maxlength="10" id="madn_voy_suz_net_tong_wgt" /> </td>
                </tr>   
          </table>
          <table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
          <table class="search" border="0" style="width:979;">
                <tr class="h23" style="color: #050099">
                	<td width="300" colspan="6">Capacity & Consumption</td>
                </tr>
                <tr class="h23">
                    <td width="160px">Oil/Water Capacity(CBM)</td>
                    <td width="30px" style="text-align:right">F.O</td>
                    <td width="90px"><input type="text" style="width:80px;text-align:right;ime-mode:disabled;" class="input" caption="F.O (CAPA/CBM)" dataformat="float" name="foil_capa" maxlength="19"  id="foil_capa" /> </td>
                    <td width="30px" style="text-align:right">D.O</td>
                    <td width="90px"><input type="text" style="width:80px;text-align:right;ime-mode:disabled;" class="input" captiㅐon="D.O (CAPA/CBM)" dataformat="float" name="doil_capa" maxlength="19"  id="doil_capa" /> </td>
                    <td width="30px" style="text-align:right">F.W</td>
                    <td width="90px"><input type="text" style="width:80px;text-align:right;ime-mode:disabled;" class="input" caption="F.W (CAPA/CBM)" dataformat="float" name="frsh_wtr_capa" maxlength="19"  id="frsh_wtr_capa" /> </td>
                    <td width="45px" style="text-align:right">Ballast</td>
                    <td><input type="text" style="width:90px;text-align:right;ime-mode:disabled;" class="input" caption="Ballast (CAPA/CBM)" dataformat="float" name="blst_tnk_capa" maxlength="19"  id="blst_tnk_capa" /> </td>
                </tr>   
                <tr class="h23">
                    <td width="160px">Daily Consumption(MT)</td>
                    <td style="text-align:right">F.O</td>
                    <td><input type="text" style="width:80px;text-align:right;ime-mode:disabled;" class="input" caption="F.O (Consumption/MT)" dataformat="float" name="foil_csm" maxlength="5"  id="foil_csm" /> </td>
                    <td style="text-align:right">D.O</td>
                    <td><input type="text" style="width:80px;text-align:right;ime-mode:disabled;" class="input" caption="D.O (Consumption/MT)" dataformat="float" name="doil_csm" maxlength="9" pointcount="4" id="doil_csm" /> </td>
                    <td style="text-align:right">F.W</td>
                    <td colspan="3"><input type="text" style="width:80px;text-align:right;ime-mode:disabled;" class="input" caption="F.W (Consumption/MT)" dataformat="float" name="frsh_wtr_csm" maxlength="9" pointcount="2" id="frsh_wtr_csm" /> </td>
                </tr>   
        </table>
        <table class="line_bluedot"><tr><td colspan="6"></td></tr></table>     
        <table class="search" border="0" style="width:979;">
                <tr class="h23">
                    <td width="120px">Main Engine</td>
                    <td width="85px">Maker</td>
                    <td width="190px"><input type="text" style="width:180px;text-align:left;" class="input"  name="mn_eng_mkr_nm" maxlength="50" id="mn_eng_mkr_nm" /> </td>
                    <td width="40px">Type</td>
                    <td width="190px"><input type="text" style="width:180px;text-align:left;" class="input"  name="mn_eng_tp_desc" maxlength="100" id="mn_eng_tp_desc" /> </td>
                    <td width="40px">B.H.P</td>
                    <td width="90px"><input type="text" style="width:80px;text-align:right;ime-mode:disabled;" class="input" dataformat="float" name="mn_eng_bhp_pwr" maxlength="7" id="mn_eng_bhp_pwr" /> </td>
                    <td width="40px">R.P.M</td>
                    <td><input type="text" style="width:90px;text-align:right;ime-mode:disabled;" class="input" dataformat="float" name="mn_eng_rpm_pwr" maxlength="7" id="mn_eng_rpm_pwr" /> </td>
                </tr>
                <tr class="h23">
                    <td>Bow Thruster</td>
                    <td>Maker</td>
                    <td><input type="text" style="width:180px;text-align:left;" class="input"  name="bwthst_mkr_nm" maxlength="50" id="bwthst_mkr_nm" /> </td>
                    <td>Type</td>
                    <td><input type="text" style="width:180px;text-align:left;" class="input"  name="bwthst_tp_desc" maxlength="100" id="bwthst_tp_desc" /> </td>
                    <td>B.H.P</td>
                    <td><input type="text" style="width:80px;text-align:right;ime-mode:disabled;" class="input" dataformat="num" name="bwthst_bhp_pwr" maxlength="6" id="bwthst_bhp_pwr" /> </td>
                    <td>R.P.M</td>
                    <td><input type="text" style="width:90px;text-align:right;ime-mode:disabled;" class="input" dataformat="float" name="bwthst_rpm_pwr" maxlength="7" id="bwthst_rpm_pwr" /> </td>
                </tr>       
                <tr class="h23">
                    <td>Generator Engine</td>
                    <td>Maker</td>
                    <td><input type="text" style="width:180px;text-align:left;" class="input"  name="gnr_mkr_nm" maxlength="50" id="gnr_mkr_nm" /> </td>
                    <td>Type</td>
                    <td><input type="text" style="width:180px;text-align:left;" class="input"  name="gnr_tp_desc" maxlength="100" id="gnr_tp_desc" /> </td>
                    <td>B.H.P</td>
                    <td><input type="text" style="width:80px;text-align:right;ime-mode:disabled;" class="input" dataformat="num" name="gnr_bhp_pwr" maxlength="6" id="gnr_bhp_pwr" /> </td>
                    <td>R.P.M</td>
                    <td><input type="text" style="width:90px;text-align:right;ime-mode:disabled;" class="input" dataformat="num" name="gnr_rpm_pwr" maxlength="6" id="gnr_rpm_pwr" /> </td>
                </tr>
        </table>
        <table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
        <table class="search" border="0" style="width:979;">
			<tr class="h23">
				<td>Delete Flag</td>
				<td><select style="width:50px;" class="input" name="delt_flg" id="delt_flg"><!-- 
				 --><option value="N">N</option><!-- 
				  --><option value="Y">Y</option><!-- 
				   --></select></td>
				<td>Create User</td>
	            <td><input type="text" style="width:80px;text-align:center;" class="input" name="cre_usr_id" id="cre_usr_id" readOnly/>
	            </td>
	            <td>Create Date/Time</td>
	            <td><input type="text" style="width:120px;text-align:center;" class="input" name="cre_dt" id="cre_dt" readOnly/>
	            </td>
	            <td>Last Update User</td>
	            <td><input type="text" style="width:80px;text-align:center;" class="input" name="upd_usr_id" id="upd_usr_id" readOnly/>
	            </td>
	            <td>Last Update Date/Time</td>
	            <td><input type="text" style="width:120px;text-align:center;" class="input" name="upd_dt" id="upd_dt" readOnly/>
	            </td>
			</tr>	
		</table>
		</table>
		</td>
		</tr>
</table>
    <!--Button (S) -->
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
        <tr><td class="btn1_bg">
            <table border="0" cellpadding="0" cellspacing="0">
            <tr>
            	<td id="btn_History">
            	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_History">History</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
                <td>
                    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                        <td class="btn1_left"></td>
                        <td class="btn1" name="btn_Retrieve">Retrieve</td>
                        <td class="btn1_right"></td>
                    </tr>
                    </table>
                </td>

                <td class="btn1_line"></td>

            <td>
                <table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
                <tr>
                    <td class="btn1_left"></td>
                    <td class="btn1" name="btn_Save">Save</td>
                    <td class="btn1_right"></td>
                </tr>
                </table>
            </td>   
          	<td id="btn_Create1">
          		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr>
					<td class="btn1_left"></td>
					<td class="btn1" name="btn_Create" id="btn_Create">Create</td>
					<td class="btn1_right"></td>
				</tr>
				</table>
			</td>
               
            <td>
                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                <tr>
                    <td class="btn1_left"></td>
                    <td class="btn1" name="btn_New">New</td>
                    <td class="btn1_right"></td>
                </tr>
                </table>
            </td>
            </tr>
            </table>
        </td></tr>
        </table>
    <!--Button (E) -->
<div class="wrap_result">
    <!-- opus_design_grid(S) -->
    <div class="opus_design_grid clear" style="display:none;">
            <script type="text/javascript">ComSheetObject('sheet1');</script>
    </div>
    <!-- opus_design_grid(E) -->
</div>

</form>
</body>