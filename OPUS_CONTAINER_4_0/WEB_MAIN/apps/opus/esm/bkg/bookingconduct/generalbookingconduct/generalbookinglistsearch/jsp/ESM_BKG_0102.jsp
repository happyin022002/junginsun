<%
/*=========================================================
* * *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0102.jsp
*@FileTitle  :  Compulsory Firm
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/04
=========================================================*/
%>                                        

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.event.EsmBkg0102Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List" %>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO" %>
<%@ page import="com.clt.apps.opus.esm.bkg.common.*" %>
<%@ page import="com.clt.framework.core.controller.DefaultViewAdapter"%>

<%
	EsmBkg0102Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from the server	
	String strErrMsg = "";						//error messege
	int rowCount	 = 0;						//the number of DB ResultSet List

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String sXml      = "";	
	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.GeneralBookingConduct.GeneralBookingListSearch");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0102Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}		
		
		//  extract additional data obtained from the server during Initial loading ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		DefaultViewAdapter adapter = new DefaultViewAdapter();
		sXml = adapter.makeXML(request, response);		

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
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="sXml"  id="sXml" value = "<%=sXml%>">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">		
		<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--  
		--><button type="button" class="btn_normal" name="btn_New" id="btn_New">New</button><!--  
		--><button type="button" class="btn_normal" name="btn_CompulsoryFirm" id="btn_CompulsoryFirm">Compulsory Firm</button><!--  
		--><button type="button" class="btn_normal" name="btn_Firm" id="btn_Firm">Waiting&nbsp;->&nbsp;Firm</button><!--  
		--><button type="button" class="btn_normal" name="btn_Waiting" id="btn_Waiting">Firm&nbsp;->&nbsp;Waiting</button>						
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">		
				<table> 
					<colgroup>
						<col width="100px">
						<col width="1px">
						<col width="1px">
						<col width="1px">
						<col width="1px">
						<col width="1px">
						
						<col width="115px">
						<col width="70px">
						<col width="1px">
						<col width="70px">
						<col width="1px">
						<col width="70px">
						<col width="1px">
						<col width="70px">
						<col width="80px">
						<col width="*">
					</colgroup>
					<tr class="h23">
						<th title="Vessel Voyage Direction">VVD</th>
						<td><input type="text" name="bkg_vvd_cd" id="bkg_vvd_cd" class="input1" tabindex="1" style="width:80px;ime-mode:disabled" value="" maxlength=9 dataformat="engup" onkeydown="bkg0102_keydown();">
						<td><input type="radio" name="vsl_pre_post_cd" id="vsl_pre_post_cd" tabindex="2" value="T" class="trans" checked></td>
						<th>Trunk</th>
						<td><input type="radio" name="vsl_pre_post_cd" id="vsl_pre_post_cd" value="1" class="trans"></td>
						<th>1st</th>
						<th title="Port of Loading">POL</th>
						<td><input type="text" name="pol_cd" id="pol_cd" tabindex="3" style="width:100%;ime-mode:disabled" value="" class="input" maxlength=5 dataformat="engup" onkeydown="bkg0102_keydown();"></td>
						<th title="Port of Discharging">POD</th>
						<td><input type="text"  name="pod_cd" id="pod_cd" tabindex="4" style="width:100%;ime-mode:disabled" value="" class="input" maxlength=5 dataformat="engup" onkeydown="bkg0102_keydown();"></td>
						<th>Rep. CMDT</th>
						<td><input type="text" name="rep_cmdt" tabindex="5" id="rep_cmdt" style="width:100%;ime-mode:disabled" value="" class="input" maxlength=4 dataformat="num" onkeydown="bkg0102_keydown();"></td>
						<th>B.OFC</th>
						<td><input type="text" name="bkg_ofc_cd" tabindex="6" id="bkg_ofc_cd"  style="width:100%;ime-mode:disabled" value="" class="input" maxlength=6 dataformat="engup" onkeydown="bkg0102_keydown();"></td>
						<th>S.OFC</th>
						<td><input type="text"  name="ob_sls_ofc_cd" tabindex="7" id="ob_sls_ofc_cd" style="width:70px;ime-mode:disabled" value="" class="input" maxlength=6 dataformat="engup" onkeydown="bkg0102_keydown();"></td>
					</tr>
				</table>
				
				<table> 
					 <colgroup>
						<col width="100px">
						<col width="200px">
						<col width="1px">
						<col width="450px">
						<col width="1px">						
						<col width="*">
					</colgroup>					
					<tr class="h23">						
						<th>Shipper Code</th>
						<td><input type="text" name="s_cust_cnt_cd" id="s_cust_cnt_cd"  class="input" style="width:30px;ime-mode:disabled" value="" maxlength=2 dataformat="engup" onBlur="deactivateNew(this);"><!-- 
						 --><input type="text" name="s_cust_seq" id="s_cust_seq"  class="input" style="width:131px" value="" maxlength=6 dataformat="num" onBlur="if(this.value!=''){this.value=ComLpad(this, 6, '0');deactivateNew(this);}"></td>
						<th>Name</th>
						<td><input type="text" name="s_cust_nm" id="s_cust_nm" style="width:370px" value="" class="input" maxlength=50></td>
						<th>BKG STS</th>
						<td><script type="text/javascript" >ComComboObject('bkg_sts_cd', 2, 40, 1, 0, 0)</script>
						</td>
					</tr>					
				<tr class="h23">
						<th>FWDR Code</th>
						<td><input type="text" name="f_cust_cnt_cd" id="f_cust_cnt_cd"  class="input" style="width:30px;ime-mode:disabled" value="" maxlength=2 dataformat="engup" onBlur="deactivateNew(this);"><!-- 
						 --><input type="text" name="f_cust_seq" id="f_cust_seq"  class="input" style="width:131px" value="" maxlength=6 dataformat="num" onBlur="if(this.value!=''){this.value=ComLpad(this, 6, '0');deactivateNew(this);}"></td>												
						<th>Name</th>
						<td><input type="text" name="f_cust_nm" id="f_cust_nm"  style="width:370px" value=" " class="input" maxlength=50></td>
					</tr>
						<tr class="h23">
						<th>Booking No.</th>
						<td><input type="text" name="bkg_no" id="bkg_no"  class="input1" style="width:166px;ime-mode:disabled" value="" maxlength=13 dataformat="engup" onkeydown="bkg0102_keydown();"></td>
						<th>Booking Period</th>
						<td>																	
						<span class="inquiry_calendar">
					       <input type="text" name="s_bkg_cre_dt" id="s_bkg_cre_dt"  style="width:80px" value="" class="input1" maxlength=10 dataformat="ymd" onBlur="deactivateNew(this);">					       
					       <span class="dash">-</span>
					       <input type="text" name="e_bkg_cre_dt" id="e_bkg_cre_dt"  style="width:80px" value="" class="input1" maxlength=10 dataformat="ymd" onBlur="deactivateNew(this);"><!-- 
					        --><a href="#" id="btns_Calendar" name="btns_Calendar"  class="calendar ir">calendar</a>
				      	</span>						
					</tr>
				</table>								
		</div>
<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
<!-- opus_design_grid(E) -->
</div>
</form>
