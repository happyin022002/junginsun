<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TRS_0250.jsp
*@FileTitle : AWK Cargo Shuttle Tariff Management
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.05
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2013.04.05 이혜민
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
<%@ page import="com.hanjin.apps.alps.esd.trs.specialcargoquotationmanage.awkwardcargomanage.event.EsdTrs0250Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdTrs0250Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_ofc		= "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_ofc = account.getOfc_cd();

		event = (EsdTrs0250Event)request.getAttribute("Event");
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
<title>AWK Cargo Shuttle Tariff Management</title>
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
<input type="hidden" name="trsp_awk_cgo_trf_tp_cd">
<input type="hidden" name="yd_cd">
<input type="hidden" name="fm_yd_cd">
<input type="hidden" name="to_yd_cd">
<input type="hidden" name="lg_usr_id" value="<%=strUsr_id%>">
<input type="hidden" name="lg_ofc_cd" value="<%=strUsr_ofc%>">
<input type="hidden" name="lcl_amt">
<input type="hidden" name="usd_amt">
<input type="hidden" name="curr_cd">
<input type="hidden" name="usd_xch_dt">
<input type="hidden" name="select_row">
<input type="hidden" name="select_col">

<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;padding-right:5;">
	<tr>
		<td valign="top">
			<!--Page Title, Historical (S)-->
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		        <tr>
		        	<td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td>
		        </tr>
		        <tr>
		        	<td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;AWK Cargo Shuttle Tariff Management</td>
		        </tr>
	        </table>
			<!--Page Title, Historical (E)-->
	
			<!--biz page (S)-->
			<table class="search"> 
		       	<tr>
		       		<td class="bg">
						<!-- biz_1  (S) -->
						<table class="search" border="0" style="width:979;" id="basictstab"> 
							<tr class="h23">
								<td width="50">Port</td>					
								<td width="140">
									<input type="text" name="port_cd" style="width:60;text-align:center;" class="input" value="" onKeyPress="ComKeyOnlyAlphabet('uppernum')" style="ime-mode:disabled" maxlength="5">&nbsp;<img src="img/btns_search.gif" width="19" height="20" name="btn_port" border="0" align="absmiddle" class="cursor">
			                    </td>
								<td width="90">Year/Month</td>
								<td width="130">
									<input type="text" name="year_month"  dataformat="ym" style="width:60;text-align:center;ime-mode:disabled;" readonly class="input1" maxlength="6" value="">&nbsp;<img src="img/btns_calendar.gif" name="btn_Calendar" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
								</td>
								<td width="120">Tariff Condition</td>
							    <td width="450">
								  <input type="text" name="cond_no" style="width:35;text-align:center;ime-mode:disabled;" readonly class="input2" value="">
								  <input type="text" name="cond_desc" style="width:270;text-align:left;ime-mode:disabled;" readonly class="input2" value="">&nbsp;<img src="img/btns_search.gif" width="19" height="20" name="btn_trfCond" border="0" align="absmiddle" class="cursor">
							    </td>
			                    <td width=""></td>
							</tr>
						</table>	
						<!-- biz_1  (E) -->		
					</td>
				</tr>
			</table>		
			
  			<table class="height_8">
  				<tr><td></td></tr>
  			</table>	

			<table class="search"> 
			    <tr>
			    	<td class="bg" style="height:438" valign="top">
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
					       	<tr>
					       		<td class="btn2_bg">
									<table border="0" cellpadding="0" cellspacing="0">
										<tr>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn_rowadd">Row Add</td>
														<td class="btn2_right"></td>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn_rowdelt">Row Delete</td>
														<td class="btn2_right"></td>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn_rowcopy">Row Copy</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
				    	<!-- Button_Sub (E) -->
					</td>
				</tr>
			</table>

			<!--Button (S) -->
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:0;"> 
		       	<tr>
		       		<td class="btn1_bg">
					    <table border="0" cellpadding="0" cellspacing="0">
						    <tr>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left"></td>
									<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
									<td class="btn1_right"></td>
									</tr>
								</table></td>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left"></td>
									<td class="btn1" name="btn_New" id="btn_New">New</td>
									<td class="btn1_right"></td>
									</tr>
								</table></td>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left"></td>
									<td class="btn1" name="btn_Save" id="btn_Save">Save</td>
									<td class="btn1_right"></td>
									</tr>
								</table></td>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left"></td>
									<td class="btn1" name="btn_His" id="btn_His">History</td>
									<td class="btn1_right"></td>
									</tr>
								</table></td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		    <!--Button (E) -->
		<!--biz page (E)-->    
		</td>
	</tr>
</table>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>