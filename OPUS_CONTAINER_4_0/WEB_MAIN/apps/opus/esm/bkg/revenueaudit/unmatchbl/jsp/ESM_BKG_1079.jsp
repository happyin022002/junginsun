<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1079.jsp
*@FileTitle  : Audit by CNTR Qty Discrepancy
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
<%@ page import="com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.event.EsmBkg1079Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.code.CodeInfo"%>
<%@ page import="com.clt.apps.opus.esm.bkg.revenueauditcommon.rascommon.rascommon.vo.RsltCdListVO"%>
<%@ page import="com.clt.apps.opus.esm.bkg.revenueauditcommon.common.RASUtil"%>
<%@ page import="com.clt.framework.component.common.AbstractValueObject"%>
<%@ page import="java.util.List"%>

<%
    EsmBkg1079Event  event = null;              //PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//serverException
	String strErrMsg = "";						//error massage
	int rowCount	 = 0;						//DB ResultSet list count
    
    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    String strRhq_ofc_cd    = "";
    String strOfc_cd        = "";
    
    //String blNo = "";
    
    String[] rhqs = null;
    String[] offices = null;
    String[] svcScpCds = null;
    String[] contractTypes = null;  
    String[] splitFlgs = null;
    String[] chargeFlgs = null;
    
    Logger log = Logger.getLogger("com.clt.apps.RevenueAudit.UnmatchBL");
    
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        strRhq_ofc_cd = account.getRhq_ofc_cd();
        strOfc_cd = account.getOfc_cd();

        //blNo = request.getParameter("bl_no");
        
        event = (EsmBkg1079Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
        
		//when open screen, get data in server..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        
        // rhq
        rhqs = RASUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("rhq"));
        // office
        offices = RASUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("office"));
        if(null == offices){
            offices = new String[] {"", ""};
        }
        // Scope
        svcScpCds = RASUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("svcScpCd"));
        // Contract Type => 0256 reference
        contractTypes = RASUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("contractType"), false , "|", "\t", "getCode", "getName");
     // Split Status Combo Data creation
        splitFlgs = RASUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("splitFlg"), true , "|", "\t", "getCode", "getName");
     // Charge Status Combo Data creation
        chargeFlgs = RASUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("chargeFlg"), true , "|", "\t", "getCode", "getName");
        
        
    }catch(Exception e) {
        out.println(e.toString());
    }
    
%>

<script type="text/javascript">

    var rhqComboValue = "|<%=rhqs[0]%>";

    var officeComboValue = "|<%=offices[0]%>";
    
    if(officeComboValue == "|"){
        officeComboValue = "";
    }
    
    var svcScpCdComboValue = "|<%=svcScpCds[0]%>";
    var svcScpCdComboText = "|<%=svcScpCds[1]%>";
    
    var contractTypeComboValue = "|<%=contractTypes[0]%>";
    var contractTypeComboText = "|<%=contractTypes[1]%>";
    
    var splitFlgComboValue = "|<%=splitFlgs[0]%>";
    var splitFlgComboText = "|<%=splitFlgs[1]%>";
    
    var chargeFlgComboValue = "|<%=chargeFlgs[0]%>";
    var chargeFlgComboText = "|<%=chargeFlgs[1]%>";
    
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            showErrMessage(errMessage);
        } // end if
        loadPage();
    }
</script>

<form name="form">

<!--  definition for Office Code Validation check -->
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="cd" id="cd" />
<!--  definition for Office Code Validation check  -->
<input type="hidden" name="ofc_cd" value="" id="ofc_cd" />
<!-- Form Hidden -->
<input type="hidden" name="strRhq_ofc_cd" id="strRhq_ofc_cd"  value="<%=strRhq_ofc_cd%>" />
<input type="hidden" name="strOfc_cd" id="strOfc_cd"  value="<%=strOfc_cd%>" />
<input type="hidden" name="eq_subst_flg" id="eq_subst_flg" value="N"  />
<input type="hidden" name="awk_cgo_flg" value="N" id="awk_cgo_flg" />
<input type="hidden" name="bb_cgo_flg" value="N" id="bb_cgo_flg" />
<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
				 --><button type="button" class="btn_normal" name="btn_new"   id="btn_new">New</button><!-- 
				 --><button type="button" class="btn_normal" name="btn_save"   id="btn_save">Save</button><!-- 
				 --><button type="button" class="btn_normal" name="btn_downexcel"   id="btn_downexcel">Down Excel</button>
		</div>
		<!-- opus_design_btn(E) -->
	
		<!-- page_location(S) -->
		<div class="location">
			<span id="navigation"></span>
		</div>
	</div>
	<!-- opus_design_inquiry(S) -->
	<div class="wrap_search">
	<div class="opus_design_inquiry wFit">
	    <!-- 조회영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <table>
	         <colgroup>
	            <col width="60" />
	            <col width="130" />
	            <col width="100" />
	            <col width="100" />
	            <col width="100" />
	            <col width="100" />
	            <col width="100" />
	            <col width="100" />
	            <col width="100" />
	            <col width="100" />
	            <col width="" />
	        </colgroup> 
	        <tbody>
			<tr>
			<th>RHQ</th>
			<td><script type="text/javascript">ComComboObject('bkg_rhq_cd', 1, 90, 0, 1, 0, false);</script></td>
			<th>Office</th>
			<td><script type="text/javascript">ComComboObject('bkg_ofc_cd', 1, 80, 0, 0, 0, false);</script></td>
			<th class = "sm">Date</th>
			<td class = "sm"><input type="radio" class="trans" name="search_date" id="search_date" value="BOOKING" ><label for = "search_date">BKG</label><input type="radio" class="trans" name="search_date" id="search_date" value="APPL"><label for = "search_date">Appl.</label><input type="radio" name="search_date" id="search_date" value="ETD" class="trans" checked><label for = "search_date">ETD</label></td>
			<td><nobr><input type="text" style="width:75px;text-align:center;" class="input1" value="" caption="From Date" name="from_dt"dataformat="ymd" maxLength="10" minlength="8">&nbsp;<button type="button" class="calendar ir" name="btns_calendar1" id="btns_calendar1"></button>~&nbsp;<input type="text" style="width:75px;text-align:center;" class="input1" value="" caption="To Date" name="to_dt"dataformat="ymd" maxLength="10" minlength="8">&nbsp;<button type="button" class="calendar ir" name="btns_calendar2" id="btns_calendar2"></button></nobr></td>
			<th>Scope</th>
			<td><script type="text/javascript">ComComboObject('svc_scp_cd', 2, 90, 0, 0, 0, false);</script></td>
			<th>T/VVD</th>
			<td><input type="text" class="input" style="width:90px;text-align:center;ime-mode:disabled" name="vvd" dataformat="engup" caption="T/VVD" maxlength="9"><button type="button" class="input_seach_btn" name="btn_com_ens_ob2" id="btn_com_ens_ob2"></button></td>
			</tr>
			<tr>
				<th>Contract Type</th>
				<td><script type="text/javascript"> ComComboObject('bkg_ctrt_tp_cd', 1, 50, 0, 0, 0, false);</script></td>
				<th>Contract No.</th>
				<td><input input type="text" class="input" value="" style="width:105px;text-align:center;ime-mode:disabled" name="ctrt_no" id="ctrt_no" dataformat="engup" caption="Contract No" maxlength="12"></td>
				<td><th>Exclusion&nbsp;</th><td class="stm"><input type="checkbox" class="trans" name="chk_exclusion"><label for = "bill_type_all">ALL</label><input type="checkbox" class="trans" id="chk_sub_exclusion" name="chk_eq_subst_flg"><label for = "chk_eq_subst_flg">EQ Sub</label><input type="checkbox" class="trans" id="chkExclusion" name="chk_awk_cgo_flg"><label for = "chk_awk_cgo_flg">AK</label><input type="checkbox" class="trans" id="chkExclusion" name="chk_bb_cgo_flg"><label for = "chk_bb_cgo_flg">BB</label></td>
			</tr>	
			</tbody>
		</table>
	    <!-- 조회영역2 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	     </div>
	     <table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
		 
		 <div class="opus_design_inquiry wFit">
	    <!-- 조회영역3 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <table>
	         <colgroup>
	            <col width="84">
	            <col width="130">
	            <col width="50">
	            <col width="60">
	            <col width="130">
	            <col width="100">
	            <col width="100">
	            <col width="">
	        </colgroup> 
	        <tbody>
				<tr>
					<th>BDR Status</th>
					<td><script type="text/javascript">ComComboObject('bdr_flg', 1, 62, 0, 0, 0, false);</script></td>
					<th>Split Status</th>
					<td><script type="text/javascript">ComComboObject('split_flg', 2, 82, 0, 0, 0, false);</script></td>
					<th>Charge Status</th>
					<td><script type="text/javascript">ComComboObject('charge_flg', 2, 82, 0, 0, 0, false);</script></td>
					<th>Bill Type</th>
                    <td><input type="checkbox" class="trans" name="bill_type_all" value="ALL" id="bill_type_all" /><label for = "bill_type_all">ALL</label><input type="checkbox" class="trans" name="bill_type_n" value="N" checked id="bill_type_n" /><label for = "bill_type_n">Normal</label><input type="checkbox" class="trans" name="bill_type_m" value="M" checked id="bill_type_m" /><label for = "bill_type_m">Master</label><input type="checkbox" class="trans" name="bill_type_c" value="C" disabled id="bill_type_c" /><label for = "bill_type_c">Covered</label><input type="checkbox" class="trans" name="bill_type_b" value="B" disabled id="bill_type_b" /><label for = "bill_type_b">Co-Biz</label></td>
				</tr>
			</tbody>
		</table>
	    <!-- 조회영역3 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
	</div>
<!-- opus_design_inquiry(E) -->
<!-- opus_design_grid(S) -->
<div class="wrap_result">
	<div class="opus_design_grid">
	    <!-- opus_design_btn(S) -->
	    <div class="opus_design_btn" style="margin-bottom:3px">
	        <table>
	        	<tr>
					<th>B/L Count&nbsp;&nbsp;</th>
					<td><input type="text" style="width:60px;text-align:right" class="input" value="" name="bl_cnt" id="bl_cnt" readonly></td>
					
				</tr>
			</table>
	    </div>
	    <!-- opus_design_btn(E) -->
	    <script type="text/javascript">ComSheetObject('sheet1');</script>
</div>
</div>
	<!-- opus_design_grid(E) -->
							
</form>
