
<%
	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : VOP_PSO_0037.jsp
	 *@FileTitle : Tariff Value Management
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2011.03.14
	 *@LastModifier : 진마리아
	 *@LastVersion : 1.0
	 * 2009.12.23 정명훈
	 * 1.0 Creation
	 *
	 * History
	 * 2011.03.14 진마리아 CHM-201109292-01 Location 조회불가건 수정 보완 요청
	 * 2014.03.12 박다은   CHM-201429104 	   [PSO] Tariff Attribute 내 불필요 Tariff 삭제 기능 요청
	 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.event.VopPso0237Event"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>

<%
	VopPso0237Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";
	String yd_cd 	= "";
	String all_info  = "";
	
	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.hanjin.apps.PortSOMasterDataMgt.PortTariffMgt");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (VopPso0237Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		yd_cd            = StringUtil.xssFilter(request.getParameter("yd_cd"))== null?"":StringUtil.xssFilter(request.getParameter("yd_cd"));
		all_info         = StringUtil.xssFilter(request.getParameter("all_info"))== null?"":StringUtil.xssFilter(request.getParameter("all_info"));


	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Copy Tariff</title>
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
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top: 2; padding-left: 5;padding-right:5;">
	<tr>
		<td valign="top"><!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		
			<tr>
			  <td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Copy Tariff</td>
			</tr>
		</table>
		<!--Page Title, Historical (E)--> <!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0"
			cellspacing="0" style="padding-top: 0; , padding-bottom: 2;">
			<tr>
				<td class="btn1_bg">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
						
							</tr>
						</table>
						</td>
						<td>

						</td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_Save">&nbsp;&nbsp;Save&nbsp;&nbsp;</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						
						<td>

						</td>
					</tr>
				</table>
				</td>
			</tr>
		</table>

		<!--Button (E) --> <!--biz page (S)-->
		<table class="search">
			<tr>
				<td class="bg">
				<table class="search_in" border="0" style="width: 800;">
					<tr class="h23">
						<td width="25">From</td>
						<td width="150">  <input type="text" style="width: 70;text-align:center;" class="input2" value="<%=yd_cd%>" name="yd_cd" readOnly> </td>
						<td width="25">TO</td>
						<td width="450"> 
						 <table class="grid2" border="0"> 
						 <tr><td>
							              <input type="text" style="width: 70;text-align:center;" dataformat="uppernum"  class="input" value="" name="new_yd_cd1"  maxlength="7" style="ime-mode:disabled">
						                  <input type="text" style="width: 70;text-align:center;" dataformat="uppernum"  class="input" value="" name="new_yd_cd2"  maxlength="7" style="ime-mode:disabled">
						                  <input type="text" style="width: 70;text-align:center;" dataformat="uppernum"  class="input" value="" name="new_yd_cd3"  maxlength="7" style="ime-mode:disabled">
						                  <input type="text" style="width: 70;text-align:center;" dataformat="uppernum"  class="input" value="" name="new_yd_cd4"  maxlength="7" style="ime-mode:disabled"> 
						                  <input type="text" style="width: 70;text-align:center;" dataformat="uppernum"  class="input" value="" name="new_yd_cd5"  maxlength="7" style="ime-mode:disabled">
						</td></tr>
						 </table>
						 </td> 
				     	<td width=""> <input type="hidden" style="width: 70;text-align:center;" class="input2" value="" name="new_yd_chg_no" > </td> 
						<td width=""> <input type="hidden" style="width: 70;text-align:center;" class="input2" value="<%=all_info%>" name="all_info" readOnly> </td>
						
						
					</tr>
				
				</table>
	
				<table class="line_bluedot"><tr><td></td></tr></table>

				<!--table class="search" border="0">
					<tr>
						<td class="title_h"></td>
						<td width="" class="title_s">Base</td>
					</tr>
				</table-->

				<table width="100%" class="search" border="0">
					<tr class="h23">
						<td width="72%" valign="top">
							<table width="100%" id="mainTable">
								<tr>
									<td width="100%"><script language="javascript">ComSheetObject('sheet1');</script></td>
								</tr>
							</table>
						</td>
				
					</tr>
				</table>
				
				<!--  Button_Sub (S)-->
				<table width="100%" class="button"> 
	       			<tr><td class="btn2_bg">
					<table border="0" cellpadding="0" cellspacing="0"><tr>
						
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_del">Row Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						</tr>
						</table></td>
					</tr></table>
				</td></tr>
				</table> 
				
				</td>
			</tr>
		</table>
		<table class="height_10">
			<tr>
				<td></td>
			</tr>
		</table>
		</td>
	</tr>
</table>

<!-- 개발자 작업  끝 --></form>
</body>
</html>
<%@include file="/bizcommon/include/common_nis2010.jsp"%>