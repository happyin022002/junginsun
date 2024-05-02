<%
/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : schedule.jsp
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2008.12.26
*@LastModifier : 정인선
*@LastVersion : 1.0
* 2008.12.26 정인선
* 1.0 최초 생성
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.syscommon.management.alps.schedule.event.ScheduleEvent"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	ScheduleEvent  event = null;					//PDTO(Data Transfer Object including Parameters)
	GeneralEventResponse eventResponse = null;	//RDTO(Data Transfer Object including DB ResultSet)
	Exception serverException   = null;				//서버에서 발생한 에러
	DBRowSet rowSet	  = null;						//DB ResultSet
	String strErrMsg = "";							//에러메세지
	int rowCount	 = 0;							//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.TestSample.sample");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (ScheduleEvent)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}else{
			eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");
			if (eventResponse != null) {
				rowSet = eventResponse.getRs();
				if(rowSet != null){
					 rowCount = rowSet.getRowCount();
				} // end if
			} // end if
		} // end else
	}catch(Exception e) {
		out.println(e.toString());
	}
	
	String today = DateTime.getFormatString("yyyyMMdd");
	String beforeOneMonth = DateTime.addMonths(today, -1);
%>
<html>
<head>
<title>Batch Program Search</title>
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
<form name="form">
<input	type="hidden" name="f_cmd"> 
<input type="hidden" name="pagerows"> 
<input type="hidden" name="s_pgm_tp_cd" value="00">
<input type="hidden" name="s_pgm_mnu_div_cd" value="02">

<table width="500" class="popup" cellpadding="10">
<tr><td class="top"></td></tr>
<tr><td valign="top">
		<!-- : ( Title ) (S) -->
		<table border="0">
		<tr><td height="79" class="title"><img src="img/icon_title_dot.gif" align="absmiddle"> Program Search</td></tr>
		</table>
		<!-- : ( Title ) (E) -->

		<!-- TABLE '#D' : ( Button : Main ) (S) -->
		<table width="100%" class="button">
       	<tr><td class="align">
			<table width="100%" class="button">
				<tr>
				<td class="btn2_bg">
					<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td>
							<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
									<td class="btn2" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
									<td class="btn2_right"></td>
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
    	<!-- TABLE '#D' : ( Button : Main ) (E) -->
    	
			<!-- TABLE '#D' : ( Search Options ) (S) -->
			<table class="search">
				<tr>
					<td class="bg">
						<!-- : ( Year ) (S) -->
						<table class="search" border="0">
							<tr class="h23">
								<td width="15%">Program No</td>
								<td width="20%"><input type="text" name="s_pgm_no" dataformat="engup" onKeyPress="javascript:ComKeyOnlyAlphabet('uppernum','95');"></td>
								<td width="15%">Program Name</td>
								<td width="20%"><input type="text" name="s_pgm_nm"></td>
							</tr>
							
						</table>
						<!-- : ( Year ) (E) -->

						<table class="height_10"><tr><td></td></tr></table>
						<!-- : ( POR ) (S) -->
						<table height="100%" width="100%" id="mainTable">
		 	                <tr>
		 	                	<td>
		 	                		<script language="javascript">ComSheetObject('sheet1');</script>
		 	                	</td>
		 	                </tr>
						</table>
						<!-- : ( grid ) (E) -->
	
					</td>
				</tr>
			</table>
			<!-- TABLE '#D' : ( Search Options ) (E) -->
			<!-- ####### TABLE '#D' ::: 'RIGHT' FRAME (END) ####### -->
		</td>
	</tr>
</table>

<table class="height_10"><tr><td></td></tr></table>


<!-- : ( Button : Sub ) (S) -->
<table width="100%" class="button">
<tr><td class="popup">

		<table width="100%" class="button">
			<tr>
			<td class="btn3_bg">
				<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
								<td class="btn2" name="btn_ok">OK</td>
								<td class="btn2_right"></td>
							</tr>
						</table>
					</td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
								<td class="btn2" name="btn_close">Close</td>
								<td class="btn2_right"></td>
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
<!-- : ( Button : Sub ) (E) -->

</form>
</body>
</html>
 <%@include file="/bizcommon/include/common_alps.jsp"%>
<!-- body 끝 -->

