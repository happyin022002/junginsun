<%
/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : ESM_SQM_0045.jsp
*@FileTitle      : QTA Edit_Office Add
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.12.10
*@LastModifier   :
*@LastVersion    : 1.0
* 2013.12.10 SQM USER
* 1.0 Creation
* 2013.12.10 PEJ [CHM-201328059] QTA Edit_Office Add 팝업 추가
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.event.EsmSqm0045Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmSqm0045Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //서버에서 발생한 에러
    String strErrMsg = "";                      //에러메세지
    int rowCount     = 0;//DB ResultSet 리스트의 건수

    String successFlag = "";
    String codeList    = "";
    String pageRows    = "100";
    String bseYr       = "";
    String bseQtrCd    = "";
    String ofcVwCd     = "";
    String ofcVwNm     = "";
    String divPeriod   = "";

    String strUsr_id   = "";
    String strUsr_nm   = "";
    Logger log = Logger.getLogger("com.hanjin.apps.alps.esm.sqm.adjustment");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();

        event = (EsmSqm0045Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        bseYr     = JSPUtil.getNull(request.getParameter("f_bse_yr"));
        bseQtrCd  = JSPUtil.getNull(request.getParameter("f_bse_qtr_cd"));
        divPeriod = JSPUtil.getNull(request.getParameter("div_period"));
        ofcVwCd   = JSPUtil.getNull(request.getParameter("f_ofc_vw_cd"));

        if (ofcVwCd.equals("L")) {
            ofcVwNm = "Loading";
        } else if (ofcVwCd.equals("C")) {
            ofcVwNm = "Contract";
        }

    }catch(Exception e) {
        out.println(e.toString());
    }
%>
<html>
<head>
<title>IAS Office Add Creation</title>
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

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="f_bse_tp_cd" value="Q">
<input type="hidden" name="f_ofc_vw_cd" value="<%=ofcVwCd%>">


<!-- 개발자 작업 -->

<!-- Outer Table (S)-->
<table width="100%" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
    <tr>
        <td valign="top">
            <!-- : ( Title ) (S) -->
            <table width="100%" border="0">
                <tr>
                    <td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;IAS Office Add Creation</td>
                </tr>
            </table>
            <!-- : ( Title ) (E) -->
            
			<!--Button_L (S) -->
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
				<tr>
					<td class="btn1_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<!-- Repeat Pattern -->
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" id="btn_Retrieve" name="btn_Retrieve">Retrieve</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>

								<!-- Repeat Pattern -->
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<!--Button_L (E) -->
			
           <!-- TABLE '#D' : ( Search Options ) (S) -->
            <table class="search" >
                <tr>
                    <td class="bg">
                        <table class="search">
                            <tr>
                                <td>
                                    <table class="search" border="0">
                                        <tr class="h23">
                                            <td width="50">Year</td>
                                            <td width="75"><input type="text" style="width:50; ime-mode:disabled" name="f_bse_yr" class="input2" maxlength="20" readOnly value="<%=bseYr%>"></td>
                                            <td width="80">Quarter</td>
                                            <td width="95"><input type="text" style="width:50; ime-mode:disabled" name="f_bse_qtr_cd" class="input2" maxlength="20" readOnly value="<%=bseQtrCd%>"></td>
                                            <td width="140" class='sm' colspan="2"><div id="div_period"><%=divPeriod%></div></td>
                                            <td width="70">Office View</td>
                                            <td width="95"><input type="text" style="width:90; ime-mode:disabled" name="f_ofc_vw_nm" class="input2" maxlength="20" readOnly value="<%=ofcVwNm%>"></td>
                                            <td colspan="3">&nbsp;</td>
                                        </tr>
                                        <tr class="h23">
                                            <td width="50">Sub Trade</td>
                                            <td width="75"><script language="javascript">ComComboObject('f_sub_trd_cd', 1, 60, 0, 1)</script></td>
                                            <td width="80">IAS Region</td>
                                            <td width="95"><script language="javascript">ComComboObject('f_ias_rgn_cd', 1, 90, 0, 0)</script></td>
                                            <td width="80">Lane Bound</td>
                                            <td width="70"><script language="javascript">ComComboObject('f_dir_cd', 1, 60, 0, 1)</script></div>
                                            <td width="70">R/Lane</td>
                                            <td width="70"><script language="javascript">ComComboObject('f_rlane_cd', 1, 65, 0, 1)</script></td>
                                            <td width="50">RHQ</td>
                                            <td width="75"><script language="javascript">ComComboObject('f_rhq_cd', 1, 70, 0, 1)</script></td>
                                            <td >&nbsp;</td>
                                        </tr>
                                    </table>
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>
            </table>
            <!-- TABLE '#D' : ( Search Options ) (E) -->
            <table class="height_10"><tr><td></td></tr></table>

            <!-- TABLE '#D' : ( Search Options ) (S) -->
            <table class="search" border="0">
                <tr>
                    <td class="bg_b1">
                        <table class="height_10"><tr><td></td></tr></table>
                        <table width="100%" class="search">
                        <tr><td class="gray" height="19" id="sheet_unit">[Unit: TEU, $]</td></tr>
                        </table>
                        <!-- : ( POR ) (S) -->
                        <table width="100%" id="mainTable">
                            <tr>
                                <td><script language="javascript">ComSheetObject('sheet1');</script></td>
                            </tr>
                        </table>
                        <!-- : ( POR ) (E) -->
                    </td>
                </tr>
            </table>
            <!-- TABLE '#D' : ( Search Options ) (E) -->
            <table class="height_5"><tr><td></td></tr></table>

            <!-- TABLE '#D' : ( Button : pop ) (S) -->
            <table width="100%" class="sbutton">
                <tr>
                    <td height="71" class="popup">
                        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
                            <tr>
                                <td class="btn3_bg">
                                    <table border="0" cellpadding="0" cellspacing="0">
                                        <tr>
                                            <td>
                                                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                    <tr>
                                                        <td class="btn1_left"></td>
                                                        <td class="btn1" id="btn_DownExcel" name="btn_Creation">Creation</td>
                                                        <td class="btn1_right"></td>
                                                    </tr>
                                                </table>
                                            </td>
                                            <td>
                                                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                                    <tr>
                                                        <td class="btn1_left"></td>
                                                        <td class="btn1" id="btn_close" name="btn_Close">Close</td>
                                                        <td class="btn1_right"></td>
                                                    </tr>
                                                </table>
                                            </td>
                                            <!-- Repeat Pattern -->
                                        </tr>
                                    </table>
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>
            </table>
            <!-- TABLE '#D' : ( Button : pop ) (E) -->
        </td>
    </tr>
</table>
<!-- Outer Table (E)-->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>