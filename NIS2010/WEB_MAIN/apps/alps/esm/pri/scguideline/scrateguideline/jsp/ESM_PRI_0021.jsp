<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0021.jsp
*@FileTitle : Rate Guideline Creation - Route Point
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.07
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.05.07 공백진
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
<%@ page import="com.hanjin.apps.alps.esm.pri.scguideline.scrateguideline.event.EsmPri0021Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.common.PRIUtil"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.hanjin.framework.component.util.code.CodeInfo"%>
<%
	EsmPri0021Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	String[] termOrgCd = null;
	String[] termDesCd = null;
	String[] transCd = null;	
	
	Logger log = Logger.getLogger("com.hanjin.apps.SCGuideline.SCRateGuideline");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (EsmPri0021Event) request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        termOrgCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("termOrgCd"), false ,"|","\t","getCode","getName");
        termDesCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("termDesCd"), false ,"|","\t","getCode","getName");
        transCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("transCd"), false ,"|","\t","getCode","getName");
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Rate Guideline Creation - Route Point</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
    var termOrgCdComboValue = " |<%=termOrgCd[0]%>";
    var termOrgCdComboText = " |<%=termOrgCd[1]%>";
    var termDesCdComboValue = " |<%=termDesCd[0]%>";
    var termDesCdComboText = " |<%=termDesCd[1]%>";    
    var transCdComboValue = " |<%=transCd[0]%>";
    var transCdComboText = " |<%=transCd[1]%>";
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

<!-- 개발자 작업	-->
<input type="hidden" name="cd" value="">
<input type="hidden" name="svc_scp_cd" value="<%=request.getParameter("svc_scp_cd")%>" >
<input type="hidden" name="gline_seq" value="<%=request.getParameter("gline_seq")%>">
<input type="hidden" name="prc_cust_tp_cd" value="<%=request.getParameter("prc_cust_tp_cd")%>">
<input type="hidden" name="cmdt_hdr_seq" value="<%=request.getParameter("cmdt_hdr_seq")%>">
<input type="hidden" name="rout_seq" value="<%=request.getParameter("rout_seq")%>">
<input type="hidden" name="org_dest_tp_cd" value="<%=request.getParameter("org_dest_tp_cd")%>">
<input type="hidden" name="pnt_via_tp_cd" value="<%=request.getParameter("pnt_via_tp_cd")%>">
<input type="hidden" name="isEditable" value="<%=request.getParameter("isEditable")%>">

<!-- OUTER - POPUP (S)tart -->
<table width="700" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp; Rate Guideline Creation - Route Point</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 
			<table class="search"> 
       		<tr><td class="bg">
				
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="%">
						<table border="0" style="width:90%;" class="search_sm"> 
						<tr class="h23">
						<td width="20%">Route Point</td>
						<td width="" class="sm">
						<input type="radio" class="trans" name="rt_pnt" value="4" checked>&nbsp;<span id="pnt1">Origin</span>&nbsp;&nbsp;
						<input type="radio" class="trans" name="rt_pnt" value="5" >&nbsp;<span id="pnt2">Origin Via</span>&nbsp;&nbsp;
						<input type="radio" class="trans" name="rt_pnt" value="6" >&nbsp;<span id="pnt3">Destination Via</span>&nbsp;&nbsp;
						<input type="radio" class="trans" name="rt_pnt" value="7" >&nbsp;<span id="pnt4">Destination</span>
						</td>
						</tr>
						</table></td>
					</tr>	
				</table>
				<!-- : ( Grid ) (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table> 				
				<!-- : ( Grid ) (E) -->	
				<!-- : ( Button : Grid ) (S) -->
				<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_RowAdd">Row Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_RowDel">Row Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>						
				</table>
			</td></tr>
			</table>			
			
	    	<!-- Button_Sub (E) -->			
		    <!-- : ( Button : Grid ) (E) -->			
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->
		
</td></tr>
</table> 

<!-- : ( Button : pop ) (S) -->

<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td width="72"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Ok">OK</td>
					<td class="btn1_right"></td>
			</tr>
			</table>
			<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left">
					<td class="btn1" name="btn_Close">Close</td>
					<td class="btn1_right">
					</tr>
				</table></td>
		</td></tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
<div id="hiddenSheetLayer" style="display: none ">
<script language="javascript">ComSheetObject('sheet2');</script>
<script language="javascript">ComSheetObject('sheet3');</script>
<script language="javascript">ComSheetObject('sheet4');</script>
<script language="javascript">ComSheetObject('sheet5');</script>
</div>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>