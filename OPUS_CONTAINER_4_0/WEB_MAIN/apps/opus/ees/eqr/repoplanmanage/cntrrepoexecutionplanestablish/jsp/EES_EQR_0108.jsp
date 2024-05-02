<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_EQR_0108.jsp
*@FileTitle  : retrieving CNTR repo execution plan
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/27
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.event.EesEqr0108Event"%>
<%@ page import="com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0108ConditionVO"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesEqr0108Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	EesEqr0108ConditionVO conditionVO = null;	// DTO(Data Transfer Object including Parameters)
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";

	String repoPlanId = "";
	String tab        = "";
	String week       = "";
	String fromecc    = "";
	String toecc      = "";
	String etd        = "";
	String eta        = "";
	String week_fromdate= "";
	String week_todate= "";
	String week_maxdate= "";
	String trspmode   = "";
	String vvd        = "";
	String lane       = "";
	String pastplan   = "";
	String scnrId     = "";
	String unit_cost = "";
	String from_cost = "";
	String to_cost   = "";
	String pln_seq	 = "";


	Logger log = Logger.getLogger("com.clt.apps.RepoPlanManage.CntrRepoExecutionPlanEstablish");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event 			= (EesEqr0108Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		conditionVO		= event.getConditionVO();
		repoPlanId = conditionVO.getRepoPlanId();
		tab        = conditionVO.getTab();
		week       = conditionVO.getWeek();
		fromecc    = conditionVO.getFromecc();
		toecc      = conditionVO.getToecc();
		etd        = conditionVO.getEtd();
		eta        = conditionVO.getEta();
		week_fromdate=conditionVO.getWeekFromdate();
		week_todate= conditionVO.getWeekTodate();
		week_maxdate= conditionVO.getWeekMaxdate();
		trspmode   = conditionVO.getTrspmode();
		vvd   	   = conditionVO.getVvd();
		lane   	   = conditionVO.getLane();
		pastplan   = conditionVO.getPastplan();
		scnrId     = conditionVO.getScnrId();

		unit_cost  = conditionVO.getUnitCost();
		from_cost  = conditionVO.getFromCost();
		to_cost    = conditionVO.getToCost();
		pln_seq	   = conditionVO.getPlnSeq();

		event = (EesEqr0108Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// adding logic to get data from server when first loading ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}

%>

<script type="text/javascript">
	// Type Size
    <%= JSPUtil.getIBCodeCombo("tpszall", "01", "CD00830", 0, "")%> // ALL TYPE SIZE CD00244
	// Reason
	<%= JSPUtil.getIBCodeCombo("reason",  "01", "CD00261", 0, " ")%> // CD00369
	// Purpose
	<%= JSPUtil.getIBCodeCombo("purpose", "01", "CD00269", 0, " ")%>
	// company
	<%= JSPUtil.getIBCodeCombo("company", "01", "CD00264", 0, "")%> //CD00264

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
        document.form.tpsz.value = consTpsz;

		loadPage();
	}
</script>
<script type="text/javascript">
	// ------- type variable -------------- START
	var consTpsz    = replaceAll(tpszallText, "|", ",");
	var consTpszArr = consTpsz.split(',');
	// ------- type variable -------------- END


</script>

<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd" id="f_cmd" />

<input type="hidden" name="repo_pln_id" value="<%= repoPlanId %>" id="repo_pln_id" />
<input type="hidden" name="tab" value="<%= tab %>" id="tab" />
<input type="hidden" name="week" value="<%= week %>" id="week" />
<input type="hidden" name="fromecc" value="<%= fromecc %>" id="fromecc" />
<input type="hidden" name="toecc" value="<%= toecc %>" id="toecc" />
<input type="hidden" name="etd" value="<%= etd %>" id="etd" />
<input type="hidden" name="eta" value="<%= eta %>" id="eta" />
<input type="hidden" name="week_fromdate" value="<%= week_fromdate %>" id="week_fromdate" />
<input type="hidden" name="week_todate" value="<%= week_todate %>" id="week_todate" />
<input type="hidden" name="week_maxdate" value="<%= week_maxdate %>" id="week_maxdate" />
<input type="hidden" name="trspmode" value="<%= trspmode %>" id="trspmode" />
<input type="hidden" name="vvd_cd" value="<%= vvd %>" id="vvd_cd" />
<input type="hidden" name="lane_cd" value="<%= lane %>" id="lane_cd" />
<input type="hidden" name="pastplan" value="<%= pastplan %>" id="pastplan" />
<input type="hidden" name="scnrId" value="<%= scnrId %>" id="scnrId" />
<input type="hidden" name="tpsz" id="tpsz" />

<input type="hidden" name="unit_cost" value="<%= unit_cost %>" id="unit_cost" />
<input type="hidden" name="from_cost" value="<%= from_cost %>" id="from_cost" />
<input type="hidden" name="to_cost" value="<%= to_cost %>" id="to_cost" />
<input type="hidden" name="pln_seq" value="<%=pln_seq %>" id="pln_seq" />


<!-- VVD  -->
<input type="hidden" name="vvdSearchCol" value="" id="vvdSearchCol" />

<!-- CNTR  -->
<input type="hidden" name="cntrno" value="" id="cntrno" />

<input type="hidden" name="cntrno_all" value="" id="cntrno_all" />

<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">

		<!-- page_title(S) -->
		<h2 class="page_title"><span>Repo. Execution Plan Inquire / Create / Update</span></h2>
		<!-- page_title(E) -->
		
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_new" 				id="btn_new">New</button><!-- 		
			 --><button type="button" class="btn_normal" name="btn_save" 			id="btn_save">Save</button><!-- 		
			 --><button type="button" class="btn_normal" name="btn_downexcel" 		id="btn_downexcel">Down Excel</button><!-- 		
			 --><button type="button" class="btn_normal" name="btn_print" 			id="btn_print">Print</button><!-- 		
			 --><button type="button" class="btn_normal" name="close" 				id="close">Close</button>		
		</div>
		<!-- opus_design_btn(E) -->
		
	</div>
	<!-- page_title_area(E) -->
</div>

<div class="layer_popup_contents">	

	<div class="wrap_result">		
				
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">	
			<!-- opus_design_btn(S) -->
			<div class="opus_design_btn">
				<button type="button" class="btn_accent" name="btng_rowadd" 			id="btng_rowadd">Row Add</button><!-- 
				 --><button type="button" class="btn_normal" name="btng_rowcopy" 		id="btng_rowcopy">Row Copy</button>		
			</div>
			<!-- opus_design_btn(E) -->		
			<script type="text/javascript">ComSheetObject('sheet1');</script>		
		</div>
		<!-- opus_design_grid(E) -->		
		
	</div>	
</div>
</form>