<%
/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : ESM_BKG_0375.jsp
 *@FileTitle  : Arrival Notice Template
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/05/05
 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg0375Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmBkg0375Event  event = null;          //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;      //error from server
    String strErrMsg = "";            //error message
    int rowCount   = 0;            //count of DB resultSET list
    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";
    String strUsr_id    = "";
    String strUsr_nm    = "";
    Logger log = Logger.getLogger("com.clt.apps.InboundBLMgt.ArrivalNotice");
    String agentKndCd = "6";
    String strOfc_cd = "";
    String strCnt_cd = "";
    String strPodCds = "";
    String strOfcKndCd = "";
    String parAutoSearchFlg = JSPUtil.getParameter(request, "autoSearchFlg");
    String mainPage="";
    try {
    	mainPage = JSPUtil.getNull(request.getParameter("mainPage"));
    	if (mainPage == null)
    		mainPage = request.getParameter("main_page");
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id =  account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        strOfc_cd = account.getOfc_cd();
        strCnt_cd = account.getCnt_cd();
        event = (EsmBkg0375Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
          strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
    } catch(Exception e) {
      out.println(e.toString());
    }
%>
<script type="text/javascript">
    var strOfc_cd = "<%=strOfc_cd%>";
    var strCnt_cd = "<%=strCnt_cd%>";
    var parAutoSearchFlg = "<%=parAutoSearchFlg %>";
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            showErrMessage(errMessage);
        } // end if
        var formObject = document.form;
        formObject.ofc_cd.value =strOfc_cd;
        loadPage();
    }
</script>

<form name="form">
<input name="f_cmd" 		id="f_cmd" value="" type="hidden" />
<input name="pagerows" 		id="pagerows" type="hidden" />
<input name="login_ofc_cd" 	id="login_ofc_cd" type="hidden" value="<%=strOfc_cd%>"/>


<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" 	id="btn_Retrieve">Retrieve</button><!-- 
		--><button type="button" class="btn_normal" name="btn_New"  		id="btn_New">New</button><!-- 
		--><button type="button" class="btn_normal" name="btn_Save" 		id="btn_Save">Save</button><!-- 
		--><button type="button" class="btn_normal" name="btn_Del" 		id="btn_Del">Delete</button><!-- 
		--><button type="button" class="btn_normal" name="btn_ANSetup" 	id="btn_ANSetup">A/N Setup</button><!-- 
		--><%if(!"true".equals(mainPage)){ %><!--
	    --><button type="button" class="btn_normal" name="btn_Close" 		id="btn_Close">Close</button>
		<%} %>		
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->

<div class="wrap_search_tab">
<!-- opus_design_inquiry(S) -->
<div class="opus_design_inquiry wFit">
	<table>
		<tbody>
			<colgroup>
				<col width="60"/>
				<col width="70"/>
				<col width="60"/>
				<col width="120"/>
				<col width="160"/>
				<col width="150" />
				<col width="*" />
			</colgroup>
			<tr>
				<th>Office</th>
				<td><input type="hidden" 	name="an_seq" 		id="an_seq" value="" /><!-- 
				--><input type="hidden" 	name="an_tp_cd" 	id="an_tp_cd" value="ARN" required="true" /><!-- 
				--><input type="text" 		name="ofc_cd" 		id="ofc_cd" caption="Office" dataformat="engup" minlength="5" maxlength="6" style="width:60px;" class="input1" required="true" style="ime-mode:disabled" onKeyPress="objEnter(this);"/>
				</td>
				<th title="Port of Discharging">POD</th>
				<td><input type="text" 		name="pod_cd" 		id="pod_cd" value="" caption="POD" maxlength="5" size="5" dataformat="engup" style="ime-mode:disabled" onKeyPress="objEnter(this);"/><!--
				--><select name="pod_cd_combo" id="pod_cd_combo" caption="POD" style="width:70px;" class="input" ></select>      
				</td>
				<th>AGENT</th>
				<td><input type="text" 		name="chn_agn_cd" 	id="chn_agn_cd" caption="AGENT" maxlength="2" fullfill="true" size="2" dataformat="engup" style="ime-mode:disabled" onKeyPress="objEnter(this);"/><!-- 
				--><select name="chn_agn_cd_combo" id="chn_agn_cd_combo" caption="AGENT" style="width:70px;" class="input" ></select>
    			</td>
    			<td></td>
			</tr>
   		</tbody>
	</table>
	<table>
		<tbody>
			<colgroup>
				<col width="120"/>
				<col width="250" />
				<col width="120" />
				<col width="100" />
				<col width="120" />
				<col width="100" />
				<col width="*" />
	    	</colgroup>
           <tr>
              <th>A/N Preview Form</th>
              <td class="sm pad_left_8"><input name="arr_prv_fom_cd" id="arr_prv_fom_cd" caption="A/N Preview Form" 	value="GE" type="radio" class="trans" onclick="fnRadioCheck()" checked ><label for = "arr_prv_fom_cd">General</label><!-- 
				   --><input name="arr_prv_fom_cd" id="arr_prv_fom_cd" caption="A/N Preview Form"  	value="BL" type="radio" class="trans" onclick="fnRadioCheck()"><label for = "arr_prv_fom_cd">B/L Form</label><!-- 
				   --><input name="arr_prv_fom_cd" id="arr_prv_fom_cd" caption="A/N Preview Form"  	value="NL" type="radio" class="trans" onclick="fnRadioCheck()"><label for = "arr_prv_fom_cd">Notify Letter</label>
              </td>
              <th>A/N Language</th>
			  <td><select name="locl_lang_flg" id="locl_lang_flg" caption="A/N Language"  style="width:140px;" class="input">
				    <option value="N">English</option>
				    <option value="Y">Local Language</option>
				  </select>
				</td>
				<th>Enclose B/L Copy</th>
				<td><select name="eclz_bl_cpy_flg" id="eclz_bl_cpy_flg" caption="Enclose B/L Copy" style="width:90px;" class="input">
						<option value="N" selected >No</option>
						<option value="Y">Yes </option>
					</select>
				</td>
				<td></td>
           </tr>
		</tbody>
	</table>
</div>
<!-- opus_design_inquiry(E) -->
</div>
<div class="wrap_result">
	<!-- opus_tab_btn(S) -->
	<div class="opus_design_tab">
		<script type="text/javascript">ComTabObject('tab1')</script>
	</div>
	<!-- opus_tab_btn(E) -->
	
	<!-- opus_design_grid(S) -->	
	<div class="opus_design_grid" name="tabLayer" id="tabLayer">
	<div class="sm" style="width:800px" >
		<table> 
		<colgroup>
            <col width="90" />
            <col width="*" />	
         </colgroup>			        
	        <tr style="height:30px !important;">
	           <th>Address</th>
	           <td><textarea  rows="2" style="width:100%;resize:none;" name = "ge_addr_ctnt" id="ge_addr_ctnt" maxlength="500" style="ime-mode:disabled"></textarea></td>
	        </tr>
	        <tr>
	           <th>Important Notice</th>
	           <td><textarea name="ge_impt_ntc_rmk" id="ge_impt_ntc_rmk" caption="'General' Important Notice" style="width:100%;height:250px;resize:none;" ></textarea></td>
	        </tr>
	    </table> 
	  </div>
	</div>
	<div class="opus_design_grid clear" name="tabLayer" id="tabLayer">
		<div class="sm" style="width:800px" >
		<table> 
		<colgroup>
            <col width="90" />
            <col width="*" />	
         </colgroup>	
			<tr style="height:30px !important;">
				<th>Address</th>
				<td><textarea  rows="2" style="width:100%;resize:none;" name = "dr_addr_ctnt" id="dr_addr_ctnt" maxlength="500" style="ime-mode:disabled"></textarea></td>
				
			</tr>
			<tr>
				<th>Important Notice</th>
				<td>
					<textarea name="dr_impt_ntc_rmk" id="dr_impt_ntc_rmk" caption="'Door' Important Notice" maxlength="4000" style="width:100%;height:250px;resize:none;"></textarea>
				</td>	
			</tr>
			</table>
           </div>

 
	</div>
		
	<div class="opus_design_grid clear" name="tabLayer" id="tabLayer">
	   <div class="sm" style="width:800px" >
		<table> 
		<colgroup>
            <col width="90" />
            <col width="*" />	
         </colgroup>	
			<tr style="height:30px !important;">
				<th>Address</th>
				<td><textarea  rows="2" style="width:100%;resize:none;" name = "cy_addr_ctnt" id="cy_addr_ctnt" maxlength="500" style="ime-mode:disabled"></textarea></td>
			</tr>
			<tr>
				<th>Important Notice</th>
				<td>
					<textarea name="cy_impt_ntc_rmk" id="cy_impt_ntc_rmk" caption="'CY' Important Notice" maxlength="4000" style="width:100%;height:250px; resize:none;"></textarea>
				</td>	
			</tr>
			</table>
           </div> 
	</div>
	
	<div class="opus_design_grid clear" name="tabLayer" id="tabLayer">
		<div class="sm" style="width:800px" >
		<table> 
		<colgroup>
            <col width="90" />
            <col width="*" />	
         </colgroup>	
			<tr style="height:30px !important;">
				<th>Address</th>
				<td><textarea  rows="2" style="width:100%;resize:none;" name = "cf_addr_ctnt" id="cf_addr_ctnt" maxlength="500" style="ime-mode:disabled"></textarea></td>
			</tr>
			<tr>
				<th>Important Notice</th>
				<td>
					<textarea name="cf_impt_ntc_rmk" id="cf_impt_ntc_rmk" caption="'CFS' Important Notice" maxlength="4000" style="width:100%;height:250px;resize:none;"></textarea>
				</td>	
			</tr>
			</table>
           </div> 
	</div>
	
	<div class="opus_design_grid clear" name="tabLayer" id="tabLayer">
		<div class="sm" style="width:800px" >
		<table> 
		<colgroup>
            <col width="90" />
            <col width="*" />	
         </colgroup>	
			<tr style="height:30px !important;">
				<th>Address</th>
				<td><textarea  rows="2" style="width:100%;resize:none;" name = "sp_addr_ctnt" id="sp_addr_ctnt" maxlength="500" style="ime-mode:disabled"></textarea></td>
			</tr>
			<tr>
				<th>Important Notice</th>
				<td>
					<textarea name="sp_impt_ntc_rmk" id="sp_impt_ntc_rmk" caption="'Special Cargo' Important Notice" maxlength="4000" style="width:100%;height:250px;resize:none;"></textarea>
				</td>	
			</tr>
			</table>
           </div>	
	</div>
	
	<div class="opus_design_grid clear" name="tabLayer" id="tabLayer">
		<div class="sm" style="width:800px" >
		<table> 
		<colgroup>
            <col width="90" />
            <col width="*" />	
         </colgroup>	
			<tr style="height:30px !important;">
				<th>Address</th>
				<td><textarea  rows="2" style="width:100%;resize:none;" name = "e1_addr_ctnt" id="e1_addr_ctnt" maxlength="500" style="ime-mode:disabled"></textarea></td>
			</tr>
			<tr>
				<th>Important Notice</th>
				<td>
					<textarea name="e1_impt_ntc_rmk" id="e1_impt_ntc_rmk" caption="'Event' Important Notice" maxlength="4000" style="width:100%;height:250px;resize:none;"></textarea>
				</td>	
			</tr>
			</table>
           </div>		
	</div>
	<div id="hiddenSheetLayer" style="display: none;">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
<!-- opus_design_grid(E) -->
</form> 