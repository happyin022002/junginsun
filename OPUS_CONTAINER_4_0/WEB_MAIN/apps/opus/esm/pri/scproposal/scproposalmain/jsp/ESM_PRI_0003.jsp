<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved. 
*@FileName   : ESM_PRI_0003.jsp
*@FileTitle  : S/C Proposal & Amendment Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/28
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.scproposal.scproposalmain.event.EsmPri0003Event"%>
<%@ page import="com.clt.syscommon.common.table.PriSpMnVO"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@ page import="java.util.List"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="com.clt.framework.component.util.code.CodeInfo"%>
<%@ page import="com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>

<%
		EsmPri0003Event event = null; //PDTO(Data Transfer Object including Parameters)
		Exception serverException = null; //Error from Server
		String strErrMsg = ""; //Error Message
		int rowCount = 0; //Number of DB ResultSet List

		String successFlag = "";
		String codeList = "";
		String pageRows = "100";
		String condPropNo = null;
		String strUsr_id = "";
		String strUsr_nm = "";
		String strUsr_ofc = "";
		String strUsrSrepCd = "";
		String propNo = null;
		String searchFlg = null;
		Logger log = Logger.getLogger("com.clt.apps.SCProposal.SCProposalMain");
		String[] appCd = null;
		String[] appAllCd = null;
		String[] scopeCd = null;
		String[] custTpCd = null;	
		String[] lodUtCd = null;
		String[] scpStsCd = null;
		String[] ctrtDurTpCd = null;

		try {
				SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
				strUsr_id = account.getUsr_id();
				strUsr_nm = account.getUsr_nm();
				strUsr_ofc = account.getOfc_cd();
				strUsrSrepCd = account.getSrep_cd();
				event = (EsmPri0003Event) request.getAttribute("Event");

				PriSpMnVO vo = event.getPriSpMnVO();

				if (vo != null) {
						propNo = vo.getPropNo();
				} else {
						propNo = "";
				}
				serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
				condPropNo = JSPUtil.getNull(request.getParameter("cond_prop_no"));
				if (serverException != null) {
						strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
				}

				// Adding Logic extracting data from server when loading initial window ..		
		        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");		

        		appCd = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("appList"), true);
        		appAllCd = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("appAllList"), true);
        		scopeCd = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("scopeList"), true);
		        custTpCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("custTypeList"), true ,"|","\t","getCode","getName");		
	        	lodUtCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("lodUtList"), false ,"|","\t","getCode","getName");	
	        	scpStsCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("scpStsList"), false ,"|","\t","getCode","getName");	
	        	ctrtDurTpCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("ctrtDurTpList"), false ,"|","\t","getCode","getName");
		
		} catch (Exception e) {
				out.println(e.toString());
		}
%>

<head>
<title>Proposal & Amendment Creation</title>

<script type="text/javascript">
    var appCdValue = "<%=appCd[0]%>";
    var appCdText = "<%=appCd[1]%>";
    var appAllCdValue = "<%=appAllCd[0]%>";
    var appAllCdText = "<%=appAllCd[1]%>";
    var scopeCdValue = " |<%=scopeCd[0]%>";
    var scopeCdText = " |<%=scopeCd[1]%>";
    var custTpCdValue = "<%=custTpCd[0]%>";
    var custTpCdText = "<%=custTpCd[1]%>";
    var lodUtCdValue = "<%=lodUtCd[0]%>";
    var lodUtCdText = "<%=lodUtCd[1]%>";    
    var scpStsCdValue = "|<%=scpStsCd[0]%>";
    var scpStsCdText = "|<%=scpStsCd[1]%>";  
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
</head>


<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="in_usr_ofc_cd" value="<%=strUsr_ofc%>" id="in_usr_ofc_cd">
<input type="hidden" name="in_usr_srep_cd" value="<%=strUsrSrepCd%>" id="in_usr_srep_cd">
<input type="hidden" name="in_usr_nm" value="<%=strUsr_nm%>" id="in_usr_nm">
<input type="hidden" name="oti_eff_dt" id="oti_eff_dt">
<input type="hidden" name="oti_exp_dt" id="oti_exp_dt">
<input type="hidden" name="oti_amt" id="oti_amt">
<input type="hidden" name="oti_lic_no" id="oti_lic_no">
<input type="hidden" name="mst_prop_no" value="<%=propNo%>" id="mst_prop_no">
<input type="hidden" name="send_usr_nm" value="<%=strUsr_nm%>" id="send_usr_nm">
<input type="hidden" name="gw_subject" id="gw_subject">
<input type="hidden" name="gw_contents" id="gw_contents">
<input type="hidden" name="gw_template" id="gw_template">
<input type="hidden" name="gw_args" id="gw_args">
<input type="hidden" name="cond_prop_no" value="<%=condPropNo%>" id="cond_prop_no">
<input type="hidden" name="backendjob_key" id="backendjob_key">
<input type="hidden" name="job_status" id="job_status">

<input type="hidden" name="ori_sc_no" id="ori_sc_no">
<input type="hidden" name="ori_prop_no" id="ori_prop_no">

<input type="hidden" name="sale_lead_ori" id="sale_lead_ori">


<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span>S/C Proposal & Amendment Creation</span></button></h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
	    <button type="button" class="btn_normal" name="btn_cancel_file" id="btn_cancel_file" style="display:none">Cancel File</button><!-- 
		 --><button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_amend" id="btn_amend">Amend</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_request" id="btn_request">Request</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_coffer" id="btn_coffer">C/offer</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_approve" id="btn_approve">Approve</button><!--
		 --><button type="button" class="btn_normal" name="btn_scnoassign" id="btn_scnoassign">S/C No. Assign</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_file" id="btn_file">File</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_cancel" id="btn_cancel">Cancel</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_copy" id="btn_copy">Copy</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_print" id="btn_print">Print</button>
	</div>
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

		<!-- opus_design_inquiry (S) -->
		<div class="opus_design_inquiry wFit">
			<!--  biz_1  (S) -->
			<table> 	
			<colgroup>
				<col width="55px">
				<col width="35px">
				<col width="50px">
				<col width="35">
				<col width="50px">
				<col width="165px">
				<col width="250px">
				<col width="50px">
				<col width="60px">
				<col width="70px">
				<col width="50px">
				<col>
			</colgroup>
			<tr class="h23">
				<th>S/C No.</th>
				<td><input type="text" style="width: 95px; text-align: center;" name="sc_no" id="sc_no" maxlength="20" class="input" dataformat="engup"></td>
				<th>AMD No.</th>
				<td><input type="text" style="width: 40px; text-align: center;" name="amdt_seq" id="amdt_seq" readonly class="input2"></td>
				<th>Proposal No.</th>
				<td>
				<input type="text" style="width: 94px; text-align: center;" name="prop_no" id="prop_no" maxlength="10" class="input" dataformat="engup">
				<button type="button" class="btn_etc" name="btn_dur_pop" id="btn_dur_pop" style="left:30px"><img class="btn_img" name="img_dur" id="img_dur" src="img/tab_icon1.gif">Duration</button>
				</td>
										
				<td><input type="text" caption="Effective date" name="ctrt_eff_dt" id="ctrt_eff_dt" coffield="ctrt_exp_dt" maxlength="10" dataformat="ymd" style="width: 80px; text-align: center;" readonly class="input1" required><!-- 
				 	--><button type="button" name="btns_calendar1" id="btns_calendar1"  class="calendar ir"></button><!--
				  	-->~ <!-- 
				    --><input type="text" caption="Expiration date" name="ctrt_exp_dt" id="ctrt_exp_dt" cofield="ctrt_eff_dt" maxlength="10" dataformat="ymd" style="width: 80px; text-align: center;" readonly class="input1" required><!-- 
				 	--><button type="button" name="btns_calendar2" id="btns_calendar2"  class="calendar ir"></button>

				<input type="checkbox" id="rf_flg" name="rf_flg" value="" class="trans"><label for="rf_flg">Reefer</label>
				<input type="checkbox" id="gamt_flg" name="gamt_flg" value="" class="trans"><label for="gamt_flg">Garment</label></td>
				<th>Status</th>
				<td><input type="text" style="width: 65px;" name="prop_sts" id="prop_sts" readonly class="input2"><!--
					--><button type="button" class="btn_down_list" name="btn_hidden" id="btn_hidden"></button></td>
			</tr>
			</table>				
		</div>
		<table class="line_bluedot"><tr><td></td></tr></table>
			
			
		<div class="opus_design_inquiry wFit">
			<div id="subterms">
				<!--  biz_2  (S) -->
				<table>
					<colgroup>
						<col width="75px">
						<col width="50px">
						<col width="51px">
						<col width="50px">
						<col width="70px">
						<col width="50px">
						<col width="70px">
						<col width="50px">
						<col width="88px">
						<col width="90px">
						<col width="117px">
						<col>
					</colgroup>
					<tr class="h23">
						<th>Req. OFC</th>
						<td><input type="text" style="width: 72px;" id="prop_ofc_cd" name="prop_ofc_cd" dataformat="engup" readonly class="input1" caption="Request Office Code" required></td>
						<th>S. Rep.</th>
						<td><script type="text/javascript">ComComboObject('prop_srep_cd', 2, 70, 0, 1);</script><input type="text" style="width: 85px;" name="prop_srep_nm" id="prop_srep_nm" readonly class="input2"></td>
						<th>APVL OFC</th>
						<td><script type="text/javascript">ComComboObject('prop_apro_ofc_cd', 2, 67, 0, 1);</script></td>
						<th>APVL STF</th>
						<td><input type="text" style="width: 137px;" name="prop_apro_staff" id="prop_apro_staff" readonly class="input2"></td>
						<th>Creation DT</th>
						<td><input type="text" maxlength="10" dataformat="ymd" style="width: 79px;" name="cre_dt" id="cre_dt" readonly class="input2"></td>
						<th>Filed DT</th>
						<td><input type="text" maxlength="10" dataformat="ymd" style="width: 79px;" name="file_dt" id="file_dt" readonly class="input2"></td>
					</tr>
				</table>

				<table>
					<colgroup>
						<col width="90px">  <!-- customer button -->
						<col width="50px">  <!-- customer code -->
						<col width="270px"> <!-- customer name + spyglass -->
						<col width="40px">  <!-- customer type -->
						<col width="0px">   <!-- hide -->
						<col width="50px">  <!-- customer sales rep code -->
						<col width="180px"> <!-- customer sales rep name + office -->
						<col width="118px">	<!-- OTI -->	
					</colgroup>
					<tr class="h23">	
						<td><button style="width:100px" type="button" class="btn_etc" name="btn_ctrt_pty_pop" id="btn_ctrt_pty_pop"><img class="btn_img" name="img_ctrt" id="img_ctrt" src="img/tab_icon1.gif">Customer</button></td>				
						<td><input type="text" style="width: 35px;" dataformat="engup" maxlength="2" minlength="2"  name="cust_cnt_cd" id="cust_cnt_cd" readonly class="input" caption="Customer Code" required> 
						    <input type="text" style="width: 50px;" dataformat="num"    maxlength="6" 				name="cust_seq" id="cust_seq"   readonly class="input" caption="Customer Code" required>
						    <button type="button" name="btn_ctrt_cust" id="btn_ctrt_cust"  class="input_seach_btn"></button>
						 </td>						 																	 				 		
						<td><input type="text" style="width: 240px;" name="ctrt_pty_nm" id="ctrt_pty_nm" readonly class="input2">
						 	<img src="img/tab_icon1.gif" width="16" height="16" border="0" align="absmiddle" name="img_ctrt_tpy" id="img_ctrt_tpy"> 
						 	<button type="button" name="btn_ctrt_cust_tp_pop" id="btn_ctrt_cust_tp_pop"  class="input_seach_btn"></button>
						</td>																						
						<td><script type="text/javascript">ComComboObject('prc_ctrt_cust_tp_cd', 2, 37, 0, 1);</script></td>
						<td><input type="text" style="display:none;" name="ctrt_cust_val_sgm" id="ctrt_cust_val_sgm" readonly class="input2"></td>										
						<td><script type="text/javascript">ComComboObject('ctrt_cust_srep_cd', 3, 65, 0, 1);</script></td>
						<td><input type="text" style="width: 175px;" name="ctrt_cust_srep_nm" id="ctrt_cust_srep_nm" readonly class="input2">
						    <input type="text" style="width: 50px;" name="ctrt_cust_sls_ofc_cd" id="ctrt_cust_sls_ofc_cd" readonly class="input2" caption="Customer Code">
						</td>
						<th style="width: 115px;">FMC Org. (OTI) No.</th>
						<td id="oti_no_desc"> 
						 	<input type="text" style="width: 79px;" dataformat="" name="oti_no"  id="oti_no" readonly class="input2"  style="cursor:hand;" >
						 	<button type="button" name="" id="" class="input_seach_btn" onclick="window.open('http://www2.fmc.gov/oti/NVOCC.aspx', 'toolbar=no')" ></button>
						</td>														
					</tr>	
				</table>
				
				<table style="display:none;">
					<colgroup>
						<col width="90px">
						<col width="50px">
						<col width="268px">
						<col width="50px">
						<col width="100px">
						<col width="50px">
						<col>
					</colgroup>
					
					<tr class="h23">
						<th width="102" align="left">Real Customer</th>
						<td>
						<input type="text" style="width: 35px;" name="real_cust_cnt_cd" id="real_cust_cnt_cd"  dataformat="engup" maxlength="2" minlength="2"	readonly class="input"><!-- 
						--><input type="text" style="width: 50px;" name="real_cust_seq" id="real_cust_seq"	 dataformat="num"   maxlength="6" readonly class="input"><!-- 
						--><button type="button" name="btn_real_cust" id="btn_real_cust"  class="input_seach_btn"></button></td>				
						<td><input type="text" style="width: 265px;" name="real_cust_nm" id="real_cust_nm" readonly class="input2"></td>
						<td><script type="text/javascript">ComComboObject('real_cust_tp_cd', 2, 37, 0);</script></td>
						<td><input type="text" style="width: 70px;" name="real_cust_val_sgm" id="real_cust_val_sgm" readonly class="input2"><!--
							--><input type="text" style="width: 50px;" name="real_cust_sls_ofc_cd" id="real_cust_sls_ofc_cd" readonly class="input2"></td>
						<td><script type="text/javascript">ComComboObject('real_cust_srep_cd', 3, 65, 0);</script></td>
						<td><input type="text" style="width: 139px;" name="real_cust_srep_nm" id="real_cust_srep_nm" readonly class="input2"></td>
					</tr>
				</table>
				
				<table>
					<tbody>
						<tr>
							<td width="100"><button type="button" id="btn_prop_mqc_pop" name="btn_prop_mqc_pop"  class="btn_etc" style="width:100px"><img class="btn_img" name="img_mqc" id="img_mqc" src="img/tab_icon1.gif" >MQC</button></td>												
							<td width="100"><input type="text" style="width: 50px; text-align: right;" id="prop_mqc_qty" name="prop_mqc_qty" readonly class="input1" caption="MQC" required dataformat="int" maxlength="6"> <script type="text/javascript">ComComboObject('cntr_lod_ut_cd', 1, 53, 0,1);</script></td>
							<th width="70">MVC</th>
							<td width="60"><input type="text" style="width: 30px;text-align:right;" name="prop_mvc" id="prop_mvc" readonly class="input2"><!--
							--><input type="text" style="width: 30px;" name="prop_mvc_tp" id="prop_mvc_tp" readonly class="input2">
							<input type="hidden" id="conv_cfm_flg" name="conv_cfm_flg" value=""><label for="conv_cfm_flg" style="display:none">Conversion update</label></td>
							<td width="90">&nbsp;<input type="checkbox" id="prxy_flg" name="prxy_flg" value="" class="trans">&nbsp;Proxy</td>
							<td width="241"></td>											
							<td width="100"><button type="button" name="btn_blpl_pop" id="btn_blpl_pop" class="btn_etc"><img class="btn_img" name="img_blpl" id="img_blpl" src="img/tab_icon1.gif">Boiler Plate</button></td>
							<td width="100"><button type="button" name="btn_afil_pop" id="btn_afil_pop" class="btn_etc"><img class="btn_img" name="img_affil" id="img_affil" src="img/tab_icon1.gif">Affiliate</button></td>
						    <th width="100">Contract Type</th>
						    <td><script type="text/javascript">ComComboObject('ctrt_dur_tp_cd', 0, 80, 0, 0);</script></td>
						</tr>	
					</tbody>			
				</table>				
			</div>
		</div>
		<!-- opus_design_inquiry (E) -->
		
		<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
		<div class="opus_design_btn">
		<!-- Content -->
			<button type="button" class="btn_normal" name="btn_rowadd" id="btn_rowadd">Row Add</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_delete" id="btn_delete">Delete</button>		
		</div>	
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
	<!-- opus_design_grid(E) -->
</div>
<!-- wrap_search(E) -->




<!-- wrap_result(S) -->
<div class="wrap_result">

	<!-- opus_design_tab(S) -->
	<div class="opus_design_tab">
		<script type="text/javascript"> ComTabObject('tab1')</script>
	</div>
	<!-- opus_design_tab(E) -->	
	
	<!-- iFrame (S) -->
	<div id="tabLayer" style="display: none">
		<iframe name="t1frame" id="t1frame" frameborder="0" scrolling="no" width="100%" height="380" src="about:blank"></iframe></div>
	<div id="tabLayer" style="display: none">
		<iframe name="t2frame" id="t2frame" frameborder="0" scrolling="no" width="100%" height="380" src="about:blank"></iframe></div>
	<div id="tabLayer" style="display: none">
		<iframe name="t3frame" id="t3frame" frameborder="0" scrolling="no" width="100%" height="380" src="about:blank"></iframe></div>
	<div id="tabLayer" style="display: none">
		<iframe name="t4frame" id="t4frame" frameborder="0" scrolling="no" width="100%" height="550" src="about:blank"></iframe></div>
	<div id="tabLayer" style="display: none">
		<iframe name="t5frame" id="t5frame" frameborder="0" scrolling="no" width="100%" height="730" src="about:blank"></iframe></div>
	<div id="tabLayer" style="display: none">
		<iframe name="t6frame" id="t6frame" frameborder="0" scrolling="no" width="100%" height="400" src="about:blank"></iframe></div>
	<div id="tabLayer" style="display: none">
		<iframe name="t7frame" id="t7frame" frameborder="0" scrolling="no" width="100%" height="450" src="about:blank"></iframe></div>
	<div id="tabLayer" style="display: none">
		<iframe name="t8frame" id="t8frame" frameborder="0" scrolling="no" width="100%" height="380" src="about:blank"></iframe></div>
	<div id="tabLayer" style="display: none">
		<iframe name="t9frame" id="t9frame" frameborder="0" scrolling="no" width="100%" height="380" src="about:blank"></iframe></div>
	<div id="tabLayer" style="display: none">
		<iframe name="t10frame" id="t10frame" frameborder="0" scrolling="no" width="100%" height="380" src="about:blank"></iframe></div>
	<!-- iFrame (E) -->
	
</div>
<!-- wrap_result(E) -->

<div id="confirmDialog"  title="ConfirmDialog" style="display: none">
	 <p>Do you want to download full version for filing new format?</p>
</div>

</form>