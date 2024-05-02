<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1065.jsp
*@FileTitle : Rail Data Setup Pop-up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.28
*@LastModifier : 박미옥
*@LastVersion : 1.0
* 2009.10.28 박미옥
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
<title>Rail Data Setup Pop-up</title>
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

<body class="popup_bg"  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->


<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
    <tr><td class="top"></td></tr>
    <tr>
        <td valign="top">
    
            <!-- : ( Title ) (S) -->
            <table width="100%" border="0">
                <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle" />&nbsp;Rail Data Setup </td></tr>
            </table>
            <!-- : ( Title ) (E) -->
        
            <!--biz page (S)-->
            <table class="search" id="mainTable"> 
                <tr>
                    <td class="bg">
                
                    
                        <table class="search" width="100%"> 
                            <tr class="h23">
                                <td width="55">AVL DT</td>
                                <td width="">
                                    <input type="text" style="width:80;text-align:center;" class="input" dataformat="ymd" maxlength="10" 
                                                       caption="AVL DT" name="avl_dt" />&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="img_avl_dt" />
                                </td>
                            </tr>
                            <tr class="h23">
                                <td width="">FRE  DT</td>
                                <td width="">
                                    <input type="text" style="width:80;text-align:center;" class="input" dataformat="ymd" maxlength="10" 
                                                       caption="FRE DT" name="fre_dt" />&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="img_fre_dt" />
                                </td>
                            </tr>
                            <tr class="h23">
                                <td width="">PICK YD</td>
                                <td width="">
                                    <input type="text" style="width:80;text-align:center;ime-mode:disabled;" class="input" name="pkup_yd_cd" 
                                        caption="PICK YD" maxlength="7" minlength="7" dataformat="" fullfill="true" />
                                </td>
                            </tr>
                            <tr class="h23">
                                <td width="">RTN YD</td>
                                <td width="">
                                    <input type="text" style="width:80;text-align:center;ime-mode:disabled;" class="input" name="rtn_yd_cd" 
                                        caption="RTN YD" maxlength="7" minlength="7" dataformat="" fullfill="true" />
                                </td>
                            </tr>
                        </table>        
                        
                
                    </td>
                </tr>
            </table>
            <!--biz page (E)--> 

        </td>
    </tr>
</table>
    
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
                                    <table border="0" cellpadding="0" cellspacing="0">
                                        <tr>
                                            <td class="btn1_left"></td>
                                            <td class="btn1" name="btn_Setup">Setup</td>
                                            <td class="btn1_right"></td>
                                        </tr>
                                    </table>
                                </td>
                                <td class="btn1_line"></td>
                                <td> 
                                    <table border="0" cellpadding="0" cellspacing="0">
                                        <tr>
                                            <td class="btn1_left"></td>
                                            <td class="btn1" name="btn_Close">Close</td>
                                            <td class="btn1_right"></td>
                                        </tr>
                                    </table>
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