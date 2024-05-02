<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : EES_EQR_0069.jsp
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
	
	String returnval = ((request.getParameter("returnval")==null )?"":request.getParameter("returnval"));
	String sel_row = ((request.getParameter("returnval")==null )?"":request.getParameter("sel_row"));
	try {
		account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);

		event = (EesEqr0059Event)request.getAttribute("Event");
		
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		} // end if
		
		
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script type="text/javascript">
//Purpose

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
<input type="hidden" name="returnval" value="<%=returnval%>" id="returnval" />

<div class="layer_popup_title">

	<!-- page_title_area(S) -->
	<div class="page_title_area clear">

		<!-- page_title(S) -->
		<h2 class="page_title"><span>MIDDLE POINT</span></h2>
		<!-- page_title(E) -->
		
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<!-- <button type="button" class="btn_accent" name="btn_select" id="btn_select">Apply</button> -->
			<button type="button" class="btn_normal" name="btn_close" 		id="btn_close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->

	</div>
	<!-- page_title_area(E) -->

</div>

<div class="layer_popup_contents">

	<%-- <div class="wrap_search">
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
 --%>
	<div class="wrap_result">
		<div class="opus_design_grid clear" id="mainTable" >
			<div class="opus_design_btn">
				<button type="button" class="btn_accent" name="btn_RowAdd" id="btn_RowAdd">Row&nbsp;Add</button> 
				<button type="button" class="btn_normal" name="btn_Apply" id="btn_Apply">Apply</button>
				<button type="button" class="btn_normal" name="btn_loadexcel" id="btn_loadexcel" >Load Excel</button>
			</div>
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">	
			<script type="text/javascript">ComSheetObject('sheet1');</script>		
		</div>
		<!-- opus_design_grid(E) -->
		<div class= "opus_design_inquiry wFit">
				<table>
					<colgroup>
						<col width="*" />
					</colgroup>
					<tbody>
						<tr>
							<td>
					    		<b>Row Count&nbsp;:&nbsp;</b><input name="row_count" id="row_count" type="text" style="width:30px; height:19; text-align:right" value="1" maxlength="3" onFocus="javascript:select()">
					    	</td>
				    	</tr>
					</tbody>
				</table>
			</div>
	</div>
</div>
</form>