<%
/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : ESM_PRI_2001_01.jsp
 *@FileTitle  :  Locaton Group Guideline Creation
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/05/27
 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.rfaguideline.rfagrouplocationguideline.event.EsmPri200101Event"%>
<%@ page import="com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="java.util.List"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
    EsmPri200101Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //error from server
	String strErrMsg = ""; //error message
	int rowCount = 0; //count of DB resultSET list

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	
	String[] orgDestTpCd = null;	//ORI/DEST
	
	Logger log = Logger.getLogger("com.clt.apps.SCGuideline.SCGuidelineMain");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmPri200101Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		 
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		//COMMBO LIST
		orgDestTpCd 		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("ORG_DEST_TP_CD"), false);
		
	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<script type="text/javascript">
	var orgDestTpCdComboValue = "<%=orgDestTpCd[0]%>";
    var orgDestTpCdComboText = "<%=orgDestTpCd[1]%>";
    
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		
		loadPage();
	}

</script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="svc_scp_cd" id="svc_scp_cd">
<input type="hidden" name="gline_seq" id="gline_seq">
<input type="hidden" name="grp_loc_seq" id="grp_loc_seq">
<input type="hidden" name="cd" id="cd">



	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn" ><!-- style="padding-right: 14px;" -->
		<!-- Content -->
		<button type="button" class="btn_normal" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!-- 
		  --><button type="button" class="btn_normal" name="btn_loadexcel" id="btn_loadexcel">Load Excel</button><!-- 
		   --><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button>
	</div>
	<!-- opus_design_grid(E) -->
<!-- layout_wrap(S) -->
<div class="layout_wrap" style="width: 100%">	
	<!-- layout_vertical_2(S) -->
	<div class="layout_vertical_2" style="width: 38%">
		<!--Content-->		
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" id="mainTable">
			<div class="opus_design_btn">
				<button type="button" class="btn_normal" name="btn_rowadd1" id="btn_rowadd1">Row Add</button><!-- 
			 	--><button type="button" class="btn_normal" name="btn_delete1" id="btn_delete1">Delete</button>
		 	</div>
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<!-- opus_design_grid(E) -->
		
	</div>
    <!-- layout_vertical_2(E) -->
    	
    
    <!-- layout_vertical_2(S) -->
		<div class="layout_vertical_2" style="width: 3%">		
			<table style="position: relative;top:190px">
			<tr>
				<td width="49" align="center">
					<button type="button" class="btn_right"></button>
					<!-- <img src="img/btn_add.gif" width="26" height="26" alt="" border="0" align="absmiddle"> -->
				</td>						
			</tr>
			</table>			
		<!--Content-->			
		</div>
     <!-- layout_vertical_2(E) -->
    
    
    <!-- layout_vertical_2(S) -->
	<div class="layout_vertical_2" style="width: 59%">		
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" id="mainTable">
			<div class="opus_design_btn">
				<button type="button" class="btn_normal" name="btn_rowadd2" id="btn_rowadd2">Row Add</button><!-- 
				 --><button type="button" class="btn_normal" name="btn_delete2" id="btn_delete2">Delete</button>
			 </div>					
			<script type="text/javascript">ComSheetObject('sheet2');</script>
		</div>
		<!-- opus_design_grid(E) -->
		
	</div>
    <!-- layout_vertical_2(E) -->
</div>
<!-- layout_wrap(E) -->



<div id="hiddenSheetLayer" style="display:none">
	<script type="text/javascript">ComSheetObject('sheet3');</script>
	<script type="text/javascript">ComSheetObject('sheet4');</script>
</div>

 
</form>
