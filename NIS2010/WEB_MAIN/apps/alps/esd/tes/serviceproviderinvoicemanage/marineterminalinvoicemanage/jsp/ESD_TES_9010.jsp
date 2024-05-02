<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TES_901.jsp
*@FileTitle : Get Container List Pop Up
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-18
*@LastModifier : 
*@LastVersion : 1.0
* 2006-10-18 
* 1.0 최초 생성
2011.08.10 [CHM-201112119-1] [TES] MR Invoice 입력시 FIO 조건 CNTR verification 결과 보완 요청 
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.event.EsdTes9010Event"%>
<%
	EsdTes9010Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	//ESD_TES_901EventResponse eventResponse = null;	//RDTO(Data Transfer Object including DB ResultSet)
	//Request req = null;
	Exception serverException   = null;			//서버에서 발생한 에러
	DBRowSet rowSet	  = null;							   //DB ResultSet
	String strErrMsg = "";								 //에러메세지
	int rowCount	 = 0;								  //DB ResultSet 리스트의 건수
	String ofcCd = "";	
	String CLPT_YD_KNT = "";
	String VRFY_TERMINALS = "";
	
	try {
	  // 파라미터값 저장

	   SignOnUserAccount account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   ofcCd = account.getOfc_cd()!=null&&!account.getOfc_cd().equals("")?account.getOfc_cd():"";

		event = (EsdTes9010Event)request.getAttribute("Event");

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}else{
		
		} // end else
			
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		if (eventResponse!=null){
			CLPT_YD_KNT = JSPUtil.getNull(eventResponse.getETCData("CLPT_YD_KNT"));
			VRFY_TERMINALS = JSPUtil.getNull(eventResponse.getETCData("VRFY_TERMINALS"));
		}
		
	}catch(Exception e) {
		out.println(e.toString());
	}
	
	String cntr_tpsz_cd = request.getParameter("cntr_tpsz_cd")!=null&&!request.getParameter("cntr_tpsz_cd").trim().equals("")?request.getParameter("cntr_tpsz_cd"):"";
%>
<html>
<head>
<title>Get Container List Pop Up</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
<%= JSPUtil.getIBCodeCombo("io_bnd_cd"		, "01", "CD00592", 0, "")%>
<%= JSPUtil.getIBCodeCombo("cntr_sty_cd"	, "01", "CD00136", 0, "")%>
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
	var CLPT_YD_KNT			= "<%=CLPT_YD_KNT%>";
	var VRFY_TERMINAL_LIST 	= "<%=VRFY_TERMINALS%>";	
</script>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input	type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="vvd">
<input type="hidden" name="vndr_seq">
<input type="hidden" name="yd_cd">
<input type="hidden" name="rcv_dt">
<input type="hidden" name="iss_dt">
<input type="hidden" name="verify_chk">
<input type="hidden" name="excel_chk">
<input type="hidden" name="tml_so_ofc_cty_cd">
<input type="hidden" name="tml_so_seq">
<input type="hidden" name="io_bnd_cd"><!-- file import 시 여기값이 하나가 더들어가서 문제가 생김 -->
<input type="hidden" name="vvd_type">
<input type="hidden" name="atb_dt">
<input type="hidden" name="fbp_exist">
<input type="hidden" name="all_tp">
<input type="hidden" name="fm_tp">
<input type="hidden" name="ts_tp">
<input type="hidden" name="cntr_tpsz_cd" value="<%=JSPUtil.getNull(cntr_tpsz_cd)%>">
<input type="hidden" name="call_yd_ind_seq">
<input type="hidden" name="clpt_ind_seq">
<input type="hidden" name="call_yd_seq_chk">

<table width="500" class="popup" cellpadding="10">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp;Get Container List</td></tr>
		</table>
		<!-- : ( Title ) (E) -->

		<!-- TABLE '#D' : ( Button : Main ) (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
				<tr><td class="btn1_bg">

						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_loadexcel" id="btn_loadexcel">Load Excel</td><td class="btn1_right"></td></tr></table></td>
							<!-- Repeat Pattern -->

						</tr></table>

				</td></tr>
		</table>
		<!-- TABLE '#D' : ( Button : Main ) (E) -->

		<!-- TABLE '#D' : ( Search Options : Speed ) (S) -->
     	<table class="search">
       	<tr><td class="bg">

				<table class="search" border="0" style="width:460;">
					<tr class="h23">
						<td width="110">File Import</td>
						<td width="130" class="stm">
							<input type="radio" name="file_import_yn" value="Y"  class="trans" onclick="sml_list_only_sts()">Yes&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="file_import_yn" value="N"  class="trans" onclick="sml_list_only_sts()">No
						</td>
						<!-- 
						<td>
						<div id="vrfy_terminal" style="display:none">
							
							<table>
								<tr class="h23">
									<td width="80" style="color:red;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Terminal</td>
									<td>&nbsp;&nbsp;<script language="javascript">ComComboObject('vrfy_tml_cd', 1, 91, 1, 1)</script></td>
								</tr>
							</table>
						</div>
						</td>
						-->
					</tr>
					<tr class="h23">
						<td width="110">SML List Only</td>
						<td width="130" class="stm" colspan=3>
							<input type="radio" name="sml_list_yn" value="Y"  class="trans" >Show&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="sml_list_yn" value="N"  class="trans" >Hide
						</td>
					</tr>
					<tr class="h23">
						<td width="110"><span title='It is possible to input the CNTR No. manually by selecting YES'>Manual Input</span></td>
						<td  width="130" class="stm" colspan=3>
							<input type="radio" name="manual_input_yn" value="Y"  class="trans" onclick="sml_list_only_sts()">Yes&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="manual_input_yn" value="N"  class="trans" onclick="sml_list_only_sts()">No
						</td>
					</tr>
					<tr class="h23">
						<td width="110">Cargo Type</td>
						<td class="stm" colspan=3>&nbsp;&nbsp;
							ALL<input type="checkbox" value="" desc="ALL" class="trans" name="import_tp_all">&nbsp;
							Local<input type="checkbox" value="" desc="L" class="trans" name="import_ts_tp">&nbsp;
							T/S<input type="checkbox" value="" desc="T" class="trans" name="import_ts_tp">&nbsp;
							Full<input type="checkbox" value="" desc="F" class="trans" name="import_fm_tp">&nbsp;
							MTY<input type="checkbox" value="" desc="M" class="trans" name="import_fm_tp">&nbsp;
						</td>
					</tr>
					<tr class="h23">
						<td width="110">W/O No.</td>
						<td class="stm" colspan=3>
							<table>
							<tr>
							<td width="159"><input type="text" name="wo_no" value="" style="width:150">
							</td>
							<td class="btn2_bg" class="align">
								<table border="0" cellpadding="0" cellspacing="0">
									<tr>
										<!-- Repeat Pattern -->
										<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn2_left"></td><td class="btn2" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
										<td class="btn2_right"></td></tr></table></td>
										<!-- Repeat Pattern -->
									</tr>
								</table>
							</td>
							</tr>
							</table>
						</td>
					</tr>
				</table>

			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options : Speed ) (E) -->

		<table class="height_10"><tr><td></td></tr></table>


		<!-- TABLE '#D' : ( Search Options : Speed ) (S) -->
     	<table class="search">
       	<tr><td class="bg">


				<!-- : ( Speed ) (S) -->
                    <table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet');</script>
                        </td></tr>
                    </table>
				<!-- : ( Speed ) (E) -->

				<table class="height_5"><tr><td></td></tr></table>


				<!--table class="search" border="0" style="width:362;">
					<tr class="h23">
						<td width="20%">SML Source</td>
						<td class="stm"><input type="radio" name="src_div" value="FBP"  class="trans">Final Bay Plan&nbsp;
														<input type="radio" name="src_div" value="BOOK" class="trans">Booking&nbsp;
														<input type="radio" name="src_div" value="WS"   class="trans">Water S/O
						</td>
					</tr>
				</table-->




			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options : Speed ) (E) -->




</td></tr>
</table>

<table class="height_10"><tr><td></td></tr></table>


<!-- : ( Button : Sub ) (S) -->
<table width="100%" class="sbutton" border=0>
		<tr><td height="71" class="popup">

			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
	       		<tr><td class="btn3_bg">
			    <table border="0" cellpadding="0" cellspacing="0">
			    <tr>

					<!-- Repeat Pattern -->
					<!-- CHM-201641075 Get CNTR List화면에서 Multi-Row Add기능 추가 -->
					<td><table border="0" cellpadding="0" cellspacing="0">
						<tr><td><input type="text" name="rowsadd" size="2" value="1" maxlength="4"></td></tr></table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" name="btn_rowadd" id="btn_rowadd">Add</td><td class="btn1_right"></td></tr></table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" name="btn_rowdel" id="btn_rowdel">Delete</td><td class="btn1_right"></td></tr></table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" name="btn_chkdigit" id="btn_chkdigit">CHK Digit</td><td class="btn1_right"></td></tr></table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" name="btn_verify" id="btn_verify">Verify</td><td class="btn1_right"></td></tr></table></td>
					<!-- Repeat Pattern -->

				</tr>
			</table>

		</td></tr>
</table>
<!-- : ( Button : Sub ) (E) -->
</form>
</body>
</html>
