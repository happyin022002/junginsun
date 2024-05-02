<%
/*=========================================================
*@FileName : BCM_CCD_2004.jsp
*@FileTitle : MDM History
*Open Issues : BCM_CCD_2004 화면
*Change history :
*@LastModifyDate : 2018.03.06
*@LastModifier : Lim Jin Young
*@LastVersion : 1.0 
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.bcm.ccd.commoncode.mstmgmt.event.BcmCcd2004Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	BcmCcd2004Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지

 	int rowCount	   = 0;						//DB ResultSet 리스트의 건수	
	String successFlag = "";
	String codeList    = "";
	String pageRows    = "100";
	String strUsr_id   = "";
	String strUsr_nm   = ""; 

	Logger log = Logger.getLogger("com.hanjin.apps.bcm/cms/custmanageCustManageSC");
	
	try {	
 		
 	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm(); 
 
		event = (BcmCcd2004Event)request.getAttribute("Event");		
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		GeneralEventResponse eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Booking History</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>

<script language="javascript">
	function setupPage(){
<%-- 		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} --%>
		loadPage();
	}
</script>
</head>

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<!-- 개발자 작업	-->
<input type="hidden" name="com_mrdPath"      value="">
<input type="hidden" name="com_mrdArguments" value="">
<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">


 	<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
    <!-- page_title(S) -->
     	<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
   	<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"> MDM History</td></tr>
	</table>
	<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->
    
		<!-- : ( Title ) (E) -->
		    <!--Button (S) -->
		    
	<table class="search" id="mainTable"> 
     <tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:989;"> 
				<tr class="h23">
					<td width="83">Table Name</td>
					<td width="160"><input type="text" style="width:120; text-align:center;" class="input2" name="tbl_nm" value="" readonly ></td>
					<td width="83">Master Key</td>
					<td width=""><input type="text" style="width:120; text-align:center;" class="input2" name="mst_key" value=""  readonly></td>			
				</tr> 
				</table>					
				<!--  biz_1   (E) -->
				
						<!-- Tab ) (S) -->
     		<table class="tab" border="0" cellpadding="0" cellspacing="0" width="100%" HEIGHT="25"> 
       		<tr><td width="100%">
					</td></tr>
				</table>
		<!-- Tab ) (E) --> 
<!--MDM Data (S) -->
				<div id="tabLayer" style="display:inline">
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t1sheet1');</script>
						</td>
					</tr>
				</table>
</div>
<!--MDM Data (E) -->
<!--TAB Documentation (E) -->

		</td></tr></table>
		<!--biz page (E)--> 
<table class="height_5"><tr><td></td></tr></table>
</td></tr></table>


	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
    	<!--Button (S) -->	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_print">Print</td>
					<td class="btn1_right"></td>
				</tr></table></td>	
			<td class="btn1_line"></td>		
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close">Close</td>
					<td class="btn1_right"></td>
				</tr></table></td>				
			</tr>
		</table></td>				
			</tr>
		</table>
    	<!--Button (E) -->	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->

<!-- RD (S) -->
<table>
    <tr>
      <td height="1" width="1">
          <script language="javascript">comRdObject('report1');</script>
      </td>
   </tr>	
</table>
<!-- RD (E) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>

<SCRIPT LANGUAGE="javascript">
<!--
      /* 
       * 유저가 입력한 정보를 event를 통해서 다시 넘겨받아 화면에 뿌려주는 부분
       */
      with(document.form)
      {
        <%
        if(event != null){ 
            String tblNm = event.getSearchMdmHistListVO().getTblNm();
            String mstKey = event.getSearchMdmHistListVO().getMstKey();
   
        %>
            eval("tbl_nm").value = "<%=tblNm%>"; 
            eval("mst_key").value = "<%=mstKey%>"; 
        <% } %>
       }
-->
</SCRIPT>
