<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_PRI_2002.jsp
*@FileTitle  : Guideline Creation [Copy]
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/25
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
<%@ page import="com.clt.apps.opus.esm.pri.rfaguideline.rfaguidelinemain.event.EsmPri2002Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="java.util.List"%>

<%
	EsmPri2002Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
    String[] svcScpCds = null;

	Logger log = Logger.getLogger("com.clt.apps.RFAGuideline.RFAGuidelineMain");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmPri2002Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        // Service Scope Combo Data creation
        svcScpCds = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("svcScpCd"));

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script language="javascript">
    var svcScpComboValue = "<%=svcScpCds[0]%>";
    var svcScpComboText = "<%=svcScpCds[1]%>";

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
<input type="hidden" name="svc_scp_cd" value="<%=StringUtil.xssFilter(request.getParameter("svc_scp_cd")) %>">
<input type="hidden" name="gline_seq"  value="<%=StringUtil.xssFilter(request.getParameter("gline_seq")) %>">
<input type="hidden" name="usr_id"  value="<%=strUsr_id %>">



<!-- OUTER - POPUP (S)tart -->
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>Guideline Creation [Copy]</span></h2>
		
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_OK" id="btn_OK">OK</button><!--  -->
			<button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
		</div>
	</div>
</div>

<div class="layer_popup_contents" style="overflow:auto; overflow:hidden;">
	<div class="wrap_search">
		<div class="opus_design_grid">
			<script language="javascript">ComSheetObject('sheet1');</script>
		</div>
		<div class="opus_design_grid" style="display:none;">
            <script language="javascript">ComSheetObject('sheet2');</script>
        </div>
	</div>
	<div class="wrap_result">
		<div class="opus_design_inquiry">
			<h3>Copy To</h3>
			<table class="search" border="0" style="width:100%;">
	              <tr class="h23">
	                  <td width="90">Service Scope</td>
	                  <td width="300"><script language="javascript">ComComboObject('trgt_svc_scp_cd', 2, 55, 0, 1, 0, false);</script>
	                  &nbsp;<input name="trgt_svc_scp_nm" type="text" style="width:200;"  value="" class="input2" readonly="readonly" caption="Service Scope"></td>
	                  <td width="60">Duration</td>
	                  <td><input type="text" style="width:75;text-align:center;" name="trgt_eff_dt" cofield="trgt_exp_dt" value="" class="input1" caption="Effective Date" maxlength="10" dataformat="ymd" required>&nbsp;
	                  <button type="button" id="btns_calendar1" name="btns_calendar1" class="calendar ir"></button>
	                  <input type="text" style="width:75;text-align:center;" name="trgt_exp_dt" cofield="trgt_eff_dt" value="" class="input1" caption="Expire Date" maxlength="10" dataformat="ymd" required>&nbsp;
	                  <button type="button" id="btns_calendar2" name="btns_calendar2" class="calendar ir"></button>
	                  </td></tr>
             </table>
		</div>
	</div>
</div>

</form>
