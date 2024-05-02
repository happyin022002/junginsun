<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fns_inv_0029.jsp
*@FileTitle : Manual System Clear
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.04
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2009.06.04 박정진
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
<%@ page import="com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.event.FnsInv0029Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.syscommon.management.alps.user.basic.UserBC"%>
<%@ page import="com.hanjin.syscommon.management.alps.user.basic.UserBCImpl"%>
<%@ page import="com.hanjin.syscommon.management.alps.user.vo.ComUserInfoVO"%>
<%@ page import="java.util.List"%>

<%
	FnsInv0029Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String usr_ofc_cd	= "";
	Logger log = Logger.getLogger("com.hanjin.apps.AccountReceivableInvoiceMgt.BookingARCreation");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   	
	   	
	   	strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		
		UserBC user= new UserBCImpl();
	   	List<ComUserInfoVO> rcvUserInfos = user.comUsrInfo(strUsr_id);
	   	
	   	usr_ofc_cd = rcvUserInfos.get(0).getOfcCd();


		event = (FnsInv0029Event)request.getAttribute("Event");
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
<title>Manual System Clear</title>
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

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<input type="hidden" name="pagetype" value = "E">
<input type="hidden" name="ofc_cd">
<input type="hidden" name="usr_ofc_cd" value = "<%=usr_ofc_cd %>">
<input type="hidden" name="ots_smry_cd">
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
<tr>
	<td valign="top">
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->

		<!--biz page (S)-->
		<table class="search" id="mainTable">
		<tr>
			<td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:800;">
				<tr class="h23">
					<td width="80">Office</td>
					<td style="padding-left:6;"><script language="javascript">ComComboObject('ar_ofc_cd', 1, 110, 0);</script></td>
				</tr>
				<tr class="h23">
					<td>B/L No.</td>
					<td style="padding-left:4;">
					<input name="bl_src_no" type="text" style="width:110" class="input1" dataformat="engup" maxlength="12" value="">
					</td>
				</tr>
<%if (usr_ofc_cd.equals("SELPIO")||usr_ofc_cd.equals("SELADG")){%>	
			   <tr class="h23">
					<td>I/F No.</td>
					<td style="padding-left:4;">
					<input name="if_no1" type="text" style="width:110" class="input1" dataformat="engup" maxlength="11" value="">
					<input name="if_no2" type="text" style="width:110" class="input1" dataformat="engup" maxlength="11" value="">
					<input name="if_no3" type="text" style="width:110" class="input1" dataformat="engup" maxlength="11" value="">
					<input name="if_no4" type="text" style="width:110" class="input1" dataformat="engup" maxlength="11" value="">
					<input name="if_no5" type="text" style="width:110" class="input1" dataformat="engup" maxlength="11" value="">
					<input name="if_no6" type="text" style="width:110" class="input1" dataformat="engup" maxlength="11" value="">
					
					</td>
				</tr>
<%}%>				
				<tr class="h23">
					<td>VVD</td>
					<td style="padding-left:4;"><input name="vvd_cd" type="text" style="width:110;" class="input1" maxlength="9" minlength="9" value="" dataformat="engup"></td>
				</tr>
				<tr class="h23">
					<td>Customer</td>
					<td style="padding-left:4;"><input name="cust_cnt_cd" type="text" style="width:25;" class="input1" value="" maxlength="2" dataformat="engup">&nbsp;<input name="cust_seq" type="text" style="width:58;" class="input1" maxlength="6" value="" dataformat="num">&nbsp;<img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" name="btns_cust1">&nbsp;<input name="cust_nm" type="text" style="width:350" class="input2" value="" readonly tabIndex="-1">&nbsp;<img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" name="btns_cust2"></td>
				</tr>
				<tr><td colspan="2" height="15"></td></tr>
				<tr class="h23">
					<td width="80">Total Count</td>
					<td style="padding-left:4;"><input name="total_count" type="text" style="width:110; text-align:right;" class="input2" value="" readOnly></td></tr>
				</table>
				<!--  biz_1   (E) -->
			</td>
		</tr>
		</table>
		<!--biz page (E)--> 
	</td>
</tr>
</table>
<!--Button (S) -->
<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
<tr>
	<td class="btn1_bg">
		<table border="0" cellpadding="0" cellspacing="0">
		<tr>
<%if (usr_ofc_cd.equals("SELPIO")||usr_ofc_cd.equals("SELADG")){%>			
			<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save">Save</td>
					<td class="btn1_right"></td>
				</tr>
			</table></td>
<%}%>			
			<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right"></td>
				</tr>
			</table></td>
			<td class="btn1_line"></td>
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_execute">Execute</td>
					<td class="btn1_right"></td>
				</tr>
			</table></td>
			
		</tr>
		</table>
		<!--Button (E) -->
	</td>
</tr>
</table>
<div style="display:none">
<!-- Grid  (S) -->
<table width="100%" class="search"  id="mainTable"> 
	<tr>
		<td width="100%">
		<script language="javascript">ComSheetObject('sheet1');</script>
		</td>
	</tr>
</table> 			
<!-- Grid (E) -->
</div>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>