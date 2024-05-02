<%
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_SCE_0035.jsp
*@FileTitle : COP POPUP
*Open Issues :
*Change history :
*@LastModifyDate : 2007-04-04
*@LastModifier : Yong-cheon Shin
*@LastVersion : 1.0
* 2007-04-04 Yong-cheon Shin
* 2007-04-25 Yong-cheon Shin 요건 변경(Unplaned)
* 1.0 최초 생성
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.copmanage.copsearch.event.EsdSce0009Event"%>
<%//@ page import="com.hanjin.apps.alps.esd.sce.copmanage.copsearch.event.EsdSce0009EventResponse"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%
    EsdSce0009Event         event           = null;    //PDTO(Data Transfer Object including Parameters)
    //EsdSce0009EventResponse eventResponse   = null;    //RDTO(Data Transfer Object including DB ResultSet)
    Exception                serverException = null;    //서버에서 발생한 에러
    DBRowSet                 rowSet          = null;    //DB ResultSet
    String strErrMsg = "";  //에러메세지
    int rowCount	 = 0;

	try {

		event = (EsdSce0009Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
	

%>
<html>
<head>
<title>Supply Chain Event Management</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body onload="selectCompleted();">
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="cop_no" value="<%=event.getCOPReplanInfoVO().getCopNo()%>">
<input type="hidden" name="bkg_no" value="<%=event.getCOPReplanInfoVO().getBkgNo()%>">
<input type="hidden" name="cop_sts_cd" value="<%=event.getCOPReplanInfoVO().getCopStsCd()%>">
<input type="hidden" name='bound_name' value='O'>
<input type="hidden" name='iscompled'  value='Y'>
<input type="hidden" name='isnodchg'  value='N'>
<input type="hidden" name='isfrmchg'  value='N'>

<!-- OUTER - POPUP (S)tart -->
<table width="400" class="popup" cellpadding="10">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
			<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp;COP Manual Replan Option</td></tr>
		</table>
		<!-- : ( Title ) (E) -->




		<!-- TABLE '#D' : ( Search Options : Speed ) (S) -->
     	<table class="search">
       	<tr><td class="bg">


				<table class="search" border="0" style="width:380;">
						<tr class="h23">
						<td class="stm">
							<table border="0" style="height:15; width:98%;background-color: #E9E9E9;">
							<tr>
							<td>
							<input type="radio" name="comm_choice"  class="trans" value="N" onClick="selectCompleted();" Checked>Planned Route Only
							</td>
							<td width="50%">
							<input type="radio" name="comm_choice" value="Y"  class="trans" onClick="selectCompleted();" >Include Completed Route
							</td>
							</tr>
							</table>
							</td>
						</tr>
						<tr>
						</tr>
						<tr class="h23">
							<td class="stm">
								<table border="0" style="height:15; width:98%;background-color: #E9E9E9;">
									<tr>
										<td>
										<span id='radioSelect1'>
										</span>
										</td>
										<td width="50%">
										<span id='radioSelect2'>
										</span>
										</td>
									</tr>
								</table>
								<table border="0" style="height:15; width:98%;background-color: #E9E9E9;">
									<tr>
										<td>
										<span id='radioSelect3'>
										</span>
										</td>
										<td width="50%">
										<span id='radioSelect4'>
										</span>
										</td>
									</tr>
								</table>
							</td>
						 </tr>

					</table>



			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options : Speed ) (E) -->




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

