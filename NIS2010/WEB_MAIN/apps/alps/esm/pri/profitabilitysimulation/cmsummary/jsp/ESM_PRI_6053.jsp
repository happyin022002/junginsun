<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_6053.jsp
*@FileTitle : CM/OP Summary And Simulation - Revenue Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.22
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2009.09.22 송민석
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
<%@ page import="com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.event.EsmPri6053Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri6053Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
 
	String frm_pfmc_unit = null;
 
	
	Logger log = Logger.getLogger("com.hanjin.apps.ProfitabilitySimulation.CMSummary");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmPri6053Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	 
		frm_pfmc_unit = JSPUtil.getParameter(request,"frm_pfmc_unit");
 

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>CM/OP Summary And Simulation - Revenue Detail</title>
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
<!-- 개발자 작업	-->
<input type="hidden" name="frm_pfmc_unit" value="<%=frm_pfmc_unit %>">
<input type="hidden" name="frm_customer_type">
<input type="hidden" name="frm_prop_apro_ofc_cd">
<input type="hidden" name="frm_contract_type"	>
<input type="hidden" name="frm_ctrt_eff_yr"	>
<input type="hidden" name="frm_ctrt_eff_wk"	>
<input type="hidden" name="frm_ctrt_exp_yr"	>
<input type="hidden" name="frm_ctrt_exp_wk"	>
<input type="hidden" name="frm_smr_eff_yr"	>
<input type="hidden" name="frm_smr_eff_wk"	>
<input type="hidden" name="frm_smr_exp_yr"	>
<input type="hidden" name="frm_smr_exp_wk"	>
<input type="hidden" name="frm_rfrc_eff_yr"	>
<input type="hidden" name="frm_rfrc_eff_wk"	>
<input type="hidden" name="frm_rfrc_exp_yr"	>
<input type="hidden" name="frm_rfrc_exp_wk"	>
<input type="hidden" name="frm_prop_ofc_cd"	>
<input type="hidden" name="frm_prop_srep_cd"	>
<input type="hidden" name="frm_prop_srep_nm"	>
<input type="hidden" name="frm_cust_list"	>
<input type="hidden" name="frm_trd_cd"	>
<input type="hidden" name="frm_dir_cd"	>
<input type="hidden" name="frm_sub_trd_cd"	>
<input type="hidden" name="frm_rlane_cd"	>
<input type="hidden" name="frm_crg_tp_dry"		>
<input type="hidden" name="frm_crg_tp_dg"		>
<input type="hidden" name="frm_crg_tp_rf"		>
<input type="hidden" name="frm_crg_tp_ak"		>
<input type="hidden" name="frm_crg_tp_bb"		>
<input type="hidden" name="frm_profit_level">
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
    		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;<span id=TITLE_TEXT></span></td>
    		</tr>
    		</table>
    		<!-- : ( Title ) (E) -->
    		
    		<!-- : ( Search Options ) (S) -->
     
    			<table class="search"> 
           		<tr><td class="bg">
    			
    				<table class="search" border="0">
    				<tr><td class="title_h"></td>
    					<td class="title_s">Gross Revenue Detail (Contract Approval)</td>
    			<td align="right" class="sm">[Unit: <%=frm_pfmc_unit %>/USD]</td>
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
    				
    			
    		
    			
    				<table class="search" border="0" style="width:100%;"> 
    				<tr class="h23">
    					<td width="80" valign="TOP">Remark(s)</td>
    					<td class="SM">
    	
&raquo; Actual &nbsp;&nbsp;&nbsp;: Actual summary data as of previous week.<br>
&raquo; Estimate: Estimated Summary data for remaining period in contract based on the actual performance<br>    					
&raquo; Gross Revenue(Actual & Estimate) : The amount of Gross Revenue comes from containerized rating in BKG. So it can be different from the amount in main screen <BR>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;which is based on COA. 
    				</tr>	
    				</table>
    					
    			
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