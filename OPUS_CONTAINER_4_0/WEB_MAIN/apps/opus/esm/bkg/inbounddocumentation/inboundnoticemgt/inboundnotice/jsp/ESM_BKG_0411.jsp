<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0411.jsp
*@FileTitle  : Pick up Notice Setup
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/27
=========================================================*/
%>
 
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg0411Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0411Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd        = "";
    String code = "";
    String value = "";
    String mainpage = "";
	Logger log = Logger.getLogger("com.clt.apps.InboundBLMgt.PickUpNotice");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
        strOfc_cd = account.getOfc_cd();
        mainpage = request.getParameter("mainPage");

		event = (EsmBkg0411Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// get data from server when load page ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        code = eventResponse.getETCData("code");
        value = eventResponse.getETCData("value");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script type="text/javascript">

	var evtCode = "-|NA|<%= code%>";
	var evtValue = "-|N/A|";

	var splitCode = "<%= code%>".split('|');
	var splitValue = "<%= value%>".split('|');
	
	for(var i=0; i<splitValue.length; i++){
		if( i == splitValue.length-1){
			evtValue += splitCode[i] + "(" + splitValue[i] + ")";
		}else{
		    evtValue += splitCode[i] + "(" + splitValue[i] + ")|";
		}
	}
	
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
<input type="hidden" name="ntc_snd_tp_cd" id="ntc_snd_tp_cd" />
<input type="hidden" name="p_ofc_cd" id="p_ofc_cd" value="<%=strOfc_cd%>" />        

<div class="page_title_area clear">
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<div class="opus_design_btn">
		<button type="button" class="btn_accent"     name="btn_Retrieve"   id="btn_Retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_Copy" 	   id="btn_Copy">Copy</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_Save"  	   id="btn_Save">Save</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_Delete" 	   id="btn_Delete">Delete</button><!-- 
		 --><%if(!"true".equals(mainpage)){ %><!--  
		--><button type="button" class="btn_normal" name="btn_Close" 	id="btn_Close">Close</button>
		<%}  %>
	</div>

	<div class="location">
		<span id="navigation"></span>
	</div>
</div>

<!-- search condition -->
<div class="wrap_search">
	<div class="opus_design_inquiry">
		<table>
    		<colgroup>
    			<col width="40px;">
    			<col width="162px;">
    			<col width="30px;">
    			<col width="*">
    		</colgroup> 
	        <tr>
	        	<th>EQ OFC</th>
	            <td><input type="text" style="width:60px;ime-mode:disabled;" class="input1" name="ofc_cd" id="ofc_cd" value="" caption="EQ Office Code" maxlength="6" dataformat="engup" required="" /></td>
	            <th title="Place of Delivery">DEL</th>
	            <td><input type="text" style="width:60px;ime-mode:disabled;" class="input1" name="del_cd" id="del_cd" value="" caption="DEL Code" maxlength="5" minlength="3" dataformat="engup" /><!-- 
	                 --><script type="text/javascript">ComComboObject("del_cd_list", 1, 75, 0, 1);</script>
	            </td>
	        </tr>
	    </table>
	  <div class="line_bluedot" ></div>
	    <table>
	    	<tr>	
	    		<td>
	    			<input type="hidden" name="frm_pkup_ntc_seq" id="frm_pkup_ntc_seq" /> 
        			<input type="hidden" name="frm_pkup_ntc_snd_tp_cd" id="frm_pkup_ntc_snd_tp_cd" />
         			<input type="hidden" name="frm_ofc_cd" id="frm_ofc_cd" />
         			<input type="hidden" name="frm_del_cd" id="frm_del_cd" />
         			<input type="hidden" name="frm_eclz_obl_cpy_flg" id="frm_eclz_obl_cpy_flg" />
         			<input type="hidden" name="frm_foc_clr_rmk_stup_flg" id="frm_foc_clr_rmk_stup_flg" />
	    		</td>
	    	</tr>
	    </table>    
	    <table>
    		<colgroup>
    			<col width="205px;">
    			<col width="130px;">
    			<col width="90px;">
    			<col width="200px;">
    			<col width="155px;">
    			<col width="130px;">
    			<col width="155px;">
                <col width="*">
    		</colgroup>  
	        <tr>
	            <th style ="display:inline" id="us_form">Freight/ B/Ls/ Customs Clear (FOC Clear)</th> 
	            <th style="display:none" id="ca_form">Freight/ B/Ls (FO Clear)</th> 
	          
	            <td>
	                <select style="width:90px;" class="input1" name="frm_auto_ntc_flg" id="frm_auto_ntc_flg" onchange="frm_auto_ntc_flg_change();"><!-- 
	                     --><option value="Y">Auto</option><!-- 
	                     --><option value="N">Manual</option><!-- 
	                 --></select> 
	                 <!--<input type="text" style="width:60px;" class="input2" value="Y/Y/Y" readOnly/>-->
	            </td>
	              <th style ="display:inline" id="us_form1">F/O/C Option</th>  
	              <th style="display:none" id="ca_form1">F/O Option</th> 
	             
	            <td>
	                <select style="width:180px;" class="input1" name="frm_each_foc_ntc_flg" id="frm_each_foc_ntc_flg"><!-- 
	                     --><option value="Y">Each Y Send</option><!-- 
	                     --><option value="N">Only 1 time Send</option><!-- 
	                 --></select>
	            </td>
	            <th>Notice to a Door Trucker</th>  
	            
	            <td>
	                <select style="width:70px;" class="input1" name="frm_trkr_ntc_flg" id="frm_trkr_ntc_flg"><!-- 
	                     --><option value="N">No</option><!-- 
	                     --><option value="Y">Yes</option><!-- 
	                 --></select>
	            </td>
	              <th>Auto Send only Yard Term</th>  
	            <td>
	                <select style="width:70px;" class="input1" name="frm_auto_ntc_yd_flg" id="frm_auto_ntc_yd_flg"><!-- 
	                     --><option value="N">No</option><!-- 
	                     --><option value="Y">Yes</option><!-- 
	                 --></select>
	            </td>
	        </tr>
	    </table>    	    
	</div>
</div>

  <div class="wrap_result">
	    <table class="grid2"> 
	    <colgroup>
          <col width="120" />
          <col width="*" />
         </colgroup>	    
	        <tr>
	            <th><strong>Head Title</strong></th>
	            <td><textarea style="width:100%;height:36px;ime-mode:disabled;resize:none;" class="textarea1" rows="2" caption="Head Title" maxLength="500" required="" name="frm_hd_tit_ctnt" id="frm_hd_tit_ctnt"></textarea></td> 
	        </tr>
	    </table>  

	
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<div class="opus_design_tab">
		<script type="text/javascript"> ComTabObject ('tab1')</script>
	</div>
	
	<div id="tabLayer" style="display:inline">
		<div class="layout_wrap">
			<input type="hidden" name="frm_t1_pkup_ntc_seq" id="frm_t1_pkup_ntc_seq" />
	        <input type="hidden" name="frm_t1_pkup_ntc_fom_cd" id="frm_t1_pkup_ntc_fom_cd" />
	        
	        <script type="text/javascript">ComSheetObject('t1sheet1');</script>
			
			<div class="layout_vertical_2" style="width: 80%;">
				<div class="opus_design_grid">
					<script type="text/javascript">ComSheetObject('t1sheet2');</script>	
				</div>
			</div>
			<div class="layout_vertical_2" style="width: 20%;">
				<div class="opus_design_inquiry">
					<table>
						<tr>
					 		<th>Enclose B/L Copy 
			                  <select style="width:70px;" class="input1" name="frm_t1_eclz_obl_cpy_flg" id="frm_t1_eclz_obl_cpy_flg">
			                      <option value="N">No</option>
			                      <option value="Y">Yes</option>
			                  </select>
			              </th>
						</tr>
					</table>
				</div>
			</div>
		</div>

		<div class="opus_design_inquiry">
	       	<table class="grid2"> 
	       		<colgroup>
	       			<col width="30px;">
	       			<col width="*">
	       		</colgroup>
	            <tr>
	                <th style="text-align: left"><strong>Bottom Remark(s)</strong></th>
	            </tr>
	            <tr>
	            	<td><textarea style="width:100%; height:130px; ime-mode:disabled; resize:none;" class="textarea1" rows="18" caption="Bottom Remark(Pre-Arrival Notice)" maxLength="4000" name="frm_t1_btm_rmk" id="frm_t1_btm_rmk" required></textarea></td> 
	            </tr>
	        </table> 
		</div>
	</div>
	<div id="tabLayer" style="display:none;">
		<div class="layout_wrap">
			<input type="hidden" name="frm_t2_pkup_ntc_seq" id="frm_t2_pkup_ntc_seq" />
	        <input type="hidden" name="frm_t2_pkup_ntc_fom_cd" id="frm_t2_pkup_ntc_fom_cd" />
	        
	        <script type="text/javascript">ComSheetObject('t2sheet1');</script>
	
			<div class="layout_vertical_2" style="width: 80%;">
				<div class="opus_design_grid">
					<script type="text/javascript">ComSheetObject('t2sheet2');</script>	
				</div>
			</div>
			
			<div class="layout_vertical_2" style="width: 20%;">
				<div class="opus_design_inquiry">
					<table>
						<tr>
					 		<th>Enclose B/L Copy 
			                  <select style="width:70px;" class="input1" name="frm_t2_eclz_obl_cpy_flg" id="frm_t2_eclz_obl_cpy_flg">
			                      <option value="N">No</option>
			                      <option value="Y">Yes</option>
			                  </select>
			              </th>
						</tr>
					</table>
				</div>
			</div>
		</div>
		
		<!-- layout_wrap(E) -->
		<div class="opus_design_inquiry">
	       	<table class="grid2"> 
	 		    <colgroup>
	       			<col width="30px;">
	       			<col width="*">
	       		</colgroup>
	            <tr>
	                <th style="text-align: left;"><strong>Bottom Remark(s)</strong></th>
	            </tr>
	            <tr>
	            	<td><textarea style="width:100%; height:205px; ime-mode:disabled; resize:none;" rows="18" caption="Bottom Remark(Pre-Arrival Notice)" maxLength="4000" name="frm_t2_btm_rmk" id="frm_t2_btm_rmk" required></textarea></td> 
	            </tr>
	        </table> 
		</div>
	</div>
</div>

</form>