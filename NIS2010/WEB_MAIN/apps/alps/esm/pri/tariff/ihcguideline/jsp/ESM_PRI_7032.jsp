<%
/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESM_PRI_7032.jsp
*@FileTitle : Inland add-on amendment history
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.16
*@LastModifier : CHLOE MIJIN SEO
*@LastVersion : 1.0
* 2012.11.16 CHLOE MIJIN SEO
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
<%@ page import="com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.event.EsmPri7032Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.common.PRIUtil"%>
<%@ page import="com.hanjin.framework.component.util.code.CodeInfo"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%
	EsmPri7032Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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

	String[] prcTrspModCd = null;
	String[] termCd = null;
	String[] srcInfoCd = null;
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_ofc = account.getOfc_cd();
	    
		event = (EsmPri7032Event)request.getAttribute("Event");
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
<title>Inland add-on amendment history</title>
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
<input type="hidden" name="cd" value="NYCRA">
<input type="hidden" name="rhq_cd" value="NYCRA">
<input type="hidden" name="etc1">
<input type="hidden" name="etc2">

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
			</tr>
			</table>
		</td></tr>
		</table>
	<!--Button (E) -->
    
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">

				<!--  biz_1  (S) -->
				<table class="Search" border="0" style="width: 979;"> 
				<tr class="h23">
					<td width="60">In/Out</td>
					<td width="120"><script language="javascript">ComComboObject('org_dest_tp_cd', 1, 100, 1, 1, 0, false);</script></td>	
					<td width="80">Country</td>
					<td width="100"><script language="javascript">ComComboObject('cost_cnt_cd', 2, 60, 1, 1, 0, false);</script></td>
					<td width="100">Service Scope</td>
					<td width="100"><script language="javascript">ComComboObject('svc_scp_cd', 2, 80, 0, 1, 0, false);</script></td>																										
					<td width="80">Tariff No.</td>
					<td width="170"><script language="javascript">ComComboObject('ihc_trf_no', 1, 150, 1, 1, 1, false);</script></td>
					<td width="80">AMD No.</td>
					<td width=""><input type="text" style="width:75;text-align:center;" class="input2" dataformat="int" name="amdt_seq" readonly ></td>
 				</tr>
 				</table>
				<!--  biz_1   (E) -->
												
				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>																				
				
				<!-- Grid  (S) -->								
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				<!-- Grid (E) -->						

				</td></tr>
			</table>
					
		<!--biz page (E)-->

		<table class="height_8"><tr><td></td></tr></table>
		
		<!-- Tab ) (S) -->
    	<table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%>
      		<tr><td width="100%">
					<script language="javascript">ComTabObject('tab1')</script>
			</td></tr>
		</table>
		<!-- Tab ) (E) -->
	
		<!-- iFrame (S) -->
           <div id="tabLayer" style="display:none">
           <iframe name="t1frame" id="t1frame" frameborder="0" scrolling="no" width="100%" height="300" src="about:blank"></iframe>
           </div>
           <div id="tabLayer" style="display:none">
           <iframe name="t2frame" id="t2frame" frameborder="0" scrolling="no" width="100%" height="300" src="about:blank"></iframe>
           </div>
		<!-- iFrame (E) --> 
		
		<table class="height_8"><tr><td colspan="8"></td></tr></table>   
                  
	</td></tr>
</table>
<div id="flagLayer1" style="display:none">
	<table width="979"  id="mainTable">
		<tr>
			<td width="100%">
				<script language="javascript">ComSheetObject('sheet3');</script>
			</td>
		</tr>
	</table>
</div>
</form>
</body>
</html>