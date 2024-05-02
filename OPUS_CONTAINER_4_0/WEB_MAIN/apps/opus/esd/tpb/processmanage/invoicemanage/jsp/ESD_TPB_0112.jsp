<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TPB_0112.jsp
*@FileTitle  : Invoice Preview 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/24
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.clt.bizcommon.util.BizComUtil"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.vo.SearchInvoiceStatusVO"%>
<%@ page import="com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.event.EsdTpb0112Event"%>
<%@ page import="com.clt.apps.opus.esd.tpb.common.TPBUtils"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdTpb0112Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	GeneralEventResponse eventResponse = null;
	Exception serverException   = null;				//Server Exception
	String strErrMsg = "";							//Error message
	int rowCount	 = 0;							//DB ResultSet list count
	
	
	List<SearchInvoiceStatusVO> list = null;
	SearchInvoiceStatusVO vo = null;
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strTrdPartyVal		= "";
	Logger log = Logger.getLogger("com.clt.apps.ProcessManage.InvoiceManage");
	
	String s_dao_n3pty_bil_tp_cd = JSPUtil.getNull(request.getParameter("s_dao_n3pty_bil_tp_cd"));
	String s_n3pty_inv_no = JSPUtil.getNull( request.getParameter("s_n3pty_inv_no") );
	String s_lnk_n3pty_inv_no = JSPUtil.getNull( request.getParameter("s_lnk_n3pty_inv_no") );
	strTrdPartyVal = JSPUtil.getNull( request.getParameter("s_trd_party_val") );
	
	if(!s_lnk_n3pty_inv_no.equals("")){
		s_n3pty_inv_no = s_lnk_n3pty_inv_no;
	}
	String s_bil_loc = ""; // JSPUtil.getNull( request.getParameter("s_bil_loc") ); 
	String s_his_seq = JSPUtil.getNull( request.getParameter("s_n3pty_inv_his_seq") ); 
	String s_final_flg = JSPUtil.getNull( request.getParameter("s_final_flg") ); // Getting value from before screen
	
	// String s_n3pty_inv_his_seq = request.getParameter("s_n3pty_inv_his_seq"); 
	// String s_n3pty_inv_rmd = request.getParameter("s_n3pty_inv_rmd"); 
	
	String s_clt_agn_flg = ""; //Collection Agency
	String s_n3pty_inv_sts_cd = ""; //ERP I/F
	// String s_n3pty_inv_rmd_yn = ""; //Invoice Version Final
	String s_erp_yn = "";
	String s_final_invoice = ""; //Final Version
	
	String s_erp_visible_flag = ""; //ERP I/F Button visable/invisible
	String s_issue_visible_flag = ""; //Issue Button visable/invisible
	String s_inquiryOnly_yn = "";
		
	String s_issue_yn = "";
	String s_erpif_yn = "";
	
	String s_is_au = "";
	
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	
	
		event = (EsdTpb0112Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
	
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	
		// Add logic information data from the server when loading the initial screen
		eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		s_erp_visible_flag = JSPUtil.getNull((String)event.getAttribute("erp_visible_flag"));
		s_issue_visible_flag = JSPUtil.getNull((String)event.getAttribute("issue_visible_flag"));
		s_inquiryOnly_yn = JSPUtil.getNull(request.getParameter("s_inquiryOnly_yn"));
		//log.debug("s_issue_visible_flag==>"+s_issue_visible_flag);
		//log.debug("s_issue_visible_flag==>"+s_issue_visible_flag);
		
		list = (List<SearchInvoiceStatusVO>)eventResponse.getRsVoList();
		
		if (eventResponse.getETCData() != null && eventResponse.getETCData().size()>0) {
			s_clt_agn_flg = eventResponse.getETCData("s_clt_agn_flg");
			s_n3pty_inv_sts_cd = eventResponse.getETCData("s_n3pty_inv_sts_cd");
			s_issue_yn = eventResponse.getETCData("s_issue_yn");
			//log.debug("s_issue_yn==>"+s_issue_yn);
			//log.debug("s_issue_yn==>"+s_issue_yn);
			s_erpif_yn = eventResponse.getETCData("s_erpif_yn");
			s_bil_loc = eventResponse.getETCData("s_bil_loc");
			
			s_is_au = eventResponse.getETCData("s_is_au");
			
			if(!s_clt_agn_flg.equals("N")){
				s_erp_yn = "_clt_agn_flg";
			}else{
				if(!s_n3pty_inv_sts_cd.equals("N")){
					s_erp_yn = "_n3pty_inv_sts_cd";
				}else{
					s_erp_yn = s_n3pty_inv_sts_cd;
				}
			}
		}
		if ( s_inquiryOnly_yn.equals("Y") ){
			s_issue_yn = "N";
			s_erpif_yn = "N";
		}
	
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script type="text/javascript" src="/opuscntr/rpt/script/common_rd.js"></script>
<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
		//_text_ChangeUpperCase(); // automatic change to uppercase 
	}
	
	var emailRnArr = new Array();
	var emailCntcInfoArr = new Array();
	var emailValidYnArr = new Array();
	var faxnoRnArr = new Array();
	var faxnoCntcInfoArr = new Array();
	var faxnoValidYnArr = new Array();
	var j = 0;
	var k = 0;

<%	
	for(int i=0; list!=null && i<list.size(); i++){
	vo = list.get(i);
		if ( vo.getInforowcount().equals("E")) { %>
				emailRnArr      [j] = "<%= vo.getRn() %>";
				emailCntcInfoArr[j] = "<%= vo.getCntcInfo()%>";
				emailValidYnArr [j] = "<%= vo.getCntcInfoValidyn().equals("Y")?"Yes":"No"%>";
				//alert(emailCntcInfoArr[j]);
				j++;
	<%  }else if ( vo.getInforowcount().equals("F")) { %>
				faxnoRnArr      [k] = "<%= vo.getRn( )%>"; 
				faxnoCntcInfoArr[k] = "<%= vo.getCntcInfo()%>"; 
				faxnoValidYnArr [k] = "<%= vo.getCntcInfoValidyn().equals("Y")?"Yes":"No"%>";
				//alert(faxnoCntcInfoArr[k]);
				k++;
	<%  }
	}%> 
/*	
//===============================================================================================	
// TEST
				emailRnArr      [j] = "2";
				emailCntcInfoArr[j] = "sunnyday40@cyberlogitec.com";
				emailValidYnArr [j] = "Yes";
				j++;
				emailRnArr      [j] = "3";
				emailCntcInfoArr[j] = "starpose@cyberlogitec.com";
				emailValidYnArr [j] = "Yes";
				j++;
				faxnoRnArr      [k] = "2";
				faxnoCntcInfoArr[k] = "0263502050";
				faxnoValidYnArr [k] = "Yes";
				k++;
//===============================================================================================
*/

</script>
<form name="form"> 
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<!-- 개발자 작업	-->

<input type="hidden" name="iPage" id="iPage" />
<input type="hidden" name="s_dao_n3pty_bil_tp_cd" value="<%=s_dao_n3pty_bil_tp_cd%>" id="s_dao_n3pty_bil_tp_cd" />
<input type="hidden" name="s_n3pty_inv_if_tp_nm" id="s_n3pty_inv_if_tp_nm" />
<input type="hidden" name="s_his_seq" value="<%=s_his_seq%>" id="s_his_seq" />
<input type="hidden" name="s_final_flg" value="<%=s_final_flg%>" id="s_final_flg" />
<input type="hidden" name="s_final_invoice" value="<%=s_final_invoice%>" id="s_final_invoice" />
<input type="hidden" name="s_contact_info" value="" id="s_contact_info" />
<input type="hidden" name="s_n3pty_inv_his_seq" value="<%=JSPUtil.getNull(request.getParameter("s_n3pty_inv_his_seq")) %>" id="s_n3pty_inv_his_seq" />
<input type="hidden" name="s_n3pty_inv_rmd_cd" value="<%=JSPUtil.getNull(request.getParameter("s_n3pty_inv_rmd_cd")) %>" id="s_n3pty_inv_rmd_cd" />

<input type="hidden" name="s_clt_agn_flg" value="<%=s_clt_agn_flg%>" id="s_clt_agn_flg" />
<input type="hidden" name="s_n3pty_inv_sts_cd" value="<%=s_n3pty_inv_sts_cd%>" id="s_n3pty_inv_sts_cd" />
<input type="hidden" name="s_issue_yn" value="<%=s_issue_yn%>" id="s_issue_yn" />
<input type="hidden" name="s_erpif_yn" value="<%=s_erpif_yn%>" id="s_erpif_yn" />
<input type="hidden" name="s_inquiryOnly_yn" value="<%=s_inquiryOnly_yn%>" id="s_inquiryOnly_yn" />
<input type="hidden" name="s_bil_loc" value="<%=s_bil_loc%>" id="s_bil_loc" />

<input type="hidden" name="trd_party_val" id="trd_party_val" value="<%=strTrdPartyVal%>"  />

<input type="hidden" name="s_is_au" value="<%=s_is_au%>" id="s_is_au" />

<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>Invoice Preview</span></h2>
		
		<div class="opus_design_btn">
			<div class="opus_design_btn">
				<button class="btn_accent" name="btn_print_only" id="btn_print_only" type="button">Print Only</button>
				<% if(s_issue_yn.equals("Y")){ %>
					<button class="btn_normal" name="btn_issue" id="btn_issue" type="button">Issue</button>
				<% } %>
				<% if(s_erpif_yn.equals("Y")){ %>
					<button class="btn_normal" name="btn_erpif" id="btn_erpif"  type="button"  style="display:none;">AR Interface</button>
				<% } %>
				<button class="btn_normal" name="btn_close" id="btn_close" type="button">Close</button>
			</div>
		</div>
	</div>
</div>

<div class="layer_popup_contents">
<!-- page_title_area(E) -->
<div class="wrap_search sm">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<% if(s_issue_yn.equals("Y")){ %>
			<table>
				<colgroup>
					<col width="80">
					<col width="440">
					<col width="80">
					<col width="*">
				</colgroup>
				<tr>
					<th>Issue Type</th>
					<td><%=JSPUtil.getCodeCombo("s_n3pty_inv_if_tp_cd", "", "style='width:100px', class='input1'  required caption='Issue Type'", "CD00869", 0, "001: :&lt;&lt;Select&gt;&gt;|")%>
					<div id="contact_info_combo" style="display:inline;">
							<script type="text/javascript">ComComboObject('combo1', 2, 300 , 1, "class='input1'")</script>
					</div>
					<div id="contact_info_input" style="display:none;">
							<input type="text" style="width:300px;" name="contact_info_email" id="contact_info_email"  />
					</div>		
					</td>
					<th>Invoice No.</th>
					<td><input type="text" style="width:95px;" name="s_n3pty_inv_no" value="<%=JSPUtil.getNull(s_n3pty_inv_no)%>" readonly id="s_n3pty_inv_no" />
					      <input type="text" style="width:33px;" name="s_n3pty_inv_rmd_cd" value="<%=JSPUtil.getNull(request.getParameter("s_n3pty_inv_rmd_cd")) %>" id="s_n3pty_inv_rmd_cd" readonly/></td>
				</tr>
			</table>
			<% } else { %>
			<table>
				<colgroup>
					<col width="80">
					<col width="*">
				</colgroup>
				<tr>
					<th>Invoice No.</th>
					<td><input type="text" style="width:95px;" name="s_n3pty_inv_no" value="<%=JSPUtil.getNull(s_n3pty_inv_no)%>" readonly id="s_n3pty_inv_no" /><input type="text" style="width:33px;" name="s_n3pty_inv_rmd_cd" value="<%=JSPUtil.getNull(request.getParameter("s_n3pty_inv_rmd_cd")) %>" id="s_n3pty_inv_rmd_cd" readonly/></td>
				</tr>
			</table>
			<% } %>
	</div>
	<!-- opus_design_inquiry(E) -->
	<br>
	<div class="opus_design_grid">
		<!-- opus_design_btn (E) -->
		<div class="opus_design_btn">
			<button class="btn_accent" name="First" id="btn_first" type="button">First</button>
			<button class="btn_normal" name="btn_back" id="btn_back" type="button">Back</button>
			<button class="btn_normal" name="btn_next" id="btn_next"  type="button">Next</button>
			<button class="btn_accent" name="btn_last" id="btn_last" type="button">Last</button>
			<button class="btn_normal" name="btn_zoomIn" id="btn_zoomIn" type="button">Zoom In(+)</button>
			<button class="btn_normal" name="btn_zoomOut" id="btn_zoomOut"  type="button">Zoom Out(-)</button>
		</div>
		<!-- opus_design_btn (E) -->
	</div>	
</div>
<div class="wrap_result">
	<div class="opus_design_RD"> 
		<script language="javascript">rdViewerObject();</script>
    </div>
</div>    	
		<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" style="display: none">
		<script type="text/javascript">ComSheetObject('sheet1');</script>		
	</div>
	<!-- opus_design_grid(E) -->		
</div>
</form>
