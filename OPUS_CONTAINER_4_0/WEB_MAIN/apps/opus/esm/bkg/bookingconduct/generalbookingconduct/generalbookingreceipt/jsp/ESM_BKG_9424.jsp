<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_BKG_9424.jsp
*@FileTitle  : Empty Repo BKG Update
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/13
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.event.EsmBkg9424Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg9424Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//serverException
	String strErrMsg = "";						//error massage
	int rowCount	 = 0;						//DB ResultSet list count

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String bkg_no = "";
	String bkg_div = "";
	String popYn	= "";
	Logger log = Logger.getLogger("com.clt.apps.GeneralBookingConduct.GeneralBookingReceipt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg9424Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		bkg_no = JSPUtil.getParameter(request, "bkgno");
		bkg_div = JSPUtil.getParameter(request, "bkgdiv");
		popYn	= request.getParameter("pop_mode") == null ? "N" : "Y";
		
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		//when open screen, get data in server..
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
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="inter_rmk" id="inter_rmk" />
<input type="hidden" name="bundle_no" id="bundle_no" />
<input type="hidden" name="bkg_div" value="<%=bkg_div %>">
<input type="hidden" name="login_id" value="<%=strUsr_id %>">
<% if(popYn.equals("Y")){ %>
<!-- page_title_area(S) -->
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>Empty Repo BKG Update</span></h2>
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_BtmRetrive" id="btn_BtmRetrive">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_BtmNew"  	id="btn_BtmNew">New</button><!--
		--><button type="button" class="btn_normal" name="btn_BtmSave" 	id="btn_BtmSave">Save</button><!--
		--><button type="button" class="btn_normal" name="btn_BtmCancel" 	id="btn_BtmCancel">BKG Cancel</button><!--
		--><button type="button" class="btn_normal" name="btn_CheckOut" 	id="btn_CheckOut" style="display:none">Check Out</button><!--
		--><button type="button" class="btn_normal" name="btn_CheckIn" 	id="btn_CheckIn" style="display:none">Check In</button>
		</div>
	</div>
</div>
<% } else { %>
<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_BtmRetrive" id="btn_BtmRetrive">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_BtmNew"  	id="btn_BtmNew">New</button><!--
		--><button type="button" class="btn_normal" name="btn_BtmSave" 	id="btn_BtmSave">Save</button><!--
		--><button type="button" class="btn_normal" name="btn_BtmCancel" 	id="btn_BtmCancel">BKG Cancel</button><!--
		--><button type="button" class="btn_normal" name="btn_CheckOut" 	id="btn_CheckOut" style="display:none">Check Out</button><!--
		--><button type="button" class="btn_normal" name="btn_CheckIn" 	id="btn_CheckIn" style="display:none">Check In</button>
	</div>
	<!-- opus_design_btn(E) -->
	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->
<% } %>
<!-- opus_design_inquiry(S) -->
<% if(popYn.equals("Y") ){ %><div class="layer_popup_contents"><%}%>
<div class= "wrap_search">
	<div class= "opus_design_inquiry wFit">
		<div class="layout_wrap">
			<div class="layout_vertical_2 pad_left_8" style="width: 16%">
				<table>
				    <tbody>
						<tr>
							<td style="height:25px;"><b>MVMT</b></td>
							<td class="input2">
								<input type="radio" name="bkg_mvmt_cd" id="bkg_mvmt_cd" value="VL" class="trans" checked>VL&nbsp;&nbsp;<!--
								--><input type="radio" name="bkg_mvmt_cd" id="bkg_mvmt_cd" value="VD" class="trans">VD
							</td>
						</tr>
						<tr>
							<td><b>T/VVD</b></td>
							<td class="input2"><input type="text" name="bkg_trunk_vvd" id="bkg_trunk_vvd" style="width:110px"  value="" class="input2" readonly></td>
						</tr>
						<tr>
								<td><b>POL ETD</b></td>
								<td><input type="text" style="width:110px;" id="pol_etd_dt" name="pol_etd_dt" value="" dataformat="" class="input2" readonly></td>
						</tr>	
					</tbody>
				</table>	        
			</div>
			
			<div class="layout_vertical_2 pad_left_8" style="width: 20%">
			    <table>
				    <tbody>
						<tr>
							<td><b>BKG</b></td>
							<td>
								<input type="text" style="width:115px;" name="bkg_no" id="bkg_no"  style="ime-mode:disabled"  dataformat="engup" maxlength="13"  value="<%=bkg_no %>" class="input"><!--
								--><img class="cursor" src="img/btns_inquiry.gif" width="19px" height="20px" border="0" align="absmiddle" name="btn_splitPop" id="btn_splitPop"><!--
								--><input type="text" name="bkg_sts_cd" id="bkg_sts_cd" style="width:18px" value=""><!--
								--><input type="hidden" name="split_flg" id="split_flg">
							</td>
						</tr>
						<tr>
							<td><b>B/L</b></td>
							<td><input type="text" style="width:115px;"  id="bl_no" name="bl_no" style="ime-mode:disabled"  dataformat="engup"  maxlength="13" value="" class="input"><!--
								--><input type="text" style="width:40px;color:blue;font-weight:bold" name="split" id="split" value="" class="noinput">
							</td>
						</tr>
						<tr>
								<td><b>POL ATD</b></td>
								<td><input type="text" style="width:115px;" id="pol_atd_dt" name="pol_atd_dt" value="" dataformat="" class="input2" readonly></td>
						</tr>	
					</tbody>
				</table>
			</div>
			
			<div class="layout_vertical_2 pad_left_8" style="width:17%">
				<table>
				    <tbody>
						<tr>
							<td><b>RHQ OFC</b></th>
							<td class="input2"><input type="text" style="width:77px;" name="sls_rhq_cd" id="sls_rhq_cd" value="" class="input2" readonly></td>
						</tr>
						<tr>
							<td><b>ORG Yard</b></td>
							<td class="input2"><input type="text" style="width:77px;" name="org_yd_cd" id="org_yd_cd" value="" class="input2" readonly></td>
						</tr>
						<tr>
								<td><b>POD ETA</b></td>
								<td><input type="text" style="width:115px;" id="pod_eta_dt" name="pod_eta_dt" value="" dataformat="" class="input2" readonly></td>
						</tr>	
					</tbody>
				</table>
			</div>
			
			<div class="layout_vertical_2 pad_left_8" style="width:25%">
				<table>
				    <tbody>
						<tr>
							<td><b>BKG DT</b></th>
							<td colspan="3" class="input2"><input type="text" style="width:115px;" id="bkg_cre_dt" name="bkg_cre_dt" value="" class="input2" readonly></td>
							<td><b>POL</b></td>
							<td class="input2"><input type="text" style="width:50px;"  name="bkg_pol_cd" id="bkg_pol_cd" value="" readonly></td>
						</tr>
						<tr>
							<td><b>POD</b></td>
							<td><input type="text" style="width:50px;" id="bkg_pod_cd" name="bkg_pod_cd" value="" dataformat="engup" class="input2" readonly></td>
							<td><b>PRE</b></td>
							<td class="input2"><input type="text" style="width:50px;" name="pol_cd" id="pol_cd" value="" class="input2" readonly></td>
							<td><b>Post</b></td>
							<td class="input2"><input type="text" style="width:50px;" name="pod_cd" id="pod_cd" value="" class="input2" readonly></td>
						</tr>
						<tr>
								<td><b>POD ATA</b></td>
								<td colspan="5"><input type="text" style="width:115px;" id="pod_ata_dt" name="pod_ata_dt" value="" dataformat="" class="input2" readonly></td>
						</tr>
					</tbody>
				</table>
			</div>
			
			<div class="layout_vertical_2 pad_left_8" style="width:20%">
				<table>
				        <tbody>
				        	<tr>
								<td><b>Ind.</b></td>
								<td  class="input2">
									<input type="radio" name="mty_bkg_sts_cd" id="mty_bkg_sts_cd" value="S" class="trans" checked>Sound&nbsp;&nbsp;<!--
									--><input type="radio" name="mty_bkg_sts_cd" id="mty_bkg_sts_cd" value="D" class="trans" >Damage&nbsp;&nbsp;<!--
									--><input type="radio" name="mty_bkg_sts_cd" id="mty_bkg_sts_cd" value="H" class="trans" >H/Rack
								</td>
						</tr>	
						<tr>
							<td></td>	
						</tr>	
						
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>
<!-- opus_design_inquiry(E) -->
<!-- layout_wrap (S) -->
<div class="wrap_result">
	<table>
		<tbody>
			<colgroup>
				<col width="700"/>
				<col width="*"/>
			</colgroup>
			<tr>
				<td><h3 class="title_design">Repo. Container No.</h3></td>
				<!--<td><input type="radio" name="mvmt_option" id="mvmt_option" value="V" class="trans" checked><Span style="color: #005CB9; font-weight: bold;">Movement(VL)</Span>&nbsp;&nbsp;
			    <input type="radio" name="mvmt_option" id="mvmt_option" value="S" class="trans"><Span style="color: #005CB9; font-weight: bold;">Stowage Plan</Span>&nbsp;&nbsp;
				</td>-->
				<td align="right" class="pad_btm_8" style="display:none"><button type="button" class="btn_etc" name="btn_Ts" id="btn_Ts">T/S Route</button></td>
			</tr>
		</tbody>
	</table>


    <div class="layout_vertical_2 pad_left_8" style="width: 45%">
        <!-- opus_design_grid(S) -->
        <div class="opus_design_grid" id="mainTable" name="mainTable">
         	<div class="opus_design_btn">
         	<button type="button" class="btn_accent" name="btn_ExcelFormat" id="btn_ExcelFormat">Excel Format</button><!--
			    --><button type="button" class="btn_accent" name="btn_LoadExcel" id="btn_LoadExcel">Load Excel</button><!--
			    --><button type="button" class="btn_normal" name="btn_DownExcel" id="btn_DownExcel">Down Excel</button><!--
			    --><button type="button" class="btn_normal" name="btn_Add" id="btn_Add">Add</button><!--
			    --><button type="button" class="btn_normal" name="btn_Delete" id="btn_Delete">Del.</button>
			</div>   
             <script type="text/javascript">ComSheetObject('sheet1');</script>
             
             <div  align="left">* () : No. of GOH</div>
        </div>
        <!-- opus_design_grid(e) -->
    </div>
    <div class="layout_vertical_2 pad_left_8" style="width: 15%">
        <!-- opus_design_grid(S) -->
        <div class="opus_design_grid" id="mainTable" name="mainTable">
	       <div class="opus_design_btn">
			  <button type="button" class="btn_normal" name="btn_Mty" id="btn_Mty">MTY</button><!--
			  --><button type="button" class="btn_normal" name="btn_Bundle" id="btn_Bundle">Bundle</button><!--
			  --><button type="button" class="btn_normal" name="btn_Rmk" id="btn_Rmk">RMK</button>
			</div>   
			<script type="text/javascript">ComSheetObject('sheet2');</script>
        </div>
        <!-- opus_design_grid(e) -->
    </div>
     
    <div class="layout_vertical_2 pad_left_8" style="width: 25%;padding-top:8px;">
         <!-- opus_design_grid(S) -->
        <div class="opus_design_grid" id="mainTable" name="mainTable"> 
             <div class="mar_btm_8">
              <input type="radio" name="mvmt_option" id="mvmt_option" value="V" class="trans" checked><Span style="color: #005CB9; font-weight: bold;">Movement(VL)</Span>&nbsp;&nbsp;<!--
			  --><input type="radio" name="mvmt_option" id="mvmt_option" value="S" class="trans"><Span style="color: #005CB9; font-weight: bold;">Stowage Plan</Span>
             </div>        	
             <script type="text/javascript">ComSheetObject('sheet3');</script>
         </div>
         <!-- opus_design_grid(e) -->
    </div>
    
	<div class="layout_vertical_2 pad_left_8" style="width: 15%">
         <!-- opus_design_grid(S) -->
        <div class="opus_design_grid" id="mainTable" name="mainTable">
            <div class="opus_design_btn">
			  <button type="button" class="btn_accent" name="btn_Move" id="btn_Move">Move</button><!--
			  --><button type="button" class="btn_normal" name="btn_CheckAll" id="btn_CheckAll">Check All</button>
			</div>
			<script type="text/javascript">ComSheetObject('sheet4');</script>
        </div>
         <!-- opus_design_grid(e) -->
     </div>
 </div>
<!-- layout_wrap (e) -->	
	<% if(popYn.equals("Y") ){ %></div><%}%>	
<!-- opus_design_grid(S) -->
<div class="wrap_result">
	<div class="opus_design_grid" id="mainTable" name="mainTable">
			<script type="text/javascript">ComSheetObject('sheet5');</script>
	</div>
</div>
<!-- opus_design_grid(E) -->	

<!-- opus_design_grid(S) -->
<div class="wrap_result">
	<div class="opus_design_grid" id="mainTable" name="mainTable">
			<script type="text/javascript">ComSheetObject('sheet6');</script>
	</div>
</div>
<!-- opus_design_grid(E) -->	

<!-- opus_design_grid(S) -->
<div class="wrap_result">
	<div class="opus_design_grid" id="mainTable" name="mainTable">
			<script type="text/javascript">ComSheetObject('sheet7');</script>
	</div>
</div>
<!-- opus_design_grid(E) -->	

</form>
