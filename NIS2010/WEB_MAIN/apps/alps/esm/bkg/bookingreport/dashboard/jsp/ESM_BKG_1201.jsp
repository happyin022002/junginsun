<%
	/*=========================================================
	 *Copyright(c) 2013 CyberLogitec
	 *@FileName : esm_bkg_1201.jsp
	 *@FileTitle : BKG Dashboard (by Office)
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2013.10.16
	 *@LastModifier : Poong-Yeon Cho
	 *@LastVersion : 1.0
	 * 2013.10.16 Poong-Yeon Cho
	 * 1.0 Creation
	 =========================================================*/ 
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingreport.dashboard.event.EsmBkg1201Event"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.common.util.basic.CodeUtilBC" %>
<%@ page import="com.hanjin.apps.alps.esd.sce.common.util.basic.CodeUtilBCImpl" %>

<%
        EsmBkg1201Event  event        = null;                       
        Exception serverException     = null;                   

        String strErrMsg              = "";                              
        DBRowSet rowSet               = null;                        
        int rowCount                  = 0;                               
        SignOnUserAccount account     =(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        String userId                 = account.getUsr_id();

        try{
            serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
            if (serverException != null) {
                strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
            }else{
                event = (EsmBkg1201Event)request.getAttribute("Event");
            }
        } catch(Exception e) {
            out.println(e.toString());
        }
%>

<html>
<head>
<title>Welcome to alps!</title>
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
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="row_size">
<input type="hidden" name="f_rpt_fom_no">
<input type="hidden" name="f_dbd_cre_dt">
<input type="hidden" name="f_dbd_cre_seq">
<input type="hidden" name="f_dest_cnt_cd">
<input type="hidden" name="f_irr_tp_cd">
<input type="hidden" name="f_irr_tp_nm">
<input type="hidden" name="s_bkg_ofc_cd">

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
                                                <tr><td class="btn1_left"></td><td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
                                            <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                <tr><td class="btn1_left"></td><td class="btn1" name="btn_template" id="btn_template">Template</td><td class="btn1_right"></td></tr></table></td>
                                            <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                <tr><td class="btn1_left"></td><td class="btn1" name="btn_downexcel" id="btn_downexcel">DownExcel</td><td class="btn1_right"></td></tr></table></td>
                                            <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                <tr><td class="btn1_left"></td><td class="btn1" name="btn_new" id="btn_new">New</td><td class="btn1_right"></td></tr></table></td>
                                            <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                            <!-- Repeat Pattern -->

                                        </tr></table>

                                </td></tr>
                        </table>
        <!-- TABLE '#D' : ( Button : Main ) (E) -->

        <!-- TABLE '#D' : ( Search Options ) (S) -->
        <table class="search">
            <tr>
                <td class="bg">
                    <table class="search_in" border="0">
                        <tr><td>
                        <table class="search_sm2">
                        <tr class="h23">
                        <td width='30'><input type='radio' value='rhq' name='s_kind' class='trans' onClick='chgCondition(this)'></td>
                            <td width='68'>RHQ</td>
                            <td width="100"><input name="f_rhq_cd" type="text" class="input1" dataformat="engup" style="width:120;" onBlur='this.value=this.value.toUpperCase();' Disabled ></td>
                            <td width='65'>&nbsp;</td>
                            <td width='30'><input type='radio' value='ofc' name='s_kind' class='trans' onClick='chgCondition(this)' checked></td>
                            <td width='80'>BKG Office</td>
                            <td width="100" ><input name="f_bkg_ofc_cd" type="text" class="input1" dataformat="engup" style="width:120;" onBlur='this.value=this.value.toUpperCase();'></td>
                            <td width='12'>&nbsp;</td>
                            <td width='20' class="sm">Sub</td>
                            <td width="45"><input name="f_sub_bkg_ofc_cd" type="checkbox" class="trans" ></td>
                            <td width='15'>&nbsp;</td>
                            <td width='30'><input type='radio' value='bkgno' name='s_kind' class='trans' onClick='chgCondition(this)'></td>
                            <td width='60'>BKG NO</td>
                            <td width="100"><input name="f_bkg_no" type="text" class="input1" dataformat="engup" style="width:120;" onBlur='this.value=this.value.toUpperCase();'></td>
                        	<td width='10'>&nbsp;</td>
                        </tr>
                        </table>
                        <table  class="search_sm2">
                        <tr class="h23">
                            <td width='30'><input type='radio' value='cust' name='s_kind' class='trans' onClick='chgCondition(this)'></td>
                            <td width='70'>Customer</td>
                            <td width ="40"><script language="javascript">ComComboObject('combo_cust',2, 40, '', 1, 2);</script></td>
                            <td width="100"><input name="f_cust_cd" type="text" class="input1" dataformat="engup" style="width:78;" onBlur='javascript:this.value=this.value.toUpperCase();'></td>
                            <td width=20>&nbsp;</td>
                            
                            <td width='25'></td>
                            <td width='30'><input type='radio' value='gcust' name='s_kind' class='trans' onClick='chgCondition(this)' onClick='chgCondition(this)'></td>
                            <td width='82'>G. Customer</td>
                            <td><script language="javascript">ComComboObject('combo_gcust',2, 40, '', 1, 2);</script></td>
                            <td width="100"><input name="f_gcust_cd" type="text" class="input1" dataformat="engup" style="width:78;" onBlur='javascript:this.value=this.value.toUpperCase();'></td>
                            <td width='72'>&nbsp;</td>
                            <td width='30'><input type='radio' value='ctrt' name='s_kind' class='trans' onClick='chgCondition(this)'></td>
                            <td width='62'>Contract</td>
                            <td><script language="javascript">ComComboObject('combo_ctrt',2, 40, '', 1, 2);</script></td>
                            <td width="90"><input name="f_ctrt_no" type="text" class="input1" dataformat="engup" style="width:78;" onBlur='javascript:this.value=this.value.toUpperCase();'></td>
                             <td width='0'></td>
                        </tr>
                        </table>
                        <table class="height_5"><tr><td></td></tr></table>
                        <table>
                        <tr class="h23">
                            <td width='34'>&nbsp;</td>
                            <td width='68'>VVD</td>
                            <td width="180"><input name="f_vvd" type="text" class="input" dataformat="engup" style="width:120;" onBlur='javascript:this.value=this.value.toUpperCase();'></td>
                            <td width='36'>&nbsp;</td>
                            <td width='81'>POL</td>
                            <td width="170"><input name="f_pol_nod_cd" type="text" class="input" dataformat="engup" style="width:120;" onBlur='javascript:this.value=this.value.toUpperCase();'"></td>
                            <td width='73'>&nbsp;</td>
                            <td width='61'>POD</td>
                            <td width="160"><input name="f_pod_nod_cd" type="text" class="input" dataformat="engup" style="width:120;" onBlur='javascript:this.value=this.value.toUpperCase();'"></td>
                            
                        </tr>
                        </table>
                        <table class="height_5"><tr><td></td></tr></table>
                        <table>
                        <tr class="h23">
                            <td width='35'>&nbsp;</td>
                             <td width='69'>BKG Staff</td>
                            <td><script language="javascript">ComComboObject('f_staff_id',1, 120, '');</script></td>
                             <td width='95'>&nbsp;</td>
                             <td width='82'>L/Rep</td>
                            <td><script language="javascript">ComComboObject('f_rep_id',1, 120, '');</script></td>
                            
                        </tr>
                        </table>
                        </td></tr>
                    </table>
                </td></tr>
        </table>
        <!-- TABLE '#D' : ( Search Options ) (E) -->


        <table class="height_10"><tr><td></td></tr></table>
        <table class="search">
        <tr>
        <td align='right'><b><span id='f_bat_st_dt'></span></b></td>
        <td width=20>&nbsp;</td>
        </tr>
        </table>

     

        <!-- TABLE '#D' : ( Tab BG Box ) (S) -->
        <div id="tabLayer" style="display: inline;">
        <table class="search" border="0">
            <tr>
                <td class="bg">
                    <table class="height_10"><tr><td></td></tr></table>

                    <!-- : ( grid ) (S) -->
                    <table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet1');</script>
                        </td></tr>
                    </table>
                    <!-- : ( grid ) (E) -->
            </td></tr>
        </table>
        </div>
        <div id="tabLayer" style="display: none">
        <table class="search" border="0">
            <tr>
                <td class="bg">
                    <table class="height_10"><tr><td></td></tr></table>

                    <!-- : ( grid ) (S) -->
                    <table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet2');</script>
                             <script language="javascript">ComSheetObject('sheet3');</script>
                        </td></tr>
                    </table>
                    <!-- : ( grid ) (E) -->
            </td></tr>
        </table>
        </div>
        <!-- TABLE '#D' : ( Tab BG Box ) (E) -->
        <!-- ####### TABLE '#D' ::: 'RIGHT' FRAME (END) ####### -->

       
        <table class="height_10"><tr><td></td></tr></table>
    </td></tr>
</table>
</form>
<!-- TABLE '#B' : 'Left + Right Body' Table (E)nd -->
    </td></tr>
</table>
<!-- Outer Table (E)-->
</body>
</html>