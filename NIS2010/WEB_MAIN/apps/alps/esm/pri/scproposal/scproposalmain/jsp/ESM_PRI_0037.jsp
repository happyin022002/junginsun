<%
/*=========================================================
*Copyright(c) 2017 Hiplus Card
*@FileName : ESM_PRI_0037.jsp
*@FileTitle : Amendment Request
*Open Issues :
*Change history :
*@LastModifyDate : 2017.09.26
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2017.09.26 송민석
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
<%@ page import="com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.event.EsmPri0037Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
String sScNo = request.getParameter("sScNo");

	String sPropNo  = request.getParameter("sPropNo"); 
    String sAmdtSeq  = request.getParameter("sAmdtSeq");

	String sEffDt = request.getParameter("sEffDt");
	String sExpDt = request.getParameter("sExpDt");

	EsmPri0037Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_ofc		= "";
	
	Logger log = Logger.getLogger("com.hanjin.apps.SCProposal.SCProposalMain");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_ofc = account.getOfc_cd();
		
		event = (EsmPri0037Event)request.getAttribute("Event");
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
<title>Amendment Effective Date</title>
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

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="sEffDt" value="<%=sEffDt%>">
<input type="hidden" name="sExpDt" value="<%=sExpDt%>">
<input type="hidden" name="org_prop_no" value="<%=strUsr_ofc%>">
<!-- 개발자 작업	-->

<!-- OUTER - POPUP (S)tart -->
<table width="500" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
    <!-- : ( Title ) (S) -->
    <table width="100%" border="0">
    <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp; Amendment Effective Date</td></tr>
    </table>
    <!-- : ( Title ) (E) -->		
	<!--biz page (S)-->
		<table class="search"> 
        <tr><td class="bg">
			<!--  biz_1  (S) -->	
	       <table class="search" border="0" style="width:450;"> 
                <tr class="h23">
                    <td width="65">S/C No.</td>
                    <td width=""><input type="text" style="width:159;" name="sc_no" readonly value="<%=sScNo%>" class="input2">
                                         <input type="hidden" style="width:80;" name="prop_no" readonly value="<%=sPropNo%>" class="input2"> 
                            <input type="hidden" style="width:20;" name="amdt_seq" readonly value="<%=sAmdtSeq%>" class="input2"> 
                    </td>
                </tr>	

				 
				<tr class="h23">
					<td width="">Duration</td>
				    <td width="" colspan=3><input type="text" style="width:70;" name="ctrt_eff_dt" readonly  class="input2" maxlength="10" dataformat="ymd" caption="Effective date" cofield="ctrt_exp_dt">&nbsp;~&nbsp;<input type="text" style="width:70;" name="ctrt_exp_dt" readonly=true class="input2" maxlength="10" dataformat="ymd" caption="Expiration date" cofield="ctrt_eff_dt"></td>
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
				<!-- Grid (E) -->
				<!--  biz_1   (E) -->
				
				
		
		</td></tr></table>
		
		<!--biz page (E)--> 

</td></tr></table>

<table class="height_5"><tr><td></td></tr></table>
	
<!-- : ( Button : pop ) (S) -->
<table width="500" class="sbutton">
<tr><td height="71" class="popup">
    	<!--Button (S) -->	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_ok">OK</td>
					<td class="btn1_right"></td>
				</tr></table></td>	
			<td class="btn1_line"></td>		
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close">Close</td>
					<td class="btn1_right">
				</tr></table></td>	
			
				
			</tr>
		</table>
    	<!--Button (E) -->
	
	</td></tr>
</table>

<!-- : ( Button : pop ) (E) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>