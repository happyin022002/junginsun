<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CIM_1027.jsp
*@FileTitle  : Location M/B by BKG-Wise
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
<%@ page import="com.clt.apps.opus.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.event.EesCim1027Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesCim1027Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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


		event = (EesCim1027Event)request.getAttribute("Event");
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
<input type="hidden" name="inquiryLevel" id="inquiryLevel" />
<input type="hidden" name="temp_tpsz_val" id="temp_tpsz_val" />

<!-- Report Start -->
<input type="hidden" name="rpt_period" id="rpt_period" />
<input type="hidden" name="rpt_fromdate" id="rpt_fromdate" />
<input type="hidden" name="rpt_todate" id="rpt_todate" />
<input type="hidden" name="rpt_locationby" id="rpt_locationby" />
<input type="hidden" name="rpt_location" id="rpt_location" />
<input type="hidden" name="rpt_tpsz" id="rpt_tpsz" />
<input type="hidden" name="rpt_rdtype" id="rpt_rdtype" />
<input type="hidden" name="rpt_soc" id="rpt_soc" />
<input type="hidden" name="rpt_cnt_cd" id="rpt_cnt_cd"  value="<%=strCnt_cd%>" >

<input type="hidden" name="com_mrdPath" id="com_mrdPath" />
<input type="hidden" name="com_mrdArguments" id="com_mrdArguments" />
<input type="hidden" name="com_mrdBodyTitle" id="com_mrdBodyTitle" />
<input type="hidden" name="com_mrdTitle" id="com_mrdTitle" />

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
			 --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_downExcel" id="btn_downExcel">Down Excel</button><!-- 
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
				<col width="45px"/>
				<col width="70px"/>
				<col width="100px"/>
				<col width="*" />
			</colgroup>	 
			<tr>
				<th>Period</th>
				<td width="127"><select style="width:128px;" class="input1" name="period" id="period" ><option value="M" selected>Month(YYYY-MM)</option><option value="W">Week(YYYY-WW)</option></select><input type="text" style="width:55px;" class="input1" value="" name="froms" caption="FM" required dataformat="ym" maxlength="6" id="froms" />~&nbsp;<input type="text" style="width:55px;" class="input1" value="" name="tos" caption="TO" required dataformat="ym" maxlength="6" id="tos" /><input type="hidden" name="getFocus" value="" maxlength="1" required id="getFocus" />
				<th>Location by</th>
				<td>
				<select style="width:100;" class="input1" name="locationBy" id="locationBy" onkeypress="form_keyup();"><!-- 
					 --><option value="AR" selected >All(by RCC)    </option><!--
					--><option value="AC"          >All(by Country)</option><!--
					--><option value="AP"          >All(by Port)   </option><!--
					--><option value="RL"          >RCC(by LCC)    </option><!--
					--><option value="RE"          >RCC(by ECC)    </option><!--
					--><option value="RC"          >RCC(by Country)</option><!--
					--><option value="RP"          >RCC(by Port)   </option><!--
					--><option value="LE"          >LCC(by ECC)    </option><!--
					--><option value="LS"          >LCC(by SCC)    </option><!--
					--><option value="ES"          >ECC(by SCC)    </option><!--
					--><option value="SS"          >SCC            </option><!--
					--></select> <input type="text" disabled style="width:65px;" class="input" value="" dataformat="engup" style="ime-mode:disabled" name="location" id="location" maxlength="5" ><!--
					--><button type="button" id="btn_loc_cd" name="btn_loc_cd" class="input_seach_btn"></button>
					<!-- <img class="cursor" name="btn_loc_cd" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"> -->
					
				</td>
			</tr> 
			<tr>
				<th>TP/SZ</th>
				<td >
					<input type="radio" class="trans" checked name="tpsz" value="A" onclick="rdTypeSel(this.value)" id="tpsz" /><!-- 
					 --><label for="radio_snc_rfa">All</label><!-- 
					 --><input type="radio" class="trans" name="tpsz" value="D" onclick="rdTypeSel(this.value)" id="tpsz" /><!-- 
					 --><label for="radio_snc_rfa">DRY</label><!-- 
					 --><input type="radio" class="trans" name="tpsz" value="S" onclick="rdTypeSel(this.value)" id="tpsz" /><!-- 
					 --><label for="radio_snc_rfa">SPCL</label><!-- 
					 --><input type="radio" class="trans" name="tpsz" value="R" onclick="rdTypeSel(this.value)" id="tpsz" /><!-- 
					 --><label for="radio_snc_rfa">Reefer</label>
					<select style="width:100;" class="input" name="rdtype" id="rdtype" disabled><!-- 
					 --><option value="I" selected>Include R/D</option><!-- 
					 --><option value="E">Exclude R/D</option><!-- 
					 --><option value="O">Only R/D</option><!-- 
					 --></select></td>
				<th>S.O.C</th>
				<td><select style="width:80px;" class="input" name="soc" id="soc"><!-- 
					 --><option value="E" selected>Exclude</option><!-- 
					 --><option value="I">Include</option><!-- 
					 --><option value="O">Only </option><!-- 
					 --></select>
				</td>
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
    <div class="opus_design_grid"  id="tabLayer" style="display:none">
 		<script type="text/javascript">ComSheetObject('t3sheet1');</script>
    </div>
</div>			
</form>				

