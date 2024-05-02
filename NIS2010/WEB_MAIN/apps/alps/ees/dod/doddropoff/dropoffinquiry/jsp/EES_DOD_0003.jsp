<%
/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EES_DOD_0003.jsp
*@FileTitle : Invoice Creation & Correction
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.23
*@LastModifier : yoo
*@LastVersion : 1.0
* 2016.06.23 yoo 
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
<%@ page import="com.hanjin.apps.alps.ees.dod.doddropoff.dropoffinquiry.event.EesDod0003Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	EesDod0003Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지

	String strUsr_id		= "";
	String strOfc_cd      = "";
	String strRhq_ofc_cd	= "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		//strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		strRhq_ofc_cd = account.getRhq_ofc_cd();

		event = (EesDod0003Event)request.getAttribute("Event");
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
<title>Invoice Creation & Correction</title>
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
<input type="hidden" name="usr_id" value="<%=strUsr_id%>">
<input type="hidden" name="ofc_cd">
<input type="hidden" name="tmp_ofc_cd">
<input type="hidden" name="usr_ofc_cd"			value="<%=strOfc_cd%>">
<input type="hidden" name="usr_rhq_ofc_cd"		value="<%=strRhq_ofc_cd%>">
<input type='hidden' name='AUTH_APRO_RQST_NO' value=''>
<input type="hidden" name="backendjob_key">		<!-- BackEndJob Key -->
<input type="hidden" name="backendjob_id">		<!-- BackEndJob 구분 ID -->
<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">

		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;<span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->
	
		<!-- TABLE '#D' : ( Button : Main ) (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
			<tr><td class="btn1_bg">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<!-- Repeat Pattern -->
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td><td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td><td class="btn1" name="btn_new" id="btn_new">New</td><td class="btn1_right"></td></tr></table></td>
						<td class="btn1_line"></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td><td class="btn1" name="btn_downexcel" id="btn_downexcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>
						<!-- Repeat Pattern -->
					</tr>
				</table>
			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Button : Main ) (E) -->
	
		<!--biz page (S)-->
		<table width="100%" class="search" border="0">
       		<tr><td class="bg">

				<!-- Condition (S)-->
				<table class="search" border="0" style="width:900;"> 
					<tr class="h23">
						<td width="350" class="stm">
							<input type="radio" name="ofc_flg" value="R" class="trans" checked>&nbsp;RHQ&nbsp;&nbsp;
							<input type="radio" name="ofc_flg" value="O" class="trans">&nbsp;Office&nbsp;&nbsp;
							<script language="javascript">ComComboObject('office',1,80,0,1,0,true);</script>
							<input type="checkbox" name="chk_sub_ofc" value="Y" onClick="doInclSubOfc()" class="trans">&nbsp;Incl. Sub Office
						</td>						
						<td width="100">&nbsp;&nbsp;DEL</td>
						<td colspan="2">	
							<input type="text" name="del_cd" style="width:100;text-align:center;ime-mode:disabled;" class="input" maxlength="5" dataformat="engup" required fullfill caption="DEL" >&nbsp;
						</td>
					</tr>
					<tr class="h23">
						<td>
							<table>
								<tr class="h23">
									<td width="80">&nbsp;&nbsp;BKG No.</td>
									<td>
										<input type="text" name="bkg_no" style="width:120;text-align:center;ime-mode:disabled;" class="input" maxlength="12" dataformat="engup" required fullfill caption="BKG" value="">&nbsp;
									</td>
									</td>
								</tr>
							</table>
						</td>
						<td>&nbsp;&nbsp;Special CUST</td>
						<td colspan="2">
							<input type="text" name="s_cust_cd" style="width:100;text-align:center;ime-mode:disabled;" class="input" maxlength="8" dataformat="engup" required fullfill caption="Customer" >&nbsp;
						    <img class="cursor" src="img/alps/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"  name="btn_customer">&nbsp;&nbsp;
							<input type="text" name="s_cust_nm" style="width:220;text-align:center;ime-mode:disabled;" class="input2" readonly caption="Customer" >&nbsp;
						</td>
					</tr>
					<tr class="h23">
						<td>
							<table>
								<tr class="h23">
									<td width="80">&nbsp;&nbsp;CNTR No.</td>
									<td>
										<input type="text" name="cntr_no" style="width:120;text-align:center;ime-mode:disabled;" class="input" maxlength="11" dataformat="engup" required fullfill caption="CNTR" value="">&nbsp;
									</td>
									</td>
								</tr>
							</table>
						</td>
						<td>&nbsp;&nbsp;Return CY</td>
						<td width="120">
							<input type="text" name="cntr_rtn_yd_cd" style="width:100;text-align:center;ime-mode:disabled;" class="input" maxlength="7" dataformat="engup" required fullfill caption="RTN CY" >&nbsp;
						</td>
						<td>
							<div id="ttl_usd_locl_amt" style="width:300;padding:4px 8px 4px 8px;"></div>
						</td>	
					</tr>
				</table>
				<!-- Condition (E)-->
			</td></tr>
		</table>
		<table class="height_10"><tr><td></td></tr></table>
		<table class="search">
			<tr><td class="bg" valign="top">
				<table width="100%"	id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				<table width="100%" id="hiddenTable">
					<tr>
						<td>
					    	<script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table>
				<table>
					<tr>
						<td>
					    	<script language="javascript">ComSheetObject('sheet3');</script>
						</td>
					</tr>
				</table>
				<table class="height_8"><tr><td></td></tr></table>
		    </td></tr>
		</table>
		<!--biz page (E)-->
	</td></tr>
</table>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>