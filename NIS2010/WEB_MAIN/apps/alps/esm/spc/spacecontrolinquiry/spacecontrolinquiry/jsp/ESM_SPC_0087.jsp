<%
/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESM_SPC_0087.jsp
*@FileTitle : T/S Plan & Guide
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.17
*@LastModifier : 이혜민
*@LastVersion : 1.0
* 2016.03.17 이혜민
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
<%@ page import="com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.event.EsmSpc0087Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmSpc0087Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.Spacecontrolinquiry.Spacecontrolinquiry");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmSpc0087Event)request.getAttribute("Event");
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
<title>T/S Plan & Guide</title>
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

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->

<!-- OUTER Table (S)tart -->
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
			<tr>
				<td class="btn1_bg">
					<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_retrieve" id="btn_retrieve" >Retrieve</td><td class="btn1_right"></td></tr>
							</table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_new" id="btn_new" >New</td><td class="btn1_right"></td></tr>
							</table></td>
	
							<td class="btn1_line"></td>
	
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_save" id="btn_save" >Save</td><td class="btn1_right"></td></tr>
							</table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_downexcel" id="btn_downexcel">Down Excel</td><td class="btn1_right"></td></tr>
							</table></td>
							<!-- Repeat Pattern -->
						</tr>
					</table>
				</td>
			</tr>
		</table>
    	<!-- TABLE '#D' : ( Button : Main ) (E) -->

	 	<!-- TABLE '#D' : ( Search Options ) (S) -->
     	<table class="search">
       		<tr><td class="bg">
				<table class="search_in" border="0">
					<tr>
						<td>
							<table class="search_in" border="0">
								<tr class="h23">
									<td width="90"><img class="nostar">Start Week</td>
									<td width="142" style="padding-left:1">
										<select class="input1" name="year" style="width:60;" onchange="checkWeek();"></select>
										<select class="input1" name="week" style="width:40;"></select>
									</td>
									<td width="80"><img class="nostar">Duration</td>
									<td width="130">
									<select class="input1" name="duration" size="1"></select>
									</td>
									<td width="50"><img class="nostar">VVD</td>
									<td width="*"><input class="input1" name="vvd" maxlength="9" style="ime-mode:disabled; width:87;" onkeypress="eventKeyChangeChar(UPPER_CASE);"></td>
								</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td>
							<table class="search_in" border="0">
								<tr class="h23">
								<td width="90"><img class="nostar">Rep. Trade</td>
								<td width="140" style="padding-left:3">
									<script language="JavaScript">ComComboObject("trade", 2, 60, 0, 1);</script>
								</td>
								<td width="79"><img class="nostar">Sub Trade</td>
								<td width="130" style="padding-left:3">
									<script language="JavaScript">ComComboObject("subtrade", 3, 50, 0, 1);</script>
								</td>
								<td width="50"><img class="nostar">Lane</td>
								<td width="150">
									<script language="JavaScript">ComComboObject("lane", 4, 87, 0, 0);</script>
								</td>
								<td width="60"><img class="nostar">Bound</td>
								<td width="*">
									<select name="bound" style="width:50;"></select>
								</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->

		<table class="height_10"><tr><td></td></tr></table>

		<!-- TABLE '#D' : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg">
			<!-- : ( grid ) (S) -->
			<table width="100%" id="mainTable1">
                      <tr><td>
                           <script language="javascript">ComSheetObject('sheet1');</script>
                      </td></tr>
            </table>
			<!-- : ( grid ) (E) -->
			<!-- : ( Button : Sub ) (S) -->
	  		<table width="100%" class="button">
				<tr><td class="btn2_bg">
					<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" name="btng_main_rowAdd" id="btng_main_rowAdd">Row Add</td><td class="btn2_right"></td></tr></table></td>
						</tr>
					</table>
				</td></tr>
			</table>
    		<!-- : ( Button : Sub ) (E) -->
			</td></tr>
		</table>



		<table class="height_10"><tr><td></td></tr></table>

		<!-- TABLE '#D' : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg">
			<table border="0">
			<tr class="h23">
				<td width="30">VVD</td>
				<td width="90"><input type="text" style="width:75; text-align:center;" value="" readonly name="txtVVD"></td>
				<td width="26">WK</td>
				<td width="80"><input type="text" style="width:60; text-align:center;" value="" readonly name="txtWeek"></td>
				<td width="80">Plan Status</td>
				<td width="100">
					<select name="ts_pln_cfm_sts_cd" style="width:100;" class="input" onchange="ts_pln_cfm_sts_cd_OnChange();">
					
						<option value="All" selected="selected">All</option>
						<option value="Y">Confirm Yes</option>
						<option value="N">Confirm No</option>
						<option value="X">Cancel</option>
					</select>
				</td>
				<td width="60"><input type="hidden" style="width:60; text-align:center;" value="" name="txtRepTrd"></td>
				<td width="60"><input type="hidden" style="width:60; text-align:center;" value="" name="txtRepSubTrd"></td>
				<td width="60"><input type="hidden" style="width:60; text-align:center;" value="" name="txtRlane"></td>
				<td width="60"><input type="hidden" style="width:60; text-align:center;" value="" name="txtDir"></td>
				<td width="60"><input type="hidden" style="width:60; text-align:center;" value="" name="txtIrrPort"></td>
				<td width="*"><input type="hidden" style="width:60; text-align:center;" value="" name="txtIrrYd"></td>
			</tr>
			</table>

			<table width="100%" id="mainTable2">
                   <tr><td>
                        <script language="javascript">ComSheetObject('sheet2');</script>
                   </td></tr>
            </table>
			<!-- : ( Grid :  ) (E) -->
 

    		<!-- : ( Button : Sub ) (S) -->
   			<table width="100%" class="button">
				<tr><td class="btn2_bg">
					<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" name="btng_save" id="btng_save">Save</td><td class="btn2_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" name="btng_tsAdd" id="btng_ts_add">T/S Add</td><td class="btn2_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" name="btng_tsDel" id="btng_ts_del">T/S Del</td><td class="btn2_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" name="btng_rowAdd" id="btng_rowAdd">Row Add</td><td class="btn2_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" name="btng_rowCopy" id="btng_rowCopy">Row Copy</td><td class="btn2_right"></td></tr></table></td>
						</tr>
					</table>
				</td></tr>
		</table>
    			<!-- : ( Button : Sub ) (E) -->
		</td></tr>
	</table> 
</td></tr>
</table>
<!-- Outer Table (E)-->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>