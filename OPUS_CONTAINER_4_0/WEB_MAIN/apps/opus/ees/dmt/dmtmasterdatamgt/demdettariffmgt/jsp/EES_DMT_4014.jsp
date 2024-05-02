<%/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_DMT_4014.jsp
*@FileTitle  : P/F SKD Settlement
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/19
=========================================================*/%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.event.EesDmt4014Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	EesDmt4014Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

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


		event = (EesDmt4014Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// Retrieving the parameter values ​​for calls to pop-up page ..
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
<input type="hidden" name="f_cmd" 				id="f_cmd">
<input type="hidden" name="pagerows" 			id="pagerows">
<input type="hidden" name="conti_cd" 			id="conti_cd">
<input type="hidden" name="cnt_cd" 				id="cnt_cd">
<input type="hidden" name="rgn_cd" 				id="rgn_cd">
<input type="hidden" name="ste_cd" 				id="ste_cd">
<input type="hidden" name="loc_cd" 				id="loc_cd">
<input type="hidden" name="yd_cd" 				id="yd_cd">

<input type="hidden" name="dmdt_trf_cd" 		id=dmdt_trf_cd">
<input type="hidden" name="cvrg_conti_cd" 		id="cvrg_conti_cd">
<input type="hidden" name="cvrg_cnt_cd" 		id="cvrg_cnt_cd">
<input type="hidden" name="cvrg_rgn_cd" 		id="cvrg_rgn_cd">
<input type="hidden" name="cvrg_ste_cd" 		id="cvrg_ste_cd">
<input type="hidden" name="cvrg_loc_cd" 		id="cvrg_loc_cd">
<input type="hidden" name="cvrg_yd_cd" 			id="cvrg_loc_cd">
<input type="hidden" name="org_dest_conti_cd" 	id="org_dest_conti_cd">
<input type="hidden" name="org_dest_cnt_cd" 	id="org_dest_cnt_cd">
<input type="hidden" name="org_dest_rgn_cd" 	id="org_dest_rgn_cd">
<input type="hidden" name="org_dest_ste_cd" 	id="org_dest_ste_cd">
<input type="hidden" name="org_dest_loc_cd" 	id="org_dest_loc_cd">

<input type="hidden" name="svr_id" 				id="svr_id">
<input type="hidden" name="trf_seq" 			id="trf_seq">
<input type="hidden" name="trf_grp_seq" 		id="trf_grp_seq">

<input type="hidden" name="wknd1" 				id="wknd1" value="SAT">
<input type="hidden" name="wknd2" 				id="wknd2" value="SUN">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" 		id="btn_Retrieve">Retrieve</button>
		<button type="button" class="btn_normal" name="btn_New"  			id="btn_New">New</button>
		<button type="button" class="btn_normal" name="btn_Create" 			id="btn_Create">Create</button>
		<button type="button" class="btn_normal" name="btn_Update"			id="btn_Update">Update</button>
		<button type="button" class="btn_normal" name="btn_Confirm" 		id="btn_Confirm">Confirm</button>
		<button type="button" class="btn_normal" name="btn_Expire" 			id="btn_Expire">Expire</button>
		<button type="button" class="btn_normal" name="btn_ConfirmCancel" 	id="btn_ConfirmCancel">Confirm Cancel</button>
		<button type="button" class="btn_normal" name="btn_Delete" 			id="btn_Delete">Delete</button>
		<button type="button" class="btn_normal" name="btn_Copy" 			id="btn_Copy">Copy</button>
		<button type="button" class="btn_normal" name="btn_Downexcel" 		id="btn_Downexcel">Down Excel</button>
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->

<!-- opus_design_inquiry(S) -->
<div class="opus_design_inquiry">
	<table>
		<tbody>
			<colgroup>
				<col width="90px"/>
				<col width="504px"/>
				<col width="95px"/>
				<col width="60px"/>
				<col width="*"/>
		    </colgroup>
			<tr class="h23">
				<th style="text-align:left;">Tariff Type</th>
				<td>
					<script type="text/javascript">ComComboObject('combo1', 2, 104 , 0, 1, 0, true)</script>&nbsp;
					<input type="text" name="dmdt_trf_nm" 	id="dmdt_trf_nm" 	style="width:373px;" 	class="input2" readonly value="">
				</td>
				<th>Confirmed</th>
				<td>
					<input type="text" name="confirm_yn" 	id="confirm_yn" 	style="width:50px;" 	class="input2" value="" readonly>
				</td>
				<td></td>
			</tr>
		</tbody>
	</table>
	<table>
		<tbody>
			<colgroup>
				<col width="90px"/>
				<col width="120px"/>
				<col width="120px"/>
				<col width="130px"/>
				<col width="130px"/>
				<col width="120px"/>
				<col width="*"/>
		    </colgroup>
			<tr class="h23">
				<th style="text-align:left;">Coverage</th>
				<td class="stm">Continent&nbsp;
					<input type="text" name="cvrg_continent" 	id="cvrg_continent" caption="Continent" style="width:44px;" 					class="input2" readonly value="A" >
				</td>
				<td class="stm">Country&nbsp;
					<input type="text" name="cvrg_country" 		id="cvrg_country"  	caption="country" 	style="width:50px;" 					class="input2" readonly value="CN" >
				</td>
				<td class="stm">Region&nbsp;
					<input type="text" name="cvrg_region" 		id="cvrg_region" 	caption="region" 	style="width:60px;" 					class="input2" readonly value="CNS" >
				</td>
				<td class="stm">Location&nbsp;
					<input type="text" name="cvrg_location" 	id="cvrg_location" 	caption="Location" 	style="width:60px;ime-mode:disabled;" 	class="input" maxlength="5" fullfill value="" dataformat="engup" onKeyPress="ComKeyOnlyAlphabet('upper')" OnKeyUp="checkLocation1(this)">
				</td>
				<td class="stm">Yard&nbsp;
					<input type="text" name="yd_cd1" 			id="yd_cd1" 							style="width:60px;ime-mode:disabled;" 	class="input" value="" dataformat="engup" maxlength="5" onKeyPress="ComKeyOnlyAlphabet('upper')" OnKeyUp="checkYard1(this)" >
					<script type="text/javascript">ComComboObject('combo2', 2, 50 , 0, 0, 0, true)</script>
				</td>
				<td></td>
			</tr>
			<tr class="h23">
				<th style="text-align:left;"><span id="OriginDest">Origin</span></th>
				<td class="stm">Continent&nbsp;
					<script type="text/javascript">ComComboObject('combo3', 2, 44 , 0, 1, 0, true)</script>
				</td>
				<td class="stm">Country&nbsp;
					<script type="text/javascript">ComComboObject('combo4', 2, 50 , 0, 0, 0, true)</script>
				</td>
				<td class="stm"><span id="Region2">Region</span>&nbsp;
					<script type="text/javascript">ComComboObject('combo5', 2, 60 , 0, 0, 0, true)</script>
				</td>
				<td class="stm">Location&nbsp;
					<input type="text" name="org_dest_location" id="org_dest_location" caption="Location" maxlength="5" fullfill style="width:60px;" class="input" value="" dataformat="engup" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('upper')" OnKeyUp="checkLocation2(this)">
				</td>
				<td></td>
			</tr>
		</tbody>
	</table>
</div>
<!-- opus_design_inquiry(E) -->

<!-- opus_design_grid(S) -->
<div class="opus_design_grid">
    <script type="text/javascript">ComSheetObject('sheet1');</script>
</div>
<!-- opus_design_grid(E) -->
<div class="layout_wrap" style="width:85%;">
    <div class="layout_vertical_2" style="width:370px;">
        <!-- opus_design_grid(S) -->
        <div class="opus_design_grid">
        	<div class="opus_design_data">
				<table class="mar_btm_4">
					<tbody>
						<colgroup>
							<col width="110px"/>
							<col width="180px"/>
					    </colgroup>
						<tr class="h23">
							<tr class="h23">
								<th>F/Time Exclusion</th>
								<td class="stm">
									<input type="checkbox" name="xcld_sat_flg" id="xcld_sat_flg" value="Y" class="trans" disabled>
									<span id="wknd1">SAT</span>&nbsp;&nbsp;
									<input type="checkbox" name="xcld_sun_flg" id="xcld_sun_flg" value="Y" disabled class="trans">
									<span id="wknd2">SUN</span>&nbsp;&nbsp;
									<input type="checkbox" name="xcld_hol_flg" id="xcld_hol_flg" value="Y" disabled class="trans">&nbsp;&nbsp;HOLIDAY
								</td>
							</tr>
					</tbody>
				</table>
			</div>
            <script type="text/javascript">ComSheetObject('sheet2');</script>
        </div>
        <!-- opus_design_grid(E) -->
    </div>
    <div class="layout_vertical_2" style="width:65%;">
        <!-- opus_design_grid(S) -->
       	<div class="opus_design_grid">
        	<div class="opus_design_data">
				<table style="width:auto" class="mar_btm_4">
					<tbody>
						<colgroup>
							<col width="120"/>
							<col width="200"/>
							<col width="60"/>
							<col/>
					    </colgroup>
						<tr class="h23">
							<th>F/Time Commence</th>
							<td class="stm">
								<input type="text" name="dmdt_chg_cmnc_tp_nm" 	id="dmdt_chg_cmnc_tp_nm" 	style="width:100px;" 	class="input2" readonly value=""><!-- 
								--><input type="text" name="cmnc_hr" 				id="cmnc_hr" 				style="width:30px;" 	class="input2" readonly class="input" value="">&nbsp;HR
							</td>
							<th>Currency</th>
							<td>
								<input type="text" name="curr_cd" 				id="curr_cd" 				style="width:60px;" 	class="input2" readonly value="">
							</td>
						</tr>
					</tbody>
				</table>
			</div>
            <script type="text/javascript">ComSheetObject('sheet3');</script>
        </div>
        <!-- opus_design_grid(E) -->
   	</div>		
</div>
<div id="mainTable2" style="display:none;">
	<!-- hidden 처리 (S)--> 
	<script type="text/javascript">ComSheetObject('sheet4');</script>
	<!-- hidden 처리 (E)-->
</div>
</form>