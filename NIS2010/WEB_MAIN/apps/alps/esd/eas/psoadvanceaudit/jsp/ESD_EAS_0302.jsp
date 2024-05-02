<%--
/*=========================================================
*Copyright(c) 2009 CyberLogitec 
*@FileName : ESD_EAS_0302.jsp
*@FileTitle : Port (Service) Charge History
*Open Issues :
*Change history :
*@LastModifyDate : 2014-12-05
*@LastModifier : DO-HYUN KIM
*@LastVersion : 1.0
* 1.0 최초 생성 
-------------------------------------------------------------------
* History

=========================================================*/
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.eas.psoadvanceaudit.event.EsdEas0302Event"%>
<%
	String param_contract_type = JSPUtil.getParameter(request, "contract_type".trim(), "");
	String param_charge_type = JSPUtil.getParameter(request, "charge_type".trim(), "");
	String param_iss_cty_cd = JSPUtil.getParameter(request, "iss_cty_cd".trim(), "");
	String param_so_seq = JSPUtil.getParameter(request, "so_seq".trim(), "");
	String param_so_dtl_seq = JSPUtil.getParameter(request, "so_dtl_seq".trim(), "");
	String param_period1 = JSPUtil.getParameter(request, "period1".trim(), "");
	String param_period2 = JSPUtil.getParameter(request, "period2".trim(), "");
	String param_vvd = JSPUtil.getParameter(request, "vvd".trim(), "");
	
	String param_cntr_vsl_clss_capa = JSPUtil.getParameter(request, "cntr_vsl_clss_capa".trim(), "");
	String param_vsl_cd = JSPUtil.getParameter(request, "vsl_cd".trim(), "");
	String param_port = JSPUtil.getParameter(request, "port".trim(), "");
	String param_yard = JSPUtil.getParameter(request, "yard".trim(), "");
	String param_acct_cd = JSPUtil.getParameter(request, "acct_cd".trim(), "");
	String param_cost_cd = JSPUtil.getParameter(request, "cost_cd".trim(), "");
	String rhq = JSPUtil.getParameter(request, "rhq".trim(), "");
	String vessel = JSPUtil.getParameter(request, "vessel".trim(), "");
	String vessel_class = JSPUtil.getParameter(request, "vessel_class".trim(), "");
	String divChargeType = JSPUtil.getParameter(request, "divChargeType".trim(), "");
	
%>
<html>
<head>
<title>Port (Service) Charge History</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
<%= JSPUtil.getIBCodeCombo("vessel_class", "", "CD03434", 0, "")%> // Vessel Class
<%= JSPUtil.getIBCodeCombo("contract_type"	, "", "CD01513", 0, "")%> //Contract type
	function setupPage(){
		loadPage();
	}
</script>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="param_contract_type" value="<%=param_contract_type%>">
<input type="hidden" name="param_rhq" value="<%=rhq%>">
<input type="hidden" name="param_vessel" value="<%=vessel%>">
<input type="hidden" name="param_vessel_class" value="<%=vessel_class%>">
<input type="hidden" name="param_charge_type" value="<%=param_charge_type%>">
<input type="hidden" name="param_iss_cty_cd" value="<%=param_iss_cty_cd%>">
<input type="hidden" name="param_so_seq" value="<%=param_so_seq%>">
<input type="hidden" name="param_so_dtl_seq" value="<%=param_so_dtl_seq%>">
<input type="hidden" name="param_vvd" value="<%=param_vvd%>">
<input type="hidden" name="param_cntr_vsl_clss_capa" value="<%=param_cntr_vsl_clss_capa%>">
<input type="hidden" name="param_vsl_cd" value="<%=param_vsl_cd%>">
<input type="hidden" name="param_yard" value="<%=param_yard%>">
<input type="hidden" name="param_acct_cd" value="<%=param_acct_cd%>">
<input type="hidden" name="param_cost_cd" value="<%=param_cost_cd%>">
<input type="hidden" name="divChargeType" value="<%=divChargeType%>">

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>
			<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S)
				<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
				</table>
			<! TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->

			<!-- TABLE '#D' : ( Button : Main ) (S) -->
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
				<tr><td class="btn1_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
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
	       		<td class="bg">
						<!-- : ( Week ) (S) -->
							<!-- [1]--------------------------------------------------------- -->
							<table border="0">
								<tr class="h23">
									<td width="110">RHQ</td>
									<td width="220">&nbsp;<script language="javascript">ComComboObject('rhq',1,80,1,1,0,0);</script>
									</td>								
									<td width="90">Vessel Class</td>
									<td width="233">&nbsp;<script language="javascript">ComComboObject('vessel_class',1,175,0);</script>
									</td>
									<td width="66" alighn="right">Vessel</td>
									<td width="260" class="stm">&nbsp;<script language="javascript">ComComboObject('vessel',1,65,0);</script>
									</td>
								</tr>								
							</table>
							<!-- [2]--------------------------------------------------------- -->
							<table border="0">
								<tr class="h23">
									<td width="110">Contract type</td>
									<td width="220">&nbsp;<script language="javascript">ComComboObject('contract_type',2, 105 , 1,0,0,0 )</script>
										&nbsp;		  				
				                  		<input name="contract_type_nm" type="text" style="width:95;" readonly class="input2">
									</td>								
									<td width="55">Country</td>
									<td ><input name="country" type="text" dataformat="uppernum" style="width:25" class="input" value="" size="2" maxlength="2">&nbsp;
									</td>
									<td width="70">&nbsp;Port Code</td>
									<td width="167"><input name="port_cd" type="text" dataformat="uppernum" style="width:45" class="input" value="<%=param_port%>" size="5" maxlength="5">&nbsp;<img class="cursor" name="btn_port_cd" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">
										<script language="javascript">ComComboObject('yard_cd',2, 43, 0, 0);</script>
									</td>
									<td width="66">Period</td>
										<td width="">&nbsp;<input type="text" style="width:70; text-align:Center" name="period1"  dataformat="ymd" maxlength="8" class="input1" value=<%=param_period1%> ><img name="btns_calendar_s" src="img/btns_calendar.gif" width="19" height="20" alt=""border="0" align="absmiddle" class="cursor"> ~
                                                           <input type="text" style="width:70; text-align:Center" name="period2"  dataformat="ymd" maxlength="8" class="input1" value=<%=param_period2%>><img name="btns_calendar_e" src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
                                        </td>
									</td>
									
								</tr>
							</table>
							<table border="0">
								<tr class="h23">
									
									<td width="110">Charge Type</td>
									<td width="220" class="stm">&nbsp;<script language="javascript">ComComboObject('charge_type',1,160,0,0,0,0);</script></td>
									<td width="95">Account Code</td>
									<td width="228" class="stm"><script language="javascript">ComComboObject('acct_cd',2, 70, 0, 0);</script>&nbsp;<input type="text" name="acct_nm" style="width: 140; text-align: left" class="input2" value="" readonly>
									</td>
									<td width="70">Cost Code</td>
									<td width=""><script language="javascript">ComComboObject('cost_cd',2, 78, 0, 0);</script>&nbsp;<input type="text" name="cost_nm" style="width:152; text-align: left" class="input2" value="" readonly></td>
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
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" name="btn_Tariff" id="btn_Tariff">Port Tariff</td>
								<td class="btn2_right"></td></tr></table></td>
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