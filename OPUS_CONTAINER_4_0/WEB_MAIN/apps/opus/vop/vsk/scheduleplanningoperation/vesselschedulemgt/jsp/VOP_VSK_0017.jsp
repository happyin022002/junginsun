<%
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : VOP_VSK_0017.js
*@FileTitle : Daily Berth Window
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/14
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event.VopVsk0017Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopVsk0017Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB ResultSet list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String eml = "";
	Logger log = Logger.getLogger("com.clt.apps.scheduleplanningoperation.vesselschedulemgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		eml = account.getUsr_eml();

		event = (VopVsk0017Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>


<script  type="text/javascript">
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
<input type="hidden" name="loc_cd" id="loc_cd">
<input type="hidden" name="gw_subject" id="gw_subject">
<input type="hidden" name="gw_contents" id="gw_contents">
<input type="hidden" name="usrInfo" id="usrInfo">
<input type="hidden" name="com_subject" id="com_subject">
<input type="hidden" name="com_content" id="com_content">
<input type="hidden" name="com_from" id="com_from" value="<%=eml%>">

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve"	id="btn_retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_save" 		id="btn_save">Save</button><!--	
		 --><button type="button" class="btn_normal" name="btn_group" 		id="btn_group">Group Registration</button><!--	
		 --><button type="button" class="btn_normal" name="btn_send_mail" 		id="btn_send_mail">Send Mail</button><!--	
		 -->
		 <!-- 
         * 2014.12.23
         * dongsoo 
         * btn_send_edi hidden 처리 
          -->
         <button type="button" class="btn_normal" name="btn_send_edi" 		id="btn_send_edi" style="display:none" >Send EDI</button>
        
	 </div>
	<!-- opus_design_btn(E) -->

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
	<table>
		<colgroup>
			<col width="40"/>
			<col width="210"/>
			<col width="70"/>
			<col width="170"/>
			<col width="90"/>
			<col width="270"/>
			<col width="180"/>									
			<col width="*" />
	   	</colgroup>
		<tbody>
			<tr>
				<th>Period</th>
				<td>
					<input type="text" name="fm_dt" id="fm_dt" style="width:80px;text-align:center;" class="input1" value="" readonly="readonly" />~&nbsp;<!-- 
					 --><input type="text" name="to_dt" id="to_dt" style="width:80px;text-align:center;" class="input1" value="" readonly="readonly" /><!-- 
					 --><button type="button" id="btn_period" name="btn_period" class="calendar ir"></button>
				</td>
				<th>Port</th>
				<td>
					<input type="text" name="vps_port_cd" id="vps_port_cd" style="width:50px;text-align:center;ime-mode:disabled;" class="input1" value="" maxlength="5" onfocus="this.select();" dataformat="engup" onchange="obj_change()"><!-- 
					 --><button type="button" id="btn_port" name="btn_port" class="input_seach_btn"></button><!-- 
					 --><script  type="text/javascript">ComComboObject('yd_cd',2,70,1,0);</script><!-- 
				 --></td>
				
				<th>Direction</th>  
				<td>
					<script  type="text/javascript">ComComboObject('skd_dir_cd',1,70,1,0);</script><!-- 
				--><script  type="text/javascript">ComComboObject('lane_grp',1,60,1,0);</script><!-- 
				--><div id="div_lane" style="display:inline"><!-- 
						 --><input type="text" name="slan_cd" id="slan_cd" style="width:60px;text-align:center;ime-mode:disabled;" class="input" value="" maxlength="3" dataformat="engup" onfocus="this.select();"><!-- 
						 --><button type="button" id="btn_lane" name="btn_lane" class="input_seach_btn"></button><!-- 
					 --></div><!-- 
				--><div id="div_grp" style="display:none"><!-- 
						 --><script  type="text/javascript">ComComboObject('lane_grp_nm',1,70,1,0);</script>
					</div>
				</td> 
				<th class="wrap_search_btn">
					<input type="radio" name="vsl_svc_tp_cd" id="vsl_svc_tp_cd" value="" class="trans" checked><label for="vsl_svc_tp_cd">All</label><!-- 
					 --><input type="radio" name="vsl_svc_tp_cd" id="vsl_svc_tp_cd_1" value="T" class="trans"><label for="vsl_svc_tp_cd_1">Trunk</label><!-- 
					 --><input type="radio" name="vsl_svc_tp_cd" id="vsl_svc_tp_cd_2" value="O" class="trans"><label for="vsl_svc_tp_cd_2">Feeder</label><!-- 
				 --></th>	
				<td></td>				
			</tr>
		</tbody>
	</table>
</div>
<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	
<!-- opus_design_grid(S) -->
<div class="opus_design_grid clear">	

	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_downexcel" id="btn_downexcel">Down Excel</button>	
	</div>
	<!-- opus_design_btn(E) -->	

	<script type="text/javascript">ComSheetObject('sheet1');</script>
</div>	
<!-- opus_design_grid(S) -->	
</div>	
</form>
					 