<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_0006.jsp
*@FileTitle : S/C Guideline Copy
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
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.scguideline.scguidelinemain.event.EsmPri0006Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri0006Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.SCGuideline.SCGuidelineMain");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmPri0006Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="gline_seq" value="<%=JSPUtil.getNull(request.getParameter("gline_seq"))%>">
<input type="hidden" name="trgt_gline_seq" value="">
<input type="hidden" name="usr_id" value="<%=strUsr_id%>">

<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>S/C Guideline Copy</span></h2>
		
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_ok" id="btn_ok">Ok</button><!--
			--><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		</div>
	</div>
</div>

<div class="layer_popup_contents">
	<div class="wrap_search">
	<div class= "opus_design_inquiry">
		<!-- opus_design_inquiry(S) -->
		<table>
		<tr>
			<td style="text-align:center;">
				<table style="width:95%" class="sm">
				<tr>
				<td style="height:8px"></td>
				</tr><tr>
				<td><b>Service Scope</b></td>
				</tr>
				<tr>
				<td style="height:3px"></td>
				</tr>
				<tr>
				<td><input type="text" name="svc_scp_cd" style="width:80px;"  value="<%=JSPUtil.getNull(request.getParameter("svc_scp_cd"))%>" class="input2" readonly></td>
			    </tr></table>
			<td style="text-align:center">
			   <table style="width:98%" class="sm"><tr>
				<td colspan="2"><b>Duration</b></td>
				</tr>
				<tr><td>Effective </td>
			        <td>Expiration</td></tr>
				<tr><td><input type="text" name="eff_dt" value="<%=JSPUtil.getNull(request.getParameter("eff_dt"))%>" style="width:80px;"  class="input2" readonly></td>
				<td><input type="text" name="exp_dt" value="<%=JSPUtil.getNull(request.getParameter("exp_dt"))%>" style="width:80px;"  class="input2" readonly></td></tr>
				</table>
			</td>
			<td style="text-align:center">
				<table style="width:95%" class="sm">
				<tr>
				<td style="height:8px"></td>
				</tr><tr><tr>
				<td><b>Location<br>Group</b></td>
				<td><b>Commodity<br>Group</b></td>
				<td><b>Origin<br>Arbitrary</b></td>
				<td><b>Destination<br>Arbitrary</b></td>
				<td><b>Rate</b></td>
				<td><b>GOH</b></td></tr>
				<tr>
				<td><input type="checkbox" name="loc_grp" value="Y" class="trans"></td>
				<td><input type="checkbox" name="cmdt_grp" value="Y" class="trans"></td>
				<td><input type="checkbox" name="org_arb" value="Y" class="trans"></td>
				<td><input type="checkbox" name="dest_arb" value="Y" class="trans"></td>
				<td><input type="checkbox" name="rate" value="Y" class="trans"></td>
				<td><input type="checkbox" name="goh" value="Y" class="trans"></td></tr>
				</table>
			</td>
		</tr>
		</table>
		
		<!-- opus_design_inquiry(E) -->
	</div>
	</div>
	<div class="wrap_result">
		<div class="opus_design_grid" style="display:none">
			<script type="text/javascript">ComSheetObject('sheet1');</script>		
		</div>
		<h3 class="title_design" style="margin-bottom:0px">Copy To</h3>
		<div class="opus_design_inquiry wFit">
			 
	        <table>
            	<tr>
					<th>Service Scope</th>
					<td width="294px">
						<script type="text/javascript">ComComboObject('trgt_svc_scp_cd', 2, 50, 0, 1, 0, false);</script>
							&nbsp;<input name="trgt_svc_scp_nm" type="text" style="width:180px;"  value="" class="input2" readonly caption="Service Scope"></td>
					<th width="60">Duration</th>
					<td width="">
						<input type="text" name="trgt_eff_dt" coffield="trgt_exp_dt" value="" style="width:80;" class="input1" caption="Effective Date" maxlength="10" dataformat="ymd" required><!--
										--><button type="button" class="calendar ir" name="btns_calendar" id="btns_calendar"></button>
						<input type="text" name="trgt_exp_dt" coffield="trgt_eff_dt" value="" style="width:80;" class="input1" caption="Expire Date" maxlength="10" dataformat="ymd" required><!--
										--><button type="button" class="calendar ir" name="btns_calendar" id="btns_calendar"></button>
					</td>
				</tr>
	        </table>
        </div>
	</div>
	
	
</div>
	
</form>
