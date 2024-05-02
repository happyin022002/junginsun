<%--
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_2019.jsp
*@FileTitle  : Proposal & Amendment Inquiry 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/28
=========================================================
*/
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.event.EsmPri2019Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="com.clt.framework.component.util.code.CodeInfo"%>
<%@ page import="com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%
	EsmPri2019Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String sRfaNo = "";
    String condPropNo = null;
	String sPropNo = "";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_ofc		= "";
	String strUsrSrepCd     = "";
	
	Logger log = Logger.getLogger("com.clt.apps.RFAProposal.RFAProposalMain");
	String[] scopeCd = null;
	String[] stsCd = null;
	String[] ctrtFlg = null;
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_ofc = account.getOfc_cd();
	    strUsrSrepCd = account.getSrep_cd();
		event = (EsmPri2019Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		// adding logic to get data from server when first loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		sRfaNo = JSPUtil.getNull(request.getParameter("s_rfa_no")); 
		sPropNo = JSPUtil.getNull(request.getParameter("s_prop_no"));
        condPropNo = JSPUtil.getNull(request.getParameter("cond_prop_no"));
        scopeCd = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("scopeList"), true);	
        stsCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("stsList"), false ,"|","\t","getCode","getName");
        //2014.09.29 ADD
        ctrtFlg = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("ctrtFlg"), false ,"|","\t","getCode","getName");
	
	} catch(Exception e) {
		out.println(e.toString());
	}
%>
<script type="text/javascript">
    var scopeCdValue = " |<%=scopeCd[0]%>";
    var scopeCdText = " |<%=scopeCd[1]%>";  
    var stsCdValue = " |<%=stsCd[0]%>";
    var stsCdText = " |<%=stsCd[1]%>";
    //2014.09.29 ADD
    var ctrtFlgValue = " |<%=ctrtFlg[0]%>";
    var ctrtFlgText = " |<%=ctrtFlg[1]%>";
     
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="in_usr_ofc_cd" id="in_usr_ofc_cd" value="<%=strUsr_ofc%>">
<input type="hidden" name="in_usr_srep_cd" id="in_usr_srep_cd" value="<%=strUsrSrepCd%>">
<input type="hidden" name="in_usr_nm" id="in_usr_nm" value="<%=strUsr_nm%>">
<input type="hidden" name="cond_prop_no" id="cond_prop_no" value="<%=condPropNo%>">
<%String mainPage = JSPUtil.getNull(request.getParameter("mainPage"));%>

<% if("false".equals(mainPage)){  %> 
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span id="title">RFA Proposal & Amendment Inquiry</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
			--><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!--
			--><button type="button" class="btn_normal" name="btn_proposal" id="btn_proposal">Open Proposal</button><!--
			--><button type="button" class="btn_normal" name="btn_history" id="btn_history">AMD History</button>
		</div>
		<!-- opus_design_btn(E) -->	
	</div>
</div>
<% } else { %>
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
		
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!--
		--><button type="button" class="btn_normal" name="btn_proposal" id="btn_proposal">Open Proposal</button><!--
		--><button type="button" class="btn_normal" name="btn_history" id="btn_history">AMD History</button>
	</div>
	<!-- opus_design_btn(E) -->	
	
    <!-- page_location(S) -->
	<div class="location"><span id="navigation"></span></div>
	
</div>
<!-- page_title_area(E) -->
<% } %>

<% if("false".equals(mainPage)){  %> 
<div class="layer_popup_contents">
<% } %>
<div class="wrap_search">
	<div class="opus_design_inquiry wFit">  <!-- TAB  -->
		<table> 
			<colgroup>
				<col width="100" />
				<col width="100" />
				<col width="264" />
				<col width="50" />
				<col width="150" />
				<col width="120" />
				<col width="100" />
				<col width="*" />
			</colgroup>
			<tbody>
				<tr>
					<th>RFA No.</th>
					<td><input type="text" style="width: 85px; text-align:center;" class="input" name="srfa_no" id="srfa_no" dataformat="engup" value="<%=sRfaNo%>" maxlength="11"></td>
					<th>Proposal No.</th>
					<td><input type="text" style="width: 80px; text-align:center;" class="input" name="sprop_no" id="sprop_no" dataformat="engup" value="<%=sPropNo%>" maxlength="11"></td>
					<th>Access Date</th>
					<td><input type="text" style="width: 80px; text-align:center;" class="input" name="seff_dt" id="seff_dt" maxlength="10" dataformat="ymd"><button type="button" class="calendar ir"  name="btns_calendar1"  id="btns_calendar1"></button></td>
					<th>Status</th>
					<td><script type="text/javascript">ComComboObject('sprop_sts_cd', 1, 93, 0, 0);</script></td>
				</tr>
			</tbody>
		</table>
		<table> 
			<colgroup>
				<col width="100" />
				<col width="50" />
				<col width="150" />
				<col width="120" />
				<col width="100" />
				<col width="*" />
			</colgroup>
			<tbody>
				<tr>
					<th>Service Scope </th>
					<td><script type="text/javascript">ComComboObject('ssvc_scp_cd', 2, 85, 0 , 0);</script><input type="text" style="width: 355px" class="input2" name="svc_scp_nm" id="svc_scp_nm" readonly caption="Service Scope Name"></td>
					<th>Request Office</th>
					<td><input type="text" style="width: 80px; text-align:center;" class="input" name="sprop_ofc_cd" id="sprop_ofc_cd" dataformat="enguponly" maxlength="6"></td>
					<th>S.Rep</th>
					<td><input type="text" style="width: 95px; text-align:center;" class="input" name="sprop_srep_cd" id="sprop_srep_cd" dataformat="engup" maxlength="5"></td>
				</tr>
			</tbody>
		</table>
		<table> 
			<colgroup>
				<col width="100" />
				<col width="120" />
				<col width="150" />
				<col width="*" />
			</colgroup>
			<tbody>
				<tr>
					<th>Customer</th>
					<td><input type="text" style="width: 30px; text-align: center;" class="input" name="scust_cnt_cd" id="scust_cnt_cd"  dataformat="enguponly" maxlength="2" minlength="2"><input type="text" style="width: 50px; text-align: center;" class="input" name="scust_seq" id="scust_seq" dataformat="num" maxlength="6"><button type="button" class="input_seach_btn" name="btn_ctrt_cust" id="btn_ctrt_cust"></button><!-- 
					--><input type="text" style="width: 327px;" class="input2" name="sctrt_pty_nm" id="sctrt_pty_nm" readonly>
					<th>Tariff</th>
					<td><script language="javascript">ComComboObject('strf_ctrt_flg', 1, 80, 0 , 0);</script></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
	<!-- inquiry_area(E) -->
	
<!-- wrap_result(S) -->
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" >
		<script type="text/javascript">ComSheetObject('sheet0');</script>
	</div>
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->

	<div class="opus_design_inquiry wFit" style="padding-top:7px !important;">
		<table style="" > 
			<colgroup>
				<col width="100"/>
				<col width="144"/>
				<col width="70"/>
				<col width="70"/>
				<col width="100"/>
				<col width="150"/>
				<col width="100"/>
				<col width="150"/>
				<col width="70"/>
				<col width="*" />
			</colgroup>
			<tbody>
				<tr>	
					<th>RFA No.</th>
					<td><input type="text" style="width: 100px; text-align:center;" class="input2" name="rfa_no" id="rfa_no" readonly></td>
					<th>AMD No.</th> 
					<td><input type="text" style="width: 35px; text-align:center;" class="input2" name="amdt_seq" id="amdt_seq" readonly></td>
					<th>Proposal No.</th>
					<td><input type="text" style="width: 100px; text-align:center;" class="input2" name="prop_no" id="prop_no" readonly></td>
					<th>Duration</th>
					<td><input type="text" style="width: 80px; text-align:center;" class="input2" name="ctrt_eff_dt" id="ctrt_eff_dt" maxlength="10" dataformat="ymd" readonly>~ <input type="text" style="width: 80px; text-align:center;" class="input2" name="ctrt_exp_dt" cofield="ctrt_eff_dt" maxlength="10" dataformat="ymd" readonly></td>
					<th>Status</th>
					<td><input type="text" style="width: 85px;" class="input2" name="prop_sts" id="prop_sts" readonly><button class="btn_down" name="btn_hidden" id="btn_hidden" type="button" class="cursor"></button></td>
			    </tr>
			</tbody>
		</table>
	</div>
		
	<table class="line_bluedot"><tr><td></td></tr></table>
	
	<div class="opus_design_inquiry wFit">	
		<div id="subterms">
	    <table> 
			<tbody>
				<colgroup>
					<col width="100"/>
					<col width="128"/>
					<col width="90"/>
					<col width="490"/>
					<col width="98"/>
					<col width="*" />
				</colgroup>
				<tr>
					<th>Request Office</th>
					<td><input type="text" style="width: 55px; text-align:center;" class="input2" name="prop_ofc_cd" id="prop_ofc_cd"  dataformat="enguponly" readonly></td>
					<th>Sales Rep.</th>
					<td>
						<input type="text" style="width: 65px; text-align:center;" class="input2" name="prop_srep_cd" id="prop_srep_cd" dataformat="enguponly" readonly>
						<input type="text" style="width: 238px; text-align:left;" class="input2" name="prop_srep_nm" id="prop_srep_nm" readonly>
					</td>
					<th>Creation Date</th>
					<td><input type="text" style="width: 80px; text-align:center;" class="input2" maxlength="10" dataformat="ymd" name="cre_dt" id="cre_dt" readonly></td>
				</tr>
			</tbody>
		</table>
		<table> 
			<tbody>
				<colgroup>
					<col width="100"/>
					<col width="111"/>
					<col width="130"/>
					<col width="467"/>
					<col width="98"/>
					<col width="*" />
				</colgroup>
				<tr>
					<th>Approval Office</th>
					<td><input type="text" style="width: 55px; text-align:center;" class="input2" name="prop_apro_ofc_cd" id="prop_apro_ofc_cd" readonly></td>
					<th>Approval Staff</th>
					<td><input type="text" style="width: 288px; text-align:left;" class="input2" name="prop_apro_staff" id="prop_apro_staff" readonly></td>
					<th>Approval Date</th>
					<td><input type="text" style="width: 80px; text-align:center;" class="input2" maxlength="10" dataformat="ymd" name="prop_apro_dt" id="prop_apro_dt" readonly></td>
				</tr>
			</tbody>
		 </table>
		 <table> 
			<tbody>
				<colgroup>
					<col width="100"/>
					<col width="*" />
				</colgroup>
				<tr>
					<th>Customer</th>
					<td>
						<input type="text" style="width: 55px;  text-align: center;" class="input2" dataformat="enguponly" maxlength="2" minlength="2" name="ctrt_cust_cnt_cd" id="ctrt_cust_cnt_cd"  readonly>
						<input type="text" style="width: 80px;  text-align: center;" class="input2" dataformat="num" name="ctrt_cust_seq" id="ctrt_cust_seq" maxlength="6" readonly>
						<input type="text" style="width: 304px; text-align:left;" class="input2" name="ctrt_pty_nm" id="ctrt_pty_nm" readonly>
						<input type="text" style="width: 65px;  text-align: center;" class="input2" name="prc_ctrt_cust_tp_nm" id="prc_ctrt_cust_tp_nm" readonly>
						<input type="hidden" style="width: 50px;" class="input2" name="ctrt_cust_val_sgm" id="ctrt_cust_val_sgm" readonly>
						<input type="text" style="width: 65px;  text-align: center;" class="input2" name="respb_srep_cd" id="respb_srep_cd" readonly>
						<input type="text" style="width: 188px;  text-align: left;" class="input2" name="ctrt_cust_srep_nm" id="ctrt_cust_srep_nm" readonly>
						<input type="text" style="width: 80px;  text-align: center;" class="input2" name="respb_sls_ofc_cd" id="respb_sls_ofc_cd" readonly>
					</td>
				</tr>
			</tbody>
		</table>
		<table> 
			<tbody>
				<colgroup>
					<col width="100"/>
					<col width="50"/>
					<col width="80"/>
					<col width="50"/>
					<col width="80"/>
					<col width="50"/>
					<col width="200"/>
					<col width="102"/>
					<col width="*" />
				</colgroup>
				<tr>
					<th>Target MVC</th>
					<td>
						<input type="text" style="width: 55px; text-align:right;" class="input2" name="tgt_mvc_qty" name="tgt_mvc_qty" dataformat="num" readonly caption="Target MVC" maxlength="6">
						<input type="text" style="width: 80px; text-align:center;" class="input2" name="cntr_lod_ut_cd" name="cntr_lod_ut_cd" readonly>
					</td>
					<th>Weekly MVC</th>
					<td>
						<input type="text" style="width: 50px; text-align:right;" class="input2" name="prop_mvc" id="prop_mvc" dataformat="num" maxlength="6" readonly>
						<input type="text" style="width: 40px; text-align:center;" class="input2" name="prop_mvc_tp" id="prop_mvc_tp" readonly>
					</td>
					<th>Free Time</th>
					<td><input type="text" style="width: 80px; text-align:center;" class="input2" name="dmdt_ft_tp_cd" id="dmdt_ft_tp_cd" readonly></td>
					<td>
					<button type="button" class="btn_etc" id="btn_dem_pop" 		name="btn_dem_pop">DEM/DET</button>
					<button type="button" class="btn_etc" id="btn_afil_pop"    name="btn_afil_pop" ><img class='btn_img'  src='img/tab_icon1.gif' name="img_affil"> Affiliate</button></td>
					<th>Tariff</th>
					<td><input type="checkbox" id="trf_ctrt_flg" name="trf_ctrt_flg" value="" class="trans" disabled="true"></td>
				</tr>
			</tbody>
		</table>
		</div>
	</div>

	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet2');</script>	
	</div>
	<!-- opus_design_grid(E) -->

	<!-- opus_tab_btn(S) -->
	<div class="opus_design_tab">
		<script type="text/javascript">ComTabObject('tab1')</script>
	</div>
	<!-- opus_tab_btn(E) -->
	
	<!-- iFrame (S) -->
	<div id="tabLayer">
		<iframe name="t1frame" id="t1frame" frameborder="0" scrolling="no" width="100%" height="685px" src="about:blank"></iframe>
	</div>
	<div id="tabLayer" style="display:none">
		<iframe name="t2frame" id="t2frame" frameborder="0" scrolling="no" width="100%" height="380px" src="about:blank"></iframe>
	</div>
	<div id="tabLayer" style="display:none">
		<iframe name="t3frame" id="t3frame" frameborder="0" scrolling="no" width="100%" height="380px" src="about:blank"></iframe>
	</div>
	<div id="tabLayer" style="display:none">
		<iframe name="t4frame" id="t4frame" frameborder="0" scrolling="no" width="100%" height="380px" src="about:blank"></iframe>
	</div>
	<div id="tabLayer" style="display:none">
		<iframe name="t5frame" id="t5frame" frameborder="0" scrolling="no" width="100%" height="590px" src="about:blank"></iframe>
	</div>                    
	<!-- iFrame (E) -->
</div>		

<% if("false".equals(mainPage)){  %> 
</div>
<% } %>
</form>
