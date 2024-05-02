<%
/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESM_ACM_0031.jsp
*@FileTitle : Special Compensation CSR Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.15
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.05.04 김영오
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
<%@ page import="com.hanjin.apps.alps.esm.acm.acmapproval.spclcmpnapproval.event.EsmAcm0031Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
  EsmAcm0031Event event = null;        //PDTO(Data Transfer Object including Parameters)
  Exception serverException = null;    //서버에서 발생한 에러
  String strErrMsg = "";               //에러메세지
  int rowCount = 0;                    //DB ResultSet 리스트의 건수

  String successFlag = "";
  String codeList  = "";
  String pageRows  = "100";

  String strUsr_id = "";
  String strUsr_nm = "";
  String strOfc_cd = "";
  String aproStep = "";
  String inv_sub_sys_cd = "";
  Logger log = Logger.getLogger("com.hanjin.apps.ACMRequest.AGNCommRequest");

  try {
    SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    strUsr_id = account.getUsr_id();
    strUsr_nm = account.getUsr_nm();
    strOfc_cd = account.getOfc_cd();
    event = (EsmAcm0031Event)request.getAttribute("Event");
    serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

    if (serverException != null) {
      strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
    }

    // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
    GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	aproStep =  com.hanjin.bizcommon.approval.util.ApprovalUtil.getApprovalRoute(strOfc_cd,"AGT");
	inv_sub_sys_cd		= JSPUtil.getParameter(request, "inv_sub_sys_cd			".trim(), "");

  } catch(Exception e) {
    out.println(e.toString());
  }
%>
<html>
<head>
<title>Agent Commission Request</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="rpt/script/rdviewer50.js"></script>

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

<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="hid_ff_cnt_seq">
<input type="hidden" name="vndr_seq">
<input type="hidden" name="csr_no">
<input type="hidden" name="ap_ofc_cd">
<input type="hidden" name="cust_cnt_seq">

<!-- 개발자 작업 -->


<input type="hidden" name="ofc_cd" value="<%=strOfc_cd%>"><!-- 로그인 한 사용자의 ofc_cd -->
<input type="hidden" name="bl_no"><!-- Multi B/L No -->
<input type="hidden" name="aproSeqKey" value="<%=com.hanjin.bizcommon.approval.util.ApprovalUtil.getApprovalRoute1(strOfc_cd, inv_sub_sys_cd) %>">


<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding:2px 0px 0px 5px; border:0px #ff0000 solid; width:1002px">
  <tr>
    <td valign="top">


      <!-- Page Title, Historical (S) -->
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
        <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
      </table>
      <!-- Page Title, Historical (E) -->


      <!-- Button (S) -->
      <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding:5px 0px 10px 0px;">
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
                <td class="btn1_line"></td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_approval_request">Approval Request</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_downexcel">Down Excel</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_csr_print">CSR Print</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
              </tr>
            </table>
          </td>
        </tr>
      </table>
      <!-- Button (E) -->


      <!-- biz page (S) -->
	<table class="search">
		<tr>
			<td class="bg" valign="top"><!-- biz_1 (S) -->
			<table width="100%" border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td align="left" valign="top">
					<table border="0" cellpadding="0" cellspacing="0">
						<tr class="h23">
							<td>Office&nbsp;
								&nbsp;<select name="ar_ofc_cd" required caption="Office" class="input1" style="width:70px;" tabindex="1"></select>
							</td>
						</tr>
					</table>
					</td>
					<td align="center" valign="top">
					<table border="0" cellpadding="0" cellspacing="0">
						<tr class="h23">
							<td>&nbsp;Date&nbsp;
								<%=JSPUtil.getCodeCombo("date_div", "", "tabindex='4' style='width:80px;'", "CD03053", 0, "")%>&nbsp;
							<input name="date_fm" type="text" dataformat="ymd" maxlength="8" required caption="From Date" cofield="date_to" class="input1" style="width: 70px;" tabindex="5">&nbsp;~ <input name="date_to" type="text" dataformat="ymd" maxlength="8" required caption="To Date" cofield="date_fm" class="input1" style="width: 70px;" tabindex="6">
								<img name="btn_calendar" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" style="cursor: hand;">
							</td>
						</tr>
					</table>
					</td>
					<td align="right" valign="top">
					<table border="0" cellpadding="0" cellspacing="0">
						<tr class="h23">
							<td>Interface Option&nbsp;<%=JSPUtil.getCodeCombo("if_opt", "", "tabindex='4' style='width:90px;'", "CD03071", 0, "")%>
							</td>
							<td>&nbsp;&nbsp;Eff Date&nbsp;<input type="text" class="input1" style="width: 85" maxlength="8" dataformat="ymd" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)" name="inv_dt">
							<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_inv_dt">
							</td>
						</tr>
					</table>
					</td>
				</tr>
			</table>

			<table border="0" cellpadding="0" cellspacing="0">
				<tr class="h23">
					<td>AGMT Customer&nbsp;
					<input type="text" name="ff_cnt_seq" dataformat="engup" style="width: 79; ime-mode: disabled;" maxlength="8">
						<img name="btn_forwarder" class="cursor" src="img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle">
					</td>

					<td>
					<table border="0" cellpadding="0" cellspacing="0">
						<tr class="h23">
							<td>&nbsp;&nbsp;&nbsp;B/L&nbsp;</td>
							<!----------------------------------------------------------------->
							<!-- Memo Sheet (S) -->
							<td width="104" height="25" id="memo_sheet1_td">
							<div id="memo_sheet1_div">
							<table width="104">
								<tr>
									<td><script language="javascript">ComSheetObject("memo_sheet1");</script></td>
								</tr>
							</table>
							</div>
							</td>
							<td>&nbsp;&nbsp;</td>
							<!-- Memo Sheet (E) -->
							<!----------------------------------------------------------------->
							<td>
							<table border="0" cellpadding="0" cellspacing="0"
								class="button">
								<tr>
									<td class="btn2_left"></td>
									<td class="btn2" name="btn2_bl_no">Multi B/L No</td>
									<td class="btn2_right"></td>
								</tr>
							</table>
							</td>


							<td>
							<table border="0" cellpadding="0" cellspacing="0">
								<tr class="h23">
									<td>&nbsp;&nbsp;Select&nbsp; <input name="slct_start" type="text" dataformat="int" maxlength="5" style="width: 41px;" tabindex="9">&nbsp;~ <input name="slct_end" type="text" dataformat="int" maxlength="5" style="width: 41px;" tabindex="10">&nbsp;&nbsp;</td>
									<td>
									<table border="0" cellpadding="0" cellspacing="0">
										<tr>
											<td>
											<table border="0" cellpadding="0" cellspacing="0"
												class="button">
												<tr>
													<td class="btn2_left"></td>
													<td class="btn2" name="btn2_check">Check</td>
													<td class="btn2_right"></td>
												</tr>
											</table>
											</td>
											<td>
											<table border="0" cellpadding="0" cellspacing="0" class="button">
												<tr>
													<td class="btn2_left"></td>
													<td class="btn2" name="btn2_uncheck">Uncheck</td>
													<td class="btn2_right"></td>
												</tr>
											</table>
											</td>
										</tr>
									</table>
									</td>
									<td>&nbsp;&nbsp;VAT(%)&nbsp;
			                          <input type="text" style="width:80;text-align:right" maxlength = "8" name="inv_tax_rt" value="0.00" onfocus="invTaxRt_onfocus(this)" onblur="invTaxRt_validate(this)">
			                        </td>
								</tr>
							</table>
							</td>
						</tr>
					</table>
					</td>

				</tr>
			</table>

			<table class="line_bluedot"><tr><td></td></tr></table>

			<table border="0" cellpadding="0" cellspacing="0">
				<tr class="h23">
					<td>Approval Step
						<input name="apro_step" type="text" class="input1" size="65" style="width: 440px;" value="<%= aproStep %>" disabled>&nbsp;
					</td>
					<td>
					<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td>
							<table border="0" cellpadding="0" cellspacing="0" class="button">
								<tr>
									<td class="btn2_left"></td>
									<td class="btn2" name="btn_clear">Clear</td>
									<td class="btn2_right"></td>
								</tr>
							</table>
							</td>
							<td>
							<table border="0" cellpadding="0" cellspacing="0" class="button">
								<tr>
									<td class="btn2_left"></td>
									<td class="btn2" name="btn_popup">Edit Approval Staff</td>
									<td class="btn2_right"></td>
								</tr>
							</table>
							</td>
						</tr>
					</table>
					</td>
				</tr>
			</table>
			<!-- biz_1 (E) --></td>
		</tr>
	</table>

	<table class="line_bluedot"><tr><td></td></tr></table>

    <table class="search">
      <tr>
        <td class="bg" valign="top">
        <img src="img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">Master
          <!-- biz_2 (S) -->
          <!-- Grid (S) -->
          <table width="100%" id="mainTable">
            <tr>
              <td width="100%"><script language="javascript">ComSheetObject("sheet1");</script></td>
            </tr>
          </table>
          <!-- Grid (E) -->
          <!-- biz_2 (E) -->

		<table width="100%" class="search">
			<tr>
				<td class="gray_tit"><img src="img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">Detail</td>
			</tr>
		</table>
		<table width="100%" id="mainTable">
			<tr>
				<td><script language="javascript">ComSheetObject('sheet2');</script></td>
			</tr>
		</table>

        </td>
      </tr>
    </table>
      <!-- biz page (E) -->

    </td>
  </tr>
</table>


<!-- 개발자 작업 끝 -->
</form>
</body>
</html>


<!-- PRINT (S)tart -->
<DIV style="display: none">
<!-- : ( Grid : DownExcel ) (S) -->
<table width="100%" id="mainTable">
	<tr>
		<td><script language="javascript">ComSheetObject('sheet3');</script></td>
	</tr>
</table>
<!-- : ( Grid : DownExcel ) (E) -->

<!-- : ( Grid : Print ) (S) -->
<table width="100%" id="mainTable">
	<tr>
		<td><script language="javascript">ComSheetObject('sheet4');</script></td>
	</tr>
</table>
<table width="100%" id="mainTable">
	<tr>
		<td><script language="javascript">ComSheetObject('sheet5');</script></td>
	</tr>
</table>
<!-- : ( Grid : Print ) (E) -->
</DIV>
<!-- PRINT (E)nd -->