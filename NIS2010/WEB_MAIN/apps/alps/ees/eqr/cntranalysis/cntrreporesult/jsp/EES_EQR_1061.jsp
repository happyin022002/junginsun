<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_EQR_1061.jsp
*@FileTitle : Empty Repo Result
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.23
*@LastModifier : 양봉준
*@LastVersion : 1.0
* 2010.11.23 양봉준
* 1.0 Creation
* 2010.12.03 양봉준 [CHM-201007345-01] EES_EQR_1061 화면 신규 개발
* 2010.12.23 이병훈 [CHM-201007931-01] [EQR] - Empty Repo Result 기능 보완
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.eqr.cntranalysis.cntrreporesult.event.EesEqr1061Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesEqr1061Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";								 //에러메세지
	int rowCount	 = 0;								  //DB ResultSet 리스트의 건수

	try {
		event = (EesEqr1061Event)request.getAttribute("Event");

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
	}catch(Exception e) {
		out.println(e.toString());
	}

	String optionStr = "000000:ALL:ALL";
	String optionStr1 = "000000: : ";

	String fmType    = JSPUtil.getCodeCombo("fmType", "", "width='55'", "CD00242", 0, optionStr);
	String toType    = JSPUtil.getCodeCombo("toType", "", "width='55'", "CD00242", 0, optionStr);

	String fmTypeBy  = JSPUtil.getCodeCombo("fmTypeBy", "E", " style='width:80;'", "CD00265", 0, "");
	String toTypeBy  = JSPUtil.getCodeCombo("toTypeBy", "E", " style='width:80;'", "CD00265", 0, "");

	String tpsz = JSPUtil.getCodeCombo("tpsz","","onChange='javascript:tpszChange(document.form.tpsz.options[document.form.tpsz.selectedIndex].value)' style='width:55;'","CD00263",0,optionStr);
%>
<html>
<head>
<title>컨테이너 수급 예측실적 및 정확도 조회</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	// mode (Truck, Rail, Water)
	<%= JSPUtil.getIBCodeCombo("item",    "01", "CD00566", 0, "")%>
	// Type Size
	<%= JSPUtil.getIBCodeCombo("tpszall", "01", "CD00830", 0, "")%> // ALL TYPE SIZE, CD00244
	<%= JSPUtil.getIBCodeCombo("tpszdry", "01", "CD00751", 0, "")%> // DRY TYPE SIZE
	<%= JSPUtil.getIBCodeCombo("tpszrfr", "01", "CD00752", 0, "")%> // RFR TYPE SIZE
	<%= JSPUtil.getIBCodeCombo("tpszot",  "01", "CD00828", 0, "")%> // OT  TYPE SIZE, CD00753
	<%= JSPUtil.getIBCodeCombo("tpszfr",  "01", "CD00829", 0, "")%> // FR  TYPE SIZE, CD00829

    // ------- type 변수선언 -------------- START
    var consTpsz      = replaceAll(tpszallText, "|", ",");
    var consTpszArr   = consTpsz.split(',');
    var consTpszDry   = replaceAll(tpszdryText, "|", ",");
    var consTpszRfr   = replaceAll(tpszrfrText, "|", ",");
    var consTpszOt    = replaceAll(tpszotText,  "|", ",");
    var consTpszFr    = replaceAll(tpszfrText,  "|", ",");
    // ------- type 변수선언 -------------- END

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		// InitTab();
		loadPage();
	}
</script>
</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();tpszChange(document.form.tpsz.options[document.form.tpsz.selectedIndex].value)">
<form method="post" name="form" onSubmit="return false;">
<input	type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="tpszall" value="">
<input type="hidden" name="tpcnt" value="">
<input type="hidden" name="transmode" value="">

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
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_downexcel" id="btn_downexcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>

							<!-- Repeat Pattern -->

						</tr></table>

				</td></tr>
		</table>
    	<!-- TABLE '#D' : ( Button : Main ) (E) -->

        <!-- TABLE '#D' : ( Search ) (S) -->
        <table class="search" border="0">
            <tr>
                <td class="bg">
                    
                    <table class="search_in" border="0">
                        <tr class="h23">
                          <td width="8%">&nbsp;&nbsp;&nbsp;Period</td>
                          <td width="10%"> 
                              <select name="period" onChange="changeFmDateMaxLength(this);" style="width:90;">
                              <option value="Day" selected>yyyymmdd</option>
                              <option value="Week" >yyyyww</option>
                              <option value="Month" >yyyymm</option>
                              </select>
                           </td>
                           <td  width="15%">
                              <input name="fmdate" value="" type="text" style="width:60;ime-mode:disabled;" onkeyup="onlyNumberInput(event);moveTabNormal(this,todate);">&nbsp;~&nbsp;
                              <input name="todate" value="" type="text" style="width:60;ime-mode:disabled;" maxlength="8" onkeyup="onlyNumberInput(event);"> 
                           </td>
                           <td width="18%"></td>
                           <td width="6%">Mode</td>
                           <td width="12%">
                              <!--select name="transmode" onChange="" style="width:70;">
                              <option value="ALL" selected>ALL</option>
                              <option value="TD" >Truck</option>
                              <option value="RD" >Rail</option>
                              <option value="WD" >Water</option>
                              </select-->
                              <script language="javascript">ComComboObject('item' , 1, 150, 1 )</script>
                            </td>
                            <td width="15%"></td>
                            <td width="12%"><img class="nostar">&nbsp;&nbsp;&nbsp;Company</td>
                            <td class="sm" width="6%">
                                <input type="text" name="" style="width:55" value="SMLine" class="input2" readonly></td>
                            
                           </tr>

                    </table>
                    <!-- : ( Scenario ID ) (E) -->

                    <table class="search_in" border="0" >
                        <tr class="h23">
                            <td width="8%">&nbsp;&nbsp;&nbsp;Fm LOC</td>
                            <td width="18%" class="sm" ><%=fmType %>
                                <input type="text" name="fmloc" style="width:60;ime-mode:disabled;" value="" onKeyUp="upperCase()">
                                <img class="cursor" src="/hanjin/img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="fmloc_btn">
                            </td>
                            <td width="6%">To LOC</td>
                            <td width="18%" class="sm" ><%=toType %>
                                <input type="text" name="toloc" style="width:60;ime-mode:disabled;" value="" onKeyUp="upperCase()">
                                <img class="cursor" src="/hanjin/img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="toloc_btn">
                            </td>
                            <td width="6%">TP/SZ</td>
                            <td width="8%">
                                <%=tpsz%>
                            </td>
                            <td width="24%">
                                <script language="javascript">ComComboObject('cntrtpszcd' , 1 , 220, 1 )</script>
                            </td>
                            <td width="12%"></td>
                        </tr>
                    </table>
                </td>
            </tr>
        </table>
        <!-- TABLE '#D' : ( Search ) (E) -->

		<table class="height_10"><tr><td></td></tr></table>

		<table class="search" border="0">
			<tr>
				<td class="bg">

					<table class="search"><tr><td class="height_2"></td></tr></table>

					<!-- table width="100%" id="sheetControlDiv" style="">
		            	<tr><td align="right"><img name="maxi" class="cursor" src="/hanjin/img/bu_next01.gif" sheetId="sheet1" type="N" onclick="toggleSheetSize();"></td></tr>
				    </table-->

					<!-- : ( Grid ) (S) -->
					<!-- 'HEAD1-BGCOLOR : 203 240 169' , 'HEAD2-BGCOLOR : 222 251 248' , 'BORDER 1-outside : 88 152 164' ,'BORDER 2-inside : 202 226 233' , 'HEAD-FONT : 39 95 101' , 'SELETED ROW BG : 252 255 233' -->

        	        <table width="100%" id="mainTable" >
        				<tr><td>
        				   <script language="javascript">ComSheetObject('sheet1');</script>
        				</td></tr>
        			</table>

					<!-- : ( Grid ) (E) -->

				</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Tab BG Box ) (S) -->

</td></tr>
</table>
<!-- Outer Table (E)-->
<iframe frameborder="0" width="0"  name="037iframe" scrolling="no" frameborder="0" width="0" height="0">
</iframe>

<!-- 주차 -->
<!-- iframe frameborder=0 width=0  name="F037iframe" scrolling="no" frameborder="0" width="0" height="0"/-->
<iframe frameborder="0" width="0"  name="periorIframe" scrolling="no" frameborder="0" width="0" height="0"/></iframe>
</form>
</body>
</html>