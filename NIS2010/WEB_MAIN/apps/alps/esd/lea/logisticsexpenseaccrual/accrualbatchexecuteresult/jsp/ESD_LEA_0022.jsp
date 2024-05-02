<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_LEA_0022.jsp
*@FileTitle : Monthly Budget Creation
*Open Issues :
*Change history : 
*@LastModifyDate : 2015.04.08
*@LastModifier : KIM HYUN HWA
*@LastVersion : 1.0
* 2015.04.08 KIM HYUN HWA
* 1.0 Creation
*
* 2015.11.11 김현화 [CHM-201538864]블라디보스톡 Combo Box 추가 관련- VVOIA RHQ 추가
*=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.event.EsdLea0022Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdLea0022Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String main_page = "";
	main_page = JSPUtil.getParameter(request, "main_page".trim(), "");
	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.LogisticsExpenseAccrual.AccrualBatchExecuteResult");

	String exeYY 	= "";
	String param_name = null;


	exeYY = DateTime.addYears(JSPUtil.getKST("yyyy-mm-dd"),-1,"yyyy-mm-dd").substring(0, 4);
	
	java.util.Enumeration enums = request.getParameterNames();
	while (enums.hasMoreElements()){
	param_name = (String)enums.nextElement();
	}

	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsdLea0022Event)request.getAttribute("Event");
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
<title>Monthly Budget Creation</title>
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
<%if(main_page.equals("true")){ %>
<body  onLoad="javascript:setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>
	<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
		 
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title">Monthly Budget Creation</span></td></tr>
		</table>
    <!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->
   		<!--Button_L (S) -->
		<table width="850" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
	       	<tr><td class="btn1_bg">
				<table border="0" cellpadding="0" cellspacing="0">
				<tr>
				<!-- Repeat Pattern -->
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td><td class="btn1" id="btn_retrieve" name="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td><td class="btn1" id="btn_create" name="btn_create">Creation</td><td class="btn1_right"></td></tr></table></td>
				<td class="btn1_line"></td>										
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">				
					<tr><td class="btn1_left"></td><td class="btn1" id="btn_save" name="btn_save">Save</td><td class="btn1_right"></td></tr></table></td>					
				<!-- Repeat Pattern -->
				</tr></table>
			</td></tr>
		</table>
		<!--Button_L (E) -->
<%} else { %>
<body class="popup_bg" onLoad="javascript:setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->

<!-- Outer Table (S)-->
<table class="popup" cellpadding="5"  width="800" border="0">
<tr><td class="top" ></td></tr>
<tr><td valign="top" width="800">
	
		<!-- : ( Title ) (S) -->
		<table width="800" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Monthly Budget Creation</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
<%} %>		

		<!-- TABLE '#D' : ( Search Options ) (S) -->
     	<table class="search"  border="0" >
       	<tr><td class="bg">
				<!-- : ( Year ) (S) -->
				<table class="search_in" border="0" style="width:800;">
				<tr class="h23">
					<td width="5">&nbsp;</td>
					<td width="60">Exe.Year</td>
					<td width="100"><input type="text" style="width:60;" class="input1" name="bse_yr"  value="<%=exeYY%>" onKeyUp="lea_comm_isNumberMessage(this,4)"></td>
				<td width="30"></td>
				<td width="40">RHQ</td>
				<td width="85">
					<SELECT style="width:70;" name="rhq_cd" class="input1">
					<OPTION value="">ALL</OPTION>
					<OPTION value="HAMRU">HAMRU</OPTION>
                    <OPTION value="NYCRA">NYCRA</OPTION>
                    <OPTION value="SHARC">SHARC</OPTION>
                    <OPTION value="SINRS">SINRS</OPTION>
					<OPTION value="SELIB">SELIB</OPTION>
					<OPTION value="TYOIB">TYOIB</OPTION>
					<OPTION value="VVOIA">VVOIA</OPTION>
					</SELECT>
				</td>
				<td width="300"></td>
				</tr>
				</table>
				<!-- : ( Year ) (E) -->
			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->
		<table class="height_10"><tr><td></td></tr></table>
		<!-- TABLE '#D' : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg">
				<!-- : ( Seq. ) (S) -->
				<table width="850" id="mainTable">
				       <tr><td>
				           <script language="javascript">ComSheetObject('sheet1');</script>
				       </td></tr>
				</table>
				<!-- : ( Seq. ) (E) -->
		
				<!--  Button_Sub (S) -->
				<table width="850" class="button">

			       	<tr>	
			       		<td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
			                      <tr>
			                        <td class="btn2_left"></td>
			                        <td class="btn2" id="btn_Load_Excel" name="btn_Load_Excel">Excel Upload(ReSet)</td>
			                        <td class="btn2_right"></td>
			                      </tr>
			                    </table>
			                </td>

							
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2" id="btn_downexcel" name="btn_downexcel">Down Excel</td><td class="btn2_right"></td></tr></table></td>	
							<!-- Repeat Pattern -->
					</tr>
					</table>
				</td></tr>
				</table>
		    	<!-- Button_Sub (E) -->
			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->
</td></tr>
</table>
<!-- Outer Table (E)-->
<%if(!main_page.equals("true")){ %>
<!-- : ( Button : Sub ) (S) -->
<table width="850" class="sbutton">
<tr><td height="71" class="popup">

		<table width="850" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn_create" id="btn_create">Creation</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn_save" id="btn_save">Save</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
					</td>					
					<td class="btn1_line"></td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn_close">Close</td>
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
<%}%>
<!-- : ( Button : Sub ) (E) -->
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>