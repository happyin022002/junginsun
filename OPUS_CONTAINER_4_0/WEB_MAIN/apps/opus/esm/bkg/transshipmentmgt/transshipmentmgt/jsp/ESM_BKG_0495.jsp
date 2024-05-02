<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0495.jsp
*@FileTitle  : T/S List by 1st VSL & 2nd VSL T/S Summary
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/07
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.event.EsmBkg0495Event"%>
<%@ page import="org.apache.log4j.Logger" %>
 

<%
	EsmBkg0495Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//DB ResultSet list count

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.TransshipmentMgt.TransshipmentMgt");
    

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg0495Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		//Add logic information data from the server when loading the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script type="text/javascript" src="/opuscntr/rpt/script/common_rd.js"></script>
<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form" onkeyup="ComKeyEnter('lengthnextfocus');">
<input type="hidden" name="f_cmd" 			id="f_cmd">
<input type="hidden" name="pagerows" 		id="pagerows">
<input type="hidden" name="disc_load_cd" 	id="disc_load_cd">
<input type="hidden" name="arrblno" 		id="arrblno">
<input type="hidden" name="vsl_Nm" 			id="vsl_Nm">
<input type="hidden" name="param" 			id="param">
<input type="hidden" name="sys_app" 		id="sys_app" 	value="BKG">
<input type="hidden" name="mrd" 			id="mrd" value="ESM_BKG_0877.mrd">
<input type="hidden" name="batch_no" 		id="batch_no" 	value="N">
<input type="hidden" name="chkport" 		id="chkport">
<input type="hidden" name="chkvvd" 			id="chkvvd">
<input type="hidden" name="vvd" 			id="vvd">
<input type="hidden" name="rdtitle" 		id="rdtitle">
<input type="hidden" name="vps_dt_flag" 	id="vps_dt_flag">
 
<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" 		id="btn_Retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_New" 			id="btn_New">New</button><!--
		--><button type="button" class="btn_normal" name="btn_CheckAll" 		id="btn_CheckAll">Check All</button><!--		
		--><button type="button" class="btn_normal" name="btn_UnCheckAll" 		id="btn_UnCheckAll">UnCheck All</button><!--		
		--><button type="button" class="btn_normal" name="btn_DownExcel" 		id="btn_DownExcel">Down Excel</button><!--
		--><button type="button" class="btn_normal" name="btn_Print" 			id="btn_Print">Print</button><!--
		--><button type="button" class="btn_normal" name="btn_Fax" 			id="btn_Fax">Fax</button><!--
		--><button type="button" class="btn_normal" name="btn_EMail" 			id="btn_EMail">Email</button>
		<div class="pad_left_8" style="float:right;margin-top:5px !important;" >
		<span style="font-weight:bold;">Fax/E-mail</span>&nbsp;
		<input type="text" style="width:120px;" class="input" value="" name="faxmail" maxlength="50">
	</div>
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
<div class= "opus_design_inquiry wFit">
	<table>
		<tbody>
			<tr>
				<th width="1">Relay Port</th>
				<td width="120">
					<input type="text" name="loc_cd" id="loc_cd" style="width:60px;" class="input1" value="" maxlength="5" dataformat="engup"><!--
				 --><input type="text" name="loc_yd_cd" id="loc_yd_cd" style="width:30px;" class="input" value="" maxlength="7" dataformat="engup">
				</td>
				<td width="100">
					<input type="radio" checked name="search_kind_cd" id="search_kind_cd_A" value="A"><label for="search_kind_cd_A"><strong>ETA</strong></label><!--
				 --><input type="radio" checked name="search_kind_cd" id="search_kind_cd_E" value="E"><label for="search_kind_cd_E"><strong>ETD</strong></label>
				</td>
				<td width="120">
					<input type="text" name="vps_etd_dt" id="vps_etd_dt" style="width:80px;" class="input1" value="" dataformat="ymd"><!--
				 --><button type="button" class="calendar ir" name="btn_calendar" id="btn_calendar"></button>
				</td>
				<th width="40">VVD</th>
				<td width="120"> 
					<script type="text/javascript">ComComboObject('vvdList', 1, 110, 0, 1, 0, true);</script>
				</td>
				<th width="30">POL</th>
				<td width="100">
					<input type="text" name="pol_cd" id="pol_cd" style="width:80px;" class="input" value="" maxlength="5" dataformat="engup">
				</td>
				<th width="30">POD</th>
				<td width="100">
					<input type="text" name="pod_cd" id="pod_cd" style="width:80px;" class="input" value="" maxlength="5" dataformat="engup">
				</td>
				<td>
					<button type="button" class="btn_etc" name="btn_Ts_Summary" id="btn_Ts_Summary">T/S Summary</button>
				</td>
			</tr>
		</tbody>
	</table>
	<table>
		<tbody>
			<tr>
				<td width="1">
					<div class="sm">
						<table>
							<tr>
								<td>
									<input type="radio" name="search_kind_cd" id="search_kind_cd" value="D"><label for="search_kind_cd"><strong>Duration</strong></label>
									<input type="text" name="dur_from" id="dur_from" style="width:80px;" class="input1" value="" dataformat="ymd">
									~
									<input type="text" name="dur_to" id="dur_to" style="width:80px;" class="input1" value="" dataformat="ymd"><!--
								 --><button type="button" class="calendar ir" name="btn_Duration" id="btn_Duration"></button>
								</td>
							</tr>
						</table>
					</div>
				</td>
				<th width="40">OOP</th>
				<td width="30"><input type="text" name="op_cd" id="op_cd" style="width:20px;" class="input" value="" maxlength="2" dataformat="engup"></td>
				<td>
					<div class="sm" style="width:505px">
						<table>
							<tr>
								<th width="60">Special</th>
								<td>
									<input type="radio" id="ALL" name="special" value="All"><label for="ALL">All</label>
									<input type="radio" id="DG" name="special" value="DG"><label for="DG">D/G</label>
									<input type="radio" id="RF" name="special" value="RF"><label for="RF">R/F</label>
									<input type="radio" id="AK" name="special" value="AK"><label for="AK">A/K</label>
									<input type="radio" id="ST" name="special" value="ST"><label for="ST">S/T</label>
									<input type="radio" id="RD" name="special" value="RD"><label for="RD">R/D</label>
									<input type="radio" id="SO" name="special" value="SO"><label for="SO">SOC</label>
									<input type="radio" id="SD" name="special" value="SD" checked><label for="SD">Special + Dry</label>
								</td>
							</tr>
						</table>
					</div>
				</td>
			</tr>
		</tbody>
	</table>
</div>
<!-- opus_design_inquiry(E) -->
</div>
<div class="wrap_result">
<!-- opus_tab_btn(S) -->
<div class="opus_design_tab sm" >
<div class="opus_design">
	<script type="text/javascript">ComTabObject('tab1')</script>
</div>
</div>
<!-- opus_tab_btn(E) -->

<!-- opus_design_grid(S) -->
<div class="opus_design_grid "  name="tabLayer" id="tabLayer">
	<script type="text/javascript">ComSheetObject('t1sheet1');</script>
	<div class="opus_design_inquiry mar_top_8">
		<table> 
			<tbody>
				<colgroup>
					<col width="50"/>
					<col width="120"/>
					<col width="50"/>
					<col width="120"/>
					<col width="50"/>
					<col width="*" />				
			   </colgroup> 
				<tr>
					<th>Total 20'</th>
					<td style="text-align:left;">
						<input type="text" name="tot_20_1" 		id="tot_20_1" 		style="width:100px; text-align:right;"  readonly>
					</td>
					<th>Total 40'</th>
					<td style="text-align:left;">
						<input type="text" name="tot_40_1" 		id="tot_40_1" 		style="width:100px; text-align:right;"  readonly>
					</td>
					<th>Grand Weight</th>
					<td style="text-align:left;">
						<input type="text" name="tot_weight_1" 	id="tot_weight_1" 	style="width:100px; text-align:right;"  readonly>
						<span style="font-weight: normal;">TON</span>
					</td>						
				</tr>
			</tbody>
		</table>
	</div>
</div>
<div class="opus_design_grid " name="tabLayer" id="tabLayer">
	<script type="text/javascript">ComSheetObject('t2sheet1');</script>
	<div class="opus_design_inquiry mar_top_8">
		<table> 
			<tbody>
				<colgroup>
					<col width="50"/>
					<col width="120"/>
					<col width="50"/>
					<col width="120"/>
					<col width="50"/>
					<col width="*" />				
			   </colgroup>
				<tr>
					<th>Total 20'</th>
					<td style="text-align:left;">
						<input type="text" name="tot_20_2" id="tot_20_2" style="width:100px; text-align:right;"  readonly>
					</td>
					<th>Total 40'</th>
					<td style="text-align:left;">
						<input type="text" name="tot_40_2" id="tot_40_2" style="width:100px; text-align:right;"  readonly>
					</td>
					<th>Grand Weight</th>
					<td style="text-align:left;">
						<input type="text" name="tot_weight_2" id="tot_weight_2" style="width:100px; text-align:right;"  readonly>
						<span style="font-weight: normal;">TON</span>
					</td>						
				</tr>
			</tbody>
		</table>
	</div>
</div>
<div class="opus_design_grid clear" style="display:none;" name="tabLayer" id="tabLayer">
	<script type="text/javascript">ComSheetObject('t3sheet1');</script>
</div>
             <script language="javascript">comRdObject('report1');</script>

<!-- opus_design_grid(E) -->
</div>
</form>