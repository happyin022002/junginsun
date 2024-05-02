<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CIM_1016.jsp
*@FileTitle : Turn Time by Location
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.12
*@LastModifier : 박광석
*@LastVersion : 1.0
* 2009.05.12 박광석
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.io.HttpUtil"%> 
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.turntimeperformancemgt.event.EesCim1016Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesCim1016Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String popYn			= "";

	Logger log = Logger.getLogger("com.hanjin.apps.CNTROperatioNPerformanceMgt.TurnTimePerformanceMgt");
	String xml = "";
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EesCim1016Event)request.getAttribute("Event");
		
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		popYn	= request.getParameter("pop_mode") == null ? "N" : "Y";

		xml = HttpUtil.makeXML(request,response);
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Turn Time by Location</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	var conds = {
		pop_yn : "<%=popYn%>"
	}

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
	     document.form.tpszs.value = "<%=event.getTTSearchOptionInGereralVO().getTpsz()%>";
		loadPage('<%=event.getTTSearchOptionInGereralVO().getInquiryLevel()%>');
	     <%
		     if(!"".equals(event.getTTSearchOptionInGereralVO().getInquiryLevel()) && !"AR".equals(event.getTTSearchOptionInGereralVO().getInquiryLevel()) && !"RC".equals(event.getTTSearchOptionInGereralVO().getInquiryLevel())){
		 %>   	 
		    	 document.getElementById("location").disabled = false;
		    	 document.getElementById("location").className = "input";
		 <%  
		     }
		     else{
		 %>
				document.getElementById("location").value = "";		
		 <%
		     }
		     if(!"AR".equals(event.getTTSearchOptionInGereralVO().getInquiryLevel()) && !"".equals(event.getTTSearchOptionInGereralVO().getInquiryLevel())){
	     
	     %>
 		    	document.getElementById("tscntr").value = "";
 		    	document.getElementById("tscntr").disabled = true;
	     <%
		     }
	     %>
	    
	}
</script>
</head>

<!-- 개발자 작업	-->
<% if(popYn.equals("Y")){ %>

<body class="popup_bg"  onLoad="setupPage();">
<form name="form" >
<input type="hidden" name="sXml" value="<%=xml%>">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="from" >
<input type="hidden" name="to" >
<input type="hidden" name="tpszs" >

<input type="hidden" name="pop_yn" value="<%=popYn %>">

<table width="100%" class="popup" cellpadding="10" border="0"> 
	<tr><td class="top"></td></tr>
	<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;T/Time by Location  </td></tr>
		</table>
		<!-- : ( Title ) (E) -->
<% }else{ %> 

<body  onLoad="setupPage();">
<form name="form" >
<input type="hidden" name="sXml" value="<%=xml%>">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="from" >
<input type="hidden" name="to" >
<input type="hidden" name="tpszs" >

<input type="hidden" name="pop_yn" value="<%=popYn %>">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">

	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
	<!--Page Title, Historical (E)-->
<% } %>
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
       	<tr><td class="btn1_bg">
		
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve"  ID="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
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
		<table class="search"> 
       	<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="40">Period&nbsp;</td>
					<td width="70"><select style="width:125;" class="input1" name="period" >
						<option value="M" selected <%if("M".equals(event.getTTSearchOptionInGereralVO().getPeriod())){%>selected <%} %>>Month(YYYY-MM)</option>
						<option value="W" <%if("W".equals(event.getTTSearchOptionInGereralVO().getPeriod())){%>selected <%} %>> Week(YYYY-WW)</option>
						</select></td>
					<td width="145">&nbsp;<input type="text" style="width:51" class="input1" value="<%=event.getTTSearchOptionInGereralVO().getFrom() %>" name="froms" caption="FM" required dataformat="ym" maxlength="6">&nbsp;~&nbsp;<input type="text" style="width:51" class="input1" value="<%=event.getTTSearchOptionInGereralVO().getTo() %>" name="tos" required dataformat="ym" caption="TO" maxlength="6"></td>
					<td width="80">Location By</td>
					<td width="262"><select style="width:95" class="input1" name="inquiryLevel">
						<option value="AR" selected <%if("AR".equals(event.getTTSearchOptionInGereralVO().getInquiryLevel())){%>selected <%} %>>ALL(by RCC)</option>
						<option value="AC"  <%if("AC".equals(event.getTTSearchOptionInGereralVO().getInquiryLevel())){%>selected <%} %>>ALL(by Country)</option>
						<option value="RC"  <%if("RC".equals(event.getTTSearchOptionInGereralVO().getInquiryLevel())){%>selected <%} %>>RCC(by Country)</option>
						<option value="RL"  <%if("RL".equals(event.getTTSearchOptionInGereralVO().getInquiryLevel())){%>selected <%} %>>RCC(by LCC)</option>
						<option value="RE"  <%if("RE".equals(event.getTTSearchOptionInGereralVO().getInquiryLevel())){%>selected <%} %>>RCC(by ECC)</option>
						<option value="LE"  <%if("LE".equals(event.getTTSearchOptionInGereralVO().getInquiryLevel())){%>selected <%} %>>LCC(by ECC)</option>
						<option value="LS"  <%if("LS".equals(event.getTTSearchOptionInGereralVO().getInquiryLevel())){%>selected <%} %>>LCC(by SCC)</option>
						<option value="ES"  <%if("ES".equals(event.getTTSearchOptionInGereralVO().getInquiryLevel())){%>selected <%} %>>ECC(by SCC)</option>
						<option value="CC"  <%if("CC".equals(event.getTTSearchOptionInGereralVO().getInquiryLevel())){%>selected <%} %>>Country</option>
						<option value="SS"  <%if("SS".equals(event.getTTSearchOptionInGereralVO().getInquiryLevel())){%>selected <%} %>>SCC</option>
						</select>&nbsp;<input type="text"  disabled style="width:55;" class="input"  name="location" value="<%=event.getTTSearchOptionInGereralVO().getLocation() %>" dataformat="engup" style="ime-mode:disabled" maxLength ="5">&nbsp;<img class="cursor" name="btn_loc_cd" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
					<td width="85">Flow Pattern</td>	
					<td width="110"><select style="width:90;" class="input" name="flowpattern">
							<option value="5" selected>Excl MIMO</option>
							<option value="A">ALL</option>
							<option value="1" >FI -> FO</option>
							<option value="2" >FI -> MO</option>
							<option value="3" >MI -> FO</option>
							<option value="4" >MI -> MO</option>
						</select></td> 
						
					<td width="50">Company</td>
					<td width=""><input type="text" style="width:30;text-align:center;" class="input" value="SML" readOnly></td>
					</tr> 
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					
					<td width="45">TP/SZ</td>
					<td width="270">
					<script language="javascript" >ComComboObject('tpsz', 1, 125,1);</script>
					<!--  &nbsp;<input type="checkbox" class="trans" name="chk_cntr_tpsz_cd"  border="0">-->
					</td>
					<td width="80">En Route</td>
					<td width="100"><select style="width:95;" class="input" name="enRoute" disabled>
						<option value="" selected></option>
						<option value="E"  >Exclude</option>
						<option value="I">Include</option>
						<option value="O">Only</option>
						</select></td>
					<td width="65">T/S CNTR</td>
					<td width="97"><select style="width:70;" class="input" name="tscntr">
						<option value="E" selected>Exclude</option>
						<option value="I" >Include</option>
						<option value="O" >Only</option>
						</select></td>
					<td width="85" align="right">S.O.C&nbsp;&nbsp;</td>
					<td width=""><select style="width:90;" class="input" name="soc">
						<option value="E" selected>Exclude</option>
						<option value="I" >Include</option>
						<option value="O" >Only</option>
						</select></td>
				
				</tr> 
				</table>
				<!--  biz_1   (E) -->
				
				</td></tr>
			</table>
			
			<table class="height_8"><tr><td colspan="8"></td></tr></table>
		<!-- Tab (S) -->
     		<table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%> 
       			<tr><td width="100%">
				<script language="javascript">ComTabObject('tab1')</script>
			</td></tr>
		</table>
		<!-- Tab (E) -->

		<!-- Tab Summary  (S) -->
		<div id="tabLayer" style="display:none">

			<!-- Tab BG Box  (S) -->
			<table class="search"> 
			<tr><td class="bg">
																		
				<!-- Grid  (S) -->
					<table width="100%" class="search"  id="mainTable"> 
						<tr>
							<td width="100%">
							<script language="javascript">ComSheetObject1('t1sheet1');</script>
							</td>
						</tr>
					</table> 				
				<!-- Grid (E) -->

				<!--  Grid_button (S) -->
				</td></tr>
			</table>
		<!-- Tab BG Box  (S) -->

		</div>

		<!-- Tab Summary  (E) -->


		<!-- Tab Detail  (S) -->
		<div id="tabLayer" style="display:none">
		<!-- Tab BG Box  (S) -->
     	<table class="search"> 
       	<tr><td class="bg">
			 														
			<!-- Grid  (S) -->
					<table width="100%" class="search"  id="mainTable"> 
						<tr>
							<td width="100%">
							<script language="javascript">ComSheetObject1('t2sheet1');</script>
							</td>
						</tr>
					</table> 			
			<!-- Grid (E) -->

			<!--  Grid_button (S) -->
			</td></tr>
		</table>
	<!-- Tab BG Box  (S) -->
				
		</div>

		<!-- Tab Detail  (E) -->


		
	<!--biz page (E)-->
	<!--Button (S) -->
		
    <!--Button (E) -->
<table class="height_5"><tr><td></td></tr></table>	
	</td></tr>
</table>
<div id="popLayer" style="display:none">

	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
	<tr>
		<td height="71" class="popup">
	
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:0;"> 
       			<tr>
       				<td class="btn3_bg">
		    			<table border="0" cellpadding="0" cellspacing="0">
		    				<tr>
		    					<%
		    						if("Y".equals(popYn)){ 
		    					%>
		    					<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_Close">Close</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<%	} %>
							</tr>
						</table>
    					<!--Button (E) -->
	
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
<!-- : ( Button : pop ) (E) -->
</div>
<!-- <script language="javascript">ComSheetObject('t2sheet2');</script>  -->							



<!-- 개발자 작업  끝 -->
</form>
</body>
</html>