<%
/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : ESM_BKG_0898.jsp
 *@FileTitle  :  Vessel/Port Group Assign by VVD, Port
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/04/28
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
<%@ page
	import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page
	import="com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.event.EsmBkg0898Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg0898Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

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


		event = (EsmBkg0898Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// If you imported data from the server initialization when loading
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
	<input type="hidden" name="f_cmd" id="f_cmd">
 	<input type="hidden" name="pagerows" id="pagerows">		
	<!-- RouteDetail  Hidden Sheet -->
	<input type="hidden" id="org_trns_mod_cd" name="org_trns_mod_cd" value="">
	<input type="hidden" name="dest_trns_mod_cd" id="dest_trns_mod_cd" value="">
 	<input type="hidden" name="bkg_por_cd" id="bkg_por_cd"> 
 	<input type="hidden" name="bkg_por_yd_cd" id="bkg_por_yd_cd">	
 	<input type="hidden" name="bkg_pol_cd" id="bkg_pol_cd">
	<input type="hidden" name="bkg_pol_yd_cd" id="bkg_pol_yd_cd">
 	<input type="hidden" name="bkg_pod_cd" id="bkg_pod_cd">
 	<input type="hidden" name="bkg_pod_yd_cd" id="bkg_pod_yd_cd">
	<input type="hidden" name="bkg_del_cd" id="bkg_del_cd">
 	<input type="hidden" name="bkg_del_yd_cd" id="bkg_del_yd_cd">
 	<!--  	<input type="hidden" name="base_vvd" id="base_vvd" value="">
 -->
 	<input type="hidden" name="same_por_del" id="same_por_del" value="">
		

	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title">
			<button type="button">
				<span id="title"></span>
			</button>
		</h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
			 --><button type="button" class="btn_accent" name="btn_save" id="btn_save">Save</button><!-- 
			  --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!-- 
			  --><!-- <button type="button" class="btn_normal" name="btn_vvdportchange" id="btn_vvdportchange">VVD/Port Change</button>--->
		</div>
		<!-- opus_design_btn(E) -->
		<!-- page_location(S) -->
		<div class="location">
			<!-- location 내용 동적생성 (별도 코딩 불필요) -->
			<span id="navigation"></span>
		</div>
	</div>
	
	<div class="wrap_search">
	
	<!-- page_title_area(E) -->
	<!-- opus_design_inquiry (S) -->
	<div class="opus_design_inquiry wFit">
		<!--  biz_1 (S) -->
		<table class="search">
			<colgroup>
			     <col width="40"/>
			     <col width="40"/>
			     <col width="100"/>
			     <col width="10"/>
			     <col width="120"/>
			     <col width="60"/>
			     <col width="90"/>	
			     <col width="6%"/>	
			     <col width="110"/>		    			    
			     <col width="*" />
		    </colgroup>
			<tr class="h23">
				<th title="Vessel Voyage Direction">VVD</th>
				<td><input type="text" style="width: 90px;" class="input1" maxlength="9" dataformat="engup" name="vvd"></td>
				<th title="Port of Loading">Loading Port</th>
				<td><input type="text" style="width: 60px;" class="input1" maxlength="5" dataformat="engup" name="pol">
				    <input type="text" style="width: 25px;" class="input" maxlength="2" dataformat="engup" name="pol_yd_cd"></td>
				<th title="Port of Discharging">Discharging Port</th>
				<td><input type="text" style="width: 60px;" class="input1" maxlength="5" dataformat="engup" name="pod">
				    <input type="text" style="width: 25px;" class="input" maxlength="2" dataformat="engup" name="pod_yd_cd"></td>
				<!-- 
				<th>POD</th>
				<td><input type="text" style="width: 60px;" class="input1" maxlength="5" dataformat="engup" name="port"></td>
				 -->
				<th>BKG Office</th>
				<td><input type="text" style="width: 90px;" class="input" value="" maxlength="6" dataformat="engup" name="bkgOfcCd"></td>
				<th>Booking No.</th>
				<td>
					<input type="text" name="bkg_no"  id="bkg_no" class="input1" style="width:110px;" maxlength="13" dataformat="engup" />
					<button type="button" class="multiple_inq ir" style="background: url(./style/images/theme_default/sprite_common.png) -98px -157px no-repeat; background-color:#fff;" name="btn_multBkgNo" id="btn_multBkgNo"></button>
				</td>
				
			</tr>
		</table>
		<!--  biz_1   (E) -->
	</div>
	<!-- opus_design_inquiry(S) -->
	</div>
	
	<!-- wrap_result(S) -->
	<div class="wrap_result">	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" >
		<h3 class="title_design mar_btm_8">Route Details</h3>
	
			<div class="opus_design_btn">
			<!-- opus_design_inquiry(S) -->
				<button type="button" class="btn_normal" name="btn_selectall_route" id="btn_CheckAll_Route">Select All</button><!-- 
				 --><button type="button" class="btn_normal" name="btn_deselectall_route" id="btn_UnCheckAll_Route">DeSelect All</button> 											
			</div>
			<!-- opus_design_btn(e) -->			
		
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<!-- opus_design_btn(S) -->
		<table>
			<colgroup>
        		<col width="130" />
        		<col width="80" />
        		<col width="90" />
        		<col width="80" />
        		<col width="90" />
        		<col width="75" />
        		<col width="100" />
        		<col width="30" />
        		<col width="100" />
        		<col width="60" />
        		<col width="90" />
        		<col width="70" />
        		<col width="90" />
        		<col width="120" />
        		<col width="15" />
        		<col width="*" />
        		<col/>
        	</colgroup>
        	<tbody>
        		<tr>
        			<td><h3 class="title_design">BKG Details</h3></td>
        			<th align="right">E'ty P/UP CY&nbsp;</th>
        			<td><input type="text" style="width: 80px;" class="input" maxlength="7" dataformat="engup" name="mty_pkup_yd_cd_apply"></td>
        			<th align="right">E'ty P/UP DT&nbsp;</th>
        			<td><input type="text" style="width: 74px;" class="input" maxlength="10" dataformat="ymd" name="mty_pkup_dt_apply"></td>
        			<th align="right">Full RTN CY&nbsp;</th>
        			<td><input type="text" style="width: 80px;" class="input" maxlength="7" dataformat="engup" name="full_rtn_yd_cd_apply"></td>
        			<th align="right">VVD&nbsp;</th>
        			<td><input type="text" style="width: 90px;" class="input2" maxlength="9" dataformat="engup" name="base_vvd" readOnly></td>
        			<th align="right"><label id="lbl_pol">POL</label></th>
        			<td><input type="text" style="width: 80px;" class="input" maxlength="7" dataformat="engup" name="pol_yd_cd_apply"></td>
        			<th align="right"><label id="lbl_pod">POD</label></th>
        			<td><input type="text" style="width: 80px;" class="input" maxlength="7" dataformat="engup" name="pod_yd_cd_apply"></td>
        			<th align="right">with Relay Terminal&nbsp;</th>
        			<td><input type="checkbox" name="with_relay" value="" id="with_relay"></td>
        			<td>			
        			<div class="opus_design_btn">
        				<button type="button" class="btn_normal" name="btn_apply" id="btn_apply">Apply</button>
        				<button type="button" class="btn_normal" name="btn_vvdportchange" id="btn_vvdportchange">Route Edit</button>
						<button type="button" class="btn_normal" name="btn_selectall" id="btn_CheckAll">Select All</button><!-- 
						 --><button type="button" class="btn_normal" name="btn_deselectall" id="btn_UnCheckAll">DeSelect All</button> 											
					</div>
					</td>
        		</tr>
       		</tbody>
      		</table>


			<!-- opus_design_btn(e) -->			
		
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
	<!-- opus_design_grid(E) -->

	<!-- wrap_result(E) -->
	

	
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<!--  biz_2 (S) -->
		<table>
			<colgroup>
			     <col width="1%"/>
			     <col width="3%"/>
			     <col width="1%"/>
			     <col width="4%"/>
			     <col width="1%"/>			     			     		    			  
			     <col width="*" />
		    </colgroup>
			<tr class="h23">
				<th>Total B/L</th>
				<td><input type="text" style="width: 40px; text-align: center" class="input2" readOnly name="totalBl" id="totalBl"></td>
				<th>Success</th>
				<td><input type="text" style="width: 40px; text-align: center"class="input2" readOnly name="success"></td>
				<th>Fail</th>
				<td><input type="text" style="width: 40px; text-align: center"class="input2" readOnly name="fail"></td>				
			</tr>
		</table>
		<!--  biz_2   (E) -->
	</div>
	<!-- opus_design_inquiry(E) -->

	<div id='layList' style='position:absolute; z-index:999; display:none; background-color: white;'> <!-- background-color: #d4f6ff; -->
		<table>
			<tr>
				<td>
					<label style="margin-right: 0px;">Rows : </label>
					<label style="margin-right: 0px;" id="rows">000</label>
					<label style="margin-right: 0px;">/</label>
					<label>100</label>
				</td>
			</tr>
		</table>
		<textarea id="mult_bkg_no" name="mult_bkg_no" placeholder="Booking No." class="multi_value mar_none" style="top:0; text-transform: uppercase; width:145px; height: 140px;"></textarea>
	</div>
	

	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet3');</script>
	</div>
	<!-- opus_design_grid(E) -->
	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet4');</script>
	</div>
	<!-- opus_design_grid(E) -->
	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet5');</script>
	</div>
	<!-- opus_design_grid(E) -->
 </div>
</form>
