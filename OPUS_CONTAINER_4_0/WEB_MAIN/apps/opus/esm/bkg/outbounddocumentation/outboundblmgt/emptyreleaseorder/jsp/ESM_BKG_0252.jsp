<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0252.jsp
*@FileTitle  : Empty Container Release Order
*@author     : CLT 
*@version    : 1.0 
*@since      : 2014/06/25
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.event.EsmBkg0252Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	EsmBkg0252Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	String strCnt_cd		= "";
	Logger log = Logger.getLogger("com.clt.apps.OutboundBLMgt.EmptyReleaseOrder");
	
	StringBuffer fileDir = new StringBuffer();
	String home = System.getProperty("user.home");
	if (home !=null) fileDir.append(home);
	String separator = System.getProperty("file.separator");
	if (separator !=null) fileDir.append(separator);	

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		strCnt_cd = account.getCnt_cd();

		event = (EsmBkg0252Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// getting data from server when load the initial screen
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
<input type="hidden" name="cnt_cd" value="<%=strCnt_cd%>" id="cnt_cd" />
<input type="hidden" name="usr_id" value="<%=strUsr_id%>" id="usr_id" />
<input type="hidden" name="strOfc_cd" value="<%=strOfc_cd%>" id="strOfc_cd" />
<input type="hidden" name="strCnt_cd" value="<%=strCnt_cd%>" id="strCnt_cd" />
<input type="hidden" name="inter_rmk" id="inter_rmk" />
<input type="hidden" name="com_mrdPath" id="com_mrdPath" />
<input type="hidden" name="com_mrdArguments" id="com_mrdArguments" />
<input type="hidden" name="com_mrdSaveDialogDir" value="<%=fileDir.toString()%>" id="com_mrdSaveDialogDir" />
<input type="hidden" name="com_mrdSaveDialogFileName" id="com_mrdSaveDialogFileName" />
<input type="hidden" name="com_mrdSaveDialogFileExt" value="pdf" id="com_mrdSaveDialogFileExt" />
<input type="hidden" name="com_mrdSaveDialogFileExtLimit" value="xls@pdf@bmp@tif" id="com_mrdSaveDialogFileExtLimit" />
<input type="hidden" name="com_mrdTitle" value="Empty Container Release Order" id="com_mrdTitle" />
<input type="hidden" name="com_mrdDisableToolbar" value="2;3;12;14" id="com_mrdDisableToolbar" />
<input type="hidden" name="com_mrdBodyTitle" value="<span style='color:red'>Empty Container Release Order</span>" id="com_mrdBodyTitle" />
<input type="hidden" name="com_zoomIn" id="com_zoomIn" />
<input type="hidden" name="com_isBatch" value="N" id="com_isBatch" />
<input type="hidden" name="edt_ntc_knd_cd" id="edt_ntc_knd_cd" />
<input type="hidden" name="edt_bkg_no_list" id="edt_bkg_no_list" />
<input type="hidden" name="edt_to_eml" id="edt_to_eml" />
<input type="hidden" name="edt_cc_eml" id="edt_cc_eml" />
<input type="hidden" name="edt_from_eml" id="edt_from_eml" />
<input type="hidden" name="edt_subject" id="edt_subject" />
<input type="hidden" name="edt_contents" id="edt_contents" />
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!--  
	--><button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--  
	--><button type="button" class="btn_normal" name="btn_New"  	id="btn_New">New</button><!--  
	--><button type="button" class="btn_normal" name="btn_LdfDownExcel" id="btn_LdfDownExcel">BKG LDF-Excel</button><!--  
	--><button type="button" class="btn_normal" name="btn_LdfDownCsv" 	id="btn_LdfDownCsv">BKG LDF-CSV</button><!--  
	--><button type="button" class="btn_normal" name="btn_DownExcel" 	id="btn_DownExcel">Down Excel</button><!--  
	--></div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>

<div class="wrap_search bg">
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="60">
				<col width="80">
				<col width="275">
				<col width="120">
				<col width="80">
				<col width="80">
				<col width="80">
				<col width="80">
				<col width="80">
				<col width="80">
				<col width="*">
			</colgroup>
			<tr>
				<th class="sm"><input type="radio" name="datetype" value="BKG" class="trans" checked id="datetype" />&nbsp;BKG</th>
				<th class="sm"><input type="radio" name="datetype" value="PUP" class="trans" id="datetype" />&nbsp;P/UP Date</th>
				<td class="sm"><input type="text" style="width:110px;" class="input1" name="from_dt" dataformat="ymdhm" cofield="end_dt" value="<%=JSPUtil.getKST("yyyy-MM-dd")%> 00:00" id="from_dt" /> ~ <!--  
				--><input type="text" style="width:110px;" class="input1" name="end_dt" dataformat="ymdhm" cofield="from_dt" value="<%=JSPUtil.getKST("yyyy-MM-dd")%> 23:59" id="end_dt" /><!--  
				--><button type="button" id="btns_calendar" name="btns_calendar" class="calendar ir"></button></td>
				<th>BKG Office</th>
				<td><input type="text" style="width:60px;text-align:center;" class="input" name="bkg_ofc_cd" maxlength="6" dataformat="engup" value="<%=strOfc_cd%>" id="bkg_ofc_cd" /> </td>
				<th>BKG Staff</th>
				<td><input type="text" style="width:80px;text-align:center;" class="input" name="doc_usr_id" value="" id="doc_usr_id" /> </td>
				<th>EQ Control</th>
				<td><input type="text" style="width:80px;" class="input" name="eq_ctrl_ofc_cd" maxlength="5" dataformat="enguponly" value="" id="eq_ctrl_ofc_cd" /> </td>
				<th>EQ Confirm</th>
				<td><select style="width:50px;" name="eq_confirm">
				<option value="" >All</option>
				<option value="Y" >Y</option>
				<option value="N" >N</option></select>
				</td>						 
			</tr>
		</table>
		<table>
			<colgroup>
				<col width="30">
				<col width="80">
				<col width="75">
				<col width="80">
				<col width="70">
				<col width="90">
				<col width="105">
				<col width="80">
				<col width="80">
				<col width="80">
				<col width="80">
				<col width="80">
				<col width="80">
				<col width="*">
			</colgroup>
			<tr>
				<th title="Vessel Voyage Direction">VVD</th>
				<td><input type="text" name="vvd" style="width:80px;" class="input1" value="" dataformat="engup" caption="VVD" maxlength="9" fullfill="" id="vvd" /> </td>
				<th title="Place of Receipt">POR</th>
				<td><input type="text" name="por_cd" style="width:60px;" class="input" value="" dataformat="engup" caption="POR" maxlength="5" fullfill="" id="por_cd" /> </td>
				<th title="Port of Loading">POL</th>
				<td><input type="text" name="pol_cd" style="width:70px;" class="input" value="" dataformat="engup" caption="POL" maxlength="5" fullfill="" id="pol_cd" /> </td>
				<th title="Port of Discharging">POD</th>
				<td><input type="text" name="pod_cd" style="width:60px;" class="input" value="" dataformat="engup" caption="POD" maxlength="5" fullfill="" id="pod_cd" /> </td>
				<th>P/UP CY</th>
				<td><input type="text" name="mty_pkup_yd_cd" style="width:80px;" class="input" value="" caption="P/UP CY" maxlength="7" fullfill="" id="mty_pkup_yd_cd" /> </td>
				<th>RTN CY</th>
				<td><input type="text" name="full_rtn_yd_cd" style="width:80px;" class="input" value="" caption="RTN CY" maxlength="7" fullfill="" id="full_rtn_yd_cd" /> </td>
				<th>BKG No.</th>
				<td><input type="text" name="bkg_no" style="width:100px;" class="input1" value="" caption="BKG No." maxlength="13" minlength="11" id="bkg_no" /> </td>
			</tr>
		</table>
		<table>
			<colgroup>
				<col width="40">
				<col width="60">
				<col width="58">
				<col width="95">
				<col width="90">
				<col width="80">
				<col width="114">
				<col width="210">
				<col width="190">
				<col width="*">
			</colgroup>
			<tr>
				<th class="sm">Type</th>
				<td class="sm"><input type="radio" name="ser_type" value="simple" class="trans" onclick="javascript:chkSerType(this)" id="ser_type" />&nbsp;Simple</td>
				<td class="sm"><input type="radio" name="ser_type" value="detail" class="trans" checked onclick="javascript:chkSerType(this)" id="ser_type" />&nbsp;Detail</td>
				<td class="sm"><input type="radio" name="ser_type" value="usa" class="trans" onclick="javascript:chkSerType(this)" id="ser_type" />&nbsp;Detail(USA)</td>
				<th>Inland/Port(s)</th>
				<td><select style="width:70px;" name="pi_type" class="input">
				<option value="" >All</option>
				<option value="I" >Inland</option>
				<option value="P" >Port(s)</option>
				</select></td>		
				<th>Loading Date</th>
				<td><input type="text" style="width:80px;" class="input" name="from_dt2" dataformat="ymd" id="from_dt2" /><!--  
				--><input type="text" style="width:88px;" class="input" name="end_dt2" dataformat="ymd"  id="end_dt2" /><!--  
				--><button type="button" id="btns_calendar2" name="btns_calendar2" class="calendar ir"></button></td>
				<th>Empty P/UP ≠ Full Return CY</th>
				<td><input type="checkbox" name="empty_full_chk" value="Y" class="trans" id="empty_full_chk" /> </td>
			</tr>
		</table>
	</div>
</div>
<div class="wrap_result">
	<div class="opus_design_grid" id="mainTable">
		<div class="opus_design_btn"><!--  
		--><button type="button" class="btn_accent" name="btn_LdfLog" id="btn_LdfLog">LDF Log</button><!--  
		--><button type="button" class="btn_accent" name="btn_CheckAll" id="btn_CheckAll">Check All</button><!--  
		--><button type="button" class="btn_normal" name="btn_UncheckAll"  	id="btn_UncheckAll">Uncheck All</button><!--  
		--><button type="button" class="btn_normal" name="btn_Print" 	id="btn_Print">Print</button><!--  
		--><button type="button" class="btn_accent" name="btn_Preview" id="btn_Preview">Preview</button><!--  
		--><button type="button" class="btn_normal" name="btn_EditFAXEmail" id="btn_EditFAXEmail">Edit Fax/E-mail</button><!--  
		--><button type="button" class="btn_normal" name="btn_Remark" 	id="btn_Remark">Remark(s)</button><!--  
		--><button type="button" class="btn_accent" name="btn_FAX" id="btn_FAX">Fax</button><!--  
		--><button type="button" class="btn_normal" name="btn_EMail"  	id="btn_EMail">E-mail</button><!--  
		--><button type="button" class="btn_normal" name="btn_EDI" 	id="btn_EDI">EDI</button><!--  
		--></div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<div class="opus_design_data">
		<table> 
			<tr><td>If you want to receive email copy, please go to “Setup -> Client Default” and select “Receiving mail copy option”</td></tr>
		</table>
	</div>	
	<div class="opus_design_grid" style="display: none;">
		<script type="text/javascript">ComSheetObject('sheet2');</script>
		<script type="text/javascript">ComSheetObject('sheet3');</script>
		<script type="text/javascript">ComSheetObject('sheet4');</script>
		<script type="text/javascript">ComSheetObject('sheet5');</script>
		<script type="text/javascript">ComSheetObject('sheet6');</script>
		<script type="text/javascript">ComSheetObject('sheet7');</script>
		<script type="text/javascript">ComSheetObject('sheet8');</script>
	</div>
	
</div>
</form>
<form name="form3" method="post">
    <input type="hidden" name="pop_mode" id="pop_mode" />
    <input type="hidden" name="display" id="display" />
    <input type="hidden" name="func" id="func" />
    <input type="hidden" name="row" id="row" />
    <input type="hidden" name="col" id="col" />
    <input type="hidden" name="sheetIdx" id="sheetIdx" />
    <input type="hidden" name="bkg_no" id="bkg_no" />
    <input type="hidden" name="bl_no" id="bl_no" />
    <input type="hidden" name="ok_hidden" id="ok_hidden" />
    <input type="hidden" name="send_hidden" id="send_hidden" />
    <input type="hidden" name="form_type" id="form_type" />
    <input type="hidden" name="form_dataOnly" id="form_dataOnly" />
    <input type="hidden" name="form_manifest" id="form_manifest" />
    <input type="hidden" name="form_hiddeData" id="form_hiddeData" />
    <input type="hidden" name="form_mainOnly" id="form_mainOnly" />
    <input type="hidden" name="form_level" id="form_level" />
    <input type="hidden" name="form_remark" id="form_remark" />
    <input type="hidden" name="form_Cntr" id="form_Cntr" />
    <input type="hidden" name="form_CorrNo" id="form_CorrNo" />
    <input type="hidden" name="form_his_cntr" id="form_his_cntr" />
    <input type="hidden" name="form_his_bkg" id="form_his_bkg" />
    <input type="hidden" name="form_his_mkd" id="form_his_mkd" />
    <input type="hidden" name="form_his_xpt" id="form_his_xpt" />
    <input type="hidden" name="form_his_bl" id="form_his_bl" />
    <input type="hidden" name="rp" id="rp" />
    <input type="hidden" name="ntc_knd_cd" id="ntc_knd_cd" />
</form>