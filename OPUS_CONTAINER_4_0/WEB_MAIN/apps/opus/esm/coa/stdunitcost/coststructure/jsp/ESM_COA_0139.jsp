<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_0139.jsp
*@FileTitle  : Feeder Term
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/27
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.coa.stdunitcost.coststructure.event.EsmCoa0139Event"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmCoa0139Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Error from server
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//Count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.STDUnitCost.CostStructure");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmCoa0139Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}


	}catch(Exception e) {
        log.error("Exception : " + e.toString());
	}
%>

<head>
<title>Feeder Term Inquiry</title>


<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
		btn_Retrieve.focus();
	}
</script>
<form name="form" onKeyDown="ComKeyEnter();">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" 	id="btn_Retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_Reset" 		id="btn_Reset">Reset</button><!--
		--><button type="button" class="btn_normal" name="btn_Save" 		id="btn_Save">Save</button><!--
		--><button type="button" class="btn_normal" name="btn_DownExcel" 		id="btn_DownExcel">Down Excel</button><!--
		--><button type="button" class="btn_normal" name="btn_LoadExcel"  		id="btn_LoadExcel">Load Excel</button>	
	</div>
	<!-- opus_design_btn(E) -->
	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->


<!-- opus_design_inquiry(S) -->
<div class= "wrap_search">
	<div class= "opus_design_inquiry wFit">
		<table>
			<tbody>
				<colgroup>
					<col width="80"/>
					<col width="193"/>
					<col width="59"/>
					<col width="198"/>
					<col width="*"/>
			    </colgroup>
			    
			    	<tr class="h23">
						<th>Origin</th>
						<td width="15%">
							<input type="text" style="width:88px;" name="f_por" class="" value="" maxlength="5" dataformat="engup" onKeyPress="onlyEngNumber();" onkeyup="ComKeyEnter('LengthNextFocus');" id="f_por" /><!-- 
							 --><button type="button" id="btns_ficonsearch1" name="btns_ficonsearch1" class="input_seach_btn" onClick="openLocationCode('getFPor');"></button>
						</td>
						<th>Destination</th>
						<td width="15%">
							<input type="text" style="width:88px;" name="f_del" class="" value="" maxlength="5" dataformat="engup" onKeyPress="onlyEngNumber();" onKeyDown="ComKeyEnter();" id="f_del" /><!-- 
							 --><button type="button" id="btns_ficonsearch2" name="btns_ficonsearch2" class="input_seach_btn" onClick="openLocationCode('getFDel');"></button>
						</td>
						<th><a href="javascript:ComOpenWindow2('ESM_COA_0140.do?f_calc_term_cd=&f_wtr_term_cd=&sysCommUiTitle=Feeder Term Ratio','', 'width=900,height=500,menubar=no,scrollbars=no, resizable=yes')" class="purple">Feeder Term Ratio Inquiry</a></th>
                      </tr>
             	
			</tbody>
		</table>
	</div>
</div>
<!-- opus_design_inquiry(E) -->

<!-- opus_design_grid(S) -->
<div class="wrap_result">
	<div class="opus_design_grid clear" id="mainTable" >
			
			<!-- opus_design_btn(S) -->
			<div class="opus_design_btn">
				<button type="button" class="btn_accent" name="btng_RowAdd" 		id="btng_RowAdd">Row Add</button><!-- 
				 --><button type="button" class="btn_normal" name="btng_RowDel" 			id="btng_RowDel">Row Del.</button>		
			</div>
			<!-- opus_design_btn(E) -->
			<script type="text/javascript">ComSheetObject('sheet1');</script>
			<div><img src="/opuscntr/img/ico_star.gif" border="0" hspace="5">DoubleClick the Org / Dest Loc. to retrieve the RCV / DEL Ratio.</div>
	</div>
</div>
<!-- opus_design_grid(E) -->


</form>