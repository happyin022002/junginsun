<%/*=========================================================
     *Copyright(c) 2009 CyberLogitec
     *@FileName : cps_gem_0001_01t.jsp
     *@FileTitle : [CPS_GEM-0001_01] Expense Request – Initial & Additional
     *Open Issues :
     *Change history :
     *@LastModifyDate : 2009.04.21
     *@LastModifier : 진윤오
     *@LastVersion : 1.0
     * 2009.04.17 진윤오
     * 1.0 Creation
     =========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@page import="com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.event.CpsGem000101Event"%>
<%
    CpsGem000101Event event = null; //PDTO(Data Transfer Object including Parameters)
    Exception serverException = null; //서버에서 발생한 에러
    String strErrMsg = ""; //에러메세지
    int rowCount = 0; //DB ResultSet 리스트의 건수

    String successFlag = "";
    String codeList = "";
    String pageRows = "100";

    String strUsr_id = "";
    String strUsr_nm = "";
    String usrOfcCd = "";
    String usrAuthTpCd = "";
    Logger log = Logger.getLogger("com.hanjin.apps.GEMCommon.GEMMasterCodeMgt");

    try
    {
        SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        
        usrAuthTpCd = account.getUsr_auth_tp_cd();
        event = (CpsGem000101Event) request.getAttribute("Event");
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
%>




<%@page import="java.util.Date"%><html>
<head>
<title>Expense Request – Initial & Additional</title>
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
<form name="form" method="post">
<input type="hidden" name="f_cmd"> 
<input type="hidden" name="pagerows">
<input type="hidden" name="auth_flg">  
<input type="hidden" name="req_upd_dt">
<input type="hidden" name="itm_upd_dt">
<input type="hidden" name="eng_abbr_nm">
<input type="hidden" name="krn_abbr_nm">
<input type="hidden" name="ofc_cd">
<input type="hidden" name="pre_gen_expn_itm_no">
<input type="hidden" name="pre_gen_expn_itm_desc">
<input type="hidden" name="pln_yrmon">
<input type="hidden" name="usr_ofc_cd">
<input type="hidden" name="usr_auth_tp_cd" value="<%=usrAuthTpCd%>">
<input type="hidden" name="usr_tic_cd">
<input type="hidden" name="rownum" value="1">
<input type="hidden" name="curr_dt" value="<%=DateTime.getFormatDate(new Date(),"yyyyMMdd")%>">
<input type="hidden" name="gw_subject">
<input type="hidden" name="gw_contents"> 
<input type="hidden" name="gw_args" value="email;">
<!-- 개발자 작업 -->
<style type="text/css">
.span_title1 {color: #FF4E00;font-size: 15px;font-weight: bold;}
.span_title2 {color: #000000;font-size: 12px;font-weight: bold;}
</style>

<table class="search">
<tr><td class="bg">

    <!--  biz_1  (S) -->
        <table class="search" border="0" style="width:979;">
        <tr class="h23">
            <td width="190">
                <table class="search_sm2"  border="0" style="width:95%;">
                    <tr class="h23">
                        <td><input type="radio" name="gen_expn_rqst_tp_cd" value="EI" class="trans" disabled="disabled" onclick="onChagneRqstTpCd();this.blur();"><span id="init_color">Initial</span>&nbsp;&nbsp;&nbsp;<input type="radio" name="gen_expn_rqst_tp_cd" value="EA" class="trans" disabled="disabled" checked="checked"  onclick="onChagneRqstTpCd();this.blur();"><span id="add_color" class="span_title1">Additional</span></td>
                    </tr>
                </table>
            </td>
            <td width="30">Year</td>
            <td width="60"><input type="text" style="width:40;text-align: center" class="input2" name="pln_yr" readonly="readonly" value="<%=DateTime.getYear()%>"></td>
            <td width="30">Month</td>
            <td width="50"><input type="text" style="width:30;text-align: center" class="input2" name="pln_mon" readonly="readonly" value="<%=DateTime.getFormatDate(new Date(), "MM")%>"></td>
            <td width="85" nowrap>Request No.</td>
            <td width="190"><input type="text" style="width:163;ime-mode:disabled;text-align: center;" class="input1" name="gen_expn_rqst_no" caption="Request No."  maxlength="20" onKeyPress="ComKeyOnlyAlphabet('uppernum')">&nbsp;<img src="img/btns_search.gif" name="btns_popup" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
            <td width="50"><input type="text" style="width:60;" class="input2" value=" USD TTL"  readonly="readonly"></td>
            <td width="160"><input type="text" style="width:150;text-align:right;" class="input2" name="usd_ttl" readonly="readonly"></td>
            <td align="right">
                <table class="search_sm2" border="0" style="width:120;">
                    <tr class="h23">
                        <td><input type="radio" value="KOR" name="lang_div" class="trans" checked>KOR&nbsp;&nbsp;&nbsp;<input type="radio" value="ENG" name="lang_div" class="trans">ENG</td>
                    </tr>
                </table>
            </td>
        
        </tr>
        </table>
        <table class="search" border="0" style="width:979;">
        <tr class="h23">
            <td width="140"><input type="checkbox" value="" class="trans" checked disabled>BU&nbsp;&nbsp;<input type="checkbox" value="N" class="trans" name="sls_ofc_div_cd"  onclick="setHOHQ(this ,'document.form.ofc_lvl');isHoHqGubun('GEM_COMMONGS.do','SEARCHLIST01','sheet3','sls_ofc_div_cd','1','document.form.ofc_lvl');">HO&nbsp;&nbsp;<input type="checkbox" value="Y" class="trans" name="sls_ofc_div_cd" onclick="setHOHQ(this ,'document.form.ofc_lvl');isHoHqGubun('GEM_COMMONGS.do','SEARCHLIST01','sheet3','sls_ofc_div_cd','1','document.form.ofc_lvl');">HQ</td>
            <td width="270" align="left"><select style="width:80;" class="input1" name="ofc_lvl1" onchange="selLevelChange('GEM_COMMONGS.do','SEARCHLIST01','sheet3','sls_ofc_div_cd','1','document.form.ofc_lvl');">
                            </select>&nbsp;
                            <select style="width: 80;" class="input1" name="ofc_lvl2" onmousedown="selLevelChange2('GEM_COMMONGS.do','SEARCHLIST02','sheet3','sls_ofc_div_cd','2','document.form.ofc_lvl');" onchange="selLevelChange('GEM_COMMONGS.do','SEARCHLIST02','sheet3','sls_ofc_div_cd','2','document.form.ofc_lvl');">
                            </select>&nbsp;
                            <select style="width: 80;" class="input1" name="ofc_lvl3" required caption="Office Code"  onchange="onChangeOfcLvl3();focusOut();">
                            </select>&nbsp;</td>
            <td width="%" align="left"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">                    <tr><td class="btn2_left"></td>
                                <td class="btn2" name="t1btn_Authorized" id="btn_authorized">Authorized Expense Code</td>
                                <td class="btn2_right"></td>
                                </tr>
                                </table></td>
            <td width="385" nowrap align="right" style="font-size: 11px"><img src="img/btns_gem_1.gif" width="21" height="18" alt="" border="0"> You should request expense for <font style="text-decoration:underline;color:blue;"><span id="clz_yrmon">MAR 2009</span></font>  by  <font style="text-decoration:underline;color:blue;"><span id="clz_day">25</span><font style="color:blue; font-size:9px; vertical-align:middle;">th</font> <span id="clz_dt">FEB 2009</span> .</font></td>
        </tr>
        </table>


        <table class="line_bluedot"><tr><td colspan="6"></td></tr></table>


        <table class="search" border="0" style="width:979;">
            <tr class="h23">
                <td width="200" valign="top">

                    <table class="search" border="0">
                        <tr><td class="title_h"></td>
                            <td class="title_s">Inputting Expense Code</td>
                        </tr>
                    </table>
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
                    <tr><td class="btn2_bg">
                        <table border="0" cellpadding="0" cellspacing="0"><tr>
                            <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                <tr><td class="btn2_left"></td>
                                <td class="btn2" name="t1btn_RowAdd">Row&nbsp;Add</td>
                                <td class="btn2_right"></td>
                                </tr>
                                </table></td>
                            <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                <tr><td class="btn2_left"></td>
                                <td class="btn2" name="t1btn_Delete">Row&nbsp;Delete</td>
                                <td class="btn2_right"></td>
                                </tr>
                                </table></td>
                        </tr></table>
                    </td></tr>
                    </table>
                    <!-- Button_Sub (E) -->
                   

                </td>
                <td width="19">&nbsp;</td>
                <td width="760" valign="top">
                    <table style="height:40"><tr><td></td></tr></table>
                    <table class="search" border="0">
                        <tr><td class="title_h"></td>
                            <td class="title_s">Description</td>
                        </tr>
                    </table>
                    <table class="search" border="0">
                        <tr class="h23">
                            <td width="160">Assigned Expense<input type="checkbox" value="Y" name="chk_assigned" class="trans"></td>
                            <td width="100">Expense Code</td>
                            <td><input type="text" style="width:90;text-align:center;" class="input2" name="gen_expn_cd" readonly="readonly">&nbsp;<input type="text" style="width:430;"  class="input2" name="gen_expn_cd_abbr_name" readonly="readonly"></td>
                        </tr>
                    </table>
                    <table class="search" border="0">
                        <tr class="h23">
                            <td width="90">Request Item</td>
                            <td width="590"><input type="text" style="width:30;text-align:center;" name="gen_expn_itm_no" class="input2" readonly="readonly">&nbsp;<textarea style="width:520;overflow: hidden;" class="input1" rows="1" required maxlength="500" caption="Request Item" name="gen_expn_itm_desc"  readonly="readonly"></textarea>&nbsp;<img src="img/btns_note.gif" width="19" height="20" alt="" border="0" style="cursor: hand;"  align="absmiddle" onClick="showNote(this,'A')"></td>
                            <td width="25">TIC</td>
                            <td><input type="text" style="width:53;text-align:center" class="input2" name="tic_cd" readonly="readonly"></td>
                        </tr>
                    </table>
                    <table class="search" border="0">
                        <tr class="h23">
                            <td width="124">Calculation Basis</td>
                            <td width="611"><textarea style="width:610;overflow: hidden;" rows="1" class="input1" caption="Calculation Basis" required maxlength="1300" caption="Calculation Basis" name="gen_expn_calc_bss_desc"  readonly="readonly"></textarea></td>
                            <td align="right"><img src="img/btns_note.gif" width="19" height="20" alt="" border="0" style="cursor: hand;"  align="absmiddle" onClick="showNote(this, 'B')"></td>
                        </tr>
                        <tr class="h23">
                            <td width="">Requester's Opinion</td>
                            <td width=""><textarea style="width:610;overflow: hidden;background-color: white;" rows="1" class="input1" caption="Requester's Opinion" name="rqst_opin_rmk" maxlength="600"  readonly="readonly"></textarea></td>
                            <td align="right"><img src="img/btns_note.gif" width="19" height="20" alt="" border="0" style="cursor: hand;" align="absmiddle" onClick="showNote(this, 'C')"></td>
                        </tr>
                    </table>
                    
                    <table style="height:10"><tr><td></td></tr></table>
                    <table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
                    <table style="height:10"><tr><td></td></tr></table>

                    <table class="search" border="0">
                        <tr><td class="title_h"></td>
                            <td class="title_s">Calculation</td>
                        </tr>
                    </table>
                    <table class="search" border="0">
                        <tr class="h23">
                            <td width="430" valign="top">
                                <table width="100%" class="grid2">
                                <tr class="tr2_head">
                                    <td width="22%"></td>
                                    <td width="12%">Unit</td>
                                    <td width="25%"><img src="img/ico_star.gif" width="13" height="9" alt="" border="0" align="absmiddle"> <span id="locl_curr_cd"></span> </td>
                                    <td width="25%">1 USD </td>
                                    <td width="%">Ex. Rate</td>
                                </tr>
                                <tr align="center">
                                    <td class="tr2_head">RQST Amount</td>
                                    <td><input type="text" style="width:100%;text-align:right;" class="noinput" readonly="readonly" name="rqst_ut_val"></td>
                                    <td class="input1"><input type="text" style="width:100%;text-align:right;" class="noinput1" dataformat="int" caption="RQST Amount" required maxlength="11" name="rqst_locl_amt"  readonly="readonly"></td>
                                    <td><input type="text" style="width:100%;text-align:right;" class="noinput" name="rqst_usd_amt" readonly="readonly"></td>
                                    <td><input type="text" style="width:100%;text-align:right;" class="noinput" name="usd_locl_xch_rt" readonly="readonly"></td>
                                </tr>
                                </table>

                            </td>
                            <td width="30"></td>
                            <td width="330" valign="top">
                                <table width="100%" class="grid2">
                                <tr class="h23">
                                    <td width="35%" class="tr2_head_l">Assignment Rule</td>
                                    <td width="%" class="stm"><input type="radio" value="M" name="assign_rule" class="trans" checked>Manual&nbsp;&nbsp;&nbsp;<input type="radio" name="assign_rule" value="A" class="trans">Auto</td>
                                </tr>
                                <tr class="h23">
                                    <td class="tr2_head_l">&nbsp;MONTH</td>
                                    <td width="%" class="stm">FM&nbsp;<select style="width:70;" class="input" name="monthFrom" onchange="focusOut();">
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
                </select>&nbsp;&nbsp;&nbsp;&nbsp;TO&nbsp;<select style="width:70;" class="input" name="monthTo" onfocus="this.value=''" onchange="onChangeMonthTo();focusOut();">
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
                    
                    <table style="height:3"><tr><td></td></tr></table>
                <!-- Grid  (S) -->
                    <div style="overflow: visible;z-index: -1">
                    <table width="100%" id="mainTable">
                        <tr>
                            <td width="100%">
                                <script language="javascript">ComSheetObject('sheet2');</script>
                            </td>
                        </tr>
                    </table>
                    </div>
                    <!-- Grid (E) -->
                    
                    <!--  Button_Sub (S) -->
                    <table width="100%" class="button">
                    <tr>
                    <td class="btn2_bg" width="200">
                        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                <tr><td class="btn2_left"></td>
                                <td class="btn2" name="t1btn_Request">Request for Expense Code</td>
                                <td class="btn2_right"></td>
                                </tr>
                         </table>
                    </td>
                    <td class="btn2_bg" nowap>&nbsp;</td>
                    <td class="btn2_bg" width="80" style="font-weight: bold">Creator ID&nbsp;</td>
                    <td class="btn2_bg" width="80"><input type="text" name="cre_usr_id" style="width:80;text-align:center" readonly="readonly" class="input2" value="<%=strUsr_id%>"></td>
                    </tr>
                    </table>
                    <!-- Button_Sub (E) -->                    
                    
                </td>
            </tr>
        </table>
    <!--  biz_1   (E) -->
    </td></tr>
</table>
<!-- Grid BG Box  (S) -->
    <!--Button (S) -->
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
        <tr><td class="btn1_bg">
            <table border="0" cellpadding="0" cellspacing="0">
            <tr>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_Retrieve">Retrieve</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                <td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_New">New</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                <td class="btn1_line"></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_Delete">Delete</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>

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
    <!--Button (E) -->
    <div style="display: none;"><script language="javascript">ComSheetObject('sheet3');</script></div>
<!-- 개발자 작업  끝 -->
</form>

<div id="note" style="display: none;background-color: white;width: 600px; height: 320px; overflow: visible">
</div>

<!-- RequestNo 검색 팝업  -->
<form name="form1" method="post">
    <input type="hidden" name="pln_yrmon">
    <input type="hidden" name="rqst_ofc_cd">
    <input type="hidden" name="gen_expn_rqst_tp_cd">    
    <input type="hidden" name="auth_flg">
</form>
<!-- 노트 전송 검색 팝업  -->
<form name="form2" method="post">
    <input type="hidden" name="type">
    <input type="hidden" name="text">
    <input type="hidden" name="saveYn">
</form>


<!-- 레포트  팝업  -->
<form name="form3" method="post">
    <input type="hidden" name="rfn">
    <input type="hidden" name="mrd">
    <input type="hidden" name="title">
    <input type="hidden" name="rp">
    <input type="hidden" name="rv">
</form>



</body>
</html>