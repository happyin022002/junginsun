<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0668_07.jsp
*@FileTitle  :  In-bound C/S Screen US
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.event.EsmBkg066806Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg066806Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//DB ResultSet List count
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfcCd         = "";
	Logger log = Logger.getLogger("com.clt.apps.CsScreenMgtSC.CsScreenBC");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfcCd  = account.getOfc_cd();
	   
		event = (EsmBkg066806Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// getting data from server when load the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script language="javascript">
	var strUsr_id    = "<%=strUsr_id%>";
	var lginOfcCd    = "<%=strOfcCd %>";

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if

		loadPage();
	}
</script>
</head>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<input type='hidden' name ='xmlData' value = "">
<input type='hidden' name ='bl_no' value = "<%=JSPUtil.getNull(request.getParameter("bl_no"))%>">
<input type='hidden' name ='bkg_no' value = "<%=JSPUtil.getNull(request.getParameter("bkg_no"))%>">
<input type='hidden' name ='h_mrd_id' value = "">
<input type='hidden' name ='h_local_lang_flg' value = "">

<input type="hidden" name="com_mrdPath" value="">
<input type="hidden" name="com_mrdArguments" value="">
<input type="hidden" name="com_mrdTitle" value="">
<input type="hidden" name="com_mrdDisableToolbar" value=""> 
<input type="hidden" name="com_mrdBodyTitle" value="">

<div class="wrap_result">

	<div class="opus_design_btn">
		<button type="button" class="btn_normal" name="btn_t6Preview" id="btn_t6Preview">Preview</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_t6Master" id="btn_t6Master">Master Data</button><!--
		 --><button type="button" class="btn_normal" name="btn_t6SendAn" id="btn_t6SendAn">Send A/N</button><!--
		 --><button type="button" class="btn_normal" name="btn_t6AnTemplate" id="btn_t6AnTemplate">A/N Template</button><!--
		 --><button type="button" class="btn_normal" name="btn_t6SendOBl" id="btn_t6SendOBl">Send O.B/L</button>
	</div>
	
	<div class="opus_design_inquiry wFit">
		<table style="width: 979px;">
			<colgroup>
				<col width="110px" />
				<col width="110px" />
				<col width="40px" />
				<col width="315px" />
				<col width="40px" />
				<col width="*" />
			</colgroup>
			<tbody>
				<tr class="h23">
					<th>Consignee Code</th>
					<td>
						<input type="text" style="width:90px;" class="input2" value="" id="frm_t6sheet1_cust_cd_c" name="frm_t6sheet1_cust_cd_c" readonly="true">
					</td>
                    <th>
                    	Name
                    </th>
                    <td>
                    	<input type="text" style="width:180px;" class="input2" value="" id="frm_t6sheet1_cust_nm_c" name="frm_t6sheet1_cust_nm_c" readonly="true">
                    </td>
                    <th>Address</th>
                    <td>
                    	<input type="text" style="width:100%;" class="input2" value="" id="frm_t6sheet1_cust_addr_c" name="frm_t6sheet1_cust_addr_c" readonly="true">
                    </td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('t6sheet1');</script>
		<script type="text/javascript">ComSheetObject('t6sheet2');</script>
	</div>
	
	<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
	
	
	<div class="opus_design_inquiry wFit">
		<table style="width: 979px;">
			 <colgroup>
				<col width="110px" />
				<col width="110px" />
				<col width="40px" />
				<col width="315px" />
				<col width="40px" />
				<col width="*" />
			</colgroup>
			<tbody>
				<tr class="h23">
					<th>Notify Code</th>
					<td>
						<input type="text" style="width:90px;" class="input2" value="" id="frm_t6sheet1_cust_cd_n" name="frm_t6sheet1_cust_cd_n" readonly="true">
					</td>
                    <th>
                    	Name
                    </th>
                    <td>
                    	<input type="text" style="width:180px;" class="input2" value="" id="frm_t6sheet1_cust_nm_n" name="frm_t6sheet1_cust_nm_n" readonly="true">
                    </td>
                    <th>
                    	Address
                    </th>
                    <td>
                    	<input type="text" style="width:100%;" class="input2" value="" id="frm_t6sheet1_cust_addr_n" name="frm_t6sheet1_cust_addr_n" readonly="true">
                    </td>
				</tr>
			</tbody>
		</table>
	</div>
	
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('t6sheet3');</script>
	</div>

	 <table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
	 
	<div class="opus_design_inquiry wFit">
		<table style="width: 979px;">
			<colgroup>
				<col width="110px" />
				<col width="110px" />
				<col width="110px" />
				<col width="*" />
			</colgroup>
			<tbody>
				<tr class="h23">
					<th>A. Notify Code</th>
					<td>
						<input type="text" style="width:70px;" class="input2" value="" id="frm_t6sheet1_cust_cd_a" name="frm_t6sheet1_cust_cd_a" readonly="true">
					</td>
					<th>
						Name & Address
					</th>
					<td>
						<input type="text" style="width:100%;" class="input2" value="" id="frm_t6sheet1_cust_nm_a" name="frm_t6sheet1_cust_nm_a" readonly="true">
					</td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
</form>
