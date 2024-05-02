<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_FMS_0079.jsp
*@FileTitle  : E-mail / Print 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/18
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.event.EsmFms0079Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmFms0079Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Error from Server
	String strErrMsg = "";						//Error Message

	String strUsr_id  = "";
	String strUsr_nm  = "";
	String strUsr_eml = "";
	
	Logger log = Logger.getLogger("com.clt.apps.TimeCharterInOutAccounting.TCharterIOInvoice");
	
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
	String content = "";
	
	String mailFlg 		= StringUtil.xssFilter(request.getParameter("mailFlg"))==null?"":StringUtil.xssFilter(request.getParameter("mailFlg"));
	String tmpSubject 	= StringUtil.xssFilter(request.getParameter("subject"))==null?"":StringUtil.xssFilter(request.getParameter("subject"));
	String fileKey 		= StringUtil.xssFilter(request.getParameter("fileKey"));
	//CON : EMAIL for Contract
	if(mailFlg.equals("CON")) {
		subject = tmpSubject;
	} else {
		subject = tmpSubject + " from Opus";
		content = subject + " is sent from Opus, If you have question, please contact to <font color=blue><a href=mailto:chartering@opus.com>chartering@opus.com</a></font>.";
	}
	
	
%>
<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
<form name="form"> 
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="from" value="<%=strUsr_eml%>" id="from" />
<input type="hidden" name="carbonCopy" id="carbonCopy" />
<input type="hidden" name="blindCarbonCopy" id="blindCarbonCopy" />
<input type="hidden" name="title" value="<%=subject%>" id="title" />
<!-- input type="hidden" name="content" value="=content%>"-->
<input type="hidden" name="msg_ctnt" value="<%=content%>" id="msg_ctnt" />
<input type="hidden" name="fileKey" value="<%=fileKey%>" id="fileKey" />
<input type="hidden" name="argument" id="argument" />
<input type="hidden" name="template" id="template" />
<input type="hidden" name="contentYn" id="contentYn" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<h2 class="page_title"><span>E-mail / Print</span></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_new" 	id="btn_new">New</button><!--
		--><button type="button" class="btn_normal" name="btn_E-mail" 		id="btn_E-mail">E-mail Send</button><!--
		--><button type="button" class="btn_normal" name="btn_close"  		id="btn_close">Close</button>	
	</div>
	<!-- opus_design_btn(E) -->
	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->

<!-- opus_design_inquiry(S) -->
<div class= "wrap_search bg">
	<div class= "opus_design_inquiry">
		<table>
			<tbody>
				<colgroup>
					<col width="100px"/>
					<col width="*"/>
			    </colgroup>
				<tr>
					<th colspan="2" style="border:1px solid #B8D6F6">Enter E-mail address to send the receiver</th>
				</tr>	
				<tr>
					<th style="border:1px solid #B8D6F6">E-mail Address</th>
					<td style="border:1px solid #B8D6F6"><input type="text" style="width:310px;" class="noinput1" name="recipient" value="" readonly id="recipient" /><button type="button" id="btn_email" name="btn_email" class="input_seach_btn"></button></td>
				</tr>	
				<tr>
					<th style="border:1px solid #B8D6F6">E-mail Subject</th>
					<td style="border:1px solid #B8D6F6"><input type="text" style="width:340px;" class="noinput1" name="subject" value="<%=subject%>" id="subject" /> </td>
				</tr>
				<tr>
					<th style="border:1px solid #B8D6F6">E-mail Editor</th>
					<td style="border:1px solid #B8D6F6" class="noinput1" align="left">
						<select style="width:80px;" class="input"  id="font_style" name="font_style" onchange="chBlockStyle(this.value, 'fontName');" onblur='this.selectedIndex=0;TextEditor.focus();'>
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
						<select style="width:80px;" class="input" id="font_size" name="font_size" onchange="chBlockStyle(this.value, 'fontSize');" onblur='this.selectedIndex=0;'>
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
						<select style="width:80px;" class="input" id="font_color" name="font_color" onchange="chFontColor(this.value,'ForeColor')" onblur='this.selectedIndex=0;'>
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
						<select style="width:80px;" class="input" id="font_etc" name="font_etc" onchange="chSelectionCommand(this,this.value);" onblur='this.selectedIndex=0;TextEditor.focus();'>
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
				<tr id="i_edit" name="i_edit" style="display:;">
					<th style="border:1px solid #B8D6F6">E-mail Content</th>
					<td style="border:1px solid #B8D6F6"><iframe id="TextEditor" name="TextEditor" class="noinput1" oncontextmenu="return false" frameborder="0" marginwidth="0" marginheight="1" vspace="0" hspace="0" style="width:340px;height:100px; background-color: #ffffff;" border="0" onload="initEditor();"></iframe></td>
				</tr>
				<tr id="i_text" name="i_text" style="display:none;">
					<th style="border:1px solid #B8D6F6">E-mail Content</th>
					<td style="border:1px solid #B8D6F6"><textarea style="width:340px;height:98px;background-color: #ffffff;" class="noinput1" name="content" onkeydown="contentLen();"></textarea></td>
				</tr>
				<tr>
					<th style="border:1px solid #B8D6F6">E-mail Mode</th>
					<td align="left" style="border:1px solid #B8D6F6">
						<select style="width:80px;" class="input" name="email_mode" onchange="chMode(this.value);">
							<option value="E">EDIT</option>
							<option value="T">TEXT</option>
                    	</select>
                    <strong><span id="ctntCount"> 0</span></strong> Byte<strong>/ 1000</strong> Byte</td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<!-- opus_design_inquiry(E) -->

<!-- opus_design_grid(S) -->
<div class="wrap_result">
	<div class="opus_design_grid clear" >
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_rowAdd" 	id="btn_rowAdd">Row Add</button><!--
			--><button type="button" class="btn_normal" name="btn_rowDel" 	id="btn_rowDel">Row Del</button>
		</div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
<!-- opus_design_grid(E) -->


<!------- FileUpload Object Start -------->
<!-- opus_design_grid(S) -->
<div class="wrap_result" style="display:none">
	<div class="opus_design_grid clear" >
			<script type="text/javascript">ComUploadObject('upload1', '<=session.getId()%>');</script>
	</div>
</div>
<!-- opus_design_grid(E) -->
<!------- FileUpload Object End -------->	
</form>		