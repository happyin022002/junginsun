<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1062.jsp
*@FileTitle  : TAA Search
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
<%@ page import="com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event.EsmBkg1062Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	EsmBkg1062Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";				//error message
	
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


		event = (EsmBkg1062Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

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
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="bkg_no" value="<%=bkgNo%>">
<input type="hidden" name="por_cd" value="<%=porCd%>">
<input type="hidden" name="del_cd" value="<%=delCd%>">
<input type="hidden" name="bkg_vvd" value="<%=bkgVvd%>">
<input type="hidden" name="calllFunc" value="<%=calllFunc%>">
<input type="hidden" name="lodg_due_dt" value="<%=lodgDueDt%>">
<input type="hidden" name="bkg_sts_cd" value="<%=bkgStsCd%>">
<!-- popup_title_area(S) -->
 <div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>TAA No Search</span></h2>
		<!-- page_title(E) -->
			
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_Select" id="btn_Select">Select</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_Taa" id="btn_Taa">TAA Inquiry</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->	
	</div>
	<!-- page_title_area(E) -->
</div>
<!-- popup_title_area(E) -->

<!-- popup_contens_area(S) -->
<div class="layer_popup_contents">
	<div class="wrap_search">
		<div class="opus_design_inquiry">   <!-- no TAB  -->
			<table> 
				<colgroup>
					<col width="40" />
					<col width="480" />
					<col width="80" />
					<col width="*" />
				</colgroup>
				
				<tbody>
					<tr>
						<th class="sm">SHPR</th> 
						<td class="sm"><input type="text" name="s_cust_cnt_cd" style="width:30px;ime-mode:disabled" class="input1" value="<%=sCustCntCd %>"  dataformat="enguponly"><!-- 
						  	 --><input type="text" name="s_cust_seq" style="width:58px;ime-mode:disabled" class="input" value="<%=sCustSeq %>"  maxlength=6 dataformat="num"><!-- 
						  	 --><input type="text" name="s_cust_nm" style="width:220px;ime-mode:disabled" class="input" value="" maxlength=40  maxlength=2 dataformat="engup" otherchar="()_\-,. &()'"><!-- 
						  	 --><button type="button" class="input_seach_btn" name="btn_Shpr" id="btn_Shpr"></button>
						</td>
						<th>Scope</th>
						<td><input type="text" name="svc_scp_cd" style="width:30px;ime-mode:disabled" class="input" value="" maxlength=3 dataformat="engup"><!--
						--><script type="text/javascript">ComComboObject('svc_scp_cd_list', 2, 195, 1, 0, 1)</script></td>
					</tr> 
					<tr>
						<th class="sm">CNEE</th> 
						<td class="sm"><input type="text" name="c_cust_cnt_cd" style="width:30px;ime-mode:disabled" class="input1" value="<%=cCustCntCd %>"  maxlength=2 dataformat="enguponly"><!-- 
			            	 --><input type="text" name="c_cust_seq" style="width:58px;ime-mode:disabled" class="input" value="<%=cCustSeq %>"  maxlength=6 dataformat="num"><!-- 
			            	 --><input type="text" name="c_cust_nm" style="width:220px;ime-mode:disabled" class="input" value="" maxlength=40  maxlength=2 dataformat="engup" otherchar="()_\-,. &()'"><!-- 
			            	 --><button type="button" class="input_seach_btn" name="btn_Cnee" id="btn_Cnee"></button><!--  
			            	 -->
			            <td></td>
			            <td></td>
			        </tr>
			        <tr>
						<th class="sm">CNPT</th> 
						<td class="sm"><input type="text" name="bkg_ctrl_pty_cust_cnt_cd" style="width:30px;ime-mode:disabled" class="input1" value="<%=bkgCtrlPtyCustCntCd %>"  maxlength=2 dataformat="enguponly"><!-- 
			            	 --><input type="text" name="bkg_ctrl_pty_cust_seq" style="width:58px;ime-mode:disabled" class="input" value="<%=bkgCtrlPtyCustSeq %>"  maxlength=6 dataformat="num"><!-- 
			            	 --><input type="text" name="bkg_ctrl_pty_cust_nm" style="width:220px;ime-mode:disabled" class="input" value="" maxlength=40  maxlength=2 dataformat="engup" otherchar="()_\-,. &()'"><!-- 
			            	 --><button type="button" class="input_seach_btn" name="btn_Ctrl_Pty" id="btn_Ctrl_Pty"></button><!--  
			            	 --><label for="include_flag">Any match</label><input type="checkbox" name="include_flag" class="trans" value="Y" id="include_flag">
			            <td></td>
			            <td></td>
			        </tr>
				</tbody>
			</table>
		</div>
	</div>
	<div class="wrap_result">
		<div class="opus_design_grid" >
			<script type="text/javascript">ComSheetObject('sheet1');</script>
			<table class="mar_top_8">
				<tr>
					<td colspan="4">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;* S - Shipper, C - Consignee, N - Notify, P - Contract Party</td> 
				</tr>
			</table>
		</div>
	</div>
</div>
</form>