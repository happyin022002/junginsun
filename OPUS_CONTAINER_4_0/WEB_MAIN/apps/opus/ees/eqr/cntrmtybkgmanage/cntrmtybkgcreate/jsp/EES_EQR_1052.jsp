<%/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EES_EQR_1052.jsp 
*@FileTitle : BKG Split
*Open Issues :
*Change history : 1. 2014-03-07, CHM-201429123, ROB booking 기능 추가, YongChan Shin
*@LastModifyDate : 2013.08.22
*@LastModifier : 
*@LastVersion : 1.0
* 2013.08.22 
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.event.EesEqr1052Event"%>
<%@ page import="com.clt.apps.opus.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.vo.EesEqr1052ConditionVO" %>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesEqr1052Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id	= "";
	String strUsr_nm	= "";
	Logger log = Logger.getLogger("com.clt.apps.CntrMtyBkgManage.CntrMtyBkgCreate");
	
	String flag         = "";
	String open_flag_rob= "";  // rob 체크 여부
	String bkg_no		= "";
	String bkg_vvd		= "";
	String bkg_pol		= "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesEqr1052Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 1018에서 대상row 를 선택하지 않으면 데이터 없을수 있음.
		flag    	 = JSPUtil.getParameter(request, "flag");	// S : Single BKG SPLIT, M : Multi BKG Split	
		
		open_flag_rob= JSPUtil.getParameter(request, "flag_rob");// 1 : ROB, 0 : NON ROB
		if(open_flag_rob.equals("1")) open_flag_rob = "Y"; 
		else						  open_flag_rob = "N";	
		
		bkg_vvd 	 = JSPUtil.getParameter(request, "vvd");
		bkg_no  	 = JSPUtil.getParameter(request, "bkg_no");
		bkg_pol 	 = JSPUtil.getParameter(request, "pol_cd");
		
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
<!-- 개발자 작업	-->
<input type="hidden" name="flag" value="<%= flag %>" >  					<!-- multi split, single split 구분 -->
<input type="hidden" name="open_flag_rob" value="<%= open_flag_rob %>" >    <!-- rob 여부를 구분() -->
<input type="hidden" name="splitresult" >
<input type="hidden" name="pod_clpt_ind_seq" >
<input type="hidden" name="iPage">
<input type="hidden" name="login_id" value="<%=strUsr_id %>">

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button>
		<button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button>
		<button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button>
		<button type="button" class="btn_normal" name="btn_close" id="btn_close" onClick="javascript:closeWindow();" style="display:none">Close</button>
	</div>
	<!-- opus_design_btn(E) -->	
	
	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->


<!-- popup_contens_area(S) -->
	<!-- inquiry_area(S) -->
	<div class="wrap_search">
		<div class="opus_design_inquiry wFit">
			<table> 
				<tbody>
					<tr>
						<% if(flag.equals("S")) { %>
						<th width="40">VVD</th>
						<td width="40"><input type="text" style="width:80" name="vvd" value="<%= bkg_vvd %>" class="input2" readOnly></td>
						<th width="40">BKG No.</th>
						<td width="40"><input type="text" style="width:90" name="bkg_no" value="<%= bkg_no %>" class="input2" readOnly></td>
						<th width="40">ROB</th>
						<td width="40"><input type="checkbox" name="flag_rob" value="" class="trans" onClick="javascript:changeROB();" ></td>
						<td><script language="javascript">ComComboObject('vvd_rob', 1, 100, 1, 0)</script></td>
						<% } else { %>
						<th width="40">VVD</th>
						<td width="40"><input type="text" style="width:75" name="vvd" class="input1"  maxlength="9"  onChange="javascript:changeVVD();" ></td>
						<th width="40">BKG No.</th>
						<td><script language="javascript">ComComboObject('bkg_no', 1, 120, 1, 0)</script></td>
						<% }        %>	
					</tr>
				</tbody>
			</table>
		</div>
	</div>
		<!-- layout_wrap(S) -->
		<!-- inquiry_area(E) -->

	<!-- layout_wrap(S) -->
	<div class="wrap_result">
		<div class="layout_wrap">
		   <!-- layout_vertical_2(S) -->
			<div class="layout_vertical_3" style="width:50%;padding-right:0px">
				<!-- opus_grid_btn(S) -->
			    <h3 class="title_design">Master Data</h3>
			    <div class="opus_design_grid">
					<div class="opus_design_btn">
						<button type="button" class="btn_normal" name="btng_formatexceldown" id="btng_formatexceldown">Format Excel Down</button>
						<button type="button" class="btn_normal" name="btng_loadexcel" id="btng_loadexcel">Load Excel</button>
						<button type="button" class="btn_normal" name="btng_rowadd" id="btng_rowadd">Row Add</button>
						<button type="button" class="btn_normal" name="btng_rowdel" id="btng_rowdel">Row Delete</button>
                        <button type="button" class="btn_normal" name="btn_CheckOut"     id="btn_CheckOut" style="display:none">Check Out</button>
                        <button type="button" class="btn_normal" name="btn_CheckIn"  id="btn_CheckIn" style="display:none">Check In</button>				
					</div>
		            <script language="javascript">ComSheetObject('sheet1');</script>
		        </div>
				<!-- opus_grid_btn(E) -->
		       <!-- opus_design_grid(E) -->
			</div>
		   
			<div class="layout_vertical_3" style="width:5%;">
				<div style="padding-top:220px;line-height:28px;">
				   	<!-- <table class="search">
						<tr><td align="center"><button type="button" src="/opuscntr/img/button/btns_add.gif" width="26" height="26" alt="" border="0" name="btns_add" /><br><br><button type="button" src="/opuscntr/img/button/btns_del.gif" width="26" height="26" alt="" border="0" name="btns_del"/></td></tr>
					</table> -->
					<table class="search">
						<tr><td align="center"><button type="button" class="btn_etc"  name="btns_add"  id="btns_add" > >> </button><br><br><button type="button" class="btn_etc"  border="0" name="btns_del"  id="btns_del"> << </button></td></tr>
					</table>
		        </div>
			</div>	
			
			<div class="layout_vertical_3" style="width:45%;">	
			    <h3 class="title_design">Split BKG Creation</h3>	
				<div class="opus_design_grid">
	        		POD
	        		<script language="javascript">ComComboObject('pod_yd_cd', 2, 90, 1, 1 )</script>
	        		<input type="text" style="width:130" name="to_etb_dt" class="input2" readOnly>
					<div class="opus_design_btn">
				        		<button type="button" class="btn_normal" name="btng_splitbkgcre" id="btng_splitbkgcre">Split BKG Cre.</button>
				    </div>
		      		<script language="javascript">ComSheetObject('sheet2');</script>
		      	</div>
		       <!-- opus_design_inquiry(E) -->
		   </div>
		   <!-- layout_vertical_2(E) -->
		</div>
	</div>
	<!-- layout_wrap(E) -->

	
<!-- popup_contens_area(E) -->



<!-- 개발자 작업  끝 -->
</form>