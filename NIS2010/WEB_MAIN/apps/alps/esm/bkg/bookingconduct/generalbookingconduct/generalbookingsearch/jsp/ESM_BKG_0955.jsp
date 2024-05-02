<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0955.jsp
*@FileTitle : Booking History (B/L Data)
*Open Issues : ESM_BKG_0955 화면
*Change history :
*@LastModifyDate : 2009.08.14
*@LastModifier : 이남경
*@LastVersion : 1.0
* 2009.08.14 이남경
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event.EsmBkg0955Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0955Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
/*	
	int rowCount	   = 0;						//DB ResultSet 리스트의 건수	
	String successFlag = "";
	String codeList    = "";
	String pageRows    = "100";
	String strUsr_id   = "";
	String strUsr_nm   = "";
*/	
	Logger log = Logger.getLogger("com.hanjin.apps.GeneralBookingConduct.GeneralBookingSearch");
	
	try {	
/* 		
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
*/ 
		event = (EsmBkg0955Event)request.getAttribute("Event");		
		GeneralEventResponse eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Booking History - Detail View</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		}
		loadPage();
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="his_seq">
<input type="hidden" name="his_dtl_seq">
<!-- 개발자 작업	-->

<!-- OUTER - POPUP (S)tart -->
<table width="700" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Booking History - Detail View</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 
			<table class="search"> 
       		<tr><td class="bg">
			<table class="search" border="0" style="width:679;"> 
						<tr class="h23">
						<td width="80">Booking No.</td>
						<td width="120"><input type="text" style="width:100;" value="" class="input2" name="bkg_no" readonly></td>
						<td width="50">B/L No.</td>
						<td width="" colspan="5"><input type="text" style="width:100;" value="" class="input2" name="bl_no" readonly></td>
						</tr>
						<tr class="h23">
						<td width="">Item</td>
						<td width=""><input type="text" style="width:100;" value="" class="input2" name="his_cate_nm" readonly></td>
						<td width="">User Name</td>
						<td width="130"><input type="text" style="width:100;" value="" class="input2" name="cre_usr_id" readonly></td>
						<td width="40">Office</td>
						<td width="90"><input type="text" style="width:50;" value="" class="input2" name="office" readonly></td>
						<td width="30">Date</td>
						<td width=""><input type="text" style="width:122;" value="" class="input2" name="cre_dt" readonly></td>
						</tr>
			</table>
			<table class="height_5"><tr><td></td></tr></table>
				<table width="100%" class="grid2" id="mainTable"> 
				<tr class="tr2_head">
					<td width="">Now Read</td>
					<td width="">Previous</td>
				</tr>
				<tr align="center">
					<td><textarea cols="65" rows="11" class="textarea2" name="crnt_ctnt" readonly></textarea></td>
					<td><textarea cols="65" rows="11" class="textarea2" name="pre_ctnt"  readonly></textarea></td>
				</tr>
				</table> 
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->
</td></tr>
</table> 

<table class="height_5"><tr><td></td></tr></table>
	
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
            String bkgNo     = event.getBkgBlNoVO().getBkgNo();
            String blNo      = event.getBkgBlNoVO().getBlNo();
            String hisCateNm = event.getHisCateNm();
            String crntCtnt  = event.getCrntCtnt();
            String preCtnt   = event.getPreCtnt();
            String creUsrId  = event.getCreUsrId();
            String office    = event.getOffice();
            String creDt     = event.getCreDt();
        %>
        	var opener = window.dialogArguments;
	    		
            eval("bkg_no").value      = '<%=bkgNo%>';
            eval("bl_no").value       = '<%=blNo%>';
            eval("his_cate_nm").value = opener.getViewDetail('his_cate_nm');  
            eval("crnt_ctnt").value   = opener.getViewDetail('crnt_ctnt_org');  
            eval("pre_ctnt").value    = opener.getViewDetail('pre_ctnt_org');
            
            eval("cre_usr_id").value  = opener.getViewDetail('cre_usr_id');  
            eval("office").value      = opener.getViewDetail('office');  
            eval("cre_dt").value      = opener.getViewDetail('cre_dt');  
            
            eval("his_seq").value      = opener.getViewDetail('his_seq');  
            eval("his_dtl_seq").value      = opener.getViewDetail('his_dtl_seq');  
            
        <% } %>
       }
-->
</SCRIPT>
