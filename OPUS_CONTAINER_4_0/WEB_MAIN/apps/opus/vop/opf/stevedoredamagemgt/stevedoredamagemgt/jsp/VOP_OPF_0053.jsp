<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : VOP_OPF_0053.jsp
*@FileTitle  : Stevedore Damage Inquiry & Update 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/19
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.event.VopOpf0053Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.Date"%>
<%
	VopOpf0053Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.StevedoreDamageMgt.StevedoreDamageMgt");
	
	String[] arrUsrAuth = null;
	String popUpOpen	= "N";	// Checking popUp Open authority
	int i_cnt 		= 0;
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id  =	account.getUsr_id();
		strUsr_nm  = account.getUsr_nm();
//		arrUsrAuth = account.getUserAuth();


		//In case of Role of login user is OPF04 , Open Pop-up
//		if(arrUsrAuth == null){
//			popUpOpen = "N";
//		}else{
//			for(int i = 0; i < arrUsrAuth.length; i++) {
//				if(arrUsrAuth[i].equals("OPF04")||arrUsrAuth[i].equals("OPF01"))
//				{
//					i_cnt++;
//				}
//			}
//			if(i_cnt > 0 ){
//				popUpOpen = "Y";
//			}
//		}
		event = (VopOpf0053Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// adding logic to get data from server when first loading
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
<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" 	id="btn_Retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_New" 		id="btn_New">New</button><!--
		--><button type="button" class="btn_normal" name="btn_Open" 		id="btn_Open">Open</button>
			<button type="button" class="btn_normal" name="btn_DownExcel" 	id="btn_DownExcel">Down Excel</button><!--
		--><button type="button" class="btn_normal" name="btn_History"  		id="btn_History">History</button>	
	</div>
	<!-- opus_design_btn(E) -->
	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->
<!-- opus_design_inquiry(S) -->
<div class= "wrap_search">
	<div class= "opus_design_inquiry wFit">
		<table>
			<tbody>
				<colgroup>
					<col width="80"/>
					<col width="100"/>
					<col width="80"/>
					<col width="100"/>
					<col width="80"/>
					<col width="100"/>
					<col width="80"/>
					<col width="*"/>
			    </colgroup>
				<tr>
					<th>Vessel</th>
					<td><input type="text" style="width:70px;ime-mode:disabled;" class="input" maxlength="4"  dataformat = "engup"  name="vvd_cd" id="vvd_cd" /><button type="button" id="vvd_cd_pop" name="vvd_cd_pop" class="input_seach_btn"></button></td>
					<th>Port</th>
					<td><input type="text" style="width:70px;ime-mode:disabled;" class="input" maxlength="5" dataformat = "engup"  name="vps_port_cd" id="vps_port_cd" /><button type="button" id="vps_port_cd_pop" name="vps_port_cd_pop" class="input_seach_btn"></button></td>
					<th>Lane</th>
					<td><input type="text" style="width:70px;ime-mode:disabled;" class="input" maxlength="3" dataformat = "engup" name="slan_cd" id="slan_cd" /><button type="button" id="slan_cd_pop" name="slan_cd_pop" class="input_seach_btn"></button></td>
					<th>Period</th>
					<td><input type="text" style="width:80px;" maxlength="8" class="input1" dataformat="ymd" name="stv_dmg_evnt_dt_from" value="2008-01-01" caption="Period From" required id="stv_dmg_evnt_dt_from" />~ <input type="text" style="width:80px;" maxlength="8" class="input1" dataformat="ymd" name="stv_dmg_evnt_dt_to" id="stv_dmg_evnt_dt_to" caption="Period To" required><button type="button" id="cal_stv_dmg_evnt_dt_to" name="cal_stv_dmg_evnt_dt_to" class="calendar ir"></button></td>
				</tr>	
				<tr>
					<th>The Day Elapse</th>
					<td><input type="text" style="width:70px;" class="input" maxlength="8" dataformat="int" name="elapse_day" id="elapse_day" /> </td>					
					<th>Report No.</th>
					<td colspan="3"><input type="text" style="width:70px;ime-mode:disabled;" class="input" maxlength="20" name="stv_dmg_ref_no" id="stv_dmg_ref_no" /> </td>
					<th>Vessel Category</th>
					<td><script type="text/javascript">ComComboObject('vsl_type_cd',1,196,1,0,0);</script></td>
				</tr>
				<tr>
					<th rowspan="2">Process</th>
					<td class="warp_search_btn" align="center">Damage</td>
					<td class="warp_search_btn" align="center" >Repair</td>
					<td class="warp_search_btn" align="center" >Compensation</td>
					<td class="warp_search_btn" align="center" >Settlement</td>
					<td></td>
					<th>Claim Amount</th>
					<td><input type="text" name="cmpn_cost_usd_amt" caption="Claim Amount" style="width:196px;" class="input" maxlength="11" maxnum="99999999" dataformat="float" pointcount="2" id="cmpn_cost_usd_amt" />(USD)</td>
				</tr>
				<tr>
					<td class="warp_search_btn" align="center"><script type="text/javascript">ComComboObject('stv_dmg_req_cate_cd',1,100,1,0,0);</script></td>
					<td class="warp_search_btn" align="center"><script type="text/javascript">ComComboObject('stv_dmg_rpr_proc_sts_cd',1,100,1,0,0);</script></td>
					<td class="warp_search_btn" align="center"><script type="text/javascript">ComComboObject('stv_dmg_cmpn_proc_sts_cd',1,100,1,0,0);</script></td>
					<td class="warp_search_btn" align="center"><script type="text/javascript">ComComboObject('stv_dmg_stl_proc_sts_cd',1,100,1,0,0);</script></td>
					<td colspan="3"></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<!-- opus_design_inquiry(E) -->
<!-- opus_design_grid(S) -->
<div class="wrap_result">
	<div class="opus_design_grid clear" >
		<div class="opus_design_btn">
			
		</div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
<!-- opus_design_grid(E) -->
</form>