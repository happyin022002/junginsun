<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CIM_1023.jsp
*@FileTitle  : Location M/B by Logistics-Wise
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
<%@ page import="com.clt.apps.opus.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.event.EesCim1023Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesCim1023Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strCnt_cd		= "";
	Logger log = Logger.getLogger("com.clt.apps.CNTROperatioNPerformanceMgt.EQMatchBackNLoadFactorMgt");
	String xml = "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strCnt_cd = account.getCnt_cd();


		event = (EesCim1023Event)request.getAttribute("Event");
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

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
		document.form.froms.focus();		
	}
</script>
<form name="form">
<input type="hidden" name="sXml" id="sXml" value="<%=xml%>">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="etcDataValue" value="" id="etcDataValue" />
<input type="hidden" name="etcChk" value="" id="etcChk" />
<input type="hidden" name="from" id="from" />
<input type="hidden" name="to" id="to" />
<input type="hidden" name="inquiryLevel2" id="inquiryLevel2" />

<!-- Report Start -->
<input type="hidden" name="rpt_period" id="rpt_period" />
<input type="hidden" name="rpt_fromdate" id="rpt_fromdate" />
<input type="hidden" name="rpt_todate" id="rpt_todate" />
<input type="hidden" name="rpt_locationby" id="rpt_locationby" />
<input type="hidden" name="rpt_location" id="rpt_location" />
<input type="hidden" name="rpt_cargotype" id="rpt_cargotype" />
<input type="hidden" name="rpt_tpsz" id="rpt_tpsz" />
<input type="hidden" name="rpt_rdtype" id="rpt_rdtype" />
<input type="hidden" name="rpt_enroute" id="rpt_enroute" />
<input type="hidden" name="rpt_soc" id="rpt_soc" />
<input type="hidden" name="rpt_company" id="rpt_company" />
<input type="hidden" name="rpt_cnt_cd" id="rpt_cnt_cd"  value="<%=strCnt_cd%>" >
<!-- Report End -->
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
		 --><button type="button" class="btn_normal" name="btn_DownExcel" id="btn_DownExcel">Down Excel</button><!-- 
		  --><button type="button" class="btn_normal" name="btn_Print" id="btn_Print">Print</button>
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
			<col width="10"/>
			<col width="80"/>
			<col width="300"/>
			<col width="10"/>
			<col width="*" />
		</colgroup>	 
		<tr>
			<th>Period</th>
			<td><select style="width:130px;" class="input1" name="period" id="period" >
				<option value="M" selected>Month(YYYY-MM)</option>
				<option value="W">Week(YYYY-WW)</option>
				</select><!-- 
			 	 --><input type="text" style="width:55px;" class="input1" value="" name="froms" caption="FM" required dataformat="ym" maxlength="6" id="froms" />~&nbsp;<!--  
				 --><input type="text" style="width:55px;" class="input1" value="" name="tos" required dataformat="ym" caption="TO" maxlength="6" id="tos" /><!-- 
			 --></td>
			<th>Location </th>
			<td><select style="width:70px;" class="input1" name="inquiryLevel" id="inquiryLevel">
				<option value="A" selected></option>
				<option value="R" >RCC</option>
				<option value="L" >LCC</option>
				<option value="E" >ECC</option>
				<option value="P" >PORT</option>
				<option value="Y" >YARD</option>
				</select><input type="text" style="width:72px;ime-mode:disabled" class="input" name="location" id="location" value=""  dataformat="engup"  maxlength="5"  disabled><!-- 
				 --><button type="button" id="btn_loc_cd" name="btn_loc_cd" class="input_seach_btn"></button>
				</td>
			<th>Cargo Type</th>
			<td width=""><select style="width:55px;" class="input" name="cargotype">
				<option value="A" selected></option>
				<option value="F">FULL</option>
				<option value="M" >MTY</option>
				</select></td>
			</tr> 
		<tr>
			<th>TP/SZ</th>
			<td width="345px" class="stm" style="font-size:12;">
				<input type="radio" class="trans" checked name="tpsz" value="A" onclick="rdTypeSel(this.value)" id="tpsz" /><!-- 
				 --><label for="radio_snc_rfa">All</label><!-- 
				 --><input type="radio" class="trans" name="tpsz" value="D" onclick="rdTypeSel(this.value)" id="tpsz" /><!-- 
				 --><label for="radio_snc_rfa">DRY</label><!-- 
				 --><input type="radio" class="trans" name="tpsz" value="S" onclick="rdTypeSel(this.value)" id="tpsz" /><!-- 
				 --><label for="radio_snc_rfa">SPCL</label><!-- 
				 --><input type="radio" class="trans" name="tpsz" value="R" onclick="rdTypeSel(this.value)" id="tpsz" /><!-- 
				 --><label for="radio_snc_rfa">Reefer</label>
				<select style="width:100px;" class="input" name="rdtype" id="rdtype" disabled>
				<option value="I"selected>Include R/D</option><!-- 
				 --><option value="E">Exclude R/D</option><!-- 
				 --><option value="O">Only R/D</option><!-- 
				 --></select></td>
			<th>T/S CNTR</th>
			<td><select style="width:78px;" class="input" name="tscntr" id="tscntr">
				<option value="E"selected>Exclude</option><!-- 
				 --><option value="I">Include</option><!-- 
				 --><option value="O">Only </option><!-- 
				 --></select></td>
			<th>S.O.C </th>
			<td width="110px"><select style="width:90px;" class="input" name="soc" id="soc">
				<option value="E"selected>Exclude</option><!-- 
				 --><option value="I">Include</option><!-- 
				 --><option value="O">Only </option><!-- 
				 --></select></td>
			<td></td>

		</tr> 
</table>
</div>
</div>
<!-- wrap_result(S) -->
<div class="wrap_result">
    <div class="opus_design_tab sm" >
		<script type="text/javascript">ComTabObject("tab1")</script>
	</div>
	<div class="opus_design_grid"  id="tabLayer" style="display:inline">
 		<script type="text/javascript">ComSheetObject('t1sheet1');</script>
    </div>
    <div class="opus_design_grid"  id="tabLayer" style="display:none">
 		<script type="text/javascript">ComSheetObject('t2sheet1');</script>
    </div>
</div>			
</form>				
