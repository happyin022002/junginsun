<%-- =========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_SCE_0063.jsp
*@FileTitle : Vessel SKD조회(공통 Popup)
*Open Issues :
*Change history :
*@LastModifyDate : 2006-08-11
*@LastModifier : Hyunsu, Ryu
*@LastVersion : 1.0
* 2006-08-11 Hyunsu, Ryu
* 1.0 최초 생성
=========================================================
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.event.EsdSce0063Event"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.event.EsdSce0063EventResponse"%>
<%
    EsdSce0063Event  event = null;                //PDTO(Data Transfer Object including Parameters)
    EsdSce0063EventResponse eventResponse = null;    //RDTO(Data Transfer Object including DB ResultSet)
    Exception serverException   = null;            //서버에서 발생한 에러
    DBRowSet rowSet      = null;                               //DB ResultSet
    String strErrMsg = "";                                 //에러메세지
    int rowCount     = 0;                                  //DB ResultSet 리스트의 건수

    try {
       /*
        꼭 유저의 정보를 받을 필요는 없습니다. 화면에서 유저의 이름이나
        권한같은 정보를 이용할 필요가 있을 경우에만 사용하면 됩니다.
        덧붙여 USER 정보에 대해서 한마디로 정리하면 user 의 정보를 이용할수 있는 곳은 jsp 와 command 입니다.
        jsp에서는 유저의 정보를 가지고 권한에 따른 버튼 처리등을 할수가 있는 것이고 (enable/disable)
        command에서는 역시 유저의 정보로 예를 들어 update 권한등이 있는지를 확인할 수가 있는 것입니다.

        주의> 사용자 테이블이 변경됨에 따라 변경 될 것입니다.
             SignOnUserAccount 의 메서드를 확인 하십시오.
             getAuth 메서드는 현재 미정이지만 권한 관련 value를 가져올 메서드가 있겠죠?
       */
       //SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
       //userId=account.getSawonNo();
       //userAuth=account.getAuth();


       /*
        일단 화면에서 USER가 입력한 정보를 다시 화면에서 사용해야 하는 경우
        request에 담아 서버로 전송시켰다가 다시 그 request에서 받아야 한다고 했습니다.
        이때 유저가 작성한 자료는 event 에 서버로부터 전송된 자료는 eventResponse에 담기게 됩니다.
        이렇게 받은 정보는 jsp 맨 하단에 있는 java script로부터 폼의 value로 값을 전달하게 됩니다.
        본 jsp소스 맨 하단을 참조하십시오.
       */
        event = (EsdSce0063Event)request.getAttribute("Event");
       /*
         ErrorHandler를 통해서 받는 에러는 CO_ERRMESSAGE 테이블에 입력되어있는
          개발자가 정의했거나 공통팀에서 결정한 정의가 되어진 에러메세지입니다
          Command 에서 EventException으로 throw를 했거나 DAO에서 DAOException을 통해
          jsp 까지 전달이 되게 됩니다. 해당 파일을 참조하십시오.
          jsp에서 최후에 에러가 display될때 onload시에 실행되는 ShowErrMessage 를 통해 showErrMessage();가 뜨게 됩니다.
          (주의) 이 에러메세지와 자바스크립트 에러를 혼동하지는 마십시오.
                 자바스크립트 에러는 서버로 전송하기전에 "주민등록번호가 잘못되었습니다" 라는 메세지이고
                 throw되는 메세지는 update 를 하려고 권한을 확인해보니까 없어서
                 "해당 권한이 없습니다" 라고 뿌리는 메세지입니다.
       */
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
       /*
        아래부분은 꼭 지켜주셔야 에러메세지가 정상적으로 전달이 됩니다.
        보시다시피 먼저 에러를 받고 에러가 아닐시에 EventResponse로 값을 전달하셔야 합니다.
       */
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }else{
            eventResponse = (EsdSce0063EventResponse)request.getAttribute("EventResponse");
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
<title>VVD</title>
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
<!--
showErrMessage를 써주지 않으면 에러 발생시 처리가 불가합니다.
그리고 지금은 showErrMessage()으로 되어있지만 추후에 고객님이 변덕을 일으켜서 웹페이지를 호출하라고 할경우를
대비해서 직접 showErrMessage() 하지 마시고 꼭 showErrMessage를 써주십시오. 한방에 바꾸게요. 표준을 안따르면 나중에 후회합니다.
-->

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input    type="hidden" name="f_cmd">
<input    type="hidden" name="loc_cd">
<input    type="hidden" name="sdate_hidden">
<input    type="hidden" name="edate_hidden">


<!-- OUTER - POPUP (S)tart -->
<table width="600" class="popup" cellpadding="10">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp;VVD Inquiry</td></tr>
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
				<table class="search" border="0" style="width:535;">
				<tr class="h23">
					<td width="70"><img class="nostar">ETD/ETA</td>
					<td width="80"><select class="input1" name="etdeta" style="width:75;">
						<option value="D">ETD</option>
						<option value="A" selected>ETA</option>
						</select></td>
					<td width="" class="stm">
						<input type="text" style="width:75" name="sdate" maxlength=""  dataformat="ymd"  required  onBlur='ComChkObjValid(this, false, false, true)' >
						<img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar1"> ~
						<input type="text" style="width:75" name="edate" maxlength=""  dataformat="ymd"  required  onBlur='ComChkObjValid(this, false, false, true)' >
						<img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar2">
						</td>
				</tr>
				</table>
				<table class="search" border="0" style="width:535;">
					<tr class="h23">
						<td width="70"><img class="nostar">Lane</td>
						<td width="165"><input type="text" style="width:75" name="lane_cd" maxlength="" onKeyUp="javascript:upper(this);"></td>
						<td width="30">POL</td>
						<td width="160"><input type="text" style="width:75" name="pol_cd" maxlength="" onKeyUp="javascript:upper(this);"></td>
						<td width="30">POD</td>
						<Td><input type="text" style="width:75" name="pod_cd" maxlength="" onKeyUp="javascript:upper(this);"></td>
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

 <%@include file="../jsp/common.jsp"%>
