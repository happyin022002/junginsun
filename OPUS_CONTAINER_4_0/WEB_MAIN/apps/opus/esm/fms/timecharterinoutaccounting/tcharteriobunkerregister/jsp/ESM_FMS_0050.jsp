<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_FMS_0050.jsp
*@FileTitle  : BunkerDataManagement
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/23
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.event.EsmFms0050Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmFms0050Event event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException = null;			//Error from Server
	String strErrMsg = "";						//Error Message

	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.clt.apps.TimeCharterInOutAccounting.TCharterIOBunkerRegister");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmFms0050Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		//Adding Logic extracting data from server when loading initial window ..
		//GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	} catch(Exception ex) {
		log.error("err " + ex.toString(), ex);
		//out.println(e.toString());
	}
%>
<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
<form name="form">  
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="ibflag" id="ibflag" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="curr_vsl_cd" id="curr_vsl_cd" />
<input type="hidden" name="curr_port_cd" id="curr_port_cd" />
<input type="hidden" name="bunker_dt" id="bunker_dt" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
	<button class="btn_accent" name="btn_retrieve" id="btn_retrieve" type="button">Retrieve</button><!--
	--><button class="btn_normal" name="btn_new" id="btn_new" type="button">New</button><!--
	--><button class="btn_normal" name="btn_save" id="btn_save" type="button">Save</button><!--
	--><button class="btn_normal" name="btn_savetofile" id="btn_savetofile" type="button">Down&nbsp;Excel</button><!--
	--></div>
<!-- opus_design_btn (E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->
<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="75" />				
				<col width="235" />				
				<col width="85" />				
				<col width="170" />				
				<col width="80" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr><th>Vessel Code</th>
					<td><input type="text" onchange="vsl_cd_change()" style="width:54px;text-align:center;" class="input1" dataformat = "engup" maxlength="4" name="vsl_cd" required=""  caption="Vessel Code" id="vsl_cd" /><button type="button" id="btn_vslpop" name="btn_vslpop" class="input_seach_btn"></button><input type="text" style="width:122px;" class="input2" name="vsl_eng_nm" readonly id="vsl_eng_nm" /> </td>
				    <th>Contract No.</th>
					<td><input type="text" style="width:120px;text-align:center;" class="input1" name="flet_ctrt_no"  caption="Contract No." readonly id="flet_ctrt_no" /><button type="button" id="contract_no" name="contract_no" class="input_seach_btn"></button></td>
					<th>Contract TP</th>
	                <td><input type="text" style="width:80px;" class="input2" name="flet_ctrt_tp_cd" alt="" border="0" align="absmiddle" readonly id="flet_ctrt_tp_cd" /> </td>
		   		</tr>
		   </tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button class="btn_accent" name="btn_add" id="btn_add" type="button">Row Add</button><!--
			--><button class="btn_normal" name="btn_ins" id="btn_ins" type="button">Row Ins</button><!--
			--><button class="btn_normal" name="btn_del" id="btn_del" type="button">Row Del</button><!--
			--></div>
		<!-- opus_design_btn (E) -->
		<script type="text/javascript">ComSheetObject('sheet1');</script>		
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>