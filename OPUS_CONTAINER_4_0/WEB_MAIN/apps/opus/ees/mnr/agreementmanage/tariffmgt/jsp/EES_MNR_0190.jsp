<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_0190.jsp
*@FileTitle  : Local Tariff File Import_Pop Up
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/13
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.event.EesMnr0190Event"%>
<%@ page import="com.clt.framework.component.util.StringUtil" %>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMnr0190Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//count of DB resultSet list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	String eqTypeCd 		= StringUtil.xssFilter(request.getParameter("eqTypeCd"));
	String programId		= "";
	String stdTrfNo			= "";
	if(request.getParameter("programId")!=null){
		programId = StringUtil.xssFilter(request.getParameter("programId"));
	}
	if(request.getParameter("stdTrfNo")!=null){
		stdTrfNo = StringUtil.xssFilter(request.getParameter("stdTrfNo"));
	}

	Logger log = Logger.getLogger("com.clt.apps.AgreementManage.TariffMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();


		event = (EesMnr0190Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// adding logic to get data from sever when first loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
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
<input type="hidden" name="eq_knd_cd" value="<%=eqTypeCd %>" id="eq_knd_cd" />
<input type="hidden" name="program_id" value="<%=programId %>" id="program_id" />
<input type="hidden" name="std_trf_no" value="<%=stdTrfNo %>" id="std_trf_no" />
<input type="hidden" name="pagerows" id="pagerows" />
<div class="layer_popup_contents">
	<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<h2 class="page_title"><span  id="title1">Tariff File Import</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_new" 	id="btn_new">New</button><!--
			--><button type="button" class="btn_normal" name="btn_downExcel" id="btn_downExcel">Format Down Excel</button><!--
			--><button type="button" class="btn_normal" name="btn_loadExcel" id="btn_loadExcel">Load Excel</button><!--
			--><button type="button" class="btn_normal" name="btn_ok" id="btn_ok">Ok</button><!--
			--><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button><!--
		--></div>
		<!-- opus_design_btn(E) -->
		<!-- page_location(S) -->
		<div class="location">
			<span id="navigation"></span>
		</div>
		<!-- page_location(E) -->
	</div>
	<!-- page_title_area(E) -->
	</div>
	<!-- opus_design_grid(S) -->	
	<div class="wrap_result">
		<div class="opus_design_grid clear" id="mainTable" >
			<div class="opus_design_btn">
				<button type="button" class="btn_accent" name="btn_Save" 	id="btn_Save">Verify</button><!--
				--><button type="button" class="btn_normal" name="btn_RowAdd" id="btn_RowAdd">Row Add</button><!--
				--><button type="button" class="btn_normal" name="btn_RowDel" id="btn_RowDel">Row Delete</button><!--
			--></div>
				<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	<!-- opus_design_grid(E) -->
		<div class= "opus_design_data">
			<h3 class="title_design"  id="title2" name="title2" >Local Tariff File Format</h3>
			<table class="grid_2 wAuto">
				<colgroup>
					<col width="100" />
					<col width="100" />
					<col width="60" />
					<col width="40" />
					<col width="200" />
					<col width="100" />
					<col width="50" />
					<col width="50" />
					<col width="50" />
					<col width="50" />
					<col width="50" />
					<col width="50" />
					<col width="80" />
					<col width="80" />
				</colgroup>  
				<tr>
					<th>Cost Group Code</th>
					<th>Component</th>
					<th>Repair</th>
					<th>Div</th>
					<th>Description</th>
					<th>Range Type</th>
					<th>Type</th>
					<th>QTY</th>
					<th>SIZE</th>
					<th>Fm</th>
					<th>To</th>
					<th>Man-Hour</th>
					<th id="materialName" name="materialName" >Material</th>
					<th>Remark</th>
				</tr>  
				<tr> 
					<td align="center">MRDR</td>
					<td align="center">RBO</td>
					<td align="center">AJ</td>
					<td align="center">CC</td>
					<td align="center">[RBO] - [AJ]Adjust - [CC]</td>
					<td align="center">F</td>
					<td align="center">Q</td>
					<td align="center">1</td>
					<td align="center">0</td>
					<td align="center">0</td>
					<td align="center">0</td>
					<td align="center">11.00</td>
					<td align="center" id="materialValue" name="materialValue" >0.00</td>
					<td align="center"></td>
				</tr>       
			</table> 		
		</div>
	</div>	
</div>
</form>
<script type="text/javascript">ComSheetObject('sheet2');</script>			