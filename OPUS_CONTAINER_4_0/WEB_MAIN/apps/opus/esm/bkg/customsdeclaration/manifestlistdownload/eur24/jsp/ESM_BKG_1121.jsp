<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   :ESM_BKG_1121.jsp
*@FileTitle  : Europe Advanced Manifest  : EXS Download  & Transmit
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/09
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
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
			showErrMessage(errMessage);
		} // end if
		
		loadPage();
	}

    
    /**
     * bl별 머지 되도록 처리하기 위해
     * CoObject.js에 있는 함수를 오버라이딩 한것임
     * MemoPad에서 Apply 버튼을 눌렀을때 이 함수를 호출하며, MemoPad의 값을 IBSheet의 특정셀로 설정한다. <br>
     * 이 함수는 이파일(CoObject.js)에서만 사용하기 위한 목적으로 만들졌으나 수정함. <br>
     */
	function setMemoValue(sValue,iMax) {
		try {
			if(sValue.length > iMax){
				ComShowMessage("characters long");
				return;
			}else{
				if (memoSheet == null) return;
				//memoSheet.CellValue(memoRow, memoCol) = sValue;
				setSameBlUpdateReason(memoRow, memoCol,sValue);//--js파일에 있음
				ComHideMemoPad(true);
				
			}
        } catch(err) { ComFuncErrMsg(err.message); }
	}
	
</script>
<form name="form" id="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="call_type" id="call_type" value="ESM_BKG_1121">
<input type="hidden" name="p_send_yn" id="p_send_yn" value="">
<input type="hidden" name="search_eu_pol_cd" id="search_eu_pol_cd" value=''>

<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button class="btn_normal" name="btn_Delete" id="btn_Delete" type="button" style="display:none">Data Delete</button><!--
			 --><button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_New"  	id="btn_New">New</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_DownExcel" 	id="btn_DownExcel">Down Excel</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_EDIDownload" 	id="btn_EDIDownload">Data Download</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_BLAdd" 	id="btn_BLAdd">B/L Add</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_BLDelete" 	id="btn_BLDelete">B/L Delete</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_Inquiry" 	id="btn_Inquiry">Manifest(B/L)</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_Transmit" 	id="btn_Transmit">EDI Transmit</button>	
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
	<div class="opus_design_inquiry">
		<table>
			<colgroup>
				<col width="150"/>
				<col width="20"/>
				<col width="130"/>
				<col width="20"/>
				<col width="150"/>
				<col width="80"/>
				<col width="120"/>
				<col width="70"/>
				<col width="120"/>
				<col width="70"/>
				<col width="*" />				
			</colgroup>
			<tbody>
				<tr>
				 	<th class="sm pad_left_4"><input type="radio" name="p_data_cd" id="p_data_cd1" value="BL" class="trans" checked><!----><label for="p_data_cd1">B/L Data</label>
				 	<input type="radio" name="p_data_cd" id="p_data_cd2" value="DL"   class="trans"><!----><label for="p_data_cd2">Download Data</label></th>
				 	<td></td>
				   	<th class="sm pad_left_4"><input type="radio" name="p_error_cd" id="p_error_cd"  value="" class="trans" checked><!--  --><label for="p_error_cd1">All</label>
					<input type="radio" name="p_error_cd" id="p_error_cd"   value="E" class="trans"><!--  --><label for="p_error_cd2">Error  B/L</label></th>
					<td></td>
					<th class="sm pad_left_4"><input type="radio" name="p_ori_amd_cd" id="p_ori_amd_cd1"  value="O" class="trans" checked><!--  --><label for="p_ori_amd_cd1">Original</label>
					<input type="radio" name="p_ori_amd_cd" id="p_ori_amd_cd2"   value="A" class="trans"><!--  --><label for="p_ori_amd_cd2">Amendment</label></th>
					<th>BKG OFC</th>
					<td><input type="text" style="width:90px;ime-mode:disabled" class="input" id="p_b_ofc_cd" name="p_b_ofc_cd" maxlength='6' dataformat='engup' ></td>
					<th>Sales OFC</th>
					<td><input type="text" style="width:90px;ime-mode:disabled" class="input"  id="p_s_ofc_cd" name="p_s_ofc_cd" maxlength='6' dataformat='engup'></td>
					<th>BKG Staff</th>
					<td><input type="text" style="width:90px;ime-mode:disabled" class="input" id="p_b_staff" name="p_b_staff" value=""  maxlength='20'  dataformat='engup'></td>
				</tr>
			</tbody>
		</table>
		
		<table>
			<colgroup>
				<col width="40"/>
				<col width="140"/>
				<col width="60"/>
				<col width="140"/>
				<col width="30"/>
				<col width="173" />	
				<col width="50"/>
				<col width="*" />				
			</colgroup> 
			
			<tbody>
				<tr>
					<th title="Vessel Voyage Direction">VVD</th>
					<td><input type="text" style="width:90px;" class="input1" name="p_vvd_cd" id="p_vvd_cd" value=""  maxlength="9" dataformat="engup" style="ime-mode:disabled"></td>
					<th>EU POL</th>
					<td>
						<script type="text/javascript">ComComboObject('p_pol_cd_temp', 1, 94, ' ',1);</script><!-- 
						 --><input type="hidden" style="width:70px;" class="input1" name="p_pol_cd" id="p_pol_cd" value="" maxlength="5" dataformat="engup" style="ime-mode:disabled" ><!-- 
						 --><input type="hidden" style="width:30px;" class="input" name="p_pol_yard_cd" id="p_pol_yard_cd" maxlength="2" dataformat="engup" style="ime-mode:disabled">
						 </td>
					<th title="Port of Discharging">POD</th>  
					<td><input type="text" style="width:60px;" class="input" name="p_pod_cd" id="p_pod_cd" value="" maxlength="5" dataformat="engup" style="ime-mode:disabled" ><!-- 
					 --><input type="text" style="width:30px;" class="input" name="p_pod_yard_cd" id="p_pod_yard_cd" maxlength="2" dataformat="engup" style="ime-mode:disabled">
					</td>
					<th>BL/No</th>
					<td><input type="text" style="width:110px;" class="input" name="p_bl_no" id="p_bl_no" value=""  maxlength="12" dataformat="engup" style="ime-mode:disabled">
				</tr>
			</tbody>
		</table>
		
	</div>
<!-- opus_design_inquiry(E) -->
</div>

<div id="div_option" style="padding-left: 15px;" name="div_option"></div>
<div class="wrap_result">
<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="mainTable" name="mainTable">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
<!-- opus_design_grid(E) -->

	<!-- opus_design_data (S) -->
	<div class="opus_design_inquiry">
		<table>
			<tbody>
			<colgroup>
				<col width="70" />
                <col width="90"  />
                <col width="30"  />
                <col width="70"  />
                <col width="80" />
                <col width="30"  />
                <col width="80" />
                <col width="80"  />
                <col width="30" />
                <col width="80"  />
                <col width="80" />
                <col width="30" />
                <col width="40"  />
                <col width="80" />
                <col width="30" />
                <col width="60"  />
                <col width="80" />
                <col width="30" />
                <col width="90"  />
                <col width="*" />
			</colgroup>
				<tr>
					<td style="text-align: left; font-weight: bold; padding-left:10px;">Error B/L</td>
					<td><input type="text" style="width:70px;color:red;" value="" class="input2"  id="div_ttl_err" name="div_ttl_err" style='color:red' readonly></td>
					<th colspan="2">Total Container</th>
					<td><input type="text" style="width:70px;" value="" class="input2"  id="div_ttl_cntr" name="div_ttl_cntr" readonly>
					 			    <input type="hidden" style="width:70px;" name="port_ofc_cd" id="port_ofc_cd" value="" ></td>
					<td colspan="16"></td>
				</tr>
				<tr><td colspan="20" style="padding-top: 5px;"> </td></tr>
				<tr>
					<td style="text-align: left; font-weight: bold; padding-left:10px;">Total B/L</td>
					<td><input type="text" style="width:70px;" value="" class="input2" id="div_ttl_bl" name="div_ttl_bl" readonly></td>
					<td style="text-align:center"> = </td>
					<td style="text-align: left; font-weight: bold;">Sent B/L</td>
					<td><input type="text" style="width:60px;" value="" class="input2"  name="div_sent_bl_cnt" id="div_sent_bl_cnt" readonly></td>
					<td style="text-align:center"> + </td>
					<td style="text-align: left; font-weight: bold; color:red">Un-Sent B/L</td>
					<td><input type="text" style="width:60px;" value="" class="input2"  name="div_unsent_bl_cnt" id="div_unsent_bl_cnt" readonly style='color:red'></td>
					<td colspan="12"></td>					
				</tr>	
				<tr ><td colspan="20" style="padding-top: 5px;"> </td></tr>
				<tr>
					<td style="text-align: left; font-weight: bold;padding-left:10px;">Sent B/L</td>
					<td><input type="text" style="width:70px;" value="" class="input2" id="div_sent_bl_cnt2" name="div_sent_bl_cnt2" readonly></td>
					<td style="font-weight: bold; text-align: center"> = </td>
					<td style="text-align: left; font-weight: bold;" >Accepted</td>
					<td><input type="text" style="width:60px;" value="" class="input2"  id="div_a_cnt" name="div_a_cnt" readonly></td>
					<td style="font-weight: bold; text-align: center"> + </td>
					<td style="text-align: left; font-weight: bold; color:red">Rejected</td>
					<td><input type="text" style="width:60px;" value="" class="input2"  name="div_r_cnt" id="div_r_cnt" readonly style='color:red'></td>
					<td style="font-weight: bold; text-align: center"> + </td>
					<td style="text-align: left; font-weight: bold; color:red">Do Not Load</td>
					<td><input type="text" style="width:60px;" value="" class="input2"  id="div_dnl_cnt" name="div_dnl_cnt" readonly style='color:red'></td>
					<td style="font-weight: bold; text-align: center"> + </td>
					<td style="text-align: left; font-weight: bold; color:red">Hold</td>
					<td><input type="text" style="width:60px;" value="" class="input2"  id="div_h_cnt" name="div_h_cnt" readonly style='color:red'></td>
					<td style="font-weight: bold; text-align: center"> + </td>
					<td style="text-align: left; font-weight: bold;">Released</td>
					<td><input type="text" style="width:60px;" value="" class="input2"  id="div_l_cnt" name="div_l_cnt" readonly></td>
					<td style="font-weight: bold; text-align: center"> + </td>
					<td style="text-align: left; font-weight: bold; color:red">Not Received</td>
					<td><input type="text" style="width:60px;" value="" class="input2"  id="div_nr_cnt" name="div_nr_cnt" readonly style='color:red'></td>
				</tr>	
				<tr ><td colspan="20" style="padding-top: 5px;"></td></tr>
				<tr>
					<td colspan="20" style="padding-left:10px;"> * EORI No Validation : <a target='_blank' href="http://ec.europa.eu/taxation_customs/dds2/eos/eori_validation.jsp" target="_blank">http://ec.europa.eu/taxation_customs/dds2/eos/eori_validation.jsp  </a></td>
				</tr>
				<tr ><td colspan="20" style="padding-top: 5px;"> </td></tr>
				<tr>
					<td colspan="20" style="padding-left:10px;"> * HS Code Validation : <a target='_blank' href="http://ec.europa.eu/taxation_customs/dds2/taric/taric_consultation.jsp?Lang=en" target="_blank">http://ec.europa.eu/taxation_customs/dds2/taric/taric_consultation.jsp?Lang=en  </a>	</td>
				</tr>
			</tbody>
		</table>
	</div>
<!-- opus_design_data(E) -->

<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="mainTable" name="mainTable" style="display:none">
			<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
<!-- opus_design_grid(E) -->
<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="mainTable" name="mainTable" style="display:none">
			<script type="text/javascript">ComSheetObject('sheet3');</script>
	</div>
<!-- opus_design_grid(E) -->
</div>
</form>

