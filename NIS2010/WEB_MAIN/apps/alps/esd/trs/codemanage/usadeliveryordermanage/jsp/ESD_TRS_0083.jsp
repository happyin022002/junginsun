<%-- =========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0083.jsp
*@FileTitle : US D/O Input
*Open Issues :
*Change history :
*@LastModifyDate : 2008-11-17
*@LastModifier : jonghyek choi
*@LastVersion : 1.0
* 2008-11-17 jonghyek choi
* 1.0 최초 생성

========================================================= --%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.trs.codemanage.usadeliveryordermanage.event.EsdTrs0083Event"%>
<%
  EsdTrs0083Event  event = null;       //PDTO(Data Transfer Object including Parameters)
  Exception serverException   = null;     //서버에서 발생한 에러
  DBRowSet rowSet   = null;                //DB ResultSet
  String strErrMsg = "";                 //에러메세지
  int rowCount   = 0;                 //DB ResultSet 리스트의 건수
  SignOnUserAccount account = null;
  try {
    account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    event = (EsdTrs0083Event)request.getAttribute("Event");

    serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

    if (serverException != null) {
      strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
    }
  }catch(Exception e) {
    out.println(e.toString());
  }
%>
<html>

<head>
<title>US D/O Input</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
  function setupPage(){
    var errMessage = "<%=strErrMsg%>";
    if (errMessage.length >= 1) {
      ComShowMessage(errMessage);
    } // end if
    // InitTab();
    loadPage();
  }
</script>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();displayType(0);">
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="localDate">
<input type="hidden" name="form_cre_usr_id" value="<%=account.getUsr_id()%>">
<input type="hidden" name="form_usr_ofc_cd" value="<%=account.getOfc_cd()%>">

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>

		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->

            <!-- TABLE '#D' : ( Button : Main ) (S) -->
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
		       	<tr><td class="btn1_bg">

					<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<!-- Repeat Pattern -->
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td><td class="btn1"  id="btn_retrieve" name="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td><td class="btn1"  id="btn_new" name="btn_new">New</td><td class="btn1_right"></td></tr></table></td>

						<td class="btn1_line"></td>

						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td><td class="btn1"  id="btn_minimize" name="btn_minimize">Minimize</td><td class="btn1_right"></td></tr></table></td>
						<!-- Repeat Pattern -->

					</tr></table>

				</td></tr>
			</table>
            <!-- TABLE '#D' : ( Button : Main ) (E) -->

            <div id="showMin" style="display:inline">
            <!-- TABLE '#D' : ( Search Options ) (S) -->
            <table class="search">
              <tr>
              	<td class="bg">

                  <!-- : ( Scenario ID ) (S) -->
                  <table class="search_in" border="0">
                    <tr class="h23">
                      <td width="110">Bill Of Lading No.</td>
                      <td width="200"><input name="bill_no" type="text" style="width:100" value="">&nbsp;<img class="cursor" src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle" name="btns_multibillno"></td>
                      <td width="90">Booking No.</td>
                      <td><input name="booking_no" type="text" style="width:100" value="">&nbsp;<img class="cursor" src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle" name="btns_multibookingno"></td>
                    </tr>
                  </table>
                  <!-- : ( Scenario ID ) (E) -->

                  <table class="line_bluedot"><tr><td colspan="6"></td></tr></table>

                  <!-- : ( From/To ) (S) -->
                  <table class="search_in" border="0">
                    <tr class="h23">
                    	<td width="110">Customer</td>
                      	<td width="102"><input type="text" name="cust_cnt_cd" style="width:100" value=""></td>
                      	<td width="102"><input type="text" name="cust_seq" style="width:100" value=""></td>
                      	<td colspan="4"><input type="text" name="cust_nm" style="width:638" value="">&nbsp;<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_consignee"></td>
                    </tr>
                    <tr class="h23">
                    	<td class="60">Address</td>
                      	<td class="" colspan="6"><input type="text" name="address" style="width:100%" value=" "></td>
                    </tr>
                    </table>

                 	<table class="search_in" border="0">
                    <tr class="h23">
                    	<td width="110">Zip Code</td>
                      	<td width="200"><input type="text" name="zip_code" style="width:100" value=" "></td>
                      	<td width="90">Door Location</td>
                      	<td width="200"><input name="dor_loc_cd" type="text" style="width:100" value=" "></td>
                      	<td width="50">Zone</td>
                      	<td><input name="zone_cd" type="text" style="width:100" value=" "></td>
                    </tr>
                    <tr class="h23">
                    	<td>Person In Charge</td>
                      	<td><input type="text" name="pic" style="width:100" value=" "></td>
                      	<td>Telephone</td>
                      	<td><input type="text" name="tel" style="width:100" value=" "></td>
                      	<td>Fax.</td>
                      	<td><input type="text" name="fax" style="width:100" value=" "></td>
                    </tr>
                    <tr class="h23">
                    	<td>Remark</td>
                      	<td colspan="6"><input type="text" name="remark" style="width:100%" value=" "></td>
                    </tr>
                  </table>
                  <!-- : ( From/To ) (E) -->
                </td>
              </tr>
            </table>
            <!-- TABLE '#D' : ( Search Options ) (E) -->
            </div>

            <table class="height_10"><tr><td></td></tr></table>


            <!-- : ( Grid BG Box ) (S) -->
            <table class="search" border="0">
              <tr>
                <td class="bg_b1">
                  <table class="search"><tr><td class="height_2"></td></tr></table>


                  <!-- : ( Grid ) (S) -->
                  <!-- 'HEAD1-BGCOLOR : 203 240 169' , 'HEAD2-BGCOLOR : 222 251 248' , 'BORDER 1-outside : 88 152 164' ,'BORDER 2-inside : 202 226 233' , 'HEAD-FONT : 39 95 101' , 'SELETED ROW BG : 252 255 233' -->
                  <table width="100%" id="mainTable">
                    <tr>
                      <td>
                        <script language="javascript">ComSheetObject('sheet1');</script>
                      </td>
                    </tr>
                  </table>
                  <!-- : ( Grid ) (E) -->

                  <!-- : ( Grid ) (S) -->
                  <!-- 'HEAD1-BGCOLOR : 203 240 169' , 'HEAD2-BGCOLOR : 222 251 248' , 'BORDER 1-outside : 88 152 164' ,'BORDER 2-inside : 202 226 233' , 'HEAD-FONT : 39 95 101' , 'SELETED ROW BG : 252 255 233' -->
                  <table width="100%" id="mainTable">
                    <tr>
                      <td>
                        <script language="javascript">ComSheetObject('sheet2');</script>
                      </td>
                    </tr>
                  </table>
                  <!-- : ( Grid ) (E) -->

                  <!-- : ( Grid ) (S) -->
                  <!-- 'HEAD1-BGCOLOR : 203 240 169' , 'HEAD2-BGCOLOR : 222 251 248' , 'BORDER 1-outside : 88 152 164' ,'BORDER 2-inside : 202 226 233' , 'HEAD-FONT : 39 95 101' , 'SELETED ROW BG : 252 255 233' -->
                  <table width="100%" id="mainTable">
                    <tr>
                      <td>
                        <script language="javascript">ComSheetObject('sheet3');</script>
                      </td>
                    </tr>
                  </table>
                  <!-- : ( Grid ) (E) -->

                </td>
              </tr>
            </table>
            <!-- : ( Grid BG Box ) (E) -->


            <!-- : ( Button : Grid ) (S) -->
			<table width="100%" class="button">
		       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
				<tr>

					<!-- Repeat Pattern -->
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td><td class="btn2"  id="btn_apply" name="btn_apply">Apply</td><td class="btn2_right"></td></tr></table></td>

					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td><td class="btn2"  id="btn_socreation" name="btn_socreation">S/O Creation</td><td class="btn2_right"></td></tr></table></td>
					<!-- Repeat Pattern -->


				</tr></table>
			</td></tr>
			</table>
            <!-- : ( Button : Grid ) (E) -->



</td></tr>
</table>
<!-- Outer Table (E)-->


</form>

</body>
</html>