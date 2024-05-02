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
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.event.EsdSce0067Event"%>
<%

	Logger log = Logger.getLogger("com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.jsp.EsdSce0067");

//log.info("**********************************************************************");
//log.info("**********************************************************************");
//log.info("**********************************************************************");
//log.info("**********************************************************************");
    EsdSce0067Event  event = null;                //PDTO(Data Transfer Object including Parameters)

    Exception serverException   = null;            //서버에서 발생한 에러
    DBRowSet rowSet      = null;                               //DB ResultSet
    String strErrMsg = "";                                 //에러메세지
    int rowCount     = 0;                                  //DB ResultSet 리스트의 건수
    String edi_grp_cd = JSPUtil.getNull(request.getParameter("edi_grp_cd"));
    String diff = JSPUtil.getNull(request.getParameter("diff"));

    log.info("\n ESD_SCE_0067.jsp:"+edi_grp_cd);



        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if( serverException == null ) {
			log.info("serverException null");
		} else {
			log.info("serverException not null");

		}
//
//			log.info("serverException 1");
//
//        out.println("step 1");
        if (serverException != null && serverException.getMessage() != null ) {
			log.info("serverException :::::::::::::::::::::::::::::::::::::::::::::::::::" + serverException.getMessage());
			log.info("\n jsjsjs "+serverException.getCause());
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

%>
<html>
<head>
<title>EDI Status</title>
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
<input    type="hidden" name="edi_grp_cd" value='<%=edi_grp_cd%>'>
<input    type="hidden" name="diff"  value='<%=diff%>'>

<!-- OUTER - POPUP (S)tart -->
<table width="800" class="popup" cellpadding="10">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp;EDI Status</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
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
