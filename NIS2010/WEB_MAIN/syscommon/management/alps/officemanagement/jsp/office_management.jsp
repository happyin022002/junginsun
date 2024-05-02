<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec 
*@FileName : office_management.jsp
*@FileTitle : Office
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.02
*@LastModifier : 정인선
*@LastVersion : 1.0
* 2009.07.02 정인선
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
<%@ page import="com.hanjin.syscommon.management.alps.officemanagement.event.OfficeManagementEvent"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>

<%
	OfficeManagementEvent  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	
	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.${SC}.${BC}");
	
	try {
	   	SignOnUserAccount account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	
	
		event = (OfficeManagementEvent)request.getAttribute("Event");
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

<head>
<title>Program Office Mapping</title>
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

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
   <!-- : ( Title ) (S) -->
   <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
       
       <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"> Program Office Mapping</td></tr>
   </table>

		<table class="height_15"><tr><td></td></tr></table>

		<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
			<table class="search" border="0" width="580"> 
				<tr><td class="bg_b1">
				
				<table class="height_10"><tr><td></td></tr></table>
				
				
				
				<table class="search" border="0" width="580">
					<tr>
					<td width="100%" valign="top">
							<table width="100%" class="search_sm2" border="0">
								<tr class="h23">
									<td width="13%">Program No.</td>
									<td width="25%"><input type="text" style="width:70%;" class="input" value="<%=StringUtil.xssFilter(request.getParameter("pgm_no"))%>" name="pgm_no"></td>
									<td width="15%">Program Name</td>
									<td width=""><input type="text" style="width:100%;" class="input" value="<%=StringUtil.xssFilter(request.getParameter("pgm_nm"))%>" name="pgm_nm"></td>
								</tr> 
							</table>
							<table width="100%" class="search" border="0">
								<tr class="h23">
									<td width="25%">Office Access Level</td>
									<td width="" class="stm">
									<input type="checkbox" name="ALL" class="trans" onClick="chkBox('A', this.checked)">ALL
									<input type="checkbox" name="SHO" class="trans" onClick="chkBox('1', this.checked)">SHO
									<input type="checkbox" name="RHQ" class="trans" onClick="chkBox('2', this.checked)">RHQ
									<input type="checkbox" name="GOF" class="trans" onClick="chkBox('3', this.checked)">GOF
									<input type="checkbox" name="SOF" class="trans" onClick="chkBox('4', this.checked)">SOF
									<input type="checkbox" name="LOF" class="trans" onClick="chkBox('5', this.checked)">LOF
									<input type="checkbox" name="AGT" class="trans" onClick="chkBox('6', this.checked)">AGT
									<input type="checkbox" name="OTH" class="trans" onClick="chkBox('9', this.checked)">OTH
									</td>
								</tr> 
							</table>
							<table width="100%" class="search_sm2" border="0">
								<tr class="h23">
									<td width="13%">County Code</td>
									<td width="25%"><input type="text" style="width:100;" name= "countryCd" class="input" value="" onKeyPress="javascript:ComKeyOnlyAlphabet('uppernum');">&nbsp;<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_cnt_cd"></td>
									<td width="15%">AR OFC</td>
									<td width=""><input type="text" style="width:100;" name= "arOfcCd" class="input" value="" onKeyPress="javascript:ComKeyOnlyAlphabet('uppernum');">&nbsp;<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_ofc_cd"></td>
									<td><input type="checkbox" name="CHK" class="trans" onClick="chkBox('Z', this.checked)">CHECK</td>
								</tr> 
							</table>
							
							<table class="height_10"><tr><td></td></tr></table>
							
							<!-- : ( Grid ) (S) -->
                			<table width="100%" id="mainTable">
                                <tr><td><div id="ibsheet">
                                     <script language="javascript">ComSheetObject('sheet1');</script></div>
                                </td></tr>
                            </table>
							<!-- : ( Grid ) (E) -->
							
					</td>
					</tr>
				
				</table>
				
				</td></tr>
			</table>
			<!-- TABLE '#D' : ( Tab BG Box ) (E) -->
		
			
	
</td></tr>
</table> 
<!-- OUTER - POPUP (E)nd -->


<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
    
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
        <tr><td class="btn3_bg">
            <table border="0" cellpadding="0" cellspacing="0">
            <tr>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_save">Save</td>
                    <td class="btn1_right">
                </tr></table></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_close">Close</td>
                    <td class="btn1_right">
                </tr></table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_DownExcel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
            </tr>
        </table>
    <!--Button (E) -->
    
    </td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
			
			

</body>
</form>
</html>

<%@ include file="/bizcommon/include/common_nis2010.jsp" %>
