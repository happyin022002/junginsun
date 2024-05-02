<%--
/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESD_AOC_3001.jsp
*@FileTitle : Inland Cost Batch Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.05
*@LastModifier : 
*@LastVersion : 1.0
* --------------------------------------------------------
* History
* 2015.03.06 최성환 [CHM-201534710] AOC 2차 소스 보안 품질 진행 요청 
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.aoc.costbatch.costbatch.event.EsdAoc3001Event"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>

<%
	EsdAoc3001Event  event = null;							//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;						//서버에서 발생한 에러
	DBRowSet rowSet	  = null;							   	//DB ResultSet
	String strErrMsg = "";								 	//에러메세지
	int rowCount	 = 0;								  	//DB ResultSet 리스트의 건수
	String today = DateTime.getFormatString("yyyyMMdd");
	String userId="";
	String ofc_cd="";
	
	String rhqCd = "";

	try {
		rhqCd = ((StringUtil.xssFilter(request.getParameter("rhq_cd"))==null)?"":StringUtil.xssFilter(request.getParameter("rhq_cd")));
		
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   	userId=account.getUsr_id();
	   	ofc_cd=account.getOfc_cd();
	   	//userAuth=account.getAuth();

		event = (EsdAoc3001Event)request.getAttribute("Event");

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
<title>Inland Cost Batch Creation</title>
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
								<td width="100"><input name="rhq_cd" type="text" style="width:50;" class="input2" value="<%=rhqCd%>" readOnly></td>
								<td width="60">Country</td>
								<td width="250">
									<input name="cnt_cd" type="text" dataformat="engupcomma" style="width:150;">
									<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_country">
									<img class="cursor" src="/hanjin/img/button/btns_multisearch.gif" width="19" height="20" border="0" align="absmiddle"  onClick="so_OnPopupClick('Country');">
								</td>
								<td width="50">Bound</td>
								<td width="100">
									<select name="io_bnd_cd" style="width:50;">
										<option value="" selected>All</option>
										<option value="I">In</option>
										<option value="O">Out</option>
									</select></td>
								<td width="50">Status</td>
								<td width=""><script language="javascript">ComComboObject('combo_sts', 1, 200, 1)</script></td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<!-- TABLE '#D' : ( Search Options ) (E) -->

			<table class="height_10"><tr><td></td></tr></table>

			<!-- TABLE '#D' : ( Gird BG Box ) (S) -->
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
	
	
						<!-- : ( Button_ Sub ) (S) -->
						<table width="100%" class="button">
					       	<tr>
					       		<td class="btn2_bg">
									<table border="0" cellpadding="0" cellspacing="0">
										<tr>
	
											<!-- Repeat Pattern -->
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left" id="btn_rebatch_l"></td>
														<td class="btn2_3" id="btn_rebatch" name="btn_rebatch">Re-Batch</td>
														<td class="btn2_right" id="btn_rebatch_r"></td>
													</tr>
												</table>
											</td>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" id="btn_downexcel" name="btn_downexcel">Down Excel</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
				
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" id="btn_batch" name="btn_batch">Batch Creation</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
											
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" id="btn_batch_cancel" name="btn_batch_cancel">Batch Creation Cancel</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
											
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" id="btn_cfm" name="btn_cfm">Confirm</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
											
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" id="btn_cfm_cancel" name="btn_cfm_cancel">Confirm Cancel</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
				
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" id="btn_cost_tariff" name="btn_cost_tariff">Cost Tariff MGMT</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
											<!-- Repeat Pattern -->
	
										</tr>
									</table>
								</td>
							</tr>
						</table>
						<!-- : ( Button_ Sub ) (E) -->
					</td>
				</tr>
			</table>
			<!-- TABLE '#D' : ( Grid BG Box ) (E) -->

		</td>
	</tr>
</table>
<!-- Outer Table (E)-->

<div id="tabLayer" style="display:none">
	<table class="search" id="mainTable"> 
      	<tr><td class="bg">	
			<table width="100%"  id="mainTable">
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet2');</script>
					</td>
				</tr>
			</table>
		</td></tr>
	</table>
</div>

</form>
</body>
</html>