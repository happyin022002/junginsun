<%
/*=========================================================
*Copyright(c) 2017 Hipluscard. All Rights Reserved.
*@FileName   : BCM_CMS_0311.jsp
*@FileTitle  : Credit customer
*@author     : CLT
*@version    : 1.0
*@since      : 2017/12/27
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.core.controller.util.WebKeys"%>
<%@ page import="com.hanjin.framework.core.view.template.Screen"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.bcm.cms.custmanage.custmain.event.BcmCms0311Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	BcmCms0311Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Error from server
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//Count of DB resultSet list
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String screenName		= "";

	Logger log = Logger.getLogger("com.hanjin.apps.custmanage.custmain");
	String mainPage 		= "";
	mainPage = request.getParameter("main_page");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	
	
		event = (BcmCms0311Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
	
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		log.debug("====================================");
		Screen screen = (Screen) request.getAttribute(WebKeys.CURRENT_SCREEN);
		screenName = screen.getName();
		log.debug("====================================");
	
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<html>
<head>
<title>Credit Customer</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if		
		ComSetObjValue(document.form.screenName,"<%=screenName%>");
		loadPage();
	}
	
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" >
<input type="hidden" name="pagerows" id="pagerows" >

<input type="hidden" name="screenName" value="<%=screenName %>">

<input type="hidden" name="ibflag" value="I" id="ibflag" >
<input type="hidden" name="creflag" value="N">
<input type="hidden" name="user_id" value="<%= strUsr_id %>" id="user_id" >

<input id="cust_seq" name="cust_seq" type="hidden" >
<input id="cust_cnt_cd" name="cust_cnt_cd" type="hidden" >
<input id="act_cust_cnt_cd" name="act_cust_cnt_cd" type="hidden" >
<input id="act_cust_seq" name="act_cust_seq" type="hidden" >
<input id="mdm_yn" name="mdm_yn" value="Y" type="hidden" >
<input id="hidden_ofc_cd" name="hidden_ofc_cd" value="" type="hidden" >
<input id="cre_usr_id" name="cre_usr_id" type="hidden" >
<input id="cre_dt" name="cre_dt" type="hidden" >
<input id="upd_usr_id" name="upd_usr_id" type="hidden" >
<input id="upd_dt" name="upd_dt" type="hidden" >
<textarea name="keys" style="width:100%; height:10px;display:none"></textarea>

<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	
	<tr><td class="top"></td></tr>
	<tr><td valign="top">
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title">&nbsp; Credit Customer</span></td></tr>
		</table>
		
		<!--Page Title, Historical (E)-->

			
		<!-- : ( Grid ) (S) -->
		<table width="100%" class="search"  id="leftTable"> 
            <tr>
                <td width="120">
                	<script language="javascript">ComSheetObject('sheet1');</script>
            	</td>
        	</tr>
        </table>
		
		<!--biz page (S)-->
		<table class="search" id="mainTable"> 
       		<tr>
       			<td class="bg">
			
				<!--  biz_1  (S) -->
					<table class="search" border="0" style="width:979;"> 
						<tr class="h23">
							<td width="150">Customer Code</td>
							<td width="180" >
								<input id="cust_cd" style="width: 100px; text-align:center;" class="input1" value="" name="cust_cd" maxlength="8" dataformat="uppernum" type="text" >
								<img src="img/btns_search.gif" name="btn_com_ens_041" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
							</td>
							<td width="130">Legal English Name</td>
							<td width="210">
								<input id="cust_lgl_eng_nm" style="width: 200px;" class="input2" value="" name="cust_lgl_eng_nm" maxlength="100" readonly dataformat="uppernum" otherchar="!@&()_/\- " type="text"  >
							</td>
							<td width="150">Delete Flag</td>
							<td width="110" >
								<select class="input" style="width:60;" name="delt_flg">
				                    	<option value="" selected></option>
				                      	<option value="Y">Y</option>
				                      	<option value="N">N</option>
				                </select>
							</td>
						</tr> 
						
					</table>			
				<!--  biz_1   (E) -->
				</td>
			</tr>
		</table>
		<table class="height_8"><tr><td></td></tr></table>	
		
		<table class="search" id="mainTable"> 
			<tr>
       			<td class="bg">	
       				<table class="search" border="0" style="width:979;">
       					<colgroup>
							<col width="100" />
							<col width="100" />
							<col width="140" />
							<col width="100" />
							<col width="150" />
							<col width="120" />
							<col width="140" />
							<col width="50" />
						</colgroup>
						<tr class="h23">
							<td colspan="2">Credit Control Office</td>
							<td ><input id="cr_clt_ofc_cd" style="width: 70px; ime-mode:disabled; text-align:center;" class="input" value="" name="cr_clt_ofc_cd" maxlength="6" dataformat="engup" type="text" />
							     <img src="img/btns_search.gif" name="btn_com_ens_071" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
  					        <td></td>
							<td colspan="2">Credit Currency</td>
							<td ><input id="cr_curr_cd" style="width: 40px; ime-mode:disabled; text-align:center;" class="input" value="" name="cr_curr_cd" maxlength="3" dataformat="engup" type="text" />
							     <img src="img/btns_search.gif" name="btn_com_ens_n13" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
  				        </tr>
					    <tr class="h23">
							<td colspan="2">O/B Credit Term/Day</td>
							<td ><input id="ob_cr_term_dys" style="width: 80px; ime-mode:disabled; text-align:right;" class="input" value="" name="ob_cr_term_dys" maxlength="3" dataformat="num" type="text" /></td>
							<td></td>
							<td colspan="2">I/B Credit Term/Day</td>
							<td ><input id="ib_cr_term_dys" style="width: 80px; ime-mode:disabled; text-align:right;" class="input" value="" name="ib_cr_term_dys" maxlength="3" dataformat="num" type="text" /></td>
						</tr>
						<tr class="h23">
					    	<td colspan="2">Credit Amount Limit</td>
							<td ><input id="cr_amt" style="width: 80px; ime-mode:disabled; text-align:right;" class="input" value="" name="cr_amt" maxlength="13" dataformat="num" type="text"/></td>
							<td></td>
							<td colspan="2">Revised Amount Re-Invoicing</td>
							<td >
								<select class="input" style="width:60;" name="riss_inv_flg">
				                      	<option value="Y">Y</option>
				                      	<option value="N"  selected>N</option>
				                </select>
							</td>
						</tr>
						<tr class="h23">
							<td colspan="2">Credit Start Date</td>
							<td width="150"><input id="cr_st_dt" style="width: 75px; ime-mode:disabled" class="input" value="" name="cr_st_dt" dataformat="ymd" maxlength="10" type="text" />
							    <img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_opn_dt_cal"></td>
							<td></td>
							<td colspan="2">Credit End Date</td>
							<td width="150"><input id="cr_end_dt" style="width: 85px; ime-mode:disabled" class="input" value="" name="cr_end_dt" dataformat="ymd" maxlength="10" type="text" />
							    <img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_clz_dt_cal"></td>
					    </tr>
					    <tr class="h23">
							<td colspan="3">Financial risk to release B/L and Cargo
							
								<select class="input" style="width:60;" name="cust_rlse_ctrl_flg">
				                    	<option value="" ></option>
				                      	<option value="Y" >Y</option>
				                      	<option value="N" selected>N</option>
				                </select>
							</td>
							<td></td>
							<td colspan="2">Credit Flag</td>
							<td width="70" >
								<select class="input" style="width:60;" name="cr_flg">
				                    	<option value="" ></option>
				                      	<option value="Y" >Y</option>
				                      	<option value="N" selected>N</option>
				                </select>
							</td>
						</tr>
						</table>
						</td>
						</tr>
						</table>
						
						
						
								
		<!-- Tab ) (S) -->
   		<table class="tab" border="0" cellpadding="0" cellspacing="0" style="width:979;" > 
     		<tr><td width="100%">
					<script language="javascript">ComTabObject('tab3')</script>
				</td></tr>
		</table>
		<!-- Tab ) (E) -->
		
		<!--Invoice Payment Information -->
		<div id="tabLayer_invoicepayment" style="display:inline">
			<table class="search" border="0" height=220 style="width:100%;" > 
		        <tr class="h23">
	    	    	<td class="bg">
	    	    		<table class="search" border="0" style="width:979;"> 
	    	    			<tr class="h23">
							    <td width="200">Invoicing Currency</td>
								<td width="200"><script type="text/javascript">ComComboObject('inv_iss_curr_tp_cd', 1, 150, 1, 0 ,0 ,false)</script></td>
								<td></td>
			                    <td width="200">Due Date Criteria</td>
			                    <td width=""200""><script type="text/javascript">ComComboObject('cust_cr_due_dt_div_cd', 1, 100, 1, 0 ,0 ,false)</script></td>
						    </tr>
						    <tr class="h23">
								<td width="200">Indi.Exch.Rate Apply Scope</td>
								<td width="200"><script type="text/javascript">ComComboObject('xch_rt_div_cd', 1, 200, 1, 0 ,0 ,false)</script></td>
								<td></td>
								<td width="200">Indi.Exch.Rate Apply Basis</td>
								<td width="200"><script type="text/javascript">ComComboObject('cng_indiv_cd', 1, 200, 1, 0 ,0 ,false)</script></td>
							</tr>
						    <tr class="h23">
								<td width="200">Exch.Rate Start Date</td>
								<td width="200"><input id="dy_xch_aply_st_dt" style="width: 71px; ime-mode:disabled" class="input" value="" name="dy_xch_aply_st_dt" dataformat="ymd" maxlength="10" type="text" />
									<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_dy_xch_aply_st_dt"></td>
								<td></td>
			                    <td width="200">Tax Invoice Issue Type</td>
			                    <td width=""200""><script type="text/javascript">ComComboObject('iss_div_cd', 1, 100, 1, 0 ,0 ,false)</script></td>
							</tr>
		
							<tr class="h23">
								<td width="200">Payment Date1</td>
								<td><input id="pay_dt_dy1" style="width: 80px; ime-mode:disabled; text-align:right;" class="input" value="" name="pay_dt_dy1" dataformat="num" maxlength="2" type="text" /> </td>
								<td></td>
								<td width="200">Payment Date2</td>
								<td><input id="pay_dt_dy2" style="width: 80px; ime-mode:disabled; text-align:right;" class="input" value="" name="pay_dt_dy2" dataformat="num" maxlength="2" type="text" /> </td>
							</tr>
							<tr class="h23">
								<td width="200">Payment Date3</td>
								<td><input id="pay_dt_dy3" style="width: 80px; ime-mode:disabled; text-align:right;" class="input" value="" name="pay_dt_dy3" dataformat="num" maxlength="2" type="text" /> </td>
								<td></td>
								<td width="200">Payment Date4</td>
								<td><input id="pay_dt_dy4" style="width: 80px; ime-mode:disabled; text-align:right;" class="input" value="" name="pay_dt_dy4" dataformat="num" maxlength="2" type="text" /> </td>
							</tr>	
							<tr class="h23">
								<td width="200">Collection Method</td>
								<td width="200"><script type="text/javascript">ComComboObject('pay_div_cd', 1, 80, 1, 0 ,0 ,false)</script></td>
								<td></td>
								<td width="200">Bank Account Number</td>
								<td width="200"><input id="bank_acct_no" style="width: 100px; ime-mode:disabled" class="input" value="" name="bank_acct_no" maxlength="30" dataformat="uppernum" otherchar="-" type="text" /> </td>
								
							</tr>	
							<tr class="h23">
								<td width="200">Actual Payer Code</td>
								<td width="200"><input id="act_cust_cd" style="width: 80px; ime-mode:disabled; text-align:center;" class="input" name="act_cust_cd" value="" maxlength="8" dataformat="uppernum" type="text" />
								    <img src="img/btns_search.gif" name="btn_com_ens_042" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
								<td></td>
								<td width="200">Person In Charge</td>
								<td width="200"><input id="cntc_pson_nm" style="width: 100px;" class="input" value="" name="cntc_pson_nm" maxlength="50" type="text" /></td>
							</tr>	
							<tr class="h23">
							<td width="150">Remark</td>
								<td colspan="5"><input id="cr_cust_rmk" style="width: 700px;" class="input" value="" name="cr_cust_rmk" maxlength="100" type="text" /> </td>
							</tr>	
						</table>
						<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
						<table class="search" border="0">
							<tr>
								<td class="title_h"></td>
								<td class="title_s">Refund</td></tr>
						</table>
						<table class="search" border="0" style="width:979;"> 
	    	    			<tr class="h23">
							    <td width="200">Create Refund Customer for ERP</td>
							    <td><input type="checkbox" name="rfnd_psdo_vndr_flg" value="" class="trans"></td> 
							    <td width="200">Refund Customer Code</td>
								<td width="120"><input id="rfnd_psdo_vndr_seq" style="width: 70px;" class="input2" value="" readonly name="rfnd_psdo_vndr_seq" maxlength="6" type="text" /></td>
								<td width="170"></td>
						    </tr>
						</table>
							
					</td>
				</tr>
			</table>
		</div>
		
		<!--TAB Invoice Information -->
		<div id="tabLayer_autoinvoice" style="display:none">
			<table class="search" border="0" style="width:100%;"> 
		        <tr class="h23">
	    	    	<td class="bg">
						<table class="height_8"><tr><td></td></tr></table>
						
						<!-- Grid (S) -->
						<table width="100%"  id="mainTable">
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('t2bsheet1_autoinvoice');</script>
								</td>
							</tr>
						</table>
						<!-- Grid (E) -->
						 <!--  Button_Sub (S) -->
						<table width="100%" class="button"table border="0"> 
					       	<tr><td class="btn2_bg">
								<table border="0" cellpadding="0" cellspacing="0">
								<tr>
									<td id="bth_addr_row_add"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									    <tr><td class="btn2_left"></td>
									        <td class="btn2" name="t2_btn_t1bAdd" id="t2_btn_t1bAdd">Row Add</td>
									        <td class="btn2_right"></td>
									    </tr>
										</table>
									</td>
								</tr>
								</table>
							</td></tr>
						</table>
				    	<!-- Button_Sub (E) -->
			    	</td>
		    	</tr>
	    	</table>
		</div>
		
		
		
		<!--Local Information for Invoice & Tax -->
		<div id="tabLayer_localinformation" style="display:inline">
			<table class="search" border="0" height=220 style="width:100%;" > 
		        <tr class="h23">
	    	    	<td class="bg">
	    	    		<table class="search" border="0" style="width:979;"> 
	    	    			<tr class="h23">
								<td colspan="2">Owner Name</td>
								<td width="120"><input id="ownr_nm" style="width: 110px;" class="input" value="" name="ownr_nm" maxlength="50" type="text" /> </td>
								<td></td>
								<td colspan="2">Business Category</td>
								<td width="110"><input id="bzct_nm" style="width: 110px;" class="input" value="" name="bzct_nm" maxlength="50" type="text" /> </td>
							</tr>
							<tr class="h23">
								<td colspan="2">Business Type</td>
								<td width="150"><input id="bztp_nm" style="width: 150px;" class="input" value="" name="bztp_nm" maxlength="100" type="text" /> </td>
								<td></td>
								
							</tr>
							<tr class="h23">
								<td >Local Name</td>
								<td colspan="3"><input id="locl_nm" style="width: 200px;" class="input" value="" name="locl_nm" maxlength="100" type="text" /> </td>
								<td width="150">Local Zip Code</td>
								<td colspan="3"><input id="locl_zip_cd" style="width: 200px;" class="input" value="" name="locl_zip_cd" maxlength="10" type="text" /> </td>
							</tr>
							 <tr class="h23">	
								<td >Local Address 1</td>
								<td colspan="3"><input id="locl_addr1" style="width: 200px;" class="input" value="" name="locl_addr1" maxlength="200" type="text" /> </td>
								<td width="150">Local Address 2</td>
								<td colspan="3"><input id="locl_addr2" style="width: 200px;" class="input" value="" name="locl_addr2" maxlength="200" type="text" /> </td>
							</tr>	
							<tr class="h23">
								<td >Local Address 3</td>
								<td colspan="3"><input id="locl_addr3" style="width: 200px;" class="input" value="" name="locl_addr3" maxlength="200"  type="text" /> </td>
								<td >Local Address 4</td>
								<td colspan="3"><input id="locl_addr4" style="width: 200px;" class="input" value="" name="locl_addr4" maxlength="200"  type="text" /> </td>
							</tr>
							<tr class="h23">
								<td colspan="2">O/B Tel No</td>
								<td width="100"><input id="ob_phn_no" style="width: 100px; ime-mode:disabled; text-align:left;" class="input" value="" name="ob_phn_no" maxlength="20" otherchar="-" dataformat="num" type="text" /></td>
								<td></td>
								<td colspan="2">I/B Tel No</td>
								<td width="100"><input id="ib_phn_no" style="width: 100px; ime-mode:disabled; text-align:left;" class="input" value="" name="ib_phn_no" maxlength="20" otherchar="-" dataformat="num" type="text" /></td>
							</tr>
							<tr class="h23">
								<td colspan="2">O/B Fax No</td>
								<td width="100"><input id="ob_fax_no" style="width: 100px; ime-mode:disabled; text-align:left;" class="input" value="" name="ob_fax_no" maxlength="20" otherchar="-" dataformat="num" type="text" /></td>
								<td></td>
								<td colspan="2">I/B Fax No</td>
								<td width="100"><input id="ib_fax_no" style="width: 100px; ime-mode:disabled; text-align:left;" class="input" value="" name="ib_fax_no" maxlength="20" otherchar="-" dataformat="num" type="text" /></td>
							</tr>
							<tr class="h23">
								<td colspan="2">O/B E-mail</td>
								<td colspan="2"><input id="ob_eml" style="width: 200px; ime-mode:disabled; text-align:left;" class="input" value="" name="ob_eml" maxlength="200" type="text" /></td>
								<td colspan="2">I/B E-mail</td>
								<td colspan="2"><input id="ib_eml" style="width: 200px; ime-mode:disabled; text-align:left;" class="input" value="" name="ib_eml" maxlength="200" type="text" /></td>
							</tr>	
							
						</table>
						<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
						<table class="search" border="0">
							<tr>
								<td class="title_h"></td>
								<td class="title_s">KOR Business</td></tr>
						</table>
						<table class="search" border="0" style="width:979;"> 
	    	    			<tr class="h23">
							    <td width="160">Korea Customer Type</td>
								<td width="160"><script type="text/javascript">ComComboObject('cr_cust_tp_cd', 1, 150, 1, 0 ,0 ,false)</script></td>
								<td width="170"></td>
								<td width="160">Korea I/B Office Code</td>
			                    <td ><input id="kr_ib_ofc_cd" style="width: 70px; ime-mode:disabled; text-align:center;" class="input" value="" name="kr_ib_ofc_cd" maxlength="6" dataformat="engup" type="text" />
							     <img src="img/btns_search.gif" name="btn_com_ens_072" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
						    </tr>
						</table>
					</td>
				</tr>
			</table>
		</div>
							
		<!--TAB History -->
		<div id="tabLayer_history" style="display:none">
			<table class="search" border="0" style="width:100%;"> 
		        <tr class="h23">
	    	    	<td class="bg">
						<table class="height_8"><tr><td></td></tr></table>
						
						<!-- Grid (S) -->
						<table width="100%"  id="mainTable">
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('t2bsheet1_history');</script>
								</td>
							</tr>
						</table>
						<!-- Grid (E) -->
			    	</td>
		    	</tr>
	    	</table>
		</div>
							
		<!--biz page (E)-->
		
		<!--Button (S) -->
		<table width="100%" class="button"  border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       		<tr>
       			<td class="btn1_bg">
		    		<table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td id="btn_Save1"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Save" id="btn_Save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<!-- <td id="btn_Create1"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Create">Create</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td> -->
				<!-- <td id="btn_Request1"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Request">MDM Request</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td> -->
				<td width="20" id="bottom_space"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Close">Close</td>
					<td class="btn1_right"></td>
					</tr>
				</table>
				</td>
				</tr>
				</table>
				</td>
			</tr>
		</table>
    <!--Button (E) -->
		
	</td></tr>
	</table>
	
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>