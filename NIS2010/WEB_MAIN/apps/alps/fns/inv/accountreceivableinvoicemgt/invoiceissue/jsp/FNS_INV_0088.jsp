<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fns_inv_0088.jsp
*@FileTitle : (Vietnam)Multi B/L List
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.30
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.10.30 최우석
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
<%@ page import="com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.event.FnsInv0088Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	FnsInv0088Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
//	String successFlag = "";
//	String codeList  = "";
//	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
//	Logger log = Logger.getLogger("com.hanjin.apps.AccountReceivableInvoiceMgt.InvoiceIssue");

	String arOfcCd = request.getParameter("ar_ofc_cd")==null?"":request.getParameter("ar_ofc_cd");
	String ioBndCd = request.getParameter("io_bnd_cd")==null?"":request.getParameter("io_bnd_cd");
	String invType = request.getParameter("inv_type")==null?"":request.getParameter("inv_type");
	String dtOpt = request.getParameter("dt_opt")==null?"":request.getParameter("dt_opt");
	String fromDt = request.getParameter("from_dt")==null?"":request.getParameter("from_dt");
	String toDt = request.getParameter("to_dt")==null?"":request.getParameter("to_dt");
	String xchRtDt = request.getParameter("xch_rt_dt")==null?"":request.getParameter("xch_rt_dt");
	String xchRt = request.getParameter("xch_rt")==null?"":request.getParameter("xch_rt");
	String vvdCd = request.getParameter("vvd_cd")==null?"":request.getParameter("vvd_cd");
	String svcScpCd = request.getParameter("svc_scp_cd")==null?"":request.getParameter("svc_scp_cd");
	String portCd = request.getParameter("port_cd")==null?"":request.getParameter("port_cd");
	String custCntCd = request.getParameter("cust_cnt_cd")==null?"":request.getParameter("cust_cnt_cd");
	String custSeq = request.getParameter("cust_seq")==null?"":request.getParameter("cust_seq");
	String issType = request.getParameter("iss_type")==null?"MULTI":request.getParameter("iss_type");
	String vnInvPayMzdCd = request.getParameter("vn_inv_pay_mzd_cd")==null?"":request.getParameter("vn_inv_pay_mzd_cd");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
	   
		event = (FnsInv0088Event)request.getAttribute("Event");
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
<title>(Vietnam)Multi B/L List</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!--<LINK href="/hanjin/css/alps_contents.css" type="text/css" rel="stylesheet"/>-->

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<input type="hidden" name="ar_ofc_cd" value="<%=arOfcCd%>">
<input type="hidden" name="io_bnd_cd" value="<%=ioBndCd%>">
<input type="hidden" name="inv_type" value="<%=invType%>">
<input type="hidden" name="dt_opt" value="<%=dtOpt%>">
<input type="hidden" name="from_dt" value="<%=fromDt%>">
<input type="hidden" name="to_dt" value="<%=toDt%>">
<input type="hidden" name="xch_rt_dt" value="<%=xchRtDt%>">
<input type="hidden" name="xch_rt" value="<%=xchRt%>">
<input type="hidden" name="vvd_cd" value="<%=vvdCd%>">
<input type="hidden" name="svc_scp_cd" value="<%=svcScpCd%>">
<input type="hidden" name="port_cd" value="<%=portCd%>">
<input type="hidden" name="cust_cnt_cd" value="<%=custCntCd%>">
<input type="hidden" name="cust_seq" value="<%=custSeq%>">
<input type="hidden" name="iss_type" value="<%=issType%>">
<input type="hidden" name="ofc_cd" value="<%=strOfc_cd%>">
<input type="hidden" name="vn_inv_pay_mzd_cd" value="<%=vnInvPayMzdCd%>">
<input type="hidden" name="com_mrdPath">
<input type="hidden" name="com_mrdArguments">

<input type="hidden" name="preview_yn">

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
	<tr><td class="top"></td></tr>
	<tr><td valign="top">
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;(Vietnam)Multi B/L List</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 		<table class="search"> 
       		<tr><td class="bg">
				<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table> 
				<!-- Grid (E) -->
			</td></tr>
		</table>
		<!-- : ( Search Options ) (E) -->
<table class="height_5"><tr><td></td></tr></table>
	
	</td></tr>
</table> 
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
	<tr><td height="71" class="popup">
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
	       	<tr><td class="btn3_bg">
			    <table border="0" cellpadding="0" cellspacing="0">
					<tr><td width="72">
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn_ok">OK</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
					<td width="72">
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn_close">Close</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
					</td></tr>
				</table>
			</td></tr>
		</table>
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>