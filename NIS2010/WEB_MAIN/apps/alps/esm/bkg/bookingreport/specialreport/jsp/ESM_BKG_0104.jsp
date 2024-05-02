
<%
	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : ESM_BKG_0104.jsp
	 *@FileTitle : Report Template
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2009.05.13
	 *@LastModifier : 김경섭
	 *@LastVersion : 1.0
	 * 2009.05.13 김경섭
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingreport.specialreport.event.EsmBkg0104Event"%>	
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg0104Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	boolean bBtn_Disabled = true;
	Logger log = Logger.getLogger("com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0104Event) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException)
					.loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request
				.getAttribute("EventResponse");

	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Welcome to alps!</title>
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

<body class="popup_bg" onLoad="setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
		

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="./img/icon_title_dot.gif" align="absmiddle">&nbsp;Report Template</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 			<!--biz page-1 (S)-->
		<table class="search"> 
       	<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table width="800" class="search"> 
					<tr class="h23">
						<td width="80">Report kind</td>
						<td width=""><select style="width:180;" name="p_bkg_rpt_knd_cd">
						<option value="B" <%=JSPUtil.getNull(request.getParameter("p_bkg_rpt_knd_cd")).equals("B")?"selected":""%>>Booking Status Report</option>
						<option value="L" <%=JSPUtil.getNull(request.getParameter("p_bkg_rpt_knd_cd")).equals("L")?"selected":""%>>B/L Status Report</option>
						<option value="V" <%=JSPUtil.getNull(request.getParameter("p_bkg_rpt_knd_cd")).equals("V")?"selected":""%>>VIP Customer Report</option>
						</select></td>
					</tr>
				</table> 
				<!--  biz_1   (E) -->
				<table class="height_2"><tr><td></td></tr></table>
				<!-- : ( Grid ) (S) -->
					<table width="100%"  id="mainTable"> 
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet1');</script>
							</td>
						</tr>
					</table> 
				<!-- : ( Grid ) (E) -->	
				<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_RowAdd">Row&nbsp;Add</td>
						<td class="btn2_right"></td>
						
						<!--<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
								<td class="btn2" name="btn_RowCopy">Row Copy</td>
								<td class="btn2_right"></td>						
						</tr>
						</table></td>
						<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_Save">Save</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						-->
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_RowDelete">Row Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
			
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->
</td></tr>
</table> 

<table class="height_5"><tr><td></td></tr></table>
	
	</td></tr>
</table> 
	<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

    	<!--Button (S) -->	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	    <tr><td class="btn3_bg">
		            <table border="0" cellpadding="0" cellspacing="0">
		              <tr>
		                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					          <tr><td class="btn1_left"></td>
					            <td class="btn1" name="btn_Save">Save</td>
					             <td class="btn1_right"></td>
				              </tr>
				            </table>
				        </td>	
			            <td class="btn1_line"></td>		
			            <td class="btn3_bg">
		                   <table border="0" cellpadding="0" cellspacing="0">
		                      <tr><td>
		                             <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					                    <tr><td class="btn1_left"></td>
					                        <td class="btn1" name="btn_Close">Close</td>
					                        <td class="btn1_right"></td>
				                        </tr>
				                     </table>
				                  </td>	
			                  </tr>
		                   </table>
		                </td>
		              </tr>
		            </table>
		    </td></tr>
		</table>
    	<!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->

			
</form>
</body>
</html>
<%@include file="../../../../../../../bizcommon/include/common_alps.jsp"%>