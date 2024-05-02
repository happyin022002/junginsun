<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESS_MNR_0155.jsp
*@FileTitle : Disposal Buyer Management
*Open Issues :
*Change history :
*@LastModifyDate : 2012.11.08
*@LastModifier : 조경완
*@LastVersion : 1.0
* 2009.10.05 권영법
* 1.0 Creation
* --------------------------------------------------------
* History
* 2012.06.19 김창헌 [CHM-201218379-01] E-Mail을 multi로 보내는 기능 추가
* 2012.11.08 조경완 [CHM-201220026-01] CTRL RHQ AND OFFICE 로 조회하는 기능 구현 요청
* 								   - Creation Office 조건은 MNR_PARTNER.CTRL_OFC_CD IN (Multi CreOfc), 
* 									 CTRL Office 조회는 MNR_PRNR_CNTC_PNT.OFC_CD IN (Multi CtrlOfc) 로 조회된 Data Display되도록 개발 
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.mnr.generalmanage.partnermgt.event.EesMnr0155Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMnr0155Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String currOfcCd		= "";
	String strUsr_eml		= "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		currOfcCd       = account.getOfc_cd();
		strUsr_eml = account.getUsr_eml();
	   
		event = (EesMnr0155Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title><span id="title"></span></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
    var currOfcCd = "<%=currOfcCd.trim() %>";
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="f_gubuns"  value="">
<input type="hidden" name="mnr_prnr_cre_seq" value="">
<input type="hidden" name="ctrl_ofc_cd"  value="">
<input type="hidden" name="cre_dt"  value="">
<input type="hidden" name="mnr_grp_tp_cd" value="DSP">
<input type="hidden" name="mnr_prnr_tp_cd" value=""> <!-- S - Service Provider B - Buyer -->
<input type="hidden" name="mnr_prnr_sts_cd"> <!--status save 시-->
<input type="hidden" name="upd_dt"> 
<input type="hidden" name="edi_id"> 
<input type="hidden" name="mnr_prnr_locl_lang_nm"> 
<input type="hidden" name="bzet_addr"> 
<input type="hidden" name="mnr_payr_cnt_cd"> 
<input type="hidden" name="mnr_payr_seq"> 
<input type="hidden" name="mnr_prnr_capi_amt"> 
<input type="hidden" name="mnr_prnr_abbr_nm"> 
<input type="hidden" name="intl_phn_no"> 
<input type="hidden" name="intl_fax_no"> 
<input type="hidden" name="trsm_mod_cd"> 
<input type="hidden" name="file_seq"> 
<input type="hidden" name="pagerows"> 
<input type="hidden" name="cre_ofc_nm" value="">
<input type="hidden" name="param_ctrl_ofc_nm" value="">

<!-- 개발자 작업	-->
<input type="hidden" name="argument">
<input type="hidden" name="com_recipient" value="">
<input type="hidden" name="com_subject">
<input type="hidden" name="com_content">
<input type="hidden" name="curr_dt">
<input type="hidden" name="com_from" value="<%=strUsr_eml%>">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	
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
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_remove">Delete</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_reject">Reject</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_confirm">Confirm</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_expire">Expire</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_send">Email Send</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				</tr>
			</table>
		</td></tr>
		</table>
    	<!--Button (E) -->
	
	<!--biz page (S)-->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
			
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="75" align=right>Buyer Type</td>
					<td width="100"><script language="javascript">ComComboObject('combo_in_mnr_prnr_knd_cd',2, 100 , 1, 0,2,false,1);</script>
						<input type="hidden" name="in_mnr_prnr_knd_cd"></td>
					<td width="65" align=right>Status</td>
					<td width="80"><script language="javascript">ComComboObject('combo_in_mnr_prnr_sts_cd',2, 80 , 1, 0,2,false,1);</script>
						<input type="hidden" name="in_mnr_prnr_sts_cd"></td>
					<td width="65" align=right>Period</td>
					<td width="250"><input type="text" style="width:80;text-align:center" class="input" name="fromcal" dataformat="ymd" required  fulfill >
						&nbsp;~&nbsp;<input type="text" style="width:80;text-align:center" class="input" name="tocal" dataformat="ymd" required  fulfill >&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_calendar">
			        </td>
			        <td width="100">&nbsp;&nbsp;Creation OFC</td>
					<td width="120"><input type="text" name="cre_ofc_cd" style="width:80;" class="input"  maxlength="6" dataformat="engup">&nbsp;<img name="cre_ofc_cd_popup" src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
					<td width="80">&nbsp;&nbsp;CTRL OFC</td>
					<td width="120"><input type="text" name="param_ctrl_ofc_cd" style="width:80;" class="input"  maxlength="6" dataformat="engup">&nbsp;<img name="ctrl_ofc_cd_popup" src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
				   	<td width="">&nbsp;&nbsp;</td>
				   </tr> 
				</table>				
				<!--  biz_1   (E) -->
				
				
		</td></tr></table>
		<table class="height_8"><tr><td></td></tr></table>	
		<table class="search"> 
       		<tr><td class="bg">
       		<table class="search" border="0" style="width:979;"> 
			<tr>
			<td width="400" valign="top" ><!-- Grid  (S) -->
				<table width="100%"  id="mainTable" border=0> 
					<tr>
						<td width="100%"><script language="javascript">ComSheetObject('sheet1');</script></td>
					</tr>
				</table><!-- Grid (E) -->
			</td>
	<td width="15"></td>
	<td width="564" valign="top">
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Basic Information</td></tr>
				</table>
				
				<!-- biz_1  (S) -->
				<table class="search" border="0" style="width:563;"> 
				<tr class="h23">
					<td width="100">Company Name</td>
					<td width="120"><input type="text" name="mnr_prnr_lgl_eng_nm" style="width:100" title="" class="input2" style="ime-mode:disabled" maxlength="100"></td>
					<td width="50">Customer</td>
					<td width=""><input type="text" name="mnr_prnr_cnt_cd" style="width:35" maxlength="2" class="input1" dataformat="engup">&nbsp;<input type="text" name="mnr_prnr_seq" style="width:55" value="" class="input1" maxlength="9" dataformat="engup">&nbsp;<img class="cursor" name="btn_customer" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">&nbsp;<input type="text" name="mnr_prnr_cnt_nm" style="width:154" value="" class="input2" readonly title=""></td>
				</tr>
				</table>
				<table class="search" border="0" style="width:563;"> 
				<tr class="h23">
					<td width="75">Buyer Type</td>
					<td width="117"><script language="javascript">ComComboObject('combo_mnr_prnr_knd_cd',2, 105 , 1, 1,2,false,1);</script>
						<input type="hidden" name="mnr_prnr_knd_cd"></td>
					<td width="80">Buyer Detail</td>
					<td width="113"><script language="javascript">ComComboObject('combo_mnr_prnr_knd_dtl_cd',2, 90 , 1, 1,2,false,1);</script>
						<input type="hidden" name="mnr_prnr_knd_dtl_cd"></td>
					<td width="47">Status</td>
					<td width=""><input type="text" name="mnr_prnr_sts_nm" value="" class="input2" readonly></td>
				</tr>
				</table>
				<table class="search" border="0" style="width:563;"> 
				<tr class="h23">
					<td width="120">Business  Category</td>
					<td width="100"><input name="bzct_nm" type="text" style="width:80" value="" class="input" style="ime-mode:disabled" maxlength="200" ></td>
					<td width="90">Business  Type</td>
					<td width="100"><input name="bztp_nm" type="text" style="width:80" value="" class="input" style="ime-mode:disabled" maxlength="100"></td>
					<td width="65">Employee</td>
					<td width=""><input type="text"  name="empe_knt"  style="width:81;text-align:right" value="" class="input" dataformat="int"  maxlength="5"></td>
				</tr>
				</table>
				<table class="search" border="0" style="width:563;"> 
				<tr class="h23">
					<td width="60">Owner</td>
					<td width="160"><input type="text"  name="ownr_nm" style="width:140;text-align:left" value="" class="input" style="ime-mode:disabled" maxlength="100"></td>
					<td width="90">Register No.</td>
					<td width="100"><input type="text"  name="biz_rgst_no" style="width:80;text-align:left" value="" class="input" style="ime-mode:disabled" maxlength="30"></td>
					<td width="65">Zip/Post</td>
					<td width=""><input type="text"  name="zip_cd" style="width:81;text-align:left" value="" class="input" style="ime-mode:disabled" maxlength="10"></td>
				</tr>
				</table>	
				<table class="search" border="0" style="width:563;"> 
				<tr class="h23">
					<td width="60">P.I.C Tel.</td>
					<td width="160"><input type="text" name="phn_no" style="width:140;text-align:left" value="" class="input" style="ime-mode:disabled" maxLength="20"></td>
					<td width="90">P.I.C Fax</td>
					<td width="100"><input type="text" name="fax_no" style="width:80;text-align:left" value="" class="input" style="ime-mode:disabled" maxLength="20"></td>
					<td width="65">P.I.C Email</td>
					<td width=""><input type="text" name="mnr_prnr_eml" style="width:81;text-align:left" value="" class="input" style="ime-mode:disabled" maxLength="200"></td>
				</tr>
				</table>
				<table class="search" border="0" style="width:563;"> 
				<tr class="h23">
					<td width="60">Bill To.</td>
					<td width=""><input type="text" name="mnr_bil_to_nm" style="width:496;" value="" class="input" style="ime-mode:disabled" maxLength="200"></td>
				</tr>
				<tr class="h23">
					<td>Address</td>
					<td><input type="text" name="mnr_prnr_addr" style="width:496;" value="" class="input" style="ime-mode:disabled" maxLength="200"></td>
				</tr>
				</table>
				<table class="search" border="0" style="width:563;"> 
				<tr class="h23">
					<td width="60">Effective</td>  
					<td width="200"><input type="text" required  fulfill style="width:70;text-align:center" class="input" name="eff_dt" dataformat="ymd" maxLength="8">
						&nbsp;~&nbsp;<input type="text" required  fulfill style="width:70;text-align:center" class="input" name="exp_dt" dataformat="ymd" maxLength="8">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_calendar2"></td>
					<td width=""><input type="checkbox" name="mnr_shop_flg"  class="trans" dataformat="">M&R Shop</td>	
					<td width=""><input type="checkbox" name="delt_flg" value="Y" class="trans" dataformat="">Delete Flag</td>
				</tr>
				</table>
				<table class="search" border="0" style="width:563;"> 
				<tr class="h23">
					<td width="60">SPP ID</td>
					<td width="160"><input type="text" name="sp_ptal_id" style="width:140;" value="" class="input2" readonly></td>
					<td width="90">SPP PWD</td>
					<td width=""><input type="text" name="sp_ptal_pwd" style="width:245;" value="" class="input2" readonly></td>
				</tr>		
				</table>	
				<table class="height_0"><tr><td></td></tr></table>		
				<table border="0" style="width:558;"> 
				<tr class="h23">	
					<td valign="bottom"  style="height:0px" colspan=2>
					<table class="search" border="0">
							<tr><td class="title_h"></td>
							<td class="title_s"><nobr>Account Information of Control Office(SML Office Account)</nobr></td></tr>
					</table>
					</td>
				</tr>
				<tr class="h23" >	
					<td valign="top">
						<table class="search" border="0" style="width:300;"> 
						<tr class="h23">
							<td width="80">Bank Name</td>
							<td width=""><input type="text" name="bank_nm" style="width:220" value="" class="input" style="ime-mode:disabled" maxLength="50"></td>
						</tr>
						<tr class="h23">
							<td width="">Account No.</td>
							<td width=""><input type="text" name="bank_acct_no" style="width:220" value="" class="input" style="ime-mode:disabled" maxLength="30"></td>
						</tr>
						<tr class="h23"> 
							<td width="">Swift Code</td>
							<td width=""><input type="text" name="mnr_swift_no" style="width:220;ime-mode:disabled" value="" class="input" maxLength="50"></td>
						</tr>
						</table>
						<table class="search" border="0" style="width:300;"> 
						<tr class="h23">
							<td width="80">Pay Term</td> 
							<td width="40"><input type="text" style="width:30;text-align:right" name="pay_term_dys" value="" class="input" maxlength="3" dataformat="int"></td>
						
							<td width="63">P.Method</td>
							<td width=""><script language="javascript">ComComboObject('combo_pay_mzd_cd',2, 120 , 1, 0,2,false,1);</script>
							<input type="hidden" name="pay_mzd_cd"></td> 
						</tr>
						</table>
				
				</td>
				<td width="350" valign=top style="padding-left:3px">
					<table border="0" style="width:100%; background-color:white;" class="grid2">  
					<tr class="tr2_head">
						<td width="20%" class="tr2_head2">Deposit<br> Info</td>
						<td  width=""><script language="javascript">ComComboObject('combo_dpt_desc',2, 194 , 1, 0,2,false,1);</script>
						<input type="hidden" name="dpt_desc"></td>
					</tr>
					</table>
					<table style="height_1"><tr><td></td></tr></table>	
					<table border="0" style="width:100%; background-color:white;" class="grid2">  
					<tr class="tr2_head">
						<td width="20%" class="tr2_head2">Remark(s)</td>
						<td  width=""><textarea name="mnr_prnr_rmk" style="width:100%;height:57;"  style="ime-mode:disabled" maxLength="4000"></textarea></td>
					</tr>
					</table>
				</td>
				</tr>

				
			<tr>
			
			<td colspan=2 valign=top>
						<table class="height_8"><tr><td></td></tr></table>	
						<table class="search" border="0">
					    <tr><td class="title_h"></td>
						<td class="title_s">Control Office & Buyer Contact Info</td></tr>
					   </table>
						<!-- Grid  (S) -->
						<table width="100%"  id="mainTable" border=0> 
						<tr>
							<td width="100%" valign=top ><script language="javascript">ComSheetObject('sheet2');</script></td>
						</tr>
						</table>				
					<!-- Grid (E) -->	
						<!--  Button_Sub (S) -->
						<table width="100%" class="button" border=0> 
		       					<tr><td class="btn2_bg">
							<table border="0" cellpadding="0" cellspacing="0"><tr> 
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_rowadd">Row&nbsp;Add</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_delete">Row&nbsp;Delete</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>
						</tr></table>
						</td></tr>
						</table>
	    				<!-- Button_Sub (E) -->
						
			</td>
			</tr>
			</table>
				<!-- biz_1  (E) -->
	</td></tr>
	</table>
		<!--biz page (E)-->
	</td></tr>
		</table>
		
</table>
</form>
</body>
</html>
