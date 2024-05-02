<%
/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : vop_opf_2022.jsp
 *@FileTitle : COPARAR EDI수신
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2016.05.26
 *@LastModifier : 
 *@LastVersion : 1.0
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
<%@ page import="com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.event.VopOpf2022Event"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>
<%
	//부모창에서 파라메터 받아오기;
	String vvd 		= "";
	String pol_clpt_ind_seq 	= "";
	String yd_cd 		= "";
		
	Logger log = Logger.getLogger("com.hanjin.apps.CargoLoadingPlanMgt.OwnContainerBookingForecastMgt");
	
	VopOpf2022Event event = null; 		//PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; 	//서버에서 발생한 에러
	String strErrMsg = ""; 				//에러메세지
	int rowCount = 0; 					//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";

	try {
		SignOnUserAccount account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (VopOpf2022Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		vvd         = StringUtil.xssFilter(request.getParameter("vvd"))== null?"":StringUtil.xssFilter(request.getParameter("vvd"));
		yd_cd       = StringUtil.xssFilter(request.getParameter("pol_cd"))== null?"":StringUtil.xssFilter(request.getParameter("pol_cd"));
		pol_clpt_ind_seq = StringUtil.xssFilter(request.getParameter("pol_clpt_ind_seq"))== null?"":StringUtil.xssFilter(request.getParameter("pol_clpt_ind_seq"));

		
		
	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>CBF Summary Preview</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} 
		loadPage();	
	}
</script>
</head>
<body class="popup_bg" onLoad="setupPage();">
<form name="form">

<input type="hidden" name="f_cmd">
<input type="hidden" name="uid">
<input type="hidden" name="pagerows">

<!-- 개발자 작업	--> <!-- OUTER - POPUP (S)tart -->

<table width="100%" class="popup" cellpadding="10" border="0">
	<tr><td valign="top">
			<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp; CBF Summary Preview</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		<!--biz page (S)-->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg" style="height:515;" valign="top">
			
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:640;"> 
				<tr class="h23"> 
					<td width="50">VVD CD</td>
								<td width="150"><input type="text" style="width: 100;text-align:center;" class="input2" value="<%=vvd %>" name="vvd" readOnly></td>
								<td width="25">POL</td>
								<td width="400"><input type="text" style="width: 70;text-align:center;" class="input2" value="<%=yd_cd %>" name="yd_cd" readOnly></td>
								<input type="hidden" style="width: 70;text-align:center;" class="input2" value="<%=pol_clpt_ind_seq %>" name="pol_clpt_ind_seq" readOnly>
								
				</tr>
				</table>
				<!--  biz_1   (E) -->
		     
		<table class="line_bluedot"><tr><td></td></tr></table>	
		
		
			<!-- Grid  (S) -->
			
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						
						</td>
					</tr>
				</table>

			<!-- Grid (E) -->			

	    	<!-- Button_Sub (E) -->
			
			
			</td></tr>
		</table>
		<!--biz page (E)-->
	
	</td></tr>
		</table>
	
<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:0;"> 
       	<tr><td class="btn1_bg">
		
		    <table border="0" cellpadding="0" cellspacing="0">
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_Excel">Down Excel</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
				</tr>
			</table>
		</td></tr>
		</table>
    	<!--Button (E) -->
		
	</td></tr>
</table>  

<!-- : ( Button : pop ) (E) --> <!-- 개발자 작업  끝 -->

</form>
</body>
</html>
<%@include file="/bizcommon/include/common_nis2010.jsp"%>