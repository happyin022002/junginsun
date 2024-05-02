<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_6032.jsp
*@FileTitle : CM,OP Summary And Simulation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.10
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2009.09.10 송민석
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
<%@ page import="com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.event.EsmPri6032Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.apps.alps.esm.pri.common.PRIUtil"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="java.util.List"%>
<%
	EsmPri6032Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.ProfitabilitySimulation.CMSummary");
	String[] customerTypeCombo = null;
	String[] applicationCombo = null;
	String[] appOfcCombo = null;
	String[] chgCdCombo = null;
	 
 
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		
		event = (EsmPri6032Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		 
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
 
 
		// Service Scope Combo Data 생성
		List<RsltCdListVO> comboData = (List<RsltCdListVO>)eventResponse.getCustomData("CustomerTypeCombo");
		customerTypeCombo = PRIUtil.getValueObject2StringArray(comboData,false);
		// Service Scope Combo Data 생성
		comboData = (List<RsltCdListVO>)eventResponse.getCustomData("ApplicationCombo");
		applicationCombo = PRIUtil.getValueObject2StringArray(comboData,false);
		// Service Scope Combo Data 생성
		comboData = (List<RsltCdListVO>)eventResponse.getCustomData("AppOfcCombo");
		appOfcCombo = PRIUtil.getValueObject2StringArray(comboData);
		// Service Scope Combo Data 생성
		comboData = (List<RsltCdListVO>)eventResponse.getCustomData("ChgCdCombo");
		chgCdCombo = PRIUtil.getValueObject2StringArray(comboData,false);
 
		
	 

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>CM,OP Summary And Simulation</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	




	var customerTypeValue = "<%=customerTypeCombo[0]%>";		
	var customerTypeText = "<%=customerTypeCombo[1]%>";
	
	var applicationValue = "<%=applicationCombo[0]%>";		
	var applicationText = "<%=applicationCombo[1]%>";
	
	var appOfcValue = "<%=appOfcCombo[0]%>";		
	var appOfcText = "<%=appOfcCombo[1]%>";
	
	var chgCdValue = "<%=chgCdCombo[0]%>";		
	var chgCdText = "<%=chgCdCombo[1]%>";


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
<input type="hidden" name="frm_svc_scp_cd">
<input type="hidden" name="frm_prop_no_list">
<input type="hidden" name="frm_rfa_prop_no_list">
<input type="hidden" name ="frm_prop_apro_ofc_cd">
<input type="hidden" name ="frm_customer_type">
<input type="hidden" name="frm_contract_type">
<input type="hidden" name="frm_pfmc_unit">
<input type="hidden" name="frm_status">
<input type="hidden" name="frm_ctrt_eff_dt">
<input type="hidden" name="frm_ctrt_exp_dt">
<input type="hidden" name="frm_prop_ofc_cd">
<input type="hidden" name="frm_prop_srep_cd">
<input type="hidden" name="frm_prop_srep_nm">
<input type="hidden" name="frm_cust_list">
<input type="hidden" name="frm_crg_tp_dry">
<input type="hidden" name="frm_crg_tp_dg">
<input type="hidden" name="frm_crg_tp_rf">
<input type="hidden" name="frm_crg_tp_ak">
<input type="hidden" name="frm_crg_tp_bb">
<input type="hidden" name="min_ctrt_eff_dt">
<input type="hidden" name="max_ctrt_exp_dt">

<input type="hidden" name="frm_ori_rout_cd"		   >  
<input type="hidden" name="frm_ori_loc_tp"	  >  
<input type="hidden" name="frm_dest_rout_cd"		  >  
<input type="hidden" name="frm_dest_loc_tp"	    >  
<input type="hidden" name="frm_slane_cd"	  >    


<!-- OUTER - POPUP (S)tart -->
<table width="800" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;  CM/OP Summary- Simulation(Contract Proposal)</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 
			<table class="search"> 
       		<tr><td class="bg">
			
				<table class="search_sm2" border="0" style="width:500;"> 
							<tr class="h23">
								<td width="120">&nbsp;Simulation Data</td>
								<td class="stm"><input type="checkbox" value="0" name="simulation_data" class="trans" checked>G.Revenue&nbsp;&nbsp;&nbsp;<input type="checkbox" name="simulation_data" value="1" class="trans">Rate&nbsp;&nbsp;&nbsp;<input type="checkbox" value="2" name="simulation_data" class="trans">Surcharge&nbsp;&nbsp;&nbsp;<input type="checkbox" value="3" name="simulation_data" class="trans">Cost&nbsp;&nbsp;&nbsp;<input type="checkbox" value="4" name="simulation_data" class="trans">Load</td>
							</tr>
				</table>
				
 	
  <div id="sheetLayer" style="display:inline">			
				
				<table class="search" border="0">
					<tr><td class="title_h"></td>
					<td class="title_s">G.Revenue Simulation</td>
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
				<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn1_Row_Add">Row Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn1_Row_Copy">Row Copy</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn1_Row_Delete">Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
</div>			
 <div id="sheetLayer" style="display:none">

				<table class="search" border="0">
					<tr><td class="title_h"></td>
					<td class="title_s">Rate Simulation</td>
					</tr>
				</table>
						<!-- : ( Grid ) (S) -->
						<table width="100%"  id="mainTable"> 
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet2');</script>
								</td>
							</tr>
						</table>
				<!-- : ( Grid ) (E) -->	
				<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn2_Row_Add">Row Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn2_Row_Copy">Row Copy</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn2_Row_Delete">Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
			
</div>			
  <div id="sheetLayer" style="display:none">
				<table class="search" border="0">
					<tr><td class="title_h"></td>
					<td class="title_s">Surcharge Simulation</td>
					</tr>
				</table>
						<!-- : ( Grid ) (S) -->
						<table width="100%"  id="mainTable"> 
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet3');</script>
								</td>
							</tr>
						</table>
				<!-- : ( Grid ) (E) -->	
				<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn3_Row_Add">Row Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn3_Row_Copy">Row Copy</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn3_Row_Delete">Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
</div>			
  <div id="sheetLayer" style="display:none">				
 				<table class="search" border="0">
					<tr><td class="title_h"></td>
					<td class="title_s">Cost Simulation</td>
					</tr>
				</table>
						<!-- : ( Grid ) (S) -->
						<table width="100%"  id="mainTable"> 
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet4');</script>
								</td>
							</tr>
						</table>
				<!-- : ( Grid ) (E) -->	
				<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn4_Row_Add">Row Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn4_Row_Copy">Row Copy</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn4_Row_Delete">Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
</div>			
  <div id="sheetLayer" style="display:none">			
 				<table class="search" border="0">
					<tr><td class="title_h"></td>
					<td class="title_s">Load Simulation</td>
					</tr>
				</table>
						<!-- : ( Grid ) (S) -->
						<table width="100%"  id="mainTable"> 
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet5');</script>
								</td>
							</tr>
						</table>
				<!-- : ( Grid ) (E) -->	
				
				
				
						 
			

						
				<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn5_Row_Add">Row Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn5_Row_Copy">Row Copy</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn5_Row_Delete">Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->	
</div>			
  </td></tr>
</table>			
		
<table class="height_5"><tr><td></td></tr></table>		
						<table class="search" border="0" style="width:100%;"> 
						<tr class="h23">
							<td width="80" valign="TOP">Remark(s)</td>
							<td class="SM">&raquo; Inputted amount will be applied based on the each applicable route sequence in contract. <br>
&raquo; In case you want to simulate based on contract not applicable route sequence under contract, we recommend you to use multiplication(X)  instead of addition(+).</td>
						</tr>	
						</table>			
		
		
		
<!-- : ( Search Options ) (E) -->

	</td></tr>
		</table>
<!-- : ( Button : pop ) (S) -->
 <div id="sheetLayer" style="display:none">
 <script language="javascript">ComSheetObject('sheet6');</script>
 </div>

<table class="height_5"><tr><td></td></tr></table>


						
						
						
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_OK">OK</td>
					<td class="btn1_right"></td></tr></table></td>
					<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_Close">Close</td>
					<td class="btn1_right"></td>
					</table>
			</td>
		</tr>
		</table></td>
		</tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>