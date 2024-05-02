<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : BCM_CCD_0032.jsp
*@FileTitle  : Organization 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.bcm.ccd.commoncode.organization.event.BcmCcd0032Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	BcmCcd0032Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Error from server
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//Count of DB resultSet list
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.commoncode.organization");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (BcmCcd0032Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	} catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	var G_MDAA_CHK;
	var G_AHTU_TP_CD;
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
<body  onLoad="setupPage();">
<form name="form" id="form">
<input id="f_cmd" name="f_cmd" type="hidden" />
<input id="pagerows" name="pagerows" type="hidden" />
<input id="hidden_ofc_cd" name="hidden_ofc_cd" value="" type="hidden" />
<input id="mdm_yn" name="mdm_yn" value="Y" type="hidden" />
<input id="old_modi_ofc_cd" name="old_modi_ofc_cd" value="" type="hidden" />
<input id="edi_if_flg" name="edi_if_flg" value="" type="hidden" />
<input id="ibflag" name="ibflag" type="hidden" />
<input type="hidden" name="onchange_flag" id="onchange_flag" />
<input type="hidden" name="vndr_cnt_cd" id="vndr_cnt_cd" />
<input type="hidden" name="vndr_seq" id="vndr_seq" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
  	<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
   	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation">Vessel Particular</span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
	</table>
</div>
<!-- page_title_area(E) -->

<!--biz page (S)-->
<table class="search">
	<tr>
	<td class="bg">
	 <!--  biz_1  (S) -->
            <table class="search" border="0" style="width:979">
              <tr class="h23">
               <td>
				<table class="search" border="0" style="width: 979">
					<tr class="h23">
						<td width ="130" style="text-align: right"">Office Code</td>
						<td width ="180"><input id="ofc_cd" style="width: 80px; ime-mode:disabled; text-align:center;" class="input1" value="" name="ofc_cd" maxlength="6" dataformat="engup" type="text" />
						<img src="img/btns_search.gif" name="btn_com_ens_071_ofc_cd" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
						<td width ="95" style="text-align: right">Legacy Code</td>
		                <td width ="140"><input type="text" style="width:120" class="input1" dataformat="engup" name="modi_ofc_cd" id="modi_ofc_cd" maxlength="30"></td>
		                <td width ="130" style="text-align: right">English Name</td>
						<td width =""><input id="ofc_eng_nm" style="width: 300px; ime-mode:disabled; text-align:left;" class="input1" value="" name="ofc_eng_nm" maxlength="50" dataformat="engupspace" otherchar="()_\-,. " type="text"/> </td>
		                   
<!-- 컬럼 없음				<td  width ="150" style="text-align: right">Sakura CTR Code</td>
		                   <td><input type="text" style="width:120" class="input1" dataformat="engup" name="modi_cost_ctr_cd" id="modi_cost_ctr_cd" maxlength="30"></td>
						<td width ="150" style="text-align: right">Sakura Agent Code</td>
		                   <td><input type="text" style="width:90" class="input1" dataformat="engup" name="modi_agn_cd" id="modi_agn_cd" maxlength="30"></td> -->
					</tr>
				</table>
<!-- 				<table class="search" border="0" style="width: 1100">
					<tr class="h23">
						<td width ="130" style="text-align: right">English Name</td>
						<td width =""><input id="ofc_eng_nm" style="width: 180px; ime-mode:disabled; text-align:left;" class="input1" value="" name="ofc_eng_nm" maxlength="50" dataformat="engup" otherchar="()_\-,. " type="text"/> </td>
 --><!--컬럼없음 						<td width ="95" style="text-align: right">Local Name</td>
						<td><input id="ofc_locl_nm" style="width: 430px; text-align:left;" class="input" value="" name="ofc_locl_nm" maxlength="50" type="text" /> </td> -->
						
<!-- 					</tr>
				</table> -->
		    <table class="search" border="0" style="width:979;"> 
				<tr class="h23">
			    		<td width="130" style="text-align: right">Phone #</td>
		    		<!-- <td><input id="intl_phn_no" style="width: 30px;" class="input" value="" name="intl_phn_no" maxlength="4" type="text" /></td> -->
<!-- 		    		<td width="20" >
					<script type="text/javascript" class="input1">ComComboObject('intl_phn_no', 2, 50, 1,1, true)</script>
					</td> -->
		    		
		    		<td><input id="ofc_phn_no" style="width: 135px;" class="input1" value="" name="ofc_phn_no" maxlength="20" type="text"  dataformat="saupja"/></td>
		    		<td width="65" style="text-align: right">Fax #</td>
<!-- 		    		<td width="20" >
					<script type="text/javascript">ComComboObject('intl_fax_no', 2, 50, true, '')</script>
					</td> -->
		    		<!-- <td><input id="intl_fax_no" style="width: 30px;" class="input" value="" name="intl_fax_no" maxlength="4" type="text" /></td> -->
		    		<td><input id="ofc_fax_no" style="width: 135px;" class="input" value="" name="ofc_fax_no" maxlength="20" type="text" dataformat="saupja"/></td>
		    		<td width="65" style="text-align: right">Email</td>
		    		<td><input id="ofc_rep_eml" style="width: 150px;" class="input" value="" name="ofc_rep_eml" maxlength="50" type="text" /></td>
		    		<td width="55" style="text-align: right">URL</td>
		    		<td><input id="ofc_url" style="width: 230px;" class="input" value="" name="ofc_url" maxlength="50" type="text" /></td>
	   			    </tr>
					<tr class="line_bluedot"><td colspan="8"></td></tr>
				</table>
				<table class="search" border="0" style="width: 1100">
					<tr class="h23">
					    <td width ="125" style="text-align: right">ZIP Code</td>
						<td colspan="7"><input id="ofc_zip_cd" style="width: 100px; text-align:left;" class="input" value="" name="ofc_zip_cd" maxlength="10" type="text" /> </td>
					</tr>
				</table>
				<table class="search" border="0" style="width: 1100">
					<tr class="h23">
						<td width ="125" style="text-align: right">Address</td>
						<td width ="350"><input id="ofc_addr" style="width: 300px; text-align:left;" class="input1" value="" name="ofc_addr" maxlength="200" type="text" /> </td>
						<td width ="125" style="text-align: right">Local Address</td>
						<td colspan="3"><input id="ofc_locl_lang_addr" style="width:300px; text-align:left;" class="input" value="" name="ofc_locl_lang_addr" maxlength="200" type="text" /></td>
					</tr>
					<tr class="line_bluedot"><td colspan="8"></td></tr>	
				</table>
				<table class="search" border="0" style="width: 1100">	
					<tr class="h23">
						<td width ="155" style="text-align: right">Office Type</td>
						<td width ="110"><script type="text/javascript">ComComboObject('ofc_tp_cd', 2, 110, 1, 1 ,0 ,false)</script></td>
						<td width ="130" style="text-align: right">Office Kind</td>
						<td width ="110"><script type="text/javascript">ComComboObject('ofc_knd_cd', 2, 110, 1, 1 ,1 ,false)</script></td>
						<td  width ="200" style="text-align: right">Inactive Sales Org.</td>
						<td><script type="text/javascript">ComComboObject('ofc_sls_delt_flg', 1, 50, 1, 0 ,0 ,false)</script></td>

					</tr>
				</table>
				<table class="search" border="0" style="width: 1100">	
					<tr class="h23">
						<td width ="155" style="text-align: right">Parent Office</td>
						<td width ="110"><input id="prnt_ofc_cd" style="width: 80px; ime-mode:disabled; text-align:center;" class="input" value="" name="prnt_ofc_cd" maxlength="6" dataformat="engup" type="text" />
						<img src="img/btns_search.gif" name="btn_com_ens_071_prnt_ofc_cd" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
						<td  width ="130" style="text-align: right">Location Code</td>
						<td width ="110" ><input id="loc_cd" style="width: 80px; ime-mode:disabled; text-align:center;" class="input1" value="" name="loc_cd" maxlength="5" dataformat="engup" type="text" />
						<img src="img/btns_search.gif" name="btn_com_ens_051_loc_cd" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
						<td  width ="200" style="text-align: right">Non-Use in BKG/DOC</td>
						<td><script type="text/javascript">ComComboObject('doc_rcvr_hide_flg', 1, 50, 1, 0 ,0 ,false)</script></td>
					</tr>
				</table>
				<table class="search" border="0" style="width: 979">
					<tr class="h23">
						<td width ="155" style="text-align: right">Open Date</td>
						<td width ="120"><input id="opn_dt" style="width: 80px;" class="input" value="" name="opn_dt" dataformat="ymd" maxlength="10" type="text" />
						<img src="img/btns_calendar.gif" name="btn_opn_dt_cal" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
						<td  width ="120" style="text-align: right">Close Date</td>
						<td width ="110"><input id="clz_dt" style="width: 80px;" class="input" value="" name="clz_dt" dataformat="ymd" maxlength="10" type="text" />
						<img src="img/btns_calendar.gif" name="btn_clz_dt_cal" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
						<td  width ="200" style="text-align: right">Non-Use in SPC CTRL</td>
						<td><script type="text/javascript">ComComboObject('ofc_rfa_sc_use_flg', 1, 50, 1, 0 ,0 ,false)</script></td>
					</tr>
				</table>
				<table class="search" border="0" style="width: 1100">	
					<tr class="h23">
						<td  width ="155" style="text-align: right">Subsidiary Company Flag</td>
						<td width ="120"><script type="text/javascript">ComComboObject('subs_co_flg', 1, 50, 1, 0 ,0 ,false)</script></td>
						<td width ="115" style="text-align: right">ALPS Security DIV</td>
						<td width ="110"><script type="text/javascript">ComComboObject('sls_ofc_div_cd', 2, 110, 1, 1 ,0 ,false)</script></td>
						<td  width ="205" style="text-align: right">Non-Use in Logistic</td>
						<td><script type="text/javascript">ComComboObject('finc_hide_flg', 1, 50, 1, 0 ,0 ,false)</script></td>
					</tr>
				</table>	
				<table class="search" border="0" style="width: 1100">	
					<tr class="h23">
					    <td  width ="155" style="text-align: right">Agent Type</td>
						<td width ="120"><script type="text/javascript">ComComboObject('agn_knd_cd', 2, 120, 1,0 ,1 ,false)</script></td>
						<td  width ="190" style="text-align: right">Communication Code(G/W)</td>
						<td width ="100"><input id="ofc_cmmc_cd" style="width: 100px; text-align:center;" class="input" value="" name="ofc_cmmc_cd" maxlength="6" dataformat="excepthan" type="text" /> </td>
						<td  width ="140" style="text-align: right">Pseudo Code(TAX/GL)</td>
						<td><script type="text/javascript">ComComboObject('finc_psdo_ofc_flg', 1, 50, 1, 0 ,0 ,false)</script></td>
					</tr>
				</table>
				<table class="search" border="0" style="width: 1100">
					<tr class="h23">	
						<td width ="155" style="text-align: right">No of Employee</td>
						<td width ="100"><input id="ofc_pson_knt" style="width: 100px; text-align:left;" class="input" value="" name="ofc_pson_knt" maxlength="5" type="text" dataformat="int"/></td>
						<td width ="138" style="text-align: right">Fax IP Address</td>
						<td><input id="fax_ip" style="width: 100px; text-align:left;" class="input" value="" name="fax_ip" maxlength="20" type="text"/></td>
					</tr>
				</table>
				<table class="search" border="0" style="width: 1100">
					<tr class="h23">
						<td width ="155" style="text-align: right">Remark</td>
						<td colspan="7"><input id="ofc_rmk" style="width: 800; text-align:left;" class="input" value="" name="ofc_rmk" maxlength="100" type="text" /></td>
					</tr>
				<tr class="line_bluedot"><td colspan="8"></td></tr>
				</table>
				<table class="search" border="0" style="width: 1100">
					<tr class="h23">
						<td width ="165" style="text-align: right">A/R Office</td>
						<td width ="133"><input id="ar_ofc_cd" style="width: 80px; ime-mode:disabled;text-align:center;" class="input" value="" name="ar_ofc_cd" maxlength="6" dataformat="engup" type="text" />
						<img src="img/btns_search.gif" name="btn_com_ens_071_ar_ofc_cd" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
					 	<td  width ="170" style="text-align: right">A/R Regional HQ</td>
						<td width ="180"><input id="ar_hd_qtr_ofc_cd" style="width: 80px; ime-mode:disabled; text-align:center;" class="input1" value="" name="ar_hd_qtr_ofc_cd" maxlength="6" dataformat="engup" type="text" />
						<img src="img/btns_search.gif" name="btn_com_ens_071_ar_hd_qtr_ofc_cd" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
						<!-- <script type="text/javascript">ComComboObject('ar_hd_qtr_ofc_cd', 1, 110, 1, 1 ,0 ,false)</script> -->
						<td  width ="173" style="text-align: right">A/R Center Code</td>
						<td><input id="ar_ctr_cd" style="width: 105px; ime-mode:disabled;text-align:center;" class="input" value="" name="ar_ctr_cd" maxlength="6" dataformat="int" type="text" />
						<!-- <img src="img/btns_search.gif" name="btn_ar_ctr_cd" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"> --></td>
					</tr>
				</table>
				<table class="search" border="0" style="width: 1100">	
					<tr class="h23">
						<td width ="165" style="text-align: right">Finance Region</td>
						<td width ="120"><script type="text/javascript">ComComboObject('finc_rgn_cd', 2, 130, 1, 0 ,0 ,false)</script>
						<!-- <input id="finc_rgn_cd" style="width: 109px; text-align:center;" class="input" value="" name="finc_rgn_cd" maxlength="2" type="text" /> --> 
						</td>
						<td  width ="172" style="text-align: right">O/B Credit Term (Days)</td>
						<td width ="115"><input id="ob_cr_term_dys" style="width: 80px; text-align:right;" class="input" value="" name="ob_cr_term_dys" maxlength="3" dataformat="int" type="text" /> </td>
						<td  width ="240" style="text-align: right">I/B Credit Term (Days)</td>
						<td width =""><input id="ib_cr_term_dys" style="width: 80px; text-align:right;" class="input" value="" name="ib_cr_term_dys" maxlength="3" dataformat="int" type="text" /> </td>
					</tr>
				</table>
				<table class="search" border="0" style="width: 1100">	
					<tr class="h23">
						<td width ="165" style="text-align: right">Rep. Customer Code</td>
						<td width ="133"><input id="rep_cust_cd" style="width: 105px; text-align:center;" class="input" value="" name="rep_cust_cd" maxlength="8" dataformat="engupnum" type="text" />
						<img src="img/btns_search.gif" name="btn_com_ens_041_rep_cust_cd" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
						<td width ="170" style="text-align: right">Invoice Prefix</td>
						<td width ="125"><input id="inv_pfx_cd" style="width: 110px; text-align:center;" class="input" value="" name="inv_pfx_cd" maxlength="2" dataformat="engup" type="text" /> </td>
						<td width ="230" style="text-align: right">Sub Agent</td>
	                    <td width=""><script type="text/javascript">ComComboObject('sub_agn_flg', 1, 70, 1, 0 ,0 ,false)</script></td>
					</tr>
				</table>
				<table class="search" border="0" style="width: 1100">
					<tr class="h23">
						<td width ="165" style="text-align: right">Agent Settle Method</td>
						<td width ="135"><script type="text/javascript">ComComboObject('ar_agn_stl_cd',  2, 105, 1, 0 ,0 ,false)</script></td>
						<td width ="170" style="text-align: right">B.C.R Control Office</td>
						<td width ="125"><input id="usa_brk_brnc_rqst_ctrl_ofc_cd" style="width: 80px; text-align:center;" class="input" value="" name="usa_brk_brnc_rqst_ctrl_ofc_cd" type="text" maxlength="6" dataformat="engup"/>
					    <img src="img/btns_search.gif" name="btn_com_ens_071_usa_ofc_cd" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
					    <td  width ="225" style="text-align: right">ASA Credit Term (Days)</td>
						<td><input id="asa_cr_term_dys" style="width: 80px;text-align:right;" class="input" value="" name="asa_cr_term_dys" maxlength="3" dataformat="int" type="text" /> </td>
					</tr>
				</table>
				<table class="search" border="0" style="width: 1100">
					<tr class="h23">
						<td width ="165" style="text-align: right">Fixed Currency Exch. Rate</td>
						<td width ="133"><input id="fx_curr_rt" style="width: 133px; ime-mode:disabled;text-align:right;" class="input" value="" name="fx_curr_rt" maxlength="10" dataformat="float" pointcount="4" caption="Fixed Currency Exch. Rate" type="text" /> </td>
						<td  width ="170" style="text-align: right">Office TAX Payer ID</td>
						<td width ="220"><input id="ofc_tax_id" style="width: 200px; text-align:left;" class="input" value="" name="ofc_tax_id" maxlength="20" type="text" /> </td>
						<td  width ="135" style="text-align: right">A/R Currency</td>
						<td width =""><input id="ar_curr_cd" style="width: 70px; text-align:center;" class="input" value="" name="ar_curr_cd" maxlength="3" dataformat="engup" type="text" />
						<img src="img/btns_search.gif" name="btn_com_ens_n13_ar_curr_cd" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
					</tr>
					<tr class="line_bluedot"><td colspan="6"></td></tr>	
				</table>
				<table class="search" border="0" style="width: 1100">
					<tr class="h23">
						<td width ="155" style="text-align: right">A/P Office</td>
						<td width ="130"><input id="ap_ofc_cd" style="width: 75px; ime-mode: disabled; text-align:center;" class="input" value="" name="ap_ofc_cd" maxlength="6" dataformat="engup" type="text" />
						<img src="img/btns_search.gif" name="btn_com_ens_071_ap_ofc_cd" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
						<td width =143 style="text-align: right">A/P Control Office</td>
						<td width ="140"><input id="ap_ctrl_ofc_cd" style="width: 75px; ime-mode:disabled; text-align:center;" class="input" value="" name="ap_ctrl_ofc_cd" maxlength="6" dataformat="engup" type="text" />
						<img src="img/btns_search.gif" name="btn_com_ens_071_ap_ctrl_ofc_cd" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
						<td width ="150" style="text-align: right">A/P Center Code</td>
						<td colspan="3"><input id="ap_ctr_cd" style="width: 115px; ime-mode:disabled; text-align:center;" class="input" value="" name="ap_ctr_cd" maxlength="6" dataformat="int" type="text" />
						<!-- <img src="img/btns_search.gif" name="btn_ap_ctr_cd" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"> --></td>
					</tr>
				</table>
				<table class="search" border="0" style="width: 1100">		
					<tr class="h23">
						<td width ="155" style="text-align: right">S/O Interface</td>
						<td width ="130"><script type="text/javascript">ComComboObject('so_if_cd', 2, 105, 1, 0 ,0 ,false)</script></td>
						<td width ="140" style="text-align: right">A/P Currency</td>
						<td width ="140"><input id="bil_curr_cd" style="width: 85px; text-align:center;" class="input" value="" name="bil_curr_cd" maxlength="3" dataformat="engup" type="text" />
						<img src="img/btns_search.gif" name="btn_com_ens_n13_bil_curr_cd" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
						<td width ="152" style="text-align: right">Vendor Code</td>
						<td><input id="vndr_cd" style="width: 80px; text-align:center;" class="input" value="" name="vndr_cd" maxlength="6" dataformat="int" type="text" />
						<img src="img/btns_search.gif" name="btn_vndr_cd_pop" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
<!--컬럼 없음 			<td  width ="180" style="text-align: right">Separate Email Invoice Flag</td>
         				<td>
	                    	<select style="width:50px;" class="input" name="sprt_eml_inv_flg">
	                            <option value="N">N</option>
	                            <option value="Y">Y</option>
	                        </select>
	                    </td> -->	
					</tr>
				</table>
				<table class="search" border="0" style="width: 1100">		
					<tr class="h23">
						<td width ="155" style="text-align: right">G/L Center Code</td>
						<td width ="130"><input id="gl_ctr_cd" style="width: 105px; ime-mode:disabled;text-align:center;" class="input" value="" name="gl_ctr_cd" maxlength="6" dataformat="int" type="text" />
						<!-- <img src="img/btns_search.gif" name="btn_gl_ctr_cd" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"> --></td>
						<td width ="140" style="text-align: right">Commission I/F</td>
						<td width ="140"><script type="text/javascript">ComComboObject('comm_if_ind_cd', 2, 105, 1, 0 ,0 ,false)</script></td>
						<td width ="155" style="text-align: right">A/P Euro Currency Use</td>
						<td><script type="text/javascript">ComComboObject('ap_euro_curr_use_flg', 1, 50, 1, 0 ,0 ,false)</script></td>
					</tr>
				</table>
				<table class="search" border="0" style="width: 265">		
					<tr class="h23">
						<td width ="149" style="text-align: right">A/P Head Office Account</td>
						<td width ="105"><input id="ap_ho_acct_cd" style="width: 105px; ime-mode:disabled;text-align:center;" class="input" value="" name="ap_ho_acct_cd" maxlength="6" dataformat="int" type="text" /></td>
					</tr>
				</table>
				<table class="search" border="0" style="width: 979">
				<tr class="line_bluedot"><td colspan="12"></td></tr>
					<tr class="h23">
						<td width ="70" style="text-align: right">Delete Flag</td>
						<td width ="40"><script type="text/javascript">ComComboObject('delt_flg', 1, 40, 1, 0 ,2 ,false)</script></td>						
						<td width ="72" style="text-align: right">Create User</td>
			            <td width ="80"><input type="text" style="width:80px;text-align:center;" class="input" name="cre_usr_id" id="cre_usr_id" readOnly/></td>
			            <td width ="108" style="text-align: right">Create Date/Time</td>
			            <td width ="110"><input type="text" style="width:120px;text-align:center;" class="input" name="cre_dt" id="cre_dt" readOnly/>
			            </td>
						<td width ="110" style="text-align: right;" >Last Update User</td>
				            <td width ="80"><input type="text" style="width:80px;text-align:center;" class="input" name="upd_usr_id" id="upd_usr_id" readOnly/>
				            </td>
				            <td width ="145" style="text-align: right">Last Update Date/Time</td>
				            <td width ="120"><input type="text" style="width:120px;text-align:center;" class="input" name="upd_dt" id="upd_dt" readOnly/>
				       </td>
				       <td></td>
				    </tr>   
				</table>
				<table style="display: none"> 
					<tr>
						<td>INPUT Flag</td>
						<td><input id="input_flg" name="input_flg" style="width:500px;" class="input1" value="" type="text" /> </td>
					</tr>	
				</table>
			</td>
		</tr>
</table>

<!-- opus_design_inquiry(E) -->
<!-- opus_design_grid(S) -->
<div class= "wrap_search">
        <div class="opus_design_grid" style="display: none;">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
        </div>
 </div>
<!-- opus_design_grid(E) -->
</td>
</tr>
</table>
<!--Button (S) -->
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;padding-bottom:10;">
        <tr><td class="btn1_bg">
            <table border="0" cellpadding="0" cellspacing="0">
            <tr>
            	<td id="btn_History">
            	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_History">History</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
                <td>
                    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                        <td class="btn1_left"></td>
                        <td class="btn1" name="btn_retrieve">Retrieve</td>
                        <td class="btn1_right"></td>
                    </tr>
                    </table>
                </td>
                <td class="btn1_line"></td>
            <td>
                <table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
                <tr>
                    <td class="btn1_left"></td>
                    <td class="btn1" name="btn_save">Save</td>
                    <td class="btn1_right"></td>
                </tr>
                </table>
            </td>
            <td id="btn_Create1">
          		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr>
					<td class="btn1_left"></td>
					<td class="btn1" name="btn_Create" id="btn_Create">Create</td>
					<td class="btn1_right"></td>
				</tr>
				</table>
			</td>
            <td>
                <table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
                <tr>
                    <td class="btn1_left"></td>
                    <td class="btn1" name="btn_new">New</td>
                    <td class="btn1_right"></td>
                </tr>
                </table>
            </td>
			</tr>
			</table>
	</td></tr>
</table>
</form>
</body>
