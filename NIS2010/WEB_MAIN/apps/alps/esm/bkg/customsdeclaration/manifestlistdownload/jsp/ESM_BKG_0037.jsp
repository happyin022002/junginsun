<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0037.jsp
*@FileTitle : B/L Inquiry: Container Information
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.02
*@LastModifier : 이수빈
*@LastVersion : 1.0
* 2009.07.02 이수빈
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.event.EsmBkg0037Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	EsmBkg0037Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strCntCd			= "";
    String strBlNo         = "";
    String strTrnkBdrFlg   = "";
    
	Logger log = Logger.getLogger("com.hanjin.apps.CustomsDeclaration.ManifestListDownload");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmBkg0037Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		strCntCd = JSPUtil.getNullNoTrim(request.getParameter("cnt_cd"));
		strBlNo  = JSPUtil.getNullNoTrim(request.getParameter("bl_no"));
        strTrnkBdrFlg = JSPUtil.getNullNoTrim(request.getParameter("trnk_bdr_flg"));
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>B/L Inquiry: Container Information</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body class="popup_bg" onLoad="javascript:setupPage();">
<form name="form" method="post">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="cnt_cd" value="<%="".equals(strCntCd) ? "US" : strCntCd%>">
<input type="hidden" name="trnk_bdr_flg" value="<%=strTrnkBdrFlg%>">
<input type="hidden" name="sheet_id">
<input type="hidden" name="cn_flg" value="Y">

<!-- 개발자 작업	-->


<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
    
        <!-- : ( Title ) (S) -->
        <table width="100%" border="0">
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;B/L Inquiry: Container Information</td></tr>
        </table>
        <!-- : ( Title ) (E) -->
        
        <!-- : ( Search Options ) (S) -->
        <!--biz page-1 (S)-->
        <table class="search"> 
        <tr><td class="bg">
                
                <table class="search" border="0" style="width:579;"> 
                    <tr class="h23">
                        <td width="60">B/L No.</td>
                        <td width=""><input type="text" name="bl_no" class="input1" style="width:100;" 
                            dataformat="eng" maxlength="12" required caption="B/L No." value="<%=strBlNo%>">
                        </td>
                    </tr>
                </table>
                <!-- : ( Grid ) (S) -->
                <table width="100%"  id="mainTable"> 
                    <tr>
                        <td width="100%">
                            <script language="javascript">ComSheetObject('sheet1');</script>
                        </td>
                    </tr>
                </table>                
                <!-- : ( Grid ) (E) --> 
                
                <!--  Button_Sub (S) -->
	            <table width="100%" class="button"> 
	            <tr><td class="btn2_bg">
	                <table border="0" cellpadding="0" cellspacing="0"><tr>
	                        
	                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
	                        <tr><td class="btn2_left"></td>
	                        <td class="btn2" name="btn_add">Row Add</td>
	                        <td class="btn2_right"></td>
	                        </tr>
	                        </table></td>
	                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
	                        <tr><td class="btn2_left"></td>
	                        <td class="btn2" name="btn_del">Row Delete</td>
	                        <td class="btn2_right"></td>
	                        </tr>
	                        </table></td>
	                    </tr></table>
	            </td></tr>
	            </table>
	            <!-- Button_Sub (E) -->
	            
                <!-- : ( Grid ) (S) -->
                <table width="100%"  id="mainTable"> 
                    <tr>
                        <td width="100%">
                            <script language="javascript">ComSheetObject('sheet2');</script>
                        </td>
                    </tr>
                </table>     
                <table width="100%"  id="mainTable"> 
                    <tr>
                        <td width="100%">
                            <script language="javascript">ComSheetObject('sheet3');</script>
                        </td>
                    </tr>
                </table>                           
                <!-- : ( Grid ) (E) --> 
	            
            </td></tr>
        </table>       
        <!-- : ( Search Options ) (E) -->
<table class="height_5"><tr><td></td></tr></table>
        
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
                    <td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
                    <td class="btn1_right">
                </tr></table></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_save">Save</td>
                    <td class="btn1_right">
                </tr></table></td>
                <td class="btn1_line">
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_close">Close</td>
                    <td class="btn1_right">
                </tr></table></td>
            </tr>
            </table>
        </td></tr>
        </table>
    
    </td></tr>
</table>
<!-- : ( Button : pop ) (E) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
