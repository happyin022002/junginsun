<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_0225.jsp
*@FileTitle  : Division Code Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/13
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.mnr.generalmanage.cedexcodemgt.event.EesMnr0225Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
 	EesMnr0225Event  event = null;				//PDTO(Data Transfer Object including Parameters)
 	Exception serverException   = null;			//Occurred error from server
 	String strErrMsg = "";						//Error message

 	String strUsr_id		= "";
 	String strUsr_nm		= "";
	String strAccess_System		= "";
	String rhqOfcCd         = "";
	String currOfcCd       = "";
	String currOfcEngNm     = "";
 	try {
 	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
 		strUsr_id =	account.getUsr_id();
 		strUsr_nm = account.getUsr_nm();
		strAccess_System = account.getAccess_system();

		rhqOfcCd     = 	account.getRhq_ofc_cd();
		currOfcCd    = 	account.getOfc_cd();
		currOfcEngNm = 	account.getOfc_eng_nm();

 		event = (EesMnr0225Event)request.getAttribute("Event");
 		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

 		if (serverException != null) {
 			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
 		}
 	}catch(Exception e) {
 		out.println(e.toString());
 	}
 %>

<script  type="text/javascript">
	var currOfcCd = "<%=currOfcCd.trim() %>";
	var usrId     = "<%=strUsr_id.trim()%>";
	var rhqOfcCd  = "<%=rhqOfcCd.trim()%>";
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

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" 		id="btn_Retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_New" 			id="btn_New">New</button><!-- 		
		 --><button type="button" class="btn_normal" name="btn_Save" 			id="btn_Save">Save</button>			
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->

</div>
<!-- page_title_area(E) -->
<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
		<table>
			<tbody>
				<colgroup>
					<col width="65">
					<col width="150">
					<col width="150">
					<col width="*">				
			  	</colgroup>				
				<tr>
					<th>Tariff Type</th>
					<td><script  type="text/javascript">ComComboObject('in_cost_grp_cd',1,160,1,1,0,false,0);</script></td>
					<th>Component Code</th>
					<td><input type="text" name="in_eq_cmpo_cd" id="in_eq_cmpo_cd" caption="Component Code" style="width:55px;text-align:left;" class="input" value="" dataformat="engup" maxlength="6" /><!-- 
						 --><input type="text" name="eq_cmpo_nm" id="eq_cmpo_nm" caption="Component Name" style="width:190px;" class="input2" value="" readonly="" />
					</td>
				</tr>				
			</tbody>
		</table>	
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear" name="tabLayer" id="tabLayer">
		<h3 class="title_design">Division Type Code</h3>
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_RowAdd" 		id="btn_RowAdd">Row Add</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_RowDelete" 	id="btn_RowDelete">Row Delete</button><!-- 		
			 --><button type="button" class="btn_normal" name="btn_RowCopy" 	id="btn_RowCopy">Row Copy</button><!-- 			
			 --><button type="button" class="btn_normal" name="btn_Excel1" 		id="btn_Excel1">Down Excel</button>			
		</div>
		<!-- opus_design_btn(E) -->
	
		<script type="text/javascript">ComSheetObject('sheet1');</script>	
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>