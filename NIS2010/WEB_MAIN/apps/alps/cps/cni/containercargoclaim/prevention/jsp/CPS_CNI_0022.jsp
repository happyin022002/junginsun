<%/*=========================================================
     *Copyright(c) 2009 CyberLogitec
     *@FileName : CPS_CNI_0022.jsp
     *@FileTitle : [CPS_CNI_0022] Prevention
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
	CpsCni0022Event event = null;
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
    
    Logger log = Logger.getLogger("com.hanjin.apps.alps.cps.cni.containercargoclaim.ContainerCargoClaimSC");
    SignOnUserAccount account = null;
    try
    {
        account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        userId = account.getUsr_id();
        userName = account.getUsr_nm();
        userOffice = account.getOfc_cd();
        
        event = (CpsCni0022Event) request.getAttribute("Event");
        serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null)
        {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

       

    }
    catch (Exception e)
    {
        out.println(e.toString());
    }
    
    
    // ----------------------------------------------------------------
    // 해당 초기 파라미터 설정
    // ----------------------------------------------------------------    
    String sXml = HttpUtil.makeXML(request,response);
    // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
    GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
    String cre_dt_start = (String)eventResponse.getCustomData("cre_dt_start");
    String cre_dt_end = (String)eventResponse.getCustomData("cre_dt_end");
    
    // 사용자 roles
    String roles = CniUtil.getRoles(account);
    String area =  CniUtil.getAreaInfo(account);
    String ofcCd = account.getOfc_cd();
%>


<%@page import="com.hanjin.apps.alps.cps.gem.common.GemUtil"%>
<%@page import="com.hanjin.framework.component.util.StringUtil"%>
<%@page import="com.hanjin.framework.component.util.io.HttpUtil"%>
<%@page import="com.hanjin.apps.alps.cps.cni.common.CniUtil"%>
<%@page import="com.hanjin.apps.alps.cps.cni.containercargoclaim.prevention.event.CpsCni0022Event"%><html>
<head>
<title>Prevention-Inquiry</title>
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
<input type="hidden" name="sXml" value="<%=sXml%>">
<input type="hidden" name="usr_id" value="<%=userId%>">
<input type="hidden" name="usr_roles" value="<%=roles%>">
<input type="hidden" name="usr_area" value="<%=area%>">
<input type="hidden" name="usr_office" value="<%=ofcCd%>">
<!-- 개발자 작업 -->
<input type="hidden" name="insur_clm_pty_no">
<input type="hidden" name="cgo_clm_sts_cd">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
<tr>
<td valign="top">

    <!--Page Title, Historical (S)-->
    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
        <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
    </table>
        <!--Page Title, Historical (E)-->
    
    
        <!--Button (S) -->
        
        <!--Button (E) -->
        
        <!--biz page (S)-->
         
<table class="search" id="mainTable"> 
    <tr><td class="bg"> 
            <table class="search" border="0" style="width:979;"> 
            <tr class="h23">
                <td width="205"><input type="text" name="cond_search_text" style="width:200;" value="" class="input"></td>
                <td width="100">
                    <table border="0" cellpadding="0" cellspacing="0" width="80"><tr>
                        <td><table width="80" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn2_left"></td>
                        <td class="btn2_3" name="btn2_Search">Search</td>
                        <td class="btn2_right"></td>
                        </tr>
                        </table></td>
                    </tr></table>
                </td>
                <td width="40">DORG</td>
                <td width="">                
                <input type="text" name="cre_dt_start" value="<%=cre_dt_start%>" caption="DORG" dataformat="ymd" required maxlength="8" style="ime-mode:disabled"  style="width: 80; text-align:center" class="input1">&nbsp;
                <img name="btns_cre_dt_start" class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">
                &nbsp;~&nbsp;
                <input type="text" name="cre_dt_end" value="<%=cre_dt_end%>" caption="DORG" dataformat="ymd" maxlength="8" style="ime-mode:disabled" required style="width: 80; text-align:center" class="input1">&nbsp;
                <img name="btns_cre_dt_end" class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">                                
                </td>                
                <!-- <td width="" align="right"><img class="cursor" src="img/btng_plus.gif" name="btng_plus" width="14" height="14" border="0" align="absmiddle">&nbsp;&nbsp;Register Prevention&nbsp;&nbsp;&nbsp;&nbsp;</td>  -->
            </tr>
            </table> 
            <table class="search" border="0" style="width:979;"> 
            <tr class="h23">
                <td width="50">CLASS</td>
                <td width="180">
                <script language="javascript">ComComboObject("combo1", 1, 151, 1);</script>
                <input type="hidden" name="clm_prve_div_cd">
                </td>
                <td width="55">PRV No.</td>
                <td width="150">                
                <input type="text" name="clm_prve_no" style="width:120;text-align: center;" class="input">                      
                </td>
                <td width="35">Area</td>
                <td width="100">                
                <select style="width:60;" name="clm_area_cd"></select>
                </td>
                <td width="45s">RGOFC</td>
                <td width="130"><input type="text" name="cre_ofc_cd" style="width:80;" value=" " class="input"></td>
                <td width="55s">Register</td>
                <td width=""><input type="text" name="cre_usr_id" style="width:80;" value=" " class="input"></td>
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
        <table border="0" style="width:100%; background-color:white;" class="grid2"> 
                <tr>
                    <td class="input2"><textarea style="width:100%" name="clm_prve_desc" rows="12" class="textarea"> 
                                       </textarea></td>
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
                <% if (!CniUtil.equalsRole(account , "CNI49")) { %>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn1_Delete">Delete</td>
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
</body>
</html>