<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_AGT_007.jsp
*@FileTitle : 미주 Brokerage 계약 요율 Creation/Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-30
*@LastModifier : Hwang GyeongNam
*@LastVersion : 1.0
* 2006-11-30 Hwang GyeongNam
* 1.0 최초 생성
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.agt.agtagreement.agtcustomeragreementinfo.event.EsmAgt0057Event"%>
<%@ page import="com.hanjin.apps.alps.esm.agt.common.ComboUtil"%>
<%
EsmAgt0057Event  event = null;                                 //PDTO(Data Transfer Object including Parameters)
Exception serverException   = null;                             //서버에서 발생한 에러
DBRowSet rowSet   = null;                                               //DB ResultSet

String userId = "";
String ofcCd = "";
String ofc_cd = "";
String arOfcCd = "";
String ar_ofc_cd = "";
String agn_cd = "";
String strErrMsg = "";                                                  //에러메세지
String tmpGrpTp = "";                                                   //Location 별 Type 구분
String tmpBrogDiv = "";                                                 //Type 구분
String tmpBrogTp = "";                                                  //Charge Type 구분
String tmpBrogKnd = "";                                                 //Kind 구분
String grpTpCode = "";                                                  //Location 별 Type 구분 Code
String grpTpText = "";                                                  //Location 별 Type 구분 Text
String brogDivCode = "";                                                //Type 구분 Code
String brogDivText = "";                                                //Type 구분 Text
String brogTpCode = "";                                                 //Charge Type 구분 Code
String brogTpText = "";                                                 //Charge Type 구분 Text
String brogKndCode = "";                                                //Kind 구분 Code
String brogKndText = "";                                                //Kind 구분 Text

int rowCount     = 0;                                                   //DB ResultSet 리스트의 건수

try {
	SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	userId = account.getUsr_id();
	ofcCd = account.getOfc_cd();

        //공통코드 combo string 가져와서 필요한 부분 추출
        tmpGrpTp = JSPUtil.getIBCodeCombo("", "", "CD00888", 0, "");
        tmpBrogDiv = JSPUtil.getIBCodeCombo("", "", "CD02812", 0, "");
        tmpBrogTp = JSPUtil.getIBCodeCombo("", "", "CD02814", 0, "");
        tmpBrogKnd = JSPUtil.getIBCodeCombo("", "", "CD02817", 0, "");

        if(tmpGrpTp != null && tmpGrpTp.length() > 8) {
                grpTpCode = tmpGrpTp.substring(tmpGrpTp.indexOf("Code = \"")+8, tmpGrpTp.lastIndexOf("\""));
                grpTpText = tmpGrpTp.substring(tmpGrpTp.indexOf("Text = \"")+8, tmpGrpTp.indexOf("\";"));
        }

        if(tmpBrogDiv != null && tmpBrogDiv.length() > 8) {
                brogDivCode = tmpBrogDiv.substring(tmpBrogDiv.indexOf("Code = \"")+8, tmpBrogDiv.lastIndexOf("\""));
                brogDivText = tmpBrogDiv.substring(tmpBrogDiv.indexOf("Text = \"")+8, tmpBrogDiv.indexOf("\";"));
        }

        if(tmpBrogTp != null && tmpBrogTp.length() > 8) {
                brogTpCode = tmpBrogTp.substring(tmpBrogTp.indexOf("Code = \"")+8, tmpBrogTp.lastIndexOf("\""));
                brogTpText = tmpBrogTp.substring(tmpBrogTp.indexOf("Text = \"")+8, tmpBrogTp.indexOf("\";"));
        }

        if(tmpBrogKnd != null && tmpBrogKnd.length() > 8) {
                brogKndCode = tmpBrogKnd.substring(tmpBrogKnd.indexOf("Code = \"")+8, tmpBrogKnd.lastIndexOf("\""));
                brogKndText = tmpBrogKnd.substring(tmpBrogKnd.indexOf("Text = \"")+8, tmpBrogKnd.indexOf("\";"));
        }

        event = (EsmAgt0057Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

} catch (Exception e) {
        out.println(e.toString());
}
//Combo Data : getCodeCombo('태그명','초기값', '추가요소', '업무명', '조건코드', '전체유무', '추가옵션')
ofc_cd = ComboUtil.getCodeCombo("ofc_cd", ofcCd, " style='width:85', class='input1'", "arOfcListCmpn", ofcCd, "&lt;&lt;select&gt;&gt;", "");
%>
<html>
<head>
<title>남미서안 Brokerage 계약 요율 Creation/Inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
        function setupPage(){
                var errMessage = "<%=strErrMsg%>";
                if (errMessage.length >= 1) {
                        ComShowMessage(errMessage);
                } // end if
                loadPage("<%=grpTpCode%>", "<%=grpTpText%>", "<%=brogDivCode%>", "<%=brogDivText%>", "<%=brogTpCode%>", "<%=brogTpText%>", "<%=brogKndCode%>", "<%=brogKndText%>");
        }
</script>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<iframe height="0" width="0" name="frmHidden"></iframe>
<form name = "hiddenF" mehhod="post">
<input type="hidden" name="f_cmd">
<input type="hidden" name="cust_cd">
<input type="hidden" name="sheetId">
<input type="hidden" name="row">
<input type="hidden" name="colNm1">
<input type="hidden" name="colNm2">
<input type="hidden" name="param1">
<input type="hidden" name="param2">
</form>

<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="rowNum">
<input type="hidden" name="colNum">
<input type="hidden" name="custNm">


<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>

				<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
				<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
				</table>
				<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->


                <!-- TABLE '#D' : ( Button : Main ) (S) -->
                <table width="100%" class="button">
                        <tr><td class="align">

			        <!--Button (S) -->
			       <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
			        <tr><td class="btn1_bg">
			                    <table border="0" cellpadding="0" cellspacing="0">
			                    <tr>
			                                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
			                                        <tr><td class="btn1_left"></td>
			                                        <td class="btn1" name="btn_retrieve">Retrieve</td>
			                                        <td class="btn1_right"></td>
			                                        </tr>
			                                </table></td>
			                                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
			                                        <tr><td class="btn1_left"></td>
			                                        <td class="btn1" name="btn_save">Save</td>
			                                        <td class="btn1_right"></td>
			                                        </tr>
			                                </table></td>
			                                <td class="btn1_line"></td>
			                                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
			                                        <tr><td class="btn1_left"></td>
			                                        <td class="btn1" name="btn_downexcel">Down Excel</td>
			                                        <td class="btn1_right"></td>
			                                        </tr>
			                                </table></td>
			                        </tr>
			                        </table></td>
			                 </tr>
			              </table>
			         <!--Button (E) -->

                </td></tr>
                </table>
                <!-- TABLE '#D' : ( Button : Main ) (E) -->

                <!-- TABLE '#D' : ( Search Options : F.Forwarder ) (S) -->
		        <table class="search">
			        <tr><td class="bg">
	                    <table class="search_in" border="0">
	                    	<tr class="h23">
	                            <td width="4%">Office</td>
	                    		<td width="12%"><%= ofc_cd %></td>
                                <td width="10%">AGMT Customer</td>
                                <td width="70%">&nbsp;<input type="text" name="search_brog_cnt_cust_seq" style="width:100;ime-mode:disabled;" onKeyPress="ComKeyOnlyAlphabet('uppernum')" maxlength="8"><input type="hidden" name="search_brog_cnt_cust_seqName">
                                <a href="javascript:openWindowCustomer(document.form);" class="purple"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></a></td>
	                    	</tr>
	                    </table>
	                </td></tr>
                </table>
                <!-- TABLE '#D' : ( Search Options : Shipper  ) (E) -->

                <table class="height_10"><tr><td></td></tr></table>

                <!-- TABLE '#D' : ( Search Options ) (S) -->
                <table class="search">
                <tr><td class="bg">

	                <!-- : ( grid ) (S) -->
	                <table width="100%" id="mainTable">
	                          <tr><td>
	                         <script language="javascript">ComSheetObject('sheet1');</script>
	                          </td></tr>
	                </table>
		            <!-- : ( grid ) (E) -->

	                <!-- : ( Button : Sub ) (S) -->
	                <table width="100%" class="button">
	                      <tr><td class="btn2_bg">
	                                        <table border="0" cellpadding="0" cellspacing="0">
	                                        <tr>
	                                                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
	                                                        <tr><td class="btn2_left"></td>
	                                                        <td class="btn2" name="btng_rowadd">Row&nbsp;Add</td>
	                                                        <td class="btn2_right"></td>
	                                                        </tr>
	                                                        </table></td>
	                                                                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
	                                                        <tr><td class="btn2_left"></td>
	                                                        <td class="btn2" name="btng_rowcopy">Row Copy</td>
	                                                        <td class="btn2_right"></td>
	                                                        </tr>
	                                                        </table></td>

	                                          </tr></table>
	                   			</td></tr>
	                  </table>
	                  <!-- : ( Button : Sub ) (E) -->

                        </td></tr>
                </table>
                <!-- TABLE '#D' : ( Search Options ) (E) -->



</td></tr>
</table>
<!-- Outer Table (E)-->



</form>
</body>
</html>
