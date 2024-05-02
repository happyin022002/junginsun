<%--
/*=========================================================
*Copyright(c) 2015 CyberLogitec 
*@FileName : ESD_EAS_0342.jsp
*@FileTitle : TRS Pre-Audit Criterion setting
*Open Issues :
*Change history :
*@LastModifyDate : 2015-5-4-Monday
*@LastModifier : Moon-Seok Jang
*@LastVersion : 1.0
* 1.0 최초 생성 
-------------------------------------------------------------------
* History

=========================================================*/
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.framework.component.util.io.HttpUtil"%> 
<%@ page import="org.apache.log4j.Logger"%>
<%
    Exception serverException = null;	//서버에서 발생한 에러
    String strErrMsg = "";              //에러메세지
	String strUsr_id = "";
	String strOfc_cd = "";

    Logger log = Logger.getLogger("com.hanjin.apps.alps.esd.eas.ESD_EAS_0378");
	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strOfc_cd = account.getOfc_cd();
		
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
        
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>TRS Pre-Audit Criterion setting</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">

<%= JSPUtil.getIBCodeCombo("expn_aud_crte_tp_cd", "", "CD03413", 0, "")%>
<%= JSPUtil.getIBCodeCombo("cgo_tp_cd", "", "CD00748", 0, "")%>
<%= JSPUtil.getIBCodeCombo("trsp_crr_mod_cd", "", "CD00794", 0, "")%>

	function setupPage(){
//	    alert('setupPage');
		loadPage();  //"<=divChargeType%>"
	}
</script>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="respb_ofc_cd">
<input type="hidden" name="rhq_ofc_cd">
<input type="hidden" name="code_key">
<input type="hidden" name="login_usr_id" value="<%=strUsr_id%>">
<input type="hidden" name="login_ofc_cd" value="<%=strOfc_cd%>">
<input type="hidden" name="ofc_cd"		value="<%=strOfc_cd%>">
<input type="hidden" name="ofclevel">

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
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_save" id="btn_save">Save</td><td class="btn1_right"></td></tr></table></td>	
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_new" id="btn_new">New</td><td class="btn1_right"></td></tr></table></td>
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
									<td width="80">RHQ </td>
									<td width="200">&nbsp;<script language="javascript">ComComboObject('s_rhq_ofc_cd',1,120,0,0);</script>
									</td>
									<td width="80">Office</td>
									<td width="180" class="stm">&nbsp;<script language="javascript">ComComboObject('s_ofc_cd',1,100,0,0);</script>
									</td>
									<td width="110">Cargo Type</td>
									<td width="180">&nbsp;<script language="javascript">ComComboObject('s_cgo_tp_cd',1,100,1,0);</script>
									</td>
									<td width="110">Trans Mode</td>
									<td width="200">&nbsp;<script language="javascript">ComComboObject('s_trsp_crr_mod_cd',1,100,1,0);</script>
									</td>
								</tr>
								<tr class="h23">
									<td>Type</td>
									<td colspan="5" class="stm">&nbsp;<script language="javascript">ComComboObject('s_expn_aud_crte_tp_cd',1,120,0,1);</script>
									</td>
									<td colspan="2"><input type="checkbox" class="trans" name="s_expn_aud_tgt_flg" value="Y" onClick="chkClickEvn()">&nbsp;Set Data Only</td>
								</tr>
							</table>
										
						</td>
					</tr>
				</table>
				<!-- TABLE '#D' : ( Search Options ) (E) -->			

			<table class="height_10"><tr><td></td></tr></table>

			<!-- TABLE '#D' : ( Grid ) (S) -->
	     	<table class="search" border="0" style="text-align:right">
	       		<tr>
	       			<td class="bg">
						<!-- <table class="height_10"><tr><td></td></tr></table> -->
						<!-- : ( POR ) (S) -->
							<table width="100%" id="mainTable">
					              <tr><td>
					                     <script language="javascript">ComSheetObject('sheet1');</script>
					              </td></tr>
							</table>
						<!-- : ( POR ) (E) -->
					     	<table >
						       	<tr>
						       		<td>
										<table class="search" border="0" width="100%">
											<tr class="h23">
												<td width="50">Type</td>
												<td width="140" class="stm">&nbsp;<script language="javascript">ComComboObject('i_expn_aud_crte_tp_cd',1,120,0,1);</script>
												</td>
												<td width="60">Office</td>
												<td width="50">
													<input type="text" dataformat="engup" style="width:70; text-align:left;" class="input" maxlength="8" name="i_ofc_cd"> 
												</td>
												<td width="50"></td>
												<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr><td class="btn2_left"></td><td class="btn2" name="btng_addoffice" id="btng_addoffice">Add Office</td><td class="btn2_right"></td></tr></table></td>
												<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr><td class="btn2_left"></td><td class="btn2" name="btng_deloffice" id="btng_deloffice">Delete Office</td><td class="btn2_right"></td></tr></table></td>	
												<!-- Repeat Pattern -->
											</tr>
										</table>
								    </td>
								</tr>
			</table>
				
			</table>
				</td></tr>
			<!-- TABLE '#D' : ( Grid ) (E) -->
			

    </td></tr>
</table>
<!-- Outer Table (E)-->
<div style="display:none;">
	<script language="javascript">ComSheetObject('sheet10');</script>
</div>
</form>
</body>
</html>