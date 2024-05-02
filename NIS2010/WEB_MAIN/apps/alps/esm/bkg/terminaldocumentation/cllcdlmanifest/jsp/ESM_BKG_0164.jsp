<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0164.jsp
*@FileTitle : Container Loading/Discharging Cross-Check
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.29
*@LastModifier : 이수빈
*@LastVersion : 1.0
* 2009.09.29 이수빈
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.event.EsmBkg0164Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0164Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.TerminalDocumentation.CLLCDLManifest");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0164Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Container Loading/Discharging Cross-Check</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="inc_mty" value="N">

<!-- 개발자 작업 -->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;padding-right:5;">
	<tr><td valign="top">

		<!--Page Title, Historical (S)-->
        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
        <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
        </table>
        <!--Page Title, Historical (E)-->
        
		<!--biz page (S)-->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
			
                <!--  biz_1  (S) -->
                <table class="search" border="0" style="width:979;"> 
                <tr class="h23">
                    <td width="300">
                        <table border="0" style="width:270;" class="search_sm2"> 
                        <tr class="h23">
                            <td width="80">List Type</td>
                            <td class="stm">
                                <input type="radio" name="list_type" value="L" class="trans" checked> Loading &nbsp;&nbsp;
                                <!-- &nbsp;<input type="radio" name="list_type" value="D" class="trans"> Discharging -->
                            </td>
                        </tr>
                        </table>
                    </td>   
                    <td width="30">VVD</td>
                    <td width="110"><input type="text" name="vvd" style="width:80;ime-mode: disabled" class="input1"
                                        dataformat="eng" maxlength="9" required fullfill caption="VVD"></td>
                    <td width="30">POL</td>
                    <td width="80"><input type="text" name="pol_cd" style="width:50;ime-mode: disabled" class="input1"
                                        dataformat="engupnum" maxlength="5" required fullfill caption="POL"></td>
                    <td width="30">POD</td>
                    <td width="90"><input type="text" name="pod_cd" style="width:50;ime-mode: disabled" class="input"
                                        dataformat="engupnum" maxlength="5" required fullfill caption="POD"></td>
                    <td width=""><input type="checkbox" name="inc_mty_chk" class="trans"> Including Empty</td>
                </tr>
                </table>
                <table class="height_2"><tr><td colspan="8"></td></tr></table>
                <table class="search" border="0" style="width:979;"> 
                <tr class="h23">
                    <td width="60">Terminal</td>
                    <td width="120">
                        <select name="tmnl_type" style="width:80;">
                        <option value="General">General</option>
                        <option value="TTI">TTI</option>
                        <option value="COSCO">COSCO</option>
                        <option value="GPA">GPA</option>
                        </select></td>
                    <td width="">
                        <table border="0" style="width:400;" class="search_sm2"> 
                        <tr class="h23">
                        <td width="120">Data Cross-Check</td>
                        <td class="stm">
                            <input type="radio" name="data_chk" value="A" class="trans" checked>&nbsp; All&nbsp;&nbsp;
                            <input type="radio" name="data_chk" value="M" class="trans">&nbsp; Matched&nbsp;&nbsp;
                            <input type="radio" name="data_chk" value="U" class="trans">&nbsp;Un-matched</td>
                        </tr>
                        </table>
                    </td>
                </tr>
                </table>
                <!--  biz_1   (E) -->
                
            
                <table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
                
        
            
                <!-- Grid  (S) -->
                    <table width="100%"  id="mainTable">
                        <tr>
                            <td width="100%">
                                <script language="javascript">ComSheetObject('sheet1');</script>
                            </td>
                        </tr>
                    </table>
                    <table width="100%"  id="mainTable" style="display:none">
                        <tr>
                            <td width="100%">
                                <script language="javascript">ComSheetObject('sheet4');</script>
                            </td>
                        </tr>
                    </table>
            <!-- Grid (E) -->


            
                <table class="height_10"><tr><td colspan="8"></td></tr></table>
            <!--  biz_2  (S) -->
            <table class="search" border="0" style="width:979;"> 
                <tr class="h23" valign="top">
                    <td width="45%">
            <!-- Grid2 (S) -->
                    <table width="100%"  id="mainTable">
                        <tr>
                            <td width="400">
                                <script language="javascript">ComSheetObject('sheet2');</script>
                            </td>
                        </tr>
                    </table>
            <!-- Grid2 (E) -->
                    </td>
                    <td width="">
            <!-- Grid2 (S) -->
                    <table width="100%"  id="mainTable">
                        <tr>
                            <td width="250">
                                <script language="javascript">ComSheetObject('sheet3');</script>
                            </td>
                        </tr>
                    </table>
            <!-- Grid2 (E) -->
                    </td>
                        </tr>
                    </table>
            <!--  biz_2  (E) -->  
            <table width="100%"  id="mainTable" style="display:none">
                <tr>
                    <td width="100%">
                        <script language="javascript">ComSheetObject('sheet5');</script>
                    </td>
                </tr>
            </table>  
            <!--biz page 2 (S)-->
            <table border="0" width="100%" height="0">
                <tr>
                    <td><script language="javascript">comRdObject('report1');</script></td>
                </tr>
            </table>
            <!--biz page 2 (E)-->
            
            <!--  Button_Sub (S) -->
            <table width="100%" class="button"> 
            <tr><td class="btn2_bg">
                <table border="0" cellpadding="0" cellspacing="0">
                        <td width=""><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn2_left"></td>
                        <td class="btn2" name="btn_loadExcel">Load Excel</td>
                        <td class="btn2_right"></td>
                        </tr>
                        </table></td>
                        
                </table>
            </td></tr>
            </table>
            <!-- Button_Sub (E) -->
            
            
            
            
            </td></tr>
        </table>
    <!-- Grid BG Box  (S) -->
    <!--biz page (E)-->
    
    <!--Button (S) -->
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
        <tr><td class="btn1_bg">
            <table border="0" cellpadding="0" cellspacing="0">
            <tr>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                <td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_new">New</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                <td class="btn1_line"></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_downExcel">Down Excel</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                
                <td class="btn1_line"></td>
                <td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_print">Print</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
            </tr>
            </table>
        </td></tr>
        </table>
    <!--Button (E) -->
    
    </td></tr>
</table>
	
</form>
</body>
</html>