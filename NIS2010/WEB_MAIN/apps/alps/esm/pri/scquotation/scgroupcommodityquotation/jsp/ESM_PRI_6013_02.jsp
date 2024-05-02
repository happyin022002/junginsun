<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_6013_02.jsp
*@FileTitle : S/C Quotation Commodity Group Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.22
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.08.09 이승준
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
<%@ page import="com.hanjin.apps.alps.esm.pri.scquotation.scgroupcommodityquotation.event.EsmPri601302Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri601302Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.SCQuotation.SCGroupCommodityQuotation");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmPri601302Event)request.getAttribute("Event");
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
<title>S/C Quotation Commodity Group Creation</title>
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

<body  onLoad="setupPage();" onResize="sheetColResize();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->

<input type="hidden" name="cd" value="">
<input type="hidden" name="qttn_no" value="">
<input type="hidden" name="qttn_ver_no" value="">
<input type="hidden" name="svc_scp_cd" value="">
<input type="hidden" name="grp_cmdt_seq" value="">
<input type="hidden" name="src_info_cd" value="N">

<input type="hidden" name="eff_dt" value="">
<input type="hidden" name="exp_dt" value="">
<!-- gline exist -->
<input type="hidden" name="grp_cmdt_cnt" value="0">

<table class="search"> 
     	<tr><td class="bg">	
	
	<!--Button (S) -->
<table width="100%" border="0" class="button" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
     	<tr><td class="btn1_bg">
    <table border="0" cellpadding="0" cellspacing="0">
    <tr>
		<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
			<tr><td class="btn1_left"></td>
			<td class="btn1" name="btn_retrieve">Retrieve</td>
			<td class="btn1_right"></td>
			</tr>
		</table></td>
	</tr>
	</table></td>
	</tr>
	</table>
  <!--Button (E) -->
	
	<table class="height_10"><tr><td></td></tr></table>
	
		<table class="search">
			<tr>
				<td width="40%" valign="top">
				<!--grid (s)-->
					<table width="100%"  id="mainTable"> 
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet1');</script>
							</td>
						</tr>
					</table>
				<td width="5%" align="center"><img src="img/btn_add.gif" width="26" height="26" alt="" border="0" align="absmiddle">&nbsp;</td>	
				<td width="55%"  valign="top">
					<table width="100%"  id="mainTable"> 
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet2');</script>
							</td>
						</tr>
					</table>
				<!--grid(E)-->
	
				</td>
			</tr>
		
		</table>
		
		
	</td></tr>
</table>
<div id="hiddenSheetLayer" style="display: none">
<script language="javascript">ComSheetObject('sheet3');</script>
</div>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>