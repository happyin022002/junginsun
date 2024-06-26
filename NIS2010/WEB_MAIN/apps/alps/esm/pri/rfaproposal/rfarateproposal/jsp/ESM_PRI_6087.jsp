<%
/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESM_PRI_6087.jsp
*@FileTitle : RFA Proposal/Amendment Surcharge View All
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.21
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2010.04.21 송민석
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
<%@ page import="com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.event.EsmPri6087Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri6087Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String prop_no		= null;
	String amdt_seq = null;
	String svc_scp_cd = null;
	
	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.RFAProposal.RFARateProposal");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmPri6087Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		prop_no		= JSPUtil.getParameter(request,"prop_no");
		amdt_seq		= JSPUtil.getParameter(request,"amdt_seq");
		svc_scp_cd =  JSPUtil.getParameter(request,"svc_scp_cd");
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>RFA Proposal/Amendment Surcharge View All</title>
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
<!-- 개발자 작업	-->

<input type="hidden" name="prop_no" value="<%=prop_no%>">
<input type="hidden" name="amdt_seq" value="<%=amdt_seq%>">
<input type="hidden" name="svc_scp_cd" value="<%=svc_scp_cd%>">




<!-- OUTER - POPUP (S)tart -->
<table width="1000" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Surcharge View All</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 
			<table class="search"> 
       		<tr><td class="bg">
			
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="600">
						<table class="search_sm2" border="0" style="width:570;"> 
							<tr class="h23">
								<td width="130">&nbsp;View Items(Include)</td>
								<td class="stm"><input type="checkbox" value="APP_ROUT" name="view_items" class="trans" checked>Applicable Route(For est.schg)&nbsp;&nbsp;<input type="checkbox" value="CMDT_NOTE" name="view_items" class="trans" >Commodity Note&nbsp;&nbsp;<input type="checkbox" value="ROUT_NOTE" name="view_items" class="trans" >Route Note</td>
							</tr>	
						</table>
					</td>
 
					</tr>	
				</table>
				
				
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="100%"  align=right class="stm"><span id="access_text"></span></td>
					
				</tr>	
				</table>				
				
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
						<td class="btn2" name="btn2_Retrieve">Retrieve</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						 
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn2_DownExcel">Down Excel</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>							
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
			
						<table class="height_5"><tr><td colspan="8"></td></tr></table>
		
			
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="80" valign="TOP">Remarks</td>
					<td class="SM">
&raquo; Surcharge data comes from [Calculate] button click that is being used to check estimated profitability at the time of RFA request.<BR>
    &nbsp;&nbsp;&nbsp;Due to this, estimated surcharge data can be different from auto-rating.<BR>
&raquo; Since this surcharge data has been generated at the time of RFA request, non-revenue surcharge or undefined surcharge is excluded from the list.<BR>
    &nbsp;&nbsp;&nbsp;Ex) Non-revenue surcharge(taxable surcharge)- AST, GST, VDT, VTT, WHF,etc<BR>
         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Undefined surcharge at the time of contract creation- WSC<BR><BR>
&raquo; Applicable route (For est.surcharge): When calculating estimated profitability, the fastest one among possible route cases based on the PRD(Product catalogue) will be applicable.<BR>
    &nbsp;&nbsp;&nbsp;In case you want to change applicable route, you can change it from [Cost Detail] screen. Then, applicable route for surcharge will be changed automatically.<BR>
&raquo; If surcharge is adjusted when calculating, surcharge amount in "Contract" column will differ from one in "Tariff" column.<BR>
					</td>
				</tr>	
				</table>

					
			
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->

	</td></tr>
		</table>
<!-- : ( Button : pop ) (S) -->


<table class="height_5"><tr><td></td></tr></table>

<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
			
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_Close">Close</td>
					<td class="btn1_right"></td>
					</table>
			</td>
		</tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>