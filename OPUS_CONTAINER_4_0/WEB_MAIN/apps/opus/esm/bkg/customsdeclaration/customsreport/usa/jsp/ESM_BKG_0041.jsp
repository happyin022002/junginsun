<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0041.jsp
*@FileTitle  : AMS Report
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.StringUtil"%>
<%
    String sOffice = "Origin";
    if ("ESM_BKG_0041_01".equals(request.getParameter("pgmNo"))) {
    	sOffice = "US";
    }
    
  //BAPLIE(ESM_BKG_1023)화면에서 Go to AMS Report 버튼 클릭이벤트 발생시
  	String strVvd = request.getParameter("vvd");
  	String strLastPol = request.getParameter("lastPol");
  	String strEventFrom = request.getParameter("eventFrom");
  	if(strVvd == null) {
  		strVvd = "";
  	}
  	if(strLastPol == null) {
  		strLastPol = "";
  	}
  	if(strEventFrom == null) {
  		strEventFrom = "";
  	}
  	
  	String mainPage = "";
  	try {
		mainPage = JSPUtil.getNull(request.getParameter("mainPage"));
	}catch(Exception e) {
		out.println(e.toString());
	}	
%>
<script type="text/javascript">
	function setupPage(){
		loadPage();
	}
</script>
<form name="form" method="post">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="pgm_no" value="ESM_BKG_0041" id="pgm_no" />
<input type="hidden" name="h_vvd" value="" id="h_vvd" />

<input type="hidden" name="pol" value="">
<input type="hidden" name="pod" value="">
<input type="hidden" name="hub" value="">
<input type="hidden" name="del" value="">
<input type="hidden" name="hid_vvd" value="<%=StringUtil.xssFilter(strVvd) %>">
<input type="hidden" name="hid_last_pol" value="<%=StringUtil.xssFilter(strLastPol) %>">
<input type="hidden" name="event_from" value="<%=StringUtil.xssFilter(strEventFrom) %>">

<input type="hidden" name="retrieve_remains" value="" id="retrieve_remains" />
<input type="hidden" name="retrieve_remains_for_report" value="" id="retrieve_remains_for_report" />
<input type="hidden" name="office" value="<%=sOffice%>" id="office" />

<%if(!mainPage.equals("true")){%>
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span id="title"></span></h2>
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button class="btn_accent" name="btn_Retrieve" id="btn_Retrieve" type="button">Retrieve</button>
			<button class="btn_normal" name="btn_Downexcel" id="btn_Downexcel" type="button">Down Excel</button>
			<button class="btn_normal" name="btn_Print" id="btn_Print" type="button">Print</button>
			<button class="btn_normal" name="btn_2q4q" id="btn_2q4q" type="button">2Q/4Q</button>
			<button class="btn_normal" name="btn_2r4r" id="btn_2r4r" type="button">2R/4R</button>
			<button class="btn_normal" name="btn_2z" id="btn_2z" type="button">2Z</button>
			<button class="btn_normal" name="btn_6h6i" id="btn_6h6i" type="button">6H/6I</button> 
			<button class="btn_normal" name="btn_non3Z" id="btn_non3Z" type="button">Non-3Z</button> 
			<button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
		</div>
		<!-- opus_design_btn (E) -->
	</div>
</div>
<%}else{%>
<!-- page_title_area(S) -->
<div class="page_title_area clear ">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button class="btn_accent" name="btn_Retrieve" id="btn_Retrieve" type="button">Retrieve</button>
			<button class="btn_normal" name="btn_Downexcel" id="btn_Downexcel" type="button">Down Excel</button>
			<button class="btn_normal" name="btn_Print" id="btn_Print" type="button">Print</button>
			<button class="btn_normal" name="btn_2q4q" id="btn_2q4q" type="button">2Q/4Q</button>
			<button class="btn_normal" name="btn_2r4r" id="btn_2r4r" type="button">2R/4R</button>
			<button class="btn_normal" name="btn_2z" id="btn_2z" type="button">2Z</button>
			<button class="btn_normal" name="btn_6h6i" id="btn_6h6i" type="button">6H/6I</button> 
			<button class="btn_normal" name="btn_non3Z" id="btn_non3Z" type="button">Non-3Z</button> 
		</div>
		<!-- opus_design_btn (E) -->
	
	<!-- page_location(S) -->
	<div class="location">
    <!-- location 내용 동적생성 (별도 코딩 불필요) -->
    <span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->
<%}%>

<%if(!mainPage.equals("true")){%><div class="layer_popup_contents" style="margin-bottom:-100px;"><%}%>

<div class="wrap_search_tab">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
		<!-- layout_wrap(S) -->
		<div class="layout_wrap">
		    <div class="layout_vertical_2" style="width:780px;">
		        <table>
					<tr>
				      	<td title="Vessel Voyage Direction" align="right"><strong>VVD</strong></td>
				      	<td><input type="text" name="vvd" id="vvd" value="<%=StringUtil.xssFilter(strVvd) %>" style="width:100px;" class="input1" dataformat="engup" maxlength="9"  minlength="9" required></td>
				      	<td>
							<div id="general">
								<table class="search">
									<tr class="h23">
										<td id="lastPolTd1" width="80px" style="display:none;"><strong>Last Foreign POL</strong></td>
										<td id="lastPolTd2" width="70px" style="display:none;"><input type="text" id="last_pol" name="last_pol" value="<%=StringUtil.xssFilter(strLastPol)%>" style="width:60px;" class="input1" dataformat="engup" maxlength="5" minlength="5" required></td>
										<td width="35px"><strong>POL</strong></td>
										<td width="75px"><input type="text" id="pol1" name="pol1" style="width:60px;" class="input1" dataformat="engup" maxlength="5" minlength="5"required></td> 
										<td width="35px"><strong>POD</strong></td>
										<td width="75px"><input type="text" id="pod1" name="pod1" style="width:60px;" class="input1" dataformat="engup" maxlength="5" minlength="5" required></td> 
										<td width="85px"><strong>HUB Location</strong></td>
										<td width="90px"><input type="text" id="hub1" name="hub1" style="width:63px;" class="input" dataformat="engup" maxlength="5" minlength="5"></td>
										<td width="35px"><strong>DEL</strong></td>
										<td width="75px"><input type="text" id="del1" name="del1" style="width:60px;" class="input1" dataformat="engup" maxlength="5" minlength="5" required></td>
										<td width="*"></td>
									</tr>
								</table>
							</div>
									
							<div id="general_1" style="display:none;">
								<table class="search">
									<tr class="h23">
										<td width="35px"><strong>POL</strong></td>
										<td width="75px"><input type="text" id="pol2" name="pol2" style="width:60px;" class="input1" dataformat="engup" maxlength="5" required></td> 
										<td width="35px"><strong>POD</strong></td>
										<td width="75px"><input type="text" id="pod2" name="pod2" style="width:60px;" class="input1" dataformat="engup" maxlength="5" required></td>
										<td width="85px"><strong>HUB Location</strong></td>
										<td width="90px"><input type="text" id="hub2" name="hub2" style="width:63px;" class="input" dataformat="engup" maxlength="5"></td>
										<td width="35px"><strong>DEL</strong></td>
										<td width="75px"><input type="text" id="del2" name="del2" style="width:60px;" class="input1" dataformat="engup" maxlength="5" required></td>
										<td width="30px"><strong>RHQ</strong></td>
										<td width="90px">
											<script type="text/javascript">ComComboObject('rhq', 1, 80, 1, 0, 0, false);</script>
										</td>																				 										
									</tr>
								</table>
							</div>
				      	</td>
						
					</tr>
				</table>
				<table>
					<tbody>
						<colgroup>
							<col width="100">
							<col width="140">
							<col width="80">
							<col width="80">
							<col width="45">
							<col width="70">
							<col width="150">
							<col width="*">
						</colgroup>
						<tr>
							<th>EQ Control OFC</th>
							<td><script type="text/javascript">ComComboObject('eq_ofc', 1, 100, 1, 0);</script></td>
							<th>B/STF</th>
							<td><input type="text" name="b_stf" id="b_stf" style="width:60px;" class="input" dataformat="engup" maxlength="10"></td> 
							<th>L/Rep.</th>
							<td><input type="text" name="l_rep" id="l_rep" style="width:60px;" class="input" dataformat="engup" maxlength="5"></td>
							<th>R/D Term</th>
							<td><script type="text/javascript">ComComboObject('rcv_term_cd', 2, 85, 0, 0);</script><!--
							--><script type="text/javascript">ComComboObject('de_term_cd', 2, 85, 1, 0);</script></td>
						</tr>
					</tbody>
				</table>
				<table>
					<tbody>
						<colgroup>
							<col width="100">
							<col width="140">
							<col width="80">
							<col width="210">
							<col width="135">
							<col width="*">
						</colgroup>
						<tr>
							<th>P/MIB TP</th>
							<td>
								<select name="pmib_tp" style="width:99;">
								<option value="0"></option>
								<option value="61" >61</option>
								<option value="62">62</option>
								<option value="63">63</option>
								<option value="L">Local</option>
								<option value="I">P/MIB</option>
								<option value="IL">P/MIB-> Local</option>
								<option value="LI">Local-> P/MIB</option>
								<option value="IPIL">IPI/Local</option>
								<option value="IPILY">IPI/Local/C:Y</option>
								<option value="CYN">C:Y->N</option>
								</select>
							</td>
							<th>Filer</th>
							<td><script type="text/javascript">ComComboObject('filer', 2, 200, 1, 0);</script></td>
							<th>Customs Result Code</th>
							<td><script type="text/javascript">ComComboObject('customs_result_code_grp', 2, 60, 0, 0);</script><!--
							--><script type="text/javascript">ComComboObject('customs_result_code', 2, 49, 0, 0);</script></td>
						</tr>
					</tbody>
				</table>
				 <table>
					<tbody>
						<colgroup>
							<col width="100">
							<col width="110">
							<col width="110">
							<col width="120">
							<col width="100">
							<col width="100">
							<col width="25">
							<col width="50">
							<col width="25">
							<col width="50">
							<col width="25">
							<col width="*">
						</colgroup>
						<tr>
							<th>M.B/L No.</th>
							<td><input type="text" name="mbl_no" id="mbl_no" style="width:95px;" class="input" dataformat="engup"  maxlength="12"  value="<%=(request.getParameter("bl_no")==null) ? "" : request.getParameter("bl_no")%>"></td> 
							<th>Manifest File No.</th>
							<td><input type="text" name="ams_file_no" ud="ams_file_no" style="width:95px;" class="input" dataformat="engup" maxlength="12"></td>
							<th>Inbound Ops Filters</th> 
							<td>
							<%--
							<input type="checkbox" name="excl_rls" id="excl_rls" class="trans" value="1">&nbsp;<strong>Excl.Rls</strong>
							 --%>
							<%=JSPUtil.getCodeCombo("excl_rls", "", "style='width:100'", "CD30108", 1 , ": :")%>
							
							</td>
							<th></th>
							<td><input type="checkbox" name="cntr_prt_flg" id="cntr_prt_flg" class="trans" value="1">&nbsp;<strong>Partial</strong></td>
							<th></th>
							<td><input type="checkbox" name="final_flg" id="final_flg" class="trans" value="1">&nbsp;<strong>final</strong></td>
							<th></th>
						</tr>
					</tbody>
				</table>
				<table id="railAms" style="display:none;">
					<tbody>
						<colgroup>
							<col width="100">
							<col width="110">
							<col width="110">
							<col width="120">
							<col width="25">
							<col width="50">
							<col width="25">
							<col width="50">
							<col width="25">
							<col width="*">
						</colgroup>
						<tr>
							<th>Customer code</th>
							<td><input type="text" name="customer_cd" style="width:80px;" class="input" dataformat="eng" maxlength="8"></td> 
							<th>S/C No.</th>
							<td><input type="text" name="sc_no" style="width:92px;" class="input" dataformat="eng" maxlength="9"></td> 
							<th>CNTR TYPE</th>
							<td><input type="text" name="cntr_tp" style="width:30px;" class="input" dataformat="eng" maxlength="2"></td> 
							<th>CNTR No.</th>
							<td><input type="text" name="cntr_no" style="width:95px;" class="input" dataformat="eng" maxlength="11"></td> 
							<th>R.Billing Y/N</th>
							<td>
							<select name="rbilling_yn" style="width:35px;" >
								<option value=""></option>
								<option value="Y">Y</option>
								<option value="N">N</option>
							</select></td>						
						</tr>
					</tbody>
				</table>
				 
		    </div>
		    
		    <div class="layout_vertical_2" style="width:230px;">
		        <table id="changeTbl" class="grid_2">
					<tbody>
						<colgroup>
							<col width="25">
							<col width="110">
							<col width="110">
						</colgroup>
						<tr>
							<td id="useDateCond" rowspan="2" valign="top" style="text-align:center;"><input type="checkbox" name="date_search" id="date_search" class="trans"></td>
							<td class="tr2_head"><input type="radio" name="cust_arr_exp" value="SND" class="trans">&nbsp;<strong>Send Date</strong></td>
							<td class="tr2_head"><input type="radio" name="cust_arr_exp" value="RCV" class="trans">&nbsp;<strong>Receive Date</strong></td>
						</tr>
						<tr class="h23">
							<td class="tr2_head"><input type="radio" name="cust_arr_exp" value="ARR" class="trans" checked="checked">&nbsp;<strong>Arrival Date</strong></td>
							<td class="tr2_head"><input type="radio" name="cust_arr_exp" value="EXP" class="trans">&nbsp;<strong>Export Date</strong></td>
						</tr>
						<tr>
							<td colspan="3">
								<input type="text" style="width: 75px;" class="input2" dataformat="ymd" name="fromd" id="fromd" caption="Sent Date" cofield="tod" maxlength="10">
								<input type="text" name="fromt" id="fromt" style="width:45px;" value="00:00" class="input2" dataformat="hm" maxlength="5">
								~ 
								<input type="text" style="width: 75px;" class="input2" dataformat="ymd" name="tod" id="tod" caption="Sent Date" cofield="fromd" maxlength="10">
								<input type="text" name="tot" id="tot" style="width:45px;" value="23:59" class="input2" dataformat="hm" maxlength="5">
								<button type="button" class="calendar" name="btn_calendar" id="btn_calendar"></button>
							</td>
				        </tr>
					</tbody>
				</table>
		    </div>
		    
				
				</div>
				<div class="opus_design_btn">
		<button class="btn_normal" name="btn_RailAmsHistory" id="btn_RailAmsHistory" type="button">Rail AMS History</button>
		<button class="btn_normal" name="btn_BLInquiry" id="btn_BLInquiry" type="button">Manifest(B/L)</button> 
		<button class="btn_normal" name="btn_InquiryByCntr" id="btn_InquiryByCntr" type="button">B/L Inquiry by CNTR</button> 
		<button class="btn_normal" name="btn_BlCharge" id="btn_BlCharge" type="button">B/L Charge</button>
    	</div>
				</div>
		
		<!-- layout_wrap(E) -->
	</div>
	<!-- opus_design_inquiry(E) -->


  


<div class="wrap_result">
	<!-- opus_tab_btn(S) -->
	<div class="opus_design_tab">
		<script type="text/javascript">ComTabObject('tab1')</script>
	</div>
	<!-- opus_tab_btn(E) -->
	<!-- opus_design_grid(S) -->	
	<div class="opus_design_grid" name="tabLayer" id="tabLayer" style="display:inline;">
		<table id="mainTable" style="width:100%;">
				<tr><td style="text-align:right;"><div style="font-size:12px;font-family: dotum;">[ B/L Count : <span id="bl_cnt"></span>]</div></td></tr>
				<tr><td></td></tr>
		</table>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<div class="opus_design_grid" name="tabLayer" id="tabLayer" style="display:none;">
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
	<div class="opus_design_grid" name="tabLayer" id="tabLayer" style="display:none;">
		<script type="text/javascript">ComSheetObject('sheet3');</script>
		<div class="opus_design_inquiry">
			<table class="search" style="width:100%;">
				<tbody>
					<colgroup>
						<col width="85">
						<col width="60">
						<col width="40">
						<col width="90">
						<col width="60">
						<col width="40">
						<col width="60">
						<col width="60">
						<col width="40">
						<col width="40">
						<col width="60">
						<col width="*">
					</colgroup>
					<tr class="h23">
						<th>Manifest TTL </th>
						<td><input type="text" name="manifest" id="manifest" style="width:50px; text-align:center" class="input" readonly="readonly"></td>
						<th align="center">=</th>
						<th>Accepted </th>
						<td><input type="text" name="accepted" id="accepted" style="width:50px; text-align:center" class="input" readonly="readonly"></td> 
						<th align="center">+</th>
						<th>Rejected</th>
						<td><input type="text" name="rejected" id="rejected" style="width:50px; text-align:center" class="input" readonly="readonly"></td> 
						<th align="center">+</th>
						<th>N/A</th>
						<td><input type="text" name="none" id="none" style="width:50px; text-align:center" class="input" readonly="readonly"></td> 
						<td>&nbsp;</td>
					</tr>
					<tr class="h23">
						<th>Target  TTL</th>
						<td><input type="text" name="target" id="target" style="width:50px; text-align:center; text-color:red" class="input2" readonly="readonly"></td>
						<td></td>
						<th><font color="red">Un-manifested</font></th>
						<td><input type="text" name="unmanifest" id="unmanifest" style="width:50px; color:red; text-align:center"  class="input" readonly="readonly"></td>
						<td></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<div class="opus_design_grid" name="tabLayer" id="tabLayer" style="display:none;">
		<script type="text/javascript">ComSheetObject('sheet4');</script>
	</div>
	<!-- opus_design_grid(E) -->
</div>

<!-- Tab ) (E) -->
<%if(!mainPage.equals("true")){	%></div><%}%>
</form>
</body>