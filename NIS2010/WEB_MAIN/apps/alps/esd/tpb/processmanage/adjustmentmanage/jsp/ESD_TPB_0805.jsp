<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TPB_0805.jsp
*@FileTitle : Adjustment Request Message
*Open Issues :
*Change history :
*@LastModifyDate : 2009-09-27
*@LastModifier : Sun, Choi
*@LastVersion : 1.1
* 2009-08-12 O Wan-Ki  1.0 최초생성
* 2009-09-27 Sun, Choi 1.1 ALPS Migration
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.tpb.processmanage.adjustmentmanage.event.EsdTpb0805Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdTpb0805Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String wrtf_rsn_text			= "";
	String wrtf_rsn_cd			= "";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.ProcessManage.AdjustmentManage");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsdTpb0805Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		wrtf_rsn_text  = JSPUtil.getParameter(request, "wrtf_rsn_text");
		wrtf_rsn_cd  = JSPUtil.getParameter(request, "wrtf_rsn_cd");
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Request Message for ROC or Write-off</title>
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

<body onLoad="setupPage();">
<form name="form" enctype="multipart/form-data">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<!-- 개발자 작업	-->
<input type="hidden" name="iPage"> 
<input type="hidden" name="s_file_no"> 
<input type="hidden" name="s_wrtf_rsn_cd" value="<%=wrtf_rsn_cd%>"> 

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10"> 
	<tr>
		<td class="top"></td>
	</tr>
	<tr>
		<td valign="top">

			<!-- : ( Title ) (S) -->
			<table width="100%" border="0">
				<tr>
					<td height="79" class="title"><img src="img/icon_title_dot.gif" align="absmiddle"> ROC or Write-off Request</td>
               </tr>
               </table>
               <table class="search" width="10%" border="0">
               <tr>
               <td width="100">Write-off Reason</td>
              <!--<td width="30"><%=JSPUtil.getCodeCombo("s_wrtf_rsn_cd", wrtf_rsn_cd, "style='width:210';","CD03040", 0, "001: : ")%></td>-->
			  <td width=""><input type="text" name="wrtf_rsn_cd" class="input2" style="width:210" value="<%=wrtf_rsn_text%>" readonly></td>
				</tr>
				
			</table>
			
			<!-- :<table class="search_in" width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">-->
			
				
				
			<!-- :</table>(E) -->
			<!-- : ( Title ) (E) -->
			
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
							
		
					
					<td class="btn1_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						
							<tr>
					
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_filesearch" id="btn_filesearch">File Search</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
				
						<!-- TABLE '#D' : ( Button : Main ) (E) -->
			
						<table class="height_10"><tr><td></td></tr></table>
			
						<!-- TABLE '#D' : ( Search Options ) (S) -->
						<table class="search"> 
							<tr>
								<td class="bg_b1">				
									<!-- : ( POR ) (S) -->
									<table width="100%" id="mainTable">
										<tr>
											<td>
												* Reason for ROC or Write-off<br>
												<textarea type="text" style="width:98%" rows="5" name="s_ra_rmk1" onblur="tpb_chkLenByByte(this,1000,'Reason')" onkeydown="f_set_placeholder(event)" onkeyup="f_chk_length(this)"></textarea>
											</td>
										</tr>
									</table>
									<!-- : ( POR ) (E) -->
								</td>
							</tr>
						</table>
						
						<table height="10"><tr><td></td></tr></table>
						
						<!-- TABLE '#D' : ( Search Options ) (S) -->
						<table class="search" style="display:none" name="adjRmk2" id="adjRmk2"> 
							<tr>
								<td class="bg_b1">			
									<!-- : ( POR ) (S) -->
									<table width="100%" id="mainTable">
										<tr>
											<td>
												* Preventive Measures (Write-off only)<br>
												<textarea type="text" style="width:98%" rows="5" name="s_ra_rmk2" onblur="tpb_chkLenByByte(this,1000,'Preventive Measures ')"></textarea>
											</td>
										</tr>
									</table>
									<!-- : ( POR ) (E) -->
								</td>
							</tr>
						</table>

						<!-- TABLE '#D' : ( Search Options ) (S) -->
						<table class="search"> 
							<tr>
								<td>			
									<!-- : ( POR ) (S) -->
									<table width="100%">
										<tr>
											<td>
												<input type="checkbox" checked readonly disabled><font color="red">The Reason above will be uploaded in Recovery Activity of TPBs selected.
											</td>
										</tr>
									</table>
									<!-- : ( POR ) (E) -->
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>

<!-- : ( Button : Sub ) (S) -->
<table width="100%" class="sbutton">
	<tr>
		<td height="71" class="popup">

			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       			<tr>
       				<td class="btn3_bg">
					    <table border="0" cellpadding="0" cellspacing="0">
					    	<tr>
					    		<td>       								
									<table border="0" cellpadding="0" cellspacing="0">
										<tr>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn1_left"></td>
														<td class="btn1" name="btn_save">Save</td>
														<td class="btn1_right"></td>
													</tr>
												</table>
											</td>
											<td width="10"></td>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn1_left"></td>
														<td class="btn1" name="btn_close" id="btn_close">Close</td>
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

		</td>
	</tr>
</table>

</form>
</body>
</html>

<!-- 개발자 작업  끝 -->