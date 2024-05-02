<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0957.jsp
*@FileTitle  : Code Creation Request Popup
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/29
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.event.EsmBkg0957Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0957Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.BookingConduct.GeneralBookingReceipt");

	String bkgNo  = "";
	String blNo  = "";
	String blNoTp  = "";
	String blTpTd  = "";

	String shCustCntCd  = "";
	String shCustSeq  = "";
	String shCustTpCd  = "";
	String shCustNm  = "";
	String shCustAddr  = "";
	String shCustCtyNm  = "";
	String shCustSteCd  = "";
	String shCstmsDeclCntCd  = "";
	String shCustZipId  = "";
	String cnCustCntCd  = "";
	String cnCustSeq  = "";
	String cnCustTpCd  = "";
	String cnCustNm = "";
	String cnCustAddr  = "";
	String cnCustCtyNm  = "";
	String cnCustSteCd  = "";
	String cnCstmsDeclCntCd  = "";
	String cnCustZipId  = "";
	String cnCustFaxNo  = "";
	String cnCustEml  = "";
	String nfCustCntCd  = "";
	String nfCustSeq  = "";
	String nfCustTpCd  = "";
	String nfCustNm  = "";
	String nfCustAddr  = "";
	String nfCustCtyNm  = "";
	String nfCustSteCd  = "";
	String nfCstmsDeclCntCd  = "";
	String nfCustZipId  = "";
	String nfCustFaxNo  = "";
	String nfCustEml  = "";	


	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		//event = (EsmBkg0957Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		bkgNo  = JSPUtil.getParameter(request, "bkg_no");
		blNo  = JSPUtil.getParameter(request, "bl_no");
		blNoTp  = JSPUtil.getParameter(request, "bl_no_tp");
		blTpTd  = JSPUtil.getParameter(request, "bl_tp_cd");
/*		
		shCustCntCd  = JSPUtil.getParameter(request, "sh_cust_cnt_cd");
		shCustSeq  = JSPUtil.getParameter(request, "sh_cust_seq");
		shCustTpCd  = JSPUtil.getParameter(request, "sh_cust_tp_cd");
		shCustNm  = JSPUtil.getParameter(request, "sh_cust_nm");
		shCustAddr  = JSPUtil.getParameter(request, "sh_cust_addr");
		shCustCtyNm  = JSPUtil.getParameter(request, "sh_cust_cty_nm");
		shCustSteCd  = JSPUtil.getParameter(request, "sh_cust_ste_cd");
		shCstmsDeclCntCd  = JSPUtil.getParameter(request, "sh_cstms_decl_cnt_cd");
		shCustZipId  = JSPUtil.getParameter(request, "sh_cust_zip_id");
		cnCustCntCd  = JSPUtil.getParameter(request, "cn_cust_cnt_cd");
		cnCustSeq  = JSPUtil.getParameter(request, "cn_cust_seq");
		cnCustTpCd  = JSPUtil.getParameter(request, "cn_cust_tp_cd");
		cnCustNm = JSPUtil.getParameter(request, "cn_cust_nm");
		cnCustAddr  = JSPUtil.getParameter(request, "cn_cust_addr");
		cnCustCtyNm  = JSPUtil.getParameter(request, "cn_cust_cty_nm");
		cnCustSteCd  = JSPUtil.getParameter(request, "cn_cust_ste_cd");
		cnCstmsDeclCntCd  = JSPUtil.getParameter(request, "cn_cstms_decl_cnt_cd");
		cnCustZipId  = JSPUtil.getParameter(request, "cn_cust_zip_id");
		cnCustFaxNo  = JSPUtil.getParameter(request, "cn_cust_fax_no");
		cnCustEml  = JSPUtil.getParameter(request, "cn_cust_eml");
		nfCustCntCd  = JSPUtil.getParameter(request, "nf_cust_cnt_cd");
		nfCustSeq  = JSPUtil.getParameter(request, "nf_cust_seq");
		nfCustTpCd  = JSPUtil.getParameter(request, "nf_cust_tp_cd");
		nfCustNm  = JSPUtil.getParameter(request, "nf_cust_nm");
		nfCustAddr  = JSPUtil.getParameter(request, "nf_cust_addr");
		nfCustCtyNm  = JSPUtil.getParameter(request, "nf_cust_cty_nm");
		nfCustSteCd  = JSPUtil.getParameter(request, "nf_cust_ste_cd");
		nfCstmsDeclCntCd  = JSPUtil.getParameter(request, "nf_cstms_decl_cnt_cd");
		nfCustZipId  = JSPUtil.getParameter(request, "nf_cust_zip_id");
		nfCustFaxNo  = JSPUtil.getParameter(request, "nf_cust_fax_no");
		nfCustEml  = JSPUtil.getParameter(request, "nf_cust_eml");		
*/		

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
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
<input type="hidden" name="bkg_no" value="<%=bkgNo%>" id="bkg_no" />
<input type="hidden" name="bl_no" value="<%=blNo%>" id="bl_no" />
<input type="hidden" name="bl_no_tp" value="<%=blNoTp%>" id="bl_no_tp" />
<input type="hidden" name="bl_tp_cd" value="<%=blTpTd%>" id="bl_tp_cd" />
<input type="hidden" name="sh_cust_cnt_cd" value="<%=shCustCntCd%>" id="sh_cust_cnt_cd" />
<input type="hidden" name="sh_cust_seq" value="<%=shCustSeq%>" id="sh_cust_seq" />
<input type="hidden" name="sh_cust_tp_cd" value="<%=shCustTpCd%>" id="sh_cust_tp_cd" />
<input type="hidden" name="sh_cust_nm" value="<%=shCustNm%>" id="sh_cust_nm" />
<input type="hidden" name="sh_cust_addr" value="<%=shCustAddr%>" id="sh_cust_addr" />
<input type="hidden" name="sh_cust_cty_nm" value="<%=shCustCtyNm%>" id="sh_cust_cty_nm" />
<input type="hidden" name="sh_cust_ste_cd" value="<%=shCustSteCd%>" id="sh_cust_ste_cd" />
<input type="hidden" name="sh_cstms_decl_cnt_cd" value="<%=shCstmsDeclCntCd%>" id="sh_cstms_decl_cnt_cd" />
<input type="hidden" name="sh_cust_zip_id" value="<%=shCustZipId%>" id="sh_cust_zip_id" />
<input type="hidden" name="cn_cust_cnt_cd" value="<%=cnCustCntCd%>" id="cn_cust_cnt_cd" />
<input type="hidden" name="cn_cust_seq" value="<%=cnCustSeq%>" id="cn_cust_seq" />
<input type="hidden" name="cn_cust_tp_cd" value="<%=cnCustTpCd%>" id="cn_cust_tp_cd" />
<input type="hidden" name="cn_cust_nm" value="<%=cnCustNm%>" id="cn_cust_nm" />
<input type="hidden" name="cn_cust_addr" value="<%=cnCustAddr%>" id="cn_cust_addr" />
<input type="hidden" name="cn_cust_cty_nm" value="<%=cnCustCtyNm%>" id="cn_cust_cty_nm" />
<input type="hidden" name="cn_cust_ste_cd" value="<%=cnCustSteCd%>" id="cn_cust_ste_cd" />
<input type="hidden" name="cn_cstms_decl_cnt_cd" value="<%=cnCstmsDeclCntCd%>" id="cn_cstms_decl_cnt_cd" />
<input type="hidden" name="cn_cust_zip_id" value="<%=cnCustZipId%>" id="cn_cust_zip_id" />
<input type="hidden" name="cn_cust_fax_no" value="<%=cnCustFaxNo%>" id="cn_cust_fax_no" />
<input type="hidden" name="cn_cust_eml" value="<%=cnCustEml%>" id="cn_cust_eml" />
<input type="hidden" name="nf_cust_cnt_cd" value="<%=nfCustCntCd%>" id="nf_cust_cnt_cd" />
<input type="hidden" name="nf_cust_seq" value="<%=nfCustSeq%>" id="nf_cust_seq" />
<input type="hidden" name="nf_cust_tp_cd" value="<%=nfCustTpCd%>" id="nf_cust_tp_cd" />
<input type="hidden" name="nf_cust_nm" value="<%=nfCustNm%>" id="nf_cust_nm" />
<input type="hidden" name="nf_cust_addr" value="<%=nfCustAddr%>" id="nf_cust_addr" />
<input type="hidden" name="nf_cust_cty_nm" value="<%=nfCustCtyNm%>" id="nf_cust_cty_nm" />
<input type="hidden" name="nf_cust_ste_cd" value="<%=nfCustSteCd%>" id="nf_cust_ste_cd" />
<input type="hidden" name="nf_cstms_decl_cnt_cd" value="<%=nfCstmsDeclCntCd%>" id="nf_cstms_decl_cnt_cd" />
<input type="hidden" name="nf_cust_zip_id" value="<%=nfCustZipId%>" id="nf_cust_zip_id" />
<input type="hidden" name="nf_cust_fax_no" value="<%=nfCustFaxNo%>" id="nf_cust_fax_no" />
<input type="hidden" name="nf_cust_eml" value="<%=nfCustEml%>" id="nf_cust_eml" />
<!-- Groupmail시 반영될 Hidden --> 
<input type="hidden" name="gw_subject" id="gw_subject" />
<input type="hidden" name="gw_contents" id="gw_contents" />
<input type="hidden" name="gw_template" value="ESM_BKG_0957_01T.html" id="gw_template" />
<input type="hidden" name="gw_args" value="bkgno;" id="gw_args" />
<input type="hidden" name="gw_args" value="blno;" id="gw_args" />
<input type="hidden" name="gw_args" value="reqcontents;" id="gw_args" />
<input type="hidden" name="com_subject" id="com_subject" />
<input type="hidden" name="com_content" id="com_content" />

<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>Code Creation Request Pop-up</span></h2>
		
		<div class="opus_design_btn">
			<button class="btn_accent" name="btn1_Send" id="btn1_Send" type="button">Send</button><!--
			--><button class="btn_normal" name="btn1_Close" id="btn1_Close" type="button">Close</button>
		</div>
	</div>
</div>

<div class="layer_popup_contents">
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="*" />				
			   </colgroup> 
			   <tbody>
			   		<tr><th style="text-align: center">Select customers to be requested.</th></tr>
			   		<tr><td><input type="checkbox" name="shipper" value="Y" class="trans" id="shipper" /><label for="shipper">Shipper</label></td></tr>
			   		<tr><td><input type="checkbox" name="consignee" value="Y" class="trans" id="consignee" /><label for="consignee">Consignee</label></td></tr>
			   		<tr><td><input type="checkbox" name="notify" value="Y" class="trans" id="notify" /><label for="notify">Notify</label></td></tr>
			   </tbody>
			</table>
			<script type="text/javascript">ComSheetObject('sheet1');</script>	
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>
</div>

</form>