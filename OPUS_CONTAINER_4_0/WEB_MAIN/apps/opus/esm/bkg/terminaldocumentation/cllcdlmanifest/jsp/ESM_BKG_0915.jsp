<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0915
*@FileTitle  : ESM_BKG_0915
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/17
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
<%@ page import="com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.event.EsmBkg0915Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0915Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//serverException
	String strErrMsg = "";						//strErrMsg
	int rowCount	 = 0;						//DB ResultSet rowCount

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String vvdCd		= "";
	String portCd			= "";
	String bkgNo			= "";
	String cntrNo			= "";
	String cntrLodgNo			= "";
	String rowNum ="";
	Logger log = Logger.getLogger("com.clt.apps.TerminalDocumentation.CLLCDLManifest");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		vvdCd = StringUtil.xssFilter(request.getParameter("vvdCd"))==null?"":StringUtil.xssFilter(request.getParameter("vvdCd"));
		portCd = StringUtil.xssFilter(request.getParameter("portCd"))==null?"":StringUtil.xssFilter(request.getParameter("portCd"));
		bkgNo = StringUtil.xssFilter(request.getParameter("bkgNo"))==null?"":StringUtil.xssFilter(request.getParameter("bkgNo"));
		cntrNo = StringUtil.xssFilter(request.getParameter("cntrNo"))==null?"":StringUtil.xssFilter(request.getParameter("cntrNo"));
		cntrLodgNo = StringUtil.xssFilter(request.getParameter("cntrLodgNo"))==null?"":StringUtil.xssFilter(request.getParameter("cntrLodgNo"));
		rowNum = StringUtil.xssFilter(request.getParameter("rowNum"))==null?"":StringUtil.xssFilter(request.getParameter("rowNum"));

		event = (EsmBkg0915Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		//when open screen, get data in server..
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
<style type="text/css">
	table tbody tr th {
		font-weight: bold !important;
	}
	table:nth-child(2) tbody tr th, 
	table:nth-child(3) tbody tr th, 
	table:nth-child(4) tbody tr th {
		text-align: center;
	}
</style>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="in_vsl_cd" value="<%= vvdCd.substring(0,4)%>">
<input type="hidden" name="in_skd_voy_no" value="<%= vvdCd.substring(4,8)%>">
<input type="hidden" name="in_skd_dir_cd" value="<%= vvdCd.substring(8)%>">
<input type="hidden" name="in_port_cd" value="<%= portCd%>">
<input type="hidden" name="in_bkg_no" value="<%= bkgNo%>">
<input type="hidden" name="in_cntr_no" value="<%= cntrNo%>">
<input type="hidden" name="in_cntr_lodg_no" value="<%= cntrLodgNo%>">
<input type="hidden" name="rowNum" value="<%= rowNum%>">
<input type="hidden" name="form1_dg_cntr_seq">
<input type="hidden" name="form1_emer_cntc_pson_nm">
<input type="hidden" name="form1_aply_no">
<input type="hidden" name="form1_dcgo_ref_no">
<!-- OUTER - POPUP (S)tart -->

<div class="layer_popup_title">
	<!-- page_title_area(S) -->
		<div class="page_title_area clear">
		   <!-- page_title(S) -->
			<h2 class="page_title"><span>CLL for EDI - DG Info</span></h2>
			<!-- page_title(E) -->
			<!-- opus_design_btn (S) -->
			<div class="opus_design_btn">
				<button class="btn_accent" name="btn_rowadd" id="btn_rowadd" type="button">Add SEQ</button><!--
				--><button class="btn_normal" name="btn_delete" id="btn_delete" type="button">Delete SEQ</button><!--
				--><button class="btn_normal" name="btn_save" id="btn_save" type="button">Save</button><!--
				--><button class="btn_normal" name="btn_close" id="btn_close" type="button">Close</button><!--
				--></div>
			<!-- opus_design_btn (E) -->
		</div>
	<!-- page_title_area(E) -->
</div>
<div class="layer_popup_contents">
	<div class="wrap_search">
		<div class="opus_design_inquiry">
			<table> 
				<colgroup>
					<col width="80"/>
					<col width="120"/>
					<col width="80"/>
					<col width="*"/>
				</colgroup>
				<tbody>
					<tr>
						<th>Booking No.</th>
						<td><input type="text" style="width:100px;text-align:center;" class="input2" name="form1_bkg_no" value="<%=bkgNo %>" readonly id="form1_bkg_no"/></td>
						<th>Container No.</th>
						<td><input type="text" style="width:100px;text-align:center;" class="input2" name="form1_cntr_no" value="<%=cntrNo %>" readonly id="form1_cntr_no"/></td>
					</tr>
				</tbody>
			</table>
			<table class="grid_2"> 
				<colgroup>
					<col width="40"/>
					<col width="30"/>
					<col width="100"/>
					<col width="30"/>
					<col width="30"/>
					<col width="*"/>
				</colgroup>
				<tbody>
					<tr>
						<th>UN</th>
						<th>Class</th>
						<th>Tel</th>
						<th>Page</th>
						<th>Flash</th>
						<th>EMS</th>
					</tr>
					<tr>
						<td><input type="text" style="width:100px;text-align:center;"  name="form1_imdg_un_no" value="" maxlength="4" dataformat="num" id="form1_imdg_un_no" /></td>
						<td><input type="text" style="width:100px;text-align:center;"  name="form1_imdg_clss_cd" value="" maxlength="3" dataformat="num" otherchar="." id="form1_imdg_clss_cd" /></td>
						<td><input type="text" style="width:100px;text-align:center;"  name="form1_emer_cntc_phn_no" value="" dataformat="num" id="form1_emer_cntc_phn_no" /></td>
						<td><input type="text" style="width:100px;text-align:center;"  name="form1_imdg_pg_no" value="" maxlength="10" dataformat="num" id="form1_imdg_pg_no" /></td>
						<td><input type="text" style="width:100px;text-align:center;"  name="form1_flsh_pnt_cdo_temp" value="" dataformat="num" otherchar="." id="form1_flsh_pnt_cdo_temp" /></td>
						<td><input type="text" style="width:100px;text-align:center;"  name="form1_emer_prc_no" value="" maxlength="10" dataformat="engupetc" id="form1_emer_prc_no" /></td>
					</tr>
				</tbody>
			</table>
			<table class="grid_2 wAuto"> 
				<colgroup>
					<col width="60"/>
					<col width="60"/>
					<col width="60"/>
					<col width="*"/>
				</colgroup>
				<tbody>
					<tr>
						<th>Group</th>
						<th>MPoll</th>
						<th>Label</th>
						<th>PSA</th>
					</tr>
					<tr>
						<td><input type="text" style="width:100px;text-align:center;" class="noinput" name="form1_dg_pck_grp_cd" value="" dataformat="engup" id="form1_dg_pck_grp_cd" /></td>
						<td class="noinput">
						<select name="form1_polut_flg" style="width:74px">
							<option value="Y">Y</option>
							<option value="N">N</option>
						</select>
						</td>
						<td><input type="text" style="width:100px;text-align:center;" class="noinput" name="form1_dg_lbl_cd" value="" maxlength="10" dataformat="engup" id="form1_dg_lbl_cd" /></td>
						<td><input type="text" style="width:100px;text-align:center;" class="noinput" name="form1_dg_clss_cd" value="" maxlength="1" dataformat="engup" id="form1_dg_clss_cd" /></td>
					</tr>
				</tbody>
			</table>
			<table class="grid_2"> 
				<colgroup>
					<col width="80"/>
					<col width="80"/>
					<col width="80"/>
					<col width="80"/>
					<col width="80"/>
					<col width="80"/>
					<col width="80"/>
					<col width="80"/>
				</colgroup>
				<tr>
					<th colspan="2">Package</th>
					<th colspan="2">Net Weight</th>
					<th colspan="2">Gross Weight</th>
					<th colspan="2">Measure</th>
				</tr>
				<tr>
					<td><input type="text" style="width:100%;text-align:right;" class="noinput" name="form1_pck_qty" value="" dataformat="num" otherchar="."id="form1_pck_qty" /></td>
					<td width="10%"><input type="text" style="width:100%;text-align:center;" class="noinput" name="form1_tml_pck_ut_id" value="" id="form1_tml_pck_ut_id" /></td>
					<td><input type="text" style="width:100%;text-align:right;" class="noinput" name="form1_net_wgt" value="" dataformat="num" otherchar="."id="form1_net_wgt" /></td>
					<td width="10%">
					<%=JSPUtil.getCodeCombo("form1_net_wgt_ut_cd", "", "", "CD00775", 0, "")%>
					<!-- input type="text" style="width:40;text-align:center;" class="noinput" name="form1_net_wgt_ut_cd" value="" style="ime-mode:disabled"--></td>
					<td><input type="text" style="width:100%;text-align:right;" class="noinput" name="form1_grs_cntr_wgt" value="" dataformat="num" otherchar="."id="form1_grs_cntr_wgt" /></td>
					<td width="10%">
					<%=JSPUtil.getCodeCombo("form1_grs_wgt_ut_cd", "", "", "CD00775", 0, "")%>
					<!-- input type="text" style="width:40;text-align:center;" class="noinput" name="form1_grs_wgt_ut_cd" value="" style="ime-mode:disabled"--></td>
					<td><input type="text" style="width:100%;text-align:right;" class="noinput" name="form1_meas_qty" value="" dataformat="num" otherchar="."id="form1_meas_qty" /></td>
					<td width="10%">
					<%=JSPUtil.getCodeCombo("form1_meas_ut_cd", "", "", "CD01116", 0, "")%>				
					<!-- input type="text" style="width:40;text-align:center;" class="noinput" name="form1_meas_ut_cd" value="" style="ime-mode:disabled"--></td>
				</tr>
			</table>
			<table class="grid_2 wAuto w100">
				<colgroup>
					<col width="110" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr>
						<th>DG Description</th>
						<td><input type="text" class="noinput" name="form1_dg_desc" value="" dataformat="engupetc" id="form1_dg_desc" style="width:100%" /></td>
					</tr>
					<tr>
						<th>Remark</th>
						<td><input type="text" class="noinput" name="form1_dg_rmk" value="" dataformat="engupetc" id="form1_dg_rmk" style="width:100%" /></td>
					</tr>
					<tr>
						<th>HAZ Contents		</th>
						<td><input type="text" class="noinput" name="form1_hzd_ctnt" value="" dataformat="engupetc" id="form1_hzd_ctnt" style="width:100%" /></td>
					</tr>
					<tr>
						<th>Stowage	</th>
						<td><input type="text" class="noinput" name="form1_stwg_desc" value="" dataformat="engupetc" id="form1_stwg_desc" style="width:100%" /></td>
					</tr>
					<tr>
						<th>Label Description</th>
						<td><input type="text" class="noinput" name="form1_dg_lbl_desc" value="" dataformat="engupetc" id="form1_dg_lbl_desc" style="width:100%" /></td>
					</tr>
				</tbody>
			</table>
			<table class="wAuto w100"> 
				<colgroup>
					<col width="50" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr>
						<th>DG SEQ</th>
						<td><input type="text" style="width:20px;text-align:center;" class="input2" name="currentSeq" value="" readonly id="currentSeq" /><!-- 
						--><span class="dash">/</span><input type="text" style="width:20px;text-align:center;" class="input2" name="totalSeq" value="" readonly id="totalSeq" /><!-- 
						--><button type="button" class="btn_left" onclick="goPrev();"></button><!-- 
						--><button type="button" class="btn_right" onclick="goNext();"></button></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<div style="display:none">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
</form>