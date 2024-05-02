<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_SPC_0066.jsp
*@FileTitle : Temporary Input
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.25
*@LastModifier : 최윤성
*@LastVersion : 1.0
* 2009.08.25 최윤성
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.event.EsmSpc0066Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmSpc0066Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.SpaceAllocationManage.SpaceAllocationManage");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmSpc0066Event)request.getAttribute("Event");
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
<title>Temporary Input</title>
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
<input type="hidden" name="trd_cd" value="">
<input type="hidden" name="sub_trd_cd" value="">
<input type="hidden" name="week" value="">
<input type="hidden" name="rlane_cd" value="">
<input type="hidden" name="dir_cd" value="">
<input type="hidden" name="vsl_cd" value="">
<input type="hidden" name="skd_voy_no" value="">
<input type="hidden" name="skd_dir_cd" value="">
<input type="hidden" name="ioc_cd" value="">
<input type="hidden" name="pol_cd" value="">
<input type="hidden" name="pod_cd" value="">
<input type="hidden" name="ofc_cd" value="">

<!-- 개발자 작업	-->
<!-- OUTER - POPUP (S)tart -->
<table width="555" class="popup" cellpadding="10">
<tr><td valign="top">


		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp;Temporary Input</td></tr>
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
		<table width="100%" id="mainInfo" class="Grid">
        <tr class="tr_head">
            <td>Trade</td>
            <td>SubTrade</td>
            <td>Lane</td>
            <td>Bound</td>
            <td>Week</td>
            <td>VVD</td>
            <td>OCN/IPC/TS</td>
            <td>POL</td>
            <td>POD</td>
        </tr>
        <tr class="cont_r" align="center">
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        </table>

		<table class="height_10"><tr><td></td></tr></table>

		<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
		<table class="search" border="0">
			<tr>
				<td class="bg">
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
										<tr><td class="btn1_left"></td><td class="btn1" name="btn_save" id="btn_save">Save</td><td class="btn1_right"></td></tr>
								</table></td>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn1_left"></td><td class="btn1" name="btn_close" id="btn_close">Close</td><td class="btn1_right"></td></tr>
								</table></td>
								<!-- Repeat Pattern -->
							</tr>
						</table>
				</td></tr>
			</table>
	</td></tr>
</table>
<!-- : ( Button : Sub ) (E) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
<script>
<%if(event != null){%>
var formObj = document.form;
formObj.trd_cd.value     = "<%=event.getConditionVO().getTrdCd()%>";
formObj.sub_trd_cd.value = "<%=event.getConditionVO().getSubTrdCd()%>";
formObj.week.value       = "<%=event.getConditionVO().getWeek()%>";
formObj.rlane_cd.value   = "<%=event.getConditionVO().getRlaneCd()%>";
formObj.dir_cd.value     = "<%=event.getConditionVO().getDirCd()%>";
formObj.vsl_cd.value     = "<%=event.getConditionVO().getVslCd()%>";
formObj.skd_voy_no.value = "<%=event.getConditionVO().getSkdVoyNo()%>";
formObj.skd_dir_cd.value = "<%=event.getConditionVO().getSkdDirCd()%>";
formObj.ioc_cd.value     = "<%=event.getConditionVO().getIocCd()%>";
formObj.pol_cd.value     = "<%=event.getConditionVO().getPolCd()%>";
formObj.pod_cd.value     = "<%=event.getConditionVO().getPodCd()%>";
formObj.ofc_cd.value     = "<%=event.getConditionVO().getOfcCd()%>";
var tr = mainInfo.rows(1);
tr.cells(0).innerText = formObj.trd_cd.value;
tr.cells(1).innerText = formObj.sub_trd_cd.value;
tr.cells(2).innerText = formObj.rlane_cd.value;
tr.cells(3).innerText = formObj.dir_cd.value;
tr.cells(4).innerText = formObj.week.value;
tr.cells(5).innerText = formObj.vsl_cd.value + formObj.skd_voy_no.value + formObj.skd_dir_cd.value;
tr.cells(6).innerText = formObj.ioc_cd.value;
tr.cells(7).innerText = formObj.pol_cd.value;
tr.cells(8).innerText = formObj.pod_cd.value;
<%}%>
</script>