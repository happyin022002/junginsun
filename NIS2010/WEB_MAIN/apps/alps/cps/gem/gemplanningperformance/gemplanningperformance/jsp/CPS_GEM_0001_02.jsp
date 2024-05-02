<%  
    /* =========================================================
     *Copyright(c) 2009 CyberLogitec
     *@FileName : cps_gem_0001_02t.jsp
     *@FileTitle : [CPS_GEM-0001_02] Expense Request - Transfer
     *Open Issues :
     *Change history :
     *@LastModifyDate : 2009.04.21
     *@LastModifier : 진윤오
     *@LastVersion : 1.0
     * 2009.04.17 진윤오
     * 1.0 Creation
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
<%@page import="com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.event.CpsGem000102Event"%>
<%
    CpsGem000102Event event = null; //PDTO(Data Transfer Object including Parameters)
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
        
        event = (CpsGem000102Event) request.getAttribute("Event");
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


<html>
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
<input type="hidden" name="gen_expn_rqst_tp_cd" value="ET">
<input type="hidden" name="to_krn_abbr_nm">
<input type="hidden" name="to_eng_abbr_nm">
<input type="hidden" name="fm_krn_abbr_nm">
<input type="hidden" name="fm_eng_abbr_nm">
<input type="hidden" name="gen_expn_rqst_seq">
<input type="hidden" name="pre_to_gen_expn_itm_no">
<input type="hidden" name="pre_to_gen_expn_itm_desc">
<input type="hidden" name="pln_yrmon">
<input type="hidden" name="fm_gen_expn_rqst_seq">
<input type="hidden" name="to_gen_expn_rqst_seq">
<input type="hidden" name="fm_gen_expn_group_cd">
<input type="hidden" name="to_gen_expn_group_cd">
<input type="hidden" name="fm_rqst_opin_rmk">
<input type="hidden" name="fm_gen_expn_calc_bss_desc">
<input type="hidden" name="to_rqst_usd_amt">
<input type="hidden" name="rownum" value="2">
<input type="hidden" name="usr_ofc_cd">
<input type="hidden" name="usr_tic_cd">
<input type="hidden" name="usr_auth_tp_cd" value="<%=usrAuthTpCd%>">
<input type="hidden" name="curr_dt" value="<%=DateTime.getFormatDate(new Date(),"yyyyMMdd")%>">
<!-- 개발자 작업 -->

<table class="search">
<tr><td class="bg">

    <!--  biz_1  (S) -->
        <table class="search" border="0" style="width:979;">
        <tr class="h23">
            
            <td width="30">Year</td>
            <td width="50"><input type="text" style="width:40;text-align: center" class="input2" name="pln_yr" onblur="setFormToSheet1();" readonly="readonly" value="<%=DateTime.getYear()%>"></td>
            <td width="30">Month</td>
            <td width="40"><input type="text" style="width:30;text-align: center" class="input2" name="pln_mon" readonly="readonly" value="<%=DateTime.getFormatDate(new Date(), "MM")%>"></td>
            <td width="78">Request No.</td>
            <td width="190"><input type="text" style="width:155;ime-mode:disabled;text-align: center;" class="input1" name="gen_expn_rqst_no" caption="Request No."  maxlength="20" onKeyPress="ComKeyOnlyAlphabet('uppernum')">&nbsp;<img src="img/btns_search.gif" name="btns_popup" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
            
            <td width="70 ">Creator ID</td>
            <td width="110"><input type="text" name="cre_usr_id" style="width:100;text-align:center" readonly="readonly" class="input2" value="<%=strUsr_id%>"></td>
            <td width="50">USD TTL</td>
            <td width=""><input type="text" style="width:160;text-align:right;" class="input2" name="usd_ttl" readonly="readonly"></td>
            <td align="right">
                <table class="search_sm2" border="0" style="width:120;">
                    <tr class="h23">
                        <td><input type="radio" value="KOR"  checked name="lang_div" class="trans">KOR&nbsp;&nbsp;&nbsp;<input type="radio" value="ENG" name="lang_div" class="trans">ENG</td>
                    </tr>
                </table>
            </td>
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
                                <td class="btn2" name="t2btn_RowAdd">Row&nbsp;Add</td>
                                <td class="btn2_right"></td>
                                </tr>
                                </table></td>
                            <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                <tr><td class="btn2_left"></td>
                                <td class="btn2" name="t2btn_Delete">Row&nbsp;Delete</td>
                                <td class="btn2_right"></td>
                                </tr>
                                </table></td>
                        </tr></table>
                    </td></tr>
                    </table>
                    <!-- Button_Sub (E) -->

                <table class="line_bluedot"><tr><td colspan="6"></td></tr></table>

                <table class="search" border="0">
                    <tr class="h23"><td class="title_h"></td>
                        <td class="title_s">From</td>
                        <td align="right"><img src="img/btns_gem_1.gif" width="21" height="18" alt="" border="0"> You should request expense for <font style="text-decoration:underline;color:blue;"><span id="clz_yrmon">MAR 2009</span></font>  by  <font style="text-decoration:underline;color:blue;"><span id="clz_day">25</span><font style="color:blue; font-size:9px; vertical-align:middle;">th</font> <span id="clz_dt">FEB 2009</span> .</font></td>     
                    </tr>
                </table>

                <table class="search" border="0" style="width:979;">
                <tr class="h23">
                    <td width="140"><input type="checkbox" value="" class="trans" checked disabled>BU&nbsp;&nbsp;<input type="checkbox" value="N" class="trans" name="fm_sls_ofc_div_cd"  onclick="setHOHQ(this ,'document.form.fm_ofc_lvl');isHoHqGubun('GEM_COMMONGS.do','SEARCHLIST01','sheet3','fm_sls_ofc_div_cd','1','document.form.fm_ofc_lvl');initFromItem();initToItem();">HO&nbsp;&nbsp;<input type="checkbox" value="Y" class="trans" name="fm_sls_ofc_div_cd" onclick="setHOHQ(this ,'document.form.fm_ofc_lvl');isHoHqGubun('GEM_COMMONGS.do','SEARCHLIST01','sheet3','fm_sls_ofc_div_cd','1','document.form.fm_ofc_lvl');initFromItem();initToItem();focusOut();">HQ</td>
                    <td width="" align="left"><select style="width:80;" class="input1" name="fm_ofc_lvl1" onchange="selLevelChange('GEM_COMMONGS.do','SEARCHLIST01','sheet3','fm_sls_ofc_div_cd','1','document.form.fm_ofc_lvl');initFromExpnItem();initToItem();focusOut();">
                            </select>&nbsp;
                            <select style="width: 80;" class="input1" name="fm_ofc_lvl2" onmousedown="selLevelChange2('GEM_COMMONGS.do','SEARCHLIST02','sheet3','fm_sls_ofc_div_cd','2','document.form.fm_ofc_lvl');" onchange="selLevelChange('GEM_COMMONGS.do','SEARCHLIST02','sheet3','fm_sls_ofc_div_cd','2','document.form.fm_ofc_lvl');initFromExpnItem();initToItem();focusOut();">
                            </select>&nbsp;
                            <select style="width: 80;" class="input1" name="fm_ofc_lvl3" required caption="Fm Office Code" onchange="initFromExpnItem();initToItem();onChangeOfcLvl3('FM');focusOut();">
                            </select>&nbsp;
                    </td>
                </tr>
                </table>

                <table class="search" border="0">
                    <tr class="h23">
                        <td width="230"><span id="fm_auth_expn_code">Authorized Expense Code</span>&nbsp;<img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" style="cursor: hand" name="t2btns_Authorized1"></td>
                        <td width="80">FM Expense</td>
                        <td width="580"><input type="text" style="width:65;text-align:center;ime-mode:disabled" maxlength="6" fullfill required caption="Fm Expense Code" name="fm_gen_expn_cd" class="input1" onchange="checkExpnInfo('FM');">&nbsp;<input type="text" name="fm_gen_expn_cd_abbr_name" style="width:480;" class="input2" readonly="readonly"></td>
                        <td width="25">TIC</td>
                        <td><input type="text" name="fm_tic_cd" style="width:53;text-align:center;" class="input2" readonly="readonly"></td>
                    </tr>
                </table>
                <table class="search" border="0">
                    <tr class="h23">
                        <td width="230">Assigned Expense<input type="checkbox" name="fm_chk_assigned" class="trans" value="Y" disabled="disabled"></td>
                        <td width="80">FM Item</td>
                        <td><input type="text" name="fm_gen_expn_itm_no" style="width:65;text-align:center;" caption="FM Item" required class="input2" readonly="readonly">&nbsp;<input type="text" name="fm_gen_expn_itm_desc" style="width:565;" class="input2" readonly="readonly">&nbsp;<img src="img/btns_note.gif" width="19" height="20" alt="" border="0" align="absmiddle" style="cursor: hand" onclick="showNote(this,'D')"></td>
                    </tr>
                </table>

                <table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
                <table class="search" border="0">
                    <tr><td class="title_h"></td>
                        <td class="title_s">To</td>
                    </tr>
                </table>
                <table class="search" border="0" style="width:979;">
                <tr class="h23">
                    <td><input type="checkbox" value="Y" name="same_ofc_cd" class="trans">Same FM Office
&nbsp;&nbsp;<input type="checkbox" value="Y" name="same_expn_cd" class="trans">Same Expense Code</td>
                </tr>
                </table>
                <table class="search" border="0" style="width:979;">
                <tr class="h23">
                    <td width="140"><input type="checkbox" value="" class="trans" checked disabled>BU&nbsp;&nbsp;<input type="checkbox" value="N" class="trans" name="to_sls_ofc_div_cd"  onclick="setHOHQ(this ,'document.form.to_ofc_lvl');onClickToSlsOfcDivCd();">HO&nbsp;&nbsp;<input type="checkbox" value="Y" class="trans" name="to_sls_ofc_div_cd" onclick="setHOHQ(this ,'document.form.to_ofc_lvl');onClickToSlsOfcDivCd();initToExpnItem();">HQ</td>
                    <td width="" align="left"><select style="width:80;" class="input1" name="to_ofc_lvl1" onchange="onChangeToOfcLvl1();initToExpnItem();focusOut();">
                            </select>&nbsp;
                            <select style="width: 80;" class="input1" name="to_ofc_lvl2" onfocus="onMouseDownToOfcLvl2();" onchange="onChangeToOfcLvl2();initToExpnItem();focusOut();">
                            </select>&nbsp;
                            <select style="width: 80;" class="input1" name="to_ofc_lvl3" required caption="To Office Code" onchange="onChangeOfcLvl3('TO');initToExpnItem();focusOut();">
                            </select>&nbsp;
                    </td>
                </tr>
                </table>

                <table class="search" border="0">
                    <tr class="h23">
                        <td width="230">Authorized Expense Code&nbsp;<img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" style="cursor: hand" name="t2btns_Authorized2"></td>
                        <td width="80">To Expense</td>
                        <td width="580"><input type="text" style="width:65;text-align:center;ime-mode:disabled" maxlength="6" fullfill required caption="To Expense Code" name="to_gen_expn_cd" class="input1" onchange="checkExpnInfo('TO')">&nbsp;<input type="text" name="to_gen_expn_cd_abbr_name" style="width:480;" class="input2" readonly="readonly"></td>
                        <td width="25">TIC</td>
                        <td><input type="text" name="to_tic_cd" style="width:53;text-align:center;" class="input2" readonly="readonly"></td>
                    </tr>
                </table>
                <table class="search" border="0">
                    <tr class="h23">
                        <td width="230">Assigned Expense<input type="checkbox" name="to_chk_assigned" class="trans" value="Y"></td>
                        <td width="80">To Item</td>
                        <td><input type="text" name="to_gen_expn_itm_no" required caption="To Item" style="width:65;text-align:center;" class="input2" readonly="readonly">&nbsp;<input type="text" name="to_gen_expn_itm_desc" required caption="To Item" style="width:567;" class="input1" onblur="setFormToSheet1();">&nbsp;<img src="img/btns_note.gif" width="19" height="20" alt="" border="0" align="absmiddle" style="cursor: hand" onclick="showNote(this,'A')"></td>
                    </tr>
                </table>                
                
                <table class="search" border="0">
                    <tr class="h23">
                        <td width="124">Calculation Basis</td>
                        <td width="827"><textarea style="width:822;overflow: hidden;" onblur="setFormToSheet1();" rows="1" class="input1" caption="Calculation Basis" required maxlength="1300" caption="Calculation Basis" name="to_gen_expn_calc_bss_desc"></textarea></td>
                        <td><img src="img/btns_note.gif" width="19" height="20" alt="" border="0" style="cursor: hand;"  align="absmiddle" onClick="showNote(this, 'B')"></td>
                    </tr>
                    <tr class="h23">
                        <td width="">Requester's Opinion</td>
                        <td width=""><textarea style="width:822;overflow: hidden;background-color: white;" rows="1" class="input1" caption="Requester's Opinion" name="to_rqst_opin_rmk" maxlength="600" onblur="setFormToSheet1();"></textarea></td>
                        <td><img src="img/btns_note.gif" width="19" height="20" alt="" border="0" style="cursor: hand;"  align="absmiddle" onClick="showNote(this, 'C')"></td>
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
                                <tr class="tr2_head">
                                    <td width="15%" nowrap rowspan="2"></td>
                                    <td width="30%" colspan="3">From</td>
                                    <td width="30%" colspan="3">To</td>
                                    <td width="%"></td>
                                </tr>
                                <tr class="tr2_head2">
                                    <td width="8%">Unit </td>
                                    <td width="18%"><img src="img/ico_star.gif" width="13" height="9" alt="" border="0" align="absmiddle"><span id="fm_locl_curr_cd"></span></td>
                                    <td width="8%">Ex. Rate  </td>
                                    <td width="8%">Unit</td>
                                    <td width="18%"><span id="to_locl_curr_cd"></span></td>
                                    <td width="8%">Ex. Rate  </td>
                                    <td width="%">1 USD</td>
                                </tr>
                                <tr align="center">
                                    <td class="tr2_head2">RQST Amount</td>
                                    <td><input type="text" name="fm_rqst_ut_val" style="width:100%;text-align:center;" class="noinput" readonly="readonly"></td>
                                    <td class="input1">
                                    <input type="text" style="width:100%;text-align:right;" class="noinput1" dataformat="int" caption="RQST Amount" required maxlength="11" name="fm_rqst_locl_amt">
                                    </td>
                                    <td><input type="text" name="fm_usd_locl_xch_rt" style="width:100%;text-align:right;" class="noinput" readonly="readonly"></td>
                                    <td><input type="text" name="to_rqst_ut_val" style="width:100%;text-align:center;" class="noinput" readonly="readonly"></td>
                                    <td><input type="text" name="to_rqst_locl_amt" style="width:100%;text-align:right;" class="noinput" readonly="readonly"></td>
                                    <td class="input"><input type="text" name="to_usd_locl_xch_rt" style="width:100%;text-align:right;" class="noinput" readonly="readonly"></td>
                                    <td><input type="text" name="fm_rqst_usd_amt" style="width:100%;text-align:right;" class="noinput" readonly="readonly"></td>
                                </tr>
                            </table>
                        </td>
                        <td width="19"></td>
                        <td width="280" valign="top">
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

                <table class="height_2"><tr><td></td></tr></table>
                <!-- Grid  (S) -->
        <table width="100%" id="mainTable">
            <tr>
                <td width="100%">
                    <script language="javascript">ComSheetObject('sheet2');</script>
                </td>
            </tr>
        </table>
                    <!-- Grid (E) -->
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