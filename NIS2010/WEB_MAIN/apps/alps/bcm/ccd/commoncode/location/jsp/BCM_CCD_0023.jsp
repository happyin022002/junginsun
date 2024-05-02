<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : BCM_CCD_0023.jsp
*@FileTitle  : Leasing Company Yard 
*@author     : CLT 
*@version    : 1.0
*@since      : 2014/06/10
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.bcm.ccd.commoncode.location.event.BcmCcd0023Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    BcmCcd0023Event  event = null;              //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //Error from server
    String strErrMsg = "";                      //Error message
    int rowCount     = 0;                       //Count of DB resultSet list
    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";
    String strUsr_id        = "";
    String strUsr_nm        = "";
    Logger log = Logger.getLogger("com.hanjin.apps.commoncode.location");
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        event = (BcmCcd0023Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
    } catch(Exception e) {
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
<form name="form" id="form">
<input id="f_cmd" name="f_cmd" type="hidden" />
<input id="pagerows" name="pagerows" type="hidden" />
<input id="ibflag" name="ibflag" type="hidden" />
<input id="mdm_yn" name="mdm_yn" value="y" type="hidden" />
<input type="hidden" name="onchange_flag" id="onchange_flag" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
    <!-- page_title(S) -->
  	<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
   	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation">Vessel Particular</span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
	</table>
</div>
      <!--biz page (S)-->
        <table class="search">
		<tr>
			<td class="bg">
				<table class="search" border="0" style="width: 979">
				<tr class="h23">
                    <td width="175">Leasing Company Yard Code</td>
                    <td><input id="lse_co_yd_cd" style="width: 80px; ime-mode:disabled; text-align:center" class="input1" name="lse_co_yd_cd" dataformat="engupnum" maxlength="7" type="text" onBlur="obj_change();"/>
                    <img src="img/btns_search.gif" name="btns_search1" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
                    <td><input type="hidden" style="width:150px;text-align:center;" class="input" dataformat="engup" id="modi_lse_co_yd_cd" name="modi_lse_co_yd_cd" maxlength="30"></td>
                </tr>
                </table>
                <table class="search" border="0">
                <tr class="h23">
                    <td width="175" style="text-align:right;">Name</td>
                    <td><input id="lse_co_yd_nm" style="width: 710px;" class="input1" name="lse_co_yd_nm" dataformat="engupspecial" otherchar="()_\-,. " maxlength="50" type="text" /> </td>
                </tr>
                </table>
    <div class="opus_design_inquiry"><table class="line_bluedot"><tr><td></td></tr></table></div>
    <div class="opus_design_inquiry">
        <table>
                <tr class="h23">
                    <td width="175" style="text-align:right;">Address</td>
                    <td><input id="yd_addr" style="width: 710px;" class="input1" name="yd_addr" maxlength="200" type="text" dataformat="all"/> </td>
                </tr>
        </table>
        <table>
                <tr class="h23">
                    <td width="175" style="text-align:right;">International Tel No</td>
                    <td width="20" ><script type="text/javascript" class="input1">ComComboObject('intl_phn_no', 2, 50, 1,1, true)</script></td>
                    <td width="50" style="text-align:right;">Tel No</td>
                    <td><input id="phn_no" style="width: 155px; ime-mode:disabled; text-align:right" class="input1" name="phn_no" dataformat="saupja" otherchar="-" maxlength="20" type="text" /> </td>
                    <td width="75" style="text-align:right;">FAX No</td>
                    <td ><input id="fax_no" style="width: 155px; ime-mode:disabled; text-align:right" class="input1" name="fax_no" dataformat="saupja" otherchar="-" maxlength="20" type="text" /> </td>
                	<td width="200"></td>
                </tr>
        </table>
        <table>
                <tr class="h23">
                    <td width="175" style="text-align:right;">E-Mail</td>
                    <td><input type="text" style="width:255px;ime-mode:disabled;" class="input" name="yd_eml" maxlengtd="50" id="yd_eml" dataformat="all"/></td>
                    <td width="75" style="text-align:right;">P.I.C</td>
                    <td colspan="3"><input id="yd_pic_nm" style="width: 255px; " class="input" name="yd_pic_nm" dataformat="all" maxlength="50" type="text" /></td>
                </tr>
        </table>
        <div><table class="line_bluedot"><tr><td colspan="6"></td></tr></table></div>
        <table> 
                <tr class="h23">
                    <td></td>
                    <td>Leasing Company Vendor 1</td>
                    <td><input id="lse_co_vndr_seq1" style="width: 250px; ime-mode:disabled; text-align:left" class="input1" name="lse_co_vndr_seq1" dataformat="int" maxlength="6" type="text" onBlur="obj_change();"/>
                    <img src="img/btns_search.gif" name="btns_search2" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
                    <td width="10"></td>
                    <td>Leasing Company Vendor 11</td>
                    <td><input id="lse_co_vndr_seq11" style="width: 250px; ime-mode:disabled; text-align:left" class="input" name="lse_co_vndr_seq11" dataformat="int" maxlength="6" type="text" onBlur="obj_change();"/>
                    <img src="img/btns_search.gif" name="btns_search3" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
                    <td></td>
                </tr>   
                <tr class="h23">
                    <td></td>
                    <td>Leasing Company Vendor 2</td>
                    <td><input id="lse_co_vndr_seq2" style="width: 250px; ime-mode:disabled;text-align:left" class="input" name="lse_co_vndr_seq2" dataformat="int" maxlength="6" type="text" onBlur="obj_change();"/>
                    <img src="img/btns_search.gif" name="btns_search4" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
                    <td></td>
                    <td>Leasing Company Vendor 12</td>
                    <td><input id="lse_co_vndr_seq12" style="width: 250px; ime-mode:disabled;text-align:left" class="input" name="lse_co_vndr_seq12" dataformat="int" maxlength="6" type="text" onBlur="obj_change();"/>
                    <img src="img/btns_search.gif" name="btns_search5" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
                    <td></td>
                </tr>   
                <tr class="h23">
                    <td></td>
                    <td>Leasing Company Vendor 3</td>
                    <td><input id="lse_co_vndr_seq3" style="width: 250px; ime-mode:disabled;text-align:left" class="input" name="lse_co_vndr_seq3" dataformat="int" maxlength="6" type="text" onBlur="obj_change();"/>
                    <img src="img/btns_search.gif" name="btns_search6" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
                    <td></td>
                    <td>Leasing Company Vendor 13</td>
                    <td><input id="lse_co_vndr_seq13" style="width: 250px; ime-mode:disabled;text-align:left" class="input" name="lse_co_vndr_seq13" dataformat="int" maxlength="6" type="text" onBlur="obj_change();"/>
                    <img src="img/btns_search.gif" name="btns_search7" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
                    <td></td>
                </tr>   
                <tr class="h23">
                    <td></td>
                    <td>Leasing Company Vendor 4</td>
                    <td><input id="lse_co_vndr_seq4" style="width: 250px; ime-mode:disabled;text-align:left" class="input" name="lse_co_vndr_seq4" dataformat="int" maxlength="6" type="text" onBlur="obj_change();"/>
                    <img src="img/btns_search.gif" name="btns_search8" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
                    <td></td>
                    <td>Leasing Company Vendor 14</td>
                    <td><input id="lse_co_vndr_seq14" style="width: 250px; ime-mode:disabled;text-align:left" class="input" name="lse_co_vndr_seq14" dataformat="int" maxlength="6" type="text" onBlur="obj_change();"/>
                    <img src="img/btns_search.gif" name="btns_search9" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
                    <td></td>
                </tr>
                <tr class="h23">
                    <td></td>
                    <td>Leasing Company Vendor 5</td>
                    <td><input id="lse_co_vndr_seq5" style="width: 250px; ime-mode:disabled;text-align:left" class="input" name="lse_co_vndr_seq5" dataformat="int" maxlength="6" type="text" onBlur="obj_change();"/>
                    <img src="img/btns_search.gif" name="btns_search10" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
                    <td></td>
                    <td>Leasing Company Vendor 15</td>
                    <td><input id="lse_co_vndr_seq15" style="width: 250px; ime-mode:disabled;text-align:left" class="input" name="lse_co_vndr_seq15" dataformat="int" maxlength="6" type="text" onBlur="obj_change();"/>
                    <img src="img/btns_search.gif" name="btns_search11" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
                    <td></td>
                </tr>   
                <tr class="h23">
                    <td></td>
                    <td>Leasing Company Vendor 6</td>
                    <td><input id="lse_co_vndr_seq6" style="width: 250px; ime-mode:disabled;text-align:left" class="input" name="lse_co_vndr_seq6" dataformat="int" maxlength="6" type="text" onBlur="obj_change();"/>
                    <img src="img/btns_search.gif" name="btns_search12" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
                    <td></td>
                    <td>Leasing Company Vendor 16</td>
                    <td><input id="lse_co_vndr_seq16" style="width: 250px; ime-mode:disabled;text-align:left" class="input" name="lse_co_vndr_seq16" dataformat="int" maxlength="6" type="text" onBlur="obj_change();"/>
                    <img src="img/btns_search.gif" name="btns_search13" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
                    <td></td>
                </tr>   
                <tr class="h23">
                    <td></td>
                    <td>Leasing Company Vendor 7</td>
                    <td><input id="lse_co_vndr_seq7" style="width: 250px; ime-mode:disabled;text-align:left" class="input" name="lse_co_vndr_seq7" dataformat="int" maxlength="6" type="text" onBlur="obj_change();"/>
                    <img src="img/btns_search.gif" name="btns_search14" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
                    <td></td>
                    <td>Leasing Company Vendor 17</td>
                    <td><input id="lse_co_vndr_seq17" style="width: 250px; ime-mode:disabled;text-align:left" class="input" name="lse_co_vndr_seq17" dataformat="int" maxlength="6" type="text" onBlur="obj_change();"/>
                    <img src="img/btns_search.gif" name="btns_search15" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
                    <td></td>
                </tr>   
                <tr class="h23">
                    <td></td>
                    <td>Leasing Company Vendor 8</td>
                    <td><input id="lse_co_vndr_seq8" style="width: 250px; ime-mode:disabled;text-align:left" class="input" name="lse_co_vndr_seq8" dataformat="int" maxlength="6" type="text" onBlur="obj_change();"/>
                    <img src="img/btns_search.gif" name="btns_search16" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
                    <td></td>
                    <td>Leasing Company Vendor 18</td>
                    <td><input id="lse_co_vndr_seq18" style="width: 250px; ime-mode:disabled;text-align:left" class="input" name="lse_co_vndr_seq18" dataformat="int" maxlength="6" type="text" onBlur="obj_change();"/>
                    <img src="img/btns_search.gif" name="btns_search17" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
                    <td></td>
                </tr>   
                <tr class="h23">
                    <td></td>
                    <td>Leasing Company Vendor 9</td>
                    <td><input id="lse_co_vndr_seq9" style="width: 250px; ime-mode:disabled;text-align:left" class="input" name="lse_co_vndr_seq9" dataformat="int" maxlength="6" type="text" onBlur="obj_change();"/>
                    <img src="img/btns_search.gif" name="btns_search18" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
                    <td></td>
                    <td>Leasing Company Vendor 19</td>
                    <td><input id="lse_co_vndr_seq19" style="width: 250px; ime-mode:disabled;text-align:left" class="input" name="lse_co_vndr_seq19" dataformat="int" maxlength="6" type="text" onBlur="obj_change();"/>
                    <img src="img/btns_search.gif" name="btns_search19" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
                    <td></td>
                </tr>   
                <tr class="h23">    
                    <td></td>
                    <td>Leasing Company Vendor 10</td>
                    <td><input id="lse_co_vndr_seq10" style="width: 250px; ime-mode:disabled;text-align:left" class="input" name="lse_co_vndr_seq10" dataformat="int" maxlength="6" type="text" onBlur="obj_change();"/>
                    <img src="img/btns_search.gif" name="btns_search20" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
                    <td></td>
                    <td>Leasing Company Vendor 20</td>
                    <td><input id="lse_co_vndr_seq20" style="width: 250px; ime-mode:disabled;text-align:left" class="input" name="lse_co_vndr_seq20" dataformat="int" maxlength="6" type="text" onBlur="obj_change();"/>
                    <img src="img/btns_search.gif" name="btns_search21" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
                    <td></td>
                </tr>   
        </table>  
        <div><table class="line_bluedot"><tr><td colspan="6"></td></tr></table></div>
        <table>
                <tr class="h23">
                    <td>Delete Flag</td>
                    <td width="50">
                        <select style="width:40px;" name="delt_flg" class="input" id="delt_flg" onChange="obj_change();">
                            <option value="N" selected>N</option>
                            <option value="Y">Y</option>
                        </select>
                    </td>
                    <td>Create User</td>
		            <td width="90"><input type="text" style="width:80px;text-align:center;" class="input" name="cre_usr_id" id="cre_usr_id" readOnly/>
		            </td>
		            <td>Create Date/Time</td>
		            <td width="130"><input type="text" style="width:120px;text-align:center;" class="input" name="cre_dt" id="cre_dt" readOnly/>
		            </td>
		            <td>Last Update User</td>
		            <td width="90"><input type="text" style="width:80px;text-align:center;" class="input" name="upd_usr_id" id="upd_usr_id" readOnly/>
		            </td>
		            <td>Last Update Date/Time</td>
		            <td width="120"><input type="text" style="width:120px;text-align:center;" class="input" name="upd_dt" id="upd_dt" readOnly/>
		            </td>
                </tr>   
        </table>
     
    </div>
<!-- opus_design_inquiry(E) -->
<div class="wrap_result">
    <!-- opus_design_grid(S) -->
    <div class="opus_design_grid" style="display: none;">
        <script type="text/javascript">ComSheetObject('sheet1');</script>
    </div>
    <!-- opus_design_grid(E) -->
</div>
</td>
</tr></table>
    <!--Button (S) -->
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;padding-bottom:10;">
        <tr><td class="btn1_bg">
            <table border="0" cellpadding="0" cellspacing="0">
            <tr>
            	<td id="btn_History"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
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
                <table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
                <tr>
                    <td class="btn1_left"></td>
                    <td class="btn1" name="btn_New">New</td>
                    <td class="btn1_right"></td>
                </tr>
                </table>
            </td>
   	 	</tr>
    </table>
    </td>
    </tr>
    </table>

</form></body>