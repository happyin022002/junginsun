<%/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : BCM_CCD_0013.jsp
*@FileTitle  :  Package Type Creation 
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
<%@ page import="com.hanjin.apps.alps.bcm.ccd.commoncode.commodity.event.BcmCcd0013Event"%>
<%@ page import="org.apache.log4j.Logger" %>
 
<%
    BcmCcd0013Event  event = null;              //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //Error from server
    String strErrMsg = "";                      //Error message
    int rowCount     = 0;                       //Count of DB resultSet list
    
    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    String screenName        = "";
    Logger log = Logger.getLogger("com.hanjin.apps.alps.bcm.ccd.commoncode.commodity");
    
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        
        event = (BcmCcd0013Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
        
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        
    }catch(Exception e) {
        out.println(e.toString());
    }
%>

<html>
<head>
<title>Equalization Port </title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">

    var G_MDAA_CHK;
    var G_AHTU_TP_CD;

    function setupPage(){
    	var formObj = document.form;
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if
        ComSetObjValue(formObj.screenName,"<%=screenName%>");
        loadPage();
    }
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="mdm_yn" id="mdm_yn" value='Y'>
<input type="hidden" name="screenName">
<input type="hidden" name="ibflag" id="ibflag" />
<input type="hidden" name="onchange_flag" id="onchange_flag" value="N"/>

<!-- page_title_area(S) -->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	

		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">   
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>   
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>   
		</table>   
		<!--Page Title, Historical (E)-->
		
		<!--biz page (S)-->
		<table class="search" id="mainTable"> 
			<tr><td class="bg">
			
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:1400"> 
					<tr class="h23">
						<td width="120" style="text-align: left">Package Type Code</td>
						<td width="120">
	                        <input type="text" style="width:50px;text-align:center;ime-mode:disabled;" class="input1" dataformat="engup" name="pck_cd" id="pck_cd" maxlength="2">
	                        <img src="img/btns_search.gif" name="btns_search" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" id="btns_search">
	                    </td>
	                    <td width="50">Name</td>
	                    <td><input type="text" style="width:800;text-align:left;" class="input1" dataformat="engupspace" otherchar="()_\-,. " name="pck_nm" id="pck_nm" maxlength="50"></td>
	                </tr>
	            </table>
	            <table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
	            
	            <table>
		            
			        <tr class="h23">
	                    <td>Delete Flag</td>
	                    <td width="100">
	                        <select style="width:80px;" name="delt_flg" class="input" id="delt_flg">
	                            <option value="N" selected>N</option>
	                            <option value="Y">Y</option>
	                        </select>
	                    </td>
	                    <td>Create User</td>
			            <td width="100"><input type="text" style="width:80px;text-align:center;" class="input" name="cre_usr_id" id="cre_usr_id" readOnly/>
			            </td>
			            <td>Create Date/Time</td>
			            <td width="140"><input type="text" style="width:120px;text-align:center;" class="input" name="cre_dt" id="cre_dt" readOnly/>
			            </td>
			            <td>Last Update User</td>
			            <td width="100"><input type="text" style="width:80px;text-align:center;" class="input" name="upd_usr_id" id="upd_usr_id" readOnly/>
			            </td>
			            <td>Last Update Date/Time</td>
			            <td width="100"><input type="text" style="width:120px;text-align:center;" class="input" name="upd_dt" id="upd_dt" readOnly/>
			            </td>
	                </tr>
				</table>
	
				<div style="display:none;">  
					<script language="javascript">ComSheetObject('sheet1');</script>
				</div>
				
				
			</td></tr>
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
	</td></tr>
</table>
</form>
</body>
</html>