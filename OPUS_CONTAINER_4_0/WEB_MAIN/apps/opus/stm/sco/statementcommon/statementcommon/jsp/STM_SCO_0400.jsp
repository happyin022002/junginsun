<%/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : STM_SCO_0400.jsp
*@FileTitle : TES Manual Cancellation
*Open Issues :
*Change history : 
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0 
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%-- <%@ page import="com.clt.apps.opus.stm.sco.statementcommon.statementcommon.event.StmSco0400Event"%> --%>
<%@ page import="org.apache.log4j.Logger" %>


<%
    /* StmSco0400Event event = null; */				//PDTO(Data Transfer Object including Parameters)
	Exception serverException = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	
	String strUsr_id  = "";
	String strUsr_nm  = "";
	String strUsr_ofc = "";
	Logger log = Logger.getLogger("com.clt.apps.opus.stm.sco.statementcommon.StatementCommonSC");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id  = account.getUsr_id();
		strUsr_nm  = account.getUsr_nm();
		strUsr_ofc = account.getOfc_cd();
	   
		/* event = (StmSco0400Event)request.getAttribute("Event"); */
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
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
	loadPage();
}
</script>



<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" /> 
<input type="hidden" name="pagerows" id="pagerows" />  

<!-- page_title_area(S) -->

<div class="page_title_area clear">
   <!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" 	id="btn_retrieve">Retrieve</button><!--<!--
		--><button type="button" class="btn_normal" name="btn_new"   	id="btn_new">New</button><!--
		--><button type="button" class="btn_normal" name="btn_save"  	id="btn_save">Save</button><!--
		--><button type="button" class="btn_normal" name="btn_downexcel"  	id="btn_save">Down Excel</button><!-- <button type="button" class="btn_normal" name="btn_auto_cancel" 	id="btn_auto_cancel">Auto Cancel</button> -->
	</div>
	<!-- opus_design_btn(E) -->
	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->
<!-- opus_design_inquiry(S) -->
<div class= "wrap_search">
	<div class= "opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="90"/>
				<col width="120"/>
				<col width="90"/>
				<col width="90"/>
				<col width="*" />
			</colgroup>
			<tbody>
				<tr>
					<th>Accrual Month</th>
					<td>
						<input type="text" style="width:100px;text-align:center;" class="input1" name="exe_yrmon" dataformat="ym" required caption="Accrual Month"><!--
						--><button type="button" class="calendar" name="exe_yrmon_cal" id="exe_yrmon_cal" class="calendar ir"></button>
					</td>
					<th>Cancel Flag</th>
		           	<td><select name="cancel_flg" class="input" style="width:50px;" id="cancel_flg">
		                <option value="N">N</option>
		                <option value="Y">Y</option>
		                </select>
		            </td>
		            <th title="Vessel Voyage Direction">VVD</th>
                    <td><input name="vvd" type="text" style="width:90px;" class="input" maxlength="9" minlength="9" value="" dataformat="engup"  caption="VVD"></td>
                    <th>Yard Code</th>
					<td><input class="input" type="text" style="width:68px;" name="yd_cd" valid="1" title="Yard Code" maxlength="7" onblur="getYardName();" id="yd_cd" dataformat="engup"/><!--  
						 --><button type="button" name="btn_yard" id="btn_yard" class="input_seach_btn"></button><!--  
						 --><input class="input2" type="text" style="width:200px;" name="yd_nm" readonly id="yd_nm" /> </td>
					<td width="300"></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>

<div class="wrap_result">
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
</form>

