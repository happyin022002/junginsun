<%
/*
=========================================================
*Copyright(c) 2017 Hipluscard. All Rights Reserved.
*@FileName   : ESM_SAM_0302.jsp
*@FileTitle  : Customer
*@author     : Hipluscard
*@version    : 1.0
*@since      : 2017/06/07 
=========================================================
*/
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
<%@ page import="com.hanjin.apps.alps.esm.sam.custmanage.custmain.event.EsmSam0302Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmSam0302Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	String screenName		= "";
	
	Logger log = Logger.getLogger("com.hanjin.apps.custmanage.custmain");
	// 승인처리용 정보
	String procTpCd		= JSPUtil.getParameter(request, "proc_tp_cd");
	String custCd		= JSPUtil.getParameter(request, "cust_cd");
	String custCntCd	= JSPUtil.getParameter(request, "cust_cnt_cd");
	String custSeq		= JSPUtil.getParameter(request, "cust_seq");
	String mainPage 		= "";
    mainPage = request.getParameter("main_page");
	try {
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		
		event = (EsmSam0302Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		log.debug("====================================");
		Screen screen = (Screen) request.getAttribute(WebKeys.CURRENT_SCREEN);
		screenName = screen.getName();
		log.debug("====================================");
	} catch(Exception e) {
		out.println(e.toString());
	}
%>

<html>
<head>
<title>MDM Customer</title>
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
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="screenName" value="<%=screenName %>">
<input type="hidden" name="cust_cnt_cd">
<input type="hidden" name="cust_seq">
<input type="hidden" name="creflag" value="N">
<input type="hidden" name="saveflag" value="N">
<input type="hidden" name="ibflag" value="">
<input type="hidden" name="file_sav_id" value="">
<input type="hidden" name="file_nm" value="">
<input type="hidden" name="intl_no" value="">
<input type="hidden" name="crm_row_id" value="">
<input type="hidden" name="proc_tp_cd" value="<%=procTpCd %>">
<textarea name="keys" style="width:100%; height:10px;display:none"></textarea>


<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	
	<tr><td class="top"></td></tr>
	<tr><td valign="top">
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title">&nbsp; MDM Customer</span></td></tr>
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
							<td width="110">Customer Code</td>
							<td width="200">
								<input id="cust_cd" style="width: 80px; text-align: center; ime-mode:disabled;" class="input1" name="cust_cd" value="<%=custCd%>" maxlength="8" dataformat="uppernum" type="text" >
								<img src="img/btns_search.gif" name="btn_com_ens_041" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
							</td>
							<td width="450"><div style="display:none;width:450;color:red;" id="user_mdm_auth"></div></td>
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
						<tr class="h23">
							<td width="130">Legal English Name</td>
							<td width="90" style="padding-left:2">
								<input id="cust_lgl_eng_nm" style="width: 280px;" class="input1" value="" name="cust_lgl_eng_nm" maxlength="100" dataformat="uppernum" otherchar="!@&()_/\- " type="text"  >
							</td>
							<td width="50"> </td>
							<td width="140">Local Language Name</td>
							<td width="90">
								<input id="cust_locl_lang_nm" style="width: 280px;" class="input" value="" name="cust_locl_lang_nm" maxlength="100"  type="text" >	
							</td>
							<td> </td>
							<td> </td>
						</tr>
						
						<tr class="h23">
							<td width="">Address</td>
							<td width="" style="padding-left:2">
								<input id="bzet_addr" style="width: 280px;" class="input1" value="" name="bzet_addr" maxlength="200" type="text" dataformat="uppernum" >
							</td>
							<td> </td>
							<td width="">Abbreviation</td>
							<td width="">
								<input id="cust_abbr_nm" style="width: 280px;" class="input" value="" name="cust_abbr_nm" maxlength="50" type="text" dataformat="uppernum" > 
							</td>
						</tr>
					</table>
					<table class="search" border="0" style="width:979;"> 
						
						<tr class="h23">
							<td width="144">Tax Payer ID</td>
							<td width="" style="padding-left:2">
								<input id="cust_rgst_no" style="width: 280px;" class="input" value="" name="cust_rgst_no" maxlength="20"  type="text" dataformat="uppernum" >
							</td>
							
							<td width="160">Named BIZ Customer</td>
							    <td><input type="checkbox" name="nmd_cust_flg" value="" class="trans"></td> 
							<td width="50"></td>
							<td width="50">No Use</td>
							    <td><input type="checkbox" name="delt_flg" value="" class="trans" onClick="deleteMsg()"></td> 
							<td width="150"></td>
						</tr>
					</table>	
			
					<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>

			
					<table class="search" border="0" style="width:979;"> 
						<tr class="h23">
							<td width="150">Location Code</td>
							<td width="150" >
								<input id="loc_cd" style="width: 100px; text-align:center;" class="input1" value="" name="loc_cd" maxlength="5" dataformat="engup" type="text" >
								<img src="img/btns_search.gif" name="btn_com_ens_051" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
							<td width="150">REP. Office</td>
							<td width="150" >
								<input id="ofc_cd" style="width: 80px; text-align:center;" class="input1" value="" name="ofc_cd" maxlength="6" dataformat="engup" type="text" >
								<img src="img/btns_search.gif" name="btn_com_ens_071" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
							<td width="150">Sales Rep Code</td>
							<td width="150" >
								<input id="srep_cd" style="width: 100px; text-align:center;" class="input1" value="" name="srep_cd" maxlength="5" dataformat="uppernum" type="text" >
								<img src="img/btns_search.gif" name="btn_com_ens_043" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
							</td>
							<td width="150">Customer Type</td>
							<td width="150" >
								<script type="text/javascript">ComComboObject('rvis_cntr_cust_tp_cd', 1, 100, true, '')</script>
							</td>
						</tr>
						<tr class="h23">
							<td width="150">Firm/Private</td>
							<td width="150" >
								<script type="text/javascript">ComComboObject('indiv_corp_div_cd', 1, 100, true, '')</script></td>
							
							<td width="">C-TPAT SVI #</td>
							<td>
								<input id="cts_no" style="width: 80px; text-align:center;" class="input" value="" name="cts_no" maxlength="11" dataformat="uppernum" type="text" >
							</td>
							<td width="">Group Customer</td>
							<td width="" >
								<input otherchar="-" id="cust_grp_id" style="width: 100px; ime-mode:disabled; text-align:center;" maxlength="10" name="cust_grp_id" class="input" value="" dataformat="uppernum" type="text" >
								<img src="img/btns_search.gif" name="btn_esm_sam_0301" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
							<td width="150"></td>
							<td width="150"></td>
						</tr>
						<tr class="h23">
							<td width="">Need Base Seg. Class1</td>
							<td width="" >
								<script type="text/javascript">ComComboObject('nbs_clss_cd1', 1, 100, 1, 0 ,0 ,false)</script>
							</td>
							<td width="">Need Base Seg. Class2</td>
							<td width="" >
								<script type="text/javascript">ComComboObject('nbs_clss_cd2', 1, 100, 1, 0 ,0 ,false)</script>
							</td>
							<td width="">Need Base Seg. Class3</td>
							<td width="" >
								<script type="text/javascript">ComComboObject('nbs_clss_cd3', 1, 100, 1, 0 ,0 ,false)</script>
							</td>
							<td width="">Value Base Seg. Class</td>
							<td width="" >
								<script type="text/javascript">ComComboObject('vbs_clss_cd', 1, 100, 1, 0 ,0 ,false)</script>
							</td>
						</tr>
					</table>
			
					<!-- <table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
			
					<table class="search" border="0" style="width:979;"> 
						<tr class="h23">
							<td width="150">Delete Flag</td>
							<td width="150" >
								<select style="width: 100px;" class="input" name="delt_flg" id="delt_flg" onChange="obj_change()";><option value="N">N</option><option value="Y" >Y</option></select>
							</td>
							<td width="150"></td>
							<td width="150" >
								
							</td>
							<td width="150"></td>
							<td width="150" >
								
							</td>
							<td width="150"></td>
							<td width="150" >
								
							</td>
					</table>	 -->
			
					
				</td>
			</tr>
		</table>
		<!--biz page (E)-->
		
		<!-- Tab ) (S) -->
   		<table class="tab" border="0" cellpadding="0" cellspacing="0" style="width:979;" > 
     		<tr><td width="100%">
					<script language="javascript">ComTabObject('tab3')</script>
				</td></tr>
		</table>
		<!-- Tab ) (E) -->
		
		<!--TAB More Information -->
		<div id="tabLayer_moreinfo" style="display:inline">
			<table class="search" border="0" height=220 style="width:100%;" > 
		        <tr class="h23">
	    	    	<td class="bg">
	    	    		<table class="search" border="0" style="width:979;"> 
							<tr class="h23">
		 			    		<td width="120">Phone #</td>
					    		<!-- <td><input id="intl_phn_no" style="width: 30px;" class="input" value="" name="intl_phn_no" maxlength="4" type="text" /></td> -->
					    		<td width="20" >
								<script type="text/javascript">ComComboObject('intl_phn_no', 2, 50, true, '')</script>
								</td>
					    		
					    		<td><input id="phn_no" style="width: 100px;" class="input" value="" name="phn_no" maxlength="20" type="text" /></td>
					    		<td width="60">Fax #</td>
					    		<td width="20" >
								<script type="text/javascript">ComComboObject('intl_fax_no', 2, 50, true, '')</script>
								</td>
					    		<!-- <td><input id="intl_fax_no" style="width: 30px;" class="input" value="" name="intl_fax_no" maxlength="4" type="text" /></td> -->
					    		<td><input id="fax_no" style="width: 100px;" class="input" value="" name="fax_no" maxlength="20" type="text" /></td>
					    		<td width="54">Email</td>
					    		<td><input id="cust_eml" style="width: 150px;" class="input" value="" name="cust_eml" maxlength="50" type="text" /></td>
					    		<td width="40">URL</td>
					    		<td><input id="cust_url" style="width: 200px;" class="input" value="" name="cust_url" maxlength="50" type="text" /></td>
				   			 </tr>
						</table>
	    	    
		    	    	<table class="search" border="0" style="width:979;"> 
							<tr class="h23">
		 			    		<td width="120">Industry Type</td>
					    		<td><input id="indus_desc" style="width: 290px;" class="input" value="" name="indus_desc" maxlength="100" type="text" /></td>
					    		<td width="28"> </td>
					    		<td width="110">Major Trade Type</td>
					    		<td> <script type="text/javascript">ComComboObject('prf_svc_desc', 2, 80, '')</script></td>
					    		<td> <script type="text/javascript">ComComboObject('prf_svc_dtl_desc', 2, 80, '')</script></td>
					    		<td width="175"> </td>
					    		
				   			 </tr>
						</table>
						<table class="search" border="0" style="width:979;"> 
							<tr class="h23">
				 			    <td width="120">CUST Competitor</td>
							    <td><input id="cmpt_desc" style="width: 290px;" class="input" value="" name="cmpt_desc" maxlength="100" type="text" /></td>
							    <td width="70"> </td>
							    <td width="105">Delivery Req</td>
							    <td><input id="spcl_req_desc" style="width: 340px;" class="input" value="" name="spcl_req_desc" maxlength="1000" type="text" /></td>
							    <td width="5"> </td>
							    
						    </tr>
						</table>
						<table class="search" border="0" style="width:979;"> 
							<tr class="h23">
				 			    <td width="120">Equipment</td>
				 			       <td><script type="text/javascript">ComComboObject('prf_cntr_tpsz_cd', 2, 80, '')</script></td>
							    <td width="140">Yearly Volume(TEU)</td>
							    <td><input id="crnt_vol_knt" style="width: 84px; text-align:right;" class="input" value="" name="crnt_vol_knt" maxlength="100" type="text" dataformat="int" /></td>
							    <td width="120">Core Customer</td>
							    <td><input type="checkbox" name="new_key_acct_flg" value="" class="trans"></td> 
							    <td width="95"> </td>
							    <td width="140">Regional Customer</td>
							    <td><input type="checkbox" name="rgn_acct_flg" value="" class="trans"></td>
							    <td width="80"> </td>
						    </tr>
						</table>
						
						<table class="search" border="0" style="width:979;"> 
							<tr class="h23">
								<td width="120">Customer Remark</td>
							    <td><textarea input id="cust_rmk" style="width: 340px; height:80px;" class="input" value="" name="cust_rmk" maxlength="500" type="text" /></textarea></td>
							    <td width="115">Booking Alert Reason</td>
							    <td><textarea input id="bkg_alt_rsn" style="width: 340px; height:80px;" class="input" value="" name="bkg_alt_rsn" maxlength="4000" type="text" /></textarea></td>
							</tr>
							
						
						</table>
						<table class="search" border="0" style="width:979;"> 
							<tr class="h23">
								<td width="120">BKG Alert Period</td>
								<td width="" >
							    	<input type="text" style="width:80" value="" class="input"  name="bkg_alt_fm_dt"  maxlength='10' dataformat="ymd" >
											 &nbsp;~&nbsp;
											  <input type="text" style="width:80" value="" class="input"  name="bkg_alt_to_dt"  maxlength='10' dataformat="ymd" >
											  <img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="bkg_alt_date">
								</td>
								<td width="143"></td>
							    <td width="115">Msg to Booking Staff</td>
							    <td><textarea input id="bkg_alt_msg" style="width: 340px; height:80px;" class="input" value="" name="bkg_alt_msg" maxlength="4000" type="text" /></textarea></td>
							</tr>
						</table>
						
					</td>
				</tr>
			</table>
		</div>
			
		<!--TAB NVOCC Information -->
		<div id="tabLayer_more2" style="display:none">
			
			<table class="search" border="0" height=220 style="width:100%;" > 
				<tr class="h23">
		    		<td class="bg">
		    			<table class="search" border="0">
							<tr>
								<td class="title_h"></td>
								<td class="title_s">NVOCC</td></tr>
						</table>
		    			<table class="search" border="0" style="width:979;"> 
							<tr class="h23">
		 			    		<td width="120">OTI License #</td>
					    		<td><input id="nvocc_lic_no" style="width: 100px;" class="input" value="" name="nvocc_lic_no" maxlength="20" dataformat="uppernum" type="text" /></td>
					    		<td width="120">OTI Bond #</td>
					    		<td><input id="nvocc_bd_no" style="width: 100px;" class="input" value="" name="nvocc_bd_no" maxlength="20" dataformat="uppernum" type="text" /></td>
					    		<td width="120">OTI Bond Amount</td>
					    		<td><input id="nvocc_bd_amt" style="width: 150px; text-align:right;" class="input" value="" name="nvocc_bd_amt" dataformat="float" maxlength="50" type="text" /></td>
				   			 </tr>
				   			 <tr class="h23">
		 			    		<td width="120">NVOCC SCAC</td>
					    		<td><input id="nvocc_hjs_scac_cd" style="width: 100px;" class="input" value="" name="nvocc_hjs_scac_cd" maxlength="10" dataformat="uppernum" type="text" /></td>
					    		<td width="120">F/F FMC License #</td>
					    		<td><input id="frt_fwrd_fmc_no" style="width: 100px;" class="input" value="" name="frt_fwrd_fmc_no" maxlength="20" dataformat="uppernum" type="text" /></td>
					    		<td width="120">Eff. Date</td>
					    		<td><input type="text" style="width:80" value="" class="input"  name="nvocc_bd_st_eff_dt"  maxlength='10' dataformat="ymd" >
											 &nbsp;~&nbsp;
											  <input type="text" style="width:80" value="" class="input"  name="nvocc_bd_end_eff_dt"  maxlength='10' dataformat="ymd" >
											  <img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="nvocc_bd_eff_date"></td>
				   			 </tr>
				   			 <tr class="h23">
		 			    		<td width="120">OTI Organization #</td>
					    		<td><input id="oti_orz_no" style="width: 100px;" class="input" value="" name="oti_orz_no" maxlength="6" dataformat="uppernum" type="text" /></td>
					    	 </tr>
						</table>
						<table class="search" border="0">
							<tr>
								<td class="title_h"></td>
								<td class="title_s">INDIA</td></tr>
						</table>
						<table class="search" border="0" style="width:979;"> 
							<tr class="h23">
		 			    		<td width="120">State Code</td>
		 			    		<!-- <td><script type="text/javascript">ComComboObject('ida_ste_cd', 3, 100, '')</script></td> -->
		 			    		<td><input id="ida_ste_cd" style="width: 100px; text-align:center;" class="input2" value="" name="ida_ste_cd" readonly maxlength="2" type="text" /></td>
					    		<td width="120">State Name</td>
					    		<td><input id="ste_nm" style="width: 190px;" class="input2" value="" name="ste_nm" readonly maxlength="50" type="text" /></td>
					    		<td width="150">State Type</td>
					    		<td><input id="ida_terr_div_cd" style="width: 150px; text-align:center;" class="input2" value="" name="ida_terr_div_cd" readonly maxlength="10" type="text" /></td>
				   			 </tr>
				   		</table>
				   		<table class="search" border="0" style="width:979;"> 
							<tr class="h23">
		 			    		<td width="120">PAN No</td>
					    		<td><input id="ida_pan_no" style="width: 100px;" class="input" value="" name="ida_pan_no" maxlength="10" dataformat="uppernum" type="text" /></td>
					    		<td width="120">GST Registration Number/UIN</td>
					    		<td><input id="ida_gst_rgst_no" style="width: 190px;" class="input" value="" name="ida_gst_rgst_no" maxlength="15" dataformat="uppernum" type="text" /></td>
					    		<td width="150">Company Type</td>
								<td width="150" >
								<script type="text/javascript">ComComboObject('ida_co_type_cd', 1, 150, '')</script></td>
								<td width="50"></td>
				   			 </tr>
				   		</table>
				   		<table class="search" border="0" style="width:979;"> 
							<tr class="h23">
				   			<td width="120">Email</td>
					    		<td><input id="cust_eml_add" style="width: 320px;" class="input" value="" name="cust_eml_add" maxlength="50" type="text" readonly /></td>
					    		<td width="120">Email (Additional)</td>
					    		<td><input id="ida_cust_eml" style="width: 320px;" class="input" value="" name="ida_cust_eml" maxlength="50" type="text" /></td>
					    	</tr>
				   		</table>
				   		<table class="search" border="0" style="width:979;"> 
							<tr class="h23">
					    		<td width="120">SEZ unit</td>
					    		<td width="135">
					    			<select class="input" style="width:40;" name="ida_spcl_ecn_zn_ut_flg">
				                    	<option value="" selected></option>
				                      	<option value="Y">Y</option>
				                      	<option value="N">N</option>
				                    </select>
				                </td>
		 			    		<td width="120">SEZ Certificate</td>
		 			    		<td>
		 			    		   <label id="file_nm" style="width: 150px;"></label> 	
<!-- 					    		   <input id="file_nm" style="width: 150px;" class="input" value="" name="file_nm" readonly maxlength="10" type="text" /> -->
					    		   <img src="img/button/btns_filesearch.gif" name="btn_t2BLRider" width="80" height="20" alt="" border="0" align="absmiddle" class="btn2">
					    		   <img src="img/button/btng_delete.gif" name="btn_t2Del" width="80" height="20" alt="" border="0" align="absmiddle" class="btn2"></td>
					    		
					    		<td width="250"></td>
				   			 </tr>
				   		</table>
				   		<table class="search" border="0">
							<tr>
								<td class="title_h"></td>
								<td class="title_s">CHINA</td></tr>
						</table>
						<table class="search" border="0" style="width:979;"> 
							<tr class="h23">
							<td width="120">Company Code</td>
							<td width="110" >
								<script type="text/javascript">ComComboObject('co_chn_tp_cd', 1, 100, true, '')</script></td>
							<td><input id="co_chn_no" style="width: 160px;" class="input" value="" name="co_chn_no" maxlength="20" dataformat="uppernum" type="text" /></td>
							<td width="150"></td>
							<td width="300"></td>
							</tr>
						</table>
						<table class="search" border="0">
							<tr>
								<td class="title_h"></td>
								<td class="title_s">INDONESIA</td></tr>
						</table>
						<table class="search" border="0" style="width:979;"> 
							<tr class="h23">
							<td width="120">NPWP</td>
							<td><input id="id_npwp_rgst_no" style="width: 190px;" class="input" value="" name="id_npwp_rgst_no" maxlength="15" dataformat="uppernum" type="text" /></td>
							<td width="150"></td>
							<td width="300"></td>
							</tr>
						</table>
		    		</td>
		    	</tr>
		    </table>
		</div>
		
		<!--TAB Keyman Information -->
		<div id="tabLayer_keyman" style="display:none">
			<table class="search" border="0" style="width:100%;"> 
		        <tr class="h23">
	    	    	<td class="bg">
						<table class="height_8"><tr><td></td></tr></table>
						
						<!-- Grid (S) -->
						<table width="100%"  id="mainTable">
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('t2bsheet1_keyman');</script>
								</td>
							</tr>
						</table>
						<!-- Grid (E) -->
					
			            <!--  Button_Sub (S) -->
						<table width="100%" class="button"table border="0"> 
					       	<tr><td class="btn2_bg">
								<table border="0" cellpadding="0" cellspacing="0">
								<tr>
									<td id="bth_key_row_add"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									    <tr><td class="btn2_left"></td>
									        <td class="btn2" name="t2_btn_t3bAdd" id="t2_btn_t3bAdd">Row Add</td>
									        <td class="btn2_right"></td>
									    </tr>
									</table></td>
									
									<td id="bth_key_row_del"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									    <tr><td class="btn2_left"></td>
									        <td class="btn2" name="t2_btn_t3bDel" id="t2_btn_t3bDel">Row Delete</td>
									        <td class="btn2_right"></td>
									    </tr>
									</table></td>
								</tr>
								</table>
							</td></tr>
						</table>
				    	<!-- Button_Sub (E) -->
			    	</td>
		    	</tr>
	    	</table>
		</div>
		
		<!--TAB Adress Information -->
		<div id="tabLayer_adress" style="display:none">
			<table class="search" border="0" style="width:100%;"> 
		        <tr class="h23">
	    	    	<td class="bg">
						<table class="height_8"><tr><td></td></tr></table>
						
						<!-- Grid (S) -->
						<table width="100%"  id="mainTable">
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('t2bsheet1_adress');</script>
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
									        <td class="btn2" name="t2_btn_t4bAdd" id="t2_btn_t4bAdd">Row Add</td>
									        <td class="btn2_right"></td>
									    </tr>
										</table>
									</td>
									<td id="bth_addr_row_del"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									    <tr><td class="btn2_left"></td>
									        <td class="btn2" name="t2_btn_t4bDel" id="t2_btn_t4bDel">Row Delete</td>
									        <td class="btn2_right"></td>
									    </tr>
									</table></td>
								</tr>
								</table>
							</td></tr>
						</table>
				    	<!-- Button_Sub (E) -->
			    	</td>
		    	</tr>
	    	</table>
		</div>
		
		<!--TAB Coverage Team Information -->
		<div id="tabLayer_coverage" style="display:none">
			<table class="search" border="0" style="width:100%;"> 
		        <tr class="h23">
	    	    	<td class="bg">
						<table class="height_8"><tr><td></td></tr></table>
						
						<!-- Grid (S) -->
						<table width="100%"  id="mainTable">
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('t2bsheet1_coverage');</script>
								</td>
							</tr>
						</table>
						<!-- Grid (E) -->
					
			            <!--  Button_Sub (S) -->
						<table width="100%" class="button"table border="0"> 
					       	<tr><td class="btn2_bg">
								<table border="0" cellpadding="0" cellspacing="0">
								<tr>
									<td id="bth_cov_row_add"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									    <tr><td class="btn2_left"></td>
									        <td class="btn2" name="t2_btn_t5bAdd" id="t2_btn_t5bAdd">Row Add</td>
									        <td class="btn2_right"></td>
									    </tr>
								    </table></td>
									<td id="bth_cov_row_del"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									    <tr><td class="btn2_left"></td>
									        <td class="btn2" name="t2_btn_t5bDel" id="t2_btn_t5bDel">Row Delete</td>
									        <td class="btn2_right"></td>
									    </tr>
									</table></td>
								</tr>
								</table>
							</td></tr>
						</table>
				    	<!-- Button_Sub (E) -->
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
		
<!--Button (S) -->
		<table width="100%" class="button"  border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       		<tr>
       			<td class="btn1_bg">
		    		<table border="0" cellpadding="0" cellspacing="0">
		    <tr>
		    	<td id="btn_GstSave1"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_GstSave" id="btn_GstSave">GST Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
		    
<!-- 				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_CheckDup" id="btn_CheckDup">Check Duplicate</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td> -->
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td id="btn_Save1"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Save" id="btn_Save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td id="btn_Create1"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Create">Create</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
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

