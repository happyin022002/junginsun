<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_S304.jsp
*@FileTitle  : My Bidding List  
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/13
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.event.EesMnrS304Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMnrS304Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = ""; 
	String codeList  = "";
	String pageRows  = "100"; 

	String strUsr_id		= ""; 
	String strUsr_nm		= "";  
	String strOfc_cd		= ""; 
	String strRhq_cd 		= "";
	String strVndr_seq		= "";
	String strVndr_nm		= "";


	Logger log = Logger.getLogger("com.clt.apps.OperationManage.DisposalMgt");

	try {     
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();        
		strUsr_nm = account.getUsr_nm();    
	    strOfc_cd = account.getOfc_cd();    
	    strRhq_cd = account.getRhq_ofc_cd();   
		strVndr_seq = account.getOfc_eng_nm();
		strVndr_nm 	= account.getOfc_krn_nm();

		event = (EesMnrS304Event)request.getAttribute("Event"); 
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



<!--MNR 공용 사용  -->                
<script type="text/javascript">  
    var strVndrSeq	= "<%=strVndr_seq%>";
    var strVndrNm	= "<%=strVndr_nm%>";
    var userNm		= "<%=strUsr_nm%>";
    var spPtalId    = "<%=strUsr_id %>";
    var ofcCd 		= "<%=strOfc_cd%>";
	function setupPage(){  
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if	 	 
		loadPage();
	}
</script> 
<script type="text/javascript">ComSheetObject('sheet1');</script> 
<script type="text/javascript">ComUploadObject('upload1', '<%=session.getId()%>');</script>    

<form name="form">  
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="sp_ptal_id" value="<%=strUsr_id %>" id="sp_ptal_id" />
<input type="hidden" name="selected_disp_no" id="selected_disp_no" />
<input type="hidden" name="file_seq" value="" id="file_seq" />
<input type="hidden" name="program_id" value="S304" id="program_id" />
<input type="hidden" name="ofc_cd" value="" id="ofc_cd" />
<!-- RD용  --> 
<input type="hidden" name="com_mrdPath" value="" id="com_mrdPath" />
<input type="hidden" name="com_mrdArguments" value="" id="com_mrdArguments" />
<input type="hidden" name="com_mrdBodyTitle" value="My Bidding List" id="com_mrdBodyTitle" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span >My Bidding List</span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" 		id="btn_Retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_New" 			id="btn_New">New</button><!--
		 --><button type="button" class="btn_normal" name="btn_Submit" 			id="btn_Submit">Submit</button><!-- 	
		 --><button type="button" class="btn_normal" name="btn_Cancel" 			id="btn_Cancel">Cancel</button><!-- 	
		 --><button type="button" class="btn_normal" name="btn_Print" 			id="btn_Print">Print</button><!-- 	 		
	 --></div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
	
</div>
<!-- page_title_area(E) -->
<div class= "wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
		<table>
			<tbody>
				<colgroup>
					<col width="100" />
					<col width="210" />
					<col width="75" />
					<col width="175" />
					<col width="45" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr> 
						<th>Starting Date</th>
						<td><!-- 
						 --><input type="text" name="disp_st_dt_fm" dataformat="ymd" caption="from date" maxlength="10" size="10" cofield="disp_st_dt_to" value="" class="input" id="disp_st_dt_fm" /><!-- 
                          -->~ <input type="text" name="disp_st_dt_to" dataformat="ymd" caption="to date" maxlength="10"  size="10"  cofield="disp_st_dt_fm" class="input">&nbsp;<img name="disp_st_dt_cal" class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"><!-- 
                         --></td>       	
						<th>Bidding No.</th>
						<td><input type="text" name="disp_no" style="width:140px;" class="input" dataformat="engup" id="disp_no" /><button type="button" id="disp_no_multi" name="disp_no_multi" class="multiple_inq ir"></button></td>
						<th>EQ No.</th>
						<td><input type="text" name="eq_no" style="width:140px;" class="input" dataformat="engup" id="eq_no" /><button type="button" id="eq_no_multi" name="eq_no_multi" class="multiple_inq ir"></button></td>
					</tr> 
					<tr> 
						<th>Result</th>
						<td><script type="text/javascript">ComComboObject('result', 1, 90, 1, 0);</script></td> 
						<th>Bidding Status</th>
						<td><script type="text/javascript">ComComboObject('bidding_status', 1, 113,0);</script></td>       	
						<th>Local Time</th>
						<td><input type="text" name="disp_local_dt" style="width:140px;text-align:left;ime-mode:disabled" class="input2" readonly id="disp_local_dt" /> </td>
					</tr>   
				</tbody>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear">
	<table>
		<tr>
			<td><h3 class="title_design">My List</h3></td>
			<td>
				<div class="opus_design_btn">
					<button type="button" class="btn_accent" name="btn_BiddingDetail" 		id="btn_BiddingDetail">Bidding Detail</button><!-- 
					 --><button type="button" class="btn_normal" name="btn_DownExcel" 			id="btn_DownExcel">Down Excel</button><!-- 		
				 --></div>
			</td>
		</tr>
	</table>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->
</div>
<div class="wrap_result">
	<h3 class="title_design">Bidding Detail & My Offer</h3>
	<!-- opus_tab_btn(S) -->
	<div class="opus_design_tab">
		<script type="text/javascript">ComTabObject('tab1')</script>
	</div>
	<!-- opus_tab_btn(E) -->
	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear" name="tabLayer" id="tabLayer">
		<script type="text/javascript">ComSheetObject('t1_sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->
	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear" name="tabLayer" id="tabLayer">
		<script type="text/javascript">ComSheetObject('t2_sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->	
</div>	

<div class= "wrap_search">
	<!-- layout_wrap(S) -->
	<div class="layout_wrap">
	    <div class="layout_vertical_2">
	    	<!-- opus_design_inquiry(S) -->
			<div class="opus_design_inquiry">
				<table class="grid_2 wAuto"> 
					<tr><th>Bidding<br>Remark(s)</th>  
						<td><textarea name="mnr_disp_rmk" id="mnr_disp_rmk" wrap="off" style="width:100%;height:60px;resize:none;" readOnly ></textarea></td>  
					</tr> 
				</table>
			</div>
			<!-- opus_design_inquiry(E) -->
	    </div>
	    <div class="layout_vertical_2">
	    <h3 class="title_design">File Attachment</h3>
	    <div class="opus_design_grid clear">
			<script type="text/javascript">ComSheetObject('sheet3');</script>
		</div>
	    </div>
	</div>
	<!-- layout_wrap(E) -->
</div>		
</form>