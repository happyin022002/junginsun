
<%
	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : VOP_PSO_0212.jsp
	 *@FileTitle : Tariff Copy
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2009.06.30
	 *@LastModifier : 박명종
	 *@LastVersion : 1.0
	 * 2009.06.30 박명종
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
	import="com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.event.VopPso0212Event"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>
<%@ page import="org.apache.log4j.Logger"%>

<%
	VopPso0212Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String strUsr_Ofc_cd = "";

	String strPortCd = "";
	String strYardCd = "";
	String strAcctCd = "";
	String strAcctNm = "";
	String strCostCd = "";
	String strCostNm = "";
	String strVndrSeq = "";
	String strVndrNm = "";

	Logger log = Logger
			.getLogger("com.hanjin.apps.PortSOMasterDataMgt.PortTariffMgt");

	String sType = StringUtil.xssFilter(request.getParameter("type")) == null ? "B" : StringUtil.xssFilter(request.getParameter("type"));
	
	String caller = StringUtil.xssFilter(request.getParameter("caller")) == null ? "POPUP" : StringUtil.xssFilter(request.getParameter("caller")); //POPUP, IFRAME

	try {
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_Ofc_cd = account.getOfc_cd();

		event = (VopPso0212Event) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException)
					.loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request
				.getAttribute("EventResponse");

		strPortCd = StringUtil.xssFilter(request.getParameter("port_cd"));
		strYardCd = StringUtil.xssFilter(request.getParameter("yd_cd"));
		strAcctCd = StringUtil.xssFilter(request.getParameter("acct_cd"));
		strAcctNm = StringUtil.xssFilter(request.getParameter("acct_nm"));
		strCostCd = StringUtil.xssFilter(request.getParameter("cost_cd"));
		strCostNm = StringUtil.xssFilter(request.getParameter("cost_nm"));
		strVndrSeq = StringUtil.xssFilter(request.getParameter("vndr_seq"));
		strVndrNm = StringUtil.xssFilter(request.getParameter("vndr_nm"));

	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Tariff Copy</title>
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

<body class="popup_bg" onLoad="setupPage();" bgcolor="<%="IFRAME".equals(caller) ? "#F3F2F8" : ""%>">
<form name="form" onKeyDown="ComKeyEnter()"><input type="hidden"
	name="f_cmd"> <input type="hidden" name="pagerows"> <input
	type="hidden" name="types" value="<%=sType%>"> <input
	type="hidden" name="sXml"> <input type="hidden" name="ydCd"
	value="<%=strYardCd%>"> <input type="hidden" name="yd_chg_no"
	value=""> <input type="hidden" name="param_acct_cd"
	value="<%=strAcctCd%>"> <input type="hidden" name="param_acct_nm"
	value="<%=strAcctNm%>"> <input type="hidden" name="cost_cd"
	value="<%=strCostCd%>"> <input type="hidden" name="cost_nm"
	value="<%=strCostNm%>"> <input type="hidden" name="yd_cd">  
	<input type="hidden" name="caller" value="<%=caller%>">
<table width="100%" class="<%="IFRAME".equals(caller) ? "" : "popup"%>" cellpadding="10" border="0">
	<tr>
		<td class="top"></td>
	</tr>
	<tr>
		<td valign="top"><!-- : ( Title ) (S) -->
		<table width="100%" border="0" style="display:<%="IFRAME".equals(caller) ? "none" : "inline"%>">
			<tr>
				<td class="title"><img src="img/icon_title_dot.gif"
					align="absmiddle">&nbsp;Copy From</td>
			</tr>
		</table>
		<!-- : ( Title ) (E) --> <!--biz page (S)-->
		<table class="search" id="mainTable">
			<tr>
				<td class="bg"><!--  biz_1  (S) -->

				<table class="search" border="0" style="display:<%="IFRAME".equals(caller) ? "none" : "inline"%>">
					<tr>
						<td class="title_h"></td>
						<td class="title_s">Copy From</td>
					</tr>
				</table>

				<table class="search" border="0" width="100%" style="display:<%="IFRAME".equals(caller) ? "none" : "inline"%>">
					<tr class="h23">
						<td width="60">Terminal</td>
						<td width="180"><input name="port_cd" type="text"
							style="width: 67; margin-left: -2px; text-align: center;"
							class="input" value="<%=strPortCd%>" dataformat="engup">&nbsp;<script
							language="javascript">ComComboObject('com_yd_cd',2, 50, 0);</script></td>
						<td width="110">Service Provider</td>
						<td width=""><script language="javascript">ComComboObject('com_vendor',2, 102, 1);</script><input type="text" name="vndr_seq" value="<%=strVndrSeq%>" style="width: 100; display:none;" class="input2" readonly> <input type="text" name="vndr_nm" value="<%=strVndrNm%>" style="width: 230;" class="input2" readonly></td>
					</tr>
					<tr class="h23">
						<td width="">Year</td>
						<td width=""><input name="year" dataformat="y" type="text"
							style="width: 120; margin-left: -2px; text-align: center;"
							maxlength="4" class="input1" value=""></td>
						<td width="" id="acct_or_cost_caption">Account Code</td>
						<!-- <td width=""><input type="text" name="acct_or_cost_cd" value="" style="width: 100;" class="input2" readonly> <input type="text" name="acct_or_cost_nm" value="" style="width: 230;" class="input2" readonly></td> -->
						<td width=""><script language="javascript">ComComboObject('acct_or_cost_cd',2, 102, 0, 0);</script>&nbsp;<input type="text" name="acct_or_cost_nm" style="width: 230; text-align: left" class="input2" value="" readonly></td>
					</tr>
					<tr class="h23">
						<td width="">Version</td>
						<td width=""><script language="javascript">ComComboObject('ver',3, 120, 1);</script></td>
						<td width="">Effective Date</td>
						<td width=""><input type="text" name="eff_date"
							style="width: 204;" class="input2" readonly></td>
					</tr>
				</table>

				<!--  biz_1   (E) -->
				<table class="line_bluedot" style="display:<%="IFRAME".equals(caller) ? "none" : "inline"%>">
					<tr>
						<td></td>
					</tr>
				</table>
				<table class="search" border="0" style="width: 100%;" style="display:<%="IFRAME".equals(caller) ? "none" : "inline"%>">
					<tr class="h23">
						<td width="100"><input type="checkbox" name="cBase" value=""
							class="trans" checked disabled>&nbsp;Base</td>
						<td width="130"><input type="checkbox" name="cSur" value=""
							class="trans" disabled>&nbsp;Surcharge</td>
						<td width=""><input type="checkbox" name="cDis" value=""
							class="trans" disabled>&nbsp;Discount</td>
					</tr>
				</table>

				<table class="line_bluedot" style="display:<%="IFRAME".equals(caller) ? "none" : "inline"%>">
					<tr>
						<td></td>
					</tr>
				</table>


				<!--  biz_2  (S) -->
				<table class="search" border="0">
					<tr>
						<td class="title_h"></td>
						<td width="" class="title_s">Base</td>
						<td align="right"><strong>Compulsory</strong>&nbsp;&nbsp;<input type="checkbox" name="cpls_flg" value="" class="trans" disabled></td>
					</tr>
				</table>

				<table class="search" border="0" width="979">
					<tr class="h23">
						<td width="350" valign="top">
						<table class="search_sm" border="0" width="100%" height="91%">
							<tr class="h23">
								<td valign="top"><!-- Grid  (S) -->
									<table width="100%" id="mainTable">
										<tr>
											<td width="100%"><script language="javascript">ComSheetObject('sheet1');</script>
											</td>
										</tr>
									</table>
									<!-- Grid (E) --> <!-- Button_Sub (E) -->
									<table class="height_10">
										<tr>
											<td></td>
										</tr>
									</table>
									
									<table width="100%" class="" border="0" cellpadding="2" cellspacing="1">
										<tr class="history">
											<td>&nbsp;&nbsp;*Formula</td>
										</tr>
										<tr height="110">
											<td>
												<div id="foml_desc" style="width:100%;height:100%;border:solid 1;overflow-y:auto;overflow-x:hidden;padding:2px;border-color:#5B8A9E;background-color:#FFFFFF"></div>
											</td>
										</tr>
										<tr class="history">
											<td>&nbsp;&nbsp;*Condition</td>
										</tr>
										<tr height="70">
											<td>
												<div id="cond_desc" style="width:100%;height:100%;border:solid 1;overflow-y:auto;overflow-x:hidden;padding:2px;border-color:#5B8A9E;background-color:#FFFFFF"></div>
											</td>
										</tr>
									</table>

								</td>
							</tr>
						</table>
						</td>
						<td width="19">&nbsp;</td>
						<td width="" valign="top"><!-- Grid  (S) -->
						<table width="100%" id="mainTable">
							<tr>
								<td width="100%"><script language="javascript">ComSheetObject('sheet2');</script>
								</td>
							</tr>
						</table>
						<!-- Grid (E) -->

						<table class="height_10">
							<tr>
								<td></td>
							</tr>
						</table>


						<!-- Grid  (S) -->
						<table width="100%" id="mainTable">
							<tr>
								<td width="100%"><script language="javascript">ComSheetObject('sheet3');</script>
								</td>
							</tr>
						</table>
						<!-- Grid (E) --> <!--  Button_Sub (S) -->
						<table width="380" class="button">
							<tr>
								<td class="btn2_bg">

								</td>
							</tr>
						</table>
						<!-- Button_Sub (E) --></td>
					</tr>
				</table>

				<!--  biz_2   (E) -->

				<div id="div_surcharge">
				<table class="line_bluedot">
					<tr>
						<td></td>
					</tr>
				</table>


				<!--  biz_3  (S) -->
				<table class="search" border="0">
					<tr>
						<td class="title_h"></td>
						<td width="" class="title_s">Surcharge</td>

					</tr>
				</table>
				<!-- Grid  (S) -->
				<table width="100%" id="mainTable">
					<tr>
						<td width="100%"><script language="javascript">ComSheetObject('sheet4');</script>
						</td>
					</tr>
				</table>
				<!-- Grid  (E) -->
				</div>
				<!-- Button_Sub (E) --> <!--  biz_3   (E) -->

				<div id="div_discount">
				<table class="line_bluedot">
					<tr>
						<td></td>
					</tr>
				</table>


				<!--  biz_4  (S) -->
				<table class="search" border="0">
					<tr>
						<td class="title_h"></td>
						<td width="" class="title_s">Discount</td>

					</tr>
				</table>
				<!-- Grid  (S) -->
				<table width="100%" id="mainTable">
					<tr>
						<td width="100%"><script language="javascript">ComSheetObject('sheet5');</script>
						</td>
					</tr>
				</table>
				<!-- Grid  (E) --> 
				</div>

				<div id="div_base_dummy" style="display:none"><!-- 추후 Hidden -->
				<table class="line_bluedot">
					<tr>
						<td></td>
					</tr>
				</table>
				<table class="search" border="0">
					<tr>
						<td class="title_h"></td>
						<td width="" class="title_s">Base Dummy</td>

					</tr>
				</table>
				<table width="100%" id="mainTable">
					<tr>
						<td width="100%"><script language="javascript">ComSheetObject('sheet6');</script>
						</td>
					</tr>
				</table>
				</div>


				</td>
			</tr>
		</table>
		<table class="height_5"><tr><td></td></tr></table>
		<!--biz page (E)--></td>
	</tr>
</table>



<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton" style="display:<%="IFRAME".equals(caller) ? "none" : "inline"%>">
	<tr>
		<td height="71" class="popup"><!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0"
			cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">
			<tr>
				<td class="btn3_bg">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_Retrieve">Retrieve</td>
								<td class="btn1_right">
							</tr>
						</table>
						</td>
						<!--td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right">
				</tr></table></td-->
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_Ok">Ok</td>
								<td class="btn1_right">
							</tr>
						</table>
						</td>
						<td class="btn1_line">
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_close">Close</td>
								<td class="btn1_right">
							</tr>
						</table>
						</td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
		<!--Button (E) --></td>
	</tr>
</table>
<!-- : ( Button : pop ) (E) --> <!-- 개발자 작업  끝 --></form>
</body>
</html>
<%@include file="/bizcommon/include/common_nis2010.jsp"%>