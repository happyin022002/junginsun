<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName       : ESM_MAS_054.jsp
*@FileTitle      : 항로 Simulation Report
*Open Issues     :
*Change history  :
*@LastModifyDate : 2006-09-26
*@LastModifier   : Park Eun Ju
*@LastVersion    : 1.0
* 2006-09-26 Park Eun Ju
* 1.0 최초 생성
=========================================================*/
' History :
' 2008.05.07 PEJ R200804296325 css 파일 참조 확인 및 수정 요청
' 2008,11.06 전성진 CSR No.N200811050011
'					- 메뉴명 수정, Radio 버튼 border 처리
' 2009.03.31 임옥영 S2K-09U-002(Lane Simulation System 개선)
' 2009.06.15 배진환 N200905220060 Lane Simulation System 수정사항
' 2009.07.20 윤진영 Alps전환작업 
' 2010.12.01 김기종 Ticket ID:CHM-201006305-01 MAS Architecture 위배사항 수정
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.apps.alps.esm.mas.lanesimulation.event.EsmMas0054Event"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.framework.component.util.io.HttpUtil"%>
<%
  	SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    EsmMas0054Event  event = null;                				//PDTO(Data Transfer Object including Parameters)
    GeneralEventResponse eventResponse =  null;
    Exception serverException   = null;            				//서버에서 발생한 에러
	String strErrMsg = "";								 //에러메세지
	String xml = "";
	//header
  	String headerCD = "";
    String headerNM = "";

    Logger log = Logger.getLogger("com.hanjin.apps.alps.esm.mas.lanesimulation.EsmMas0054Event");

	try {
	
		event = (EsmMas0054Event)request.getAttribute("Event");
    	eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}else{
			if (eventResponse != null) {
				xml = HttpUtil.makeXML(request,response); 
	            xml = xml.replaceAll("\"", "'");
	            
	            headerCD = eventResponse.getETCData("headerCD");
	            headerNM = eventResponse.getETCData("headerNM");
			} // end if
		} // end else
     
	}catch(Exception e) {
		log.error("ESM_MAS_0054 Exception : "+e.toString());
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Inquire/Edit Results of Simulation Case</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
<!--
	var f_sim_rpt_noCode = "";
	var f_sim_rpt_noText = "";

    var header = "<%= headerCD %>";
    var headerNM = "<%= headerNM %>";

    //ComShowMessage(header + " : " + headerNM);
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage(header, headerNM);
	}
-->
</script>
</head>

<body onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="f_txtTmp" > <!-- simNo       -->
<input type="hidden" name="header" value="<%= headerCD %>">
<input type="hidden" name="headerNM" value="<%= headerNM %>">
<input type="hidden" name="sXml" value="<%=xml%>"> 

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>


		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"> Simulation Result</td></tr>
		</table>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->

		<!--Button_L (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
	       	<tr><td class="btn1_bg">

				<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<!-- Repeat Pattern -->
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" id="btn_retrieve" name="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>

					<td class="btn1_line"></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" id="btn_downexcel" name="btn_downexcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>
					<!-- Repeat Pattern -->

				</tr></table>

			</td></tr>
		</table>
		<!--Button_L (E) -->

		<!-- TABLE '#D' : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg">

					<!-- : ( Select 'Simulation No' ) (S) -->
	                <table class="search_in" border="0">
	                      <tr class="h23">
	                          <td width="110">S/Lane</td>
	                          <td width="84" style="text-indent:2;">
	                          	<script language="javascript">ComComboObject('f_slan_cd', 1, 80, 0);</script>
	                          </td>
	                          <td width="84">
	                          	<script language="javascript">ComComboObject('f_dept_cd2', 1, 80 , 0 )</script>
	                          </td>
	                          <td width="206">
	                          	<script language="javascript">ComComboObject('f_sim', 1, 204 , 0 )</script>
	                          </td>
	                          <td><script language="javascript">ComComboObject('f_sim_rpt_no', 2, 150, 0);</script></td>
	                      </tr>
	                </table>

	                <table class="search_in" border="0">
	                      <tr class="h23">
	                          <td width="110">Simulation No.</td>
	                          <td width="317">
	                              <input type="text" style="width:30;" name="f_dept_cd" class="input2" maxlength="3" readOnly">&nbsp;&nbsp;-&nbsp;
	                              <input type="text" style="width:75;" name="f_sim_dt" dataformat="ymd" maxlength="8" readOnly class="input2">
	                              <input type="text" style="width:34;" name="f_sim_no" class="input2" maxlength="3" onkeydown="onlyNumber(window);" onBlur="fillSpace(this, 3, '0', 'left');" onfocus="this.select()" readOnly>
	                              <!--input type="text" style="width:75;" name="f_sim_dt" class="input2" maxlength="8" dataformat="ymd" onblur="ComAddSeparator(this);" onFocus="ComClearSeparator(this); this.select();" readOnly>
	                              <input type="text" style="width:34;" name="f_sim_no" class="input2" maxlength="3" onBlur="fillSpace(this, 3, '0', 'left');" onfocus="this.select()" readOnly-->
	                              <input type="text" style="width:75;" name="f_usr_id" class="input2" readOnly>
	                          </td>
	                          <td width="55">Remark</td>
	                          <td><input type="text" style="width:100%;" name="f_sim_rmk"></td>
	                      </tr>
	                </table>

	                <table class="search_in" border="0">
	              	<tr class="h23">
	                  	<td>Working Steps</td></tr>
					<tr><td valign="top">
	                              <table class="search" border="0">
	                                  <tr>
	                                  	<td width="110">&nbsp;</td>
	                                      <td width="120" style="padding-right:5;"><img class="cursor" src="/hanjin/img/alps/cost_step01.gif"    border="0" name="step01"></td>
	                                      <td width="120" style="padding-right:5;"><img class="cursor" src="/hanjin/img/alps/cost_step02.gif" border="0" name="step02"></td>
	                                      <td width="120" style="padding-right:5;"><img class="cursor" src="/hanjin/img/alps/cost_step03.gif"    border="0" name="step03"></td>
	                                      <td><img class="cursor" src="/hanjin/img/alps/cost_step04_on.gif"    border="0" name="step04"></td>
	                                  </tr>
	                              </table>
	                          </td>
	                      </tr>
	                </table>
					<!-- : ( Select 'Simulation No' ) (E) -->

			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->

		<table class="height_10"><tr><td></td></tr></table>

		<!-- TABLE '#D' : ( Search Options ) (S) -->
     	<table class="search" width="100%">
       	<tr><td class="bg">

				<table class="search" border="0">
					<tr><td height="30" valign="top"><img src="/hanjin/img/alps/cost_step04s.gif" height="22" border="0"></td></tr>
				</table>

				<!-- : ( Cost Items ) (S) -->
				<table class="search" border="0" width="100%">
				<tr class="h23">
					<td width="45">Trade</td>
					<td width="70">
						<script language="javascript">ComComboObject('f_trd_cd', 1, 66 , 0 )</script>
					</td>
					<td width="230">
						<select style="width:220;" name="f_searchItem2" onChange="javascript:chgItem2(this);">
							<option value="0">Voyage PL By All Ships</option>
							<option value="1">Voyage PL By individual Vessel</option>
							<option value="2">Annual PL By All Ships</option>
						</select>
					</td>
					<td width="220" class="sm">
						<div id="div_tot_avg" style="display:inline;border:none;height:16">
							<input type="radio" value="0" name="f_voy_view" class="trans" checked>Total
							<input type="radio" value="1" name="f_voy_view" class="trans" >AVG PER VOY
						</div>
						<div id="div_vessel" style="display:none;border:none;width:50;height:16">
							<script language="javascript">ComComboObject('f_vsl_cd', 1, 80, 0);</script>
						</div>
					</td>
					<td width="150">
						<div id="" style="display:inline;border:none;width:130;height:16">
						<input type="radio" value="0" name="f_kor_eng" class="trans" onClick="javascript:chgHeader('0');" checked>KOR
						<input type="radio" value="1" name="f_kor_eng" class="trans" onClick="javascript:chgHeader('1');">ENG
						</div>
					</td>
					<td align="right" valign="bottom" style="padding-right:3;">
				        <div id="div_zoom_in1" style="display:inline"> <!-- absolute / relative -->
						<img class="cursor" src="/hanjin/img/bu_prev01.gif" width="20" height="11" border="0" name="bu_zoom_in1" alt="Zoom in(+)">
						</div>
						<div id="div_zoom_out1" style="display:none">
						<img class="cursor" src="/hanjin/img/bu_next01.gif" width="20" height="11" border="0" name="bu_zoom_out1" alt="Zoom out(-)">
						</div>
					</td>
					</tr>

				<tr><td class="height_5" colspan="8"></td></tr>
				</table>

				<!-- : ( Grid : POL / POD ) (S) -->
				<!-- 'HEAD1-BGCOLOR : 203 240 169' , 'HEAD2-BGCOLOR : 222 251 248' , 'BORDER 1-outside : 88 152 164' ,
					 'BORDER 2-inside : 202 226 233' , 'HEAD-FONT : 39 95 101' , 'SELETED ROW BG : 252 255 233' -->

				<table width="100%" id="mainTable">
			              <tr><td>
			                     <script language="javascript">ComSheetObject('sheet1');</script>
			              </td></tr>
				</table>
				<!-- : ( Grid : POL / POD ) (E) -->

				<!--  Button_Sub (S) -->
				<table width="100%" class="button">
			       	<tr><td class="btn2_bg">
					<table border="0" cellpadding="0" cellspacing="0">
					<tr>

						<!-- Repeat Pattern -->
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td><td class="btn2" id="btng_creation2" name="btng_creation2">Creation (Variant Change)</td><td class="btn2_right"></td></tr></table></td>
						<!-- Repeat Pattern -->


					</tr></table>
				</td></tr>
				</table>
		    	<!-- Button_Sub (E) -->


			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->


</td></tr>
</table>
<!-- Outer Table (E)-->


</form>
</body>
</html>
