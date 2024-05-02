<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CPS_CNI_0401.jsp
*@FileTitle : Insurance Main
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.13
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.11.13 윤세영
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.cps.cni.insurance.insurance.event.CpsCni0401Event"%>
<%@ page import="com.hanjin.apps.alps.cps.cni.common.CniUtil"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	CpsCni0401Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.Insurance.Insurance");
	SignOnUserAccount account = null;

	try {
	   	account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (CpsCni0401Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
	
    // 사용자 roles
    String roles = CniUtil.getRoles(account);
    String area =  CniUtil.getAreaInfo(account);
    String ofcCd = account.getOfc_cd(); 
    
    //roles = "CNI51";
%>
<html>
<head>
<title>Insurance Main</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<input type="hidden" name="insur_tp_nm">
<input type="hidden" name="pop_desc">

<input type="hidden" name="usr_id" value="<%=strUsr_id%>">
<input type="hidden" name="usr_roles" value="<%=roles%>">
<input type="hidden" name="usr_area" value="<%=area%>">
<input type="hidden" name="usr_office" value="<%=ofcCd%>">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	
		<!--Page Title, Historical (S)-->
        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
        </table>
		<!--Page Title, Historical (E)-->
	
	
		<!--Button (S) -->
		
    	<!--Button (E) -->
		
		<!--biz page (S)-->
		
<table class="search" id="mainTable"> 
    <tr><td class="bg">	
			<table class="search" border="0" style="width:979;"> 
			<tr class="h23">
				<td width="121">Type of Insurance</td>
				<td width="250"><select name="insur_tp_cd" style="width:227;" class="input1" required  caption="Type of Insurance">
						</select></td>
				<td width="71">Policy Year</td>
				<td width=""><input type="text" name="insur_plcy_yr" value="" class="input1" caption="Policy Year" style="width:50;ime-mode:disabled;text-align:center" maxlength="4" dataformat="int" fullfill required></td>
				</tr>
			</table> 
			</td>
	</tr></table> 
		<table class="height_8"><tr><td></td></tr></table>
		
		<!-- Tab (S) -->
     	<table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%>
				<tr>
					<td width="100%">
						<script language="javascript">ComTabObject('tab1')</script>
					</td>
				</tr>
			</table>
		<!-- Tab (E) -->	
		
		<!--  Main  Tab(s) -->	
	
		<table class="search" id="mainTable"> 
    <tr><td class="bg">	
    	<div id="tabLayer" style="display:inline">
			<table class="search" border="0" style="width:979;"> 
			<tr class="h23">
				<td width="110"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_insur_ctnt" style="color:#cc3300">Insurer</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
				<td width="400" colspan="2"><input type="hidden" name="insur_clm_pty_no"><div style="display:none"><textarea name="insur_ctnt"></textarea></div>
				<input type="text" name="insur_clm_pty_nm" required class="input1" caption="Insurer" dataformat="eng" style="width:315;" value="">&nbsp;<img src="img/btns_search.gif" name="pop_insur_clm_pty" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
				<td width="190"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_ins_ctnt" style="color:#cc3300">Insured</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
				<td width=""><input type="hidden" name="ins_clm_pty_no"><div style="display:none"><textarea name="ins_ctnt"></textarea></div>
				<input type="text" name="ins_clm_pty_nm" dataformat="eng" style="width:265;" value="">&nbsp;<img src="img/btns_search.gif" name="pop_ins_clm_pty" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
				</tr>
				<tr class="h23">
				<td width=""><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_rins_ctnt" style="color:#cc3300">Reinsurer</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
				<td width="" colspan="2"><input type="hidden" name="rins_clm_pty_no"><div style="display:none"><textarea name="rins_ctnt"></textarea></div>
				<input type="text" name="rins_clm_pty_nm" dataformat="eng" style="width:315;" value="">&nbsp;<img src="img/btns_search.gif" name="pop_rins_clm_pty" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
				<td width=""><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_cins_ctnt" style="color:#cc3300">Co-Insured</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
				<td width=""><input type="hidden" name="cins_clm_pty_no"><div style="display:none"><textarea name="cins_ctnt"></textarea></div>
				<input type="text" name="cins_clm_pty_nm" dataformat="eng" style="width:265;" value="">&nbsp;<img src="img/btns_search.gif" name="pop_cins_clm_pty" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
				</tr>
				<tr class="h23">
				<td width="">&nbsp;&nbsp;Broker</td>
				<td width="400" colspan="2"><input type="hidden" name="bro_clm_pty_no"><div style="display:none"></div>
				<input type="text" name="bro_clm_pty_nm" dataformat="eng" style="width:315;" value="">&nbsp;<img src="img/btns_search.gif" name="pop_bro_clm_pty" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
				<td width=""><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_int_desc" style="color:#cc3300">Interest</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
				<td width=""><div style="display:none"><textarea name="int_desc"></textarea></div>
				<textarea name="int_desc_nm" caption="Interest" maxlength="4000" style="width:290;height:20" rows=1></textarea></td>
				</tr>
				<tr class="h23">
				<td width="">&nbsp;&nbsp;Period</td>
				<td width="150" class="stm">&nbsp;From&nbsp;&nbsp;&nbsp;<input type="text" name="insur_ctrt_eff_dt" caption="Period(From)" style="width:80;ime-mode:disabled;text-align:center" maxlength="8" dataformat="ymd" fullfill>&nbsp;<img src="img/btns_calendar.gif" name="cal_insur_ctrt_eff_dt" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
				<td width="" class="stm">To&nbsp;<input type="text" name="insur_ctrt_exp_dt" caption="Period(To)" style="width:80;ime-mode:disabled;text-align:center" maxlength="8" dataformat="ymd" fullfill>&nbsp;<img src="img/btns_calendar.gif" name="cal_insur_ctrt_exp_dt" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
				<td width=""><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_subj_mat_ins_desc" style="color:#cc3300">Subject Matter Insured</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
				<td width=""><div style="display:none"><textarea name="subj_mat_ins_desc"></textarea></div>
				<textarea name="subj_mat_ins_desc_nm" caption="Subject Matter Insured" maxlength="4000" style="width:290;height:20" rows=1></textarea></td>
				</tr>
			</table> 
			<table class="search" border="0" style="width:979;"> 
			<tr class="h23">
				<td width="110">&nbsp;&nbsp;Total Premium</td>
				<td width="69"><input type="text" name="insur_ttl_curr_cd" style="width:40;text-align:center" readonly class="input2" value=""></td>
				<td width="325"><input type="text" name="insur_ttl_locl_amt" style="width:247;text-align:right" readonly class="input2"  value=""></td>
				<td width="66" title="Rate of Exchange">&nbsp;R. O. E.</td>
				<td width="130"><input type="text" name="insur_ttl_xch_rt" style="width:80;text-align:right" readonly class="input2" value=""></td>
				<td width="36">USD</td>
				<td width=""><input type="text" name="insur_ttl_usd_amt" style="width:241; text-align:right" readonly value="" class="input2"></td>
				</tr>
			</table> 
			<table class="search" border="0" style="width:979;"> 
			<tr class="h23">
				<td width="110">&nbsp;&nbsp;Amount Insured</td>
				<td width="69"><input type="text" name="ins_curr_cd" caption="Amount Insured(Currency)" style="width:40;text-align:center;ime-mode:disabled" value="" maxlength="3" dataformat="engup" fullfill>&nbsp;<img src="img/btns_search.gif" name="pop_ins_curr_cd" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
				<td width="325"><input type="text" name="ins_locl_amt" style="width:247; text-align:right" dataformat="float" maxlength="18" value=""></td>
				<td width="66" title="Rate of Exchange">&nbsp;R. O. E.</td>
				<td width="130"><input type="text" name="ins_xch_rt" style="width:80;text-align:right;ime-mode:disabled" dataformat="float" maxlength="11" value="">&nbsp;<img src="img/btns_search.gif" name="pop_ins_xch_rt" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
				<td width="36">USD</td>
				<td width=""><input type="text" name="ins_usd_amt" style="width:241; text-align:right" readonly value="" class="input2"></td>
				</tr>
				<tr class="h23">
				<td width="110">&nbsp;&nbsp;Limit</td>
				<td width="69"><input type="text" name="lmt_ins_curr_cd" caption="Limit(Currency)" style="width:40;text-align:center;ime-mode:disabled" value="" maxlength="3" dataformat="engup" fullfill>&nbsp;<img src="img/btns_search.gif" name="pop_lmt_ins_curr_cd" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
				<td width="325"><input type="text" name="lmt_ins_locl_amt" style="width:247; text-align:right" dataformat="float" maxlength="18" value=""></td>
				<td width="66" title="Rate of Exchange">&nbsp;R. O. E.</td>
				<td width="130"><input type="text" name="lmt_ins_xch_rt" style="width:80;text-align:right;ime-mode:disabled" dataformat="float" maxlength="11" value="">&nbsp;<img src="img/btns_search.gif" name="pop_lmt_ins_xch_rt" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
				<td width="36">USD</td>
				<td width=""><input type="text" name="lmt_ins_usd_amt" style="width:241; text-align:right" readonly value="" class="input2"></td>
				</tr>
			</table> 
			
			<table class="height_8"><tr><td></td></tr></table>
		
	<!--  Main sub Tab (s)-->	
	
		<!-- Tab (S) -->
     	<table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%>
				<tr>
					<td width="100%">
						<script language="javascript">ComTabObject('tab2')</script>
					</td>
				</tr>
			</table>
			
		<!-- Tab (E) -->	
		
	<!--  sub 1(s)-->	
	<div id="tabLayer1" style="display:inline;height:230">
	<table class="search" id="mainTable"> 
    <tr><td class="bg">	
		<table class="search" width="100%"> 
				<tr>
					<td width="100%"><textarea name="insur_rmk" caption="Main Terms Remark" maxlength="4000" style="width:99%;" rows="15"></textarea>
						
					</td>
				</tr>
		</table> 	
	</td></tr>
	</table> 
	</div>
	<!--  sub 1(e)-->	
	
		
		<!-- Grid  (S) -->

		
	<div id="tabLayer1" style="display:none;height:230">
	<table class="search" id="mainTable"> 
    <tr><td class="bg">	
    		<table width="100%"  id="mainTable"> 
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet1');</script>
					</td>
				</tr>
			</table><!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       		<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn2_Row_Add">Row&nbsp;Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn2_Row_Insert">Row Insert</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn2_Row_Delete">Row Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn2_Save">File Save</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) --> 
	    		
	</td></tr>
	</table> 
	</div>

	<div id="tabLayer1" style="display:none;height:230">
	<table class="search" id="mainTable"> 
    <tr><td class="bg">	
    	<table width="100%"  id="mainTable"> 
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet2');</script>
					</td>
				</tr>
			</table> 
			<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       		<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn2_Row_Add">Row&nbsp;Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn2_Row_Insert">Row Insert</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn2_Row_Delete">Row Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn2_Save">File Save</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
	    		
	</td></tr>
	</table> 
	</div>
		
	<div id="tabLayer1" style="display:none;height:230">
	<table class="search" id="mainTable"> 
    <tr><td class="bg">	
			<table width="100%"  id="mainTable"> 
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet3');</script>
					</td>
				</tr>
			</table><!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       		<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn2_Row_Add">Row&nbsp;Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn2_Row_Insert">Row Insert</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn2_Row_Delete">Row Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn2_Save">File Save</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) --> 
	    		
	</td></tr>
	</table> 
	</div>
		
	<div id="tabLayer1" style="display:none;height:230">
	<table class="search" id="mainTable"> 
    <tr><td class="bg">	
			<table width="100%"  id="mainTable"> 
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet4');</script>
					</td>
				</tr>
			</table><!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       		<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn2_Row_Add">Row&nbsp;Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn2_Row_Insert">Row Insert</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn2_Row_Delete">Row Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn2_Save">File Save</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) --> 
	    		
	</td></tr>
	</table> 
	</div>
		
	<div id="tabLayer1" style="display:none;height:230">
	<table class="search" id="mainTable"> 
    <tr><td class="bg">	
			<table width="100%"  id="mainTable"> 
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet5');</script>
					</td>
				</tr>
			</table><!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       		<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn2_Row_Add">Row&nbsp;Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn2_Row_Insert">Row Insert</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn2_Row_Delete">Row Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn2_Save">File Save</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) --> 
	    		
	</td></tr>
	</table> 
	</div>
		
	<div id="tabLayer1" style="display:none;height:230">
	<table class="search" id="mainTable"> 
    <tr><td class="bg">	
			<table width="100%"  id="mainTable"> 
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet6');</script>
					</td>
				</tr>
			</table><!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       		<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn2_Row_Add">Row&nbsp;Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn2_Row_Insert">Row Insert</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn2_Row_Delete">Row Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn2_Save">File Save</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) --> 
	    		
	</td></tr>
	</table> 
	</div>
		
	<div id="tabLayer1" style="display:none;height:230">
	<table class="search" id="mainTable"> 
    <tr><td class="bg">	
			<table width="100%"  id="mainTable"> 
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet7');</script>
					</td>
				</tr>
			</table><!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       		<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn2_Row_Add">Row&nbsp;Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn2_Row_Insert">Row Insert</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn2_Row_Delete">Row Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn2_Save">File Save</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) --> 
	    		
	</td></tr>
	</table> 
	</div>
		
	<div id="tabLayer1" style="display:none;height:230">
	<table class="search" id="mainTable"> 
    <tr><td class="bg">	
			<table width="100%"  id="mainTable"> 
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet8');</script>
					</td>
				</tr>
			</table><!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       		<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn2_Row_Add">Row&nbsp;Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn2_Row_Insert">Row Insert</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn2_Row_Delete">Row Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn2_Save">File Save</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) --> 
	    		
	</td></tr>
	</table> 
	</div>
		<!-- Grid  (e) -->
		
		
			
			
			
			</div>
			
			
			
			<div id="tabLayer" style="display:none">
				
			<table class="search" border="0" style="width:979;"> 
			<tr class="h23">
				<td width="100%" colspan="2"><table width="100%" border="0" cellpadding="0" cellspacing="0">
						<tr class="h23"><td width="116">Insurer</td>
						<td><input type="hidden" name="insur_clm_pty_prm_no">
						<input type="text" name="insur_clm_pty_prm_nm" required class="input1" caption="Insurer" dataformat="eng" style="width:315;" value="">&nbsp;<img src="img/btns_search.gif" name="pop_insur_clm_pty_prm" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
						</td>
						</tr>
					</table>
				</td>		 
			</tr>
			<tr class="h23">
				<td width="260" valign="top">
						<table class="search" border="0" style="width:320;"> 
							<tr class="h23">
							<td width="115">Type of Premium</td>
							<td width=""><select name="insur_prm_tp_cd" style="width:200;" required class="input1"  caption="Type of Premium">
						</select></td>
							</tr></table>
						<table class="search_sm2" border="0" style="width:240;"> 
						<tr>
						<td>
							<table class="search" border="0">
							<tr><td class="title_h"></td>
							<td class="title_s">Total</td></tr>
							</table>
						<table class="search" border="0" style="width:240;"> 
								<tr class="h23">
							<td width="60">Amount</td>
							<td width="68"><input type="text" name="ttl_curr_cd" caption="Amount(Currency)" style="width:40;text-align:center;ime-mode:disabled" value="" maxlength="3" dataformat="engup" fullfill>&nbsp;<img class="cursor" name="pop_ttl_curr_cd" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
							<td width=""><input type="text" name="ttl_locl_amt" style="width:110;text-align:right;ime-mode:disabled" dataformat="float" maxlength="18" value=""></td>
							</tr>
							<tr class="h23">
							<td width="" colspan="2" title="Rate of Exchange">R. O. E.</td>
							<td width=""><input type="text" name="ttl_xch_rt" style="width:85;text-align:right;ime-mode:disabled" dataformat="float" maxlength="11" value="">&nbsp;<img class="cursor" name="pop_ttl_xch_rt" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
							</tr>
							<tr class="h23">
							<td width="">Amount</td>
							<td width="">USD</td>
							<td width=""><input type="text" name="ttl_usd_amt" caption="Total Amount USD" style="width:110;text-align:right;ime-mode:disabled" dataformat="float" maxlength="18" value=""></td>
							</tr>
							<tr class="h23">
							<td width="" colspan="2">Due Date</td>
							<td width=""><input type="text" name="ttl_due_dt" caption="Total Due Date" style="width:85;ime-mode:disabled;text-align:center" maxlength="8" dataformat="ymd" fullfill value="">&nbsp;<img class="cursor" name="cal_ttl_due_dt" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"></td>
							</tr>
							<tr class="h23">
							<td width="" colspan="2">Paid Date</td>
							<td width=""><input type="text" name="ttl_pay_dt" caption="Total Paid Date" style="width:85;ime-mode:disabled;text-align:center" maxlength="8" dataformat="ymd" fullfill value="">&nbsp;<img class="cursor" name="cal_ttl_pay_dt" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"></td>
							</tr>
						</table>
					</td>
					</tr></table>
				</td>
				<td width="" valign="top">
					
					<table class="search" border="0" style="width:100%;"> 
					<tr class="h23">
					<td valign="top">
						<table style="height:25;"><tr><td></td></tr></table>
						<table class="search" border="0" style="width:110;"> 
							<tr class="h23">
							<td>&nbsp;Paid</td>
							</tr>
							<tr class="h23">
							<td width=""><input type="text" name="adj_locl_amt" caption="Paid Amount" style="width:100;text-align:right;ime-mode:disabled" dataformat="float" maxlength="18" value=""></td>
							</tr>
							<tr class="h23">
							<td width=""><input type="text" name="adj_xch_rt" caption="Paid R. O. E." style="width:75;text-align:right;ime-mode:disabled" dataformat="float" maxlength="11" value="">&nbsp;<img class="cursor" name="pop_adj_xch_rt" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
							</tr>
							<tr class="h23">
							<td width=""><input type="text" name="adj_usd_amt" caption="Paid Amount USD" style="width:100;text-align:right;ime-mode:disabled" dataformat="float" maxlength="18" value=""></td>
							</tr>
							<tr class="h23">
							<td width=""><input type="text" name="adj_due_dt" caption="Paid Due Date" style="width:75;ime-mode:disabled;text-align:center" maxlength="8" dataformat="ymd" fullfill>&nbsp;<img class="cursor" src="img/btns_calendar.gif" name="cal_adj_due_dt" width="19" height="20" border="0" align="absmiddle"></td>
							</tr>
							<tr class="h23">
							<td width=""><input type="text" name="adj_pay_dt" caption="Paid Paid Date" style="width:75;ime-mode:disabled;text-align:center" maxlength="8" dataformat="ymd" fullfill>&nbsp;<img class="cursor" src="img/btns_calendar.gif" name="cal_adj_pay_dt" width="19" height="20" border="0" align="absmiddle"></td>
							</tr>
						</table>
					</td>
					<td valign="top">
						<table style="height:25;"><tr><td></td></tr></table>
						<table class="search" border="0" style="width:110;"> 
							<tr class="h23">
							<td>&nbsp;Refunded</td>
							</tr>
							<tr class="h23">
							<td width=""><input type="text" name="rfnd_locl_amt" caption="Refunded Amount" style="width:100;text-align:right;ime-mode:disabled" dataformat="float" maxlength="18" value=""></td>
							</tr>
							<tr class="h23">
							<td width=""><input type="text" name="rfnd_xch_rt" caption="Refunded R. O. E." style="width:75;text-align:right;ime-mode:disabled" dataformat="float" maxlength="11" value="">&nbsp;<img class="cursor" name="pop_rfnd_xch_rt" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
							</tr>
							<tr class="h23">
							<td width=""><input type="text" name="rfnd_usd_amt" caption="Refunded Amount USD" style="width:100;text-align:right;ime-mode:disabled" dataformat="float" maxlength="18" value=""></td>
							</tr>
							<tr class="h23">
							<td width=""><input type="text" name="rfnd_due_dt" caption="Refunded Due Date" style="width:75;ime-mode:disabled;text-align:center" maxlength="8" dataformat="ymd" fullfill>&nbsp;<img class="cursor" src="img/btns_calendar.gif" name="cal_rfnd_due_dt" width="19" height="20" border="0" align="absmiddle"></td>
							</tr>
							<tr class="h23">
							<td width=""><input type="text" name="rfnd_pay_dt" caption="Refunded Paid Date" style="width:75;ime-mode:disabled;text-align:center" maxlength="8" dataformat="ymd" fullfill>&nbsp;<img class="cursor" src="img/btns_calendar.gif" name="cal_rfnd_pay_dt" width="19" height="20" border="0" align="absmiddle"></td>
							</tr>
						</table>
					</td>
					<td valign="top">
						
						<table style="height:25;"><tr><td></td></tr></table>
						<table class="search" border="0" style="width:110;"> 
							<tr class="h23">
							<td>&nbsp;O/S</td>
							</tr>
							<tr class="h23">
							<td width=""><input type="text" name="ots_locl_amt" caption="O/S Amount" style="width:100;text-align:right;ime-mode:disabled" dataformat="float" maxlength="18" value=""></td>
							</tr>
							<tr class="h23">
							<td width=""><input type="text" name="ots_xch_rt" caption="O/S R. O. E." style="width:75;text-align:right;ime-mode:disabled" dataformat="float" maxlength="11" value="">&nbsp;<img class="cursor" name="pop_ots_xch_rt" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
							</tr>
							<tr class="h23">
							<td width=""><input type="text" name="ots_usd_amt" caption="O/S Amount USD" style="width:100;text-align:right;ime-mode:disabled" dataformat="float" maxlength="18" value=""></td>
							</tr>
							<tr class="h23">
							<td width=""><input type="text" name="ots_due_dt" caption="O/S Due Date" style="width:75;ime-mode:disabled;text-align:center" maxlength="8" dataformat="ymd" fullfill>&nbsp;<img class="cursor" src="img/btns_calendar.gif" name="cal_ots_due_dt" width="19" height="20" border="0" align="absmiddle"></td>
							</tr>
							<tr class="h23">
							<td width=""><input type="text" name="ots_pay_dt" caption="O/S Paid Date" style="width:75;ime-mode:disabled;text-align:center" maxlength="8" dataformat="ymd" fullfill>&nbsp;<img class="cursor" src="img/btns_calendar.gif" name="cal_ots_pay_dt" width="19" height="20" border="0" align="absmiddle"></td>
							</tr>
						</table>
					</td>
					<td valign="top">
						<table class="search" border="0" style="height:25;">
							<tr><td class="title_h"></td>
							<td class="title_s">Installment</td></tr>
						</table>
						<table class="search" border="0" style="width:;"> 
							<tr class="h23">
							<td valign="top">
									<div style="display:inline" style="width:330;height:165;overflow:scroll;overflow-y:hidden; ">
										<table class="search" border="0" style="width:100%;"> 
										<tr class="h23">
										<% for (int i=1; i<11; i++) { %>
										<td>
											<table class="search" border="0" style="width:110;"> 
												<tr class="h23">
												<% String strOrder = null;
												   if (i==1) {
												   		strOrder = i+"st";
												   } else if (i==2) {
												   		strOrder = i+"nd";
												   } else if (i==3) {
												   		strOrder = i+"rd";
												   } else {
												   		strOrder = i+"th";
												   } 
												%>
												<td>&nbsp;<%=strOrder%></td>
												</tr>
												<tr class="h23">
												<td width=""><input type="text" name="inst_locl_amt_<%=i%>" caption="<%=strOrder%> Amount" style="width:100;text-align:right;ime-mode:disabled" dataformat="float" maxlength="18" value=""></td>
												</tr>
												<tr class="h23">
												<td width=""><input type="text" name="inst_xch_rt_<%=i%>" caption="<%=strOrder%> R. O. E." style="width:75;text-align:right;ime-mode:disabled" dataformat="float" maxlength="11" value="">&nbsp;<img class="cursor" name="pop_inst_xch_rt_<%=i%>" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
												</tr>
												<tr class="h23">
												<td width=""><input type="text" name="inst_usd_amt_<%=i%>" caption="<%=strOrder%> Amount USD" style="width:100;text-align:right;ime-mode:disabled" dataformat="float" maxlength="18" value=""></td>
												</tr>
												<tr class="h23">
												<td width=""><input type="text" name="inst_due_dt_<%=i%>" caption="<%=strOrder%> Due Date" style="width:75;ime-mode:disabled;text-align:center" maxlength="8" dataformat="ymd" fullfill>&nbsp;<img class="cursor" src="img/btns_calendar.gif" name="cal_inst_due_dt_<%=i%>" width="19" height="20" border="0" align="absmiddle"></td>
												</tr>
												<tr class="h23">
												<td width=""><input type="text" name="inst_pay_dt_<%=i%>" caption="<%=strOrder%> Paid Date" style="width:75;ime-mode:disabled;text-align:center" maxlength="8" dataformat="ymd" fullfill>&nbsp;<img class="cursor" src="img/btns_calendar.gif" name="cal_inst_pay_dt_<%=i%>" width="19" height="20" border="0" align="absmiddle"></td>
												</tr>
											</table>
										</td>
										<% } %>
									</tr>
									</table>
								</div>
							</td>
							</tr>
						</table>
					</td>
					
					</tr>
					</table>
				
				</td>
				</tr></table>
				
				
				<table class="height_8"><tr><td></td></tr></table>
		
	<!--  Main sub Tab (s)-->	
	
	
	
	
		<!-- Tab (S) -->
     	<table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%>
				<tr>
					<td width="100%">
						<script language="javascript">ComTabObject('tab3', "white", "100%", 25, false)</script>
					</td>
				</tr>
			</table>
			
		<!-- Tab (E) -->	
		
	<!--  sub 1(s)-->	
	<div id="tabLayer3" style="display:inline">
	<table class="search" id="mainTable"> 
    <tr><td class="bg">	
    	<table class="search" width="100%"> 
				<tr>
					<td width="100%"><textarea name="diff_rmk" caption="Premium Remark" maxlength="4000" style="width:99%;" rows="12"></textarea>
						
					</td>
				</tr>
		</table> 	
	</td></tr>
	</table> 
	</div>
	<!--  sub 1(e)-->	
	
		
		<!-- Grid  (S) -->
	<div id="tabLayer3" style="display:none">
	<table class="search" id="mainTable"> 
    <tr><td class="bg">	
			<table width="100%"  id="mainTable"> 
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet9');</script>
					</td>
				</tr>
			</table> 
			<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       		<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn2_Row_Add">Row&nbsp;Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn2_Row_Insert">Row Insert</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn2_Row_Delete">Row Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn2_Save">File Save</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) --> 	
	</td></tr>
	</table> 
	</div>
		
	<div id="tabLayer3" style="display:none">
	<table class="search" id="mainTable"> 
    <tr><td class="bg">	
			<table width="100%"  id="mainTable"> 
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet10');</script>
					</td>
				</tr>
			</table><!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       		<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn2_Row_Add">Row&nbsp;Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn2_Row_Insert">Row Insert</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn2_Row_Delete">Row Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn2_Save">File Save</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->  	
	</td></tr>
	</table> 
	</div>
		
	
			
			
		
	
	<!--  Main sub Tab (e)-->	
	
	<!--  Main  Tab (e)-->	
	</td>
	</tr></table> 
	<!--Button (S) -->
	<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_Retrieve" id="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_New" id="btn1_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_Save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_Delete">Delete</td>
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
	

	</td></tr>
		</table>
<script language="javascript">ComUploadObject('upload1', '<=session.getId()%>');</script>

	<div id="" style="display:none;">
			<table width="100%"  id="mainTable"> 
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet11');</script>
					</td>
				</tr>
			</table><!--  Button_Sub (S) -->
	</div>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>