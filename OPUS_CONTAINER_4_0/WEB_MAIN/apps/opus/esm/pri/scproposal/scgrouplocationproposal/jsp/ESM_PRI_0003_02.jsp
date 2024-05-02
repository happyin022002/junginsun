<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0003_02.jsp
*@FileTitle  : S/C Location Group Creation
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
<%@ page import="com.clt.apps.opus.esm.pri.scproposal.scgrouplocationproposal.event.EsmPri000302Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri000302Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.SCProposal.SCGroupLocationProposal");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmPri000302Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// adding logic to get data from server when first loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script language="javascript">
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

<input type="hidden" name="grp_loc_seq" id="grp_loc_seq" />
<input type="hidden" name="req_usr_flg" id="req_usr_flg" />
<input type="hidden" name="apro_usr_flg" id="apro_usr_flg" />
<input type="hidden" name="dur_dup_flg" id="dur_dup_flg" />
<input type="hidden" name="lgcy_if_flg" id="lgcy_if_flg" />

<!-- opus_design_btn(S) -->
<div class="opus_design_btn" style="padding-right: 14px;">
	<!-- Content -->
	<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
 	--><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!-- 
  	--><button type="button" class="btn_normal" name="btn_acceptall" id="btn_acceptall">Accept All</button><!-- 
   	--><button type="button" class="btn_normal" name="btn_cancelall" id="btn_cancelall">Accept Cancel</button><!-- 
    --><button type="button" class="btn_normal" name="btn_glinecopy" id="btn_glinecopy">G/L Copy</button>
</div>
<!-- opus_design_grid(E) -->

<div class="opus_design_grid" id="mainTable">

	<!-- layout_vertical_2(S) -->
	<div class="layout_vertical_2" style="width: 30%">
		<!--Content-->
			<div class="opus_design_btn">
				<button type="button" class="btn_normal" name="btn_rowadd1" id="btn_rowadd1">Row Add</button><!-- 
			 	--><button type="button" class="btn_normal" name="btn_delete1" id="btn_delete1">Delete</button>
		 	</div>
			<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
     <!-- layout_vertical_2(E) -->
     
      <!-- layout_vertical_2(S) -->
		<div class="layout_vertical_2" style="width: 3%">		
			<table style="position: relative;top:190px">
			<tr>
				<td width="49" align="center"><button type="button" class="btn_right"></button></td>						
			</tr>
			</table>			
		<!--Content-->			
		</div>
     <!-- layout_vertical_2(E) -->
     
     <!-- layout_vertical_2(S) -->
	<div class="layout_vertical_2" style="width: 67%">		
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" id="mainTable">
			<div class="opus_design_btn">
				<button type="button" class="btn_normal" name="btn_rowadd2" suppressWait="Y" id="btn_rowadd2">Row Add</button><!-- 
				 --><button type="button" class="btn_normal" name="btn_delete2" id="btn_delete2">Delete</button><!-- 
				 --><button type="button" class="btn_normal" name="btn_amend" id="btn_amend" suppressWait="Y">Amend</button><!--
				 --><button type="button" class="btn_normal" name="btn_amendcancel" id="btn_amendcancel">Amend Cancel</button><!-- 
				 --><button type="button" class="btn_normal" name="btn_accept" id="btn_accept">Accept</button><!-- 
				 --><button type="button" class="btn_normal" name="btn_acceptcancel" id="btn_acceptcancel">Accept Cancel</button>				 
			 </div>					
			<script type="text/javascript">ComSheetObject('sheet2');</script>
		</div>
	</div>
	<!-- layout_wrap(E) -->
</div>
</form>
