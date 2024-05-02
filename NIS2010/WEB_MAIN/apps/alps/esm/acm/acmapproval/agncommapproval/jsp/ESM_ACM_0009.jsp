<%--
 - Copyright(c) 2012 CyberLogitec
 - @FileName : ESM_ACM_0009.js
 - @FileTitle : Agent Commission CSR Creation
 - Open Issues :
 - Change history :
 - @LastModifyDate : 2012.04.05
 - @LastModifier : 김영오
 - @LastVersion : 1.0
 - 2012.04.05 김영오 1.0 Creation
 - 2014.01.07 박다은 [CHM-201428365] CSR Creation 화면, VAT옆에 WHT Column 추가
 - 2015.01.05 김상현 1.6 [CHM-201433439] 파일 첨부 기능 개발 요청
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="com.hanjin.framework.component.util.JSPUtil" %>
<%@ page import="com.hanjin.framework.component.util.DateTime" %>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler" %>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse" %>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys" %>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount" %>
<%@ page import="com.hanjin.apps.alps.esm.acm.acmapproval.agncommapproval.event.EsmAcm0009Event" %>
<%@ page import="org.apache.log4j.Logger" %>
<%
  EsmAcm0009Event event = null;        //PDTO(Data Transfer Object including Parameters)
  Exception serverException = null;    //서버에서 발생한 에러
  String strErrMsg = "";               //에러메세지
  int rowCount = 0;                    //DB ResultSet 리스트의 건수

  String successFlag = "";
  String codeList  = "";
  String pageRows  = "100";

  String strUsr_id = "";
  String strUsr_nm = "";
  String strOfc_cd = "";
  String vendor = "";
  String aproStep = "";
  String inv_sub_sys_cd = "";
  Logger log = Logger.getLogger("com.hanjin.apps.ACMApproval.AGNCommApproval");

  try {
    SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    strUsr_id = account.getUsr_id();
    strUsr_nm = account.getUsr_nm();
    strOfc_cd = account.getOfc_cd();
    event = (EsmAcm0009Event)request.getAttribute("Event");
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
<title>Agent Commission CSR Creation</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="rpt/script/rdviewer50.js"></script>
<script language="javascript">
  // 공통코드 combo string 추출
<%=JSPUtil.getIBCodeCombo("ofcChr", "", "CD03015", 0, "")%>
<%=JSPUtil.getIBCodeCombo("effDiv", "", "CD03014", 0, "")%>
<%=JSPUtil.getIBCodeCombo("xchRtDivLvl", "", "CD03020", 0, "")%>
RdReport = "apps/alps/esm/agt/common/jsp/ESM_AGT_RDReport.jsp";
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
<!-- 개발자 작업 -->

<input name="ofc_cd" type="hidden" value="<%=strOfc_cd%>"><!-- 로그인 한 사용자의 ofc_cd -->
<input name="aud_no" type="hidden">
<input name="aud_nos" type="hidden"><%//aud_nos에는 체크박스에서 선택한 aud_no들로 csr_usd_amt 를 계산하고 GW&ALPS결재여부결정  %>
<input name="csr_no" type="hidden">
<input name="vvd_cd" type="hidden"><!-- Multi VVD -->
<input name="bl_no" type="hidden" ><!-- Multi B/L No -->
<input type="hidden" name="h_csr_no"> <!-- grid에서 선택된 csrNo -->
<input type="hidden" name="aproSeqKey" value="<%=com.hanjin.bizcommon.approval.util.ApprovalUtil.getApprovalRoute1(strOfc_cd, inv_sub_sys_cd) %>">
<input type="hidden" name="appro_yn">

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
                  <div id="divCsrBtn" style="display:none">
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_csr_create">CSR Create</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                  </div>
                  <div id="divApproBtn" style="display:inline">
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_approval_request">Approval Request</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                  </div>
                </td>
                <td>
                  <div id="divAuditRejectBtn" style="display:inline">
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_audit_reject">Audit Reject</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                  </div>
                </td>
                <td>
                  <div id="divCSRPrintBtn" style="display:none">
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_print">CSR Print</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                  </div>
                </td>
                <td>
                  <div id="divAGMTFilesBtn" style="display:none">
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_agmt_files">AGMT Files</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                  </div>
                </td>
                <!-- td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_clearALL">Clear</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td-->                
              </tr>
            </table>
          </td>
        </tr>
      </table>
      <!-- Button (E) -->

      <!-- biz page (S) -->
      <!-- 조회조건 상단 영역 -->
      <table class="search">
        <tr>
          <td class="bg" valign="top">
            <!-- biz_1 (S) -->
            <table width="100%" border="0" cellpadding="0" cellspacing="0">
              <tr>

                <td align="left" valign="top">
                  <table align="left" border="0" cellpadding="0" cellspacing="0">
                    <tr class="h23">
                      <td>Office&nbsp;
                        <select name="ar_ofc_cd" required caption="Office" class="input1" style="width:70px;" tabindex="1"></select>
                        &nbsp;
                        Sub Office&nbsp;
                        <select name="agn_cd" required caption="Sub Office" class="input1" style="width:70px;" tabindex="2"></select>
                      </td>
                    </tr>
                    <tr>
                      <td>
                        <table border="0" cellpadding="0" cellspacing="0">
                          <tr class="h23">
                          <td>Invoice Date&nbsp;
                            <input type="text" class="input1"style="width:85" maxlength="10"  dataformat="ymd" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)" name="inv_dt">
                            <img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_inv_dt">
                          </td>
                      </tr>
                        </table>
                      </td>
                    </tr>

                    <tr>
                      <td>
                        <table border="0" cellpadding="0" cellspacing="0">
                          <tr class="h23">
                            <td>VAT(%)&nbsp;
                              <input type="text" style="width:70;text-align:right" maxlength = "8" name="inv_tax_rt"  value="0.00" onfocus="invTaxRt_onfocus(this)" onblur="invTaxRt_validate(this)">
                            </td>
                            <td>&nbsp;&nbsp;&nbsp;WHT(%)&nbsp;
                              <input type="text" style="width:70;text-align:right" maxlength = "8" name="whld_tax_rt" value="0.00" >
                            </td>
                          </tr>
                        </table>
                      </td>

                    </tr>
                  </table>
                </td>

                <td align="center" valign="top">
                  <table align="center" border="0" cellpadding="0" cellspacing="0">
                    <tr class="h23">
                      <td>Commission Status&nbsp;
                        <%=JSPUtil.getCodeCombo("ac_sts_cd", "", "tabindex='3' style='width:125px;'", "CD03088", 0, "")%>
                      </td>
                    </tr>
                    <tr>
                      <td>
                        <table border="0" cellpadding="0" cellspacing="0">
                          <tr class="h23">
                            <td>ASA No&nbsp;<select name="asa_no" style="width:302px;" tabindex="2"></select>&nbsp;</td>
                          </tr>
                        </table>
                      </td>
                    </tr>

                    <tr>
                      <td>
                        <table border="0" cellpadding="0" cellspacing="0">
                          <tr class="h23">
                            <td>Vendor&nbsp;&nbsp;<input type="text" class="input2" style="width:300;" name="vendor_name" disabled>&nbsp;</td>
                          </tr>
                        </table>
                      </td>
                    </tr>

                  </table>
                </td>

                <td align="right" valign="top">
                  <table align="right" border="0" cellpadding="0" cellspacing="0">
                    <tr class="h23">
                      <td>Date&nbsp;&nbsp;&nbsp;
                        <input name="date_div_disp" type="text" class="input2" style="width:100px;" readOnly>&nbsp;
                        <input name="date_fm" type="text" dataformat="ymd" maxlength="8" required caption="From Date" cofield="date_to" class="input1" style="width:70px;" tabindex="5">&nbsp;~
                        <input name="date_to" type="text" dataformat="ymd" maxlength="8" required caption="To Date" cofield="date_fm" class="input1" style="width:70px;" tabindex="6">
                        <img name="btn_calendar" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" style="cursor:hand;">
                      </td>
                    </tr>
					<tr class="h23">
						<td width="">&nbsp;</td>
					</tr>
					<tr class="h23">
						<td width="">
							<div id="srLayer" style="display:inline">
								<!-- <table class="search" border="0">
									<tr class="h23">
										<td width="120">Approval System</td>
										<td>&nbsp;<select style="width:180;" name="appro_gb" id="appro_gb" onChange="approSrch()">
											<option value="1">ALL</option>
											<option value="2">ALPS Approval System</option>
											<option value="3">GW Approval System</option>
											</select></td>
									</tr>
								</table> -->
							</div>
						</td>
						<td width="">&nbsp;</td>
					</tr>
                  </table>
                </td>

              </tr>
            </table>
            <!-- biz_1 (E) -->
          </td>
        </tr>
      </table>

      <!-- 조회조건 하단 영역 -->
    <table class="line_bluedot"><tr><td></td></tr></table>

	<%//GW결재 %>
	<div id="divStepNo" style="display:none">
    <table class="search">
        <tr>
          <td class="bg" valign="top">
            <!-- biz_1 (S) -->
            <table width="100%" border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td align="left" valign="top">
                  <table align="left" border="0" cellpadding="0" cellspacing="0">
                  <%--
                    <tr>
                      <td>
                        <table border="0" cellpadding="0" cellspacing="0">
                          <tr class="h23">
                            <td>Approval Step&nbsp;
                              <input name="apro_step" type="text" class="input1" size="65" style="width:440px;" value="<%//= aproStep%>" disabled>
                              &nbsp;
                            </td>
                            <td>
                              <table  border="0" cellpadding="0" cellspacing="0">
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
                      </td>
                    </tr>
					--%>
                    <tr>
                      <td>
                        <table border="0" cellpadding="0" cellspacing="0">
                          <tr class="h23">
                            <td>Check&nbsp;
                              <input name="slct_start" type="text" dataformat="int" maxlength="5" style="width:41px;" tabindex="9">&nbsp;~
                              <input name="slct_end" type="text" dataformat="int" maxlength="5" style="width:41px;" tabindex="10">&nbsp;&nbsp;
                            </td>
                            <td>
                              <table  border="0" cellpadding="0" cellspacing="0">
                                <tr>
                                  <td>
                                    <table border="0" cellpadding="0" cellspacing="0" class="button">
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
                          </tr>
                        </table>
                      </td>
                    </tr>

                  </table>
                </td>
              </tr>
            </table>
            <!-- biz_1 (E) -->
          </td>
        </tr>
      </table>
	</div>
	<%//ALPS결재 %>
	<div id="divStepYes" style="display:inline">
    <table class="search">
        <tr>
          <td class="bg" valign="top">
            <!-- biz_1 (S) -->
            <table width="100%" border="0" cellpadding="0" cellspacing="0">
              <tr>

                <td align="left" valign="top">
                  <table align="left" border="0" cellpadding="0" cellspacing="0">
                    <tr>
                      <td>
                        <table border="0" cellpadding="0" cellspacing="0">
                          <tr class="h23">
                            <td>Approval Step&nbsp;
                              <input name="apro_step" type="text" class="input1" size="65" style="width:440px;" value="<%= aproStep %>" disabled>
                              &nbsp;
                            </td>
                            <td>
                              <table  border="0" cellpadding="0" cellspacing="0">
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
                      </td>
                    </tr>

                    <tr>
                      <td>
                        <table border="0" cellpadding="0" cellspacing="0">
                          <tr class="h23">
                            <td>Check&nbsp;
                              <input name="slct_start" type="text" dataformat="int" maxlength="5" style="width:41px;" tabindex="9">&nbsp;~
                              <input name="slct_end" type="text" dataformat="int" maxlength="5" style="width:41px;" tabindex="10">&nbsp;&nbsp;
                            </td>
                            <td>
                              <table  border="0" cellpadding="0" cellspacing="0">
                                <tr>
                                  <td>
                                    <table border="0" cellpadding="0" cellspacing="0" class="button">
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
                          </tr>
                        </table>
                      </td>
                    </tr>

                  </table>
                </td>
              </tr>
            </table>
            <!-- biz_1 (E) -->
          </td>
        </tr>
      </table>
	</div>

      <table class="line_bluedot"><tr><td></td></tr></table>
    <table class="search" border="0">
        <tr>
      <td class="title_h"></td>
      <td class="title_s">Master</td>
      <td class="btn2_bg" align="right" style="padding-bottom:3;">
      <!-- : ( Button : Sub ) (S) -->
      <table border="0" cellpadding="0" cellspacing="0">
        <tr>
            <!-- Repeat Pattern -->
          <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
          <tr><td class="btn2_left"></td><td class="btn2" name="btng_downexcel1">Down Excel</td><td class="btn2_right"></td></tr></table></td>
          <!-- Repeat Pattern -->
        </tr>
      </table>
      <!-- : ( Button : Sub ) (S) -->
      </td>
        </tr>
      </table>
      <table class="search">
        <tr>
          <td class="bg" valign="top">
            <!-- biz_2 (S) -->
            <!-- Grid (S) -->
            <table width="100%" id="mainTable">
              <tr>
                <td width="100%"><script language="javascript">ComSheetObject("sheet1");</script></td>
              </tr>
            </table>
            <!-- Grid (E) -->
            <!-- biz_2 (E) -->
          </td>
        </tr>
      </table>

    <table class="search" border="0">
        <tr>
          <td class="title_h"></td>
          <td class="title_s">Detail</td>
      <td class="btn2_bg" align="right" style="padding-bottom:3;">
      <!-- : ( Button : Sub ) (S) -->
      <table border="0" cellpadding="0" cellspacing="0">
        <tr>
            <!-- Repeat Pattern -->
          <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
          <tr><td class="btn2_left"></td><td class="btn2" name="btng_downexcel2">Down Excel</td><td class="btn2_right"></td></tr></table></td>
          <!-- Repeat Pattern -->
        </tr>
      </table>
      <!-- : ( Button : Sub ) (S) -->
      </td>
        </tr>
      </table>
      <table class="search">
        <tr>
          <td class="bg" valign="top">
            <!-- biz_2 (S) -->
            <!-- Grid (S) -->
            <table width="100%" id="mainTable">
              <tr>
                <td width="100%"><script language="javascript">ComSheetObject("sheet2");</script></td>
              </tr>
            </table>
            <!-- Grid (E) -->
            <!-- biz_2 (E) -->
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
<!-- PRINT (S)tart -->
<DIV style="display:none">
<!-- : ( Grid : AP_INV_HDR ) (S) -->
<table width="100%" id="mainTable">
  <tr>
    <td><script language="javascript">ComSheetObject('sheet3');</script></td>
  </tr>
</table>
<!-- : ( Grid : AP_INV_HDR ) (E) -->

<!-- : ( Grid : AP_INV_DTRB ) (S) -->
<table width="100%" id="mainTable">
  <tr>
    <td><script language="javascript">ComSheetObject('sheet4');</script></td>
  </tr>
</table>
<!-- : ( Grid : AP_INV_DTRB ) (E) -->
</DIV>
<!-- PRINT (E)nd -->
</html>