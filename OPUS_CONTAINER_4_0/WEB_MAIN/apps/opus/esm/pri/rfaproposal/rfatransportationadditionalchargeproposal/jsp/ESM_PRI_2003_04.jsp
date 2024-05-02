<%
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_2003_04.jsp
*@FileTitle  : RFA Proposal Origin/Destination Arbitrary Charge Creation 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/28
=========================================================
*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.event.EsmPri200304Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.clt.framework.component.util.code.CodeInfo"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="com.clt.framework.component.common.AbstractValueObject"%>
<%@ page import="java.util.List"%>

<%
	EsmPri200304Event  event = null;			//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String strUsr_id			= "";
	String strUsr_nm			= "";
	String[] prcTrspModCd		= null;
	String[] ratUtCd			= null;
	String[] currCd				= null;
	String[] prcCgoTpCd			= null;
	String[] srcInfoCd			= null;
	String[] prcProgStsCd		= null;
	String[] orgRcvDeTermCd		= null;
	String[] destRcvDeTermCd	= null;
	Logger log = Logger.getLogger("com.clt.apps.RFAProposal.RFATransportationAdditionalChargeProposal");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (EsmPri200304Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		// adding logic to get data from server when first loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		prcTrspModCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("prcTrspModCd"), false,"|","\t","getCode","getName");
		ratUtCd = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("ratUtCd"),false,"|","\t");
		currCd = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("currCd"),false,"|","\t");
		prcCgoTpCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("prcCgoTpCd"), true,"|","\t","getCode","getName");
		srcInfoCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("srcInfoCd"), false,"|","\t","getCode","getName");
		prcProgStsCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("prcProgStsCd"), false,"|","\t","getCode","getName");
		orgRcvDeTermCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("orgRcvDetermCd"), false,"|","\t","getCode","getName");
		destRcvDeTermCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("destRcvDetermCd"), false,"|","\t","getCode","getName");
	} catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	var prcTrspModCdValue = " |<%=prcTrspModCd[0]%>";
	var prcTrspModCdText = " |<%=prcTrspModCd[1]%>";
	var ratUtCdValue = " |<%=ratUtCd[0]%>";
	var ratUtCdText = " |<%=ratUtCd[1]%>";
	var currCdValue = "|<%=currCd[0]%>";
	var currCdText = "|<%=currCd[1]%>";
	var prcCgoTpCdValue = " |<%=prcCgoTpCd[0]%>";
	var prcCgoTpCdText = " |<%=prcCgoTpCd[1]%>";
	var srcInfoCdValue = "|<%=srcInfoCd[0]%>";
	var srcInfoCdText = "|<%=srcInfoCd[1]%>";
	var PrcProgStsCdValue = "|<%=prcProgStsCd[0]%>";
	var PrcProgStsCdText = "|<%=prcProgStsCd[1]%>";
	var orgRcvDeTermCdValue = " |<%=orgRcvDeTermCd[0]%>";
	var orgRcvDeTermCdText = " |<%=orgRcvDeTermCd[1]%>";
	var destRcvDeTermCdValue = " |<%=destRcvDeTermCd[0]%>";
	var destRcvDeTermCdext = " |<%=destRcvDeTermCd[1]%>";
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form" id="form">
<input id="f_cmd" name="f_cmd" type="hidden" />
<input id="pagerows" name="pagerows" type="hidden" />
<input id="cd" name="cd" type="hidden" />
<input id="prop_no" name="prop_no" value="" type="hidden" />
<input id="amdt_seq" name="amdt_seq" value="" type="hidden" />
<input id="svc_scp_cd" name="svc_scp_cd" value="" type="hidden" />
<input id="pre_amdt_seq" name="pre_amdt_seq" value="" type="hidden" />
<input id="prop_sts_cd" name="prop_sts_cd" value="" type="hidden" />
<input id="eff_dt" name="eff_dt" value="" type="hidden" />
<input id="exp_dt" name="exp_dt" value="" type="hidden" />
<input id="pre_exp_dt" name="pre_exp_dt" value="" type="hidden" />
<input id="dur_dup_flg" name="dur_dup_flg" value="" type="hidden" />
<input id="grp_loc_seq" name="grp_loc_seq" type="hidden" />
<input id="req_usr_flg" name="req_usr_flg" type="hidden" />
<input id="apro_usr_flg" name="apro_usr_flg" type="hidden" />

<div class="opus_design_inquiry">
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_acceptall" id="btn_acceptall">Accept All</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_cancelall" id="btn_cancelall">Accept Cancel</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_glinecopy" id="btn_glinecopy">G/L Copy</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_loadexcel" id="btn_loadexcel">Load Excel</button><!-- 
	 -->
	</div>
</div>

<div class="opus_design_grid" id="mainTable">
	<div class="grid_option_left">
		<table>
			<tbody>
				<tr>
					<th class="sm" width="60">Type</th>
					<td class="sm">
						<input type="radio" name="org_dest_tp_cd" id="org_dest_tp_cd" value="O" class="trans" checked><span id="org_dest_tp_cd1">Origin Arbitrary</span>
						<input type="radio" name="org_dest_tp_cd" id="org_dest_tp_cd" value="D" class="trans"><span id="org_dest_tp_cd2">Destination Arbitrary</span>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	
	<div class="opus_design_grid">
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_rowadd" id="btn_rowadd">Row Add</button><!-- 
				 --><button type="button" class="btn_normal" name="btn_rowcopy" id="btn_rowcopy">Row Copy</button><!-- 
				 --><button type="button" class="btn_normal" name="btn_delete" id="btn_delete">Delete</button><!-- 
				 --><button type="button" class="btn_normal" name="btn_amend" id="btn_amend">Amend</button><!-- 
				 --><button type="button" class="btn_normal" name="btn_amendcancel" id="btn_amendcancel">Amend Cancel</button><!--  
				 --><button type="button" class="btn_normal" name="btn_accept" id="btn_accept">Accept</button><!-- 
				 --><button type="button" class="btn_normal" name="btn_acceptcancel" id="btn_acceptcancel">Accept Cancel</button>
		</div>
		
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>

<div id="hiddenSheetLayer" style="display: none">
	    <script type="text/javascript">ComSheetObject('sheet2');</script>
</div>

</form>