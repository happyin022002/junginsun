<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : message.jsp
*@FileTitle : Message
*Open Issues :
*Change history :
*@LastModifyDate : 2009.01.02
*@LastModifier : 정인선
*@LastVersion : 1.0
* 2009.01.02 정인선
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
<%@ page import="com.hanjin.syscommon.common.messages.event.MessageEvent"%>
<%@ page import="com.hanjin.syscommon.common.messages.event.MessageEventResponse"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	MessageEvent  event = null;					//PDTO(Data Transfer Object including Parameters)
	MessageEventResponse eventResponse = null;
	Exception serverException   = null;
	DBRowSet rowSet	  = null;
	String strErrMsg = "";
	int rowCount	 = 0;
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String strUsr_id		= "";
	String strUsr_nm		= "";

	Logger log = Logger.getLogger("com.hanjin.apps.Message.Messages");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
		event = (MessageEvent)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}else{
			eventResponse = (MessageEventResponse)request.getAttribute("EventResponse");
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
%>
<html>
<head>
<title>Message</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="/hanjin/css/alps_contents.css" type="text/css" rel="stylesheet"/>

<script language="javascript">
	function setupPage(){
		var ids = '<%=request.getParameter("rcvrId")%>';
		var names = '<%=request.getParameter("rcvrNm")%>';
		var content = '<%=request.getParameter("msgCtnt")%>';
		if ( ids != 'null' && names != 'null' ) {
			document.form.rcvr_usr_id.value = ids;
			document.form.rcvr_usr_nm.value = names;
			document.form.msg_ctnt.value = content;
			loadPage(0);
		} else
			loadPage(1);
	}
</script>
</head>

<body  onLoad="setupPage();">

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="tabNum">
<input type="hidden" name="check">


<!-- OUTER - POPUP (S)tart -->
<table width="700" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- Tab ) (S) -->
     		<table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%> 
       		<tr><td width="100%">
						<script language="javascript">ComTabObject('tab1')</script>
						<!-- img src="/img/sub_tab.gif" alt="" width="998" height="23" border="0" -->
					</td></tr>
				</table>
		<!-- Tab ) (E) -->
		
<!--TAB 쪽지보내기 (S) -->
<div id="tabLayer" style="display:inline">		
		<!-- : ( Search Options ) (S) -->
			<table class="search"> 
       		<tr><td class="bg">
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">New Message</td></tr>
				</table>
				<table border="0" style="width:100%;"> 
					<tr class="h23">
						<td width="60" align="right">To.</td>
						<td width="450">
							<input type="text" style="width:450;" class="input2" value="" name="rcvr_usr_nm" required caption="To." readonly>							<input type="hidden" name="rcvr_usr_id"></td>
						<td width=""><table width="120" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_t1address">Address Search</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
					</tr>
					<tr class="h23">
						<td align="right">Content</td>
						<td colspan="2"><textarea style="width:600;height:370" name="msg_ctnt" onkeydown="contentLen();"></textarea></td>
					</tr>
					<tr class="h23">
						<td></td>
						<td>
						<table border="0" style="width:100%;">
							<tr>
							<td width="20%">
								<table width="90" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
								<td class="btn2" name="btn_send">Send</td>
								<td class="btn2_right"></td>
								</tr>
								</table>
							</td>
							<td width="80%"><input class="Trans" type="checkbox" name="kep_flg"/><font color="#6699cc">Save to Savedbox</font></td>
							</tr>
						</table>
						</td>
						<td class="sm" align="right"><strong><span id="ctntCount"> 0</span></strong> Byte<strong>/ 4000</strong> Byte</td>
					</tr>
				</table> 
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->
</div>
<!--TAB 쪽지보내기 (E) --> 



<!--TAB 받은쪽지함 (S) -->
<div id="tabLayer" style="display:none">
		<!-- : ( Search Options ) (S) -->
			<table class="search"> 
       		<tr><td class="bg">
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Inbox </td>
						<td width="72"><table width="70" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_t2reply">Reply</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td width="72"><table width="70" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_t2delete">Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td width="72"><table width="70" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_t2keep">Archive</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td></tr>
				</table>
				<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t2sheet1');</script>
						</td>
					</tr>
				</table> 				
				<!-- Grid  (E) -->
				<table class="height_5"><tr><td></td></tr></table>
				<table border="0" style="width:100%;">  
				<tr class="h23">
						<td> </td>
						<td colspan="3" class="sm" style="color:#6699cc;">Please archive important message to savedbox. before server delete expired message (default set to 30 days after the message arrives)</td>
					</tr>
				</table> 

				<table border="0" style="width:100%;">  
					<tr class="h23">
						<td colspan="2"><textarea style="width:100%;height:250" name="to_ctnt""></textarea></td>
					</tr>
				</table> 
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->
</div>
<!--TAB 받은쪽지함 (E) --> 



<!--TAB 보낸쪽지함 (S) -->
<div id="tabLayer" style="display:none">
		<!-- : ( Search Options ) (S) -->
			<table class="search"> 
       		<tr><td class="bg">
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Outbox</td>
						<td width="72"><table width="70" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_t3delete">Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td width="72"><table width="70" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_t3keep">Archive</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
					</tr>
				</table>
				<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t3sheet1');</script>
						</td>
					</tr>
				</table> 
				<!-- Grid  (E) -->
				<table class="height_5"><tr><td></td></tr></table>
				<table border="0" style="width:100%;">  
				<tr class="h23">
						<td> </td>
						<td colspan="3" class="sm" style="color:#6699cc;">Please archive important message to savedbox. before server delete expired message (default set to 30 days after the message arrives)</td>
					</tr>
				</table> 
				<table border="0" style="width:100%;">  
					<tr class="h23">
						<td colspan="2"><textarea style="width:100%;height:250" name="from_ctnt""></textarea></td>
					</tr>
				</table> 
			
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->
</div>
<!--TAB 보낸쪽지함 (E) --> 



<!--TAB 쪽지보관함 (S) -->
<div id="tabLayer" style="display:none">
		<!-- : ( Search Options ) (S) -->
			<table class="search"> 
       		<tr><td class="bg">
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Savedbox </td>
						<td width="72"><table width="70" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_t4reply">Reply</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td width="72"><table width="70" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_t4delete">Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
					</tr>
				</table>
				<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t4sheet1');</script>
						</td>
					</tr>
				</table> 				
				<!-- Grid  (E) -->
				<table border="0" style="width:100%;">  
				<tr class="h23">
						<td> </td>
						<td colspan="3" class="sm" style="color:#6699cc;"></td>
					</tr>
				</table> 
				<table border="0" style="width:100%;">  
					<tr class="h23">
						<td colspan="2"><textarea style="width:100%;height:250" name="archive_ctnt""></textarea></td>
					</tr>
				</table> 
			
			
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->
</div>
<!--TAB 쪽지보관함 (E) --> 





</td></tr>
</table> 

<table class="height_5"><tr><td></td></tr></table>
	
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="20">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close">Close</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
		</tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table>
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->


</form>

</body>
</html>
