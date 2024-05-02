<%
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MST_0047.jsp
*@FileTitle  : Reefer Unit Info Inquiry and Update 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/04
=========================================================
*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.event.EesMst0047Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMst0047Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.EquipmentManagement.ContainerOnOffHire");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (EesMst0047Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		// adding logic to get data from server when first loading ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	} catch(Exception e) {
		out.println(e.toString());
	}
	
	// change to table name
	String ruLableTp   = JSPUtil.getCodeCombo("ru_lable_type", "01", "style='width:120'", "CD20097", 0, "000020:ALL:ALL");
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
<input type="hidden" name="hidden_curdate" id="hidden_curdate" />
<input type="hidden" name="cntr_nos" id="cntr_nos" />
<input type="hidden" name="eq_knd_cd" value="U" id="eq_knd_cd" />
<input type="hidden" name="hid_rulabel_type" id="hid_rulabel_type" />
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button>
	</div>
	<!-- opus_design_btn(E) -->
	<div class="location"><span id="navigation"></span></div>
</div>
<!-- page_title_area(E) -->

<div class= "wrap_search">
<!-- opus_design_inquiry(S) -->
<div class="opus_design_inquiry wFit">
	<table>
		<tbody>
			<colgroup>
				<col width="80"/>
				<col width="400" />
				<col width="80" />
				<col width="227" />
				<col width="70" />
				<col width="180" />
				<col width="70" />
				<col width="*" />
			</colgroup>
			<tr>
				<th>Lessor</th>
				<td>&nbsp;<input type="text" name="vndr_seq" id="vndr_seq" maxlength="6" style="width: 50px; text-align:center; ime-mode:disabled"  class="input1" dataformat="num"><button type="button" class="input_seach_btn" name="btns_vndr" id="btns_vndr" ></button><input type="text" name="vndr_abbr_nm" id="vndr_abbr_nm" readonly style="width: 50px; ime-mode:disabled" class="input2" value=""><input type="text" name="vndr_lgl_eng_nm" id="vndr_lgl_eng_nm" readonly style="width: 200px; ime-mode:disabled" class="input2" value=""></td>
				<th>Lease Term</th>
				<td>&nbsp;<script type="text/javascript" >ComComboObject('combo1', 1, 100, 1 );</script><input type="hidden" name="lstm_cd" id="lstm_cd" value="" ></td>
				<th>AGMT No.</th>
				<td>&nbsp;<input type="text" style="width: 35px" class="input" dataformat="engup" name="agmt_cty_cd" id="agmt_cty_cd" maxlength="3" value="HHO"><input type="text" style="width: 85px" class="input" dataformat="engup" name="agmt_seq" id="agmt_seq" style="ime-mode:disabled; text-align:center;" maxlength="6"><button type="button" class="input_seach_btn" name="ComOpenPopupWithTargetAgmtNo" id="ComOpenPopupWithTargetAgmtNo"></button></td>
				<th>Maker Info</th>
				<td class="sm pad_left_8"><input type="radio" name="mi_flg" id="mi_flg" value="" class="trans" checked><label>All</label><input type="radio" name="mi_flg" id="mi_flg" value="Y" class="trans"> Exists<label></label><input type="radio" name="mi_flg" id="mi_flg" value="N" class="trans" >Not Exists</td>
			</tr>
			<tr>
				<th>RU Label</th>
				<td><input type="text"  name="rstr_usg_lbl" id="rstr_usg_lbl"   style="ime-mode:inactive;background-color:#ffffff"  style="width:150px;" class="input" value=""> <button type="button" id="btn_rulabel_cd" name="btn_rulabel_cd" class="input_seach_btn"></button></td>
				<td style="display:none">
				&nbsp;<%=ruLableTp%> 
				<script language="javascript" >ComComboObject('rstr_usg_lbl1', 1, 140, 1 );</script>
				</td>				
				<th>TP/SZ</th>
				<td>&nbsp;<script type="text/javascript" >ComComboObject('combo2', 1, 147, 1 );</script><input type="hidden" name="cntr_tpsz_cd" id="cntr_tpsz_cd" value=""></td>
				<th>Status</th>
				<td class="sm pad_left_8"><input type="radio" name="sts_flg" id="sts_flg" value="" class="trans" checked><label>All</label><input type="radio" name="sts_flg" id="sts_flg" value="A" class="trans" ><label>Active</label><input type="radio" name="sts_flg" id="sts_flg" value="I" class="trans"><label>InActive</label></td>
			</tr>
		</tbody>
	</table>
</div>
</div>
<!-- opus_design_inquiry(E) -->	

<div class="wrap_result">
<!-- opus_design_grid(S) -->
<div class="opus_design_grid">
    <div class="opus_design_btn">
		<button type="button" class="btn_normal" name="btn_loadexcel" id="btn_loadexcel">Load Excel</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button>
	</div>
	<script type="text/javascript">ComSheetObject('sheet1');</script>
</div>
</div>
<!-- opus_design_grid(E) -->
</form>
