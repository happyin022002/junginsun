<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_ACM_0105.jsp
*@FileTitle  : Calculation Detail
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/05
=========================================================
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.acm.acmrequest.agncommrequest.event.EsmAcm0105Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
  EsmAcm0105Event event = null;        //PDTO(Data Transfer Object including Parameters)
  Exception serverException = null;    //서버에서 발생한 에러
  String strErrMsg = "";               //에러메세지
  int rowCount = 0;                    //DB ResultSet 리스트의 건수

  String successFlag = "";
  String codeList  = "";
  String pageRows  = "100";

  String strUsr_id = "";
  String strUsr_nm = "";
  String strOfc_cd = "";
  Logger log = Logger.getLogger("com.clt.apps.ACMRequest.AGNCommRequest");

  try {
    SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    strUsr_id = account.getUsr_id();
    strUsr_nm = account.getUsr_nm();
    strOfc_cd = account.getOfc_cd();
    event = (EsmAcm0105Event)request.getAttribute("Event");
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
//    alert("^^^^^^^^^^^^^^^");
	  //alert("*****************"+document.getElemnetById('top').innerHTML);
  }
  
//  window.onload=function() {
//	  alert("&&&&&&&&&&&&&&");
//	  alert("!!!!!!!!!!!!!!!!!!!!"+document.getElemnetById('top').innerHTML);
//	  document.getElemnetById('top').innerHTML=1;
//  }
</script>


<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="bkg_no" value="<%=JSPUtil.getParameter(request, " bkg_no") %>" id="bkg_no" />
<input type="hidden" name="agn_cd" value="<%=JSPUtil.getParameter(request, " agn_cd") %>" id="agn_cd" />
<input type="hidden" name="io_bnd_cd" value="<%=JSPUtil.getParameter(request, " io_bnd_cd") %>" id="io_bnd_cd" />
<input type="hidden" name="ac_seq" value="<%=JSPUtil.getParameter(request, " ac_seq") %>" id="ac_seq" />

<!-- page_title_area(S) -->
<div class="layer_popup_title">
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><span>Calculation Detail</span></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
	</div>
	<!-- opus_design_btn(E) -->
</div>
</div>
<div class="layer_popup_contents" id="top">
<div class="wrap_result">
<div class="layout_wrap">
<div class="layout_vertical_2 pad_rgt_12" >
<h3 style="margin-bottom:0" class="title_design">Booking Detail</h3>

	<div class="opus_design_grid clear "  id="mainTableB1S1">
		<div class= "opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="50" />
				<col width="*" />
			</colgroup>
			<tbody>
			 <tr>
	            <th>Booking Revenue</th>
	            <td></td>
	        </tr>
	    </table>
	 	</div>
		<script type="text/javascript">ComSheetObject('box1sheet1');</script>
	</div>
	<div class= "opus_design_inquiry wFit">
	<table>
		<colgroup>
			<col width="650" />
			<col width="*" />
		</colgroup>
		<tbody>
		 <tr>
           <th>Non Deducted Rev.</th>
           <td><input name="non_ddc_rev" id="non_ddc_rev" type="text" class="input2" style="width:100px; text-align:right;"  value="<%=JSPUtil.getParameter(request, "crnt_rev_amt")%>" readOnly><label for ="non_ddc_rev">USD</label></td>
        </tr>
    </table>
 	</div>
	<table class="line_bluedot"><tr><td></td></tr></table>
	<div class="opus_design_grid clear"  id="mainTableB1S2">
	<div class= "opus_design_inquiry wFit">
		<table >
			<colgroup>
				<col width="50" />
				<col width="*" />
			</colgroup>
			<tbody>
			 <tr>
	            <th>Booking Q'ty</th>
	            <td></td>
	        </tr>
	    </table>
	</div>
		<table>
		<colgroup>
			<col width="240" />
			<col width="*" />
		</colgroup>
		<tbody>
			<tr>
				<td><script type="text/javascript">ComSheetObject('box1sheet2');</script></td>
				<th>Total Q'ty</th>
		 		<td><input name="ttl_qty" id="ttl_qty" type="text" class="input2" style="width:60px; text-align:right;"  value="<%=JSPUtil.getParameter(request, "ttl_qty")%>" readOnly><label for = "ttl_qty">Box</label></td>
			</tr>
		</tbody>
	</table>
	</div>
	<table class="line_bluedot"><tr><td></td></tr></table>
	<div class="opus_design_grid clear"  id="mainTableB1S3">
	<div class= "opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="50" />
				<col width="*" />
			</colgroup>
			<tbody>
			 <tr>
	            <th>Booking Route</th>
	            <td></td>
	        </tr>
	    </table>
	</div>
	<script type="text/javascript">ComSheetObject('box1sheet3');</script>
	</div>
</div>

<div class="layout_vertical_2">
	<h3 style="margin-bottom:0" class="title_design">Deduction Detail</h3>

	<div class="opus_design_grid clear"  id="mainTableB2S1">
		<div class= "opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="50" />
				<col width="*" />
			</colgroup>
			<tbody>
			 <tr>
	            <th>Charge Deduction</th>
	            <td></td>
	        </tr>
	    </table>
	 	</div>
		<script type="text/javascript">ComSheetObject('box2sheet1');</script>
		</div>
		<div class= "opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="650" />
				<col width="*" />
			</colgroup>
			<tbody>
			 <tr>
	            <th>Total Charge Deduction</th>
	            <td><input name="ttl_chr_ddc" id="ttl_chr_ddc" type="text" class="input2" style="width:100px; text-align:right;"  value="<%=JSPUtil.getParameter(request, "ddct_chg_amt")%>" readOnly><label for = "ttl_chr_ddc">USD</label></td>
	        </tr>
	    </table>
	</div>
	<table class="line_bluedot"><tr><td></td></tr></table>
	<div class="opus_design_grid clear"  id="mainTableB2S2">
		<div class= "opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="50" />
				<col width="*" />
			</colgroup>
			<tbody>
			 <tr>
	            <th>Transportation Cost Deduction</th>
	            <td></td>
	        </tr>
	    </table>
	 	</div>
		<script type="text/javascript">ComSheetObject('box2sheet2');</script>
	</div>
    <div class= "opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="650" />
				<col width="*" />
			</colgroup>
			<tbody>
			 <tr>
	           <th>Total Transportation Deduction</th>
	           <td><input name="ttl_trs_ddc" id="ttl_trs_ddc" type="text" class="input2" style="width:100px; text-align:right;"  value="<%=JSPUtil.getParameter(request, "ddct_trsp_amt")%>" readOnly><label for ="ttl_trs_ddc">USD</label></td>
   			</tr>
   			</tbody>
	    </table>
	</div>   
	<table class="line_bluedot"><tr><td></td></tr></table>
	<div class= "opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="650" />
				<col width="*" />
			</colgroup>
			<tbody>
			 <tr>
	          <th style="color:#FB1901;">Net Revenue</th>
	          <td><input name="net_rev" id="net_rev" type="text" class="input2_1" style="width:100px; text-align:right;"  value="<%=JSPUtil.getParameter(request, "post_rev_amt")%>" readOnly><label for = "net_rev">USD</label></td>
       		 </tr>
   			</tbody>
	    </table>
	</div>   

</div>
</div>
<div class="opus_design_grid clear"  id="mainTableB3S1" style="display:none">
<h3 style="margin-bottom:0" class="title_design">General Commission</h3>
	<script type="text/javascript">ComSheetObject("box3sheet1");</script>
</div>


<div class="opus_design_grid clear"  id="mainTableB3S2" style="display:none">
<h3 style="margin-bottom:0" class="title_design">Container Handling Fee (CHF)</h3>
	<script type="text/javascript">ComSheetObject("box3sheet2");</script>
</div>


<div class="opus_design_grid clear"  id="mainTableB3S3" style="display:none">
<h3 style="margin-bottom:0" class="title_design">T/S Commission</h3>
	<script type="text/javascript">ComSheetObject("box3sheet3");</script>
</div>

<div style="height:30px;"></div>

<div class="opus_design_grid clear"  id="mainTableB3S4">
<h3 style="margin-bottom:0" class="title_design">Commission Detail</h3>
	<script type="text/javascript">ComSheetObject("box3sheet4");</script>
</div>

<div style="height:50px;"></div>
</div>
</div>

</form>