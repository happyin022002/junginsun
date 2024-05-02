<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_0157.jsp
*@FileTitle  : Agent Other Commission Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/27
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.coa.stdunitcost.agencycommission.event.EsmCoa0157Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmCoa0157Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Error from server
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//Count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String f_cost_yrmon = JSPUtil.getNullNoTrim(request.getParameter("f_cost_yrmon"));
	String f_comm_loc_cd = JSPUtil.getNullNoTrim(request.getParameter("f_comm_loc_cd"));
	Logger log = Logger.getLogger("com.clt.apps.STDUnitCost.AgencyCommission");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmCoa0157Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		  log.error("Exception : " + e.toString());
	}
%>



<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
		ComSetFocus(document.form.f_cost_yrmon);
	}
</script>

<form method="post" name="form" onKeyUp="ComKeyEnter();">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />


<div class="page_title_area clear">
   <!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" 	id="btn_Retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_Creation" 		id="btn_DownExcel">Creation</button><!--
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
					<col width="*"/>
			    </colgroup>
			    <tr>
					<th>YYYY-MM</th>
					<td><input type="text" name="f_cost_yrmon" class="input1" style="width:60px;" value="" maxlength="6" dataformat="ym" onKeyDown="ComKeyEnter();" id="f_cost_yrmon" /> </td>
					<th>Location</th>
					<td><script type="text/javascript">ComComboObject('f_comm_loc_cd',1, 100 , 0 )</script></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<!-- opus_design_inquiry(E) -->
<div class="wrap_result">
	
	<div class= "opus_design_grid" id="mainTable">
		
			<table>
				<tr><td width="500px"><h3 class="title_design">Agent Other Commission Inquiry</h3></td>
				<td align="right">
				<div class="opus_design_btn">
					<button type="button" class="btn_accent" name="btng_RowAdd" id="btng_RowAdd" >Row Add</button><!--
        			--><button type="button" class="btn_accent" name="btng_Save" id="btng_Save" >Save</button>					
				</div>
				</td>
					<td align="right" width="35px">
					
        				<div class="opus_design_btn">
							<div id="div_zoom_in" style="display:inline; ">
							 <button type="button" class="btn_down" name="bu_zoom_in" id="bu_zoom_in" title="Zoom in(+)" style="margin-bottom:3px"></button>
						 </div>
						 <div id="div_zoom_out" style="display:none">
							 <button type="button" class="btn_up" name="bu_zoom_out" id="bu_zoom_out"  title="Zoom out(-)" style="margin-bottom:3px" ></button>
						 </div>
						</div>
					</td>
				</tr>
			</table>		
				<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>	
	
	
	
	
	
	
</div>


</form>




<!-- Developer DIV	END -->