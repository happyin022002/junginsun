<%@page import="com.clt.framework.component.util.StringUtil"%>
<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : vop_vsk_0249.jsp
*@FileTitle : VSL SKD Delete Information (Pop-Up)
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
<%@ page import="com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event.VopVsk0249Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopVsk0249Event event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB ResultSet list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.scheduleplanningoperation.vesselschedulemgt");
	
	StringBuilder xml = null;
	
	String vslSlanCd[] = null;
	String bkgVvd[] = null;
	//String nonBkgVvd[] = null;
	String hisflag[] = null;
	String turnVoy[] = null;
	String turnDir[] = null;
	
	String tmpVslSlanCd = null;
	
	String tp = null;
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopVsk0249Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		vslSlanCd = request.getParameterValues("lane_vvd");
		//nonBkgVvd = request.getParameterValues("vvd");
		bkgVvd = request.getParameterValues("bkg_vvd");
		hisflag = request.getParameterValues("his_vvd");
		
		turnVoy = request.getParameterValues("turn_voy");
		turnDir = request.getParameterValues("turn_dir");
		
		tmpVslSlanCd = request.getParameter("tmp_vsl_slan_cd");
		tmpVslSlanCd = tmpVslSlanCd==null?"":tmpVslSlanCd.trim();
		
		tp = request.getParameter("tp");
		tp = tp==null?"":tp;
		
		xml = new StringBuilder("<SHEET><DATA>");
		for(int i=0; bkgVvd!=null && i<bkgVvd.length; i++){
			xml.append("<TR><TD><![CDATA[]]></TD><TD><![CDATA[]]></TD><TD><![CDATA[]]></TD>");
			xml.append("<TD><![CDATA[").append(vslSlanCd[i]).append("]]></TD>");
			xml.append("<TD><![CDATA[").append(bkgVvd[i]).append("]]></TD>");
			xml.append("<TD><![CDATA[").append(hisflag[i]).append("]]></TD>");
			xml.append("<TD><![CDATA[").append(turnVoy[i]).append("]]></TD>");
			xml.append("<TD><![CDATA[").append(turnDir[i]).append("]]></TD>");
			xml.append("</TR>");
		}
		xml.append("</DATA></SHEET>");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Delay check (Pop-Up)</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="xml" value="<%=xml.toString()%>">
<input type="hidden" name="vskd_tp_cd" value="M">
<input type="hidden" name="diff_rmk">
<input type="hidden" name="tp" value="<%=StringUtil.xssFilter(tp)%>">

<input type="hidden" name="aft_vsl_slan_cd" value="">
<input type="hidden" name="aft_vsl_cd" value="">
<input type="hidden" name="aft_skd_voy_no" value="">
<input type="hidden" name="aft_skd_dir_cd" value="">
<input type="hidden" name="aft_vps_port_cd" value="">
<input type="hidden" name="aft_clpt_ind_seq" value="">
<input type="hidden" name="aft_yd_cd" value="">
<input type="hidden" name="aft_vps_eta_dt" value="">
<input type="hidden" name="aft_vps_etb_dt" value="">
<input type="hidden" name="aft_vps_etd_dt" value="">


<%
	//for(int i=0; nonBkgVvd!=null && i<nonBkgVvd.length; i++){
		//out.print("<input type='hidden' name='non_bkg_vvd' value='" + nonBkgVvd[i] + "'>");
	//}
%>

<div class="layer_popup_title">	
	<div class="page_title_area clear">
		<h2 class="page_title"><span>VSL SKD Delete information </span></h2>
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_ok"	id="btn_ok">OK</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_close"	id="btn_close">Close</button>
			
	    </div>
	</div>
</div>

<div class="layer_popup_contents">
	<div class="layout_wrap wrap_result">
   		<div class="layout_vertical_2 pad_rgt_8">
   		<h3 class="title_design"> Voyage No. List</h3>
			<div class="opus_design_grid">
				
				<script type="text/javascript">ComSheetObject('sheet1');</script>
			</div>		
   		</div>
   		<div class="layout_vertical_2 pad_rgt_8">
   		     <div class="opus_design_inquiry">
   		<h3 class="title_design">Remark</h3>
   				<table class="grid_2" border="0">
					
					<tr>
						<td colspan="5">
							<select id="vskd_cng_tp_cd" name="vskd_cng_tp_cd" style="width:100%;">
								<option value="V" selected>Change Lane </option>
								<option value="V">Change VSK Position and Sequence</option>
								<option value="V">Phase Out</option>
								<option value="V">Voyage Cancellation</option>
								<option value="V">Others</option>
								</select>
						</td>
					</tr>
					<tr>
						<td colspan="5">
							<input type="text" id="rmk" name="rmk" tabindex="1" style="width:100%;ime-mode:disabled;" class="noinput" value="">
						</td>
					</tr> 
					</table>
					<table class="grid_2">
						<h3 class="title_design">Change information</h3>
					
					<tr>
						<th>
							Lane
						</th>
						<td colspan="3">  
							<input type="text" id="tmp_vsl_slan_cd" name="tmp_vsl_slan_cd" maxlength="3" tabindex="2" style="width:100%;ime-mode:disabled;" dataformat="engup" class="noinput" value="<%=StringUtil.xssFilter(tmpVslSlanCd)%>">
						</td>
						<td>
							<button type="button" name="btns_lane_search" id="btns_lane_search" class="input_seach_btn"></button>
						</td>
					</tr>
					<tr>
						<th width="50">
							VVD
						</th>
						<td width="60">
							<input type="text" id="tmp_vsl_cd" name="tmp_vsl_cd" maxlength="4" tabindex="3" dataformat="engup" style="width:100%;ime-mode:disabled;" class="noinput" value="">
						</td>
						<td width="60">
							<input type="text" id="tmp_skd_voy_no" name="tmp_skd_voy_no" maxlength="4" tabindex="4" dataformat="engup" style="width:100%;ime-mode:disabled;" class="noinput" value="">
						</td>
						<td width="">
							<input type="text" id="tmp_skd_dir_cd" name="tmp_skd_dir_cd" maxlength="1" tabindex="5" dataformat="engup" style="width:100%;ime-mode:disabled;" class="noinput" value="">
						</td>
						<td width="20">
							<button type="button" name="btns_vvd_search" id="btns_vvd_search" class="input_seach_btn"></button>
						</td>
					</tr>
					<tr>
						<th width="">Port</th>
							<td width="" colspan="3">
								<input type="text" id="tmp_vps_port_cd" name="tmp_vps_port_cd" maxlength="5" dataformat="engup" tabindex="6" style="width:100%;ime-mode:disabled;" class="noinput" value="">
							</td>
							<td width="">
								<button type="button" name="btns_port_search" id="btns_port_search" class="input_seach_btn"></button>
							</td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</div>

</form>			
