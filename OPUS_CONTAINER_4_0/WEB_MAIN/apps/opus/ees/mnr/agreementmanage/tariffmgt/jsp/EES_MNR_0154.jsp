<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_0154.jsp
*@FileTitle  :  Disposal Tariff Input by Region
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.event.EesMnr0154Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMnr0154Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Occurred error from server
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//Row count of retrieved database data

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	Logger log = Logger.getLogger("com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();


		event = (EesMnr0154Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		//Extracting retrieved data from server on load screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		}
		loadPage();
	}
</script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<!-- Developer's task	-->
<input type="hidden" name="backendjob_key" id="backendjob_key">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!--  
	--><button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--  
	--><button type="button" class="btn_normal" name="btn_New"  	id="btn_New">New</button><!--  
	--><button type="button" class="btn_normal" name="btn_Save" 	id="btn_Save">Save</button><!--  
	--></div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
	<!-- page_title_area(E) -->
<!-- opus_design_inquiry(S) -->
<div class="wrap_search">
	<div class="opus_design_inquiry wFit">
		<table>
			<tbody>
			<colgroup>
				<col width="60">
				<col width="90">
				<col width="80">
				<col width="110">
				<col width="80">
				<col width="*">
			</colgroup>
				<tr>
					<th>Effective Year/Quarter</th>
					<td><input type="text" name="p_trf_eff_yr" id="p_trf_eff_yr" style="width:50px;" class="input1" maxlength="4" dataformat="yyyy"  caption="From Date"><!--  
					--><button type="button" class="calendar ir" name="btns_calendar1" id="btns_calendar1"></button><!-- 
						 --><select name="p_trf_eff_qtr_no" id="p_trf_eff_qtr_no" caption="Effective Quarter" style="width:90px;" class="input1"><!-- 
						 --><option value="1" selected>1/4 QTA</option>
					 <option value="2">2/4 QTA</option>
					 <option value="3">3/4 QTA</option>
					 <option value="4">4/4 QTA</option>  
					</select> 
					</td>
					<th>EQ Type</th>
					<td><select name="p_eq_knd_cd" id="p_eq_knd_cd" caption="EQ Type" style="width:90;" class="input1"><!-- 
						 --><option value="U" selected>Container</option><!--   
						 --><option value="Z">Chassis</option><!--   
						 --><option value="G">M.G.Set</option>
						</select>
					</td>
					<th>Create By</th>
					<td><input type="text" name="p_cre_usr_id" id="p_cre_usr_id" caption="Create By" style="width:100;text-align:center;color:blue;cursor:hand;" class="input2" value="<%= strUsr_id %>" readonly></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<!-- opus_design_inquiry(E) -->
<div class="wrap_result">
	<div class="opus_design_grid" id="mainTable">
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn"><!--  
		--><button type="button" class="btn_accent" name="btn_RowAdd" id="btn_RowAdd">Row Add</button><!--  
		--><button type="button" class="btn_normal" name="btn_Delete"  	id="btn_Delete">Row Delete</button><!--  
		--><button type="button" class="btn_normal" name="btn_LoadExcel" 	id="btn_LoadExcel">Load Excel</button><!--  
		--><button type="button" class="btn_normal" name="btn_DownExcel" 	id="btn_DownExcel">Down Excel</button><!--  
		--></div>
		<!-- opus_design_btn(E) -->
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
</form>