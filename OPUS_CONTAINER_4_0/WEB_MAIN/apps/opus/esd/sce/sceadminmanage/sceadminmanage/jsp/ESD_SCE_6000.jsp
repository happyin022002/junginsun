<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_SCE_6000.jsp
*@FileTitle  : SCE Admin
*@author     : CLT
*@version    : 1.0
*@since      : 2014/11/12
=========================================================*/
%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.sce.sceadminmanage.sceadminmanage.event.EsdSce6000Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdSce6000Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.SceAdminManage.SceAdminManage");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsdSce6000Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script language="javascript">
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
	<div class="page_title_area clear ">
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--  
			--><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!-- 
			--><button type="button" class="btn_normal" name="btn_download" id="btn_download">Download</button>	
		</div>

		<div class="location">
			<span id="navigation"></span>
		</div>
	</div>
	
	<div class="wrap_result">
		<div class="opus_design_tab">
			<script language="javascript">ComTabObject('tab1')</script>
		</div>
	
		<div id="tabLayer" style="display:inline">
			<div class="opus_design_inquiry">
				<table>
					<tr>
						<th width="100">From / To Date</th>
						<td>
							<input type="text" style="width:78px" name="tml_fm_dt" id="tml_fm_dt" dataformat="ymd">~
							<input type="text" style="width:78px" name="tml_to_dt" id="tml_to_dt" dataformat="ymd"><!--
						 --><button type="button" class="calendar" id="btns_calendar1" name="btns_calendar1"></button>
						</td>
					</tr>
				</table>
			</div>
			<div class="opus_design_grid">
				<div class="opus_design_btn">
					<button type="button" class="btn_normal" name="btn_terminalChange" id="btn_terminalChange">Terminal Change</button>
				</div>
				<script language="javascript">ComSheetObject('t1sheet1');</script>
			</div>
		</div>
		
		<div id="tabLayer" style="display:none">
			<div class="opus_design_inquiry">
				<table>
					<tr>
						<th width="100">Booking No.</th>
						<td width="120"><input name="rpln_bkg_no" id="rpln_bkg_no" type="text" style="width:120px" maxlength="13" value="" Onkeydown="onEnterKey(this)" dataformat="engup" ></td>
						<th width="60">B/L No.</th>
						<td width="120"><input name="rpln_bl_no"  id="rpln_bl_no" type="text" style="width:110px" maxlength="13"  Onkeydown="onEnterKey(this)"  onKeyUp="ComChkObjValid(this, false, true, true)" dataformat="engup"></td>
						<th width="90">Container No.</th>
						<td><input name ="rpln_cntr_no" id ="rpln_cntr_no" type = "hidden" value =""></td>
						<td width="140">
							<input name="rpln_cntr_no_nonbit" id="rpln_cntr_no_nonbit" type="text" value ="" style="width:100px" maxlength="11" Onkeydown="onEnterKey(this)" onChange="CheckDigitSplit(this,'rpln_cntr_no_split', 'rpln_cntr_no')"  onKeyUp="CheckDigitSplit(this, 'rpln_cntr_no_split', 'rpln_cntr_no')" dataformat="engup"><!-- 
						 --><input name="rpln_cntr_no_split" id ="rpln_cntr_no_split" type="text" style="width:22px" maxlength="2" readonly></td>
						<th width="50">COP No.</th>
						<td><input name="rpln_cop_no" id="rpln_cop_no" type="text" style="width:110px" maxlength="14"  Onkeydown="onEnterKey(this)" dataformat="engup"></td> 
					</tr>
					<tr>
						<th>From / To Date</th>
						<td colspan="3">
							<input type="text" style="width:78px" id="rpln_fm_dt" name="rpln_fm_dt" dataformat="ymd">~
							<input type="text" style="width:78px" id="rpln_to_dt" name="rpln_to_dt" dataformat="ymd"><!-- 
						 --><button type="button" class="calendar" id="btns_calendar2" name="btns_calendar2"></button>
						</td>
					</tr>
				</table>
			</div>
			<div class="opus_design_grid">
				<div class="opus_design_btn">
					<button type="button" class="btn_normal" name="btn_manualReplan" id="btn_manualReplan">Manual Replan</button>
					<button type="button" class="btn_normal" name="btn_RowAdd" id="btn_RowAdd">Row Add</button>
					<button type="button" class="btn_normal" name="btn_RowDelete" id="btn_RowDelete">Row Delete</button>
				</div>
				<script language="javascript">ComSheetObject('t2sheet1');</script>
			</div>
		</div>
		
		<div id="tabLayer" style="display:none">
			<div class="opus_design_inquiry">
				<table>
					<tr>
						<th width="100">From / To Date</th>
						<td>
							<input type="text" style="width:78px" name="mst_fm_dt" id="mst_fm_dt" dataformat="ymd">~
							<input type="text" style="width:78px" name="mst_to_dt" id="mst_to_dt" dataformat="ymd"><!--
						 --><button type="button" class="calendar" id="btns_calendar3" name="btns_calendar3"></button>
						</td>
					</tr>
				</table>
			</div>
			<div class="opus_design_grid">
				<script language="javascript">ComSheetObject('t3sheet1');</script>
			</div>
		</div>
		
		<div id="tabLayer" style="display:none">
			<div class="opus_design_inquiry">
				<table>
					<tr>
						<th width="100">Booking No.</th>
						<td width="160"><input name="cdiff_bkg_no" id="cdiff_bkg_no" type="text" style="width:120px" maxlength="13" value="" Onkeydown="onEnterKey(this)" dataformat="engup" ></td>
						<th width="50">B/L No.</th>
						<td width="140"><input name="cdiff_bl_no"  id="cdiff_bl_no" type="text" style="width:110px" maxlength="13"  Onkeydown="onEnterKey(this)"  onKeyUp="ComChkObjValid(this, false, true, true)" dataformat="engup"></td>
						<th width="50">COP No.</th>
						<td><input name="cdiff_cop_no" id="cdiff_cop_no" type="text" style="width:110px" maxlength="14"  Onkeydown="onEnterKey(this)" dataformat="engup"></td> 
					</tr>
					<tr>
						<th>From / To Date</th>
						<td>
							<input type="text" style="width:78px" id="cdiff_fm_dt" name="cdiff_fm_dt" dataformat="ymd">~
							<input type="text" style="width:78px" id="cdiff_to_dt" name="cdiff_to_dt" dataformat="ymd"><!-- 
						 --><button type="button" class="calendar" id="btns_calendar4" name="btns_calendar4"></button>
						</td>
					</tr>
				</table>
			</div>
			<div class="opus_design_grid">
				<div class="opus_design_btn">
					<button type="button" class="btn_normal" name="btn_diff" id="btn_diff">Attach / Detach</button>
				</div>
				<script language="javascript">ComSheetObject('t4sheet1');</script>
			</div>
		</div>
		
		<div id="tabLayer" style="display:none">
			<div class="opus_design_grid">
				<script language="javascript">ComSheetObject('t5sheet1');</script>
			</div>
		</div>
		
		<div id="tabLayer" style="display:none">
			<div class="opus_design_inquiry">
				<table>
					<tr>
						<th width="100">Booking No.</th>
						<td width="120"><input name="act_bkg_no" id="act_bkg_no" type="text" style="width:120px" maxlength="13" value="" Onkeydown="onEnterKey(this)" dataformat="engup"></td>
						<th width="130">B/L No.</th>
						<td width="120"><input name="act_bl_no" id="act_bl_no" type="text" style="width:110px" maxlength="13"  Onkeydown="onEnterKey(this)"  onKeyUp="ComChkObjValid(this, false, true, true)" dataformat="engup"></td>
						<th width="85">Container No.</th>
						<td width="1"><input name ="act_cntr_no" id ="act_cntr_no" type = "hidden" value =""></td>
						<td width="140">
							<input name="act_cntr_no_nonbit" id="act_cntr_no_nonbit" type="text" value ="" style="width:100px" maxlength="11" Onkeydown="onEnterKey(this)" onChange="CheckDigitSplit(this,'act_cntr_no_split', 'act_cntr_no')"  onKeyUp="CheckDigitSplit(this, 'act_cntr_no_split', 'act_cntr_no')" dataformat="engup">
							<input name="act_cntr_no_split" id ="act_cntr_no_split" type="text" style="width:22px" maxlength="2" readonly>
						</td>
						<th width="50">COP No.</th>
						<td><input name="act_cop_no" id="act_cop_no" type="text" style="width:110px" maxlength="14"  Onkeydown="onEnterKey(this)" dataformat="engup"></td> 
					</tr>
				</table>
				<table>
					<tr>
						<th width="100">From / To Date</th>
						<td width="200">
							<input type="text" style="width:78px" name="act_fm_dt" id="act_fm_dt" dataformat="ymd">~
							<input type="text" style="width:78px" name="act_to_dt" id="act_to_dt" dataformat="ymd"><!--
						 --><button type="button" class="calendar" id="btns_calendar5" name="btns_calendar5"></button>
						<th width="49">VVD</th>
						<td width="80"><input onKeyUp="ComChkObjValid(this)" onBlur="ComChkObjValid(this)" name="vvd" id="vvd" type="text" class="input" dataformat="engup" style="width:78px"></td>
						<td width="1"><input name ="cntr_no" id ="cntr_no" type = "hidden" value =""></td>
						<td width="1"><input name ="cntr_no" id ="cntr_no" type = "hidden" value =""></td>
						<td width="1"><input name ="cntr_no" id ="cntr_no" type = "hidden" value =""></td>
						<th width="115">Rcv TP</th>
						<td width="120">
							<select name="act_rcv_tp_cd" id="act_rcv_tp_cd" style="width:112px">
								<option value="" >ALL</option>
								<option value="1" >MVMT</option>
								<option value="2" >VSK ACTUAL</option> 
								<option value="3" >EDI 322</option>
								<option value="9" >SPP</option>
							</select>
						</td>
						<th width="70">Result</th>
						<td>
							<select name="act_umch_tp_cd" id="act_umch_tp_cd" style="width:112px">
								<option value="" >ALL</option>
								<option value="99" >Success</option>
								<option value="30" >Node Not Found</option> 
								<option value="50" >Fail</option>
							</select>
						</td>
					</tr>
				</table>
			</div>
			<div class="opus_design_grid">
				<script language="javascript">ComSheetObject('t6sheet1');</script>
			</div>
		</div>
	</div>
</form>