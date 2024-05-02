<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_FMS_0001.jsp
*@FileTitle : Agreement Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.12
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2009.04.22 최초 생성??
* 1.0 생성
* 2012.06.12 [CHM-201218110-01] CP Period 
* 2013.06.10 [CHM-201324825] Customer Code Logic - Agreement Pop up
* 2014.09.25 [] [FMS] 10만불 비용지급 결재건 관련 3차 - G/W 계약문서 연계 개발
=========================================================*/
%>

<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.core.config.SubSystemConfigFactory"%>
<%
	Exception serverException = null;		
	String strErrMsg = "";	

	String cre_usr_id = "";
	Logger log = Logger.getLogger("com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriocontract");
	String csrGwUrl = "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   	cre_usr_id = account.getUsr_id();
	   		
	   	serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		csrGwUrl = SubSystemConfigFactory.get("CSR.GW.URL");
		
	}catch(Exception e) {
		log.error(e.getMessage(),e);
	}
%>

<html>
<head>
<title>Agreement Creation</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

<script language="javascript">

    function setupPage(){ 
    	var errMessage = "<%=strErrMsg%>";
    	
    	if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if 

        loadPage();
    }

</script>


<body  onLoad="setupPage();"> 
<form name="form" onKeyUp="ComKeyEnter('LengthNextFocus')">
<input type="hidden" name="f_cmd">
<input type="hidden" name="ibflag">
<input type="hidden" name="pagerows">
<input type="hidden" name="cnt_cd">
<input type="hidden" name="curr_cd">
<input type="hidden" name="cre_usr_id" value="<%=cre_usr_id%>">
<input type="hidden" name="eff_dt">
<input type="hidden" name="exp_dt">
<input type="hidden" name="vndr_seq">
<input type="hidden" name="curr_port_cd">
<input type="hidden" name="csr_gw_url" value="<%=csrGwUrl%>">
<input type="hidden" name="agmt_doc_no" >				

<table width="100%"  border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
    <tr><td valign="top">
    </td></tr>
    <tr><td valign="top">
    <!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
	<!--Page Title, Historical (E)-->
	
	<!--Button (S) -->
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
        <tr><td class="btn1_bg">
            <table border="0" cellpadding="0" cellspacing="0">
            <tr>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1"  name="btn_retrive">Retrieve</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1"   name="btn_new">New</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                <td class="btn1_line"></td>
                <td id="btn_creation2" style="display:''"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1"  name="btn_creation">Creation</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                <td id="btn_save2" style="display:none"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1"  name="btn_save">Save</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                <td id="btn_delete2" style="display:none"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1"  name="btn_delete">Delete</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
            </tr>
            </table>
        </td></tr>
        </table>
    <!--Button (E) -->
    
    <!--biz page (S)-->
        <table class="search"> 
        <tr><td class="bg">
                <!--  biz_1  (S) -->
                <table class="search" border="0" style="width:979;"> 
                <tr class="h23">
                    <td width="80">Contract No.</td>
                    <td width="170"><input type="text" style="width:120;text-align:center;" class="input2" maxlength="15" name="flet_ctrt_no" fullfill caption="Contract No." readonly>&nbsp;<img class="cursor" src="img/btns_search.gif" name="contract_no" width="19" height="20" alt="" border="0" align="absmiddle"></td>
                    <td width="75">Vessel Code</td>
                    <td width="270"><input type="text" style="width:54;text-align:center;" class="input1" maxlength="4" name="vsl_cd" required fullfill caption="Vessel Code" style="ime-mode:disabled">&nbsp;<img class="cursor" src="img/btns_search.gif" name="btn_vslpop" width="19" height="20" alt="" border="0" align="absmiddle">&nbsp;<input type="text" style="width:161;" class="input2" name="vsl_eng_nm" readonly></td> 
                    <td width="90">Contract Type</td>
					<td width="100">&nbsp;<script language="javascript">ComComboObject('flet_ctrt_tp_cd', 1, 86, 1);</script></td>
					<!-- 
                    <td width="100">&nbsp;<select style="width:70;" name="flet_ctrt_tp_cd" onchange="setOwnerCode(this.value)">
                        <option value="TI" selected>T/C In</option>
                        <option value="TO">T/C Out</option>
						<option value="OW">Ownership</option></td>
					-->
                    <td width="90">Contract Fact</td> 
					<td>&nbsp;<script language="javascript">ComComboObject('flet_ctrt_fact_cd', 1, 72, 1);</script></td></tr>
					<!--   
                    <td>&nbsp;<select style="width:73;" name="flet_ctrt_fact_cd">
                        <option value="ACT" selected>Actual</option>
                        <option value="PSE">Pseudo</option></td></tr>
                    -->

                <tr class="h23">
                    <td>CP Date</td>
                    <td><input type="text" style="width:80;text-align:center;" class="input" name="cp_dt" maxlength="8" dataformat="ymd" caption="CP Date">&nbsp;<img class="cursor" src="img/btns_calendar.gif" name="cp_da" width="19" height="20" alt="" border="0" align="absmiddle"></td>
                    <td>CP Period</td>
                      <td colspan="4"><input type="text" style="width:76;text-align:center;" class="input1" name="ori_eff_dt" required fullfill caption="CP Period From" maxlength="8" dataformat="ymd">&nbsp;<input type="text" style="width:45;text-align:center;" class="input1" maxlength="4" dataformat="hm"  name="from_time" required fullfill caption="CP Time">&nbsp;<img class="cursor" src="img/btns_calendar.gif" name="ef_dt" width="19" height="20" alt="" border="0" align="absmiddle" >&nbsp;~&nbsp;<input type="text" style="width:76;text-align:center;" class="input1" name="ori_exp_dt" required fullfill caption="CP Period To" maxlength="8" dataformat="ymd" cofield="ori_eff_dt">&nbsp;<input type="text" style="width:45;text-align:center;" class="input1" maxlength="4" name="to_time" dataformat="hm" required fullfill caption="CP Time">&nbsp;<img class="cursor" src="img/btns_calendar.gif" name="ex_dt" width="19" height="20" alt="" border="0" align="absmiddle" >
                      
                      <!-- select style="width:50;" class="input1" name="flet_gmt_lmt_cd">
                      </select -->
                      
                      <input type="text" style="color: #000000; width: 250; background-color: #F3F2F8; border: #F3F2F8 1px solid; font-size: 12px; color: #313131; font-weight: normal; " maxlength="3" name="flet_gmt_lmt_view" 
                          required fullfill caption="UTC" value ='UTC' readonly>
                      
                         <input type="hidden"  name="flet_gmt_lmt_cd" value ='G' readonly>
                          
                      </td></tr>

                <tr class="h23">
                    <td colspan="2">Customs Declaration&nbsp;<input type="checkbox" value="N" class="trans" name="decl_flg"></td>
                    <td>Owner Code</td>
                    <td colspan="2"><input type="text" style="width:30;text-align:center;" class="input1" maxlength="2" name="cust_cnt_cd" readonly style="ime-mode:disabled">&nbsp;<input type="text" style="width:67;text-align:center;" class="input1" maxlength="6" name="cust_seq" required caption="Owner Code" dataformat="int">&nbsp;<img class="cursor" src="img/btns_search.gif" name="owner_code" width="19" height="20" alt="" border="0" align="absmiddle">&nbsp;<input type="text" style="width:186;" class="input2" name="vndr_lgl_eng_nm" caption="Owner Code" readonly></td><!-- required --> 
                    <td colspan="3">Owner Name&nbsp;<input type="text" style="width:165;" class="input2" name="ownr_nm" readonly>&nbsp;<img class="cursor" src="img/btns_search.gif" name="btn_ownr_nm" width="19" height="20" alt="" border="0" align="absmiddle"> </td></tr>
                </table>
                <!--  biz_1   (E) -->
                <table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
                
                <!--  biz_2  (S) -->
                <table class="search" border="0" style="width:979;"> 
                <tr class="h23">
                    <td width="100">Address Comm.</td>
                    <td width="100" class="stm"><input type="text" style="width:48;text-align:right;" class="input" name="acmm_rt_amt" dataformat="float" maxlength="6" pointcount="2" caption="Address Comm.">&nbsp;%</td>
                    <td width="125">Outlay Comm.</td>
                    <td width="190" class="stm"><input type="text" style="width:48;text-align:right;" class="input" name="flet_olay_comm_rt_amt" value="2.5" dataformat="float" maxlength="6" pointcount="2" caption="Outlay Comm">&nbsp;%</td>
                    <td width="78">Flag Code</td>																				<!-- readonly -->
                    <td width="96"><input type="text" style="width:46;text-align:center;" class="input" maxlength="2" name="vsl_cnt_cd" style="ime-mode:disabled">&nbsp;<img class="cursor" src="img/btns_search.gif" name="flag_code" width="19" height="20" alt="" border="0" align="absmiddle"></td>
                    <td width="75">Flag Name</td><!-- style="width:94;" -->  
                    <td><input type="text" style="width:185;" class="input2" name="cnt_nm" readonly></td></tr>
                <tr class="h23">
                       <td valign="top">Brokerage</td>
                    <td class="stm" valign="top"><input type="text" style="width:48;text-align:right;" class="input" name="flet_brog_rt_amt" dataformat="float" maxlength="6" pointcount="2" caption="Brokerage">&nbsp;%</td>
                    <td valign="top">Reservation of O/A</td>																																		<!-- width:60 -->
                    <td valign="top"><input type="text" style="width:48;text-align:center;" class="input" name="oa_rsv_curr_cd" maxlength="3" style="ime-mode:disabled">&nbsp;<input type="text" style="width:62;text-align:right;" class="input" name="oa_rsv_amt" dataformat="float" maxlength="13" pointcount="2"></td>
                </table>
                <table class="search" border="0" style="width:1500;"> 
                <tr class="h23">
                    <td width="515" valign="bottom">
                		<table class="search" border="0" style="width:510;">
		                <tr class="h23">
		                    <td valign="top" style="width:120;">GW Contract Link</td>
		                    <td valign="top" style="width:340;"><input type="text" style="width:300;text-align:left;" class="input2" name="agmt_doc_desc" readonly>&nbsp;<img class="cursor" src="img/btns_search.gif" name="btn_gw" width="19" height="20" alt="" border="0" align="absmiddle"></td>
		                    <td>
							<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" name="btng_del" id="btng_del">Del</td>
							<td class="btn2_right"></td>
							</tr></table>		                    		                    
		                    </td>
    					</tr>      
		                <tr class="h23">
		                    <td valign="top">&nbsp;</td>
		                    <td valign="top">&nbsp;</td>
		                    <td valign="top">&nbsp;</td>
    					</tr>          					
                        </table>                      
                        <table border="0" style="width:1000; background-color:white;" class="grid2"> 
                            <tr class="tr2_head">
                                <td width="7%">Bunker TP</td>
								<td width="7%">F.O.</td>
								<td width="7%">L.S.F.O.</td>
								<td width="7%">D.O.</td>
								<td width="7%">L.S.G.O.</td>
								<td width="5.7%"></td>
								<td width="7.5%">F.O. Price</td>
								<td width="8.1%">L.S.F.O. Price</td>
								<td width="9.3%">D.O. Price</td>
								<td width="9.3%">L.S.G.O. Price</td>
								<td width="9.3%">Del / Redel</td>
								<td width="4%"></td></tr>
                            <tr><td class="tr2_head2">BOD</td>
                                <td><input type="text" style="width:100%;text-align:right;" class="noinput" name="act_foil_bod_qty" dataformat="float" maxlength="13" pointcount="3" caption="BOD F.O."></td> 
                                <td><input type="text" style="width:100%;text-align:right;" class="noinput" name="act_low_sulp_foil_bod_qty" dataformat="float" maxlength="13" pointcount="3" caption="BOD L.S.F.O"></td> 
                                <td><input type="text" style="width:100%;text-align:right;" class="noinput" name="act_doil_bod_qty"  dataformat="float" maxlength="13" pointcount="3" caption="BOD D.O."></td>
                                <td><input type="text" style="width:100%;text-align:right;" class="noinput" name="act_low_sulp_gas_oil_bod_qty"  dataformat="float" maxlength="13" pointcount="3" caption="BOD L.S.G.O"></td>
                                <td class="tr2_head2">USD</td> 
                                <td><input type="text" style="width:100%;text-align:right;" class="noinput" name="foil_bod_out_prc"  dataformat="float" maxlength="14" pointcount="2" caption="BOD Price of F.O."></td>
                                <td><input type="text" style="width:100%;text-align:right;" class="noinput" name="low_sulp_foil_bod_out_prc"  dataformat="float" maxlength="14" pointcount="2" caption="BOD Price of L.S.F.O"></td>
                                <td><input type="text" style="width:100%;text-align:right;" class="noinput" name="doil_bod_out_prc"  dataformat="float" maxlength="14" pointcount="2" caption="BOD Price of F.O."></td>
                                <td><input type="text" style="width:100%;text-align:right;" class="noinput" name="low_sulp_gas_oil_bod_out_prc"  dataformat="float" maxlength="14" pointcount="2" caption="BOD Price of L.S.G.O"></td>
                                <td><input type="text" style="width:100%;text-align:center;ime-mode:disabled;" class="noinput" name="bod_port_cd" maxlength="5"></td>
                                <td class="tr2_head2"><img class="cursor" src="img/btns_search.gif" name="img_bod_port_cd" width="19" height="20" alt="" border="0" align="absmiddle"></td></tr>
                            <tr><td class="tr2_head2">BOR</td>
                                <td><input type="text" style="width:100%;text-align:right;" class="noinput" name="act_foil_bor_qty" dataformat="float" maxlength="13" pointcount="3" caption="BOR F.O."></td> 
                                <td><input type="text" style="width:100%;text-align:right;" class="noinput" name="act_low_sulp_foil_bor_qty" dataformat="float" maxlength="13" pointcount="3" caption="BOR L.S.F.O"></td> 
                                <td><input type="text" style="width:100%;text-align:right;" class="noinput" name="act_doil_bor_qty" dataformat="float" maxlength="13" pointcount="3" caption="BOR D.O."></td>
                                <td><input type="text" style="width:100%;text-align:right;" class="noinput" name="act_low_sulp_gas_oil_bor_qty" dataformat="float" maxlength="13" pointcount="3" caption="BOR L.S.G.O"></td>
                                <td class="tr2_head2">USD</td> 
                                <td><input type="text" style="width:100%;text-align:right;" class="noinput" name="foil_bor_out_prc" dataformat="float" maxlength="14" pointcount="2" caption="BOR Price of F.O."></td>
                                <td><input type="text" style="width:100%;text-align:right;" class="noinput" name="low_sulp_foil_bor_out_prc" dataformat="float" maxlength="14" pointcount="2" caption="BOR Price of L.S.F.O"></td>
                                <td><input type="text" style="width:100%;text-align:right;" class="noinput" name="doil_bor_out_prc" dataformat="float" maxlength="14" pointcount="2" caption="BOR Price of F.O."></td>
                                <td><input type="text" style="width:100%;text-align:right;" class="noinput" name="low_sulp_gas_oil_bor_out_prc" dataformat="float" maxlength="14" pointcount="2" caption="BOR Price of L.S.G.O"></td>
                                <td><input type="text" style="width:100%;text-align:center;ime-mode:disabled;" class="noinput" name="bor_port_cd" maxlength="5"></td>
                                <td class="tr2_head2"><img class="cursor" src="img/btns_search.gif" name="img_bor_port_cd" width="19" height="20" alt="" border="0" align="absmiddle"></td></tr>
                        </table>
                    </td>
                    <td style="width:10"></td>
                    <td>
                        <!-- Grid  (S) -->
                          <table width="100%" class="grid"> 
                        <tr><td class="tr_head" width="15%">Built</td> 
                            <td width="15%" align="center"><input type="text"  style="width:100;text-align:center;" class="input" name="vsl_bld_dt" maxlength="8" dataformat="ymd" caption="Built">&nbsp;<img class="cursor" src="img/btns_calendar.gif" name="vsl_bld_da" width="19" height="20" alt="" border="0" align="absmiddle"></td>
                            <td class="tr_head" width="15%">Speed</td>
                            <td width="15%" align="center"><input type="text"  style="text-align:right;" class="input" maxlength="9" name="shp_spd_qty" dataformat="float" maxlength="9" pointcount="2" caption="Speed"></td></tr>
                        <tr><td class="tr_head">Max TEU</td> 
                            <td align="center"><input type="text"  style="text-align:right;" class="input" maxlength="5" name="vsl_dznd_capa" dataformat="int" maxlength="5" caption="Max TEU"></td>
                            <td class="tr_head">14 Ton</td>
                            <td align="center"><input type="text"  style="text-align:right;" class="input" maxlength="5" name="bse_14ton_vsl_capa" dataformat="int" maxlength="5" caption="14 Ton"></td></tr>
                        <tr><td class="tr_head">Reefer Plug Qty</td> 
                            <td align="center"><input type="text"  style="text-align:right;" class="input" name="rf_cntr_plg_qty" dataformat="int" maxlength="6" caption="Reefer Plug Qty"></td>
                            <td class="tr_head">Geared / G.Less</td>
                            <td align="center"><select style="width:73;" name="gr_flg">
                        <option value="Y" selected>Geared</option>
                        <option value="N">G.Less</option></td></tr>
                        <tr><td class="tr_head">Dead Weight</td> 
                            <td align="center"><input type="text"  style="text-align:right;" class="input" name="ddwt_cgo_capa_qty" dataformat="float" maxlength="9" pointcount="2" caption="Dead Weight"></td>
                            <td class="tr_head">Gross Ton</td>
                            <td align="center"><input type="text"  style="text-align:right;" class="input" name="grs_wgt" dataformat="int" maxlength="6" caption="Gross Ton"></td></tr>
                        <tr><td class="tr_head"></td> 
                            <td align="center"></td>
                            <td class="tr_head">Net Ton</td>
                            <td align="center"><input type="text"  style="text-align:right;" class="input" name="nrt_wgt" dataformat="int" maxlength="6" caption="Net Ton"></td></tr>                        </table> 
                        <!-- Grid (E) -->
                    </td></tr>
                </table>
                <!--  biz_2   (E) -->
                <table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
                <!--  biz_3  (S) -->
                <table class="search" border="0">
                <tr><td class="title_h"></td>
                    <td class="title_s">Hire Information</td></tr>
                </table>
                <table class="search" border="0" style="width:979;"> 
                <tr class="h23">
                    <td width="85">Hire</td>
                    <td><input type="text" style="width:76;" class="input2" name="hir_eff_dt" readonly>&nbsp;<input type="text" style="width:45;text-align:center;" class="input2" name="hir_eff_dt_time" readonly>&nbsp~&nbsp;<input type="text" style="width:76;" class="input2" name="hir_exp_dt" readonly>&nbsp;<input type="text" style="width:45;text-align:center;" class="input2" name="hir_exp_dt_time" readonly>&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" style="width:40;text-align:center;" class="input2" name="hir_hir_curr_n1st_cd" readonly>&nbsp;<input type="text" style="width:95;text-align:right;" class="input2" name="hir_hir_rt_n1st_amt" readonly>&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" style="width:40;text-align:center;" class="input2" name="hir_hir_curr_n2nd_cd" readonly>&nbsp;<input type="text" style="width:95;text-align:right;" class="input2" name="hir_hir_rt_n2nd_amt" readonly></td></tr>
                </table>
                <table class="height_10"><tr><td colspan="8"></td></tr></table>
                <table class="search" border="0">
                <tr><td class="title_h"></td>
                    <td class="title_s">Other Lumpsum information</td></tr>
                </table><!-- width:979; -->
				<table class="search" border="0" style="width:665;"> 
                <tr class="h23">
                    <td><!-- Grid  (S) -->
			                <script language="javascript">ComSheetObject('sheet1');</script>
			            <!-- Grid (E) -->
					</td>
                </tr>
                </table>
				<!-- 
                <table class="search" border="0" style="width:979;"> 
                <tr class="h23">
                    <td width="85" id="vsl_acct_itm_nm">Victualling</td>
                    <td><input type="text" style="width:76;" class="input2" name="vsl_eff_dt" readonly>&nbsp;~&nbsp;<input type="text" style="width:76;" class="input2" name="vsl_exp_dt" readonly>&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" style="width:40;" class="input2" name="vsl_curr_cd" readonly>&nbsp;<input type="text" style="width:76;" class="input2" name="vsl_otr_expn_amt" readonly></td></tr>
                <tr class="h23">
                    <td id="vsl_acct_itm_nm">Lashing EQ</td>
                    <td><input type="text" style="width:76;" class="input2" name="vsl_eff_dt" readonly>&nbsp;~&nbsp;<input type="text" style="width:76;" class="input2" name="vsl_exp_dt" readonly>&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" style="width:40;" class="input2" name="vsl_curr_cd" readonly>&nbsp;<input type="text" style="width:76;" class="input2" name="vsl_otr_expn_amt" readonly></td></tr>
                <tr class="h23">
                    <td id="vsl_acct_itm_nm">Crew Commu</td>
                    <td><input type="text" style="width:76;" class="input2" name="vsl_eff_dt" readonly>&nbsp;~&nbsp;<input type="text" style="width:76;" class="input2" name="vsl_exp_dt" readonly>&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" style="width:40;" class="input2" name="vsl_curr_cd" readonly>&nbsp;<input type="text" style="width:76;" class="input2" name="vsl_otr_expn_amt" readonly></td></tr>
                </table>
                -->
                <!--  biz_3   (E) -->
                </td></tr>
            </table>
            <table class="height_10"><tr><td colspan="8"></td></tr></table>

        <!-- Tab (S) Hire,  Other Exp,  Payment Term,  Redelivery,  CP file up, Certi File up, Duplication -->
            <table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%> 
            <tr><td width="100%">
                        <script language="javascript">ComTabObject('tab1')</script>
                        <!-- img src="/img/sub_tab.gif" alt="" width="998" height="23" border="0" -->
                    </td></tr>
                </table>
        <!-- Tab  (E) -->

        <!--TAB Hire(S) -->
        <div id="tabLayer" style="display:inline">

        <!-- Tab BG Box  (S) -->
        <table class="search"  id="mainTable" width="100%"> 
        <tr><td class="bg" width="100%">
            <!-- Grid  (S) -->
                <script language="javascript">ComSheetObject('t1sheet1');</script>
            <!-- Grid (E) -->

            <!--  Grid_button (S) -->
            <table width="100%" class="button"> 
            <tr><td class="btn2_bg">
                <table border="0" cellpadding="0" cellspacing="0">
                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn2_left"></td>
                        <td class="btn2"  name="btn_add">Row&nbsp;Add</td>
                        <td class="btn2_right"></td>
                        </tr>
                        </table></td>
						<!-- 
                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn2_left"></td>
                        <td class="btn2" name="btn_ins">Row&nbsp;Ins</td>
                        <td class="btn2_right"></td>
                        </tr>
                        </table></td>
                        -->
                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn2_left"></td>
                        <td class="btn2" name="btn_del">Row&nbsp;Del</td>
                        <td class="btn2_right"></td>
                        </tr>
                        </table></td>
                </table>
            </td></tr>
            </table>
            <!-- Grid_button (E) -->
            </td></tr>
        </table>

        </div>

    <!-- Tab BG Box  (S) -->

    <!--TAB Hire(S) -->



    <!--TAB Other Exp(S) -->
        <div id="tabLayer" style="display:none">

        <!-- Tab BG Box  (S) -->
        <table class="search" width="100%"> 
        <tr><td class="bg"  id="mainTable" width="100%">
            <!-- Grid  (S) -->
                <script language="javascript">ComSheetObject('t2sheet1');</script>
            <!-- Grid (E) -->

            <!--  Grid_button (S) -->
            <table width="100%" class="button"> 
            <tr><td class="btn2_bg">
                <table border="0" cellpadding="0" cellspacing="0">
                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn2_left"></td>
                        <td class="btn2"  name="btn_t2Add">Row&nbsp;Add</td>
                        <td class="btn2_right"></td>
                        </tr>
                        </table></td>
						<!-- 
                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn2_left"></td>
                        <td class="btn2" name="btn_t2Ins">Row&nbsp;Ins</td>
                        <td class="btn2_right"></td>
                        </tr>
                        </table></td>
                        -->
                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn2_left"></td>
                        <td class="btn2" name="btn_t2Del">Row&nbsp;Del</td>
                        <td class="btn2_right"></td>
                        </tr>
                        </table></td>
                </table>
            </td></tr>
            </table>
            <!-- Grid_button (E) -->
            </td></tr>
        </table>

        </div>

    <!-- Tab BG Box  (S) -->

    <!--TAB Other Exp(S) -->



    <!--TAB Payment Term(S) -->
        <div id="tabLayer" style="display:none">

        <!-- Tab BG Box  (S) -->
        <table class="search" width="100%"> 
        <tr><td class="bg"  id="mainTable" width="100%">
            <!-- Grid  (S) -->
                <script language="javascript">ComSheetObject('t3sheet1');</script>
            <!-- Grid (E) -->

            <!--  Grid_button (S) -->
            <table width="100%" class="button"> 
            <tr><td class="btn2_bg">
                <table border="0" cellpadding="0" cellspacing="0">
                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn2_left"></td>
                        <td class="btn2"  name="btn_t3Add">Row&nbsp;Add</td>
                        <td class="btn2_right"></td>
                        </tr>
                        </table></td>
						<!-- 
                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn2_left"></td>
                        <td class="btn2" name="btn_t3Ins">Row&nbsp;Ins</td>
                        <td class="btn2_right"></td>
                        </tr>
                        </table></td>
                        -->
                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn2_left"></td>
                        <td class="btn2" name="btn_t3Del">Row&nbsp;Del</td>
                        <td class="btn2_right"></td>
                        </tr>
                        </table></td>
                </table>
            </td></tr>
            </table>
            <!-- Grid_button (E) -->
            </td></tr>
        </table>

        </div>

    <!-- Tab BG Box  (S) -->

    <!--TAB Payment Term(S) -->



    <!--TAB Redelivery(S) -->
        <div id="tabLayer" style="display:none">

        <!-- Tab BG Box  (S) -->
        <table class="search" width="100%"> 
        <tr><td class="bg"  id="mainTable" width="100%">
            <!-- Grid  (S) -->
                <script language="javascript">ComSheetObject('t4sheet1');</script>
            <!-- Grid (E) -->

            </td></tr>
        </table>

        </div>

    <!-- Tab BG Box  (S) -->

    <!--TAB Redelivery(S) -->


    <!--TAB CP file up(S) -->
        <div id="tabLayer" style="display:none">

        <!-- Tab BG Box  (S) -->
        <table class="search" width="100%"> 
        <tr><td class="bg"  id="mainTable" width="100%">
            <!-- Grid  (S) -->
                <script language="javascript">ComSheetObject('t5sheet1');</script>
            <!-- Grid (E) -->

            <!--  Grid_button (S) -->
            <table width="100%" class="button"> 
            <tr><td class="btn2_bg">
                <table border="0" cellpadding="0" cellspacing="0">
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn2_left"></td>
                        <td class="btn2" name="btn_t5Add">Row&nbsp;Add</td>
                        <td class="btn2_right"></td>
                        </tr>
                        </table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn2_left"></td>
                        <td class="btn2" name="btn_t5Ins">Row&nbsp;Ins</td>
                        <td class="btn2_right"></td>
                        </tr>
                        </table></td>
						<!-- 
                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn2_left"></td>
                        <td class="btn2" name="btn_t5Upload">File&nbsp;Upload</td>
                        <td class="btn2_right"></td>
                        </tr>
                        </table></td>
                        -->
						<!-- 
                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn2_left"></td>
                        <td class="btn2" name="btn_t5Download">File&nbsp;Download</td>
                        <td class="btn2_right"></td>
                        </tr>
                        </table></td>
                        -->
						<!-- 
                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn2_left"></td>
                        <td class="btn2" name="btn_t5Open">File&nbsp;Open</td>
                        <td class="btn2_right"></td>
                        </tr>
                        </table></td>
                        -->
                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn2_left"></td>
                        <td class="btn2" name="btn_t5Delete">Row&nbsp;Del</td>
                        <td class="btn2_right"></td>
                        </tr>
                        </table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn2_left"></td>
                        <td class="btn2" name="btn_t5E-mail">E-mail</td>
                        <td class="btn2_right"></td>
                        </tr>
                        </table></td>
                </table>
            </td></tr>
            </table>
            <!-- Grid_button (E) -->
            </td></tr>
        </table>

        </div>

    <!-- Tab BG Box  (S) -->

    <!--TAB CP file up(S) -->



    <!--TAB Certi File up(S) -->
        <div id="tabLayer" style="display:none">

        <!-- Tab BG Box  (S) -->
        <table class="search" width="100%"> 
        <tr><td class="bg"  id="mainTable" width="100%">
            <!-- Grid  (S) -->
                <script language="javascript">ComSheetObject('t6sheet1');</script>
            <!-- Grid (E) -->

            <!--  Grid_button (S) -->
            <table width="100%" class="button"> 
            <tr><td class="btn2_bg">
                <table border="0" cellpadding="0" cellspacing="0">
                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn2_left"></td>
                        <td class="btn2" name="btn_t6Add">Row&nbsp;Add</td>
                        <td class="btn2_right"></td>
                        </tr>
                        </table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn2_left"></td>
                        <td class="btn2" name="btn_t6Ins">Row&nbsp;Ins</td>
                        <td class="btn2_right"></td>
                        </tr>
                        </table></td>
						<!-- 
                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn2_left"></td>
                        <td class="btn2" name="btn_t6Download">File&nbsp;Download</td>
                        <td class="btn2_right"></td>
                        </tr>
                        </table></td>
                        -->
						<!-- 
                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn2_left"></td>
                        <td class="btn2" name="btn_t6Open">File&nbsp;Open</td>
                        <td class="btn2_right"></td>
                        </tr>
                        </table></td>
                        -->
                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn2_left"></td>
                        <td class="btn2" name="btn_t6Delete">Row&nbsp;Del</td>
                        <td class="btn2_right"></td>
                        </tr>
                        </table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn2_left"></td>
                        <td class="btn2" name="btn_t6E-mail">E-mail</td>
                        <td class="btn2_right"></td>
                        </tr>
                        </table></td>
                </table>
            </td></tr>
            </table>
            <!-- Grid_button (E) -->
            </td></tr>
        </table>

        </div>

    <!-- Tab BG Box  (S) -->

    <!--TAB Certi File up(S) -->



    <!--TAB Duplication(S) -->
        <div id="tabLayer" style="display:none">

        <!-- Tab BG Box  (S) -->
        <table class="search" width="100%"> 
        <tr><td class="bg"  id="mainTable" width="100%">
            <!-- Grid  (S) -->
                <script language="javascript">ComSheetObject('t7sheet1');</script>
            <!-- Grid (E) -->

            <!--  Grid_button (S) -->
            <table width="100%" class="button"> 
            <tr><td class="btn2_bg">
                <table border="0" cellpadding="0" cellspacing="0">
                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn2_left"></td>
                        <td class="btn2"  name="btn_t7Add">Row&nbsp;Add</td>
                        <td class="btn2_right"></td>
                        </tr>
                        </table></td>
                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn2_left"></td>
                        <td class="btn2" name="btn_t7Ins">Row&nbsp;Ins</td>
                        <td class="btn2_right"></td>
                        </tr>
                        </table></td>
                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn2_left"></td>
                        <td class="btn2" name="btn_t7Del">Row&nbsp;Del</td>
                        <td class="btn2_right"></td>
                        </tr>
                        </table></td>
                </table>
            </td></tr>
            </table>
            <!-- Grid_button (E) -->
            </td></tr>
        </table>

        </div>

    <!-- Tab BG Box  (E) -->

    <!--TAB Duplication(E) -->





    <!--biz page (E)-->
    
    
    <!--Button (S) -->
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
        <tr><td class="btn1_bg">
            <table border="0" cellpadding="0" cellspacing="0">
            <tr>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1"  name="btn_retrive">Retrieve</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1"   name="btn_new">New</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                <td class="btn1_line"></td>
                <td id="btn_creation" style="display:''"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1"  name="btn_creation">Creation</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                <td id="btn_save" style="display:none"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1"  name="btn_save">Save</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                <td id="btn_delete" style="display:none"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1"  name="btn_delete">Delete</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
            </tr>
            </table>
        </td></tr>
        </table>
    <!--Button (E) -->
    </td></tr>
</table>

<table class="search" border="0" style="width:665;" style="display:none"> 
<tr class="h23">
    <td><!-- Grid  (S) -->
   <script language="javascript">ComSheetObject('sheet2');</script>
<!-- Grid (E) -->
</td>
</tr>
</table>

<script language="javascript">ComUploadObject('upload1', '<=session.getId()%>');</script>
<!-- 
<script language="javascript">ComUploadObject('upload1', '<=session.getId()%>', 100, 200);</script>
-->
</form>
</body>
</html>

<%@include file="/bizcommon/include/common_alps.jsp"%>