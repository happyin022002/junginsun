<%/*=========================================================
     *Copyright(c) 2009 CyberLogitec
     *@FileName : cps_gem_0002.jsp
     *@FileTitle : [CPS_GEM_0002] Processing Status
     *Open Issues :
     *Change history :
     *@LastModifyDate : 2009.04.21
     *@LastModifier : 진윤오
     *@LastVersion : 1.0
     * 2009.04.17 진윤오
     * 1.0 Creation
     =========================================================*/%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@page import="com.clt.apps.opus.cps.gem.gemcommon.gemmastercodemgt.event.CpsGem0007Event"%>
<%@ page import="org.apache.log4j.Logger"%><%@page import="java.util.Date"%>
<%
SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
String usrId = account.getUsr_id();
String usrAuthTpCd = account.getUsr_auth_tp_cd();

%>
<html>
<head>
<title>Approval of Requested expense</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
    function setupPage(){
        loadPage();      
    }
</script>
</head>
<body onLoad="setupPage();">
<form name="form" method="post">
<input type="hidden" name="f_cmd"> 
<input type="hidden" name="pagerows">
<input type="hidden" name="gw_subject"> 
<input type="hidden" name="gw_contents">
<input type="hidden" name="gw_args" value="email;">
<input type="hidden" name="usr_ofc_cd">
<input type="hidden" name="usr_auth_tp_cd" value="<%=usrAuthTpCd%>">
<input type="hidden" name="usr_role">
<input type="hidden" name="usr_tic_cd">
<input type="hidden" name="pagerows">
<input type="hidden" name="auth_flg">
<input type="hidden" name="pln_yrmon">
<input type="hidden" name="fm_gen_expn_cd_grp">
<input type="hidden" name="fm_ofc_cd">
<input type="hidden" name="fm_gen_expn_cd"> 
<input type="hidden" name="rownum">
<input type="hidden" name="curr_dt" value="<%=DateTime.getFormatDate(new Date(),"yyyyMMdd")%>">


<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
    <tr><td valign="top">           
	<!--Page Title, Historical (S)-->
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
	    <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span>&nbsp;</td></tr>
	    <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
	</table>
	<!--Page Title, Historical (E)-->         
    <table class="search">        
    <tr>
        <td class="bg" valign="top">		                      
        <table class="search" border="0" style="width:979;"> 
                <tr class="h23">
                    <td width="160">
                        <table class="search_sm2" border="0" style="width:95%;"> 
                            <tr class="h23">
                                <td><input type="radio" value="EA" name="gen_expn_rqst_tp_cd" class="trans" onclick="onChagneRqstTpCd()"  checked>ADD/TRS
                                &nbsp;&nbsp;&nbsp;<input type="radio" name="gen_expn_rqst_tp_cd" value="EI" onclick="onChagneRqstTpCd()"  class="trans">INI</td>
                            </tr>
                        </table> 
                    </td>
                    <td width="80">Request No.</td>
                    <td width="200"><input type="text" style="width:155;text-align: center;ime-mode:disabled" class="input" name="gen_expn_rqst_no" onKeyPress="ComKeyOnlyAlphabet('uppernum')">&nbsp;<img src="img/btns_search.gif" name="btns_popup" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
                    
                    <td width="230">
                        <table class="search_sm2" border="0" style="width:95%;"> 
                            <tr class="h23">
                                <td><input type="radio" name="ofc_expn_div" value="O" class="trans">Office&nbsp;&nbsp;<input type="radio" value="E" name="ofc_expn_div" class="trans">Expense&nbsp;&nbsp;&nbsp;<input type="text" style="width:70;text-align: center;ime-mode:disabled;" class="input" name="ofc_expn_cd" maxlength="6" fullfill onKeyPress="ComKeyOnlyAlphabet('uppernum')"></td>
                            </tr>
                        </table> 
                    </td>
                    <td width="95">Expense Group</td>
                    <td width="">
                    <script language="javascript">ComComboObject("combo1", 2, 70, 1, 0, 0, true);</script>
                    </td>
                    <td align="right">
                        <table class="search_sm2" border="0" style="width:120;"> 
                            <tr class="h23">
                                <td><input type="radio" name="lang_div" checked="checked" value="KOR" class="trans">KOR&nbsp;&nbsp;&nbsp;<input type="radio" name="lang_div" value="ENG" class="trans">ENG</td>
                            </tr>
                        </table> 
                    </td>
                </tr>
                </table>    
                <table class="height_2"><tr><td></td></tr></table>
                <table class="search" border="0" style="width:979;"> 
                <tr class="h23">                    
                    <td width="140"><input type="checkbox" value="" class="trans" checked disabled>BU&nbsp;&nbsp;<input type="checkbox" value="N" class="trans" name="sls_ofc_div_cd"  onclick="setHOHQ(this ,'document.form.ofc_lvl');isHoHqGubun('GEM_COMMONGS.do','SEARCHLIST01','sheet2','sls_ofc_div_cd','1','document.form.ofc_lvl');">HO&nbsp;&nbsp;<input type="checkbox" value="Y" class="trans" name="sls_ofc_div_cd" onclick="setHOHQ(this ,'document.form.ofc_lvl');isHoHqGubun('GEM_COMMONGS.do','SEARCHLIST01','sheet2','sls_ofc_div_cd','1','document.form.ofc_lvl');">HQ</td>
                    <td width="280" align="left"><select style="width:80;" class="input1" name="ofc_lvl1" onchange="selLevelChange('GEM_COMMONGS.do','SEARCHLIST01','sheet2','sls_ofc_div_cd','1','document.form.ofc_lvl');;">
                            </select>&nbsp;
                            <select style="width:80;" class="input1" name="ofc_lvl2" onmousedown="selLevelChange2('GEM_COMMONGS.do','SEARCHLIST02','sheet2','sls_ofc_div_cd','2','document.form.ofc_lvl');" onchange="selLevelChange('GEM_COMMONGS.do','SEARCHLIST02','sheet2','sls_ofc_div_cd','2','document.form.ofc_lvl');focusOut();">
                            </select>&nbsp;
                            <select style="width:80;" class="input1" name="ofc_lvl3" required caption="Office Code" onchange="focusOut();">
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
                                <td class="stm"><input type="radio" name="curr_cd" value="LCL" class="trans" checked>LCL&nbsp;&nbsp;<input type="radio" name="curr_cd" value="USD" class="trans">USD&nbsp;&nbsp;<input type="radio" name="curr_cd" value="KRW" class="trans">KRW</td>
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
    
                    
            <!--  biz_1   (E) -->
            
            <table class="height_8"><tr><td></td></tr></table>
            <!-- ==================================================================== -->                
                
            <!-- Grid  (S) -->
            <table width="100%" class="grid2"> 
            <tr class="tr2_head">                                
                <td width="25%" colspan="3">Request (1st)   </td>                                            
                <td width="25%" colspan="3">Regional HQ / BU Control (2nd)  </td>                                    
                <td width="25%" colspan="3">T.I.C (3rd) </td>                                                
                <td width="25%" class="tr_head" colspan="3">Committee (Final)   </td>       
            </tr>
            <tr class="tr2_head2">                               
                <td width="8%">Process</td>                              
                <td width="8%">Reject</td>                                   
                <td width="%">Approval</td>                              
                <td width="8%">Process</td>                              
                <td width="8%">Reject</td>                                   
                <td width="%">Approval</td>                          
                <td width="8%">Process</td>                              
                <td width="8%">Reject</td>                                   
                <td width="%">Approval</td>                              
                <td width="8%" class="tr_head2">Process</td>                                 
                <td width="8%" class="tr_head2">Reject</td>                                  
                <td width="%" class="tr_head2">Approval</td>            
            </tr>
            <tr align="center">
                <td><img src="img/btng_icon_g.gif" id="imgRq1" width="13" height="13" alt="" border="0" align="absmiddle"></td>
                <td><img src="img/btng_icon_g.gif" id="imgRq2" width="13" height="13" alt="" border="0" align="absmiddle"></td>
                <td><img src="img/btng_icon_g.gif" id="imgRq3" width="13" height="13" alt="" border="0" align="absmiddle"></td>
                <td><img src="img/btng_icon_g.gif" id="imgHq1" width="13" height="13" alt="" border="0" align="absmiddle"></td>
                <td><img src="img/btng_icon_g.gif" id="imgHq2" width="13" height="13" alt="" border="0" align="absmiddle"></td>
                <td><img src="img/btng_icon_g.gif" id="imgHq3" width="13" height="13" alt="" border="0" align="absmiddle"></td>
                <td><img src="img/btng_icon_g.gif" id="imgTc1" width="13" height="13" alt="" border="0" align="absmiddle"></td>
                <td><img src="img/btng_icon_g.gif" id="imgTc2" width="13" height="13" alt="" border="0" align="absmiddle"></td>
                <td><img src="img/btng_icon_g.gif" id="imgTc3" width="13" height="13" alt="" border="0" align="absmiddle"></td>
                <td><img src="img/btng_icon_g.gif" id="imgCo1" width="13" height="13" alt="" border="0" align="absmiddle"></td>
                <td><img src="img/btng_icon_g.gif" id="imgCo2" width="13" height="13" alt="" border="0" align="absmiddle"></td>
                <td><img src="img/btng_icon_g.gif" id="imgCo3" width="13" height="13" alt="" border="0" align="absmiddle"></td>
            </tr>
            </table> 
            <!-- Grid (E) -->
        
        
            <table width="100%" class="button"> 
            <tr class="h23">
                <td width="150" >Approval Opinion&nbsp;&nbsp;<img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" name="btns_approval_opinion" style="cursor: hand"></td>
                <td style="padding-top:2"><table width="180" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn2_left"></td>
                        <td class="btn2" name="btn2_Request">Request for Approval</td>
                        <td class="btn2_right"></td>
                        </tr>
                        </table></td>
            </tr>
            </table>                
    
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
                    <td class="btn1" name="btn1_Retrieve">Retrieve</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                <td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn1_New">New</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                <td class="btn1_line"></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn1_Adjustment" id="btn1_Adjustment">Adjustment</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn1_Approval" id="btn1_Approval">Approval</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn1_History">Request Information</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn1_Down_Excel">Down Excel</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
            </tr>
            </table>
        </td></tr>
        <script language="javascript">ComSheetObject('sheet2');</script>
        </table>
    <!--Button (E) -->
<!-- 개발자 작업  끝 -->
    </td></tr>
</table>
</form>

<!-- RequestNo 검색 팝업  -->
<form name="form1" method="post" onsubmit="return false">
    <input type="hidden" name="pln_yrmon">
    <input type="hidden" name="rqst_ofc_cd">
    <input type="hidden" name="gen_expn_rqst_tp_cd">    
    <input type="hidden" name="prg_id">
</form>
</body>
</html>