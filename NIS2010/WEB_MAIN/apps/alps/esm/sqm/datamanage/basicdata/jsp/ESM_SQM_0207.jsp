<%
/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : ESM_SQM_0207.jsp
*@FileTitle      : Basic Data Creation for IAS Sector
*Open Issues     :
*Change history  :
*@LastModifyDate : 2014.01.06
*@LastModifier   : SQM USER
*@LastVersion    : 1.0
* 2014.01.06 SQM USER
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
<%@ page import="com.hanjin.apps.alps.esm.sqm.datamanage.basicdata.event.EsmSqm0207Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmSqm0207Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.datamanage.basicdata");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmSqm0207Event)request.getAttribute("Event");
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
<title>Basic Data Creation for IAS Sector</title>
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

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
	<tr>
		<td>
			<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
			</table>
			<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->
			
			<!--Button_L (S) -->
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
				<tr>
					<td class="btn1_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<!-- Repeat Pattern -->
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" id="btn_Retrieve" name="btn_Retrieve">Retrieve</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								
								<td class="btn1_line"></td>
								
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" id="btn_Creation" name="btn_Creation">Creation</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" id="btn_Downexcel" name="btn_Downexcel">Down Excel</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>

								<!-- Repeat Pattern -->
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<!--Button_L (E) -->
		
			<!-- TABLE '#D' : ( Search Options ) (S) -->
			<table class="search">
				<tr>
					<td class="bg">
						<table class="search" border="0">
							<tr>
  								<td width="105" rowspan="2">
									<table class="search_sm2" width="95">
										<tr class="h23"><td><input type="radio" name="f_bse_tp_cd" class="trans" value="Y"><label style="padding-left:2;">Yearly</label></td></tr>
										<tr class="h23"><td><input type="radio" name="f_bse_tp_cd" class="trans" value="Q" checked><label style="padding-left:2;">Quarterly</label></td></tr>
									</table>
								</td>							
								<td width="">
									<table class="search" border="0">
										<tr class="h23">
											<td width="70">Year</td>
											<td width="70"><script language="javascript">ComComboObject('f_bse_yr', 1, 60, 1, 1)</script></td>
											<td width="70"><div id="div_qtr">Quarter</div></td>
											<td width="90"><script language="javascript">ComComboObject('f_bse_qtr_cd', 1, 85, 1, 1)</script></td>
											<td width="150" class='sm' colspan = '2'><div id="div_period"></div></td>
											<td width="80">Office View</td>
											<td width="80"><script language="javascript">ComComboObject('f_ofc_vw_cd', 1, 70, 1, 1)</script></td>
											<td width="40">RHQ</td>
											<td width="80"><script language="javascript">ComComboObject('f_rhq_cd', 1, 70, 1)</script></td>
											<td width="40">Office</td>
											<td width="80"><script language="javascript">ComComboObject('f_rgn_ofc_cd', 1, 70, 1)</script></td>
										</tr>
										<tr class="h23">
											<td width="70">Sub Trade</td>
											<td width="70"><script language="javascript">ComComboObject('f_sub_trd_cd', 1, 60, 1)</script></td>
											<td width="70">IAS Region</td>
                                            <td width="90"><script language="javascript">ComComboObject('f_ias_rgn_cd', 1, 85, 1)</script></td>
											<td width="80">Lane Bound</td>
											<td width="70"><script language="javascript">ComComboObject('f_dir_cd', 1, 60, 1)</script></td>
											<td width="80">R/Lane</td>
											<td width="80"><script language="javascript">ComComboObject('f_rlane_cd', 1, 70, 1)</script></td>
											<td width="40">POL</td>
											<td width="80"><script language="javascript">ComComboObject('f_pol_cd', 1, 70, 1)</script></td>
											<td width="40">POD</td>
											<td width=""><script language="javascript">ComComboObject('f_pod_cd', 1, 70, 1)</script></td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>	
			<!-- TABLE '#D' : ( Search Options ) (E) -->

			<table class="height_10"><tr><td></td></tr></table>	

			<!-- TABLE '#D' : ( Search Options ) (S) -->
			<table class="search" border="0">
				<tr>
					<td class="bg_b1">
						<table class="height_10"><tr><td></td></tr></table>
						<table width="100%" class="search">
							<tr>
								<td><font color="blue" >[ Creation Source Data Period : <span id="span_period"></span>&nbsp;]</font></td>
								<td style="text-align:right;">[Unit : TEU, $]</td>
							</tr>
						</table>
						<!-- : ( POR ) (S) -->
						<table width="100%" id="mainTable">
							<tr>
								<td><script language="javascript">ComSheetObject('sheet1');</script></td>
							</tr>
						</table>
						<!-- : ( POR ) (E) -->
					</td>

				</tr>
				
			</table>
			<!-- TABLE '#D' : ( Search Options ) (E) -->
		</td>
	</tr>
</table>
<!-- Outer Table (E)-->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>