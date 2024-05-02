<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec 
*@FileName : FNS_JOO_0056.jsp
*@FileTitle : RDR Download by Lane
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.17
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.09.17 장강철
* 1.0 Creation
* --------------------------------------------------------
* History
* 2011.01.11 김상수 [CHM-201007350-01] JOO - RDR Inquiry by Lane 기능 보완 요청
*                   1. 보완 대상
*                      가. 조회  Option
*                         - Region Multi 선택
*                         - Carrier 추가 - Multi 선택
*                      나. Remark Pop up 추가 - 일부 Data 저장 및 해당 컬럼에 반영 (계산 Logic 포함)
*                      다. Asjusted Allocation 컬럼 추가 (계산Logic 포함)
*                      라. Over Used 계산 Logic( Allocation 참조 컬럼을  Adjusted Allocation으로 변경
*                      마. 기타 : 컬럼별 계산 Logic 수정
* 2012.05.11 김창헌 [CHM-201217413-01]
*                  [ALPS JOO] TDR Inquiry by VVD 및 RDR Inquiry by Lane
*                   - Sum 기능 추가, 정렬순서 및 표시형식 변경
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.event.FnsJoo0056Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    FnsJoo0056Event  event = null;                    //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;            //서버에서 발생한 에러
    String strErrMsg = "";                        //에러메세지
    int rowCount     = 0;                        //DB ResultSet 리스트의 건수

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    Logger log = Logger.getLogger("com.hanjin.apps.JointOperationAgreementSettlement.CarrierSettlementProcess");
    String strFromyyyyMMdd = "";
    String strToyyyyMMdd = "";
    try {
           SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id =    account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        strFromyyyyMMdd = DateTime.getFormatDate( DateTime.addMonths( JSPUtil.getKST("yyyyMMdd"), -1 ), "yyyyMMdd", "yyyy-MM-dd" )    ;
        strToyyyyMMdd   = DateTime.getFormatDate( JSPUtil.getKST("yyyyMMdd"), "yyyyMMdd", "yyyy-MM-dd");

        event = (FnsJoo0056Event)request.getAttribute("Event");
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
<title>RDR Download by Lane</title>
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
<!-- 개발자 작업    -->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
    <tr><td valign="top">
<!--Page Title, Historical (S)-->
    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
        <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
    </table>
<!--Page Title, Historical (E)-->
    <!--biz page (S)-->
        <table class="search">
           <tr><td class="bg">
                <!--  biz_1  (S) -->
                <table class="search" border="0" style="width:979;">
                <tr class="h23">
                    <td width="45">Period&nbsp;</td>
                    <td><input type="text" style="width:80;text-align:center" class="input1" required dataformat="ymd" maxlength="8" caption="Period From" name="pre_fr" value="<%=strFromyyyyMMdd%>" cofield="pre_to">&nbsp;<img src="img/btns_calendar.gif" align="absmiddle" name="btns_calendar_from" style="cursor:hand">&nbsp;~
                        <input type="text" style="width:80;text-align:center" class="input1" required dataformat="ymd" maxlength="8" caption="Period To" name="pre_to" value="<%=strToyyyyMMdd%>" cofield="pre_fr">&nbsp;<img src="img/btns_calendar.gif" align="absmiddle" name="btns_calendar_to" style="cursor:hand"></td>
                    <td align="right">Lane&nbsp;</td>
                    <td><input type="text" style="width:50;ime-mode:disabled" class="input1" required dataformat="uppernum"  maxlength="3" fullfill caption="Lane" name="rlane_cd" value="">&nbsp;<img class="cursor" src="img/btns_search.gif" name="srch_rlane_cd" width="19" height="20" border="0" align="absmiddle"></td>
                    <td align="right">Dir.&nbsp;</td>
                    <td><script language="javascript">ComComboObject("skd_dir_cd", 1, 60, 1, 0, 0);</script></td>
                    <td align="right">Region&nbsp;</td>
                    <td><script language="javascript">ComComboObject("joRgnCdCombo", 1, 130, 1, 0, 0);</script><input type="hidden" name="region"></td>
                    <td align="right">VVD&nbsp;</td>
                    <td><input type="text" style="width:80" class="input" name="vvd" dataformat="uppernum" caption="VVD" maxlength="9" minlength="4" fullfill style="ime-mode:disabled"></td>
                    <td align="right">Carrier&nbsp;</td>
                    <td><script language="javascript">ComComboObject("oprCdCombo", 1, 70, 1, 0, 0);</script><input type="hidden" name="opr_cd"></td>
                    <td align="right">Sum&nbsp;</td>
                    <td><input type="checkbox" value="N" name="sum_flg" id="sum_flg" class="trans"></td>
                </tr>
                </table>
                <!--  biz_1   (E) -->

                </td></tr>
            </table>
            <table class="height_10"><tr><td colspan="8"></td></tr></table>

        <!-- Tab BG Box  (S) -->
         <table class="search">
           <tr><td class="bg">
             <!-- Grid  (S) -->
                <table width="100%" id="mainTable">
                    <tr>
                        <td width="100%">
                            <script language="javascript">ComSheetObject("sheet1");</script>
                        </td>
                    </tr>
                </table>
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table>
            <!-- Grid (E) -->
            <!--  biz_1  (S) -->
                <!--  biz_1   (E) -->
            </td></tr>
        </table>
    <!-- Tab BG Box  (S) -->
    <!--biz page (E)-->


    <!--Button (S) -->
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
           <tr><td class="btn1_bg">
            <table border="0" cellpadding="0" cellspacing="0">
            <tr>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>

                <td class="btn1_line"></td>

                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_save" id="btn_save">Save</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>

                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_downexcel" id="btn_downexcel">Down Excel</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>


        </td></tr>
        </table>
    <!--Button (E) -->
    </td></tr>
</table>
</td></tr>
</table>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>