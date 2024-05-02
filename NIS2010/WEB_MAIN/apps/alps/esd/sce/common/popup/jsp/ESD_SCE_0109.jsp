<%--=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : CESD_SCE_0109.jsp
*@FileTitle : Location조회/POR/POL/POD/DEL(Popup)
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
* 2008-07-21 Hun-Il Jung
* 1.0 최초 생성
=========================================================--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.bizcommon.location.event.ComEns051Event"%>
<%@ page import="com.hanjin.bizcommon.location.event.ComEns051EventResponse"%>
<%
	ComEns051Event  event = null;                        //PDTO(Data Transfer Object including Parameters)
	ComEns051EventResponse eventResponse = null;         //RDTO(Data Transfer Object including DB ResultSet)
	Exception serverException   = null;                    //서버에서 발생한 에러
	DBRowSet rowSet      = null;                           //DB ResultSet
	String strErrMsg = "";                                 //에러메세지
	int rowCount     = 0;                                  //DB ResultSet 리스트의 건수

	String usr_ofc_cd = "";
	// 정헌일 체크박스 멀티선택
	String diff = JSPUtil.getNull(request.getParameter("diff"));
	try {
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        //userId=account.getSawonNo();
        //userAuth=account.getAuth();
        usr_ofc_cd = account.getOfc_cd();


	    event = (ComEns051Event)request.getAttribute("Event");
	   //serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);					//	?

	    if (serverException != null) {
	        strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
	    }else{
	        eventResponse = (ComEns051EventResponse)request.getAttribute("EventResponse");
	        if (eventResponse != null) {
	            rowSet = eventResponse.getRs();
	            if(rowSet != null){
	                 rowCount = rowSet.getRowCount();
	            } // end if
	        } // end if
	    } // end else
	}catch(Exception e) {
	    out.println(e.toString());
	}
%>
<html>
<head>
<title>Location</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if

		// 탭을 사용하는 화면인 경우 추가한다.
        // InitTab();
        loadPage();
    }
</script>
</head>
<!--
showErrMessage를 써주지 않으면 에러 발생시 처리가 불가합니다.
그리고 지금은 showErrMessage()으로 되어있지만 추후에 고객님이 변덕을 일으켜서 웹페이지를 호출하라고 할경우를
대비해서 직접 showErrMessage() 하지 마시고 꼭 showErrMessage를 써주십시오. 한방에 바꾸게요. 표준을 안따르면 나중에 후회합니다.
-->

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input    type="hidden" name="f_cmd">
<input type="hidden" name="loc_port_ind">
<input type="hidden" name="lcc_cd" value="">
<input type="hidden" name="sysCode">
<!-- 정헌일 체크박스 멀티선택-->
<input    type="hidden" name="diff"  value='<%=diff%>'>

<!-- OUTER - POPUP (S)tart -->
<table width="800" class="popup" cellpadding="10">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
			<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp;Location / Port Code Inquiry</td></tr>
		</table>
		<!-- : ( Title ) (E) -->

		<!-- TABLE '#D' : ( Button : Main ) (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
				<tr><td class="btn1_bg">

						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_new" id="btn_new">New</td><td class="btn1_right"></td></tr></table></td>
							<!-- Repeat Pattern -->

						</tr></table>

				</td></tr>
		</table>
    	<!-- TABLE '#D' : ( Button : Main ) (E) -->

		<!-- TABLE '#D' : ( Search Options : Scenario ID ) (S) -->
		<table class="search">
			<tr>
				<td class="bg">


				<!-- : ( Scenario ID ) (S) -->
				<table class="search" border="0" style="width:745;">
				<tr class="h23">
					<td width="90">Continent</td>
					<td width="80"><input name="conti_cd" type="text" style="width:60" onKeyUp="javascript:upper(this);"></td>
					<td width="95">Sub Continent</td>
					<td width="120"><input name="sconti_cd" type="text" style="width:60" onKeyUp="javascript:upper(this);"></td>
					<td width="55">Country</td>
					<td width="120"><input name="cnt_cd" type="text" style="width:60" onKeyUp="javascript:upper(this);"></td>
					<td width="40">State</td>
					<td width=""><input name="loc_state" type="text" style="width:50" onKeyUp="javascript:upper(this);"></td></tr>
				</table>
				<table class="search" border="0" style="width:745;">
				<tr class="h23">
					<td width="90">Control Office</td>
					<td width="80"><input name="loc_eq_ofc" type="text" style="width:60" onKeyUp="javascript:upper(this);"></td>
					<td width="95">Location Code</td>
					<td width="80"><input name="loc_cd" type="text" style="width:60" onKeyUp="javascript:upper(this);"></td>
					<td width="95">Location Name</td>
					<td><input name="loc_nm" type="text" style="width:210">&nbsp;
									<input name="chk_port_ind" type="checkbox" value="Y" class="trans"> Port Only
					</td>
				</tr>
				</table>
				<!-- : ( Scenario ID ) (E) -->

			</tr>
		</table>
		<!-- TABLE '#D' : ( Search Options : Scenario ID ) (E) -->

		<table class="height_10"><tr><td></td></tr></table>


		<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
		<table class="search" border="0">
			<tr>
				<td class="bg">

			<table class="height_10"><tr><td></td></tr></table>

			<!-- : ( Grid ) (S) -->
			<!-- 'HEAD1-BGCOLOR : 203 240 169' , 'HEAD2-BGCOLOR : 222 251 248' , 'BORDER 1-outside : 88 152 164' ,
				 'BORDER 2-inside : 202 226 233' , 'HEAD-FONT : 39 95 101' , 'SELETED ROW BG : 252 255 233' -->

					<table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet1');</script>
                        </td></tr>
		            </table>



			<!-- : ( Grid ) (E) -->

				</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Tab BG Box ) (E) -->




</td></tr>
</table>
<!-- OUTER - POPUP (E)nd -->



<table class="height_10"><tr><td></td></tr></table>


<!-- : ( Button : Sub ) (S) -->
<table width="100%" class="sbutton">
		<tr><td height="71" class="popup">

			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
	       		<tr><td class="btn3_bg">
			    <table border="0" cellpadding="0" cellspacing="0">
			    <tr>

					<!-- Repeat Pattern -->
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" name="btn_ok" id="btn_ok">Ok</td><td class="btn1_right"></td></tr></table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" name="btn_close" id="btn_close">Close</td><td class="btn1_right"></td></tr></table></td>
					<!-- Repeat Pattern -->

				</tr>
			</table>

		</td></tr>
</table>
<!-- : ( Button : Sub ) (E) -->


</form>
</body>
</html>

<SCRIPT LANGUAGE="javascript">
<!--
      /*
        ibSheet 를 제외한 폼 입력값(?) 유저가 입력한 정보를 event를 통해서 다시 넘겨받아 화면에 뿌려주는 부분입니다.
      */
      with(document.form)
      {
        <%
        if(event != null){

        	//String conti_cd     = event.getConti_cd();
            //String sconti_cd = event.getScontiCd();
            String cnt_cd     = event.getCntCd();
            //String loc_state     = event.getLocState();
            String loc_eq_ofc     = event.getLocEqOfc();
            String loc_cd     = event.getLocCd();
            //String loc_desc     = event.getLocDesc();
            //String loc_port_ind     = event.getLocPortInd();
            //String sysCode     = event.getSysCode();

			// Office Default 세팅
        	if(!"N".equals(loc_eq_ofc)) {
        %>
        		eval("loc_eq_ofc").value = "<%=usr_ofc_cd%>";
        <%
        	}
        %>

	        eval("cnt_cd").value     = "<%=cnt_cd%>";
	        eval("loc_eq_ofc").value     = "<%=loc_eq_ofc%>";
	        eval("loc_cd").value     = "<%=loc_cd%>";


        <% } %>
       }
-->
</SCRIPT>

<%@ include file="/apps/alps/esd/sce/common/commonpopup/include/common.jsp"%>


