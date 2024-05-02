<%/*=========================================================
*Copyright(c) 2017 SM Line
*@FileName : ui_bkg_1085.jsp
*@FileTitle : ACI_Vessel Information
*Open Issues :
*Change history :
*@LastModifyDate : 2017.11.14
*@LastModifier : 하대성
*@LastVersion : 1.0
* 2017.11.14 하대성  두바이 세관 라이브 반영
* 2009.04.24 김민정
* 1.0 Creation
=========================================================*/%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.dubai.event.EsmBkg1085Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	EsmBkg1085Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.CustomsDeclaration.ManifestListDownload");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (EsmBkg1085Event)request.getAttribute("Event");
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
<title></title>
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
<input type="hidden" name="tab_no" value="1">
<input type="hidden" name="sheet_no">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr>
		<td valign="top">
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
			</table>
			
<table class="search" id="mainTable">
	<tr>
		<td class="bg">
			<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="160">
						<table class="search_sm2" border="0" style="width:90%;"> 
							<tr class="h23">
								<td width="">Data&nbsp;</td>
								<td class="stm">
									<input type="radio" class="trans" name="data_type" value="bl">B/L &nbsp;&nbsp;
									<input type="radio" class="trans" name="data_type" value="dl" checked="checked">D/L </td>
							</tr>
						</table>
					</td>
					<td width="25">VVD</td>
					<td width="100"><input type="text" style="width:80;ime-mode:disabled" class="input1" 
						name="vvd" maxlength="9" dataformat="eng" caption="VVD" fullfill value=""></td>
					<td width="80">Vessel Name</td>
					<td width="100"><input type="text" style="width:90;" class="input2" name="vvd_nm" readonly="readonly"></td>
					<td width="25">POL</td>
					<td width="70"><input type="text" style="width:50;ime-mode:disabled" class="input" 
						name="pol_cd" maxlength="5" dataformat="engupnum" caption="POL" fullfill></td>
					<td width="25">POD</td>
					<td width="70"><input type="text" style="width:50;ime-mode:disabled" class="input1" 
						name="pod_cd" maxlength="5" dataformat="engupnum" caption="POD" fullfill value=""></td>
					<td width="55">&nbsp;B/L No.</td>
					<td width="120"><input type="text" style="width:100;ime-mode:disabled" class="input" 
						name="bl_no" maxlength="12" dataformat="eng" caption="B/L No." fullfill></td>
					<td>
					<div style="display:none" id="cgo1">
						<table class="search_sm2" border="0" style="width:150;"> 
						<tr class="h23">
							<td>Cargo Type</td>
							<td width="" class="stm">
								<select name="cgo_type" style="width:50;">
									<option value="">All</option>
									<option value="F" selected>Full</option>
									<option value="M">Empty</option>
								</select>
							</td>
						</tr>
						</table>
					</div>
					
					<div id="cgo2">
						<table class="search_sm2" border="0" style="width:150;"> 
						<tr class="h23">
							<td>Cargo Code</td>
							<td width="" class="stm">
								<script language="javascript">ComComboObject('cgo_code', 2, 50, 1, 0);</script>
							</td>
						</tr>
						</table>
					</div>
					
					</td>
				
				</tr>

				
				
			</table>
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
			<table class="search" border="0" style="width:979;" > 
				<tr class="h23">
					<td>
						<table class="search_sm2" border="0" style="width:100%"> 
						<tr class="h23">
							<td width="80">Arrival Date</td>
							<td width="130">
								<input type="text" style="width:80;ime-mode: disabled" class="input" maxlength="10"
									dataformat="ymd" name="eta_dt" caption="Arrival Date">
								<img src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" class="cursor" name="btn_calendar">
							</td>
							<td width="80">Rotation No.</td>
							<td width="110"><input type="text" style="width:90;ime-mode:disabled" class="input" 
								name="rotn_no" maxlength="10" dataformat="eng" caption="Rotation No."></td>
						
							<td width="120">No. of Installment</td>
							<td width="80"><input type="text" style="width:50;ime-mode:disabled" class="input" 
								name="instl_no" maxlength="4" dataformat="int" caption="No. of Installment"></td>
						
							<td width="60">MRN No.</td>
							<td width="110"><input type="text" style="width:80;ime-mode:disabled" class="input" 
								name="mrn_no" maxlength="7" dataformat="eng" caption="MRN No."></td>
							<td width="160">
								<div id="cgo3">
									<table class="search_sm2" border="0" style="width:150;"> 
										<tr class="h23">
											<td>Trade Code</td>
											<td width="" class="stm">
												<script language="javascript">ComComboObject('du_trd_cd', 2, 50, 1, 0);</script>
											</td>
										</tr>
									</table>
								</div>
							</td>
						</tr>
						</table>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
<table class="height_8"><tr><td></td></tr></table>
<!-- Tab (S) -->
<table class="tab" border="0" cellpadding="0" cellspacing="0" width="900">
	<tr>
		<td width="100%">
			<script language="javascript">ComTabObject('tab1')</script>
		</td>
	</tr>
</table>
<!-- Tab (E) -->

<!-- (TAB) BL (S) -->
<div id="tabLayer">
<table class="search">
	<tr>
		<td class="bg">
			<table width="100%"  id="mainTable">
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet1');</script>
					</td>
				</tr>
			</table>
			
			<table width="100%" class="button"> 
	       		<tr>
	       			<td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn2_left"></td>
											<td class="btn2" name="btn_bl">B/L Detail</td>
											<td class="btn2_right"></td>
										</tr>
									</table>
								</td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn2_left"></td>
											<td class="btn2" name="btn_cust">Customer Detail</td>
											<td class="btn2_right"></td>
										</tr>
									</table>
								</td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn2_left"></td>
											<td class="btn2" name="btn_Unit">Package Unit</td>
											<td class="btn2_right"></td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
</div>
<!-- (TAB) BL (E) -->

<!-- (TAB) Container (S) -->
<div id="tabLayer" style="display:none">
<table class="search">
	<tr>
		<td class="bg">
			<table width="100%"  id="mainTable">
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet2');</script>
					</td>
				</tr>
			</table>
			
			<table width="100%" class="button"> 
	       		<tr>
	       			<td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn2_left"></td>
											<td class="btn2" name="btn_bl">B/L Detail</td>
											<td class="btn2_right"></td>
										</tr>
									</table>
								</td>
								<td class="btn1_line"></td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn2_left"></td>
											<td class="btn2" name="btn_cust">Customer Detail</td>
											<td class="btn2_right"></td>
										</tr>
									</table>
								</td>
								<td class="btn1_line"></td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn2_left"></td>
											<td class="btn2" name="btn_Unit">Package Unit</td>
											<td class="btn2_right"></td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
</div>

<!--Button (S) -->
<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
	<tr>
		<td class="btn1_bg">
			<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_Retrieve" id="btn_retrieve">Retrieve</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_New">New</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
					<td class="btn1_line"></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_Save">Save</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_Edi">EDI File Download</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_Excel">Excel File Download</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
				</tr>
			</table>
		</td>
	</tr>
</table>
<!--Button (E) -->
		</td>
	</tr>
</table>

<!--EDI File Download용 hidden Sheet(S) -->
<table width="100%" id="mainTable" style="display:inline">
    <tr>
        <td width="100%"><script language="javascript">ComSheetObject('sheet3');</script></td>
    </tr> 
</table>
<!--EDI File Download용 hidden Sheet (E) -->
</form>
</body>
</html>