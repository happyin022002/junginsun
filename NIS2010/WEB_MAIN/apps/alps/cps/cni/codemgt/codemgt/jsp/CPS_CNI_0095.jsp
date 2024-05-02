<%/*=========================================================
     *Copyright(c) 2009 CyberLogitec
     *@FileName : CPS_CNI_0095.jsp
     *@FileTitle : [CPS_CNI_0095] Main Code-Popup
     *Open Issues :
     *Change history :
     *@LastModifyDate : 2010.12.03
     *@LastModifier : 이준범
     *@LastVersion : 1.0
     * 2010.12.03 이준범
     * 1.0 Creation
     * -----------------------------------------------------------------
     * History
     * 2010.12.10 이준범 [CHM-201007236-01]
     * 1.제목 : CNI Main Code Creation Logic 보완 및 Popup 화면 추가 요청
     * 2.처리내역
     *  2.1 Main code creation시 Code 생성 규칙에 따른 중복 유사 Code를 검색하여 
     *      그 결과를 Popup display하며 User의 선택에  따라 생성 또는 Detail 
     *      information을 확인할 수 있는 Main Code View 화면으로 이동하도록 보완 
     =========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@ page import="com.hanjin.apps.alps.cps.cni.codemgt.codemgt.event.CpsCni0095Event"%>
<%
	CpsCni0095Event event = null;
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
    String clmPtyAbbrNm= "";
    String ptyNm = "";
    
    Logger log = Logger.getLogger("com.hanjin.apps.alps.cps.cni.codemgt.CodeMgtSC");
    
    
    try
    {
        SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        userId = account.getUsr_id();
        userName = account.getUsr_nm();
        userOffice = account.getOfc_cd();
        
        event = (CpsCni0095Event) request.getAttribute("Event");
        serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null)
        {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

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
    // claim party no    
    clmPtyAbbrNm = JSPUtil.getParameter(request , "clm_pty_abbr_nm" , "");
    ptyNm        = JSPUtil.getParameter(request , "pty_nm" , "");
    
%>


<%@page import="com.hanjin.apps.alps.cps.gem.common.GemUtil"%>
<%@page import="com.hanjin.framework.component.util.StringUtil"%><html>
<head>
<title>Main Code- Popup</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<script language="javascript">
	function setupPage(year){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		
		loadPage(year);
	}
</script>
<script language="javascript" src="rpt/script/rdviewer50.js"></script>
</head>

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd"> 
<input type="hidden" name="pagerows">

<!-- 개발자 작업 -->
<!-- PRINT  -->
<input type="hidden" name="com_mrdPath">
<input type="hidden" name="com_mrdArguments">
<input type="hidden" name="com_mrdTitle">
<input type="hidden" name="com_mrdBodyTitle">

<input type="hidden" name="clm_pty_abbr_nm" value="<%=clmPtyAbbrNm%>">

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
    
        <!-- : ( Title ) (S) -->
        <table width="100%" border="0">
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Main Code- Popup</td></tr>
        </table>
        <!-- : ( Title ) (E) -->
        
        <!-- : ( Search Options ) (S) -->
 
            <table class="search"> 
            <tr><td class="bg">
                <table class="search" border="0" style="width:100%;"> 
                <tr class="h23">
                    <td width="40">Name</td>
                    <td><input type="text" style="width:180;" name="pty_nm" value="<%=ptyNm%>" class="input2" readonly="readonly" maxlength="100"></td>
                </tr>
                </table>
           
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
                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn2_left"></td>
                        <td class="btn2" name="btn2_Save">Save</td>
                        <td class="btn2_right"></td>
                        </tr>
                        </table></td> 
                    </tr></table>
            </td></tr>
            </table>
            <!-- Button_Sub (E) -->
            </td></tr>
        </table>
<!-- : ( Search Options ) (E) -->
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

</body>
</html>