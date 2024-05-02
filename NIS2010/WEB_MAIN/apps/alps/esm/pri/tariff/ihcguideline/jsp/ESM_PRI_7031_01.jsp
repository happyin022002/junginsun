<%
/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESM_PRI_7031_01.jsp
*@FileTitle : US Inland Add-on Creation & Amendment - Dry tab
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.07
*@LastModifier : SEO MI JIN
*@LastVersion : 1.0
* 1.0 Creation
=========================================================
* History                                                                            
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.event.EsmPri703101Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.common.PRIUtil"%>
<%@ page import="com.hanjin.framework.component.util.code.CodeInfo"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%
	EsmPri703101Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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
	    
		event = (EsmPri703101Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");	

		prcTrspModCd 	= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("PRC_TRSP_MOD_CD"), false);
		termCd 	= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("RCV_DE_TERM_CD"), false);
		srcInfoCd 	= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("SRC_INFO_CD"), false);
        
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>   
<title>Inland Add-on Creation & Amendment - Dry tab</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">

	var prcTrspModCdValue = " |<%=prcTrspModCd[0]%>";
	var prcTrspModCdText = " |<%=prcTrspModCd[1]%>";
	
	var termCdValue = " |<%=termCd[0]%>";
	var termCdText = " |<%=termCd[1]%>";
	
	var srcInfoCdValue = " |<%=srcInfoCd[0]%>";
	var srcInfoCdText = " |<%=srcInfoCd[1]%>";

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
<input type="hidden" name="prog_ofc_cd" value="<%=strUsr_ofc%>" >
<input type="hidden" name="fic_prop_sts_cd">
<input type="hidden" name="ihc_trf_no">
<input type="hidden" name="exp_dt">
<input type="hidden" name="svc_scp_cd">
<input type="hidden" name="amdt_seq">
<input type="hidden" name="eff_dt">    
<input type="hidden" name="cost_cnt_cd">
<input type="hidden" name="org_dest_tp_cd">
<input type="hidden" name="ihc_cgo_tp_cd">
<input type="hidden" name="locl_curr_cd">
<table width="100%" border="0" cellpadding="0" cellspacing="0">
	<tr><td valign="top">	
	
		<table class="search"> 
       	<tr><td class="bg">
       	
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save">Save</td>
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
			<table class="search" border="0" style="width: 979;">                                                                                                                                                                                                                  
			<tr class="h23">                                                                                                                                                                                                              
				<td width="120"></td>  
				<td width="190">Tariff Rate Adjustment : </td><td width="50">Rail</td><td width="50">U$ 20'</td>
				<td width="40"><script language="javascript">ComComboObject('flat_percent_20_rail_combo', 1, 50, 0, 0, false);</script></td>	
				<td width="60"><input type="text" style="width:50;text-align:center;" class="input" name="flat_percent_20_rail" maxlength="6" dataformat="apply"></td>	
 				<td width="30">40'</td>										
				<td width="50"><script language="javascript">ComComboObject('flat_percent_40_rail_combo', 1, 50, 0, 0, false);</script></td>	
				<td width="60"><input type="text" style="width:50;text-align:center;" class="input" name="flat_percent_40_rail" maxlength="6" dataformat="apply"></td>					
				<td><table width="70" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn2_left"></td>
				<td class="btn2" name="btn_apply_rail">Apply</td>
				<td class="btn2_right"></td>
				</tr></table></td>	
				<td><table width="110" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn2_left"></td>
				<td class="btn2" name="btn_gl_tuning_rail">Tariff Tuning</td>
				<td class="btn2_right"></td>
				</tr></table></td>	
				<td><table width="110" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn2_left"></td>
				<td class="btn2" name="btn_excel_update_rail">Excel Update</td>
				<td class="btn2_right"></td>
				</tr></table></td>	
				<td><table width="110" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn2_left"></td>
				<td class="btn2" name="btn_route_delete">Route Delete</td>
				<td class="btn2_right"></td>
				</tr></table></td>																		
			</tr>  
			<tr class="h23">                                                                                                                                                                                                              
				<td width="120"></td>  
				<td width="190"></td><td width="50">Truck</td><td width="50">U$ 20'</td>
				<td width="40"><script language="javascript">ComComboObject('flat_percent_20_truck_combo', 1, 50, 0, 0, false);</script></td>	
				<td width="60"><input type="text" style="width:50;text-align:center;" class="input" name="flat_percent_20_truck" maxlength="6" dataformat="apply"></td>	
 				<td width="30">40'</td>										
				<td width="50"><script language="javascript">ComComboObject('flat_percent_40_truck_combo', 1, 50, 0, 0, false);</script></td>	
				<td width="60"><input type="text" style="width:50;text-align:center;" class="input" name="flat_percent_40_truck" maxlength="6" dataformat="apply"></td>					
				<td><table width="70" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn2_left"></td>
				<td class="btn2" name="btn_apply_truck">Apply</td>
				<td class="btn2_right"></td>
				</tr></table></td>	
				<td><table width="110" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn2_left"></td>
				<td class="btn2" name="btn_gl_tuning_truck">Tariff Tuning</td>
				<td class="btn2_right"></td>
				</tr></table></td>	
				<td width="110"></td>																		
			</tr>                                                                                                                                                                                                                                                                                                                                                                                         
			</table> 
			<!-- Grid  (S) -->								
			<table width="100%"  id="mainTable">
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet3');</script>
					</td>
				</tr>
			</table>
			<!-- Grid (E) -->   
			
			<!-- Grid  (S) -->								
			<table width="100%"  id="mainTable">
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet1');</script>
					</td>
				</tr>
			</table>
			<!-- Grid (E) -->			
			
			<!--  Button_Sub (S) -->
			<table width="979" class="button">
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
				<tr>							
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_amend_down">Amend</td>
						<td class="btn2_right"></td>
						</tr></table></td>
						
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_cancel_down">Amend Cancel</td>
						<td class="btn2_right"></td>
						</tr></table></td>
						
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_delete_down">Delete</td>
						<td class="btn2_right"></td>
						</tr></table></td>	
						<td class="btn1_line"></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_add_down">Row Add</td>
						<td class="btn2_right"></td>
						</tr></table></td>		
						
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_down_excel">Down Excel</td>
						<td class="btn2_right"></td>
						</tr></table></td>																			
				</tr>
				</table>
			</td></tr>
		  	</table>
		  	<!-- Button_Sub (E) -->		  
					
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
		
		</td></tr>
	</table>
	
	</td></tr>
</table>
</form>
</body>
</html>