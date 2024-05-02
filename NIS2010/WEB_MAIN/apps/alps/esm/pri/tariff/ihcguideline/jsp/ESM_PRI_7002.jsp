<%
/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESM_PRI_7002.jsp
*@FileTitle : IHC Tariff Creation & Amendment - Amend
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.08
*@LastModifier : SEO MI JIN
*@LastVersion : 1.0
* 2012.05.05
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
<%@ page import="com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.event.EsmPri7002Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.common.PRIUtil"%>
<%@ page import="com.hanjin.framework.component.util.code.CodeInfo"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>

<%
	EsmPri7002Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	//int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String svcScpCd = "";	
	String tariffNo = "";	
	String amendSeq = "";
	String creDt = "";
	String effDt = "";
	String expDt = "";
	String amendEff = "";
	String tariffNoView = "";	
	String rhqCd = "";
	String orgDestTpCd = "";	
	
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_ofc		= "";

	Logger log = Logger.getLogger("com.hanjin.apps.alps.esm.pri.tariff");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_ofc = account.getOfc_cd();

		event = (EsmPri7002Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		svcScpCd = request.getParameter("svc_scp_cd");
		tariffNo = request.getParameter("ihc_trf_no");	
		amendSeq = request.getParameter("amdt_seq");		
		
		creDt = DateTime.getFormatDate(JSPUtil.getParameter(request, "cre_dt"), "yyyyMMdd", "yyyy-MM-dd"); 
		effDt = DateTime.getFormatDate(JSPUtil.getParameter(request, "eff_dt"), "yyyyMMdd", "yyyy-MM-dd"); 
		expDt = request.getParameter("exp_dt");
		tariffNoView = request.getParameter("ihc_trf_no_view");	
		rhqCd = request.getParameter("rhq_cd");
		orgDestTpCd = request.getParameter("org_dest_tp_cd");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>IHC Tariff Creation & Amendment - Amend</title>
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
<input type="hidden" name="exp_dt" value="<%=expDt%>" >
<input type="hidden" name="prog_ofc_cd" value="<%=strUsr_ofc%>" >
<input type="hidden" name="tobe_amdt_seq">
<input type="hidden" name="ihc_trf_no" value="<%=tariffNo%>">
<input type="hidden" name="rhq_cd" value="<%=rhqCd%>">
<input type="hidden" name="org_dest_tp_cd" value="<%=orgDestTpCd%>">

<!-- OUTER - POPUP (S)tart -->
<table width="700" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">	

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;IHC Tariff Creation & Amendment - Amend</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 
		<table class="search"> 
       		<tr><td class="bg">
				<table class="search" border="0" style="width:700;"> 
				<tr class="h23">
					<td width="100">Service Scope</td>
					<td width="120"><input type="text" name="svc_scp_cd" style="width:110;text-align:center;" readonly class="input2" value="<%=svcScpCd%>"></td>		
					<td width="100">Tariff No.</td>
					<td width="130"><input type="text" name="ihc_trf_no_view" style="width:110;text-align:center;" readonly class="input2" value="<%=tariffNoView%>"></td>
					<td width="110">AMD No.</td>
					<td width="150"><input type="text" name="amdt_seq" style="width:110;text-align:center;" readonly class="input2" value="<%=amendSeq%>"></td>
				</tr>
				<tr class="h23">
					<td width="100">Creation Date</td>
					<td width="120"><input type="text" name="cre_dt" style="width:110;text-align:center;" readonly class="input2" value="<%=creDt%>"></td>		
					<td width="100">Effective Date</td>
					<td width="130"><input type="text" name="eff_dt" style="width:110;text-align:center;" readonly class="input2" value="<%=effDt%>"></td>
					<td width="110">AMD Effective</td>
					<td width="150"><input type="text" name="amdt_eff" style="width:90;text-align:center;" class="input1" maxlength="10" dataformat="ymd" >
					<img src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" name="btn_calendar"></td>
				</tr>				
				</table>
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->

<table class="height_5"><tr><td></td></tr></table>
		
</td></tr>
</table> 

<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
	<tr>
		<td height="71" class="popup">		
		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">
			<tr>
				<td class="btn3_bg">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_ok">OK</td>
								<td class="btn1_right">
							</tr>
						</table>
						</td>
						
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_close">Close</td>
								<td class="btn1_right">
							</tr>
						</table>
						</td>						
					</tr>
				</table>
				</td>
			</tr>
		</table>
		<!--Button (E) --></td>
		<td width="0">
		<div id="flagLayer1" style="display:none">
		<table width="100%"  cellpadding="5"  id="mainTable"> 
			<tr>
				<td width="100%">
				<script language="javascript">ComSheetObject('sheet1');</script>
				</td>
			</tr>
		</table>
		</div>
		</td>		
	</tr>
</table>

<!-- : ( Button : pop ) (E) -->

</form>
</body>
</html>