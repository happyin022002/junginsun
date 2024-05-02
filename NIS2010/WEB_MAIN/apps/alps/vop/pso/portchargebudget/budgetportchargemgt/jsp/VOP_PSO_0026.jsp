<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_pso_0026.jsp
*@FileTitle : Port Charge Invoice Summary Report
*Open Issues : 
*Change history :
*@LastModifyDate : 2011.10.07
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.06.08 박명종
* 1.0 Creation
*
* History
* 2010.09.16 진마리아 CHM-201005696-01 Port charge invocie Summary 메뉴 수정 요청건
*										지역본부및 office별, Port별 S/P No.로 발생한 Actual invoice를 조회하기 위한 조건 추가/삭제 및 Grid내 칼럼 추가 요청함
*										기존 Main 화면에서 조회조건이 속한 Invoice Master 정보를 보여주고, Detail에서는 해당 Invoice의 Detail  모든 정보를 보여주도록 되어있으나, 조회조건에 맞는 Detail 정보만이 조회되도록 수정.
* 2011.01.12 이석준 CHM-201108296-01 Invoice Summary Report내 Down Excel function 변경 요청
* 2011.03.04 진마리아 CHM-201108565-01 Port Charge Invoice Summary 조회 로직 변경 - ctrl h/q 조회로직 변경 및 조회조건(created id), 결과(csr no, status) 컬럼 추가
* 2011.03.14 진마리아 CHM-201109292-01 Location 조회불가건 수정 보완 요청
* 2011.10.07 진마리아 CHM-201113739-01 [VOP-PSO] Port Charge Invocie Summary 조회 로직 변경 - Invocie Created Date, Issue Date로 조회시 ALPS내 스케줄 Check없이 invocie내 data로 조회 가능하도록 로직 수정
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.pso.portchargebudget.budgetportchargemgt.event.VopPso0026Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopPso0026Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.PortChargeBudget.BudgetPortChargeMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopPso0026Event)request.getAttribute("Event");
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
<title>Invoice Summary</title>
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
<form name="form" >
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="vvd" value="" />
<!-- 개발자 작업	-->

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;padding-right:5;">
	
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
		<table width="979" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
	<!----Page Title, Historical (E)-->	
	
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:100%;">  
					<tr class="h23">
						<td width="70">Date Type</td>
						<td width="120">
								<select name="date_type" style="width:140;" class="input1">
								    <option value="VVD"  selected="selected">VVD ETD</option>
									<option value="CR">Invoice Created DT</option>
									<option value="IS">Invoice Issue DT</option>
								</select>	
						</td>
						<td width="240">
						<input type="text" name="from_date" style="width:80;text-align:center;" class="input1" dataformat="ymd" value="" maxlength="8" size="10">&nbsp;<img class="cursor" name="btns_Calendar1" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">&nbsp;~
						<input type="text" name="to_date" style="width:80;text-align:center;" class="input1" dataformat="ymd" value="" maxlength="8" size="10">&nbsp;<img name="btns_Calendar2" class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"></td>
					
						<td width="65">VVD</td>
						<td width="145"><input type="text" name="vsl_cd" dataformat="engupnumber" style="width:40;ime-mode:disabled;text-align:center;" class="input" value="" maxlength="4">&nbsp;<input type="text" name="skd_voy_no" dataformat="int" style="width:40;ime-mode:disabled;text-align:center;" class="input" value=""  maxlength="4">&nbsp;<input type="text" name="skd_dir_cd" dataformat="engup" style="width:22;ime-mode:disabled;text-align:center;" class="input" value=""  maxlength="1">&nbsp;<img class="cursor" name="btn_vvd_search" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
					 
						 <td width="70">Created ID</td>
						<td width="164"><input name="cre_usr_id" type="text" style="width:50" class="input" value="" ></td>
				     </tr>
				  </table>
				  
				  <table class="search"  border="0" style="width:100%;"> 
					<tr class="h23">
					    <td width="70">Account</td>
						<td width="160"><script language="javascript">ComComboObject('combo1',2,80,0);</script></td>
						<td width="50">Lane</td>
						<td width=160><input name="vsl_slan_cd" dataformat="engup" maxlength="3" type="text" style="width:44;text-align:center;" class="input" value="">&nbsp;<img class="cursor" name="btn_lane_search" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>						
					  	<td width="205"><input type="radio" name="s_retrieve_cp" class="trans" value="C" OnClick="chg_retrieve_cp();" checked>
				         Country 
					    <input type="text" name="cnt_cd" dataformat="engupnumber" style="width:30;text-align:Center;ime-mode:disabled" maxlength=2 class="input" tabindex='1' value="">&nbsp;<img class="cursor" src="img/btns_search.gif" name="btn_cnt_cd"  width="19" height="20" border="0" align="absmiddle">&nbsp;<input type="hidden" name="cnt_nm" style="width:10;" class="input2" readonly>
					    </td>
					    <td width="229"><input type="radio" name="s_retrieve_cp" class="trans" value="P" OnClick="chg_retrieve_cp();" checked>
						               Port
						<input name="port_cd" type="text" dataformat="engupnumber" style="width:50" class="input" value="" size="5" maxlength="5" >&nbsp;<img class="cursor" name="btn_port_cd" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">&nbsp;<script language="javascript">ComComboObject('term_code',2, 60, 1);</script></td>
					   
						</tr>
				  </table>
				    
				  <table class="search" border="0" style="width:100%;"> 
					<tr class="h23">
				      <td width="70">CTRL H/Q</td>
						<td width="160"><script language="javascript">ComComboObject('vskd_port_rhq_cd',1,80,1,0);</script>&nbsp;<script language="javascript">ComComboObject('sls_ofc_cd',1,70,1,0);</script></td>
					    <td width="50">V.Class</td>
						<td width="160"><script language="javascript">ComComboObject('cntr_vsl_clss_capa',1,65,0);</script></td>
				    	<td width="100">Service Provider</td>
						<td width="334"><input type="text" name="vndr_seq" style="width: 55; text-align: center" class="input" value="" dataformat="num" maxlength="6">&nbsp;<img class="cursor" name="btns_VendorSeq" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">&nbsp;<input type="text" name="vndr_lgl_eng_nm" style="width: 125; text-align: left" class="input2" value="" readonly></td>
				      
				    </tr>
				    </table>
						
				   <!-- 
						<td width="70">CTRL H/Q</td>
						<td width="170"><script language="javascript">ComComboObject('vskd_port_rhq_cd',1,80,1,0);</script>&nbsp;<script language="javascript">ComComboObject('sls_ofc_cd',1,70,1,0);</script></td>
						<td width="110">Service Provider</td>
						<td width=""><input type="text" name="vndr_seq" style="width: 55; text-align: center" class="input" value="" dataformat="num" maxlength="6">&nbsp;<img class="cursor" name="btns_VendorSeq" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">&nbsp;<input type="text" name="vndr_lgl_eng_nm" style="width: 125; text-align: left" class="input2" value="" readonly></td>
					</tr>
				</table>
				<table class="search" border="0" style="width:100%;"> 
					<tr class="h23">
						<td width="50">Account</td>
						<td width="65"><script language="javascript">ComComboObject('combo1',2,65,0);</script></td>
						<td width="30">Lane</td>
						<td width=""><input name="vsl_slan_cd" dataformat="engup" maxlength="3" type="text" style="width:44;text-align:center;" class="input" value="">&nbsp;<img class="cursor" name="btn_lane_search" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>						
						
						<td width="20">VVD</td>
						<td width="140"><input type="text" name="vsl_cd" dataformat="engupnumber" style="width:40;ime-mode:disabled;text-align:center;" class="input" value="" maxlength="4">&nbsp;<input type="text" name="skd_voy_no" dataformat="int" style="width:40;ime-mode:disabled;text-align:center;" class="input" value=""  maxlength="4">&nbsp;<input type="text" name="skd_dir_cd" dataformat="engup" style="width:22;ime-mode:disabled;text-align:center;" class="input" value=""  maxlength="1">&nbsp;<img class="cursor" name="btn_vvd_search" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
					    <td width="80"><input type="radio" name="s_retrieve_cp" class="trans" value="C" OnClick="chg_retrieve_cp();" checked>
					     Country</td>
					    <td width="60">
					    <input type="text" name="cnt_cd" dataformat="engupnumber" style="width:30;text-align:Center;ime-mode:disabled" maxlength=2 class="input" tabindex='1' value="">&nbsp;<img class="cursor" src="img/btns_search.gif" name="btn_cnt_cd"  width="19" height="20" border="0" align="absmiddle">&nbsp;<input type="hidden" name="cnt_nm" style="width:125;" class="input2" readonly></td>
						<td width="60"><input type="radio" name="s_retrieve_cp" class="trans" value="P" OnClick="chg_retrieve_cp();" checked>
						               Port
						</td>
						<td width="145">
						<input name="port_cd" type="text" dataformat="engupnumber" style="width:50" class="input" value="" size="5" maxlength="5" >&nbsp;<img class="cursor" name="btn_port_cd" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">&nbsp;<script language="javascript">ComComboObject('term_code',2, 60, 1);</script></td>
						<td width="80">Vessel Class</td>
						<td width="65"><script language="javascript">ComComboObject('cntr_vsl_clss_capa',1,65,0);</script></td>
						<td width="70">Created ID</td>
						<td width=""><input name="cre_usr_id" type="text" style="width:50" class="input" value="" ></td>
					</tr>
				</table> -->  		
				<!--  biz_1   (E) -->
			<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
				
				<!--  biz_2  (S) -->
		
		
				<!-- Grid  (S) -->
					<table width="100%" id="mainTable"> 
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet1');</script>
							</td>
						</tr>
					</table>
					
					<table width="100%" id="mainTable"> 
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet2');</script>
							</td>
						</tr>
					</table>
						<!-- Grid (E) -->
						
					<!--  Button_Sub (S) -->
				 <!-- 	<table width="100%" class="button"> 
			     	<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td>
								<table width="100%" border="0" cellpadding="0" cellspacing="0"
									class="button">
									<tr>
										<td class="btn2_left"></td>
										<td class="btn2" name="btn_DownExcel">Down Excel</td>
										<td class="btn2_right"></td>
									</tr>
								</table>
								</td>
							</tr>
						</table>
						</td></tr>
					</table>-->
			    	<!-- Button_Sub (E) -->
					<!--  biz_2   (E) -->
				
				
				</td></tr>
			</table>
	
	<!--biz page (E)-->
	
	
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
		      <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
					    <td class="btn1_left"></td>
				   	    <td class="btn1" name="btn_DownExcel">Down Excel</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve"  id="btn_Retrieve" >Retrieve</td>
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
					<td class="btn1" name="btn_Detail"  id="btn_Detail" >Detail</td>
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

<!-- 개발자 작업  끝 -->
</form>

</body>
</html>