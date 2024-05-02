<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : STM_SAR_1002.jsp
*@FileTitle  : Outstanding Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/07
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.event.StmSar1002Event"%> 
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List"%>
<%@ page import="com.clt.bizcommon.util.BizComUtil"%>


<%
    StmSar1002Event event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지

	int rowCount	 = 0;						//DB ResultSet Count of list
	String pageRows  	    = "1000";
	
	String strUsr_id = "";
	String strUsr_nm = "";
	String strUsr_ofc = "";
	Logger log = Logger.getLogger("com.clt.apps.opus.stm.sar.accountreceivableoutstanding.AccountReceivableOutstandingSC"); //수정

	//String asofDt =DateTime.addMonths(JSPUtil.getKST("yyyy-MM-dd"),-1,"yyyy-MM-dd");
	String asofDt = JSPUtil.getKST("yyyy-MM-dd");

	String asofDtFm = JSPUtil.getKST("yyyy-MM-dd");
	String asofDtTo = JSPUtil.getKST("yyyy-MM-dd");

	try {
		/*
		꼭 유저의 정보를 받을 필요는 없습니다. 화면에서 유저의 이름이나 
		권한같은 정보를 이용할 필요가 있을 경우에만 사용하면 됩니다.
		덧붙여 USER 정보에 대해서 한마디로 정리하면 user 의 정보를 이용할수 있는 곳은 jsp 와 command 입니다.
		jsp에서는 유저의 정보를 가지고 권한에 따른 버튼 처리등을 할수가 있는 것이고 (enable/disable)
		command에서는 역시 유저의 정보로 예를 들어 update 권한등이 있는지를 확인할 수가 있는 것입니다.

		주의> 사용자 테이블이 변경됨에 따라 변경 될 것입니다.
			SignOnUserAccount 의 메서드를 확인 하십시오.
			getAuth 메서드는 현재 미정이지만 권한 관련 value를 가져올 메서드가 있겠죠? 
	     */
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_ofc = account.getOfc_cd();
		/* 
		일단 화면에서 USER가 입력한 정보를 다시 화면에서 사용해야 하는 경우 
		request에 담아 서버로 전송시켰다가 다시 그 request에서 받아야 한다고 했습니다.
		이때 유저가 작성한 자료는 event 에 서버로부터 전송된 자료는 eventResponse에 담기게 됩니다.
		이렇게 받은 정보는 jsp 맨 하단에 있는 java script로부터 폼의 value로 값을 전달하게 됩니다.
		본 jsp소스 맨 하단을 참조하십시오.
		*/
		/* 
		ErrorHandler를 통해서 받는 에러는 CO_ERRMESSAGE 테이블에 입력되어있는 
		개발자가 정의했거나 공통팀에서 결정한 정의가 되어진 에러메세지입니다 
		Command 에서 EventException으로 throw를 했거나 DAO에서 DAOException을 통해 
		jsp 까지 전달이 되게 됩니다. 해당 파일을 참조하십시오.
		jsp에서 최후에 에러가 display될때 onload시에 실행되는 ShowErrMessage 를 통해 showErrMessage();가 뜨게 됩니다.
		(주의) 이 에러메세지와 자바스크립트 에러를 혼동하지는 마십시오. 
			자바스크립트 에러는 서버로 전송하기전에 "주민등록번호가 잘못되었습니다" 라는 메세지이고 
			throw되는 메세지는 update 를 하려고 권한을 확인해보니까 없어서 
			"해당 권한이 없습니다" 라고 뿌리는 메세지입니다.
	   */
		event = (StmSar1002Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		/* 
		아래부분은 꼭 지켜주셔야 에러메세지가 정상적으로 전달이 됩니다. 
		보시다시피 먼저 에러를 받고 에러가 아닐시에 EventResponse로 값을 전달하셔야 합니다. 
		*/
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

	} catch(Exception ex) {
		log.error("err " + ex.toString(), ex);
		//out.println(e.toString());
	}
%>
<script type="text/javascript">
	var strUsr_id = "<%=strUsr_id%>";
	var strUsr_nm = "<%=strUsr_nm%>";
	var strUsr_ofc = "<%=strUsr_ofc%>";

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}

</script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows"  id="pagerows" value="<%=pageRows%>">
<input type="hidden" name="iPage"> 
<input type="hidden" name="ots_grp_tp_cd" value="" id="ots_grp_tp_cd" />
<input type="hidden" name="multi_ofc_cd" id="multi_ofc_cd" />
<input type="hidden" name="cust_cnt_cd" id="cust_cnt_cd" />
<input type="hidden" name="cust_seq" id="cust_seq" />
<input type="hidden" name="cust_cd" id="cust_cd" />
<input type="hidden" name="ofc_cd" id="ofc_cd" />
<input type="hidden" name="f_cust_cnt_cd" />
<input type="hidden" name="f_cust_seq" />
<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!-- 
		 --><button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_new"  	id="btn_new">New</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_downexcel" 	id="btn_downexcel">Down Excel</button>
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="100">
				<col width="302">
				<col width="40">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th>Date Type</th>
					<td width="140"><select name="date_tp_cd" id="date_tp_cd" class="input1" style="width:130" >
                 <!--    <option  value="A">S/A Date</option>
                    <option  value="I">Invoice Date</option> -->
                  	</select>
                	<input type="text" style="width:80px;" class="input1" value="<%=asofDt%>" name="sail_arr_dt" dataformat="ymd" maxlength="8" id="sail_arr_dt" /><!-- 
                 	 --><button type="button" id="btnCalasofDt" name="btnCalasofDt" class="calendar ir"></button></td>	
                	<th>Office</th>
                	<td><script type="text/javascript">ComComboObject('combo1', 1, 120, 1);</script>
				</tr>
			</tbody>
		</table>
		<table>
			<colgroup>
				<col width="100">
				<col width="120">
				<col width="80">
				<col width="460">
				<col width="40">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th>Customer</th>
					<td class="sm"><input type="text" style="width:30px;display: Inline;" class="input" name="rct_cust_cnt_cd" maxlength="2" dataformat="engup" id="rct_cust_cnt_cd" />
	                <input type="text" style="width:62px;display: Inline;" class="input" name="rct_cust_seq" maxlength="6" dataformat="num" id="rct_cust_seq" />
	                <button type="button" id="btn_pop_credit_cust" name="btn_pop_credit_cust" class="input_seach_btn"></button>
	                <input type="text" style="width:160px;display: Inline;" class="input2" name="cust_nm" readonly tabindex="-1" id="cust_nm" />
	                <button type="button" name="btn_pop_cust_cd" id="btn_pop_cust_cd" class="input_seach_btn"></button>
	                </td>
	                <th>Source</th>
    	            <td><input type="radio" name="kind2_radio" value="ALL" class="trans" checked id="kind2_radio" /><label for="kind2_radio">All</label><!-- 
                  	 --><input type="radio" name="kind2_radio" value="INVAR" class="trans" id="kind2_radio_2" /><label for="kind2_radio_2">FRT</label><!-- 
                  	 --><input type="radio" name="kind2_radio" value="OTHER" class="trans" id="kind2_radio_3" /><label for="kind2_radio_3">Other</label><!-- 
                  	 --><!-- <input type="radio" name="kind2_radio" value="BMS" class="trans" id="kind2_radio_4" /><label for="kind2_radio_4">BULK</label> --><!-- 
                  	 --><input type="radio" name="kind2_radio" value="JOO" class="trans" id="kind2_radio_5" /><label for="kind2_radio_5">J/O</label><!-- 
                  	 --><input type="radio" name="kind2_radio" value="FMS" class="trans" id="kind2_radio_6" /><label for="kind2_radio_6">FMS</label><!-- 
                  	 --><input type="radio" name="kind2_radio" value="STM A%" class="trans" id="kind2_radio_7" /><label for="kind2_radio_7">Agent</label><!-- 
                  	 --><input type="radio" name="kind2_radio" value="TPB" class="trans" id="kind2_radio_8" /><label for="kind2_radio_8">TPB</label><!-- 
                  	 --><input type="radio" name="kind2_radio" value="UNAPP" class="trans" id="kind2_radio_9" /><label for="kind2_radio_9">Unapplied</label></td>                	
                	<td><input type="text" style="width:80px;display:none;" class="input1" value="" name="rhq" id="rhq"/></td>
                	<td></td>
				</tr>
			</tbody>
		</table>
		<table>
			<colgroup>
				<col width="100"> 
				<col width="970">
				<col width="*">
			</colgroup>
			<tbody>
				<tr style="height: 29px">  
					<th class="sm">Summary Group</th>
                	<td class="sm"><input type="radio" name="kind_3" value="CUSTOMER" class="trans" checked id="kind_3_1" /><label for="kind_3_1">Customer</label><!-- 
	                 --><input type="radio" name="kind_3" value="VVD" class="trans" id="kind_3" /><label for="kind_3">VVD</label><!-- 
	                 --><input type="radio" name="kind_3" value="SALESREP" class="trans" id="kind_3_2" /><label for="kind_3_2">Sales Rep</label><!-- 
	                 --><input type="radio" name="kind_3" value="SA_DATE" class="trans" id="kind_3_3" /><label for="kind_3_3">S/A Date</label><!-- 
	                 --><input type="radio" name="kind_3" value="HJSREF" class="trans" id="kind_3_4" /><label for="kind_3_4">Ref No</label><!-- 
	                 --><input type="radio" name="kind_3" value="APAR_OFFSET" class="trans" id="kind_3_5" /><label for="kind_3_5">AR/AP Offset</label><!-- 
	                 --><input type="radio" name="kind_3" value="SCNO" class="trans" id="kind_3_6" /><label for="kind_3_6">S/C No</label><!-- 
	                 --><input type="radio" name="kind_3" value="BLNO" class="trans" id="kind_3_7" /><label for="kind_3_7">BL No</label><!-- 
	                 --><input type="radio" name="kind_3" value="INVNO" class="trans" id="kind_3_8" /><label for="kind_3_8" id="l_kind_3_8">INV No</label>
	                   <input type="text" style="width:100px;display: none;" class="input" value="" name="kind3_code" id="kind3_code" /><!--
	                --><input type="text" style="width:100px;display: none;" class="input" value="" name="kind3_code2" dataformat="engup" id="kind3_code2" /><!--
	                --><input type="text" style="width:45px;border:0;display:none;" class="input2" value="FROM" name="sa_date_fm" readonly="false" id="sa_date_fm" /><!--  
	                --><input type="text" style="width:80px;display: none;" class="input1" value="<%=asofDtFm%>" name="sail_arr_dt_fm" dataformat="ymd" maxlength="8" id="sail_arr_dt_fm" /><!-- 
	                --><button type="button" style="display:none;" id="btnCalasofDtfm" name="btnCalasofDtfm" class="calendar ir"></button><!--  
	                --><input type="text" style="width:35px;border:0;display:none;" class="input2" value="~ TO" name="sa_date_to" readonly="false" id="sa_date_to" /><!--  
	                --><input type="text" style="width:80px;display: none;" class="input1" value="<%=asofDtTo%>" name="sail_arr_dt_to" dataformat="ymd" maxlength="8" id="sail_arr_dt_to" /><!-- 
	                --><button type="button" style="display:none;" id="btnCalasofDtto" name="btnCalasofDtto" class="calendar ir"></button></td>
	                <td></td>
				</tr>
			</tbody>
		</table>
		<table>
			<colgroup>
				<col width="100">
				<col width="80">
				<col width="50">
				<col width="140">
				<col width="61">
				<col width="70">
				<col width="30">
				<col width="70">
				<col width="40">
				<col width="85">
				<col width="50">
				<col width="105">
				<col width="65">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th>Bound</th>
	                <td><select name="bnd" id="bnd" class="input1" style="width:85px;">
	                    <option value="ALL" selected>All</option>
						<option value="I"           >Inbound</option>
						<option value="O"           >Outbound</option>
	                  </select></td>
	                <th>Overdue</th>
	                <td><input type="text" style="width:50px;" class="input" value="" name="overdue_from" dataformat="num" otherchar="-" id="overdue_from" /><span class="dash">~</span><input type="text" style="width:50px;" class="input" value="" name="overdue_to" dataformat="num" otherchar="-" id="overdue_to" /></td>
	                <th>SCP</th>
	                <td><input type="text" style="width:50px;" class="input" value="" name="svc_scp_cd" dataformat="engup" id="svc_scp_cd" /></td>
	                <th>PORT</th>
	                <td><input type="text" style="width:60px;" class="input" value="" name="port" dataformat="engup" id="port" /></td>
	                <th>Credit</th>
	                <td><select name="credit_flg" class="input1" style="width:54px;">
	                    <option value="ALL" selected>All</option>
	                    <option value="Y"           >Yes</option>
						<option value="N"           >No</option>
	                  </select></td>
	                <th>OTS/OPY</th>
	                <td><select name="ots_opy" class="input1" style="width:100px;">
	                    <option value="ALL">All</option>
	                    <option value="OTS" selected>Outstanding</option>
						<option value="OPY"         >Overpaid</option>
	                  </select></td>
	                <th>DTL/SUM</th>
	                <td><select name="summary_yn" class="input1" style="width:90px;">
	                    <option value="D" selected>Detail</option>
	                    <option value="S"         >Summary</option>
	                </select></td>
				</tr>
			</tbody>
		</table>
		<table>
			<colgroup>
				<col width="100">
				<col width="280">
				<col width="40">
				<col width="309">
				<col width="50">
				<col width="120">
				<col width="50">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th>OTS Group</th>
                	<td><script type="text/javascript">ComComboObject('ots_grp_tp_desc' , 3, 80, 1, 0, 0,false ,1);</script><!-- 
                   	 --><input type="text" style="width:168px;" class="input2" name="ots_grp_tp_cd_nm" readonly id="ots_grp_tp_cd_nm" />
                	<th>OTS Type</th>
                	<td><script type="text/javascript">ComComboObject('ots_tp_cd' , 2, 60, 1, 0, 0,false ,1);</script><!-- 
                     --><input type="text" style="width:172px;" class="input2" name="ots_tp_cd_nm" readonly id="ots_tp_cd_nm" />
                	<th>Ex. Rate</th>
                	<td><select name="rate_yn" id="rate_yn" class="input1" style="width:100px;" onclick="change_event_combo()">
	                    <option value="ALL"          >All</option>
	                    <option value="Y"   selected>With Rate</option>
						<option value="N"           >Without Rate</option>
	                  </select></td>
                	<th>BL/INV</th>
                	<td><select name="bl_inv" id="bl_inv" class="input1" style="width:90px;">
	                    <option value="ALL"  selected >All</option>
	                    <option value="B"  >B/L</option>
						<option value="I"           >Invoice</option>
                  	</select></td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="mainTable">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="60">
				<col width="90">
				<col width="30">
				<col width="120">
				<col width="30">
				<col width="*">
			</colgroup>
			<tr>
				<th>BL/INV Count</th>
                <td><input type="text" style="width:70px;text-align:center;" class="input2" value=" " name="bl_inv_count" readonly id="bl_inv_count" /></td>
                <th>USD</th>
                <td><input type="text" style="width:100px;text-align:right;" class="input2" value=" " name="usd_sum" readonly id="usd_sum" /></td>
                <th>LCL</th>
                <td><input type="text" style="width:100px;text-align:right;" class="input2" value=" " name="lcl_sum" readonly id="lcl_sum" /></td>
			</tr>
		</table>
	</div>
</div>
</form>