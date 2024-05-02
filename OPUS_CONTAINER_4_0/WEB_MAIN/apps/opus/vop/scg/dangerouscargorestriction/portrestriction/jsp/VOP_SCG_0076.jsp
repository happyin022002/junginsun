<%
/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : VOP_SCG_0076.jsp
 *@FileTitle : DG Prohibition Summary by Port - Inquiry
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
<%@ page import="com.clt.apps.opus.vop.scg.dangerouscargorestriction.portrestriction.event.VopScg0076Event"%>
<%@ page import="org.apache.log4j.Logger"%>
<%
	VopScg0076Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.DangerousCargoRestriction.PortRestriction");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopScg0076Event)request.getAttribute("Event");
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
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" 		id="btn_retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_new" 			id="btn_new">New</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_Excel" 			id="btn_Excel">Down Excel</button>			
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
	
</div>
<!-- page_title_area(E) -->
<!-- wrap_search(S) -->
<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<tbody>
				<colgroup>
					<col width="70" />
					<col width="330" />
					<col width="10" />
					<col width="10" />
					<col width="*" />
				</colgroup>
				<tr>
					<th>Port Code</th>
					<%--<td><input type="text" style="width:60px;ime-mode:disabled" class="input1" name='port_cd' id='port_cd' dataformat='enguponly' fullfill  caption='Port Code' required maxlength=5 value="" onkeyup="obj_keyup();"><button type="button" id="srch_port_cd" onclick="img_click()" name="srch_port_cd" class="input_seach_btn"></button><input type="text" style="width:200px;" class="input2" name='port_cd_nm' id='port_cd_nm' value=""></td> --%>
					<td><input type="text" style="width:60px;ime-mode:disabled" class="input1" name='port_cd' id='port_cd' required dataformat='engup' maxLength=5 fullfill caption='Port Code' value=""><button type="button" id="srch_port_cd" name="srch_port_cd" class="input_seach_btn"></button><input type="text" style="width:200px;"  readonly class="input2" name='port_cd_nm' value=""></td>
					<th>Option</th>
					<td class="wrap_search_tab"><input type="radio" value='class' name='optclass' class="trans" checked  >&nbsp;Class&nbsp;&nbsp;<input type="radio"  name='optclass'  value='unno' class="trans">&nbsp;UN No.</td>
					<td></td>
				</tr>
			</tbody>
		</table>
		<table>
			<tbody>
				<colgroup>
					<col width="70" />
					<col width="100" />
					<col width="10" />
					<col width="*" />
				</colgroup>
				<tr>
					<th>Class</th>
					<td><script type="text/javascript">ComComboObject('imdg_clss_cd', 2, 60, 0, 0);</script></td>
					<th>UN No.</th>
					<td><input type="text" style="width:60px;" name='imdg_un_no' id='imdg_un_no' class="input" dataformat='eng' style="ime-mode:disabled" caption='UN No.'    fullfill   maxlength=4  value=""><button type="button" onclick="img_click()" id="srch_imdg_un_no" name="srch_imdg_un_no" class="input_seach_btn"></button></td>					
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
<!-- wrap_search(E) -->

<!-- wrap_result(S) -->
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" style="display: none;">
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
	<!-- opus_design_grid(E) -->
</div>
<!-- wrap_result(E) -->
				
</form>
