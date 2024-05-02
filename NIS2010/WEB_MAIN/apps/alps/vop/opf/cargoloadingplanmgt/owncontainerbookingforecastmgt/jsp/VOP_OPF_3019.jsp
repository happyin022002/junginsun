<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_opf_3019.jsp
*@FileTitle : Weight Group (Creation)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.11
*@LastModifier : 이선영
*@LastVersion : 1.0
* 2009.05.11 이선영
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
<%@ page import="com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.event.VopOpf3019Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>
<%
	VopOpf3019Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	String slan_cd = "";
	String slan_cd_desc = "";
	String skd_dir_cd = "";
	String pol_cd = "";
	
	if(request.getParameter("slan_cd")!=null) {
		slan_cd	= StringUtil.xssFilter(request.getParameter("slan_cd"));
	}
	if(request.getParameter("slan_cd_desc")!=null) {
		slan_cd_desc	= StringUtil.xssFilter(request.getParameter("slan_cd_desc"));
	}
	if(request.getParameter("skd_dir_cd")!=null) {
		skd_dir_cd	= StringUtil.xssFilter(request.getParameter("skd_dir_cd"));
	}
	if(request.getParameter("pol_cd")!=null) {
		pol_cd	= StringUtil.xssFilter(request.getParameter("pol_cd"));
	}
	
	Logger log = Logger.getLogger("com.hanjin.apps.CargoLoadingPlanMgt.OwnContainerBookingForecastMgt");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (VopOpf3019Event)request.getAttribute("Event");
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
<title>Weight Group (Creation)</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


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
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="sel_skd_dir_cd" value="<%=skd_dir_cd%>">
<!-- 개발자 작업	-->

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp; Weight Group (Creation)</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 
			<table class="search"> 
       		<tr><td class="bg">
				<table class="search" border="0" style="width:626;"> 
				<tr class="h23">
					<td width="33">Lane</td>
					<td width="350"><input type="text" tabIndex="1" style="width:50;" maxlength="3" fullfill caption="Lane" class="input1" name="slan_cd" value="<%=slan_cd%>" style="ime-mode:disabled" required>&nbsp;<img src="img/btns_search.gif" name="slan_cd_pop" width="19" height="20" border="0" align="absmiddle" class="cursor">&nbsp;<input type="text" style="width:230;" class="input2" name="slan_cd_desc" value="<%=slan_cd_desc%>" readonly></td>
					<td width="63">Direction</td>
					<td width="90">
						<select tabIndex="2" style="width:40;" class="input1" name="skd_dir_cd" onchange="skd_dir_cd_change(this.form)">
						<option value="E">E</option>
						<option value="W">W</option>
						<option value="S">S</option>
						<option value="N">N</option>
						</select>
					</td>
					<td width="33">POL</td>
					<td width=""><input type="text" tabIndex="3" style="width:50;" maxlength="5" fullfill caption="POL" class="input1" name="pol_cd" value="<%=pol_cd%>" style="ime-mode:disabled" required>&nbsp;<img src="img/btns_search.gif" name="pol_cd_pop" width="19" height="20" border="0" align="absmiddle" class="cursor"></td>
				</tr>
				</table>
			</td> 
			</tr>
			</table>
			<table class="height_8"><tr><td></td></tr></table>
			<!-- Tab (S) -->
			<table class="search"> 
       		<tr><td class="bg">	
				
				<!-- : ( Grid ) (S) -->

				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>

				<!-- : ( Grid ) (E) -->	
				<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td tabIndex="4" class="btn2" name="btn_RowAdd">Row Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_RowDelete">Row Delete</td>
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

		<!-- TAB [ Port/Oper ] (S) -->
		<div id="tabLayer" style="display:none">
			<!-- Grid BG Box  (S) -->
	     	<table class="search" id="mainTable">
	       	<tr><td class="bg">

					<!-- Grid (S) -->
					<table width="100%"  id="mainTable">
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet2');</script>
							</td>
						</tr>
					</table>
					<!-- Grid (E) -->

				</td></tr>
			</table>
			<!-- Grid BG Box  (S) -->
		</div>
		<!-- TAB [ Port/Oper ] (E) -->	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td width="">
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
						<td class="btn1_right"></td>
					</tr>
					</table>
				</td>
				<td width="">
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_New">New</td>
						<td class="btn1_right"></td>
					</tr>
					</table>
				</td>
				<td width="">
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_Save">Save</td>
						<td class="btn1_right"></td>
					</tr>
					</table>
				</td>
				<td class="btn1_line"></td>
				<td width="">
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
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
    <!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>