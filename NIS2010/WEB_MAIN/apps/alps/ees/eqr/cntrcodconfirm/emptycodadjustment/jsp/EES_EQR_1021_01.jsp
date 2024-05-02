<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_EQR_6001_01.jsp
*@FileTitle : MTY COD Simulation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.31
*@LastModifier : 박광석
*@LastVersion : 1.0
* 2009.07.31 박광석
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
<%@ page import="com.hanjin.apps.alps.ees.eqr.cntrcodconfirm.emptycodadjustment.event.EesEqr1021Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesEqr1021Event  event = null;			//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
//	Logger log = Logger.getLogger("com.hanjin.apps.cntrcodconfirm.emptycodadjustment");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesEqr1021Event)request.getAttribute("Event");
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
<title>MTY COD Simulation</title>
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
<input type="hidden" name="week">
<input type="hidden" name="trade">
<input type="hidden" name="vvd">
<!-- 개발자 작업	-->

<table class="search" border="0" style="width:1630; background-color:#F3F2F8;"> 
<tr><td style="align:center;"> 

<table class="search" border="0"> 
<tr><td>

	<table class="search" border="0"> 
	<tr class="h23">													
		<td width="315">

			<!-- Grid  (S) -->
			<table width="100%"  id="mainTable"> 
			<tr>
					<td width="100%">
					<script language="javascript">ComSheetObject('sheet1');</script>
					</td>
			</tr>
			</table> 			

					<!-- Grid (E) -->
					<!--  Button_Sub (S) -->
					<table class="search" border="0" style="width:100%;"> 
					<tr><td>
						<table class="search" border="0" > 
						<tr class="h23">													
							<td width="80"  style="padding-top:3">Lane&nbsp;<input type="text" name="lane1" class="input" style="width:40" dataformat="engup" style="ime-mode:disabled" maxLength ="3"></td>
							<td>
							<!--  Button_Sub (S) -->
								<table width="70" class="button"> 
				       				<tr><td class="btn2_bg">
									<table border="0" cellpadding="0" cellspacing="0"><tr>
										<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn2_left"></td>
										<td class="btn2" name="btn_s1retrieve" >Search</td>
										<td class="btn2_right"></td>
										</tr>
										</table></td>
									</tr></table>
								</td></tr>
								</table>
							</td>
				    			<!-- Button_Sub (E) -->
						</tr>
						</table>
					</td>
					<td width="170" >
					<!--  
						<table width="170" class="button"> 
		       			<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0"><tr>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_s1add">R.Add</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_s1del">R.Del</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>
						</tr></table>
						</td></tr>
						</table>
					-->
					</td>
					</tr>
					</table>
	    		<!-- Button_Sub (E) -->
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
			<!-- Grid  (S) -->
			<table width="100%"  id="mainTable"> 
				<tr>
					<td width="100%">
					<script language="javascript">ComSheetObject('sheet6');</script>
					</td>
				</tr>
			</table> 
			<!-- Grid  (E) -->
		</td> 
		<td width="6"></td>
		<td width="315">
			<!-- Grid  (S) -->
			<table width="100%"  id="mainTable"> 
			<tr>
					<td width="100%">
					<script language="javascript">ComSheetObject('sheet2');</script>
					</td>
			</tr>
			</table> 			

					<!-- Grid (E) -->
					<!--  Button_Sub (S) -->
					<table class="search" border="0" style="width:100%;"> 
					<tr><td>
						<table class="search" border="0" > 
						<tr class="h23">													
							<td width="80" style="padding-top:3">Lane <input type="text" name="lane2" class="input" style="width:40" dataformat="engup" style="ime-mode:disabled" maxLength ="3"></td>
							<td>
							<!--  Button_Sub (S) -->
								<table width="70" class="button"> 
				       				<tr><td class="btn2_bg">
									<table border="0" cellpadding="0" cellspacing="0"><tr>
										<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn2_left"></td>
										<td class="btn2" name="btn_s2retrieve" >Search</td>
										<td class="btn2_right"></td>
										</tr>
										</table></td>
									</tr></table>
								</td></tr>
								</table>
							</td>
				    			<!-- Button_Sub (E) -->
						</tr>
						</table>
					</td>
					<td width="170" >
					<!--  
						<table width="170" class="button"> 
		       			<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0"><tr>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_s2add">R.Add</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_s2del">R.Del</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>
						</tr></table>
						</td></tr>
						</table>
						-->
					</td>
					</tr>
					</table>
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
			<!-- Grid  (S) -->
			<table width="100%"  id="mainTable"> 
				<tr>
					<td width="100%">
					<script language="javascript">ComSheetObject('sheet7');</script>
					</td>
				</tr>
			</table> 
			<!-- Grid  (E) -->
		</td> 
		<td width="6"></td>
		<td width="315">
			<!-- Grid  (S) -->
			<table width="100%"  id="mainTable"> 
			<tr>
					<td width="100%">
					<script language="javascript">ComSheetObject('sheet3');</script>
					</td>
			</tr>
			</table> 			

					<!-- Grid (E) -->
					<!--  Button_Sub (S) -->
					<table class="search" border="0" style="width:100%;"> 
					<tr><td>
						<table class="search" border="0" > 
						<tr class="h23">													
							<td width="80" style="padding-top:3">Lane&nbsp;<input type="text" name="lane3" class="input" style="width:40" dataformat="engup" style="ime-mode:disabled" maxLength ="3"></td>
							<td>
							<!--  Button_Sub (S) -->
								<table width="70" class="button"> 
				       				<tr><td class="btn2_bg">
									<table border="0" cellpadding="0" cellspacing="0"><tr>
										<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn2_left"></td>
										<td class="btn2" name="btn_s3retrieve" >Search</td>
										<td class="btn2_right"></td>
										</tr>
										</table></td>
									</tr></table>
								</td></tr>
								</table>
							</td>
				    			<!-- Button_Sub (E) -->
						</tr>
						</table>
					</td>
					<td width="170" >
					<!--  
						<table width="170" class="button"> 
		       			<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0"><tr>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_s3add">R.Add</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_s3del">R.Del</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>
						</tr></table>
						</td></tr>
						</table>
						-->
					</td>
					</tr>
					</table>
			<!-- Button_Sub (E) -->
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
			<!-- Grid  (S) -->
			<table width="100%"  id="mainTable"> 
				<tr>
					<td width="100%">
					<script language="javascript">ComSheetObject('sheet8');</script>
					</td>
				</tr>
			</table> 
			<!-- Grid  (E) -->
		</td> 
		
		<td width="6"></td>
		<td width="315">

			<!-- Grid  (S) -->
			<table width="100%"  id="mainTable"> 
			<tr>
					<td width="100%">
					<script language="javascript">ComSheetObject('sheet4');</script>
					</td>
			</tr>
			</table> 			

					<!-- Grid (E) -->
					<!--  Button_Sub (S) -->
					<table class="search" border="0" style="width:100%;"> 
					<tr><td>
						<table class="search" border="0" > 
						<tr class="h23">													
							<td width="80" style="padding-top:3">Lane&nbsp;<input type="text" name="lane4" class="input" style="width:40" dataformat="engup" style="ime-mode:disabled" maxLength ="3"></td>
							<td>
							<!--  Button_Sub (S) -->
								<table width="70" class="button"> 
				       				<tr><td class="btn2_bg">
									<table border="0" cellpadding="0" cellspacing="0"><tr>
										<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn2_left"></td>
										<td class="btn2" name="btn_s4retrieve" >Search</td>
										<td class="btn2_right"></td>
										</tr>
										</table></td>
									</tr></table>
								</td></tr>
								</table>
							</td>
				    			<!-- Button_Sub (E) -->
						</tr>
						</table>
					</td>
					<td width="170" >
					<!--  
						<table width="170" class="button"> 
		       			<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0"><tr>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_s4add">R.Add</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_s4del">R.Del</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>
						</tr></table>
						</td></tr>
						</table>
						-->
					</td>
					</tr>
					</table>
			<!-- Button_Sub (E) -->
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
			<!-- Grid  (S) -->
			<table width="100%"  id="mainTable"> 
				<tr>
					<td width="100%">
					<script language="javascript">ComSheetObject('sheet9');</script>
					</td>
				</tr>
			</table> 
			<!-- Grid  (E) -->
		</td> 
		
		<td width="6"></td>
		<td width="315">

			<!-- Grid  (S) -->
			<table width="100%"  id="mainTable"> 
			<tr>
					<td width="100%">
					<script language="javascript">ComSheetObject('sheet5');</script>
					</td>
			</tr>
			</table> 			

					<!-- Grid (E) -->
					<!--  Button_Sub (S) -->
					<table class="search" border="0" style="width:100%;"> 
					<tr><td>
						<table class="search" border="0" > 
						<tr class="h23">													
							<td width="80" style="padding-top:3">Lane&nbsp;<input type="text" name="lane5" class="input" style="width:40" dataformat="engup" style="ime-mode:disabled" maxLength ="3"></td>
							<td>
							<!--  Button_Sub (S) -->
								<table width="70" class="button"> 
				       				<tr><td class="btn2_bg">
									<table border="0" cellpadding="0" cellspacing="0"><tr>
										<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn2_left"></td>
										<td class="btn2" name="btn_s5retrieve" >Search</td>
										<td class="btn2_right"></td>
										</tr>
										</table></td>
									</tr></table>
								</td></tr>
								</table>
							</td>
				    			<!-- Button_Sub (E) -->
						</tr>
						</table>
					</td>
					<td width="170" >
					<!--  
						<table width="170" class="button"> 
		       			<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0"><tr>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_s5add">R.Add</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_s5del">R.Del</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>
						</tr></table>
						</td></tr>
						</table>
						-->
					</td>
					</tr>
					</table>
	    		<!-- Button_Sub (E) -->
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
			<!-- Grid  (S) -->
			<table width="100%"  id="mainTable"> 
				<tr>
					<td width="100%">
					<script language="javascript">ComSheetObject('sheet10');</script>
					</td>
				</tr>
			</table> 
			<table width="100%"  id="mainTable"  style="display:none"> 
				<tr>
					<td width="100%">
					<script language="javascript">ComSheetObject('vvdTotal');</script>
					</td>
				</tr>
			</table> 
			<table width="100%"  id="mainTable"  style="display:none"> 
				<tr>
					<td width="100%">
					<script language="javascript">ComSheetObject('portTotal');</script>
					</td>
				</tr>
			</table> 
			<!-- Grid  (E) -->
		</td> 
		</tr>
		</table> 
		<!--<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>-->
	<!--  Grid_button (S) -->
	<!--  biz_1  (S) -->

	<!--  biz_1   (E) -->
		</td>
	</tr>
	</table> 	
</td>
</tr> 
</table>	

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>