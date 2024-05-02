<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_BKG_0511.jsp
*@FileTitle  : Hold Notice: Pre-Hold Notice Set-up
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/02
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg0511Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0511Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//DB ResultSet list count

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd        = "";
	String strPopUp         = "";
    String strPreOfc_cd     = "";
	String strPrePod_cd     = "";
	Logger log = Logger.getLogger("com.clt.apps.InboundBLMgt.HoldNotice");
	
	String mainPage = "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();


		strPopUp     = JSPUtil.getParameter(request, "popUp");
        strPreOfc_cd = JSPUtil.getParameter(request, "ofc_cd");
		strPrePod_cd = JSPUtil.getParameter(request, "pod_cd");
		
		event = (EsmBkg0511Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		//Add logic information data from the server when loading the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		mainPage = JSPUtil.getNull(request.getParameter("mainPage"));

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if

        document.form.ofc_cd.value = "<%="Y".equals(strPopUp)?strPreOfc_cd:strOfc_cd%>";
        document.form.pod_cd.value = "<%="Y".equals(strPopUp)?strPrePod_cd:""%>";       
       
		loadPage();		
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<input type="hidden" name="usr_ofc_cd"     value="<%=strOfc_cd%>">
<input type="hidden" name="hld_ntc_tp_cd"  value="PH">
<input type="hidden" name="hld_ntc_fom_cd" value="**">

<%
	if(mainPage.equals("true")) {		
%>
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		
		<!-- page_title(S) -->
	    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->
	
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_Retrieve" 	id="btn_Retrieve">Retrieve</button><!--  
		 --><button type="button" class="btn_normal" name="btn_Save" 	  	id="btn_Save">Save</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_HoldNotice" 	id="btn_HoldNotice">Hold Notice</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_Delete" 		id="btn_Delete">Delete</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_Copy" 		id="btn_Copy">Copy</button>
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
	
<% 
	} else { 
%>	
	<!-- popup_title_area(S) -->
	<div class="layer_popup_title">
		<div class="page_title_area clear">
			<h2 class="page_title"><span>Hold Notice Set-Up</span></h2>
			<div class="opus_design_btn">
				<button type="button" class="btn_accent" name="btn_Retrieve" 	id="btn_Retrieve">Retrieve</button><!--  
			 --><button type="button" class="btn_normal" name="btn_Save" 	  	id="btn_Save">Save</button><!--  
			 --><button type="button" class="btn_normal" name="btn_HoldNotice" 	id="btn_HoldNotice">Hold Notice</button><!--  
			 --><button type="button" class="btn_normal" name="btn_Delete" 		id="btn_Delete">Delete</button><!--  
			 --><button type="button" class="btn_normal" name="btn_Copy" 		id="btn_Copy">Copy</button><!--  
			 --><button type="button" class="btn_normal" name="btn_Close" 		id="btn_Close">Close</button>				
			</div>
		</div>
	</div>
	<!-- popup_title_area(E) -->
	
	<!-- popup_contens_area(S) -->
	<div class="layer_popup_contents">
<% 
	} 
%>
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
		    <!-- 조회영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
		    <table class="bg">
		    	<tr>
		    		<td>
						<table>
							 <colgroup>
						    	 <col width="100px" />
						         <col width="110px" />
						         <col width="30px" />
						         <col width="200px" />
						         <col width="" />
						     </colgroup>
						     <tbody>
						    	<tr>
									<th>Handling Office</th>
									<td>
										<input type="text" style="width:80px;" class="input1" name="ofc_cd"
	                                        caption="Handling Office" maxlength="6" minlength="5" dataformat="engup" required="" />
									</td>
									<th title="Port of Discharging">POD</th>
									<td>
										<input type="text" style="width:80px;" class="input1" name="pod_cd" caption="POD Code" maxlength="5" minlength="5" dataformat="engup" required="" fullfill="fullfill" /><!--
										--><script type="text/javascript">ComComboObject("pod_cd_list", 1, 100, 0, 0);</script>
									</td>
									<td></td>
								</tr>
							</tbody>							
						</table>
					</td>
				</tr>
				</table>
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				<table>
				<tr>
					<td>
						<table>
							 <colgroup>
						    	 <col width="70px" />
						         <col width="136px" />
						         <col width="160px" />
						         <col width="136px" />
						         <col width="" />
						     </colgroup>
						     <tbody>
						    	<tr>
									<th class="smt">Auto Send</th>
									<td class="smt">
										<input type="radio" class="trans" name="frm_auto_ntc_flg" value="Y" />&nbsp;Yes&nbsp;
                                    	<input type="radio" class="trans" name="frm_auto_ntc_flg" value="N" />&nbsp;No
									</td>
									<th class="sm">Enclose B/L Copy</th>
									<td class="sm">
										<input type="radio" class="trans" name="frm_eclz_obl_flg" value="Y" />&nbsp;Yes&nbsp;
                                    	<input type="radio" class="trans" name="frm_eclz_obl_flg" value="N" />&nbsp;No
									</td>
									<td></td>
								</tr>
							</tbody>							
						</table>
					</td>
				</tr>
				<tr>
					<td>
						<table class="grid2">
							 <colgroup>						    	 
						         <col width="509px" />
						     </colgroup>
						     <tbody>
						    	<tr class="tr2_head">									
									<td align="left">&nbsp;Address</td>									
								</tr>
								<tr>
									<td>
										<input type="text" class="noinput" style="width:100%;" name="frm_addr_ctnt" format="" maxlength="4000" />
									</td>
								</tr>
							</tbody>							
						</table>
					</td>
				</tr>
				<tr>
					<td>
						<table class="grid2">
							 <colgroup>						    	 
						         <col width="509px" />
						     </colgroup>
						     <tbody>
						    	<tr class="tr2_head">									
									<td align="left">&nbsp;From</td>									
								</tr>
								<tr>
									<td>
										<input type="text" style="width:100%;" class="noinput" name="frm_snd_ofc_cntc_ctnt" format="" maxlength="500" />
									</td>
								</tr>
							</tbody>							
						</table>
					</td>
				</tr>
				<tr>
					<td>
						<table class="grid2">
							 <colgroup>						    	 
						         <col width="100%" />
						     </colgroup>
						     <tbody>
						    	<tr class="tr2_head">									
									<td align="left">&nbsp;Important Notice</td>									
								</tr>
								<tr>
									<td>
										<textarea cols="7" rows="13"style="width:100%" caption="Important Notice" name="frm_hld_rmk"></textarea>
									</td>
								</tr>
							</tbody>							
						</table>
					</td>
				</tr>
			</table>
		</div>
	</div>
			
	<div class="wrap_result" style="display:none">				
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" id="mainTable">
		    <script type="text/javascript">ComSheetObject('sheet1');</script>						
		</div>
		<!-- opus_design_grid(E) -->
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" id="mainTable">
			<script type="text/javascript">ComSheetObject('sheet2');</script>			
		</div>
		<!-- opus_design_grid(E) -->
	</div>
<%
	if(!mainPage.equals("true")) {		
%>					
	</div>
<%
	}
%>

</form>
