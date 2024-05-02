<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_EQR_1002.jsp
*@FileTitle : History Report
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 
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
<%@ page import="com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastreport.event.EesEqr1002Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesEqr1002Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	String fcastYrwk = "";
	String levelCd = "";
	String ofcCd = "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		ofcCd	  = account.getOfc_cd();


		event = (EesEqr1002Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		fcastYrwk = eventResponse.getETCData("fcast_yrwk");
		levelCd   = eventResponse.getETCData("level_cd");
		
	}catch(Exception e) {
		out.println(e.toString());
	}
	
	String locSelectBox = JSPUtil.getCodeCombo("loc_tp_cd_second","L","","CD03052",0,"");	
    
	String optionStr2 = "000000: :ALL";
    String cntrTpsz  = JSPUtil.getCodeCombo("cntrTpsz","","style='width:70;'","CD00263",0,optionStr2);
    String locSelectBox2 = JSPUtil.getCodeCombo("loc_tp_cd_second","L","","CD03052",0,"");   
	
%>
<html>
<head>
<title>History Report</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	parent.window.moveTo(0,0);
	parent.window.resizeTo("1600","900");
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
<input type="hidden" name="level_cd" value="<%= levelCd %>">
<input type="hidden" name="ofc_cd" value="<%= ofcCd %>">

<input type="hidden" name="loc_grp_cd" value="L">
<!-- 개발자 작업	-->

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;" >
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
	</table>
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_downExcel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
		</td></tr>
		</table>
	    <!--Button (E) -->
	
		<!--biz page (S)-->
		<!-- 1 (S) -->
		<table class="search"> 
       	<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
                    <td width="40">Period</td>
					<td width="80"> 
                        <select name="period" style="width:70;" class="input1">
                        <option value="W" >yyyyww</option>
                        <option value="M" >yyyymm</option>
                        </select>
                    </td>
                    <td width="140">
                       <input name="fmdate" value="" type="text" class="input1" style="width:60;ime-mode:disabled;" maxlength="6" onkeyup="onlyNumberInput(event);moveTabNormal(this,todate);">&nbsp;~
                       <input name="todate" value="" type="text" class="input1" style="width:60;ime-mode:disabled;" maxlength="6" onkeyup="onlyNumberInput(event);"> 
                    </td>
                    <td width="12"></td>
					<td width="30">RCC</td>
					<td width="97">
					<select style="width:80;" class="input1" name="loc_cd">
						<option value="" selected>All</option>
						<option value="CNSHA">CNSHA</option>
						<option value="CNHKG">CNHKG</option>
						<option value="TWTPE">TWTPE</option>
						<option value="KRSEL">KRSEL</option>
						<option value="JPTYO">JPTYO</option>
						<option value="SGSIN">SGSIN</option>		
						<option value="DEHAM">DEHAM</option>   
                        <option value="USNYC">USNYC</option>   
						</select>
					</td>
					
					<td width="500">
						<table border="0" style="width:500;" class="search_sm2"> 
						<tr class="h23">
											
							<td width="15">
								<input type="radio" name="div_flag" value="1" class="trans" OnClick="changeInputStatus();" checked>
							</td>					
							<td width="73" align="right">Location by</td>
							<td width="110">
								<select style="width:110;" name="loc_type_code" class="input" ><!-- LOC_TYPE_CODE -->
									<option value="RE">RCC (by ECC)</option>
									<option value="LE" selected>LCC (by ECC)</option>
									<option value="RS">RCC (by SCC)</option>
									<option value="LS">LCC (by SCC)</option>
									<option value="ES">ECC (by SCC)</option>
									<!-- loc_cd -->
								</select> 
							</td>
							<td width="80">	
								<input type="text" class="input2" name="sub_loc_cd" dataformat="engup" size="5" maxlength="5" fulfill size="5" maxlength="5" fulfill style="width:50;" value="" readOnly>&nbsp;<!-- USNYC --><img class="cursor" src="img/btns_search.gif" name="btn_loc_cd" width="19" height="20" border="0" align="absmiddle" disabled>
							</td>
							
							<td width="15">
								<input type="radio" name="div_flag" value="2" class="trans" OnClick="changeInputStatus();">
							</td>
							<td width="50">Location</td>
							<td width="50"><%= locSelectBox %></td> <!-- loc_tp_cd_second -->
							<td width="80">
								<input type="text" dataformat="engup" size="5" maxlength="5" caption="Location CD" style="width:50;" class="input2" name="loc_cd_second" value=""> <img src="img/btns_search.gif" name="btn_loc_cd_second" width="19" height="20" border="0" align="absmiddle" class="cursor">
							</td>							
							
						</tr>
					    </table>
					</td>					
					
					
				</tr> 
				</table>
        
                <table class="search" style=""> 
                <tr class="h23">
                    <td width="44">TP/SZ</td>
                    <td width="85"><%= cntrTpsz %></td>
                    <td colspan=8>&nbsp;<script language="javascript">ComComboObject('tpsztype' , 1, 278, 1 )</script></td>
                </tr></table>
        
				<!--  biz_1   (E) -->
		<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
		<!-- 1 (E) -->
		
		<!-- 2 (S) -->		
		
			<!-- grid box (S) -->
					<!-- Grid - 1 (S) -->
					<table width="100%" height="" id="mainTable1" border="0"> 
						<tr>
							<td><script language="javascript">ComSheetObject('sheet1');</script></td>
						</tr>
					</table>				 
					<!-- Grid - 1 (E) -->
			<!-- grid box (E) -->
			
		</td></tr>
		</table>			
		<!-- 2 (E) -->
		<!--biz page (E)-->
	</td></tr>
</table>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>