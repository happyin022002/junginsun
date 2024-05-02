 <%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CIM_1051.jsp
*@FileTitle  : MTY CNTR PFMC by Movement
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
<%@ page import="com.clt.apps.opus.ees.cim.cntroperationperformancemgt.mtyrepositionperformanceanalysis.event.EesCim1051Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesCim1051Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			// error from server
	String strErrMsg = "";						// error message
	int rowCount	 = 0;						// count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.CNTROperatioNPerformanceMgt.MTYRepositionPerformanceAnalysis");
	String xml = "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesCim1051Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		//adding logic to get data from server when first loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		xml = HttpUtil.makeXML(request,response);

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
<form name="form" id="form">
<input type="hidden" name="backendjob_key" id="backendjob_key" />
<input type="hidden" name="gubun" value="S" id="gubun" />
<input type="hidden" name="sXml" id="sXml" value="<%=xml.replaceAll("\n", "").replaceAll("\"", "'")%>">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<!-- developer job	-->
<input type="hidden" name="from" id="from" />
<input type="hidden" name="to" id="to" />
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
			 --><button type="button" class="btn_normal" name="btn_New" id="btn_New">New</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_downExcel" id="btn_downExcel">Down Excel</button>
		</div>
		<!-- opus_design_btn(E) -->	
<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_location(E) -->
<div class= "wrap_search_tab">
<div class= "opus_design_inquiry wFit">
	<!-- layout_wrap(S) -->
      <table>
		<tbody>
		<colgroup>
			<col width="50"/>
			<col width="370"/>
			<col width="90"/>
			<col width="250"/>
			<col width="50"/>
			<col width="*" />
		</colgroup>	 
			<tr>
				<th>Period</th>
				<td><select style="width:140px;" class="input1" name="period" id="period"><!-- 
					 --><option value="D" selected>Date(YYYY-MM-DD)</option><!-- 
					 --><option value="M" >Month(YYYY-MM)</option><!-- 
					 --><option value="W">Week(YYYY-WW) </option><!-- 
					 --></select><!-- </td>
				<td> --><input type="text" style="width:80px;" class="input1" value="" name="froms" caption="FM" required dataformat="ymd" maxlength="8" id="froms" />~&nbsp;<!-- 
					 --><input type="text" style="width:80px;" class="input1" value="" name="tos" required dataformat="ymd" caption="TO" maxlength="8" id="tos" /><!-- 
					  --><button type="button" id="btns_calendarto" name="btns_calendarto" class="calendar ir"></button></td>
				<th>Location </th>
				<td><select style="width:60px;" class="input1" name="inquiryLevel" id="inquiryLevel">
					<option value="L" >LCC</option>
					<option value="E" >ECC</option>
					<option value="S"  selected>SCC</option> 
					<option value="Y" >Yard</option>
					</select><input type="text"  style="width:70px;ime-mode:disabled;" class="input1"  name="location" id="location" value="" dataformat="engup" maxLength ="5"><!-- 
					--><button type="button" id="btn_loc_cd" name="btn_loc_cd" class="input_seach_btn"></button>
				</td>
				<th>S.O.C</th>
				<td><select style="width:80px;" class="input" name="soc" id="soc"><!-- 
					--><option value="E"selected>Exclude</option><!-- 
					--><option value="I" >Include</option><!-- 
					--><option value="O" >Only </option><!-- 
					--></select></td>
			</tr>  
			</tbody>
		</table>
		<table>
		<tbody>
		<colgroup>
			<col width="50"/>
			<col width="120"/>
			<col width="121"/>
			<col width="80"/>
			<col width="102"/>
			<col width="80"/>
			<col width="*" />
		</colgroup>	 
		<tr>
			<th>TP/SZ</th>
			<td><script type="text/javascript" >ComComboObject('tpsz', 1, 140,1);</script></td>
			<th>MVMT PFMC</th><!-- 
			 --><td><select style="width:82px;" class="input" name="mtymvmt" id="mtymvmt"><!-- 
				--><option value="MT" selected>MT</option><!--
				--><option value="MTIDMG">MG</option><!--
				--><option value="MP">MP</option><!--
				--><option value="MR">MR</option><!--
				--><option value="MTVDVD-MT">VD(MTY)</option><!--
				--><option value="VD">VD(Full)</option><!--
				--><option value="VLMTMT-VL">VL(MTY)</option><!--
				--><option value="VL">VL(Full)</option><!--
				--><option value="OP">OP</option><!--
				--><option value="OC">OC</option><!--
				--><option value="IC">IC</option><!--
				--><option value="ID">ID</option><!--
				--><option value="ENF">EN(Full)</option><!--
				--><option value="ENM">EN(MTY)</option><!--
				--><option value="TNF">TN(Full)</option><!--
				--><option value="TNM">TN(MTY)</option><!--
				--><option value="TS">TS</option><!--
				--><option value="CM">CM</option><!--
				--><option value="CP">CP</option><!--
				--><option value="CI">CI</option><!--
				--><option value="CO">CO</option><!--
				--><option value="CD">CD</option><!--
				--><option value="CT">CT</option><!--
				--><option value="CE">CE</option><!--
				--><option value="XX">XX</option><!--
				--><option value="MTOPOP-MT">OP-MT</option><!--
				--><option value="MTOCOC-MT">OC-MT</option><!--
				--><option value="OCIDID-OC">ID-OC</option><!--
				--></select></td>
			<th>Bound</th>
			<td>
				<select style="width:61px;" class="input" name="bound" id="bound">
					<option value="" selected>ALL</option>
					<option value="N" >IN</option>
					<option value="Y" >OUT </option>
				</select>
			</td>
			<th>&nbsp;</th>

			</tr> 
		</tbody>
	</table>
</div>
</div>
<div class="wrap_result">
    <div class="opus_design_tab" >
		<script type="text/javascript">ComTabObject("tab1")</script>
	</div>
	<div class="opus_design_grid"  id="tabLayer" style="display:inline">
 		<script type="text/javascript">ComSheetObject('t1sheet1');</script>
    </div>
    <div class="opus_design_grid"  id="tabLayer" style="display:none">
    <div class="opus_design_btn">
			 <button type="button" class="btn_normal" name="btn_t2EachCNTR" id="btn_t2EachCNTR">Each&nbsp;CNTR</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_t2EachBKG" id="btn_t2EachBKG">Each&nbsp;BKG</button>
		</div>
 		<script type="text/javascript">ComSheetObject('t2sheet1');</script>
    </div>
    <div class="opus_design_grid"  id="tabLayer" style="display:none">
 		<script type="text/javascript">ComSheetObject('t3sheet1');</script>
    </div>
</div>			
</form>				
