<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : EES_EQR_0059.jsp
*@FileTitle : Execution Plan
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/23
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.eqr.common.Constants"%>
<%@ page import="com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.event.EesEqr0059Event"%>
<%@ page import="com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0059ConditionVO" %>
<%@ page import="com.clt.apps.opus.ees.eqr.common.eqrcommon.basic.CommonBC"%>
<%@ page import="com.clt.apps.opus.ees.eqr.common.eqrcommon.basic.CommonBCImpl"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	EesEqr0059Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.RepoPlanManage.CntrRepoExecutionPlanEstablish");

	String user_id              = "";
	String user_level 			= "";
	String user_search_div 		= "";
	String user_modify_div 		= "";
	String user_search_location = "";
	String user_modify_location = "";
	String user_access          = ""; // checking user athority (TRUE, FALSE)

	String linkTabNum = "0";
	String yyyyww     = "";
	String seq        = "";
	String fromStatus = "";
	String toStatus   = "";
	String fromLocation= "";
	String toLocation = "";

	String saveFlag = "";  //  checking user athority 

	String optionStr = "000001: :ALL";

	// from loc select box
	String frLocSelectBox = JSPUtil.getCodeCombo("fromStatus","","onChange='javascript:frLocChange(document.form.fromStatus.options[document.form.fromStatus.selectedIndex].value)' style='width:80px;'","CD00259",0,optionStr);

	// to loc select box
	String toLocSelectBox = JSPUtil.getCodeCombo("toStatus",  "","onChange='javascript:toLocChange(document.form.toStatus.options[document.form.toStatus.selectedIndex].value)'     style='width:80px;'","CD00259",0,optionStr);
	
	//Execution Type
	String execTypeSelectBox = JSPUtil.getCodeCombo("exectype","","onChange='javascript:exectypeChange(document.form.exectype.options[document.form.exectype.selectedIndex].value)' style='width:53;background-color: rgb(212, 246, 255);'","CD30127",0,"");
	
	// At loc select box
	//String atLocSelectBox = JSPUtil.getCodeCombo("atStatus",  "","onChange='javascript:atLocChange(document.form.atStatus.options[document.form.atStatus.selectedIndex].value)' 	    style='width:120;'","CD00259",0,optionStr);

	// TP/SZ select 박스
	String tyszSelectBox = JSPUtil.getCodeCombo("tpsz","","onChange='javascript:tpszChange(document.form.tpsz.options[document.form.tpsz.selectedIndex].value)' style='width:50;'","CD01527",0,optionStr);
	CommonBC tpszUtil = new CommonBCImpl(); 	//Combo BOX
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesEqr0059Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		EesEqr0059ConditionVO conditionVO = new EesEqr0059ConditionVO();
		conditionVO = event.getEesEqr0059ConditionVO();
		user_level 			 = conditionVO.getUserLevel();
		user_search_div 	 = conditionVO.getUserSearchDiv();
		user_modify_div 	 = conditionVO.getUserModifyDiv();
		user_search_location = conditionVO.getUserSearchLocation();
		user_modify_location = conditionVO.getUserModifyLocation();
		user_access          = conditionVO.getUserFullAccess();

		user_id = event.getSignOnUserAccount().getUsr_id();

		// data from EES_EQR_0051
		linkTabNum	= conditionVO.getLinktabnum();
		fromStatus	= conditionVO.getFromstatus();
		toStatus	= conditionVO.getTostatus();
		fromLocation= conditionVO.getFromlocation();
		toLocation	= conditionVO.getTolocation();
		
		yyyyww		= conditionVO.getYyyyww();
		seq			= conditionVO.getSeq();
		

		// ====================== checking user athority about retrieving, modifying[START] =============================================
        /*
         * eqr_auth[0]==true || eqr_auth[6]==true    ----> retrieving, modifying  [all location retrieving]
         * eqr_auth[7]==true                         ----> retrieving, modifying  [RCC retrieving]
         * eqr_auth[4]==true                         ----> retrieving        [RCC retrieving]
         * eqr_auth[3]==true                         ----> retrieving        [all location retrieving]
         */
        if(user_level.equals("1")) {
        	saveFlag = "TRUE"; 

        }else if(user_level.equals("2")) {
        	saveFlag = "TRUE";

        }else if(user_level.equals("3")) {
        	saveFlag = "FALSE";

        }else if(user_level.equals("4")) {
        	saveFlag = "FALSE";

        }else if(user_level.equals("5")) {
        	saveFlag = "TRUE"; 

        }else {
        	saveFlag = "FALSE";

        }
  		// ====================== checking user athority about retrieving, modifying[ END ] =============================================


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
	ComOpenWait(true);
	// Item ( ALL )
	<%= JSPUtil.getIBCodeCombo("item",    "01", "CD00253", 0, "")%>
	// Item (Truck, Rail, Water)
	<%= JSPUtil.getIBCodeCombo("item_inland",    "01", "CD00566", 0, "")%>
	// Item ( On Hire & Off Hire )
	<%= JSPUtil.getIBCodeCombo("item_hire",    "01", "CD00241", 0, "")%>
	// Item ( LEASE Status Code )
	<%= JSPUtil.getIBCodeCombo("item_lease",    "01", "CD00240", 0, "")%>
	
	// Item (Truck, Water) - SHUTTLE
	<%= JSPUtil.getIBCodeCombo("item_shuttle",    "01", "CD00566", 0, "")%>
	// Purpose
	<%= JSPUtil.getIBCodeCombo("purpose", "01", "CD00269", 0, " ")%>
	// company
	<%= JSPUtil.getIBCodeCombo("company", "01", "CD00264", 0, "")%> //CD00264 // CD00434
	
	//
	<%= JSPUtil.getIBCodeCombo("exectype", "01", "CD30127", 0, "")%>
	<%= JSPUtil.getIBCodeCombo("trsp", "01", "CD30127", 0, "")%>

	// Type Size
    <%//= JSPUtil.getIBCodeCombo("tpszall", "01", "CD00830", 0, "")%> // ALL TYPE SIZE CD00244
    <%//= JSPUtil.getIBCodeCombo("tpszdry", "01", "CD00751", 0, "")%> // DRY TYPE SIZE
    <%//= JSPUtil.getIBCodeCombo("tpszrfr", "01", "CD00752", 0, "")%> // RFR TYPE SIZE
    <%//= JSPUtil.getIBCodeCombo("tpszot",  "01", "CD00828", 0, "")%> // OT  TYPE SIZE CD00753
    <%//= JSPUtil.getIBCodeCombo("tpszfr",  "01", "CD00829", 0, "")%> // FR  TYPE SIZE CD00754
    <%= tpszUtil.getTpSzCodeCombo("eqr", "tpszall", "", "", "", "", "")%>
    <%= tpszUtil.getTpSzCodeCombo("eqr", "tpszdry", "", "D", "", "", "")%>
    <%= tpszUtil.getTpSzCodeCombo("eqr", "tpszspc", "", "S", "", "", "")%>
    <%= tpszUtil.getTpSzCodeCombo("eqr", "tpszrb", "", "R", "", "", "")%>

	// ------- type variable -------------- START
	var consTpsz      = replaceAll(tpszallText, "|", ",");
	var consTpszArr   = consTpsz.split(',');
	var consTpszDry   = replaceAll(tpszdryText, "|", ",");
	var consTpszSpc   = replaceAll(tpszspcText, "|", ",");
	var consTpszZrb   = replaceAll(tpszrbText, "|", ",");
	// ------- type variable -------------- END

	// ------- Constant variable --------------- START
	var repoword = "<%=Constants.REPO_WORD%>";
	var repoweek = "<%=Constants.SCNR_WEEK%>";
	// ------- Constant variable -------------- END

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		// InitTab();		
		
        sheetObjects[0].SetWaitImageVisible(1);
		loadPage(<%=linkTabNum%>);  
	}
</script>

<form name="form" id="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />

<input type="hidden" name="iPage" id="iPage" />
<input type="hidden" name="localDate" id="localDate" />
<input type="hidden" name="position_row1" value="1" id="position_row1" />
<input type="hidden" name="position_row2" value="1" id="position_row2" />
<input type="hidden" name="position_row3" value="1" id="position_row3" />
<input type="hidden" name="position_row4" value="1" id="position_row4" />

<!-- 051 링크 -->
<input type="hidden" name="link_fromStatus" value="<%= fromStatus %>" id="link_fromStatus" />
<input type="hidden" name="link_toStatus" value="<%= toStatus %>" id="link_toStatus" />

<!-- USER LEVEL, ACTION, LOCATION -->
<input type="hidden" name="user_id" value="<%= user_id %>" id="user_id" />
<input type="hidden" name="user_level" value="<%= user_level %>" id="user_level" />
<input type="hidden" name="user_search_div" value="<%= user_search_div %>" id="user_search_div" />
<input type="hidden" name="user_modify_div" value="<%= user_modify_div %>" id="user_modify_div" />
<input type="hidden" name="user_search_location" value="<%= user_search_location %>" id="user_search_location" />
<input type="hidden" name="user_modify_location" value="<%= user_modify_location %>" id="user_modify_location" />
<input type="hidden" name="user_access" value="<%= user_access %>" id="user_access" />

<!-- IFrame value S -->
<input type="hidden" name="st_year" id="st_year" />
<input type="hidden" name="st_month" id="st_month" />
<input type="hidden" name="st_weekly" id="st_weekly" />
<input type="hidden" name="end_year" id="end_year" />
<input type="hidden" name="end_month" id="end_month" />
<input type="hidden" name="end_weekly" id="end_weekly" />

<input type="hidden" name="perfix_month" id="perfix_month" />
<input type="hidden" name="title_month" id="title_month" />
<input type="hidden" name="perfix_weekly" id="perfix_weekly" />
<input type="hidden" name="title_weekly" id="title_weekly" />
<input type="hidden" name="monthly_count" id="monthly_count" />
<input type="hidden" name="status_type" id="status_type" />
<input type="hidden" name="max_plnYr" id="max_plnYr" />
<input type="hidden" name="max_weekly" id="max_weekly" />
<input type="hidden" name="max_plnYrWk" id="max_plnYrWk" />
<input type="hidden" name="maxWkStr" id="maxWkStr" />
<input type="hidden" name="exePlnEditFlg" id="exePlnEditFlg" />
<input type="hidden" name="exePlnEditFlg_split" id="exePlnEditFlg_split" />

<input type="hidden" name="scnr_id" id="scnr_id" />
<input type="hidden" name="repo_pln_id" id="repo_pln_id" />
<input type="hidden" name="fromToPlnId" id="fromToPlnId" />
<input type="hidden" name="dtrb_flg" id="dtrb_flg" />

<!---------- IFrame value E ------------------>

<input type="hidden" name="vvdSearchCol" value="" id="vvdSearchCol" />

<input type="hidden" name="cntrno" value="" id="cntrno" />
<input type="hidden" name="cntrno_all" value="" id="cntrno_all" />

<input type="hidden" name="repoPlnNextWeek" id="repoPlnNextWeek" />
<input  type="hidden" name="pre_repo_rmk" id="pre_repo_rmk" />   
<input type="hidden" name="saveFlag" value="<%= saveFlag %>" id="saveFlag" />

<input  type="hidden" name="nowWeek" id="nowWeek" />
<input  type="hidden" name="nowDay" id="nowDay" />
<input  type="hidden" name="hidToEta" id="hidToEta" />
<!-- S/O SEND ACTION  -->
<input type="hidden" name="so_action" id="so_action" />

<input type="hidden" name="fmPlnYr" id="fmPlnYr" />
<input type="hidden" name="fmPlnWk" id="fmPlnWk" />
<input type="hidden" name="toPlnYr" id="toPlnYr" />
<input type="hidden" name="toPlnWk" id="toPlnWk" />
<input type="hidden" name="dataselect3" id="dataselect3" />
<input type="hidden" name="middle_point_val" id="middle_point_val" />

<span id="progressPop" width="100%" height="100%"></span>
<!-- 제목 -->
<div class="page_title_area clear">
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->

		<!-- btn_div -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
		--><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!--
		--><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!--
	    --><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button><!--
	    --><button type="button" class="btn_normal" name="btn_print" id="btn_print">Print</button><!--
	     --><button type="button" class="btn_normal" name="btn_eqorg" id="btn_eqorg">Eq Org</button><!--
	    --><button type="button" class="btn_normal" name="btn_eqr_week" id="btn_eqr_week">EQR Week</button><!--
	    --><button type="button" class="btn_normal" name="btn_minimize" 		id="btn_minimize">Maximize</button>
	</div>

   <!-- page_location(S) -->
   <div class="location">
		<span id="navigation"></span>
   </div>
</div>
<!-- 제목 -->
<div id="searchLayer">
	<div class="wrap_search_tab">
		<div class="opus_design_inquiry">
		<table>
			<colgroup>
	            <col width="100">
	            <col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th>Repo. Plan ID </th>
					<td><!-- 
						 --><input class=" input1" type="text" style="width:50px;ime-mode:disabled;" name="yyyyww" id="yyyyww" value="<%=yyyyww%>" maxlength="6" dataformat='num' onkeyup="moveTab(this,seq)" onBlur="javascript:return checkSearch()"><!-- 
						 --><input type="text" style="width:20px" value="W" class="noinput2" readOnly><!-- 
						 --><%= execTypeSelectBox %><!-- 
						 --><input type="text" style="width:40px" value="From" class="noinput2" readOnly><!-- 
						 --><script type="text/javascript">ComComboObject('fm_conti_cd' , 1, 120, 1,1,0  )</script><!-- 
						 --><input type="text" style="width:40px" value="To" class="noinput2" readOnly><!-- 
						 --><script type="text/javascript">ComComboObject('to_conti_cd' , 1, 120, 1,1,0  )</script><!-- 
						 --><input class=" input1" type="text" style="width:35px;ime-mode:disabled;" name="seq" id="seq" value="<%= seq %>" maxlength="2"  dataformat='num' onBlur="javascript:return goSearchRepoid()" ><!-- 				
						 --><button type="button" class="input_seach_btn" name="btn_repolist" id="btn_repolist"></button><!-- 
						 --><input class=" input1" type="text" style="width:355px;" name="repo_rmk" id="repo_rmk" title="">
						 <button class="btn_normal" type="button" name="btn_create" id="btn_create">Create</button>&nbsp;<!-- 
					--> <button class="btn_normal" type="button" name="btn_delete" id="btn_delete">Delete</button>
					</td>
				</tr>
				</table>
				</div>
				<table><tr ><td class="line_bluedot"></td></tr></table>
				<div class="opus_design_inquiry">
				<table>
			<colgroup>
	            <col width="100">
	            <col width="*">
			</colgroup>
			<tbody>
				<!-- <tr>
					<td colspan="2">
						<input type="radio" name="fmToAt" id="fmTo"  value="1" class="trans" checked><label for="fmTo"><b>FM/To</b></label>
						<input type="radio" name="fmToAt" id="fmAt" value="2" class="trans"><label for="fmAt"><b>At</b></label>
						<input type="radio" name="fmToAt" id="fmETD" value="3" class="trans" ><label for="fmETD"><b>Fm ETD</b></label>
						<input type="radio" name="fmToAt" id="fmToEE" value="4" class="trans"><label for="fmToEE"><b>To ETA/ETB</b></label></td>
				</tr> -->
			</tbody>
		</table>
		<table>
				<!-- FROM, TO LOCATION -->
				<colgroup>
		            <col width="100">
		            <col width="300">
		            <col width="80">
		            <col width="200">
		            <col width="127">
		            <col width="250">
		            <col width="*">
				</colgroup>
				<tbody>
					<tr>
						<th class="sm">From Location</th>
						<td class="sm"><%= frLocSelectBox %><!-- 
							 --><input type="text" style="width:150px;ime-mode:disabled;" name="fromLocation" id="fromLocation" value="<%= fromLocation %>" dataformat='engup'><!-- 										
							 --><button type="button" class="input_seach_btn" name="frloc_btn" id="frloc_btn"></button>
						</td>

						<th class="sm">To Location</th>
						<td class="sm"><%= toLocSelectBox %><!-- 
							 --><input type="text" style="width:150px;ime-mode:disabled;" name="toLocation" id="toLocation" value="<%= toLocation %>" dataformat='engup'><!-- 										
							 --><button type="button" class="input_seach_btn" name="toloc_btn" id="toloc_btn"></button>
						</td>
						<th title="Vessel Voyage Direction">VVD</th>
						<td><input name="vvd" id="vvd" type="text" style="width:199px;ime-mode:disabled;" value="" dataformat='engup'><!-- 						
							 --><button type="button" class="input_seach_btn" id="btn_vvd" name="btn_vvd"></button>
						</td>
						<td></td>
					</tr>
				</tbody>
			</table>
		
		
		<div id="fmToLayer" style="display:inline">
			<table>
			<colgroup>
	            <col width="100">
	            <col width="300">
	            <col width="80">
	            <col width="110">
	            <col width="80">
	            <col width="110">
	            <col width="150">
		        <col width="200">
	            <col width="*">
			</colgroup>
			<tbody>
				<tr>
					
					<th>TP / SZ</th>
					<td><%= tyszSelectBox %><!-- 
						 --><script type="text/javascript">ComComboObject('tpsztype' , 1, 150, 1,1,0  )</script></td>
					<th>MT BKG No.</th>
					<td>
						<input type="text" id="mtyBkgNo" name="mty_bkg_no" style="width:80px;" dataformat='engup'>
					</td>
					<th>Ref ID.</th>
					<td><input type="text" id="refId" name="ref_id" style="width:80px;" dataformat='engup' otherchar="_"></td>
					<th>Vol. Selection</th>
						<td><script type="text/javascript">ComComboObject('volsec' , 1, 148, 1,1,0  )</script></td>
					<td></td>
				</tr>
			</tbody>
		</table>
		</div></div>
	</div>
</div>

<div class="wrap_result">
		<div class="opus_design_tab">
			<script type="text/javascript">ComTabObject('tab1')</script>
		</div>
		
		
		<!-- UI_ESS_EQR_083 : THIS IS 4st TAB -->
		<div id="tabLayer">
			<div class="opus_design_grid">
				<div style="float:left;">
			</div>
			
			<div>
				<div class="opus_design_btn">
						<button type="button" class="btn_normal" name="btng_rowadd" id="btng_rowadd">Execution Add</button><!-- 
						--><button type="button" class="btn_normal" name="btng_repobkgcre" id="btng_repobkgcre">Repo BKG Cre</button><!-- 
						 --><button type="button" class="btn_normal" name="btng_sendtoso" id="btng_sendtoso">S/O Send</button><!-- 
						 --><button type="button" class="btn_normal" name="btng_cancelsoreq" id="btng_cancelsoreq">Cancel S/O Req.</button><!--
						 --><button type="button" class="btn_normal" name="btng_contassign" id="btng_contassign">Container Assignment</button><!-- 
						 --><button type="button" class="btn_normal" name="btng_middlepoint" id="btng_middlepoint">Middle Point</button><!--
						 --><button type="button" class="btn_normal" name="t1btng_rowadd" id="t1btng_rowadd" hidden></button><!-- 
						 --><button type="button" class="btn_normal" name="t1btng_rowdelete" id="t1btng_rowdelete" hidden></button>
					</div>
					<script type="text/javascript">ComSheetObject('sheet1');</script>
				</div>	
			</div>		
		</div>	
		
</div>

<!-- <iframe frameborder="0" width="0"  name="059iframe"          scrolling="no" frameborder="0" width="0" height="0"  onload="javascript:059iframe.setupPage()"></iframe> -->
<iframe frameborder="0" width="0"  name="059iframe"          scrolling="no" frameborder="0" width="0" height="0"></iframe>
<iframe frameborder="0" width="0"  name="iframe059_yard"     scrolling="no" frameborder="0" width="0" height="0"></iframe>
<iframe frameborder="0" width="0"  name="iframe059_vvdexist" scrolling="no" frameborder="0" width="0" height="0"></iframe>

</form>
