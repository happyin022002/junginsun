<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0995.jsp
*@FileTitle : Pick up Notice Receiver Setup Pop-up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 박미옥
*@LastVersion : 1.0
* 2009.07.14 박미옥
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
<%@ page import="org.apache.log4j.Logger" %>

<%
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.InboundBlMgt.PickUpNotice");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Pick up Notice Receiver Setup Pop-up</title>
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

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->


<!-- OUTER - POPUP (S)tart -->
<table width="900" class="popup" cellpadding="10" border="0"> 
    <tr><td class="top"></td></tr>
    <tr>
        <td valign="top">
    
            <!-- : ( Title ) (S) -->
            <table width="100%" border="0">
                <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle" />&nbsp;Pick up Notice Receiver Setup </td></tr>
            </table>
            <!-- : ( Title ) (E) -->
        
            <!--biz page (S)-->
            <table class="search" id="mainTable"> 
                <tr>
                    <td class="bg">
                
                        <!--  biz_1  (S) -->
                        <table class="search" border="0" style="width:100%;"> 
                            <tr class="h23">
                                <td width="70">Form  Type</td>
                                <td width="">
                                    <select style="width:100;" name="fom_cd">
                                        <option value="EV1" selected="selected">Event#1</option>
                                        <option value="EV2">Event#2</option>
                                        <option value="EV3">Event#3</option>
                                    </select>
                                </td>                                                  
                            </tr> 
                        </table>                
                        <!--  biz_1   (E) -->
            
                        <table class="height_5"><tr><td></td></tr></table>
                        
                        <!-- Grid  (S) -->
                        <table width="100%"  id="mainTable"> 
                            <tr>
                                <td width="100%">
                                    <script language="javascript">ComSheetObject('sheet1');</script>
                                    <script language="javascript">ComSheetObject('sheet2');</script>
                                </td>
                            </tr>
                        </table>                
                        <!-- Grid (E) -->   
                
                    </td>
                </tr>
            </table>
            <!--biz page (E)--> 

        </td>
    </tr>
</table>

<table class="height_5"><tr><td></td></tr></table>
    
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
    <tr>
        <td height="71" class="popup">

            <!--Button (S) -->  
            <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
                <tr>
                    <td class="btn3_bg">
                        <table border="0" cellpadding="0" cellspacing="0">
                            <tr>
                                <td>
                                    <table width="" border="0" cellpadding="0" cellspacing="0" class="button">
                                        <tr>
                                            <td class="btn1_left"></td>
                                            <td class="btn1" name="btn_DownExcel">Down Excel</td>
                                            <td class="btn1_right"></td>
                                        </tr>
                                    </table>
                                </td>  
                        
                                <td>
                                    <table width="" border="0" cellpadding="0" cellspacing="0" class="button">
                                        <tr>
                                            <td class="btn1_left"></td>
                                            <td class="btn1" name="btn_LoadExcel">Upload Excel</td>
                                            <td class="btn1_right"></td>
                                        </tr>
                                    </table>
                                </td>  
                                <td>
                                    <table width="" border="0" cellpadding="0" cellspacing="0" class="button">
                                        <tr>
                                            <td class="btn1_left"></td>
                                            <td class="btn1" name="btn_Setup">Setup</td>
                                            <td class="btn1_right"></td>
                                        </tr>
                                    </table>
                                </td>  
                                <td class="btn1_line"></td> 
                                <td class="btn3_bg">
                                    <table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
                                        <tr>
                                            <td class="btn1_left"></td>
                                            <td class="btn1" name="btn_close">Close</td>
                                            <td class="btn1_right"></td>
                                        </tr>
                                    </table>
                                    <!--Button (E) -->
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>
            </table>
    
        </td>
    </tr>
</table>
<!-- : ( Button : pop ) (E) -->


<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
<%@include file="/bizcommon/include/common_nis2010.jsp"%>