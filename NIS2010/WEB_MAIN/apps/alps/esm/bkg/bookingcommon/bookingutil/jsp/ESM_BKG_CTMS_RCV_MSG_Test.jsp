
<%
	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : ESM_BKG_CTMS_RCV_MSG_Test.jsp
	 *@FileTitle :  Customs Receive Message Test
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2017.07.18
	 *@LastModifier : 
	 *@LastVersion : 1.0
	 * 1.0 Creation
	 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page
	import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page
	import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	String strErrMsg = ""; //에러메세지 
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	boolean bBtn_Disabled = true;
	try {
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

	} catch (Exception e) {
		out.println(e.toString());
	}

%>	
<html>
<head>
<title> Query Execution</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body onLoad="setupPage();">
<div id="debug"></div>
<form name="form">
	<input type="hidden" name="f_cmd"> 
	<input type="hidden" name="pagerows"> 
<!-- OUTER - POPUP (S)tart -->
<table width="1000" class="popup" cellpadding="10" border="0">
	<tr>
		<td class="top"></td>
	</tr>
	<tr>
		<td valign="top"><!-- : ( Title ) (S) -->
		<table width="100%" border="0">
			<tr>
				<td class="title"><img src="./img/icon_title_dot.gif"
					align="absmiddle">&nbsp;BKG Customs Receive Message Test</td>
			</tr>
		</table>
		<!-- : ( Title ) (E) --> <!-- : ( Search Options ) (S) -->
			<table class="search"> 
       		<tr><td class="bg">
			
				<!-- : ( Grid ) (S) -->
				<table>
					<tr>
					    <td style="padding-right:10px"> </td>
						<td style="padding-right:20px">국가</td>
						<td style="padding-right:30px">
							<select name="cnt_cd" style="width:50">
		                       <option value="US">US</option>
		                       <option value="KR">KR</option>
		                       <option value="CA">CA</option>
	                        </select>
						</td>
						<td style="padding-right:20px">Commit YN</td>
						<td><select name="commit_yn">
                                <option value="N">No</option>
                                <option value="Y">Yes</option>
                           	</select>
						</td>
					</tr>
					<tr>
					<td style="height:5px"></td>
					</tr>
				</table>
				 
				<table class="grid2"> 
				<tr>
					<td class="tr2_head" width="150">Message</td>
					<td align="center"><textarea rows="30" style="width:100%" name="flat_file" wrap="hard"></textarea></td>
				</tr>
				<tr>
					<td class="tr2_head">Result</td>
					<td align="left" >
						<div id='result' style="padding:5 10 5 10;width: 900px;height:100px;border-right:#000000 1px; border-top: #000000 1px;z-index:1;visibility: visible;overflow: auto;border-left: #000000 1px;border-bottom: #000000 1px;" >
						</div>
					</td>
					</tr>
				</table> 
				<!-- : ( Grid ) (E) -->	
		    <!-- : ( Button : Grid ) (E) -->	
			
			</td></tr>
		</table>


		<!-- : ( Search Options ) (E) -->
		</td>
	</tr>
</table>

<table class="height_5"><tr><td></td></tr></table>
	
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

					<table width="100%" class="button" border="0" cellpadding="0"
						cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">
						<tr>
							<td class="btn3_bg">
									<table border="0" cellpadding="0" cellspacing="0">
										<tr>
											<td>
											<table width="100%" border="0" cellpadding="0" cellspacing="0"
												class="button">
												<tr>
													<td class="btn1_left"></td>
													<td class="btn1" name="btn_execute">Run Test</td>
													<td class="btn1_right"></td>
												</tr>
											</table>
											</td>										
											<td>
													<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
														<tr>
															<td class="btn1_left"></td>
															<td class="btn1" name="btn_Close">Close</td>
															<td class="btn1_right"></td>
														</tr>
													</table>
											</td>
										</tr>
									</table>
							<!--Button (E) --></td>
						</tr>
					</table>
			</td>
		</tr>
	</table>					
		<!-- : ( Button : pop ) (E) -->

<!-- 개발자 작업  끝 -->
</form>
<div style="display:none">
	<!-- Grid  (S) -->
	<table width="100%"  id="mainTable">
		<tr>
			<td width="100%">
				<script language="javascript">ComSheetObject('sheet1');</script>
			</td>
		</tr>
	</table>
	<!-- Grid (E) -->
</div>
</body>
</html>
