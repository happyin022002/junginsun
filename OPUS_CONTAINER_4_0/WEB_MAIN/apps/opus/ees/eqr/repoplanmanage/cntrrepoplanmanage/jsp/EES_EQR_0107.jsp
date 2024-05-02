<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_EQR_0107.jsp
*@FileTitle  : Repo Plan ID List retreive Pop-UP
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/15
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoplanmanage.event.EesEqr0045Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesEqr0045Event  event = null;						 //PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;					 //error from server
	String strErrMsg = "";								 //error message
	int rowCount	 = 0;								 //count of DB resultSET list

	String yyyy = JSPUtil.getKST("yyyy");				 // current year

	try {
		event = (EesEqr0045Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// adding logic to get data from server when first loading ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}

//	String optionStr = "000000: :ALL";
//	String status    = JSPUtil.getCodeCombo("status", "", "width='130'", "CD00602", 0, optionStr);
	String repo_SWeek = (request.getParameter("repo_SWeek") == null)? "": request.getParameter("repo_SWeek");
	String repo_EWeek = (request.getParameter("repo_EWeek") == null)? "": request.getParameter("repo_EWeek");
%>


<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
		displayType(0);
	}
</script>

<form method="post" name="form" id="form" onSubmit="return false;">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="yyyy" value="<%=yyyy%>" id="yyyy" />
<input type="hidden" name="repo_SWeek" id="repo_SWeek" value="<%=repo_SWeek%>">
<input type="hidden" name="repo_EWeek" id="repo_EWeek" value="<%=repo_EWeek%>">

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><span>Inquire / Create Container Repo. Plan List</span></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" type="button" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
		--><button class="btn_normal" type="button" name="btn_new" id="btn_new">New</button><!--
		--><button class="btn_normal" type="button" name="btn_downexcel" id="btn_downexcel">Down Excel</button><!--
		--><button class="btn_normal" type="button" name="btn_print" id="btn_print">Print</button><!--
		--><button class="btn_normal" type="button" name="btn_ok" id="btn_ok">Ok</button><!-- 
		--><button class="btn_normal" type="button" name="btn_close" id="btn_close">Close</button>
		</div>
	<!-- opus_design_btn (E) -->
 
	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="100" />
				<col width="170" />		
				<col width="80" />		
				<col width="115" />
				<col width="110" />		
				<col width="110" />		
				<col width="110" />		
				<col width="120" />			
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
		   			<th><lable  for="tp1">Week</lable></th>
					<td><input name="repo_syear" type="text" class=" input1" style="width:35px;ime-mode:disabled;text-align:center;" maxlength="4" value="<%=yyyy%>" onkeyup="return onlyNumberInput(event)" onChange="return checkWeekInqireList(repo_syear,repo_sweek,repo_eyear,repo_eweek)"><!-- 
						 --><input name="repo_sweek" type="text" class=" input1" style="width:25px;ime-mode:disabled;text-align:center;" maxlength="2" onkeyup="onlyNumberInput(event)" onChange="return checkWeekInqireList(repo_syear,repo_sweek,repo_eyear,repo_eweek)" value="<%=repo_SWeek%>">&nbsp;~&nbsp;<!-- 
                         --><input name="repo_eyear" type="text" class=" input1" style="width:35px;ime-mode:disabled;text-align:center;" maxlength="4" value="<%=yyyy%>" onkeyup="return onlyNumberInput(event)" onChange="return checkWeekInqireList(repo_syear,repo_sweek,repo_eyear,repo_eweek)"><!-- 
						 --><input name="repo_eweek" type="text" class=" input1" style="width:25px;ime-mode:disabled;text-align:center;" maxlength="2" onkeyup="return onlyNumberInput(event)" onChange="return checkWeekInqireList(repo_syear,repo_sweek,repo_eyear,repo_eweek)" value="<%=repo_EWeek%>">&nbsp;&nbsp;<!-- 
						 --><%//=status%><input name="status" type="hidden">
					</td>
					<td></td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;RCC</td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;LCC</td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;ECC</td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;LOC</td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Yard</td>
					<td></td>
		   		</tr>
	   		</tbody>
	   	</table>
		<table>
			<colgroup>
				<col width="100" />
				<col width="170" />		
				<col width="80" />		
				<col width="110" />
				<col width="110" />		
				<col width="110" />		
				<col width="110" />		
				<col width="120" />			
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
					<th><lable for="tp2">Repo. Plan ID</lable></th>
					<td><input type="text" style="width:80px;ime-mode:disabled;text-align:center;" name="repo_pln" maxlength="10" dataformat="engup">&nbsp;<!-- 
						 --><input type="text" style="width:22px" value="W" class="noinput2" readonly><!-- 
						 --><input type="text" style="width:35px;ime-mode:disabled;text-align:center;" name="repo_pln_seq" maxlength="4" onkeyup="onlyNumberInput(event)">
					</td>
					<td style="text-align:right">From</td>
					<td><input type="text" style="width:70px;ime-mode:disabled;" name="fm_rcc_cd" dataformat="engup" otherchar=",">
					<button type="button" id="fm_rcc_btn" name="fm_rcc_btn" class="input_seach_btn"></button>
					</td>
					<td><input type="text" style="width:70px;ime-mode:disabled;" name="fm_lcc_cd" dataformat="engup" otherchar=",">
					<button type="button" id="fm_lcc_btn" name="fm_lcc_btn" class="input_seach_btn"></button>
					</td>
					<td><input type="text" style="width:70px;ime-mode:disabled;" name="fm_ecc_cd" dataformat="engup" otherchar=",">
					<button type="button" id="fm_ecc_btn" name="fm_ecc_btn" class="input_seach_btn"></button>
					</td>
					<td><input type="text" style="width:70px;ime-mode:disabled;" name="fm_loc_cd" dataformat="engup" otherchar=",">
					<button type="button" id="fm_loc_btn" name="fm_loc_btn" class="input_seach_btn"></button>
					</td>
					<td><input type="text" style="width:80px;ime-mode:disabled;text-align:center;" name="fm_yard_cd" dataformat="engup" maxlength="7">
					<button type="button" id="fm_yard_btn" name="fm_yard_btn" class="input_seach_btn"></button>
					</td>
					<td></td>
				</tr>
				
				<tr>
					<th><lable for="tp2">Service Lane</lable></th>
					<td><input type="text" style="width:120px;ime-mode:disabled;" name="s_lane_cd" dataformat="engup" otherchar=","><!-- 
						 --><button type="button" id="s_lane_btn" name="s_lane_btn" class="input_seach_btn"></button>
					</td>
					<td style="text-align:right">To</td>
					<td><input type="text" style="width:70px;ime-mode:disabled;" name="to_rcc_cd" dataformat="engup" otherchar=",">
					<button type="button" id="to_rcc_btn" name="to_rcc_btn" class="input_seach_btn"></button>
					</td>
					<td><input type="text" style="width:70px;ime-mode:disabled;" name="to_lcc_cd" dataformat="engup" otherchar=",">
					<button type="button" id="to_lcc_btn" name="to_lcc_btn" class="input_seach_btn"></button>
					</td>
					<td><input type="text" style="width:70px;ime-mode:disabled;" name="to_ecc_cd" dataformat="engup" otherchar=",">
					<button type="button" id="to_ecc_btn" name="to_ecc_btn" class="input_seach_btn"></button>
					</td>
					<td><input type="text" style="width:70px;ime-mode:disabled;" name="to_loc_cd" dataformat="engup" otherchar=",">
					<button type="button" id="to_loc_btn" name="to_loc_btn" class="input_seach_btn"></button>
					</td>
					<td><input type="text" style="width:80px;ime-mode:disabled;text-align:center;" name="to_yard_cd" dataformat="engup" maxlength="7">
					<button type="button" id="to_yard_btn" name="to_yard_btn" class="input_seach_btn"></button>
					</td>
					<td></td>
				</tr>
		   </tbody>
		</table>
		<table>
			<colgroup>
				<col width="100" />
				<col width="170" />
				<col width="80" />
				<col width="80" />
				<col width="110" />
				<col width="40" />
				<col width="90" />
				<col width="30" />
				<col width="90" />
				<col width="45" />
				<col width="*" />	 
		   </colgroup> 
		   <tbody>
		   		<tr>
					<th><lable for="tp2">VVD</lable></th>
					<td><input type="text" style="width:120px;ime-mode:disabled;text-align:center;" name="vvd_cd" maxlength="9" dataformat="engup"><!-- 
						 --><button type="button" id="vvd_btn" name="vvd_btn" class="input_seach_btn"></button>
					</td>
					<td></td>
					<td style="text-align:right">Empty BKG #</td>
					<td><input type="text" style="width:102px;ime-mode:disabled;" name="emt_bkg_no" maxlength="13" dataformat="engup"></td>
					<td style="text-align:right">Ref ID</td>
					<td><input type="text" style="width:97px;ime-mode:disabled;" name="ref_id" maxlength="15" dataformat="engup"></td>
					<td style="text-align:right">SO #</td>
					<td><input type="text" style="width:90px;ime-mode:disabled;" name="so_no" maxlength="18" dataformat="engup"></td>
					<td style="text-align:right">User ID </td>
					<td><input type="text" style="width:52px;ime-mode:disabled;" name="usr_id"></td>
				</tr>
		   	</tbody>
		   </table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>


<div class="wrap_result">
<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="100" />
				<col width="300" />		
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
		   			<td><lable  for="tp1">Show in list</lable></td>
					<td><input type="checkbox" name="cbx_ep_tp_cd" class="trans" value="Y" onClick='setListSelCond();'> EP & Data Type &nbsp;&nbsp;&nbsp;<!-- 
                     --><input type="checkbox" name="cbx_rcc_cd" class="trans" value="Y" onClick='setListSelCond();'> RCC &nbsp;&nbsp;&nbsp;<!-- 
					 --><input type="checkbox" name="cbx_lcc_cd" class="trans" value="Y" onClick='setListSelCond();'> LCC &nbsp;&nbsp;&nbsp;<!--
					 --><input type="checkbox" name="cbx_ecc_cd" class="trans" value="Y" onClick='setListSelCond();'> ECC &nbsp;&nbsp;&nbsp;<!--
					 --><input type="checkbox" name="cbx_loc_cd" class="trans" value="Y" onClick='setListSelCond();'> LOC &nbsp;&nbsp;&nbsp;<!--
					 --><input type="checkbox" name="cbx_yard_cd"class="trans" value="Y" onClick='setListSelCond();'> Yard &nbsp;&nbsp;&nbsp;<!--
					 --><input type="checkbox" name="cbx_vvd_cd" class="trans" value="Y" onClick='setListSelCond();'> VVD &nbsp;&nbsp;&nbsp;<!--
					 --><input type="checkbox" name="cbx_emt_bkg_no" class="trans" value="Y" onClick='setListSelCond();'> Empty BKG # &nbsp;&nbsp;&nbsp;<!--
					 --><input type="checkbox" name="cbx_ref_id" class="trans" value="Y" onClick='setListSelCond();'> Ref ID &nbsp;&nbsp;&nbsp;<!--
					 --><input type="checkbox" name="cbx_so_no"  class="trans" value="Y" onClick='setListSelCond();'> SO # &nbsp;&nbsp;&nbsp;
					</td>
					
					<td></td>
		   		</tr>
	   		</tbody>
	   	</table>
	   	
</div>
<div class="opus_design_grid">
		
		<script type="text/javascript">ComSheetObject('sheet');</script>		
	</div>
</div>


</form>
