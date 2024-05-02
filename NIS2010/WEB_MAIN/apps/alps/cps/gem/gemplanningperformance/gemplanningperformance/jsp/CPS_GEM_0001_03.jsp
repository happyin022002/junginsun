<%  
    /* =========================================================
     *Copyright(c) 2009 CyberLogitec
     *@FileName : cps_gem_0001_03t.jsp
     *@FileTitle : [CPS_GEM-0001_02] Expense Request - Adjustment
     *Open Issues :
     *Change history :
     *@LastModifyDate : 2009.04.21
     *@LastModifier : 진윤오
     *@LastVersion : 1.0
     * 2009.04.17 진윤오
     * 1.0 Creation
     *---------------------------------------------------------------------------------
     * 2010.11.19 이준범 [CHM-201007198-01] Initial Plan - Closing date 설정 이후 INI RQ/AD/AP block 적용
     * 1) open000103()
     *   - searchInitialDate() ofcCd 파라미터 추가
     *   - 화면에서 Closing DT 의 유효성을 식별할수 있는 initClzFlg 를 추가하여 Input필드 및 Save 버튼  block 적용      
     ========================================================= */
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@page import="java.util.Date"%>
<%@page import="com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.event.CpsGem000103Event"%><html>
<%
    CpsGem000103Event event = null; //PDTO(Data Transfer Object including Parameters)
    Exception serverException = null; //서버에서 발생한 에러
    String strErrMsg = ""; //에러메세지
    int rowCount = 0; //DB ResultSet 리스트의 건수

    String successFlag = "";
    String codeList = "";
    String pageRows = "100";

    String strUsr_id = "";
    String strUsr_nm = "";
    String usrAuthTpCd = "";
    String usrOfcCd = "";
    Logger log = Logger.getLogger("com.hanjin.apps.GEMCommon.GEMMasterCodeMgt");

    try
    {
        SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        usrAuthTpCd = account.getUsr_auth_tp_cd();
       
        event = (CpsGem000103Event) request.getAttribute("Event");
        serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null)
        {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

    }
    catch (Exception e)
    {
        out.println(e.toString());
    }
    
    //팝업여부
    String popupYn = JSPUtil.getParameter(request , "popup_yn" , "N");
    String genExpnRqstNo = JSPUtil.getParameter(request , "gen_expn_rqst_no" , "");
    String genExpnRqstSeq = JSPUtil.getParameter(request , "gen_expn_rqst_seq" , "");
    String genExpnRqstTpCd = JSPUtil.getParameter(request , "gen_expn_rqst_tp_cd" , "");
    String ofcLvl1 = JSPUtil.getParameter(request , "ofc_lvl1" , "");
    String ofcLvl2 = JSPUtil.getParameter(request , "ofc_lvl2" , "");
    String ofcLvl3 = JSPUtil.getParameter(request , "ofc_lvl3" , "");
    String slsOfcDivCd = JSPUtil.getParameter(request , "sls_ofc_div_cd" , "");
    String fmOfcCd = JSPUtil.getParameter(request , "fm_ofc_cd" , "");
    String fmGenExpnCd = JSPUtil.getParameter(request , "fm_gen_expn_cd" , "");
    String fmGenExpnItmNo = JSPUtil.getParameter(request , "fm_gen_expn_itm_no" , "");
    String toOfcCd = JSPUtil.getParameter(request , "to_ofc_cd" , "");
    String toGenExpnCd = JSPUtil.getParameter(request , "to_gen_expn_cd" , "");
    String toGenExpnItmNo = JSPUtil.getParameter(request , "to_gen_expn_itm_no" , "");
    
%>



<html>
<head>
<title>Expense Request Adjustment</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function setupPage(year){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		
		loadPage(year);
	}
</script>
</head>

<body onLoad="setupPage('<%=DateTime.getYear()%>');">
<!-- Processing Status 에서의  호출시  팝업  -->
<form name="form6" method="post">
    <input type="hidden" name="popup_yn" value="<%=popupYn%>"> 
    <input type="hidden" name="gen_expn_rqst_no" value="<%=genExpnRqstNo%>">
    <input type="hidden" name="gen_expn_rqst_seq" value="<%=genExpnRqstSeq%>">
    <input type="hidden" name="gen_expn_rqst_tp_cd" value="<%=genExpnRqstTpCd%>">
    <input type="hidden" name="ofc_lvl1" value="<%=ofcLvl1%>">
    <input type="hidden" name="ofc_lvl2" value="<%=ofcLvl2%>">
    <input type="hidden" name="ofc_lvl3" value="<%=ofcLvl3%>">
    <input type="hidden" name="sls_ofc_div_cd" value="<%=slsOfcDivCd%>">
    <input type="hidden" name="fm_ofc_cd" value="<%=fmOfcCd%>">
    <input type="hidden" name="fm_gen_expn_cd" value="<%=fmGenExpnCd%>">
    <input type="hidden" name="fm_gen_expn_itm_no" value="<%=fmGenExpnItmNo%>">
    <input type="hidden" name="to_ofc_cd" value="<%=toOfcCd%>">
    <input type="hidden" name="to_gen_expn_cd" value="<%=toGenExpnCd%>">
    <input type="hidden" name="to_gen_expn_itm_no" value="<%=toGenExpnItmNo%>">
    
</form>
<% 
if ("Y".equals(popupYn)) {
%>
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr>
<td valign="top">
<!--Page Title, Historical (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
    <tr><td class="history">&nbsp;</td></tr>
    <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"> Expense Request - Adjustment</span></td></tr>
</table>
<!--Page Title, Historical (E)-->     
<%
}
%>
<!-- 개발자 작업 -->
<a name="top"></a>

<table class="search">
    <tr>
        <td class="bg">
		<form name="form" method="post">
		<input type="hidden" name="f_cmd"> 
		<input type="hidden" name="pagerows">
        <input type="hidden" name="req_upd_dt">
        <input type="hidden" name="itm_upd_dt">		
		<input type="hidden" name="auth_flg">		
		<input type="hidden" name="pln_yrmon">
		<input type="hidden" name="init_clz_flg">
		<input type="hidden" name="fm_gen_expn_cd_grp">
		<input type="hidden" name="fm_ofc_cd">
		<input type="hidden" name="fm_gen_expn_cd">	
		<input type="hidden" name="rownum">
        <input type="hidden" name="curr_dt" value="<%=DateTime.getFormatDate(new Date(),"yyyyMMdd")%>">       
        <input type="hidden" name="usr_auth_tp_cd" value="<%=usrAuthTpCd%>">
        <input type="hidden" name="usr_ofc_cd">
        <input type="hidden" name="usr_tic_cd">
        <input type="hidden" name="lcl_search_flg">        
        <table class="search" border="0" style="width:979;"> 
                <tr class="h23">
                    <td width="160">
                        <table class="search_sm2" border="0" style="width:95%;"> 
                            <tr class="h23">                            
                            <% if ("Y".equals(popupYn)) {                            
                                   String eiFlg = "";
                                   String eaFlg = "";
                                   
                                   if ("EI".equals(genExpnRqstTpCd)) {
                                	   eiFlg = "checked";
                                   } else {
                                	   eaFlg = "checked";
                                   }
                            %>                           	
                                <td><input type="radio" value="EA" name="gen_expn_rqst_tp_cd" onclick="onChagneRqstTpCd()" class="trans" <%=eaFlg%>>ADD/TRS
                                &nbsp;&nbsp;&nbsp;<input type="radio" name="gen_expn_rqst_tp_cd" value="EI" onclick="onChagneRqstTpCd()" class="trans"  <%=eiFlg%>>INI</td>
                           
                            <% } else {%>
                                <td><input type="radio" value="EA" name="gen_expn_rqst_tp_cd" onclick="onChagneRqstTpCd()" class="trans" checked>ADD/TRS
                                &nbsp;&nbsp;&nbsp;<input type="radio" name="gen_expn_rqst_tp_cd" value="EI" onclick="onChagneRqstTpCd()" class="trans">INI</td>
                            <%}%>
                            </tr>
                        </table> 
                    </td>
                    <td width="80">Request No.</td>
                    <td width="200"><input type="text" style="width:155;text-align: center;ime-mode:disabled" class="input" name="gen_expn_rqst_no" onKeyPress="ComKeyOnlyAlphabet('uppernum')">&nbsp;<img src="img/btns_search.gif" name="btns_popup" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
                    
                    <td width="230">
                        <table class="search_sm2" border="0" style="width:95%;"> 
                            <tr class="h23">
                                <td><input type="radio" name="ofc_expn_div" value="O" class="trans">Office&nbsp;&nbsp;<input type="radio" value="E" name="ofc_expn_div" class="trans">Expense&nbsp;&nbsp;&nbsp;<input type="text" style="width:70;text-align: center;ime-mode:disabled" class="input" name="ofc_expn_cd" maxlength="6" fullfill onKeyPress="ComKeyOnlyAlphabet('uppernum')"></td>
                            </tr>
                        </table> 
                    </td>
                    <td width="95">Expense Group</td>
                    <td width="110">
                    <script language="javascript">ComComboObject("combo1", 2, 70, 1, 0, 0, true);</script>
                    </td>
                    <td align="right">
                        <table class="search_sm2" border="0" style="width:120;"> 
                            <tr class="h23">
                                <td><input type="radio" name="lang_div" value="KOR" checked="checked" class="trans">KOR&nbsp;&nbsp;&nbsp;<input type="radio" name="lang_div" value="ENG" class="trans">ENG</td>
                            </tr>
                        </table> 
                    </td>
                </tr>
                </table>    
                <table class="height_2"><tr><td></td></tr></table>
                <table class="search" border="0" style="width:979;"> 
                <tr class="h23">                                
                    <td width="140"><input type="checkbox" value="" class="trans" checked disabled>BU&nbsp;&nbsp;<input type="checkbox" value="N" class="trans" name="sls_ofc_div_cd"  onclick="setHOHQ(this ,'document.form.ofc_lvl');isHoHqGubun('GEM_COMMONGS.do','SEARCHLIST01','sheet3','sls_ofc_div_cd','1','document.form.ofc_lvl');">HO&nbsp;&nbsp;<input type="checkbox" value="Y" class="trans" name="sls_ofc_div_cd" onclick="setHOHQ(this ,'document.form.ofc_lvl');isHoHqGubun('GEM_COMMONGS.do','SEARCHLIST01','sheet3','sls_ofc_div_cd','1','document.form.ofc_lvl');">HQ</td>
                    <td width="280" align="left"><select style="width:80;" class="input1" name="ofc_lvl1" onchange="selLevelChange('GEM_COMMONGS.do','SEARCHLIST01','sheet3','sls_ofc_div_cd','1','document.form.ofc_lvl');focusOut();">
                            </select>&nbsp;
                            <select style="width:80;" class="input1" name="ofc_lvl2" onmousedown="selLevelChange2('GEM_COMMONGS.do','SEARCHLIST02','sheet3','sls_ofc_div_cd','2','document.form.ofc_lvl');" onchange="selLevelChange('GEM_COMMONGS.do','SEARCHLIST02','sheet3','sls_ofc_div_cd','2','document.form.ofc_lvl');focusOut();">
                            </select>&nbsp;
                            <select style="width:80;" class="input1" name="ofc_lvl3" required caption="Office Code" onchange="onChangeOfcLvl3();focusOut();">
                            </select>&nbsp;</td>                        
                    <td width="25">TIC</td>
                    <td width="95">
                        <select style="width:75;" class="input" name="fm_tic_cd" onfocus="this.value=''" onchange="focusOut();">
                        </select></td>
                    <td width="">
                        <table class="search_sm2" border="0" style="width:100%;"> 
                            <tr class="h23">
                                <td width="55">Level</td>
                                <td class="stm">
                                <table cellspacing="0" cellpadding="3" border="0">
                                <tr>
                                    <td width="40"><input type="radio" name="crnt_gen_expn_apro_step_cd" value="" class="trans" checked="checked">All</td>
                                    <td width="70"><input type="radio" value="RQ" name="crnt_gen_expn_apro_step_cd" class="trans">RQST</td>
                                    <td width="90"><input type="radio" value="HQ" name="crnt_gen_expn_apro_step_cd" class="trans">RHQ|BU</td>
                                    <td width="60"><input type="radio" value="TC" name="crnt_gen_expn_apro_step_cd" class="trans" >TIC</td>
                                    <td width="70"><input type="radio" value="CO" name="crnt_gen_expn_apro_step_cd" class="trans">COM</td>
                                </tr>
                                </table>
                                </td>
                            </tr>
                        </table> 
                    </td>
                </tr>
                </table>    
                <table class="height_2"><tr><td></td></tr></table>
                <table class="search" border="0" style="width:979;"> 
                <tr class="h23">
                    <td width="250">
                        <table class="search_sm2" border="0" style="width:98%;"> 
                            <tr class="h23">
                                <td width="50">CUR</td>
                                <td class="stm">
                                <input type="radio" name="curr_cd" value="LCL" class="trans" checked>LCL&nbsp;&nbsp;<input type="radio" name="curr_cd" value="USD" class="trans">USD&nbsp;&nbsp;<input type="radio" name="curr_cd" value="KRW" class="trans">KRW
                                </td>
                            </tr>
                        </table> 
                    </td><td width="290">
                        <table class="search_sm2" border="0" style="width:270;"> 
                            <tr class="h23">
                                <td width="70">SUM UP</td>
                                <td class="stm"><input type="radio" name="sum_up" value="N" class="trans" checked>No&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="sum_up" value="O" class="trans">Office&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="sum_up" value="E" class="trans">Expense</td>
                            </tr>
                        </table> 
                    </td>
                    <td width="">
                        <table class="search_sm2" border="0" style="width:100%;"> 
                            <tr class="h23">
                                <td width="55">Status</td>
                                <td class="stm">                                
                                <table cellspacing="0" cellpadding="3" border="0">
                                <tr>
                                    <td width="40"><input type="radio" name="crnt_gen_expn_apsts_cd" value="" class="trans" checked="checked">All</td>
                                    <td width="70"><input type="radio" name="crnt_gen_expn_apsts_cd" value="RQ" class="trans">Request</td>
                                    <td width="90"><input type="radio" name="crnt_gen_expn_apsts_cd" value="AD" class="trans">Adjustment</td>
                                    <td width="60"><input type="radio" name="crnt_gen_expn_apsts_cd" value="RJ" class="trans">Reject</td>
                                    <td width="70"><input type="radio" name="crnt_gen_expn_apsts_cd" value="AP" class="trans">Approval</td>
                                </tr>
                                </table>
                                </td>
                            </tr>
                        </table> 
                    </td>
                </tr>
                </table>    
            
                <table class="height_5"><tr><td></td></tr></table>
                
                <!-- Grid  (S) -->
                <table width="100%" id="mainTable">
                    <tr>
                        <td width="100%">
                            <script language="javascript">ComSheetObject('sheet1');</script>
                        </td>
                    </tr>
                </table>
                <!-- Grid (E) -->
            
            <!--  Button_Sub (S) -->
                            <table width="100%" class="button"> 
                            <tr class="h23">
                                <td align="left" width="200">Performance Inquiry&nbsp;&nbsp;<img src="img/btns_search.gif" width="19" height="20" name="btns_perf_search" style="cursor: hand" alt="" border="0" align="absmiddle"></td>
                                <td align="left" width="200"><span id="sp_commit" style="display: none;"><input type="checkbox" class="trans" name="chk_commit" value="Y" checked="checked">Committee</span></td>
                            <td class="btn2_bg">
                                <table border="0" cellpadding="0" cellspacing="0"><tr>
                                    
                                    <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                        <tr><td class="btn2_left"></td>
                                        <td class="btn2" name="t3_btn2_Retrieve">Retrieve</td>
                                        <td class="btn2_right"></td>
                                        </tr>
                                        </table></td>
                                    <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                        <tr><td class="btn2_left"></td>
                                        <td class="btn2" name="t3_btn2_New">New</td>
                                        <td class="btn2_right"></td>
                                        </tr>
                                        </table></td>
                                    <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                        <tr><td class="btn2_left"></td>
                                        <td class="btn2" name="t3_btn2_Down_Excel">Down&nbsp;Excel</td>
                                        <td class="btn2_right"></td>
                                        </tr>
                                        </table></td>
                                </tr></table>
                            </td></tr>
                            </table>
                            <!-- Button_Sub (E) -->
            
            </form>
              
            <!-- =================================================== -->
            <!-- =======FORM 1================================= -->
            <!-- =======FORM 1******====================================== -->
            <!-- =======FORM 1*=========================================== -->
            <!-- =================================================== -->
              
            <!--  biz_1   (E) -->
            <form name="form1" method="post">
	        <input type="hidden" name="to_krn_abbr_nm">
	        <input type="hidden" name="to_eng_abbr_nm">
	        <input type="hidden" name="fm_krn_abbr_nm">
	        <input type="hidden" name="fm_eng_abbr_nm">  
            <a name="type1"></a>
            <div id="div_type1" style="overflow: visible;display: none;">
                <table class="line_bluedot"><tr><td colspan="6"></td></tr></table>            
                <!--  biz_2  (S) -->
                <table class="search" border="0" style="width:979;"> 
                <tr class="h23">
                    <td width="130">
                        <table class="search_sm2" border="0" style="width:98%;"> 
                            <tr class="h23">
                                <td><input type="radio" name="gen_expn_rqst_tp_cd" value="EI" class="trans" disabled="disabled">INI/ADD&nbsp;&nbsp;<input type="radio" name="gen_expn_rqst_tp_cd" value="EA" class="trans" disabled="disabled">TRS</td>
                            </tr>
                        </table> 
                    </td>
                    <td width="30">Year</td>
                    <td width="50"><input type="text" style="width:40;text-align:center;" name="pln_yr" readonly="readonly" class="input2" ></td>
                    <td width="30">Month</td>
                    <td width="40"><input type="text" style="width:30;text-align:center;" class="input2" name="pln_mon" readonly="readonly"></td>
                    <td width="75">Request No.</td>
                    <td width="200"><input type="text" style="width:155;text-align:center;" class="input2" readonly="readonly" name="gen_expn_rqst_no">&nbsp;<img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
                    <td width="70">Creator ID</td>
                    <td width="80"><input type="text" style="width:75;text-align:center;" class="input2" name="cre_usr_id"  readonly="readonly"></td>
                    <td width="50">USD TTL</td>
                    <td width=""><input type="text" style="width:100%;text-align:right;" class="input2" name="usd_ttl" readonly="readonly"></td>
                </tr>
                </table> 
                
                <table class="search" border="0" style="width:979;">
                    <tr class="h23"><td class="title_h"></td>
                        <td class="title_s">From</td>
                        <td align="right"><img src="img/btns_gae_1.gif" width="21" height="18" alt="" border="0"> You should request expense for <font style="text-decoration:underline;color:blue;"><span id="et_clz_yrmon">MAR 2009</span></font>  by  <font style="text-decoration:underline;color:blue;"><span id="et_clz_day">25</span><font style="color:blue; font-size:9px; vertical-align:middle;">th</font> <span id="et_clz_dt">FEB 2009</span> .</font></td>
                    </tr>
                </table>
                <table class="search" border="0" style="width:979;"> 
                <tr class="h23">
                    <td width="140"><input type="checkbox" value="" class="trans" checked disabled>BU&nbsp;&nbsp;<input type="checkbox" value="N" disabled class="trans" name="fm_sls_ofc_div_cd"  onclick="setHOHQ(this ,'document.form.fm_ofc_lvl');isHoHqGubun('GEM_COMMONGS.do','SEARCHLIST01','sheet3','fm_sls_ofc_div_cd','1','document.form.fm_ofc_lvl');">HO&nbsp;&nbsp;<input type="checkbox" value="Y" class="trans" disabled name="fm_sls_ofc_div_cd" onclick="setHOHQ(this ,'document.form.fm_ofc_lvl');isHoHqGubun('GEM_COMMONGS.do','SEARCHLIST01','sheet3','fm_sls_ofc_div_cd','1','document.form.fm_ofc_lvl');">HQ</td>
                    <td width="" align="left"><select style="width:80;" class="input2" name="fm_ofc_lvl1" disabled onchange="selLevelChange('GEM_COMMONGS.do','SEARCHLIST01','sheet3','fm_sls_ofc_div_cd','1','document.form.fm_ofc_lvl');focusOut();">
                            </select>&nbsp;
                            <select disabled style="width: 80;" class="input2" name="fm_ofc_lvl2" onchange="selLevelChange('GEM_COMMONGS.do','SEARCHLIST02','sheet3','fm_sls_ofc_div_cd','2','document.form.fm_ofc_lvl');focusOut();">
                            </select>&nbsp;
                            <select disabled style="width: 80;" class="input2" name="fm_ofc_lvl3" required caption="Fm Office Code" onchange="onChangeOfcLvl3('FM');focusOut();">
                            </select>&nbsp;</td>
                        <td align="right">Performance Inquiry&nbsp;&nbsp;<img src="img/btns_search.gif" name="btns_perf_search" width="19" height="20" alt="" border="0" align="absmiddle" style="cursor: hand"></td>
                </tr>
                </table>    
                
                <table class="search" border="0">
                    <tr class="h23">
                        <td width="230">Authorized Expense Code&nbsp;<img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle"></td>
                        <td width="80">FM Expense</td>
                        <td width="580"><input type="text" style="width:65;text-align:center;" class="input2" name="fm_gen_expn_cd" readonly="readonly">&nbsp;<input type="text" style="width:480;" class="input2" name="fm_gen_expn_cd_abbr_name" readonly="readonly"></td>
                        <td width="25">TIC</td>
                        <td><input type="text" name="fm_tic_cd" readonly="readonly" style="width:53;text-align:center;" class="input2" value="SELIPD"></td>
                    </tr>
                </table>
                <table class="search" border="0">
                    <tr class="h23">
                        <td width="230">Assigned Expense<input type="checkbox"  name="fm_chk_assigned" class="trans" value="Y" disabled="disabled"></td>
                        <td width="80">FM Item</td>
                        <td><input type="text" style="width:65;text-align:center;" name="fm_gen_expn_itm_no" class="input2" readonly="readonly">&nbsp;<input type="text"  name="fm_gen_expn_itm_desc" readonly="readonly" style="width:566;" class="input2">&nbsp;<img src="img/btns_note.gif" width="19" height="20" alt="" border="0" align="absmiddle" style="cursor: hand" onclick="showNote('A', 'A')"></td>
                    </tr>
                </table>
                
                <table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
                 
                <table class="search" border="0">
                    <tr><td class="title_h"></td>
                        <td width="80" class="title_s">To</td>
                        <td><input type="checkbox" value="Y" name="same_ofc_cd" disabled="disabled" class="trans">Same FM Office
&nbsp;&nbsp;<input type="checkbox"  value="Y" name="same_expn_cd" class="trans" disabled="disabled">Same Expense Code</td>
                    </tr>
                </table>
                
                <table class="search" border="0" style="width:979;"> 
                <tr class="h23">
                        <td width="85"></td>
                    <td width="140"><input type="checkbox" value="" class="trans" checked disabled>BU&nbsp;&nbsp;<input type="checkbox" value="N" class="trans" disabled="disabled" name="to_sls_ofc_div_cd"  onclick="setHOHQ(this ,'document.form.to_ofc_lvl');isHoHqGubun('GEM_COMMONGS.do','SEARCHLIST01','sheet3','to_sls_ofc_div_cd','1','document.form.to_ofc_lvl');">HO&nbsp;&nbsp;<input type="checkbox" value="Y" disabled="disabled" class="trans" name="to_sls_ofc_div_cd" onclick="setHOHQ(this ,'document.form.to_ofc_lvl');isHoHqGubun('GEM_COMMONGS.do','SEARCHLIST01','sheet3','to_sls_ofc_div_cd','1','document.form.to_ofc_lvl');">HQ</td>
                    <td width="" align="left"><select style="width:80;" class="input2" name="to_ofc_lvl1" disabled="disabled" onchange="selLevelChange('GEM_COMMONGS.do','SEARCHLIST01','sheet3','to_sls_ofc_div_cd','1','document.form.to_ofc_lvl');focusOut();">
                            </select>&nbsp;
                            <select style="width: 80;" class="input2" disabled="disabled" name="to_ofc_lvl2" onchange="selLevelChange('GEM_COMMONGS.do','SEARCHLIST02','sheet3','to_sls_ofc_div_cd','2','document.form.to_ofc_lvl');focusOut();">
                            </select>&nbsp;
                            <select style="width: 80;" class="input2" disabled="disabled" name="to_ofc_lvl3"  caption="To Office Code" onchange="onChangeOfcLvl3('TO');focusOut();">
                            </select>&nbsp;</td>
                </tr>
                </table>    
                
                <table class="search" border="0">
                    <tr class="h23">
                        <td width="230">Authorized Expense Code&nbsp;<img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" style="cursor: hand" name="t2btns_Authorized2"></td>
                        <td width="80">To Expense</td>
                        <td width="580"><input type="text" style="width:65;text-align:center;ime-mode:disabled" maxlength="6" readonly="readonly" caption="To Expense Code" name="to_gen_expn_cd" class="input2">&nbsp;<input type="text" name="to_gen_expn_cd_abbr_name" style="width:480;" class="input2" readonly="readonly"></td>
                        <td width="25">TIC</td>
                        <td><input type="text" name="to_tic_cd" style="width:53;text-align:center;" class="input2" readonly="readonly"></td>
                    </tr>
                </table>
                <table class="search" border="0">
                    <tr class="h23">
                        <td width="230">Assigned Expense<input type="checkbox" name="to_chk_assigned" class="trans" value="Y" disabled="disabled"></td>
                        <td width="80">To Item</td>
                        <td><input type="text" name="to_gen_expn_itm_no" caption="To Item" style="width:65;text-align:center;" class="input2" readonly="readonly">&nbsp;<input type="text" name="to_gen_expn_itm_desc" caption="To Item" readonly="readonly" style="width:565;" class="input2">&nbsp;<img src="img/btns_note.gif" width="19" height="20" alt="" border="0" align="absmiddle" style="cursor: hand" onclick="showNote('B','A')"></td>
                    </tr>
                </table>                
                
                <table class="search" border="0">
                    <tr class="h23">
                        <td width="124">Calculation Basis</td>
                        <td width="827"><textarea style="width:822;overflow: hidden;" rows="1" class="input2" caption="Calculation Basis" readonly="readonly" maxlength="1300" caption="Calculation Basis" name="to_gen_expn_calc_bss_desc"></textarea></td>
                        <td><img src="img/btns_note.gif" width="19" height="20" alt="" border="0" style="cursor: hand;"  align="absmiddle" onClick="showNote('C', 'B')"></td>
                    </tr>
                    <tr class="h23">
                        <td width="">Requester's Opinion</td>
                        <td width=""><textarea style="width:822;overflow: hidden;"  readonly="readonly" class="input2" rows="1" caption="Requester's Opinion" name="to_rqst_opin_rmk" maxlength="600"></textarea></td>
                        <td><img src="img/btns_note.gif" width="19" height="20" alt="" border="0" style="cursor: hand;"  align="absmiddle" onClick="showNote('D', 'C')"></td>
                    </tr>
                </table>

                
            <table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
                
                <table class="search" border="0">
                    <tr><td class="title_h"></td>
                        <td class="title_s">Calculation</td>
                    </tr>
                </table>
                
                
                
                <!-- ================================================================== -->
                <table class="search" border="0" style="width:979;">
                    <tr>
                        <td width="780" valign="top">
                            <table width="100%" class="grid2"> 
                                <tr class="tr2_head">                                            
                                    <td width="120" rowspan="2">&nbsp;</td>                                    
                                    <td width="370" colspan="4">From</td>                                    
                                    <td width="370" colspan="4">To</td>       
                                </tr>
                                <tr class="tr2_head2">                                       
                                    <td width="8%">Unit</td>                                            
                                    <td width="15%"><span id="fm_locl_curr_cd"></span></td>                            
                                    <td width="15%">1 USD</td>                     
                                    <td width="12%">Ex. Rate</td>                                    
                                    <td width="8%">Unit</td>                                             
                                    <td width="15%"><span id="to_locl_curr_cd"></span></td>                         
                                    <td width="15%">1 USD</td>                     
                                    <td width="12%">Ex. Rate</td>         
                                </tr>
                                <tr align="center">
                                    <td class="tr2_head2" nowrap width="120">RQST Amount</td>
                                    <td><input type="text" style="width:100%;text-align:right;" class="noinput" name="fm_ut_val" readonly="readonly"></td>
                                    <td class="input"><input type="text" style="width:100%;text-align:right;" class="noinput" name="fm_rq_amt" readonly="readonly"></td>
                                    <td><input type="text" style="width:100%;text-align:right;" class="noinput" name="fm_usd_amt" readonly="readonly"></td>
                                    <td><input type="text" style="width:100%;text-align:right;" class="noinput" name="fm_usd_locl_xch_rt" readonly="readonly"></td>
                                    <td><input type="text" style="width:100%;text-align:right;" class="noinput" name="to_ut_val" readonly="readonly"></td>
                                    <td><input type="text" style="width:100%;text-align:right;" class="noinput" name="to_rq_amt" readonly="readonly"></td>
                                    <td><input type="text" style="width:100%;text-align:right;" class="noinput" name="to_usd_amt" readonly="readonly"></td>
                                    <td><input type="text" style="width:100%;text-align:right;" class="noinput" name="to_usd_locl_xch_rt" readonly="readonly"></td>
                                </tr>
                                <tr align="center">
                                    <td class="tr2_head2">Adjustment</td>
                                    <td><input type="text" style="width:100%;text-align:right;" class="noinput" name="fm_ad_ut_val" readonly="readonly"></td>
                                    <td class="input"><input type="text" style="width:100%;text-align:right;" class="noinput1" required dataformat="int" name="fm_ad_amt"></td>
                                    <td><input type="text" style="width:100%;text-align:right;" class="noinput" name="fm_ad_usd_amt" readonly="readonly"></td>
                                    <td><input type="text" style="width:100%;text-align:right;" class="noinput" name="fm_ad_usd_locl_xch_rt" readonly="readonly"></td>
                                    <td><input type="text" style="width:100%;text-align:right;" class="noinput" name="to_ad_ut_val" readonly="readonly"></td>
                                    <td><input type="text" style="width:100%;text-align:right;" class="noinput" name="to_ad_amt" readonly="readonly"></td>
                                    <td><input type="text" style="width:100%;text-align:right;" class="noinput" name="to_ad_usd_amt" readonly="readonly"></td>
                                    <td><input type="text" style="width:100%;text-align:right;" class="noinput" name="to_ad_usd_locl_xch_rt" readonly="readonly"></td>
                                </tr>
                            </table> 
                        </td>
                        <td width="19"></td>
                        <td width="180" valign="top">
                            <table width="100%" class="grid2">
                                <tr class="tr2_head">
                                    <td width="30%" rowspan="2" colspan="2">Auto</td>
                                    <td width="%" colspan="2">Month</td>
                                </tr>
                                <tr class="tr2_head2">
                                    <td width="35%">Fm  </td>
                                    <td width="%">To    </td>
                                </tr>
                                <tr align="center">
                                    <td>FM</td>
                                    <td><input type="checkbox" value="Y" name="fm_assign_rule" class="trans" disabled="disabled"></td>
                                    <td><select style="width:100%;" class="input" name="fm_monthFrom" onchange="focusOut();">
                                        <option value="1" selected="selected">JAN</option>
                                        <option value="2">FEB</option>
                                        <option value="3">MAR</option>
                                        <option value="4">APR</option>
                                        <option value="5">MAY</option>
                                        <option value="6">JUN</option>
                                        <option value="7">JUL</option>
                                        <option value="8">AUG</option>
                                        <option value="9">SEP</option>
                                        <option value="10">OCT</option>
                                        <option value="11">NOV</option>
                                        <option value="12">DEC</option>
                        </select></td>
                                    <td><select style="width:100%;" class="input" name="fm_monthTo" onfocus="this.value=''" onchange="onChangeFmMonthTo();focusOut();">
                                        <option value=""></option>
                                        <option value="1">JAN</option>
                                        <option value="2">FEB</option>
                                        <option value="3">MAR</option>
                                        <option value="4">APR</option>
                                        <option value="5">MAY</option>
                                        <option value="6">JUN</option>
                                        <option value="7">JUL</option>
                                        <option value="8">AUG</option>
                                        <option value="9">SEP</option>
                                        <option value="10">OCT</option>
                                        <option value="11">NOV</option>
                                        <option value="12">DEC</option>
                        </select></td>
                                </tr>

                                <tr align="center">
                                    <td>To</td>
                                    <td><input type="checkbox" value="Y" name="to_assign_rule" class="trans"></td>
                                    <td><select style="width:100%;" class="input" name="to_monthFrom" onchange="focusOut();">
                                        <option value="1" selected="selected">JAN</option>
                                        <option value="2">FEB</option>
                                        <option value="3">MAR</option>
                                        <option value="4">APR</option>
                                        <option value="5">MAY</option>
                                        <option value="6">JUN</option>
                                        <option value="7">JUL</option>
                                        <option value="8">AUG</option>
                                        <option value="9">SEP</option>
                                        <option value="10">OCT</option>
                                        <option value="11">NOV</option>
                                        <option value="12">DEC</option>
                        </select></td>
                                    <td><select style="width:100%;" class="input" name="to_monthTo" onfocus="this.value=''" onchange="onChangeToMonthTo();focusOut();">
                                        <option value=""></option>
                                        <option value="1">JAN</option>
                                        <option value="2">FEB</option>
                                        <option value="3">MAR</option>
                                        <option value="4">APR</option>
                                        <option value="5">MAY</option>
                                        <option value="6">JUN</option>
                                        <option value="7">JUL</option>
                                        <option value="8">AUG</option>
                                        <option value="9">SEP</option>
                                        <option value="10">OCT</option>
                                        <option value="11">NOV</option>
                                        <option value="12">DEC</option>
                        </select></td>
                                </tr>
                            </table>
                        
                        </td>
                    </tr>
                </table>                
                                
                
                <!--  biz_2   (E) -->
        
        <table class="height_8"><tr><td></td></tr></table>
        
        <!-- Tab (S) -->
        <table class="tab" border="0" cellpadding="0" cellspacing="0">
        <tr><td><script language="javascript">ComTabObject('tab2','white','100%',27,false)</script></td></tr>
        </table>
        <!-- Tab (E) -->

        <!--TAB From (S) -->
        <div id="tabLayer_sub" style="display:none">
        
            <!-- Grid  (S) -->
            <table width="100%" id="mainTable">
                    <tr>
                        <td width="100%">
                            <script language="javascript">ComSheetObject('sheet2');</script>
                        </td>
                    </tr>
            </table>
        </div>

        <!--TAB To (S) -->
        <div id="tabLayer_sub" style="display:inline">
            <!-- Grid  (S) -->
            <table width="100%" id="mainTable">
                    <tr>
                        <td width="100%">
                            <script language="javascript">ComSheetObject('sheet3');</script>
                        </td>
                    </tr>
            </table>
            <!-- Grid (E) -->
        </div>
    <!--biz page (E)-->
    <table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
    </div>  
    </form>
    

<!-- ============================================================================= -->
<!-- ============================================================================= -->
<!-- ============================================================================= -->
                
    <form name="form2" method="post">  
        <input type="hidden" name="fm_krn_abbr_nm">
        <input type="hidden" name="fm_eng_abbr_nm"> 
        <input type="hidden" name="rqst_ofc_cd">
            <a name="type2"></a>
            <div id="div_type2" style="overflow: visible;display: none;">        
                <table class="line_bluedot"><tr><td colspan="6"></td></tr></table>            
                <!--  biz_2  (S) -->
                <table class="search" border="0" style="width:979;"> 
                <tr class="h23">
                    <td width="170">
                        <table class="search_sm2" border="0" style="width:98%;"> 
                            <tr class="h23">
                                <td><input type="radio" name="gen_expn_rqst_tp_cd" value="EI" class="trans" disabled="disabled">Initial&nbsp;&nbsp;<input type="radio" name="gen_expn_rqst_tp_cd" value="EA" class="trans" disabled="disabled">Additional</td>
                            </tr>
                        </table> 
                    </td>
                    <td width="30">Year</td>
                    <td width="50"><input type="text" style="width:40;text-align:center;" name="pln_yr" readonly="readonly" class="input2" ></td>
                    <td width="30">Month</td>
                    <td width="40"><input type="text" style="width:30;text-align:center;" class="input2" name="pln_mon" readonly="readonly"></td>
                    <td width="75">Request No.</td>
                    <td width="200"><input type="text" style="width:155;text-align:center;" class="input2" readonly="readonly" name="gen_expn_rqst_no">&nbsp;<img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
                    <td width="70">Creator ID</td>
                    <td width="80" align="left"><input type="text" style="width:75;text-align:center;" class="input2" name="cre_usr_id"  readonly="readonly"></td>
                    <td width="50">USD TTL</td>
                    <td width=""><input type="text" style="width:100%;text-align:right;" class="input2" name="usd_ttl" readonly="readonly"></td>
                </tr>
                </table> 
                
                <table class="search" border="0" style="width:979;">
                    <tr class="h23"><td class="title_h"></td>
                        <td class="title_s">Description</td>
                        <td align="right"><img src="img/btns_gae_1.gif" width="21" height="18" alt="" border="0"> You should request expense for <font style="text-decoration:underline;color:blue;"><span id="ei_clz_yrmon">MAR 2009</span></font>  by  <font style="text-decoration:underline;color:blue;"><span id="ei_clz_day">25</span><font style="color:blue; font-size:9px; vertical-align:middle;">th</font> <span id="ei_clz_dt">FEB 2009</span> .</font></td>
                    </tr>
                </table>
                <table class="search" border="0" style="width:979;"> 
                <tr class="h23">
                    <td width="140"><input type="checkbox" value="" class="trans" checked disabled>BU&nbsp;&nbsp;<input type="checkbox" value="N" disabled class="trans" name="fm_sls_ofc_div_cd"  onclick="setHOHQ(this ,'document.form.fm_ofc_lvl');isHoHqGubun('GEM_COMMONGS.do','SEARCHLIST01','sheet3','fm_sls_ofc_div_cd','1','document.form.fm_ofc_lvl');">HO&nbsp;&nbsp;<input type="checkbox" value="Y" class="trans" disabled name="fm_sls_ofc_div_cd" onclick="setHOHQ(this ,'document.form.fm_ofc_lvl');isHoHqGubun('GEM_COMMONGS.do','SEARCHLIST01','sheet3','fm_sls_ofc_div_cd','1','document.form.fm_ofc_lvl');">HQ</td>
                    <td width="" align="left"><select style="width:80;" class="input2" name="fm_ofc_lvl1" disabled onchange="selLevelChange('GEM_COMMONGS.do','SEARCHLIST01','sheet3','fm_sls_ofc_div_cd','1','document.form.fm_ofc_lvl');">
                            </select>&nbsp;
                            <select disabled style="width:80;" class="input2" name="fm_ofc_lvl2" onchange="selLevelChange('GEM_COMMONGS.do','SEARCHLIST02','sheet3','fm_sls_ofc_div_cd','2','document.form.fm_ofc_lvl');">
                            </select>&nbsp;
                            <select disabled style="width:80;" class="input2" name="fm_ofc_lvl3" required caption="Fm Office Code" onchange="onChangeOfcLvl3('FM')">
                            </select>&nbsp;</td>
                        <td align="right">Performance Inquiry&nbsp;&nbsp;<img src="img/btns_search.gif" name="btns_perf_search" style="cursor: hand" width="19" height="20" alt="" border="0" align="absmiddle"></td>
                </tr>
                </table>    
                
                <table class="search" border="0">
                    <tr class="h23">
                        <td width="230">Authorized Expense Code&nbsp;<img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle"></td>
                        <td width="90">Expense Code</td>
                        <td width="580"><input type="text" style="width:65;text-align:center;" class="input2" name="fm_gen_expn_cd" readonly="readonly">&nbsp;<input type="text" style="width:480;" class="input2" name="fm_gen_expn_cd_abbr_name" readonly="readonly"></td>
                        <td width="25">TIC</td>
                        <td><input type="text" name="fm_tic_cd" readonly="readonly" style="width:53;text-align:center;" class="input2" value="SELIPD"></td>
                    </tr>
                </table>
                <table class="search" border="0">
                    <tr class="h23">
                        <td width="230">Assigned Expense<input type="checkbox"  name="fm_chk_assigned" class="trans" value="Y" disabled="disabled"></td>
                        <td width="90">Request Item</td>
                        <td><input type="text" style="width:65;text-align:center;" name="fm_gen_expn_itm_no" class="input2" readonly="readonly">&nbsp;<input type="text"  name="fm_gen_expn_itm_desc" readonly="readonly" style="width:566;" class="input2">&nbsp;<img src="img/btns_note.gif" width="19" height="20" alt="" border="0" align="absmiddle" style="cursor: hand" onclick="showNote('E', 'A')"></td>
                    </tr>
                </table>
                
                <table class="search" border="0">
                    <tr class="h23">
                        <td width="124">Calculation Basis</td>
                        <td width="836"><textarea style="width:831;overflow: hidden;" rows="1" class="input2" caption="Calculation Basis" readonly="readonly" maxlength="1300" caption="Calculation Basis" name="fm_gen_expn_calc_bss_desc"></textarea></td>
                        <td><img src="img/btns_note.gif" width="19" height="20" alt="" border="0" style="cursor: hand;"  align="absmiddle" onClick="showNote('F', 'B')"></td>
                    </tr>
                    <tr class="h23">
                        <td width="">Requester's Opinion</td>
                        <td width=""><textarea style="width:831;overflow: hidden;" rows="1" class="input2" readonly="readonly" caption="Requester's Opinion" name="fm_rqst_opin_rmk" maxlength="600"></textarea></td>
                        <td><img src="img/btns_note.gif" width="19" height="20" alt="" border="0" style="cursor: hand;"  align="absmiddle" onClick="showNote('G', 'C' )"></td>
                    </tr>
                </table>
                                
            <table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
                
                <table class="search" border="0">
                    <tr><td class="title_h"></td>
                        <td class="title_s">Calculation</td>
                    </tr>
                </table>
                
                <table class="search" border="0">
                    <tr>
                        <td width="680" valign="top">
                            <table width="100%" class="grid2"> 
                                
                                <tr class="tr_head">                                         
                                    <td width="20%">    </td>                                            
                                    <td width="20%">UNIT</td>                            
                                    <td width="20%"><span id="ei_fm_locl_curr_cd"></span></td>                     
                                    <td width="20%">1 USD </td>                                    
                                    <td width="%">Ex. Rate</td>     
                                </tr>
                                <tr align="center">
                                    <td class="tr2_head2"> RQST Amount  </td>                                    
                                    <td><input type="text" style="width:100%;text-align:right;" class="noinput" name="fm_ut_val" readonly="readonly"></td>
                                    <td class="input"><input type="text" style="width:100%;text-align:right;" class="noinput" name="fm_rq_amt" readonly="readonly"></td>
                                    <td><input type="text" style="width:100%;text-align:right;" class="noinput" name="fm_usd_amt" readonly="readonly"></td>
                                    <td><input type="text" style="width:100%;text-align:right;" class="noinput" name="fm_usd_locl_xch_rt" readonly="readonly"></td>
                                </tr>
                                <tr align="center">
                                    <td class="tr2_head2">Adjustment</td>                                    
                                    <td><input type="text" style="width:100%;text-align:right;" class="noinput" name="fm_ad_ut_val" readonly="readonly"></td>
                                    <td class="input"><input type="text" style="width:100%;text-align:right;" class="noinput1" required dataformat="int" name="fm_ad_amt"></td>
                                    <td><input type="text" style="width:100%;text-align:right;" class="noinput" name="fm_ad_usd_amt" readonly="readonly"></td>
                                    <td><input type="text" style="width:100%;text-align:right;" class="noinput" name="fm_ad_usd_locl_xch_rt" readonly="readonly"></td>
                                </tr>
                            </table> 
                        </td>
                        <td width="19"></td>
                        <td width="280" valign="top">
                            <table width="100%" class="search_sm2"> 
                                <tr class="h23">                                         
                                    <td width="40%">Assignment Rule</td>                                         
                                    <td class="stm"><input type="radio" value="M" name="ei_fm_assign_rule" class="trans" checked>Manual&nbsp;&nbsp;&nbsp;<input type="radio" value="A" name="ei_fm_assign_rule" class="trans">Auto</td> 
                                </tr>
                            </table> 
                            <table width="100%" class="search"> 
                                <tr class="h23">                                         
                                    <td width="20%">&nbsp;Month</td>                                         
                                    <td width="40%" class="stm">FM&nbsp;<select style="width:80;" class="input" name="fm_monthFrom" onchange="focusOut();">
                                        <option value="1" selected="selected">JAN</option>
                                        <option value="2">FEB</option>
                                        <option value="3">MAR</option>
                                        <option value="4">APR</option>
                                        <option value="5">MAY</option>
                                        <option value="6">JUN</option>
                                        <option value="7">JUL</option>
                                        <option value="8">AUG</option>
                                        <option value="9">SEP</option>
                                        <option value="10">OCT</option>
                                        <option value="11">NOV</option>
                                        <option value="12">DEC</option>
                        </select></td>  
                                    <td class="stm">TO&nbsp;<select style="width:80;" class="input" name="fm_monthTo" onfocus="this.value=''" onchange="onChangeFmMonthTo2();focusOut();">
                                        <option value=""></option>
                                        <option value="1">JAN</option>
                                        <option value="2">FEB</option>
                                        <option value="3">MAR</option>
                                        <option value="4">APR</option>
                                        <option value="5">MAY</option>
                                        <option value="6">JUN</option>
                                        <option value="7">JUL</option>
                                        <option value="8">AUG</option>
                                        <option value="9">SEP</option>
                                        <option value="10">OCT</option>
                                        <option value="11">NOV</option>
                                        <option value="12">DEC</option>
                        </select></td>
                                </tr>
                            </table> 
                        </td>   
                            
                    </tr>
                </table>
                <!--  biz_2   (E) -->
        
        <table class="height_8"><tr><td></td></tr></table>
        
            <!-- Grid  (S) -->
            <table width="100%" id="mainTable">
                    <tr>
                        <td width="100%">
                            <script language="javascript">ComSheetObject('sheet4');</script>
                        </td>
                    </tr>
            </table>
            <!-- Grid (E) -->	    
	       </div>
	       </form>
 </td></tr>
     </table>

     

<!-- Grid BG Box  (S) -->
    <!--Button (S) -->
        <div id="div_type3" style="display: none;">
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
        <tr><td class="btn1_bg">
            <table border="0" cellpadding="0" cellspacing="0">
            <tr>
                <!-- 
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_Retrieve">Retrieve</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                 -->
                <td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_New">New</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                <td class="btn1_line"></td>
                <!--
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_Delete">Delete</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                -->
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_Save">Save</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                <td class="btn1_line"></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_Print">Print</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
            </tr>
            </table>
        </td></tr>
        </table>
        </div>
    <!--Button (E) -->
    <div style="display: none;"><script language="javascript">ComSheetObject('sheet5');</script></div>
<!-- 개발자 작업  끝 -->


<!-- RequestNo 검색 팝업  -->
<form name="form3" method="post">
    <input type="hidden" name="pln_yrmon">
    <input type="hidden" name="rqst_ofc_cd">
    <input type="hidden" name="gen_expn_rqst_tp_cd">    
    <input type="hidden" name="prg_id">
    <input type="hidden" name="auth_flg">
</form>

<!-- 노트 전송 검색 팝업  -->
<form name="form4" method="post">
    <input type="hidden" name="type">
    <input type="hidden" name="text">
    <input type="hidden" name="saveYn">
</form>


<!-- 레포트  팝업  -->
<form name="form5" method="post">
    <input type="hidden" name="rfn">
    <input type="hidden" name="mrd">
    <input type="hidden" name="title">
    <input type="hidden" name="rp">
    <input type="hidden" name="rv">
</form>


<% 
if ("Y".equals(popupYn)) {
%>
</td>
</tr>
</table> 
<%
}
%>

</body>
</html>