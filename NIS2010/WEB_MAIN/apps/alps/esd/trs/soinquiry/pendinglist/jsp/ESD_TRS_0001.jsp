<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0001.jsp
*@FileTitle : Pending List Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009-3-5
*@LastModifier : juhyun
*@LastVersion : 1.0
* 2006-10-18 juhyun
* 1.0 최초 생성
* N200902240170 2009-03-05 Pending list ofc 매뉴얼 입력 가능 조정
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.trs.soinquiry.pendinglist.event.EsdTrs0001Event"%>

<%
	EsdTrs0001Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	
	Exception serverException   = null;			//서버에서 발생한 에러
	DBRowSet rowSet	  = null;							   //DB ResultSet
	String strErrMsg = "";								 //에러메세지
	int rowCount	 = 0;								  //DB ResultSet 리스트의 건수
	String today = DateTime.getFormatString("yyyyMMdd");
	String beforeday = DateTime.addDays(today, -7);
	beforeday = beforeday.substring(0,4) + "-" + beforeday.substring(4,6)+ "-" + beforeday.substring(6,8);  //월 저장
	String today_1 = DateTime.getFormatString("yyyy-MM-dd");
	String selCOSTMODE = ""; //Cost Mode
	String selTRANSMODE = ""; //Transportation Mode
	String selRHQMODE = ""; //RHQ Mode
	String optionStr = "000020:ALL:ALL";
	String userId="";
	String ofc_cd="";
	String eq_ctrl ="";

	selCOSTMODE  = JSPUtil.getCodeCombo("sel_costmode", "01", "style='width:170'", "CD00744", 0, optionStr);
	selTRANSMODE  = JSPUtil.getCodeCombo("sel_transmode", "01", "style='width:90'", "CD00283", 0, optionStr);
//	selRHQMODE  = JSPUtil.getCodeCombo("sel_rhqmode", "01", " onChange='rhq_OnChange(this);'", "style='width:90'", "CD00738", 0, optionStr);
	selRHQMODE  = JSPUtil.getCodeCombo("sel_rhqmode", "01", "style='width:90'",  "CD00738", 0, optionStr);
	try {

	   SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   userId=account.getUsr_id();
	   ofc_cd=account.getOfc_cd();
	   eq_ctrl=account.getOfc_cd();

	   //userAuth=account.getAuth();

		event = (EsdTrs0001Event)request.getAttribute("Event");

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
<title>Pending List</title>
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


<!--body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();fn_combo();"-->
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input	type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="stsval" value="Y">
<input type="hidden" name="hid_cargo" value="ALL">
<input type="hidden" name="hid_bound" value="ALL">
<input type="hidden" name="hid_cost" value="ALL">
<input type="hidden" name="hid_to_date" value="">
<input type="hidden" name="hid_from_date" value="">
<input type="hidden" name="hid_rhq" value="ALL">
<input type="hidden" name="ofc_cd" value="<%=ofc_cd%>">
<input type="hidden" name="old_ofc_cd" value="<%=ofc_cd%>">



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
						<tr><td class="btn1_left"></td><td class="btn1" id="btn_minimize" name="btn_minimize">Minimize</td><td class="btn1_right"></td></tr></table></td>
					<!-- Repeat Pattern -->

				</tr></table>

			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Button : Main ) (E) -->


        <div id="showMin" style="display:inline">
		<!-- TABLE '#D' : ( Search Options ) (S) -->
		<table class="search">
			<tr>
				<td class="bg">
					<table class="height_2"><tr><td></td></tr></table>

					<table class="search_in" border="0">
						<tr class="h23">
							<td width="150">Planned Departure Date</td>
							<td width="240" class="sm">
								<input name="from_date" type="text" style="width:75;" value="<%=beforeday%>" onFocus='fun_Focus_del(this)'  onBlur='BlurDate(this);addBar_from(this);' >&nbsp;&nbsp;~&nbsp;
								<input name="to_date" type="text" style="width:75;" value="<%=today_1%>"   onFocus='fun_Focus_del(this)'  onBlur='BlurDate(this);addBar_to(this);' >
								<img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar"> </td>
							<td width="60">Cargo</td>
							<td width="220">
								<table border="0" style="height:15; width:171; background-color: #E9E9E9;">
                                	<tr>
                                		<td class="sm" style="text-align:center; ">
                                			<input name="btng_cargo" type="radio" class="trans" value="A" checked  Onclick="change_val_1();" >All&nbsp;&nbsp;&nbsp;
											<input name="btng_cargo" type="radio" value="B" class="trans"  Onclick="change_val_1();" >Full&nbsp;&nbsp;&nbsp;
											<input name="btng_cargo" type="radio" value="C" class="trans"  Onclick="change_val_1();" >Empty</td>
                                	</tr>
                                </table></td>
							<td width="97">Bound</td>
							<td>
								<table border="0" style="height:15; width:140;background-color: #E9E9E9;">
                                	<tr>
                                		<td class="sm" style="text-align:center; ">
                                			<input name="btng_bound"  type="radio" class="trans" value="ALL" checked Onclick="change_val_2();" >All&nbsp;&nbsp;&nbsp;
											<input name="btng_bound"  type="radio" value="I" class="trans" Onclick="change_val_2();" >In&nbsp;&nbsp;&nbsp;
											<input name="btng_bound"  type="radio" value="O" class="trans" Onclick="change_val_2();" >Out</td>
                                	</tr>
                                </table></td>
						</tr>
					</table>

					<table class="search_in" border="0">
						<tr class="h23">
							<td width="150">Cost Mode </td>
							<td width="240">
                              <SELECT name = "sel_costmode" style='width:170'>
                                <OPTION  value="ALL">ALL</OPTION>
                                <OPTION  value="CY">CY</OPTION>
                                <OPTION  value="DR">DOOR</OPTION>
                                <OPTION  value="LS">LOCAL SHUTTLE</OPTION>
                                <OPTION  value="TS">T/S SHUTTLE</OPTION>
                                <!-- OPTION  value="ER">EMPTY REPO</OPTION -->
                              </SELECT>
                            </td>
							<td width="140">Transportation Mode</td>
							<td><%=selTRANSMODE%></td>
						</tr>
					</table>

					<table class="search_in" border="0" >
						<tr class="h23">
							<td width="150">Trunk VVD </td>
							<td width="240"> 
								<input name="trunk_vvd" value="" type="text" style="width:170;"   onFocus='fun_Focus(this)' onBlur="vvd_check(this)" maxlength="10">
								<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" onClick="vvd_OnPopupClick();"></td>
							<td width="140">Regional Headquarter</td>
							<td width="140"><%=selRHQMODE%></td>
							<td width="90">Control Office</td>
<!--  							<td><input type="text" name="combo1" width="5" value="<%=ofc_cd%>" ></td>  -->

							<td class="sm" align="right">
								<input name="input_office" type="text" style="width:90;" onkeyup="upper(this)" value="<%=ofc_cd%>" >
								<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_office">
								<input type="checkbox" name="chk_office" value="Y" class="trans" onClick="javascript:fun_chkOffice();">Incl. Sub OFC</td>


<!--  							<td><script language="javascript">ComComboObject('combo1',1, 80 , 0 )</script></td>  -->
							<td width="1%"></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->
        </div>
		<table class="height_10"><tr><td></td></tr></table>

		<!-- TABLE '#D' : ( Gird BG Box ) (S) -->
		<table class="search" border="0">
			<tr>
				<td class="bg">

					<table class="height_10"><tr><td></td></tr></table>

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
	<script language="javascript">ComSheetObject('sheet2');</script>
</td></tr>
</table>
<!-- Outer Table (E)-->


</form>
</body>
</html>


