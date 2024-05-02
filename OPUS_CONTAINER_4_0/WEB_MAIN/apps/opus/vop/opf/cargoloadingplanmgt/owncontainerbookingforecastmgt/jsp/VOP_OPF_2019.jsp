<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : vop_opf_2019.jsp
*@FileTitle  : CBF Summary Preview
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/15
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil" %>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.event.VopOpf2019Event"%>
<%@ page import="org.apache.log4j.Logger"%>
<%
	//Get Parameter by parent page ;
	String vsl_cd 		= "";
	String skd_voy_no 	= "";
	String skd_dir_cd 	= "";
	String yd_cd 		= "";
	String crr_cd 		= "";
	String yd_nm 		= "";
	String cbf_ind_flg 	= "";

	String vsl_slan_cd 	= "";
	String vsl_slan_nm 	= "";

	String bkg_shpr_ownr_flg = "";

	Logger log = Logger.getLogger("com.clt.apps.CargoLoadingPlanMgt.OwnContainerBookingForecastMgt");

	VopOpf2019Event event = null; 		//PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; 	//error from server
	String strErrMsg = ""; 				//error message
	int rowCount = 0; 					//count of DB resultSET list

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";

	try {
		SignOnUserAccount account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (VopOpf2019Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// adding logic to get data from server when first loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		vsl_cd      = request.getParameter("vsl_cd")== null?"":request.getParameter("vsl_cd");
		skd_voy_no  = request.getParameter("skd_voy_no")== null?"":request.getParameter("skd_voy_no");
		skd_dir_cd  = request.getParameter("skd_dir_cd")== null?"":request.getParameter("skd_dir_cd");
		yd_cd       = request.getParameter("yd_cd")== null?"":request.getParameter("yd_cd");
		crr_cd      = request.getParameter("crr_cd")== null?"":request.getParameter("crr_cd");
		yd_nm       = request.getParameter("yd_nm")== null?"":request.getParameter("yd_nm");
		cbf_ind_flg = request.getParameter("cbf_ind_flg")== null?"":request.getParameter("cbf_ind_flg");
		vsl_slan_cd = request.getParameter("vsl_slan_cd")== null?"":request.getParameter("vsl_slan_cd");
		vsl_slan_nm = request.getParameter("vsl_slan_nm")== null?"":request.getParameter("vsl_slan_nm");

		bkg_shpr_ownr_flg = request.getParameter("bkg_shpr_ownr_flg")== null?"":request.getParameter("bkg_shpr_ownr_flg");

	} catch (Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} 
		loadPage('<%=StringUtil.xssFilter(bkg_shpr_ownr_flg)%>');		
	}
</script>

<form name="form">

<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="uid" id="uid" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="vsl_slan_cd" value="<%=StringUtil.xssFilter(vsl_slan_cd)%>" id="vsl_slan_cd" />
<input type="hidden" name="vsl_slan_nm" value="<%=StringUtil.xssFilter(vsl_slan_nm)%>" id="vsl_slan_nm" />
<input type="hidden" name="crr_cd" value="<%=StringUtil.xssFilter(crr_cd)%>" id="crr_cd" />
<input type="hidden" name="bkg_shpr_ownr_flg" value="<%=StringUtil.xssFilter(bkg_shpr_ownr_flg)%>" id="bkg_shpr_ownr_flg" />
<input type="hidden" name="qty1" id="qty1" />
<input type="hidden" name="st_1" id="st_1" />
<input type="hidden" name="st_2" id="st_2" />
<input type="hidden" name="st_3" id="st_3" />
<input type="hidden" name="st_4" id="st_4" />
<input type="hidden" name="st_5" id="st_5" />
<input type="hidden" name="st_6" id="st_6" />
<input type="hidden" name="st_7" id="st_7" />
<input type="hidden" name="st_8" id="st_8" />
<input type="hidden" name="st_9" id="st_9" />
<input type="hidden" name="st_10" id="st_10" />
<input type="hidden" name="st_11" id="st_11" />
<input type="hidden" name="st_12" id="st_12" />
<input type="hidden" name="st_13" id="st_13" />
<input type="hidden" name="st_14" id="st_14" />
<input type="hidden" name="st_15" id="st_15" />
 
<div class="layer_popup_title">
<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	
		<!-- page_title(S) -->
		<h2 class="page_title"><span>CBF Summary Preview</span></h2>
		<!-- page_title(E) -->
		
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn1_WGC" 			id="btn1_WGC">Weight Group (Creation)</button><!-- 
			 --><button type="button" class="btn_normal" name="btn1_Close" 		id="btn1_Close">Close</button>		
		</div>
		<!-- opus_design_btn(E) -->	
		
	</div>
<!-- page_title_area(E) --> 
</div>


<div class="layer_popup_contents">
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="60">
					<col width="150">
					<col width="100">
					<col width="600">
					<col width="50">
					<col width="60">
					<col width="*">				
				</colgroup> 
				<tbody>
					<tr>
						<th>VVD CD</th>
						<td><input type="text" style="width:55px;text-align:center;" class="input2" value="<%=StringUtil.xssFilter(vsl_cd)%>" name="vsl_cd" readonly id="vsl_cd" /><input type="text" style="width: 40px;text-align:center;" class="input2" value="<%=StringUtil.xssFilter(skd_voy_no)%>" name="skd_voy_no" readonly id="skd_voy_no" /><input type="text" style="width: 20px;text-align:center;" class="input2" value="<%=StringUtil.xssFilter(skd_dir_cd)%>" name="skd_dir_cd" readonly id="skd_dir_cd" /></td>
						<th title="Port of Loading">POL</th>
						<td><input type="text" style="width:80px;text-align:center;" class="input2" value="<%=StringUtil.xssFilter(yd_cd.substring(0, yd_cd.length()-1))%>" name="yd_cd2" readonly id="yd_cd2" /><input type="hidden" name="yd_cd" value="<%=StringUtil.xssFilter(yd_cd)%>" id="yd_cd" /><input type="text" style="width: 300px;" class="input2" value=" <%=StringUtil.xssFilter(yd_nm)%>" name="yd_nm" readonly id="yd_nm" /></td>
						<th class= "sm"></th>
						<td class = "sm">
						<div id="cbfIndLayer" style="display:">
							<table border="0" style="width:163;">
								<tr class="h23">
									<td width="33">CBF</td>
									<td width="" class="stm">
									<input type="radio" value="P" name="cbf_ind_flg" id = "cbf_ind_flg" class="trans" <% if("P".equals(cbf_ind_flg)) { %>checked<% } %> readOnly disabled>
									<label for ="cbf_ind_flg"><span class="dash"><strong>Pre</strong></span></label>
									<input type="radio" value="F" name="cbf_ind_flg" id ="cbf_ind_flg1" class="trans" <% if("F".equals(cbf_ind_flg)) { %>checked<% } %> readOnly disabled>
									<label for="cbf_ind_flg1"><span class = "dash"><strong>Final</strong></span></label>
									</td>
								</tr>
							</table>
						</div>
						</td>
						<td></td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>
	
	<div class="wrap_result">
	
		<!-- opus_tab_btn(S) -->
		<div class="opus_design_tab">
			<script type="text/javascript">ComTabObject('tab1')</script>
		</div>
		<!-- opus_tab_btn(E) -->
		
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid clear" name="tabLayer" id="tabLayer">		
			<script type="text/javascript">ComSheetObject('t1sheet1');</script>		
		</div>
		<!-- opus_design_grid(E) -->
		
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid clear" name="tabLayer" id="tabLayer">
			<table>
				<colgroup>				
					<col width="*" />				
				</colgroup> 
				<tbody>
					<tr>
						<td><h3 class="title_design">Special Cargo</h3></td>
					</tr>
				</tbody>
			</table>		
			<script type="text/javascript">ComSheetObject('t2sheet1');</script>
			<table>
				<colgroup>				
					<col width="*" />				
				</colgroup> 
				<tbody>
					<tr>
						<td><h3 class="title_design">Stowage Request</h3></td>
					</tr>
				</tbody>
			</table>		
			<script type="text/javascript">ComSheetObject('t2sheet2');</script>
		</div>
		<!-- opus_design_grid(E) -->	
	</div> 	
</div> 
</form>