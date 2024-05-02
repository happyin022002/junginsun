<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   :ESM_BKG_1043.jsp
*@FileTitle  : Container Rate
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/29
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.event.EsmBkg1043Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	EsmBkg1043Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.BlRating.BlRating");

	// search Init
	String bkgNo      = "";
	String blNo       = "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg1043Event)request.getAttribute("Event");
		bkgNo      = event.getBkgNo();
		blNo       = event.getBlNo();
				
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<!-- 개발자 작업	-->
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>Rate per container</span></h2>
		
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--  -->
			<button type="button" class="btn_normal" name="btn_exchange" id="btn_exchange">Exchange Rate</button><!--  -->
			<button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button><!--  -->
			<button type="button" class="btn_normal" name="btn_remark" id="btn_remark">Remark</button>
		</div>
	</div>
</div>


<div class="layer_popup_contents">

	<div class="wrap_search">
 		
		<div class="opus_design_inquiry wFit"  style="width:979px;">
 		    <table class="search" border="0"> 
			<tr class="h23">
    			<td width="740px;">
					<table class="search" border="0" width="100%"> 
						<tr class="h23">
						<th width="55px">BKG No.</th>
						<td width="100px"><input type="text" name="bkg_no" value="<%=bkgNo%>" style="ime-mode:disabled;width:120;" dataformat="engup" class="input1">
						<img class="cursor" src="img/btns_inquiry.gif" width="19" height="20" border="0" align="absmiddle" name="btn_splitPop">
						</td>
						<th width="55px">B/L No.</th>
						<td width="150px"><input type="text" name="bl_no" value="<%=blNo%>" style="ime-mode:disabled;width:114;" dataformat="engup" class="input"></td>
						<th width="120px">Application Date</th>
						<td width=""><input type="text" name="rt_aply_dt" style="ime-mode:disabled;width:82px;" class="input2"></td>
						</tr>
					</table>
					
					<table class="search" border="0" width="100%">						
						<tr class="h23">
						<th width="54px">T/VVD</th>
						<td width="133px"><input type="text" name="vvd" style="ime-mode:disabled;width:100px;" dataformat="engup" class="input2"></td>
						<th width="35px">Route</th>
						<td width="230px"><input type="text" name="por_cd" style="ime-mode:disabled;width:50px;" dataformat="engup" class="input2">&nbsp;<input type="text" name="pol_cd" style="ime-mode:disabled;width:50px;" dataformat="engup" class="input2">&nbsp;<input type="text" name="pod_cd" style="ime-mode:disabled;width:50px;" dataformat="engup" class="input2">&nbsp;<input type="text" name="del_cd" style="ime-mode:disabled;width:50px;" dataformat="engup" class="input2"></td>
						<th width="85px">PRE/POST</th>
						<td width=""><input type="text" name="pre_rly_port_cd" style="ime-mode:disabled;width:50px;" dataformat="engup" class="input2">&nbsp;/&nbsp;<input type="text" name="pst_rly_port_cd" style="ime-mode:disabled;width:50px;" dataformat="engup" class="input2"></td>
						</tr>
					</table>	
					
					<table class="search" border="0" width="100%">	
						<tr class="h23">
						<th width="54px">SHPR</th>
						<td width="410px"><input type="text" name="shpr_cd" style="ime-mode:disabled;width:100px;" dataformat="engup" otherchar=" " class="input2">&nbsp;<input type="text" name="shpr_nm" style="ime-mode:disabled;width:291px;" dataformat="engup" otherchar=" " class="input2"></td>
						<th width="90px">Contract No</th>
						<td width="12px">&nbsp;</td>
						<td width=""><input type="text" name="contract_no" style="ime-mode:disabled;width:91px;" dataformat="engup" class="input2"></td>
						</tr>
					</table>
 
					<table class="search" border="0" width="100%">	
						<tr class="h23">
						<th width="54px">CNEE</th>
						<td width="410px"><input type="text" name="cnee_cd" style="ime-mode:disabled;width:100px;" dataformat="engup" otherchar=" " class="input2">&nbsp;<input type="text" name="cnee_nm" style="ime-mode:disabled;width:291px;" dataformat="engup" otherchar=" " class="input2"></td>
						<th width="107px">Customs Desc.</th>
						<td width=""><input type="text" name="cstms_desc" style="ime-mode:disabled;width:91px;" dataformat="engup" otherchar=" " class="input2"></td>
						</tr>
					</table>	

					<table class="search" border="0" width="100%">										
						<tr class="h23">
						<th width="54px">Bill Type</th>
						<td width="110px"><input type="text" name="rt_bl_tp_cd" style="ime-mode:disabled;width:30px;" dataformat="engup" class="input2"></td>
						<th width="75px" id="td_cvrd_text">Covered By</th>
						<td width=""><input type="text" name="mst_cvrd_bl_no" style="ime-mode:disabled;width:112px;" dataformat="engup" class="input2">&nbsp;<img class="cursor" name="btn_findCovered" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
						</tr>
					</table> 
				</td>
				<!-- 
				<td width="239px;" valign="top" >
					<div class="opus_design_grid" style="margin-right:8px; height:125px;">
						<table class="search" border="0" width="100%">
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet1');</script>
								</td>
							</tr>
						</table>
					</div>
				</td>-->
			</tr>
			</table>	
			</div>
			<div class="layout_flex_flex" style="padding-left:705px;padding-top:10px;padding-right:11px">
				<div class="opus_design_grid">
					<script type="text/javascript">ComSheetObject('sheet1');</script>
				</div>
			</div>
		<script language="javascript">ComSheetObject('sheet2');</script>
		<script language="javascript">ComSheetObject('sheet3');</script>
		<script language="javascript">ComSheetObject('sheet4');</script>
	</div>
	
	<div class="wrap_result">
		<div class="layout_wrap">
			<table border="0" style="width:979px;" class="search"> 
			<tr class="h23">
    			<td width="240">
    				<table border="0" class="grid2"> 
					<tr>
						<th width="40px" rowspan="2" class="tr2_head"><b>PPD</b></th>
						<th width="50px" class="tr2_head"><b>Total</b></th>
						<td width="150px" height="48px" style="text-indent:0px;"><div id="pn_amt_layer" style="width:150px;height:48px;overflow:auto;"></div></td>
					</tr>
					<tr>
						<th class="tr2_head"><b>At</b></th>
						<td height="16px" style="text-indent:0px;"><div id="pn_ofc_layer" style="width:150px;height:24px;overflow:hidden;"></div></td>
					</tr>
					</table>
				</td>
				<td width="10"></td>
				<td width="240px">
    				<table border="0" class="grid2"> 
					<tr>
						<th width="40px" rowspan="2" class="tr2_head"><b>CCT</b></th>
						<th width="50px" class="tr2_head"><b>Total</b></th>
						<td width="150px" height="48" style="text-indent:0px;"><div id="cn_amt_layer" style="width:150px;height:48px;overflow:auto;"></div></td>
					</tr>
					<tr>
						<th class="tr2_head"><b>At</b></th>
						<td height="16px" style="text-indent:0px;"><div id="cn_ofc_layer" style="width:150px;height:24px;overflow:hidden;"></div></td>
					</tr>
					</table>
				</td>
				<td width="10px"></td>
				<td width="240px">
    				<table border="0" class="grid2"> 
					<tr>
						<th width="40px" rowspan="2" class="tr2_head"><b>3RD</b></th>
						<th width="50px" class="tr2_head"><b>Total</b></th>
						<td width="150px" height="48" style="text-indent:0px;"><div id="py_amt_layer" style="width:150px;height:48px;overflow:auto;"></div></td>
					</tr>
					<tr>
						<th class="tr2_head"><b>At</b></th>
						<td height="16px" style="text-indent:0px;"><div id="py_ofc_layer" style="width:150px;height:24px;overflow:hidden;"></div></td>
					</tr>
					</table>
				</td>
				<td width="10px"></td>
				<td width="240px">
    				<table border="0" class="grid2"> 
					<tr>
						<th width="40px" rowspan="2" class="tr2_head"><b>3RD</b></th>
						<th width="50px" class="tr2_head"><b>Total</b></th>
						<td width="150px" height="48px" style="text-indent:0px;"><div id="cy_amt_layer" style="width:150px;height:48px;overflow:auto;"></div></td>
					</tr>
					<tr>
						<th class="tr2_head"><b>At</b></th>
						<td height="16px" style="text-indent:0px;"><div id="cy_ofc_layer" style="width:150px;height:24px;overflow:hidden;"></div></td>
					</tr>
					</table>
				</td>
				</tr>
			</table>
		</div>
	</div>
</div>
</form>
