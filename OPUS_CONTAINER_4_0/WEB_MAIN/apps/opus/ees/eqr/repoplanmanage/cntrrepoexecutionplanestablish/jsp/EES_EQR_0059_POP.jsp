<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : EES_EQR_0059.jsp
*@FileTitle : Execution Plan
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/23
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.event.EesEqr0059Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.StringUtil"%>
<%
	EesEqr0059Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Error occurred on the server
	DBRowSet rowSet	  = null;							   //DB ResultSet
	String strErrMsg = "";								 //Error message
	int rowCount	 = 0;								  //DB ResultSet List the number of
	
	SignOnUserAccount account = null;
	String strFmYdCd = "";
	String strToYdCd = "";
	String strFmEtdDt = "";
	String strToEtaDt = "";
	String strTpszValue = "";
	try {
		account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);

		event = (EesEqr0059Event)request.getAttribute("Event");

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		} // end if
		
		strFmYdCd = (request.getParameter("fm_yd_cd") == null)? "": request.getParameter("fm_yd_cd");
		strToYdCd = (request.getParameter("to_yd_cd") == null)? "": request.getParameter("to_yd_cd");
		
		strFmEtdDt = (request.getParameter("fm_etd_dt") == null)? "": request.getParameter("fm_etd_dt");
		strToEtaDt = (request.getParameter("to_eta_dt") == null)? "": request.getParameter("to_eta_dt");
		strTpszValue = (request.getParameter("tpsz_value") == null)? "": request.getParameter("tpsz_value");
		
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script type="text/javascript">
//Purpose
<%= JSPUtil.getIBCodeCombo("purpose", "01", "CD00269", 0, " ")%>

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form method="post" name="form">
<input id="f_cmd" name="f_cmd" type="hidden" />
<input id="iPage" name="iPage" type="hidden" />
<input id="cntrno" name="cntrno" type="hidden" />
<input id="cntrno_all" name="cntrno_all" type="hidden" />

<input id="fm_etd_dt" name="fm_etd_dt" type="hidden" value="<%=StringUtil.xssFilter(strFmEtdDt) %>" />
<input id="to_eta_dt" name="to_eta_dt" type="hidden" value="<%=StringUtil.xssFilter(strToEtaDt) %>" />
<input id="tpsz_value" name="tpsz_value" type="hidden" value="<%=StringUtil.xssFilter(strTpszValue) %>" />

<div class="layer_popup_title">

	<!-- page_title_area(S) -->
	<div class="page_title_area clear">

		<!-- page_title(S) -->
		<h2 class="page_title"><span>IRG Selection for USA Rail</span></h2>
		<!-- page_title(E) -->
		
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_select" id="btn_select">Apply</button>
			<button type="button" class="btn_normal" name="btn_close" 		id="btn_close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->

	</div>
	<!-- page_title_area(E) -->

</div>

<div class="layer_popup_contents">

	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="80px"/>
					<col width="80px" />
					<col width="80px"/>
					<col width="*" />						
				</colgroup> 
				<tr>
					<th>From</th>
					<td><input type='text' name="fm_yd_cd" id="fm_yd_cd" style='width:100px;ime-mode:disabled;text-align:center;text-transform:uppercase;' class="input2" value='<%=StringUtil.xssFilter(strFmYdCd) %>' maxlength="11" dataformat="engup" disabled></td>
					<th>To</th>
					<td><input type='text' name="to_yd_cd" id="to_yd_cd" style='width:100px;ime-mode:disabled;text-align:center;text-transform:uppercase;' class="input2" value='<%=StringUtil.xssFilter(strToYdCd) %>' maxlength="11" dataformat="engup" disabled></td>
					
				</tr>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>

	<div class="wrap_result">

		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">	
			<script type="text/javascript">ComSheetObject('sheet1');</script>		
		</div>
		<!-- opus_design_grid(E) -->
		
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" style="displany:none">	
			<script type="text/javascript">ComSheetObject('sheet2');</script>		
		</div>
		<!-- opus_design_grid(E) -->
		
	</div>
</div>
</form>