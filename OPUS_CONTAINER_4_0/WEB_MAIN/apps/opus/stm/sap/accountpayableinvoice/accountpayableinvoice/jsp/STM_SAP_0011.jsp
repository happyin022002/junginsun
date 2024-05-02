<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : STM_SAP_0011.jsp
*@FileTitle  : Evidence Popup
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/06 
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.component.util.StringUtil" %>


<%
		
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	
	String sNmW = "150";
	String valW = "270";
	String lNmW = "150";
	
	
	String sNmAlign = "left";
	String lNmAlign = "right";
	
	String req_evi_type = JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("evidence_type")));
	String chk_editable = JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("chk_editable")));
	String ctnt2 = JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("ctnt2")));
	String ctnt3 = JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("ctnt3")));
	String ctnt4 = JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("ctnt4")));
	String ctnt5 = JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("ctnt5")));
	String ctnt6 = JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("ctnt6")));
	String ctnt7 = JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("ctnt7")));
	String ctnt8 = JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("ctnt8")));
	String ctnt9 = JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("ctnt9")));
	String ctnt11 = JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("ctnt11")));
	
	String gctnt1 = JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("gctnt1")));
	String gctnt13 = JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("gctnt13")));
	String gctnt14 = JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("gctnt14")));
	String gctnt15 = JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("gctnt15")));
	String gctnt16 = JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("gctnt16")));
	String gctnt17 = JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("gctnt17")));
	String gctnt18 = JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("gctnt18")));
	
	String ofc_cd= JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("ofc_cd")));
	String inv_seq = JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("inv_seq")));
	String inv_curr_cd = JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("inv_curr_cd")));
	String inv_type = JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("inv_type")));
	String evidence_flag = JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("evidence_flag")));
	if(inv_seq == null || "".equals(inv_seq)) {
		inv_seq = "NO_DATA";
	}
	
	String strReadOnly = "";
	if ("N".equals(chk_editable)) {
		strReadOnly = "  class='input2'  readonly ";
	}
	
	try {
		
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
	
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
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
<input	type="hidden" name="f_cmd" id="f_cmd"> 
<input type="hidden" name="req_evi_type" id="req_evi_type" value="<%=req_evi_type %>">
<input type="hidden" name="s_wid" id="s_wid" value="<%=sNmW %>">
<input type="hidden" name="l_wid" id="l_wid" value="<%=lNmW %>">
<input type="hidden" name="h_ctnt2" id="h_ctnt2" value="<%=ctnt2 %>">
<input type="hidden" name="h_ctnt8" id="h_ctnt8" value="<%=ctnt8 %>">
<input type="hidden" name="h_ctnt11" id="h_ctnt11" value="<%=ctnt11 %>">
<input type="hidden" name="h_ofc_cd" id="h_ofc_cd" value="<%=ofc_cd %>">
<input type="hidden" name="h_inv_seq" id="h_inv_seq" value="<%=inv_seq %>">
<input type="hidden" name="h_inv_curr_cd" id="h_inv_curr_cd" value="<%=inv_curr_cd %>">
<input type="hidden" name="h_inv_type" id="h_inv_type" value="<%=inv_type %>">
<input type="hidden" name="h_evidence_flag" id="h_evidence_flag" value="<%=evidence_flag %>">
<input type="hidden" name="chk_editable" id="chk_editable" value="<%=chk_editable %>">

	
	<!-- layer_popup_title(S) -->
	<div class="layer_popup_title">
		<!-- page_title_area(S) -->
		<div class="page_title_area clear">
		
			<!-- page_title(S) -->
			<h2 class="page_title"><span>Invoice Evidence Type</span></h2>
			<!-- page_title(E) -->
			
			<!-- opus_design_btn (S) -->
			<div class="opus_design_btn"><!-- 
				--><% if (chk_editable != null && !chk_editable.equals("N")) { %><button type="button" id="btn_ok" name="btn_ok" class="btn_accent">OK</button><!--
				--><button type="button" id="btn_new" name="btn_new" class="btn_normal">New</button><%}%><!--
				--><button type="button" id="btn_close" name="btn_close" class="btn_normal">Close</button><!--
				--></div>
			<!-- opus_design_btn (E) -->
			
		</div>
		<!-- page_title_area(E) -->
	</div>
	<!-- layer_popup_title(E) -->
	
	
	<!-- layer_popup_contents(S) -->
	<div class="layer_popup_contents">
		<!-- wrap_search(S) -->
		<div class="wrap_search">
			<!-- opus_design_inquiry(S) -->
			<div class="opus_design_inquiry wFit">
				<table>
					<colgroup>
						<col width="150"/>
						<col width="200"/>
						<col width="*" />				
					</colgroup> 
					<tr>
						<th id="titTd" width="<%=sNmW%>" ><span id="nmTd">Evidence Type</span></th>
						<td width="<%=valW%>"><script type="text/javascript">ComComboObject('evi_type', 2, 200, 1, 1,0,false,1);</script></td>
						<td></td>
					</tr> 
				</table>
			</div>
			<!-- opus_design_inquiry(E) -->
		</div>
		<!-- wrap_search(E) -->
		<!-- wrap_result(S) -->
		<div class="wrap_result">
			<table class="line_bluedot"><tr><td></td></tr></table>
			<div class="opus_design_inquiry wFit">
		        <table id="tINVOICES" border="0" style="display:none"> 
		        	<colgroup>
						<col width="150"/>
						<col width="200"/>
						<col width="*" />				
					</colgroup>
					<tr>
						<th width="<%=sNmW%>" align="<%=sNmAlign%>" >ASA No</th>
						<td width="<%=valW%>"><script type="text/javascript">ComComboObject('in_attr_ctnt2', 5, 200, 1, 0,0,false,1);</script></td>
						<td></td>
					</tr> 
				</table>
					
				<table id="tTAX" border="0" style="display:none"> 
					<colgroup>
						<col width="150"/>
						<col width="200"/>
						<col width="*" />				
					</colgroup>
					<tr>
						<th width="<%=lNmW%>" align="<%=lNmAlign%>" >신고사업장코드</th>
						<td width="<%=valW%>"><input type="text" style="width:80px;" class="input1" name="ta_attr_ctnt5" maxlength="20" dataformat="engup" value="<%=ctnt5%>" id="ta_attr_ctnt5" /><button type="button" id="btns_ta_srh1" name="btns_ta_srh1" class="input_seach_btn"></button><input type="text" style="width:160px;" class="input2" name="ta_attr_ctnt5_nm" id="ta_attr_ctnt5_nm" /></td>
						<td></td>
					</tr> 
					<tr>
						<th width="<%=lNmW%>" align="<%=lNmAlign%>" >발행거래처</th>
						<td width="<%=valW%>"><input type="text" style="width:80px;" class="input1" name="ta_attr_ctnt2" maxlength="20" dataformat="engup" value="<%=ctnt2%>" id="ta_attr_ctnt2" /><button type="button" id="btns_ta_srh2" name="btns_ta_srh2" class="input_seach_btn"></button><input type="text" style="width:160px;" class="input2" name="ta_attr_ctnt2_nm" id="ta_attr_ctnt2_nm" /></td>
						<td></td>
					</tr> 
					<tr>
						<th width="<%=lNmW%>" align="<%=lNmAlign%>" >세금계산서일자</th>
						<td width="<%=valW%>"><input type="text" style="width:80px;" class="input1" name="ta_attr_ctnt3" maxlength="20" dataformat="ymd" caption="세금계산서일자" value="<%=ctnt3%>" id="ta_attr_ctnt3" /><button type="button" id="btns_calTa1" name="btns_calTa1" class="calendar ir"></button></td>
						<td></td>
					</tr> 
					<tr>
						<th width="<%=lNmW%>" align="<%=lNmAlign%>" >신고구분</th>
						<td width="<%=valW%>"  style="padding-left:2"><script type="text/javascript">ComComboObject('ta_attr_ctnt8', 2, 170, 1, 1,0,false,1);</script></td>
						<td></td>
					</tr> 
					<tr>
						<th width="<%=lNmW%>" align="<%=lNmAlign%>" >총공급가액</th>
						<td width="<%=valW%>"><input type="text" style="width:170px;text-align:right" class="input1" name="ta_attr_ctnt4" maxlength="20" dataformat="num" value="<%=ctnt4%>" id="ta_attr_ctnt4" /></td>
						<td></td>
					</tr>	
					<tr>
						<th width="<%=lNmW%>" align="<%=lNmAlign%>" >총세액</th>
						<td width="<%=valW%>"><input type="text" style="width:170px;text-align:right" class="input1" name="ta_attr_ctnt6" maxlength="20" dataformat="num" value="<%=ctnt6%>" id="ta_attr_ctnt6" /></td>
						<td></td>
					</tr>					
					<tr>
						<th width="<%=lNmW%>" align="<%=lNmAlign%>" >품명1</th>
						<td width="<%=valW%>"><input type="text" style="width:170px;" class="input1" name="ta_glo_attr_ctnt1" maxlength="20" dataformat="engup" value="<%=gctnt1%>" id="ta_glo_attr_ctnt1" /></td>
						<td></td>
					</tr>	
					<tr>
						<th width="<%=lNmW%>" align="<%=lNmAlign%>" >Digital Tax Status</th>
						<td width="<%=valW%>" style="padding-left:2"><script type="text/javascript">ComComboObject('ta_attr_ctnt11', 2, 170, 1, 0,0,false,1);</script></td>
						<td></td>
					</tr>		
					<tr>
						<th width="<%=lNmW%>" align="<%=lNmAlign%>" >Legacy I/F 원시수취번호</th>
						<td width="<%=valW%>"><input type="text" style="width:170px;" class="input" name="ta_glo_attr_ctnt13" maxlength="20" dataformat="engup" value="<%=gctnt13%>" id="ta_glo_attr_ctnt13" /></td>
						<td></td>
					</tr>
					<tr>
						<th width="<%=lNmW%>" align="<%=lNmAlign%>" >Legacy I/F 당초 INV #</th>
						<td width="<%=valW%>"><input type="text" style="width:170px;" class="input" name="ta_glo_attr_ctnt14" maxlength="20" dataformat="engup" value="<%=gctnt14%>" id="ta_glo_attr_ctnt14" /></td>
						<td></td>
					</tr>	
					<tr>
						<th width="<%=lNmW%>" align="<%=lNmAlign%>" >VAT I/F 신고월</th>
						<td width="<%=valW%>"><input type="text" style="width:80px;" class="input" name="ta_glo_attr_ctnt15" maxlength="20" dataformat="ym" caption="VAT I/F 신고월" value="<%=gctnt15%>" id="ta_glo_attr_ctnt15" /></td>
						<td></td>
					</tr>	
					<tr>
						<th width="<%=lNmW%>" align="<%=lNmAlign%>" >VAT I/F 신고유형</th>
						<td width="<%=valW%>"><input type="text" style="width:170px;" class="input" name="ta_glo_attr_ctnt16" maxlength="20" dataformat="engup" value="<%=gctnt16%>" id="ta_glo_attr_ctnt16" /></td>
						<td></td>
					</tr>
					<tr>
						<th width="<%=lNmW%>" align="<%=lNmAlign%>" >VAT I/F 권번호</th>
						<td width="<%=valW%>"><input type="text" style="width:170px;" class="input" name="ta_glo_attr_ctnt17" maxlength="20" dataformat="engup" value="<%=gctnt17%>" id="ta_glo_attr_ctnt17" /></td>
						<td></td>
					</tr>	
					<tr>
						<th width="<%=lNmW%>" align="<%=lNmAlign%>" >VAT I/F 추출여부</th>
						<td width="<%=valW%>"><select style="width:60;" name="ta_glo_attr_ctnt18">
						    <option value=""  <%=gctnt18.equals("")?"selected":""%> ></option>
		                       <option value="Y" <%=gctnt18.equals("Y")?"selected":""%>>Y</option>
		                       <option value="N" <%=gctnt18.equals("N")?"selected":""%>>N</option>
		                       <option value="C" <%=gctnt18.equals("C")?"selected":""%>>C</option>
		                       </select>
						<td></td>
					</tr>
				</table>				
					
				<table id="tVAT" border="0" style="display:none"> 
					<colgroup>
						<col width="150"/>
						<col width="200"/>
						<col width="*" />				
					</colgroup>
					<tr>
						<th width="<%=lNmW%>" align="<%=lNmAlign%>" >신고사업장코드</th>
						<td width="<%=valW%>"><!-- 
						 --><input type="text" style="width:80px" class="input1" name="va_attr_ctnt5" id="va_attr_ctnt5" maxlength="20" dataformat="engup" style="ime-mode:disabled" value="<%=ctnt5%>"><!-- 
						 --><button class="input_seach_btn" name="btns_va_srh1" id="btns_va_srh1" type="button"></button><!-- 
						 --><input type="text" style="width:160px" class="input2" name="va_attr_ctnt5_nm" id="va_attr_ctnt5_nm"><!-- 
						 --></td>
						<td></td>
					</tr> 
					<tr>
						<th width="<%=lNmW%>" align="<%=lNmAlign%>" >발행거래처</th>
						<td width="<%=valW%>"><!-- 
						 --><input type="text" style="width:80px" class="input1" name="va_attr_ctnt2" id="va_attr_ctnt2" maxlength="20" dataformat="engup" style="ime-mode:disabled" value="<%=ctnt2%>"><!-- 
						 --><button class="input_seach_btn" name="btns_va_srh2" id="btns_va_srh2" type="button"></button><!-- 
						 --><input type="text" style="width:160px" class="input2" name="va_attr_ctnt2_nm" id="va_attr_ctnt2_nm"><!-- 
						 --></td>
						<td></td>
					</tr> 
					<tr>
						<th width="<%=lNmW%>" align="<%=lNmAlign%>" >계산서일자</th>
						<td width="<%=valW%>"><!-- 
						 --><input type="text" style="width:80px" class="input1" name="va_attr_ctnt3" id="va_attr_ctnt3" maxlength="20" dataformat="ymd" style="ime-mode:disabled" caption="계산서일자"  value="<%=ctnt3%>"><!-- 
						 --><button class="calendar ir" name="btns_calVa1" id="btns_calVa1" type="button"></button><!-- 
						 --></td>
						<td></td>
					</tr> 
					<tr>
						<th width="<%=lNmW%>" align="<%=lNmAlign%>" >신고구분</th>
						<td width="<%=valW%>" style="padding-left:2"><script type="text/javascript">ComComboObject('va_attr_ctnt8', 2, 170, 1, 1,0,false,1);</script></td>
						<td></td>
					</tr> 
					<tr>
						<th width="<%=lNmW%>" align="<%=lNmAlign%>" >총공급가액</th>
						<td width="<%=valW%>"><input type="text" style="width:170px;text-align:right" class="input1" name="va_attr_ctnt4" id="va_attr_ctnt4" maxlength="20" dataformat="int" style="ime-mode:disabled" value="<%=ctnt4%>"></td>
						<td></td>
					</tr>	
					<tr>
						<th width="<%=lNmW%>" align="<%=lNmAlign%>" >총세액</th>
						<td width="<%=valW%>"><input type="text" style="width:170px;text-align:right" class="input1" name="va_attr_ctnt6" id="va_attr_ctnt6" maxlength="20" dataformat="int" style="ime-mode:disabled" value="<%=ctnt6%>"></td>
						<td></td>
					</tr>					
					<tr>
						<th width="<%=lNmW%>" align="<%=lNmAlign%>" >품명1</th>
						<td width="<%=valW%>"><input type="text" style="width:170px" class="input1" name="va_glo_attr_ctnt1" id="va_glo_attr_ctnt1" maxlength="20" dataformat="engup" style="ime-mode:disabled" value="<%=gctnt1%>"></td>
						<td></td>
					</tr>	
					<tr>
						<th width="<%=lNmW%>" align="<%=lNmAlign%>" >Digital Tax Status</th>
						<td width="<%=valW%>" style="padding-left:2"><script type="text/javascript">ComComboObject('va_attr_ctnt11', 2, 170, 1, 0,0,false,1);</script></td>
						<td></td>
					</tr>		
					<tr>
						<th width="<%=lNmW%>" align="<%=lNmAlign%>" >Legacy I/F 원시수취번호</th>
						<td width="<%=valW%>"><input type="text" style="width:170px" class="input" name="va_glo_attr_ctnt13" id="va_glo_attr_ctnt13" maxlength="20" dataformat="engup" style="ime-mode:disabled" value="<%=gctnt13%>"></td>
						<td></td>
					</tr>
					<tr>
						<th width="<%=lNmW%>" align="<%=lNmAlign%>" >Legacy I/F 당초 INV #</th>
						<td width="<%=valW%>"><input type="text" style="width:170px" class="input" name="va_glo_attr_ctnt14" id="va_glo_attr_ctnt14" maxlength="20" dataformat="engup" style="ime-mode:disabled" value="<%=gctnt14%>"></td>
						<td></td>
					</tr>	
					<tr>
						<th width="<%=lNmW%>" align="<%=lNmAlign%>" >VAT I/F 신고월</th>
						<td width="<%=valW%>"><input type="text" style="width:80px" class="input" name="va_glo_attr_ctnt15" id="va_glo_attr_ctnt15" maxlength="20" dataformat="ym" style="ime-mode:disabled" caption="VAT I/F 신고월"  value="<%=gctnt15%>"></td>
						<td></td>
					</tr>	
					<tr>
						<th width="<%=lNmW%>" align="<%=lNmAlign%>" >VAT I/F 신고유형</th>
						<td width="<%=valW%>"><input type="text" style="width:170px" class="input" name="va_glo_attr_ctnt16" id="va_glo_attr_ctnt16" maxlength="20" dataformat="engup" style="ime-mode:disabled" value="<%=gctnt16%>"></td>
						<td></td>
					</tr>
					<tr>
						<th width="<%=lNmW%>" align="<%=lNmAlign%>" >VAT I/F 권번호</th>
						<td width="<%=valW%>"><input type="text" style="width:170px" class="input" name="va_glo_attr_ctnt17" id="va_glo_attr_ctnt17" maxlength="20" dataformat="engup" style="ime-mode:disabled" value="<%=gctnt17%>"></td>
						<td></td>
					</tr>	
					<tr>
						<th width="<%=lNmW%>" align="<%=lNmAlign%>" >VAT I/F 추출여부</th>
						<td width="<%=valW%>">
							<select style="width:60px;" name="va_glo_attr_ctnt18" id="va_glo_attr_ctnt18">
						    	<option value=""  <%=gctnt18.equals("")?"selected":""%> ></option>
		                       	<option value="Y" <%=gctnt18.equals("Y")?"selected":""%>>Y</option>
		                       	<option value="N" <%=gctnt18.equals("N")?"selected":""%>>N</option>
		                       	<option value="C" <%=gctnt18.equals("C")?"selected":""%>>C</option>
		                    </select>
		                </td>
						<td></td>
					</tr>
					</table>				
					
					
								
					<!-- 법인영수증 Evidence Popup================================================================== -->
				<table id="tCREDITCARD"  border="0" style="display:none"> 
					<colgroup>
						<col width="150"/>
						<col width="200"/>
						<col width="*" />				
					</colgroup>
					<tr>
						<th width="<%=lNmW%>" align="<%=lNmAlign%>" >Card Number</th> <!-- 법인카드번호 -->
						<td width="<%=valW%>"><input type="text" style="width:170px" class="input" name="cr_attr_ctnt2" id="cr_attr_ctnt2" maxlength="20" dataformat="engup" style="ime-mode:disabled" value="<%=ctnt2%>"></td>
						<td></td>
					</tr> 
					<tr>
						<th width="<%=lNmW%>" align="<%=lNmAlign%>" >Approve No</th> <!-- 승인번호 -->
						<td width="<%=valW%>"><input type="text" style="width:170px" class="input" name="cr_attr_ctnt3" id="cr_attr_ctnt3" maxlength="20" dataformat="engup" style="ime-mode:disabled" value="<%=ctnt3%>"></td>
						<td></td>
					</tr> 
					<tr>
						<th width="<%=lNmW%>" align="<%=lNmAlign%>" >Used Person</th> <!-- 사용자 -->
						<td width="<%=valW%>"><input type="text" style="width:100px" class="input" name="cr_attr_ctnt4" id="cr_attr_ctnt4" maxlength="20" dataformat="han"  value="<%=ctnt4%>"></td>
						<td></td>
					</tr> 
					<tr>
						<th width="<%=lNmW%>" align="<%=lNmAlign%>" >Shop Regist No</th> <!-- 거래처 사업자번호 -->
						<td width="<%=valW%>"><input type="text" style="width:170px" class="input" name="cr_attr_ctnt5" id="cr_attr_ctnt5" maxlength="20" dataformat="saupja" style="ime-mode:disabled" value="<%=ctnt5%>"></td>
						<td></td>
					</tr> 
					<tr>
						<th width="<%=lNmW%>" align="<%=lNmAlign%>" >Shop Name</th> <!-- 거래처명 -->
						<td width="<%=valW%>"><input type="text" style="width:170px" class="input" name="cr_attr_ctnt6" id="cr_attr_ctnt6" maxlength="20" dataformat="han"  value="<%=ctnt6%>"></td>
						<td></td>
					</tr>	
					<tr>
						<th width="<%=lNmW%>" align="<%=lNmAlign%>" >Service Fee</th> <!-- 봉사료 -->
						<td width="<%=valW%>"><input type="text" style="width:170px;text-align:right" class="input" name="cr_attr_ctnt7" id="cr_attr_ctnt7" maxlength="20" dataformat="int" style="ime-mode:disabled" value="<%=ctnt7%>"></td>
						<td></td>
					</tr>					
					<tr>
						<th width="<%=lNmW%>" align="<%=lNmAlign%>" >Transaction Date</th> <!-- 사용일자 -->
						<td width="<%=valW%>"><input type="text" style="width:80px" class="input" name="cr_attr_ctnt8" id="cr_attr_ctnt8" maxlength="20" dataformat="ymd" style="ime-mode:disabled" value="<%=ctnt8%>"><button class="calendar ir" name="btns_calCr1" id="btns_calCr1" type="button"></button></td>
						<td></td>
					</tr>	
					<tr>
						<th width="<%=lNmW%>" align="<%=lNmAlign%>" >Settlement No</th> <!-- 정산번호 -->
						<td width="<%=valW%>"><input type="text" style="width:170px" class="input" name="cr_attr_ctnt9" id="cr_attr_ctnt9" maxlength="20" dataformat="engup" style="ime-mode:disabled" value="<%=ctnt9%>"></td>
						<td></td>
					</tr>		
					</table>	
					
		
					<!-- Refund Evidence Popup================================================================== -->
				<table id="tREFUND"  border="0" style="display:none"> 
					<colgroup>
						<col width="150"/>
						<col width="200"/>
						<col width="*" />				
					</colgroup>
					<tr>
						<th width="<%=sNmW%>" align="<%=sNmAlign%>" >Receipt No</th>
						<td width="<%=valW%>"><input type="text" style="width:170px" <%=strReadOnly %> name="re_attr_ctnt4" id="re_attr_ctnt4" maxlength="20" dataformat="engup" style="ime-mode:disabled" value="<%=ctnt4%>"></td>
						<td></td>
					</tr> 
				</table>			
					
					
					<!-- ARAP Offset Evidence Popup================================================================== -->
					
				<table id="tARAPOFFSET" border="0" style="display:none"> 
					<colgroup>
						<col width="150"/>
						<col width="200"/>
						<col width="*" />				
					</colgroup>
					<tr>
						<th width="<%=sNmW%>" align="<%=sNmAlign%>" >Offset No</th>
						<td width="<%=valW%>"><input type="text" style="width:170px" <%=strReadOnly %> name="ar_attr_ctnt2" id="ar_attr_ctnt2" maxlength="20" dataformat="engup" style="ime-mode:disabled" value="<%=ctnt2%>"></td>
						<td></td>
					</tr> 
				</table>
		
					<!-- 기타 Evidence Popup================================================================== -->
				<table id="tETC"border="0" style="display:none"> 
					<colgroup>
						<col width="150"/>
						<col width="200"/>
						<col width="*" />				
					</colgroup>
					<tr>
						<th width="<%=sNmW%>" align="<%=sNmAlign%>" >Offset No</th>
						<td width="<%=valW%>"><input type="text" style="width:170px" <%=strReadOnly %> name="et_attr_ctnt2" id="et_attr_ctnt2" maxlength="20" dataformat="engup" style="ime-mode:disabled" value="<%=ctnt2%>"></td>
						<td></td>
					</tr> 
				</table>				
			</div>
			
			<!-- opus_design_grid(S) -->
			<div class="opus_design_grid"  id="hidSheetDiv"  style="display:none" >
				<script type="text/javascript">ComSheetObject('sheet');</script>
			</div>
			<!-- opus_design_grid(E) -->
		</div>
		<!--  wrap_result(E) -->
	</div>
	<!-- layer_popup_contents(E) -->
</form>
<%@include file="/bizcommon/include/common_opus.jsp"%>
 <!-- <iframe name="iframe_bizcom" style="display:none"> -->