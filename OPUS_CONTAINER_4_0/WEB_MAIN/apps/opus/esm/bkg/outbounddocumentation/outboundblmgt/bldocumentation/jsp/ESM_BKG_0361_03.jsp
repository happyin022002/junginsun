<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0361_03.jsp
*@FileTitle  : Export / Import Information (Brazil)
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
	Exception serverException   = null;			//serverException
	String strErrMsg = "";						//error massage
	int rowCount	 = 0;						//DB ResultSet list count

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
	String pkg_qty = "";
	String wgt_qty = "";
	String pkg_tp = "";
	String wgt_tp = "";

	String popUpTpCd   = "";
    String xter_sndr_id  = "";
    String xter_rqst_no  = "";
    String xter_rqst_seq = "";

	List<XptImpLicVO> xptImpLicBrVO = null;

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

		//when open screen, get data in server..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		xptImpLicBrVO = (List<XptImpLicVO>) eventResponse.getCustomData("xptImpLicBrVO");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<base target="_self">

<script language="javascript">
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
		<input type="hidden" name="pkg_tp" value="<%=pkg_tp%>">
		<input type="hidden" name="wgt_tp" value="<%=wgt_tp%>">
		
		<input type="hidden" name="popUpTpCd" value="<%=popUpTpCd%>">
		<input type="hidden" name="xter_sndr_id" value="<%=xter_sndr_id%>">
		<input type="hidden" name="xter_rqst_no" value="<%=xter_rqst_no%>">
		<input type="hidden" name="xter_rqst_seq" value="<%=xter_rqst_seq%>">	
	

		<div class="opus_design_btn"><!--
		--><button type="button" class="btn_accent" name="btn_delete" id="btn_delete">Delete</button><!--
		--><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!--
		--><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		</div>
		<div class="wrap_search_tab">
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
								<%=JSPUtil.getCodeCombo("exp_cnt_cd", "BR", "onChange='javascript:goCtnCd(this);'", "CD20055", 0, "")%>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="opus_design_inquiry">
				<table>
					<colgroup>
						<col width="10%" />
						<col width="*" />
					</colgroup>
					<tbody>
						<tr class="h23">
							<th colspan="3"  style="text-align:left"><h3 class="title_design">Manifest Data for BRAZIL Customs</h3></th>
						</tr>
						<tr class="h23">
							<th>Booking No.</th>
							<td colspan="2">
								<input type="text" name="exp_bkg_no" style="width:110px;" class="input2" value="<%=bkg_no%>" readonly>
							</td>
						</tr>
						<tr class="h23">
							<th>
								Shipper CPF/CNPJ
							</th>
							<td>
								<input type="text" style="width:170px;" class="input" name="exp_shpr_tax_no" maxlength="14" dataformat="engup">
							</td>
							<td class="stm">
								<input type="checkbox" name="exp_shpr_tax_cpy_desc_flg" class="trans"  id="CHK01" value="Y" onClick="javascript:copyToDesc(this);"><label id="CHK01">Copy to Description</label> 
							</td>
						</tr>
						<tr class="h23">
							<th>
								Consignee CPF/CNPJ
							</th>
							<td>
								<input type="text" style="width:170px;" class="input" name="exp_cnee_tax_no" maxlength="14" dataformat="engup">
							</td>
							<td class="stm">
								<input type="checkbox" name="exp_cnee_tax_cpy_desc_flg" class="trans" id="CHK02" value="Y" onClick="javascript:copyToDesc(this);"><label id="CHK02">Copy to Description</label>
							</td>
						</tr>
						<tr class="h23">
							<th>
								Notify CPF/CNPJ
							</th>
							<td>
								<input type="text" style="width:170px;" class="input" name="exp_ntfy_tax_no" maxlength="14" dataformat="engup">
							</td>
							<td class="stm">
								<input type="checkbox" name="exp_ntfy_tax_cpy_desc_flg" class="trans" id="CHK05" value="Y" onClick="javascript:copyToDesc(this);"><label id="CHK05">Copy to Description</label>
							</td>
						</tr>
						<tr class="h23">
							<th>
								DDE/SD
							</th>
							<td>
								<input type="text" style="width:170px;" class="input" name="exp_brz_decl_no" maxlength="14" dataformat="engup">
							</td>
							<td class="stm">
								<input type="checkbox" name="exp_brz_decl_cpy_desc_flg" class="trans" id="CHK06" value="Y" onClick="javascript:copyToDesc(this);"><label id="CHK06">Copy to Description</label>
							</td>
						</tr>
	
					</tbody>
				</table>
			</div>
		</div>
		</form>
	</div>
	
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



		<div class="opus_design_btn"><!--
		--><button type="button" class="btn_accent" name="btn_delete2" id="btn_delete2">Delete</button><!--
		--><button type="button" class="btn_normal" name="btn_save2" id="btn_save2">Save</button><!--
		--><button type="button" class="btn_normal" name="btn_close2" id="btn_close2">Close</button>
		</div>

		<div class="wrap_search_tab">
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
								<%=JSPUtil.getCodeCombo("imp_cnt_cd", "BR", "onChange='javascript:goCtnCd(this);'", "CD30017", 0, "")%>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
	<!--TAB Import (E) -->
			<div class="opus_design_inquiry">
				<table>
					<tbody>
						<tr class="h23">
						<th colspan="3"  style="text-align:left"><h3 class="title_design">Manifest Data for BRAZIL Customs</h3></th>
						</tr>
						<tr class="h23">
							<th>Booking No.</th>
							<td colspan="2">
								<input type="text" name="imp_bkg_no" style="width:110px;" class="input2" value="<%=bkg_no%>" readOnly>
							</td>
						</tr>
						<tr class="h23">
							<th>
								Shipper CPF/CNPJ
							</th>
							<td>
								<input type="text" style="width:170px;" class="input" name="imp_shpr_tax_no" maxlength="14" dataformat="engup">
							</td>
							<td class="stm">
								<input type="checkbox" name="imp_shpr_tax_cpy_desc_flg" class="trans"  id="CHK11" value="Y" onClick="javascript:copyToDesc(this);"><label id="CHK11">Copy to Description</label>
							</td>
						</tr>
						<tr class="h23">
							<th>
								Consignee CPF/CNPJ
							</th>
							<td>
								<input type="text" style="width:170px;" class="input" name="imp_cnee_tax_no" maxlength="14" dataformat="engup">
							</td>
							<td class="stm">
								<input type="checkbox" name="imp_cnee_tax_cpy_desc_flg" class="trans"  id="CHK12" value="Y" onClick="javascript:copyToDesc(this);"><label id="CHK12">Copy to Description</label>
							</td>
						</tr>
						<tr class="h23">
							<th>
								Notify CPF/CNPJ
							</th>
							<td>
								<input type="text" style="width:170px;" class="input" name="imp_ntfy_tax_no" maxlength="14" dataformat="engup">
							</td>
							<td class="stm">
								<input type="checkbox" name="imp_ntfy_tax_cpy_desc_flg" class="trans"  id="CHK13" value="Y" onClick="javascript:copyToDesc(this);"><label id="CHK13">Copy to Description</label>
							</td>
						</tr>
						<tr class="h23">
							<th>
								DDE/SD
							</th>
							<td>
								<input type="text" style="width:170px;" class="input" name="imp_brz_decl_no" maxlength="14" dataformat="engup">
							</td>
							<td class="stm">
								<input type="checkbox" name="imp_brz_decl_cpy_desc_flg" class="trans"  id=""CHK14"" value="Y" onClick="javascript:copyToDesc(this);"><label id="CHK14">Copy to Description</label>
							</td>
						</tr>
					</tbody>
					</table>
				</div>
			</div>	
			</form>		
		</div>
	
		<div class="wrap_result" >
			<div class="opus_design_grid">
				<script type="text/javascript">ComSheetObject('sheet1');</script>
				<script type="text/javascript">ComSheetObject('sheet2');</script>
			</div>
		</div>
	</div>
	</div>
<!--TAB Import (E) -->




<form name="form3">
<input type="hidden" name="pol_cd" value="<%=pol_cd%>">
<input type="hidden" name="pod_cd" value="<%=pod_cd%>">
<input type="hidden" name="bkg_no" value="<%=bkg_no%>">
<input type="hidden" name="get_io_bnd_cd" value="<%=io_bnd_cd%>">
<input type="hidden" name="pkg_qty" value="<%=pkg_qty%>">
<input type="hidden" name="wgt_qty" value="<%=wgt_qty%>">
<input type="hidden" name="pkg_tp" value="<%=pkg_tp%>">
<input type="hidden" name="wgt_tp" value="<%=wgt_tp%>">
<input type="hidden" name="popUpTpCd" value="<%=popUpTpCd%>">
<input type="hidden" name="xter_sndr_id" value="<%=xter_sndr_id%>">
<input type="hidden" name="xter_rqst_no" value="<%=xter_rqst_no%>">
<input type="hidden" name="xter_rqst_seq" value="<%=xter_rqst_seq%>">
</form>
<form name="form4">
<input type="hidden" name="tabclosechk">
<input type="hidden" name="savechk">
<input type="hidden" name="modchk">
</form>
<form name="urlForm"></form>
</body>
</html>
