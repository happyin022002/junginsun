<%--
/*=========================================================
*Copyright(c) 2009 CyberLogitec 
*@FileName : ESD_EAS_0361.jsp
*@FileTitle : M&R Invoice Charge Detail
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
<%@ page import="com.hanjin.framework.component.util.StringUtil"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.eas.mnradvanceaudit.event.EsdEas0361Event"%>
<%
	String inv_no = StringUtil.xssFilter(request.getParameter("s_inv_no"));
	String vndr_seq = StringUtil.xssFilter(request.getParameter("s_vndr_seq"));
	String eq_knd_cd = StringUtil.xssFilter(request.getParameter("s_eq_knd_cd"));
	String vndr_nm = StringUtil.xssFilter(request.getParameter("s_vndr_nm"));
	String s_difference = StringUtil.xssFilter(request.getParameter("s_difference"));
	String s_err_type = StringUtil.xssFilter(request.getParameter("s_err_type"));
	String s_cost_cd = StringUtil.xssFilter(request.getParameter("s_cost_cd"));
	String s_subsys_no = StringUtil.xssFilter(request.getParameter("s_subsys_no"));
	String s_mnr_inv_sts_cd = StringUtil.xssFilter(request.getParameter("s_mnr_inv_sts_cd"));
%>
<html>
<head>
<title>M&R Invoice Charge Detail</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	var req_cost_cd = "<%=s_cost_cd%>";
	var req_difference = "<%=s_difference%>";
	var req_err_type = "<%=s_err_type%>";
	var subsysIF = <%="".equals(s_subsys_no) ? "false" : "true"%>;
	function setupPage(){
		loadPage();
	}
</script>
</head>
<body onload="javascript:setupPage();"  onUnLoad="unLoadEac();">
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="s_vndr_seq" value="<%=vndr_seq%>">
<input type="hidden" name="s_cost_group_cd" value="<%=eq_knd_cd%>">
<input type="hidden" name="code_key">
<input type="hidden" name="s_mnr_code_type">
<input type="hidden" name="t_eac_if_flg">
<input type="hidden" name="s_subsys_no" value="<%=s_subsys_no %>">
<input type="hidden" name="s_mnr_inv_sts_cd" value="<%=s_mnr_inv_sts_cd %>">
<!-- Outer Table (S)-->
<table width="100%" cellpadding="10" class="popup">
<tr><td class="top"></td></tr>
<tr><td>
			<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
				<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title">&nbsp; M&R Invoice Charge Detail</span></td></tr>
				</table>
			<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->

			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
				<tr><td class="btn1_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
							<!-- Repeat Pattern -->
						</tr></table>
				</td></tr>
			</table>
			
	     	<table width="100%" class="search" border="0">
		       	<tr>
		       		<td class="bg">
						<!-- : ( Week ) (S) -->
							<!-- [1]--------------------------------------------------------- -->
						<table class="search_in" border="0">
							<tr class="h23">
								<td width="90">Invoice No.</td>
								<td width="200" style="padding-left:2"><input type="text" name="s_inv_no" class="input2" value="<%=inv_no%>" readonly />
								</td>
								<td width="85">INV S/P Code</td>
								<td width="240" style="padding-left:2"><input type="text" name="s_vndr_seq" class="input2" style="width:60px"  value="<%=vndr_seq%>" readonly /> &nbsp; <input type="text" name="s_vndr_nm" class="input2" style="width:120px"  value="<%=vndr_nm %>" readonly /></td>
								<td width="90">Cost Group</td>
								<td width="200" style="padding-left:2"><script language="javascript">ComComboObject('s_eq_knd_cd',1,80,0);</script>
								</td>
							</tr>								
							<tr class="h23">
								<td width="85">Cost Code</td>
								<td width="240" style="padding-left:4px"><script language="javascript">ComComboObject('s_cost_cd',2,200,0,0,0);</script>
								</td>
								<td width="85">Difference</td>
								<td width="240" style="padding-left:4px"><script language="javascript">ComComboObject('s_difference',1,200,0);</script>
								</td>
								<td width="100">Error Type</td>
								<td width="" style="padding-left:2"><script language="javascript">ComComboObject('s_err_type',2,230,0);</script></td>
							</tr>								
						</table>
						<!-- : ( Week ) (E) -->
					</td>
				</tr>
			</table>
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
								<!-- Repeat Pattern -->
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" name="btn_invoice" id="btn_invoice">M&R Invoice</td>
								<td class="btn2_right"></td></tr></table></td>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" name="btn_repair" id="btn_repair">Repair Inquiry</td>
								<td class="btn2_right"></td></tr></table></td>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" name="btn_agreement" id="btn_agreement">Agreement</td>
								<td class="btn2_right"></td></tr></table></td>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" name="btn_tariff" id="btn_tariff">Tariff</td>
								<td class="btn2_right"></td></tr></table></td>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" name="btn_eac_if" id="btn_eac_if">EAC I/F</td>
								<td class="btn2_right"></td></tr></table></td>
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