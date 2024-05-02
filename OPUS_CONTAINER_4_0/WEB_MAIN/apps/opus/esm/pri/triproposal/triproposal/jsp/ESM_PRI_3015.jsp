<%  
/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_PRI_3015.jsp
 *@FileTitle : Publication Date Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier :
 *@LastVersion : 1.0
 =========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil" %>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.triproposal.triproposal.event.EsmPri3015Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
    EsmPri3015Event event = null; //PDTO(Data Transfer Object including Parameters)
    Exception serverException = null; //Error from Server
    String strErrMsg = ""; //Error Message
    int rowCount = 0; //Number of DB ResultSet List

    String successFlag = "";
    String codeList = "";
    String pageRows = "100";

    String strUsr_id = "";
    String strUsr_nm = "";
    Logger log = Logger.getLogger("com.clt.apps.TRIProposal.TRIRateProposal");

    try {
        SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();

        event = (EsmPri3015Event) request.getAttribute("Event");
        serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");        

    } catch (Exception e) {
        out.println(e.toString());
    }
%>
<html>
<head>
<title>Publication Date Creation</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            showErrMessage(errMessage);
        } // end if
        
        loadPage();
    }

</script>
</head>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<input type="hidden" name="amdt_seq" value="<%=StringUtil.xssFilter(request.getParameter("amdt_seq"))%>">
<input type="hidden" name="prop_sts_cd" value="<%=StringUtil.xssFilter(request.getParameter("prop_sts_cd"))%>">
<input type="hidden" name="is_req_usr" value="<%=StringUtil.xssFilter(request.getParameter("is_req_usr"))%>">
<input type="hidden" name="is_apro_usr" value="<%=StringUtil.xssFilter(request.getParameter("is_apro_usr"))%>">

<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span >Publication Date Creation</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_ok" id="btn_ok">Save</button>
			<button type="button" class="btn_normal" name="btn_close"  	id="btn_close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->
	</div>
	<!-- page_title_area(E) -->
</div>

<div class="layer_popup_contents">
	<div class="wrap_result">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">  
	    	<table>
			<tbody>
				<colgroup>
					<col width="55"/>
					<col width="200"/>
					<col width="80"/>
					<col width="*"/>
			    </colgroup>
				<tr class="h23">
					<th width="55">TRI No.</th>
					<td width="200"><input type="text" name="tri_no" style="width:120;text-align:center;" class="input2" value="<%=StringUtil.xssFilter(request.getParameter("tri_no"))%>" caption="TRI No." required readonly></td>
					<th width="80">Proposal No.</th>
					<td width=""><input type="text" name="tri_prop_no" style="width:80;text-align:center;" class="input2" value="<%=StringUtil.xssFilter(request.getParameter("tri_prop_no"))%>" caption="Proposal No." required readonly></td>
				</tr>
				
				<tr class="h23">
					<th width="">Duration</td>
					<td colspan="3"><input type="text" name="disp_eff_dt" style="width:75;text-align:center;" class="input2" value="<%=StringUtil.xssFilter(request.getParameter("eff_dt"))%>" caption="Effective date" cofield="disp_exp_dt" maxlength="10" dataformat="ymd" required readonly>
					 ~ <input type="text" name="disp_exp_dt" style="width:75;text-align:center;" class="input2" value="<%=StringUtil.xssFilter(request.getParameter("exp_dt"))%>" caption="Expiration date" cofield="disp_eff_dt" maxlength="10" dataformat="ymd" required readonly></td>
					
				</tr>
			</tbody>
		</table>
		</div>
		<table class="line_bluedot"><tr><td></td></tr></table>
		<div class="opus_design_inquiry wFit">    
		
		<table class="grid2"> 
				<tr class="">
					<th width="50%">Last Publication Date</th>
					<th width="">New Publication Date</th>	
				</tr>
				<tr class="h23">
					<td align="center" class="noinput2"><input type="text" name="last_pub_dt" style="width:100%;text-align:center;" class="noinput2" value="<%=StringUtil.xssFilter(request.getParameter("last_pub_dt"))%>" caption="Last Publication date" maxlength="10" dataformat="ymd" readonly></td>
					<td align="center" class="noinput1"><input type="text" name="pub_dt" style="width:100%;text-align:center;" class="noinput1" value="" caption="Publication date" maxlength="10" dataformat="ymd" required>
					<!-- img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"></td -->
				</tr>
		</table>
		<table class="grid2"> 
				<tr class="">
					<th width="50%">Current Expiration Date</th>
					<th width="">New Expiration Date</th>	
				</tr>
				<tr class="">
					<td align="center" class="noinput2"><input type="text" name="cur_exp_dt" style="width:100%;text-align:center;" class="noinput2" value="<%=StringUtil.xssFilter(request.getParameter("exp_dt"))%>" caption="Current Expiration date" maxlength="10" dataformat="ymd" readonly></td>
					<td align="center" class="noinput1"><input type="text" name="exp_dt" style="width:100%;text-align:center;" class="noinput1" value="<%=StringUtil.xssFilter(request.getParameter("exp_dt"))%>" caption="New Expiration date" maxlength="10" dataformat="ymd" required>
					<!-- img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"></td -->
				</tr>
		</table>		

		</div>
	</div>

	<div class="opus_design_grid">	
		<div id="hiddenSheetLayer" style="display: none">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
			</div>
	</div>
</div>
</form>