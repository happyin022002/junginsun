<%
/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ESM_PRI_8106.jsp
*@FileTitle : Remark Text Edit Popup
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.26
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2013.04.10 송호진
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
    String strOfc_cd        = "";
    String rmk_text         = "";
    String edit_flag        = "";
    
	Logger log = Logger.getLogger("com.hanjin.apps.SpecialCargoQuotation.ScqAwkward");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
        strOfc_cd = account.getOfc_cd();


		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		rmk_text = JSPUtil.getParameter(request, "rmk_text" );
		edit_flag = JSPUtil.getParameter(request, "edit_flag" );

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
<title>Remark Text <%=(edit_flag.equals("Y")?"Edit":"View")%> Popup</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	var rmk_text = "<%=rmk_text%>";
	var edit_flag = "<%=edit_flag%>";
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
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->


<table width="100%" class="popup" border="0" cellpadding="0" cellspacing="0" style="padding-top:10;padding-left:5;padding-right:5;">
    <tr><td class="top"></td></tr>
    <tr><td valign="top">
    <!--Page Title, Historical (S)-->
        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
        	<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Remark Text <%=(edit_flag.equals("Y")?"Edit":"View")%></td></tr>
        </table>
    <!--Page Title, Historical (E)-->


    <!--biz page (S)-->

    <!--  biz_1   (E) -->
    <table class="height_8"><tr><td></td></tr></table>

    <table class="search" >
        <tr><td class="bg">

    <table class="search" border="0" style="width:100%;">
        <tr class="h23">
        <td width="25%" valign="top">
            <table width="100%"  id="mainTable" >
                <tr>
                    <td width="100%" height="10px">
                        &nbsp;
                    </td>
                </tr>
                <tr>
                    <td width="100%">
                        <textarea name="ta_rmk" class="textarea" style="width:100%;height:300;ime-mode:inactive"></textarea>
                    </td>
                </tr>
            </table>
        </td>


        </tr>
        </table>

            <!--  biz_2   (E) -->

            </td>
            </tr>
            </table>

<table class="height_5"><tr><td></td></tr></table>
        
        </td>
            </tr>
        </table>    
        
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">        
            <!--Button (S) -->
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
        <tr><td class="btn3_bg">
            <table border="0" cellpadding="0" cellspacing="0">
            <tr>
                <td id="btn_ok_td" ><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_ok" id="btn_close">Ok</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table>
            </td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_close" id="btn_close">Close</td>
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
<!-- : ( Button : pop ) (E) -->
            


    <!--biz page (E)-->



<!-- 개발자 작업  끝 -->
</form>
</body>
</html>