<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0030.jsp
*@FileTitle : Service Provider로부터 W/O실행 이후 비용 지불을 위한 Invoice를 일괄 Confirm하거나, Confirmed or Interfaced Invoice를 취소하는 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2007-01-26
*@LastModifier : poong_yeon
*@LastVersion : 1.0 
* 2007-01-26 poong_yeon
* 1.0 최초 생성
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.trs.invoicemanage.invoiceinquirycorrection.event.EsdTrs0030Event"%>
<%
	EsdTrs0030Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	DBRowSet rowSet	  = null;							   //DB ResultSet
	String strErrMsg = "";								 //에러메세지
	int rowCount	 = 0;								  //DB ResultSet 리스트의 건수

	SignOnUserAccount account= null;
	try {

		account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		event = (EsdTrs0030Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
	String today = DateTime.getFormatString("yyyyMMdd");
	String beforeOneMonth = DateTime.addMonths(today, -1);

	String dateCD = JSPUtil.getCodeCombo("date_cd", "01", "style='width:110'", "CD01475", 0, "");
	String statusCD = JSPUtil.getCodeCombo("status_cd", "01", "style='width:176'", "CD00824", 0, "000030:ALL:ALL");
	String holdCD = JSPUtil.getCodeCombo("hold_cd", "01", "style='width:79'", "CD00912", 0, "000030:ALL:ALL");
	String receivedCD = JSPUtil.getCodeCombo("recieved_cd", "01", "style='width:85'", "CD00914", 0, "000030:ALL:ALL");
	String amountVeryfyCD = JSPUtil.getCodeCombo("amount_verify_cd", "01", "style='width:279'", "CD00927", 0, "000030:ALL:ALL");

%>
<html>
<head>
<title>Invoice Inquiry - Correction</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	var beforeOneMonth = '<%=beforeOneMonth%>';
	var today = '<%=today%>';
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
<form method="post" name="form" onSubmit="return false;">
<input	type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="old_ofc_cd" value="<%=account.getOfc_cd()%>">
<input type="hidden" name="FORM_CRE_USR_ID" value="<%=account.getUsr_id()%>">
<input type="hidden" name="FORM_USR_OFC_CD" value="<%=account.getOfc_cd()%>">
<input type="hidden" name="INV_CRE_OFC_CD">
<input type="hidden" name="FORM_INV_NO">
<input type="hidden" name="FORM_INV_VNDR_SEQ">



<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
	<tr>
		<td>
			<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr>
					<td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td>
				</tr>
				<tr>
					<td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td>
				</tr>
			</table>
			<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->

			<!-- TABLE '#D' : ( Button : Main ) (S) -->
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
		       	<tr>
		       		<td class="btn1_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<!-- Repeat Pattern -->
								<td>
									<div id="invEdiPdfViewLayer" style="display:none">
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" id="btn_inv_edi_pdf_view" name="btn_inv_edi_pdf_view">EDI Invoice View</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
									</div>
								</td>								
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" id="btn_retrieve" name="btn_retrieve">Retrieve</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td class="btn1_line"></td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" id="btn_reset" name="btn_reset">Reset</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" id="btn_minimize" name="btn_minimize">Minimize</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<!-- 
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" id="btn_pdf" name="btn_pdf">PDF</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								 -->
								<!-- Repeat Pattern -->
							</tr>
						</table>
					</td>
				</tr>
			</table>
		<!-- TABLE '#D' : ( Button : Main ) (E) -->
	 <div id="showMin" style="display:inline">
		<!-- TABLE '#D' : ( Search Options ) (S) -->
		<table class="search">
			<tr>
				<td class="bg">
					<table class="search_in" border="0">
						<tr class="h23">
							<td width="57">Date</td>
							<td width="326" class="stm"><%=dateCD%><img src="/hanjin/img/blank.gif" width="2" height="1" border="0"><input type="text" maxlength="8" style="width:75" name='fmdate'>&nbsp;~&nbsp;<input type="text" maxlength="8" style="width:75" name='todate'><img src="/hanjin/img/blank.gif" width="2" height="1" border="0"><img class="cursor" img src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name='btns_calendar'></td>
							<td width="50">Status</td>
							<td width="220"><%=statusCD%></td>
							<td width="35">Hold</td>
							<td width="110"><%=holdCD%></td>
							<td width="88">Received Type</td>
							<td align="right"><%=receivedCD%></td>
						</tr>
					</table>
					<table class="search_in" border="0">
						<tr class="h23">
							<td width="57">Amount</td>
							<td width="326"><%=amountVeryfyCD%></td>
							<td width="110">Service Provider</td>
							<td>
								<table border="0" style="height:15; width:100%; background-color: #E9E9E9;">
                                	<tr>
                                		<td class="sm" width="185" style="padding-left:10;">
	                                		<input type="radio" class="trans" name='sp_tp' value='wo' checked>Work Order
											<input type="radio" name='sp_tp' value='py'class="trans">Payment
										</td>
										<td>
											<input type='text' name='combo_svc_provider'  style="width:79;" onChange='getTextVendorSeq(sheetObjects[0], document.form, this.value)' onKeyup='enterCheck(this)'>
											<input name='svc_provider' ReadOnly class="input2" type="text" style="width:206;">
										</td>
									</tr>
                                </table>
							</td>
						</tr>
					</table>
					<table class="search_in" border="0">
						<tr class="h23">
							<td width="59">Number</td>
							<td width="324">
								<table border="0" style="height:15; width:94%; background-color: #E9E9E9;">
                                	<tr>
                                		<td width="110" class="sm">
                                			<input type="radio" name='no_tp' value='iv' class="trans" checked>Invoice
                                			<input type="radio" name='no_tp' value='csr' class="trans">CSR
                                		</td>
										<td>
											<input name="no_cd" type="text" onKeyup='enterCheck(this)' style="width:167;">
											<img class="cursor" img src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle" name='btns_no_cd'>
										</td>
									</tr>
                                </table>
							</td>
							<td width="151">Invoice Creation Office</td>
							<td class="sm" width="205">
								<input name="inv_cre_ofc" type="text" style="width:79;" value='<%=account.getOfc_cd()%>' onBlur='value_upper(this)' onKeyup='enterCheck(this)'>
								<img class="cursor" img src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle" name='btns_ofc_cd'>
								<input type="checkbox" name="chk_office" value="Y" class="trans" onClick="javascript:fun_chkOffice();">Incl. Sub OFC
							</td>
							<td width=160>Invoice Update User Name</td>
							<td align="right">
								<input name="ivc_upd_usr_id" type="text" style="width:79;" maxlength='100' onKeyup='enterCheck(this)'>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->
		<table class="height_10"><tr><td></td></tr></table>
	</div>

		<!-- TABLE '#D' : ( Gird BG Box ) (S) -->
		<table class="search" border="0">
			<tr>
				<td class="bg">
					<!-- : ( From Location ) (S) -->
					<table width="100%" id="mainTable">
                        <tr>
                        	<td>
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
					<!-- : ( From Location ) (E) -->

					<!-- : ( Grid ) (E) -->
					<!-- : ( Button_ Sub ) (S) -->
					<table width="100%" class="button">
				       	<tr>
				       		<td class="btn2_bg">
								<table border="0" cellpadding="0" cellspacing="0">
									<tr>
										<!-- Repeat Pattern -->
										<td>
											<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr>
													<td class="btn2_left"></td>
													<td class="btn2" id="btng_downexcel1" name="btng_downexcel1">Down In Excel(1)</td>
													<td class="btn2_right"></td>
												</tr>
											</table>
										</td>
										<td>
											<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr>
													<td class="btn2_left"></td>
													<td class="btn2" id="btng_downexcel2" name="btng_downexcel2">Down In Excel(2)</td>
													<td class="btn2_right"></td>
												</tr>
											</table>
										</td>
										<td>
											<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr>
													<td class="btn2_left"></td>
													<td class="btn2" id="btng_MasterInvoiceCreation" name="btng_MasterInvoiceCreation">Master Invoice Creation(Print)</td>
													<td class="btn2_right"></td>
												</tr>
											</table>
										</td>
										<td>
											<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr>
													<td class="btn2_left"></td>
													<td class="btn2" id="btng_detailinquiry" name="btng_detailinquiry">Detail Inquiry</td>
													<td class="btn2_right"></td>
												</tr>
											</table>
										</td>
										<td>
											<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr>
													<td class="btn2_left"></td>
													<td class="btn2" id="btng_holdsave" name="btng_holdsave">Hold Save</td>
													<td class="btn2_right"></td>
												</tr>
											</table>
										</td>
										<!-- Repeat Pattern -->
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<td class="btn2_bg">
								<table border="0" cellpadding="0" cellspacing="0">
									<tr>
										<!-- Repeat Pattern -->
										<td>
											<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					                            <tr>
					                            	<td class="btn2_left"></td>
						                            <td class="btn2" id="btng_saveupdusrid" name="btng_saveupdusrid">Save</td>
						                            <td class="btn2_right"></td>
					                           	</tr>
					                         </table>
					                    </td>
										<td>
											<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr>
													<td class="btn2_left"></td>
													<td class="btn2" id="btng_invoicedelete" name="btng_invoicedelete">Invoice Delete</td>
													<td class="btn2_right"></td>
												</tr>
											</table>
										</td>
										<td>
											<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr>
													<td class="btn2_left"></td>
													<td class="btn2" id="btng_invaudit" name="btng_invaudit">Invoice Audit</td>
													<td class="btn2_right"></td>
												</tr>
											</table>
										</td>
										<td>
											<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr>
													<td class="btn2_left"></td>
													<td class="btn2" id="btng_invconfirm" name="btng_invconfirm">Invoice Confirm</td>
													<td class="btn2_right"></td>
												</tr>
											</table>
										</td>
										<td>
											<table width="170" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr>
													<td class="btn2_left"></td>
													<td class="btn2" id="btng_invconfrimcancel" name="btng_invconfrimcancel">Invoice Confirm Cancel</td>
													<td class="btn2_right"></td>
												</tr>
											</table>
										</td>
										<!-- Repeat Pattern -->
									</tr>
								</table>
							</td>
						</tr>
					</table>
					<!-- : ( Button_ Sub ) (E) -->
				</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Grid BG Box ) (E) -->
	</tr>
</table>
<!-- Outer Table (E)-->

</form>
<form method="post" name="inv_form" action='ESD_TRS_0033.do' onSubmit="return false;">
<input	type="hidden" name="inv_no">
<input	type="hidden" name="inv_vndr_seq">
<input	type="hidden" name="mode">
<input	type="hidden" name="sysCommUiTitle" value="Audit &amp; Confirm">
<input	type="hidden" name="sysCommUiNavigation" value="Trans S/O > Invoice">
<input  type="hidden" name="if_sys_knd_cd_param">
<input type="hidden" name="pgmNo" value='ESD_TRS_0033'>
</form>

<form method="post" name="esd_030rd_form" action='ESD_TRS_0208.do' onSubmit="return false;">
<input	type="hidden" name="queryStr">
</form>
</body>
</html>
