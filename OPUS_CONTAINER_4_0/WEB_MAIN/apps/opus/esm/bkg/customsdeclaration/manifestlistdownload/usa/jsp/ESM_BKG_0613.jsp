<%/*=========================================================
*@FileName   : ESM_BKG_0613.jsp
*@FileTitle  :   US Manifest Transmit(MI)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/02
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.event.EsmBkg0613Event"%><%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0613Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			// error from server
	String strErrMsg = "";						// error message
	int rowCount	 = 0;						// count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String pgmNo = request.getParameter("pgmNo");
	//out.println(pgmNo);
	Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.ManifestListDownload");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0613Event)request.getAttribute("Event");
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
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
<form name="form" method="post">
<input type="hidden" id="f_cmd" name="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="search_mtd" id="search_mtd">
<input type="hidden" name="pageNo" id="pageNo" value="<%=StringUtil.xssFilter(pgmNo)%>">
<input type="hidden" name="pagedbclick" id="pagedbclick">
 
<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_normal" name="btn_OfmGeneration" id="btn_OfmGeneration">OFM Generation</button><!-- 
		 --><button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_Delete" id="btn_Delete">Delete</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_Add_BL" id="btn_Add_BL">B/L Add</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_Edit_BL" id="btn_Edit_BL">Manifest(B/L)</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_Transmit" id="btn_Transmit">Transmit (Full)</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_Transmit_e" id="btn_Transmit_e">Transmit (Empty)</button>
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->

 <!-- wrap_search(S) -->  
<div class="wrap_search">
<!-- opus_design_inquiry (S) -->
<div class="opus_design_inquiry wFit">
			<table>
				<tbody> 
					<tr>
						<th width="40">VVD</th>
						<td width="85"><input type="text" name="vvd" id="vvd" style="width:80px;ime-mode:disabled" tabindex="1" maxlength="9" class="input1" dataformat="engup" required fullfill caption="VVD"></td>
						<th width="35">POL</th>
						<td width="65"><input type="text" name="pol"  id="pol" style="width:50px;ime-mode:disabled" tabindex="2" maxlength="5" class="<%="ESM_BKG_0613".equals(pgmNo)?"input1":"input" %>" dataformat="engup" <%="ESM_BKG_0613".equals(pgmNo)?"required":"" %> fullfill caption="POL"></td>
						<th width="30">POD</th>
						<td width="65"><input type="text" name="pod" id="pod" style="width:50px;ime-mode:disabled" tabindex="3" maxlength="5" class="<%="ESM_BKG_0613_2".equals(pgmNo)?"input1":"input" %>" dataformat="engup" fullfill caption="POD"></td>
						<th width="30">Customs</th>
						<td width="65"><input type="text" name="customs" style="width:50px;ime-mode:disabled" maxlength="5" tabindex="4" class="<%="ESM_BKG_0613_2".equals(pgmNo)?"input1":"input" %>" dataformat="engup" fullfill caption="Customs"></td>
						<th width="100">Actual Filing VVD</th>
						<td width="90"><input type="text" name="actualvvd" style="width:80px;ime-mode:disabled" class="input2" readonly></td>												
						<td width="120">
							<div class="sm">
								<table>
									<tr>
										<td width="60">
											<input type="radio" name="all_err" id="err_all" value="All" checked><label for="err_all">All</label><!-- 
											--><input type="radio" name="all_err" id="err_bl" value="err" ><label for="err_bl">Error B/L</label>
										</td>
									</tr>
								</table>						
							</div>
						</td>
						<td>
							<select name="full_empty" style="width:67px;"><!-- 
							 --><option value="F" selected>Full</option><!-- 
							  --><option value="M">Empty</option>
							</select>
						</td> 
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

<!-- wrap_result(E) -->  
<!-- wrap_result(S) -->  


<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject('sheet2');</script>
		</div>
<!-- opus_design_grid(E) -->
<!--  Total  (S) -->
	<div class="grid_option_right">
		<table class="grid2 noinput2"> 
			<tr>
				<th width="60"><strong>Total</strong></th>
				<th width="80">01 H/BL</th>								
				<td width="50"><input type="text" name="hbl01" tabindex="20" style="width:40px;text-align:right;" class="noinput2" value=""></td>
				<th width="80">01 M/BL</th>
				<td width="50"><input type="text" name="mbl01" tabindex="21" style="width:40px;text-align:right;" class="noinput2" value=""></td>
				<th width="80">02 M/BL</th>
				<td width="50"><input type="text" name="mbl02" tabindex="22" style="width:40px;text-align:right;" class="noinput2" value=""></td>
				<th width="80">03 M/BL</th>
				<td width="50"><input type="text" name="mbl03" tabindex="23" style="width:40px;text-align:right;" class="noinput2" value=""></td>
				<th width="100">B/L Total Count</th>
				<td width="50"><input type="text" name="totbl" tabindex="24" style="width:50px;text-align:right;" class="noinput2" value=""></td>				
			</tr> 
		</table>
	</div>				
<!--  Total  (E) -->

<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" style="display:none">
			<script type="text/javascript">ComSheetObject('sheet3');</script>
		</div>
<!-- opus_design_grid(E) -->
</div>
<!-- wrap_result(E) -->  
</form>
