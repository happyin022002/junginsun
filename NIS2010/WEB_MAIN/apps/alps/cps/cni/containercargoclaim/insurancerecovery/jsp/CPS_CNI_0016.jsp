<%/*=========================================================
     *Copyright(c) 2009 CyberLogitec
     *@FileName : CPS_CNI_0016.jsp
     *@FileTitle : [CPS_CNI_0016] Insurance Recovery by VVD
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
<%@page import="com.hanjin.apps.alps.cps.cni.containercargoclaim.insurancerecovery.event.CpsCni0016Event"%>
<%
	CpsCni0016Event event = null;
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
        
        event = (CpsCni0016Event) request.getAttribute("Event");
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
    
    // vvd 
    String vvd = CniUtil.getVvd(account);
    if (vvd == null || vvd.trim().length() == 0) {
    	vvd = "";
    }

    if ("Y".equals(popupYn)) {
    	vvd = JSPUtil.getParameter(request , "trnk_ref_vvd_no" , "");		
    }
    
    // 사용자 roles
    String roles = CniUtil.getRoles(account);
    String area =  CniUtil.getAreaInfo(account);
    String ofcCd = account.getOfc_cd();
    
%>

<%@page import="com.hanjin.framework.component.util.StringUtil"%>
<%@page import="com.hanjin.framework.component.util.io.HttpUtil"%>
<%@page import="com.hanjin.apps.alps.cps.cni.common.CniUtil"%>
<html>
<head>
<title>Insurance Recovery by VVD</title>
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
<script language="javascript" src="rpt/script/rdviewer50.js"></script>
</head>
<% if ("Y".equals(popupYn)) {%>
<body class="popup_bg" onLoad="setupPage();">
<% } else { %>
<body onLoad="setupPage();">       
<% } %>      

<form name="form">
<input type="hidden" name="f_cmd"> 
<input type="hidden" name="pagerows">
<input type="hidden" name="insur_clm_pty_no">
<input type="hidden" name="usr_id" value="<%=userId%>">
<input type="hidden" name="usr_roles" value="<%=roles%>">
<input type="hidden" name="usr_area" value="<%=area%>">
<input type="hidden" name="usr_office" value="<%=ofcCd%>">
<!-- PRINT  -->
<input type="hidden" name="com_mrdPath">
<input type="hidden" name="com_mrdArguments">
<input type="hidden" name="com_mrdTitle">
<input type="hidden" name="com_mrdBodyTitle">
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
        <tr><td height="79" class="title"><img src="img/icon_title_dot.gif" align="absmiddle">  Insurance Recovery by VVD</td></tr>
        <% } else { %>
        <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>        
        <% } %>
    </table>
    <!--Page Title, Historical (E)-->
    
    
        <!--Button (S) -->
        
        <!--Button (E) -->
        
        <!--biz page (S)-->
        
    <table class="search" id="mainTable"> 
    <tr><td class="bg"> 
            
            <table class="search" border="0" style="width:979;"> 
            <tr class="h23">
                <td width="45">VVD</td>
                <td width="83"><input type="text" style="width:80;text-align: center;ime-mode:disabled;" dataformat="engup" required fullfill maxlength="9" caption="VVD" class="input1" name="trnk_ref_vvd_no" value="<%=vvd%>"></td>                
                <td width="70"><input type="text" style="width:60;text-align: center;ime-mode:disabled;" readonly="readonly" class="input2" name="insur_vsl_oshp_cd"></td>
                <td width="">
                        <table width="100" border="0" cellpadding="0" cellspacing="0" class="button">
                            <tr>
                                <td class="btn2_left"></td>
                                <td class="btn2_3" name="btn1_FileUpload">File Upload</td>
                                <td class="btn2_right"></td>
                            </tr>
                        </table>                
                </td>
                </tr>
            </table> 
            <table class="search" border="0" style="width:979;"> 
                <tr class="h23">
                <td width="45">Insurer</td>
                <td width="550"><input type="text" style="width:80;text-align: center;" name="insur_clm_pty_abbr_nm" readonly="readonly" class="input2">&nbsp;<input type="text" style="width:439;" name="insur_pty_nm" class="input2"></td>
                <td width="69">Policy Year</td>
                <td width="131"><input type="text" style="width:41;text-align: center;" name="insur_plcy_yr" readonly="readonly" class="input2"></td>
                <td width="70">Deductible</td>
                <td width=""><input type="text" style="width:80;text-align: right;" name="ddct_cgo_amt" caption="Deductible" readonly="readonly" class="input1">USD</td>
                </tr>
            </table> 
            <table class="height_8"><tr><td></td></tr></table>
    <!-- Grid  (S) -->
            <table width="100%"  id="mainTable"> 
                    <tr>
                        <td width="100%">
                            <script language="javascript">ComSheetObject('sheet1');</script>
                        </td>
                    </tr>
                    </table> 
    <!-- Grid  (E) -->
 
                        
        </td>
       </tr>
       </table> 
      <!-- 
      <table class="height_8"><tr><td></td></tr></table>
      <table class="search" id="mainTable"> 
       <tr>
       <td class="bg">
            <p style="padding: 0;margin: 0"><span style="font-weight: bold"><span style="color: red">NB :</span> 1. Insurance Recoverable Amount</span> : A portion of Net Paid Claim amount of  Settled Amount  deducted by Recovered Amount from LP (Liable Party) ,</p>
            <p style="padding-left: 249px;margin: 0">provided that it shall arise from covered risks and be recoverable from Insurer under the applicable policy.</p>
            <p style="padding-left: 27px;margin: 0"><span style="font-weight: bold">2. INS Claimed Amount</span> :  Net Paid Claim Amount  filed  with Insurer  for recovery exceeding  Deductible  under the applicable policy.</p>
       </td>
       </tr>
       </table> 
       -->

    <!--biz page (E)-->
    
</td>
</tr>
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
					<td class="btn1_right"></td>
				</tr></table></td>
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_New">New</td>
					<td class="btn1_right"></td>
				</tr></table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_Save">Save</td>
					<td class="btn1_right"></td>
				</tr></table></td>
                <td class="btn1_line"></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn1_Print">Print</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                 <% if ("Y".equals(popupYn)) {%>
                 <td class="btn1_lline"></td>
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