<%/*=========================================================
     *Copyright(c) 2009 CyberLogitec
     *@FileName : CPS_GEM_0101.jsp
     *@FileTitle :  [CPS_GEM_0101] Authorized Expense Code
     *Open Issues :
     *Change history :
     *@LastModifyDate : 2009.04.21
     *@LastModifier : 진윤오
     *@LastVersion : 1.0
     * 2009.04.17 진윤오
     * 1.0 Creation
     =========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@page import="com.clt.apps.opus.cps.gem.gemcommon.gemmastercodemgt.event.CpsGem0007Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
    CpsGem0101Event event = null; //PDTO(Data Transfer Object including Parameters)
    Exception serverException = null; //서버에서 발생한 에러
    String strErrMsg = ""; //에러메세지
    int rowCount = 0; //DB ResultSet 리스트의 건수

    String successFlag = "";
    String codeList = "";
    String pageRows = "100";

    String strUsr_id = "";
    String strUsr_nm = "";
    Logger log = Logger.getLogger("com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.basic.GemPlanningPerformanceBC");

    try
    {
        SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();

        event = (CpsGem0101Event) request.getAttribute("Event");
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
    
    // 오피스 코드 
    String ofc_cd = JSPUtil.getParameter(request,"ofc_cd","");
    // 언어구분
    String lang_div = JSPUtil.getParameter(request,"lang_div","KOR");
    
    // 멀티 선택 여부(Y->멀티, N->싱글)
    String sel_div = JSPUtil.getParameter(request,"sel_div","");
    
    String usr_tic_cd = JSPUtil.getParameter(request,"usr_tic_cd","");
    
    //Expense Group Code
    String gen_expn_group_cd = JSPUtil.getParameter(request,"gen_expn_group_cd","");
%>


<%@page import="com.clt.apps.opus.cps.gem.gemplanningperformance.gemplanningperformance.event.CpsGem0101Event"%><html>
<head>
<title>Authorized Expense Code</title>
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

<body CLASS="popup_bg" onLoad="setupPage();">
<form name="form" method="post">
<input type="hidden" name="f_cmd"> 
<input type="hidden" name="pagerows"> 

<!-- 개발자 작업 -->
<input type="hidden" name="gw_subject"> 
<input type="hidden" name="gw_contents">
<input type="hidden" name="gw_args" value="email;">
<input type="hidden" name="lang_div" value="<%=lang_div%>">
<input type="hidden" name="sel_div" value="<%=sel_div%>">
<input type="hidden" name="usr_tic_cd" value="<%=usr_tic_cd%>">
<input type="hidden" name="gen_expn_group_cd" value="<%=gen_expn_group_cd%>">

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
    
        <!-- : ( Title ) (S) -->
        <table width="100%" border="0">
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Authorized Expense Code</td></tr>
        </table>
        <!-- : ( Title ) (E) -->
        
        <!--biz page (S)-->
        <table class="search" id="mainTable"> 
            <tr><td class="bg">
            
                <!--  biz_1  (S) -->
                <table class="search" border="0" style="width:100%;"> 
                <tr class="h23">
                    <td width="70">OFC Code</td>
                    <td width="80"><input type="text" style="width:60;text-align: center;" class="input2" readonly="readonly" name="ofc_cd" value="<%=ofc_cd%>"></td>
                    
                    <td width="90">Expense Code</td>
                    <td width="80"><input type="text" style="width:60;text-align: center;" class="input" maxlength="6" fullfill caption="Expense Code" name="gen_expn_cd"></td>
                    <td width="230">Expense Group&nbsp;
                    <script language="javascript">ComComboObject("combo1", 2, 70, 0, 0, 0, true);</script>                    
                    &nbsp;</td>
                    <td>TIC
&nbsp;<select style="width:80;" class="input" name="tic_cd" onchange="focusOut();">                        
                        </select></td>          
                </tr> 
                </table>                
                <!--  biz_1   (E) -->
                
                <table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
                
                <!-- Grid  (S) -->
                <table width="100%" id="mainTable"> 
                    <tr>
                        <td width="100%">
                            <script language="javascript">ComSheetObject('sheet1');</script>
                        </td>
                    </tr>
                </table>
                <!-- Grid (E) -->   
            
        </td></tr></table>
        <!--biz page (E)--> 

<table class="height_5"><tr><td></td></tr></table>

</td></tr></table>
    
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

        <!--Button (S) -->  
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
        <tr>
        
        <td class="btn3_bg">
            <table border="0" cellpadding="0" cellspacing="0">
            <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_Retrieve">Retrieve</td>
                    <td class="btn1_right"></td>
                </tr></table></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_Select">Select</td>
                    <td class="btn1_right"></td>
                </tr></table></td>  
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_RequestOfExpenseCode">Request for Expense Code</td>
                    <td class="btn1_right"></td>
                </tr></table></td>      
            <td class="btn1_line"></td>     
            <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_Close">Close</td>
                    <td class="btn1_right"></td>
                </tr></table></td>                
            </tr>
        </table>
        <!--Button (E) -->
    
		</td>
		
		</tr>
		</table>
		
</td>
</tr>
</table>		
<!-- : ( Button : pop ) (E) -->


 
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>