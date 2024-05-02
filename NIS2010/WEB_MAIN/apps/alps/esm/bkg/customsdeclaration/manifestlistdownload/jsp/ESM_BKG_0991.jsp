
<%
	/*=========================================================
	 *Copyright(c) 2017 Hi-Plus Card
	 *@FileName : esm_bkg_0991.jsp
	 *@FileTitle : ESM_BKG-0991
	 *Open Issues :
	 *Change history :
		 2017.08.08 하대성 2017 Renewal Version Transmit 반영
	 *@LastModifyDate : 2017.08.08
	 *@LastModifier : 하대성
	 *@LastVersion : 1.0
	 * 2009.06.03 김승민
	 * 1.0 Creation
	 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page
	import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page
	import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page
	import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page
	import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.event.EsmBkg0991Event"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>

<%
	EsmBkg0991Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	//int rowCount = 0; //DB ResultSet 리스트의 건수

	//String successFlag = "";
	//String codeList = "";
	//String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String bl_no= "";
	String in_vvd_cd= "";
	String in_pod_cd= "";
	String in_pod_split_cd= "";
	String action="";
	//Logger log = Logger.getLogger("com.hanjin.apps.CustomsDeclaration.ManifestListDownload");

	try {
		bl_no = StringUtil.xssFilter(request.getParameter("bl_no"))==null?"":StringUtil.xssFilter(request.getParameter("bl_no"));
		in_vvd_cd = StringUtil.xssFilter(request.getParameter("in_vvd_cd"))==null?"":StringUtil.xssFilter(request.getParameter("in_vvd_cd"));
		in_pod_cd = StringUtil.xssFilter(request.getParameter("in_pod_cd"))==null?"":StringUtil.xssFilter(request.getParameter("in_pod_cd"));
		in_pod_split_cd = StringUtil.xssFilter(request.getParameter("in_pod_split_cd"))==null?"":StringUtil.xssFilter(request.getParameter("in_pod_split_cd"));
		action = StringUtil.xssFilter(request.getParameter("action"))==null?"":StringUtil.xssFilter(request.getParameter("action"));
		
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0991Event) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException)
					.loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		//GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>ESM_BKG-0991</title>
<meta http-eqEsmv="Content-Type" content="text/html; charset=UTF-8">
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

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="form_action" value="<%=action%>">
<input type="hidden" name="f_cmd"> 
<input type="hidden" name="pagerows"> 
<input type="hidden" name="form1_bl_number" value="<%=bl_no%>">
<input type="hidden" name="form1_in_vvd_cd" value="<%=in_vvd_cd%>">
<input type="hidden" name="form1_in_pod_cd" value="<%=in_pod_cd%>">
<input type="hidden" name="form1_in_pod_split_cd" value="<%=in_pod_split_cd%>">
<input type="hidden" name="form1_in_msg_tp" value=""> 
<input type="hidden" name="form1_in_msg_flag" value=""> 
<input type="hidden" name="form1_in_mfr_gubun" value="Y"> 
<input type="hidden" name="cmf_cd" value="">
<input type="hidden" name="cmf_reason" value="">
<!-- 개발자 작업	-->
<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"> Manifest Registration(MFR)_Transmit to New NACCS</span></td></tr>
		</table>	
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 
		<table class="search"> 
       		<tr><td class="bg">
			<table class="search" border="0" style="width:100%;"> 
<%if(action.equals("18")) { %>
				<tr class="h23">
				<td align="center">Do you want to trans to New NACCS as CMF01 or CMF02 ?</td>
				</tr>
<%} else { %>		
				<tr class="h23">
				<td align="center">Do you want to trans to SEA_NACCS as CMF01 or CMF02 ?</td>
				</tr>
<% } %>				
			</table>
		<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td align="center">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><table width="120" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn2_MFR">MFR</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="120" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn2_CMF01">CMF01</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="120" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn2_CMF02">CMF02</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
			<table class="search" border="0" style="width:100%;"> 
				<tr>
				<td width="170"></td>
				<td width="125">
					<table class="search" border="0" style="width:100%;"> 
						<tr class="h23">
							<td width="90" class="stm"></td>
							<td width="" class="stm" valign="middle"> </td>
						</tr>
						<tr class="h23">
							<td width="" class="stm"><input type="radio" name="CMF01Checked" value="5" class="trans" onClick="goCheck('CMF01')">Correction</td>
							<td width="" class="stm" valign="middle"> 5</td>
						</tr>
						<tr class="h23">
							<td width="" class="stm"><input type="radio" name="CMF01Checked" value="1" class="trans" onClick="goCheck('CMF01')">Delete</td>
							<td width="" class="stm" valign="middle"> 1</td>
						</tr>
					</table>
				
				</td>
				<td width=""><table class="search" border="0" style="width:110;"> 
						<tr class="h23">
							<td width="90" class="stm"><input type="radio" name="CMF02Checked" value="2" class="trans" onClick="goCheck('CMF02')">Add</td>
							<td width="" class="stm" valign="middle"> 2</td>
						</tr>
						<tr class="h23">
							<td width="" class="stm"><input type="radio" name="CMF02Checked" value="5" class="trans" onClick="goCheck('CMF02')">Correction</td>
							<td width="" class="stm" valign="middle"> 5</td>
						</tr>
						<tr class="h23">
							<td width="" class="stm"><input type="radio" name="CMF02Checked" value="1" class="trans" onClick="goCheck('CMF02')">Delete</td>
							<td width="" class="stm" valign="middle"> 1</td>
						</tr>
					</table>
				</td>
				</tr>
			</table>

			<table class="search" id="row0" height="46" border="0" style="width:100%; "> 
				<tr>
					<td>

					</td>
				</tr>
			</table>

			<table class="search" id="row1" border="0" style="width:100%; display:none;"> 
				<tr>
					<td>
						<table class="search" border="0" style="width:100%;"> 
							<tr class="h23">
								<td style="width:120px">
									Deletion Code
								</td>	
								<td>
									<select name="del_cd" caption="Deletion Code">
										<option value="" selected></option>
										<option value="1">1.Loading suspended</option>
										<option value="2">2.Landing suspended</option>
										<option value="3">3.B/L No.changed</option>
										<option value="4">4.Misregistration</option>	
										<option value="5">5.Others</option>
									</select> 
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr id="row1_1">
					<td height="23">
					</td>
				</tr>
				<tr id="row1_2" style="margin-top:10px; display:none;">	
					<td>
						<table class="search" border="0" style="width:100%;"> 
							<tr class="h23">
								<td style="width:120px">
									 Deletion Reason 
								</td>
								<td>	
									<textarea name="del_reason" style="ime-mode:disabled" caption="Deletion Reason" rows="1" cols="58" dataformat="etc" maxlength="200"></textarea>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			
			<table class="search" id="row2" border="0" style="width:100%; display:none;"> 
				<tr>
					<td>
						<table class="search" border="0" style="width:100%;"> 
							<tr class="h23">
								<td style="width:120px">
									Addition Code
								</td>	
								<td>
									<select name="add_cd" caption="Addition Code">
										<option value="" selected></option>
										<option value="2">2.Change the transportation contract etc.</option>
										<option value="3">3.Change the cargo operation etc.</option>
										<option value="4">4.Change the B/L No.</option>	
										<option value="5">5.Error in reported contents</option>
										<option value="6">6.Others</option>
									</select> 
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr id="row2_1">
					<td height="23">
					</td>
				</tr>
				<tr id="row2_2" style="margin-top:10px; display:none;">
					<td>
						<table class="search" border="0" style="width:100%;"> 
							<tr class="h23">
								<td style="width:120px">
									 Addition Reason 
								</td>
								<td>	
									<textarea name="add_reason" style="ime-mode:disabled" caption="Addition Reason" rows="1" cols="58" dataformat="etc" maxlength="200"></textarea>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			
			<table class="search" id="row3" border="0" style="width:100%; display:none;"> 
				<tr>
					<td>
						<table class="search" border="0" style="width:100%;"> 
							<tr class="h23">
								<td style="width:120px;">
									Correction Code
								</td>	
								<td>
									<select name="cor_cd" caption="Correction Code">
										<option value="" selected></option>
										<option value="1">1.Change the quantity</option>
										<option value="2">2.Change the transportation contract etc.</option>
										<option value="3">3.Change the cargo operation etc.</option>
										<option value="4">4.Change the B/L No.</option>	
										<option value="5">5.Error in reported contents</option>
										<option value="6">6.Others</option>
									</select> 
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr id="row3_1">
					<td height="23">
					</td>
				</tr>
				<tr id="row3_2" style="margin-top:10px; display:none;">
					<td>
						<table class="search" border="0" style="width:100%;"> 
							<tr class="h23">
								<td style="width:120px;">
									 Correction Reason 
								</td>
								<td>	
									<textarea name="cor_reason" style="ime-mode:disabled" caption="Correction Reason" rows="1" cols="58" dataformat="etc" maxlength="200"></textarea>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			</td></tr>
		</table>
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
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_Close">Close</td>
					<td class="btn1_right"></td>
				</tr></table></td>
			</tr>
		</table></td>
			</tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table>
	    <table width="100%" id="mainTable" style="display:none">
	        <tr>
	            <td width="100%"><script language="javascript">ComSheetObject('sheet1');</script></td>
	        </tr>
	    </table>
<!-- : ( Button : pop ) (E) -->
</form>
</body>
</html>