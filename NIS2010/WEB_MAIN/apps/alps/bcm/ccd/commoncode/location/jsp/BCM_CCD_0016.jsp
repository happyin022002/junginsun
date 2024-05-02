<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : BCM_CCD_0016.jsp
*@FileTitle  : country
*@author     : CLT
*@version    : 1.0 
*@since      : 2014/05/29
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.bcm.ccd.commoncode.location.event.BcmCcd0016Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
        BcmCcd0016Event  event = null;              //PDTO(Data Transfer Object including Parameters)
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


                event = (BcmCcd0016Event)request.getAttribute("Event");
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
<input type="hidden" name="ibflag" id="ibflag" />
<input type="hidden" name="mdm_yn" value="Y" id="mdm_yn" />
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
    
</div>
<!-- page_title_area(E) -->

<!--biz page (S)-->
        <table class="search">
		<tr>
			<td class="bg">
				<table class="search" border="0" style="width: 979">
				<tr class="h23">
                    <td width="95" style="text-align: right">Country Code</td>
                    <td width="90">
                        <input type="text" style="width:50px;ime-mode:disabled;text-align:center" name="cnt_cd" class="input1" dataformat="engup" maxlength="2" id="cnt_cd"/>
                        <img src="img/btns_search.gif" name="btns_search3" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" id="btns_search3">
                    </td>
                    <td width="120" style="text-align: right">Name</td>
                    <td><input type="text" style="width:60%;" dataformat="engupspace" otherchar="()_\-,. " name="cnt_nm" class="input1"  maxlength="50" id="cnt_nm" /></td>
                </tr>
        </table>
	<table class="line_bluedot"><tr><td></td></tr></table>
          <table class="search" border="0" style="width:979;">
			<tr class="h23">
					<td width="95" style="text-align: right">Continent</td>
                    <td width =""><script type="text/javascript">ComComboObject('conti_cd', 2, 100, 1, 1 ,1 ,false)</script></td>
                    <td width="" style="text-align: right">Sub Continent</td>
                    <td width="">
                        <input type="text" style="width:50px;ime-mode:disabled;text-align:center" name="sconti_cd" class="input1" dataformat="engup" maxlength="2" id="sconti_cd"/>
                        <img src="img/btns_search.gif" name="btns_search1" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" id="btns_search1">
					</td>
			</tr>
			<tr class="h23">
					<td width="95" style="text-align: right">Zone Division</td>		
					<td width ="120"><script type="text/javascript">ComComboObject('zn_div_bsel_cd', 2, 100, 1, 0 ,1 ,false)</script></td>
                    <td width="120" style="text-align: right">Currency Code</td>
                    <td>
                    	<input type="text" style="width:50px;ime-mode:disabled;text-align:center" name="curr_cd" class="input" dataformat="engup" maxlength="3" id="curr_cd"/>
                    	<img src="img/btns_search.gif" name="btns_search2" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" id="btns_search2">
                    </td>
                </tr>   
                <tr class="h23">
                    <td width="95" style="text-align: right">ISO Code</td>
                    <td width="90"><input type="text" style="width:50px;ime-mode:disabled;text-align:center" name="cnt_iso_cd" class="input" dataformat="engup" maxlength="3" id="cnt_iso_cd" /> </td>
                	<td width="120" style="text-align: right">EU Country Flag</td>
                    <td>
                        <select style="width:50px;" name="eu_cnt_flg" class="input" id="eu_cnt_flg" >
                            <option value="N" selected>N</option>
                            <option value="Y">Y</option>
                        </select>
                    </td>
                </tr>
                </table>
                <table>
                <tr class="h23">
                    <td width="110" style="text-align: right">E-Mail disclaimer</td>
                    <td width="90"><input type="text" style="width:863px;ime-mode:disabled;" name="eml_dsclm_ctnt" class="input" dataformat="engup" maxlength="1000" id="eml_dsclm_ctnt" /> </td>
                </tr>
        </table>
        <table class="search" border="0" style="width:979;">
			<tr class="h23">
                    <td style="text-align: center">Delete Flag</td>
                    <td>
                        <select style="width:50px;" name="delt_flg" class="input" id="delt_flg" onChange="obj_change();">
                            <option value="N" selected>N</option>
                            <option value="Y">Y</option>
                        </select>
                    </td>
                    <td style="text-align: center">Create User</td>
		            <td><input type="text" style="width:80px;text-align:center;" class="input" name="cre_usr_id" id="cre_usr_id" readOnly/>
		            </td>
		            <td style="text-align: center">Create Date/Time</td>
		            <td><input type="text" style="width:120px;text-align:center;" class="input" name="cre_dt" id="cre_dt" readOnly/>
		            </td>
		            <td style="text-align: center">Last Update User</td>
		            <td><input type="text" style="width:80px;text-align:center;" class="input" name="upd_usr_id" id="upd_usr_id" readOnly/>
		            </td>
		            <td style="text-align: center">Last Update Date/Time</td>
		            <td><input type="text" style="width:120px;text-align:center;" class="input" name="upd_dt" id="upd_dt" readOnly/>
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