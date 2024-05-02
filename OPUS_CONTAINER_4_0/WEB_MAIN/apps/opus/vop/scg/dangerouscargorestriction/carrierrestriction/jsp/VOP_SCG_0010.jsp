<%
/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : VOP_SCG_0010.jsp
 *@FileTitle : Vessel Operator's Restriction on DG - Inquiry
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/06/17
 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.bcm.sup.valuemanage.util.ConstantMgr"%>
<%@ page import="com.clt.apps.opus.vop.scg.dangerouscargorestriction.carrierrestriction.event.VopScg0010Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopScg0010Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.DangerousCargoRestriction.CarrierRestriction");
    String pCrr_cd             = "";
    String pImdg_clss_cd       = "";
    String pImdg_clss_cd_desc  = "";
    String pImdg_un_no         = "";
    String pImdg_un_no_seq     = "";    
    String pPrp_shp_nm         = "";
    String pSearchMethod       = "";
    
    String pop_yn       = "";
    
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopScg0010Event)request.getAttribute("Event");
		pCrr_cd            = event.getPCrrCd();
		pImdg_clss_cd      = event.getPImdgClssCd();  
		pImdg_clss_cd_desc = event.getPImdgClssCdDesc(); 
		pImdg_un_no        = event.getPImdgUnNo();  
		pImdg_un_no_seq    = event.getPImdgUnNoSeq();		
		pPrp_shp_nm        = event.getPPrpShpNm();	
		pSearchMethod      = event.getPSearchMethod();	
		
		if("".equals(pImdg_un_no)){
			pSearchMethod = "class";
		}else{
			pSearchMethod = "unno";
		}
		
		pop_yn      = request.getParameter("pop_mode")==null?"N":"Y";
		
		//System.out.println("==========================>"+pop_yn);
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// add logic data extracting from server when loading initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
<%=ConstantMgr.getCompanyCodeToJS()%>
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		
		var doc = document.all;	
		if(document.form.pCrr_cd.value != ""){
		     ComScgMainToMakePopup();
		     //document.all.closeBtnLayer.style.display = "";
		}
		
		loadPage();
		
	}
</script>
</head>

<form name="form">

<%// if("".equals(pCrr_cd)) { %>

<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="pCrr_cd"            value="<%=pCrr_cd %>"        >
<input type="hidden" name="pImdg_clss_cd"      value="<%=pImdg_clss_cd %>"  >
<input type="hidden" name="pImdg_clss_cd_desc" value="<%=pImdg_clss_cd_desc %>">
<input type="hidden" name="pImdg_un_no"        value="<%=pImdg_un_no %>"    >
<input type="hidden" name="pImdg_un_no_seq"    value="<%=pImdg_un_no_seq %>">
<input type="hidden" name="pPrp_shp_nm"        value="<%=pPrp_shp_nm %>"    >
<input type="hidden" name="pSearchMethod"      value="<%=pSearchMethod %>"  >

<% if (pop_yn=="Y") { %>
<div class="layer_popup_title">
	<div class="page_title_area clear">
	<h2 class="page_title"><span>Vessel Operator's Restriction on DG - Inquiry</span></h2>
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" 		id="btn_Retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_New" 			id="btn_New">New</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_DownExcel" 			id="btn_DownExcel">Down Excel</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_Close" style="display:yes"			id="btn_Close">Close</button>			
	</div>
	<!-- opus_design_btn(E) -->
	</div>
</div>
<%}else{%>
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" 		id="btn_Retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_New" 			id="btn_New">New</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_DownExcel" 			id="btn_DownExcel">Down Excel</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_Close" style="display:none"			id="btn_Close">Close</button>			
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
	
</div>
<%}%>

<% if (pop_yn=="Y") { %><div class="layer_popup_contents"><%}%>
<!-- page_title_area(E) -->
<!-- wrap_search(S) -->
<div class="wrap_search">
<!-- opus_design_inquiry(S) -->
<div class="opus_design_inquiry wFit">
	<table>
		<tbody>
			<colgroup>
				<col width="100" />
				<col width="360" />
				<col width="40" />
				<col width="80" />
				<col width="*" />
			</colgroup>
			<tr>
				<th>Vessel Operator</th>
				<td><input type="text" style="width:60px;ime-mode:disabled" name='crr_cd' id="crr_cd"  dataformat='enguponly' caption='Vessel Operator' required  maxlength=3 minlength=3  class="input1" value="" onkeyup="javascript:obj_keyup();"><button type="button" id="srch_crr_cd" onclick="img_click()" name="srch_crr_cd" class="input_seach_btn"></button><input type="text" style="width:250px;" name='crr_nm' id='crr_nm' readonly class="input2" value=""></td>
				<th>Option</th>
				<td class="wrap_search_tab"><input type="radio" value='class' name='optclass' id="optclass" class="trans" checked>&nbsp;Class&nbsp;&nbsp;<input type="radio"  name='optclass' id="optclass"  value='unno' class="trans">&nbsp;UN No.</td>
				<td></td>
			</tr>	
		</tbody>
	</table>
	<table>
		<tbody>
			<colgroup>
				<col width="100" />
				<col width="*" />
			</colgroup>
			<tr>
				<th>Class</th>
				<td width="" colspan="3">
					<script type="text/javascript">ComComboObject('combo_imdg_clss_cd', 2, 60, 0);</script><input type="text" style="width:800px;" class="input2" readonly  name='imdg_clss_cd_desc' id='imdg_clss_cd_desc' >
				</td>
			</tr>
			<tr>
				<th>UN No./Seq.</th>
				<td colspan="3"><input type="text" style="width:60px;ime-mode:disabled" dataformat='num' name='imdg_un_no' id='imdg_un_no' class="input" maxlength='4' fullfill caption='UN No.'  value="" onkeyup="javascript:obj_keyup();"><input type="text" style="width:40px;" name='imdg_un_no_seq' value=""  dataformat='engup' minlength=1 onKeyPress="ComKeyOnlyNumber(this)" readOnly><button type="button" id="srch_imdg_un_no" name="srch_imdg_un_no" class="input_seach_btn"></button><input type="text" style="width:727px;" class="input2" name='prp_shp_nm' svalue="" readonly></td>					
			</tr>
		</tbody>
	</table>
</div>
<!-- opus_design_inquiry(E) -->
</div>
<!-- wrap_search(E) -->

<!-- wrap_result(S) -->
<div class="wrap_result">
<div id='div_s1'>
<h3 class="title_design">Restrictions on Class</h3>	
<!-- opus_design_grid(S) -->
<div class="opus_design_grid">
	<script type="text/javascript">ComSheetObject('sheet1');</script>
</div>
<!-- opus_design_grid(E) -->
<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
	<table>
		<tbody>
			<colgroup>
				<col width="980" />
				<col width="*" />
			</colgroup>
			<tr>
			<td><textarea style="height:70px;width:980px;resize: none;"  name='crr_regu_desc_class' id="crr_regu_desc_class"></textarea></td>
			<td></td>
			</tr>		
		</tbody>
	</table>
</div>
<!-- opus_design_inquiry(E) -->
</div>
<div id='div_s2' style='display:none'>
<h3 class="title_design">Restrictions on UN No.</h3>	
<!-- opus_design_grid(S) -->
<div class="opus_design_grid">
	<script type="text/javascript">ComSheetObject('sheet2');</script>
</div>
<!-- opus_design_grid(E) -->
<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
	<table>
		<tbody>
			<colgroup>
				<col width="980" />
				<col width="*" />
			</colgroup>
			<tr>
			<td><textarea style="height:70px;width:980px;resize:none;"  name='crr_regu_desc_unno' id="crr_regu_desc_unno"></textarea></td>
			<td></td>
			</tr>		
		</tbody>
	</table>
</div>
<!-- opus_design_inquiry(E) -->
</div>
</div>
<!-- wrap_result(E) -->
				
<% if (pop_yn=="Y") { %></div><%}%>
</form>