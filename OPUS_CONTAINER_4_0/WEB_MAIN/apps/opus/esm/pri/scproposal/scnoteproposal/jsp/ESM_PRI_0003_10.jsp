<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0003_10.jsp
*@FileTitle  : S/C Proposal Special Note Creation
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
<%@ page import="com.clt.apps.opus.esm.pri.scproposal.scnoteproposal.event.EsmPri000310Event"%>
<%@ page import="com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="java.util.List"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
		EsmPri000310Event  event = null;					//PDTO(Data Transfer Object including Parameters)
		Exception serverException   = null;         //error from server
		String strErrMsg = ""; //error message
		int rowCount = 0; //count of DB resultSET list

		String successFlag = "";
		String codeList  = "";
		String pageRows  = "100";

		String strUsr_id		= "";
		String strUsr_nm		= "";
		
		String[] noteClssCd = null;		//NOTE CLASSIFICATION CODE
		String[] srcInfoCd = null;		//Source
		String[] prcProgStsCd = null;	//Status
		//String[] chargeCd = null;   	//SCOPE CHARGE CODE LIST
								
		Logger log = Logger.getLogger("com.clt.apps.SCProposal.SCNoteProposal");

		try {
		   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
				strUsr_id =	account.getUsr_id();
				strUsr_nm = account.getUsr_nm();


				event = (EsmPri000310Event)request.getAttribute("Event");
				serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

				if (serverException != null) {
						strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
				}

				 
				GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
				//COMMBO LIST
				noteClssCd 		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("NOTE_CLSS_CD"), false);
				srcInfoCd 		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("SRC_INFO_CD"), false);
				prcProgStsCd 	= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("PRC_PROG_STS_CD"), false);
	       	//chargeCd 		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("CHARGE_CD"), false);
        
        
		}catch(Exception e) {
				out.println(e.toString());
		}
%>

<head>
<title>S/C Proposal Special Note Creation</title>


<script type="text/javascript">
		var srcInfoCdComboValue = "<%=srcInfoCd[0]%>";
    var srcInfoCdComboText = "<%=srcInfoCd[1]%>";
    
    var prcProgStsCdComboValue = "<%=prcProgStsCd[0]%>";
    var prcProgStsCdComboText = "<%=prcProgStsCd[1]%>";

		var noteClssCdComboValue = " |<%=noteClssCd[0]%>";
    var noteClssCdComboText = " |<%=noteClssCd[1]%>";

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
<input type="hidden" name="cd" id="cd" />
<input type="hidden" name="req_usr_flg" id="req_usr_flg" />
<input type="hidden" name="apro_usr_flg" id="apro_usr_flg" />
<input type="hidden" name="dur_dup_flg" id="dur_dup_flg" />
<input type="hidden" name="note_seq" id="note_seq" />
<input type="hidden" name="note_tp_cd" value="P" id="note_tp_cd" />
<input type="hidden" name="lgcy_if_flg" id="lgcy_if_flg" />

<input type="hidden" name="master_del_chk" value="N" id="master_del_chk" />

<!-- opus_design_btn(S) -->
<div class="opus_design_btn">
	<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
 	--><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!-- 
 	--><button type="button" class="btn_normal" name="btn_acceptall" id="btn_acceptall">Accept All</button>	
	   <button type="button" class="btn_normal" name="btn_cancelall" id="btn_cancelall">Accept Cancel</button>
</div>
<!-- opus_design_btn(E) -->


<!-- opus_design_grid(S) -->
<div class="opus_design_grid" id="mainTable">
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<!-- Content -->
		<button type="button" class="btn_normal" name="btn_rowadd1" id="btn_rowadd1">Row Add</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_delete1" id="btn_delete1">Delete</button>
	</div>
	<!-- opus_design_btn(e) -->
	
	<script type="text/javascript">ComSheetObject('sheet1');</script>
</div>
<!-- opus_design_grid(E) -->

<!-- opus_design_grid(S) -->
<div class="opus_design_grid" id="mainTable">
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<!-- Content -->
			<button type="button" class="btn_normal" name="btn_rowadd2" id="btn_rowadd2">Row Add</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_delete2" id="btn_delete2">Delete</button><!-- 
	 	 --><button type="button" class="btn_normal" name="btn_amend" id="btn_amend">Amend</button><!-- 
	 	 --><button type="button" class="btn_normal" name="btn_amendcancel" id="btn_amendcancel">Amend Cancel</button><!--
	 	 --><button type="button" class="btn_normal" name="btn_accept" id="btn_accept">Accept</button><!--
	 	 --><button type="button" class="btn_normal" name="btn_acceptcancel" id="btn_acceptcancel">Accept Cancel</button> 
	</div>
	<!-- opus_design_btn(e) -->
	
	<script type="text/javascript">ComSheetObject('sheet2');</script>
</div>
<!-- opus_design_grid(E) -->
 </form>
