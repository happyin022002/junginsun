<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_EQR_6001.jsp
*@FileTitle  : MTY COD Simulation 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/15
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.eqr.eqtransportplannperform.emptycodadjustment.event.EesEqr6001Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesEqr6001Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.EQTransportPlanNPerform.EmptyCODAdjustment");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesEqr6001Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// adding logic to get data from server when first loading ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}   
%>

<script type="text/javascript">  
	ComOpenWait(true);
	parent.window.moveTo(0,0);
	parent.window.resizeTo("1600","900");
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
<input type="hidden" name="trade" id="trade">
<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!-- 
		 --><button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_new"  	id="btn_new">New</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_save"  	id="btn_save">Save</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_downexcel" 	id="btn_downexcel">Down Excel</button>
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
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="50">
				<col width="160">
				<col width="50">
				<col width="120">
				<col width="60">
				<col width="130">
				<col width="40">
				<col width="60">
				<col width="50">
				<col width="70">
				<col width="85">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th>Period</th>
					<td><input type="text" style="width:55px;" class="input1" value="" name="week" required dataformat="yw" maxlength="6" id="week" /> (YYYY-WW)</td>
					<th>Trade </th>
					<td><!-- <select style="width:60px;" class="input" name="trade" id="trade">
						<option value="" selected >All</option>
			 			<option value="TPS" >TPS</option>
						<option value="AES" >AES</option>
						<option value="IAS" >IAS</option>
                        <option value="EMS" >EMS</option>
						</select> --><script language="javascript">ComComboObject('combo1', 1, 58 , 0)</script></td>
					<th class="sm"><input type="radio" class="trans" name="tpsz" checked value="D" id="tpsz" onclick="radio_click();" />&nbsp;DRY</th>
					<th class="sm"><input type="radio" class="trans" name="tpsz" value="S" id="tpsz" onclick="radio_click();" />&nbsp;SPCL(RF,OT,FR)</th>
					<th class="sm"><input type="radio" class="trans" name="tpsz" value="A" id="tpsz" onclick="radio_click();"/>&nbsp;ALL</th>
					<td>&nbsp;</td>
					<td><button type="button" class="btn_etc" name="btn_remark" id="btn_remark">Remark by VVD</button></td>
					<th title="Vessel Voyage Direction">VVD</th>
					<td><input type="text" style="width:80px;" value="" name="searchvvd" maxlength="9" dataformat="engup" id="searchvvd" /></td>
					<td><button type="button" class="btn_etc" name="btn_mainretrieve" id="btn_mainretrieve">Retrieve</button></td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->	
</div>
<div style="display:none"><script language="javascript">ComSheetObject('sheet1');</script></div>
				
<div class="wrap_result">
	<iframe src="EES_EQR_6001_01.do"  width="100%"  height="850"  frameborder="0"  name="frameLayer0" id="frameLayer0"  scrolling="auto" ></iframe>
</div>
</form>