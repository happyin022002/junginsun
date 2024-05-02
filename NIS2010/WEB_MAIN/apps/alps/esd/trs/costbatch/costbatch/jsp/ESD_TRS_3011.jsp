<%--
/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESD_TRS_3011.jsp
*@FileTitle : Ocean Feeder Cost Batch Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2012-05-03
*@LastModifier : 
*@LastVersion : 1.0
===============================================================================
 History
 2012.05.03 변종건 [CHM-201217633] Ocean Feeder Cost Batch Creation 생성
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.trs.costbatch.costbatch.event.EsdTrs3011Event"%>
<%
	EsdTrs3011Event  event = null;							//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;						//서버에서 발생한 에러
	DBRowSet rowSet	  = null;							   	//DB ResultSet
	String strErrMsg = "";								 	//에러메세지
	int rowCount	 = 0;								  	//DB ResultSet 리스트의 건수
	String today = DateTime.getFormatString("yyyyMMdd");
	String userId="";
	String ofc_cd="";

	try {

	   SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   userId=account.getUsr_id();
	   ofc_cd=account.getOfc_cd();
	   //userAuth=account.getAuth();

		event = (EsdTrs3011Event)request.getAttribute("Event");

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		/*
		아래부분은 꼭 지켜주셔야 에러메세지가 정상적으로 전달이 됩니다.
		보시다시피 먼저 에러를 받고 에러가 아닐시에 EventResponse로 값을 전달하셔야 합니다.
		*/
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<html>
<head>
<title>Ocean Feeder Cost Batch Creation</title>
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


<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="rhq_cd" value="">
<input type="hidden" name="shq_flg" value="">


<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
	<tr>
		<td>
			<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr>
					<td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td>
				</tr>
				<tr>
					<td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td>
				</tr>
			</table>
			<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->


			<!-- TABLE '#D' : ( Button : Main ) (S) -->
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
		       	<tr>
		       		<td class="btn1_bg">
	
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<!-- Repeat Pattern -->
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" id="btn_retrieve" name="btn_retrieve">Retrieve</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" id="btn_batch" name="btn_batch">Batch Creation</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" id="btn_cost_tariff" name="btn_cost_tariff">Cost Tariff MGMT</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<!-- Repeat Pattern -->
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<!-- TABLE '#D' : ( Button : Main ) (E) -->
			
			<!-- TABLE '#D' : ( Search Options ) (S) -->
			<table class="search">
				<tr>
					<td class="bg">
						<table class="search_in" border="0">
							<tr class="h23">
								<td width="40">RHQ</td>
								<td width=""><script language="javascript">ComComboObject('combo_rhq', 1, 160, 1)</script></td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<!-- TABLE '#D' : ( Search Options ) (E) -->

			<table class="height_10"><tr><td></td></tr></table>

			<!-- TABLE '#D' : ( Gird BG Box ) (S) -->
			<div style="display:inline">
			<table class="search" border="0">
				<tr>
					<td class="bg">
						<!-- : ( Grid ) (S) -->
						<table width="100%" id="mainTable">
	                        <tr>
	                        	<td>
	                            	<script language="javascript">ComSheetObject('sheet1');</script>
	                        	</td>
	                        </tr>
	                    </table>
						<!-- : ( Grid ) (E) -->
					</td>
				</tr>
			</table>
			</div>
			<!-- TABLE '#D' : ( Grid BG Box ) (E) -->

		</td>
	</tr>
</table>
<!-- Outer Table (E)-->


</form>
</body>
</html>