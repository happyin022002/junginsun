<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_EAS_0225.jsp
*@FileTitle : Change Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2015-09-07
*@LastModifier : CJH
*@LastVersion : 1.0
* 1.0 최초 생성
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>
<%
	Exception serverException   = null;			//서버에서 발생한 에러
	DBRowSet rowSet	  = null;							   //DB ResultSet
	String strErrMsg = "";								 //에러메세지
	int rowCount	 = 0;								  //DB ResultSet 리스트의 건수
	// SignOnUserAccount Info
	String usr_id 				= "";
	String usr_nm				= "";
	String sel_aud_cd		= StringUtil.xssFilter(request.getParameter("sel_aud_cd"))!=null&&!StringUtil.xssFilter(request.getParameter("sel_aud_cd")).equals("")?StringUtil.xssFilter(request.getParameter("sel_aud_cd")):"";
	String reasonCodeTpCd = "";

	if (sel_aud_cd.equals("A")) { //Candidate EAC일 경우
		reasonCodeTpCd = "CD03479";
	}else{
		reasonCodeTpCd = "CD03480";
	}
	
	try {
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		usr_nm 			= account.getUsr_nm();
		usr_id       		= account.getUsr_id();      
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Change Detail</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
	<%= JSPUtil.getIBCodeCombo("expn_aud_rslt_cd", "", reasonCodeTpCd, 0, "")%>
	<%= JSPUtil.getIBCodeCombo("auto_aud_sts_cd", "", "CD03417", 0, "")%>
	<%= JSPUtil.getIBCodeCombo("expn_aud_sts_cd", "", "CD03410", 0, "")%>
</script>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="expn_aud_rslt_usr_id">
<input type="hidden" name="mdl_tp_cd">
<input type="hidden" name="parent_row">
<input type="hidden" name="session_usr_id" value="<%=usr_id%>">
<input type="hidden" name="session_usr_nm" value="<%=usr_nm%>">
<input type="hidden" name="atch_file_lnk_id">
<input type="hidden" name="inv_no">
<input type="hidden" name="inv_cfm_dt">
<!-- OUTER - POPUP (S)tart -->
<table width="700"  class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp; Change Detail</td></tr>
		</table>
		<!-- : ( Title ) (E) -->

		<!-- : ( Search Options ) (S) -->
		<table class="search" align="center">
			<tr><td class="bg">

							<!--  biz_1  (S) -->
							<table class="search" border="0" style="width:100%;"> 
							<tr class="h23">
								<td width="84">&nbsp;Auto Audit</td>
								<td width="99"><script language="javascript">ComComboObject('auto_aud_sts_cd',1,108,1,0,0);</script>
								<td width="60">&nbsp;Change</td>
								<td width="120"><script language="javascript">ComComboObject('expn_aud_sts_cd',1,108,1,0,0);</script>
							</tr>
							</table>	

							<table class="search" border="0" style="width:100%;"> 
							<tr class="h23">
								<td width="81">&nbsp;Reason</td>
								<td width="282"><input type="text" name ='expn_aud_rslt_display' style="width:30;" class="input2" readonly=true>&nbsp;
								<script language="javascript">ComComboObject('expn_aud_rslt_cd',2,220,0,0,1);
								</script>
							</tr>
							</table>	
							
							<table class="search" border="0" style="width:100%;"> 
							<tr class="h23">
								<td width="114">&nbsp;Detail</td>
								<td width="256">
								<textarea name="expn_aud_rslt_rmk" rows="8" cols="76" class="textarea"></textarea>
                                </td>
							</tr>
							</table>
							
							<table class="search" border="0" style="width:100%;"> 
							<tr class="h23">
								<td width="80">&nbsp;Attachment</td>
								<td width="280"><input type="text" name ='atch_file_lnk_flg' style="width:150;" class="input2" readonly=true>
								<img class="cursor" src="img/btns_search.gif" width="20" height="20" border="0" align="absmiddle" name="btn_attach">
								</td>
							</tr>
							</table>	
							
							<table class="search" border="0" style="width:100%;"> 
							<tr class="h23">
								<td width="80">&nbsp;Input User</td>
								<td width="280"><input type="text" name ='expn_aud_rslt_usr_nm' style="width:150;" class="input2" readonly=true></td>
							</tr>
							</table>	
							
							<table class="search" border="0" style="width:100%;"> 
							<tr class="h23">
								<td width="127">&nbsp;CUR</td>
								<td width="80">
									<script language="javascript">ComComboObject('curr_cd',1,80,0,1,0);</script>
								</td>
								<td width="60">&nbsp;Diff AMT</td>
								<td width="120">
									<input type="number" name ='expn_aud_rslt_inv_aud_diff_amt' style="width:120; text-align:right;"" onkeyup="cmaComma(this);" onchange="cmaComma(this);">
								</td>
								<td width="60">&nbsp;US$ AMT</td>
								<td width="120">
									<input type="number" name ='expn_aud_rslt_inv_usd_diff_amt' style="width:120;text-align:right;"  class="input2" readonly=true >
								</td>
							</tr>
							</table>	
							
							<!--  biz_1   (E) -->

			</td></tr>
		</table>
		<!-- : ( Search Options ) (E) -->
</td>
</tr>
</table>
<!-- OUTER - POPUP (E)nd -->

<table class="height_5"><tr><td></td></tr></table>

<!-- Grid_1 (S) -->
<table width="95%"  id="mainTable"> 
	<tr>
		<td width="95%">
			<script language="javascript">ComSheetObject('sheet1');</script>
		</td>
	</tr>
</table>	

<!-- : ( Button : Sub ) (S) -->
<table width="700" class="sbutton">
	<tr>
		<td height="81" class="popup">

			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">
				<tr>
					<td class="btn3_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<!-- Repeat Pattern -->
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_save" id="btn_save">Save</td>
											<td class="btn1_right"></td>
										</tr>
									</table></td>
									
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_delete" id="btn_delete">Delete</td>
											<td class="btn1_right"></td>
										</tr>
									</table></td>

								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_close" id="btn_close">Close</td>
											<td class="btn1_right"></td>
										</tr>
									</table></td>
								<!-- Repeat Pattern -->
							</tr>
						</table>

					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
<!-- : ( Button : Sub ) (E) -->

</form>
</body>
</html>
