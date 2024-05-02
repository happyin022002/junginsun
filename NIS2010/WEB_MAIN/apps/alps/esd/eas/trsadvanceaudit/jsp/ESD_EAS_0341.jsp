
<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_EAS_0341.jsp
*@FileTitle : TRS Auto Audit - Detail
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
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.lea.common.CodeComboUtil"%>
<%@	page import="com.hanjin.apps.alps.esd.eas.trsadvanceaudit.event.EsdEas0340Event"%>
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

	String param_name 	= null;
	String ofc_cd	= "";
	String strUsr_ofc_cd = "";
	String strUsr_rhq_ofc_cd = "";
	
	//0340화면에서 넘겨주는 인자들
	String inv_no = "";
	String trsp_so_tp_cd ="";
	String inv_vndr_seq	="";
	String inv_vndr_nm	="";
	String expn_aud_sts_cd	="";
	String trsp_crr_mod_cd	="";
	String trsp_cost_dtl_mod_cd	="";
	String inv_iss_usr_nm = "";
	String aud_itm_cd = "";
	String hjl_inv_no = "";
	String hjl_inv_vndr_seq = "";
	String dis_inv_vndr_seq = "";
	String dis_inv_vndr_nm = "";

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
		
		inv_no = (StringUtil.xssFilter(request.getParameter("s_inv_no"))==null)?"":StringUtil.xssFilter(request.getParameter("s_inv_no"));
		inv_vndr_seq = (StringUtil.xssFilter(request.getParameter("s_inv_vndr_seq"))==null)?"":StringUtil.xssFilter(request.getParameter("s_inv_vndr_seq"));

		trsp_so_tp_cd = (StringUtil.xssFilter(request.getParameter("s_trsp_so_tp_cd"))==null)?"":StringUtil.xssFilter(request.getParameter("s_trsp_so_tp_cd"));
		expn_aud_sts_cd = (StringUtil.xssFilter(request.getParameter("s_expn_aud_sts_cd"))==null)?"":StringUtil.xssFilter(request.getParameter("s_expn_aud_sts_cd"));
		trsp_cost_dtl_mod_cd = (StringUtil.xssFilter(request.getParameter("s_trsp_cost_dtl_mod_cd"))==null)?"":StringUtil.xssFilter(request.getParameter("s_trsp_cost_dtl_mod_cd"));
		trsp_crr_mod_cd = (StringUtil.xssFilter(request.getParameter("s_trsp_crr_mod_cd"))==null)?"":StringUtil.xssFilter(request.getParameter("s_trsp_crr_mod_cd"));
		inv_iss_usr_nm = (StringUtil.xssFilter(request.getParameter("s_inv_iss_usr_nm"))==null)?"":StringUtil.xssFilter(request.getParameter("s_inv_iss_usr_nm"));
		aud_itm_cd = (StringUtil.xssFilter(request.getParameter("s_aud_itm_cd"))==null)?"":StringUtil.xssFilter(request.getParameter("s_aud_itm_cd"));
		hjl_inv_no = (StringUtil.xssFilter(request.getParameter("s_hjl_inv_no"))==null)?"":StringUtil.xssFilter(request.getParameter("s_hjl_inv_no"));
		hjl_inv_vndr_seq = (StringUtil.xssFilter(request.getParameter("s_hjl_inv_vndr_seq"))==null)?"":StringUtil.xssFilter(request.getParameter("s_hjl_inv_vndr_seq"));
		dis_inv_vndr_seq = (StringUtil.xssFilter(request.getParameter("s_dis_inv_vndr_seq"))==null)?"":StringUtil.xssFilter(request.getParameter("s_dis_inv_vndr_seq"));
		dis_inv_vndr_nm = (StringUtil.xssFilter(request.getParameter("s_dis_inv_vndr_nm"))==null)?"":StringUtil.xssFilter(request.getParameter("s_dis_inv_vndr_nm"));

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
	
	<%=JSPUtil.getIBCodeCombo("s_trsp_so_tp_cd", "", "CD00279", 0, "")%>
	<%=JSPUtil.getIBCodeCombo("s_expn_aud_sts_cd", "", "CD03410", 0, "")%>
	<%=JSPUtil.getIBCodeCombo("s_trsp_cost_dtl_mod_cd", "", "CD00958", 0, "")%>
	<%=JSPUtil.getIBCodeCombo("s_trsp_crr_mod_cd", "", "CD00283", 0, "")%>
	
</script>
</head>

<iframe height="0" width="0" name="frmHidden"></iframe>
<body onLoad="setupPage();" onUnLoad="unLoadEac();">
<form method="post" name="form" >
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<input type="hidden" name="iPage">
<input type="hidden" name="frm_retrieveDiv" value="0"> <!-- 조회구분 -->
<input type="hidden" name="usr_ofc_cd"		value="<%=strUsr_ofc_cd%>">
<input type="hidden" name="usr_rhq_ofc_cd"	value="<%=strUsr_rhq_ofc_cd%>">

<input type="hidden" name="trsp_so_tp_cd"	value="<%=trsp_so_tp_cd%>">
<input type="hidden" name="s_inv_iss_usr_nm"	value="<%=inv_iss_usr_nm%>">
<input type="hidden" name="trsp_cost_dtl_mod_cd"	value="<%=trsp_cost_dtl_mod_cd%>">
<input type="hidden" name="trsp_crr_mod_cd"	value="<%=trsp_crr_mod_cd%>">
<input type="hidden" name="expn_aud_sts_cd"	value="<%=expn_aud_sts_cd%>">
<input type="hidden" name="aud_itm_cd"	value="<%=aud_itm_cd%>">
<input type="hidden" name="s_hjl_inv_no"	value="<%=hjl_inv_no%>">
<input type="hidden" name="s_hjl_inv_vndr_seq"	value="<%=hjl_inv_vndr_seq%>">
<input type="hidden" name="s_inv_vndr_seq"	value="<%=inv_vndr_seq%>">

<input type="hidden" name="t_eac_if_flg">
<input type="hidden" name="code_key">

<!-- Outer Table (S)-->
<table width="100%" class="popup" cellpadding="10"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">	

	<!-- ______________________________________________ Start Page Navigation & Title -->
	<!-- | -->
		<table width="580" border="0">
		<tr><td height="79" class="title"><img src="img/icon_title_dot.gif" align="absmiddle"> TRS Auto Audit Detail</td></tr>
		</table>
	<!-- |______________________________________________ End Page Navigation & Title -->

	<!-- ______________________________________________ Start Main Button -->
	<!-- | -->
	<!-- | -->	<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
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
	<!-- |______________________________________________ End Main Button -->
		
<!--biz page (S)-->
		<table class="search" border="0" style="width: 100%;">
						<tr>
							<td class="bg">
								<!-- biz_1  (S) -->
								<table class="search" border="0" style="width: 979;">
									<tr class="h23">
										<td width="100">Invoice No.</td>
										<td width="100" style="padding-left: 1;"><input type="text" class="input2" value="<%=inv_no%>" style="width: 99;" size="20" name="s_inv_no" readonly>
										</td>
										
										<td width ="20"></td>
										<td width="100">Invoice S/P</td>
										<td width="105"><input name="s_dis_inv_vndr_seq" value= <%=dis_inv_vndr_seq%> dataformat="int" type="text" style="width: 103; text-align: left;" class="input2" readonly="readonly"></td> 
										<td width="110" align="left"><input name="s_dis_inv_vndr_nm" value = "<%=dis_inv_vndr_nm %>" type="text" style="width: 108; text-align: left;"	class="input2" readonly="readonly"></td>
										
										<td width="20"></td>
										<td width="80">S/O Type</td>
										<td width="100" style="padding-left: 1;"><script language="javascript">ComComboObject('s_trsp_so_tp_cd',1,99,1,0,0);</script></td>
										
										<td width ="20"></td>
										<td width="100">Audit Result</td>
										<td width="100" style="padding-left: 0;"><script language="javascript">ComComboObject('s_expn_aud_sts_cd',1,99,0,0,0);</script>
										</td>
									</tr>
								</table>

								<table class="search" border="0" style="width: 979;">
									<tr class="h23">
										<td width="100">Cost Mode</td>
										<td width="100" style="padding-left: 1;"><script language="javascript">ComComboObject('s_trsp_cost_dtl_mod_cd',1,99,1,0,0);</script>
										</td>
										<td width ="19"></td>
										<td width="98">Trans Mode</td>
										<td width="208" style="padding-left: 0;"><script language="javascript">ComComboObject('s_trsp_crr_mod_cd',1,99,1,0,0);</script></td>

										<td width="23"></td>
										<td width="78">Difference</td>
										<td width="105"><script language="javascript">ComComboObject('s_aud_itm_cd',1,99,1,0,0);</script>
										</td>
										<td width ="210"></td>
									</tr>
								</table>
					</table>
					
					<table class="height_10"><tr><td></td></tr></table>
					<!-- TABLE '#D' : ( Gird BG Box ) (S) -->
					<table class="search" border="0">
						<tr>
							<td class="bg">
								<!-- : ( Seq. ) (S) -->
								<table width="100%" id="mainTable">
									<tr>
										<td><script language="javascript">ComSheetObject('sheet1');</script>
										</td>
									</tr>
								</table>
																		
								<!--Button (S) -->
								<table width="100%" class="sbutton">
								<tr><td height="71" class="popup">
									<table border="0" cellpadding="0" cellspacing="0">
										<tr>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn1_left"></td>
														<td class="btn1" name="btng_eacif" id="btng_eacif">EAC I/F</td>
														<td class="btn1_right"></td>
													
														<td class="btn1_left"></td>
														<td class="btn1" name="btng_close" id="btng_close">Close</td>
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
							</td>
						</tr>
					</table>
					<!-- TABLE '#D' : ( Grid BG Box ) (E) -->
	</table>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>