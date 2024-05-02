<%
/*=========================================================
 *Copyright(c) 2015 CyberLogitec
 *@FileName : ESM_BKG_1706.jsp
 *@FileTitle  : OPUSADM
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
<%@ page import="com.clt.apps.opus.esm.bkg.bookingreport.statusreport.event.EsmBkg1706Event"%>	
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg1706Event event = null; //PDTO(Data Transfer Object including Parameters)
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

		event = (EsmBkg1706Event) request.getAttribute("Event");
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

	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		    <button type="button" class="btn_accent" name="btn_Direct_Retrieve" id="btn_Direct_Retrieve">Direct Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_Sort" 			id="btn_Sort" style="display:none">Sort</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_New" 			id="btn_New">New</button>
	</div>
	<!-- opus_design_btn(E) -->
	
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
	<input type="hidden" name="p_bkg_rpt_knd_cd" 	value="F">
	<input type="hidden" name="rpt_id">				
	<input type="hidden" name="orderby">
			<!-- layout_wrap(S) -->
			<div class="opus_design_inquiry">
			<div class="layout_wrap mar_top_12">
				<div class="layout_vertical_2" style="width:100%;">
					<div class="opus_design_data sm" style="height:150px;">
						<table>
							<colgroup>
								<col width="80" />
								<col width="150" />
								<col width="100" />
								<col width="150" />
								<col width="148" />
								<col width="150" />
								<col width="100" />
								<col width="*" />
							</colgroup>	
							<tr>
								<th>VVD</th>
								<td colspan="7"><input type="text" style="IME-MODE: disabled; WIDTH: 90px" class="input1" name="vvd_cd" value="" maxlength="9" id="vvd_cd" dataformat="engup" /></td>
							</tr>
							<tr>
								<th>POL</th>
								<td><input type="text" style="IME-MODE: disabled; WIDTH: 90px" value="" name="pol_cd" maxlength="5" class="input" id="pol_cd"  dataformat="engup"/>(<input type="checkbox" class="trans" name="pol_local" value="Y" id="pol_local" />Local)</td>
								<th>POD</th>
								<td colspan="5"><input type="text" style="IME-MODE: disabled; WIDTH: 90px" value="" name="pod_cd" maxlength="5" class="input" id="pod_cd"  dataformat="engup" />(<input type="checkbox" class="trans" name="pod_local" value="Y" id="pol_local" />Local)</td>
							</tr>	
							<tr>
								<th>POR</th>
								<td><input type="text" style="IME-MODE: disabled; WIDTH: 90px" value="" name="por_cd" maxlength="5" class="input" id="por_cd"  dataformat="engup"/></td>
								<th>DEL</th>
								<td><input type="text" style="IME-MODE: disabled; WIDTH: 90px" value="" name="del_cd" maxlength="5" class="input" id="del_cd"  dataformat="engup" /></td>
								<th>Sales Office</th>
								<td><input type="text" style="IME-MODE: disabled; WIDTH: 90px;" name="ob_sls_ofc_cd"  value="" class="input" style="ime-mode:disabled" dataformat="enguponly" caption="Sales Office" maxlength="6"  fullfill></td>
								<th>Booking Office</th>
								<td><input type="text" style="IME-MODE: disabled; WIDTH: 90px;" name="bkg_ofc_cd"  value="" class="input" style="ime-mode:disabled" dataformat="enguponly" caption="Booking Office" maxlength="6"  fullfill></td>
																
							</tr>
							<tr>
								<th>Trade</th>
								<td><script language="javascript">ComComboObject('trd_cd', 1, 90, "");</script></td>
								<th>Freight Charge Type</th>
								<td><script type="text/javascript">ComComboObject('frt_chg_tp_cd', 2, 90, "");</script></td>
								<td colspan="4"><input type="radio" name="sc_rfa_gbn" id="sc_rfa_gbn_sc" value="S" checked><label for="sc_rfa_gbn_sc">S/C</label><!-- 
											 --><input type="radio" name="sc_rfa_gbn" id="sc_rfa_gbn_rfa" value="R"><label for="sc_rfa_gbn_rfa">RFA</label><!--
											 --><input type="radio" name="sc_rfa_gbn" id="sc_rfa_gbn_taa" value="T"><label for="sc_rfa_gbn_taa">TAA</label>
												<input type="text" 	name="sc_rfa_no"  id="sc_rfa_no" 	class="input" value="" style="width:90px;" maxlength="11" dataformat="engup">
								</td>							
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