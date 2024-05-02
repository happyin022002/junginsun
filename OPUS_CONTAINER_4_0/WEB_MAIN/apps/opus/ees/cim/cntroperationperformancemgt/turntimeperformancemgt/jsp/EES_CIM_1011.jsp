<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CIM_1011.jsp
*@FileTitle  : Turn Time by Movement
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
<%@ page import="com.clt.apps.opus.ees.cim.cntroperationperformancemgt.turntimeperformancemgt.event.EesCim1011Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesCim1011Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB ResultSet list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.CNTROperatioNPerformanceMgt.TurnTimePerformanceMgt");
	String xml = "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesCim1011Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// adding logic to get data from server when first loading
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

<form name="form">
<input type="hidden" name="sXml" id="sXml" value="<%=xml%>" />
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="from" id="from" />
<input type="hidden" name="to" id="to" />
<!-- developer job	-->
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
			 --><button type="button" class="btn_normal" name="btn_downexce" id="btn_downexce">Down Excel</button>
			
			
		</div>
		<!-- opus_design_btn(E) -->	
<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_location(E) -->
<!-- opus_design_inquiry(S) -->
<div class= "wrap_search_tab">
<div class= "opus_design_inquiry wFit">
	<!-- layout_wrap(S) -->
      <table>
		<tbody>
			<colgroup>
				<col width="50"/>
				<col width="300"/>
				<col width="70"/>
				<col width="220"/>
				<col width="150"/>
				<col width="*" />
			</colgroup>
				<tr>
					<th>&nbsp;Period</th>
					<td><select style="width:130px;" class="input1" name="period" id="period"> 
						 <option value="M" selected>Month(YYYY-MM)</option> 
						 <option value="W" >Week(YYYY-WW)</option> 
						 </select><!-- 
					 	--><input type="text" style="width:55px;text-align:center;" class="input1" value="" name="froms" id="froms" dataformat="ym" maxlength="6">&nbsp;~&nbsp;&nbsp;<!-- 
						 --><input type="text" style="width:55px;text-align:center;" class="input1" value="" name="tos" id="tos" dataformat="ym" maxlength="6"></td>
					<th>Location by</th>
					<td><select style="width:100px;" class="input1" name="inquiryLevel" id="inquiryLevel">
							 <option value="AR" selected>All(by RCC)</option>
							 <option value="AC" >All(Country)</option> 
							 <option value="RL" >RCC(by LCC)</option> 
							 <option value="RE" >RCC(by ECC)</option> 
							 <option value="LE" >LCC(by ECC)</option> 
							 <option value="LS" >LCC(by SCC)</option> 
							 <option value="ES" >ECC(by SCC)</option> 
							 <option value="SS" >SCC</option> 
						 </select><!-- 
						 --><input type="text" style="width:85px;" class="input2" value="" name="location" id="location" dataformat="engup" maxLength ="5" disabled><!-- 
						 --><button type="button" id="btn_loc_cd" name="btn_loc_cd" class="input_seach_btn"></button><!-- 
						 --></td>
					<td><input type="radio" class="trans" name="mvmtPairDivision" id="mvmtPairDivision" value="2"><b> MVMT Pair of Sequence</b></td>
					<td><select style="width:140px;" class="input" name="mvmtPair2" id="mvmtPair2"> 
							 <option value="Z" selected></option>
							 <option value="A">IC-EN</option> 
							 <option value="B">EN-IC</option> 
							 <option value="C">IC-ID</option> 
							 <option value="D">ID-MT</option> 
							 <option value="E">MT-EN</option> 
							 <option value="O">MT-TN</option> 
							 <option value="F">MT-XX</option> 
							 <option value="G">XX-MT</option> 
							 <option value="H">MT-OP</option> 
							 <option value="I">OP-OC</option> 
							 <option value="J">OC-EN</option> 
							 <option value="K">EN-OC</option> 
							 <option value="L">OC-VL</option> 
							 <option value="M">EN-MT</option> 
							 <option value="N">MT-VL</option> 
						 </select></td><!-- 
				 --></tr> 
				<tr>
						<th>TP/SZ</th>
						<td>
						<input type="radio" class="trans" checked	   name="tpsz" id="tpsz" value="A"><!-- 
						 --><label for="radio_snc_sc">All</label><!-- 
						 --><input type="radio" class="trans" 			name="tpsz" id="tpsz" value="D"><!-- 
						 --><label for="radio_snc_sc">DRY</label><!-- 
						 --><input type="radio" class="trans" 			name="tpsz" id="tpsz" value="S"><!-- 
						 --><label for="radio_snc_sc">SPCL</label><!-- 
						 --><input type="radio" class="trans" 			name="tpsz" id="tpsz" value="R"><!-- 
						 --><label for="radio_snc_sc">Reefer</label>
						</td>
						<th>S.O.C </th>
						<td width="100"><select style="width:80px;" class="input" name="soc" id="soc"> 
							 <option value="E" selected>Exclude</option> 
							 <option value="I" >Include</option> 
							 <option value="O" >Only</option> 
							 </select></td><!-- 
		 --></tr> 
</table>
</div>
</div>
<!-- wrap_result(S) -->
<div class="wrap_result">	
    <div class="opus_design_tab" >
		<script type="text/javascript">ComTabObject("tab1")</script>
	</div>
	<div class="opus_design_grid"  id="tabLayer" style="display:inline">
 		<script type="text/javascript">ComSheetObject('sheet1');</script>
    </div>
    <div class="opus_design_grid"  id="tabLayer" style="display:none">
 		<script type="text/javascript">ComSheetObject('sheet2');</script>
    </div>
</div>
</form>

