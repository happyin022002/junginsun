<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_EQR_1060.jsp
*@FileTitle : MTY Rail Arrival Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.21
*@LastModifier : 나상보
*@LastVersion : 1.0
* 2009.10.07 
* 1.0 Creation
* =======================================================
* 2011.06.13 나상보 [CHM-201111518-01] [EQR]  MTY Rail Trans. 화면의 CNTR List 조회 기능 추가
* 2011.07.25 나상보 [CHM-201112443] [EQR]  MTY Rail Arrival Detail 화면에 Down Excel 기능 추가
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.StringUtil"%>
<%
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String dest1			= "";
	String dest2			= "";
	String tpsz				= "";
	String eta_dt			= "";
	String gubun			= "";
	String opn_scr			= "";

	try { 
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		dest1			= StringUtil.xssFilter(request.getParameter("dest1"));
		dest2			= StringUtil.xssFilter(request.getParameter("dest2"));
		tpsz			= StringUtil.xssFilter(request.getParameter("tpsz"));
		eta_dt			= StringUtil.xssFilter(request.getParameter("eta_dt"));
		gubun			= StringUtil.xssFilter(request.getParameter("gubun"));
		opn_scr			= StringUtil.xssFilter(request.getParameter("opn_scr"));

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
<title>MTY Rail Arrival Detail</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

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
<!-- 개발자 작업	-->

<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
    
        <!-- : ( Title ) (S) -->
        <table width="100%" border="0">
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;MTY Rail Arrival Detail</td></tr>
        </table>
        <!-- : ( Title ) (E) -->
</td></tr></table>    

        <!-- Tab BG Box  (S) -->
        <table class="search"> 
        <tr><td class="bg">
        		<table  width="100%"  id="mainTable">
							<tr class="h23">
<% if("A".equals(gubun)){ %>
								<td width="95">Dest. Location</td> 
								<td width="100"><input name="dest1" type="text" class="input2" style="width:85;ime-mode:disabled;" value="<%= dest1 %>" dataformat='engup' readOnly></td>
								<td width="95">Dest.Yard</td>
								<td width="100"><input name="dest2" type="text" class="input2" style="width:85;ime-mode:disabled;" value="<%= dest2 %>" dataformat='engup' readOnly></td>
<% }else{ %>
								<td width="95">Dest. Yard</td> 
								<td width="100"><input name="dest1" type="text" class="input2" style="width:85;ime-mode:disabled;" value="<%= dest1 %>" dataformat='engup' readOnly></td>
								<td width="95">Org.Yard</td>
								<td width="100"><input name="dest2" type="text" class="input2" style="width:85;ime-mode:disabled;" value="<%= dest2 %>" dataformat='engup' readOnly></td>
<% } %> 
							</tr>
							<tr class="h23">
								<td width="95">TP/SZ</td>
								<td width="100"><input name="tpsz" type="text" class="input2" style="width:85;ime-mode:disabled;" value="<%= tpsz %>" readOnly></td>
<% if("1058".equals(opn_scr)){ %>
								<td width="95">Est. Arr. Date</td>
								<td width="100"><input name="eta_dt" type="text" class="input2" style="width:85;ime-mode:disabled;" value="<%= eta_dt %>" readOnly></td>
<% } %>
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
				<!-- Grid  (E) -->
            <table class="height_10"><tr><td colspan="8"></td></tr></table>
  
            <!--  Button_Sub (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

        <!--Button (S) -->  
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
        <tr><td class="btn3_bg">
            <table border="0" cellpadding="0" cellspacing="0">
            <tr>
            <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_downexcel" id="btn_downexcel">Down Excel</td>
					<td class="btn1_right"></td>
				</tr></table></td>	
			<td class="btn1_line"></td>     
            <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                   <tr><td class="btn1_left"></td>
                   <td class="btn1" name="btn_close">Close</td>
                   <td class="btn1_right"></td>
            </tr></table></td>
            </tr>
        </table></td>
        </tr>
        </table>
        <!--Button (E) -->
    
    </td></tr>
</table>
            <!-- Button_Sub (E) -->
		</td></tr>
        </table>
            
</td></tr>
</table>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>