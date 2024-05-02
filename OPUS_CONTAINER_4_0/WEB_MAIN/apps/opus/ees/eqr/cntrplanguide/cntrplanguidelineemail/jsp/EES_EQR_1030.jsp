<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_EQR_1030.jsp
*@FileTitle  : Empty Repo Guideline Email
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/09
=========================================================*/
%>     
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.eqr.cntrplanguide.cntrplanguidelineemail.event.EesEqr1030Event"%>
<%@ page import="com.clt.apps.opus.ees.eqr.cntrplanguide.cntrplanguidelineemail.vo.EesEqr1030ConditionVO"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesEqr1030Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);

		event = (EesEqr1030Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		EesEqr1030ConditionVO conditionVO = new EesEqr1030ConditionVO();
		conditionVO = event.getEesEqr1030ConditionVO();

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
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
<form method="post" name="form" onSubmit="return false;">
<input	type="hidden" name="f_cmd">

	<div class="page_title_area clear ">
			<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		
			<div class="opus_design_btn">
				<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--  
				--><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!-- 
				--><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!-- 	
				--><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button>
			</div>
	
			<div class="location">
				<span id="navigation"></span>
			</div>
	</div>

	<div class="wrap_search">
		<div class="opus_design_inquiry wFit">
			<table> 
				<tbody>
					<tr>
						<th width="80">RHQ Office</th>								
						<td width="70">
	      					<select style="width:85px;" class="input" id="f_rhqcd" name="f_rhqcd">
	          				<option value="" selected>ALL</option>
	          				<option value="NYCNA" >NYCNA</option>                        
	          				<option value="HAMUR" >HAMUR</option>    
	          				<option value="SHAAS" >SHAAS</option>    
	          				<option value="SINWA" >SINWA</option>    
	          				<option value="OTHER" >Others</option>    
	          				</select>									
                 		</td>
						<th width="80">Office Code</th>
						<td class="input">
						    <input type="text" class="input" id="f_ofccd" name="f_ofccd" caption="Office"  dataformat="engup" size="10" maxlength="10" fulfill size="10" style="width:100px;" value="" ><!-- 
						    --><button type="button" class="input_seach_btn" id="btns_open_ofc" name="btns_open_ofc"></button>
						</td>
				</tbody>
			</table>
		</div>
	</div>
	
	<div class="wrap_result">
		<div class="opus_design_grid">
			<div class="opus_design_btn">
				<button type="button" class="btn_normal" name="btn_row_add" id="btn_row_add">Row Add</button>
			</div>
			<script language="javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
</form>
</body>
</html>