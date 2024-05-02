<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_PRI_6080.jsp
*@FileTitle : Surcharge Adjust-Commodity
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.08
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2009.07.08 송민석
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
<%@ page import="com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.event.EsmPri6080Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri6080Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.scquotation.scratequotation");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmPri6080Event)request.getAttribute("Event");
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
<title>Surcharge Adjust-Commodity</title>
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
<input type="hidden" name="service_code">
<input type="hidden" name="prop_no" >
<input type="hidden" name="amdt_seq" >
<input type="hidden" name="svc_scp_cd"  >

<!-- OUTER - POPUP (S)tart -->
<table width="900" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Surcharge Adjust- Commodity </td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
	
	
	
		<table class="search"> 
       		<tr><td class="bg">	
			
		
				
				<table class="search">
					<tr>
						<td width="350" valign="top">
						<table class="search" border="0">
							<tr><td class="title_h"></td>
							<td class="title_s">Commodity Code</td></tr>
						</table>
						<!--grid (s)-->
						<table width="100%"  id="mainTable"> 
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet1');</script>
								</td>
							</tr>
						</table>
						<!--grid(E)-->
						
						</td>
						<td width="49" align="center"><img src="img/btn_add.gif" width="26" height="26" alt="" border="0" align="absmiddle">&nbsp;</td>	
						<td width="" valign="top">
						<table class="search" border="0">
							<tr><td class="title_h"></td>
							<td class="title_s">Commodity Group Detail</td></tr>
						</table>
						<!--grid (s)-->
						<table width="100%"  id="mainTable"> 
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet2');</script>
								</td>
							</tr>
						</table>
						<!--grid(E)-->
						
						</td>
					</tr>
		</table>					
		
		<table class="search" >
		<tr>
						<td  >
							<table class="height_5"  ><tr><td ></td></tr></table>
							<table class="search" border="0" style="width:100%;"> 
							<tr class="h23">
								<td width="80" valign="TOP">Remark(s)</td>
								<td class="SM" width=""  valign="top">&raquo; In case of adjusting surcharge by commodity code, please click
	    one on the list of commodity code.<br>
	&raquo; If you click any group code in commodity code, commodity group 
	    detail will be displayed for your reference only.
	    						</td>
							</tr>	
							</table>							
						</td>
					</tr>					
					
				</table>
				
			</td></tr>
		</table>
  

</td></tr></table>
<table class="height_5"><tr><td></td></tr></table>
</td></tr></table>
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
					<td class="btn1" name="btn1_OK">OK</td>
					<td class="btn1_right"></td></tr></table></td>
					<td class="btn1_line"></td>
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_Close">Close</td>
					<td class="btn1_right">
				</tr></table></td>
			</tr>
		</table></td>
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