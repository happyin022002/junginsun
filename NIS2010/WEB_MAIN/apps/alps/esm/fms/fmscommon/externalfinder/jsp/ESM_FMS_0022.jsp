<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_FMS_0022.jsp
*@FileTitle : Vessel Code
*Open Issues :
*Change history :
*@LastModifyDate : 2009.03.24
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.03.24 정윤태
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.fms.fmscommon.externalfinder.event.EsmFms0022Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmFms0022Event event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지

	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.hanjin.apps.Fmscommon.Externalfinder");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmFms0022Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		//초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		//GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
	}catch(Exception ex) {
		log.error("err " + ex.toString(), ex);
		//out.println(e.toString());
	}
%>
<html>
<head>
<title>Vessel Code</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body class="popup_bg" onLoad="setupPage();"> 
<form name="form"> 
<input type="hidden" name="f_cmd">
<input type="hidden" name="ibflag">
<input type="hidden" name="pagerows">
<input type="hidden" name="eff_dt">
<input type="hidden" name="exp_dt">
<input type="hidden" name="vndr_seq">

<!-- OUTER - POPUP (S)tart -->
<table width="500" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
    
        <!-- : ( Title ) (S) -->
        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
           <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Vessel Code</td></tr>
        </table>

        <!-- : ( Title ) (E) -->
        
        <!-- : ( Search Options ) (S) -->
 
            <table class="search"> 
            <tr><td class="bg">
                <!--  biz_1  (S) -->
                <table class="search" border="0" style="width:484;"> 
                <tr class="h23">
                    <td width="80">Vessel Code</td>
                    <td width="150"><input type="text" style="width:70;text-align:center;" class="input" required fullfill name="vsl_cd" maxlength="4" style="ime-mode:disabled"></td>
                    <td width="75">Vessel Name</td>
                    <td width="">&nbsp;<input type="text" style="width:150;" class="input" name="vsl_eng_nm" maxlength="50" required fullfill style="ime-mode:disabled"></td> 
                </tr>
                <tr class="h23">
                    <td width="">Carrier Code</td>
                    <td width=""><input type="text" style="width:70;text-align:center;" class="input" required fullfill name="crr_cd" maxlength="4" onblur="obj_deactivate();">&nbsp;<img src="img/btns_search.gif" name="btn_crr_cd" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
                    <td width="">Trunk / Off</td>
                    <td width="">&nbsp;<select style="width:100;" name="fdr_div_cd">
                        <option value=" " selected>All</option>
                        <option value="T">Trunk</option>
                        <option value="O">Off</option>
                        </select></td> 
                
                
                </table>
                <!--  biz_1  (E) -->
                <table class="height_8"><tr><td colspan="6"></td></tr></table>
                <!--  biz_2  (S) -->
                <!-- Grid  (S) -->
                    <table width="100%" class="search"  id="mainTable"> 
                        <tr>
                            <td width="100%">
                            <script language="javascript">ComSheetObject('sheet1');</script>
                            </td>
                        </tr>
                    </table> 
                        
                
                <!--  biz_2   (E) -->
                
                
            </td></tr>
        </table>
<!-- : ( Search Options ) (E) -->
	<table class="height_5"><tr><td></td></tr></table>
</td></tr>
</table> 
    
            </td></tr>
        </table>
    
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
    
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
        <tr><td class="btn3_bg">
            <table border="0" cellpadding="0" cellspacing="0">
            <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
                    <td class="btn1_right"></td>
                </tr></table></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_confirm">Confirm</td>
                    <td class="btn1_right"></td>
                </tr></table></td>
                  <td class="btn1_line"></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_close">Close</td>
                    <td class="btn1_right"></td>
                </tr></table></td>
                
            </tr>
        </table></td>
                
            </tr>
        </table>
    <!--Button (E) -->
    
    </td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
            

</form>         
</body>
</html>
<%@include file="/bizcommon/include/common_alps.jsp"%>