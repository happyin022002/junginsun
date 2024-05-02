<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_0107.jsp
*@FileTitle  : Allocation Result(Internal Pricing)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/26
* SJH.20150106.MOD : coaPeriod1, VVD
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.coa.weeklypfmc.networkdistribution.event.EsmCoa0107Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmCoa0107Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Error from server
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//Count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.WeeklyPFMC.NetworkCost");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmCoa0107Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

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
		} // end if
		loadPage();
	}
</script>
<form method="post" name="form" onKeyDown="ComKeyEnter();"/>
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<!-- Developer DIV	-->

<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" 	id="btn_Retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_Create" 		id="btn_Create">Creation</button><!--
		--><button type="button" class="btn_normal" name="btn_Applytopl"  		id="btn_Applytopl">Apply to P/L</button><!--
		--><button type="button" class="btn_normal" name="btn_Downexcel"  		id="btn_Downexcel">Down Excel</button>		
	</div>
	<!-- opus_design_btn(E) -->
	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

<!-- opus_design_inquiry(S) -->
<div class= "wrap_search">
	<div class= "opus_design_inquiry">
		<table>
			<colgroup>
				<col width="50" />
				<col width="100" />
				<col width="135" />
				<col width="100" />
				<col width="100" />
				<col width="*" />
			</colgroup>
			<tbody>
				<tr>
                	<td colspan="6"><script type="text/javascript">coaPeriod1("1","");</script></td>
             	</tr>
			</tbody>
			<tbody>				
             	<tr><td class="line_bluedot" colspan="6"></td></tr>
             	<tr>
	                <th>Trade</th>
	                <td><script type="text/javascript">ComComboObject('f_seltrade',1, 100 , 0 )</script></td>
	                <th>Lane</th>
	                <td><div id="div_rLane"><script type="text/javascript">ComComboObject('f_selrlane',1, 100 , 0 )</script></div></td>
	                <th title="Vessel Voyage Direction">VVD</th>
	                <td><input type="text" name="f_vsl_cd" id="f_vsl_cd" style="width:70px;text-align:center;" maxlength="4" dataformat="engup" onClick="ComAddSeparator(this);"  onKeyUp="ComKeyEnter('f_skd_voy_no');" onKeyPress="ComKeyOnlyAlphabet('uppernum');" onFocus="this.select();" onBlur="upper(this);">
                        <input type="text" name="f_skd_voy_no" id="f_skd_voy_no" style="width:70px;text-align:center;" maxlength="4" dataformat="num" onClick="ComAddSeparator(this);" onKeyUp="ComKeyEnter('f_dir_cd');" onkeyPress="ComKeyOnlyNumber(window);" onFocus="this.select();" >
                        <input type="text" name="f_dir_cd" id="f_dir_cd" style="width:30px;text-align:center;" maxlength="1" dataformat="engup" onClick="ComAddSeparator(this);" onKeyUp="ComKeyEnter('f_year');" onKeyPress="ComKeyOnlyAlphabet('upper');" onFocus="this.select();" onBlur="upper(this);"></td>
                    </td>
              </tr>
             	
			</tbody>
		</table>
	</div>
</div>
<!-- opus_design_inquiry(E) -->
<!-- opus_design_grid(S) -->
<div class="wrap_result">
	<div class="opus_design_grid clear" >
			<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
<!-- opus_design_grid(E) -->
</form>