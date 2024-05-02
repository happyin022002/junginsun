<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_scg_1005.jsp
*@FileTitle : SAVE DG Restriction by Port
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.03
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.06.03 장강철 jkc
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
<%@ page import="com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.portrestriction.event.VopScg1005Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopScg1005Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";


	
	String strPort_cd               =  "";
	String strPort_cd_nm            =  "";
	String strImdg_clss_cd          =  "";
	String strImdg_clss_cd_desc     =  "";
	String strImdg_un_no            =  "";
	String strImdg_un_no_seq        =  "";	
	String strOpt                   = "";
	String strImdg_port_rstr_seq    = "";
	Logger log = Logger.getLogger("com.hanjin.apps.DangerousCargoRestriction.PortRestriction");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopScg1005Event)request.getAttribute("Event");
		
		strPort_cd               =  event.getAttribute("port_cd"          ).toString();
		strPort_cd_nm            =  event.getAttribute("port_cd_nm"       ).toString();
		strImdg_clss_cd          =  event.getAttribute("imdg_clss_cd"     ).toString();
		strImdg_clss_cd_desc     =  event.getAttribute("imdg_clss_cd_desc").toString();
		strImdg_un_no            =  event.getAttribute("imdg_un_no"       ).toString();
		strImdg_un_no_seq        =  event.getAttribute("imdg_un_no_seq"   ).toString();
		strOpt                   =  event.getAttribute("optClass"         ).toString();
		strImdg_port_rstr_seq    =  event.getAttribute("imdg_port_rstr_seq" ).toString();
		 
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

/*		
		strPort_cd               =  "CNCHG";
		strPort_cd_nm            =  "strPort_cd_nm";
		strImdg_clss_cd          =  "5";
		strImdg_clss_cd_desc     =  "strImdg_clss_cd_desc";
		strImdg_un_no            =  "1045";
		strImdg_un_no_seq        =  "1";		
		strOpt = "unno";*/
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>SAVE DG Restriction by Port</title>
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

<body class="popup_bg"  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="strOpt" value = "<%=strOpt %>">

<input type="hidden" name="imdg_port_rstr_seq" value = "<%=strImdg_port_rstr_seq %>">

<!-- 개발자 작업	-->
<!-- OUTER - POPUP (S)tart -->
<table width="500" class="popup" cellpadding="10" border="0"> 
	<tr><td class="top"></td></tr>
	<tr>
		<td valign="top">
	
			<!-- : ( Title ) (S) -->
			<table width="100%" border="0">
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;SAVE DG Restrictions by Port  </td></tr>
			</table>
			<!-- : ( Title ) (E) -->
		
			<!-- : ( Search Options ) (S) -->
 
			<table class="search"> 
	       		<tr>
	       			<td class="bg">
			
						<table class="search" border="0" style="width:580;"> 
						<tr class="h23">
							<td width="320">
							    Port&nbsp;<input type="text" style="width:60;" class="input2" name='port_cd' readonly value="<%=strPort_cd %>">&nbsp;<input type="text"  readonly style="width:120;" class="input2" name='port_cd_nm' value="<%=strPort_cd_nm %>"></td>
							<td>Class&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" style="width:114;" align='center'  readonly class="input2" name='imdg_clss_cd'  value="<%=strImdg_clss_cd %>"></td>
							</tr>
						<tr class="h23"><td width="">&nbsp;</td>
						<td style="padding-left:1">UN No./Seq.&nbsp;&nbsp;<input type="text" style="width:44;"  readonly class="input2" name="imdg_un_no" value="<%=strImdg_un_no %>">&nbsp;<input type="text" style="width:29;"  readonly class="input2" name='imdg_un_no_seq' value="<%= strImdg_un_no_seq  %>"></td></tr>
						</table> 
					    <!-- : ( Button : Grid ) (E) -->	
						<!-- Grid  (S) -->
						<table width="100%"  id="mainTable"> 
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet1');</script>
								</td>
							</tr>
						</table>
						<!-- Grid (E) -->
		
			
				
						<!--  Button_Sub (S) -->
						<table width="100%" class="button"> 
				       	<tr><td class="btn2_bg">
							<table border="0" cellpadding="0" cellspacing="0"><tr>
									<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td>
									<td class="btn2" name="btn_rowAdd">Row&nbsp;Add</td>
									<td class="btn2_right"></td>
									</tr>
									</table></td>
									
									<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td>
									<td class="btn2" name="btn_delete">Row&nbsp;Delete</td>
									<td class="btn2_right"></td>
									</tr>
									</table></td>
									<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td>
									<td class="btn2" name="btn_save">Save</td>
									<td class="btn2_right"></td>
									</tr>
									</table></td>
								</tr></table>
						</td></tr>
						</table>
				    	<!-- Button_Sub (E) -->
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->


<table class="height_5"><tr><td></td></tr></table>

</td></tr>
</table> 
	
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
	<tr>
		<td height="71" class="popup">
	
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
    	   		<tr>
       				<td class="btn3_bg">
					    <table border="0" cellpadding="0" cellspacing="0">
						    <tr>
								<td>
									<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_close">Close</td>
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
			
<!-- : ( Button : pop ) (E) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>