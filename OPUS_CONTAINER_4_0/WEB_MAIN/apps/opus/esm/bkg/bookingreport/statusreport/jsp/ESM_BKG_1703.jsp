<%
/*=========================================================
 *Copyright(c) 2015 CyberLogitec
 *@FileName : ESM_BKG_1703.jsp
 *@FileTitle  : Booking Loading Report
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2015/01/29
 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingreport.statusreport.event.EsmBkg1703Event"%>	
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg1703Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //error from the server		
	String strErrMsg = ""; //error messege
	int rowCount = 0; //the number of DB ResultSet List

	String successFlag = "";
	String codeList = "";
	String pageRows = "50";

	String strUsr_id = "";
	String strUsr_nm = "";
	boolean bBtn_Disabled = true;
	Logger log = Logger.getLogger("com.clt.apps.opus.esm.bkg.bookingreport.statusreport");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg1703Event) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException)
					.loadPopupMessage();
		}

		// extract additional data obtained from the server during Initial loading ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request
				.getAttribute("EventResponse");

	} catch (Exception e) {
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
<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->		

	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Direct_Retrieve" id="btn_Direct_Retrieve">Direct Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_Sort" id="btn_Sort" style="display:none">Sort</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_New" id="btn_New">New</button>
	</div>
	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
	
</div>
<!-- page_title_area(E) -->
<div class="wrap_result">
	
	<div class="opus_design_inquiry" >
		<form method="post" name="tempform" onSubmit="return false;">  	
			<table style="width:550px" >
				<colgroup>
					<col width="90" />
					<col width="250" />
				</colgroup>
				<tbody>
				   <tr>
				   		<th >Report Type</th>
						<td><script  type="text/javascript">ComComboObject('report_type', 1, 240, '');</script><button type="button" class="btn_etc" name="btn_ReportTemplate"	id="btn_ReportTemplate">Report Template</button></td>							
					</tr>	
				</tbody>
			</table>
		</form>	
	</div>			
		
<form method="post" name="form" id="mainform" onSubmit="return false;">
	<input type="hidden" name="f_cmd"/>
	<input type="hidden" name="p_bkg_rpt_knd_cd" 	value="D">
	<input type="hidden" name="rpt_id">	
	<input type="hidden" name="orderby">
		<div class="opus_design_inquiry">
			<div class="layout_wrap mar_top_12">
				<div class="layout_vertical_2" style="width:100%;">
					<div class="opus_design_data sm" style="height:150px;">
						<table>
						<colgroup>
							<col width="60" />
							<col width="250" />
							<col width="80" />
							<col width="132" />
							<col width="60" />
							<col width="150" />
							<col width="60" />
							<col width="*" />
						</colgroup>						
						<tr>
							<th>VVD</th>
							<td><input type="text" style="IME-MODE: disabled; WIDTH: 90px" class="input1" name="vvd_cd" value="" maxlength="9" id="vvd_cd" dataformat="engup"/> Trunk <input type="checkbox" class="trans" name="trunk_flag" value="Y"></td>
							<th>Lane</th>
							<td><input type="text" style="width:80px;" class="input" name="lane_cd" value="" maxlength="3" id="lane_cd" dataformat="engup" /> </td>
							<th>Dir</th>
							<td><script type="text/javascript">ComComboObject('dir_cd', 1, 57, '');</script></td>
							<th>Cargo Type</th>
							<td><script type="text/javascript">ComComboObject('bkg_cgo_tp_cd', 2, 100, '');</script></td>								
						</tr> 
						<tr>
							<th>POL</th>
							<td><input type="text" style="IME-MODE: disabled; WIDTH: 80px" value="" name="pol_cd" maxlength="5"  class="input" id="pol_cd"  dataformat="engup"/>  <input type="text" style="IME-MODE: disabled; width:35px;" value="" class="input" name="pol_yard_cd" maxlength="2"  id="pol_yard_cd" dataformat="engup" />(<input type="checkbox" class="trans" name="pol_local" value="Y" id="pol_local" />Local<input type="checkbox" class="trans" name="pol_ts" value="Y" id="pol_ts"/>T/S)</td>
							<th title="Port of Discharging">POD</th>
							<td colspan="3"><input type="text" style="IME-MODE: disabled; WIDTH: 80px" value="" name="pod_cd" maxlength="5" class="input" id="pod_cd"  dataformat="engup" />  <input type="text" style="IME-MODE: disabled; WIDTH: 35px" value="" class="input" name="pod_yard_cd" maxlength="2" id="pod_yard_cd" dataformat="engup" />(<input type="checkbox" class="trans" name="pod_local" value="Y" id="pod_local" />Local<input type="checkbox" class="trans" name="pod_ts" value="Y" id="pod_ts" />T/S)</td>
							<th>EQ TP/SZ</th>
							<td><script type="text/javascript">ComComboObject('eq_type', 1, 100, '');</script></td>
						</tr> 
						 <tr>
							<th>POR</th>
							<td><input type="text" style="IME-MODE: disabled; WIDTH: 80px" class="input" name="por_cd" maxlength="5" value="" id="por_cd"  dataformat="engup" /><strong>DEL </strong><input type="text" style="IME-MODE: disabled; WIDTH: 80px" class="input" name="del_cd" id="del_cd" maxlength="5" value="" dataformat="engup"></td>
							<th>R/D Term</th>
							<td colspan="3"><script type="text/javascript">ComComboObject('r_term', 1, 123, 1);</script><script type="text/javascript">ComComboObject('d_term', 1, 123, 1);</script></td>
							<th>SCC</th>
							<td><input type="text" style="width:100px;" class="input" maxlength="5" dataformat="engup" name="ecc_cd" value="" id="ecc_cd" /></td>
						</tr> 					
					</table>
					<table>
						<colgroup>
							<col width="30" />
							<col width="100" />
							<col width="*" />
						</colgroup>	
						<tr>
							<td>&nbsp;</td>								
							<th style="text-align:left;">BKG Office</th>
							<td><input type="text" style="IME-MODE: disabled; WIDTH: 115px" class="input" name="bkg_ofc_cd" maxlength="6"  dataformat='engup' value="" id="bkg_ofc_cd" /></td>
						</tr>
						<tr>
							<td>&nbsp;</td>	
							<th style="text-align:left;">Booking Status</th>
							<td><script type="text/javascript">ComComboObject('bkg_sts_cd', 2, 115, '' );</script></td>
						</tr>	
					</table>
					</div>																				
			    </div>
			</div>
		</div>
			<!-- layout_wrap(E) -->						
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear"  name="downSheet_options" id="downSheet_options" style="display:none">
		<script  type="text/javascript">ComSheetObject('search_options');</script>
	</div>
	<!-- opus_design_grid(E) -->
				
</form>

</div>