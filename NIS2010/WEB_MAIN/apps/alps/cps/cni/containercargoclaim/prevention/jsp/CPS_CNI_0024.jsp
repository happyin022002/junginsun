<%/*=========================================================
     *Copyright(c) 2009 CyberLogitec
     *@FileName : CPS_CNI_0024.jsp
     *@FileTitle : [CPS_CNI_0024] Prevention-View
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
	CpsCni0023Event event = null;
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
        
        event = (CpsCni0023Event) request.getAttribute("Event");
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
    String sXml = HttpUtil.makeXML(request,response);
    String popupYn = JSPUtil.getParameter(request , "popupYn" , "N");
    String year = DateTime.getYear()+"";
    String clmPrveNo = JSPUtil.getParameter(request , "clm_prve_no" , "PRV"+year);
    // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
    GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
    String effDt = (String)eventResponse.getCustomData("eff_dt");
    String clmAreaCd = (String)eventResponse.getCustomData("clm_area_cd");
    // 사용자 roles
    String roles = CniUtil.getRoles(account);
    String area =  CniUtil.getAreaInfo(account);
    String ofcCd = account.getOfc_cd();
    
    
%>


<%@page import="com.hanjin.apps.alps.cps.gem.common.GemUtil"%>
<%@page import="com.hanjin.framework.component.util.StringUtil"%>
<%@page import="com.hanjin.framework.component.util.io.HttpUtil"%>
<%@page import="com.hanjin.apps.alps.cps.cni.containercargoclaim.prevention.event.CpsCni0023Event"%>
<%@page import="com.hanjin.apps.alps.cps.cni.common.CniUtil"%><html>
<head>
<title>Prevention-View</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="rpt/script/rdviewer50.js"></script>
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

<% if ("Y".equals(popupYn)) {%>
<body class="popup_bg" onLoad="setupPage();">        
<% } else { %>
<body  onLoad="setupPage();">         
<% } %>
<form name="form">
<input type="hidden" name="f_cmd"> 
<input type="hidden" name="pagerows">  
<input type="hidden" name="sXml" value="<%=sXml%>">
<input type="hidden" name="usr_id" value="<%=userId%>">
<input type="hidden" name="usr_roles" value="<%=roles%>">
<input type="hidden" name="usr_area" value="<%=area%>">
<input type="hidden" name="usr_office" value="<%=ofcCd%>">
<!-- PRINT  -->
<input type="hidden" name="com_mrdPath">
<input type="hidden" name="com_mrdArguments">
<input type="hidden" name="com_mrdTitle">
<input type="hidden" name="com_mrdBodyTitle">
<!-- 개발자 작업 -->

<input type="hidden" name="popupYn" value="<%=popupYn%>">

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
        <tr><td height="79" class="title"><img src="img/icon_title_dot.gif" align="absmiddle">  Prevention-View</td></tr>
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
                <td width="55">PRV No.</td>
                <td width="140"><input type="text" style="width:100;text-align: center;" fullfill dataformat="engup" required maxlength="11" name="clm_prve_no" caption="PRV No." value="<%=clmPrveNo%>" class="input1"></td>
                <td width="50">CLASS</td>
                <td width="220">                
                <input type="text" name="clm_prve_div_nm" style="width:180;" class="input2" readonly="readonly">
                </td>
                <td width="55">Effective</td>
                <td width="350"><input type="text" style="width:80;text-align: center;" name="eff_dt" class="input2" readonly="readonly">&nbsp;&nbsp;~&nbsp;
                <input type="text" style="width:80;text-align: center;" name="exp_dt" class="input2" readonly="readonly">&nbsp;</td>                
            </tr>
            <tr class="h23">
                <td width="">Register</td>
                <td width=""><input type="text" style="width:100;text-align: center;" name="cre_usr_id" class="input2"  readonly="readonly"></td>
                <td width="">Area</td>
                <td width=""><input type="text" style="width:25;text-align: center;" name="clm_area_cd" class="input2"  readonly="readonly"></td>
                <td width="">RGOFC</td>
                <td width="" colspan="2"><input type="text" style="width:70;text-align: center;" name="cre_ofc_cd" class="input2"  readonly="readonly"></td>
            </tr>
            <tr class="h23">
                <td>Subject</td>
                <td colspan="7" align="left"><input type="text" style="width:680;" maxlength="200" name="clm_prve_subj_nm" class="input2" readonly="readonly"></td>
            </tr>            
            </table> 
            
            <table class="line_bluedot"><tr><td></td></tr></table>
            <table border="0" style="width:100%; background-color:white;" class="grid2"> 
                <tr>
                    <td class="input2"><textarea style="width:100%" rows="15" name="clm_prve_desc" class="textarea2"></textarea></td>
                </tr>
            </table>
            
	        <table class="line_bluedot"><tr><td></td></tr></table> 
	            
	        <table class="search" border="0" style="width:100%;"> 
	            <tr class="h23">
	            <td width="100%">
	               <script language="javascript">ComSheetObject('sheet1');</script>
	            </td>
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
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn1_Print">Print</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>               
                <% if ("Y".equals(popupYn)) {%>
               <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn1_close">Close</td>
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

<form name="form1" method="post">
</form>
</body>
</html>