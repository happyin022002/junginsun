<%
/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : VOP_OPF_0073.jsp
*@FileTitle : Vessel Not Operationally Ready Report Summary Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.12
*@LastModifier : 이병훈
*@LastVersion : 1.0
* 2015.05.12 이병훈
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
<%@ page import="com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.event.VopOpf0073Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.Date"%>

<%
	VopOpf0073Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	try {
		event = (VopOpf0073Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
	} catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Vessel Not Operationally Ready Report Summary Inquiry</title>
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

<body  onLoad="setupPage();">

<form name="form">
<!-- 기본 필수 hidden -->
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 업무용 hidden -->
<input type="hidden" name="now_date" value="<%=DateTime.getFormatDate(new Date(),"yyyy-MM-dd")%>">
<input type="hidden" name="intg_cd_id">
<input type="hidden" name="intg_cd_val_ctnt">

<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">	
	<tr>
		<td valign="top">
		
			<!--Page Title, Historical (S)-->
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
			</table>
			<!--Page Title, Historical (E)-->
			
			<!--Button (S) -->
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;">
       			<tr>
       				<td class="btn1_bg">
		    			<table border="0" cellpadding="0" cellspacing="0">
						    <tr>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_New">New</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_Retrieve">Retrieve</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_Down_Excel">Down Excel</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
    		<!--Button (E) -->
			<!--biz page (S)-->
			<table class="search"> 
       			<tr>
       				<td class="bg">
						<!-- biz_1  (S) -->
						<table class="search" border="0" style="width:979;"> 
							<tr class="h23">
								<td width="50">Period</td>
								<td width="900">
									<input type="text" name="from_date" style="width:80;" class="input" dataformat="ymd" maxlength="8" caption="From to Date">
									&nbsp;~&nbsp;
									<input type="text" name="to_date" style="width:80;" class="input" dataformat="ymd" maxlength="8" caption="From to Date">
									<img src="img/btns_calendar.gif" name="from_to_calendar" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
								</td>
							</tr>
						</table>
						<table class="search" border="0" style="width:979;">
							<tr class="h23">
								<td width="47">Vessel</td>
								<td width="100">
									<input name="vsl_cd" type="text" style="width:60;text-align:center;" class="input" required fullfill maxlength="4" dataformat="engup" style="ime-mode:disabled">
									<img src="img/btns_search.gif" name="btn_vslpop"  class="cursor" width="19" height="20" alt="" border="0" align="absmiddle">
								<td width="130">
									Kind
									&nbsp;
									<script language="javascript">ComComboObject('vnor_offh_knd_cd', 1, 90, 1);</script>
								</td>
								<td width="250">
									Type
									&nbsp;
									<script language="javascript">ComComboObject('vnor_offh_tp_cd', 1, 200, 1);</script>
								</td>
								<td width="350">
									Status
									&nbsp;
									<script language="javascript">ComComboObject('vnor_stup_sts_cd', 1, 150, 1);</script>
								</td>
							</tr>
						</table>
						<!-- biz_1  (E) -->		
				
					</td>
				</tr>
			</table>		
			
   			<table class="height_8"><tr><td></td></tr></table>
			<table class="search"> 
   				<tr>
   					<td class="bg">
       					<table class="search">
           					<tr>
           						<td>
									<!-- Grid  (S) -->
									<table width="100%"  id="mainTable">
										<tr>
											<td width="100%">
												<script language="javascript">ComSheetObject('sheet1');</script>
											</td>					
										</tr>
									</table>
									<table width="100%"  id="excelTable" style="display:none">
										<tr>
										     <td width="100%">
												<script language="javascript">ComSheetObject('sheet2');</script>
											</td>
										</tr>
									</table>
									<!-- Grid (E) -->
								</td>
							</tr>
						</table>

					</td>
				</tr>
			</table>
			<!--biz page (E)-->
			<table class="height_10"><tr><td></td></tr></table>
		</td>
	</tr>
</table>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>