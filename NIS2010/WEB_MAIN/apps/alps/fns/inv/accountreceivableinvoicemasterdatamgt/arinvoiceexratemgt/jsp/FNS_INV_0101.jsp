<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_INV_0101.jsp
*@FileTitle : VVD Ex.Rate Creation by VVD
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.07
*@LastModifier : 김세일
*@LastVersion : 1.0
* 2009.07.07 김세일
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
<%@ page import="com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.event.FnsInv0101Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	FnsInv0101Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.AccountReceivableInvoiceMasterDataMgt.ARInvoiceExRateMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (FnsInv0101Event)request.getAttribute("Event");
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
<title>VVD Ex.Rate Creation by VVD</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>
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
<input type="hidden" name="ofc" value="">
<input type="hidden" name="ofc_cd" value="">
<input type="hidden" name="svr_id" value="">
<input type="hidden" name="pagetype" value = "I"><!-- OFFICE LIST -->
<input type="hidden" name="ar_ofc_cd2"><!-- OFFICE LIST -->
<input type="hidden" name="curr_cd" value="">
<input type="hidden" name="xch_rt_rvs_flg" value="">
<input type="hidden" name="port" value="">
<input type="hidden" name="vvd" value="">
<input type="hidden" name="bnd" value="">
<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	style="padding-top: 2; padding-left: 5;">
	<tr>
		<td valign="top"><!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0"	class="title">
			<tr>
				<td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td>
			</tr>
			<tr>
				<td class="title"><img src="img/icon_title_dot.gif"	align="absmiddle"><span id="title"></span></td>
			</tr>
		</table>
		<!--Page Title, Historical (E)-->

		<table class="search">
			<tr>
				<td class="bg"><!-- biz_1  (S) -->
				<table class="search" border="0" style="width: 979;">
					<tr class="h23">
						<td width="" colspan="7">&nbsp;</td>
						<td width="">Office</td>
						<td width=""><script language="javascript">ComComboObject('ar_ofc_cd', 1, 100, 1);</script>
						</td>
					</tr>
					<tr class="h23">
						<td width="64">Local Cur.</td>
						<td width="110"><input type="text" value="" style="width: 40" class="input2" name="locl_curr_cd"></td>
						<td width="30">VVD</td>
						<td width="200"><input type="text" value="" name="vvd_cd" style="width: 80" class="input1" maxlength="9" dataformat="uppernum" required fullfill></td>
						<td width="250">
						<table class="search_sm2" border="0" style="width: 190;">
							<tr class="h23">
								<td>Bound</td>
								<td class="stm"><input type="radio" value="O" class="trans"	name="bnd_cd" checked onClick="javascript:changeHeaderName(this.value);">&nbsp;O/B
								&nbsp;&nbsp;<input	type="radio" value="I" class="trans" name="bnd_cd" onClick="javascript:changeHeaderName(this.value);">&nbsp;I/B</td>
							</tr>
						</table>
						</td>
						<td width="34">Port</td>
						<td width="140"><script language="javascript">ComComboObject('vps_port_cd', 1, 80, 2);</script>
						</td>
						<td width="40">Scope</td>
						<td width=""><script language="javascript">ComComboObject('svc_scp_cd', 1, 50, 1);</script>
						</td>
					</tr>
				</table>
				<!-- biz_1  (E) --></td>
			</tr>
		</table>

		<!--biz page (S)-->
		<table class="height_8">
			<tr>
				<td></td>
			</tr>
		</table>
		<table class="search">
			<tr>
				<td class="bg"><!--grid Box(S)--> <!--grid (S)-->
				<table width="100%" id="mainTable">
					<tr>
						<td width="100%"><script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				<!--grid (E)--> <!--  Button_Sub (S) -->
				<table width="100%" class="button">
					<tr>
						<td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr>
										<td class="btn2_left"></td>
										<td class="btn2" name="Row_Add">Row&nbsp;Add</td>
										<td class="btn2_right"></td>
									</tr>
								</table>
								</td>
								<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr>
										<td class="btn2_left"></td>
										<td class="btn2" name="btn2_Row_Copy">Row&nbsp;Copy</td>
										<td class="btn2_right"></td>
									</tr>
								</table>
								</td>
								<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr>
										<td class="btn2_left"></td>
										<td class="btn2" name="btn2_Row_Delete">Row&nbsp;Delete</td>
										<td class="btn2_right"></td>
									</tr>
								</table>
								</td>

							</tr>
						</table>
						</td>
					</tr>
				</table>
				<!-- Button_Sub (E) --></td>
			</tr>
		</table>

		</td>
	</tr>
</table>
<!--Button (S) -->
<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">
	<tr>
		<td class="btn1_bg">
		<table border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td>
				<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr>
						<td class="btn1_left"></td>
						<td class="btn1" name="btn1_Retrieve">Retrieve</td>
						<td class="btn1_right"></td>
					</tr>
				</table>
				</td>
				<td>
				<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr>
						<td class="btn1_left"></td>
						<td class="btn1" name="btn1_New">New</td>
						<td class="btn1_right"></td>
					</tr>
				</table>
				</td>
				<td class="btn1_line"></td>
				<td>
				<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr>
						<td class="btn1_left"></td>
						<td class="btn1" name="btn1_Save">Save</td>
						<td class="btn1_right"></td>
					</tr>
				</table>
				</td>
				<td>
				<table width="100%" border="0" cellpadding="0" cellspacing="0"	class="button">
					<tr>
						<td class="btn1_left"></td>
						<td class="btn1" name="btn_downexcel">Down Excel</td>
						<td class="btn1_right"></td>
					</tr>
				</table>
				</td>
				<td>
				<table width="100%" border="0" cellpadding="0" cellspacing="0"	class="button">
					<tr>
						<td class="btn1_left"></td>
						<td class="btn1" name="btn_print">Print</td>
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
<!------- Print용 Hidden RD Object Start -------->
<table width="100%" id="rdTable"> 
	<tr>
		<td width="100%">
			<script language="javascript">comRdObject('Rd');</script>
		</td>
	</tr>
</table>
<!------- Print용 Hidden RD Object End -------->

<!-- 개발자 작업  끝 -->
</form>
<form name="form2">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="curr_cd">
<input type="hidden" name="locl_curr_cd">
<input type="hidden" name="port_cd">
<input type="hidden" name="vvd_cd">
<input type="hidden" name="io_bnd_cd">
<input type="hidden" name="vsl_cd">
<input type="hidden" name="skd_voy_no">
<input type="hidden" name="skd_dir_cd">
<input type="hidden" name="svc_scp_cd">
<input type="hidden" name="chg_curr_cd">
</form>
</body>
</html>