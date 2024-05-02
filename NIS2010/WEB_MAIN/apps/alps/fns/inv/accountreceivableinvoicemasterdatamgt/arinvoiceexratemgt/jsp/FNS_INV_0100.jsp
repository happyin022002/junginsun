<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : fns_inv_0100.jsp
*@FileTitle : VVD Ex.Rate Creation by S/A Date
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
<%@ page import="com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.event.FnsInv0100Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	FnsInv0100Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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


		event = (FnsInv0100Event)request.getAttribute("Event");
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
<title>VVD Ex.Rate Creation by S/A Date</title>
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
<input type="hidden" name="eff_dt" value="">
<input type="hidden" name="curr_cd" value="">
<input type="hidden" name="xch_rt_rvs_flg" value="">
<input type="hidden" name="etd_dt2" value="">
<input type="hidden" name="org_curr_cd" value="">
<input type="hidden" name="org_ofc_cd" value="">

<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	style="padding-top: 2; padding-left: 5;">
	<tr>
		<td valign="top"><!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
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
				<td class="bg">
				<!-- 2009.12.15 옵션 삭제       	
				<table class="search" border="0" style="width:979;"> 
				
				<tr class="h23">
				<td width="">
					<table class="search_sm2" border="0" style="width:240;"> 
					<tr class="h23">
						<td width="50">&nbsp;Option</td>   
						<td class="stm"><input type="radio" value="S" class="trans" name="opt_type" checked onclick="fn_option(this.value);">&nbsp;S/A Date&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" value="V" class="trans" name="opt_type" onclick="fn_option(this.value);">&nbsp;VVD</td>
					</tr>
					</table>	
				</td>
				</tr>
				</table>
				--> 
				
				<!-- biz_1  (S) -->
				<table class="search" border="0" style="width: 979;">
					<tr class="h23">
						<td width="26">ETA/D</td>
						<td width="135"><input type="text" value="" name="etd_dt" style="width: 85" class="input1" dataformat="num" onBlur="fn_ComGetMaskedValue();">
										<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar"></td>
						<td width="80">&nbsp;&nbsp;Local Cur.</td>
						<td width="80"><input type="text" value="" style="width: 40" readonly class="input2" name="locl_curr_cd"></td>

						<td width="30">Port</td>
						<td width="100"><script language="javascript">ComComboObject('vps_port_cd', 1, 80, 2);</script>
						</td>

						<td width="35">Scope</td>
						<td width="100"><script language="javascript">ComComboObject('svc_scp_cd', 1, 50, 1);</script>
						</td>
						<td>
						<table class="search" border="0" id="bnd_ctnt">
							<tr class="h23">
								<td width="44">Bound</td>
								<td><select style="width: 67;" class="input1" name="bnd_cd">
									<option value="O" selected>O/B</option>
									<option value="I">I/B</option>
									<option value="T">Triangle</option>
								</select></td>
							</tr>
						</table>
						<table class="search" border="0" id="tri_ctnt" style="display: none">
							<tr class="h23">
								<td width="44">Triangle</td>
								<td><select style="width: 67;" class="input1" name="tri_yn"	onChange="javascript:changeTriYn()">
									<option value="N" selected>N</option>
									<option value="Y">Y</option>
								</select></td>
							</tr>
						</table>
						</td>
						<!-- 2009.12.15  VVD 삭제 					
						<td width="30">VVD</td>
						<td width="110"><input type="text" value="" name="vvd_cd" style="width:80" class="input2" maxlength="9" disabled dataformat="uppernum"></td>
						-->
						<td width="34">Office</td>
						<td width=""><script language="javascript">ComComboObject('ar_ofc_cd', 1, 100, 1);</script></td>
					</tr>
				</table>
				<!-- biz_1  (E) -->
				</td>
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
				<td class="bg"><!--grid Box(S)-->
				<table class="search" border="0" style="width: 100%;">
					<tr class="h23">
						<td width="68%" valign="top">
						<!--grid (S)-->
						<table width="100%" id="mainTable">
							<tr>
								<td width="100%"><script language="javascript">ComSheetObject('sheet1');</script>
								</td>
							</tr>
						</table>
						<!--grid (E)--> 
						<!--  Button_Sub (S) -->
						<table width="100%" class="button">
							<tr>
								<td class="btn2_bg">
								<table border="0" cellpadding="0" cellspacing="0">
									<tr>
										<td>
										<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr>
												<td class="btn2_left"></td>
												<td class="btn2" name="btn2_Row_Add">Row&nbsp;Add</td>
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
												<td class="btn2" name="btn2_Delete">Row&nbsp;Delete</td>
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
						<td width="2%"></td>
						<td width="32%" valign="top"><!--grid (S)-->
						<table width="100%" id="mainTable">
							<tr>
								<td width="100%"><script language="javascript">ComSheetObject('sheet2');</script>
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
												<td class="btn2" name="btn3_Row_Add">Row&nbsp;Add</td>
												<td class="btn2_right"></td>
											</tr>
										</table>
										</td>
										<td>
										<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr>
												<td class="btn2_left"></td>
												<td class="btn2" name="btn3_Row_Copy">Row&nbsp;Copy</td>
												<td class="btn2_right"></td>
											</tr>
										</table>
										</td>
										<td>
										<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr>
												<td class="btn2_left"></td>
												<td class="btn2" name="btn3_Delete">Row&nbsp;Delete</td>
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
				<!--grid Box(E)-->
				<script language="javascript">ComSheetObject('sheet3');</script>
				</td>
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

		<!--Button (E) --></td>
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
</body>
</html>