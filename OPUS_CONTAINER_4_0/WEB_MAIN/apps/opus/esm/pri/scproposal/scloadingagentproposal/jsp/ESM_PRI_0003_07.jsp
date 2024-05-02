<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0003_07.jsp
*@FileTitle  : S/C Proposal Loading Agent Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/29
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.scproposal.scloadingagentproposal.event.EsmPri000307Event"%>
<%@ page import="com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="java.util.List"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
		EsmPri000307Event  event = null;					//PDTO(Data Transfer Object including Parameters)
		Exception serverException   = null;			//Error from Server
		String strErrMsg = "";						//Error Message
		int rowCount	 = 0;						//Number of DB ResultSet List

		String successFlag = "";
		String codeList  = "";
		String pageRows  = "100";

		String strUsr_id		= "";
		String strUsr_nm		= "";

		String[] srcInfoCd = null;		//Source
		String[] prcProgStsCd = null;	//Status
		
		Logger log = Logger.getLogger("com.clt.apps.SCProposal.SCLoadingAgentProposal");

		try {
		   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
				strUsr_id =	account.getUsr_id();
				strUsr_nm = account.getUsr_nm();


				event = (EsmPri000307Event)request.getAttribute("Event");
				serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

				if (serverException != null) {
						strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
				}

				// Adding Logic extracting data from server when loading initial window ..
				GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

				//COMMBO LIST
				srcInfoCd 		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("SRC_INFO_CD"), false);
				prcProgStsCd 	= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("PRC_PROG_STS_CD"), false);
		}catch(Exception e) {
				out.println(e.toString());
		}
%>

<head>
<title></title>


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
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />

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
<input type="hidden" name="cust_cnt_cd" id="cust_cnt_cd" />
<input type="hidden" name="cust_seq" id="cust_seq" />
<input type="hidden" name="lgcy_if_flg" id="lgcy_if_flg" />

<!-- opus_design_btn(S) -->
<div class="opus_design_btn">
	<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
 	--><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!-- 
 	--><button type="button" class="btn_normal" name="btn_acceptall" id="btn_acceptall">Accept All</button><!-- 	
	--><button type="button" class="btn_normal" name="btn_cancelall" id="btn_cancelall">Accept Cancel</button>
</div>
<!-- opus_design_btn(E) -->

<!-- opus_design_grid(S) -->
<div class="opus_design_grid" id="mainTable">
	<!-- opus_design_btn(S) -->
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
</div>
<!-- opus_design_grid(E) -->

</form>
