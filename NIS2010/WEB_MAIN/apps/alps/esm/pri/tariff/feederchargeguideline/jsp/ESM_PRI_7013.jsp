<%
/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : ESM_PRI_7013.jsp
 *@FileTitle : EUR Add-on Guideline Creation / Amend – Load Excel
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.05.30
 *@LastModifier : 이은섭
 *@LastVersion : 1.0
 * 2012.05.30 이은섭
 * 1.0 Creation
 ========================================================= */
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.tariff.feederchargeguideline.event.EsmPri7013Event"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@ page import="com.hanjin.framework.core.config.SiteConfigFactory"%>

<%
	EsmPri7013Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.hanjin.apps.alps.esm.pri.tariff");
	String templateKey = null;

	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmPri7013Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Add-on Guideline Creation / Amend – Load Excel</title>
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
<!-- 개발자 작업 -->
<input type="hidden" name="svc_scp_cd" value="<%=  JSPUtil.getParameter(request, "svc_scp_cd")%>">
<input type="hidden" name="fdr_trf_no" value="<%= JSPUtil.getParameter(request, "fdr_trf_no")%>">
<input type="hidden" name="amdt_seq" value="<%= JSPUtil.getParameter(request, "amdt_seq")%>">
<input type="hidden" name="org_dest_tp_cd" value="<%= JSPUtil.getParameter(request, "org_dest_tp_cd")%>">
<input type="hidden" name="rhq_cd" value="<%= JSPUtil.getParameter(request, "rhq_cd")%>">

<!-- OUTER - POPUP (S)tart -->
<table width="950" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
	<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Add-on Guideline Creation / Amend – Load Excel</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 			
			<table class="search"> 
       		<tr><td class="bg">
				<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				<table width="100%" class="button">
		       	<tr><td class="btn2_bg">
					<table border="0" cellpadding="0" cellspacing="0">
					<tr>							
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_rowadd">Row Add</td>
							<td class="btn2_right"></td>
							</tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_delete">Delete</td>
							<td class="btn2_right"></td>
							</tr></table></td>		
					</tr>
					</table>				
						<!-- Grid (E) -->
				</td></tr>
			</table>
			</td>
		</tr>
	</table>
	
	<!--biz page (E)-->
	
<table class="height_5"><tr><td></td></tr></table>
	
	</td></tr>
</table>	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td width=""><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_openfile">Open&nbsp;File</td>
					<td class="btn1_right"></td>
					</tr></table>
					</td>
				</td><td width="72"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_check">Check</td>
					<td class="btn1_right"></td>
					</tr></table>
				</td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left">
					<td class="btn1" name="btn_save">Save</td>
					<td class="btn1_right">
				</table></td>
				<td class="btn1_line"></td>
				<td width="72"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close">Close</td>
					<td class="btn1_right"></td>
					</tr></table>
				</td></tr>
		</table></td></tr>
		</table>
		
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
</form>
</body>
</html>

