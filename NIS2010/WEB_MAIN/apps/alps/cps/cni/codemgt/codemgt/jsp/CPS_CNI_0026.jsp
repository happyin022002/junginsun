<%/*=========================================================
     *Copyright(c) 2009 CyberLogitec
     *@FileName : CPS_CNI_0026.jsp
     *@FileTitle : [CPS_CNI_0026] Main Code-Inquiry
     *Open Issues :
     *Change history :
     *@LastModifyDate : 2009.04.21
     *@LastModifier : 진윤오
     *@LastVersion : 1.0
     * 2009.04.17 진윤오
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
<%@page import="com.hanjin.apps.alps.cps.cni.codemgt.codemgt.event.CpsCni0026Event"%>
<%
	CpsCni0026Event event = null;
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
    
    Logger log = Logger.getLogger("com.hanjin.apps.alps.cps.cni.codemgt.CodeMgtSC");
    
    SignOnUserAccount account = null;
    try
    {
        account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        userId = account.getUsr_id();
        userName = account.getUsr_nm();
        userOffice = account.getOfc_cd();
        
        event = (CpsCni0026Event) request.getAttribute("Event");
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
    String clmPtyNo = JSPUtil.getParameter(request , "clm_pty_no" , "");
    
    
    String area =  CniUtil.getAreaInfo(account);
    
    
%>



<%@page import="com.hanjin.framework.component.util.StringUtil"%>
<%@page import="com.hanjin.apps.alps.cps.cni.common.CniUtil"%><html>
<head>
<title>Main Code-Inquiry</title>
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

<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd"> 
<input type="hidden" name="pagerows">

<!-- 개발자 작업 -->
<!-- PRINT  -->
<input type="hidden" name="com_mrdPath">
<input type="hidden" name="com_mrdArguments">
<input type="hidden" name="com_mrdTitle">
<input type="hidden" name="com_mrdBodyTitle">
<input type="hidden" name="usr_area" value="<%=area%>">
<input type="hidden" name="clm_pty_no" value="<%=clmPtyNo%>">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
<tr>
<td valign="top">

    <!--Page Title, Historical (S)-->
    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
        <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
    </table>
    <!--Page Title, Historical (E)-->
    
    
    <!--biz page (S)-->
        <!--Button (S) -->
        
        <!--Button (E) -->
        
        <!--biz page (S)-->
        
<table class="search" id="mainTable"> 
    <tr><td class="bg"> 
            <table class="search" border="0" style="width:979;"> 
            <tr class="h23">                
                <td width="35">Code</td>
                <td width="120"><input type="text" style="width:110;text-align: center;ime-mode:disabled;" name="clm_pty_abbr_nm" dataformat="engup" maxlength="8" value="" class="input"></td>
                <td width="40">Name</td>
                <td width="190"><input type="text" style="width:180;" name="pty_nm" value="" class="input" maxlength="100"></td>
                <td width="55">Register</td>
                <td width="90"><input type="text" style="width:80;" name="cre_usr_id" value="" class="input" maxlength="60"></td>
                <td width="45">RGOFC</td>
                <td width="90"><input type="text" style="width:80;ime-mode:disabled;text-align: center;" name="cre_ofc_cd" dataformat="engup" class="input" maxlength="20"></td>
                <td width="60">Location</td>
                <td width="100"><input type="text" style="width:70;text-align: center;ime-mode:disabled;" name="loc_cd"  dataformat="engup" maxlength="5" class="input">&nbsp;<img class="cursor" src="img/btns_search.gif" name="btns_location" width="19" height="20" border="0" align="absmiddle"></td>                
                <td width="" align="right">Deleted Code <input name="delt_flg" type="checkbox" value="Y" class="trans"></td>
            </tr>
            </table> 
            
            <table class="line_bluedot"><tr><td></td></tr></table>
            <!-- Grid  (S) -->
            <table width="100%"  id="mainTable"> 
                    <tr>
                        <td width="100%">
                            <script language="javascript">ComSheetObject('sheet1');</script>
                        </td>
                    </tr>
                    </table> 
            <!-- Grid (E) -->
            
            
            <table class="line_bluedot"><tr><td></td></tr></table> 
            
        <table class="search" border="0">
                <tr><td class="title_h"></td>
                    <td class="title_s">Comment</td></tr>
                </table>
                <table border="0" style="width:100%;" class="grid2"> 
                <tr>
                <td width=""><textarea style="width:100%;line-height: 16px" name="pty_rmk" rows="6"></textarea></td>
                </tr>
                </table> 
            </td>
            </tr>
            </table> 
            
  
            <!--Button (S) -->
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
        <tr><td class="btn1_bg">
            <table border="0" cellpadding="0" cellspacing="0">
            <tr>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn1_Retrieve">Retrieve</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn1_New">New</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                <td class="btn1_line"></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1_2" name="btn1_Detail">Detail</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                <td class="btn1_line"></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn1_Print">Print</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
            
            </tr>
            </table>
        </td></tr>
        </table>
    <!--Button (E) -->
            
        

    <!--biz page (E)-->
    
</td>
</tr>
</table>

<!-- 개발자 작업  끝 -->
</form>

</body>
</html>