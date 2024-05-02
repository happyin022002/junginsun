<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0156.jsp
*@FileTitle  : COD Application at BKG Office
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/07
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.event.EsmBkg0156Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO" %>
<%@ page import="com.clt.apps.opus.esm.bkg.common.*" %>
<%@ page import="com.clt.framework.core.controller.util.WebKeys"%>
<%@ page import="com.clt.framework.core.view.template.Screen"%>
<%@ page import="com.clt.framework.core.controller.DefaultViewAdapter"%>
<%@ page import="com.clt.apps.opus.bcm.sup.valuemanage.util.ConstantMgr"%>
<%
	EsmBkg0156Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//serverException
	String strErrMsg = "";						//error massage
	int rowCount	 = 0;						//DB ResultSet list count

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_eml       = "";
	String strBkgNo			= "";
	String strBlNo			= "";
	String strcodRqstSeq    = "";
	String strPopFlg		= "";
	String strCodStsCd		= "";
	String screenName		= "";		
	String mainPage 		= "";
	String sXml 			= "";
	Logger log = Logger.getLogger("com.clt.apps.BookingCorrection.CODCorrection");
	
	//List<BkgComboVO> codReasonlist = null;
	//List<BkgComboVO> statuslist = null;
	//List<BkgComboVO> approvalRsolist = null;
	//List<BkgComboVO> rejectReasonlist = null;



	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_eml = account.getUsr_eml();
		event = (EsmBkg0156Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		//when open screen, get data in server..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		strPopFlg = JSPUtil.getParameter(request, "popFlg");
		mainPage = JSPUtil.getNull(request.getParameter("mainPage"));
		if("S".equals(strPopFlg)){
			strBkgNo  		= JSPUtil.getParameter(request, "bkg_no");
			strBlNo   		= JSPUtil.getParameter(request, "bl_no");
			strcodRqstSeq 	= JSPUtil.getParameter(request, "cod_rqst_seq");
		} else {
			strBkgNo		= JSPUtil.getNull(event.getBkgBlNoVO().getBkgNo());
			strBlNo 		= JSPUtil.getNull(event.getBkgBlNoVO().getBlNo());
			strcodRqstSeq 	= JSPUtil.getNull(event.getCodRqstSeq());
			
			DefaultViewAdapter adapter = new DefaultViewAdapter();
			sXml = adapter.makeXML(request, response);
		}
		if(sXml != null && !sXml.equals(""))
			sXml = JSPUtil.replace(sXml, "\"", "&quot;");
		else
			sXml = "";
			
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
<%=ConstantMgr.getCompanyCodeToJS()%>
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>



<form name="form" onkeyup="ComKeyEnter('lengthnextfocus');">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="popFlg" id="popFlg" value="<%=strPopFlg%>"> 
<input type="hidden" name="codRemark"  id="codRemark"> 
<input type="hidden" name="codRjctRsnRmk"  id="codRjctRsnRmk">
<input type="hidden" name="oldBkgNo" id="oldBkgNo" value="<%=strBkgNo%>">
<input type="hidden" name="oldBlNo" id="oldBlNo"  value="<%=strBlNo%>">
<input type="hidden" name="oldCodRqstSeq" id="oldCodRqstSeq" value="<%=strcodRqstSeq%>">
<input type="hidden" name="codStsCd" id="codStsCd"><!--cod status, btn able, disable-->
<input type="hidden" name="saveModeCd" id="saveModeCd" value="C"><!--C : CREATE, U : UPDATE-->
<input type="hidden" name="pctl_no" id="pctl_no" ><!--P/C result1-->
<input type="hidden" name="map_seq" id="map_seq" ><!--P/C result2-->
<input type="hidden" name="codRjctCd" id="codRjctCd">
<input type="hidden" name="routeRow" id="routeRow">
<input type="hidden" name="sXml" id="sXml" value="<%=JSPUtil.replace(sXml, "\"", "&quot;")%>">
<input type="hidden" name="pc_flg" id="pc_flg" value="N">
<!-- Groupmail Hidden --> 
<input type="hidden" name="gw_subject" id="gw_subject">
<input type="hidden" name="gw_contents" id="gw_contents">
<input type="hidden" name="gw_template" id="gw_template" value="ESM_BKG_COMM_01T.html">
<input type="hidden" name="gw_args"  id="gw_args" value="reqcontents;">

<input type="hidden" name="bkg_por_cd" id="bkg_por_cd"> 
<input type="hidden" name="bkg_por_yd_cd" id="bkg_por_yd_cd">
<input type="hidden" name="bkg_pol_cd" id="bkg_pol_cd">
<input type="hidden" name="bkg_pol_yd_cd" id="bkg_pol_yd_cd">
<input type="hidden" name="bkg_pod_cd" id="bkg_pod_cd">
<input type="hidden" name="bkg_pod_yd_cd" id="bkg_pod_yd_cd">
<input type="hidden" name="bkg_del_cd" id="bkg_del_cd">
<input type="hidden" name="bkg_del_yd_cd" id="bkg_del_yd_cd">
<input type="hidden" name="bkgStsCd" id="bkgStsCd">
<!-- RouteDetail Hidden Sheet -->
<input type="hidden" name="org_trns_mod_cd" id="org_trns_mod_cd"  value="">
<input type="hidden" name="dest_trns_mod_cd" id="dest_trns_mod_cd" value="">

<input type="hidden" name="oldVslCd" id="oldVslCd">
<input type="hidden" name="oldSkdVoyNo" id="oldSkdVoyNo">
<input type="hidden" name="oldSkdDirCd" id="oldSkdDirCd">
<input type="hidden" name="oldPorYdCd" id="oldPorYdCd">
<input type="hidden" name="oldPolYdCd" id="oldPolYdCd">
<input type="hidden" name="oldPodYdCd"  id="oldPodYdCd">
<input type="hidden" name="oldDelYdCd"  id="oldDelYdCd">
<input type="hidden" name="newVslCd"  id="newVslCd">
<input type="hidden" name="newSkdVoyNo" id="newSkdVoyNo">
<input type="hidden" name="newSkdDirCd" id="newSkdDirCd">
<input type="hidden" name="newPorYdCd" id="newPorYdCd">
<input type="hidden" name="newPolYdCd" id="newPolYdCd">
<input type="hidden" name="newPodYdCd" id="newPodYdCd">
<input type="hidden" name="newDelYdCd" id="newDelYdCd"> 
<input type="hidden" name="newDeTermCd" id="newDeTermCd"> 
<input type="hidden" name="confirmFlg" id="confirmFlg">

<!-- mailbody items -->
<input type="hidden" name="eml_header" id="eml_header">
<input type="hidden" name="rhnd_vvd" id="rhnd_vvd">
<input type="hidden" name="rhnd_vvd_nm" id="rhnd_vvd_nm">
<input type="hidden" name="rhnd_vvd_voyage" id="rhnd_vvd_voyage">
<input type="hidden" name="rhnd_port_cd" id="rhnd_port_cd">
<input type="hidden" name="rhnd_vvd_old_pol" id="rhnd_vvd_old_pol">
<input type="hidden" name="rhnd_vvd_old_pol_nm" id="rhnd_vvd_old_pol_nm">
<input type="hidden" name="rhnd_vvd_old_pod" id="rhnd_vvd_old_pod">
<input type="hidden" name="rhnd_vvd_old_pod_nm" id="rhnd_vvd_old_pod_nm">
<input type="hidden" name="rhnd_vvd_new_pod" id="rhnd_vvd_new_pod">
<input type="hidden" name="rhnd_vvd_new_pod_nm" id="rhnd_vvd_new_pod_nm">
<!-- CA Reason hidden -->
<input type="hidden" name="ca_rsn_cd" id="ca_rsn_cd">
<input type="hidden" name="ca_remark" id="ca_remark">

<input type="hidden" name="com_recipient" id="com_recipient">
<input type="hidden" name="com_subject" id="com_subject">
<input type="hidden" name="com_content" id="com_content">
<input type="hidden" name="carrier_cd" id="carrier_cd">
<input type="hidden" name="vsl_eng_nm" id="vsl_eng_nm">
<input type="hidden" name="ob_cssm_voy_nm" id="ob_cssm_voy_nm">
<input type="hidden" name="old_pol_full_nm" id="old_pol_full_nm">
<input type="hidden" name="old_pod_full_nm" id="old_pod_full_nm">
<input type="hidden" name="new_pod_full_nm" id="new_pod_full_nm">
<input type="hidden" name="eml_dt" id="eml_dt">
<input type="hidden" name="pic_eml" id="pic_eml">
<input type="hidden" name="btn_eml_clk" value="N">
<input type="hidden" name="old_pol">
<input type="hidden" name="old_pod">
<input type="hidden" name="new_pod">
<input type="hidden" name="cod_sts_cd">
<input type="hidden" name="company_cd">
<input type="hidden" name="cod_sts">

<input type="hidden" name="edt_ntc_knd_cd">
<input type="hidden" name="edt_bkg_no_list">
<input type="hidden" name="edt_to_eml">
<input type="hidden" name="edt_cc_eml">
<input type="hidden" name="edt_from_eml">
<input type="hidden" name="edt_subject">
<input type="hidden" name="edt_contents">
<input type="hidden" name="edt_eml_btn_flg" value="N">
<input type="hidden" name="cod_cnt" id="cod_cnt">


<% if(!mainPage.equals("true")){ %>
<div class="layer_popup_title">
<% } %>
<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<% if(!mainPage.equals("true")){ %>
			<h2 class="page_title"><span>COD Application Inquiry</span></h2>
		<% } else { %>
			<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<% } %>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn"><!--
		--><button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
		--><%if (strPopFlg.length()>0) {%><!--
		--><button type="button" class="btn1" name="btn_new"  	id="btn_new"></button><!--
		--><button type="button" class="btn1" name="btn_save" 	id="btn_save"></button><!--
		--><button type="button" class="btn1" name="btn_add" id="btn_add"></button><!--
		--><button type="button" class="btn1" name="btn_del" 	id="btn_del"></button><!--
		--><button type="button" class="btn1" name="btn_request"  	id="btn_request"></button><!--
		--><button type="button" class="btn1" name="btn_approve" 	id="btn_approve"></button><!--
		--><button type="button" class="btn1" name="btn_cancel" 	id="btn_cancel"></button><!--
		--><button type="button" class="btn1" name="btn_bkg_main"  	id="btn_bkg_main"></button><!--
		--><button type="button" class="btn1" name="btn_confirm" 	id="btn_confirm"></button><!--
		--><%}else{%><!--
		--><button type="button" class="btn_normal" name="btn_new"  	id="btn_new">New</button><!--
		--><button type="button" class="btn_normal" name="btn_save" 	id="btn_save">Save</button><!--
		--><%if (strPopFlg.length()>0){%><!--
		--><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
			<%}%><!--
		--><button type="button" class="btn_normal" name="btn_add" 	id="btn_add">Add Seq</button><!--
		--><button type="button" class="btn_normal" name="btn_del"  	id="btn_del">Delete Seq</button><!--
		--><button type="button" class="btn_normal" name="btn_Mail"  	id="btn_Mail">Email</button><!--
		--><button type="button" class="btn_normal" name="btn_request" 	id="btn_request">Request</button><!--
		--><button type="button" class="btn_normal" name="btn_approve" 	id="btn_approve">Approve(Manual)</button><!--
		--><button type="button" class="btn_normal" name="btn_cancel"  	id="btn_cancel">Cancel</button><!--
		--><button type="button" class="btn_normal" name="btn_bkg_main" 	id="btn_bkg_main">BKG Main</button><!--
		--><button type="button" class="btn_normal" name="btn_confirm" 	id="btn_confirm">Confirm</button><!--
		--><%}%> 
			<% if(!mainPage.equals("true")){ %>
			<button type="button" class="btn_normal" name="btn_close" id="btn_Close">Close</button>
			<% } %>
		</div>
		<!-- opus_design_btn(E) -->
	
		<!-- page_location(S) -->
		<div class="location">
			<!-- location 내용 동적생성 (별도 코딩 불필요) -->
			<span id="navigation"></span>
		</div>
	</div>
<% if(!mainPage.equals("true")){ %>
</div>
<% } %>
	
	
<% if(!mainPage.equals("true")){ %>
<div class="layer_popup_contents"> 
<% } %>
	<div class= "wrap_search">
		<div class= "opus_design_inquiry wFit">
			<table>
				<tbody>
					<tr>
						<th width="60">BKG No.</th>
						<td width="100"><input type="text" style="width:100px;" value="<%=strBkgNo%>" class="input1" dataformat="engup" name="bkg_no" id="bkg_no" maxlength="13">&nbsp;</td>
						<th width="60">B/L No.</th>
						<td width="100"><input type="text" style="width:100px" class="input1" dataformat="engup" name="bl_no"  value="<%=strBlNo%>" maxlength="13"></td>
						<td width="50"><input type="checkbox"  class="trans" name="bdr_flag" id="bdr_flag" disabled value="Y"><label for="bdr_flags">BDR</label></td>
						<th width="60">Sequence</th>
						<td><select style="width:57px;" name="cod_rqst_seq" id="cod_rqst_seq" ></select><!--
						--><input type="text" style="width:20px" class="input2" name="max_seq" id="max_seq"></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>

	<div class="wrap_result">
		<div class= "opus_design_inquiry">
		  <table>
				<tbody>
					<tr> 
					    <td><h3 class="title_design">COD Request Information</h3></td>
						<th width="60">Manual</th>
						<td width="40"><input type="text" style="width:35px" class="input2_red" name="cod_mnl_flg" id="cod_mnl_flg" readOnly></td>
						<th width="60">Approval</th>
						<td width="40"><input type="text" style="width:35px" class="input2_red" name="cod_auth_flg" id="cod_auth_flg" readOnly></td>
					</tr>						
				</tbody>
			</table>
		</div>
	
		<div class="opus_design_grid" id="mainTable" name="mainTable">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		
		<div class= "opus_design_inquiry wFit">
			<table>
				<tbody>
					<tr> 
						<th width="70">COD Reason</th>
						<td>
							<script type="text/javascript">ComComboObject('cod_rqst_rsn_cd', 2, 80, 1, 1);</script><!--
						 --><div style="position:relative;display:inline-block;vertical-align:top;">
								<button type="button" class="btn_etc" name="btn_remark" id="btn_remark">COD Remark(s)</button>
								<div id="codRemarkView" name="codRemarkView" style="visibility:hidden;position:absolute;overflow:hidden;width:500px; height:500px;z-index:999px;">
							   		<iframe name="codRemarkIfrm" id="codRemarkIfrm" src="/opuscntr/ESM_BKG_1009.do" width="320px" height="285px"></iframe>
								</div>
					 		</div><!--
						 --><%if (strPopFlg.length()==0) {%><button type="button" class="btn_etc" name="btn_pc" id="btn_pc">P/C</button><%}%>
						</td>
					</tr>						
				 </tbody>
			</table>
		</div>
			
		<div class="opus_design_grid clear" id="mainTable" name="mainTable">
			<script type="text/javascript">ComSheetObject('sheet2');</script>
		</div>
	
		<div class= "opus_design_inquiry wFit">
			<table>
				<tbody>
					<tr>
						<th width="80">Approval RSO</th>
						<td><script type="text/javascript">ComComboObject('rgn_cd', 2, 80, 1, 2);</script></td>
					</tr>	
				 </tbody>
			</table>
		</div>
			
		<table class="line_bluedot"><tr><td></td></tr></table>	
			
		<div class= "opus_design_inquiry">
			<table>
				<tbody>
					<tr>
						<td colspan="2"><h3 class="title_design">Freight & Charges For COD</h3></td>
					</tr>
					<tr>
						<th width="80">Re-handling Port</th>
						<td><input type="text" style="width:70px" value="" class="input1" name="cod_rhnd_port_cd" id="cod_rhnd_port_cd" dataformat="engup" maxlength="7"><!--
						--><button type="button" class="btn_etc" name="btn_calculation" id="btn_calculation">Calculation</button><!--
						--><button type="button" class="btn_etc" name="btn_Inquiry" id="btn_Inquiry">Tariff Inquiry</button></td>					
					</tr>		
				 </tbody>
			</table>
		</div>
	
		<div class="layout_wrap">
		     <div class="layout_vertical_2" style="width: 75%">
		         <!-- opus_design_grid(S) -->
		         <div class="opus_design_grid" id="mainTable" name="mainTable">
		             <script type="text/javascript">ComSheetObject('sheet3');</script>
		         </div>
		         <!-- opus_design_grid(e) -->
		     </div>
		     <div class="layout_vertical_2" style="width: 24%; float:right;">
		         <!-- opus_design_grid(S) -->
		    <div class="opus_design_grid" id="mainTable" name="mainTable">
		    	<script type="text/javascript">ComSheetObject('sheet4');</script>
		     </div>
		         <!-- opus_design_grid(e) -->
		 </div>
		 </div>
	
		<div class= "opus_design_inquiry mar_top_12">
			<table>
				<tbody>
					<tr>
						<td>* Estimated Re-handling Cost - calculation based on Stevedorage(Loading/Discharging Cost) only.</td>
					</tr>
					<tr>
						<td>Additional charges may apply based on circumstance.</td>
					</tr>
				</tbody>
			</table>
		</div>
		
		<table class="line_bluedot"><tr><td></td></tr></table>
		
		
		<div class="opus_design_inquiry wFit">
			<table>
				<tbody>
					<tr><td colspan="3"><h3 class="title_design">Request Status</h3></td></tr>
				</tbody>
			</table>
		</div>

		
		<div class="opus_design_grid clear" id="mainTable" name="mainTable">
				<script type="text/javascript">ComSheetObject('sheet5');</script>
		</div>
				
		<div class="opus_design_inquiry wFit">
			<table>
				<tbody>
					<tr>
						<th width="80">Reject Reason</th>
						<td>
							<script type="text/javascript">ComComboObject('cod_rjct_cd', 2, 560, 1, 1, 1);</script>
							<button type="button" class="btn_etc" name="btn_history" id="btn_history">History</button>
						 	<!-- memo DIV(S) -->
						 	<div style="position:relative;display:inline-block;vertical-align:top">
								<button type="button" class="btn_etc" name="btn_reject" id="btn_reject">Reject Reason Remarks</button>
								<div id="codRemarkView1" name="codRemarkView1" style="top:-285px;left:-92px;visibility:hidden;position:absolute;overflow:hidden;width:340px;height:285px;z-index:999px;">
									<iframe name="codRemarkIfrm1" id="codRemarkIfrm1" src="/opuscntr/ESM_BKG_1009.do?isPop=R" width="340px" height="285px"></iframe>
								</div>
							</div>
						 	<!-- memo DIV(E) -->
						</td>
					</tr> 
				</tbody>
			</table>
		</div>
	
		<div class="opus_design_grid" id="mainTable" name="mainTable">
				<script type="text/javascript">ComSheetObject('sheet6');</script>
				<script type="text/javascript">ComSheetObject('sheet7');</script>
				<script type="text/javascript">ComSheetObject('sheet8');</script>
				<script type="text/javascript">ComSheetObject('sheet9');</script>
				<!--  <script type="text/javascript">ComSheetObject('sheet10');</script> -->
		</div>
	</div>
<% if(!mainPage.equals("true")){ %>
</div>
<% } %>
</form>