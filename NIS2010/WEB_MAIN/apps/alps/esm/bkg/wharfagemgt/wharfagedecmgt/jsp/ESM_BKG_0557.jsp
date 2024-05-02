<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ui_bkg_0557.jsp
*@FileTitle : Wharfage Declare
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.01
*@LastModifier : OH DONG HYUN
*@LastVersion : 1.0
* 2009.04.24 정재엽
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.event.EsmBkg0557Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0557Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String sBound = "";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.wharfagemgt.wharfagedecmgt");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

		event = (EsmBkg0557Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		sBound = (request.getParameter("bound")==null) ? "" : request.getParameter("bound");
		// Inbound / Outbound 메뉴가 다르기 때문
			String sPgmNo = (request.getParameter("pgmNo")==null) ? "" : request.getParameter("pgmNo");
		if ("".equals(sBound)) {
			if (sPgmNo.length() == 12) {
				sBound = "I";
			} else {
				sBound = "O";
			}
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
	
%>

<html>
<head>
<title>Ancs ACI: Vessel Arrival Manifest (A6)</title>
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

<body  onLoad="setupPage();">
<form name="form" method="post">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="edi_msg_snd_id">
<input type="hidden" name="cntr_20_ut_rt">
<input type="hidden" name="cntr_40_ut_rt">
<input type="hidden" name="cntr_45_ut_rt">
<input type="hidden" name="blk_ut_rt">
<input type="hidden" name="blk_rt_rto">
<input type="hidden" name="cancel_flag" value = "N">  <!-- Dec I/F 인지 Dec Cancel I/F 인지 구분하기 위한 Flag  -->
<input type="hidden" name="csr_no" value = "">  
<input type="hidden" name="ofc_cd" value = "<%=strOfc_cd %>">

<input type="hidden" name="his_seq">
<input type="hidden" name="return_values">

<!-- 개발자 작업	-->
<%
	//String keyAddr     = (request.getParameter("keyAddr") == null)? "":request.getParameter("keyAddr");
%>

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
		
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title">&nbsp;Wharfage Declaration</span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->
	
		<!--biz page (S)-->
		<table class="search">
       	<tr><td class="bg">

				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;">
					<tr class="h23">
						<td width="30">VVD</td>
					<td width="110"><input type="text" style="width:77;ime-mode:disabled" class="input1" name="vvd" dataformat="ennum" maxlength="9" onkeyup="condition_KeyUp()" ></td>
					<td width="35">Port</td>
					<td width="90">
						<input type="text" style="width:49;ime-mode:disabled" class="input1" name="port_cd"  dataformat="engupnum" maxlength="5" onkeyup="condition_KeyUp()">
					</td>
					<td width="35">Bound</td>
					<td width="160">
						<select style="width:140;" class="input1" name="whf_bnd_cd" onchange="searcgBySelect()">							
							<option value="II" <%if("I".equals(sBound)) out.println("selected");%>>II – Inbound Import</option>
							<option value="IN">IN – Inbound </option>
							<option value="IT">IT – Inbound T/S</option>
							<option value="IM">IM – Inbound MT</option>
							<option value="OO" <%if("O".equals(sBound)) out.println("selected");%>>OO – Outbound Export</option>
							<option value="ON">ON – Outbound</option>
							<option value="OT">OT – Outbound T/S</option>
							<option value="OM">OM – Outbound MT</option>
						</select>
					</td>
					<td width="35">Send</td>
					<td width="80"><select style="width:60;" class="input1" name="send">
						<option value="2" selected="selected"> Add</option>
						<option value="4"> Change</option>
						<option value="3"> Delete</option>
						<option value="0"> None</option>
						</select></td>
					<td width="54">MRN No.</td>
					<td width="160"><input type="text" style="width:110;" class="input2" name="mf_ref_no" maxlength="22" readonly="readonly" ></td>
					<td width="74">Sailing Date</td>
					<td width=""><input type="text" style="width:80;" class="input2" name="sail_dt" maxlength="10" dataformat="ymd" readonly="readonly" ></td>
				</tr>
				</table>
				<!--  biz_1   (E) -->


				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>


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
						<td class="btn2" name="btn_add">Row Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_del">Row Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>

					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
			<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>


				<!-- Grid  (S) -->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table>
			<!-- Grid (E) -->


		

			<table class="search" border="0" style="width:979;">
				<tr class="h23">
					<td width="250" valign="top">

					<table width="230" class="grid2">
						<tr>
							<td width="35%" class="tr2_head">허가일자	</td>
							<td width="%"  class="input1">
								<input type="text" style="ime-mode:disabled" name="whf_ntc_dt" dataformat="ymd" class="input1" caption="년월일"  maxlength="10" size="10"  >
								<img src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" name="btn_calendar1">
							</td>
						</tr>
						<tr>
							<td class="tr2_head">납기일자 	</td>
							<td  class="input1">
							<input type="text" style="width:74;" dataformat="ymd" class="input1" name="whf_pay_dt" class="input1" caption="년월일"  maxlength="10" size="10">
							<img src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" name="btn_calendar2">
							</td>
						</tr>
						<tr>
							<td class="tr2_head">담당자 	</td>
							<td  class="input1"><input type="text" style="width:80;" class="noinput1" name="whf_usr_nm"></td>
						</tr>
						<tr>
							<td class="tr2_head">화주 	</td>
							<td  class="input"><input type="radio" value="C" class="trans" name="whf_cust_knd_cd"  onclick="changeCommition(this.value)" checked="checked">복수 &nbsp;&nbsp;&nbsp;
							                   <input type="radio" value="U" class="trans" name="whf_cust_knd_cd" onclick="changeCommition(this.value)">단수</td>
						</tr>
					</table>

					</td>
					<td width="350" valign="top">


					<table width="330" class="grid2">
						<tr>
							<td width="35%" class="tr2_head">Total Amount	</td>
							<td width="%"  class="input2">
							<input type="text" style="width:100%;text-align:right;" class="noinput2"  maxlength="22" dataformat="float" name="whf_rt_amt" onkeyup="changeTotalAmtAndNtcAmt()" value="0"></td>
						</tr>
						<tr>
							<td class="tr2_head">신고 금액  	</td>
							<td width="%"  class="input"><input type="text" style="width:100%;text-align:right;ime-mode:disabled" dataformat="float" maxlength="22" class="noinput" name="ntc_amt" onkeyup="changeTotalAmtAndNtcAmt()" value="0"></td>
						</tr>
						<tr>
							<td class="tr2_head">WHF DEC No. 	</td>
							<td  class="input2" ><input type="text" style="width:100%;" class="noinput2" name="whf_decl_no" readonly="readonly"></td>
						</tr>
						<tr>
							<td class="tr2_head">I/B T/S Amount</td>
							<td  class="input2" ><input type="text" style="width:100%;text-align:right;" class="noinput2" name="ibts_amt" readonly="readonly"></td>
						</tr>
					</table>

					</td>
					<td width="260" valign="top">
					<table width="240" class="grid2">
						<tr>
							<td width="38%" class="tr2_head">절사</td>
							<td width="%"  class="input" colspan="3"><input type="text" style="width:100%;text-align:right;ime-mode:disabled" class="noinput" dataformat="float" maxlength="22" name="rduc_amt" onkeyup="PointNumberFixed(this.name, this.value)"; value="0"></td>
						</tr>
						<tr>
							<td class="tr2_head">Commission 	</td>
							<td width="%"  class="input" colspan="3"><input type="text" style="width:100%;text-align:right;ime-mode:disabled" class="noinput" dataformat="float" maxlength="22" name="comm_amt" onkeyup="PointNumberFixed(this.name, this.value)"; value="0"></td>
						</tr>
						<tr>
							<td class="tr2_head">항만 	</td>
							<td  class="input2" colspan="3"><input type="text" style="width:100%;" class="noinput2" name="port_nm"></td>
						</tr>
						<tr>
							<td class="tr2_head">허가번호 </td>
							<td  class="input" width="20%"><input type="text" style="width:100%;ime-mode:disabled" class="noinput" dataformat="yy" name="whf_ntc_no_yr" maxlength="4" onchange="changePermitNum()"></td>
							<td  class="input" width="15%"><input type="text" style="width:100%;ime-mode:disabled" class="noinput" dataformat="yy" name="whf_ntc_no_mon" maxlength="2" onchange="changePermitNum()"></td>
							<td  class="input" width="%"><input type="text" style="width:100%;ime-mode:disabled" class="noinput" dataformat="yy" name="whf_ntc_no_seq" maxlength="6" onchange="changePermitNum()"></td>
						</tr>
					</table>

					</td>
                    <td valign="bottom">
                        <table width="50" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr>
                            <td class="btn2_left"></td>
                            <td class="btn2" name="btn_erp">ERP</td>
                            <td class="btn2_right"></td>
                        </tr>
                        </table>
                    </td>

				</tr>
				</table>

				</td></tr>
			</table>

			<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
       	<tr>
       		<td>
					<table border="0" style="width: 300" class="search" >
						<tr class="h23">
							<td>LAST UPDATE:</td>
							<td><input type="text" style="width: 80;"
							class="input2" name="upd_usr_id" readonly="readonly"></td>
							<td><input type="text" style="width: 110;"
							class="input2" name="upd_dt" readonly="readonly"></td>
						</tr>
					</table>
				</td>
       	<td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save" >Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>

				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_send">Send</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_decIF">Dec I/F</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_changeNoIF">Change No. I/F</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_decCancelIF">Dec Cancel I/F</td>
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
	<!-- Grid BG Box  (S) -->
	<!--biz page (E)-->
	</td></tr>
		</table>


</form>
</body>
</html>