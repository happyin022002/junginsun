<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_COA_0014.jsp
*@FileTitle : US domestic cost/credit 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.17
*@LastModifier : 김보배
*@LastVersion : 1.0 
* 2012.10.17 김보배
* 1.0 Creation
=========================================================
* History
* 2012.11.19 송호진 [CHM-201221090-01] [COA] US DOMESTIC 반영 - Tab 및 저장용 공통 Sheet 추가
* 2012.11.20 송호진 [CHM-201221090-01] [COA] US DOMESTIC 반영 - CNTR_SZ_CD -> CNTR_TPSZ_CD 컬럼명 변경에 따른 조회조건 Text 변경 ( Size -> Type Size )
* 2012.11.26 송호진 [CHM-201221090-01] [COA] US DOMESTIC 반영 - Create 작업 전 기존 데이터 존재 체크 부분 추가 관련 수정 , Creation Date, User ID, Currency 표시 부분 추가
* 2013.05.09 서미진 [선처리 CSR] User office 가 SELCDA, SELCDO, SELCOL 인 경우에만 Create, Save 버튼 보이도록 변경 
* 2013.05.10 최성민 [CHM-201324573-01] [COA] Domestic Saving Credit 화면 버튼 추가 
=========================================================*/ 
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.coa.stdunitcost.usdomestic.event.EsmCoa0014Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmCoa0014Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	
	Logger log = Logger.getLogger("com.hanjin.apps.STDUnitCost.usdomestic");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

		event = (EsmCoa0014Event)request.getAttribute("Event");
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
<title>US domestic cost/credit</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
function setupPage(){
	var errMessage = "<%=strErrMsg%>";
	if (errMessage.length >= 1) {
		showErrMessage(errMessage);
	} // end if
	
	loadPage();
	ComSetFocus(document.form.f_cost_yrmon);
}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<input type="hidden" name="v_ofc_cd" value="<%=strOfc_cd %>">
<input type="hidden" name="coa_mty_ecc_ut_cost_cnt">
<input type="hidden" name="coa_ut_cost_cre_sts_cnt">


<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr>
				<td class="history"><img src="img/icon_history_dot.gif"
					align="absmiddle"><span id="navigation"></span></td>
			</tr>
			<tr>
				<td class="title"><img src="img/icon_title_dot.gif"
					align="absmiddle"><span id="title"></span></td>
			</tr>
		</table>
		<!--Page Title, Historical (E)-->	
      
		<!--Button (S) -->
      	<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
        <tr>
        	<td class="btn1_bg">
			<table border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td>
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                    	<td class="btn1_left"></td>
						<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
						<td class="btn1_right"></td>
					</tr>
				</table>
                </td>
                <td class="btn1_line"></td>
                
                <!-- 
                <td>
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button" id="btn_month_copy">
                    <tr>
                    	<td class="btn1_left"></td>
						<td class="btn1" name="btn_month_copy">Month Copy</td>
						<td class="btn1_right"></td>
					</tr>
				</table>
                </td>
                
                <td>
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button" id="btn_create">
                    <tr>
                    	<td class="btn1_left"></td>
						<td class="btn1" name="btn_create">Create</td>
						<td class="btn1_right"></td>
					</tr>
				</table>
                </td>
			
				<td>
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button" id="btn_save">
					<tr>
						<td class="btn1_left"></td>
						<td class="btn1" name="btn_save">Save</td>
						<td class="btn1_right"></td>
					</tr>
					</table>
				</td>
				-->
                <td>
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr>
						<td class="btn1_left"></td>
						<td class="btn1" name="btn_downExcel">Down Excel</td>
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
      
		<!--biz page (S)-->
		<table class="search">
		<tr>
			<td class="bg"><!-- biz_1  (S) -->
			<table class="search" border="0" style="width:979;">
            	<tr class="h23">
                	<td width="60">&nbsp;YYYY-MM</td>
                	<td width="80">&nbsp;&nbsp;&nbsp;<input type="text" class="input1" name="f_cost_yrmon" style="width:60" maxlength="7"
                 					onKeyPress="ComKeyOnlyNumber(window)" onChange="setPeriod(this);"
                					onBlur="addDash(this , 4);" 
                					onFocus="this.value=ComReplaceStr(this.value, '-', '');" >
	                </td>
	                <td width="120" class='sm'><div id='div_period'></div></td>
	                <td width="130">Period (YYYY-MM)</td>
					<td >&nbsp;From&nbsp; <input type="text" class="input" name="f_cre_start_dt" id="f_cre_start_dt" style="width:60"  maxlength="7"
									onKeyPress="ComKeyOnlyNumber(window)" 
                					onBlur="addDash(this , 4);" 
                					onFocus="this.value=ComReplaceStr(this.value, '-', '');" >
									&nbsp;~&nbsp;
									To&nbsp;&nbsp;&nbsp; <input type="text" class="input" name="f_cre_end_dt" id="f_cre_end_dt" style="width:60"  maxlength="7"
									onKeyPress="ComKeyOnlyNumber(window)" 
                					onBlur="addDash(this , 4);" 
                					onFocus="this.value=ComReplaceStr(this.value, '-', '');" >
                	</td>
	                <td  width="20">&nbsp;</td>
	                <td  width="90">Creation Date</td>
	                <td  width="100"><input type="text" class="input2" name="f_cre_dt" style="width:80;text-align:center;" readonly ></td>
	                <td  width="50">User ID</td>
	                <td ><input type="text" class="input2" name="f_cre_usr_id" style="width:100;text-align:center;" readonly ></td>
	            </tr>
	        </table>
	        <table class="search" border="0" style="width:979;">
	            <tr><td class="line_bluedot" style="height:11;"></td></tr>
	        </table>
	        <table class="search" border="0" style="width:979;">
	            <tr class="h23">
	                <td width="140">&nbsp;Location Hierarchy</td>
	                <td width="128">&nbsp;&nbsp;&nbsp;<input type="text" disabled class="input2" name="f_cost_loc_grp_cd" style="width:60;text-align:center;" value="ECC"></td>
	            
	                <td width="35">ECC</td>
	                <td width="100">&nbsp;&nbsp;<script language="javascript">ComComboObject('f_ecc_cd', 1, 70 , 0 )</script></td>
	
					<td width="20">Type&nbsp;Size</td>
					<td width="100">&nbsp;&nbsp;&nbsp;<script language="javascript">ComComboObject('f_cntr_tpsz_cd', 1, 50 , 0 )</script></td>
					
					<td width="200">
						<table id="drd_table" border="0">
							<tr><td>
							Domestic rev detail&nbsp;
									<input type="checkbox" class="trans" name="f_dom_rev_det" style="border-style:none" 
									onClick="viewRevDetail();" value="Y">
						</table>
					</td>
	                <td width="114">&nbsp;</td>
	                <td width="60">Currency</td>
	                <td ><input type="text" class="input2" name="f_currency" style="width:40;text-align:center;" readonly ></td>
				 </tr>
            </table>	
					
       </tr>
       </table>
<!-- /table -->

		<table class="height_8"><tr><td></td></tr></table>

		<!-- Tab ) (S) -->
		<table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%>
			<tr><td width="100%"><script language="javascript">ComTabObject('tab1')</script>
				<!-- img src="/img/sub_tab.gif" alt="" width="998" height="23" border="0" -->
				</td>
			</tr>
		</table>
		<!-- Tab ) (E) --> <!-- iFrame (S) -->
		<div id="tabLayer" style="display:inline">
		<!--  iframe name="t1frame" id="t1frame" frameborder="0" scrolling="no" width="100%" height="380" src="about:blank"></iframe-->
			<table class="search" border="0">
				<tr>
					<td class="bg">
			       		<table width="100%"  id="mainTable">
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet1');</script>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</div>
		<div id="tabLayer" style="display: none">
			<table class="search" border="0">
				<tr>
					<td class="bg">
			       		<table width="100%"  id="mainTable">
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet2');</script>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</div>
		<div id="tabLayer" style="display: none">
			<table class="search" border="0">
				<tr>
					<td class="bg">
			       		<table width="100%"  id="mainTable">
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet3');</script>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		<!-- iFrame (E) -->
		</div>

		<table class="height_10" >
			<tr>
				<td colspan="8"><script language="javascript">ComSheetObject('sheet4');</script></td>
			</tr>
		</table>
        <!-- table class="search"><tr>   
            
            < Grid  (S) >
       		<table width="100%"  id="mainTable">
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet1');</script>
					</td>
				</tr>
			</table>
			
        </tr>
      </table -->
      <!-- Tab BG Box(E) -->
      <!--biz page (E)-->
  </tr>
</table>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
