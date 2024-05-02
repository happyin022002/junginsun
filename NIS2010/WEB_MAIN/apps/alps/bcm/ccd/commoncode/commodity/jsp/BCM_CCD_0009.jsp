<%/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : BCM_CCD_0009.jsp
*@FileTitle  : Group Commodity 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/03
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%> 
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.bcm.ccd.commoncode.commodity.event.BcmCcd0009Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    BcmCcd0009Event  event = null;              //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //Error from server
    String strErrMsg = "";                      //Error message
    int rowCount     = 0;                       //Count of DB resultSet list
    
    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    Logger log = Logger.getLogger("com.hanjin.apps.alps.bcm.ccd.commoncode.commodity");
    
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        
        event = (BcmCcd0009Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
        
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        
    }catch(Exception e) {
        out.println(e.toString());
    }
%>
<script language="javascript">
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
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="ibflag" id="ibflag" />
<input type="hidden" name="onchange_flag" id="onchange_flag" />
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	    <!-- page_title(S) -->
    <!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
   	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
	</table>
	<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->

<!-- page_title_area(E) -->
<!--biz page (S)-->
        <table class="search">
		<tr>
			<td class="bg">
				<table class="search" border="0" style="width: 979">
				<tr class="h23">
                    <td width="50" style="text-align: right">Code</td>
                    <td width="100"><input type="text" style="width:100px;text-align:center;ime-mode:disabled;" class="input1" dataformat="int" name="grp_cmdt_cd" id="grp_cmdt_cd" maxlength="2"></td>
                    <td width="140" style="text-align: right">Rep Min Code</td>
                    <td width="200"><input type="text" style="width:150px;text-align:center;ime-mode:disabled;" class="input" dataformat="int" name="min_rep_cmdt_cd" id="min_rep_cmdt_cd" maxlength="4"></td>
                    <td width="140" style="text-align: right">Rep Max Code</td>
                    <td><input type="text" style="width:150px;text-align:center;ime-mode:disabled;" class="input" dataformat="int" name="max_rep_cmdt_cd" id="max_rep_cmdt_cd" maxlength="4"></td>
                </tr>
        </table>
<table class="line_bluedot"><tr><td></td></tr></table>
				<table class="search" border="0" style="width: 979">
				<tr class="h23">
                    <td width="140" style="text-align: right">Group English Name</td>
                    <td><input type="text" style="width:300px;text-align:left;ime-mode:disabled;" class="input1" dataformat="engupspecial" otherchar=" " name="grp_cmdt_eng_nm" id="grp_cmdt_eng_nm" maxlength="200"></td>
                    <td style="text-align: right">Group Korean Name</td>
                    <td width=""><input type="text" style="width:300px;text-align:left;" class="input"  name="grp_cmdt_krn_nm" id="grp_cmdt_krn_nm" maxlength="200" dataformat="engupspecial"></td>
                </tr>
                <tr class="h23">
                    <td width="140" style="text-align: right">Group Japanese Name</td>
                    <td><input type="text" style="width:300px;text-align:left;" class="input" name="grp_cmdt_jpn_nm" id="grp_cmdt_jpn_nm" maxlength="200" dataformat="engupspecial"></td>
                    <td style="text-align: right">Group Chinese Name</td>
                    <td width=""><input type="text" style="width:300px;text-align:left;" class="input"  name="grp_cmdt_chn_nm" id="grp_cmdt_chn_nm" maxlength="200" dataformat="engupspecial"></td>
                </tr>
            </tbody>
        </table>
		<table class="line_bluedot"><tr><td></td></tr></table>
          <table class="search" border="0" style="width:979;">
			<tr class="h23">
                    <td width="95" style="text-align: right">Delete Flag</td>
                    <td>
                        <select style="width:70px;" class="input" name="delt_flg">
                            <option value="N">N</option>
                            <option value="Y">Y</option>
                        </select>
                    </td>
                </tr>   
        </table>
        </td>
     </tr>
     </table>
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

    <div style="display:none;">   
        <script type="text/javascript">ComSheetObject('sheet1');</script>
    </div>
</form>
</body>
