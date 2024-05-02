<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1034.jps
*@FileTitle  : Pick-up Notice Template(Manual Send)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/13/5
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg1034Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%

	EsmBkg1034Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//serverException
	String strErrMsg = "";						//error massage
	int rowCount	 = 0;						//DB ResultSet list count

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd        = "";
	Logger log = Logger.getLogger("com.clt.apps.InboundBLMgtSC.PickUpNoticeBC");
    String mainPage   = "";
    
	try {
		
		mainPage = JSPUtil.getNull(request.getParameter("mainPage"));
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		

		event = (EsmBkg1034Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		//when open screen, get data in server..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

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
		
		with(document.form) {
            eval("ofc_cd").value        = "<%=strOfc_cd%>";          
            resetFormData();
        }
        
		loadPage();
	}
</script>


<!-- <body  onLoad="setupPage();"> -->
<form name="form" id="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">

<input type='hidden' name='autoSearchFlg' id='autoSearchFlg' value ="<%=JSPUtil.getNull(request.getParameter("autoSearchFlg"))%>">
<input type='hidden' name ='frm_edo_rqst_dt_s' id ='frm_edo_rqst_dt_s' value = "<%=JSPUtil.getNull(request.getParameter("edo_rqst_dt_s"))%>">
<input type='hidden' name ='frm_edo_rqst_dt_e' id ='frm_edo_rqst_dt_e' value = "<%=JSPUtil.getNull(request.getParameter("edo_rqst_dt_e"))%>">
<input type='hidden' name ='frm_bl_no' id ='frm_bl_no' value = "<%=JSPUtil.getNull(request.getParameter("bl_no"))%>">
<input type='hidden' name ='frm_sch_tp' id ='frm_sch_tp' value = "">
<!-- Developer Work	-->


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
			<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_Reset" id="btn_Reset">New</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_Save" id="btn_Save">Save</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_Delete" id="btn_Delete">Delete</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_PickupNotice" id="btn_PickupNotice">Pick-up Notice</button>
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
			<h2 class="page_title"><span>Pick-Up Notice Template ( Manual Send )</span></h2>
			<div class="opus_design_btn">
				<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_Reset" id="btn_Reset">New</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_Save" id="btn_Save">Save</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_Delete" id="btn_Delete">Delete</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_PickupNotice" id="btn_PickupNotice">Pick-up Notice</button><!--  
			 --><button type="button" class="btn_normal" name="btn_Close" 		id="btn_Close">Close</button>				
			</div>
		</div>
		
	   	<!-- page_location(S) -->
	   	<div class="location">
			<!-- location 내용 동적생성 (별도 코딩 불필요) -->
	        <span id="navigation"></span>
	   	</div>
	   	<!-- page_location(E) -->
	   			
	</div>
	<!-- popup_title_area(E) -->
	
	<div class="layer_popup_contents"> 
	
<% 
	} 
%>

	<div class= "wrap_search_tab">
	 	<!-- opus_design_inquiry(S) -->
		<div class= "opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="100"/>
					<col width="*"/>
				</colgroup>
				<tbody>		
					<tr>
		                 <th>Handling Office</th>
		                 <td>
		                     <input type="text" style="width:65px;ime-mode:disabled;" class="input1" name="ofc_cd" id="ofc_cd" value="" caption="Handling Office" maxlength="6" minlength="5" dataformat="enguponly" required="" />
		                 </td>                                            
		            </tr>     
				</tbody>
			</table>
		</div>
		<table class="line_bluedot" ><tr><td colspan="6"></td></tr></table>	
			 <!-- Pickup Notice Setup(S) -->
	          <input type="hidden" name="frm_pkup_ntc_seq"  	 id="frm_pkup_ntc_seq" />     
	          <input type="hidden" name="frm_pkup_ntc_snd_tp_cd" id="frm_pkup_ntc_snd_tp_cd" />
	          <input type="hidden" name="frm_ofc_cd" 			 id="frm_ofc_cd" />
	          <input type="hidden" name="frm_del_cd" 			 id="frm_del_cd" />
	          <input type="hidden" name="frm_auto_ntc_flg" 		 id="frm_auto_ntc_flg" />
	          <input type="hidden" name="frm_each_foc_ntc_flg" 	 id="frm_each_foc_ntc_flg" />
	          <input type="hidden" name="frm_trkr_ntc_flg" 	  	 id="frm_trkr_ntc_flg" />
	          <!-- opus_design_grid(S) -->
		<div class="opus_design_grid clear">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
			<!-- opus_design_grid(E) -->
			<table>
				<colgroup>
					<col width="150"/>
					<col width="250"/>
					<col width="180"/>
					<col width="*"/>
				</colgroup>
				<tbody>		
					<tr>
		                 <th>Enclose Original B/L Copy</th>
		                 <td class="pad_left_12"><input type="radio" class="trans" name="frm_eclz_obl_cpy_flg" id="frm_eclz_obl_cpy_flg" value="Y" />&nbsp;<b>Yes</b>&nbsp;&nbsp;&nbsp;&nbsp;<!-- 
		                      --><input type="radio" class="trans" name="frm_eclz_obl_cpy_flg" id="frm_eclz_obl_cpy_flg" value="N" />&nbsp;<b>No</b>
		                 </td>                                                    
		                 <th style ="display:inline" id="us_form">F/O/C Clear Remark(s) Setup</th>  
	                     <th style="display:none" id="ca_form">F/O Clear Remark(s) Setup</th>               
		                 <td class="pad_left_12">
		                     <input type="radio" class="trans" name="frm_foc_clr_rmk_stup_flg" id="frm_foc_clr_rmk_stup_flg" value="Y" />&nbsp;<b>Yes</b>&nbsp;&nbsp;&nbsp;&nbsp;<!-- 
		                      --><input type="radio" class="trans" name="frm_foc_clr_rmk_stup_flg" id="frm_foc_clr_rmk_stup_flg" value="N" />&nbsp;<b>No</b>
		                 </td>
		           </tr>
		           </tbody>
			</table>
			<div class="opus_design_inquiry mar_top_12">
			     <table>
		        <colgroup>
		            <col width="150px" />
		            <col width="*" />
		        </colgroup>  			     
					<tr>
						<th><b>Head Title</b></th>	
						<td style="padding-left:15px;"><textarea style="resize:none; width:970px;height:36px;ime-mode:disabled;" class="textarea1" rows="2" caption="Head Title" maxLength="500px" required="" name="frm_hd_tit_ctnt" id="frm_hd_tit_ctnt"></textarea></td>					
					</tr>
				</table>
			</div>
		  </div>	
	</div>	
	
	<div class="wrap_result">
		<!-- opus_tab_btn(S) -->
		<div class="opus_design_tab">
			<script type="text/javascript">ComTabObject('tab1')</script>
		</div>
		<!-- opus_tab_btn(E) -->
		<div id="tabLayer" style="display:inline">
			<!-- opus_design_grid(S) -->	
			<div class="opus_design_grid clear">
						
		        <table class="grid2">  
		        <colgroup>
		            <col width="150px" />
		            <col width="*" />
		        </colgroup>  
		             <tr>
		                 <th><b>Bottom Remark(s)</b></th>
	                     <td>
	                         <textarea style="width:100%;height:245px;ime-mode:disabled; resize:none;" caption="Bottom Remark(Event#1)" rows="18" maxLength="3000" name="frm_t1_btm_rmk" id="frm_t1_btm_rmk"></textarea>
	                     </td>		                 
		             </tr>                                   
		        </table>  
				<input type="hidden" name="frm_t1_pkup_ntc_seq" id="frm_t1_pkup_ntc_seq" />
		         <input type="hidden" name="frm_t1_pkup_ntc_fom_cd" id="frm_t1_pkup_ntc_fom_cd" />
		         <input type="hidden" name="frm_t1_eclz_obl_cpy_flg" id="frm_t1_eclz_obl_cpy_flg" />
		         <script type="text/javascript">ComSheetObject('t1sheet1');</script>   
			</div>
		</div>
		<div id="tabLayer" style="display:none">
			<div class="opus_design_grid clear">
				<script type="text/javascript">ComSheetObject('t2sheet1');</script>
				<input type="hidden" name="frm_t2_pkup_ntc_seq" id="frm_t2_pkup_ntc_seq" />
			     <input type="hidden" name="frm_t2_pkup_ntc_fom_cd" id="frm_t2_pkup_ntc_fom_cd" />
			     <input type="hidden" name="frm_t2_eclz_obl_cpy_flg" id="frm_t2_eclz_obl_cpy_flg" />
			       <table class="grid_2">
		          <colgroup>
		              <col width="150px" />
		              <col width="*" />
		          </colgroup> 			       
			            <tr>
			            	<th><b>Bottom Remark(s)</b></th>
			                <td>	
			                    <textarea style="resize:none; width:100%;height:245px;ime-mode:disabled;" caption="Bottom Remark(Event#2)" rows="18"  maxLength="3000" name="frm_t2_btm_rmk" id="frm_t2_btm_rmk"></textarea>
			                </td>			            	 
			            </tr>                                   
			    </table>   
			</div>	
		</div>
		<div id="tabLayer" style="display:none">
			<div class="opus_design_grid clear">
				
				 <table class="grid_2">
		          <colgroup>
		              <col width="150px" />
		              <col width="*" />
		          </colgroup> 					 
				     <tr>
				     	<th><b>Bottom Remark(s)</b></th>
				         <td>
				             <textarea style="resize:none;width:100%;height:245px;ime-mode:disabled;" caption="Bottom Remark(Event#3)" rows="18" maxLength="3000" name="frm_t3_btm_rmk" id="frm_t3_btm_rmk" ></textarea>
				         </td>				     	
				     </tr>                                   
				 </table>   
				 <script type="text/javascript">ComSheetObject('t3sheet1');</script>
				<input type="hidden" name="frm_t3_pkup_ntc_seq" id="frm_t3_pkup_ntc_seq" />
			    <input type="hidden" name="frm_t3_pkup_ntc_fom_cd" id="frm_t3_pkup_ntc_fom_cd" />
			    <input type="hidden" name="frm_t3_eclz_obl_cpy_flg" id="frm_t3_eclz_obl_cpy_flg" />
			</div>
		</div>
	</div>
	<!-- opus_design_grid(E) -->
</div>

<%	if(!mainPage.equals("true")) { %></div><% } %>	
</form>

  