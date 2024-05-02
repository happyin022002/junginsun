<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0361_07.jsp
*@FileTitle  : Export / Import Information (MEXICO)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event.EsmBkg036101Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List" %>
<%@ page import="com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.XptImpLicVO" %>
<%@ page import="com.clt.apps.opus.esm.bkg.common.*" %>

<%

	EsmBkg036101Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.outboundblmgt.bldocumentation");

	/*
	*/
	String bkg_no = "";
	String io_bnd_cd = "";
	String pol_cd = "";
	String pod_cd = "";
	String go_cnt_cd = "";
	String go_cnt_nm = "";
	String pkg_qty = "";
	String wgt_qty = "";
	String pkg_tp = "";
	String wgt_tp = "";

	String popUpTpCd   = "";
    String xter_sndr_id  = "";
    String xter_rqst_no  = "";
    String xter_rqst_seq = "";

	List<XptImpLicVO> xptImpLicVO = null;

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg036101Event)request.getAttribute("Event");
		bkg_no       = event.getBkgNo();
		io_bnd_cd    = event.getIoBndCd();

		pol_cd		 = event.getPolCd();
		pod_cd       = event.getPodCd();
		go_cnt_cd    = (event.getGoCntCd()==null ||event.getGoCntCd().length()==0) ? "" : event.getGoCntCd();
		go_cnt_nm    = (event.getGoCntNm()==null ||event.getGoCntNm().length()==0) ? "" : event.getGoCntNm();
		pkg_qty		 = (event.getPkgQty()==null ||event.getPkgQty().length()==0) ? "0" : event.getPkgQty();
		wgt_qty		 = (event.getWgtQty()==null ||event.getWgtQty().length()==0) ? "0" : event.getWgtQty();
		pkg_tp		 = event.getPkgTp();
		wgt_tp       = event.getWgtTp();

		popUpTpCd       = event.getPopUpTpCd();
		xter_sndr_id    = event.getXterSndrId();
		xter_rqst_no    = event.getXterRqstNo();
		xter_rqst_seq   = event.getXterRqstSeq();

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// getting data from server when load the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		xptImpLicVO = (List<XptImpLicVO>) eventResponse.getCustomData("xptImpLicVO");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<base target="_self">

<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if

		loadPage();
	}
</script>

<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>Export / Import Information</span></h2>
	</div>
</div>

<div class="layer_popup_contents" style="overflow:hidden">
<div class="wrap_search_tab">
	<div class="opus_design_tab">
		<script >ComTabObject('tab1')</script>
	</div>
	<div id="tabLayer" style="display:inline">
	<form name="form" style="margin:0px;">
		<input type="hidden" name="f_cmd">
		<input type="hidden" name="pagerows">
		<input type="hidden" name="bkg_no" value="<%=bkg_no%>">
		<input type="hidden" name="io_bnd_cd" value="O">
		<input type="hidden" name="exp_io_bnd_cd" value="O">
		<input type="hidden" name="exp_xpt_imp_seq" value="1">
		<input type="hidden" name="go_cnt_cd" value="<%=go_cnt_cd%>">
		<input type="hidden" name="go_cnt_nm" value="<%=go_cnt_nm%>">
		<input type="hidden" name="pkg_tp" value="<%=pkg_tp%>">
		<input type="hidden" name="wgt_tp" value="<%=wgt_tp%>">
		
		<input type="hidden" name="popUpTpCd" value="<%=popUpTpCd%>">
		<input type="hidden" name="xter_sndr_id" value="<%=xter_sndr_id%>">
		<input type="hidden" name="xter_rqst_no" value="<%=xter_rqst_no%>">
		<input type="hidden" name="xter_rqst_seq" value="<%=xter_rqst_seq%>">
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_save" id="btn_save">Save</button>
			<button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		</div>
		<!-- wrap_search(S) -->
		<div class="wrap_search">
		<div class="opus_design_inquiry">
			<table>
				<colgroup>
					<col width="103" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr class="h23">
						<th>Country</th>
						<td>
						<%if(go_cnt_cd.equals("MX")){%>
							<%=JSPUtil.getCodeCombo("exp_cnt_cd", "MX", "onChange='javascript:goCtnCd(this);'", "CD20055", 0, "")%>
						<%}else if(go_cnt_cd.equals("CO")){%>
							<%=JSPUtil.getCodeCombo("exp_cnt_cd", "CO", "onChange='javascript:goCtnCd(this);'", "CD20055", 0, "")%>
						<%}else if(go_cnt_cd.equals("EC")){%>
							<%=JSPUtil.getCodeCombo("exp_cnt_cd", "EC", "onChange='javascript:goCtnCd(this);'", "CD20055", 0, "")%>
						<%}else if(go_cnt_cd.equals("PE")){%>
							<%=JSPUtil.getCodeCombo("exp_cnt_cd", "PE", "onChange='javascript:goCtnCd(this);'", "CD20055", 0, "")%>
						<%}%>
						<%--
							<%=JSPUtil.getCodeCombo("exp_cnt_cd", "MX", "onChange='javascript:goCtnCd(this);'", "CD20055", 0, "")%>
						 --%>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="opus_design_inquiry">
			<table>
				<tbody>
					<colgroup>
						<col width="10" />
						<col width="*" />
					</colgroup>
					<tr class="title_h">
						<th colspan="2" style="text-align:left"><h3 class="title_design">Manifest Data for <%=go_cnt_nm %> Customs</h3></th>
					</tr>
					<tr class="h23">		
						<th>Booking No.</th>
						<td>
							<input type="text" name="exp_bkg_no" style="width:110px;" class="input2" value="<%=bkg_no%>" readOnly>
						</td>
					</tr>
					<tr class="h23">
						<th>Shipper Tax ID</th>
						<td>
							<input type="text" style="width:200px;" class="input" name="exp_mx_shpr_tax_id" dataformat="engup"  maxlength="20" value="">
						</td>
					</tr>
					<tr class="h23">
						<th>
							Consignee Tax ID
						</th>
						<td>
							<input type="text" style="width:200px;" class="input" name="exp_mx_cnee_tax_id" dataformat="engup"  maxlength="20" value="">
						</td>
					</tr>
					<tr class="h23">
						<th>Notify Tax ID</th>
						<td>
							<input type="text" style="width:200px;" class="input" name="exp_mx_ntfy_tax_id" dataformat="engup"  maxlength="20" value="">
						</td>
					</tr>	
				</tbody>
			</table>
		</div>
		
	</div>
	<!-- wrap_search(E) -->
	</form>
	</div>
	<!-- wrap_search(S) -->
	<div class="wrap_search">
	<div id="tabLayer" style="display:none">
		<form name="form2" style="margin:0px;">
		<input type="hidden" name="f_cmd">
		<input type="hidden" name="pagerows">
		<input type="hidden" name="bkg_no" value="<%=bkg_no%>">
		<input type="hidden" name="io_bnd_cd" value="I">
		<input type="hidden" name="imp_io_bnd_cd" value="I">
		<input type="hidden" name="imp_xpt_imp_seq" value="1">
		<input type="hidden" name="go_cnt_cd" value="<%=go_cnt_cd%>">
		<input type="hidden" name="pkg_tp" value="<%=pkg_tp%>">
		<input type="hidden" name="wgt_tp" value="<%=wgt_tp%>">
		
		<input type="hidden" name="popUpTpCd" value="<%=popUpTpCd%>">
		<input type="hidden" name="xter_sndr_id" value="<%=xter_sndr_id%>">
		<input type="hidden" name="xter_rqst_no" value="<%=xter_rqst_no%>">
		<input type="hidden" name="xter_rqst_seq" value="<%=xter_rqst_seq%>">
		
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_save2" id="btn_save2">Save</button>
			<button type="button" class="btn_normal" name="btn_close2" id="btn_close2">Close</button>
		</div>
		<div class="opus_design_inquiry">
			<table>
				<colgroup>
					<col width="10%" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr class="h23">
						<th>Country</th>
						<td>
							<%=JSPUtil.getCodeCombo("imp_cnt_cd", "MX", "onChange='javascript:goCtnCd(this);'", "CD30017", 0, "")%>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="opus_design_inquiry">
			<table>
				<tbody>
					<tr class="title_h">
						<th colspan="2" style="text-align:left"><h3 class="title_design">Manifest Data for MEXICO Customs</h3></th>
					</tr>
					<tr class="h23">
						<th>
							Booking No.
						</th>
						<td>
							<input type="text" name="imp_bkg_no" style="width:110px;" class="input2" value="<%=bkg_no%>" readOnly>
						</td>
					</tr>
					<tr class="h23">
						<th>
							Shipper Tax ID
						</th>
						<td width=""><input type="text" style="width:200px;" class="input" name="imp_mx_shpr_tax_id" dataformat="engup"  maxlength="20" value=""></td>
					</tr>
					<tr class="h23">
						<th>
							Consignee Tax ID
						</th>
						<td>
							<input type="text" style="width:200px;" class="input" name="imp_mx_cnee_tax_id" dataformat="engup"  maxlength="20" value="">
						</td>
					</tr>
					<tr class="h23">
						<th>
							Notify Tax ID
						</th>
						<td>
							<input type="text" style="width:200px;" class="input" name="imp_mx_ntfy_tax_id" dataformat="engup"  maxlength="20" value="">
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		</form>
	</div>
	</div>
	<!-- wrap_search(E) -->
	<!-- wrap_result(S) -->
	<div class="wrap_result">
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
	</div>
</div>
</div>

<form name="form3">
<input type="hidden" name="pol_cd" value="<%=pol_cd%>" id="pol_cd" />
<input type="hidden" name="pod_cd" value="<%=pod_cd%>" id="pod_cd" />
<input type="hidden" name="bkg_no" value="<%=bkg_no%>" id="bkg_no" />
<input type="hidden" name="get_io_bnd_cd" value="<%=io_bnd_cd%>" id="get_io_bnd_cd" />
<input type="hidden" name="pkg_qty" value="<%=pkg_qty%>" id="pkg_qty" />
<input type="hidden" name="wgt_qty" value="<%=wgt_qty%>" id="wgt_qty" />
<input type="hidden" name="pkg_tp" value="<%=pkg_tp%>" id="pkg_tp" />
<input type="hidden" name="wgt_tp" value="<%=wgt_tp%>" id="wgt_tp" />
<input type="hidden" name="popUpTpCd" value="<%=popUpTpCd%>" id="popUpTpCd" />
<input type="hidden" name="xter_sndr_id" value="<%=xter_sndr_id%>" id="xter_sndr_id" />
<input type="hidden" name="xter_rqst_no" value="<%=xter_rqst_no%>" id="xter_rqst_no" />
<input type="hidden" name="xter_rqst_seq" value="<%=xter_rqst_seq%>" id="xter_rqst_seq" />
</form>
<form name="form4">
<input type="hidden" name="tabclosechk" id="tabclosechk" />
<input type="hidden" name="savechk" id="savechk" />
</form>
<form name="urlForm"></form>


