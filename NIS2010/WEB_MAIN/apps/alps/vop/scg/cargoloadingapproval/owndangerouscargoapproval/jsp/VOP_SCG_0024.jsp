<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_scg_0024.jsp
*@FileTitle : Systematic Inspection Filtering Text
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.24
*@LastModifier : 김도현
*@LastVersion : 1.0
* 2015.06.24 김도현
* 1.0 Creation

*history
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.event.VopScg0024Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopScg0024Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag 	= "";
	String codeList  	= "";
	String pageRows 	= "100";

	String strUsr_id	= "";
	String strUsr_nm	= "";
	Logger log = Logger.getLogger("com.hanjin.apps.CargoLoadingApproval.OwnDangerousCargoApproval");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (VopScg0024Event)request.getAttribute("Event");
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
<title>SPCL CGO APVL for Own BKG</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">

	var frDt = ComGetDateAdd('<%=JSPUtil.getKST("yyyy-MM-dd")%>', "M", -1);
	var toDt = ComGetDateAdd('<%=JSPUtil.getKST("yyyy-MM-dd")%>', "M", 0);

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<input type="hidden" name="tabSelectedIdx" value="0">
<input type="hidden" name="retrieve_flg" value="N">
<input type="hidden" name="t0retrieve_flg" value="N">
<input type="hidden" name="t1retrieve_flg" value="N">
<input type="hidden" name="t2retrieve_flg" value="N">
<input type="hidden" name="t3retrieve_flg" value="N">
<input type="hidden" name="t4retrieve_flg" value="N"><!-- // Non-DG chemical -->
<input type="hidden" name="vsl_slan_cd">
<input type="hidden" name="bkg_no">
<input type="hidden" name="non_dcgo_rqst_seq">
<input type="hidden" name="content">
<input type="hidden" name="rqst_ofc_cd">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr>
		<td valign="top">
			<!--Page Title, Historical (S)-->
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
			</table>
			<!--Page Title, Historical (E)-->
			
			<!--biz page (S)-->
			<table class="search">
		       	<tr>
		       		<td class="bg">
						<!--  biz_1  (S) -->
						<table class="search" border="0" style="width:979;">
							<!-- <tr class="h23"> -->
							<tr>
<!-- 								<td width="37"><B>RSO</B></td> -->
<!-- 								<td width="90" style="padding-left:3"> -->
<!-- 							   		<script language="javascript">ComComboObject('rgn_shp_opr_cd', 3, 74, 1, 1);</script> -->
<!-- 								</td> -->
								<td width="42"><B>B/OFC</B></td>
								<td width="180">
<!-- 									<script language="javascript">ComSheetObject1('laneSheet');</script> -->
									<script language="javascript">ComSheetObject1('rqstOfcCd');</script>
								</td>
								<td title="Request date" width="60">&nbsp;<B>RQT D/T</B></td>
								<td title="Request date" width="210"><input type="text" name="rqst_fr_dt" style="width:80; text-align:center;" class="input1" dataformat="ymd" maxlength="8" caption="the from date" value="">&nbsp;~&nbsp;<input type="text" name="rqst_to_dt" style="width:80; text-align:center;" class="input1" dataformat="ymd" maxlength="8" caption="the to date" value="">&nbsp;<img src="img/btns_calendar.gif" id="btns_period" name="btns_period" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
								<td width="50">&nbsp;<B>STATUS</B></td>
								<td width="">
									<select name="non_dg_cgo_status" style="width:85;" class="input">
										<option value="R">Request</option>
										<option value="P">Pass</option>
										<option value="H">Hold</option>
										<option value="X">Undeclared</option>
									</select>
								</td>	
								<td width="40">&nbsp;<B>TYPE</B></td>
								<td width="">
									<select name="dg_flg" style="width:70;" class="input">
										<option value="">ALL</option>
										<option value="D">D/G</option>
										<option value="N">Normal</option>
									</select>
								</td>	
							</tr>
						</table>
						<!--  biz_1   (E) -->
					</td>
				</tr>
			</table>
			<table class="height_7"><tr><td></td></tr></table>
			
			<!-- Tab ) (S) -->
     		<table class="tab" border="0" cellpadding="0" cellspacing="0" style="width:100%;">
       			<tr>
       				<td width="100%">
						<script language="javascript">ComTabObject('tab1')</script>
					</td>
				</tr>
			</table>
			<!-- Tab ) (E) -->

			<!--  Tab) KEYWORD I (S) -->
			<div id="tabLayer" style="display:inline;">
	     	<table class="search">
		       	<tr>
		       		<td class="bg" style="height:408;" valign="top">
						<!-- Grid  (S) -->
						<table width="100%" class="search"  id="mainTable">
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('t1sheet1');</script>
								</td>
							</tr>
						</table>
						<!-- Grid (E) -->
					</td>
				</tr>
			</table>
			</div>	
			<!--  Tab) KEYWORD I (E) -->

			<!--  Tab) KEYWORD II (S) -->
			<div id="tabLayer" style="display:none">
	     	<table class="search">
		       	<tr>
		       		<td class="bg" style="height:408;" valign="top">
						<!-- Grid  (S) -->
						<table width="100%" class="search"  id="mainTable">
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('t2sheet1');</script>
								</td>
							</tr>
						</table>
						<!-- Grid (E) -->
					</td>
				</tr>
			</table>
			</div>
			<!--  Tab)  KEYWORD II (E) -->

			<!--  Tab) KEYWORD III (S) -->
			<div id="tabLayer" style="display:none">
			<table class="search">
				<tr>
					<td class="bg" style="height:408;" valign="top">
						<!-- Grid  (S) -->
						<table width="100%" class="search"  id="mainTable">
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('t3sheet1');</script>
								</td>
							</tr>
						</table>
						<!-- Grid (E) -->
					</td>
				</tr>
			</table>
			</div>
			<!--  Tab) KEYWORD III (E) -->

			<!--  Tab) KEYWORD IV (S) -->
			<div id="tabLayer" style="display:none">
    	 	<table class="search">
       			<tr>
       				<td class="bg" style="height:408;" valign="top">
						<!-- Grid  (S) -->
						<table width="100%" class="search"  id="mainTable">
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('t4sheet1');</script>
								</td>
							</tr>
						</table>
						<!-- Grid (E) -->
					</td>
				</tr>
			</table>
			</div>
			<!--  Tab) KEYWORD IV (E) -->
	
			<!--  Tab) NON-DG CHEMICAL (S) -->
			<div id="tabLayer" style="display:none">
    	 	<table class="search">
       			<tr>
       				<td class="bg" style="height:408;" valign="top">
						<!-- Grid  (S) -->
						<table width="100%" class="search"  id="mainTable">
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('t5sheet1');</script>
								</td>
							</tr>
						</table>
						<!-- Grid (E) -->
					</td>
				</tr>
			</table>
			</div>
			<!--  Tab) NON-DG CHEMICAL (E) -->
			
			<!--Button (S) -->
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;">
		     	<tr>
		     		<td class="btn1_bg">
					    <table border="0" cellpadding="0" cellspacing="0">
						    <tr>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td>
									<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_New">New</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td class="btn1_line"></td>
								<td>
									<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_Save">Save</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<!--Button (E) -->
		</td>
	</tr>
</table>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>