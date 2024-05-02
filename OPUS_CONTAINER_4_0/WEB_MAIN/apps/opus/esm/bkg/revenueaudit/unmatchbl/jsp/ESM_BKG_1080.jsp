﻿<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1080.jsp
*@FileTitle : Audit by Hanger Installation
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.event.EsmBkg1080Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.code.CodeInfo"%>
<%@ page import="com.clt.apps.opus.esm.bkg.revenueauditcommon.rascommon.rascommon.vo.RsltCdListVO"%>
<%@ page import="com.clt.apps.opus.esm.bkg.revenueauditcommon.common.RASUtil"%>
<%@ page import="com.clt.framework.component.common.AbstractValueObject"%>
<%@ page import="java.util.List"%>

<%
    EsmBkg1080Event  event = null;              //PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//serverException
	String strErrMsg = "";						//error massage
	int rowCount	 = 0;						//DB ResultSet list count
    
    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    String strRhq_ofc_cd    = "";
    String strOfc_cd        = "";
    
    //String blNo = "";
    
    String[] rhqs = null;
    String[] offices = null;
    String[] svcScpCds = null;
    String[] contractTypes = null; 
    String[] splitFlgs = null;
    String[] chargeFlgs = null;
    
    Logger log = Logger.getLogger("com.clt.apps.RevenueAudit.UnmatchBL");
    
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        strRhq_ofc_cd = account.getRhq_ofc_cd();
        strOfc_cd = account.getOfc_cd();

        //blNo = request.getParameter("bl_no");
        
        event = (EsmBkg1080Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
        
		//when open screen, get data in server..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        
        // rhq
        rhqs = RASUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("rhq"));
        // office
        offices = RASUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("office"));
        if(null == offices){
            offices = new String[] {"", ""};
        }
        // Scope
        svcScpCds = RASUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("svcScpCd"));
        // Contract Type => 0256 reference
        contractTypes = RASUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("contractType"), false , "|", "\t", "getCode", "getName");
     // Split Status Combo Data creation
        splitFlgs = RASUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("splitFlg"), true , "|", "\t", "getCode", "getName");
     // Charge Status Combo Data creation
        chargeFlgs = RASUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("chargeFlg"), true , "|", "\t", "getCode", "getName");
        
        
    }catch(Exception e) {
        out.println(e.toString());
    }
    
%>

<script language="javascript">

    var rhqComboValue = "|<%=rhqs[0]%>";

    var officeComboValue = "|<%=offices[0]%>";
    
    if(officeComboValue == "|"){
        officeComboValue = "";
    }
    
    var svcScpCdComboValue = "|<%=svcScpCds[0]%>";
    var svcScpCdComboText = "|<%=svcScpCds[1]%>";
    
    var contractTypeComboValue = "|<%=contractTypes[0]%>";
    var contractTypeComboText = "|<%=contractTypes[1]%>";
    
     var splitFlgComboValue = "|<%=splitFlgs[0]%>";
    var splitFlgComboText = "|<%=splitFlgs[1]%>";
    
    var chargeFlgComboValue = "|<%=chargeFlgs[0]%>";
    var chargeFlgComboText = "|<%=chargeFlgs[1]%>";
    
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            showErrMessage(errMessage);
        } // end if
        loadPage();
    }
</script>




<form name="form" id="form">

<!--  definition for Office Code Validation check -->
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="cd">
<!--  definition for Office Code Validation check -->
<input type="hidden" name ="ofc_cd" value="">
<!-- Form Hidden -->

<input type="hidden" name="strRhq_ofc_cd" value="<%=strRhq_ofc_cd%>">
<input type="hidden" name="strOfc_cd" value="<%=strOfc_cd%>">

	<!-- page_title_area(S) -->
	<div class="page_title_area clear ">
		<!-- page_title(S) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->
	
		    <!-- opus_design_btn(S) -->
		    <div class="opus_design_btn">
		        <!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
				<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
				--><button type="button" class="btn_normal" name="btn_new"   id="btn_new">New</button><!--
				--><button type="button" class="btn_normal" name="btn_save"   id="btn_save">Save</button><!--
				--><button type="button" class="btn_normal" name="btn_downexcel"   id="btn_downexcel">Down Excel</button>
		    </div>
		    <!-- opus_design_btn(E) -->
	    
		<!-- page_location(S) -->
		<div class="location">
			<!-- location 내용 동적생성 (별도 코딩 불필요) -->
			<span id="navigation"></span>
		</div>
		<!-- page_location(E) -->
	
	</div>
	<!-- page_title_area(E) -->
	

<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
	    <!-- 조회영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <table>
	    	<tbody>
				<tr>
					<th width="90">RHQ</th>
					<td width="100">
						<script language="javascript">ComComboObject('bkg_rhq_cd', 1, 90, 0, 1, 0, false);</script>
					</td>
					<th width="80">Office</th>
					<td width="120">
						<script language="javascript">ComComboObject('bkg_ofc_cd', 1, 80, 0, 0, 0, false);</script>
					</td>
					<td width="200" colspan="2">
						<div class="sm">
							<table>
								<tr>
									<td>
										<input type="radio" id="search_date_bkg" name="search_date" value="BOOKING"><label for="search_date_bkg">BKG</label>
										<input type="radio" id="search_date_appl" name="search_date" value="APPL"><label for="search_date_appl">Appl.</label>
										<input type="radio" id="search_date_etd" name="search_date" value="ETD" checked><label for="search_date_etd">ETD</label>
									</td>
								</tr>
							</table>
						</div>
					</td>
					<th width="40">Date</th>
					<td width="210">
					    <input type="text" style="width:75px;text-align:center;" class="input1" value="" caption="From Date" name="from_dt" dataformat="ymd" maxLength="10" minlength="8"><!--
					    --><button type="button" class="calendar" id="btns_calendar1" name="btns_calendar1"></button>
					    ~
					    <input type="text" style="width:75px;text-align:center;" class="input1" value="" caption="To Date" name="to_dt" dataformat="ymd" maxLength="10" minlength="8"><!--
					    --><button type="button" class="calendar" id="btns_calendar1" name="btns_calendar2"></button>
					</td>
					<th width="60">Scope</th>
					<td width="100">
						<script language="javascript">ComComboObject('svc_scp_cd', 2, 90, 0, 0, 0, false);</script>
					</td>
					<th width="50">T/VVD</th>
					<td>
						<input type="text" class="input" style="width:90px;text-align:center;ime-mode:disabled" name="vvd" dataformat="engup" caption="T/VVD" maxlength="9" fullfill><!-- 
						--><button type="button" class="input_seach_btn" id="btn_com_ens_ob2" name="btn_com_ens_ob2"></button>
					</td>
				</tr>
				<tr>
					<th>Contract Type</th>
					<td>
						<script language="javascript"> ComComboObject('bkg_ctrt_tp_cd', 1, 50, 0, 0, 0, false);</script>
					</td>
					<th>Contract No.</th>
					<td>
						<input input type="text" class="input" value="" style="width:105px;text-align:center;ime-mode:disabled" name="ctrt_no" dataformat="engup" caption="Contract No" maxlength="12">
					</td>
				</tr>
				<tr>
					<th>BDR Status</th>
					<td>
						<script language="javascript">ComComboObject('bdr_flg', 1, 62, 0, 0, 0, false);</script>
					</td>
					<th>Split Status</th>
					<td>
						<script language="javascript">ComComboObject('split_flg', 2, 82, 0, 0, 0, false);</script>
					</td>
					<th>Charge Status</th>
					<td>
						<script language="javascript">ComComboObject('charge_flg', 2, 82, 0, 0, 0, false);</script>
					</td>
					<td colspan="3">
						<div class="sm">
							<table>
								<tr>
									<td>
										<input type="checkbox" id="bill_type_all" name="bill_type_all"  value="ALL"><label for="bill_type_all">ALL</label>
	                                	<input type="checkbox" id="bill_type_n" name="bill_type_n" value="N" checked><label for="bill_type_n">Normal</label>
	                                	<input type="checkbox" id="bill_type_m" name="bill_type_m" value="M" checked><label for="bill_type_m">Master</label>
	                                	<input type="checkbox" id="bill_type_c" name="bill_type_c" value="C" disabled><label for="bill_type_c">Covered</label>
	                                	<input type="checkbox" id="bill_type_b" name="bill_type_b" value="B" disabled><label for="bill_type_b">Co-Biz</label>
									</td>
								</tr>
							</table>
						</div>
					</td>
				</tr>
			</tbody>
		</table>
	    <!-- 조회영역3 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid grid_option_right">
	    
	    <!-- opus_design_btn(S) -->
	       <table>
				<tr>
					<th width="80">B/L Count</th>
					<td>
						<input type="text" style="width:60px;text-align:right" class="input" value="" name="bl_cnt" id="bl_cnt" readonly>
					</td>
				</tr>
			</table>
	
	    <!-- opus_design_btn(E) -->
	 </div>
	 
    <!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
    <script language="javascript">ComSheetObject('sheet1');</script>
    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    
</div>
<!-- opus_design_grid(E) -->
</form>
