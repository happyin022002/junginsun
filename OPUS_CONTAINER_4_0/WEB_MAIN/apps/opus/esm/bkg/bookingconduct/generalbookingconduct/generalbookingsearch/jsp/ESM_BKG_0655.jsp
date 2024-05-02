<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0655.jsp
*@FileTitle  : SC Search 
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
<%@ page import="com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event.EsmBkg0655Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0655Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//serverException
	String strErrMsg = "";						//error massage

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.GeneralBookingConduct.GeneralBookingSearch");

	String bkgNo = "";
	String sCustCntCd = "";
	String sCustSeq = "";
	String cCustCntCd = "";
	String cCustSeq = "";
	String bkgCtrlPtyCustCntCd = "";
	String bkgCtrlPtyCustSeq = "";
	String porCd = "";
	String delCd = "";
	String calllFunc = "";
	String bkgVvd = "";	
	String lodgDueDt = "";	
	String bkgStsCd = "";	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg0655Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		bkgNo  = JSPUtil.getParameter(request, "bkg_no");
		sCustCntCd  = JSPUtil.getParameter(request, "s_cust_cnt_cd");
		sCustSeq  = JSPUtil.getParameter(request, "s_cust_seq");
		cCustCntCd  = JSPUtil.getParameter(request, "c_cust_cnt_cd");
		cCustSeq  = JSPUtil.getParameter(request, "c_cust_seq");
		bkgCtrlPtyCustCntCd = JSPUtil.getParameter(request, "bkg_ctrl_pty_cust_cnt_cd");
		bkgCtrlPtyCustSeq = JSPUtil.getParameter(request, "bkg_ctrl_pty_cust_seq");
		porCd  = JSPUtil.getParameter(request, "por_cd");
		delCd  = JSPUtil.getParameter(request, "del_cd");
		calllFunc  = JSPUtil.getParameter(request, "func");
		bkgVvd  = JSPUtil.getParameter(request, "bkg_vvd");	
		lodgDueDt = JSPUtil.getParameter(request, "lodg_due_dt");
		bkgStsCd = JSPUtil.getParameter(request, "bkg_sts_cd");	
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

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="bkg_no" value="<%=bkgNo%>">
<input type="hidden" name="por_cd" value="<%=porCd%>">
<input type="hidden" name="del_cd" value="<%=delCd%>">
<input type="hidden" name="bkg_vvd" value="<%=bkgVvd%>">
<input type="hidden" name="calllFunc" value="<%=calllFunc%>">
<input type="hidden" name="lodg_due_dt" value="<%=lodgDueDt%>">
<input type="hidden" name="bkg_sts_cd" value="<%=bkgStsCd%>">
<!-- Developer Work	-->

<!-- popup_title_area(S) -->
 <div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>S/C No. Search</span></h2>
		<!-- page_title(E) -->
			
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn"><!--
		--><button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_Select" id="btn_Select">Select</button><!--
		--><button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->	
	</div>
	<!-- page_title_area(E) -->
</div>
<!-- popup_title_area(E) -->
<!-- wrap_search(S) -->

<div class="layer_popup_contents">
	<div class="wrap_search">
		<div class="opus_design_inquiry">
			<table> 
				<tbody>
					<colgroup>
						<col width="40" />
						<col width="*" />
					</colgroup>
					<tr>
						<th>SHPR</th> 
						<td colspan="2"><input type="text" name="s_cust_cnt_cd" style="width:30px" class="input1" value="<%=sCustCntCd %>" style="ime-mode:disabled"  maxlength=2 dataformat="enguponly"><!--
						--><input type="text" name="s_cust_seq" style="width:58px" class="input" value="<%=sCustSeq %>"style="ime-mode:disabled"  maxlength=6 dataformat="num"><!--
						--><input type="text" name="s_cust_nm" style="width:320px" class="input" value="" maxlength=40 style="ime-mode:disabled"  maxlength=2 dataformat="engup" otherchar="()_\-,. &()'"><!--
						--><button type="button" class="input_seach_btn" name="btn_Shpr" id="btn_Shpr"></button>
						</td>
					</tr>
					<tr>
						<th>CNEE</th> 
						<td><input type="text" name="c_cust_cnt_cd" style="width:30px" class="input1" value="<%=cCustCntCd %>"style="ime-mode:disabled"  maxlength=2 dataformat="enguponly"><!--
						--><input type="text" name="c_cust_seq" style="width:58px" class="input" value="<%=cCustSeq %>"style="ime-mode:disabled"  maxlength=6 dataformat="num"><!--
						--><input type="text" name="c_cust_nm" style="width:320px" class="input" value="" maxlength=40 style="ime-mode:disabled"  maxlength=2 dataformat="engup" otherchar="()_\-,. &()'"><!--
						--><button type="button" class="input_seach_btn" name="btn_Cnee" id="btn_Cnee"></button><!--
						-->
						</td>
					</tr>
					<tr>
						<th>CNPT</th> 
						<td><input type="text" name="bkg_ctrl_pty_cust_cnt_cd" style="width:30px" class="input1" value="<%=bkgCtrlPtyCustCntCd %>"style="ime-mode:disabled"  maxlength=2 dataformat="enguponly"><!--
						--><input type="text" name="bkg_ctrl_pty_cust_seq" style="width:58px" class="input" value="<%=bkgCtrlPtyCustSeq %>"style="ime-mode:disabled"  maxlength=6 dataformat="num"><!--
						--><input type="text" name="bkg_ctrl_pty_cust_nm" style="width:320px" class="input" value="" maxlength=40 style="ime-mode:disabled"  maxlength=2 dataformat="engup" otherchar="()_\-,. &()'"><!--
						--><button type="button" class="input_seach_btn" name="btn_Ctrl_Pty" id="btn_Ctrl_Pty"></button><!--
						--><label for="include_flag"><strong>Any match</strong></label><input type="checkbox" name="include_flag" class="trans" value="Y" id="include_flag">
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<div class="wrap_result">
		<div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
			<div class="opus_design_data">
				<table>
					<colgroup>
						<col width="*" />
					</colgroup>
					<tbody>
						<tr>
							<td class="pad_top_4">* S - Shipper, C - Consignee, N - Notify, P - Contract Party</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>
<!-- wrap_search(E) -->	
</form>