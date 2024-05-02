
<%/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : BCM_CCD_0012.jsp
*@FileTitle  : Customs Package Type Creation
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
<%@ page import="com.hanjin.framework.core.controller.util.WebKeys"%>
<%@ page import="com.hanjin.framework.core.view.template.Screen"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.bcm.ccd.commoncode.commodity.event.BcmCcd0012Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    BcmCcd0012Event  event = null;              //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //error from server
    String strErrMsg = "";                      //error message
    int rowCount     = 0;                       //count of DB resultSet list
    
    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    String screenName		= "";
    Logger log = Logger.getLogger("com.hanjin.apps.alps.bcm.ccd.commoncode.commodity");
    
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        
        event = (BcmCcd0012Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
        
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        
        log.debug("====================================");
		Screen screen = (Screen) request.getAttribute(WebKeys.CURRENT_SCREEN);
		screenName = screen.getName();
		log.debug("====================================");
        
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
<input type="hidden" name="pagerows"  id="pagerows">
<input type="hidden" name="screenName">
<input type="hidden" name="ibflag" id="ibflag" />
<input type="hidden" name="onchange_flag" id="onchange_flag" value="N"/>
<!-- 개발자 작업	-->


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
			<table class="search" border="0" style="width:700"> 
				<tr class="h23">
					<td width="120" style="text-align: left">Package Type</td>
					<td>
						<script language="javascript">ComComboObject('pck_cd', 2, 203, 1, 1, 1, false);</script>
					</td>
					<td width="120">Customs Country</td>
					<td width="120">
						<input type="text" style="width:90;text-align:center;ime-mode:disabled;" class="input1" dataformat="engup" name="cstms_cnt_cd" id="cstms_cnt_cd" maxlength="2">
						<img src="img/btns_search.gif" name="btns_search" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" id="btns_search"></td>
					</td>
				</tr>
			</table>
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
			<table>
				<tr class="h23">
					<td width="120" style="text-align: left">Package Customs</td>
					<td><input type="text" style="width:550px" class="input1"  name="pck_cstms_cd" id="pck_cstms_cd" maxlength="10"></td>
				</tr>   
				<tr class="h23">
					<td width="120" style="text-align: left">Delete Flag</td>
	                <td><select style="width:100px;" class="input" name="delt_flg" id="delt_flg">
	                <option value="N" selected>N</option><option value="Y">Y</option></select></td>
		         </tr>   
			</table>
			<!--  biz_1   (E) -->
	
			</td></tr>
		</table>
		
		<table class="height_8"><tr><td></td></tr></table>
		
		
		<div style="display:none;">  
			<script language="javascript">ComSheetObject('sheet1');</script>
		</div>
		
		<!--biz page (E)-->
	
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