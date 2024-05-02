<%
/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESM_PRI_7011.jsp
*@FileTitle : Add-on Guideline Creation & Amendment
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.22
*@LastModifier : SEO MI JIN
*@LastVersion : 1.0
* 1.0 Creation
=========================================================
* History                                                
* 2013.03.16 전지예 [CHM-201534279] Pricing Feeder/IHC tariff 45" 칼럼 추가 안
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.tariff.feederchargeguideline.event.EsmPri7011Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.common.PRIUtil"%>
<%@ page import="com.hanjin.framework.component.util.code.CodeInfo"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>
<%
	EsmPri7011Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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
	String[] termCd = null;
	String[] srcInfoCd = null;
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_ofc = account.getOfc_cd();
	    
		event = (EsmPri7011Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");	
		termCd 	    = PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("RCV_DE_TERM_CD"), false);
		srcInfoCd 	= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("SRC_INFO_CD"), false);
        
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>   
<title>IHC Tariff Creation & Amendment</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
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
<input type="hidden" name="fdr_trf_no">
<input type="hidden" name="exp_dt">
<input type="hidden" name="svc_scp_cd">
<input type="hidden" name="in_svc_scp_cd" value="<%= JSPUtil.getParameter(request, "in_svc_scp_cd") %>" >
<input type="hidden" name="in_org_dest_tp_cd" value="<%= JSPUtil.getParameter(request, "in_org_dest_tp_cd") %>" >
<input type="hidden" name="menu_rhq_cd" value="<%=StringUtil.xssFilter(request.getParameter("rhq_cd"))%>">
<input type="hidden" name="cd">
<input type="hidden" name="etc1">
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
	</table>
	<!--Page Title, Historical (E)-->

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
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
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
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_amend">Amend</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_cancel">Cancel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_confirm">Confirm</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_dg_cgo_scg" id="btn_dg_cgo_scg">Add-on DG CGO SCHG</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>								
			</tr>
			</table>
		</td></tr>
		</table>
	<!--Button (E) -->
    
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">

				<!--  biz_1  (S) -->
				<table class="Search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="60">In/Out</td>
					<td width="100"><script language="javascript">ComComboObject('org_dest_tp_cd', 1, 90, 1, 1, 0, false);</script></td>								
					<td width="96">Service Scope</td>
					<td width="140"><script language="javascript">ComComboObject('svc_scp_combo', 2, 70, 0, 1, 0, false);</script></td>	
					<td width="160">Tariff No.</td>
					<td width="230"><input type="text" style="width:160;text-align:center;" class="input2" name="fdr_trf_no_view" readonly></td>
					<td width="110">AMD No.</td>
					<td width=""><input type="text" style="width:130;text-align:center;" class="input2" dataformat="int" name="amdt_seq" readonly ></td>
 				</tr>

				<tr class="h23">
					<td width="" colspan="2">Creation Date</td>
					<td width="" colspan="2"><input type="text" style="width:160;text-align:center;" class="input2" maxlength="10" dataformat="ymd" name="cre_dt" readonly></td>
					<td width="">Effective Date</td>
					<td width=""><input type="text" style="width:135;text-align:center;" class="input2" maxlength="10" dataformat="ymd" name="eff_dt" readonly>
					<img src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" name="btn_calendar"></td>
					<td width="">Confirm Date</td>
					<td width=""><input type="text" style="width:130;text-align:center;" class="input2" maxlength="10" dataformat="ymd" name="cfm_dt" readonly></td>				
				</tr>

				<tr class="h23">
					<td width="" colspan="2">Confirm Staff/Team</td>
					<td width="" colspan="2"><input type="text" style="width:160;text-align:center;" class="input2" name="cfm_usr" readonly></td>
					<td width="">Creation Staff/Team</td>
					<td width=""><input type="text" style="width:160;text-align:center;" class="input2" name="cre_usr" readonly></td>
					<td width="">Status</td>
					<td width=""><input type="text" style="width:130;text-align:center;" class="input2" name="fic_prop_sts_nm" readonly></td>				
				</tr>
				</table>
				<!--  biz_1   (E) -->
												
				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>																				
				
				<table class="search" border="0" style="width: 979;">                                                                                                                                                                                                                  
				<tr class="h23">                                                                                                                                                                                                                                                      
					<td width="210">Tariff Rate Adjustment : U$ 20'</td>
					<td width="40"><script language="javascript">ComComboObject('fix_percent_20', 1, 50, 0, 0, false);</script></td>	
					<td width="60"><input type="text" style="width:50;text-align:center;" class="input" name="flat_percent_20_app" maxlength="6" dataformat="apply"></td>	
	 				<td width="30">40'</td>										
					<td width="50"><script language="javascript">ComComboObject('fix_percent_40', 1, 50, 0, 0, false);</script></td>	
					<td width="60"><input type="text" style="width:50;text-align:center;" class="input" name="flat_percent_40_app" maxlength="6" dataformat="apply"></td>
					<td width="30">45'</td>
					<td width="50"><script language="javascript">ComComboObject('fix_percent_45', 1, 50, 0, 0, false);</script></td>
					<td width="140"><input type="text" style="width:50;text-align:center;" class="input" name="flat_percent_45_app" maxlength="6" dataformat="apply"></td>
					
					<td width="100">
						<input type="checkbox" name="cgoTpcd" style="border-style:none;" value="D">Dry&nbsp;
						<input type="checkbox" name="cgoTpcd" style="border-style:none;" value="R">RF&nbsp;
					</td>		
												
					<td><table width="80" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_apply">Apply</td>
					<td class="btn2_right"></td>
					</tr></table></td>	
					<td><table width="110" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_gl_tuning">Tariff Tuning</td>
					<td class="btn2_right"></td>
					</tr></table></td>	
																										
				</tr>                                                                                                                                                                                                                                                                                                                                                                                          
				</table>    
				
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
				<table width="100%" class="button">
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
						
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_load_excel">Load Excel</td>
						<td class="btn2_right"></td>
						</tr></table></td>																			
					</tr>
					</table>
				</td></tr>
			  	</table>
			  	<!-- Button_Sub (E) -->

				</td></tr>
			</table>
			
		<div id="flagLayer1" style="display:none">   
		<table>
			<tr>
			    <td width="">RHQ_CD</td>
				<td width=""><script language="javascript">ComComboObject('rhq_cd', 1, 80, 1, 0, 0, false);</script></td>
			</tr>	
		</table>
		</div>	
					
	<!--biz page (E)-->
                  
	</td></tr>
</table>
<div id="flagLayer1" style="display:none">
	<table width="979"  id="mainTable">
		<tr>
			<td width="100%">
				<script language="javascript">ComSheetObject('sheet2');</script>
			</td>
		</tr>
	</table>
</div>
</form>
</body>
</html>