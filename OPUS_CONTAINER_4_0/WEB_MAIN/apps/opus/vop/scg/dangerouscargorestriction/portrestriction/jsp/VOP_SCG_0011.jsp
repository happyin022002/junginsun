<%
/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : VOP_SCG_0011.jsp
 *@FileTitle : Port & VSL OPR"s Restriction En-route
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/06/17
 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.scg.dangerouscargorestriction.portrestriction.event.VopScg0011Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopScg0011Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						////count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.DangerousCargoRestriction.CarrierRestriction");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopScg0011Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// add logic data extracting from server when loading initial screen
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
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<input type="hidden" name="eventFile" value="true">
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_New" id="btn_New">New</button>		
	</div>
	<div class="location">	
		<span id="navigation"></span>
	</div>
</div>

<div class="wrap_search">
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="80">
				<col width="*">
			</colgroup> 
			<tbody>
				<tr>
	                <th>UN No./Seq.</th>
	                <td colspan="5">
	                	<input type="text" style="width:60px;" id="imdg_un_no" name="imdg_un_no" fullfill class="input1" caption="UN No." required maxlength="4" style="ime-mode:disabled" value="" dataformat="num"><!-- 
	               	 --><input type="text" style="width:50px;" id="imdg_un_no_seq" name="imdg_un_no_seq" class="input1"  caption="UN No./Seq." maxlength="4" minlength="1" value="" dataformat="num" required><!-- 
	               	 --><button type="button" id="srch_imdg_un_no" onclick="img_click()" name="srch_imdg_un_no" class="input_seach_btn"></button><!-- 
	               	 --><input type="text" style="width:750px;" readonly class="input2" name="prp_shp_nm" value="">
	                </td>
	            </tr>
	            <tr>
	                <th>Class</th>
	                <td colspan="5"><input type="text" style="width:60px;" class="input2"  readonly name="imdg_clss_cd" value=""><!-- 
	                 --><input type="text" style="width:833px;" class="input2"  name="imdg_clss_cd_desc"  readonly value="">
	           		</td>
	            </tr>
	      	</tbody>
	    </table>
	    <table>
			<colgroup>
				<col width="80">
				<col width="160">
				<col width="60">
				<col width="160">
				<col width="100">
				<col width="*">
			</colgroup> 
	      	<tbody>	
	            <tr>
	                <th title="Port of Loading">POL</th>
	                <td>
	                	<input type="text" style="width:60px;" class="input1" value=""  required  dataformat="engup"  style="ime-mode:disabled" caption="POL"   maxlength=5 name="pol_port_cd"><!-- 
	                 --><button type="button" onclick="img_click()" id="srch_pol_port_cd" name="srch_pol_port_cd" class="input_seach_btn"><!-- 
	                 --></button><div style="display:none"><script type="text/javascript">ComComboObject("pol_port_rotn_seq", 1, 40, 1, 1, 0);</script></div>
	                </td>
	                <th title="Port of Discharging">POD</th>
	                <td>
	                	<input type="text" style="width:60px;" class="input1" value=""  required   dataformat="engup"  style="ime-mode:disabled" caption="POD"   maxlength=5  name="pod_port_cd"><!--
	                 --><button type="button" onclick="img_click()" id="srch_pod_port_cd" name="srch_pod_port_cd" class="input_seach_btn"></button><!-- 
	                 --><div style="display:none"><script type="text/javascript">ComComboObject("pod_port_rotn_seq", 1, 40, 1, 1, 0);</script></div>
	                </td>
	                <th>Target Lane</th>
	                <td><script type="text/javascript">ComComboObject("slan_cd", 2, 67, 2, 1,0);</script></td>
	            </tr>
			</tbody>
		</table>
	</div>
</div>

<div class="wrap_result">
	<div class="opus_design_grid">
		<h3 class="title_design grid_heading_clear mar_btm_8">Vessel Operator’s Restrictions on DG</h3>
		<script type="text/javascript">ComSheetObject("sheet1");</script>
	</div>
	
	<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
	
	<div class="grid_option_left">
		<table>
			<tr>
				<td>
					<button type="button" class="btn_etc" name="srch_irregulars_list" id="srch_irregulars_list">Irregulars List</button>
				</td>
			</tr>
		</table>
	</div>

	<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
	
	<div class="opus_design_grid">
		<h3 class="title_design mar_btm_8">Port Restrictions En-route</h3>
		<script type="text/javascript">ComSheetObject("sheet2");</script>
	</div>
	
	<div class="opus_design_grid" style="display:none">
		<script type="text/javascript">ComSheetObject("sheet3");</script>
	</div>
</div>
				
</form>