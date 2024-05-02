<%
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_COA_0136.jsp
*@FileTitle : POR ECC Setting popup
*Open Issues :
*@LastModifyDate : 2007-04-21
*                : 2008-05-06
*@LastModifier : Ari
*              : 전윤주
*@LastVersion : 1.0
* 2007-04-21 Ari
* 2008-05-06 전윤주
* 1.0 최초 생성
* 2015.07.07 이윤정 [CHM-201536740] COA 내 화면의 조회 기능 (Retrieve, Down Excel)을 뺀 나머지 버튼들을 비활성화 요청 CSR
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.coa.stdunitcost.averagerpb.event.EsmCoa0184Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmCoa0184Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	//사용 변수
	String f_rpb_yrmon = JSPUtil.getNullNoTrim(request.getParameter("f_rpb_yrmon"));
	String classId = JSPUtil.getNullNoTrim(request.getParameter("classId"));
	String titleName = "RPB";
	
	if(classId.equals("ESM_COA_0174")) {
		titleName = "Average U/C";
	}
	
	Logger log = Logger.getLogger("com.hanjin.apps.EQBalance.EQBalance");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmCoa0184Event)request.getAttribute("Event");
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
<title>RPB Creation</title>
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
<form name="form" onKeyDown="ComKeyEnter();">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="f_cost_yrmon" value="<%= f_rpb_yrmon %>">
<input type="hidden" name="f_duration" value="">
<input type="hidden" name="f_class_id" value="<%= classId %>">


<!-- OUTER - POPUP (S)tart -->
<table width="300" class="popup" cellpadding="10" border="0">  <!-- CSR NO. N200802010006 -->
    <tr><td class="top"></td></tr>
    <tr><td valign="top">



		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp; <%=titleName %> Creation</td></tr>
		</table>
		<!-- : ( Title ) (E) -->

        <table class="search" align="center" >
          <tr>
            <td class="bg">

              <!-- : ( Level Group ) (E) -->
              <table class="search" border="0">
        	<tr class="h23">
        		<td width="180">Target Month(YYYY_MM)</td>
        		<td><input type="text" class="input1" name="f_target_yrmon" value ="<%=f_rpb_yrmon%>" style="width:60" maxlength="7"
                 					onKeyPress="ComKeyOnlyNumber(window)" onChange=""
                					onBlur="addDash(this , 4);" 
                					onFocus="this.value=ComReplaceStr(this.value, '-', '');" >
	            </td>
	        </tr>
	        <tr><td>&nbsp;</td></tr>
	        <tr class="h23">
	        	<td>Period(YYYY_WK)</td>
	        </tr>
	        <tr class="h23">
	        	<td>From&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" class="input1" name="f_fm_yrwk" style="width:60" maxlength="7"
                 					onKeyPress="ComKeyOnlyNumber(window)" onChange=""
                					onBlur="addDash(this , 4);" 
                					onFocus="this.value=ComReplaceStr(this.value, '-', '');" >&nbsp;&nbsp;&nbsp;~&nbsp;&nbsp;&nbsp;
                					To
                					</td>
                <td><input type="text" class="input1" name="f_to_yrwk" style="width:60" maxlength="7"
                 					onKeyPress="ComKeyOnlyNumber(window)" onChange=""
                					onBlur="addDash(this , 4);" 
                					onFocus="this.value=ComReplaceStr(this.value, '-', '');" ></td>
                					
	        </tr>
	        <tr>
	        <td>

              <!-- : ( Level Group ) (E) -->
              <table width="100%" height="10" id="mainTable"> <!-- CSR NO. N200802010006 -->
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
<table width="300" class="sbutton">
<tr><td height="51" class="popup">

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

</form>
</body>
</html>