<%--
/* =========================================================
 ' 주  시 스 템 : ENIS
 ' 서브  시스템 : Inquiry by BKG (ABC/STP)
 ' 프로그램 ID  : apps/enis/esm/coa/multidimensionrpt/sales/jsp/ESM_COA_0156.jsp
 ' 프로그램 명  : Inquiry by BKG (ABC/STP)
 ' 프로그램개요 : Inquiry by BKG (ABC/STP)
 ' 작   성   자 : Park Eun Ju
 ' 작   성   일 : 2008.06.16
============================================================
 '  History : N200805307021
 ' 2008.08.29 박상희 N200807298360 Expense Detail로 테이블 변경하면서 화면단 모두 변경[156]
 ' 2008.09.22 박상희 N200808278919 메뉴명과 윈도우 타이틀명 일치.버튼 이미지 교체
 ' 2009.09.26 전윤주 N200808260005 년/월 항목추가, ABC/STP 상세 항목 링크 버튼 추가
 ' 2009.03.12 박상희 N200903040144 ABC/STP 단가 팝업창 윈도우 크기 변경
 ' 2009.10.21 김기식 Alps전환작업
 ' 2010.12.01 김기종 Ticket ID:CHM-201006305-01 COA Architecture 위배사항 수정
 ' 2011.05.09 최윤성 [CHM-201110694-01] COA Report 화면 combo box validation 추가 
=========================================================*/

--%>


<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%
    Exception serverException   = null;
    String strErrMsg = "";
    String userId   = "";
    String ofc_cd   = "";
    String ofc_lvl  = "";

    try {
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }else{
        	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        	userId = account.getUsr_id();
        	ofc_cd = account.getOfc_cd();  //.getUserOffice2();
        	ofc_lvl = account.getUsr_auth_tp_cd();  //.getUserLevel();

        } // end else
        	
//		N200903120100 처리를 위해 ofc_cd, ofc_lvl을 무조껀 SELHO.  1로 바꿔준다
		ofc_cd = !"SELHO".equals(ofc_cd)?"SELHO":ofc_cd;
		ofc_lvl = !"1".equals(ofc_cd)?"1":ofc_lvl;
    }catch(Exception e) {
        out.println(e.toString());
    }
%>
<html>
<head>
<title>Inquiry by BKG (ABC/STP)</title>
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

<body onload="javascript:setupPage();">
<form method="post" name="form" onKeyDown="ComKeyEnter();">
<input type="hidden" name="f_cmd">
<input type="hidden" name="f_ofc_cd" value="<%=ofc_cd %>">
<input type="hidden" name="f_ofc_lvl" value="<%=ofc_lvl %>">
<input type="hidden" name="iPage">
<input type="hidden" name="s_pro_vw" value="<%=JSPUtil.getNull(request.getParameter("f_pro_vw"))%>">
<input type="hidden" name="s_pro_lvl" value="<%=JSPUtil.getNull(request.getParameter("f_pro_lvl"))%>">


<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" id="navigation_icon_popup_hidden" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->

		<!--Button_L (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
	       	<tr><td class="btn1_bg">

				<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<!-- Repeat Pattern -->
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" id="btn_retrieve" name="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>

					<td class="btn1_line"></td>

					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" id="btn_downexcel" name="btn_downexcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>
					<!-- Repeat Pattern -->

				</tr></table>

			</td></tr>
		</table>
		<!--Button_L (E) -->


            <!-- TABLE '#D' : ( Search Options ) (S) -->
            <table class="search" border="0">
                <tr>
                    <td class="bg">

                        <!-- : ( BKG ) (S) -->
                        <table class="search_in" border="0">
                            <tr class="h23">
                                <td width="97">Booking</td>
                                <td width="200">
                                    <input type="text" style="width:133" class="input1" name="f_bkg_no"  value="<%=JSPUtil.getNull(request.getParameter("f_bkg_no"))%>" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum');" maxlength="13">
                                </td>
                                <td>
                                    <!-- <table class="line_bluedot"><tr><td></td></tr></table> -->
                                    <table class="search" border="0" >
                                        <tr class="h23" align="left">
                                            <td width="94" class="gray_tit"><img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">By View</td>
                                            <td width="90"> Profit View</td>
                                            <td width="120">
                                            	<script language="javascript">ComComboObject('f_pro_vw',1, 100 , 1 )</script>
                                            </td>
                                            <td id="td_stp1" style="display:none">
                                                <input type="radio" class="trans" name="f_stp_flg" value="I"> STP Income&nbsp;&nbsp;&nbsp;
                                                <input type="radio" class="trans" name="f_stp_flg" value="O" checked> STP Cost
                                            </td>
                                            <td id="td_stp2">&nbsp; </td>
                                        </tr>
                                    </table>

                                </td>
                            </tr>
                        </table>
                        <!-- : ( BKG ) (E) -->

                    </td>
                </tr>
            </table>
            <!-- TABLE '#D' : ( Search Options ) (E) -->


            <table class="height_10"><tr><td></td></tr></table>


            <!-- TABLE '#D' : ( Search Options ) (S) -->
            <table class="search" border="0">
                <tr>
                    <td class="bg">

                        <!-- : ( Contract Office ) (S) -->
                        <table class="height_10"><tr><td></td></tr></table>
                        <table class="search_in" border="0">
                            <tr class="h23">
                                <td width="97">Contract Office</td>
                                <td width="90"><input type="text" style="width:60" name="f_ctrt_ofc_cd" value=""  disabled class="input2"></td>
                                <td width="93">Loading Office</td>
                                <td width="90"><input type="text" style="width:60" name="f_sls_ofc_cd" value=""  disabled class="input2"></td>
                                <td width="27">IOC</td>
                                <td width="60"><input type="text" style="width:30;text-align:center;" name="f_ioc" value="" disabled class="input2"></td>
                                <td width="90">Revenue Lane</td>
                                <td width="90"><input type="text" style="width:60" name="f_rlane" value="" disabled class="input2"></td>
                                <td width="33">VVD</td>
                                <td width="120"><input type="text" style="width:90" name="f_vvd" value="" disabled class="input2"></td>
                                <td width="45">Period</td>
		                        <td><input type="text" style="width:70" name="f_sls_yrmon" value="" disabled class="input2">&nbsp;<input type="text" style="width:40" name="f_cost_wk" value="" disabled class="input2"></td>
                            </tr>
                        </table>
                        <!-- : ( Contract Office ) (S) -->

                        <table class="line_bluedot"><tr><td></td></tr></table>

                        <!-- : ( Grids ) (S) -->
	                    <table width="100%" id="mainTable1">
	                        <tr><td><script language="javascript">ComSheetObject('sheet1');</script></td></tr>
	                    </table> 
	                    <table width="100%" id="mainTable2">
	                        <tr><td><script language="javascript">ComSheetObject('sheet2');</script></td></tr>
	                    </table> 
	                    <table width="100%" id="mainTable3">
	                        <tr><td><script language="javascript">ComSheetObject('sheet3');</script></td></tr>
                        </table>
                        <!-- : ( Grids ) (E) -->


						<!--  Button_Sub (S) -->
						<table width="100%" class="button">
					       	<tr><td class="btn2_bg">
							<table border="0" cellpadding="0" cellspacing="0">
							<tr>

								<!-- Repeat Pattern -->
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" onClick="javascript:popupAbcStpUnitCost();">ABC/STP Unit Cost</td><td class="btn2_right"></td></tr></table></td>
								<!-- Repeat Pattern -->


							</tr></table>
						</td></tr>
						</table>
				    	<!-- Button_Sub (E) -->

                    </td>
                </tr>
            </table>
            <!-- TABLE '#D' : ( Search Options ) (E) -->


</td></tr>
</table>
<!-- Outer Table (E)-->



</form>
</body>
</html>
<iframe id=myiframe src="" width=0 height=0></iframe>