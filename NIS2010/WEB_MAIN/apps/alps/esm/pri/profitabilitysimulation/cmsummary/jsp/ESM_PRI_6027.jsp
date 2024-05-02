<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_6027.jsp
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
<%// page import="com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.event.EsmPri6027Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.common.PRIUtil"%>
<%@ page import="com.hanjin.framework.component.common.AbstractValueObject"%>

<%@ page import="java.util.List"%>

<%
//	EsmPri6027Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.ProfitabilitySimulation.CMSummary");

	
	String frm_pfmc_unit = null;
	String frm_profit_view = null;
	String frm_profit_level = null;
	String frm_contract_type = null;

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		
		frm_pfmc_unit = JSPUtil.getParameter(request,"frm_pfmc_unit");
		frm_profit_view = JSPUtil.getParameter(request,"frm_profit_view");
		frm_profit_level = JSPUtil.getParameter(request,"frm_profit_level");
		frm_contract_type = JSPUtil.getParameter(request,"frm_contract_type");

  
//		event = (EsmPri6027Event)request.getAttribute("Event");
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
<title>CM/OP Summary & Simulation - Contract Approval Status</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>
<script language="javascript">
	 

	var dispRangeTpValue = "LOAD|CMPB|CM|OPB|OP";
	var dispRangeTpText = "LOAD|CMPB|CM|OPB|OP";
	
	var dispRangeVlValue = "5|10|15|20|5P|10P|15P|20P";
	var dispRangeVlText = "5|10|15|20|5%|10%|15%|20%";
	
   	var horizonalAxisValue = "RO|PN|CM|SR";
   	var horizonalAxisText = "Request Office|Contract No.|Customer|Sales Rep.";
	
	var verticalAxisValue = "LOAD|CMPB|CM|OPB|OP";
	var verticalAxisText = "LOAD|CMPB|CM|OPB|OP";
	
	
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
<input type="hidden" name="frm_sc_no_list" >
<input type="hidden" name ="frm_pfmc_unit" value="<%=frm_pfmc_unit %>">
<input type="hidden" name ="frm_profit_view" value="<%=frm_profit_view%>">
<input type="hidden" name ="frm_profit_level" value="<%=frm_profit_level%>">
<input type="hidden" name ="frm_contract_type" value="<%=frm_contract_type%>">

<input type="hidden" name="frm_ctrt_eff_yr">      
<input type="hidden" name="frm_ctrt_eff_wk">      
<input type="hidden" name="frm_ctrt_exp_yr">      
<input type="hidden" name="frm_ctrt_exp_wk">      
<input type="hidden" name="frm_smr_eff_yr">       
<input type="hidden" name="frm_smr_eff_wk">       
<input type="hidden" name="frm_smr_exp_yr">       
<input type="hidden" name="frm_smr_exp_wk">       
<input type="hidden" name="frm_rfrc_eff_yr">     
<input type="hidden" name="frm_rfrc_eff_wk">      
<input type="hidden" name="frm_rfrc_exp_yr">      
<input type="hidden" name="frm_rfrc_exp_wk">      
<input type="hidden" name="frm_trd_cd">    
<input type="hidden" name="frm_dir_cd">    
<input type="hidden" name="frm_sub_trd_cd">       
<input type="hidden" name="frm_rlane_cd">           
<input type="hidden" name="frm_customer_type">    
<input type="hidden" name="frm_prop_ofc_cd">      
<input type="hidden" name="frm_prop_srep_cd">     
<input type="hidden" name="frm_prop_apro_ofc_cd"> 
<input type="hidden" name="frm_cust_list">               
<input type="hidden" name="frm_crg_tp_dry"		>
<input type="hidden" name="frm_crg_tp_dg"		>
<input type="hidden" name="frm_crg_tp_rf"		>
<input type="hidden" name="frm_crg_tp_ak"		>
<input type="hidden" name="frm_crg_tp_bb"		>
<input type="hidden" name="frm_ori_rout_cd">
<input type="hidden" name="frm_ori_loc_tp">
<input type="hidden" name="frm_dest_rout_cd">
<input type="hidden" name="frm_dest_loc_tp">

 
			
<!-- OUTER - POPUP (S)tart -->
<table width="1000" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;CM/OP Summary - Chart(Contract Approval)</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 
			<table class="search"> 
       		<tr><td class="bg">
			
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="260">
						<table class="search_sm2" border="0" style="width:245;"> 
							<tr>
								<td width="70">&nbsp;<strong>Contract</strong></td>
								<td class=""><input type="radio" value="B" class="trans" name="readonly_contract_type" disabled >Both&nbsp;&nbsp;&nbsp;<input type="radio" value="S" name="readonly_contract_type" class="trans" disabled>S/C&nbsp;&nbsp;&nbsp;<input type="radio" value="R" name="readonly_contract_type" class="trans" disabled>RFA</td>
							</tr>
						</table>
					</td>
					<td width="80">Profit View</td>
					<td width="130"><input type="text" style="width:100;" class="input2" value="" name="readonly_profit_view" class="input2" disabled></td>
					<td width="80">Profit Level</td>
					<td width="130"><input type="text" style="width:50;" class="input2" value="" name="readonly_profit_level" class="input2" disabled></td>
					<td width="">
						<table class="search_sm2" border="0" style="width:200;"> 
							<tr>
								<td width="75">&nbsp;<strong>PFMC Unit</strong></td>
								<td class=""><input type="radio" value="FEU" class="trans" name="readonly_pfmc_unit" disabled>FEU&nbsp;&nbsp;&nbsp;<input type="radio" value="TEU" name="readonly_pfmc_unit" class="trans" disabled>TEU</td>
							</tr>
						</table>
					</td>
					</tr>
				</table>
				
				 
				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>	
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="370">
						<table class="search_sm2" border="0" style="width:350;"> 
						<tr>
							<td width="100">&nbsp;<strong>Display Range</strong></td>
							<td class=""><script language="javascript">ComComboObject('frm_disp_range_tp', 1, 70, 1, 1);</script>&nbsp;&nbsp;<input type="radio" value="MAX" name="frm_min_max" class="trans" checked>Max.&nbsp;&nbsp;<input type="radio" value="MIN" name="frm_min_max" class="trans">Min.&nbsp;<script language="javascript">ComComboObject('frm_disp_range_vl', 1, 60, 1, 1);</script></td>
						</tr>
						</table>
					</td>
					<td width="100">Horizontal Axis</td>
					<td width="150"><script language="javascript">ComComboObject('frm_h_axis', 1, 120, 1, 1);</script></td>
					<td width="80">Vertical Axis</td>
					<td width=""><script language="javascript">ComComboObject('frm_v_axis', 1, 80, 1, 1);</script></td>
					</tr>
				</table>
				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
				<!-- Grid  (S) -->
					<table width="100%" height="280" class="grid"> 
						<tr class="tr_head">
							<td width="100%"><script language="javascript">comRdObject('report1');</script></td>
						</tr>		
					</table> 
				<!-- Grid (E) -->
				
				
				
				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
				<table class="search" border="0">
					<tr><td class="title_h"></td>
					<td class="title_s">CM/OP Summary</td>
					<td class="sm" align="right"><span id=UNIT_TEXT></span></td>
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
&raquo; Actual &nbsp;&nbsp;&nbsp;: Actual summary data as of previous week.<br>
&raquo; Estimate: Estimated Summary data for remaining period in contract based on the actual performance<br>							


							
				</td>
						</tr>	
						</table>
					
				
			<!-- biz_1  (E) -->	
					
			
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->

	</td></tr>
		</table>
<!-- : ( Button : pop ) (S) -->


<table class="height_5"><tr><td></td></tr></table>

<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_Retrieve" id="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td></tr></table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_Down_Excel">Down Excel</td>
					<td class="btn1_right"></td></tr></table></td>
					
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_Close">Close</td>
					<td class="btn1_right"></td>
					</table>
			</td>
		</tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table>

<!-- : ( Button : pop ) (E) -->

    <div style="display:none">
    <script language="javascript">ComSheetObject('sheet2');</script>
    </div>
    
<!-- 개발자 작업  끝 -->

</form>
</body>
</html>