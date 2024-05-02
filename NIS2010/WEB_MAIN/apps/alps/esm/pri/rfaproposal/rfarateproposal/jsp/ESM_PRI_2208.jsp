<%  
/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_PRI_2208.jsp
 *@FileTitle : RFA Proposal Creation - Rate [Load Excel] (H Type)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2016.04.14
 *@LastModifier : 박근환
 *@LastVersion : 1.0
 * 2016.04.14 박근환
 * 1.0 Creation
 =========================================================
 * History
 * [CHM-201640671] RFA 효율화를 위한 요청 (1차)
 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.event.EsmPri2208Event"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.common.PRIUtil"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@ page import="com.hanjin.framework.core.config.SiteConfigFactory"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>
<%@ page import="java.util.List"%>

<%
    EsmPri2208Event event = null; //PDTO(Data Transfer Object including Parameters)
    Exception serverException = null; //서버에서 발생한 에러
    String strErrMsg = ""; //에러메세지
    int rowCount = 0; //DB ResultSet 리스트의 건수

    String successFlag = "";
    String codeList = "";
    String pageRows = "100";

    String strUsr_id = "";
    String strUsr_nm = "";
    Logger log = Logger.getLogger("com.hanjin.apps.RFAProposal.RFARateProposal");
    String templateKey = null;

	String[] rtApplTpCd = null;		    //APLICATION
	String[] currCd = null;				//CURRENCY	
	String[] ruleCd = null;				//NOTE CONVERSION RULE CODE 
	String[] chargeCd = null;    		//SCOPE CHARGE CODE LIST
	String[] payTermCd = null;    		//PAY TERM
		
    try {
        SignOnUserAccount account = (SignOnUserAccount) session
                .getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();

        event = (EsmPri2208Event) request.getAttribute("Event");
        serverException = (Exception) request
                .getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        
        templateKey = (String)eventResponse.getCustomData("TEMPLATE_KEY");
        
	    //COMMBO LIST	    
		ruleCd 			= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("RULE_CD"), false);
	    chargeCd 		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("CHARGE_CD"));
		rtApplTpCd 		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("RT_APPL_TP_CD"), false);
		currCd 			= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("CURR_CD"), false);
		payTermCd 		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("PAY_TERM_CD"), false);
		
    } catch (Exception e) {
        out.println(e.toString());
    }
%>
<html>
<head>
<title>RFA Proposal Creation - Rate [Load Excel] (H Type)</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">	 
	var chargeRuleCdComboValue = "<%=ruleCd[0]%>"; 
	chargeRuleCdComboValue = chargeRuleCdComboValue + " |OFT";
	var chargeRuleCdComboText = "<%=ruleCd[1]%>";  
	chargeRuleCdComboText = chargeRuleCdComboText + " |OFT";
	
	var rtApplTpCdComboValue = " |<%=rtApplTpCd[0]%>";
	var rtApplTpCdComboText = " |<%=rtApplTpCd[1]%>";

	var currCdComboValue = "<%=currCd[0]%>";   
	var currCdComboText = "<%=currCd[1]%>";

	var payTermCdComboValue = " |<%=payTermCd[0]%>";   
	var payTermCdComboText = " |<%=payTermCd[1]%>";
    
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            showErrMessage(errMessage);
        } // end if
        
        loadPage();
    }

</script>
</head>

<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업 -->
<input type="hidden" name="prop_no" value="<%=StringUtil.xssFilter(request.getParameter("prop_no"))%>">
<input type="hidden" name="amdt_seq" value="<%=StringUtil.xssFilter(request.getParameter("amdt_seq"))%>">
<input type="hidden" name="svc_scp_cd" value="<%=StringUtil.xssFilter(request.getParameter("svc_scp_cd"))%>">
<input type="hidden" name="pre_amdt_seq" value="<%=StringUtil.xssFilter(request.getParameter("pre_amdt_seq"))%>">
<input type="hidden" name="prc_prop_sts_cd" value="<%=StringUtil.xssFilter(request.getParameter("prc_prop_sts_cd"))%>">
<input type="hidden" name="eff_dt" value="<%=StringUtil.xssFilter(request.getParameter("eff_dt"))%>">
<input type="hidden" name="exp_dt" value="<%=StringUtil.xssFilter(request.getParameter("exp_dt"))%>">
<input type="hidden" name="pre_exp_dt" value="<%=StringUtil.xssFilter(request.getParameter("pre_exp_dt"))%>">
<input type="hidden" name="is_req_usr" value="<%=StringUtil.xssFilter(request.getParameter("is_req_usr"))%>">
<input type="hidden" name="is_apro_usr" value="<%=StringUtil.xssFilter(request.getParameter("is_apro_usr"))%>">
<input type="hidden" name="dur_dup_flg" value="<%=StringUtil.xssFilter(request.getParameter("dur_dup_flg"))%>">
<input type="hidden" name="ctrt_eff_dt" value="<%=StringUtil.xssFilter(request.getParameter("ctrt_eff_dt"))%>">
<input type="hidden" name="ctrt_exp_dt" value="<%=StringUtil.xssFilter(request.getParameter("ctrt_exp_dt"))%>">
<input type="hidden" name="fic_rt_tp_cd" value="<%=JSPUtil.getParameter(request, "fic_rt_tp_cd") %>">
<!-- OUTER - POPUP (S)tart -->
<table width="950" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
	<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;RFA Proposal Creation - Rate [Load Excel] (H Type)</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 			
			<table class="search"> 
       		<tr><td class="bg">
				<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
                <table width="100%"  id="mainTable" style="display:none;">
                    <tr>
                        <td width="100%">
                            <script language="javascript">ComSheetObject('sheet2');</script>
                        </td>
                    </tr>
                </table>
						<!-- Grid (E) -->
				</td></tr>
			</table>
	
	<!--biz page (E)-->
	
<table class="height_5"><tr><td></td></tr></table>
	
	</td></tr>
</table>	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
                <td width=""><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_template">Template</td>
                    <td class="btn1_right"></td>
                    </tr></table>
                    </td>
				<td width=""><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_openfile">Open&nbsp;File</td>
					<td class="btn1_right"></td>
					</tr></table>
				</td>
				<td width=""><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_downexcel">Down&nbsp;Excel</td>
                    <td class="btn1_right"></td>
                    </tr></table>
                </td>
				<td width="72"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_check">Check</td>
					<td class="btn1_right"></td>
					</tr></table>
				</td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left">
					<td class="btn1" name="btn_save">Save</td>
					<td class="btn1_right">
				</table></td>
				<td class="btn1_line"></td>
				<td width="72"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close">Close</td>
					<td class="btn1_right"></td>
					</tr></table>
				</td></tr>
		</table></td></tr>
		</table>
		
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->

</form>
<form name="downform" action="/hanjin/FileDownload" method="post">
<input type="hidden" name="<%=SiteConfigFactory.get("COM.FILE.DOWNLOAD.KEY") %>" value="<%=templateKey%>">
</form>
</body>
</html>

