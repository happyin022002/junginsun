<%/*=========================================================
     *Copyright(c) 2009 CyberLogitec
     *@FileName : CPS_CNI_0027.jsp
     *@FileTitle : [CPS_CNI_0025] Main Code-View
     *Open Issues :
     *Change history :
     *@LastModifyDate : 2009.04.21
     *@LastModifier : 진윤오
     *@LastVersion : 1.0
     * 2009.04.17 진윤오
     * 1.0 Creation
     * 2010.07.01 윤진영 CHM-201004242 Refund/Vndr Code 화면에 조회 되로록 UI 변경     
     =========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@page import="com.hanjin.apps.alps.cps.cni.codemgt.codemgt.event.CpsCni0025Event"%>
<%
	CpsCni0025Event event = null;
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

    try
    {
        SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        userId = account.getUsr_id();
        userName = account.getUsr_nm();
        userOffice = account.getOfc_cd();
        
        event = (CpsCni0025Event) request.getAttribute("Event");
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
    String popupYn = JSPUtil.getParameter(request , "popupYn" , "N");
    
    // claim party no    
    String clmPtyNo = JSPUtil.getParameter(request , "clm_pty_no" , "");
    
%>


<%@page import="com.hanjin.apps.alps.cps.gem.common.GemUtil"%>
<%@page import="com.hanjin.framework.component.util.StringUtil"%>
<%@page import="com.hanjin.framework.component.util.io.HttpUtil"%><html>
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

        <% if ("Y".equals(popupYn)) {%>
<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd"> 
<input type="hidden" name="pagerows">  

<!-- 개발자 작업 -->
<input type="hidden" name="clm_pty_no" value="<%=clmPtyNo%>">
<input type="hidden" name="popupYn" value="<%=popupYn%>">
<input type="hidden" name="prnt_clm_pty_no">
<input type="hidden" name="clm_pty_clr_no">
<!-- Mdm code hidden key -->
<input type="hidden" name="vndr_seq">
        <table width="100%" class="popup" cellpadding="10" border="0"> 
        <tr><td class="top"></td></tr>
       <% } else { %>
  
<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd"> 
<input type="hidden" name="pagerows">  

<!-- 개발자 작업 -->
<input type="hidden" name="clm_pty_no" value="<%=clmPtyNo%>">
<input type="hidden" name="popupYn" value="<%=popupYn%>">
<input type="hidden" name="prnt_clm_pty_no">
<input type="hidden" name="clm_pty_clr_no">
<!-- Mdm code hidden key -->
<input type="hidden" name="vndr_seq">
		<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">		
        <% } %>            
<tr>
<td valign="top">
    <!--Page Title, Historical (S)-->
    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
        <% if ("Y".equals(popupYn)) { %>
        <tr><td height="79" class="title"><img src="img/icon_title_dot.gif" align="absmiddle">  Main Code-View</td></tr>
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
            <table class="search" border="0" style="width:979;"> 
            <tr class="h23">
                <td width="67"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn2_left"></td>
                        <td class="btn2_3" name="btn1_Code" style="text-align: center;">Code</td>
                        <td class="btn2_right"></td>
                        </tr>
                        </table></td>
                <td width="150"><input name="clm_pty_abbr_nm" type="text" style="width:142;" readonly="readonly" value="" class="input1"></td>
                <td width="40">Delete</td>
                <td width="110"><input type="radio" name="delt_flg" value="N" checked="checked" class="trans" disabled="disabled">No
                <input type="radio" name="delt_flg" value="Y" class="trans" disabled="disabled">Yes
                </td>
                <td width="50">Register</td>
                <td width="90"><input type="text" name="cre_usr_id" style="width:80;text-align: center;" readonly="readonly"  class="input2"></td>
                <td width="42">RGOFC</td>
                <td width="90"><input type="text" name="cre_ofc_cd" style="width:80;text-align: center;" readonly="readonly"  class="input2"></td>
                <td width="30">Area</td>
                <td width="60"><input type="text" name="clm_area_cd" style="width:50;text-align: center;" readonly="readonly" class="input2"></td>
                <td width="50">Update</td>
                <td width=""><input type="text" name="upd_dt" style="width:80;text-align: center;" readonly="readonly" value="" class="input2"></td>
            </tr></table>
            
            <table class="search" border="0" style="width:979;"> 
            <tr class="h23">
                <td width="130">Same Code Mapping</td>
                <td width="85">
                <input type="text" name="clm_pty_clr_cd" style="width:80;text-align: center;" readonly="readonly" value="" class="input2">                
                </td>                
                <td width="128">MDM Code Mapping</td>
                <td width="410"><input type="text" name="cnt_cd" style="width:25;text-align: center;" readonly="readonly" value="" class="input2">&nbsp;<input type="text" name="cust_seq" style="width:80;text-align: center;" readonly="readonly" value="" class="input2">&nbsp;<input type="text" name="cust_nm" style="width:280;text-align: left;" readonly="readonly" value="" class="input2"></td>
                <td width="120">Refund/Vndr Code</td>
                <td width=""><input type="text" name="tpb_cd" style="width:80;text-align: center;" readonly="readonly" value="" class="input2"></td>
            </tr></table>            
            
            <table class="line_bluedot"><tr><td></td></tr></table>
            <table class="search" border="0" style="width:979;">
            <tr class="h23">
                <td width="67">Name</td>
                <td width="360"><input type="text" name="pty_nm" dataformat="engup" required caption="Name" style="width:339;" value="" readonly="readonly" class="input2" maxlength="200"></td>
                <td width="70">Location</td>
                <td width="80"><input type="text" name="loc_cd" required caption="Location" style="width:50;text-align: center;" value="" readonly="readonly" class="input2" maxlength="5"></td>
                <td width="40">Principal</td>
                <td width=""><input type="text" name="prnt_clm_pty_abbr_nm" caption="Principal" style="width:110;text-align: center;" value="" readonly="readonly" class="input2"></td>
            </tr>
            </table>
            
            <table class="search" border="0" style="width:979;"> 
            <tr class="h23">
                <td width="67">Tel.</td>
                <td width="170">
                <input type="text" name="intl_phn_no" required caption="Tel" style="width:30;ime-mode:disabled;text-align: center;" value="" readonly="readonly" class="input2" maxlength="4" dataformat="number">
                <input type="text" name="phn_no" required caption="Tel" style="width:110;ime-mode:disabled;" value="" readonly="readonly" class="input2" maxlength="50"></td>
                <td width="25">Fax</td>
                <td width="165">
                <input type="text" name="intl_fax_no" style="width:30;ime-mode:disabled;text-align: center;" value="" readonly="readonly" class="input2" maxlength="4" dataformat="number">
                <input type="text" name="fax_no" style="width:110;ime-mode:disabled;" value="" readonly="readonly" class="input2" maxlength="50"></td>
                <td width="70">Address</td>
                <td width="" ><input type="text" dataformat="engup" name="pty_addr" style="width:380" value="" readonly="readonly" class="input2" maxlength="100"></td>
            </tr>
            <tr class="h23">
                <td width="">E-Mail</td>
                <td width="" colspan="3"><input name="pty_eml"  type="text" style="width:339;ime-mode:disabled;" value="" readonly="readonly" class="input2"  maxlength="200"></td>
                <td width="70">ZIP/Postal</td>
                <td width="" ><input type="text" name="zip_cd_ctnt" style="width:120;text-align: center;ime-mode:disabled;" value="" readonly="readonly" class="input2"  maxlength="100"></td>            </tr>
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
            <!--  Button_Sub (S) -->
             
            <table class="line_bluedot"><tr><td></td></tr></table> 
            
            <table class="search" border="0">
            <tr><td class="title_h"></td>
                <td class="title_s">Comment</td></tr>
            </table>
            <table border="0" style="width:100%;" class="grid2"> 
            <tr>
            <td width=""><textarea style="width:100%" rows="4" name="pty_rmk" caption="Comment" maxlength="4000" disabled="disabled"></textarea></td>
            </tr>
            </table>             
            
            <!-- Button_Sub (E) -->
            </td>
            </tr>
            </table> 
            
 
</td></tr>
</table>
 

<% if ("Y".equals(popupYn)) {%>
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
<% } %>

		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
       	<tr><% if ("Y".equals(popupYn)) {%><td class="btn3_bg"><% }else{ %><td class="btn1_bg"><%}%>
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_Retrieve">Retrieve</td>
					<td class="btn1_right">
				</tr></table></td>
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_New">New</td>
					<td class="btn1_right">
				</tr></table></td>
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

<% if ("Y".equals(popupYn)) {%>
</tr>
</table>
<% } %>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>