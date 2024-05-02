<%
/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : VOP_SCG_0078.jsp
 *@FileTitle : Time of SPCL CGO Request APVL
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
<%@ page import="com.clt.apps.opus.bcm.sup.valuemanage.util.ConstantMgr"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.event.VopScg0078Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopScg0078Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList    = "";
	String pageRows    = "100";

	String strUsr_id   = "";
	String strUsr_nm   = "";
	Logger log = Logger.getLogger("com.clt.apps.CargoLoadingApproval.OwnDangerousCargoApproval");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopScg0078Event)request.getAttribute("Event");
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
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="params" id="params" />
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" 		id="btn_Retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_new" 			id="btn_new">New</button><!-- 		
		 --><button type="button" class="btn_normal" name="btn_Detail" 			id="btn_Detail">Detail(Excel)</button>		
	</div>
	<!-- opus_design_btn(E) -->

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
		<tbody>
			<colgroup>
				<col width="56" />
				<col width="252" />
				<col width="100" />
				<col width="275" />
				<col width="125" />
				<col width="10" />
				<col width="*" />
			</colgroup>
			<tr>
				<th>RSO</th>
				<td><script type="text/javascript">ComComboObject('rgn_shp_opr_cd', 3, 74, 1, 1);</script></td>
				<th>Option 1</th>
				<td class="wrap_search_tab"><input type="radio" name="option_pending" id="option_pending" value="Y" class="trans" checked><label for = "option_pending">Incl. Pending</label><input type="radio" name="option_pending" id="option_pending" value="N" class="trans"><label for = "option_pending">Excl. Pending</label></td>
				<th>Option 2</th>
				<td class="wrap_search_tab"><input type="radio" name="option_post_vvd" id="option_post_vvd" value="I" class="trans"><label for = "option_pending">Incl. Post VVD</label><input type="radio" name="option_post_vvd" id="option_post_vvd" value="E" class="trans" checked><label for = "option_pending">Excl. Post VVD</label></td>
				<td></td>
			</tr>
		</tbody>
	</table>
	<table>
		<tbody>
			<colgroup>
				<col width="56" />
				<col width="250" />
				<col width="235" />
				<col width="165" />
				<col width="104" />
				<col width="*" />
			</colgroup>
			<tr>
				<th>Period</th>
				<td><input type="text" name="from_rqst_dt" style="width:80px" class="input1" value="<%=DateTime.addMonths(DateTime.getYear()+"0101",(((int)Math.ceil((float)DateTime.getMonth()/3)-1)*2+((int)Math.ceil((float)DateTime.getMonth()/3)-1)))%>" dataformat="ymd" maxlength="8">~ <input type="text" name="to_rqst_dt" style="width:80px" class="input1" value="<%=DateTime.getFormatDate(new java.util.Date(),"yyyyMMdd")%>" dataformat="ymd" maxlength="8"><button type="button" id="btn_Calendar" name="btn_Calendar" class="calendar ir"></button></td>
				<th>Processing Time Setting (hours)</th>
				<td><input type="text" name="proc_hour" style="width:40px;text-align:right;" class="input1" value="24" caption="Processing Time Setting (hours)" required dataformat="num" style="ime-mode:disabled"></td>
				<th>Term</th>
				<td><script type="text/javascript">ComComboObject('term', 1, 85, 0, 0, 0, false);</script></td>
			</tr>
		</tbody>
	</table>
	<table>
		<tbody>
			<colgroup>
				<col width="56" />
				<col width="230" />
				<col width="98" />
				<col width="10" />
				<col width="10" />
				<col width="191" />
				<col width="100" />
				<col width="*" />
			</colgroup>
			<tr>
				<th>VSL OPR</th>
				<td class="wrap_search_tab"><input type="radio" name="crr_cd" id="crr_cd" value="" class="trans" checked><label for = "crr_cd">All</label><!-- 
					 --><input type="radio" name="crr_cd" id="crr_cd" value="<%=ConstantMgr.getCompanyCode()%>" class="trans"><label for = "crr_cd">Own</label><!-- 
					 --><input type="radio" name="crr_cd" id="crr_cd" value="" class="trans"><label for = "crr_cd">Others</label><!-- 
					 --><input type="text" name="cgo_opr_cd" id="cgo_opr_cd" style="width:40px" class="input" value="" caption="VSL OPR" maxlength="4" dataformat="engup" style="ime-mode:disabled"><!-- 
					 --><button type="button" id="btn_Carrier" name="btn_Carrier" class="input_seach_btn" alt=""  align="absmiddle"></button></td>
				<th>Lane</th>
				<td><input type="text" name="slan_cd" style="width:45px" class="input" value="" fullfill caption="Lane" maxlength="3" dataformat="engup" style="ime-mode:disabled"><button type="button" id="btn_SlanCd" name="btn_SlanCd" class="input_seach_btn"></button></td>
				<th>VVD CD</th>
				<td><input type="text" name="vsl_cd" style="width:55px" class="input" value="" fullfill caption="VVD CD" maxlength="4" dataformat="engup" style="ime-mode:disabled"><input type="text" name="skd_voy_no" style="width:40px" class="input" value="" fullfill caption="VVD CD" maxlength="4" dataformat="num" style="ime-mode:disabled"><input type="text" name="skd_dir_cd" style="width:25px" class="input" value="" fullfill caption="VVD CD" maxlength="1" dataformat="engup" style="ime-mode:disabled"><button type="button" id="btn_VVDpop" name="btn_VVDpop" class="input_seach_btn"></button></td>
				<th>SPCL CGO Type</th>
				<td width=""><script type="text/javascript">ComComboObject('scg_flg', 1, 85, 1, 0, 0, true);</script></td>
			</tr>
		</tbody>
	</table>
</div>
<!-- opus_design_inquiry(E) -->
</div>
<!-- wrap_search(E) -->

<!-- wrap_result(S) -->
<div class="wrap_result">
<!-- opus_design_grid(S) -->
<div class="opus_design_grid">
<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_downExcel" 		id="btn_downExcel">Down Excel</button> 
	</div>
	<!-- opus_design_btn(E) -->
	<script type="text/javascript">ComSheetObject('sheet1');</script>
	<div style="display:none;"><script type="text/javascript">ComSheetObject("sheet2");</script></div>
</div>
<!-- opus_design_grid(E) -->
</div>
<!-- wrap_result(E) -->
				
</form>