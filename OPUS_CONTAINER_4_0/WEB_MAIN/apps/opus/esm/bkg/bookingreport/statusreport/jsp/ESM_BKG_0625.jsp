<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0625.jsp
*@FileTitle  : VIP Customer Report
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/10
=========================================================*/
%>


<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page
	import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page
	import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingreport.statusreport.event.EsmBkg0625Event"%>	
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg0625Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "50";

	String strUsr_id = "";
	String strUsr_nm = "";
	String rpt_nm = JSPUtil.getNull(request.getParameter("rpt_nm")); ;

	boolean bBtn_Disabled = true;
	Logger log = Logger.getLogger("com.clt.apps.opus.esm.bkg.bookingreport.statusreport");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0625Event) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException)
					.loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request
				.getAttribute("EventResponse");

	} catch (Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
	var paramReportName="<%=rpt_nm%>";
</script>

<div id="debug"></div>
<!-- 개발자 작업	-->

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" type="button" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--
		--><button class="btn_normal"  type="button" name="btn_New" id="btn_New">New</button><!--
		--><button class="btn_normal"  type="button" name="btn_DownExcel" id="btn_DownExcel">Down Excel</button><!--
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
	
		<!--  biz_1  (S) -->
		<form method="post" name="tempform" id="tempform" onSubmit="return false;"> 
			<table>
				<colgroup>
					<col width="70" />	
					<col width="240" />							
					<col width="*" />				
			   </colgroup>  
				<tbody>
					<tr>
						<th>Report Type</th>
						<td><script type="text/javascript">ComComboObject('report_type', 1, 240, '');</script><!-- 
						--><button class="btn_etc" type="button" name="btn_ReportTemplate" id="btn_ReportTemplate">Report&nbsp;Template</button></td>
						<td></td>
					</tr>	
				</tbody>
			</table>		
		</form>
		</div>
		<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
		
<!--  biz_1   (E) -->

<!-- ********************************************* Form Start  ********************************************* -->	
<form method="post" name="form" id="form" onSubmit="return false;" style="margin-top:-1">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="select_list" id="select_list" />
<input type="hidden" name="p_bkg_rpt_knd_cd" value="V" id="p_bkg_rpt_knd_cd" />
<input type="hidden" name="p_grid_type" value="G" id="p_grid_type" />
<input type="hidden" name="curr_page" value="1" id="curr_page" />
<input type="hidden" name="rows_per_page" value="50" id="rows_per_page" />
<input type="hidden" name="vis_flg" value="Y" id="vis_flg" />
<div class="opus_design_inquiry wFit">
<!-- layout_wrap(S) -->
<div class="layout_wrap">
    <div class="layout_vertical_2 sm"   style="width:100px;">
       <div class="opus_design_inquiry">  
			<table> 
				<colgroup>
					<col width="90" />								
					<col width="*" />				
			   </colgroup>  
				<tbody>
					<tr>
						<td ><input type="radio" name="in_out_cd" id="in_out_cd" value="IN" class="trans" checked>&nbsp;<b>Inbound</b> </td>
						<td> </td>
					</tr>
					<tr>
						<td><input type="radio" name="in_out_cd" id="in_out_cd" value="OUT" class="trans">&nbsp;<b>Outbound</b></td>
						<td> </td>
					</tr>
				</tbody>
			</table>
		</div>
    </div>
    <div class="layout_vertical_2"  style="width:900px;">
       <div class="opus_design_inquiry wFit">  
			<table >
				<colgroup>
					<col width="70" />				
					<col width="190" />				
					<col width="40" />				
					<col width="80" />				
					<col width="40" />
					<col width="80" />				
					<col width="100" />				
					<col width="80" />				
					<col width="40" />				
					<col width="80" />
					<col width="40" />				
					<col width="60" />				
					<col width="50" />							
					<col width="*" />				
			   </colgroup>  
				<tbody>
		    		<tr>
						<th  id="eta_id" name="eta_id" >ETA</th>
						<td><input type="text" style="width:75px;" class="input1" maxlength="10" dataformat="ymd" name="vps_eta_dt" value="" id="vps_eta_dt" />-&nbsp;<!-- 
						 --><input type="text" style="width:75px;" class="input1" maxlength="10" dataformat="ymd" name="vps_etd_dt" value="" id="vps_etd_dt" /><!-- 
						 --><button type="button" id="btn_eta_date" name="btn_eta_date" class="calendar ir"></button></td>
						<th title="Vessel Voyage Direction">VVD</th>
						<td><input type="text" style="width:85px;" class="input1" name="vvd_cd" value="" maxlength="9" required="" fullfill="" dataformat="engup" id="vvd_cd" /> </td>
						<th title="Port of Loading">POL</th>
						<td><input type="text" style="width:55px;" class="input" name="pol_cd" value="" maxlength="5" dataformat="engup" id="pol_cd" /><!--
						  --><input type="text" style="width:25px;" value="" class="input" name="pol_yard_cd" maxlength="2" dataformat="engup" id="pol_yard_cd" /> </td>
						<th title="Port of Discharging">POD</th>
						<td><input type="text" style="width:60px;" value="" name="pod_cd" maxlength="5" dataformat="engup" class="input" id="pod_cd" /><!-- 
						   --><input type="text" style="width:25px;" value="" class="input" name="pod_yard_cd" maxlength="2" dataformat="engup" id="pod_yard_cd" /> </td>
						<th title="Place of Receipt">POR</th>
						<td><input type="text" style="width:60px;" class="input" name="por_cd" maxlength="5" dataformat="engup" value="" id="por_cd" /> </td>
						<th title="Place of Delivery">DEL</th>
						<td><input type="text" style="width:60px;" class="input" name="del_cd" maxlength="5" dataformat="engup" value="" id="del_cd" /> </td>
						<th>EQ Office</th>
						<td><input type="text" style="width:70px;" class="input" name="eq_ofc_cd" maxlength="6" dataformat="engup" value="" id="eq_ofc_cd" /> </td>
					</tr>
	
					<tr>
						<th>S/C</th>
						<td><input type="text" style="width:151px;" class="input1" name="sc_no" value="" maxlength="20" dataformat="engup" id="sc_no" /> </td>
						<th>RFA</th>
						<td><input type="text" style="width:85px;" class="input1" name="rfa_no" value="" maxlength="11" dataformat="engup" id="rfa_no" /> </td>
						<th>TAA</th>
						<td><input type="text" style="width:85px;" class="input1" name="taa_no" value="" maxlength="10" dataformat="engup" id="taa_no" /> </td>
						<th>Group Customer</th>
						<td><input type="text" style="width:90px;" class="input1" name="gcust" value="" maxlength="10" dataformat="engup" otherchar="#&*()., -" id="gcust" />  </td>
						<th>A/Customer</th>
						<td><input type="text" name="agmt_act_cnt_cd" style="width:23px;" class="input" value="" maxlength="2" dataformat="engup" id="agmt_act_cnt_cd" /><!--  
						  --><input type="text" name="agmt_act_cust_seq" style="width:50px;" class="input" value="" maxlength="6" dataformat="num" id="agmt_act_cust_seq" /> </td>
						<td> </td>
						<td> </td>
						<td> </td>
						<td> </td>
					</tr>
				</tbody>
			</table>
			
			<table> 
				<colgroup>			
					<col width="70" />				
					<col width="311" />				
					<col width="60" />							
					<col width="*" />				
			   </colgroup> 
				<tbody>
					<tr>
						<th>Customer</th>
						<td><script type="text/javascript">ComComboObject('cust_tp_cd', 2, 50, true, '');</script><!-- 
						 -->&nbsp;<input type="text" style="width:25px;" class="input1" name="cust_cnt_cd" id="cust_cnt_cd" value=""  maxlength='2'  dataformat='engup' style="ime-mode:disabled">&nbsp;<!-- 
						 --><input type="text" style="width:50px;" class="input1" maxlength='6' dataformat='num' name="cust_seq" id="cust_seq"  style="ime-mode:disabled"  value="">&nbsp;<!-- 
						 --><input type="text" style="width:118px;" class="input" maxlength='50' dataformat="engup" otherchar="#&*()., -" name="cust_nm" value="" ><!-- 
						 --><button type="button" id="btn_customer_pop" name="btn_customer_pop" class="input_seach_btn"></button>
						</td>
						<th>EDI ID</th>
						<td><input type="text" style="width:68px;" class="input1" name="edi_id" value="" maxlength="9" dataformat="engup" id="edi_id" /><!-- 
						 --><input type="text" style="width:87px;" class="input2" maxlength="50" dataformat="engup" name="edi_gr_cd" value="" readonly id="edi_gr_cd" /><!-- 
						 --><input type="text" style="width:96px;" class="input2" maxlength="50" dataformat="engup" name="edi_gr_nm" value="" readonly id="edi_gr_nm" /><!-- 
						 --><button type="button" id="btn_Edi_Id" name="btn_Edi_Id" class="input_seach_btn"></button></td>
					</tr>
				</tbody>
			</table>
			
			<table>
				<colgroup>			
					<col width="90" />				
					<!-- <col width="200" />				
					<col width="120" /> -->							
					<col width="*" />				
			   </colgroup> 
				<tbody> 
					<tr>
						<th>Special Cargo</th>
						<td>
						   <input type="checkbox" class="trans" name="sp_cargo_rf" value="RF" id="sp_cargo_rf" /><label for="sp_cargo_rf">RF</label><!-- 
						--><input type="checkbox" class="trans" name="sp_cargo_dg" value="DG" id="sp_cargo_dg" /><label for="sp_cargo_dg">DG</label><!-- 
						--><input type="checkbox" class="trans" name="sp_cargo_ak" value="AK" id="sp_cargo_ak" /><label for="sp_cargo_ak">AK</label><!-- 
					    --><input type="checkbox" class="trans" name="sp_cargo_bb" value="BB" id="sp_cargo_bb" /><label for="sp_cargo_bb">BB</label>
						</td>
						<!-- <th>Assign Credit Term</th>
						<td><input type="text" style="width:20px;" class="input" name="credit" value="" maxlength="2" dataformat="num" id="credit" /> </td>
						 -->
					</tr>
				</tbody>
			</table>	
			
		</div>
    </div>
</div>
<!-- layout_wrap(e) -->
		
	<!-- Cargo Type (E) -->
</form>
<!-- ********************************************* Form End  ********************************************* -->	

	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="id_sheet1">
		<script type="text/javascript">ComSheetObject('sheet1');</script>		
	</div>
	<!-- opus_design_grid(E) -->
</div>
 