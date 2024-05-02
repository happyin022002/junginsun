<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_JOO_0082.jsp
*@FileTitle : [FNS_JOO_0082] File Upload
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.08
*@LastModifier : 이준범
*@LastVersion : 1.0
* 2010.11.08 이준범
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@page import="com.hanjin.apps.alps.fns.joo.joocommon.joofileupload.event.FnsJoo0082Event"%>
<%@page import="com.hanjin.framework.component.util.StringUtil"%>
<%
	FnsJoo0082Event event = null;
    Exception serverException = null;
    String strErrMsg = "";
    int rowCount = 0; 

    String successFlag = "";
    String codeList = "";
    String pageRows = "100";

    String userId = "";
    String userName = "";
    String userOffice = "";
    String userArea = "";
    String joCrrCd = "";
    String crrCntcSeq  = "";
    String editAble = "";
    
    Logger log = Logger.getLogger("com.hanjin.apps.alps.fns.joo.joocommon.JOOCommonSC");
    
    try
    {
        SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        userId = account.getUsr_id();
        userName = account.getUsr_nm();
        userOffice = account.getOfc_cd();
        
        event = (FnsJoo0082Event) request.getAttribute("Event");
        serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null)
        {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        joCrrCd     = JSPUtil.getParameter(request , "jo_crr_cd" , "");
        crrCntcSeq  = JSPUtil.getParameter(request , "crr_cntc_seq" , "");
        editAble    = JSPUtil.getParameter(request , "edit_able" , "");
        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

    }
    catch (Exception e)
    {
        out.println(e.toString());
    }
    
    
    // ----------------------------------------------------------------
    // 해당 초기 파라미터 설정
    // ----------------------------------------------------------------    
    // clm_file_tp_cd  (UI번호(4) + fileupload 일련번호  000501 , 000502)   
%>


<html>
<head>
<title>File Upload</title>
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

<body  class="popup_bg" onLoad="javascript:setupPage();" >
<form name="form">
<input type="hidden" name="f_cmd"> 
<input type="hidden" name="pagerows">

<!-- 개발자 작업 -->
<input type="hidden" name="jo_crr_cd" value="<%=joCrrCd%>">
<input type="hidden" name="crr_cntc_seq" value="<%=crrCntcSeq%>">


<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
    
        <!-- : ( Title ) (S) -->
        <table width="100%" border="0">
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp; File Upload</td></tr>
        </table>
        <!-- : ( Title ) (E) -->
        
        <!-- : ( Search Options ) (S) -->
        <table class="search"> 
            <tr><td class="bg">
            
         <!-- Grid  (S) -->
            <table width="100%"  id="mainTable"> 
                <tr>
                    <td width="100%">
                        <script language="javascript">ComSheetObject('sheet1');</script>
                    </td>
                </tr>
            </table> 
            <!-- Grid (E) -->
            
            <!--  Button_Sub (S) -->
            <table width="100%" class="button"> 
            <tr><td class="btn2_bg">
                <table border="0" cellpadding="0" cellspacing="0"><tr>
<%if ("Y".equals(editAble)) {%>  
                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn2_left"></td>
                        <td class="btn2" name="btn2_Row_Add">Row Add</td>
                        <td class="btn2_right"></td>
                        </tr>
                        </table></td>
                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn2_left"></td>
                        <td class="btn2" name="btn2_Row_Delete">Row Delete</td>
                        <td class="btn2_right"></td>
                        </tr>
                        </table></td>
                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn2_left"></td>
                        <td class="btn2" name="btn2_Save">Save</td>
                        <td class="btn2_right"></td>
                        </tr>
                        </table></td> 
<%} %>	                                                                       
                    </tr></table>
            </td></tr>
            </table>
            <!-- Button_Sub (E) -->
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
            <tr>
            <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn1_Close">Close</td>
                    <td class="btn1_right"></td>
                </tr></table></td>
            </tr>
        </table>
    <!--Button (E) -->
    
    </td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
</td></tr>
</table>
<!-- 개발자 작업  끝 -->
</form>
<script language="javascript">ComUploadObject('upload1', '<=session.getId()%>');</script>
<form name="form1" method="post">
</form>
</body>
</html>