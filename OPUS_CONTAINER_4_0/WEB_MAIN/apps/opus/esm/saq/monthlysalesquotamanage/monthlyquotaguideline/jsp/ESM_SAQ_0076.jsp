<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_SAQ_0076.jsp
*@FileTitle  : Master Version Creation 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaguideline.event.EsmSaq0076Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmSaq0076Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	Logger log = Logger.getLogger("com.clt.apps.MonthlySalesQuotaManage.MonthlyQuotaGuideline");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();


		event = (EsmSaq0076Event)request.getAttribute("Event");
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
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="mqtaMdlVerNo" id="mqtaMdlVerNo" />
<input type="hidden" name="slsFcastPubNo" id="slsFcastPubNo" />
<input type="hidden" name="inclPortFlag" id="inclPortFlag" />
<select name="newVersion" id="newVersion" class="input1" style="display:none"></select>

<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩  불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" 	id="btn_retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_new" 		id="btn_new">New</button><!--
		--><button type="button" class="btn_normal" name="btn_downexcel"  		id="btn_downexcel">Down Excel</button><!--
		<button type="button" class="btn_normal" name="btn_saveasnew"  		id="btn_saveasnew">Save As New Version</button>
		<button type="button" class="btn_normal" name="btn_cancelcurrent"  		id="btn_cancelcurrent">Cancel Current Version</button>
		--><button type="button" class="btn_accent" name="btn_confirmdraft" 	id="btn_confirmdraft">Confirm</button><!--
		--><button type="button" class="btn_normal" name="btn_cancelconfirmation" 		id="btn_cancelconfirmation">Cancel Confirmation</button><!--
		--><button type="button" class="btn_normal" name="btn_notifydraft"  		id="btn_notifydraft">Notify</button><!--
		--><button type="button" class="btn_normal" name="btn_cancelnotification"  		id="btn_cancelnotification">Cancel Notification</button><!--
		--><button type="button" class="btn_accent" name="btn_basedatacreation" id="btn_basedatacreation">Master Data Creation</button>	<!--	
		<button type="button" class="btn_accent" name="btn_saveasfinal" id="btn_saveasfinal">Master Version Creation</button>--><!--
		--><button type="button" class="btn_normal" name="btn_confirmasfinal"  		id="btn_confirmasfinal">Confirm As Final Version</button>
		<button type="button" class="btn_normal" name="btn_cancelfinal"  		id="btn_cancelfinal">Cancel Final Version</button>
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->

<div class= "wrap_search_tab">
<!-- opus_design_inquiry(S) -->
	<div class= "opus_design_inquiry">
		<table>
			<tbody>
				<colgroup>
					<col width="90px"/>
					<col width="120px"/>
					<col width="40px"/>
					<col width="120px"/>
					<col width="53px"/>
					<col width="120px"/>
					<col width="53px"/>
					<col width="225px"/>
					<col width="35px"/>
					<col width="*"/>
			    </colgroup>
				<tr>
					<th>Origin</th>
					<td><input type="text" name="ofcCd" class="input1" style="width: 80px;" value="<%=strOfc_cd%>" readonly id="ofcCd" /> </td>
					<th>Year</th>
					<td><select class="input1" name="year" id="year" style="width:80px;" onchange="version_change();"></select></td>
					<th>Quarter</th>
					<td colspan="5"><select class="input1" name="bse_qtr_cd" id="bse_qtr_cd" style="width:80px;" onchange="version_change();"></select></td>
				</tr>
				<tr>
					<th>Target Group</th>
					<td><script type="text/javascript">ComComboObject("targetGrp", 2, 80, 0, 1);</script></td>
					<th>Trade</th>
					<td><select name="trade" id="trade" class="input1" style="width:80px;"></select></td>
					<th>Bound</th>
					<td><select name="dirCd" id="dirCd" class="input1" style="width:80px;"></select></td>
					<th>Version</th>
					<td><select name="version" class="input1" style="width: 170px;" Onclick = "version_change();" ></select></td>
					<th>Unit</th>
					<td><select name="unit" id="unit" class="input1" style="width:80px;"></select></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<!-- opus_design_inquiry(E) -->
<div class="wrap_result">
	<!-- opus_tab_btn(S) -->
		<div class="opus_design_tab">
			<script type="text/javascript">ComTabObject('tab')</script>
		</div>
	<!-- opus_tab_btn(E) -->
	
	<div id="tabLayer" style="display:inline">
		<!-- opus_design_grid(S) -->
			<div class="opus_design_grid" style="text-align:right;">
			<table>
				<tr>
					<td width="1020"></td>
					<td width="180" style="text-align:right;">
						<span class="gray pad_btm_8" id="sheet_unit" name="sheet_unit" style="display:block;" >Unit : TEU / USD / USD 1,000*</span>
					</td>
					<td>
						<div class="opus_design_btn">
							<div id="div_zoom_in1" style="display:inline" class="grid_option_right"><button type="button" class="btn_down" name="bu_zoom_in1" title="Zoom in(+)"></button></div>
		       				<div id="div_zoom_out1" style="display:none" class="grid_option_right"><button type="button" class="btn_up" name="bu_zoom_out1"  title="Zoom out(-)" ></button></div>
		       			</div>
		       		</td>
		       	</tr>
	       	</table>
	       	<table>
				<tr><td height="5"></td>
				</tr>
			</table>
			<script type="text/javascript">ComSheetObject('tradeSheet');</script>
		</div>
		
		<!-- opus_design_grid(E) -->
	</div>
	
	<div id="tabLayer" style="display:none">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" style="text-align:right;">
			<table>
				<tr>
					<td width="1020"></td>
					<td width="180" style="text-align:right;">
						<span style="display:block;" class="gray pad_btm_8" id="sheet_unit" name="sheet_unit" >Unit : TEU / USD / USD 1,000*</span>
					</td>
					<td>
						<div class="opus_design_btn">
							<div id="div_zoom_in2" style="display:inline" class="grid_option_right"><button type="button" class="btn_down" name="bu_zoom_in2" title="Zoom in(+)"></button></div>
       						<div id="div_zoom_out2" style="display:none" class="grid_option_right"><button type="button" class="btn_up" name="bu_zoom_out2"  title="Zoom out(-)" ></button></div>
       					</div>
       				</td>
       			</tr>
       		</table>
			<table>
				<tr><td height="5"></td>
				</tr>
			</table>
			<script type="text/javascript">ComSheetObject('subTradeSheet');</script>
		</div>
		<!-- opus_design_grid(E) -->
	</div>
</div>

</form>