<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : BCM_CCD_0024.jsp
*@FileTitle  : daylight saving time
*@author     : CLT
*@version    : 1.0 
*@since      : 2014/06/03
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.bcm.ccd.commoncode.location.event.BcmCcd0024Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
        BcmCcd0024Event  event = null;              //PDTO(Data Transfer Object including Parameters)
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


                event = (BcmCcd0024Event)request.getAttribute("Event");
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
<input type="hidden" name="mdm_yn" value="N" id="mdm_yn" />
<input type="hidden" name="onchange_flag" id="onchange_flag" value="N"/>

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
                    <td width="92" style="text-align: center">DST Code</td>
                    <td><input type="text" style="width:123px;ime-mode:disabled;text-align:center" class="input1" name="dst_id" dataformat="engupnum" maxlength="6" id="dst_id" onBlur="obj_change();"/>
                    <img src="img/btns_search.gif" name="btns_search" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" id="btns_search"></td>
                </tr>
                </table>
                <table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
		        <table class="search" border="0" style="width:979;">
					<tr class="h23">
		                    <td style="text-align: center">Country</td>
		                    <td><input type="text" style="width:100px;ime-mode:disabled;text-align:center" class="input1" name="dst_cnt_cd" dataformat="engup" maxlength="2" id="dst_cnt_cd" onBlur="obj_change();"/>
		                    <img src="img/btns_search.gif" name="btns_search1" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" id="btns_search1" ></td>
		                    <td style="text-align: center">DST year</td>
		                    <td><input type="text" style="width:100px;ime-mode:disabled;text-align:center" class="input1" name="dst_yr" dataformat="yy" maxlength="4" id="dst_yr" /> </td>
		                    <td style="text-align: center">DST Diff(Minutes)</td>
		                    <td><input type="text" style="width:100px;ime-mode:disabled;text-align:center" class="input1" name="dst_mnts" dataformat="int" maxlength="3" id="dst_mnts" /> </td>
	                		<td style="text-align: center">Not Applying State</td>
		                    <td><input type="text" style="width:130px;ime-mode:disabled;text-align:center" class="input" name="dst_not_aply_ste_nm" dataformat="engup" maxlength="50" id="dst_not_aply_ste_nm" readOnly/>
		                    <input type="hidden" style="width:100px;ime-mode:disabled;text-align:center" class="input" name="dst_not_aply_ste_cd" dataformat="engup" maxlength="3" id="dst_not_aply_ste_cd"/>
		                    <img src="img/btns_search.gif" name="btns_search2" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
	                </tr>   
	                <tr class="h23">
		                    <td style="text-align: center">Start DST Rule</td>
		                    <td colspan="3"><input type="text" style="width:350px;" class="input" name="st_dst_rule_desc" maxlength="120" id="st_dst_rule_desc" dataformat="all"/> </td>
		                    <td style="text-align: center">END DST Rule</td>
		                    <td colspan="3"><input type="text" style="width:350px;" class="input" name="end_dst_rule_desc" maxlength="100" id="end_dst_rule_desc" dataformat="all"/> </td>
	                </tr>   
	                <tr class="h23">
		                    <td style="text-align: center">Start Date</td>
		                    <td><input type="date" style="width:100px;ime-mode:disabled;text-align:center" class="input1" name="st_dst_dt" dataformat="ymd" maxlength="10" id="st_dst_dt" />
		                    <img class="cursor" src="img/btns_calendar.gif" name="btns_Calendar1" width="19" height="20" alt="" border="0" align="absmiddle" ></td>
		                    <td style="text-align: right">END Date</td>
		                    <td><input type="text" style="width:100px;ime-mode:disabled;text-align:center" class="input1" name="end_dst_dt" dataformat="ymd" maxlength="10" id="end_dst_dt" />
		                    <img class="cursor" src="img/btns_calendar.gif" name="btns_Calendar2" width="19" height="20" alt="" border="0" align="absmiddle" ></td>
		                    <td style="text-align: center">Start Time(HHMM)</td>
		                    <td><input type="text" style="width:100px;ime-mode:disabled;text-align:center" class="input1" name="st_dst_hrmnt" dataformat="hm" maxlength="5" id="st_dst_hrmnt" /> </td>
		                    <td style="text-align: center">END Time(HHMM)</td>
		                    <td><input type="text" style="width:100px;ime-mode:disabled;text-align:center" class="input1" name="end_dst_hrmnt" dataformat="hm" maxlength="5" id="end_dst_hrmnt" /> </td>
		                </tr>   
		        </table>
		        <table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
		        <table class="search" border="0" style="width:979;">
					<tr class="h23">
	                    <td width="92" style="text-align: center">Delete Flag</td>
	                    <td><select style="width:100px;" class="input1" name="delt_flg" id="delt_flg" onChange="obj_change()";><option value="N" selected>N</option><option value="Y">Y</option></select></td>
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

