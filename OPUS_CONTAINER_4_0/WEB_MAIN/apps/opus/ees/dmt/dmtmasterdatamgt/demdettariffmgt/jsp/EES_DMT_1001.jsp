<%
/*=========================================================
*@FileName   EES_DMT_1001.jsp
*@FileTitle  : Basic Tariff Creation
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
<%@ page import="com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.event.EesDmt1001Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	EesDmt1001Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB ResultSet list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.DMTMasterDataMgt.DemDetTariffMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesDmt1001Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// in loading page, Get data from server.
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
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
</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="conti_cd" id="conti_cd">
<input type="hidden" name="cnt_cd" id="cnt_cd">
<input type="hidden" name="rgn_cd" id="rgn_cd">
<input type="hidden" name="ste_cd" id="ste_cd">
<input type="hidden" name="loc_cd" id="loc_cd">
<input type="hidden" name="yd_cd" id="yd_cd">

<input type="hidden" name="dmdt_trf_cd" id="dmdt_trf_cd">
<input type="hidden" name="cvrg_conti_cd" id="cvrg_conti_cd">
<input type="hidden" name="cvrg_cnt_cd" id="cvrg_cnt_cd">
<input type="hidden" name="cvrg_rgn_cd" id="cvrg_rgn_cd">
<input type="hidden" name="cvrg_ste_cd" id="cvrg_ste_cd">
<input type="hidden" name="cvrg_loc_cd" id="cvrg_loc_cd">
<input type="hidden" name="cvrg_yd_cd" id="cvrg_yd_cd">
<input type="hidden" name="org_dest_conti_cd" id="org_dest_conti_cd">
<input type="hidden" name="org_dest_cnt_cd" id="org_dest_cnt_cd">
<input type="hidden" name="org_dest_rgn_cd" id="org_dest_rgn_cd">
<input type="hidden" name="org_dest_ste_cd" id="org_dest_ste_cd">
<input type="hidden" name="org_dest_loc_cd" id="org_dest_loc_cd">

<input type="hidden" name="svr_id" id="svr_id">
<input type="hidden" name="trf_seq" id="trf_seq">
<input type="hidden" name="trf_grp_seq" id="trf_grp_seq">

<input type="hidden" name="wknd1" id="wknd1" value="SAT">
<input type="hidden" name="wknd2" id="wknd2" value="SUN">


<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!-- 
	 	--><button type="button" class="btn_accent" name="btn_Retrieve" 		id="btn_Retrieve">Retrieve</button><!-- 
	  	--><button type="button" class="btn_normal" name="btn_New"  			id="btn_New">New</button><!-- 
	   	--><button type="button" class="btn_normal" name="btn_Create"  			id="btn_Create">Create</button><!-- 
	    --><button type="button" class="btn_normal" name="btn_Update"  			id="btn_Update">Update</button><!-- 
     	--><button type="button" class="btn_normal" name="btn_Confirm"  		id="btn_Confirm">Confirm</button><!-- 
      	--><button type="button" class="btn_normal" name="btn_Expire" 			id="btn_Expire">Expire</button><!-- 
       	--><button type="button" class="btn_normal" name="btn_ConfirmCancel" 	id="btn_ConfirmCancel">Confirm Cancel</button><!-- 
        --><button type="button" class="btn_normal" name="btn_Delete" 			id="btn_Delete">Delete</button><!-- 
       	--><button type="button" class="btn_normal" name="btn_Copy" 			id="btn_Copy">Copy</button><!-- 
        --><button type="button" class="btn_normal" name="btn_Downexcel" 		id="btn_Downexcel">Down Excel</button>
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="74px">
				<col width="480px">
				<col width="84px">
				<col width="*">
			</colgroup> 
			<tr>
				<th>Tariff Type</th>
				<td>
					<script type="text/javascript">ComComboObject('combo1', 2, 96 , 0, 1, 0, true)</script><!-- 
				 --><input type="text" name="dmdt_trf_nm" id="dmdt_trf_nm" style="width:410px;" class="input2" readonly value=""></td>
				<th>Confirmed</th>
				<td><input type="text" name="confirm_yn" id="confirm_yn" style="width:60px;" class="input2" value="" readonly></td>
			</tr> 
		</table>
		<table>
			<colgroup>
				<col width="70px">
				<col width="60px">
				<col width="70px">
				<col width="50px">
				<col width="80px">
				<col width="50px">
				<col width="90px">
				<col width="55px">
				<col width="115px">
				<col width="35px">
				<col width="50px">
				<col width="*">
			</colgroup>
			<tr>
				<th>Coverage</th>
				<td>Continent</td>
				<td><script type="text/javascript">ComComboObject('combo2', 2, 40 , 0, 1, 0, true)</script></td>
				<td>Country</td>
				<td><script type="text/javascript">ComComboObject('combo3', 2, 50 , 0, 1, 0, true)</script></td>
				<td><span id="Region">Region</span></td>
				<td><script type="text/javascript">ComComboObject('combo4', 2, 60 , 0, 0, 0, true)</script></td>
				<td>Location</td>
				<td><input type="text" id="cvrg_location" name="cvrg_location" caption="Location" maxlength="5" fullfill style="width:60px;" class="input" value="" dataformat="engup" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum')" OnKeyUp="checkLocation1(this)"></td>
				<td>Yard</td>
				<td><input type="text" id="yd_cd1" name="yd_cd1" style="width:60px;" class="input" value="" dataformat="engup" maxlength="5" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum')" OnKeyUp="checkYard1(this)" ></td>
				<td><script type="text/javascript">ComComboObject('combo5', 2, 50 , 0, 0, 0, true)</script></td>
			</tr>
		</table>
		<table>
			<colgroup>
				<col width="70px">
				<col width="60px">
				<col width="70px">
				<col width="50px">
				<col width="80px">
				<col width="50px">
				<col width="90px">
				<col width="55px">
				<col width="90px">
				<col width="*">
			</colgroup>
			<tr>
				<th><span id="OriginDest">Origin</span></th>
				<td>Continent</td>
				<td><script type="text/javascript">ComComboObject('combo6', 2, 40 , 0, 1, 0, true)</script></td>
				<td>Country</td>
				<td><script type="text/javascript">ComComboObject('combo7', 2, 50 , 0, 0, 0, true)</script></td>
				<td><span id="Region2">Region</span></td>
				<td><script type="text/javascript">ComComboObject('combo8', 2, 60 , 0, 0, 0, true)</script></td>
				<td>Location</td>
				<td><input type="text" id="org_dest_location" name="org_dest_location" caption="Location" maxlength="5" fullfill style="width:60px;" class="input" value="" dataformat="engup" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum')" OnKeyUp="checkLocation2(this)"></td>
				<td></td>
			</tr>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(S) -->

	<!-- layout_wrap(S) -->
	<div class="layout_wrap" style="width: 100%;">
		<!-- layout_vertical_2(S) -->
		<div class="layout_vertical_2 mar_top_4" style="width: 30%;">
			<div style="height: 26px;">
				<table>
					<tr>
						<th width="110" class="align_left" >F/Time Exclusion</th>
						<td width="*" >
							<input type="checkbox" name="xcld_sat_flg" id="xcld_sat_flg" value="" disabled><label for="xcld_sat_flg"><span id="wknd1">SAT</span></label><!--
						 --><input type="checkbox" name="xcld_sun_flg" id="xcld_sun_flg" value="" disabled><label for="xcld_sun_flg"><span id="wknd2">SUN</span></label><!--
						 --><input type="checkbox" name="xcld_hol_flg" id="xcld_hol_flg" value="" disabled><label for="xcld_hol_flg">HOLIDAY</label>
						</td>
					</tr>
				</table>
			</div>
			<div class="opus_design_grid" id="mainTable">
				<script type="text/javascript">ComSheetObject('sheet2');</script>
			</div>
		</div>
	    <!-- layout_vertical_2(E) -->
	    
	    <!-- layout_vertical_2(S) -->
		<div class="layout_vertical_2 pad_left_12" style="width: 70%;">
			<div style="height: 30px;">
				<table>
					<tr>
						<th width="120">F/Time Commence</th>
						<td width="180">
							<input type="text" name="dmdt_chg_cmnc_tp_nm" id="dmdt_chg_cmnc_tp_nm" style="width:100px;" class="input2" readonly value=""><!--
						 --><input type="text" name="cmnc_hr" id="cmnc_hr" class="input2" readonly style="width:30px;" class="input" value="">HR
						</td>
						<th width="60">Currency</th>
						<td><input type="text" name="curr_cd" id="curr_cd" style="width:60px;" class="input2" readonly value=""></td>
					</tr>
				</table>
			</div>
			<div class="opus_design_grid" id="mainTable">
				<script type="text/javascript">ComSheetObject('sheet3');</script>
			</div>
		</div>
		<!-- layout_vertical_2(E) -->
	</div>
	<!-- layout_wrap(E) -->
					
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="mainTable2" style="display: none;">
		<script type="text/javascript">ComSheetObject('sheet4');</script>
	</div>
	<!-- opus_design_grid(S) -->
</div>
</form>