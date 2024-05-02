<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : EES_MNR_S122.jsp
*@FileTitle  : SPP Damage Flagging/Unflagging
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
<%@ page import="com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.event.EesMnrS122Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMnrS122Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	  
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";  
 	
	String strUsr_id		= ""; 
	String strUsr_nm		= "";  
	
	Logger log = Logger.getLogger("com.clt.apps.OperationManage.EQFlagMgt");
		      
	try {	    
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();       
		strUsr_nm = account.getUsr_nm(); 
	     
		event = (EesMnrS122Event)request.getAttribute("Event"); 
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
 
		if (serverException != null) {   
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();  
		}       
		   
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	    	  
	}catch(Exception e) {
		out.println(e.toString());
	}
%>	                
<script  type="text/javascript">   
	function setupPage(){	 
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if  
		loadPage();
	}
</script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="eq_no" id="eq_no" />
<input type="hidden" name="eq_tpsz_cd" value="" id="eq_tpsz_cd" />
<input type="hidden" name="mnr_dmg_flg_dt" value="" id="mnr_dmg_flg_dt" />
<input type="hidden" name="mnr_flg_tp_cd" value="" id="mnr_flg_tp_cd" />
<input type="hidden" name="flag_type" value="ALL" id="flag_type" /> 	   
<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<h2 class="page_title"><span>Damage Flagging/Unflagging</span></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrive" 	id="btn_retrive">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_new" 		id="btn_new">New</button><!--
		--><button type="button" class="btn_normal" name="btn_save"  		id="btn_save">Save</button>	
	</div>
	<!-- opus_design_btn(E) -->
</div>
<!-- page_title_area(E) -->
<!-- opus_design_inquiry(S) -->
<div class= "wrap_search">
	<div class= "opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="60"/>
				<col width="120"/>
				<col width="60"/>
				<col width="*"/>
			</colgroup>
			<tbody>
				<tr>
					<th>EQ Type</th>
					<td><script type="text/javascript">ComComboObject('eq_knd_cd',1, 100 , 1,1)</script></td>
					<th>EQ No.</th>
					<td><input required type="text" caption="EQ No" name="eq_list" style="width:100px;" class="input1" dataformat="engup" otherchar="." id="eq_list" /><button type="button" id="eq_no_multi" name="eq_no_multi" class="multiple_inq ir"></button></td>
				</tr>	
			</tbody>
		</table>
	</div>
</div>
<!-- opus_design_inquiry(E) -->
<!-- opus_design_grid(S) -->
<div class="wrap_result">
	<div class="opus_design_grid clear" >
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_downExcel" id="btn_downExcel">Down Excel</button><!--
			--><button type="button" class="btn_normal" name="btn_loadExcel" 	id="btn_loadExcel">Load Excel</button>
		</div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
<!-- opus_design_grid(E) -->
</form>   