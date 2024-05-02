<%/*=========================================================
     *Copyright(c) 2009 CyberLogitec
     *@FileName : CPS_CNI_0001.jsp
     *@FileTitle : [CPS_CNI_0001] Client Default Setup
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

<%
	CpsCni0001Event event = null;
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
    String clmAreaCd = "";
    try
    {
        SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        userId = account.getUsr_id();
        userName = account.getUsr_nm();
        userOffice = account.getOfc_cd();
        
        event = (CpsCni0001Event) request.getAttribute("Event");
        serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null)
        {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        clmAreaCd = (String)eventResponse.getCustomData("clmAreaCd");
        
    }
    catch (Exception e)
    {
        out.println(e.toString());
    }
    
    
    // ----------------------------------------------------------------
    // 해당 초기 파라미터 설정
    // ----------------------------------------------------------------    
    String popupYn = JSPUtil.getParameter(request , "popupYn" , "N");
    
    String sXml = HttpUtil.makeXML(request,response);
%>

<%@page import="com.hanjin.framework.component.util.StringUtil"%>
<%@page import="com.hanjin.framework.component.util.io.HttpUtil"%>
<%@page import="com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.event.CpsCni0001Event"%><html>
<head>
<title>Main Code-View</title>
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

<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd"> 
<input type="hidden" name="pagerows">  

<!-- 개발자 작업 -->
<input type="hidden" name="sXml" value="<%=sXml%>">
<input type="hidden" name="popupYn" value="<%=popupYn%>">
<input type="hidden" name="clmAreaCd" value="<%=clmAreaCd%>">


<!-- Mdm code hidden key -->
<input type="hidden" name="vndr_seq">
        <% if ("Y".equals(popupYn)) {%>
        <table width="100%" class="popup" cellpadding="10" border="0"> 
        <tr><td class="top"></td></tr>
       <% } else { %>
		<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">		
        <% } %>            
<tr>
<td valign="top">
    <!--Page Title, Historical (S)-->
    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
        <% if ("Y".equals(popupYn)) { %>
        <tr><td height="79" class="title"><img src="img/icon_title_dot.gif" align="absmiddle">  Client Default Setup</td></tr>
        <% } else { %>
        <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>        
        <% } %>
        
    </table>
    <!--Page Title, Historical (E)-->    
    
    <!--biz page (S)-->
        <!--Button (E) -->
        
        <!--biz page (S)-->
        
    <table class="search" id="mainTable"> 
    <tr><td class="bg"> 
            <table class="search" border="0" style="width:100%;"> 
            <tr class="h23">
                <td width="100">Handling Office </td>
                <td width=""><input type="text" name="ofc_cd" style="width:60;text-align: center;" value="<%=userOffice%>" readonly="readonly" class="input2"></td>
            </tr>
            <tr class="h23">
                <td width="">Area</td>
                <td width=""><select style="width:60;" name="clm_area_cd" onchange="onchangeClmAreaCd()"></select>                       
                       &nbsp;<input type="text" style="width:180;" name="clm_area_nm" readonly="readonly" class="input2"></td>
            </tr>
            </table> 
            
        <!--biz page (E)--> 

            </td></tr>
        </table>

    <!--Button (S) -->
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
        <tr><td class="btn1_bg">
            <table border="0" cellpadding="0" cellspacing="0">
            <tr>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn1_Save">Save</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td> 
                <% if ("Y".equals(popupYn)) {%>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn1_Close">Close</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>          
                <% } %>      
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
<div style="display: none;"><script language="javascript">ComSheetObject('sheet1');</script></div>
</body>

</html>