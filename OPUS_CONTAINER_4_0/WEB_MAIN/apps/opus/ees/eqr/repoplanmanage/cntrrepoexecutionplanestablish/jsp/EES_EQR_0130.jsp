<%/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : EES_EQR_0130.jsP
*@FileTitle  : BKG Split 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/03
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.event.EesEqr0130Event"%>
<%@ page import="com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.SearchExecutionPlanBkgNoVO"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesEqr0130Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.RepoPlanManage.CntrRepoExecutionPlanEstablish");
	
	String targetRow	= "";
	String co_cd		= "";
	String bkg_pod		= "";
	String bkg_no		= "";
	String bkg_status	= "";
	String bkg_vvd		= "";
	String bkg_pol		= "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesEqr0130Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// adding logic to get data from server when first loading ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		SearchExecutionPlanBkgNoVO searchExecutionPlanBkgNoVO = new SearchExecutionPlanBkgNoVO();
		
		searchExecutionPlanBkgNoVO = (SearchExecutionPlanBkgNoVO) eventResponse.getRsVoList().get(0);
		
		targetRow	= event.getConditionVO().getTargetrow();
		co_cd		= event.getConditionVO().getCoCd();
		
		bkg_no		= searchExecutionPlanBkgNoVO.getBkgNo();
		bkg_status	= searchExecutionPlanBkgNoVO.getBkgStsCd();
		bkg_vvd		= searchExecutionPlanBkgNoVO.getVvd();
		bkg_pol		= searchExecutionPlanBkgNoVO.getPolCd();
		bkg_pod		= searchExecutionPlanBkgNoVO.getPodCd();

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
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="iPage" id="iPage" />
<input type="hidden" name="targetRow" value="<%= targetRow %>" id="targetRow" />
<input type="hidden" name="co_cd" value="<%= co_cd %>" id="co_cd" />
<input type="hidden" name="bkg_pod" value="<%= bkg_pod %>" id="bkg_pod" />
<input type="hidden" name="excel_cntr_no" id="excel_cntr_no" />

<div class="layer_popup_title">
	<div class="page_title_area clear">
		   <!-- page_title(S) -->
			<h2 class="page_title"><span>Booking Split for Repositioning Empty Containers</span></h2>
			<!-- page_title(E) -->
			<!-- opus_design_btn(S) -->
			<div class="opus_design_btn">
				<button type="button" class="btn_accent" name="btn_new" 	id="btn_new">New</button><!--
				--><button type="button" class="btn_normal" name="btn_loadexcel" 		id="btn_loadexcel">Load Excel</button><!--
				--><button type="button" class="btn_normal" name="btn_downexcel" 		id="btn_downexcel">Down Excel</button><!--				
				--><button type="button" class="btn_normal" name="btn_close" 		id="btn_close">Close</button>	
			</div>
			<!-- opus_design_btn(E) -->
		</div>
</div>
		<!-- page_title_area(E) -->
	<!-- opus_design_inquiry(S) -->
	
	<div class="layer_popup_contents">
		<div class= "wrap_search">
		<div class= "opus_design_inquiry">
			<table>
				<tbody>
					<colgroup>
						<col width="80"/>
						<col width="100"/>
						<col width="60"/>
						<col width="30"/>
						<col width="50"/>
						<col width="80"/>
						<col width="80"/>
						<col width="80"/>
						<col width="80"/>
						<col width="*"/>
				    </colgroup>
					<tr>
						<th>BKG No.</th>
						<td><input type="text" style="width:90px;" name="bkg_no" value="<%= bkg_no %>" class="input2" readonly id="bkg_no" /> </td>
						<th>Status</th>
						<td><input type="text" style="width:20px;" value="<%= bkg_status %>" class="input2" readonly /> </td>
						<th title="Vessel Voyage Direction">VVD</th>
						<td><input type="text" style="width:75px;" value="<%= bkg_vvd %>" class="input2" readonly /> </td>
						<th>BKG POL</th>
						<td><input type="text" style="width:70px;" value="<%= bkg_pol %>" class="input2" readonly /> </td>
						<th>BKG POD</th>
						<td><input type="text" style="width:70px;" value="<%= bkg_pod %>" class="input2" readonly /> </td>
					</tr>	
				</tbody>
			</table>
		</div>
	</div>
	<!-- opus_design_inquiry(E) -->
	
	<!-- opus_design_grid(S) -->
	<div class="wrap_result">
		<!-- layout_wrap (S) -->
		 <div class="layout_wrap">
		     <div class="layout_vertical_3" style="width:460px;"> 
		     <div class="opus_design_grid clear" >
		     	<div class="opus_design_inquiry">
		     	<table>
		     		<tr>
		     			<td><h3 class="title_design">Master Data</h3></td>	     			
		     		</tr>
		     		
		     	</table>
		     	</div> 
					<script type="text/javascript">ComSheetObject('sheet1');</script>
				</div>  
		     </div>     
		      <div class="layout_vertical_3" style="width:80px;padding-top: 160px;">
		      	<table><tr><td align="center"><button type="button" class="btn_right" name="btns_add" id="btns_add"></button><br><br><button type="button" class="btn_left" name="btns_del" id="btns_del"></button></td></tr></table>
		      </div>
		     <div class="layout_vertical_3" style="width:460px;">	     
		      	<div class="opus_design_grid clear" >
		     	<div class="opus_design_inquiry">
		     	<table>
		     		<tr>
		     			<td><h3 class="title_design">Split BKG Creation</h3></td>
		     			<td><div class="opus_design_btn"><button type="button" class="btn_normal" name="btng_splitbkgcre" 	id="btng_splitbkgcre">Split BKG Cre.</button></div></td>
		     		</tr>
		     	</table> 
					<script type="text/javascript">ComSheetObject('sheet2');</script>
				</div>  
		     </div>
		 </div>
		<!-- layout_wrap (e) -->
		</div>
	<!-- opus_design_grid(E) -->
	</div>
	
	</div>
</form>