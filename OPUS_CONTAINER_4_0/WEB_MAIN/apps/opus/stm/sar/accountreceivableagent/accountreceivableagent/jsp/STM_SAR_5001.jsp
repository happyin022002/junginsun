<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : stm_sar_5001.jsp // 수정
*@FileTitle  : Agent Collection Entry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/06
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.event.StmSar5001Event"%> 
<%@ page import="org.apache.log4j.Logger" %>


<%
    StmSar5001Event event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지

	String asa_no  = "";

	String strUsr_id = "";
	String strUsr_nm = "";
	String strUsr_ofc = "";
	Logger log = Logger.getLogger("com.clt.apps.opus.stm.sar.accountreceivableagent.AccountreceivableagentSC"); //수정

	String glmonFm = JSPUtil.getKST("yyyy-MM-dd");
	String glmonTo = JSPUtil.getKST("yyyy-MM-dd");

	String duedtFm = ""; //JSPUtil.getKST("yyyy-MM-dd");
	String duedtTo = "";   //JSPUtil.getKST("yyyy-MM-dd");



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
		event = (StmSar5001Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		asa_no = request.getParameter("asa_no");
		asa_no = asa_no==null?"":asa_no;

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

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();  // .js 호출
	}
</script>

<form name="form" id="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="ar_ofc_cd" id="ar_ofc_cd" />
<input type="hidden" name="curr_cd" id="curr_cd" />
<input type="hidden" name="dp_prcs_knt" id="dp_prcs_knt" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_retrieve" id="btn_retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_new" id="btn_new" type="button">New</button><!--
		--><button class="btn_normal" name="btn_save" id="btn_save" type="button">Save</button><!--
		--><button class="btn_normal" name="btn_downexcel" id="btn_downexcel" type="button">Down Excel</button><!--
		--></div>
	<!-- opus_design_btn (E) -->

	<!-- page_location(S) -->
	<div class="location">	
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
				<col width="50" />				
				<col width="190" />				
				<col width="70" />				
				<col width="300" />				
				<col width="50" />	
				<col width="160" />				
				<col width="120" />	
				<col width="100" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
		   			<th>Agent</th>
		            <td><script type="text/javascript">ComComboObject('agn_ofc_cd', 1, 80, 1, 1);</script></td>  
		            <th>A.S.A No</th>
		            <td><input name="asa_no1" type="text" class="input2" style="width:50px;" readonly="true" value=""  id="asa_no1"/>- <!--  
					    --><input name="asa_no2" type="text" class="input2" style="width:50px;" value="" readonly="false" id="asa_no2" />- <!--  
					    --><input name="asa_no3" type="text" class="input2" style="width:50px;" value="" readonly="false" id="asa_no3" /><!-- 
		                --><button type="button" id="btn_pop_asa_cd" name="btn_pop_asa_cd" class="input_seach_btn"></button>
		             <th>Period</th>
		             <td><input name="gl_yrmon_fm" type="text" style="width:80px;" class="input2" value="" dataformat="ymd" maxlength="8" readonly id="gl_yrmon_fm" />- <!-- 
		                 --><input name="gl_yrmon_to" type="text" style="width:80px;" class="input2" value="" dataformat="ymd" maxlength="8" readonly="" id="gl_yrmon_to" onchange="gl_yrmon_to_OnChange()"/>
		            <th>Currency</th>
		            <td><input name="asa_curr_cd" type="text" class="input2" style="width:50px;" value="" readonly id="asa_curr_cd" onchange="asa_curr_cd_OnChange()"/> </td>
		            <td></td>
		   		</tr>
				<tr>
		             <th>Option 1</th>
		             <td><!--  
		                   --><input type="radio" name="option1" value="C" class="trans" checked id="option11" onclick="change_event_radio1();" checked/><label for="option11">Collection</label><!-- 
		                   --><input type="radio" name="option1" value="R" class="trans" id="option12" onclick="change_event_radio1();" /><label for="option12">Refund</label></td>
		             <th>Bound</th>
		             <td><select name="bnd" class="input1" style="width:85px;">
		                    <option value="ALL" selected>All</option>
							<option value="I">Inbound</option>
							<option value="O">Outbound</option>
		                  </select></td>
		             <th>SCP/Port</th>
		             <td><input name="svc_scp_cd" type="text" class="input" dataformat="enguponly" style="width:40px;" id="svc_scp_cd" /><strong>/</strong>&nbsp;<input name="port_cd" type="text" class="input" dataformat="engup" style="width:40px;" id="port_cd" /></td>
		             <td></td>
		             <td></td>
		             <td></td>
		         </tr>
		         <tr>
		             <th>Option 2</th>
		             <td><span style="font-weight:normal"><!-- 
		             	 --><input type="radio" name="option2" value="D" class="trans" checked id="option21" onclick="change_event_radio2();"/><label for="option21">Due Date</label><!-- 
		                 --><input type="radio" name="option2" value="V" class="trans" id="option22" onclick="change_event_radio2();"/><label for="option22">VVD</label></span></td>
		             <th>Due Date</th>
		             <td><input name="due_dt_fm" type="text" style="width:80px;" class="input" value="<%=duedtFm%>" dataformat="ymd" maxlength="8" id="due_dt_fm" /><!-- 
		              --><button type="button" id="btnCalduedtFm" name="btnCalduedtFm" class="calendar ir"></button>- <!-- 
		              --><input name="due_dt_to" type="text" style="width:80px;" class="input" value="<%=duedtTo%>" dataformat="ymd" maxlength="8" id="due_dt_to" /><!-- 
		              --><button type="button" id="btnCalduedtTo" name="btnCalduedtTo" class="calendar ir"></button>
		             <th title="Vessel Voyage Direction">VVD</th>
		             <td><input name="vvd_cd" type="text" class="input" style="width:90px;" dataformat="engup" id="vvd_cd" /></td>
		          	<td></td>
		          	<td></td>
		          	<td></td>
		         </tr>		   		
		   </tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button class="btn_accent" name="btn_add" id="btn_add" type="button">Row Add</button><!--
			--><button class="btn_normal" name="btn_del" id="btn_del" type="button">Row Delete</button><!--
			--></div>
		<!-- opus_design_btn (E) -->
		<script type="text/javascript">ComSheetObject('sheet1');</script>		
	</div>
	<!-- opus_design_grid(E) -->
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
		<table>
			<colgroup>
				<col width="90" />
				<col width="70" />
				<col width="70" />
				<col width="100" />
				<col width="70" />
				<col width="100" />
				<col width="70" />
				<col width="100" />
				<col width="100" />
				<col width="100" />
				<col width="100" />
				<col width="100" />
				<col width="100" />
				<col width="*" />
		   </colgroup> 
		   <tbody>
		   		<tr>
	               <th>Total Count</th>
	               <td><input name="ttl_cnt" type="text" style="width:50px;text-align:right;" class="input2" value="" id="ttl_cnt" /></td>
		           <th>TTL AMT</th>
		           <td><input name="ttl_amt_sum" type="text" style="width:80px;text-align:right;" class="input2" value="" id="ttl_amt_sum" /></td>
		           <th>USD AMT</th>
		           <td><input name="usd_amt_sum" type="text" style="width:80px;text-align:right;" class="input2" value="" id="usd_amt_sum" /></td>
		           <th>Equivalence LCL</th>
		           <td><input name="eqv_lcl_sum" type="text" style="width:80px;text-align:right;" class="input2" value="" id="eqv_lcl_sum" /></td>
		           <th>Source AMT</th>
		           <td><input name="source_amt_sum" type="text" style="width:80px;text-align:right;" class="input2" value="" id="source_amt_sum" /></td>
		           <th>Charge AMT</th>
		           <td><input name="charge_amt_sum" type="text" style="width:80px;text-align:right;" class="input2" value="" id="charge_amt_sum" /></td>		           
		           <th>Equivalence LCL2</th>
		           <td><input name="eqv_lcl2_sum" type="text" style="width:80px;text-align:right;" class="input2" value="" id="eqv_lcl2_sum" /></td>
			    </tr>
                <tr style="display:none;">
                   <td></td>
                   <td></td>
	               <th>3rd AMT1</th>
	               <td><input name="n3rd_amt1_sum" type="text" style="width:80px;text-align:right;" class="input2" value="" id="n3rd_amt1_sum" /></td>
		           <th>3rd AMT2</th>
		           <td><input name="n3rd_amt2_sum" type="text" style="width:80px;text-align:right;" class="input2" value="" id="n3rd_amt2_sum" /></td>
		           <th>3rd AMT3</th>
		           <td><input name="n3rd_amt3_sum" type="text" style="width:80px;text-align:right;" class="input2" value="" id="n3rd_amt3_sum" /></td>
		           <th>3rd AMT4</th>
		           <td><input name="n3rd_amt4_sum" type="text" style="width:80px;text-align:right;" class="input2" value="" id="n3rd_amt4_sum" /></td>
	         	</tr>
		   </tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->		
</div>
</form>
<%@include file="/bizcommon/include/common_alps.jsp"%>
