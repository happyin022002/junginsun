<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TES_024_1.jsp ===> ALPS로 변환되면서 ESD_TES_0026.jsp로 변환됨.
*@FileTitle : Terminal invoice CSR Creation - Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-18
*@LastModifier : jongbaemoon
*@LastVersion : 1.0
* 2006-12-18 jongbaemoon
* 1.0 최초 생성 2
2012.09.28  유병희  [CHM-201220148] [TES] eBilling PDF 증빙 조회 -- CSR Creation에 추가 수정 작업
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.event.EsdTes0024Event"%>
<%
//	ESD_TES_024Event  event = null;				//PDTO(Data Transfer Object including Parameters)
//	ESD_TES_024EventResponse eventResponse = null;	//RDTO(Data Transfer Object including DB ResultSet)
	Exception serverException   = null;			//서버에서 발생한 에러
	DBRowSet rowSet	  	= null;							   //DB ResultSet
	String strErrMsg 	= "";								 //에러메세지
	int rowCount	 	= 0;								  //DB ResultSet 리스트의 건수
	String userId  		= "";
	//String ofc_cd  = "";
	String usr_eml 		= "";
	String usr_nm  		= "";
	String cnt_cd  		= "";

	String csr_no 		= "";
	csr_no 				= JSPUtil.getParameter(request, "csr_no".trim(), "");

	try {

	   SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   userId=account.getUsr_id();
	   //userAuth=account.getAuth();
	   //ofc_cd=account.getOfc_cd();
	   usr_nm	= account.getUsr_nm();
	   usr_eml	= account.getUsr_eml();
	   cnt_cd 	= account.getCnt_cd();

	   // ofc_cd  = "CHIBB";

//		event = (ESD_TES_024Event)request.getAttribute("Event");

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}else{

		} // end else
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Terminal invoice CSR Creation - Detail</title>
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
	var cnt_cd = "<%=cnt_cd%>";


</script>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input	type="hidden" name="f_cmd">
<input type="hidden" name="iPage">


<!-- TABLE '#C' : ( Left Menu : Round Frame ) (S) -->

<!-- OUTER FRAME : "to make sum of components' HEIGHTS 100%" (S)tart -->
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
<tr><td valign="top">

<!-- ################# TABLE '#A' ::: 'TOP' FRAME (START) ################## -->

<!-- Put your 'STYLESHEET' into the <HEAD> tag on the corresponding page if you make 'FRAMESET's -->

<!-- TABLE '#A' : Top Menu (E)nd -->
<!-- ################# TABLE '#A' ::: 'TOP' FRAME (END) ################## -->


<!-- ################# TABLE '#B' ::: 'LEFT + RIGHT' FRAME (START) ################## -->
<!-- TABLE '#B' : 'Left + Right Body' Table (S)tart -->
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
<tr><td class="bodyleft">

	</td>
	<td class="bodyright">

		<!-- ####### TABLE '#D' ::: 'RIGHT' FRAME (START) ####### -->

		<!-- Put your 'STYLESHEET' into the <HEAD> tag on the corresponding page if you make 'FRAMESET's -->
		<br>

		<!-- TABLE '#D' : ( Search Options :  ) (S) -->
		<table class="search">
			<tr>
				<td class="bg">
					<!-- : ( Week ) (S) -->
					<table class="search_in" border="0" style="width:870;">
						<tr class="h23">
							<td width="13%">Cost Office</td>
							<td width="11%">&nbsp;<input name="cost_ofc_cd" type="text" style="width:60" value="" readonly></td>
							<td width="12%">Confirmed Date</td>
							<td width="17%">&nbsp;<input name="inv_cfm_dt" type="text" style="width:75" value="" readonly>&nbsp;<!--<img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar1">--></td>
							<td width="13%">Payment Vender</td>
							<td>&nbsp;<input name="vndr_seq" type="text" style="width:70" value="" readonly> <!--<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle">--> &nbsp;<input name="vndr_seq_name" type="text" style="width:150" value="" readonly></td>
						</tr>

						<tr class="h23">
							<td>No Of INV</td>
							<td>&nbsp;<input name="cnt_inv" type="text" style="width:60" value="" readonly></td>
							<td>INV Currency</td>
							<td>&nbsp;<input name="curr_cd" type="text" style="width:75" value="" readonly></td>
							<td>Total Amount</td>
							<td>&nbsp;<input name="total_amt" type="text" style="width:93" value="" readonly></td>
						</tr>

						<tr class="h23">
							<td>Payment Due DT</td>
							<td colspan="3">&nbsp;<input name="payment_due_dt" type="text" style="width:75" maxlength="10" value="" onKeyUp='isNum1(this);;tes_isNumD(this,"Y");' onKeyDown='tes_chkInput(this);;tes_isNumD(this,"Y");' onBlur='isDate1(this);' readonly>&nbsp;<img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar2"></td>
							<td colspan="2">
								<div id="srLayer" style="display:none">
								<table class="search" border="0" style="width:100%;">
									<tr class="h23">
										<td width="28%">ASA No</td>
										<!--<td>&nbsp;<select style="width:93;"><option value="0" selected></option></select></td>-->
										<td><script language="javascript">ComComboObject('asa_no',1, 100 , 0 )</script></td>
									</tr>
								</table>
								</div>
								<div id="srLayer" style="display:none">
								<table class="search" border="0" style="width:100%;">
									<tr class="h23">
										<td width="28%">증 빙 구 분</td>
										<td>&nbsp;<select style="width:93;" name="evi_gb1" onChange="eviGbSelect(1)"><option value=""></option>
											<option value="1">세금계산서</option>
											<option value="2">계산서</option>
											<option value="3">기타</option>
											</select></td>
									</tr>
								</table>
								</div>
								<div id="srLayer" style="display:none">
								<table class="search" border="0" style="width:100%;">
									<tr class="h23">
										<td width="28%">증 빙 구 분</td>
										<td>&nbsp;<select style="width:93;" name="evi_gb2" onChange="eviGbSelect(2)"><option value=""></option>
											<option value="1">세금계산서</option>
											<option value="2">계산서</option>
											<option value="3">기타</option>
											</select></td>
											<td width="15%">&nbsp;&nbsp; ASA No </td>
											<td><script language="javascript">ComComboObject('asa_no',1, 100 , 0 )</script></td>
									</tr>
								</table>
								</div>
							</td>
						</tr>
					</table>
					<!-- : ( Week ) (E) -->
				</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Search Options : ) (E) -->


		<table class="height_10"><tr><td></td></tr></table>

		<!-- TABLE '#D' : ( Search Options :  ) (S) -->
		<table class="search">
			<tr>
				<td class="bg">
					<!-- : ( Week ) (S) -->
					<table class="search_in" border="0" style="width:870;">
						<tr class="h23">
							<td width="6%">CSR No.</td>
							<td width="40%">&nbsp;<input name="csr_no" type="text" style="width:260" value="<%=csr_no%>"></td>
						</tr>

					</table>
					<!-- : ( Week ) (E) -->
				</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Search Options : ) (E) -->


		<table class="height_10"><tr><td></td></tr></table>

		<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
		<table class="search" border="0">
			<tr>
				<td class="bg_b1">
					<table class="height_10"><tr><td></td></tr></table>

					<!-- : ( Grid : Week ) (S) -->
					<table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet1');</script>
                        </td></tr>
		            </table>
					<!-- : ( Grid : Week ) (E) -->
					<!-- : ( Button : Sub ) (S) -->
					<table width="100%" class="sbutton">
						<tr>
							<td class="align">
								<!--div id="btLayer" style="display:none"-->
								<table class="sbutton">
									<tr>
										<td>
											<div id="EDILayer01" style="display:none">
											<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td>
											<td class="btn2" name="btn_EDIinvoiceview" id="btn_EDIinvoiceview">Invoice PDF</td>
											<td class="btn2_right"></td></tr></table>
											</div>
										</td>										
										<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn2_left"></td><td class="btn2" name="btng_preview" id="btng_preview">CSR Preview</td>
										<td class="btn2_right"></td></tr></table>
										</td>	
										<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn2_left"></td><td class="btn2" name="btng_detail" id="btng_detail">Detail</td>
										<td class="btn2_right"></td></tr></table>
										</td>											
										<!-- 								
										<td class="bt"><img class="cursor" src="/hanjin/img/button/btng_preview.gif" width="65" height="19" border="0" name="btng_preview"></td>
										<td class="bt"><img class="cursor" src="/hanjin/img/button/btng_detail.gif" height="19" border="0" name="btng_detail"></td>
										 -->
									</tr>
								</table>
								<!--/div-->
								<!--
								<div id="btLayer" style="display:none">
								<table class="sbutton">
									<tr>
										<td class="bt"><img class="cursor" src="/hanjin/img/button/btng_evidence.gif" height="19" border="0" name="btng_evidence"></td>
										<td class="bt"><img class="cursor" src="/hanjin/img/button/btng_preview.gif" width="65" height="19" border="0" name="btng_preview"></td>
										<td class="bt"><img class="cursor" src="/hanjin/img/button/btng_print.gif" width="65" height="19" border="0" name="btng_print"></td>
										<td class="bt"><img class="cursor" src="/hanjin/img/button/btng_approvalrequest.gif" width="126" height="19" border="0" name="btng_approvalrequest"></td>
									</tr>
								</table>
								</div>
								-->
							</td>
						</tr>
					</table>
					<!-- : ( Button : Sub ) (E) -->
				</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Tab BG Box ) (E) -->
		<!-- ####### TABLE '#D' ::: 'RIGHT' FRAME (END) ####### -->


	</td>
</tr>
</table>
<!-- TABLE '#B' : 'Left + Right Body' Table (E)nd -->
<!-- ################# TABLE '#B' ::: 'LEFT + RIGHT' FRAME (END) ################## -->

	</td></tr>
</table>
<!-- OUTER FRAME : "to make sum of components' HEIGHTS 100%" (E)nd -->

</form>
</body>
</html>
<DIV style="display:none">
					<!-- : ( Grid : Week ) (S) -->
					<table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet2');</script>
                        </td></tr>
		            </table>
					<!-- : ( Grid : Week ) (E) -->

					<!-- : ( Grid : Week ) (S) -->
					<table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet3');</script>
                        </td></tr>
		            </table>
					<!-- : ( Grid : Week ) (E) -->

</DIVाऀऀऀऀऀऀ