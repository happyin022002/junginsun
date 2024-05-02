<%--
/*=========================================================
*Copyright(c) 2009 CyberLogitec 
*@FileName : ESD_EAS_0301.jsp
*@FileTitle : Port (Service) Charge
*Open Issues :
*Change history :
*@LastModifyDate : 2014-12-05
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 최초 생성 
-------------------------------------------------------------------
* History
* 2016.03.25 김도현 CHM-201640191 Split02-Auto Audit - Invoice Batch 개발 요청
* 2016.07.09 Arie Im CHM-201641447 PSO Auto Audit - Audit Tool(Tariff Simulation) 추가
=========================================================*/
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.eas.psoadvanceaudit.event.EsdEas0301Event"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.StringUtil"%>
<%
	String divChargeType = JSPUtil.getParameter(request, "CHARGE_TYPE".trim(), "");

	EsdEas0301Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	
	String ofcCd		= "";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.psoadvanceaudit.Port S/O Invoice Charge");
	
	String param_name 	= null;
	String ofc_cd	= "";
	String strUsr_ofc_cd = "";
	String strUsr_rhq_ofc_cd = "";
	
	String s_popup_flg = "";
	String s_popup_rhq_cd = "";
	String s_popup_inv_ofc_cd = "";
	String s_popup_fm_dt = "";
	String s_popup_to_dt = "";
	String s_popup_auto_aud_sts_cd = "";
	String s_popup_expn_aud_sts_cd = "";
	
	java.util.Enumeration enums = request.getParameterNames();
	while (enums.hasMoreElements()){
		param_name = (String)enums.nextElement();
	}
	
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		ofcCd = account.getOfc_cd();
		strUsr_ofc_cd = account.getOfc_cd();
		strUsr_rhq_ofc_cd = account.getRhq_ofc_cd();
		
		s_popup_flg = (StringUtil.xssFilter(request.getParameter("s_popup_flg"))==null)?"":StringUtil.xssFilter(request.getParameter("s_popup_flg"));
		s_popup_rhq_cd = (StringUtil.xssFilter(request.getParameter("s_popup_rhq_cd"))==null)?"":StringUtil.xssFilter(request.getParameter("s_popup_rhq_cd"));
		s_popup_inv_ofc_cd = (StringUtil.xssFilter(request.getParameter("s_popup_inv_ofc_cd"))==null)?"":StringUtil.xssFilter(request.getParameter("s_popup_inv_ofc_cd"));
		s_popup_fm_dt = (StringUtil.xssFilter(request.getParameter("s_popup_fm_dt"))==null)?"":StringUtil.xssFilter(request.getParameter("s_popup_fm_dt"));
		s_popup_to_dt = (StringUtil.xssFilter(request.getParameter("s_popup_to_dt"))==null)?"":StringUtil.xssFilter(request.getParameter("s_popup_to_dt"));
		s_popup_auto_aud_sts_cd = (StringUtil.xssFilter(request.getParameter("s_popup_auto_aud_sts_cd"))==null)?"":StringUtil.xssFilter(request.getParameter("s_popup_auto_aud_sts_cd"));
		s_popup_expn_aud_sts_cd = (StringUtil.xssFilter(request.getParameter("s_popup_expn_aud_sts_cd"))==null)?"":StringUtil.xssFilter(request.getParameter("s_popup_expn_aud_sts_cd"));
	
		event = (EsdEas0301Event)request.getAttribute("Event");
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
<title>Port (Service) Charge</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
<%= JSPUtil.getIBCodeCombo("audit_status", "01", "CD03417", 0, "")%>
<%= JSPUtil.getIBCodeCombo("s_expn_aud_sts_cd", "", "CD03410", 0, "")%>
<%= JSPUtil.getIBCodeCombo("contract_type"	, "", "CD01513", 0, "")%>
<%= JSPUtil.getIBCodeCombo("auto_audit_flg", "", "CD03417", 0, "")%> // Auto Audit Status
<%= JSPUtil.getIBCodeCombo("vessel_class", "", "CD03434", 0, "")%> // Vessel Class
<%= JSPUtil.getIBCodeCombo("if_status",      "", "CD03411", 0, "")%>
<%= JSPUtil.getIBCodeCombo("sel_aud_cd", "01", "CD03348", 0, "")%>
	function setupPage(){
		loadPage("<%=divChargeType%>");
	}
</script>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="vskd_port_rhq_cd">
<input type="hidden" name="s_rhq_ofc_cd">
<input type="hidden" name="divChargeType" value="<%=divChargeType%>">

<input type="hidden" name="usr_ofc_cd"		value="<%=strUsr_ofc_cd%>">
<input type="hidden" name="usr_rhq_ofc_cd"	value="<%=strUsr_rhq_ofc_cd%>">
<input type="hidden" name="code_key">
<input type="hidden" name="ofc_cd"		value="<%=strUsr_ofc_cd%>">
<input type="hidden" name="ofclevel">

<input type="hidden" name="pop_parent_row">
<input type="hidden" name="pop_expn_aud_rslt_usr_nm">
<input type="hidden" name="pop_expn_aud_rslt_usr_id">
<input type="hidden" name="pop_expn_aud_rslt_rmk">
<input type="hidden" name="pop_ofcLevel">
<input type="hidden" name="s_save_tp_cd">
<input type="hidden" name="portlChargeType">
<input type="hidden" name="serviceChargeType">
<input type="hidden" name="canalChargeType">
<input type="hidden" name="otherChargeType">

<input type="hidden" name="pop_mdl_tp_cd">
<input type="hidden" name="pop_atch_file_lnk_flg">
<input type="hidden" name="pop_auto_aud_sts_cd">
<input type="hidden" name="pop_expn_aud_sts_cd">
<input type="hidden" name="pop_atch_file_lnk_id">
<input type="hidden" name="pop_expn_aud_rslt_cd">
<input type="hidden" name="pop_inv_no">

<input type="hidden" name="s_popup_flg" value="<%=s_popup_flg%>">
<input type="hidden" name="s_popup_rhq_cd" value="<%=s_popup_rhq_cd%>">
<input type="hidden" name="s_popup_inv_ofc_cd" value="<%=s_popup_inv_ofc_cd%>">
<input type="hidden" name="s_popup_fm_dt" value="<%=s_popup_fm_dt%>">
<input type="hidden" name="s_popup_to_dt" value="<%=s_popup_to_dt%>">
<input type="hidden" name="s_popup_auto_aud_sts_cd" value="<%=s_popup_auto_aud_sts_cd%>">
<input type="hidden" name="s_popup_expn_aud_sts_cd" value="<%=s_popup_expn_aud_sts_cd%>">

<input type="hidden" name="pop_inv_aud_curr_cd">
<input type="hidden" name="pop_inv_usd_diff_amt">
<input type="hidden" name="pop_inv_aud_diff_amt">
<input type="hidden" name="pop_inv_cfm_dt">

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>
			<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
				<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
				</table>
			<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->

			<!-- TABLE '#D' : ( Button : Main ) (S) -->
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
				<tr><td class="btn1_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
							<!-- td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_retrieve2" id="btn_retrieve2">Retrieve2</td><td class="btn1_right"></td></tr></table></td-->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_new" id="btn_save">New</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btng_confirm" id="btng_confirm">Confirm</td><td class="btn1_right"></td></tr></table></td>
							<td class="btn1_line"></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_downexcel" id="btn_downexcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>
							<!-- Repeat Pattern -->
						</tr></table>
				</td></tr>
			</table>
			<!-- TABLE '#D' : ( Button : Main ) (E) -->

			<!-- TABLE '#D' : ( Search Options ) (S) -->
	     	<table width="100%" class="search" border="0">
	       	<tr>
	       		<td class="bg" >
						<!-- : ( Week ) (S) -->
							<!-- [1]--------------------------------------------------------- -->
							<table class="search_in" border="0">
								<tr class="h23">
									<td width="100">RHQ</td>
									<td width="200" class="stm" style="padding-left:2px"><script language="javascript">ComComboObject('rhq',1,80,1,0,0,0);</script></td>
									<td width="95">Office</td>
									<td width="250" class="stm" style="padding-left:2px"><script language="javascript">ComComboObject('office',1,80,0,0,0,0);</script></td>
									<td width="90">Period</td>
									<td width=""><input type="text" style="width:75; text-align:Center" name="period1" value="" dataformat="ymd" maxlength="8" class="input1">
										<img name="btns_calendar_s" src="img/btns_calendar.gif" width="19" height="20" alt=""border="0" align="absmiddle" class="cursor"> ~
										<input type="text" style="width:75; text-align:Center" name="period2" value="" dataformat=""ymd"" maxlength="8" class="input1">
										<img name="btns_calendar_e" src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
										</td>
									</td>
								</tr>								
							</table>
							<!-- [2]--------------------------------------------------------- -->
							<table class="search_in" border="0">
								<tr class="h23">
									<td width="100">Charge Type</td>
									<td width="200" class="stm"  style="padding-left:2px"><script language="javascript">ComComboObject('charge_type',1,155,0,0,0,0);</script></td>
									<td width="95">Account Code</td>
									<td width="250" class="stm" style="padding-left:2px">
									<script language="javascript">ComComboObject('acct_cd',2, 80, 0, 0,0,0);</script>
									&nbsp;<input type="text" name="acct_nm" style="width: 145; text-align: left" class="input2" value="" readonly></td>
									<td width="90">Cost Code</td>
									<td width="" style="padding-left:2px"><script language="javascript">ComComboObject('cost_cd',2, 75, 0, 0,0,0);</script>&nbsp;<input type="text" name="cost_nm" style="width: 134; text-align: left" class="input2" value="" readonly></td>
								</tr>
							</table>
							<!-- [3]--------------------------------------------------------- -->
							<table class="search_in" border="0">
								<tr class="h23">
									<td width="100">Port Code</td>
									<td width="200" class="stm"><input name="port_cd" type="text" dataformat="eng" style="width:80;" class="input" value="" size="5" maxlength="5">&nbsp;<img class="cursor" name="btn_port_cd" src="img/btns_search.gif" width="17" height="20" border="0" align="absmiddle">&nbsp;<script language="javascript">ComComboObject('yard_cd',2, 50, 0, 0,0,0);</script></td>
									<td width="95" style="padding-left:2px">S/P No.</td>
									<td width="250" class="stm"><input type="text" name="spcode" dataformat="int" maxlength="6" style="width:80;text-align:center;ime-mode:disabled;" class="input" value="">&nbsp;<img class="cursor" src="img/btns_search.gif" name="btn_sp_cd" width="19" height="20" alt="" border="0" align="absmiddle">
										<input type="text" name="spname" style="width:122;text-align:left;" class="input2" value="" readonly>
									</td>
									<td width="90" style="padding-left:2px">Audit Status</td>
									<td width="" class="stm" style="padding-left:2px"><script language="javascript">ComComboObject('audit_status',1, 105, 1,0,0,0 )</script>
									                   &nbsp;<script language="javascript">ComComboObject('s_expn_aud_sts_cd',1,105,1,0,0);</script>
									</td>
								</tr>
							</table>
							<!-- [4]--------------------------------------------------------- -->
							<table class="search_in" border="0">
								<tr class="h23">
									<td width="100">Contract type</td>
									<td width="200" class="stm" style="padding-left:2px"><script language="javascript">ComComboObject('contract_type',2, 80 , 1,0,0,0 )</script>&nbsp;<input name="contract_type_nm" type="text" style="width:70;" readonly class="input2"></td>
									<!-- 조회조건이 쿼리에 없음 -->
									<td width="95">Vessel Class</td>
									<td width="250" class="stm" style="padding-left:2px"><script language="javascript">ComComboObject('vessel_class',1,120,0,0,0,0);</script>
										&nbsp;<B>Vessel</B>&nbsp;<script language="javascript">ComComboObject('vessel',1,63,0,0,0,0);</script>
									</td>
									<% if("1".equals(divChargeType)){ %>
									
										<td width="90">Diff.</td>
										<td width="" class="stm"><select style="width:75;" name="diff" onChange="diffChange();">
											<option value="" selected> </option>
											<option value="01"><=</option>
											<option value="02">=</option>
											<option value="03">>=</option>
											</select>
					                  		<input name="diff_num" type="text" style="width:80;text-align:Right" onKeyUp="chkField(this, 'num', true, 8);" maxlength="3">
										</td>
									<% }else if("2".equals(divChargeType)){ %>
										<td width="90">Remark</td>
										<td width="" class="stm">&nbsp;<input name="remark" type="text" style="width:180;text-align:Reft" dataformat="engnum">
										</td>
									<% } %>
								</tr>
							</table>
							<!-- [5]--------------------------------------------------------- -->
							<table class="search_in" border="0">
								<tr class="h23">
									<td width="100">CSR NO.</td>
									<td width="200"><input name="csr_no" type="text" dataformat="uppernum" style="width:154;text-align:Center"  class="input">
									<img src="img/btns_multisearch.gif" name="csr_no_multi1"width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
									</td>
									<!-- 조회조건이 쿼리에 없음 -->
									<td width="95" style="padding-left:2px">Invoice No.</td>
									<td width="250" class="stm" ><input name="inv_no" type="text" style="width:205;text-align:Center"  class="input">
									<img src="img/btns_multisearch.gif" name="inv_no_multi1"width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
									</td>
									<td width="90" style="padding-left:2px">CSR Status</td>
									<td style="padding-left:2;"><script language="javascript">ComComboObject('if_status',1,105,1);</script></td>
								</tr>
							</table>
						<!-- : ( Week ) (E) -->
						</td>
					</tr>
				</table>
				<!-- TABLE '#D' : ( Search Options ) (E) -->			

			<table class="height_10"><tr><td></td></tr></table>

			<!-- TABLE '#D' : ( Grid ) (S) -->
	     	<table class="search">
	       		<tr><td class="bg">
					<!-- <table class="height_10"><tr><td></td></tr></table> -->
					<!-- : ( POR ) (S) -->
					<table width="100%" id="mainTable">
			              <tr><td>
			                     <script language="javascript">ComSheetObject('sheet1');</script>
			              </td></tr>
					</table>
					<!-- : ( POR ) (E) -->

					<!-- : ( Button : Grid ) (S) -->
					<table width="100%" class="button">
						<tr><td class="btn2_bg">
							<table border="0" cellpadding="0" cellspacing="0">
								<tr>
								<% if("1".equals(divChargeType)){ %>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td><td class="btn2" name="btng_rebatch">Re-Batch</td><td class="btn2_right"></td></tr>
									</table>
								</td>
								<% } %>
								<!-- Repeat Pattern -->
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" name="btn_transfer" id="btn_transfer">EAC Transfer</td>
								<td class="btn2_right"></td></tr></table></td>

								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" name="btn_history" id="btn_history">History Amount</td>
								<td class="btn2_right"></td></tr></table></td>
								
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" name="btn_simulation" id="btn_simulation">Tariff Simulation</td>
								<td class="btn2_right"></td></tr></table></td>								
								<td width="80"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" name="btn_Tariff" id="btn_Tariff">Port Tariff</td><td class="btn2_right"></td></tr>
								</table></td>
								<!-- Repeat Pattern -->
								</tr>
							</table>
						</td></tr>
					</table>
			    	<!-- : ( Button : Grid ) (E) -->

				</td></tr>
			</table>
			<!-- TABLE '#D' : ( Grid ) (E) -->

    </td></tr>
</table>
<!-- Outer Table (E)-->

</form>
</body>
</html>