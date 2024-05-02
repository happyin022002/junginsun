<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_EQR_1021.jsp
*@FileTitle : MTY COD Simulation
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
<%@ page import="com.clt.apps.opus.ees.eqr.cntrcodconfirm.emptycodadjustment.event.EesEqr1021Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesEqr1021Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			
	String strErrMsg = "";						
	int rowCount	 = 0;						//DB ResultSet 

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesEqr1021Event)request.getAttribute("Event");
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

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">


<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title">
		<button type="button"><span id="title"></span></button>
	</h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
		<div class="opus_design_btn"><!--
		--><button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!-- 
	    --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!-- 
	    --><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!-- 
	    --><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button>
		</div>
		<!-- opus_design_btn(E) -->	
	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
</div>
<!-- page_location(E) -->


<!-- TAB  -->
	<div class="opus_design_inquiry">
		<!-- no TAB  -->
		<table>
			<colgroup>
				<col width="40px" />
				<col width="160px" />
				<col width="38px" />
				<col width="90px" />
				<col width="280px" />
				<col width="160px" />
				<col width="30px" />
				<col width="82px" />
				<col width="100px" />
				<col width="*" />
			</colgroup>
			<tbody>
				<tr>
					<th>Period</th>
					<td width="160" class="sm">
						<input type="text" style="width:55px;" class="input1" value="" name="week" id="week" required style="ime-mode:disabled"  dataformat="yw" maxlength="6"> (YYYY-WW)
					<th>Trade </th>
					<td width="90"><select style="width:60px;" class="input" name="trade">
						<option value="" selected >All</option>
			 			<option value="TPS" >TPS</option>
						<option value="AES" >AES</option>
						<option value="IAS" >IAS</option>
                        <option value="EMS" >EMS</option>
						</select></td>
					<th>
						<table class="search_sm2" border="0" style="width:240px;" > 
							<tr class="h23" >
								<td><input type="radio" class="trans" name="tpsz" checked value="D"> DRY &nbsp;<input type="radio" class="trans" name="tpsz" value="S">SPCL(RF,OT,FR) &nbsp;&nbsp;<input type="radio" class="trans" name="tpsz" value="A">ALL
								</td>
							</tr></table>
						</th>
					<th style="padding-bottom:3"><!--  Button_Sub (S) -->
						<button type="button" class="btn_etc" name="btn_remark" id="btn_remark">Remark by VVD</button>
						
		    			<!-- Button_Sub (E) -->
		    		</th>
					<th title="Vessel Voyage Direction">VVD</th>
					<td><input type="text" style="width:80px;" value=""  name="searchvvd"  style="ime-mode:disabled"   maxLength ="9" dataformat="engup" ></td>
					<th style="padding-bottom:3"><!--  Button_Sub (S) -->
						<button type="button" class="btn_etc" name="btn_mainretrieve" id="btn_mainretrieve">Retrieve</button>
						
			    			<!-- Button_Sub (E) -->
			    	</th>
                    <td width=""></td>
				</tr>
			</tbody>
		</table>
		
		
	</div>
	<!-- inquiry_area(E) -->
	
	<iframe src="EES_EQR_1021_01.do"  width="100%"  height="625"  frameborder="0"  name="frameLayer0" id="frameLayer0"  scrolling="auto" ></iframe>
		
</form>