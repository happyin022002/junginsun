<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_ACM_0001.jsp
*@FileTitle  : Agent Commission Agreement Creation 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/23
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.acm.acmagreement.agncommagreement.event.EsmAcm0001Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
  EsmAcm0001Event event = null;        //PDTO(Data Transfer Object including Parameters)
  Exception serverException = null;    //서버에서 발생한 에러
  String strErrMsg = "";               //에러메세지
  int rowCount = 0;                    //DB ResultSet 리스트의 건수

  String successFlag = "";
  String codeList  = "";
  String pageRows  = "100";

  String strUsr_id = "";
  String strUsr_nm = "";
  Logger log = Logger.getLogger("com.clt.apps.ACMAgreement.AGNCommAgreement");

  try {
    SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    strUsr_id = account.getUsr_id();
    strUsr_nm = account.getUsr_nm();
    event = (EsmAcm0001Event)request.getAttribute("Event");
    serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

    if (serverException != null) {
      strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
    }

    // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
    GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

  } catch(Exception e) {
    out.println(e.toString());
  }
%>
<script type="text/javascript">
// 공통코드 combo string 추출
<%=JSPUtil.getIBCodeCombo("effDiv", "", "CD03014", 0, "")%>
<%=JSPUtil.getIBCodeCombo("acTp", "", "CD03021", 0, "")%>
<%=JSPUtil.getIBCodeCombo("ioBnd", "", "CD00592", 0, "")%>
<%=JSPUtil.getIBCodeCombo("fullMty", "", "CD00748", 0, "")%>
<%=JSPUtil.getIBCodeCombo("commPayTerm", "", "CD03022", 0, "")%>
<%=JSPUtil.getIBCodeCombo("revDiv", "", "CD03023", 0, "")%>
<%=JSPUtil.getIBCodeCombo("ofcSetTp", "", "CD03016", 0, "")%>
<%=JSPUtil.getIBCodeCombo("ofcCvrg", "", "CD03019", 0, "")%>


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
<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->
<!-- opus_design_inquiry(S) -->
<div class= "wrap_search_tab">
	<div class= "opus_design_inquiry wFit">
		<table>
			<tbody>
				<colgroup>
					<col width="30">
					<col width="100">
					<col width="60">
					<col width="100">					
					<col width="80">
					<col width="100">
					<col width="*">
			    </colgroup>
				<tr>
					<th>RHQ</th>
					<td><select name="combo_rhq_cd_disp" id="combo_rhq_cd_disp" required caption="RHQ" class="input1" style="width:100px; display:none;" tabindex="1"></select>
					<input name="rhq_cd" id="rhq_cd" type="Text" class="input2" style="width:100px; text-align:center;" tabindex="1" readOnly></td>
					<th>Office</th>
					<td><select name="ar_ofc_cd" id="ar_ofc_cd" required caption="Office" class="input1" style="width:100px;" tabindex="2"></select></td>
					<th>Sub Office</th>
					<td><select name="agn_cd" id="agn_cd" required caption="Sub Office" class="input1" style="width:100px;" tabindex="3"></select></td>
					<td><label for ="delt_flg"><b>Show Deleted Agreement</b></label><input name="delt_flg" type="checkbox" class="trans" value="Y" id="delt_flg" /></td>
				</tr>	
			</tbody>
		</table>
	</div>
</div>
<!-- opus_design_inquiry(E) -->
<div class="wrap_result">
	<!-- opus_tab_btn(S) -->
		<div class="opus_design_tab sm">
			<script type="text/javascript">ComTabObject('tab1')</script>
		</div>
	<!-- opus_tab_btn(E) -->
	<div id="tabLayer" style="display:inline">
		<div class="opus_design_grid clear" >
			<div class="opus_design_btn">
				<button type="button" class="btn_accent" name="tab1btn_retrieve" id="tab1btn_retrieve">Retrieve</button><!--
				--><button type="button" class="btn_normal" name="tab1btn_save" 	id="tab1btn_save">Save</button><!--
				--><button type="button" class="btn_normal" name="tab1btn_add" 	id ="tab1btn_add">Row Add</button><!--
				--><button type="button" class="btn_normal" name="tab1btn_copy" 	id="tab1btn_copy">Copy</button>
			</div>
			<script type="text/javascript">ComSheetObject('tab1sheet1');</script>
		</div>
	</div>
	
	<div id="tabLayer" style="display:none">
		<h3 class="title_design">Selected Agreement</h3>
		<div class="opus_design_grid clear" >			
			<script type="text/javascript">ComSheetObject('tab2sheet1');</script>
		</div>		
		
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<!-- opus_design_inquiry(S) -->
			<div class="opus_design_inquiry">
				<!-- layout_wrap(S) -->
				<div class="layout_wrap">
					<div class="layout_vertical_2 layout_flex_fixed" style="width:400px">
						<h3 class="title_design">Compensation Master</h3>
							<div class="opus_design_grid clear" >	
								<div class="opus_design_btn">
									<button type="button" class="btn_accent" name="tab2btn_add" id="tab2btn_add">Row Add</button><!-- 
									 --><button type="button" class="btn_normal" name="tab2btn_delete" 	id="tab2btn_delete">Delete</button>
								</div>		
								<script type="text/javascript">ComSheetObject('tab2sheet2');</script>
							</div>
							<!-- div style="width:1px; height:290px; border-left:1px #AABFDE dashed;"></div-->						
					</div>
					<div class="layout_vertical_2 layout_flex_flex" style="padding-left:408px">
						<h3 class="title_design">Compensation Rate</h3>
						
						<div class="opus_design_grid clear" >		
							<div class="opus_design_btn">
								<button type="button" class="btn_accent" name="tab2btn_retrieve" id="tab2btn_retrieve">Retrieve</button><!--
								--><button type="button" class="btn_normal" name="tab2btn_save" 	id="tab2btn_save">Save</button>
							</div>	
							<table class ="grid_2">
				            <tr class="sm">
				                <td class="sm" style="text-align:center;" width=375><input type="radio" name="rate_div" class="trans" onClick="javascript:chkRate('F');" id="rate_div" /><strong>  Fixed Amount Base</strong></td>
				                <td class="sm" style="text-align:center;"><input type="radio" name="rate_div" class="trans" onClick="javascript:chkRate('R');" id="rate_div" /><strong>  Rate Base</strong></td>
				            </tr>
				        </table>	
							<script type="text/javascript">ComSheetObject('tab2sheet3');</script>
						</div>
						
						<div class="layout_wrap">
							<div class="layout_vertical_2">
								<h3 class="title_design">Office Setting</h3>
								<div class="opus_design_grid clear pad_rgt_8" >
									<script type="text/javascript">ComSheetObject('tab2sheet4');</script>
								</div>
							</div>
							<div class="layout_vertical_2 layout_flex">
								<h3 class="title_design">Route Setting</h3>
								<div class="opus_design_grid clear" >
									<script type="text/javascript">ComSheetObject('tab2sheet5');</script>
								</div>
							</div>
						</div>				
						
						<h3 class="title_design">Charge/Surcharge Deduction Setting</h3>
						<div class="opus_design_grid clear" >
							<script type="text/javascript">ComSheetObject('tab2sheet6');</script>
						</div>
						<h3 class="title_design">Haulage Deduction Setting</h3>
						<div class="opus_design_grid clear" >								
							<script type="text/javascript">ComSheetObject('tab2sheet7');</script>
						</div>						
					</div>
				</div>
				<!-- layout_wrap(E) -->
			</div>
			<!-- opus_design_inquiry(E) -->
		</div>
		<!-- opus_design_grid(E) -->		
	</div>
	
	<div id="tabLayer" style="display:none;">
	<div style="position:relative;">
		<h3 class="title_design mar_top_4" style="position:absolute;">Agreement List</h3>
		<div class="opus_design_grid clear" >
		<div class="opus_design_btn">
				<button type="button" class="btn_accent" name="tab3btn_retrieve" id="tab3btn_retrieve">Retrieve</button>
			</div>	
			<script type="text/javascript">ComSheetObject('tab3sheet1');</script>
		</div>
		</div>
		<h3 class="title_design">Agreement Detail</h3>
		<div class="opus_design_grid clear" >	
			<script type="text/javascript">ComSheetObject('tab3sheet2');</script>
		</div>
	</div>
	
</div>
</form>
