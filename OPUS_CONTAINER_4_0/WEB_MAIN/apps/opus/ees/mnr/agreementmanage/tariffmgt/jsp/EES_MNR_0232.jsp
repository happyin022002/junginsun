<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName :  EES_MNR_0232.jsp
*@FileTitle : Disposal Tariff Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/21
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.event.EesMnr0232Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMnr0232Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	Logger log = Logger.getLogger("com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		event = (EesMnr0232Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	} catch(Exception e) {
		out.println(e.toString());
	}
%>

<script  type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		}
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" 		id="btn_Retrieve">Retrieve</button><!--  
		--><button type="button" class="btn_normal" name="btn_New" 			id="btn_New">New</button>			
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
	
</div>
<!-- page_title_area(E) -->

<div class="wrap_search_tab">
<div class="opus_design_inquiry wFit">
	<table>
	<colgroup>
       <col width="90" />
       <col width="1" />
       <col width="1" />
       <col width="60" />
       <col width="50" />
       <col width="75" />
       <col width="50" />
       <col width="*" />
     </colgroup>
	
		<tbody>
			<tr>
				<th>Effective Year/Quarter</th>
				<td>
					<input type="text" name="p_trf_eff_yr" id="p_trf_eff_yr" caption="Effective Year" style="width:60px;text-align:center;ime-mode:disabled;" class="input1" value="" maxlength="4" dataformat="yyyy" required fullfill><button type="button" class="calendar ir" name="btns_calendar1" id="btns_calendar1"></button>
				</td>
				<td>
					<select name="p_trf_eff_qtr_no" id="p_trf_eff_qtr_no" caption="Effective Quarter" style="width:90px;" onchange="obj_change();">
						<option value="">ALL</option>
						<option value="1">1/4 QTA</option>
						<option value="2">2/4 QTA</option>
						<option value="3">3/4 QTA</option>
						<option value="4">4/4 QTA</option>
	            	</select>
				</td>
				<th>EQ Type</th>
				<td>
					<select name="p_eq_knd_cd" id="p_eq_knd_cd" caption="EQ Type" style="width:90px;" class="input1"  onclick="obj_change();">
						<option value="U" selected>Container</option>
						<option value="Z">Chassis</option>
						<option value="G">M.G.Set</option>
	                </select>
				</td>
				<th>Location By</th>
				<td>
					<select name="p_loc_tp" id="p_loc_tp"  onclick="obj_change();">
						<option value="0">ALL (by RCC)</option>
						<option value="1">RCC (by LCC)</option>
						<option value="2">LCC (by SCC)</option>
	                </select><input type="text" name="p_loc_cd" id="p_loc_cd" caption="Location" style="width:60px;text-align:center;ime-mode:disabled;" class="input2" value="" maxlength="5" dataformat="engup" readonly><button type="button" name="btns_search" id="btns_search" class="input_seach_btn"></button>
				</td>
				<td></td>
			</tr>
		</tbody>
	</table>	
</div>
<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<!-- opus_tab_btn(S) -->
	<div class="opus_design_tab">
		<script type="text/javascript">ComTabObject('tab1')</script>
	</div>
	<!-- opus_tab_btn(E) -->
	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear" name="tabLayer" id="tabLayer">	
	
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_DownExcel1" 	id="btn_DownExcel1">Down Excel</button>				
		</div>
		<!-- opus_design_btn(E) -->
		
		<script type="text/javascript">ComSheetObject('t1sheet1');</script>	
	</div>
	<!-- opus_design_grid(E) -->
	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear" name="tabLayer" id="tabLayer">	
	
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_DownExcel2" 	id="btn_DownExcel2">Down Excel</button>				
		</div>
		<!-- opus_design_btn(E) -->
		
		<script type="text/javascript">ComSheetObject('t2sheet1');</script>	
	</div>
	<!-- opus_design_grid(E) -->
	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear" name="tabLayer" id="tabLayer">	
	
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_DownExcel3" 	id="btn_DownExcel3">Down Excel</button>				
		</div>
		<!-- opus_design_btn(E) -->
		
		<script type="text/javascript">ComSheetObject('t3sheet1');</script>	
	</div>
	<!-- opus_design_grid(E) -->
	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear" name="tabLayer" id="tabLayer">	
	
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_DownExcel4" 	id="btn_DownExcel4">Down Excel</button>				
		</div>
		<!-- opus_design_btn(E) -->
		
		<script type="text/javascript">ComSheetObject('t4sheet1');</script>	
	</div>
	<!-- opus_design_grid(E) -->
	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear"  name="tabLayer" id="tabLayer">
		<script type="text/javascript">ComSheetObject('t5sheet1');</script>	
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>