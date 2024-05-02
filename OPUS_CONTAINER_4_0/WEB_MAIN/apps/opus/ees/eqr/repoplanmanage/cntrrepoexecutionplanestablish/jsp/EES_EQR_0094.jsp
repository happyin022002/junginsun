<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : EES_EQR_0094.jsp
*@FileTitle  : Inventory Container List
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/03
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.event.EesEqr0094Event"%>
<%@ page import="com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0094ConditionVO"%>
<%@ page import="com.clt.apps.opus.ees.eqr.common.eqrcommon.basic.CommonBC"%>
<%@ page import="com.clt.apps.opus.ees.eqr.common.eqrcommon.basic.CommonBCImpl"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	EesEqr0094Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";								 //error message
	int rowCount	 = 0;								  //count of DB resultSET list

	String ref_id 		= "";
	String targetSheet  = "";
	String targetRow    = "";
	String cntrno    = "";
	String cntr_all     = "";
	String repoplan_id  = "";
	String ref_check = "";
	String view = "";
    String bkgno = "";
    String bkgno_split = "";
    String fm_ecc = "";
    String to_ecc = "";
    String trsp_mode = "";
    String pln_yrwk = "";


	try {

		event = (EesEqr0094Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		EesEqr0094ConditionVO conditionVO = event.getEesEqr0094ConditionVO();
		ref_id     = conditionVO.getRefId();
		targetSheet= conditionVO.getTargetsheet();
		targetRow  = conditionVO.getTargetrow();
		cntrno     = conditionVO.getCntrno(); // getCntrList
		cntr_all   = conditionVO.getCntrAll();//getCntrAllList
		repoplan_id= conditionVO.getRepoplanId();
		view	   = conditionVO.getView();
		bkgno      = conditionVO.getBkgno();
		bkgno_split= conditionVO.getBkgnoSplit();
		fm_ecc     = conditionVO.getFmEcc();
		to_ecc	   = conditionVO.getToEcc();
		trsp_mode  = conditionVO.getTrspMode();
		pln_yrwk   = conditionVO.getPlnYrwk();

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}

	String optionStr = "000000: :ALL";
	String actionSelectBox  = JSPUtil.getCodeCombo("loctype","","OnChange='displayType()' style='width:63;'","CD00242",0,optionStr);
	//String actionSelectBox1 = JSPUtil.getCodeCombo("TPSZ","","onChange='javascript:tpszChange(document.form.TPSZ.options[document.form.TPSZ.selectedIndex].value)' style='width:63;'","CD00263",0,optionStr);
	
	String actionSelectBox1 = JSPUtil.getCodeCombo("TPSZ","","onChange='javascript:tpszChange(document.form.TPSZ.options[document.form.TPSZ.selectedIndex].value)' style='width:63;'","CD01527",0,optionStr);
	CommonBC tpszUtil = new CommonBCImpl(); 	//Combo BOX

%>
<script  type="text/javascript">

// Type Size
<%//= JSPUtil.getIBCodeCombo("tpszall", "01", "CD00244", 0, "")%> // ALL TYPE SIZE
<%//= JSPUtil.getIBCodeCombo("tpszdry", "01", "CD00751", 0, "")%> // DRY TYPE SIZE
<%//= JSPUtil.getIBCodeCombo("tpszrfr", "01", "CD00752", 0, "")%> // RFR TYPE SIZE
<%//= JSPUtil.getIBCodeCombo("tpszot",  "01", "CD00753", 0, "")%> // OT  TYPE SIZE
<%//= JSPUtil.getIBCodeCombo("tpszfr",  "01", "CD00754", 0, "")%> // FR  TYPE SIZE
<%= tpszUtil.getTpSzCodeCombo("eqr", "tpszall", "", "", "", "", "")%>
<%= tpszUtil.getTpSzCodeCombo("eqr", "tpszdry", "", "D", "", "", "")%>
<%= tpszUtil.getTpSzCodeCombo("eqr", "tpszspc", "", "S", "", "", "")%>
<%= tpszUtil.getTpSzCodeCombo("eqr", "tpszrb", "", "R", "", "", "")%>

<%= JSPUtil.getIBCodeCombo("lease",   "01", "CD00240", 0, "")%> // Lease Term
<%= JSPUtil.getIBCodeCombo("move",   "01", "CD00252", 0, "") %> // Movement Status

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if

		loadPage();
	}

</script>
<script  type="text/javascript">
	// ------- type variable -------------- START
	var consTpsz      = replaceAll(tpszallText, "|", ",");
	var consTpszArr   = consTpsz.split(',');
	var consTpszDry   = replaceAll(tpszdryText, "|", ",");	
	var consTpszSpc   = replaceAll(tpszspcText, "|", ",");
	var consTpszZrb   = replaceAll(tpszrbText, "|", ",");
	/* var consTpszRfr   = replaceAll(tpszrfrText, "|", ",");
	var consTpszOt    = replaceAll(tpszotText,  "|", ",");
	var consTpszFr    = replaceAll(tpszfrText,  "|", ","); */
	// ------- type variable -------------- END
</script>
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="iPage" id="iPage" />
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
<input type="hidden" name="scnr_id" id="scnr_id" />
<input type="hidden" name="ref_id" value="<%=ref_id%>" id="ref_id" />
<input type="hidden" name="ref_check" value="<%=ref_check%>" id="ref_check" />
<input type="hidden" name="targetSheet" value="<%=targetSheet%>" id="targetSheet" />
<input type="hidden" name="targetRow" value="<%=targetRow%>" id="targetRow" />
<input type="hidden" name="cntrno" value="<%=cntrno%>" id="cntrno" />
<input type="hidden" name="cntr_all" value="<%=cntr_all%>" id="cntr_all" />
<input type="hidden" name="repoplan_id" value="<%=repoplan_id%>" id="repoplan_id" />
<input type="hidden" name="view" value="<%=view%>" id="view" />
<input type="hidden" name="bkgno" value="<%=bkgno%>" id="bkgno" />
<input type="hidden" name="bkgno_split" value="<%=bkgno_split%>" id="bkgno_split" />
<input type="hidden" name="chk_cntrno" id="chk_cntrno" />
<input type="hidden" name="fm_ecc" value="<%=fm_ecc%>" id="fm_ecc" />
<input type="hidden" name="to_ecc" value="<%=to_ecc%>" id="to_ecc" />
<input type="hidden" name="trsp_mode" value="<%=trsp_mode%>" id="trsp_mode" />
<input type="hidden" name="pln_yrwk" value="<%=pln_yrwk%>" id="pln_yrwk" />
<input type="hidden" name="cntr_no_list" id="cntr_no_list" />
<input type="hidden" name="hid_rulabel_type" id="hid_rulabel_type" />
<!-- add IFrame value E -->
	<div class="layer_popup_title">
		<!-- page_title_area(S) -->
		<div class="page_title_area clear">
		   <!-- page_title(S) -->
			<h2 class="page_title"><span>Create / Update</span></h2>
			<!-- page_title(E) -->
			<!-- opus_design_btn(S) -->
			<div class="opus_design_btn">
				<button type="button" class="btn_accent" name="btn_retrieve" 	id="btn_retrieve">Retrieve</button><!--
				--><button type="button" class="btn_normal" name="btn_new" 		id="btn_new">New</button><!--
				--><button type="button" class="btn_normal" name="btn_apply" 		id="btn_apply">Apply</button><!--
				--><button type="button" class="btn_normal" name="btn_loadexcel" 		id="btn_loadexcel">Load Excel</button><!--
				--><button type="button" class="btn_normal" name="btn_Close"  		id="btn_Close" onClick="javascript:ComClosePopup();">Close</button>	
			</div>
			<!-- opus_design_btn(E) -->
		</div>
		<!-- page_title_area(E) -->
	</div>
	<!-- opus_design_inquiry(S) -->
<div class="layer_popup_contents">
	<div class= "wrap_search">
		<div class= "opus_design_inquiry wFit">
			<table>
				<tbody>
					<colgroup>
						<col width="80"/>
						<col width="320"/>
						<col width="80"/>
						<col width="100"/>
						<col width="80"/>
						<col width="*"/>
				    </colgroup>
					<tr>
						<th>Location</th>
						<td><select id="loctype"  style="width:56px;" name="loctype" id="loctype" class="input1"><option value="L">LCC</option><option value="E">ECC</option></select><input class="input1" name="locList" type="text" dataformat="engup" style="width:150px;ime-mode:disabled;" value="" id="locList" /><button type="button" id="loc_btn" name="loc_btn" class="input_seach_btn"></button></td>
						<th>MVMT Status</th>
						<td><script type="text/javascript">ComComboObject('move' , 1 , 80, 1 )</script></td>
						<th>Lease Term</th>
						<td> <script type="text/javascript">ComComboObject('lease' , 1 , 80, 1 )</script></td>
					</tr>	
					<tr>
						<th>TP/SZ</th>
						<td colspan="5"><%=actionSelectBox1%><script type="text/javascript">ComComboObject('TPSZS' , 1 , 160, 1 )</script><!-- 
							--><input type="checkbox" name="dm" value="Y" class="trans" id="dm" /><label for="dm">DM</label><!--
							--><input type="checkbox" name="hr" value="Y" class="trans" id="hr" /><label for="hr">HR</label><!--
							--><input type="checkbox" name="hb" value="Y" class="trans" id="hb" /><label for="hb">HB</label><!--
							--><input type="checkbox" name="rb" value="Y" class="trans" id="rb" /><label for="rb">RB</label><!--
							--><input type="checkbox" name="dp" value="Y" class="trans" id="dp" /><label for="dp">DB</label><!--
							--><input type="checkbox" name="pf" value="Y" class="trans" id="pf" style="display:none"/><label for=pf style="display:none">PF</label><!--
							--><input type="checkbox" name="im" value="Y" class="trans" id="im" /><label for="im">IM</label><!--
							--><input type="checkbox" name="ma" value="Y" class="trans" id="ma" /><label for="ma">MA</label><!--
							--><input type="checkbox" name="hm" value="Y" class="trans" id="hm" /><label for="hm">HM</label></td>
					</tr>
					<tr>
						<th>Yard</th>
						<td><input name="yard" type="text" dataformat="engup" style="width:210px;ime-mode:disabled;" value="" id="yard" /><button type="button" id="yard_btn" name="yard_btn" class="input_seach_btn"></button></td>
						<th>AGMT No.</th>
						<td><input name="agmt_no" type="text" dataformat="engup" style="width:100px;ime-mode:disabled;" value="" id="agmt_no" /> </td>
						<th>RU Label</th>
						<td><input type="text"  name="rstr_usg_lbl" id="rstr_usg_lbl"    style="ime-mode:inactive;background-color:#ffffff"  style="width:150px;" class="input" value=""> <button type="button" id="btn_rulabel_cd" name="btn_rulabel_cd" class="input_seach_btn"></button></td>
					</tr> 
				</tbody>
			</table>
		</div>
	</div>
<!-- opus_design_inquiry(E) -->
<!-- opus_design_grid(S) -->
<div class="wrap_result">
	<div class="opus_design_grid clear" >
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btng_rowadd" id="btng_rowadd">Row Add</button>
			<!-- <button type="button" class="btn_accent" name="btng_delete" id="btng_delete">Row Delete</button> -->
		</div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
<!-- opus_design_grid(E) -->	
	
</div>
<iframe frameborder=0 width=0 name="094iframe" scrolling="no" frameborder="0" width="0" height="0">
</iframe>
</form>