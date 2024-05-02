<html>
<script language="javascript" type="text/javascript" src="/hanjin/syscommon/common/fckeditor/ckeditor.js"></script>
<script language="javascript" type="text/javascript" src="../script/UI_email_02.js"></script>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.core.config.SiteConfigFactory"%>
<%@ page import="java.io.BufferedReader"%>
<%@ page import="java.util.List"%>
<%@ page import="com.hanjin.framework.component.util.io.FileUtils"%>
<%@ page import="com.hanjin.syscommon.common.mail.vo.MailCustomVO"%>
<%@ page import="com.hanjin.framework.component.util.CheckUtils"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
 
<%
	String content = null;
	MailCustomVO mailCustomVO = null;
	String mailKey = "";
	if (request.getAttribute("EventResponse") != null) {
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		content = (String) eventResponse.getCustomData("templateContent");
		mailCustomVO = (MailCustomVO) eventResponse.getCustomData("mailCustomVO");
		mailKey = (String) eventResponse.getETCData("mailKey");
	}
	
	//업무에서 올라온 파일키를 공통 메일창에 설정하기
	String fileInformations = JSPUtil.getParameter(request, "com_fileKey");
	String[] arrayFileInformation = null;
	if(!CheckUtils.isNullAndNullString(fileInformations)){
		arrayFileInformation = fileInformations.split(";");
	}
%>
<head>
<title>Welcome to ALPS!</title>
</head>

<body class="popup_bg" onload="checkKey()">
<form name="formMail"><!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;e-Mail</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!--biz page (S)-->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">	
				<!-- Grid  (S) -->
				<table width="100%" class="grid2">
					<tr>
						<td class="tr2_head" width="12%">From</td>
						<td colspan="2"><textarea name="com_from" style="width: 100%;hight:20; text-align: left;" class="noinput"><%=StringUtil.xssFilter(request.getParameter("com_from"))%></textarea></td>
					</tr>
					<tr>
						<td class="tr2_head">TO</td>
						<td colspan="2"><textarea name="com_recipient" style="width: 100%;hight:20; text-align: left;" class="noinput"><%=StringUtil.xssFilter(request.getParameter("com_recipient"))%></textarea></td>
					</tr>
					<tr>
						<td class="tr2_head">CC</td>
						<td colspan="2"><textarea name="com_carbonCopy" style="width: 100%;hight:20; text-align: left;" class="noinput"><%=StringUtil.xssFilter(request.getParameter("com_carbonCopy"))%></textarea></td>
					</tr>
					<tr>
						<td class="tr2_head">BCC</td>
						<td colspan="2"><textarea name="com_blindCarbonCopy" style="width: 100%;hight:20; text-align: left;" class="noinput"><%=StringUtil.xssFilter(request.getParameter("com_blindCarbonCopy"))%></textarea></td>
					</tr>
					<tr>
						<td class="tr2_head" width="12%">Subject</td>
						<td colspan="2"><textarea name="com_subject" style="width: 100%;hight:20; text-align: left;" class="noinput"><%=StringUtil.xssFilter(request.getParameter("com_subject"))%></textarea></td>
					</tr>

					<tr>
						<td class="tr2_head" width="12%">Attach</td>
						<td width="10%">
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn2_left" style="border: 0 !important; padding: 0 !important;"></td>
								<td class="btn2" name="btn_Attach" style="border: 0 !important; padding: 0 !important;">Attach</td>
								<td class="btn2_right" style="border: 0 !important; padding: 0 !important;"></td>
							</tr>
						</table>
						</td>						
						<td width="78">
						<span  id="userAttachFile" style="width:530;height:20;overflow:auto">
						<%
						StringBuffer loopBuf = new StringBuffer();
						if(arrayFileInformation != null) {
							if(!CheckUtils.isNull(arrayFileInformation)){
								for(int i=0;i<arrayFileInformation.length;i++){
									String fileInformation = arrayFileInformation[i];
									String lastFileNameInformation = "NoName";
									String lastFileInformation = "";
									if(fileInformation.contains("<")){
										String[]  oneFileInfomation = fileInformation.split("<");
										lastFileInformation =  oneFileInfomation[0];
										lastFileNameInformation = oneFileInfomation[1];
									} else{
										lastFileInformation = fileInformation;
									}
									out.print("<input type=\"button\" name=\"fileInfoDelButton"+i+"\" value=\"Del\" onclick=\"deletePreFileInfo("+i+")\">");
									out.print("<input type=\"button\" name=\"fileInfo"+i+"\" value=\""+lastFileNameInformation+"\">");
									out.print("<input type=\"hidden\" name=\"fileInfoObj"+i+"\" value=\""+lastFileInformation+"\">");
									loopBuf.append(i).append(";");
								}
							}
						}
						String loopFile = loopBuf.toString();
						out.print("<input type=\"hidden\" name=\"com_PreFileForLoop\" value=\""+loopFile+"\">");
						%>
						</span>
						</td>
					</tr>
					<tr>
						<td class="tr2_head" width="12%">Report<br>
						Attach</td>
						<td colspan="2">
						<%
							int i = 0;
							if (mailCustomVO != null) {
								for(String templateMrd:mailCustomVO.getTemplateMrd()){
									out.print("<input type=\"checkbox\" name=\"reportFileCheckBox"+i+"\" checked=\"true\" onclick=\"changeStatusReportFileButton("+i+")\">");
									out.print("<input type=\"button\" name=\"reportFileButton"+i+"\" value=\"" + mailCustomVO.getRdExportFileName().get(i) + "\" onclick=\"setReportMeta("+i+");ComOpenRDPopupModal('dialogWidth:750px;dialogHeight:690px')\">");
									out.print("<input type=\"hidden\" name=\"com_mrdPath"+i+"\" value=\""+mailCustomVO.getTemplateMrd().get(i)+"\">");
									out.print("<input type=\"hidden\" name=\"com_mrdArguments"+i+"\" value=\""+mailCustomVO.getTemplateMrdArguments().get(i)+"\">");
									out.print("<input type=\"hidden\" name=\"com_rdExportFileName"+i+"\" value=\""+mailCustomVO.getRdExportFileName().get(i)+"\">");
									out.print("<input type=\"hidden\" name=\"com_rdExportFileType"+i+"\" value=\""+mailCustomVO.getRdExportFileType().get(i)+"\">");
									out.print("<input type=\"hidden\" name=\"com_reportForLoop\">");
									i++;
								}
							}
						%>
						</td>
					</tr>
				</table>
				<textarea class="ckeditor" name="com_content" id="com_content"><%=content == null ? "" : content%></textarea> <!-- Grid  (E) --></td>
			</tr>
		</table>
		<table class="height_5">
			<tr>
				<td></td>
			</tr>
		</table>
		<!-- : ( Search Options ) (E) -->
		
		</td>
	</tr>
</table>

			

<!-- : ( Button : Sub ) (S) -->
<table width="100%" class="sbutton">
	<tr>
		<td height="71" class="popup">

		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">
			<tr>
				<td class="btn3_bg">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
					<td>
						<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" onclick="doMail()">Send</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td class="btn1_line"></td>
						<td>
						<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_Close">Close</td>
								<td class="btn1_right"></td>
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
<!-- : ( Button : Sub ) (E) --> 
<!-- hidden start --> 
<input type="hidden" name="com_fromName" value="<%=StringUtil.xssFilter(request.getParameter("com_fromName"))%>" /> 
<input type="hidden" name="com_smtp" value="<%=StringUtil.xssFilter(request.getParameter("com_smtp"))%>" /> 
<input type="hidden" name="f_cmd" value="7" /> 
<input type="hidden" name="com_officeCode" value="<%=StringUtil.xssFilter(request.getParameter("com_officeCode"))%>" /> 
<input type="hidden" name="com_groupwareMail" value="<%=StringUtil.xssFilter(request.getParameter("com_groupwareMail"))%>" /> 
<input type="hidden" name="com_fileKey"/> 
<input type="hidden" name="com_mailKeyFlag" value="<%=StringUtil.xssFilter(request.getParameter("com_mailKeyFlag"))%>" /> 
<input type="hidden" name="com_mailKey" value="<%=mailKey%>" /> 
<!-- hidden end -->
<!-- : ( bottom : email ) (E) -->

<!-- : ( hidden : report ) (S) -->
<input type="hidden" name="com_mrdPath" value="">
<input type="hidden" name="com_mrdArguments" value="">
<input type="hidden" name="com_mrdSaveDialogDir" value="c:\\">
<input type="hidden" name="com_mrdSaveDialogFileName" value="SaveFileName">
<input type="hidden" name="com_mrdSaveDialogFileExt" value="pdf">
<input type="hidden" name="com_mrdSaveDialogFileExtLimit" value="xls@pdf@bmp@tif">
<input type="hidden" name="com_mrdTitle" value="Report Designer Common Popup">
<input type="hidden" name="com_mrdPrintPaperSize" value="1">
<input type="hidden" name="com_mrdDisableToolbar" value="0;1;2;3;4;5;12;13;14;15;16;17">
<input type="hidden" name="com_mrdBodyTitle" value="Report Sample">
<input type="hidden" name="com_zoomIn">
<input type="hidden" name="com_isBatch" value="N">
<!-- : ( hidden : report ) (E) -->

<!-- : ( hidden : report mail Attached ) (S) -->
<input type="hidden" name="com_templateMrd" value="">
<input type="hidden" name="com_templateMrdArguments" value="">
<input type="hidden" name="com_rdExportFileName" value="">
<input type="hidden" name="com_rdExportFileType" value="">
<!-- : ( hidden : report mail Attached ) (E) -->

<!--  : (file : user file Attached() -->
<input type="file" name="com_fileObject" style="display:none;" onchange="addFile()"/>

<!-- IBUpload  (S) -->
<script language="javascript">ComUploadObject('upload1','obj');</script>
<!-- IBUpload  (E) -->	

</form>
</body>
</html>
