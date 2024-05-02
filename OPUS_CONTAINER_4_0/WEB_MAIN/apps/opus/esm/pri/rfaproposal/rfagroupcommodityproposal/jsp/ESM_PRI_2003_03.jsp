<%
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_2003_03.jsp
*@FileTitle  : Proposal & Amendment Creation - Commodity Group 
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
<%@ page import="com.clt.apps.opus.esm.pri.rfaproposal.rfagroupcommodityproposal.event.EsmPri200303Event"%>
<%@ page import="com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="java.util.List"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmPri200303Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //error from server
	String strErrMsg = ""; //error message
	int rowCount = 0; //count of DB resultSET list
	String successFlag = "";
	String codeList = "";
	String pageRows = "100";
	String strUsr_id = "";
	String strUsr_nm = "";
	String[] srcInfoCd = null;		//Source
	String[] prcProgStsCd = null;	//Status
	Logger log = Logger.getLogger("com.clt.apps.RFAProposal.RFAGroupCommodityProposal");
	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (EsmPri200303Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		//COMMBO LIST
		srcInfoCd 		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("SRC_INFO_CD"), false);
		prcProgStsCd 	= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("PRC_PROG_STS_CD"), false);
	} catch (Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	var srcInfoCdComboValue = "<%=srcInfoCd[0]%>";
    var srcInfoCdComboText = "<%=srcInfoCd[1]%>";
    var prcProgStsCdComboValue = "<%=prcProgStsCd[0]%>";
    var prcProgStsCdComboText = "<%=prcProgStsCd[1]%>";
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form"><input type="hidden" name="f_cmd"> 
<input id="pagerows" name="pagerows" type="hidden" />
<input id="prop_no" name="prop_no" type="hidden" />
<input id="amdt_seq" name="amdt_seq" type="hidden" />
<input id="svc_scp_cd" name="svc_scp_cd" type="hidden" />
<input id="pre_amdt_seq" name="pre_amdt_seq" type="hidden" />
<input id="prop_sts_cd" name="prop_sts_cd" type="hidden" />
<input id="eff_dt" name="eff_dt" type="hidden" />
<input id="exp_dt" name="exp_dt" type="hidden" />
<input id="pre_exp_dt" name="pre_exp_dt" type="hidden" />
<input id="grp_cmdt_seq" name="grp_cmdt_seq" type="hidden" />
<input id="req_usr_flg" name="req_usr_flg" type="hidden" />
<input id="apro_usr_flg" name="apro_usr_flg" type="hidden" />
<input id="dur_dup_flg" name="dur_dup_flg" type="hidden" />

	<!-- page_title_area(S) -->
	<div class="opus_design_inquiry">
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_acceptall" id="btn_acceptall">Accept All</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_cancelall" id="btn_cancelall">Accept Cancel</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_glinecopy" id="btn_glinecopy">G/L Copy</button><!-- 
		 --></div>
		<!-- opus_design_btn(E) -->
	<!-- page_title_area(E) -->
	</div>
	
	<!-- layout_wrap (S) -->
	<div class="layout_wrap">
	    <div class="layout_vertical_2" style="width: 40%">
	        <!-- opus_design_grid(S) -->
	        <div class="opus_design_grid">
	            <div class="opus_design_btn">
					<button type="button" class="btn_accent" name="btn_rowadd1" id="btn_rowadd1">Row Add</button><!-- 
					 --><button type="button" class="btn_normal" name="btn_delete1" id="btn_delete1">Delete</button><!-- 
				 --></div>
				<script type="text/javascript">ComSheetObject('sheet1');</script>
	        </div>
	        <!-- opus_design_grid(E) -->
	    </div>
	    
	    <div class="layout_vertical_2" style="width: 5%; text-align: center; margin-top: 170px;">
	    	<button type="button" class="btn_right" ></button>
			<!-- <img src="img/btn_add.gif" width="26px" height="26px" alt="" border="0" align="absmiddle"> -->
	    </div>
	    
	     <div class="layout_vertical_2" style="width: 55%">
	        <!-- opus_design_grid(S) -->
	        <div class="opus_design_grid">
	        	<div class="opus_design_btn">
					<button type="button" class="btn_normal" name="btn_rowadd2" id="btn_rowadd2">Row Add</button><!-- 
					 --><button type="button" class="btn_normal" name="btn_delete2" id="btn_delete2">Delete</button><!-- 
					 --><button type="button" class="btn_normal" name="btn_amend" id="btn_amend">Amend</button><!-- 
					 --><button type="button" class="btn_normal" name="btn_amendcancel" id="btn_amendcancel">Amend Cancel</button><!-- 
					 --><button type="button" class="btn_normal" name="btn_accept" id="btn_accept">Accept</button><!-- 
					 --><button type="button" class="btn_normal" name="btn_acceptcancel" id="btn_acceptcancel">Accept Cancel</button><!-- 
				 --></div>
	            <script type="text/javascript">ComSheetObject('sheet2');</script>
	        </div>
	        <!-- opus_design_grid(E) -->
	    </div>
	</div>
	
<!-- layout_wrap (E) -->
</form>