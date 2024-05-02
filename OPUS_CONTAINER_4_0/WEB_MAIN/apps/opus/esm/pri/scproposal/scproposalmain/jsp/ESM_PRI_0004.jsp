<%/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0004.jsp
*@FileTitle  :  Proposal & Amendment Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.scproposal.scproposalmain.event.EsmPri0004Event"%>
<%@ page import="com.clt.syscommon.common.table.PriSpMnVO"%>
<%@ page import="com.clt.framework.component.util.code.CodeInfo"%>
<%@ page import="com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="java.util.List"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List"%>

<%
	EsmPri0004Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;         //error from server
	String strErrMsg = ""; //error message
	int rowCount = 0; //count of DB resultSET list
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_ofc		= "";
	String strUsrSrepCd     = "";
    String propNo = null;
    String searchFlg = null;
	Logger log = Logger.getLogger("com.clt.apps.SCProposal.SCProposalMain");
	String[] appList = null;
	String[] preList = null;
	String[] mqcSignList = null;
	String[] scTypeList = null;
	String[] stsTypeList = null;
	String[] saleRepList = null;
	String[] custTpCd = null;
    // Parameter passed to 0060	
    String scNoP = "";
    String scNoS = "";
    String sPropNo = "";
    String expDt = "";
    String effDt = "";
    
    try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_ofc = account.getOfc_cd();
		strUsrSrepCd = account.getSrep_cd();
		event = (EsmPri0004Event)request.getAttribute("Event");
        
		PriSpMnVO vo = event.getPriSpMnVO();
        
        if (vo != null) {
            propNo = vo.getPropNo();
        } else {
            propNo = "";
        }
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
	    // Parameters passed from esm_bkg_0427  
	    scNoP = JSPUtil.getNull(request.getParameter("sc_no_p"));
	    scNoS = JSPUtil.getNull(request.getParameter("sc_no_s"));
	    sPropNo = JSPUtil.getNull(request.getParameter("sprop_no"));
	    expDt = JSPUtil.getNull(request.getParameter("exp_dt"));
	    effDt = JSPUtil.getNull(request.getParameter("eff_dt"));
		 
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		appList = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("appList"), true);
		preList = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("preList"), true);
		mqcSignList = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("mqcSignList"), true ,"|","\t","getCode","getName");		
		scTypeList = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("scTypeList"), false ,"|","\t","getCode","getName");	
		stsTypeList = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("stsTypeList"), false ,"|","\t","getCode","getName");	
       
		custTpCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("custTypeList"), true ,"|","\t","getCode","getName");	
		saleRepList = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("saleRepList"), true);          
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script type="text/javascript">

    var appListValue = " |<%=appList[0]%>";
    var appListText = " |<%=appList[1]%>";
    var preListValue = " |<%=preList[0]%>";
    var preListText = " |<%=preList[1]%>";
    var mqcSignListValue = " |<%=mqcSignList[0]%>";
    var mqcSignListText = " |<%=mqcSignList[1]%>";
    var scTypeListValue = " |<%=scTypeList[0]%>";
    var scTypeListText = " |<%=scTypeList[1]%>";    
    var stsTypeListValue = " |<%=stsTypeList[0]%>";
    var stsTypeListText = " |<%=stsTypeList[1]%>";    
     
    var saleListValue = " |<%=saleRepList[0]%>";
    var saleListText = " |<%=saleRepList[1]%>";        
    var custTpCdValue = "<%=custTpCd[0]%>";
    var custTpCdText = "<%=custTpCd[1]%>";
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

<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="in_usr_ofc_cd" value="<%=strUsr_ofc%>" id="in_usr_ofc_cd" />
<input type="hidden" name="in_usr_srep_cd" value="<%=strUsrSrepCd%>" id="in_usr_srep_cd" />
<input type="hidden" name="in_usr_nm" value="<%=strUsr_nm%>" id="in_usr_nm" />
<input type="hidden" name="oti_eff_dt" id="oti_eff_dt" />
<input type="hidden" name="oti_exp_dt" id="oti_exp_dt" />
<input type="hidden" name="oti_amt" id="oti_amt" />
<input type="hidden" name="mst_prop_no" value="<%=propNo %>" id="mst_prop_no" />
<input type="hidden" name="send_usr_nm" value="<%=strUsr_nm%>" id="send_usr_nm" />
<input type="hidden" name="gw_subject" id="gw_subject" />
<input type="hidden" name="gw_contents" id="gw_contents" />
<input type="hidden" name="gw_template" id="gw_template" />
<input type="hidden" name="gw_args" id="gw_args" />
<input type="hidden" name="ssc_no" id="ssc_no" />
<input type="hidden" name="smqc_sign_nm" id="smqc_sign_nm" />

<input type="hidden" name="sc_no_p" value="<%=scNoP%>" id="sc_no_p" />
<input type="hidden" name="sc_no_s" value="<%=scNoS%>" id="sc_no_s" />
<input type="hidden" name="exp_dt" value="<%=expDt%>" id="exp_dt" />
<input type="hidden" name="eff_dt" value="<%=effDt%>" id="eff_dt" />

<input type="hidden" name="backendjob_key" id="backendjob_key" />
<input type="hidden" name="job_status" id="job_status" />
<%String mainPage = JSPUtil.getNull(request.getParameter("mainPage"));%>

<!-- Popup for BKG-->
<% if("false".equals(mainPage)){  %> 
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>S/C Proposal & Amendment Inquiry</span></h2>
		<div class="opus_design_btn"><!-- 
			--><button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve" >Retrieve</button><!-- 
			--><button type="button" class="btn_normal" name="btn_new" id="btn_new" >New</button><!--
			--><button type="button" class="btn_normal" name="btn_proposal" id="btn_proposal" >Open Proposal</button><!--
			--><button type="button" class="btn_normal" name="btn_history" id="btn_history" >AMD History</button><!-- 
			--><button type="button" class="btn_normal" name="btn_Close" 	id="btn_Close" onclick="ComClosePopup()">Close</button>
		</div>
	</div>
</div>

<!-- Main -->	
<% } else { %>
	<div class="page_title_area clear">
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<div class="opus_design_btn"><!-- 
			--><button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve" >Retrieve</button><!-- 
			--><button type="button" class="btn_normal" name="btn_new" id="btn_new" >New</button><!--
			--><button type="button" class="btn_normal" name="btn_proposal" id="btn_proposal" >Open Proposal</button><!--
			--><button type="button" class="btn_normal" name="btn_history" id="btn_history" >AMD History</button>
		</div>
		<div class="location">	
			<span id="navigation"></span>
		</div>
	</div>
<% } %>

<% if("false".equals(mainPage)){  %> 
<div class="layer_popup_contents">
<% } %>
<div class="wrap_search">
	<div class="opus_design_inquiry wFit">
		<table>
		<colgroup>
          <col width="90" />
          <col width="150" />
          <col width="50" />
          <col width="50" />
          <col width="130" />
          <col width="120" />
          <col width="50" />
          <col width="50" />
          <col width="50" />
          <col width="70" />
          <col width="*" />
        </colgroup>
		
			<tbody>
				<tr>
					<th>S/C No.</th>
					<td><input type="text" style="width:113px;text-align:center;" class="input" name="ssc_no2" dataformat="engup" maxlength="9">
					</td>
					<th>Proposal No.</th>
					<td colspan="2"><input type="text" style="width:145px;text-align:center;" class="input" name="sprop_no" dataformat="engup" maxlength="10" value="<%=sPropNo%>"></td>
					
					<th>S/C EFF Date</th>
					<td colspan="3"><!-- 
						 --><span class="inquiry_calendar"><!-- 
                               --><input type="text" class="input" name="seff_dt1" maxlength="10" dataformat="ymd"  style="width:75px"><!-- 
                               --><button type="button" class="calendar ir" name="btns_calendar1" id="btns_calendar1"></button>- <!-- 
                               --><input type="text" class="input" name="seff_dt2" maxlength="10" dataformat="ymd"  style="width:75px"><!-- 
                               --><button type="button" class="calendar ir" name="btns_calendar2" id="btns_calendar2"></button><!-- 
                           --></span><!-- 
                     --></td>
                     
					<th>Status</th>
					<td><script type="text/javascript">ComComboObject('sprop_sts_cd', 1, 88, 0, 0);</script></td>
				</tr>
				<tr class="h23">
					<th>Request Office</th>
					<td><input type="text" style="width:113px;text-align:center;" class="input" name="sprop_ofc_cd" dataformat="enguponly"></td>
					
					<th>Sales Rep.</th>
					<td colspan="2">
			   		   <script type="text/javascript">ComComboObject('sprop_srep_cd', 2, 73, 0, 0);</script><!-- 
			   		   --><input type="text"  style="width:148px;" class="input2" name="sprop_srep_nm" readonly>
					</td>					
					
					
					<th>Approval Office</th>
					<td><script type="text/javascript">ComComboObject('sprop_apro_ofc_cd', 2, 75, 0, 0);</script></td>
					
					<th>MQC</th>
					<td><script type="text/javascript">ComComboObject('smqc_sign_cd', 1, 47, 0, 0);</script><input type="text" style="width:80px;text-align:right;" class="input" name="sprop_mqc_qty" dataformat="int"></td>
					
					<th>S/C Type</th>
					<td><script type="text/javascript">ComComboObject('ssc_type_cd', 1, 88, 0, 0);</script></td>
				</tr>
				<tr class="h23">
					<th>Customer</th>
					<td><input type="text" style="width:25px;" class="input" name="scust_cnt_cd" dataformat="enguponly" maxlength="2" minlength="2"><input type="text" style="width:55px;" class="input" name="scust_seq" dataformat="num" maxlength="6"><button type="button" class="input_seach_btn" name="btn_ctrt_cust" id="btn_ctrt_cust"></button></td>
					<td colspan="3" ><input type="text" style="width:305px;" class="input2" name="sctrt_pty_nm" readonly></td>

					<th>Customer Type</th>
					<td colspan="5"><script type="text/javascript">ComComboObject('sprc_ctrt_cust_tp_cd', 2, 75, 0, 0);</script></td>
				</tr>			
			</tbody>
		</table>
	</div>
</div>
<div class="wrap_result" style="min-width:1012px;">
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet0');</script>
	</div>
	
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	
	<div class="opus_design_inquiry wFit">
		
		
		<div id="subterms">
		<table>
		 <colgroup>
             <col width="100" />
             <col width="110" />
             <col width="60" />
             <col width="100" />
             <col width="70" />
             <col width="100" />
             <col width="70" />
             <col width="100" />
             <col width="100" />
             <col width="100" />
             <col width="125" />
             <col width="*" />                                                                                                                                                            
          </colgroup>
			<tbody>
			    <tr class="h23">
					<th>S/C  No.</th>
					<td><input type="text" style="width:90px;text-align:center;" class="input2" name="sc_no" readonly></td>
					
					<th>AMD No.</th>
					<td><input type="text" style="width:45px;text-align:center;" class="input2" name="amdt_seq" readonly></td>
					
					<th>Proposal No.</th>
					<td><input type="text" style="width:85px;text-align:center;" class="input2" name="prop_no" readonly></td>
					
					<th>Duration</th>
					<td><input type="text" style="width:75px;text-align:center;" class="input2" name="ctrt_eff_dt" readonly>&nbsp;~&nbsp;<input type="text" style="width:75px;text-align:center;" class="input2" name="ctrt_exp_dt" readonly></td>
					
					<th><input type="checkbox" value="" class="trans" name="rf_flg" id="CHK01"><label id="CHK01">Reefer</label></th>
					<th><input type="checkbox" value="" class="trans" name="gamt_flg" id="CHK02"><label id="CHK02">Garment</label></th>
					
					<th>Status</th>
					<td><input type="text" style="width:65px;" class="input2" name="prop_sts" readonly><button type="button" class="btn_down" name="btn_hidden" id="btn_hidden"></button></td>
				</tr>
				<tr class="h23">
					<th>Req. OFC</th>
					<td><input type="text" style="width:90px; text-align: center;" class="input2" name="prop_ofc_cd" readonly></td>
					
					<th>S. Rep.</th>
					<td><input type="text" style="width:45px; text-align: center;" class="input2" name="prop_srep_cd" readonly><input type="text" style="width:96px;" class="input2" name="prop_srep_nm" readonly></td>
					
					<th>APVL OFC</th>
					<td><input type="text" style="width:85px; text-align: center;" class="input2" name="prop_apro_ofc_cd" readonly></td>
					
					<th>APVL STF</th>
					<td><input type="text" style="width:171px;" class="input2" name="prop_apro_staff" readonly></td>
					
					<th>Creation DT</th>
					<td><input type="text" style="width:88px; text-align: center;" class="input2" name="cre_dt" readonly></td>
					
					<th>Filed DT</th>
					<td><input type="text" style="width:93px; text-align: center;" class="input2" name="file_dt" readonly></td>
				</tr>
				<tr class="h23">
					<th><button type="button" class="btn_etc" name="btn_ctrt_pty_pop" id="btn_ctrt_pty_pop" style="width:90px;text-align:center;"><img class='btn_img'  src='img/tab_icon1.gif'>Customer</button></th>
					<td colspan="6"><!-- 
						 --><input type="text" style="width:5%; text-align: center;" class="input2" name="cust_cnt_cd" readonly><!-- 
						 --><input type="text" style="width:10.5%; text-align: center;" class="input2" name="cust_seq" readonly><!-- 
						 --><input type="text" style="width:75%;" class="input2" name="ctrt_pty_nm" readonly><!-- 
						 --><input type="text" style="width:6%;text-align: center;" class="input2" name="prc_ctrt_cust_tp_cd" readonly><!-- 
					 --><input type="hidden" style="width:90%;" class="input2" name="ctrt_cust_val_sgm" readonly><!-- 
					 --></td>
					<td colspan="3"><!-- 
						 --><input type="text" style="width:18%; text-align: center;" class="input2" name="ctrt_cust_srep_cd" readonly><!-- 
						 --><input type="text" style="width:60%;" class="input2" name="ctrt_cust_srep_nm" readonly><!-- 
						 --><input type="text" style="width:18%; text-align: center;" class="input2" name="ctrt_cust_sls_ofc_cd" readonly><!-- 
						 --></td>
					<th>FMC Org. (OTI) No.</th>
					<td><input type="text" style="width:95%;" class="input2" name="oti_no" id="oti_no" readonly></td>
				</tr>
				<tr class="h23" style="display:none;">
					<th>Real Customer</th>
					<td colspan="5">
						<input type="text" style="width:5%;" class="input2" name="real_cust_cnt_cd" readonly>
						<input type="text" style="width:10%;" class="input2" name="real_cust_seq" readonly>
						<input type="text" style="width:75%;" class="input2" name="real_cust_nm" readonly>
						<input type="text" style="width:6%;text-align: center;" class="input2" name="real_cust_tp_cd" readonly>
					</td>
					<td><input type="text" style="width:90%;" class="input2" name="real_cust_val_sgm" readonly></td>
					<td colspan="3">
						<input type="text" style="width:18%;" class="input2" name="real_cust_sls_ofc_cd" readonly>
						<input type="text" style="width:18%;" class="input2" name="real_cust_srep_cd" readonly>
						<input type="text" style="width:60%;" class="input2" name="real_cust_srep_nm" readonly>
					</td>
				</tr> 
				<tr class="h23">
					<th>MQC</th>
					<td><input type="text" style="width:45px;text-align:right;" class="input2" name="prop_mqc_qty" readonly dataformat="int"><!-- 
						 --><input type="text" style="width:40px; text-align:center;" class="input2" name="cntr_lod_ut_cd" readonly></td>
					<th>MVC</th>
					<td><input type="text" style="width:45px;text-align:right;" class="input2" name="prop_mvc" readonly dataformat="int"><input type="text" style="width:40px; text-align:center;" class="input2" name="prop_mvc_tp" readonly></td>
					<td>&nbsp;<input type="checkbox" id="prxy_flg" name="prxy_flg" value="" class="trans" disabled>&nbsp;Proxy</td>
					<td colspan="8" class="align_right"><button type="button" class="btn_etc" name="btn_blpl_pop" id="btn_blpl_pop" style="width:100px;text-align:center;"><img class="btn_img"  src='img/tab_icon1.gif'>Boiler Plate</button><button type="button" class="btn_etc" name="btn_afil_pop" id="btn_afil_pop" style="width:100px;text-align:center;"><img class='btn_img'  src='img/tab_icon1.gif'>Affiliate</button></td>
				</tr>
			</tbody>
		</table>
		</div>
		
	</div>
	
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>				


	<div class="opus_design_tab">
		<script >ComTabObject('tab1')</script>
	</div>


			<!-- iFrame (S) -->
			<div id="tabLayer" style="display:none">
			<iframe name="t1frame" id="t1frame" frameborder="0" scrolling="no" width="100%" height="380" src="about:blank"></iframe>
			</div>
            <div id="tabLayer" style="display:none">
            <iframe name="t2frame" id="t2frame" frameborder="0" scrolling="no" width="100%" height="380" src="about:blank"></iframe>
            </div>
            <div id="tabLayer" style="display:none">
            <iframe name="t3frame" id="t3frame" frameborder="0" scrolling="no" width="100%" height="380" src="about:blank"></iframe>
            </div>
            <div id="tabLayer" style="display:none">
            <iframe name="t4frame" id="t4frame" frameborder="0" scrolling="no" width="100%" height="380" src="about:blank"></iframe>
            </div>
            <div id="tabLayer" style="display:none">
            <iframe name="t5frame" id="t5frame" frameborder="0" scrolling="no" width="100%" height="720" src="about:blank"></iframe>
            </div>
            <div id="tabLayer" style="display:none">
            <iframe name="t6frame" id="t6frame" frameborder="0" scrolling="no" width="100%" height="380" src="about:blank"></iframe>
            </div>
            <div id="tabLayer" style="display:none">
            <iframe name="t7frame" id="t7frame" frameborder="0" scrolling="no" width="100%" height="380" src="about:blank"></iframe>
            </div>
            <div id="tabLayer" style="display:none">
            <iframe name="t8frame" id="t8frame" frameborder="0" scrolling="no" width="100%" height="380" src="about:blank"></iframe>
            </div>
            <div id="tabLayer" style="display:none">
            <iframe name="t9frame" id="t9frame" frameborder="0" scrolling="no" width="100%" height="380" src="about:blank"></iframe>
            </div>
            <div id="tabLayer" style="display:none">
            <iframe name="t10frame" id="t10frame" frameborder="0" scrolling="no" width="100%" height="380" src="about:blank"></iframe>
            </div>                                    
			<!-- iFrame (E) -->

</div>

<% if("false".equals(mainPage)){  %> 
</div>
<% } %>
 
</form>