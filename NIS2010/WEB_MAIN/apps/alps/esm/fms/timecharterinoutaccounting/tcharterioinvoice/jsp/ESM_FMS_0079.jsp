<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_FMS_0079.jsp
*@FileTitle : E-mail / Print
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.29
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.04.29 정윤태
* 2009.06.30 최우석
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
<%@ page import="com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.event.EsmFms0079Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmFms0079Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지

	String strUsr_id  = "";
	String strUsr_nm  = "";
	String strUsr_eml = "";
	
	Logger log = Logger.getLogger("com.hanjin.apps.TimeCharterInOutAccounting.TCharterIOInvoice");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id  = account.getUsr_id();
		strUsr_nm  = account.getUsr_nm();
		strUsr_eml = account.getUsr_eml();
	   
	   
		event = (EsmFms0079Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
	}catch(Exception e) {
		log.error(e.getMessage(),e);
	}
	
	String subject = "";
	String fileKey = "";
	String content = "";
	String csrNo = "";
	
	String mailFlg = request.getParameter("mailFlg")==null?"":request.getParameter("mailFlg");
	
	//CON : 계약용 EMAIL
	if(mailFlg.equals("CON")) {
		subject = JSPUtil.replaceForHTML(request.getParameter("subject"));
	} else {
		//subject = JSPUtil.replaceForHTML(request.getParameter("subject")) + " from Hanjin";
		//content = subject + " is sent from Hanjin, If you have question, please contact to <font color=blue><a href=mailto:chartering@hanjin.com>chartering@hanjin.com</a></font>.";
		subject = JSPUtil.replaceForHTML(request.getParameter("subject")) + " from SM Line Corporation";
		//content = subject + " is sent from SM Line Corporation, If you have question, please contact to <font color=blue><a href=mailto:seladg@smlines.com>seladg@smlines.com</a></font>.";
	    content = subject + " is sent from SM Line Corporation. If you have any question, please feel free to contact to <font color=blue><a href=mailto:selctf@smlines.com>selctf@smlines.com</a></font>.";
	}
	
	fileKey = JSPUtil.replaceForHTML(request.getParameter("fileKey"));
	csrNo =  JSPUtil.replaceForHTML(request.getParameter("csrNo"));
%>

<html>
<head>
<title>E-mail / Print</title>
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


<body class="popup_bg" onLoad="setupPage();"> 
<form name="form"> 
<input type="hidden" name="f_cmd">

<input type="hidden" name="from" value="<%=strUsr_eml%>">
<input type="hidden" name="carbonCopy">
<input type="hidden" name="blindCarbonCopy">
<input type="hidden" name="title" value="<%=subject%>">
<!-- input type="hidden" name="content" value="=content%>"-->
<input type="hidden" name="msg_ctnt" value="<%=content%>">
<input type="hidden" name="fileKey" value="<%=fileKey%>">
<input type="hidden" name="argument">
<input type="hidden" name="template">
<input type="hidden" name="contentYn">
<input type="hidden" name="csrNo" value="<%=csrNo%>">

<!-- OUTER - POPUP (S)tart -->
<table width="500" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;E-mail / Print </td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 
			<table width="100%" class="grid2"> 
				<tr class="tr2_head">
					<td colspan="3">Enter E-mail address to send the receiver</td>
				</tr>
				<tr class="tr2_head2">
					<td width="150">E-mail Address</td>
					<!--<td width="%" class="noinput1"><input type="text" style="width:100%;" class="noinput1" name="recipient" value="<%=strUsr_eml%>"></td>-->
					<td width="380" class="noinput1"><input type="text" style="width:100%;" class="noinput1" name="recipient" value="" readonly></td>
					<td><img class="cursor" src="img/btns_search.gif" name="btn_email" width="19" height="20" alt="" border="0" align="absmiddle"></td>
				</tr>
				<tr class="tr2_head2">
					<td>E-mail Subject&nbsp;</td>
					<td colspan="2" class="noinput1"><input type="text" style="width:100%;" class="noinput1" name="subject" value="<%=subject%>"></td>
				</tr>
				<tr class="tr2_head2">
					<td>E-mail Editor&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td colspan="2" class="noinput1" align="left">
					<select style="width:67;" class="input" name="font_style" onchange="chBlockStyle(this.value, 'fontName');" onblur='this.selectedIndex=0;TextEditor.focus();'>
						<option value>글꼴</option>
						<option value>------------</option>
						<option value='굴림'>굴림</option>
						<option value='궁서'>궁서</option>
						<option value='돋움'>돋움</option>
						<option value='바탕'>바탕</option>
						<option value='Arial'>Arial</option>
						<option value='Arial Black'>Arial Black</option>
						<option value='Courier New'>Courier New</option>
						<option value='Impact'>Impact</option>
						<option value='Verdana'>Verdana</option>
						<option value='Webdings'>Webdings</option>
						<option value='Wingdings'>Wingdings</option>
                    </select>
                    <select style="width:53;" class="input" name="font_size" onchange="chBlockStyle(this.value, 'fontSize');" onblur='this.selectedIndex=0;'>
						<option value>크기</option>
						<option value>------------</option>
						<option value='1'>1</option>
						<option value='2'>2</option>
						<option value='3'>3</option>
						<option value='4'>4</option>
						<option value='5'>5</option>
						<option value='6'>6</option>
						<option value='7'>7</option>
                    </select>
					<select style="width:60;" class="input" name="font_color" onchange="chFontColor(this.value,'ForeColor')" onblur='this.selectedIndex=0;'>
						<option value>글자색</option>
						<option value>------------</option>
						<option value>기본색</option>
						<option value='white'>흰색</option>
						<option value='gray'>회색</option>
						<option value='#ffff90'>연노랑</option>
						<option value='#ffffcf'>베이지</option>
						<option value='#cf9000'>황토색</option>
						<option value='maroon'>적갈색</option>
						<option value='#ff9000'>주황색</option>
						<option value='red'>빨간색</option>
						<option value='#9090ff'>연보라</option>
						<option value='#902fcf'>보라색</option>
						<option value='#cfffff'>하늘색</option>
						<option value='#6666FF'>파란색</option>
						<option value='#2fff2f'>연두색</option>
						<option value='green'>녹색</option>
						<option value='black'>검정색</option>
                    </select>
                    <select style="width:77;" class="input" name="font_etc" onchange="chSelectionCommand(this,this.value);" onblur='this.selectedIndex=0;TextEditor.focus();'>
						<option value>기타</option>
						<option value>------------</option>
						<option value='Bold'>볼드체</option>
						<option value='Italic'>이탤릭체</option>
						<option value='Underline'>언더라인</option>
						<option value='JustifyLeft'>좌측정렬</option>
						<option value='JustifyCenter'>가운데정렬</option>
						<option value='JustifyRight'>우측정렬</option>
						<option value='InsertOrderedList'>숫자목록</option>
						<option value='InsertUnOrderedList'>점표시목록</option>
						<option value='Indent'>들여쓰기 늘임</option>
						<option value='Outdent'>들여쓰기 줄임</option>
						<option value='CreateLink'>HyperLink</option>
						<option value='cut'>자르기</option>
						<option value='copy'>복사</option>
						<option value='paste'>붙여넣기</option>
                    </select>
					</td>
				</tr>
				<tr class="tr2_head2" id="i_edit" style="display:;">
					<td>E-mail Content</td>
					<td colspan="2" class="noinput"><iframe id='TextEditor' oncontextmenu='return false' frameborder='0' marginwidth='0' marginheight='1' vspace='0' hspace='0' style='width:100%;height:100;' border="0" onload="initEditor();" onfocus="chLineHeight();"></iframe></td>
				</tr>
				<tr class="tr2_head2" id="i_text" style="display:none;">
					<td>E-mail Content</td>
					<td colspan="2" class="noinput"><textarea style="width:100%;height:98;" class="noinput" name="content" onkeydown="contentLen();"></textarea></td>
				</tr>
				<tr class="tr2_head2">
				<td>E-mail Mode</td>
				<td colspan="2" class="sm" align="left">
					<select style="width:58;" class="input" name="email_mode" onchange="chMode(this.value);">
						<option value="E">EDIT</option>
						<option value="T">TEXT</option>
                    </select>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <strong><span id="ctntCount"> 0</span></strong> Byte<strong>/ 1000</strong> Byte</td>
				<!-- td colspan="3" class="sm" align="right"><strong><span id="ctntCount"> 0</span></strong> Byte<strong>/ 1000</strong> Byte</td-->
				</tr> 
			</table> 
			<!-- Grid (E) -->
			<table width="100%"  id="mainTable"> 
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet1');</script>
					</td>
				</tr>
			</table>
			<!--  Grid_button (S) -->
            <table width="100%" class="button"> 
            <tr><td class="btn2_bg">
                <table border="0" cellpadding="0" cellspacing="0">
                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn2_left"></td>
                        <td class="btn2" name="btn_rowAdd">Row&nbsp;Add</td>
                        <td class="btn2_right"></td>
                        </tr>
                        </table></td>
                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn2_left"></td>
                        <td class="btn2" name="btn_rowDel">Row&nbsp;Del</td>
                        <td class="btn2_right"></td>
                        </tr>
                        </table></td>
                </table>
            </td></tr>
            </table>
            <!-- Grid_button (E) -->

<!-- : ( Search Options ) (E) -->
	<table class="height_5"><tr><td></td></tr></table>
</td></tr>
</table> 
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right"></td>
				</tr></table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_E-mail">E-mail Send</td>
					<td class="btn1_right"></td>
				</tr></table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close">Close</td>
					<td class="btn1_right">
				</tr></table></td></td>
				</tr>
        </table></td>
			</tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->

<!------- FileUpload Object Start -------->
<table width="100%"> 
	<tr>
		<td width="100%">
			<script language="javascript">ComUploadObject('upload1', '<=session.getId()%>');</script>
		</td>
	</tr>
</table>
<!------- FileUpload Object End -------->	
</form>		
</body>
</html>