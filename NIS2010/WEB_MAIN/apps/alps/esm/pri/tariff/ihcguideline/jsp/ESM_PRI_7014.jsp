<%
/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : ESM_PRI_7014.jsp
 *@FileTitle : IHC Tariff Creation & Amendment - Load Excel
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2013.04.12
 *@LastModifier : 조정민
 *@LastVersion : 1.0
 * 2013.04.12 조정민
 * 1.0 Creation
 =========================================================
 * History              
 * 2013.07.08 서미진 [CHM-201325626] HAMRU 산하 TAE, TAW, ASE, ASW 인 경우 Local Currency 가 기준이 되도록 변경
 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.event.EsmPri7014Event"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.common.PRIUtil"%>
<%@ page import="org.apache.log4j.Logger"%>

<%@ page import="java.util.List"%>

<%
	EsmPri7014Event event = null; //PDTO(Data Transfer Object including Parameters)
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
	String[] prcTrspModCd = null;

	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmPri7014Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) { 
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		prcTrspModCd 	= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("PRC_TRSP_MOD_CD"), false);
	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>IHC Tariff Creation & Amendment - Load Excel</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	var prcTrspModCdValue = " |<%=prcTrspModCd[0]%>";
	var prcTrspModCdText = " |<%=prcTrspModCd[1]%>";
	
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
<input type="hidden" name="org_dest_tp_cd" value="<%= JSPUtil.getParameter(request, "org_dest_tp_cd")%>">
<input type="hidden" name="amdt_seq" value="<%= JSPUtil.getParameter(request, "amdt_seq")%>">
<input type="hidden" name="ihc_trf_no" value="<%= JSPUtil.getParameter(request, "ihc_trf_no")%>">
<input type="hidden" name="ihc_cgo_tp_cd" value="<%= JSPUtil.getParameter(request, "ihc_cgo_tp_cd")%>">
<input type="hidden" name="locl_curr_cd" value="<%= JSPUtil.getParameter(request, "locl_curr_cd")%>">
<input type="hidden" name="rhq_cd" value="<%= JSPUtil.getParameter(request, "rhq_cd")%>">

<!-- OUTER - POPUP (S)tart -->
<table width="950" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
	<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;IHC Tariff Creation & Amendment - Load Excel</td></tr>
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

