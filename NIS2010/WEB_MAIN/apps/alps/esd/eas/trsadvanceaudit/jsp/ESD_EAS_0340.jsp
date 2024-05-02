<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_EAS_0340.jsp
*@FileTitle : Transportation Invoice Charge
*Open Issues :
*Change history :2014.05 Hyun Sung Gil 최초생성
*@LastModifyDate : 2015.05.22
*@LastModifier : 현성길
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.apps.alps.esd.eas.trsadvanceaudit.event.EsdEas0340Event"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.lea.common.CodeComboUtil"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.StringUtil"%>
<%
	EsdEas0340Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String ofcCd		= "";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.trsadvanceaudit.Transportation Invoice Charge");

	String param_name 	= null;
	String ofc_cd	= "";
	String strUsr_ofc_cd = "";
	String strUsr_rhq_ofc_cd = "";
	
	String s_popup_flg = "";
	String s_popup_rhq_cd = "";
	String s_popup_inv_ofc_cd = "";
	String s_popup_fm_dt = "";
	String s_popup_to_dt = "";
	String s_popup_auto_aud_sts_cd = "";
	String s_popup_expn_aud_sts_cd = "";
	
	java.util.Enumeration enums = request.getParameterNames();
	while (enums.hasMoreElements()){
		param_name = (String)enums.nextElement();
	}


	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		ofcCd = account.getOfc_cd();
		strUsr_ofc_cd = account.getOfc_cd();
		strUsr_rhq_ofc_cd = account.getRhq_ofc_cd();
		
		s_popup_flg = (StringUtil.xssFilter(request.getParameter("s_popup_flg"))==null)?"":StringUtil.xssFilter(request.getParameter("s_popup_flg"));
		s_popup_rhq_cd = (StringUtil.xssFilter(request.getParameter("s_popup_rhq_cd"))==null)?"":StringUtil.xssFilter(request.getParameter("s_popup_rhq_cd"));
		s_popup_inv_ofc_cd = (StringUtil.xssFilter(request.getParameter("s_popup_inv_ofc_cd"))==null)?"":StringUtil.xssFilter(request.getParameter("s_popup_inv_ofc_cd"));
		s_popup_fm_dt = (StringUtil.xssFilter(request.getParameter("s_popup_fm_dt"))==null)?"":StringUtil.xssFilter(request.getParameter("s_popup_fm_dt"));
		s_popup_to_dt = (StringUtil.xssFilter(request.getParameter("s_popup_to_dt"))==null)?"":StringUtil.xssFilter(request.getParameter("s_popup_to_dt"));
		s_popup_auto_aud_sts_cd = (StringUtil.xssFilter(request.getParameter("s_popup_auto_aud_sts_cd"))==null)?"":StringUtil.xssFilter(request.getParameter("s_popup_auto_aud_sts_cd"));
		s_popup_expn_aud_sts_cd = (StringUtil.xssFilter(request.getParameter("s_popup_expn_aud_sts_cd"))==null)?"":StringUtil.xssFilter(request.getParameter("s_popup_expn_aud_sts_cd"));

		event = (EsdEas0340Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Transportation Invoice Charge</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
		//changeRHQCd1(document.form.f_rhq_cd[0].value);
	}
	
	<%=JSPUtil.getIBCodeCombo("s_auto_aud_sts_cd", "", "CD03417", 0, "")%>
	<%=JSPUtil.getIBCodeCombo("s_expn_aud_sts_cd", "", "CD03410", 0, "")%>
	<%=JSPUtil.getIBCodeCombo("s_csr_sts_cd", "", "CD03411", 0, "")%>
	<%=JSPUtil.getIBCodeCombo("s_trsp_so_tp_cd", "", "CD00279", 0, "")%>
	<%=JSPUtil.getIBCodeCombo("s_trsp_cost_dtl_mod_cd", "", "CD00958", 0, "")%>
	<%=JSPUtil.getIBCodeCombo("s_trsp_crr_mod_cd", "", "CD00283", 0, "")%>
	
	<%=JSPUtil.getIBCodeCombo("sel_aud_cd", "01", "CD03348", 0, "")%>
	<%=JSPUtil.getIBCodeCombo("auto_aud_sts_cd", "01", "CD03417", 0, "")%>
	<%=JSPUtil.getIBCodeCombo("expn_aud_sts_cd", "01", "CD03410", 0, "")%>
	<%=JSPUtil.getIBCodeCombo("trsp_so_tp_cd", "01", "CD00279", 0, "")%>
	<%=JSPUtil.getIBCodeCombo("inv_aud_sts_cd", "01", "CD03411", 0, "")%>
	<%=JSPUtil.getIBCodeCombo("bat_prog_sts_cd", "01", "CD03051", 0, "")%>
	
</script>
</head>

<iframe height="0" width="0" name="frmHidden"></iframe>
<body  onLoad="setupPage();">
<form method="post" name="form" >
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<input type="hidden" name="iPage">
<input type="hidden" name="frm_retrieveDiv" value="0"> <!-- 조회구분 -->
<input type="hidden" name="usr_ofc_cd"		value="<%=strUsr_ofc_cd%>">
<input type="hidden" name="usr_rhq_ofc_cd"	value="<%=strUsr_rhq_ofc_cd%>">
<input type="hidden" name="code_key">
<input type="hidden" name="ofc_cd"		value="<%=strUsr_ofc_cd%>">
<input type="hidden" name="ofclevel">

<input type="hidden" name="pop_parent_row">
<input type="hidden" name="pop_expn_aud_rslt_usr_nm">
<input type="hidden" name="pop_expn_aud_rslt_usr_id">
<input type="hidden" name="pop_expn_aud_rslt_rmk">
<input type="hidden" name="pop_ofcLevel">
<input type="hidden" name="s_save_tp_cd">
<input type="hidden" name="pop_mdl_tp_cd">
<input type="hidden" name="pop_atch_file_lnk_flg">
<input type="hidden" name="pop_auto_aud_sts_cd">
<input type="hidden" name="pop_expn_aud_sts_cd">
<input type="hidden" name="pop_atch_file_lnk_id">
<input type="hidden" name="pop_expn_aud_rslt_cd">
<input type="hidden" name="pop_inv_no">
<input type="hidden" name="pop_inv_usd_diff_amt">
<input type="hidden" name="pop_inv_aud_curr_cd">
<input type="hidden" name="pop_inv_aud_diff_amt">
<input type="hidden" name="pop_curr_cd">
<input type="hidden" name="pop_inv_cfm_dt">

<input type="hidden" name="s_popup_flg" value="<%=s_popup_flg%>">
<input type="hidden" name="s_popup_rhq_cd" value="<%=s_popup_rhq_cd%>">
<input type="hidden" name="s_popup_inv_ofc_cd" value="<%=s_popup_inv_ofc_cd%>">
<input type="hidden" name="s_popup_fm_dt" value="<%=s_popup_fm_dt%>">
<input type="hidden" name="s_popup_to_dt" value="<%=s_popup_to_dt%>">
<input type="hidden" name="s_popup_auto_aud_sts_cd" value="<%=s_popup_auto_aud_sts_cd%>">
<input type="hidden" name="s_popup_expn_aud_sts_cd" value="<%=s_popup_expn_aud_sts_cd%>">

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->


		<!--Button (S) -->
	    <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top: 0; padding-bottom: 2;">
		<tr>
			<td class="btn1_bg">
				<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
							<td class="btn1_right"></td>
						</tr>
						</table>
					</td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1" name="btn_new" id="btn_new">New</td>
							<td class="btn1_right"></td>
						</tr>
						</table>
					</td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1" name="btn_confirm" id="btn_confirm">Confirm</td>
							<td class="btn1_right"></td>
						</tr>
						</table>
					</td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1" name="btn_downexcel">Down Excel</td>
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
		
<!--biz page (S)-->
		<table class="search">
						<tr>
							<td class="bg">
								<!-- biz_1  (S) -->
								<table class="search" border="0"  style="width: 979;">
									<tr class="h23">
										<td width=80>RHQ</td>
										<td width="80" style="padding-left: 1;"><script
												language="javascript">ComComboObject('s_rhq_ofc_cd',1,79,1,0,0);</script>
										</td>

										<td width="5"></td>
										<td width="80">Office</td>
										<td width="110" style="padding-left: 0;"><script
												language="javascript">ComComboObject('s_ofc_cd',1,79,0,0,0);</script>
										</td>

										<td width="35"></td>
										<td width="100">Inv Cfm Date</td>
										<td width="235">
										    <input type="text" name="s_fm_dt" dataformat="ymd" maxlength="8" size="10" style="width:80; text-align: center;" class="input1"	value="">
										    <img name="btns_calendar_s" src="img/btns_calendar.gif" width="19" height="20" alt=""border="0" align="absmiddle" class="cursor"> ~ 
										    <input type="text" name="s_to_dt" dataformat="ymd" maxlength="8" size="10" style="width:80; text-align: center;" class="input1" value="">
											<img name="btns_calendar_e" src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
										<td width="15"></td>
										<td width="140">Service Order Type</td>
										<td width="100" style="padding-left: 0;"><script
												language="javascript">ComComboObject('s_trsp_so_tp_cd',1,99,0,0,0);</script>
										</td>
									</tr>
								</table>


								<table class="search" border="0"  style="width: 979;">
									<tr class="h23">
										<td width="80">Cost Mode</td>
										<td width="80" style="padding-left: 1;"><script
												language="javascript">ComComboObject('s_trsp_cost_dtl_mod_cd',1,79,1,0,0);</script>
										</td>

										<td width="5"></td>
										<td width="80">Trans Mode</td>
										<td width="110" style="padding-left: 0;"><script
												language="javascript">ComComboObject('s_trsp_crr_mod_cd',1,79,1,0,0);</script>
										</td>
										<td width="35"></td>
										<td width="100">Inv. S/P</td>
										<td width="96"><input name="s_inv_vndr_seq"	dataformat="int" type="text" style="width: 70; text-align: left;" class="input"> 
										<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_vndr_seq"></td>
										<td width="139" align="left"><input name="s_inv_vndr_nm" type="text" style="width: 138; text-align: left;"	class="input2" readonly="readonly"></td>

										<td width="15"></td>
										<td width="140">Difference</td>
										<td width="100"><script language="javascript">ComComboObject('s_aud_itm_cd',1,99,1,0,0);</script>
										</td>
									</tr>
								</table>

								<table>
									<tr>
										<td></td>
									</tr>
								</table>

								<table class="search" border="0"  style="width: 979;">
									<tr class="h23">
										<td width="78">Invoice No.</td>
										<td width="82" style="padding-left: 1;"><input type="text" class="input" style="width: 56;" size="20" name="s_inv_no">
										<img src="img/btns_multisearch.gif" name="inv_no_multi1"width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
										</td>

										<td width="5"></td>
										<td width="78">CSR No.</td>
										<td width="142" style="padding-left: 0;"><input type="text" class="input" style="width: 115" size="20"name="s_csr_no">
										<img src="img/btns_multisearch.gif" name="csr_no_multi1"width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
										</td>

										<td width="5"></td>
										<td width="101">Audit Status</td>
										<td width="110"><script language="javascript">ComComboObject('s_auto_aud_sts_cd',1,109,1,0,0);</script>
										<td width="124"><script language="javascript">ComComboObject('s_expn_aud_sts_cd',1,109,1,0,0);</script>
										</td>

										<td width="15"></td>
										<td width="140">CSR Status</td>
										<td width="100"><script language="javascript">ComComboObject('s_csr_sts_cd',1,99,1,0,0);</script>
										</td>
									</tr>
							
								</table>
					</table>
					
		<table class="height_10"><tr><td></td></tr></table>
		<!-- TABLE '#D' : ( Gird BG Box ) (S) -->
		<table class="search" border="0">
			<tr>
				<td class="bg">
					<table width="100%" id="mainTable">
						<tr>
							<td><script language="javascript">ComSheetObject('sheet1');</script>
							</td>
						</tr>
					</table>
					<!--  Button_Sub (S) -->
					<table width=100% class="button">
						<tr>
							<td class="btn2_bg">
							<table border="0" cellpadding="0" cellspacing="0">
								<tr>
									<td>
										<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr>
												<td class="btn2_left"></td>
												<td class="btn2" name="btng_rebatch">Re-Batch</td>
												<td class="btn2_right"></td>
											</tr>
										</table>
									</td>
									<td>
										<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr>
												<td class="btn2_left"></td>
												<td class="btn2" name="btng_detail">Detail</td>
												<td class="btn2_right"></td>
											</tr>
										</table>
									</td>							
								</tr>
							</table>
							</td>
						</tr>
					</table>
					<!-- Button_Sub (E) -->
				</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Grid BG Box ) (E) -->
					
	</table>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>