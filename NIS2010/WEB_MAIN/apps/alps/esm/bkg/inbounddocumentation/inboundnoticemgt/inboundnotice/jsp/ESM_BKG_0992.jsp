<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0992.jsp
*@FileTitle : Pickup No Notice Setup copy Popup
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.16
*@LastModifier : 박미옥
*@LastVersion : 1.0
* 2009.09.16 박미옥
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg0992Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0992Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.InboundBLMgt.PickUpNotice");

    String from_ofc_cd = "";
	String from_del_cd = "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

        from_ofc_cd = request.getParameter("from_ofc_cd");
        from_del_cd = request.getParameter("from_del_cd");

		event = (EsmBkg0992Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Pickup No Notice Setup copy Popup</title>
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

<input type="hidden" name="usr_id"    value="<%=strUsr_id%>" />
<input type="hidden" name="fm_ofc_cd" value="<%=from_ofc_cd%>" />
<input type="hidden" name="fm_del_cd" value="<%=from_del_cd%>" />

<!-- OUTER - POPUP (S)tart -->
<table width="500" class="popup" cellpadding="10" border="0"> 
    <tr><td class="top"></td></tr>
    <tr>
        <td valign="top">
    
            <!-- : ( Title ) (S) -->
            <table width="100%" border="0">
                <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle" />&nbsp;Pick up No Notice Setup copy</td></tr>
            </table>
            <!-- : ( Title ) (E) -->
                
            <!-- : ( Search Options ) (S) -->
            
            <table class="search"> 
                <tr>
                    <td class="bg">
                        <table class="search" border="0" style="width:100%;"> 
                            <tr class="h23">
                                <td width="50">EQ OFC</td>
                                <td width="100">
                                    <input type="text" style="width:60;ime-mode:disabled;" class="input1" name="ofc_cd" 
                                           caption="EQ Office" maxlength="5" minlength="5" dataformat="" required="" fullfill="fullfill" />
                                </td>
                                <td width="30">DEL</td>
                                <td width="">
                                    <input type="text" style="width:60;ime-mode:disabled;" class="input1" name="del_cd" value="" 
                                           caption="DEL Code" maxlength="5" minlength="3" dataformat="" />
                                </td>
                            </tr>
                        </table>
        
                    </td>
                </tr>
            </table>
            <!-- : ( Search Options ) (E) -->
        </td>
    </tr>
</table> 

<table class="height_5"><tr><td></td></tr></table>
    
    
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
    <tr>
        <td height="71" class="popup">
    
            <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
                <tr>
                    <td class="btn3_bg">
                        <table border="0" cellpadding="0" cellspacing="0">
                            <tr>
                                <td>
                                    <table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
                                        <tr>
                                            <td class="btn1_left"></td>
                                            <td class="btn1" name="btn_Copy">Copy</td>
                                            <td class="btn1_right"></td>
                                        </tr>
                                    </table>
                                </td>
                                <td class="btn1_line"></td>     
                                <td>
                                    <table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
                                        <tr>
                                            <td class="btn1_left"></td>
                                            <td class="btn1" name="btn_Close">Close</td>
                                            <td class="btn1_right"></td>
                                        </tr>
                                    </table>
                                </td>
                            </tr>
                        </table>
                        <!--Button (E) -->    
    
                    </td>               
                </tr>
            </table>

            <!--Grid (s)-->
            <table width="100%"  id="mainTable">
                <tr>
                    <td width="100%">
                        <script language="javascript">ComSheetObject('sheet1');</script>
                    </td>
                </tr>
            </table>
            <!--Grid (E)-->
        
        </td>
    </tr>
</table>    
<!-- : ( Button : pop ) (E) -->            

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
<%@include file="/bizcommon/include/common_nis2010.jsp"%>