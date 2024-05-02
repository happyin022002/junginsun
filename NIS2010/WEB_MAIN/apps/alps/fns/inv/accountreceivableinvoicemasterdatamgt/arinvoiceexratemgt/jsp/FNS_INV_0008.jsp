<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fns_inv_0008.jsp
*@FileTitle : Ex. Rate Entry by Date
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.27
*@LastModifier : 김세일
*@LastVersion : 1.0
* 2009.04.27 김세일
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
<%@ page import="com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.event.FnsInv0008Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	FnsInv0008Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfcCd = "";
	Logger log = Logger.getLogger("com.hanjin.apps.AccountReceivableInvoiceMasterDataMgt.ARInvoiceExRateMgt");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	    strOfcCd = account.getOfc_cd();	   
	   
		event = (FnsInv0008Event)request.getAttribute("Event");
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
<title>Ex. Rate Entry by Date</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

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

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="pagetype" value = "E">
<input type="hidden" name="strOfcCd" value="<%=strOfcCd %>">
<input type="hidden" name="ar_ctrl_ofc_cd" >
<input type="hidden" name="ar_ofc_cd" >
<input type="hidden" name="fm_dt" >
<input type="hidden" name="to_dt" >
<input type="hidden" name="loc_cd" >
<input type="hidden" name="eff_dt" >
<input type="hidden" name="curr_cd" >
<input type="hidden" name="ar_ofc_cd_1" >
<input type="hidden" name="locl_curr_cd_1" >
<input type="hidden" name="xch_rt_tp_cd" >
<input type="hidden" name="xch_rt_n3rd_tp_cd" >

<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top: 2; padding-left: 5;">
	<tr>
		<td valign="top"><!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0"
			class="title">
			<tr>
				<td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td>
			</tr>
			<tr>
				<td class="title"><img src="img/icon_title_dot.gif"	align="absmiddle"><span id="title"></span></td>
			</tr>
		</table>
		<!--Page Title, Historical (E)--> <!--biz page (S)-->
		<table class="search">
			<tr>
				<td class="bg"><!-- biz_1  (S) -->
				<table class="search" border="0" style="width: 979;">
					<tr class="h23">
						<td width="95">Local Currency</td>
						<td width="100"><input type="text" style="width: 60" value="" class="input2" name="locl_curr_cd"></td>
						<td width="44">Bound</td>
						<td width="110"><select style="width: 70;" class="input" name="io_bnd_cd">
							<option value="" selected>ALL</option>
							<option value="O">O/B</option>
							<option value="I">I/B</option>
						</select></td>
						<td width="30">Date</td>
						<td width="250"><input type="text" style="width: 75" value="" name="fm_dt1" onBlur="fn_ComGetMaskedValue('fm_dt1');" onKeyUp="javascript:checkFmDtLeng(this.value)">
										<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar1">&nbsp;&nbsp;~&nbsp;&nbsp;
										<input type="text" style="width: 75" value="" name="to_dt1"	onBlur="fn_ComGetMaskedValue('to_dt1');">
										<img class="cursor" src="img/btns_calendar.gif" width="19" height="20"	border="0" align="absmiddle" name="btns_calendar2"></td>
						<td width="44">Office</td>
						<td width=""><script language="javascript">ComComboObject('ar_ofc_cd2', 1, 100, 1);</script>
						</td>
					</tr>
				</table>

				<table class="height_2">
					<tr>
						<td></td>
					</tr>
				</table>
				<!-- Grid (S) -->
				<table width="100%" id="mainTable">
					<tr>
						<td width="100%"><script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				<!-- Grid (E) --> <!--  Button_Sub (S) -->
				<table width="100%" class="button">
					<tr>
						<td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr>
										<td class="btn2_left"></td>
										<td class="btn2" name="btn_add">Row&nbsp;Add</td>
										<td class="btn2_right"></td>
									</tr>
								</table>
								</td>
								<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr>
										<td class="btn2_left"></td>
										<td class="btn2" name="btn_copy">Row&nbsp;Copy</td>
										<td class="btn2_right"></td>
									</tr>
								</table>
								</td>
								<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr>
										<td class="btn2_left"></td>
										<td class="btn2" name="btn_del">Delete</td>
										<td class="btn2_right"></td>
									</tr>
								</table>
								</td>
								<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr>
										<td class="btn2_left"></td>
										<td class="btn2" name="btn_downExcel">Down Excel</td>
										<td class="btn2_right"></td>
									</tr>
								</table>
								</td>
								<!-- 삭제 2010-01-13 정영한
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
								<td class="btn2" name="btn_loadExcel">Load Excel</td>
								<td class="btn2_right"></td>
								</tr>
								</table></td>
								 -->
							</tr>
						</table>
						</td>
					</tr>
				</table>
				<!-- Button_Sub (E) --></td>
			</tr>
		</table>
		<!-- Tab BG Box(E) --> <!--biz page (E)--> <!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">
			<tr>
				<td class="btn1_bg">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_retrieve">Retrieve</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td>
						<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_new">New</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td class="btn1_line"></td>
						<td>
						<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_save">Save</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
					</tr>
				</table>

				<!--Button (E) --></td>
			</tr>
		</table>

		</td>
	</tr>
</table>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>