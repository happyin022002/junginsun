<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_6054.jsp
*@FileTitle : CM/OP Summary & Simulation - Contract Proposal Status
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.13
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2009.08.13 송민석
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
<%@ page import="com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.event.EsmPri6054Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.common.PRIUtil"%>
<%@ page import="com.hanjin.framework.component.common.AbstractValueObject"%>

<%@ page import="java.util.List"%>

<%
	EsmPri6054Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd = "";
	Logger log = Logger.getLogger("com.hanjin.apps.ProfitabilitySimulation.CMSummary");
	String[] svcScpCombo = null;
	String[] appOfcCdCombo = null;
	String[] profitViewCombo = null;
	String[] cmOpCombo = null;
	String[] customerTypeCombo = null;
	RsltCdListVO authData = null; 

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		


		event = (EsmPri6054Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
 

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		// Service Scope Combo Data 생성
		List<RsltCdListVO> comboData = (List<RsltCdListVO>)eventResponse.getCustomData("SvcScpCombo");
		svcScpCombo = PRIUtil.getValueObject2StringArray(comboData);
		// Approval Office Code List ( IN 조건으로 8건만 가져온다. )
		comboData = (List<RsltCdListVO>)eventResponse.getCustomData("AppOfcCombo");
		appOfcCdCombo = PRIUtil.getValueObject2StringArray(comboData);
		// Profit View
		comboData = (List<RsltCdListVO>)eventResponse.getCustomData("ProfitViewCombo");
		profitViewCombo = PRIUtil.getValueObject2StringArray(comboData);
		// CM/OP
		comboData = (List<RsltCdListVO>)eventResponse.getCustomData("CmOpCombo");
		cmOpCombo = PRIUtil.getValueObject2StringArray(comboData);
		// Customer Type
		comboData = (List<RsltCdListVO>)eventResponse.getCustomData("CustomerTypeCombo");
		customerTypeCombo = PRIUtil.getValueObject2StringArray(comboData);
 
 
		// 권한정보
		authData = (RsltCdListVO)eventResponse.getCustomData("AuthData");
 
		
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>CM/OP Summary & Simulation - Contract Proposal Status</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	
	var svcScpComboValue = "<%=svcScpCombo[0]%>";
	var svcScpComboText = "<%=svcScpCombo[1]%>";
	
	var appOfcCdComboValue = "<%=appOfcCdCombo[0]%>";	
	var appOfcCdComboText = "<%=appOfcCdCombo[1]%>";
	
 	var profitViewComboValue = "<%=profitViewCombo[0]%>";		
	var profitViewComboText = "<%=profitViewCombo[1]%>";

	var cmOpComboValue = "<%=cmOpCombo[0]%>";		
	var cmOpComboText = "<%=cmOpCombo[1]%>";

	var customerTypeComboValue = "<%=customerTypeCombo[0]%>";		
	var customerTypeComboText = "<%=customerTypeCombo[1]%>";
	

	var authCode = "<%=authData.getCd()%>"
	var authReqOfcCd = "<%=PRIUtil.getNvl(authData.getNm(),"")%>"

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
<input type="hidden" name = "usr_id" value = "<%=strUsr_id%>">
<input type="hidden" name="req_ofc_cd"  value="<%=strOfc_cd %>">
<input type="hidden" name="searched_svc_scp_cd">
<input type="hidden" name="searched_customer_type">
<input type="hidden" name="searched_prop_apro_ofc_cd">

<input type="hidden" name="searched_contract_type"	>
<input type="hidden" name="searched_pfmc_unit"		>
<input type="hidden" name="searched_ctrt_eff_dt"	>
<input type="hidden" name="searched_ctrt_exp_dt"	>
<input type="hidden" name="searched_prop_ofc_cd"	>
<input type="hidden" name="searched_prop_srep_cd"	>
<input type="hidden" name="searched_prop_srep_nm"	>
<input type="hidden" name="searched_cust_list"	>
<input type="hidden" name="searched_crg_tp_dry"		>
<input type="hidden" name="searched_crg_tp_dg"		>
<input type="hidden" name="searched_crg_tp_rf"		>
<input type="hidden" name="searched_crg_tp_ak"		>
<input type="hidden" name="searched_crg_tp_bb"		>


<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
 	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
	<!--Page Title, Historical (E)-->
	
	
			<!--Button (S) -->
		<table width="100%" border="0" class="button" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_Retrieve" id="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>				
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_Down_Excel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table></td>
			</tr>
			</table>
    <!--Button (E) -->
	
		
		<table class="search"> 
       		<tr><td class="bg">	
			
			
			<!-- biz_1  (S) -->
			<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="330">
						<table class="search_sm2" border="0" style="width:245;"> 
							<tr>
								<td width="70">&nbsp;<strong>Contract</strong></td>
								<td class="noinput1"><input type="radio" value="B" class="trans" name="frm_contract_type" checked>Both&nbsp;&nbsp;&nbsp;<input type="radio" name="frm_contract_type" value="S" class="trans">S/C&nbsp;&nbsp;&nbsp;<input type="radio" value="R" name="frm_contract_type" class="trans">RFA</td>
							</tr>
						</table>
					</td>
					<td width="">
						<table class="search_sm2" border="0" style="width:220;"> 
							<tr>
								<td width="95">&nbsp;<strong>PFMC Unit</strong></td>
								<td class="noinput1"><input type="radio" value="FEU" name="frm_pfmc_unit" class="trans" >FEU &nbsp;&nbsp;&nbsp;<input type="radio" value="TEU" name="frm_pfmc_unit" class="trans" checked>TEU</td>
							</tr>
						</table>
					</td>
				</tr>
				</table>
				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
				<table class="search_sm2" border="0" style="width:979;"> 
				<tr class="h23"><td>
				
					<table class="search" border="0" style="width:979;"> 
					<tr>
						<td width="120"><strong>&raquo; By View</strong></td>   
						<td width="95">Profit View</td>
						<td width="120"><script language="javascript">ComComboObject('frm_profit_view', 1, 90, 0, 1);</script></td> 
						<td width="90">Profit Level</td>
						<td width=""><script language="javascript">ComComboObject('frm_profit_level', 1, 68, 0, 1);</script></td> 
						 
						</tr>
					</table>
					<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
					<table class="search" border="0" style="width:979;"> 
					<tr>
						<td width="120"><strong>&raquo; By Scope</strong></td>   
						<td width="95">SVC Scope</td>
						<td width="120"><script language="javascript">ComComboObject('frm_svc_scp_cd', 2, 90, 0, 1);</script></td> 
						<td width="90">Duration</td>
						<td width=""><input type="text" caption="Duration" name="frm_ctrt_eff_dt" cofield="frm_ctrt_exp_dt" maxlength="10" dataformat="ymd" style="width:70;"   class="input1" required>&nbsp;<img src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" name="btns_calendar1" class="cursor">&nbsp;&nbsp;~&nbsp;&nbsp;<input type="text" caption="Duration" name="frm_ctrt_exp_dt" cofield="frm_ctrt_eff_dt" maxlength="10" dataformat="ymd" style="width:70;"   class="input" required>&nbsp;<img src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" name="btns_calendar2" class="cursor"></td> 
						</tr>
					</table>
					<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
					<table class="search" border="0" style="width:979;"> 
					<tr>
						<td width="120"><strong>&raquo; By Office</strong></td>   
					<td width="95">Approval Office</td>
					<td width="120"><script language="javascript">ComComboObject('frm_prop_apro_ofc_cd', 1, 90, 0, 0);</script></td> 
					<td width="90">Request Office</td>
					<td width="120"><input type="text" style="width:60;" class="input" value="" dataformat="engup" maxlength="6" name="frm_prop_ofc_cd" id="frm_prop_ofc_cd"></td>
					<td width="65">Sales Rep.</td>
					<td width=""><script language="javascript">ComComboObject('frm_prop_srep_cd', 2, 61, 0, 0);</script>&nbsp;<input type="text" style="width:85;" name="frm_prop_srep_nm" readonly=true class="input" ></td>
						</tr>
					</table>
					<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
					<table class="search" border="0" style="width:979;"> 
					<tr>
						<td width="120"><strong>&raquo; By Customer</strong></td>   
					<td width="95">Customer Type</td>
					<td width="120"><script language="javascript">ComComboObject('frm_customer_type', 1, 90, 0, 0);</script></td>
					<td width="90">Customer</td>

					<td width=""><input type="text" style="width:310;" class="input" value="" name="frm_cust_nm" readonly>
						<input type="hidden" name="frm_cust_list"><img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" name="btn_customer">&nbsp;
						</td> 
						</tr>
					</table>
					<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
					<table class="search" border="0" style="width:979;"> 
					<tr>
						<td width="120"><strong>&raquo; By Cargo Type</strong></td>   
					<td width="80"><input type="checkbox" value="Y" class="trans" name="frm_crg_tp_dry">Dry</td> 
					<td width="80"><input type="checkbox" value="Y" class="trans" name="frm_crg_tp_dg">DG</td>
					<td width="80"><input type="checkbox" value="Y" class="trans" name="frm_crg_tp_rf">RF</td>
					<td width="80"><input type="checkbox" value="Y" class="trans" name="frm_crg_tp_ak">AK</td>
					<td width=""><input type="checkbox" value="Y" class="trans" name="frm_crg_tp_bb">BB</td>
						</tr>
					</table>
				
				</td></tr>
				</table>
				
				
				
				
				
				
				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
				<table class="search" border="0">
					<tr><td class="title_h"></td>
					<td class="title_s"><span id="sheet_title"></span></td>
					<td class="sm" align="right"><span id="unit_text"></span></td>
					</tr>
				</table>
					<!--grid (s)-->
						<table width="100%"  id="mainTable"> 
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet1');</script>
								</td>
							</tr>
						</table> 
						<!--grid(E)-->
						<table class="height_5"><tr><td colspan="8"></td></tr></table>
						<table class="search" border="0" style="width:100%;"> 
						<tr class="h23">
							<td width="80" valign="TOP">Remark(s)</td>
							<td class="SM"> 
&raquo; Quotation:  Estimated summary data based on the Quotation request status <BR>
&raquo; Proposal:  Estimated summary data based on the Proposal request status<BR>
&raquo; Approval: Estimated summary data based on the Proposal/Amendment approval status<BR>
&nbsp;&nbsp;(Actual Performance in contract + Estimate performance for remaining period in contract)<BR>
</td>
						</tr>	
						</table>
					
				
			<!-- biz_1  (E) -->	
				
			</td></tr>
		</table>
	
	
		
		
 		<table class="height_10"><tr><td colspan="8"></td></tr></table>
		
 </td></tr>
</table>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>