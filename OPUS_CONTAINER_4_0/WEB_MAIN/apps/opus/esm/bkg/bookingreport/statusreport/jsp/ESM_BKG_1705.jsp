<%
/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : ESM_BKG_1705.jsp
 *@FileTitle : Special Cargo Report
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/05/27
 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingreport.statusreport.event.EsmBkg1705Event"%>	
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg1705Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //error from the server		
	String strErrMsg = ""; //error messege
	int rowCount = 0; //the number of DB ResultSet List

	String successFlag = "";
	String codeList = "";
	String pageRows = "50";

	String strUsr_id = "";
	String strUsr_nm = "";
	boolean bBtn_Disabled = true;
	Logger log = Logger.getLogger("com.clt.apps.opus.esm.bkg.bookingreport.statusreport");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg1705Event) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException)
					.loadPopupMessage();
		}

		// extract additional data obtained from the server during Initial loading ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request
				.getAttribute("EventResponse");

	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<script  type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>		
	
<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->		

	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		   <button type="button" class="btn_accent"  name="btn_Direct_Retrieve" id="btn_Direct_Retrieve">Direct Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_Sort" 			id="btn_Sort" style="display:none">Sort</button><!-- 
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

<div class="wrap_result">	
	<div class="opus_design_inquiry" >
		<form method="post" name="tempform" onSubmit="return false;">  	
			<table style="width:550px" >
				<colgroup>
					<col width="90" />
					<col width="250" />
				</colgroup>
				<tbody>
					<tr>
				   		<th>Option</th>	
				   		<td>					
						   <input type="radio" name="p_bkg_rpt_knd_cd" id="rdo0_0" value="G" class="trans" onclick="chgRepoType();" checked><label for="rdo0_0">DG</label><!--
						--><input type="radio" name="p_bkg_rpt_knd_cd" id="rdo0_1" value="R" class="trans" onclick="chgRepoType();" ><label for="rdo0_1">RF</label><!--
						--><input type="radio" name="p_bkg_rpt_knd_cd" id="rdo0_2" value="A" class="trans" onclick="chgRepoType();" ><label for="rdo0_2">AK</label><!--
						--><input type="radio" name="p_bkg_rpt_knd_cd" id="rdo0_3" value="S" class="trans" onclick="chgRepoType();" ><label for="rdo0_3">BB</label><!--
						<input type="radio" name="p_bkg_rpt_knd_cd" id="rdo0_4" value="H" class="trans" onclick="chgRepoType();" ><label for="rdo0_4">HG</label>-->
						</td>	
					</tr>				
				   	<tr>
				   		<th >Report Type</th>
						<td><script  type="text/javascript">ComComboObject('report_type', 1, 240, '');</script><button type="button" class="btn_etc" name="btn_ReportTemplate"	id="btn_ReportTemplate">Report Template</button></td>							
				   	</tr>
				</tbody>
			</table>
		</form>	
	</div>			
<form method="post" name="form" id="mainform" onSubmit="return false;">
	<input type="hidden" name="f_cmd"/>
	<input type="hidden" name="rpt_id">	
	<input type="hidden" name="orderby">	
	<!-- layout_wrap(S) -->
	<div class="opus_design_inquiry">
	<div class="layout_wrap mar_top_12">
		<div class="layout_vertical_2" style="width:49%;">
			<div class="opus_design_data sm" style="height:258px;">		
				<h3 class="title_design">VVD & POL / POD</h3>
				<table>
					<colgroup>
					  <col width="80"/>
					  <col width="220"/>
					  <col width="80"/>
					  <col width="*"/>
					</colgroup>						
					<tr>
						<td colspan="4">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<input name="io_bnd_cd" type="radio" value="O" class="trans" id="rdo1_1" onclick="chgMandatory();" checked><label for="rdo1_1">Outbound</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;		
							<input name="io_bnd_cd" type="radio" value="I" class="trans" id="rdo1_2" onclick="chgMandatory();"><label for="rdo1_2">Inbound</label>					
						</td>
					</tr>
					<tr>
						<th>VVD</th>
						<td colspan="3"><input type="text" style="IME-MODE: disabled; WIDTH: 90px" class="input1" name="vvd_cd" value="" maxlength="9" id="vvd_cd" dataformat="engup"/> Trunk <input type="checkbox" class="trans" name="trunk_flag" value="Y"></td>
					</tr> 							
					<tr>
						<th>POL</th>
						<td><input type="text" style="IME-MODE: disabled; WIDTH: 80px" value="" name="pol_cd" maxlength="5"  class="input1" id="pol_cd"  dataformat="engup"/>  <input type="text" style="IME-MODE: disabled; width:35px;" value="" class="input" name="pol_yard_cd" maxlength="2"  id="pol_yard_cd" dataformat="engup" />(<input type="checkbox" class="trans" name="pol_local" value="Y" id="pol_local" />Local<input type="checkbox" class="trans" name="pol_ts" value="Y" id="pol_ts"/>T/S)</td>
						<th>POD</th>
						<td><input type="text" style="IME-MODE: disabled; WIDTH: 80px" value="" name="pod_cd" maxlength="5" class="input" id="pod_cd"  dataformat="engup" />  <input type="text" style="IME-MODE: disabled; WIDTH: 35px" value="" class="input" name="pod_yard_cd" maxlength="2" id="pod_yard_cd" dataformat="engup" />(<input type="checkbox" class="trans" name="pod_local" value="Y" id="pod_local" />Local<input type="checkbox" class="trans" name="pod_ts" value="Y" id="pod_ts" />T/S)</td>								
					</tr>
					<tr>
						<th>Sail Date</th>
						<td><input type="text" style="width:80px" value="" class="input1"  name="sail_from_dt" id=sail_from_dt  maxlength='10' dataformat="ymd" >~<input type="text" style="width:80px" value="" class="input1"  name="sail_to_dt" id="sail_to_dt"  maxlength='10' dataformat="ymd" ><button type="button" class="calendar ir" name="btn_sail_date" id="btn_sail_date"></button></td>
						<th>Arrival Date</th>
						<td><input type="text" style="width:80px" value="" class="input"  name="arr_from_dt" id="arr_from_dt"  maxlength='10' dataformat="ymd" >~<input type="text" style="width:80px" value="" class="input"  name="arr_to_dt" id="arr_to_dt"  maxlength='10' dataformat="ymd" ><button type="button" class="calendar ir" name="btn_arr_date" id="btn_arr_date"></button></td>
					</tr>
					<tr>
						<th>BKG Date</th>
						<td><input type="text" style="width:80px" value="" class="input1"  name="bkg_from_dt" id="bkg_from_dt"  maxlength='10' dataformat="ymd" >~<input type="text" style="width:80px" value="" class="input1"  name="bkg_to_dt" id="bkg_to_dt"  maxlength='10' dataformat="ymd" ><button type="button" class="calendar ir" name="btn_bkg_date" id="btn_bkg_date"></button></td>
					</tr>
					<tr>
						<th>BKG No.</th>
						<td><input type="text" name="bkg_no" style="width: 125px;" maxlength="13" dataformat="engup" class="input" id="bkg_no" /><!--
										   <button type="button" id="btn_find_bkg" name="btn_find_bkg" class="input_seach_btn"></button>--></td>
						<th>B/L No.</th>
						<td><input type="text" name="bl_no" id="bl_no" style="width:128px" maxlength="12" dataformat="engup" class="input"></td>
					</tr> 														
				</table>				
				<table>
				 <colgroup>
				  <col width="80"/>
				  <col width="70"/>
				  <col width="40"/>
				  <col width="70"/>
				  <col width="40"/>
				  <col width="70"/>
				  <col width="*"/>
				 </colgroup>
					<tr>
						<th>BKG OFC</th>
						<td>
							<input type="text" name="bkg_ofc_cd"  id="bkg_ofc_cd" style="width:60px;" value="" style="ime-mode:disabled" dataformat="enguponly" caption="BKG Office" maxlength="6" >
						</td>
						<th>S.Rep</th>
						<td>
							<input type="text" name="ob_srep_cd" id="ob_srep_cd" style="width:55px;" value="" style="ime-mode:disabled" dataformat="enguponly" caption="S.Rep" maxlength="4">
						</td>
						<th>BKG Staff</th>
						<td class="sm">
							<input type="radio" name="bkg_staff_type" id="bkg_staff_type1" value="ID" class="trans" checked><label for="bkg_staff_type1">ID</label>
							<input type="radio" name="bkg_staff_type" id="bkg_staff_type2" value="NAME" class="trans"><label for="bkg_staff_type2">Name</label>
							<input type="text" name="bkg_staff" style="width: 80px;" value="" maxlength="20" dataformat="engup" class="input">
						</td>
						<td></td>
					</tr>
				
				</table>																								
				<table class="sm mar_top_4" height="30px">
					<colgroup>
					  <col width="100"/>
					  <col width="*"/>
					</colgroup>						
					<tr>
						<th>Booking Status</th>
						<td><input type="checkbox" class="trans" name="bkg_sts_cd_f" value="F" id="bkg_sts_cd_f" />F-Firm <input type="checkbox" class="trans" name="bkg_sts_cd_w" value="W" id="bkg_sts_cd_w" /> W-Waiting   (<input type="checkbox" class="trans" name="non_sp_cargo" value="Y" id="non_sp_cargo" /> Non approval of special cargo    <input type="checkbox" class="trans" name="holding" value="Y" id="holding" /> Holding)</td>
					</tr>							
				</table>
			</div>		
	    </div>
	    <div class="layout_vertical_2" style="width:50%; float:right;">
			<div class="opus_design_data sm">
			    <h3 class="title_design">Booking Route</h3>
		    	<table>		
					<colgroup>
					  <col width="80"/>
					  <col width="250"/>
					  <col width="80"/>
					  <col width="*"/>
					</colgroup>					
					<tr>
						<th>POR</th>
						<td><input type="text" style="IME-MODE: disabled; WIDTH: 80px" value="" name="por_cd2" id="por_cd2" maxlength='5' dataformat='engup' style="ime-mode:disabled" class="input"></td>
						<th>POL</th>
						<td><input type="text" style="IME-MODE: disabled; WIDTH: 80px" value="" name="pol_cd2" id="pol_cd2" maxlength='5' dataformat='engup' style="ime-mode:disabled" class="input"></td>
						
					</tr>
					<tr>
						<th>POD</th>
						<td><input type="text" style="IME-MODE: disabled; WIDTH: 80px" value="" name="pod_cd2" id="pod_cd2" maxlength='5' dataformat='engup' style="ime-mode:disabled" class="input"></td>
						<th>DEL</th>
						<td><input type="text" style="IME-MODE: disabled; WIDTH: 80px" value="" name="del_cd2" id="del_cd2" maxlength='5' dataformat='engup' style="ime-mode:disabled" class="input"></td>
					</tr>
					<tr>
						<th>R/D Term</th>
						<td><script type="text/javascript">ComComboObject('r_term', 1, 100, 1);</script><script type="text/javascript">ComComboObject('d_term', 1, 100, 1);</script></td>
						<th>Bound</th>
						<td><script type="text/javascript">ComComboObject('dir_cd', 1, 80, '');</script></td>
					</tr>	
				</table>
		    	<table>		
					<colgroup>
					  <col width="80"/>
					  <col width="70"/>
					  <col width="74"/>
					  <col width="106"/>
					  <col width="80"/>
					  <col width="*"/>
					</colgroup>
					<tr>
						<th>Trade</th>
						<td><script language="javascript">ComComboObject('trd_cd', 1, 60, '');</script></td>
						<th>Sub Trade</th>
						<td><script language="javascript">ComComboObject('sub_trd_cd', 1, 60, '');</script></td>
						<th>Lane</th>
						<td><input type="text" style="width:80px;" class="input" name="lane_cd" value="" maxlength="3" id="lane_cd" dataformat="engup" /></td>
					</tr>	
				</table>						
			</div>
			<div class="opus_design_data sm mar_top_4" style="height:104px">
				<h3 class="title_design">Customer</h3>		
		    	<table>					
					<tbody>	
						<colgroup>
						  <col width="80"/>
						  <col width="*"/>
						</colgroup>									
						<tr>
							<td colspan="2">&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="checkbox" class="trans" name="cust_tp_cd_s" id="cust_tp_cd_s" value="S">Shipper &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				                <input type="checkbox" class="trans" name="cust_tp_cd_c" id="cust_tp_cd_c" value="C">Consignee &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				                <input type="checkbox" class="trans" name="cust_tp_cd_n" id="cust_tp_cd_n" value="N">Notify &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				                <input type="checkbox" class="trans" name="cust_tp_cd_f" id="cust_tp_cd_f" value="F">Forwarder &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				                <input type="checkbox" class="trans" name="cust_tp_cd_a" id="cust_tp_cd_a" value="A">Also Notify &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				                <!--<input type="checkbox" class="trans" name="cust_tp_cd_g" id="cust_tp_cd_g" value="Y">Group-->
							</td>
						</tr>
						<tr>
							<th>Customer</th>
							<td><input type="text" style="IME-MODE: disabled; WIDTH: 32px" class="input" name="cust_cnt_cd" id="cust_cnt_cd" value=""  maxlength='2' dataformat='engup' style="ime-mode:disabled" onkeyup="onlyText(this);"><input type="text" style="IME-MODE: disabled; WIDTH: 55px" class="input" maxlength='6' dataformat='engup' name="cust_seq" id="cust_seq" style="ime-mode:disabled"  value=""><input type="text" style="width:100px;" class="input"  maxlength='50' dataformat='engup' otherchar="#().,*& -" name="cust_nm" id="cust_nm" value="" ><button type="button" name="btn_customer_pop" id="btn_customer_pop" class="input_seach_btn"></button></td>
							<!-- 
							<th>Group Customer</th>
							<td><input type="text" style="width:100px;" class="input"  maxlength='20' dataformat='engup' otherchar=" -" name="cust_grp_id" id="cust_grp_id" value="" ><button type="button" name="btn_cust_grp_pop" id="btn_cust_grp_pop" class="input_seach_btn"></button></td>
							 -->
						</tr>
					</tbody>
				</table>
				<table class="mar_top_2" height="30px">					
					<tr>
						<td width="16px"></td>
						<td class="sm" width="100px">&nbsp;
							<input type="radio" name="sc_rfa_gbn" id="sc_rfa_gbn_sc" value="S" checked><label for="sc_rfa_gbn_sc">S/C</label><!-- 
						 --><input type="radio" name="sc_rfa_gbn" id="sc_rfa_gbn_rfa" value="R"><label for="sc_rfa_gbn_rfa">RFA</label><!--
						 --><input type="radio" name="sc_rfa_gbn" id="sc_rfa_gbn_taa" value="T"><label for="sc_rfa_gbn_taa">TAA</label>
							<input type="text" 	name="sc_rfa_no"  id="sc_rfa_no" 	class="input" value="" style="width:85px;" maxlength="11" dataformat="engup">
						</td>
						<td></td>
					</tr>							
				</table>						
			</div>
	    </div>
	</div>
	</div>
	<!-- layout_wrap(E) -->	
	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear"  name="downSheet_options" id="downSheet_options" style="display:none">
		<script  type="text/javascript">ComSheetObject('search_options');</script>
	</div>
	<!-- opus_design_grid(E) -->
</div>

</form>
