<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_SAQ_0165.jsp
*@FileTitle  : QTA Editing
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/10
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacfmadjustment.event.EsmSaq0165Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmSaq0165Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String loginOfcCd		= "";
	
	Logger log = Logger.getLogger("com.clt.apps.MonthlySalesQuotaManage.monthlyquotacfmadjustment");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id   = account.getUsr_id();
		strUsr_nm   = account.getUsr_nm();
		loginOfcCd 	= account.getOfc_cd();


		event = (EsmSaq0165Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

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
<input type="hidden" name="usr_id" value="<%=strUsr_id%>" id="usr_id" />
<input type="hidden" name="ofcCd" value="<%=loginOfcCd%>" id="ofcCd" />
<input type="hidden" name="qtaTgtCd" value="Q" id="qtaTgtCd" />
<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" 	id="btn_retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_save" 		id="btn_save">Save</button><!--
		--><button type="button" class="btn_normal" name="btn_templatedownload"  		id="btn_templatedownload">Template Download</button><!--	
		--><button type="button" class="btn_normal" name="btn_excelupload"  		id="btn_excelupload">Load Excel</button>	
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->
<div class= "wrap_search">
<!-- opus_design_inquiry(S) -->
	<div class= "opus_design_inquiry wFit">
		<table>
			<tbody>
				<colgroup>
					<col width="103px"/>
					<col width="100px"/>
					<col width="50px"/>
					<col width="100px"/>
					<col width="55px"/>
					<col width="110px"/>
					<col width="70px"/>					
					<col width="*"/>
			    </colgroup>
				<tr>
					<th>Release Version</th>
					<td><input name="mqtaRlseVerNo" id="mqtaRlseVerNo" type="text" class="input1" style="width:80px;" readonly id="mqtaRlseVerNo" /> </td>
					<th>Year</th>
					<td><select class="input1" name="bse_yr" id="bse_yr" style="width:80px;" onchange="quarter_OnChange();"></select></td>
					<th>Quarter</th>
					<td><select class="input1" name="bse_qtr_cd" id="bse_qtr_cd" style="width:80px;" onchange="quarter_OnChange();"></select></td>
					<th>Quarterly</th>
				    <td>Sales Quota  <input type="radio" name="rb_qta_tgt_cd" id="rb_qta_tgt_cd" value="Q" class="trans" onClick="qta_tgt_OnChange(this);" checked>  Load Target  <input type="radio" name="rb_qta_tgt_cd" id="rb_qta_tgt_cd" value="T" class="trans" onClick="qta_tgt_OnChange(this);">
					</td>					
				</tr>
				<tr>
					<th>Trade</th>
					<td><select name="trd_cd" id="trd_cd" class="input1" style="width:80px;" onchange="rlane_cd_change()"></select></td>
					<th>Bound</th>
					<td><select name="dir_cd" id="dir_cd" class="input1" style="width:80px;" onchange="rlane_cd_change();"></select></td>
					<th>Lane</th>
					<td colspan="3"><select id="rlane_cd" name="rlane_cd" style="width:80px;"></select></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<!-- opus_design_inquiry(E) -->
<!-- opus_design_grid(S) -->
<div class="wrap_result">
		
	<div class="opus_design_grid clear" >
	<div class="opus_design_btn">
	  <button type="button" class="btn_accent" name="btng_laneadd"  id="btng_laneadd">Lane Add</button><!-- 
	  --><button type="button" class="btn_normal" name="btng_officeadd"   id="btng_officeadd">Office Add</button> 
	 </div>
			<script type="text/javascript">ComSheetObject('rhqAdjSheet');</script>
	</div>
	<div class= "opus_design_data">
		<table>
			<tbody>
				<tr>
					<td>
						<div>
							<textarea name="msg" border="0" rows="5" readonly style="text-align:left;background-color:#cccccc;color:#ff0000;width:100%;"></textarea>
						</div>       		    		
					 </td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<!-- opus_design_grid(E) -->
<!-- opus_design_grid(S) -->
<div id="hiddenLayer2" style="display:none">
	<div class="opus_design_grid clear" >
			<script type="text/javascript">ComSheetObject('rhqAdjSheet_campare');</script>
	</div>
</div>
<!-- opus_design_grid(E) -->
</form>
