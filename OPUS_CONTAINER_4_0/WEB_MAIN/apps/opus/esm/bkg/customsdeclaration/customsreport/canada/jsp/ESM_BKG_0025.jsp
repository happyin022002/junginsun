<%/*=========================================================
*Copyright(c) 2014 CyberLogitec All Rights Reserved
*@FileName : ui_bkg_0025.jsp
*@FileTitle : ACI_Vessel Information
*@author : CLT
*@version : 1.0
*@since : 2014.04.24
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.canada.event.EsmBkg0025Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0025Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//occurring error in server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//list count of DB resultSet 

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.ManifestListDownload");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		event = (EsmBkg0025Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		//When initial screen loading, adding logic extrat data obtained from the server.
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
	
%>

<script  type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form" method="post">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="ofc_cd" value="<%=strOfc_cd%>" id="ofc_cd" />
<input type="hidden" name="attach_flg" value="false" id="attach_flg" />
<input type="hidden" name="attach_max_cnt" value="0" id="attach_max_cnt" />

<input type="hidden" name="com_mrdPath" id="com_mrdPath" />
<input type="hidden" name="com_mrdArguments" id="com_mrdArguments" />
<input type="hidden" name="com_mrdTitle" value="Advice Notes" id="com_mrdTitle" />
<input type="hidden" name="com_mrdBodyTitle" value="Advice Notes" id="com_mrdBodyTitle" />
<input type="hidden" name="com_mrdDisableToolbar" id="com_mrdDisableToolbar" />

<!-- 제목 -->
<div class="page_title_area clear">
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->

		<!-- btn_div -->
   <div class="opus_design_btn">
		 <button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
	     --><button type="button" class="btn_normal" name="btn_Save" id="btn_Save">Save</button><!-- 
	     --><button type="button" class="btn_normal" name="btn_excel" id="btn_excel">Down Excel</button><!-- 
	     --><button type="button" class="btn_normal" name="btn_listPrint" id="btn_listPrint">List Print</button><!-- 
	     --><button type="button" class="btn_normal" name="btn_previewPrint" id="btn_previewPrint">Preview</button><!-- 
	     --><button type="button" class="btn_normal" name="btn_fax" id="btn_fax" >Fax</button><!-- 
	     --><button type="button" class="btn_normal" name="btn_mail" id="btn_mail">E-mail</button><!-- 
	     --><button type="button" class="btn_normal" name="btn_anSetup" id="btn_anSetup">Code Validate</button><!-- 
	     --><button type="button" class="btn_normal" name="btn_history" id="btn_history">History</button>
   </div>

   <!-- page_location(S) -->
   <div class="location">
		<span id="navigation"></span>
   </div>
</div>
<!-- 제목 -->

<div class="wrap_search_tab">
<!-- 검색영역 -->
<div class="opus_design_inquiry wFit">		
	<table>
			<colgroup>
		  		<col width="50"></col>
		  		<col width="120"></col>
		  		<col width="80"></col>
		  		<col width="90"></col>
		  		<col width="80"></col>
		  		<col width="120"></col>
		  		<col width="80"></col>
		  		<col width="150"></col>
		  		<col width="100"></col>
		  		<col width="*"></col>
		  	</colgroup> 			
			<tbody>
			<tr>
				<th title="Vessel Voyage Direction">VVD</th>
				<td>
					<input type="text" style="width:90px;ime-mode:disabled" class="input1" name="vvd_cd" maxlength="9" dataformat="engup" minlength="9" caption="VVD">
				</td>
				<th title="Port of Discharging">POD</th>
				<td>
					<input type="text" style="width:50px;ime-mode:disabled" class="input1" name="pod_cd" maxlength="5" dataformat="engup" minlength="5" caption="POD">
				</td>
				<th title="Place of Delivery">DEL</th>
				<td>
					<input type="text" style="width:90px;ime-mode:disabled" class="input" name="del_cd" maxlength="5" dataformat="engup" minlength="5" caption="DEL">			
				</td>			
				<th>B/L No.</th>
				<td>
					<input type="text" style="width:120px;ime-mode:disabled" class="input1" name="sch_bl_no" maxlength="12" dataformat="engup">
				</td>
				<th>Code Validate</th>
				<td>
					<select name="mtch_flg" style="width:100px">
						<option value="">All</option>
						<option value="Y">Yes</option>
						<option value="N">No</option>
					</select>
				</td>
			</tr> 
		</tbody>
	</table>
</div>
<!-- 검색영역 -->
</div>

<div class="wrap_result">
<!-- opus_tab_btn(E) -->
	<div class="opus_design_tab">
			<script  type="text/javascript">ComTabObject('tab1')</script>
	</div>
<!-- opus_tab_btn(E) -->

<div class="opus_design_grid">	
	<div class="opus_design_btn">
	   <button type="button" class="btn_normal" name="btn_arrival" id="btn_arrival">Arrival Info.</button>
	</div>
	<script  type="text/javascript">ComSheetObject('sheet1');</script>
</div>
</div>
<!-- 시트영역 -->

</form>
