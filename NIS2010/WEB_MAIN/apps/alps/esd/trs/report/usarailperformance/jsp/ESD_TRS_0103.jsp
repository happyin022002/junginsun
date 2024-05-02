<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0103.jsp
*@FileTitle : USA Rail Performance
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.10
*@LastModifier : 김종호
*@LastVersion : 1.4
* 2007-12-19 Jun Ho Kim
* 1.0 최초 생성
* 1.1 2011.02.18 손은주 [CHM-201108834-01][TRS] Rail performance Report 부분의 주 단위 data 조회기능 추가 요청
* 1.3 2011.05.27 김종호 [CHM-201110817] [TRS] US Rail report 기능 보완 / 추가 요청
* 1.4 2011.06.10 김종호 [CHM-201110817] [TRS] US Rail report 기능 보완 / 추가 요청
* 2013.05.15 조인영 [CHM-201324500] Rail performance report by SO (NYCNA) domestic data 추가
* 2013.06.25 조인영 [CHM-201324798] [TRS] Report 메뉴 40ft CNTR 세분화 및 조회조건 추가
=========================================================*/
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.trs.report.usarailperformance.event.EsdTrs0103Event"%>

<%
	EsdTrs0103Event  event = null;				    //PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			    //서버에서 발생한 에러
	DBRowSet rowSet	  = null;						//DB ResultSet
	String strErrMsg = "";							//에러메세지
	int rowCount	 = 0;							//DB ResultSet 리스트의 건수

	String today = DateTime.getFormatString("yyyyMMdd");
	String userId="";
	String ofc_cd="";

	SignOnUserAccount account= null;

	try {
		account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
 	    userId=account.getUsr_id();
 	    ofc_cd=account.getOfc_cd();

		event = (EsdTrs0103Event)request.getAttribute("Event");

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
	<title>Rail Performance Report(NYCNA)</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script language="javascript">

		<%= JSPUtil.getIBCodeCombo("rail_road_code", "", "CD00930", 0, "")%>

		function setupPage(){
			var errMessage = "<%=strErrMsg%>";
			if (errMessage.length >= 1) {
				ComShowMessage(errMessage);
			}  // end if

			loadPage();

		}
	</script>
</head>


<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">

	<input type="hidden" name="f_cmd">
	<input type="hidden" name="iPage">
	<input type="hidden" name="login_ofc_cd" value="<%=ofc_cd%>">
	<input type="hidden" name="login_usr_id" value="<%=userId%>">
	<input type="hidden" name="login_date" value="<%=today%>">
	<input type="hidden" name="fm_date" value="">
	<input type="hidden" name="to_date" value="">
	

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>

				<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
				<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
				</table>
				<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->

				<!-- TABLE '#D' : ( Button : Main ) (S) -->
				<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
			       	<tr><td class="btn1_bg">

						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" id="btn_retrieve" name="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" id="btn_new" name="btn_new">New</td><td class="btn1_right"></td></tr></table></td>

							<td class="btn1_line"></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" id="btn_downexcel" name="btn_downexcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>
							<!-- Repeat Pattern -->

						</tr></table>

					</td></tr>
				</table>
				<!-- TABLE '#D' : ( Button : Main ) (E) -->

				<!-- TABLE '#D' : ( Search Options ) (S) -->
				<table class="search">
					<tr>
						<td class="bg">

							<table class="search_in" border="0">
								<tr class="h23">
									<td width="80">Date</td>
									<td width="250"><select name="date_type" style="width:230;" onchange="selectDateKind(this);">
										<!-- option value="I" >Invoice Confirm (By Rail Company) </option> -->
										<option value="R" >S/O Creation (By Rail Company) </option>
										<option value="E" selected>S/O Creation (By Entire Route) </option>
										</select></td>
									<td class="sm">
									<table border='0'>
										<tr class='h23'>
											<td width='50'>&nbsp;&nbsp;W/M</td>
											<td width='160'>
												<div id='div_wm' style='display:inline;border:solid 0;'>
												<input type='radio' value='W' name='f_chkprd' class='trans' onClick="javascript:chkWM('W');" checked>&nbsp;Week
												<input type='radio' value='M' name='f_chkprd' class='trans' onClick="javascript:chkWM('M');">&nbsp;Month
												</div>
											</td>
											<td width='250' class='sm'>
											    <div id='div_month' style='display:none;border:solid 0;width:240;height:16'>
											    Month&nbsp;(YYYYMM)&nbsp;
												<input type='text' style='width:60;text-align:center;' class='input1' name='f_fm_mon' maxlength='6' style='ime-mode:disabled' onKeyPress="keyCheck(this);" onKeyUp="checkLength(this);" onBlur="if(this.value!=''){check_format(this);}" >&nbsp;&nbsp;~&nbsp;
												<input type='text' style='width:60;text-align:center;' class='input1' name='f_to_mon' maxlength='6' style='ime-mode:disabled' onKeyPress="keyCheck(this);" onKeyUp="checkLength(this);" onBlur="if(this.value!=''){check_format(this);}" >
												</div>
											    <div id='div_week' style='display:inline;border:solid 0;width:240;height:16'>
											    Week&nbsp;(YYYYWW)&nbsp;
												<input type='text' style='width:60;text-align:center;' class='input1' name='f_fm_wk' maxlength='6' style='ime-mode:disabled' onKeyPress="keyCheck(this);" onKeyUp="checkLength(this);" onBlur="if(this.value!=''){check_format(this);}" >&nbsp;&nbsp;~&nbsp;
												<input type='text' style='width:60;text-align:center;' class='input1' name='f_to_wk' maxlength='6' style='ime-mode:disabled' onKeyPress="keyCheck(this);" onKeyUp="checkLength(this);" onBlur="if(this.value!=''){check_format(this);}" >
												</div>
											</td>
											<td class='sm'><div id='div_period'></div></td>
										</tr>
									</table>
									</td>									
								</tr>
							</table>
							
							<table class="search_in" border="0">
								<tr class="h23">
									
									<td width="70">Lane / VVD </td>
									<td width="20" align="left"><input type="checkbox" name="vvd_dip" value="" class="trans" checked></td>
									<td width="10"></td>
									<td width="89" align="left">Rail Company</td>
									<td width="67"><script language="javascript">ComComboObject('rail_road_code',2, 67 , 1 )</script> </td>
									<td width="170" align="left"><input name="rail_road_name" type="text" style="width:100%;" readOnly class="input2"></td>									
									<td width="90" align="right"> Full / Empty</td>
									<td width="125"><select name="status" style="width:118;" onchange="checkFullEmptyOption(this)";>
										<option value="A" selected>ALL</option>
										<option value="F">Full</option>
										<option value="M">Empty</option>
										<option value="X">Empty + Full Out</option>
										</select></td>
									<td width="42">Bound</td>
									<td width="70"><select name="io_bound" style="width:53;" disabled>
										<option value="A" selected>ALL</option>
										<option value="I">IN</option>
										<option value="O">OUT</option>
										</select></td>
									<td width="24" align="left"><input type="checkbox" name="agmt_chk" value="" class="trans" onclick="checkAgmtRefNoOption();" disabled></td>
									<td width="97">Agmt. Ref. No.</td>
									<td><input name="agmt_ref_no" type="text" style="width:89px;" disabled></td>
								</tr>
							</table>


							<table class="search_in" border="0">
								<tr class="h23">
									
									<td width="100">Int'l / Domestic</td>
									<td width="120">
										<select name="comp_cd" style="width:100;" >
											<option value="A" selected>ALL</option>
											<option value="H">Int'l</option>
											<option value="D">Domestic</option>
										</select>
									</td>
									<td width="40">Route</td>
									<td width="52"><input name="frm_node" type="text" style="width:50;" maxlength="5" onChange="getComboList(this, document.frm_yard, 'F');" onBlur="setgetUpper(this);"></td>
									<td width="72"><script language="javascript">ComComboObject('frm_yard', 1, 49, 0);</script><img src="/hanjin/img/blank.gif" width="2" height="2"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="22" border="0" align="absmiddle" name="btns_frmnode"></td>
									<td width="15" align="center">~</td>
									<td width="52"><input name="to_node" type="text" style="width:50;" maxlength="5" onChange="getComboList(this, document.to_yard, 'T');" onBlur="setgetUpper(this);"></td>
									<td width="96"><script language="javascript">ComComboObject('to_yard', 1, 47, 0);</script><img src="/hanjin/img/blank.gif" width="2" height="2"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="22" border="0" align="absmiddle" name="btns_tonode"></td>
									<td width="160">LOC On &nbsp;<input type="checkbox" name="loc_on" class="trans" value="L"></td>
									<td width="106">Equipment Office</td>
									<td width="96"><input name="ctrl_ofc" type="text" style="width:95%;" maxlength="6" onkeyup="upper(this)" ></td>
								</tr>
								</table>
							<table class="search_in" border="0">
								<tr class="h23">
									<td width="101">CNTR TP/SZ</td>
									<td width="115"><script language="javascript">ComComboObject('cntr_tpsz', 1, 100, 1)</script></td>
									<td width="28" align="left"><input type="checkbox" name="size_chk" value="" class="trans"></td>
									<td width="100">Detailed Size</td>
									<td width="555"></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
				<!-- TABLE '#D' : ( Search Options ) (E) -->

				<table class="height_10"><tr><td></td></tr></table>


		        <div id="tabLayer" style="display:inline">
					<!-- TABLE '#D' : ( Gird BG Box ) (S) -->
					<table class="search" border="0">
						<tr>
							<td class="bg">

								<!-- 'HEAD1-BGCOLOR : 203 240 169' , 'HEAD2-BGCOLOR : 222 251 248' , 'BORDER 1-outside : 88 152 164' ,'BORDER 2-inside : 202 226 233' , 'HEAD-FONT : 39 95 101' , 'SELETED ROW BG : 252 255 233' -->
			                    <table width="100%" id="mainTable">
			                        <tr><td>
	 		                             <script language="javascript">ComSheetObject('sheet1');</script>
			                        </td></tr>
			                    </table>
								<!-- : ( Grid ) (E) -->
							</td>
						</tr>
					</table>
					<!-- TABLE '#D' : ( Grid BG Box ) (E) -->
  			    </div>

		       <div id="tabLayer" style="display:none">
					<!-- TABLE '#D' : ( Gird BG Box ) (S) -->
					<table class="search" border="0">
						<tr>
							<td class="bg">

								<!-- 'HEAD1-BGCOLOR : 203 240 169' , 'HEAD2-BGCOLOR : 222 251 248' , 'BORDER 1-outside : 88 152 164' ,'BORDER 2-inside : 202 226 233' , 'HEAD-FONT : 39 95 101' , 'SELETED ROW BG : 252 255 233' -->
			                    <table width="100%" id="mainTable">
			                        <tr><td>
	 		                             <script language="javascript">ComSheetObject('sheet2');</script>
			                        </td></tr>
			                    </table>
								<!-- : ( Grid ) (E) -->
							</td>
						</tr>
					</table>
					<!-- TABLE '#D' : ( Grid BG Box ) (E) -->
			   </div>
			   <table width="100%" id="hiddenTable3">
					<tr><td>
						 <script language="javascript">ComSheetObject('sheet3');</script>
					</td></tr>
				</table>

</td></tr>
</table>
<!-- Outer Table (E)-->

</form>
</body>
</html>
