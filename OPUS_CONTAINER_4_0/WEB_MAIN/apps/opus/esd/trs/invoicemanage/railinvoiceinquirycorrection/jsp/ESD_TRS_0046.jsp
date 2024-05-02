<%--
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESD_TRS_0046.jsp
*@FileTitle  : Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/04
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.trs.invoicemanage.railinvoiceinquirycorrection.event.EsdTrs0046Event"%>
<%
	EsdTrs0046Event  event = null;
	Exception serverException   = null;
	DBRowSet rowSet	 = null;
	String strErrMsg = "";
	int rowCount	 = 0;							
	SignOnUserAccount account= null;
	try {
	   	account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		event = (EsdTrs0046Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
	String today = DateTime.getFormatString("yyyyMMdd");
	String beforeOneMonth = DateTime.addMonths(today, -1);
	String dateCD         = JSPUtil.getCodeCombo("date_cd"         , "01", "style='width:125'", "CD00928", 0, "000030:ALL:ALL");
	String statusCD       = JSPUtil.getCodeCombo("status_cd"       , "01", "style='width:147'", "CD00824", 0, "000046:ALL:ALL");
	String holdCD         = JSPUtil.getCodeCombo("hold_cd"         , "01", "style='width:70'" , "CD00912", 0, "000046:ALL:ALL");
	String amountVeryfyCD = JSPUtil.getCodeCombo("amount_verify_cd", "01", "style='width:232'", "CD00927", 0, "000046:ALL:ALL");
%>
<script language="javascript">
	var beforeOneMonth = '<%=beforeOneMonth%>';
	var today = '<%=today%>';
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		}
		loadPage();
	}
</script>
<form method="post"  name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="inv_aud_sts_cd" id="inv_aud_sts_cd" />
<input type="hidden" name="usr_id" value="<%=account.getUsr_id()%>" id="usr_id" />
<input type="hidden" name="usr_ofc_cd" value="<%=account.getOfc_cd()%>" id="usr_ofc_cd" />
<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" 	id="btn_retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_reset" 		id="btn_reset">New</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_minimize"  		id="btn_minimize">Minimize</button>	
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->

<div id="MiniLayer" style="display:inline">
	<div class= "wrap_search">
	<!-- opus_design_inquiry(S) -->
		<div class= "opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="100"/>
					<col width="279"/>
					<col width="100"/>
					<col width="47"/>
					<col width="*"/>
			    </colgroup>
				<tr>
					<td><%=dateCD%><input type="text" style="width:75px" name='fmdate' id='fmdate' value="" dataformat="ymd" > ~ <input type="text" style="width:75px" name='todate' id='todate' value="" dataformat="ymd" onBlur="chkDaysBetween();" ><button type="button"  name='btns_calendar'  id='btns_calendar' class="calendar ir"></button>
					<th>Status</th>
					<td><%=statusCD%></td>
					<th>Hold</th>
					<td><%=holdCD%></td>
				</tr>
			</table>	
			<table>
				<colgroup>
					<col width="100px"/>
					<col width="104px"/>
					<col width="180px"/>
					<col width="*"/>
				</colgroup>
				<tr>
					<td><strong>Amount</strong> <%=amountVeryfyCD%></td>
					<th>Service Provider</th>
					<td class="sm pad_left_4"><input type="radio" class="trans" name="sp_tp" value="wo" checked id="sp_tp" />Work Order&nbsp;&nbsp;<!--  
						 --><input type="radio" name="sp_tp" value="py" class="trans" id="sp_tp" /><!-- 
						 -->Payment&nbsp;&nbsp;<script type="text/javascript">ComComboObject('combo_svc_provider', 2, 73, 0);</script><!-- 
						 --><input name="svc_provider" readonly class="input2" type="text" style="width:260px;" id="svc_provider" />
					</td>
					<td>&nbsp;</td>
				</tr>
			</table>
			<table>
				<colgroup>
					<col width="280"/>
					<col width="168"/>
					<col width="104"/>
					<col width="148"/>
					<col width="*"/>
			    </colgroup>
				<tr>
					<td class="sm pad_left_4"><input type="radio" name="no_tp" value="iv" class="trans" checked id="no_tp" onchange="funcRadioOnChange(this)"/> Invoice &nbsp;&nbsp;<input type="radio" name="no_tp" value="csr" class="trans" id="no_tp" onchange="funcRadioOnChange(this)" />&nbsp; CSR <input name="no_cd" type="text" style="width:181px;" id="no_cd" dataformat="engupetc"  otherchar=","/><button type="button" id="btns_no_cd" name="btns_no_cd" class="multiple_inq ir"></button></td>
					<th>Invoice Creation Office</th>
					<td><input name="inv_cre_ofc" type="text" style="width:83px;" value="<%=account.getOfc_cd()%>" id="inv_cre_ofc"  dataformat="engup"/></td>
					<th>Invoice Creation User ID</th>
					<td><input name="ivc_cre_usr_id" type="text" style="width:107px;" maxlength="10" id="ivc_cre_usr_id"  dataformat="eng"/></td>
				</tr>
			</table>
		</div>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<!-- opus_design_grid(S) -->
<div class="wrap_result">
	<div class="opus_design_grid" id="mainTable">
		<div class="opus_design_btn"><!-- 
			--><button type="button" class="btn_normal" name="btng_downinexcel1" 	id="btng_downinexcel1">Down In Excel 1</button><!-- 
			--><button type="button" class="btn_normal" name="btng_downexcel2" 	    id="btng_downexcel2">Down In Excel 2</button><!-- 
			--><button type="button" class="btn_normal" name="btng_detailinquiry" 	id="btng_detailinquiry">Detail Inquiry</button><!-- 
			--><button type="button" class="btn_normal" name="btng_holdsave" 	id=btng_holdsave>Hold Save</button><!-- 
			--><button type="button" class="btn_normal" name="btng_invoicedelete" 	id="btng_invoicedelete">Invoice Delete</button><!-- 
			--><button type="button" class="btn_normal" name="btng_invaudit" 	id=btng_invaudit>Invoice Audit</button><!-- 
			--><button type="button" class="btn_normal" name="btng_invconfrimcancel" 	id="btng_invconfrimcancel">Invoice Confirm Cancel</button><!-- 
	--></div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
</div>
<!-- opus_design_grid(E) -->
</form>

<form name='AuditForm' method='POST'>
<input type="hidden" name="inv_no" id="inv_no" />
<input type="hidden" name="inv_vndr_seq" id="inv_vndr_seq" />
<input type="hidden" name="editflag" id="editflag" />
<input type="hidden" name="pgmNo" value="ESD_TRS_0038" id="pgmNo" />
</form>

