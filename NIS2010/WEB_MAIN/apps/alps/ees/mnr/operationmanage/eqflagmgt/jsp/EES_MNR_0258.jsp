<%
/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EES_MNR_0258.jsp
*@FileTitle : Hanger Rack/Bar Using Report Pop Up
*Open Issues :     
*Change history :  
*@LastModifyDate : 2012.01.04
*@LastModifier : 
*@LastVersion : 1.0
* 2012.01.04 신혜정   
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
<%@ page import="com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.event.EesMnr0258Event" %>
<%@ page import="org.apache.log4j.Logger" %>

<%

	EesMnr0258Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	 
	Logger log = Logger.getLogger("com.hanjin.apps.OperationManage.eqflagmgt");
	//팝업용 데이타			 	
	String mnrHngrRckCd = ((request.getParameter("mnrHngrRckCd")==null )?"":request.getParameter("mnrHngrRckCd"));
	String mnrHngrTrfCd = ((request.getParameter("mnrHngrTrfCd")==null )?"":request.getParameter("mnrHngrTrfCd"));
	String yearMonth = ((request.getParameter("yearMonth")==null )?"":request.getParameter("yearMonth"));
	String location = ((request.getParameter("location")==null )?"":request.getParameter("location"));
	String pLocTp = ((request.getParameter("pLocTp")==null )?"":request.getParameter("pLocTp"));
	String pLocCd = ((request.getParameter("pLocCd")==null )?"":request.getParameter("pLocCd"));
	String fromDate = ((request.getParameter("fromDate")==null )?"":request.getParameter("fromDate"));
	String toDate = ((request.getParameter("toDate")==null )?"":request.getParameter("toDate"));
	String eqTpszCd = ((request.getParameter("eqTpszCd")==null )?"":request.getParameter("eqTpszCd"));

	try {     
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		
		event = (EesMnr0258Event)request.getAttribute("Event"); 
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
<title></title>
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
<input type="hidden" name="mnr_hngr_rck_cd" value="<%=mnrHngrRckCd%>">
<input type="hidden" name="mnr_hngr_trf_cd" value="<%=mnrHngrTrfCd%>">
<input type="hidden" name="year_month" value="<%=yearMonth%>">
<input type="hidden" name="location" value="<%=location%>">
<input type="hidden" name="p_loc_tp" value="<%=pLocTp%>">
<input type="hidden" name="p_loc_cd" value="<%=pLocCd%>">
<input type="hidden" name="from_date" value="<%=fromDate%>">
<input type="hidden" name="to_date" value="<%=toDate%>">
<input type="hidden" name="eq_tpsz_cd" value="<%=eqTpszCd%>">
 
<input type="hidden" name="f_cmd">

<table width="990" class="popup" cellpadding="10" border="0"> 
	<tr>
		<td class="top"></td>
	</tr>
	<tr>
		<td valign="top">
			<table width="100%" border="0">
				<tr>
					<td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Hanger Rack/Bar Using Report Pop Up</td>
				</tr>
			</table>
 			
			<table class="search" > 
       			<tr>
       				<td class="bg">
						<table width="100%"  id="mainTable" > 
							<tr>	
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet1');</script>
								</td>
							</tr>
						</table>
						<table width="100%" class="button" >
					    	<tr>
					    		<td class="btn2_bg">
						        	<table border="0" cellpadding="0" cellspacing="0">
						        		<tr>
						            		<td>
						            			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					            					<tr><td class="btn2_left"></td>
					            						<td class="btn2" name="btn_downexcel">Down Excel</td>
					            						<td class="btn2_right"></td>
					            					</tr>
					            				</table>
					            			</td>
					          			</tr>
					          		</table>
					      	 	</td>
					      	</tr>
						</table>						
		</td>
	</tr>
</table>
<table class="height_5" >
	<tr><td></td>
	</tr>
</table>
	
<table width="100%" class="sbutton">
	<tr>
		<td height="35" class="popup">
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
    		   	<tr>
    		   		<td class="btn3_bg">
		   				<table border="0" cellpadding="0" cellspacing="0">
		   					<tr>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_close">Close</td>
											<td class="btn1_right">
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
		
</form>			
			
</body>
</html>
