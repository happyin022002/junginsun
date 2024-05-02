<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_0143.jsp
*@FileTitle  : Invoice Creation File Import Pop Up
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/13
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.mnr.accountmanage.expensemgt.event.EesMnr0143Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMnr0143Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//count of DB resultSet list

	//Variable for existing logic
 	String vndrSeq = ((request.getParameter("vndr_seq")==null )?"":request.getParameter("vndr_seq"));
 	String woOfcCd = ((request.getParameter("wo_ofc_cd")==null )?"":request.getParameter("wo_ofc_cd"));

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	String strVndr_seq		= "";
	String strVndr_nm		= "";
	String strAccess_system		= "";

	Logger log = Logger.getLogger("com.clt.apps.accountmanage.expensemgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		strVndr_seq = account.getOfc_eng_nm();
		strVndr_nm 	= account.getOfc_krn_nm();
		strAccess_system = account.getAccess_system();

		event = (EesMnr0143Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		//adding logic to get data from sever when first loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	var currOfcCd = '<%=strOfc_cd %>';
	var woOfcCd = '<%=woOfcCd %>';
	var vndrSeq = '<%=vndrSeq %>';
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
<input type="hidden" name="strAccess_system" value="<%= strAccess_system%>" id="strAccess_system" />
<input type="hidden" name="strVndr_seq" value="<%= strVndr_seq%>" id="strVndr_seq" />
<input type="hidden" name="strVndr_nm" value="<%= strVndr_nm%>" id="strVndr_nm" />

<!-- page_title_area(S) -->
<div class="layer_popup_title">
	<div class="page_title_area clear">
   		<!-- page_title(S) -->
		<h2 class="page_title"><span>M&R Invoice Creation File Import</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn"><!-- 
			 --><button type="button" class="btn_accent" name="btn_new" id="btn_new">New</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_downExcel"  	id="btn_downExcel">Format Down Excel</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_loadExcel" 	id="btn_loadExcel">Load Excel</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_ok" 	id="btn_ok">OK</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_close" 	id="btn_close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->
	</div>
</div>
<!-- page_title_area(E) -->

<div class="layer_popup_contents">
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="50">
					<col width="*">
				</colgroup>
				<tbody>
					<tr>
						<th>S/Provider</th>
						<td width=""><input type="text" name="vndr_seq" style="width:82px" class="input2" dataformat="num" readOnly value="<%=vndrSeq%>"><!-- 
						 --><script type="text/javascript">ComComboObject('combo1', 7, 170, 1, 1,0,false,1);</script></td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>
	
	<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<!-- opus_design_btn(S) -->
			<div class="opus_design_btn"><!-- 
				 --><button type="button" class="btn_accent" name="btn_Save" id="btn_Save">Verify</button><!-- 
				 --><button type="button" class="btn_normal" name="btn_RowAdd"  	id="btn_RowAdd">Row Add</button><!-- 
				 --><button type="button" class="btn_normal" name="btn_RowDel" 	id="btn_RowDel">Row Delete</button> 
			</div>
			<!-- opus_design_btn(E) -->
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<!-- opus_design_grid(S) -->
		<div class="opus_design_data">
			<h3 class="title_design mar_btm_8">Damage Flagging/Unflagging File Format</h3>
			<table class="grid_2 wAuto">
				<colgroup>
					<col width="200" />
					<col width="200" />					
				</colgroup>
				<tbody>
					<tr>
						<th>W/O No</th>
						<th>G.Amount</th>
					</tr>
					<tr>
						<td align="center">SEL018</td>
						<td align="center">2000</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>
</form>