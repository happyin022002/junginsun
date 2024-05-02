<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_SPC_0052.jsp
*@FileTitle : spaceallocationmanage
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.22
*@LastModifier : 한상훈
*@LastVersion : 1.0
* 2009.09.22 한상훈
* 1.0 Creation

* 2011.09.22 김종준 [CHM-201113515-01] SPC내에서 사용하고 있는 Tag Library 제거 작업
* 2013.01.23 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
* 2014.07.30 [CHM-201431081] SPC Allocation Control Option 추가 보완
* 2015.01.02 Arie [CHM-201433401]Control Option Registration - Upload기능 추가 요청
* 2015.06.11 김성욱 [CHM-201535211] SPC BKG 연동
* 2015.06.24 이혜민 [CHM-201535810] [SPC] Fixed Rate 계약 정보의 SPC 적용 개발 요청 
* 2015.07.24 Arie [CHM-201537010] Control Option Management 및 VVD별 EDIT기능 보완 - 패키지 이동
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.event.EsmSpc0052Event"%>
<%@ page import="com.hanjin.framework.component.util.code.CodeInfo"%>
<%@ page import="com.hanjin.apps.alps.esm.spc.common.SPCUtil"%>
<%@ page import="java.util.List"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmSpc0052Event  event = null;			//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;		//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.BasicDataManage.ConstraintMaster");
	String[] arrCtrlTp = null;	//aloc_ctrl_tp_cd

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmSpc0052Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		arrCtrlTp		= SPCUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("CtrlTp"), false);

		
	}catch(Exception e) {
		out.println(e.toString());
	}
	
%>
<html>
<head>
<title>spaceallocationmanage</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
var arrCtrlTpComboCd = "<%=arrCtrlTp[0]%>";
var arrCtrlTpComboNm = "<%=arrCtrlTp[1]%>";

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
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_new" id="btn_new">New</td><td class="btn1_right"></td></tr></table></td>

							<td class="btn1_line"></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_save" id="btn_save">Save</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_downexcel" id="btn_downexcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>
							
							<td class="btn1_line"></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_match" id="btn_match">Match Back</td><td class="btn1_right"></td></tr></table></td>
																					
							<!-- Repeat Pattern -->

						</tr></table>

				</td></tr>
		</table>
    	<!-- TABLE '#D' : ( Button : Main ) (E) -->

	 	<!-- TABLE '#D' : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg">

				<!-- : ( Year ) (S) -->
				<table class="search_in" border="0">
				<tr style="display:none;" class="h23">
					<td width="80"><img class="nostar">Period</td>
					<td colspan="10" style="padding-left:2">
						<select class="input1" name="year1" style="width:60;" onchange="checkWeek1();"></select>
						<select class="input1" name="week1" style="width:50;"></select>&nbsp;
					</td>
				</tr>
				<tr class="h23">
					<td width="80"><img class="nostar">Rep. Trade</td>
					<td width="170">&nbsp;
						<script language="JavaScript">ComComboObject("trade", 2, 60, 0, 0);</script>
					</td>
					<td width="80"><img class="nostar">Sub Trade</td>
					<td width="140">&nbsp;
						<script language="JavaScript">ComComboObject("subtrade", 3, 50, 0, 0);</script>
					</td>
					<td width="45"><img class="nostar">Lane</td>
					<td width="140">
						<script language="JavaScript">ComComboObject("lane", 4, 80, 0, 0);</script>
					</td>
					<td width="50"><img class="nostar">Bound</td>
					<td width="140">&nbsp;
						<select name="bound" style="width:50;"></select>
					</td>
				</tr>

				</table>
				<!-- : ( Year ) (E) -->
			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->
		<table class="height_10"><tr><td></td></tr></table>

		<!-- TABLE '#D' : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg">

			<!-- : ( grid ) (S) -->
			<table  border="0" class="search">
				<tr><td>
					<table width="100%" id="mainTable">
						<tr><td>
							 <script language="javascript">ComSheetObject('sheet1');</script>
						</td></tr>
					</table>
				</td></tr>
			</table>
			<!-- : ( grid ) (E) -->


			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->

		<table class="height_10"><tr><td></td></tr></table>
		

		<!-- TABLE '#D' : ( Search Options ) (S) -->		
     	<table class="search" id="search2">
       	<tr><td class="bg">

			<!-- : ( grid ) (S) -->
			<table  border="0" class="search">
				<tr><td width="68%">
					<table width="100%">
						<tr>
							<td><span id="acc_rep_trade">&nbsp;</span></td>
							<td><span id="acc_sub_trade"></span></td>
							<td><span id="acc_lane"></span></td>
							<td><span id="acc_bound"></span></td>
						</tr>
					</table>
				</td>
				<!-- <td width="15%">
					<table width="100%" style="text-align:center">
						<tr>
							<td><span id="acc_control"></span></td>
						</tr>
					</table>
				</td> -->
				<td width="32%">
					<table width="100%" style="text-align:center">
						<tr>
							<td><span id="yg_title">Booking Control option</span></td>
						</tr>
					</table>
				</td>
				</tr>
				
				<tr><td>
					<table width="100%" id="mainTable2">
						<tr><td>
							 <script language="javascript">ComSheetObject('sheet2');</script>
						</td></tr>
					</table>
				</td>
				<!-- <td>
					<table width="100%" id="mainTable3" style="margin-left:10px">
						<tr><td>
							 <script language="javascript">ComSheetObject('sheet3');</script>
						</td></tr>
					</table>
				</td> -->
				<td>
					<table width="93%" id="mainTable4" style="margin-left:20px;">
						<tr><td>
							 <script language="javascript">ComSheetObject('sheet4');</script>
						</td></tr>
					</table>
				</td></tr>
				
				<tr><td>
                    <!----btn area--start------------------>
                    <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:0;">
                        <tr>
                            <td class="btn1_bg">
                                <table border="0" cellpadding="0" cellspacing="0"><tr>
	                                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button_in"><tr>
	                                    <td class="btn2_left"></td><td class="btn2" name="btn_sheet2RowAdd">Row Add</td><td class="btn2_right"></td>
	                                    </tr></table>
	                                </td>
	                                <!-- <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button_in"><tr>
	                                    <td class="btn2_left"></td><td class="btn2" name="btn_sheet2RowDelete">Row Delete</td><td class="btn2_right"></td>
	                                    </tr></table>
	                                </td> -->
	                                <td class="btn1_line"></td>
	                                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button_in"><tr>
	                                    <td class="btn2_left"></td><td class="btn2" name="btn_sheet2Save">Save</td><td class="btn2_right"></td>
	                                    </tr></table>
	                                </td>
	                                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button_in"><tr>
	                                    <td class="btn2_left"></td><td class="btn2" name="btn_sheet2Excel">Down Excel</td><td class="btn2_right"></td>
	                                    </tr></table>
	                                </td>
	                                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button_in"><tr>
	                                    <td class="btn2_left"></td><td class="btn2" name="btn_import">Import</td><td class="btn2_right"></td>
	                                    </tr></table>
	                                </td>  
                                </tr></table>
                            </td>
                        </tr>
                    </table>
                    <!----------btn area--end------------------>				
				</td>
				<!-- <td>
					<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:0;" style="margin-left:10px">
                        <tr>
                            <td class="btn1_bg">
                                <table border="0" cellpadding="0" cellspacing="0"><tr>
	                                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button_in"><tr>
	                                    <td class="btn2_left"></td><td class="btn2" name="btn_sheet3RowAdd">Row Add</td><td class="btn2_right"></td>
	                                    </tr></table>
	                                </td>
	                                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button_in"><tr>
	                                    <td class="btn2_left"></td><td class="btn2" name="btn_sheet3RowDelete">Delete</td><td class="btn2_right"></td>
	                                    </tr></table>
	                                </td>
	                                <td class="btn1_line"></td>
	                                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button_in"><tr>
	                                    <td class="btn2_left"></td><td class="btn2" name="btn_sheet3Save">Save</td><td class="btn2_right"></td>
	                                    </tr></table>
	                                </td>
                                </tr></table>
                            </td>
                        </tr>
                    </table>
				</td> -->
				<td>
					<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:0;">
                        <tr>
                            <td class="btn1_bg">
                                <table border="0" cellpadding="0" cellspacing="0"><tr>
	                                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button_in"><tr>
	                                    <td class="btn2_left"></td><td class="btn2" name="btn_sheet4RowAdd">Row Add</td><td class="btn2_right"></td>
	                                    </tr></table>
	                                </td>
	                                <td class="btn1_line"></td>
	                                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button_in"><tr>
	                                    <td class="btn2_left"></td><td class="btn2" name="btn_sheet4Save">Save</td><td class="btn2_right"></td>
	                                    </tr></table>
	                                </td>
                                </tr></table>
                            </td>
                        </tr>
                    </table>
				</td></tr>
				
			</table>
			<!-- : ( grid ) (E) -->


			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->
				
</td></tr>
</table>
<!-- Outer Table (E)-->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>