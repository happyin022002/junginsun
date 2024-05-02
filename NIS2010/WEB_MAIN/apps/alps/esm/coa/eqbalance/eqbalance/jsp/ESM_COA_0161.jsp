<%
/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : ESM_COA_161.jsp
*@FileTitle : DEL ECC setting popup
*Open Issues :
*@LastModifyDate :
*@LastModifier : 전윤주
*@LastVersion : 1.0
* 2008-09-03 전윤주
* 1.0 최초 생성
*Change history :
  2008.09.03 전윤주 CSR No.N200808260006 EQ repo rule-set(Rlane setting을 From-To ECC setting으로)
  2009.10.06 박수훈 0161화면 New FrameWork 적용
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.coa.eqbalance.eqbalance.event.EsmCoa0161Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmCoa0161Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
    
	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	//사용 변수
	String f_cost_yrmon = JSPUtil.getNullNoTrim(request.getParameter("f_cost_yrmon"));
	String f_cntr_tpsz_cd = JSPUtil.getNullNoTrim(request.getParameter("f_cntr_tpsz_cd"));

	Logger log = Logger.getLogger("com.hanjin.apps.EQBalance.EQBalance");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmCoa0161Event)request.getAttribute("Event");
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
<title>To(DEL) RCC For EQ Repo. Contribution</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form" onKeyDown="ComKeyEnter();">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="f_cost_yrmon" value="<%= f_cost_yrmon %>">
<input type="hidden" name="f_cntr_tpsz_cd" value="<%= f_cntr_tpsz_cd %>">

<!-- 개발자 작업	-->
 <!-- OUTER - POPUP (S)tart -->
  <table width="400" class="popup" cellpadding="10" border="0">  <!-- CSR NO. N200802010006 -->
    <tr>
      <td class="top"></td>
    </tr>
    <tr>
      <td valign="top">


		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp; To(DEL) RCC For EQ Repo. Contribution</td></tr>
		</table>
		<!-- : ( Title ) (E) -->


        <!-- : ( Search Options ) (S) -->
        <table class="search" align="center">
          <tr>
            <td class="bg">


              <!-- : ( Level Group ) (E) -->
              <table width="100%" height="200" id="mainTable"> <!-- CSR NO. N200802010006 -->
                <tr>
                  <td>
                    <script language="javascript">ComSheetObject('sheet1');</script>
                  </td>
                </tr>
              </table>
              <!-- : ( Level Group ) (E) -->

            </td>
          </tr>
        </table>
        <!-- : ( Search Options ) (E) -->


      </td>
    </tr>
  </table>
  <!-- OUTER - POPUP (E)nd -->



<table class="height_5"><tr><td></td></tr></table>


<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">


<tr><td height="71" class="popup">

		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>

				<!-- Repeat Pattern -->
<!-- 
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td><td class="btn1" name="btn_Save" id="btn_Save">Save</td><td class="btn1_right"></td></tr></table></td>

				<td class="btn1_line"></td>
 -->
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td><td class="btn1" name="btn_Close" id="btn_Close">Close</td><td class="btn1_right"></td></tr></table></td>
				<!-- Repeat Pattern -->

			</tr>
		</table>

	</td></tr>

</table>
<!-- : ( Button : pop ) (E) -->

</form>
</body>
</html>