<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0003_04.jsp
*@FileTitle  : S/C Proposal Origin/Destination Arbitrary Charge Creation
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
<%@ page import="com.clt.apps.opus.esm.pri.scproposal.sctransportationadditionalchargeproposal.event.EsmPri000304Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.clt.framework.component.util.code.CodeInfo"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="com.clt.framework.component.common.AbstractValueObject"%>
<%@ page import="java.util.List"%>

<%
		EsmPri000304Event  event = null;			//PDTO(Data Transfer Object including Parameters)
		Exception serverException   = null;         //error from server
		String strErrMsg = ""; //error message
		int rowCount = 0; //count of DB resultSET list
		
		String successFlag = "";
		String codeList  = "";
		String pageRows  = "100";

		String strUsr_id		= "";
		String strUsr_nm		= "";
		String[] prcTrspModCd	= null;
		String[] ratUtCd		= null;
		String[] currCd			= null;
		String[] prcCgoTpCd		= null;
		String[] griApplTpCd	= null;
		String[] srcInfoCd		= null;
		String[] prcProgStsCd	= null;
		String[] orgRcvDeTermCd		= null;
		String[] destRcvDeTermCd		= null;
		       
		Logger log = Logger.getLogger("com.clt.apps.SCProposal.SCTransportationAdditionalChargeProposal");
		
		try {
		   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
				strUsr_id =	account.getUsr_id();
				strUsr_nm = account.getUsr_nm();
		   
		   
				event = (EsmPri000304Event)request.getAttribute("Event");
				serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

				if (serverException != null) {
						strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
				}
				
				 
				GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
				
				prcTrspModCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("prcTrspModCd"), false,"|","\t","getCode","getName");
				ratUtCd = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("ratUtCd"),false,"|","\t");
				currCd = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("currCd"),false,"|","\t");
				prcCgoTpCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("prcCgoTpCd"), true,"|","\t","getCode","getName");
				griApplTpCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("griApplTpCd"), false,"|","\t","getCode","getName");
				srcInfoCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("srcInfoCd"), false,"|","\t","getCode","getName");
				prcProgStsCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("prcProgStsCd"), false,"|","\t","getCode","getName");
				orgRcvDeTermCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("orgRcvDetermCd"), false,"|","\t","getCode","getName");
				destRcvDeTermCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("destRcvDetermCd"), false,"|","\t","getCode","getName");
		}catch(Exception e) {
				out.println(e.toString());
		}
%>

<head>
<title>S/C Proposal Origin/Destination Arbitrary Charge Creation</title>

<script type="text/javascript">
		var prcTrspModCdValue = " |<%=prcTrspModCd[0]%>";
		var prcTrspModCdText = " |<%=prcTrspModCd[1]%>";
		var ratUtCdValue = " |<%=ratUtCd[0]%>";
		var ratUtCdText = " |<%=ratUtCd[1]%>";
		var currCdValue = "|<%=currCd[0]%>";
		var currCdText = "|<%=currCd[1]%>";
		var prcCgoTpCdValue = " |<%=prcCgoTpCd[0]%>";
		var prcCgoTpCdText = " |<%=prcCgoTpCd[1]%>";
		var griApplTpCdValue = "|<%=griApplTpCd[0]%>";
		var griApplTpCdText = "|<%=griApplTpCd[1]%>";
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
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />

 
<input type="hidden" name="cd" id="cd" />
<input type="hidden" name="prop_no" value="" id="prop_no" />
<input type="hidden" name="amdt_seq" value="" id="amdt_seq" />
<input type="hidden" name="svc_scp_cd" value="" id="svc_scp_cd" />
<input type="hidden" name="pre_amdt_seq" value="" id="pre_amdt_seq" />
<input type="hidden" name="prop_sts_cd" value="" id="prop_sts_cd" />
<!-- <input type="hidden" name="add_chg_tp_cd" value="A" id="add_chg_tp_cd" /> -->
<input type="hidden" name="eff_dt" value="" id="eff_dt" />
<input type="hidden" name="exp_dt" value="" id="exp_dt" />
<input type="hidden" name="pre_exp_dt" value="" id="pre_exp_dt" />
<input type="hidden" name="dur_dup_flg" value="" id="dur_dup_flg" />
<input type="hidden" name="lgcy_if_flg" value="" id="lgcy_if_flg" />
<input type="hidden" name="gri_btn" id="gri_btn" />
<input type="hidden" name="grp_loc_seq" id="grp_loc_seq" />
<input type="hidden" name="req_usr_flg" id="req_usr_flg" />
<input type="hidden" name="apro_usr_flg" id="apro_usr_flg" />



<!-- opus_design_btn(S) -->
<div class="opus_design_btn">
	<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
	 --><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!-- 
	 --><button type="button" class="btn_normal" name="btn_acceptall" id="btn_acceptall">Accept All</button><!-- 
	 --><button type="button" class="btn_normal" name="btn_cancelall" id="btn_cancelall">Accept Cancel</button><!-- 
	 --><button type="button" class="btn_normal" name="btn_glinecopy" id="btn_glinecopy">G/L Copy</button><!-- 
	 --><button type="button" class="btn_normal" name="btn_gricalc" id="btn_gricalc">GRI Calculation</button><!-- 
	 --><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button><!--
	 --><button type="button" class="btn_normal" name="btn_loadexcel" id="btn_loadexcel">Load Excel</button> 
</div>
<!-- opus_design_btn(E) -->


<!-- opus_design_grid(S) -->
<div class="opus_design_grid" id="mainTable">

	<div class="grid_option_left">
		<table>
			<tbody>
				<tr>
					<th class="sm" width="60">Type</th>
					<td class="sm" id="rdoTpCd">
						<input type="radio" name="org_dest_tp_cd" value="O" checked><span id="org_dest_tp_cd1">  Origin Arbitrary</span>
						<input type="radio" name="org_dest_tp_cd" value="D" class="trans"><span id="org_dest_tp_cd2">  Destination Arbitrary</span>
					</td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</div>
	
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
	<!-- Content -->
		<button type="button" class="btn_normal" name="btn_rowadd" id="btn_rowadd">Row Add</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_rowcopy" id="btn_rowcopy">Row Copy</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_delete" id="btn_delete">Delete</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_amend" id="btn_amend">Amend</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_amendcancel" id="btn_amendcancel">Amend Cancel</button><!-- 
	     --><button type="button" class="btn_normal" name="btn_accept" id="btn_accept">Accept</button><!-- 
	     --><button type="button" class="btn_normal" name="btn_acceptcancel" id="btn_acceptcancel">Accept Cancel</button>
	</div>
	<!-- opus_design_btn(e) -->
	
	<script type="text/javascript">ComSheetObject('sheet1');</script>
</div>
<!-- opus_design_grid(E) -->


<!-- opus_design_grid(S) -->
<div class="opus_design_grid" id="subTable" style="display:none">
	<script type="text/javascript">ComSheetObject('sheet2');</script>
</div>
<!-- opus_design_grid(E) -->


</form>