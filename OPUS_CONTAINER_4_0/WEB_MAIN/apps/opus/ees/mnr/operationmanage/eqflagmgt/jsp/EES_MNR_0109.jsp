<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0109.jsp
*@FileTitle : Hanger Rack/Bar Installation/Uninstallation
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.event.EesMnr0109Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	EesMnr0109Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//count of DB resultSet list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd        = "";
	String rhqOfcCd         = "";
	Logger log = Logger.getLogger("com.clt.apps.test.test");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		rhqOfcCd  = account.getRhq_ofc_cd();

		event = (EesMnr0109Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		//adding logic to get data from sever when first loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script type="text/javascript">
	var currOfcCd = '<%=strOfc_cd %>';
	var rhqOfcCd  = '<%=rhqOfcCd %>';

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
<script type="text/javascript">ComSheetObject('sheet2');</script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="key_value" id="key_value" />
<input type="hidden" name="usr" value="<%=strUsr_id %>" id="usr" />
<input type="hidden" name="mnr_flg_tp_cd" id="mnr_flg_tp_cd" />
<input type="hidden" name="excel_load_flg" id="excel_load_flg" />
<input type="hidden" name="str_ofc_cd" value="<%=strOfc_cd %>" id="str_ofc_cd" />
<input type="hidden" name="hid_rulabel_type" id="hid_rulabel_type" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_retrieve" id="btn_retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_new" id="btn_new" type="button">New</button><!--
		--><button class="btn_normal" name="btn_save" id="btn_save" type="button">Save</button>
	</div>
	<!-- opus_design_btn (E) -->

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
			<tbody>
				<colgroup>
					<col width="1">
					<col width="175">
					<col width="140">
					<col width="180">
					<col width="130">
					<col width="110">
					<col width="50">
					<col width="*">
				</colgroup>
				<tr>
					<th>Location By</th>
		            <td><script type="text/javascript">ComComboObject('p_loc_tp',1, 60 , 1,0);</script><!--  
		            	--><input type="text" name="p_loc_cd" id="p_loc_cd" caption="Location" style="width:70px;ime-mode:disabled;" value="" class="input2"  dataformat="engup" maxlength="5" readonly/><!--  
		            	--><button type="button" class="input_seach_btn" name="btns_search" id="btns_search"></button>
		            </td>
					<th>EQ No.</th>
					<td align="left"><input type="text" name="eq_list" id="eq_list" style="width:130px;" class="input" dataformat="engup"><!--  
						--><button type="button" class="multiple_inq ir" id="eq_no_multi" name="eq_no_multi"></button>
					</td>
					<th>EQ Type</th>
					<td><script type="text/javascript">ComComboObject('eq_knd_cd',1, 100 , 1,0)</script></td>
					<th>TP/SZ</th>
					<td><script type="text/javascript">ComComboObject('eq_tpsz_cd', 2, 100 ,0)</script></td>
					<th>RU Label</th>
					<td><input type="text"  name="rstr_usg_lbl" id="rstr_usg_lbl"   style="ime-mode:inactive;background-color:#ffffff"  style="width:150px;" class="input" value=""> <button type="button" id="btn_rulabel_cd" name="btn_rulabel_cd" class="input_seach_btn"></button></td>
					
				</tr>
				<tr>
					<th>Tariff Type</th>
					<td><script type="text/javascript">ComComboObject('mnr_hngr_trf_cd',1, 156 , 1,0);</script></td>
					<th>Hanger Rack Type</th>
					<td><script type="text/javascript">ComComboObject('mnr_hngr_rck_cd',1, 157 , 1,0)</script></td>
					<th>Hanger Bar Type</th>
					<td><script type="text/javascript">ComComboObject('mnr_hngr_bar_tp_cd',1, 100 , 1,0)</script></td>
					<th>Bound</th>
					<td><script type="text/javascript">ComComboObject('bound_tp_cd',1, 100 , 1,0)</script>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
<div class="wrap_result">
	<h3 class="title_design">Hanger Rack/Bar Installation/Removal Update</h3>
	<div class="opus_design_grid" id="mainTable">
		<div class="opus_design_btn" style="margin-top:-25px">
			<button class="btn_accent" name="btn_more" id="btn_more" type="button">more</button>
			<button class="btn_normal" name="btn_loadexcel" id="btn_loadexcel" type="button">Load Excel</button>
			<button class="btn_normal" name="btn_downexcel" id="btn_downexcel" type="button">Down Excel</button>
		</div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
		
	</div>
	
	<!-- opus_design_grid(E) -->
</div>

</form>
