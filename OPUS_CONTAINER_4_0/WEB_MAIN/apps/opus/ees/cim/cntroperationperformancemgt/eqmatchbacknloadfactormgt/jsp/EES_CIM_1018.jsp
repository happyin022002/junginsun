<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CIM_1018.jsp
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
<%@ page import="com.clt.apps.opus.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.event.EesCim1018Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesCim1018Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strCnt_cd		= "";
	String popYn			= "";

	Logger log = Logger.getLogger("com.clt.apps.CNTROperatioNPerformanceMgt.EQMatchBackNLoadFactorMgt");
	String xml = "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strCnt_cd = account.getCnt_cd();

		event = (EesCim1018Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		// adding logic to get data from server when first loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		popYn	= request.getParameter("pop_mode") == null ? "N" : "Y";

		xml = HttpUtil.makeXML(request,response);

	}catch(Exception e) {
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
		var tempVal01  = "<%=JSPUtil.getParameter(request, "inquiryLevel")%>";
		var tempVal02  = "<%=JSPUtil.getParameter(request, "locationBy")%>";
		var tempVal03  = "<%=JSPUtil.getParameter(request, "period")%>";
		var tempVal04  = "<%=JSPUtil.getParameter(request, "froms")%>";
		var tempVal05  = "<%=JSPUtil.getParameter(request, "tos")%>";
		
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		if(tempVal01==""){
			flag0001 = "No";
		}else{
			flag0001 = "Yes";
		}
		document.getElementById("period"    ).value = tempVal03;
		document.getElementById("froms"     ).value = tempVal04;
		document.getElementById("tos"       ).value = tempVal05;
		document.getElementById("locationBy").value = tempVal01;
		document.getElementById("location"  ).value = tempVal02;
		if(tempVal03=="W"){
			document.getElementById("froms").setAttribute("dataformat", "yw");
			document.getElementById("tos").setAttribute("dataformat", "yw");
		}else{
			document.getElementById("froms").setAttribute("dataformat", "ym");
			document.getElementById("tos").setAttribute("dataformat", "ym");
		}
		if( tempVal01=="AR" || tempVal01=="AC" || tempVal01=="AP" ){
			document.getElementById("location").disable   = true;
			document.getElementById("location").className = "input2";
			document.getElementById("location").value     = "";
		}else{
			document.getElementById("location").disable   = false;
			document.getElementById("location").className = "input";
			document.getElementById("location").value     = tempVal02;
		}
		if(tempVal01==""){
			document.getElementById("period").value = "M";
		}
		if(tempVal01==""){
			document.getElementById("locationBy").value = "AR";
		}
		document.form.froms.focus();		
		loadPage(tempVal01);
	}
</script>
<% if(popYn.equals("Y")){ %>
<form name="form">
<input type="hidden" name="sXml" id="sXml" value="<%=xml%>">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="etcDataValue" value="" id="etcDataValue" />
<input type="hidden" name="etcChk" value="" id="etcChk" />
<input type="hidden" name="from" id="from" />
<input type="hidden" name="to" id="to" />
<input type="hidden" name="inquiryLevel" id="inquiryLevel" />
<input type="hidden" name="flag0001" id="flag0001" />
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
<input type="hidden" name="rpt_loc_cd" id="rpt_loc_cd" />
<input type="hidden" name="rpt_cnt_cd" id="rpt_cnt_cd"  value="<%=strCnt_cd%>" >

<input type="hidden" name="pop_yn" id="pop_yn" value="<%=popYn %>">
<!-- page_title_area(S) -->
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>Location M/B By Logistics-wise</span></h2>
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_downExcel" id="btn_downExcel">Down Excel</button><!-- 
			  --><button type="button" class="btn_normal" name="btn_Print" id="btn_Print">Print</button>
		</div>
	</div>
</div>
<!-- page_location(E) -->
<% }else{ %> 
<form name="form">
<input type="hidden" name="sXml" id="sXml" value="<%=xml%>">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="etcDataValue" value="" id="etcDataValue" />
<input type="hidden" name="etcChk" value="" id="etcChk" />
<input type="hidden" name="from" id="from" />
<input type="hidden" name="to" id="to" />
<input type="hidden" name="inquiryLevel" id="inquiryLevel" />
<input type="hidden" name="flag0001" id="flag0001" />
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
<input type="hidden" name="rpt_loc_cd" id="rpt_loc_cd" />
<input type="hidden" name="rpt_cnt_cd" id="rpt_cnt_cd"  value="<%=strCnt_cd%>" >
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
<% } %>	
<% if(popYn.equals("Y") ){ %><div class="layer_popup_contents"><%}%>
<!-- opus_design_inquiry(S) -->
<div class= "wrap_search_tab">
<div class= "opus_design_inquiry wFit">
	<!-- layout_wrap(S) -->
      <table>
		<tbody>
			<colgroup>
				<col width="10"/>
				<col width="10"/>
				<col width="10"/>
				<col width="10"/>
				<col width="10"/>
				<col width="*" />
			</colgroup>	 
				<tr class="h23">
					<th>&nbsp;Period</th>
					<td><select style="width:130px;" class="input1" name="period" id="period" ><!-- 
						 --><option value="M" selected>Month(YYYY-MM)</option><!-- 
						 --><option value="W">Week(YYYY-WW)</option><!-- 
						 --></select><!-- 
						 --><input type="text" style="width:55px;" class="input1" value="" name="froms" id="froms" caption="FM" required dataformat="ym" maxlength="6">&nbsp;~&nbsp;<!-- 
						 --><input type="text" style="width:55px;" class="input1" value="" name="tos" id="tos"   caption="TO" required dataformat="ym" maxlength="6"></td>
					<th>Location by</th>
					<td>
						<select style="width:120px;" class="input1" name="locationBy" id="locationBy" >
						<option value="AR" selected >ALL(by RCC)    </option><!-- 
						 --><option value="AC"          >ALL(by Country)</option><!-- 
						 --><option value="RL"          >RCC(by LCC)    </option><!-- 
						 --><option value="RE"          >RCC(by ECC)    </option><!-- 
						 --><option value="LE"          >LCC(by ECC)    </option><!-- 
						 --><option value="LS"          >LCC(by SCC)    </option><!-- 
						 --><option value="ES"          >ECC(by SCC)    </option><!-- 
						 --><option value="CC"          >Country        </option><!-- 
						 --><option value="SS"          >SCC            </option><!-- 
						 --></select>
						<input type="text" disabled style="width:45;" class="input" value="" dataformat="engup" style="ime-mode:disabled" name="location" id="location" maxlength="5" >
<!-- 						<img class="cursor" name="btn_loc_cd" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"> -->
						<button type="button" id="btn_loc_cd" name="btn_loc_cd" class="input_seach_btn"></button>
					</td>
					<th>Cargo Type</th>
					<td><select style="width:80px;" class="input" name="cargoType" id="cargoType" ><!-- 
						 --><option value="A" selected></option><!-- 
						 --><option value="F"         >Full</option><!-- 
						 --><option value="M"         >MTY</option><!-- 
						 --></select></td><!-- 
					 --><td></td>
					</tr>  
   					<tr class="h23">
       					<th>TP/SZ</th>
       					<td width="" class="stm" style="font-size:12;"><!-- 
   						 --><input type="radio" class="trans" checked name="tpsz" id="tpsz" value="A" onClick="rdTypeSel(this.value)"><!-- 
   						 --><label for="radio_snc_sc">All</label><!-- 
   						 --><input type="radio" class="trans"  name="tpsz" id="tpsz" value="D" onClick="rdTypeSel(this.value)"><!-- 
   						 --><label for="radio_snc_sc">DRY</label><!-- 
   						 --><input type="radio" class="trans"  name="tpsz" id="tpsz" value="S" onClick="rdTypeSel(this.value)"><!-- 
   						 --><label for="radio_snc_sc">SPCL</label><!-- 
   						 --><input type="radio" class="trans"  name="tpsz" id="tpsz" value="R" onClick="rdTypeSel(this.value)"><!-- 
   						 --><label for="radio_snc_sc">Reefer</label><!-- 
   						 --><select style="width:100px;" class="input" name="rdtype" id="rdtype" disabled><!-- 
   						 --><option value="I" selected>Included R/D</option><!-- 
   						 --><option value="E">Excluded R/D</option><!-- 
   						 --><option value="O">Only R/D</option><!-- 
   						 --></select>
          		 	</td>
					<th>En Route </th>
					<td><select style="width:78px;" class="input" name="enRoute" id="enRoute"><!-- 
						 --><option value="E" selected>Exclude</option><!-- 
						 --><option value="I">Include</option><!-- 
						 --><option value="O">Only </option><!-- 
						 --></select>
					</td>
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
<% if(popYn.equals("Y") ){ %></div><%}%>	
</form>
