<%/*=========================================================
*Copyright(c) 2014 CyberLogitec All Rights Reserved
*@FileName : ui_bkg_0125.jsp
*@FileTitle : ACI_Vessel Information
*@author : CLT
*@version : 1.0
*@since : 2014.04.24
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.event.EsmBkg0125Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0125Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.wharfagemgt.wharfagedecmgt");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0125Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// get data from server when load page ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
	
%>

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
		document.getElementById("title").innerHTML = "Wharfage Cargo Classification - B/L Check";
	}
</script>

<form name="form" method="post">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="frm_attr_ctnt2">


<%
	String vvd       = (request.getParameter("vvd") == null)? "":request.getParameter("vvd");
	String portCd      = (request.getParameter("port_cd") == null)? "":request.getParameter("port_cd");
	String whfBndCd  = (request.getParameter("whf_bnd_cd") == null)? "":request.getParameter("whf_bnd_cd");
	String mrnNo     = (request.getParameter("mrn_no") == null)? "":request.getParameter("mrn_no");
%>


<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>Wharfage Cargo Classification - B/L Check</span></h2>
		
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
			--><button type="button" class="btn_normal" name="btn_downexcel">Down Excel</button><!--
			--><button type="button" class="btn_normal" name="btn_close">Close</button>
		</div>
	</div>
</div>

<!-- 검색영역 -->
<div class="layer_popup_contents">
	<div class="wrap_search">
		<div class="opus_design_inquiry wFit">		
				<table>
					<colgroup>
				  		<col width="60px"></col>
				  		<col width="115px"></col>
				  		<col width="31px"></col>
				  		<col width="*"></col>
				  	</colgroup> 			
					<tbody>
					<tr>
						<th title="Vessel Voyage Direction">VVD</th>
						<td><input type="text" style="width:100;" class="input1" name="vvd" dataformat="engup" maxlength="9" value="<%=vvd %>"></td>
						<th>Port</th>
						<td><input type="text" style="width:50;" class="input1" name="port_cd" dataformat="engup" maxlength="5" value="<%=portCd %>"></td>
					</tr> 
					<tr>
						<th>MRN NO</th>
						<td><input type="text" style="width:100;" class="input1" name="mrn_no" dataformat="engup" maxlength="11" value="<%=mrnNo %>"></td>
						<th>BND</th>
						<td><input type="text" style="width:50;" class="input1" name="io_bnd_cd" dataformat="engup" maxlength="2" value="<%=whfBndCd %>"></td>
					</tr> 
					</tbody>
				</table>
		</div>
	</div>
		<!-- 검색영역 -->
	<div class="wrap_result">
		<div class="opus_design_grid">		
			<script language="javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
</div>
</form>