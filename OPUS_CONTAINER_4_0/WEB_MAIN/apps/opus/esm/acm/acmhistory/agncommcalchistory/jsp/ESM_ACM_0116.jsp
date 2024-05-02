<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_ACM_0116.jsp
*@FileTitle  : Calculation Detail from History
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/08
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.acm.acmhistory.agncommcalchistory.event.EsmAcm0116Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
  EsmAcm0116Event event = null;        //PDTO(Data Transfer Object including Parameters)
  Exception serverException = null;    //서버에서 발생한 에러
  String strErrMsg = "";               //에러메세지
  int rowCount = 0;                    //DB ResultSet 리스트의 건수

  String successFlag = "";
  String codeList  = "";
  String pageRows  = "100";

  String strUsr_id = "";
  String strUsr_nm = "";
  String strOfc_cd = "";
  Logger log = Logger.getLogger("com.clt.apps.ACMHistory.AGNCommCalcHistory");

  try {
    SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    strUsr_id = account.getUsr_id();
    strUsr_nm = account.getUsr_nm();
    strOfc_cd = account.getOfc_cd();
    event = (EsmAcm0116Event)request.getAttribute("Event");
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
<input type="hidden" name="bkg_no" value="<%=JSPUtil.getParameter(request, " bkg_no") %>" id="bkg_no" />
<input type="hidden" name="agn_cd" value="<%=JSPUtil.getParameter(request, " agn_cd") %>" id="agn_cd" />
<input type="hidden" name="io_bnd_cd" value="<%=JSPUtil.getParameter(request, " io_bnd_cd") %>" id="io_bnd_cd" />
<input type="hidden" name="ac_seq" value="<%=JSPUtil.getParameter(request, " ac_seq") %>" id="ac_seq" />
<input type="hidden" name="calc_no" value="<%=JSPUtil.getParameter(request, " calc_no") %>" id="calc_no" />

<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>Calculation Detail from History</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button class="btn_accent" type="button" name="btn_close" id="btn_close">Close</button>
		</div>
		<!-- opus_design_btn (E) -->
	</div>
</div>
<!-- page_title_area(E) -->
<div class="layer_popup_contents">		     
	<div class="wrap_result">
		<div class="layout_wrap">
		   	<!-- layout_vertical_2(S) -->
			<div class="layout_vertical_2 pad_rgt_8">
				<!-- opus_design_inquiry(S) -->
				<div class="opus_design_inquiry wFit">
					<h3 class="title_design">Booking Detail</h3>
					<table id="mainTableB1S1">
						<colgroup>
							<col width="90">
							<col width="*">
						</colgroup>
						<tbody>
				            <tr>
				              <th>Booking Revenue</th>
				              <td></td>
				            </tr>
			            </tbody>
			        </table>
			        <div class="opus_design_grid" id="mainTableB1S2">
						<script type="text/javascript">ComSheetObject("box1sheet1");</script>
					</div> 
					<table>
						<tr>
				             <th>Non Deducted Rev. <input name="non_ddc_rev" id="non_ddc_rev" type="text" class="input2" style="width:100px; text-align:right;"  value="<%=JSPUtil.getParameter(request, "crnt_rev_amt")%>" readOnly> USD</th>
			            </tr>
			        </table>
			        <table class="line_bluedot"><tr><td></td></tr></table>
					<table>
						<colgroup>
							<col width="150">
							<col width="*">
						</colgroup>
						<tbody>
							<tr>
			                 	 <td><strong>Booking Q'ty</strong></td>
			                 	 <td></td>
			                </tr>
			                <tr>
			                	<td><div class="opus_design_grid" id="mainTableB1S2" style="width: 230px">
										<script type="text/javascript">ComSheetObject("box1sheet2");</script>
									</div>
								</td>
			                	<th valign="bottom">Total Q'ty <input name="ttl_qty" id="ttl_qty" type="text" class="input2" style="width:75px; text-align:right;" readOnly> Box</th>
			                </tr>
			            </tbody>
			         </table>
			         <div style="height:20px;"></div>
					 <table class="line_bluedot"><tr><td></td></tr></table>
					<table  id="mainTableB1S3">
						<colgroup>
							<col width="90">
							<col width="*">
						</colgroup>
						<tbody>
				          <tr>
				            <th>Booking Route</th>
				            <td></td>
				          </tr>
				        </tbody>
			        </table>
			        <div class="opus_design_grid" id="mainTable">
						<script type="text/javascript">ComSheetObject("box1sheet3");</script>
					</div> 
				</div>
			</div>
			<div class="layout_vertical_2">
	     		 <!-- opus_design_inquiry(S) -->
				<div class="opus_design_inquiry wFit">
					<h3 class="title_design">Deduction Detail</h3>
					<table  id="mainTableB2S1">
						<colgroup>
							<col width="90">
							<col width="*">
						</colgroup>
						<tbody>
	                      <tr>
	                        <th>Charge Deduction</th>
	                        <td></td>
	                      </tr>
	                     </tbody>
	                 </table>
	                 <div class="opus_design_grid" id="mainTable">
						<script type="text/javascript">ComSheetObject("box2sheet1");</script>
					</div> 
					<table>
		                <tr>
		                  <th>Total Charge Deduction <input name="ttl_chr_ddc" type="text" class="input2" style="width:100px; text-align:right;"  value="<%=JSPUtil.getParameter(request, "ddct_chg_amt")%>" readOnly> USD</th>
		                </tr>
		             </table>
			        <table class="line_bluedot"><tr><td></td></tr></table>
					<table id="mainTableB2S2">
						<colgroup>
							<col width="90">
							<col width="*">
						</colgroup>
						<tbody>
	                      <tr>
	                        <th>Transportation Cost Deduction</th>
	                        <td></td>
	                      </tr>
	                     </tbody>
	                </table>
	                <div class="opus_design_grid" id="mainTable">
						<script type="text/javascript">ComSheetObject("box2sheet2");</script>
					</div> 
	                <table>
	                      <tr>
	                        <th>Total Transportation Deduction <input name="ttl_trs_ddc" type="text" class="input2" style="width:100px; text-align:right;"  value="<%=JSPUtil.getParameter(request, "ddct_trsp_amt")%>" readOnly> USD</th>
	                      </tr>
	                </table>
					<table class="line_bluedot"><tr><td></td></tr></table>
					<table>
	                      <tr>
	                        <th><font color="red">Net Revenue </font><input name="net_rev" type="text" class="input2_1" style="width:100px; text-align:right;"  value="<%=JSPUtil.getParameter(request, "post_rev_amt")%>" readOnly> <font color="red">USD</font></th>
	                      </tr>
	                </table>
	            </div>
	        </div>
	    </div>
	    <div style="height:45px;"></div>
	   	<div class="opus_design_inquiry wFit">
	   		<div class="opus_design_grid" id="mainTableB3S1" style="display:none">
	            <h3 class="title_design">General Commission</h3>
				<script type="text/javascript">ComSheetObject("box3sheet1");</script>
			</div> 
			<div style="height:10px;"></div>
			<div class="opus_design_grid" id="mainTableB3S2" style="display:none">
			<h3 class="title_design">Container Handling Fee (CHF)</h3>
				<script type="text/javascript">ComSheetObject("box3sheet2");</script>
			</div> 
			<div style="height:10px;" ></div>
			<div class="opus_design_grid"  id="mainTableB3S3" style="display:none">
			<h3 class="title_design">T/S Commission</h3>
				<script type="text/javascript">ComSheetObject("box3sheet3");</script>
			</div> 
			<div class="opus_design_grid clear"  id="mainTableB3S4">
			<h3 style="margin-bottom:0" class="title_design">Commission Detail</h3>
				<script type="text/javascript">ComSheetObject("box3sheet4");</script>
			</div>
		<div style="height:80px;"></div>	
		</div>
	</div>
</div>
</form>