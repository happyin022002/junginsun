<%  
/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : ESM_PRI_6095.jsp
 *@FileTitle : Rate Creation - Excel Import(Vertical)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.07.30
 *@LastModifier : 이은섭
 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@ page import="com.hanjin.framework.core.config.SiteConfigFactory"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.event.EsmPri6095Event"%>

<%
	EsmPri6095Event event = null; //PDTO(Data Transfer Object including Parameters)
    Exception serverException = null; //서버에서 발생한 에러
    String strErrMsg = ""; //에러메세지
    int rowCount = 0; //DB ResultSet 리스트의 건수

    String successFlag = "";
    String codeList = "";
    String pageRows = "100";

    String strUsr_id = "";
    String strUsr_nm = "";
    String templateKey = null;
    Logger log = Logger.getLogger("com.hanjin.apps.SCQuotation.SCRateQuotation");

    try {
        SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();

        event = (EsmPri6095Event) request.getAttribute("Event");
        serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        
     	// Excel Template File Key
		templateKey = (String)eventResponse.getCustomData("TEMPLATE_KEY");
    } catch (Exception e) {
        out.println(e.toString());
    }
%>
<html>
<head>
<title>Rate Creation - Excel Import (Vertical)</title>
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

<body onLoad="setupPage();" scrolling="no">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업 -->
<input type="hidden" name="qttn_no" value="<%=request.getParameter("qttn_no")%>">
<input type="hidden" name="qttn_ver_no" value="<%=request.getParameter("qttn_ver_no")%>">
<input type="hidden" name="svc_scp_cd" value="<%=request.getParameter("svc_scp_cd")%>">
<input type="hidden" name="qttn_sts_cd" value="<%=request.getParameter("qttn_sts_cd")%>">
<input type="hidden" name="eff_dt" value="<%=JSPUtil.getParameter(request, "eff_dt")%>">
<input type="hidden" name="fic_rt_tp_cd" value="<%=JSPUtil.getParameter(request, "fic_rt_tp_cd")%>">

<!-- OUTER - POPUP (S)tart -->
<table width="950" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
	<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Quotion Creation - Excel Import (Vertical)</td></tr>
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
						<!-- Grid (E) -->
				</td></tr>
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
		    	<!-- <td width=""><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Template">Template</td>
					<td class="btn1_right"></td>
					</tr></table>
					</td> -->
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

<div id="hiddenSheetLayer" style="display: none">
<script language="javascript">ComSheetObject('sheet2');</script>
<script language="javascript">ComSheetObject('sheet3');</script>
</div>
</form>
<!-- 
<form name="downform" action="/hanjin/FileDownload" method="post" target="downifm">
<input type="hidden" name="<%=SiteConfigFactory.get("COM.FILE.DOWNLOAD.KEY") %>" value="<%=templateKey%>">
</form>
 -->
<iframe name="downifm" style="display:none;"></iframe>
</body>
</html>

