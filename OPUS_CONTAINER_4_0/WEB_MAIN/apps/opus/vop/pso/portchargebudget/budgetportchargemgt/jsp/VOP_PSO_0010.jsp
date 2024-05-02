<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_pso_0010.jsp
*@FileTitle : Estimate Expense Creation
*Open Issues :
*Change history : 
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.event.VopPso0010Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopPso0010Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.PortChargeBudget.BudgetPortChargeMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopPso0010Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="vvd" value="" />


<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	    
	    <!-- page_title(S) -->
	    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	    <h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	    <!-- page_title(E) -->
    	
	    <!-- opus_design_btn(S) -->
	    <div class="opus_design_btn">
	        <!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
			<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
			--><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!--
			--><button type="button" class="btn_normal" name="btn_detail" id="btn_detail">Detail</button><!--
			--><button type="button" class="btn_normal" name="btn_exp" id="btn_exp">Expense Apply</button>
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
	<div class="opus_design_inquiry">
	    <!-- 조회영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <table>
	        <colgroup>
	        	<col width="100px" />
	            <col width="120px" />
	            
	        	<col width="80px" />
	            <col width="220px" />
	            
	            <col width="30px" />
	            <col width="110px" />
	            
	            <col width="30px" />
	            <col width="100px" />
				
	            <col width="" />
	        </colgroup>
	        <tbody>
				<tr>
					<th>Accrual Month</th>
					<td><input name="exe_yrmon" dataformat="ym" maxlength="6" type="text" style="ime-mode:disabled; width:65px; text-align:center;" class="input1" value=""><!-- 
					 --><button type="button" id="btns_calendar_r" name="btns_calendar_r" class="calendar ir"></button>
					</td>
					<th>Rev. Month</td>
					<td>
						<input type="text" name="txtsdate" dataformat="ym" maxlength="6" size="10" cofield="txtedate" style="width:55px;" class="input1" value=""><!--
						--><button type="button" class="calendar" name="btns_calendar_s" id="btns_calendar_s"></button>
						~
						<input type="text" name="txtedate" dataformat="ym" maxlength="6" size="10" cofield="txtsdate" style="width:55px;" class="input1" value=""><!--
						--><button type="button" class="calendar" name="btns_calendar_e" id="btns_calendar_e"></button>
					</td>
					<td></td>
					<th><input type="checkbox" name="mismatched" id="mismatched" value=""/><label for="mismatched">Mismatched</label><!-- 
					 -->&nbsp;&nbsp;<input type="checkbox" name="hide_vrtl_port_flg" id="hide_vrtl_port_flg" value="Y" checked/><label for="hide_vrtl_port_flg">Hide Virtual Port</label></td>
					<th>Status</th>						
					<td width=""><input type="text" name="status" class="input2" readonly/></td>
					<td></td>
				</tr>
				<tr>
					<th>Lane Code</td>
					<td><input name="lane" dataformat="engup"  maxlength="3" type="text" style="width:50px;ime-mode:disabled;text-align:center;" class="input" value=""><button type="button" class="input_seach_btn" name="btns_search" id="btns_search"></button></td>
					<th>VVD</td>
					<td>
						<input type="text" name="vsl_cd" dataformat="engup" style="width:50px;ime-mode:disabled;text-align:center;" class="input" value="" maxlength="4"><!-- 
					 --><input type="text" name="skd_voy_no" maxlength="4" dataformat="num" style="width:40px;ime-mode:disabled;text-align:center;" class="input" value="" ><!-- 
					 --><input type="text" name="skd_dir_cd" dataformat="engup" style="width:25px;ime-mode:disabled;text-align:center;" class="input" value=""  maxlength="1"><!-- 
					 --><button type="button" class="input_seach_btn" name="btn_vvd_search" id="btn_vvd_search"></button>
					</td>
					<th>Port</th>
					<td><input id="port_cd" name="port_cd" dataformat="engup" style="width: 50px;" class="input" value="" size="5" maxlength="5" type="text" /><button class="input_seach_btn" name="btn_port_cd" id="btn_port_cd" type="button"></button><script type="text/javascript">ComComboObject('yard_cd',2, 50, 0, 0);</script></td>
					<td colspan="3"></td>
				</tr>
				
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>	
	
<div class="wrap_result">	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		
	    <!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    <script language="javascript">ComSheetObject('sheet1');</script>
	    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
	<!-- opus_design_grid(E) -->
	<div>
	<table border="0" style="width:100%">
		<tr>
		<td width="50px"><b><font color='#FF0000'>* Red</font></b></td><td align="left">Need to setup tariff first or tariff expired.<b>(Mismatched)</b></td>
		</tr>
		<tr>
		<td><b><font color='#F44EDC'>* Pink</font></b></td><td align="left">Need to check tariff condition / rate or object value / Compulsory flag.<b>(Mismatched)</b></td>
		</tr>
		<tr>
		<td><b><font color='#0054FF'>* Blue</font></b></td><td align="left">Need to check tariff's Vendor or recalculation needed due to Estimate Rev. VVD/SKD changed.<b>(Mismatched)</b></td>
		</tr>
		</tr>
		<td><b><font color='#000000'>* Black</font></b></td><td align="left">Normal.(Including info. message)</td>
		</tr>
	</table>
	</div>
</div>	
</form>