<%
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
// *@FileName   : ESM_PRI_2003.jsp
*@FileTitle  : Proposal & Amendment Creation 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/27
=========================================================
*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.event.EsmPri2003Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="com.clt.framework.component.util.code.CodeInfo"%>
<%@ page import="com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.PriParaCdDtlVO"%>

<%
	EsmPri2003Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String rfaNo = "";
    String condPropNo = null;
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_ofc		= "";
	String strUsrSrepCd     = "";
	Logger log = Logger.getLogger("com.clt.apps.RFAProposal.RFAProposalMain");
	String[] scopeCd = null;
	String[] dmdtCd = null;	
	String[] lodUtCd = null;
	String[] scpStsCd = null;
	String[] ctrtDurTpCd = null;
	//2014.10.13 Tariff basic Customer / Sales Rep
	String strTffBscCustCd = "";
	String strIsRoleforPri = "";
		
		
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_ofc = account.getOfc_cd();
	    strUsrSrepCd = account.getSrep_cd();
		event = (EsmPri2003Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		// adding logic to get data from server when first loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		rfaNo = JSPUtil.getNull(request.getParameter("rfa_no_2043"));
        condPropNo = JSPUtil.getNull(request.getParameter("cond_prop_no"));
        scopeCd = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("scopeList"), true);
        dmdtCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("dmdtList"), true ,"|","\t","getCode","getName");		
        lodUtCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("lodUtList"), false ,"|","\t","getCode","getName");	
        scpStsCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("scpStsList"), false ,"|","\t","getCode","getName");
        ctrtDurTpCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("ctrtDurTpList"), false ,"|","\t","getCode","getName");
        
      	//2014.10.13 Tariff
        strTffBscCustCd = PRIUtil.getStringValuePriParaCdDtl((List<PriParaCdDtlVO>)eventResponse.getCustomData("tariffBasicCustCd"),"getAttrCtnt1");
        strIsRoleforPri = eventResponse.getETCData("isRole");
        
        
	} catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
    var scopeCdValue = " |<%=scopeCd[0]%>";
    var scopeCdText = " |<%=scopeCd[1]%>";
    var dmdtCdValue = "<%=dmdtCd[0]%>";
    var dmdtCdText = "<%=dmdtCd[1]%>";
    var lodUtCdValue = "<%=lodUtCd[0]%>";
    var lodUtCdText = "<%=lodUtCd[1]%>";    
    var scpStsCdValue = "<%=scpStsCd[0]%>";
    var scpStsCdText = "<%=scpStsCd[1]%>";  
  	//2014.10.13 Tariff
    var tffBscCustCd = "<%=strTffBscCustCd%>";
    var isRoleforPri = "<%=strIsRoleforPri%>";
    //2015.07.23
    var ctrtDurTpCdValue = "<%=ctrtDurTpCd[0]%>";
    var ctrtDurTpCdText = "<%=ctrtDurTpCd[1]%>";  
    
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form" id="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="in_usr_ofc_cd" id="in_usr_ofc_cd" value="<%=strUsr_ofc%>">
<input type="hidden" name="in_usr_srep_cd" id="in_usr_srep_cd" value="<%=strUsrSrepCd%>">
<input type="hidden" name="in_usr_nm" id="in_usr_nm"  value="<%=strUsr_nm%>">
<input type="hidden" name="rfa_no_2043" id="rfa_no_2043" value="<%=rfaNo%>">
<input type="hidden" name="cond_prop_no" id="cond_prop_no" value="<%=condPropNo%>">
<input type="hidden" name="ori_rfa_no" id="ori_rfa_no" >
<input type="hidden" name="ori_prop_no" id="ori_prop_no" >

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title">
		<button type="button"><span>RFA Proposal & Amendment Creation</span></button>
	</h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_request" id="btn_request">Request</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_amend" id="btn_amend">Amend</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_coffer" id="btn_coffer">C/offer</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_approve" id="btn_approve">Approve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_cancel" id="btn_cancel">Cancel</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_copy" id="btn_copy">Copy</button><!--  
		 --><button type="button" class="btn_normal" name="btn_print" id="btn_print">Print</button><!-- 
	 --></div>
	<!-- opus_design_btn(E) -->
	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->

<!-- wrap_search(S) -->
<div class="wrap_search_tab">
<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
		<table>
			<tbody>
				<colgroup>
					<col width="50"/>
					<col width="110"/>
					<col width="60"/>
					<col width="60"/>
					<col width="70"/>
					<col width="200"/>
					<col width="220"/>
					<col width="60"/>
					<col width="100"/>
					<col width="80"/>
					<col width="*" />
				</colgroup>
				<tr>
					<th>RFA No.</th>
					<td><input type="text" style="width: 100px; text-align:center;" class="input" name="rfa_no" id="rfa_no" maxlength="11" dataformat="engup" /> </td>
					<th>AMD No.</th>
					<td><input type="text" style="width: 35px; text-align:center;" class="input2" name="amdt_seq" id="amdt_seq" readonly /> </td>
					<th>Proposal No.</th>
					<td><input type="text" style="width: 100px; text-align:center;" class="input" name="prop_no" id="prop_no" maxlength="11" dataformat="engup" /><!-- </td>
					 --><button type="button" class="btn_etc" name="btn_dur_pop" id="btn_dur_pop">Duration</button>
					</td>
					<td><input type="text" style="width: 80px; text-align:center;" class="input1" caption="Effective date" name="ctrt_eff_dt" id="ctrt_eff_dt" coffield="ctrt_exp_dt" maxlength="10" dataformat="ymd" required="required" />~&nbsp;<input type="text" style="width: 80px; text-align:center;" class="input1" caption="Expiration date" name="ctrt_exp_dt" id="ctrt_exp_dt" cofield="ctrt_eff_dt" maxlength="10" dataformat="ymd" required="required" /><!--  </td>
					 --><button type="button" class="calendar ir" name="btns_calendar1" id="btns_calendar1"></button></td>
					<th>Status</th>
					<td><input type="text" style="width: 85px; text-align:center;" class="input2" name="prop_sts" id="prop_sts" readonly /> </td>
					<td><button type="button" class="btn_down" name="btn_hidden" id="btn_hidden" ></button>
					<td></td>
				</tr>
			</tbody>
		</table>
	</div>

	<div class="opus_design_inquiry">
		<div id="subterms" >
			<table>
				<tbody>
					<colgroup>
						<col width="100"/>
						<col width="80"/>
						<col width="90"/>
						<col width="270"/>
						<col width="120"/>
						<col width="107"/>
						<col width="75"/>
						<col width="*" />
					</colgroup>
					<tr>
						<th>Request Office</th>
						<td><input type="text" style="width: 60px; text-align:center;" class="input1" name="prop_ofc_cd" id="prop_ofc_cd"  dataformat="engup" readonly caption="Request Office Code" required></td>
						<th>Sales Rep.</th>
						<td><script type="text/javascript">ComComboObject('prop_srep_cd', 2, 92, 0, 1);</script><input type="text" style="width: 185px; text-align:left;" class="input2" name="prop_srep_nm"  id="prop_srep_nm" readonly></td>
						<th>Creation Date</th>
						<td><input type="text" style="width: 80px; text-align:center;" class="input2" maxlength="10" dataformat="ymd" name="cre_dt" id="cre_dt" readonly></td>
						<th>Tariff</th>
						<td><input type="checkbox" id="trf_ctrt_flg" name="trf_ctrt_flg" value="" class="trans"></td>
					</tr>
				</tbody>
			</table>
			<table>
				<tbody>
					<colgroup>
						<col width="100"/>
						<col width="80"/>
						<col width="90"/>
						<col width="270"/>
						<col width="120"/>
						<col width="*" />
					</colgroup>
					<tr>
						<th>Approval Office</th>
						<td><input type="text" style="width: 60px; text-align:center;" class="input2" name="prop_apro_ofc_cd" id="prop_apro_ofc_cd" readonly></td>
						<th>Approval Staff</th>
						<td><input type="text" style="width: 281px; text-align:left;" class="input2" name="prop_apro_staff" id="prop_apro_staff" readonly></td>
						<th>Approval Date</th>
						<td><input type="text" style="width: 80px; text-align:center;" class="input2" maxlength="10" dataformat="ymd" name="prop_apro_dt" id="prop_apro_dt" readonly></td>
					</tr>
				</tbody>
			</table>
		<table>
			<tbody>
				<colgroup>
					<col width="100"/>
					<col width="548"/>
					<col width="430"/>
					<col width = "*"/>
				</colgroup>
				<tr>
					<th>Customer</th>
					<td>
						<input type="text" style="width: 55px; text-align:center;" class="input1" dataformat="engup" maxlength="2" minlength="2" name="ctrt_cust_cnt_cd" id="ctrt_cust_cnt_cd" readonly caption="Customer Code" required />
						<input type="text" style="width: 55px; text-align:center;" class="input1" dataformat="num" name="ctrt_cust_seq" id="ctrt_cust_seq" maxlength="6" readonly caption="Customer Code" required />
						 <button type="button" class="input_seach_btn" name="btn_ctrt_cust" id="btn_ctrt_cust"></button>
						 <input type="text" style="width: 291px; text-align:left;" class="input2"  name="ctrt_pty_nm" id="ctrt_pty_nm" readonly />
						 <input type="text" style="width: 100px;text-align:center;" class="input2" name="prc_ctrt_cust_tp_nm" id="prc_ctrt_cust_tp_nm" readonly />
						 <input type="hidden" style="width: 52px; text-align:center;" class="input2" name="ctrt_cust_val_sgm" id="ctrt_cust_val_sgm" readonly />
					 </td>
					<td>
						 <script type="text/javascript">ComComboObject('respb_srep_cd', 3, 92, 0,1);</script>
						 <input type="text" style="width: 265px;" class="input2" name="ctrt_cust_srep_nm"  id="ctrt_cust_srep_nm" readonly />
						 <input type="text" style="width: 67px; text-align:center;" class="input2" name="respb_sls_ofc_cd" id="respb_sls_ofc_cd" readonly caption="Customer Code" />
					</td>
					<td></td>
				</tr>
			</tbody>
		</table>
		<table>
			<tbody>
				<colgroup>
					<col width="100"/>
					<col width="150"/>
					<col width="40"/>
					<col width="237"/>
					<col width="98"/>
					<col width="80" />
					<col width="80" />
					<col width="*" />
				</colgroup>
				<tr>
					<th>Target MVC</th>
					<td><input type="text" style="width: 55px; text-align:right;" class="input" name="tgt_mvc_qty" id="tgt_mvc_qty" dataformat="int" readonly caption="Target MVC" maxlength="6"><script type="text/javascript">ComComboObject('cntr_lod_ut_cd', 1, 57, 0);</script></td>
					<th>Weekly MVC</th>
					<td><input type="text" style="width: 50px; text-align:right;" class="input2" name="prop_mvc" id="prop_mvc" dataformat="int" maxlength="6" readonly ><input type="text" style="width: 40px; text-align:center;" class="input2"  name="prop_mvc_tp" id="prop_mvc_tp" readonly></td>
					<td>
						<button type="button" class="btn_etc" name="btn_free_pop" id="btn_free_pop">Free Time</button>
						 <script type="text/javascript">ComComboObject('dmdt_ft_tp_cd', 1, 92, 0, 1);</script>
						<button type="button" class="btn_etc" name="btn_dem_pop" id="btn_dem_pop">DEM/DET</button>
						 <button type="button" class="btn_etc" name="btn_afil_pop" id="btn_afil_pop">
						 Affiliate</button>
					</td>
					<th width="83">Contract Type</th>
					<td><script type="text/javascript">ComComboObject('ctrt_dur_tp_cd', 0, 80, 0, 0);</script></td>
					<td></td>
				</tr>
				</tbody>
			</table>	
		</div>
	</div>
	<!-- opus_design_inquiry(E) -->
		
	<div class="opus_design_inquiry"><table class="line_bluedot"><tr><td colspan="6"></td></tr></table></div>
	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" style="display: none;">
        <script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<div class="opus_design_grid">
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_rowadd" id="btn_rowadd">Row Add</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_delete" id="btn_delete">Delete</button><!-- 
		 --></div>
        <script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
	<!-- opus_design_grid(E) -->
</div>		
<!-- wrap_search(E) -->

<!-- wrap_result(S) -->
<div class="wrap_result">

	<!-- opus_tab_btn(S) -->
	<div class="opus_design_tab">
		<script type="text/javascript">ComTabObject('tab1')</script>
	</div>
	<!-- opus_tab_btn(E) -->			
		
	<!-- iFrame (S) -->
	<div id="tabLayer" style="display:none">
		<iframe name="t1frame" id="t1frame" frameborder="0" scrolling="no" width="100%" height="400" src="about:blank"></iframe>
	</div>
	 <div id="tabLayer" style="display:none">
		<iframe name="t2frame" id="t2frame" frameborder="0" scrolling="no" width="100%" height="400" src="about:blank"></iframe>
	</div>
	<div id="tabLayer" style="display:none">
		<iframe name="t3frame" id="t3frame" frameborder="0" scrolling="no" width="100%" height="520" src="about:blank"></iframe>
	</div>
	<div id="tabLayer" style="display:none">
		<iframe name="t4frame" id="t4frame" frameborder="0" scrolling="no" width="100%" height="750" src="about:blank"></iframe>
	</div>
	<div id="tabLayer" style="display:none">
		<iframe name="t5frame" id="t5frame" frameborder="0" scrolling="no" width="100%" height="650" src="about:blank"></iframe>
	</div>
	<!-- iFrame (E) -->	
</div>
<!-- wrap_result(E) -->		
</form>