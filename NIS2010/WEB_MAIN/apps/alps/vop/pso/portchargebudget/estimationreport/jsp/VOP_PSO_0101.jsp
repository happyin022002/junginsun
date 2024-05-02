<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_pso_0101.jsp
*@FileTitle : Monthly Estimation Comparison
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.02
*@LastModifier : 조정민
*@LastVersion : 1.0
* 2009.07.07 김진일
* 1.0 Creation
* 2013.09.03 SKY   CHM-201326398 Monthly Estimation Comparision 검색 조건(Scenario CD) 추가
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.pso.portchargebudget.estimationreport.event.VopPso0101Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopPso0101Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String scn_dt = DateTime.getDateString().substring(0,4);
	Logger log = Logger.getLogger("com.hanjin.apps.PortChargeBudget.EstimationReport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopPso0101Event)request.getAttribute("Event");
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
<title>Lane/Port Expense Ratio Creation</title>
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
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="raw_flg">
<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
	</table>
	<!--Page Title, Historical (E)-->
	
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
				<!--  biz_1  (S) -->
				
				<table class="search" border="0" style="width:990;"> 
					<tr class="h23">
						<td width="110">Revenue Month</td>
						<td width="90">
							<input type="text" name="rev_yrmon" dataformat="ym" caption="시작년월" maxlength="7" size="10" cofield="rev_yrmon" style="width:60;" class="input1" value="">&nbsp;<img name="btns_calendar_s" src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
						</td>
						
						<td width="75">Scenario CD</td>
						<td width="120">
							<input type="text" name="scn_dt" style="width:40;text-align:center;" class="input1" caption="Period FM" dataformat="y" size="4" maxlength="4" fulfill required value="<%=scn_dt %>">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendarsn"  id="btns_calendarsn">&nbsp;
							<script language="javascript">ComComboObject('scn_cd',1,50,0,1);</script>
						</td>

                    <td width="590">
                        <table class="search_ssm1" border="0" style="width:590">
                        <tr class="h23">

						
							<td width="140">This Month vs Budget</td>
							<td width="20"><input type="radio" name="chk_rdo" value="B" class="trans" checked></td>
							<td width = "0">&nbsp;</td>
							<td width="190">This Month vs Previous Month</td>
							<td width="20"><input type="radio" name="chk_rdo" value="PM" class="trans" ></td>
							<td width = "0">&nbsp;</td>
							<td width="180">This Month vs Previous Year</td>
							<td width="20"><input type="radio" name="chk_rdo" value="PY" class="trans" ></td>
					
                        </tr>
                        </table>
                    </td>

					</tr>
				</table>
				<!--  biz_1   (E) -->
				
				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
				
				
				
				<!--  biz_2  (S) -->
				
				<!-- Grid  (S) -->
					<table width="979"  id="mainTable">
						<tr>
							<td width="310">
								<script language="javascript">ComSheetObject('sheet1');</script>
							</td>
							<td width="2%"></td>
							<td width="310">
								<script language="javascript">ComSheetObject('sheet2');</script>
							</td>
							<td width="2%"></td>
							<td width="310">
								<script language="javascript">ComSheetObject('sheet3');</script>
							</td>
						</tr>
					</table>
				<!-- Grid (E) -->
						
				<!--  biz_2   (E) -->
				
				<table width="979" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
					<tr>
						<td class="btn1_bg" width="310">
							<table border="0" cellpadding="0" cellspacing="0">
		    					<tr>
		    						<td>
										<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td>
											<td class="btn2" name="btn_raw1">Raw Data</td>
											<td class="btn2_right"></td>
											</tr>
										</table>
									</td>
								</tr>
							</table>			
						</td>
						<td width="2%"></td>
						<td class="btn1_bg"  width="310">
							<table border="0" cellpadding="0" cellspacing="0">
		    					<tr>
		    						<td>
										<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td>
											<td class="btn2" name="btn_raw2">Raw Data</td>
											<td class="btn2_right"></td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
						</td>
						<td width="2%"></td>
						<td width="310"></td>
					</tr>
				</table> 
				</td></tr>
			</table>
	
	<!--biz page (E)-->
	
	
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" id="btn_Retrieve" name="btn_Retrieve">Retrieve</td>
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
					<td class="btn1" name="btn_down_excel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>

			</tr>
			</table>
		
    <!--Button (E) -->
	</td></tr>
</table>
</td></tr>
</table>
<!--Raw data용 테이블 -->
<table width="100%" id="mainTable">
	<tr>
		<td width="100%" >
			<script language="javascript">ComSheetObject('sheet4');</script>
		</td>
	</tr>
</table>
<table width="100%" id="mainTable">
	<tr>
		<td width="100%" >
			<script language="javascript">ComSheetObject('sheet5');</script>
		</td>
	</tr>
</table>
<table width="100%" id="mainTable">
	<tr>
		<td width="100%" >
			<script language="javascript">ComSheetObject('sheet6');</script>
		</td>
	</tr>
</table>
<table width="100%" id="mainTable">
	<tr>
		<td width="100%" >
			<script language="javascript">ComSheetObject('sheet7');</script>
		</td>
	</tr>
</table>
<table width="100%" id="mainTable">
	<tr>
		<td width="100%" >
			<script language="javascript">ComSheetObject('sheet8');</script>
		</td>
	</tr>
</table>
<table width="100%" id="mainTable">
	<tr>
		<td width="100%" >
			<script language="javascript">ComSheetObject('sheet9');</script>
		</td>
	</tr>
</table>
<table width="100%" id="mainTable">
	<tr>
		<td width="100%" >
			<script language="javascript">ComSheetObject('sheet10');</script>
		</td>
	</tr>
</table>
<!--Raw data용 테이블 -->


<!--전체 엑셀 다운용 테이블 -->
<table width="100%" id="mainTable">
	<tr>
		<td width="100%" >
			<script language="javascript">ComSheetObject('sheet11');</script>
		</td>
	</tr>
</table>
<table width="100%" id="mainTable">
	<tr>
		<td width="100%" >
			<script language="javascript">ComSheetObject('sheet12');</script>
		</td>
	</tr>
</table>
<table width="100%" id="mainTable">
	<tr>
		<td width="100%" >
			<script language="javascript">ComSheetObject('sheet13');</script>
		</td>
	</tr>
</table>
<table width="100%" id="mainTable">
	<tr>
		<td width="100%" >
			<script language="javascript">ComSheetObject('sheet14');</script>
		</td>
	</tr>
</table>
<table width="100%" id="mainTable">
	<tr>
		<td width="100%" >
			<script language="javascript">ComSheetObject('sheet15');</script>
		</td>
	</tr>
</table>
<table width="100%" id="mainTable">
	<tr>
		<td width="100%" >
			<script language="javascript">ComSheetObject('sheet16');</script>
		</td>
	</tr>
</table>
<table width="100%" id="mainTable"> 
	<tr>
		<td width="100%" >
			<script language="javascript">ComSheetObject('sheet17');</script>
		</td>
	</tr>
</table>
<table width="100%" id="mainTable">
	<tr>
		<td width="100%" >
			<script language="javascript">ComSheetObject('sheet18');</script>
		</td>
	</tr>
</table>
<table width="100%" id="mainTable">
	<tr>
		<td width="100%" >
			<script language="javascript">ComSheetObject('sheet19');</script>
		</td>
	</tr>
</table>
<!--전체 엑셀 다운용 테이블 -->
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>