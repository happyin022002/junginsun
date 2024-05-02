<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_VSK_5001.jsp
*@FileTitle  : Consortium Voyage Update
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/25
=========================================================*/
%>
   
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.vsk.scheduleutilitymanagement.consortiumvoyagemgt.event.VopVsk5001Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopVsk5001Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg   = "";					//error message
	int rowCount	   = 0;						//count of DB ResultSet list

	String successFlag = "";
	String codeList    = "";
	String pageRows    = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.VSKCommon.VSKCodeFinder");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopVsk5001Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

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
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" id="btn_retrieve" name="btn_retrieve" type="button">Retrieve</button>
		<button class="btn_normal" id="btn_new"      name="btn_new"      type="button">New   </button>
		<button class="btn_normal" id="btn_save"     name="btn_save"     type="button">Save  </button>
	</div>
	<!-- opus_design_btn (E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->
<!-- wrap_search(S) -->
<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="80" />
				<col width="80" />
				<col width="80" />
				<col width="80" />
				<col width="80" />
				<col width="80" />
				<col width="80" />
				<col width="*"  />
		   </colgroup>
		   <tbody>
		   		<tr>
					<th>Lane Code</th>
					<td><input  type="text"   id="vsl_slan_cd" name="vsl_slan_cd" class="input1" style="width:45px;text-align:center;ime-mode:disabled;" dataformat="engup" value="" maxlength="3" onfocus="this.select();"  /><!-- 
					 --><button type="button" id="btn_slan_cd" name="btn_slan_cd" class="input_seach_btn"></button>
					</td>
					<th title="Vessel Voyage Direction">VVD</th>
					<td><input type="text"    id="vsl_cd"      name="vsl_cd"     class="input1" style="width:45px;text-align:center;ime-mode:disabled;" dataformat="engup"  value="" maxlength="4" onfocus="this.select();"  /><!-- 
					 --><input type="text"    id="skd_voy_no"  name="skd_voy_no" class="input1" style="width:45px;text-align:center;ime-mode:disabled;" dataformat="num"    value="" maxlength="4" onfocus="this.select();"  /><!-- 
					  --><input type="text"    id="skd_dir_cd"  name="skd_dir_cd" class="input1" style="width:20px;text-align:center;ime-mode:disabled;" dataformat="engup"  value="" maxlength="1" onfocus="this.select();"  /><!--
					  --><button type="button" id="btn_vvd"     name="btn_vvd"    class="input_seach_btn"></button>
					</td>
					<th>ETB</th>
				    <td><input type="text"    id="fm_dt"       name="fm_dt"      class="input1" style="width:100px;text-align:center;"  value="" dataformat="ymd" maxlength="8" size="10">  
					    <span class="dash">~</span> 
					    <input  type="text"   id="to_dt"       name="to_dt"      style="width:100px;text-align:center;" class="input1" value="" dataformat="ymd" maxlength="8" size="10">
					    <button type="button" id="btn_etb"     name="btn_etb"    class="calendar" ></button>
					</td>
					
					<th>&nbsp;&nbsp;&nbsp;&nbsp;Update status&nbsp;&nbsp;</th>
					<td>
						<!--  <script type="text/javascript">ComComboObject('cv_cbm1',1,100,0,1);</script>-->
						<script type="text/javascript">ComComboObject('cv_cbm2',1,120,0,1);</script>
						<input type="checkbox" name="chk_virtual_port"  class="trans"  id="chk_virtual_port"/>&nbsp;&nbsp;<b>incl. Virtual Port</b>
					</td>
				</tr>
		   </tbody>
		</table>
	</div>
	
	<!-- opus_design_inquiry(E) -->
</div>

<!-- wrap_search(E) -->
<!-- wrap_result(S) -->

<div class="wrap_result">
<table><tr><td class="pad_btm_4" style="width:70px"><div style="width:70px;background-color: #FFFF99;text-align: center;padding: 5px">Updated</div> </td>
<td style="color:blue;text-align: left"><b>&nbsp;&nbsp;* Port Code in red means 'Virtual Add Call Port'.</b></td>
</tr>

</table>
<!-- opus_design_grid(S) -->


	<div class="opus_design_grid">	
		<script type="text/javascript">ComSheetObject('sheet1');</script>		
	</div>
	<!-- opus_design_grid(E) -->
	
	<th>
		<input type="checkbox" name="chk_voyage" id="chk_voyage" value="" class="trans" >&nbsp;<b>Voyage</b>&nbsp;
	</th>
	<th>
	<input type="text" id= "voyage" name="voyage" style="width:105px;text-align:center;ime-mode:disabled;" class="input" value="" dataformat="engupetc" maxlength="10" onfocus="this.select();" >
	</th>
	<td>
		<button class="btn_normal" id="btn_apply" name="btn_apply" type="button">Apply</button>
	</td>
	<th>
	<input type="text" name="" style="width:400px;text-align:center;ime-mode:disabled;border:0px;color:blue;font-weight:bold;background-color: #FFFFFF" class="input" value="Turning Indicator : Y - Turing Port, N - Normal Port, V - Virtual Port" readonly>
	</th>
</div>
<!-- wrap_result(E) -->
</form>