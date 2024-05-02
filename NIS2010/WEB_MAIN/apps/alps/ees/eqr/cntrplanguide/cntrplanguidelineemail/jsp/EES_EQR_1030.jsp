<%
/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : EES_EQR_1030.jsp
 *@FileTitle : Empty Repo Guideline Email
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : YONGCHAN SHIN
 *@LastVersion : 1.0
 * 2013.01.06 YONGCHAN SHIN
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
<%@ page import="com.hanjin.apps.alps.ees.eqr.cntrplanguide.cntrplanguidelineemail.event.EesEqr1030Event"%>
<%@ page import="com.hanjin.apps.alps.ees.eqr.cntrplanguide.cntrplanguidelineemail.vo.EesEqr1030ConditionVO"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesEqr1030Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);

		event = (EesEqr1030Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		EesEqr1030ConditionVO conditionVO = new EesEqr1030ConditionVO();
		conditionVO = event.getEesEqr1030ConditionVO();

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
<title>Guideline Recipient Set-up</title>
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
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="setupPage();">
<form method="post" name="form" onSubmit="return false;">
	<input	type="hidden" name="f_cmd">
	
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
												<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
												<td class="btn1_right"></td>
											</tr>
										</table>
									</td>
									<td>
										<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr>
												<td class="btn1_left"></td>
												<td class="btn1" name="btn_new" id="btn_new">New</td>
												<td class="btn1_right"></td>
											</tr>
										</table>
									</td>
									<td>
										<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr>
												<td class="btn1_left"></td>
												<td class="btn1" name="btn_save" id="btn_save">Save</td>
												<td class="btn1_right"></td>
											</tr>
										</table>
									</td>	
									<td>
										<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr>
												<td class="btn1_left"></td>
												<td class="btn1" name="btn_downexcel" id="btn_downexcel">Down Excel</td>
												<td class="btn1_right"></td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
		    	<!-- TABLE '#D' : ( Button : Main ) (E) -->
		        <!-- TABLE '#D' : ( Search ) (S) -->
		        <table class="search" border="0">
					<tr>
		                <td class="bg">
		                    <table class="search_in" border="0">
								<tr class="h23">
									<td width="80">RHQ Office</td>								
									<td width="70">
									   <!-- CHM-201537079, 2015-08-10, 신용찬, 표준코드 변환, NYCNA-NYCRA, SHAAS-SHARC, SINWA-SINRS, HAMUR-HAMRU -->
                    					<select style="width:70;" class="input" name="f_rhqcd">
                        				<option value="" selected>ALL</option>
                        				<option value="NYCRA" >NYCRA</option>                        
                        				<option value="HAMRU" >HAMRU</option>    
                        				<option value="SHARC" >SHARC</option>    
                        				<option value="SINRS" >SINRS</option>    
                        				<option value="OTHER" >Others</option>    
                        				</select>									
                        			</td>
									<td width="25">&nbsp;</td>
									<td width="80">Office Code</td>
									<td class="input">
									    <input type="text" class="input" name="f_ofccd" caption="Office" onKeyUp="upperCase_Num()" size="10" maxlength="10" fulfill size="10" style="width:100;" value="" >
										<img class="cursor" src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" name="btns_open_ofc">
									</td>
								</tr>
		                    </table>
		                </td>
		            </tr>
		        </table>
	        	<!-- TABLE '#D' : ( Search ) (E) -->
				<table class="height_10"><tr><td></td></tr></table>
				<table class="search" border="0">
					<tr>
						<td class="bg">
							<!-- : ( Grid ) (S) -->
							<!-- 'HEAD1-BGCOLOR : 203 240 169' , 'HEAD2-BGCOLOR : 222 251 248' , 'BORDER 1-outside : 88 152 164' ,'BORDER 2-inside : 202 226 233' , 'HEAD-FONT : 39 95 101' , 'SELETED ROW BG : 252 255 233' -->
		        	        <table width="100%" id="mainTable" >
		        				<tr>
		        					<td>
			        				   <script language="javascript">ComSheetObject('sheet1');</script>
			        				</td>
			        			</tr>
		        			</table>
							<!-- : ( Grid ) (E) -->
		        			<!-- : Space (S) -->
		        			<table class="height_5">
		        				<tr>
		        					<td>
		        					</td>
		        				</tr>
		        			</table>
		        			<!-- : Space (E) -->
							<!-- TABLE '#D' : ( Button : Sub ) (S) -->
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
															<td class="btn1" name="btn_row_add" id="btn_row_add">Row Add</td>
															<td class="btn1_right"></td>
														</tr>
													</table>
												</td>								
												<!-- td>
													<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
														<tr>
															<td class="btn1_left"></td>
															<td class="btn1" name="btn_row_del" id="btn_row_del">Row Delete</td>
															<td class="btn1_right"></td>
														</tr>
													</table>
												</td-->
											</tr>
										</table>
									</td>
								</tr>
							</table>
					    	<!-- TABLE '#D' : ( Button : Sub ) (E) -->
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</form>
</body>
</html>