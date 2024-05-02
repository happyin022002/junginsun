<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_MAS_0157.jsp
*@FileTitle :  Agent Other Commission Inquiry (PA/RA)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.18
*@LastModifier : 장영석
*@LastVersion : 1.0
* 2009.09.18 장영석
* 1.0 Creation
* =======================================================
* History
* 2010.12.01 김기종 Ticket ID:CHM-201006305-01 MAS Architecture 위배사항 수정
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.mas.stdunitcost.agencycommission.event.EsmMas0157Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmMas0157Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	
	String f_cost_yrmon = JSPUtil.getNullNoTrim(request.getParameter("f_cost_yrmon"));
	String f_comm_loc_cd = JSPUtil.getNullNoTrim(request.getParameter("f_comm_loc_cd"));
	Logger log = Logger.getLogger("com.hanjin.apps.STDUnitCost.AgencyCommission");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

		event = (EsmMas0157Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		  log.error("Exception : " + e.toString());
	}
%>
<html>
<head>
<title> Agent Other Commission Inquiry (PA/RA)</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
		ComSetFocus(document.form.f_cost_yrmon);
	}
</script>
</head>

<body  onLoad="setupPage();">
<form method="post" name="form" onSubmit="return false;" onKeyDown="ComKeyEnter();">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="v_ofc_cd" value="<%=strOfc_cd %>">
<!-- 개발자 작업	-->
<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>


		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->

		<!--Button_L (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
	       	<tr><td class="btn1_bg">

				<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<!-- Repeat Pattern -->
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" id="btn_Retrieve" name="btn_Retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
                   <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" id="btn_Month_Copy" name="btn_Month_Copy">Month Copy</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>      
                  </td>   
					<td class="btn1_line"></td>

					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" id="btn_DownExcel" name="btn_DownExcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>


  

					<!-- Repeat Pattern -->

				</tr></table>

			</td></tr>
		</table>
		<!--Button_L (E) -->


	<!-- TABLE '#D' : ( Search Options ) (S) -->
		<table class="search">
		<tr><td class="bg">

		<!-- : ( Month ) (S) -->
		<table class="search_in" border="0">
			<tr class="h23">
				<td width="7%">YYYY-MM</td>
				<td width="15%"><input type="text" name="f_cost_yrmon" class="input1" style="width:60" value="" maxlength="7" onKeyPress="ComKeyOnlyNumber(window)" onFocus="this.value=ComReplaceStr(this.value, '-', '');" onBlur="addDash(this , 4);"></td>
				<td width="7%">Location</td>
				<td>
					<script language="javascript">ComComboObject('f_comm_loc_cd',1, 100 , 0 )</script>
				</td>
			</tr>
		</table>
		<!-- : ( Month ) (E) -->

		</td></tr>
	</table>
	<!-- TABLE '#D' : ( Search Options ) (E) -->

		<table class="height_10"><tr><td></td></tr></table>


		<!-- TABLE '#D' : ( Grid Box ) (S) -->
		<table class="search" border="0">
		<tr><td class="bg">


				<table class="search" border="0">
					<tr>
						<td class="title_h"></td>
						<td class="title_s">Agent Other Commission Inquiry</td>
						<td align="right" valign="bottom">
							<div id="div_zoom_in" style="display:inline">
								<img class="cursor" src="/hanjin/img/bu_prev01.gif" height="11" border="0" name="bu_zoom_in" alt="Zoom in(+)">
							</div>
							<div id="div_zoom_out" style="display:none">
								<img class="cursor" src="/hanjin/img/bu_next01.gif" height="11" border="0" name="bu_zoom_out" alt="Zoom out(-)">
							</div>
						</td>
					</tr>
					<tr>
						<td class="height_5"></td>
					</tr>
				</table>

				<!-- : ( Grid : Week ) (S) -->
					<table width="100%" id="mainTable">
						<tr>
							<td>
								<script language="javascript">ComSheetObject('sheet1');</script>
							</td>
						</tr>
					</table>
				<!-- : ( Grid : Week ) (E) -->


				<!--  Button_Sub (S) -->
				<table width="100%" class="button" id="btn_control">
			       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>

						<!-- Repeat Pattern -->
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn2_left"></td>
							<td class="btn2" id="btng_RowAdd" name="btng_RowAdd">RowAdd</td>
							<td class="btn2_right"></td>
						</tr>
						</table>
						</td>

                         <td>
                         <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                             <tr>
                                 <td class="btn2_left"></td>
                                 <td class="btn2" id="btng_RowDel" name="btng_RowDel">RowDel</td>
                                 <td class="btn2_right"></td>
                             </tr>
                         </table>
                         </td>
                         
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
						<td class="btn2_left"></td>
						<td class="btn2" id="btng_Save" name="btng_Save">Save</td>
						<td class="btn2_right"></td>
						</tr>
						</table>
						</td>
						<!-- Repeat Pattern -->


					</tr></table>
				</td></tr>
				</table>
		    	<!-- Button_Sub (E) -->



			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Grid Box ) (E) -->


</td></tr>
</table>
<!-- Outer Table (E)-->

</form>
</body>
</html>


<!-- 개발자 작업  끝 -->
