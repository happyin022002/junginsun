<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0003_01.jsp
*@FileTitle  : S/C Proposal Org/Dst Location Information - Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/28
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.scproposal.scroutepointproposal.event.EsmPri000301Event"%>
<%@ page import="com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="java.util.List"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	EsmPri000301Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	String[] srcInfoCd = null;		//Source
	String[] prcProgStsCd = null;	//Status
	
	Logger log = Logger.getLogger("com.clt.apps.SCProposal.SCRoutePointProposal");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmPri000301Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// adding logic to get data from server when first loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		//COMMBO LIST
		srcInfoCd 		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("SRC_INFO_CD"), false);
		prcProgStsCd 	= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("PRC_PROG_STS_CD"), false);
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script language="javascript">
	var srcInfoCdComboValue = "<%=srcInfoCd[0]%>";
    var srcInfoCdComboText = "<%=srcInfoCd[1]%>";
    
    var prcProgStsCdComboValue = "<%=prcProgStsCd[0]%>";
    var prcProgStsCdComboText = "<%=prcProgStsCd[1]%>";

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
	<!-- developer performance	-->
<input type="hidden" name="prop_no" id="prop_no" />
<input type="hidden" name="amdt_seq" id="amdt_seq" />
<input type="hidden" name="svc_scp_cd" id="svc_scp_cd" />
<input type="hidden" name="pre_amdt_seq" id="pre_amdt_seq" />
<input type="hidden" name="prop_sts_cd" id="prop_sts_cd" />
<input type="hidden" name="eff_dt" id="eff_dt" />
<input type="hidden" name="exp_dt" id="exp_dt" />
<input type="hidden" name="pre_exp_dt" id="pre_exp_dt" />
<input type="hidden" name="req_usr_flg" id="req_usr_flg" />
<input type="hidden" name="apro_usr_flg" id="apro_usr_flg" />
<input type="hidden" name="dur_dup_flg" id="dur_dup_flg" />
<input type="hidden" name="cd" id="cd" />
<input type="hidden" name="lgcy_if_flg" id="lgcy_if_flg" />

<div class="opus_design_btn">
<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
 --> <button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!--
 --><button type="button" class="btn_normal" name="btn_acceptall" id="btn_acceptall">Accept All</button><!-- 
  --><button type="button" class="btn_normal" name="btn_cancelall" id="btn_cancelall">Accept Cancel</button>
</div>

<!-- opus_design_grid(S) -->
<div class="opus_design_grid" id="mainTable">

	<div class="grid_option_left">
		<table>
			<tbody>
				<tr>
					<th class="sm" width="60">Route</th>
					<td class="sm">
						<input type="radio" name="org_dest_tp_cd"  value="O"  checked><span id="org_dest_tp_cd1">  Origin</span> 
					 	<input type="radio" name="org_dest_tp_cd" value="D" ><span id="org_dest_tp_cd2">  Destination</span>
					</td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry (E) -->

<!-- opus_design_grid(S) -->
<div class="opus_design_grid">
	<div class="opus_design_btn">
	<!-- Content -->
		<button type="button" class="btn_normal" name="btn_rowadd" id="btn_rowadd">Row Add</button><!--
		--><button type="button" class="btn_normal" name="btn_delete" id="btn_delete">Delete</button><!--
		--><button type="button" class="btn_normal" name="btn_amend" id="btn_amend">Amend</button><!--
		--><button type="button" class="btn_normal" name="btn_amendcancel" id="btn_amendcancel">Amend Cancel</button><!--
		--><button type="button" class="btn_normal" name="btn_accept" id="btn_accept">Accept</button><!--
		--><button type="button" class="btn_normal" name="btn_acceptcancel" id="btn_acceptcancel">Accept Cancel</button>
	</div>
	<!-- opus_design_btn(e) -->	
		
	<script type="text/javascript">ComSheetObject('sheet1');</script>
	<script type="text/javascript">ComSheetObject('sheet2');</script>
</div>
<!-- opus_design_grid(E) -->
</div>    			
</form>