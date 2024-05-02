<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EES_MNR_0200.jsp
*@FileTitle : Disposal Detail Information Popup
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/21
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.event.EesMnr0200Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMnr0200Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Occurred error from server
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//Row count of retrieved database data

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	String strRhq_cd 		= "";

	String dispNo = ((request.getParameter("disp_no")==null )?"":request.getParameter("disp_no"));
	String eqKndCd = ((request.getParameter("eq_knd_cd")==null )?"":request.getParameter("eq_knd_cd"));
	String dispQty = ((request.getParameter("disp_qty")==null )?"":request.getParameter("disp_qty"));
	String dispStPrc = ((request.getParameter("disp_st_prc")==null )?"":request.getParameter("disp_st_prc"));
	String rqstOfcCd = ((request.getParameter("rqst_ofc_cd")==null )?"":request.getParameter("rqst_ofc_cd"));
	String rqstUsrId = ((request.getParameter("rqst_usr_id")==null )?"":request.getParameter("rqst_usr_id"));
	String rqstDt = ((request.getParameter("rqst_dt")==null )?"":request.getParameter("rqst_dt"));
	String dispStsCd = ((request.getParameter("disp_sts_cd")==null )?"":request.getParameter("disp_sts_cd"));
	String aproOfcCd = ((request.getParameter("apro_ofc_cd")==null )?"":request.getParameter("apro_ofc_cd"));
	String currCd = ((request.getParameter("curr_cd")==null )?"":request.getParameter("curr_cd"));
	String dispEmlFlg = ((request.getParameter("disp_eml_flg")==null )?"":request.getParameter("disp_eml_flg"));
	String fileSeq = ((request.getParameter("file_seq")==null )?"":request.getParameter("file_seq"));
	String mnrDispRmk = ((request.getParameter("mnr_disp_rmk")==null )?"":request.getParameter("mnr_disp_rmk"));
	String chgCd = ((request.getParameter("chg_cd")==null )?"":request.getParameter("chg_cd"));

	Logger log = Logger.getLogger("com.clt.apps.OperationManage.DisposalMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	    strOfc_cd = account.getOfc_cd();
	    strRhq_cd = account.getRhq_ofc_cd();

		event = (EesMnr0200Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		//Extracting retrieved data from server on load screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>


<!--Use a common at MNR  -->
<script  type="text/javascript">
	function setupPage(){
		var formObj = document.form;
		formObj.disp_no.value = "<%=dispNo%>";
	 	formObj.app_ofc_cd.value = "<%=aproOfcCd%>";
		formObj.disp_qty.value = ComAddComma2("<%=dispQty%>", "#,###");
		formObj.disp_st_prc.value = ComAddComma2("<%=dispStPrc%>", "#,###");
		formObj.rqst_ofc_cd.value = "<%=rqstOfcCd%>";
		formObj.rqst_usr_id.value = "<%=rqstUsrId%>";

		//Combo reset at IBCLEAR
		formObj.temp2.value   = "<%=eqKndCd%>";
		formObj.temp3.value   = "<%=dispStsCd%>";
		formObj.temp4.value   = "<%=currCd%>";
		
		formObj.chg_cd.value   = "<%=chgCd%>";

		loadPage();

		formObj.rqst_dt.value = "<%=rqstDt%>";

		if("<%=dispEmlFlg%>" == 'Y'){
			formObj.disp_eml_flg.value = 'Y';
			formObj.disp_eml_flg_temp.checked = true;
		} else {
			formObj.disp_eml_flg.value = 'N';
			formObj.disp_eml_flg_temp.checked = false;
		}
		formObj.mnr_disp_rmk.value = "<%=mnrDispRmk%>";

		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		}
	}
</script>
<script  type="text/javascript">ComSheetObject('sheet1');</script>
<script  type="text/javascript">ComSheetObject('sheet2');</script>
<div style="display:none">
	<script  type="text/javascript">ComUploadObject('upload1', '<=session.getId()%>');</script>
</div>
<form name="form">

<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<!-- Variable for app office -->
<input type="hidden" name="rhq_cd" id="rhq_cd" value="<%=strRhq_cd%>">
<input type="hidden" name="mnr_grp_tp_cd" id="mnr_grp_tp_cd" value="DSP">
<input type="hidden" name="file_seq" id="file_seq" value="">
<input type="hidden" name="disp_eml_flg" id="disp_eml_flg" value="N">
<input type="hidden" name="disp_search_type" id="disp_search_type" value="approval">
<input type="hidden" name="self_ofc_cd" id="self_ofc_cd" value="<%=strOfc_cd%>">
<input type="hidden" name="rqst_ofc_cd" id="rqst_ofc_cd" value="">
<input type="hidden" name="rqst_usr_id" id="rqst_usr_id" value="">
<input type="hidden" name="fileSeq" id="fileSeq" value="<%=fileSeq%>">

<input type="hidden" name="temp1" id="temp1" value="">
<input type="hidden" name="temp2" id="temp2" value="">
<input type="hidden" name="temp3" id="temp3" value="">
<input type="hidden" name="temp4" id="temp4" value="">
<input type="hidden" name="chg_cd" id="chg_cd" value="">

<!-- page_title_area(S) -->
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>Disposal Detail information</span></h2>
		<!-- page_title(E) -->
			
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
            <button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->	
	</div>
	</div>
<!-- page_title_area(E) -->
<div class="layer_popup_contents">
<!-- layout_wrap(S) -->
<div class="wrap_search" style="width: 1000;">
    <div class="layout_vertical_2" style="width: 60%;" >	
     	<table>
			<tbody>
				<colgroup>					
					<col width="80"/>
					<col width="120"/>
					<col width="80"/>			
					<col width="120"/>			
					<col width="50"/>			
					<col width="120"/>			
			  	</colgroup>	
			  	<span class="title_s" style="color: #005CB9; font-weight: bold; padding-left: 5px;">Disposal Information</span>				  		
				<tr>
					<th style="text-align:left;padding:7px;width:80px">Disposal No.</th>
					<td>
						<input type="text" name="disp_no" id="disp_no" style="width:120px"  class="input2" readOnly>
					</td>
					<th style="text-align:left;padding:7px;">Request DT</th>
					<td>
						<input type="text" name="rqst_dt" id="rqst_dt" style="width:80px"  class="input2" readOnly>
					</td>
					<th style="text-align:left;padding:7px;width:50px">Status</th>
					<td>
						<script  type="text/javascript">ComComboObject('disp_sts_cd', 1, 90, 1, 3,0,false,0);</script>
					</td>
				</tr>
				<tr>
					<th style="text-align:left;padding:7px;width:80px">EQ Type</th>
					<td>
						<script  type="text/javascript">ComComboObject('eq_knd_cd', 1, 104, 1, 1,0,false,0);</script>
					</td>
					<th style="text-align:left;padding:7px;">APP Office</th>
					<td>
						<input type="text" name="app_ofc_cd" style="width:104px"  class="input2" readOnly>
					</td>
					<th style="text-align:left;padding:7px;width:50px">Currency</th>
					<td>
						<script  type="text/javascript">ComComboObject('curr_cd', 1, 104, 1, 1,0,false,0);</script>
					</td>
				</tr>
				<tr>
					<th style="text-align:left;padding:7px;width:80px">Total Qty
					<td>
						<input type="text" name="disp_qty" id="disp_qty" style="width:104px;text-align:right" value="" class="input2" dataformat="int" readOnly>
					</td>
					<th style="text-align:left;padding:7px;width:50px">Total AMT
					<td>
						<input type="text" name="disp_st_prc" id="disp_st_prc" style="width:104px;text-align:right" value="" class="input2" dataformat="float" pointcount="2" readOnly>
					</td>
					<td></td>
					<td>
						<input name="disp_eml_flg_temp" id="disp_eml_flg_temp" type="checkbox" class="trans" ><strong style="padding-left: 10px;">E-mail Notice</strong>
					</td>					
				</tr>
			</tbody>
		</table>	
		
    </div>
    <div class="layout_vertical_2" style="width: 40%;" >   	
        <div class="opus_design_grid_sm">
        	<span class="title_s" style="color: #005CB9; font-weight: bold; padding-left: 5px;">Buyer Selection</span>
         	<script  type="text/javascript">ComSheetObject('sheet3');</script>
        </div>
<!--         opus_design_grid(E) -->
    </div>
</div>
<!-- layout_wrap(E) -->

<!-- layout_wrap(S) -->
<div class="wrap_result">
<div class="layout_wrap">
    <div class="layout_vertical_2 pad_rgt_12"> 
    	
    	<span class="title_s" style="color: #005CB9; font-weight: bold; padding-left: 5px;">Unit Sale</span>
    		
        <!-- opus_design_grid(S) -->
        <div class="opus_design_grid clear">
          	<script  type="text/javascript">ComSheetObject('t1_sheet1');</script>
        </div>
        <!-- opus_design_grid(E) -->
    </div>
    <div class="layout_vertical_2">
    	
        <!-- opus_design_grid(S) -->
        <div class="opus_design_grid" >
        	<span class="title_s" style="color: #005CB9; font-weight: bold; padding-left: 5px;">File Attach</span>	
          	<script  type="text/javascript">ComSheetObject('sheet4');</script>
        </div>
        <!-- opus_design_grid(E) -->
        
    </div>
    
</div>
<!-- layout_wrap(E) -->
<div class="wrap_result">
<div class="layout_wrap">
<!-- opus_design_data(S) -->
<div class="opus_design_inquiry">
	<table border="5" style="width:100%; background-color:white;margin-top:20px;">
		<tr>
			<th width="5%">Remark</th>
			<td>
				<textarea name="mnr_disp_rmk" wrap="off" style="width:99%;resize:none;" rows="1"></textarea>
			</td>
		</tr>
	</table>
</div>
</div>
</div>
</div>
</div>
<!-- opus_design_data(E) -->
</form>