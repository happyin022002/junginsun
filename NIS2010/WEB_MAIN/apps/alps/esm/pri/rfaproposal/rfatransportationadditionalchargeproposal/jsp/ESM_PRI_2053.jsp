
<%/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESM_PRI_2051.jsp
*@FileTitle : RFA Proposal Creation - Arbitrary[Load Excel] (Add-On Tariff Management)
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.17
*@LastModifier : 이은섭
*@LastVersion : 1.0
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.vo.RsltPriRpScpArbKeyVO" %>
<%@ page import="com.hanjin.apps.alps.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.event.EsmPri2053Event"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.common.PRIUtil"%>
<%@ page import="java.util.List"%>
<%@ page import="com.hanjin.framework.core.config.SiteConfigFactory"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri2053Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	//부모창에서 넘어온 파라미터
	String svcScpCd		= "";
	String propNo		= "";
	String amdtSeq		= "";
	String orgDestTpCd	= "";
	String addChgTpCd	= "";
	String n1stCmncDt	= "";
	
	//COMBO CODE
	String[] rcvDeTermCd = null;    	//TERM
	String[] prcTrspModCd = null;    	//TRANS. MODE
	String[] prcCgoTpCd = null;    		//CARGO TYPE
	String[] ratUtCd = null;			//PER TYPE
	String[] currCd = null;				//CURRENCY
	String[] custDefCd = null;			//ACTUAL CUSTOMER
	
	String templateKey = null;
		
	Logger log = Logger.getLogger("com.hanjin.apps.RFAProposal.RFATransportationAdditionalChargeProposal");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmPri2053Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		//부모창에서 넘어노 파라미터
		RsltPriRpScpArbKeyVO rsltPriRpScpArbKeyVO = event.getRsltPriRpScpArbKeyVO();		
		if(rsltPriRpScpArbKeyVO != null) {
			propNo = rsltPriRpScpArbKeyVO.getPropNo();
			amdtSeq = rsltPriRpScpArbKeyVO.getAmdtSeq();
			svcScpCd = rsltPriRpScpArbKeyVO.getSvcScpCd();
			orgDestTpCd = rsltPriRpScpArbKeyVO.getOrgDestTpCd();
			addChgTpCd = rsltPriRpScpArbKeyVO.getAddChgTpCd();
			n1stCmncDt = rsltPriRpScpArbKeyVO.getN1stCmncDt();
		}
		
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		//COMMBO LIST
        rcvDeTermCd			= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("RCV_DE_TERM_CD"), false);
        prcTrspModCd 		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("PRC_TRSP_MOD_CD"), false);
        prcCgoTpCd 			= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("PRC_CGO_TP_CD"),false);
        ratUtCd 			= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("RAT_UT_CD"), false);      
        currCd 				= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("CURR_CD"), false);       
        custDefCd 			= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("CUST_DEF_CD"));  
     	
        // Excel Template File Key
        templateKey = (String)eventResponse.getCustomData("templateKey");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>RFA Proposal Creation - Arbitrary[Load Excel]</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
    var rcvDeTermCdComboValue = " |<%=rcvDeTermCd[0]%>";   
    var rcvDeTermCdComboText = " |<%=rcvDeTermCd[1]%>";
    
    var prcTrspModCdComboValue = " |<%=prcTrspModCd[0]%>";   
    var prcTrspModCdComboText = " |<%=prcTrspModCd[1]%>";
    
    var prcCgoTpCdComboValue = " |<%=prcCgoTpCd[0]%>";
    var prcCgoTpCdComboText = " |<%=prcCgoTpCd[1]%>";
       
    var ratUtCdComboValue = " |<%=ratUtCd[0]%>";   
    var ratUtCdComboText = " |<%=ratUtCd[1]%>";
    
    var currCdComboValue = "<%=currCd[0]%>";   
    var currCdComboText = "<%=currCd[1]%>";
     
    var custDefCdComboValue = " |<%=custDefCd[0]%>";   
    var custDefCdComboText = " |<%=custDefCd[1]%>";
    
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
<input type="hidden" name="svc_scp_cd" value="<%=svcScpCd %>">
<input type="hidden" name="prop_no" value="<%=propNo %>">
<input type="hidden" name="amdt_seq" value="<%=amdtSeq %>">
<input type="hidden" name="add_chg_tp_cd" value="<%=addChgTpCd %>">
<input type="hidden" name="org_dest_tp_cd" value="<%=orgDestTpCd %>">
<input type="hidden" name="n1st_cmnc_dt" value="<%=n1stCmncDt %>">
<input type="hidden" name="prop_sts_cd" value="<%=JSPUtil.getParameter(request, "prop_sts_cd") %>">
<input type="hidden" name="cd" >

<input type="hidden" name="eff_dt" value="<%=JSPUtil.getParameter(request, "eff_dt") %>">
<!-- OUTER - POPUP (S)tart -->
<table width="850" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;RFA Proposal Creation - Arbitrary [Load Excel]</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 			
			<table class="search"> 
       		<tr><td class="bg">
				<!--Grid (s)-->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table> 
				<!--Grid (E)-->
		    <!-- : ( Button : Grid ) (E) -->	
			
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->
</td></tr>
</table> 

<table class="height_5"><tr><td></td></tr></table>
	
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
		    	<td width=""><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				    <tr><td class="btn1_left"></td>
				    <td class="btn1" name="btn_Template">Template</td>
				    <td class="btn1_right"></td>
				    </tr></table>
				    </td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_file">Open File</td>
					<td class="btn1_right"></td>
				</tr></table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_check">Check</td>
					<td class="btn1_right"></td>
				</tr></table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save">Save</td>
					<td class="btn1_right"></td>
				</tr></table></td>
			<td class="btn1_line"></td>	
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close">Close</td>
					<td class="btn1_right"></td>
				</tr></table></td>
			</tr>
		</table>
    <!--Button (E) -->
		</td></tr>
</table>
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
<!-- Grid (S) -->
	<div style="display:block;">
	<table id="mainTable"> 
		<tr>
			<td>
				<script language="javascript">ComSheetObject('sheet2');</script>
			</td>
		</tr>
	</table>
	</div>	
<!-- Grid (E) -->
<!-- 개발자 작업  끝 -->
</form>
<form name="downform" action="/hanjin/FileDownload" method="post" target="downifm">
<input type="hidden" name="<%=SiteConfigFactory.get("COM.FILE.DOWNLOAD.KEY") %>" value="<%=templateKey%>">
</form>
<iframe name="downifm" style="display:none;"></iframe>
</body>
</html>