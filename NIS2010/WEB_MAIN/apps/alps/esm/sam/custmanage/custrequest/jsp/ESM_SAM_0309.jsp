<%
/*
=========================================================
*Copyright(c) 2017 Hipluscard. All Rights Reserved.
*@FileName   : ESM_SAM_0309.jsp
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
<%@ page import="com.hanjin.apps.alps.esm.sam.custmanage.custrequest.event.EsmSam0309Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmSam0309Event  event = null;				//PDTO(Data Transfer Object including Parameters)
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
	String rqstNo		= JSPUtil.getParameter(request, "rqst_no");
	String mainPage 		= "";
    mainPage = request.getParameter("main_page");
	try {
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		
		event = (EsmSam0309Event)request.getAttribute("Event");
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
<input type="hidden" name="delt_flg" value="">
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
							<td width="110">Request No</td>
							<td width="150">
								<input id="rqst_no" style="width: 100px; text-align: center; ime-mode:disabled;" class="input1" name="rqst_no" value="<%=rqstNo%>" maxlength="8" dataformat="int" type="text" >
								</td>
							</td>
							
							<td width="120">Group/Individual</td>
							<td width="135">
						    			<select id="grp_indiv_div" class="input1" style="width:100;" name="grp_indiv_div" >
					                    	<option value="" selected></option>
					                      	<option value="I">Individual</option>
					                      	<option value="G">Group</option>
					                    </select>
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
							<td width="">Address</td>
							<td width="" style="padding-left:2">
								<input id="bzet_addr" style="width: 280px;" class="input1" value="" name="bzet_addr" maxlength="200" type="text" dataformat="uppernum" >
							</td>
							<td> </td>
							<td> </td>
						</tr>
					</table>
					<table class="search" border="0" style="width:979;"> 
						
						<tr class="h23">
							<td width="130">Tax Payer ID</td>
							<td width="" style="padding-left:2">
								<input id="cust_rgst_no" style="width: 280px;" class="input" value="" name="cust_rgst_no" maxlength="20"  type="text" dataformat="uppernum" >
							</td>
							
							<td width="160">Named BIZ Customer</td>
							    <td><input type="checkbox" name="nmd_cust_flg" value="" class="trans"></td> 
							<td width="50"></td>
							<td width="100">Request Status</td>
								<td><input id="rqst_sts" readonly style="width: 70px;" class="input" value="" name="rqst_sts" maxlength="4" type="text" /></td>
							<td width="100"></td>
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
							<td width="">C-TPAT SVI #</td>
							<td>
								<input id="cts_no" style="width: 80px; text-align:center;" class="input" value="" name="cts_no" maxlength="11" dataformat="uppernum" type="text" >
							</td>
							<td width="">Group Customer</td>
							<td width="" >
								<input otherchar="-" id="cust_grp_id" style="width: 100px; ime-mode:disabled; text-align:center;" maxlength="10" name="cust_grp_id" class="input" value="" dataformat="uppernum" type="text" >
								<img src="img/btns_search.gif" name="btn_esm_sam_0301" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
					    		<td width="110">Major Trade Type</td>
					    		<td> <script type="text/javascript">ComComboObject('prf_svc_desc', 2, 80, '')</script></td>
					    		<td> <script type="text/javascript">ComComboObject('prf_svc_dtl_desc', 2, 80, '')</script></td>
						</tr>
					</table>
					<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
					<table class="search" border="0" style="width:979;"> 
							<tr class="h23">
		 			    		<td width="120">Phone #</td>
					    		<td width="20" >
								<script type="text/javascript">ComComboObject('intl_phn_no', 2, 50, true, '')</script>
								</td>
					    		<td><input id="phn_no" style="width: 100px;" class="input" value="" name="phn_no" maxlength="20" type="text" /></td>
					    		<td width="60">Fax #</td>
					    		<td width="20" >
								<script type="text/javascript">ComComboObject('intl_fax_no', 2, 50, true, '')</script>
								</td>
					    		<td><input id="fax_no" style="width: 100px;" class="input" value="" name="fax_no" maxlength="20" type="text" /></td>
					    		<td width="45">Email</td>
					    		<td><input id="cust_eml" style="width: 150px;" class="input" value="" name="cust_eml" maxlength="50" type="text" /></td>
					    		<td width="30">URL</td>
					    		<td><input id="cust_url" style="width: 180px;" class="input" value="" name="cust_url" maxlength="50" type="text" /></td>
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
							    <td><input id="crnt_vol_knt" style="width: 84px; text-align:right;" class="input" value="" name="crnt_vol_knt" maxlength="100" type="text" dataformat="int"/></td>
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
						<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
						<table class="search" border="0">
							<tr>
								<td class="title_h"></td>
								<td class="title_s">NVOCC</td></tr>
							<tr><td class="height_5"></td></tr>
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
			
				</td>
			</tr>
		</table>
		<!--biz page (E)-->
		
		
		<!--Button (S) -->
		<table width="100%" class="button"  border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       		<tr>
       			<td class="btn1_bg">
		    		<table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_CheckDup" id="btn_CheckDup">Check Duplicate</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
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
				
				<td id="btn_Request1"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button" >
					<tr><td class="btn1_left" ></td>
					<td class="btn1" name="btn_Request" id="btn_Request">MDM Request</td>
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

