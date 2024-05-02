<%--
/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESM_AGT_0052.jsp
*@FileTitle : CSR Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2010-10-20
*@LastModifier : Sungjin Park
*@LastVersion : 1.0
* 2010-10-20 Sungjin Park
* 1.0 최초 생성
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.agt.common.Utils"%>
<%@ page import="com.hanjin.apps.alps.esm.agt.common.CodeUtil"%>
<%@ page import="com.hanjin.apps.alps.esm.agt.common.ComboUtil"%>
<%@ page import="com.hanjin.apps.alps.esm.agt.agtclosing.agtclosing.event.EsmAgt0053Event"%>
<%@ page import="com.hanjin.bizcommon.util.BizComUtil"%>
<%@ page import="org.apache.log4j.Logger"%>
<%
	EsmAgt0053Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	DBRowSet rowSet = null; //DB ResultSet
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수
	//String successFlag = "";
	//String codeList  = "";
	//String pageRows  = "100";

	String userId = "";
	String ofcCd = "";
	String arOfcCd = "";
	String ar_ofc_cd = "";
	String agn_cd = "";
	String s_csr_no = "";
	String comm_stnd_cost_cd = "";
	String rev_vvd_cd = "";

	try {
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		userId = account.getUsr_id();
		ofcCd = account.getOfc_cd();

		event = (EsmAgt0053Event) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException)
					.loadPopupMessage();
		}else{
			GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

			//ESM_AGT_0052 화면에서 넘어온 파라미터를 받는다.
			s_csr_no  = JSPUtil.getParameter(request, "s_csr_no");
			comm_stnd_cost_cd  = JSPUtil.getParameter(request, "comm_stnd_cost_cd");
			agn_cd  = JSPUtil.getParameter(request, "agn_cd");
			rev_vvd_cd  = JSPUtil.getParameter(request, "rev_vvd_cd");

		} // end else
	} catch (Exception e) {
		out.println(e.toString());
	}


%>
<html>
<head>
<title>Agent Commission Request</title>
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

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<iframe height="0" width="0" name="frmHidden"></iframe>

<form method="post" name="form" onSubmit="return false;"><input type="hidden" name="f_cmd">
<input type="hidden" name="iPage"> 
<input type="hidden" name="s_csr_no" value="<%= s_csr_no %>">
<input type="hidden" name="comm_stnd_cost_cd" value="<%= comm_stnd_cost_cd %>">
<input type="hidden" name="agn_cd" value="<%= agn_cd %>">
<input type="hidden" name="rev_vvd_cd" value="<%= rev_vvd_cd %>">
<!-- BL No --> <!-- Outer Table (S)-->
<table width="800" class="popup" cellpadding="10" border="0">
	<tr>
		<td class="top"></td>
	</tr>
	<tr>
		<td><!-- : ( Title ) (S) -->
			<table width="100%" border="0">
				<tr>
					<td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp; CSR Detail Inquiry</td>
				</tr>
			</table>
			<!-- : ( Title ) (E) -->

				<!-- TABLE '#D' : ( Search Options ) (E) --> <!-- TABLE '#D' : ( Search Options ) (S) -->
				<table class="search">
					<tr>
						<td class="bg"><!-- : ( Agent Commission Request ) (S) --> <!-- : ( grid ) (S) -->
						<table width="100%" id="mainTable">
							<tr>
								<td><script language="javascript">ComSheetObject('sheet1');</script></td>
							</tr>
						</table>
						<!-- : ( grid ) (E) --> <!-- : ( Agent Commission Request ) (E) --> <!-- <textarea name="sXml" cols="150" rows="10" ></textarea> --></td>
					</tr>
				</table>
				<!-- TABLE '#D' : ( Search Options ) (E) --></td>
				<!-- Repeat Pattern -->
			</tr>
		</table>
<!-- : ( Button : pop ) (S) -->
<table class="gridtitle"><tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;※ N.Rev is only for O/B general commission.</td><td></td></tr></table>
<table class="height_5">
	<tr>
		<td></td>
	</tr>
</table>
			
<table width="100%" class="sbutton">
	<tr>
		<td height="71" class="popup">
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
    	 	  	<tr>
    	 	  		<td class="btn3_bg">
		    			<table border="0" cellpadding="0" cellspacing="0" align="left">
		    				<tr>
								<!-- Repeat Pattern -->
								<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_close" id="btn_close">Close</td><td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<!-- Repeat Pattern -->
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
<!-- : ( Button : pop ) (E) -->		

</form>
</body>

</html>

