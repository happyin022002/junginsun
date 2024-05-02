<%/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EES_EQR_1031.jsp
*@FileTitle : Guideline Mailing
*Open Issues :
*Change history :
*@LastModifyDate : 2014.01.08
*@LastModifier : 신용찬
*@LastVersion : 1.0
* 2013.08.22 신용찬
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.eqr.cntrplanguide.cntrplanguidelineemail.event.EesEqr1031Event"%>
<%@ page import="com.hanjin.apps.alps.ees.eqr.cntrplanguide.cntrplanguidelineemail.vo.EesEqr1031ConditionVO"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesEqr1031Event  event      = null;			//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	String pageRows  = "100";


	try {
		event = (EesEqr1031Event)request.getAttribute("Event");
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
<title>Guideline Mailing</title>
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

	<!--  Mail Sending 에서 인식하는 value (중요) -->
	<input type="hidden" name="com_from" 			value="">
	<input type="hidden" name="com_fromName" 		value="">
	<input type="hidden" name="com_recipient" 		value="">
	<input type="hidden" name="com_carbonCopy" 		value="">
	<input type="hidden" name="com_blindCarbonCopy" value="">
	<input type="hidden" name="com_subject" 		value="">
	<input type="hidden" name="com_fileKey" 		value="">
	<input type="hidden" name="com_content" 		value="">		
	<!-- input type="hidden" name="com_smtp" 			value="203.246.130.40" -->

	<!-- OUTER - POPUP (S)tart -->
	<table width="500" class="popup" cellpadding="10">
		<tr><td class="top"></td></tr>
		<tr><td valign="top">
			<!-- : ( Title ) (S) -->
			<table width="100%" border="0">
				<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp;Guideline Mailing</td></tr>
			</table>
			<!-- : ( Title ) (E) -->			

			<!-- TABLE '#D' : ( Button : Main ) (S) -->
			<!-- TABLE '#D' : ( Button : Main ) (E) -->
			
			<!-- TABLE '#D' : ( Search Options ) (S) -->
			<table class="search">
				<tr>
					<td class="bg">
	
					<!-- : ( Scenario ID ) (S) -->
					<table class="search" border="0" style="width:400;">
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
					<tr class="h23">
						<td colspan=5>&nbsp;</td>
					</tr>
					<tr class="h23">
						<td colspan=5>&nbsp;</td>
					</tr>
					
					</table>
					<!-- : ( Scenario ID ) (E) -->
	
				</td></tr>
			</table>
			<!-- TABLE '#D' : ( Search Options ) (E) -->

			<table class="height_10">
				<tr>
					<td>
		        	        <table width="100%" id="mainTable" >
		        				<tr>
		        					<td>
			        				   <script language="javascript">ComSheetObject('sheet1');</script> <!-- ETC 데이터 조회를 위해서만 사용함 -->
			        				</td>
			        			</tr>
		        			</table>					
					</td>
				</tr>
			</table>


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
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr>
										<td class="btn1_left"></td>
										<td class="btn1" name="btn_mailsend" id="btn_mailsend" onClick="javascript:emailSend();">Send Mail</td>
										<td class="btn1_right"></td>
									</tr>
									</table>
								</td>			    				
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr>
										<td class="btn1_left"></td>
										<td class="btn1" name="btn_close" id="btn_close" onClick="javascript:closeWindow();">Close</td>
										<td class="btn1_right"></td>
									</tr>
									</table>
								</td>
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