<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CIM_1016.jsp
*@FileTitle  : Turn Time by Location
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/11 
=========================================================
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.io.HttpUtil"%> 
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.cim.cntroperationperformancemgt.turntimeperformancemgt.event.EesCim1016Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesCim1016Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB ResultSet list
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String popYn			= "";
	Logger log = Logger.getLogger("com.clt.apps.CNTROperatioNPerformanceMgt.TurnTimePerformanceMgt");
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
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		popYn	= request.getParameter("pop_mode") == null ? "N" : "Y";
		xml = HttpUtil.makeXML(request,response);
	} catch(Exception e) {
		out.println(e.toString());  
	}
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript">
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


<!-- developer job	-->
<% if(popYn.equals("Y")){ %>

<form name="form" id="form">
<input type="hidden" name="sXml" id="sXml" value="<%=xml%>">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="from" id="from" />
<input type="hidden" name="to" id="to" />
<input type="hidden" name="tpszs" id="tpszs" />

<input type="hidden" name="pop_yn" id="pop_yn" value="<%=popYn %>">
<!-- page_title_area(S) -->
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>T/Time by Location</span></h2>
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_downExcel" id="btn_downExcel">Down Excel</button>
		</div>
	</div>
</div>

<!-- page_location(E) -->

<% }else{ %> 

<form name="form" >
<input type="hidden" name="sXml" id="sXml" value="<%=xml%>">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="from" id="from" />
<input type="hidden" name="to" id="to" />
<input type="hidden" name="tpszs" id="tpszs" />

<input type="hidden" name="pop_yn" id="pop_yn" value="<%=popYn %>">
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title">
		<button type="button"><span id="title"></span></button>
	</h2>
<!-- page_title(E) -->
<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_downExcel" id="btn_downExcel">Down Excel</button>
			 <div id="popLayer" style="display:none">
   					<%
   						if("Y".equals(popYn)){ 
   					%>
					<button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
											
					<%	} %>
			 </div>
		</div>
		<!-- opus_design_btn(E) -->	
<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_location(E) -->
<% } %>
<% if(popYn.equals("Y") ){ %><div class="layer_popup_contents"><%}%>
<!-- opus_design_inquiry(S) -->
<div class= "wrap_search_tab">
<div class= "opus_design_inquiry wFit">
	<!-- layout_wrap(S) -->
      <table>
		<tbody>
			<colgroup>
				<col width="1px"/>
				<col width="1px"/>
				<col width="1px"/>
				<col width="1px"/>
				<col width="1px"/>
				<col width="1px"/>
				<col width="*" />
			</colgroup>
				<tr class="h23">
					<th>Period&nbsp;</th>
					<td><select style="width:130px;" class="input1" name="period" id="period" >
						<option value="M" selected <%if("M".equals(event.getTTSearchOptionInGereralVO().getPeriod())){%>selected <%} %>>Month(YYYY-MM)</option>
						<option value="W" <%if("W".equals(event.getTTSearchOptionInGereralVO().getPeriod())){%>selected <%} %>> Week(YYYY-WW)</option>
						</select></td>
					<td>&nbsp;<input type="text" style="width:61px;text-align:center;" class="input1" value="<%=event.getTTSearchOptionInGereralVO().getFrom() %>" name="froms" id="froms" caption="FM" required <%if("M".equals(event.getTTSearchOptionInGereralVO().getPeriod())){%>dataformat="ym"<%}else{%>dataformat="yw"<%}%> maxlength="6">&nbsp;~&nbsp;
							  <input type="text" style="width:61px;text-align:center;" class="input1" value="<%=event.getTTSearchOptionInGereralVO().getTo() %>" name="tos" id="tos" required  <%if("M".equals(event.getTTSearchOptionInGereralVO().getPeriod())){%>dataformat="ym"<%}else{%>dataformat="yw"<%}%> caption="TO" maxlength="6"></td>
					<th>Location By</th>
					<td><select style="width:125px" class="input1" name="inquiryLevel" id="inquiryLevel">
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
						</select><input type="text"  disabled style="width:55px;" class="input"  name="location" id="location" value="<%=event.getTTSearchOptionInGereralVO().getLocation() %>" dataformat="engup" style="ime-mode:disabled" maxLength ="5">&nbsp;
						<button type="button" id="btn_loc_cd" name="btn_loc_cd" class="input_seach_btn"></button>
						</td>
					<th>Flow Pattern</th>	
					<td><select style="width:95px;" class="input" name="flowpattern" id="flowpattern">
							<option value="5" selected>Excl MIMO</option>
							<option value="A">ALL</option>
							<option value="1" >FI -> FO</option>
							<option value="2" >FI -> MO</option>
							<option value="3" >MI -> FO</option>
							<option value="4" >MI -> MO</option>
						</select></td> 
					<td></td>
				</tr> 
				<tr class="h23">
					
					<th>TP/SZ</th>
					<td><script type="text/javascript">ComComboObject('tpsz', 1, 125,1);</script></td>
					<td></td>
					<th>En Route</th>
					<td><select style="width:95px;" class="input" name="enRoute" id="enRoute" disabled>
						<option value="" selected></option>
						<option value="E"  >Exclude</option>
						<option value="I">Include</option>
						<option value="O">Only</option>
						</select></td>
					<th>T/S CNTR</th>
					<td width="97"><select style="width:80px;" class="input" name="tscntr" id="tscntr">
						<option value="E" selected>Exclude</option>
						<option value="I" >Include</option>
						<option value="O" >Only</option>
						</select></td>
					<th>S.O.C&nbsp;&nbsp;</th>
					<td><select style="width:90px;" class="input" name="soc" id="soc">
						<option value="E" selected>Exclude</option>
						<option value="I" >Include</option>
						<option value="O" >Only</option>
						</select></td>
				
				</tr> 
			</table>
</div>
</div>
<!-- wrap_result(S) -->
<div class="wrap_result">
    <div class="opus_design_tab sm" >
		<script type="text/javascript">ComTabObject("tab1")</script>
	</div>
	<div class="opus_design_grid"  id="tabLayer" style="display:none">
 		<script type="text/javascript">ComSheetObject('t1sheet1');</script>
    </div>
    <div class="opus_design_grid"  id="tabLayer" style="display:none">
 		<script type="text/javascript">ComSheetObject('t2sheet1');</script>
    </div>
</div>		
<% if(popYn.equals("Y") ){ %></div><%}%>		
</form>