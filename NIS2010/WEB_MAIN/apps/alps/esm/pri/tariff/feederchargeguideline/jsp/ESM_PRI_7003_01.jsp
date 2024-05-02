<%
/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESM_PRI_7003_01.jsp
*@FileTitle : Feeder/IHC Tariff Inquiry - Dry Tab
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.06
*@LastModifier : SEO MI JIN
*@LastVersion : 1.0
* 1.0 Creation
=========================================================
* History     
* 2013.03.20 [CHM-201323687] 전윤주  sheet 하단에 문구 추가
* 2013.07.30 [CHM-201326002] 전윤주 Over weight, DG service flag가 'Y' 인 경우 버튼 파란색으로 표시  
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.tariff.feederchargeguideline.event.EsmPri700301Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.common.PRIUtil"%>
<%@ page import="com.hanjin.framework.component.util.code.CodeInfo"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%
	EsmPri700301Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			
	String strErrMsg = "";						
	int rowCount	 = 0;						
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_ofc		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.alps.esm.pri.tariff");

	String[] scopeCd = null;
	String[] prcTrspModCd = null;
	String[] termCd = null;
	String[] srcInfoCd = null;
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_ofc = account.getOfc_cd();
	    
		event = (EsmPri700301Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");	
        
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>   
<title>Feeder/IHC Tariff Inquiry - Dry Tab</title>
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
<input type="hidden" name="acc_dt">
<input type="hidden" name="svc_scp_cd">
<input type="hidden" name="pnt_loc_cd">
<input type="hidden" name="bse_port_loc_cd">
<input type="hidden" name="org_dest_tp_cd">
<input type="hidden" name="ihc_cgo_tp_cd">  
<input type="hidden" name="svc_tp_cd">  
<table width="100%" border="0" cellpadding="0" cellspacing="0">
	<tr><td valign="top">	
	
		<table class="search"> 
       	<tr><td class="bg">
       	
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="width: 979;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr class="h23"> 
	    		<td width="80">Cargo Type</td>
				<td width="420">
					<input type="checkbox" name="cgoTpcd" style="border-style:none;" checked="checked" value="D">Dry&nbsp;
					<input type="checkbox" name="cgoTpcd" style="border-style:none" value="G">DG
				</td>	
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_down_excel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>	
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_dg_cgo_scg" id="btn_dg_cgo_scg">Add-on DG CGO SCHG</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>	
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_ihc_ovr_cgo" id="btn_ihc_ovr_cgo">IHC Over Weight CGO SCHG</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>				
			</tr>
			</table>
		</td></tr>
		</table>
	<!--Button (E) -->
	
		<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>																				
	
	<!--biz page (S)-->
		
			<!-- Grid  (S) -->								
			<table width="100%"  id="mainTable">
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet1');</script>
					</td>
				</tr>
			</table>
			<!-- Grid (E) -->				  
					
	<!--biz page (E)-->
	
	<!--hidden page (S)-->
		<div id="flagLayer1" style="display:none">
			<table width="979"  id="mainTable">
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet2');</script>
					</td>
				</tr>
			</table>
		</div>	
	<!--hidden page (E)-->	
			<table class="search" border="0">
				<tr><td height="18"><img src="/hanjin/img/ico_star.gif" border="0" hspace="3" align="absmiddle">
				If the tariff amounts is "0", please contact each RHQ and ask for more accurate amounts.
				</td></tr>		
			</table>	
		</td></tr>
	</table>
	
	</td></tr>
</table>
</form>
</body>
</html>