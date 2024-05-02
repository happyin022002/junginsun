<%/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : STM_SAP_0018.jsp
*@FileTitle  : Evidence Popup 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/05
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.component.util.StringUtil" %>

<%
		
Exception serverException   = null;			//error from server
String strErrMsg = "";						//error message
String req_evi_type = "";					//req_evi_type

String sNmW = "150";
String valW = "210";
String lNmW = "150";


String sNmAlign = "left";
String lNmAlign = "right";



try {
	
	req_evi_type = JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("evidence_type")));
	   	
	serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

	if (serverException != null) {
		strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
	}
	
	
}catch(Exception e) {
	out.println(e.toString());
}

%>
<script  type="text/javascript">
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
<div class="layer_popup_contents">
	<div class="layer_popup_title">
		<!-- page_title_area(S) -->
		<div class="page_title_area clear">
		   <!-- page_title(S) -->
			<h2 class="page_title"><span>Invoice Evidence Type</span></h2>
			<!-- page_title(E) -->
			<!-- opus_design_btn(S) -->
			<div class="opus_design_btn">
				<button type="button" class="btn_accent" name="btn_Ok" 	id="btn_Ok">Ok</button><!--
				--><button type="button" class="btn_normal" name="btn_new" 		id="btn_new">New</button><!--
				--><button type="button" class="btn_normal" name="btn_close"  		id="btn_close">Close</button>	
			</div>
			<!-- opus_design_btn(E) -->
			<!-- page_location(S) -->
			<div class="location">
				<span id="navigation"></span>
			</div>
			<!-- page_location(E) -->
		</div>
		<!-- page_title_area(E) -->
	</div>
	<!-- opus_design_inquiry(S) -->
	<div class= "wrap_search">
		<div class= "opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="100"/>
					<col width="*"/>
			    </colgroup>
			    <tbody>
					<tr>
						<th id="titTd"><div id="nmTd">Evidence Type</div></th>
						<td><script  type="text/javascript">ComComboObject('evi_type', 2, 200, 1, 1,0,false,1);</script></td>
					</tr>
					<tr class="line_bluedot"><td colspan="2"></td></tr>	
				</tbody>
			</table>
			<table id="tINVOICES"> 
				<colgroup>
					<col width="100"/>
					<col width="40"/>
					<col width="*"/>
			    </colgroup>
			    <tbody>
				<tr>
					<th>ASA No</th>
					<td><input type="text" style="width:170px" class="input" name="in_attr_ctnt2" id="in_attr_ctnt2" maxlength="20" dataformat="engup" style="ime-mode:disabled"></td>
					<td></td>
				</tr> 
				</tbody>
			</table>
			<table id="tTAX"  style="display:none"> 
				<colgroup>
					<col width="100"/>
					<col width="1"/>
					<col width="40"/>
					<col width="*"/>
			    </colgroup>
				<tr>
					<th>신고사업장코드</th>
					<td></td>
					<td><input type="text" style="width:170px;" class="input1" name="ta_attr_ctnt5" maxlength="20" dataformat="engup" id="ta_attr_ctnt5" /><button type="button" id="btns_ta_srh1" name="btns_ta_srh1" class="input_seach_btn"></button></td>
					<td></td>
				</tr> 
				<tr>
					<th>발행거래처</th>
					<td></td>
					<td><input type="text" style="width:170px;" class="input1" name="ta_attr_ctnt2" maxlength="20" dataformat="engup" id="ta_attr_ctnt2" /><button type="button" id="btns_ta_srh2" name="btns_ta_srh2" class="input_seach_btn"></button></td>
					<td></td>
				</tr> 
				<tr>
					<th>세금계산서일자</th>
					<td></td>
					<td><input type="text" style="width:80px;" class="input1" name="ta_attr_ctnt3" maxlength="20" dataformat="ymd" caption="세금계산서일자" id="ta_attr_ctnt3" /><button type="button" id="btns_calTa1" name="btns_calTa1" class="calendar ir"></button></td>
					<td></td>
				</tr> 
				<tr>
					<th>신고구분</th>
					<td></td>
					<td width="<%=valW%>">
					<script  type="text/javascript">ComComboObject('ta_attr_ctnt8', 2, 170, 1, 1,0,false,1);</script>
					<td></td>
				</tr> 
				<tr>
					<th>총공급가액</th>
					<td></td>
					<td><input type="text" style="width:170px;text-align:right" class="input1" name="ta_attr_ctnt4" maxlength="20" dataformat="num" id="ta_attr_ctnt4" /></td>
					<td></td>
				</tr>	
				<tr>
					<th>총세액</th>
					<td></td>
					<td><input type="text" style="width:170px;text-align:right" class="input1" name="ta_attr_ctnt6" maxlength="20" dataformat="num" id="ta_attr_ctnt6" /></td>
					<td></td>
				</tr>					
				<tr>
					<th>품명1</th>
					<td></td>
					<td><input type="text" style="width:170px;" class="input1" name="ta_glo_attr_ctnt1" maxlength="20" dataformat="engup" id="ta_glo_attr_ctnt1" /></td>
					<td></td>
				</tr>	
				<tr>
					<th>Digital Tax Status</th>
					<td></td>
					<td width="<%=valW%>">
					<script  type="text/javascript">ComComboObject('ta_attr_ctnt11', 2, 170, 1, 0,0,false,1);</script>
					<td></td>
				</tr>		
				<tr>
					<th>Legacy I/F 원시수취번호</th>
					<td></td>
					<td><input type="text" style="width:170px;" class="input" name="ta_glo_attr_ctnt13" maxlength="20" dataformat="engup" id="ta_glo_attr_ctnt13" /></td>
					<td></td>
				</tr>
				<tr>
					<th>Legacy I/F 당초 INV #</th>
					<td></td>
					<td><input type="text" style="width:170px;" class="input" name="ta_glo_attr_ctnt14" maxlength="20" dataformat="engup" id="ta_glo_attr_ctnt14" /></td>
					<td></td>
				</tr>	
				<tr>
					<th>VAT I/F 신고월</th>
					<td></td>
					<td><input type="text" style="width:80px;" class="input" name="ta_glo_attr_ctnt15" maxlength="20" dataformat="ym" caption="VAT I/F 신고월" id="ta_glo_attr_ctnt15" /></td>
					<td></td>
				</tr>	
				<tr>
					<th>VAT I/F 신고유형</th>
					<td></td>
					<td><input type="text" style="width:170px;" class="input" name="ta_glo_attr_ctnt16" maxlength="20" dataformat="engup" id="ta_glo_attr_ctnt16" /></td>
					<td></td>
				</tr>
																																							<tr>
					<th>VAT I/F 권번호</th>
					<td></td>
					<td><input type="text" style="width:170px;" class="input" name="ta_glo_attr_ctnt17" maxlength="20" dataformat="engup" id="ta_glo_attr_ctnt17" /></td>
					<td></td>
				</tr>	
				<tr>
					<th>VAT I/F 추출여부</th>
					<td></td>
					<td width="<%=valW%>"><select style="width:60px;" name="ta_glo_attr_ctnt18">
					    <option value=""></option>
                        <option value="Y">Y</option>
                        <option value="N">N</option>
                        <option value="C">C</option>
                        </select>
					<td></td>
				</tr>
			</table>				
			<table id="tVAT"  style="display:none"> 
				<colgroup>
					<col width="100"/>
					<col width="1"/>
					<col width="40"/>
					<col width="*"/>
			    </colgroup>
				<tr>
					<th>신고사업장코드</th>
					<td></td>
					<td><input type="text" style="width:170px;" class="input1" name="va_attr_ctnt5" maxlength="20" dataformat="engup" id="va_attr_ctnt5" /><button type="button" id="btns_va_srh1" name="btns_va_srh1" class="input_seach_btn"></button></td>
					<td></td>
				</tr> 
				<tr>
					<th>발행거래처</th>
					<td></td>
					<td><input type="text" style="width:170px;" class="input1" name="va_attr_ctnt2" maxlength="20" dataformat="engup" id="va_attr_ctnt2" /><button type="button" id="btns_va_srh2" name="btns_va_srh2" class="input_seach_btn"></button></td>
					<td></td>
				</tr> 
				<tr>
					<th>계산서일자</th>
					<td></td>
					<td><input type="text" style="width:80px;" class="input1" name="va_attr_ctnt3" maxlength="20" dataformat="ymd" caption="계산서일자" id="va_attr_ctnt3" /><button type="button" id="btns_calVa1" name="btns_calVa1" class="calendar ir"></button></td>
					<td></td>
				</tr> 
				<tr>
					<th>신고구분</th>
					<td></td>
					<td width="<%=valW%>">
					<script  type="text/javascript">ComComboObject('va_attr_ctnt8', 2, 170, 1, 1,0,false,1);</script>
					<td></td>
				</tr> 
				<tr>
					<th>총공급가액</th>
					<td></td>
					<td><input type="text" style="width:170px;text-align:right" class="input1" name="va_attr_ctnt4" maxlength="20" dataformat="num" id="va_attr_ctnt4" /></td>
					<td></td>
				</tr>	
				<tr>
					<th>총세액</th>
					<td></td>
					<td><input type="text" style="width:170px;text-align:right" class="input1" name="va_attr_ctnt6" maxlength="20" dataformat="num" id="va_attr_ctnt6" /></td>
					<td></td>
				</tr>					
				<tr>
					<th>품명1</th>
					<td></td>
					<td><input type="text" style="width:170px;" class="input1" name="va_glo_attr_ctnt1" maxlength="20" dataformat="engup" id="va_glo_attr_ctnt1" /></td>
					<td></td>
				</tr>	
				<tr>
					<th>Digital Tax Status</th>
					<td></td>
					<td width="<%=valW%>">
					<script  type="text/javascript">ComComboObject('va_attr_ctnt11', 2, 170, 1, 0,0,false,1);</script>
					<td></td>
				</tr>		
				<tr>
					<th>Legacy I/F 원시수취번호</th>
					<td></td>
					<td><input type="text" style="width:170px;" class="input" name="va_glo_attr_ctnt13" maxlength="20" dataformat="engup" id="va_glo_attr_ctnt13" /></td>
					<td></td>
				</tr>
				<tr>
					<th>Legacy I/F 당초 INV #</th>
					<td></td>
					<td><input type="text" style="width:170px;" class="input" name="va_glo_attr_ctnt14" maxlength="20" dataformat="engup" id="va_glo_attr_ctnt14" /></td>
					<td></td>
				</tr>	
				<tr>
					<th>VAT I/F 신고월</th>
					<td></td>
					<td><input type="text" style="width:80px;" class="input" name="va_glo_attr_ctnt15" maxlength="20" dataformat="ym" caption="VAT I/F 신고월" id="va_glo_attr_ctnt15" /></td>
					<td></td>
				</tr>	
				<tr>
					<th>VAT I/F 신고유형</th>
					<td></td>
					<td><input type="text" style="width:170px;" class="input" name="va_glo_attr_ctnt16" maxlength="20" dataformat="engup" id="va_glo_attr_ctnt16" /></td>
					<td></td>
				</tr>
																																							<tr>
					<th>VAT I/F 권번호</th>
					<td></td>
					<td><input type="text" style="width:170px;" class="input" name="va_glo_attr_ctnt17" maxlength="20" dataformat="engup" id="va_glo_attr_ctnt17" /></td>
					<td></td>
				</tr>	
				<tr>
					<th>VAT I/F 추출여부</th>
					<td></td>
					<td width="<%=valW%>"><select style="width:60px;" name="va_glo_attr_ctnt18" id="va_glo_attr_ctnt18">
					    <option value=""></option>
                        <option value="Y">Y</option>
                        <option value="N">N</option>
                        <option value="C">C</option>
                        </select>
					<td></td>
				</tr>
				</table>
				<table id="tCREDITCARD"   style="display:none"> 
				<colgroup>
					<col width="100"/>
					<col width="1"/>
					<col width="40"/>
					<col width="*"/>
			    </colgroup>
				<tr>
					<th>법인카드번호</th>
					<td></td>
					<td><input type="text" style="width:170px;" class="input" name="cr_attr_ctnt2" maxlength="20" dataformat="engup" id="cr_attr_ctnt2" /></td>
					<td></td>
				</tr> 
				<tr>
					<th>승인번호</th>
					<td></td>
					<td><input type="text" style="width:170px;" class="input" name="cr_attr_ctnt3" maxlength="20" dataformat="engup" id="cr_attr_ctnt3" /></td>
					<td></td>
				</tr> 
				<tr>
					<th>사용자</th>
					<td></td>
					<td><input type="text" style="width:100px;" class="input" name="cr_attr_ctnt4" maxlength="20" dataformat="han" id="cr_attr_ctnt4" /></td>
					<td></td>
				</tr> 
				<tr>
					<th>거래처 사업자번호</th>
					<td></td>
					<td><input type="text" style="width:170px;" class="input" name="cr_attr_ctnt5" maxlength="20" dataformat="saupja" id="cr_attr_ctnt5" /></td>
					<td></td>
				</tr> 
				<tr>
					<th>거래처명</th>
					<td></td>
					<td><input type="text" style="width:170px;" class="input" name="cr_attr_ctnt6" maxlength="20" dataformat="han" id="cr_attr_ctnt6" /></td>
					<td></td>
				</tr>	
				<tr>
					<th>봉사료</th>
					<td></td>
					<td><input type="text" style="width:170px;text-align:right" class="input" name="cr_attr_ctnt7" maxlength="20" dataformat="num" id="cr_attr_ctnt7" /></td>
					<td></td>
				</tr>					
				<tr>
					<th>사용일자</th>
					<td></td>
					<td><input type="text" style="width:80px;" class="input" name="cr_attr_ctnt8" maxlength="20" dataformat="ymd" id="cr_attr_ctnt8" /><button type="button" id="btns_calCr1" name="btns_calCr1" class="calendar ir"></button></td>
					<td></td>
				</tr>	
				<tr>
					<th>정산번호</th>
					<td></td>
					<td><input type="text" style="width:170px;" class="input" name="cr_attr_ctnt9" maxlength="20" dataformat="engup" id="cr_attr_ctnt9" /></td>
					<td></td>
				</tr>		
				</table>	
				<table id="tREFUND"   style="display:none"> 
				<tr>
					<th>Receipt No</th>
					<td></td>
					<td><input type="text" style="width:170px;" class="input" name="re_attr_ctnt4" maxlength="20" dataformat="engup" id="re_attr_ctnt4" /></td>
					<td></td>
				</tr> 
				</table>			
							
				<table id="tARAPOFFSET"  style="display:none"> 
				<tr>
					<th>Offset No</th>
					<td></td>
					<td><input type="text" style="width:170px;" class="input" name="ar_attr_ctnt2" maxlength="20" dataformat="engup" id="ar_attr_ctnt2" /></td>
					<td></td>
				</tr> 
				</table>
				<table id="tETC" style="display:none"> 
				<tr>
					<th>Offset No</th>
					<td></td>
					<td><input type="text" style="width:170px;" class="input" name="et_attr_ctnt2" maxlength="20" dataformat="engup" id="et_attr_ctnt2" /></td>
					<td></td>
				</tr> 
				</table>					
		</div>
	</div>
	<!-- opus_design_inquiry(E) -->
	<!-- opus_design_grid(S) -->
	<div id="hidSheetDiv"  style="display:none" >
	<div class="wrap_result">
		<div class="opus_design_grid clear" >
			<script type="text/javascript">ComSheetObject('sheet');</script>
		</div>
	</div>
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>
<%@include file="/bizcommon/include/common_opus.jsp"%>
 <iframe name="iframe_bizcom" style="display:none"></iframe>