<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : CPS_CNI_0008.jsp
*@FileTitle  : [CPS_CNI_0008] Payment
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/22
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@page import="com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.event.CpsCni0008Event"%>
<%@page import="com.clt.apps.opus.cps.cni.common.CniUtil"%>

<%
	CpsCni0008Event event = null;
    Exception serverException = null;
    String strErrMsg = "";
    int rowCount = 0;

    String successFlag = "";
    String codeList = "";
    String pageRows = "100";

    String userId = "";
    String userName = "";
    String userOffice = "";
    String userArea = "";

	String cgoClmNo = "";

    Logger log = Logger.getLogger("com.clt.apps.opus.cps.cni.codemgt.CodeMgtSC");
    SignOnUserAccount account = null;

    try
    {

		cgoClmNo  = JSPUtil.getParameter(request, "cgo_clm_no","");

        account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        userId = account.getUsr_id();
        userName = account.getUsr_nm();
        userOffice = account.getOfc_cd();

        event = (CpsCni0008Event) request.getAttribute("Event");
        serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null)
        {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

    }
    catch (Exception e)
    {
        out.println(e.toString());
    }
    
    // 사용자 roles
    String roles = CniUtil.getRoles(account);
    String area =  CniUtil.getAreaInfo(account);
    String ofcCd = account.getOfc_cd(); 
    
    //roles = "CNI03";
    //area =  "E";
    //ofcCd = "GOABB";
    //userId = "003997933";    
%>


<%@page import="com.clt.apps.opus.cps.gem.common.GemUtil"%>
<%@page import="com.clt.framework.component.util.StringUtil"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
function setupPage(){
	var errMessage = "<%=strErrMsg%>";
	if (errMessage.length >= 1) {
		showErrMessage(errMessage);
	} // end if
	loadPage();
}
</script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="usr_id" id="usr_id" value="<%=userId%>">
<input type="hidden" name="usr_roles" id="usr_roles" value="<%=roles%>">
<input type="hidden" name="usr_area" id="usr_area" value="<%=area%>">
<input type="hidden" name="usr_office" id="usr_office" value="<%=ofcCd%>">
<!-- Status 변경을 위한 변수 -->
<input type="hidden" name="cgo_clm_sts_cd" id="cgo_clm_sts_cd" />
<input type="hidden" name="cgo_clm_clz_cd" id="cgo_clm_clz_cd" />
<input type="hidden" name="upd_usr_id" id="upd_usr_id" />
<!-- 권한체크위한 변수 -->
<input type="hidden" name="hdlr_usr_id" id="hdlr_usr_id" />
<input type="hidden" name="hdlr_ofc_cd" id="hdlr_ofc_cd" />
<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<h2 class="page_title"><span>Payment</span></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		    <button type="button" class="btn_accent" name="btn1_Retrieve" id="btn1_Retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn1_New" id="btn1_New">New</button><!-- 
		 --><button type="button" class="btn_normal" name="btn1_Save" id="btn1_Save">Save</button><!-- 
		 --><button type="button" class="btn_normal" name="btn1_Close" id="btn1_Close">Close</button>
	</div>
	<!-- opus_design_btn(E) -->
	<!-- page_location(S) -->
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit" >
		<table> 
			<colgroup>
				<col width="120">
				<col width="200">	
				<col width="50">	
				<col width="100">
				<col width="40">	
				<col width="100">	
				<col width="*">
		   </colgroup>
			<tbody>
				<tr>
						<th>Claim No.</th>
						<td>
							<input type="text" style="width:120px;text-align:center" class="input1" name="cgo_clm_no" id="cgo_clm_no" value="<%=cgoClmNo%>" required caption="Claim No" maxlength="10" ><!-- 
							 --><input type="text" name="clm_area_cd" id="clm_area_cd" style="width:35px;text-align:center" value="" class="input2" readonly>
						</td>
						<th>Status</th>
						<td><input type="text" name="clm_misc_nm" id="clm_misc_nm"  style="width:112px;text-align:center" class="input2" value="" readonly></td>
						<td></td>
						<th title="Date Of Close">DOC</th>
						<td><input type="text" name="cs_clz_dt" id="cs_clz_dt" style="width:100%;text-align:center; dataformat="ymd" class="input2" value="" readonly></td>
				</tr>
			</tbody>
		</table>
		<table>
			<colgroup>
				<col width="120">
				<col width="*">
		   </colgroup>
			<tbody>
				<tr>
					<th>Claimant</th>
					<td><input type="text" name="pty_nm" id="pty_nm" style="width:363px;" class="input2" value="" readonly>
				</tr>
			</tbody>
		</table>
		<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
		<table> 
			<colgroup>
				<col width="120">
				<col width="100">	
				<col width="60">
				<col width="10">
				<col width="180">	
				<col width="68">	
				<col width="*">
		   </colgroup>
			<tbody>
				<tr>
					<th>Claim Amount</th>
					<td>
						<input type="text" name="clmt_locl_amt" id="clmt_locl_amt" style="width:110px;text-align:right;ime-mode:disabled" dataformat="float" pointcount="2" class="input2" value="" readonly><!--  
						--><input type="text" name="clmt_locl_curr_cd" style="width:35px;text-align:center" class="input2" value="">
					</td>
					<th title="Rate of Exchange">R.O.E<th>
					<td>
						<input type="text" name="clmt_locl_xch_rt" id="clmt_locl_xch_rt" style="width:70px;text-align:right;ime-mode:disabled" dataformat="float" pointcount="5" class="input2" value="" readonly><!-- 
						 --><input type="text" name="clmt_usd_amt" id="clmt_usd_amt" style="width:110px;text-align:right;ime-mode:disabled" dataformat="float" pointcount="2" class="input2" value="" readonly>USD 
					</td>
					<th title="Date of Formal Claim">DOF</th>
					<td><input type="text" name="fmal_clm_rcv_dt" id="fmal_clm_rcv_dt" dataformat="ymd" style="width:100%;text-align:center;ime-mode:disabled" class="input2" value="" readonly></td>
				</tr>
			</tbody>
		</table>
		<table>
			<colgroup>
				<col width="120">
				<col width="100">	
				<col width="60">
				<col width="10">
				<col width="180">	
				<col width="68">	
				<col width="*">
		   </colgroup>
			<tbody>
				<tr>
					<th>Settled Amount</th>
					<td>
						<input type="text" name="cgo_clm_stl_locl_amt" id="cgo_clm_stl_locl_amt" style="width:110px;text-align:right;ime-mode:disabled" dataformat="float" pointcount="2" class="input2" value="" readonly><!--  
						 --><input type="text" name="cgo_clm_stl_locl_curr_cd" id="cgo_clm_stl_locl_curr_cd" style="width:35px;text-align:center" class="input2" value="" readonly>
					</td>
					<th title="Rate of Exchange">R.O.E<th>
					<td>
						<input type="text" name="cgo_clm_stl_xch_rt" id="cgo_clm_stl_xch_rt" style="width:70px;text-align:right;ime-mode:disabled" dataformat="float" pointcount="5" class="input2" value="" readonly><!-- 
						 --><input type="text" name="cgo_clm_stl_usd_amt" id="cgo_clm_stl_usd_amt" style="width:110px;text-align:right;ime-mode:disabled" dataformat="float" pointcount="2" class="input2" value="" readonly>USD
					</td>
					<th title="Date Of Settlement">DOS</th>
					<td><input type="text" name="cgo_clm_stl_dt" id="cgo_clm_stl_dt" dataformat="ymd" style="width:100%;text-align:center;ime-mode:disabled" class="input2" value="" readonly></td>
				</tr>
			</tbody>
		</table>
		<table>
			<colgroup>
				<col width="420">	
				<col width="*">
		   </colgroup>
			<tbody>
				<tr>
					<th>Recovered Amount</th>
					<td><input type="text" name="recovered_amount" id="recovered_amount" style="width:110px;text-align:right;ime-mode:disabled" dataformat="float" pointcount="2" class="input2" value="" readonly>USD</td>
				</tr>
			</tbody>
		</table>
		<table>
			<colgroup>
				<col width="120">	
				<col width="100">	
				<col width="60">	
				<col width="10">	
				<col width="230">	
				<col width="*">
		   </colgroup>
			<tbody>
				<tr>
					<th>From Liable Party</th>
					<td>
						<input type="text" name="labl_pty_rcvr_locl_amt" id="labl_pty_rcvr_locl_amt" style="width:110px;text-align:right;ime-mode:disabled" dataformat="float" pointcount="2" class="input2" value="" readonly><!-- 
						 --><input type="text" name="labl_pty_rcvr_locl_curr_cd" id="labl_pty_rcvr_locl_curr_cd" style="width:35px;text-align:center" class="input2" value="" readonly>
					</td>
					<th title="Rate of Exchange">R.O.E<th>
					<td>
						<input type="text" name="labl_pty_rcvr_locl_xch_rt"  id="labl_pty_rcvr_locl_xch_rt" style="width:70px;text-align:right;ime-mode:disabled" dataformat="float" pointcount="5" class="input2" value="" readonly><!--  
						 --><input type="text" name="labl_pty_rcvr_usd_amt" id="labl_pty_rcvr_usd_amt" style="width:110px;text-align:right;ime-mode:disabled" dataformat="float" pointcount="2" class="input2" value="" readonly>USD
					</td>
					<th width=50px>LP DOR</th>
					<td><input type="text" name="labl_pty_rcvr_dt" id="labl_pty_rcvr_dt" dataformat="ymd" style="width:100%;text-align:center;ime-mode:disabled" class="input2" value="" readonly></td>
				</tr>
			</tbody>
		</table>
		<table>
			<colgroup>
				<col width="120">	
				<col width="100">	
				<col width="60">	
				<col width="10">	
				<col width="230">	
				<col width="*">
		   </colgroup>
			<tbody>
				<tr>
					<th>From Insurer</th>
					<td>
						<input type="text" name="insur_rcvr_amt" id="insur_rcvr_amt" style="width:110px;text-align:right;ime-mode:disabled" dataformat="float" pointcount="2" class="input2" value="" readonly><!-- 
						 --><input type="text" name="insur_rcvr_locl_curr_cd"  id="insur_rcvr_locl_curr_cd" style="width:35px;text-align:center" class="input2" value="" readonly>
					</td>
					<th title="Rate of Exchange">R.O.E<th>
					<td>
						<input type="text" name="insur_rcvr_xch_rt" id="insur_rcvr_xch_rt" style="width:70px;text-align:right;ime-mode:disabled" dataformat="float" pointcount="5" class="input2" value="" readonly><!-- 
						 --><input type="text" name="insur_rcvr_usd_amt" id="insur_rcvr_usd_amt" style="width:110px;text-align:right;ime-mode:disabled" dataformat="float" pointcount="2" class="input2" value="" readonly>USD
					</td>
					<th width="50px">INS DOR</th>
					<td><input type="text" name="insur_rcvr_dt"  id="insur_rcvr_dt" dataformat="ymd" style="width:100%;text-align:center;ime-mode:disabled" class="input2" value="" readonly></td>
				</tr>
			</tbody>
		</table>
		<table>
			<colgroup>
				<col width="420">	
				<col width="*">
		   </colgroup>
			<tbody>
				<tr>
					<th>Net Paid Amount</th>
					<td><input type="text" name="net_paid_amount"  id="net_paid_amount" style="width:110px;text-align:right;ime-mode:disabled" dataformat="float" pointcount="2" class="input2" value="" readonly>USD</td>
				</tr>
			</tbody>
		</table>
		<table>
			<colgroup>
				<col width="479">
				<col width="*">
		   </colgroup>
			<tbody>
				<tr>
					<th>Defense Ratio on Settlement</th>
					<td><input type="text" name="defense_ratio_on_settlement" id="defense_ratio_on_settlement" style="width:50px;text-align:right;ime-mode:disabled" dataformat="float" pointcount="2" class="input2" value="" readonly>% </td>
				</tr>
				<tr>
					<th>on Net Payment&nbsp;</th>
					<td><input type="text" name="on_net_payment" id="on_net_payment" style="width:50px;text-align:right;ime-mode:disabled" dataformat="float" pointcount="2" class="input2" value="" readonly>% </td>
				</tr>
			</tbody>
		</table>
		
		<table>
			<colgroup>
				<col width="420" />
				<col width="*" />
		   </colgroup> 
			<tbody>
				<tr>
					<th>Handling Cost in Total</th>
					<td><input type="text" name="inv_usd_amt"  id="inv_usd_amt"  style="width:110px;text-align:right;ime-mode:disabled" dataformat="float" pointcount="2" class="input2" value="" readonly>USD</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="opus_design_data">
		<table class="grid_2"> 
			<colgroup>
				<col width="120" />
				<col width="*" />
		   </colgroup> 
			<tbody>
				<tr>
					<th><strong>Remarks</strong></th>
					<td><textarea style="width:100%; resize:none" name="pay_rmk" id="pay_rmk" caption="Remarks" rows="3"></textarea></td>
				</tr>
			</tbody>
		</table>
		<div style="text-align:right;margin-bottom:4px">
			<button class="btn_etc" name="btn1_Handling_Costs" id="btn1_Handling_Costs" type="button">Handling Costs</button>
		</div>
	</div>
</div>
</form>
<div style="display: none;"><script type="text/javascript">ComSheetObject('sheet1');</script></div>