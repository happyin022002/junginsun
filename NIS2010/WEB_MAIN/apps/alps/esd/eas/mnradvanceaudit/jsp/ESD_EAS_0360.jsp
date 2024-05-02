<%--
/*=========================================================
*Copyright(c) 2009 CyberLogitec 
*@FileName : ESD_EAS_0360.jsp
*@FileTitle : M&R Invoice Charge
*Open Issues :
*Change history :
*@LastModifyDate : 2015-04-14
*@LastModifier : Jeong-Min Park
*@LastVersion : 1.0
* 1.0 최초 생성 
-------------------------------------------------------------------
* History

=========================================================*/
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.eas.mnradvanceaudit.event.EsdEas0360Event"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil"%>
<%
	String strOfcCd = "";
	String strRhqOfcCd = "";
	
	String s_popup_flg = "";
	String s_popup_rhq_cd = "";
	String s_popup_inv_ofc_cd = "";
	String s_popup_fm_dt = "";
	String s_popup_to_dt = "";
	String s_popup_auto_aud_sts_cd = "";
	String s_popup_expn_aud_sts_cd = "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);

		strOfcCd = account.getOfc_cd();
		strRhqOfcCd = account.getRhq_ofc_cd();
		
		s_popup_flg = (StringUtil.xssFilter(request.getParameter("s_popup_flg"))==null)?"":StringUtil.xssFilter(request.getParameter("s_popup_flg"));
		s_popup_rhq_cd = (StringUtil.xssFilter(request.getParameter("s_popup_rhq_cd"))==null)?"":StringUtil.xssFilter(request.getParameter("s_popup_rhq_cd"));
		s_popup_inv_ofc_cd = (StringUtil.xssFilter(request.getParameter("s_popup_inv_ofc_cd"))==null)?"":StringUtil.xssFilter(request.getParameter("s_popup_inv_ofc_cd"));
		s_popup_fm_dt = (StringUtil.xssFilter(request.getParameter("s_popup_fm_dt"))==null)?"":StringUtil.xssFilter(request.getParameter("s_popup_fm_dt"));
		s_popup_to_dt = (StringUtil.xssFilter(request.getParameter("s_popup_to_dt"))==null)?"":StringUtil.xssFilter(request.getParameter("s_popup_to_dt"));
		s_popup_auto_aud_sts_cd = (StringUtil.xssFilter(request.getParameter("s_popup_auto_aud_sts_cd"))==null)?"":StringUtil.xssFilter(request.getParameter("s_popup_auto_aud_sts_cd"));
		s_popup_expn_aud_sts_cd = (StringUtil.xssFilter(request.getParameter("s_popup_expn_aud_sts_cd"))==null)?"":StringUtil.xssFilter(request.getParameter("s_popup_expn_aud_sts_cd"));

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>M&R Invoice Charge</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	<%=JSPUtil.getIBCodeCombo("auto_audit", "01", "CD03417", 0, "")%>
	<%=JSPUtil.getIBCodeCombo("audit_result", "01", "CD03410", 0, "")%>
	<%=JSPUtil.getIBCodeCombo("select_flg", "01", "CD03348", 0, "")%>
	
	var userOfcCd = "<%=strOfcCd%>";
	var userRhqOfcCd = "<%=strRhqOfcCd%>";

	function setupPage(){
		loadPage();
	}
</script>
</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="code_key">
<input type="hidden" name="s_mnr_code_type">
<input type="hidden" name="backendjob_key" />
<input type="hidden" name="ofc_cd"		value="<%=strOfcCd%>">
<input type="hidden" name="ofclevel">

<input type="hidden" name="pop_parent_row">
<input type="hidden" name="pop_expn_aud_rslt_usr_nm">
<input type="hidden" name="pop_expn_aud_rslt_usr_id">
<input type="hidden" name="pop_expn_aud_rslt_rmk">
<input type="hidden" name="pop_ofcLevel">

<input type="hidden" name="pop_mdl_tp_cd" />
<input type="hidden" name="pop_atch_file_lnk_flg" />
<input type="hidden" name="pop_auto_aud_sts_cd" />
<input type="hidden" name="pop_expn_aud_sts_cd" />
<input type="hidden" name="pop_atch_file_lnk_id" />
<input type="hidden" name="pop_expn_aud_rslt_cd" />
<input type="hidden" name="pop_inv_no" />

<input type="hidden" name="s_popup_flg" value="<%=s_popup_flg%>">
<input type="hidden" name="s_popup_rhq_cd" value="<%=s_popup_rhq_cd%>">
<input type="hidden" name="s_popup_inv_ofc_cd" value="<%=s_popup_inv_ofc_cd%>">
<input type="hidden" name="s_popup_fm_dt" value="<%=s_popup_fm_dt%>">
<input type="hidden" name="s_popup_to_dt" value="<%=s_popup_to_dt%>">
<input type="hidden" name="s_popup_auto_aud_sts_cd" value="<%=s_popup_auto_aud_sts_cd%>">
<input type="hidden" name="s_popup_expn_aud_sts_cd" value="<%=s_popup_expn_aud_sts_cd%>">

<input type="hidden" name="pop_inv_aud_curr_cd">
<input type="hidden" name="pop_inv_usd_diff_amt">
<input type="hidden" name="pop_inv_aud_diff_amt">
<input type="hidden" name="pop_inv_cfm_dt">

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>
			<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
				<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
				</table>
			<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->

			<!-- TABLE '#D' : ( Button : Main ) (S) -->
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
				<tr><td class="btn1_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_new" id="btn_save">New</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_confirm" id="btn_confirm">Confirm</td><td class="btn1_right"></td></tr></table></td>
							<td class="btn1_line"></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_downexcel" id="btn_downexcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>
							<!-- Repeat Pattern -->
						</tr></table>
				</td></tr>
			</table>
			<!-- TABLE '#D' : ( Button : Main ) (E) -->

			<!-- TABLE '#D' : ( Search Options ) (S) -->
	     	<table width="100%" class="search" border="0">
		       	<tr>
		       		<td class="bg">
						<!-- : ( Week ) (S) -->
							<!-- [1]--------------------------------------------------------- -->
						<table class="search_in" border="0">
							<tr class="h23">
								<td width="90">RHQ</td>
								<td width="200" style="padding-left:2"><script language="javascript">ComComboObject('s_rhq_ofc_cd',1,80,0,0);</script>
								</td>
								<td width="85">Office</td>
								<td width="240" style="padding-left:2"><script language="javascript">ComComboObject('s_ofc_cd',1,80,0,0);</script>
								</td>
								<td width="100">INV CFM Date</td>
								<td width="">
									<input type="text" style="width:80; text-align:Center" name="s_start_dt" value="<%=s_popup_fm_dt%>" dataformat="ymd" maxlength="10" class="input1">
									<img name="btn_start_dt" src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
									&nbsp;~&nbsp;
									<input type="text" style="width:80; text-align:Center" name="s_end_dt" value="<%=s_popup_to_dt%>" dataformat="ymd" maxlength="10" class="input1">
									<img name="btn_end_dt" src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
								</td>
							</tr>								
							<tr class="h23">
								<td width="90">Cost Group</td>
								<td width="200" style="padding-left:2"><script language="javascript">ComComboObject('s_cost_group_cd',1,80,0);</script>
								</td>
								<td width="85">Cost Code</td>
								<td width="240" style="padding-left:2"><script language="javascript">ComComboObject('s_cost_cd',2,200,0,0,0);</script>
								</td>
								<td width="100">INV S/P Code.</td>
								<td width=""><input type="text" name="s_vndr_seq" dataformat="int" maxlength="6" style="width:80;text-align:center;ime-mode:disabled;" class="input" value="">&nbsp;<img class="cursor" src="img/btns_search.gif" name="btn_sp_cd" width="19" height="20" alt="" border="0" align="absmiddle">
									<input type="text" name="s_vndr_nm" style="width:123;text-align:left;" class="input2" value="" readonly>
								</td>
							</tr>								
							<tr class="h23">
								<td width="90">Audit Status</td>
								<td width="200" style="padding-left:2">
									<script language="javascript">ComComboObject('s_auto_aud_sts_cd',1, 95, 0 )</script>
									&nbsp;
									<script language="javascript">ComComboObject('s_expn_aud_sts_cd',1, 95, 0 )</script>
								</td>
								<td width="85">Difference</td>
								<td width="240" style="padding-left:2"><script language="javascript">ComComboObject('s_difference',1,200,0);</script>
								</td>
								<td width="100">Error Type</td>
								<td width="" style="padding-left:2"><script language="javascript">ComComboObject('s_err_type',2,230,0);</script></td>
							</tr>
							<tr class="h23">
								<td width="90">CSR NO.</td>
								<td width="200"><input name="s_csr_no" type="text" dataformat="ENGUP" style="width:150;text-align:Center" maxlength="20" class="input">&nbsp;<img src="img/btns_multisearch.gif" name="csr_no_multi1"width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
								<td width="85">Invoice No.</td>
								<td width="240"><input name="s_inv_no" type="text" dataformat="ENG" style="width:150;text-align:Center" maxlength="20" class="input">&nbsp;<img src="img/btns_multisearch.gif" name="inv_no_multi1"width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
								<td width="100">CSR Status</td>
								<td width="" style="padding-left:2"><script language="javascript">ComComboObject('s_csr_status',1,150,0);</script></td>
							</tr>
						</table>
						<!-- : ( Week ) (E) -->
					</td>
				</tr>
			</table>
			<!-- TABLE '#D' : ( Search Options ) (E) -->			

			<table class="height_10"><tr><td></td></tr></table>

			<!-- TABLE '#D' : ( Grid ) (S) -->
	     	<table class="search">
	       		<tr><td class="bg">
					<!-- <table class="height_10"><tr><td></td></tr></table> -->
					<!-- : ( POR ) (S) -->
					<table width="100%" id="mainTable">
			              <tr><td>
			                     <script language="javascript">ComSheetObject('sheet1');</script>
			              </td></tr>
					</table>
					<!-- : ( POR ) (E) -->

					<!-- : ( Button : Grid ) (S) -->
					<table width="100%" class="button">
						<tr><td class="btn2_bg">
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
								<!-- Repeat Pattern -->
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" name="btn_detail" id="btn_detail">Detail</td>
								<td class="btn2_right"></td></tr></table></td>
								&nbsp;&nbsp;&nbsp;
								<!-- Repeat Pattern -->

								</tr>
							</table>
						</td></tr>
					</table>
			    	<!-- : ( Button : Grid ) (E) -->

				</td></tr>
			</table>
			<!-- TABLE '#D' : ( Grid ) (E) -->

    </td></tr>
</table>
<table width="100%" style="display:none"> 
	<tr>
		<td width="100%">
			<script language="javascript">ComSheetObject('sheet2');</script>
		</td>
	</tr>
</table> 
<!-- Outer Table (E)-->

</form>
</body>
</html>