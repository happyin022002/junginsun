<%--
/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ESD_TRS_0980.jsp
*@FileTitle :More CNT Candidates
*Open Issues :
*Change history :
*@LastModifyDate : 2014-11-19
*@LastModifier : SHIN DONG IL
*@LastVersion : 1.0
* 2014-11-19 SHIN DONG IL
* 1.0 최초 생성
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.Vector"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.trs.workordermanage.workorderissue.event.EsdTrs0980Event"%>
<%
	EsdTrs0980Event  			event 			= null;		//PDTO(Data Transfer Object including Parameters)
	Exception 					serverException	= null;		//서버에서 발생한 에러
	DBRowSet 					rowSet	 		= null;		//DB ResultSet
	String 						strErrMsg 		= "";		//에러메세지
	String sc_no        = "";
	String rfa_no       = "";
	String ctrl_ofc_cd  = "";
	String trsp_bnd_cd 	= "";
	String fm_nod_cd   	= "";
	String fm_nod_yard 	= "";
	String to_nod_cd   	= "";
	String to_nod_yard 	= "";
	String dor_nod_cd  	= "";
	String dor_nod_yard = "";
	String chk_row      = "";
	String vndr_seq     = "";
	String scrn_mode    = "";

	try {

	  	SignOnUserAccount account	= (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);

		sc_no       	= JSPUtil.getNull(request.getParameter("sc_no"));
		rfa_no       	= JSPUtil.getNull(request.getParameter("rfa_no"));
		ctrl_ofc_cd 	= JSPUtil.getNull(request.getParameter("ctrl_ofc_cd"));
	    trsp_bnd_cd 	= JSPUtil.getNull(request.getParameter("trsp_bnd_cd"));
	    fm_nod_cd   	= JSPUtil.getNull(request.getParameter("fm_nod_cd"));
	    fm_nod_yard 	= JSPUtil.getNull(request.getParameter("fm_nod_yard"));
	    to_nod_cd   	= JSPUtil.getNull(request.getParameter("to_nod_cd"));
	    to_nod_yard 	= JSPUtil.getNull(request.getParameter("to_nod_yard"));
	    dor_nod_cd  	= JSPUtil.getNull(request.getParameter("dor_nod_cd"));
	    dor_nod_yard 	= JSPUtil.getNull(request.getParameter("dor_nod_yard"));
	    chk_row 	    = JSPUtil.getNull(request.getParameter("chk_row"));
	    ctrl_ofc_cd 	= JSPUtil.getNull(request.getParameter("ctrl_ofc_cd"));
	    vndr_seq        = JSPUtil.getNull(request.getParameter("vndr_seq"));
	    scrn_mode 		= JSPUtil.getNull(request.getParameter("scrn_mode"));
	    
	    event 				= (EsdTrs0980Event)request.getAttribute("Event");
	    serverException 	= (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>More Candidates</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">

	<%//= JSPUtil.getIBCodeCombo("wy_type", "", "CD00929", 0, "")%>

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="vndr_seq" value="<%=vndr_seq %>">
<input type="hidden" name="sc_no" value="<%=sc_no %>">
<input type="hidden" name="rfa_no" value="<%=rfa_no %>">
<input type="hidden" name="ctrl_ofc_cd" value="<%=ctrl_ofc_cd %>">
<input type="hidden" name="trsp_bnd_cd" value="<%=trsp_bnd_cd %>">
<input type="hidden" name="fm_nod_cd" value="<%=fm_nod_cd %>">
<input type="hidden" name="fm_nod_yard" value="<%=fm_nod_yard %>">
<input type="hidden" name="to_nod_cd" value="<%=to_nod_cd %>">
<input type="hidden" name="to_nod_yard" value="<%=to_nod_yard %>">
<input type="hidden" name="dor_nod_cd" value="<%=dor_nod_cd %>">
<input type="hidden" name="dor_nod_yard" value="<%=dor_nod_yard %>">
<input type="hidden" name="chk_row" value="<%=chk_row %>">
<input type="hidden" name="scrn_mode" value="<%=scrn_mode %>">

<input type="hidden" name="WY_TP_CD"	 	value="">
<input type="hidden" name="SP_TP_CD"	 	value="">
<input type="hidden" name="CUST_CNT_CD" 	value="">
<input type="hidden" name="CUST_SEQ" 		value="">
<input type="hidden" name="BASIS_DT"		value="">
<input type="hidden" name="VNDR_CD"			value="">
<input type="hidden" name="WTR_RCV_TERM"	value="">
<input type="hidden" name="WTR_DE_TERM"		value="">


<!-- OUTER - POPUP (S)tart -->
<table width="450" class="popup" cellpadding="10" border="0">
	<tr><td class="top"></td></tr>
	<tr>
		<td valign="top">
			<!-- : ( Title ) (S) -->
			<table width="100%" border="0">
				<tr>
					<td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp; More CNT Candidate</td>
				</tr>
			</table>
			<!-- : ( Title ) (E) -->
			<!-- : ( Search Options ) (S) -->
	     	<table class="search">
	       		<tr>
	       			<td class="bg">
	                    <table width="100%" id="mainTable">
	                        <tr>
	                        	<td>
		                             <script language="javascript">ComSheetObject('sheet');</script>
		                        </td>
		                    </tr>
	                    </table>
	                    <table width="100%" id="hiddenTable">
	                        <tr>
	                        	<td>
		                             <script language="javascript">ComSheetObject('sheet1');</script>
		                        </td>
		                    </tr>
	                    </table>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>

<table class="height_5"><tr><td></td></tr></table>

<!-- : ( Button : Sub ) (S) -->
<table width="100%" class="sbutton">
	<tr>
		<td height="71" class="popup">
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
		       	<tr>
		       		<td class="btn3_bg">
					    <table border="0" cellpadding="0" cellspacing="0">
						    <tr>
								<!-- Repeat Pattern -->
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td><td class="btn1" name="btn_apply" id="btn_apply">Apply</td><td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td class="btn1_line"></td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td><td class="btn1" name="btn_close" id="btn_close">Close</td><td class="btn1_right"></td>
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
<!-- : ( Button : Sub ) (E) -->



</form>

</body>
</html>