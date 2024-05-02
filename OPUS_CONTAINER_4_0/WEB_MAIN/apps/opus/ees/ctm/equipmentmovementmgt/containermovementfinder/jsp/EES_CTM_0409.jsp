<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : ees_ctm_0409.jsp
*@FileTitle : Each Booking
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/22
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.event.EesCtm0409Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
  EesCtm0409Event  event = null;       //PDTO(Data Transfer Object including Parameters)
  Exception serverException = null;    //error from server
  String strErrMsg = "";               //error message
  int rowCount = 0;                    //DB ResultSet list count

  String successFlag = "";
  String codeList = "";
  String pageRows = "100";

  String strUsr_id = "";
  String strUsr_nm = "";
  String strUsr_ofc = "";
  String strCnt_cd = "";;
  Logger log = Logger.getLogger("com.clt.apps.EquipmentMovementMgt.ContainerMovementFinder");

  try {
    SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    strUsr_id = account.getUsr_id();
    strUsr_nm = account.getUsr_nm();
    strUsr_ofc = account.getOfc_cd();
    event = (EesCtm0409Event)request.getAttribute("Event");
    serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

    if (serverException != null) {
      strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
    }

    
    GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

  } catch(Exception e) {
    out.println(e.toString());
  }


  // bkgNo
  String bkgNo = (request.getParameter("bkg_no") == null)? "": request.getParameter("bkg_no");
  // mtyPlnNo
  String mtyPlnNo = (request.getParameter("mty_pln_no") == null)? "": request.getParameter("mty_pln_no");
  // pop_mode
  String popMode = (request.getParameter("pop_mode") == null)? "N": "Y";
%>

<script type="text/javascript">
  function setupPage() {
    var errMessage = "<%//=strErrMsg%>";
    if (errMessage.length >= 1) {
      ComShowMessage(errMessage);
    } // end if
    loadPage();
  }
</script>


<form name="form">
<% if (popMode.equals("Y")) { %>
<!-- popup_title_area(S) -->
 <div class="layer_popup_title">
    <!-- page_title_area(S) -->
    <div class="page_title_area clear">
        <!-- page_title(S) -->
        <h2 class="page_title"><span> Each Booking & EQR Reference Inquiry</span></h2>
        <!-- page_title(E) -->
            
        <!-- opus_design_btn(S) -->
        <div class="opus_design_btn">
            <button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--  
            --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!--  
            --><button type="button" class="btn_normal" name="btn_eachcntr" id="btn_eachcntr">Each CNTR</button><!--  
            --><button type="button" class="btn_normal" name="btn_report" id="btn_report">Print</button><!--  
            --><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
        </div>
        <!-- opus_design_btn(E) --> 
    </div>
    <!-- page_title_area(E) -->
</div>
<!-- popup_title_area(E) -->

<% } else { %>
<!-- 제목 -->
<div class="page_title_area clear">
        <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
        <h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
        <!-- page_title(E) -->

        <!-- btn_div -->
    <div class="opus_design_btn">
        <button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--  
        --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!-- 
        --><button type="button" class="btn_normal" name="btn_eachcntr" id="btn_eachcntr">Each CNTR</button><!-- 
        --><button type="button" class="btn_normal" name="btn_report" id="btn_report">Print</button>
    </div>

   <!-- page_location(S) -->
   <div class="location">
        <span id="navigation"></span>
   </div>
</div>
<!-- 제목 -->

<% } %>

<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="com_mrdArguments" id="com_mrdArguments" />
<input type="hidden" name="com_mrdTitle" value="Movement History by Booking No" id="com_mrdTitle" />
<input type="hidden" name="com_mrdBodyTitle" value="Each Booking Inquiry" id="com_mrdBodyTitle" />
<input type="hidden" name="com_mrdPath" value="apps/opus/ees/ctm/equipmentmovementmgt/containermovementfinder/report/EES_CTM_0409.mrd" id="com_mrdPath" />
<input type="hidden" name="usrId" value="<%=strUsr_id%>" id="usrId" />
<input type="hidden" name="usrOfc" value="<%=strUsr_ofc%>" id="usrOfc" />
<input type="hidden" name="cnt_cd" id="cnt_cd" />


<% if (popMode.equals("Y")) { %>
    <!-- popup_contens_area(S) -->
    <div class="layer_popup_contents">
<% } %>
<div class="wrap_search">
<!-- 검색영역 -->
<div class="opus_design_inquiry">       

    <!-- biz_1  (S) -->
    <table class="search" border="0" style="width:979px;">
      <tr class="h23">
        <th width="79px" style="text-align:left;">Booking No.</th>
        <td width="200px"><input type="text" style="width:105px;ime-mode:disabled;" class="input" maxlength="12" value="<%=bkgNo%>" tabindex="1" name="bkg_no" dataformat="engup"><input type="text" style="width:18px;" class="input2" readonly="readonly" name="bkg_sts_cd"><button type="button" class="input_seach_btn" name="btn_0472Pop" id="btn_0472Pop"></button></td>
        <th width="65px" style="text-align:left;"> B/L No.</th>
        <td width="200px"><input type="text" style="width:100px;" class="input" maxlength="12" tabindex="3" name="bl_no"></td>
        <th width="79px" style="text-align:left;"> EQR Ref. No.</th>
        <td width="200px"><input type="text" style="width:105px;ime-mode:disabled;" class="input" maxlength="12" value="<%=mtyPlnNo%>" tabindex="1" name="mty_pln_no" dataformat="engup"><button type="button" class="input_seach_btn" name="btn_0473Pop" id="btn_0473Pop"></button></td>
      </tr>
    </table>
    
    
    <div class="line_bluedot"></div>
    
    <div class="wrap_result">
		<div class="opus_design_tab">
			<script type="text/javascript">ComTabObject('tab1')</script>
		</div>
		
		<!-- 1st tab : Booking Information -->
		<div id="tabLayer" style="display:inline">
			<div class="opus_design_grid">
				<div style="float:left;">

					<table class="search" border="0" style="width:979;">
				      <tr class="h23">
				        <th width="79px" style="text-align:left;">Pre VVD</th>
				        <td width="160px"><script type="text/javascript">ComComboObject('pre_vvd', 2, 92, 1, 3)</script><input type="text" style="width:50px;" class="input2" readonly="readonly" name="pre_pol_cd"></td>
				        <th width="26px" style="text-align:left;">POR</th>
				        <td width="80px"><input type="text" style="width:52px;" class="input2" readonly="readonly" name="por_cd"></td>
				        <th width="30px" style="text-align:left;">POL</th>
				        <td width="75"><input type="text" style="width:52px;" class="input2" readonly="readonly" name="bkg_pol_cd"></td>
				        <th width="32px" style="text-align:left;">SHPR</th>
				        <td width="230px"><input type="text" style="width:202px;" class="input2" readonly="readonly" name="shpr"></td>
				        <th width="75px" style="text-align:left;">Split Info.</th>
				        <td><input type="text" style="width:25px;" class="input2" readonly="readonly" name="split_cd"><input type="text" style="width:25px;" class="input2" readonly="readonly" name="split_count"><input type="text" style="width:135px;" class="input2" readonly="readonly" name="split_bkg_no"><script type="text/javascript">ComComboObject('split_info', 3, 52, 1, 3, 1)</script></td>
				      </tr>
				      <tr class="h23">
				        <th style="text-align:left;">T/VVD</th>
				        <td style="padding-left:2"> <input type="text" style="width:92px;" class="input2" readonly="readonly" name="t_vvd"><input type="text" style="width:50px;" class="input2" readonly="readonly" name="t_pol_cd"></td>
				        <th style="text-align:left;">POD</th>
				        <td><input type="text" style="width:52px;" class="input2" readonly="readonly" name="pod_cd"></td>
				        <th style="text-align:left;">DEL</th>
				        <td><input type="text" style="width:52px;" class="input2" readonly="readonly" name="del_cd"></td>
				        <th style="text-align:left;">CNEE</th>
				        <td><input type="text" style="width:202px;" class="input2" readonly="readonly" name="cnee"></td>
				        <th style="text-align:left;">Volume</th>
				        <td style="padding-left:2"><script type="text/javascript">ComComboObject("cntr_tpsz_cd", 1, 100, 1, 3)</script></td>
				      </tr>
				      <tr class="h23">
				        <th style="text-align:left;">Post VVD</th>
				        <td> <script type="text/javascript">ComComboObject("post_vvd", 2, 92, 1, 3)</script><input type="text" style="width:50px;" class="input2" readonly="readonly" name="post_pol_cd"></td>
				        <th style="text-align:left;">Term</th>
				        <td><input type="text" style="width:18px;" class="input2" readonly="readonly" name="rcv_term_cd"> / &nbsp;<input type="text" style="width:18px;" class="input2" readonly="readonly" name="de_term_cd"></td>
				        <th colspan="2" style="text-align:left;">CGO Type&nbsp;&nbsp;<input type="text" style="width:22px;" class="input2" readonly="readonly" name="bkg_cgo_tp_cd"></th>
				        <th style="text-align:left;">NTFY</th>
				        <td><input type="text" style="width:202px;" class="input2" readonly="readonly" name="ntfy"></td>
				        <th style="text-align:left;">CMDT</th>
				        <td><input type="text" style="width:249px;" class="input2" readonly="readonly" name="rep_cmdt_nm"></td>
				      </tr>
				    </table>					

	    		</div>
	    	</div>
	    </div>	
	    	
	    <!-- 2nd tab : EQR Ref.No Information -->
		<div id="tabLayer" style="display:none">
			<div class="opus_design_grid">
				<div style="float:left;">
				
					<table class="search" border="0" style="width:979;">
				      <tr class="h23">
				        <th width="89px" style="text-align:left;">Repo. Plan ID</th>
				        <td width="160px"><input type="text" style="width:117px;" class="input2" readonly="readonly" name="repo_pln_id"></td>
				        <th width="36px" style="text-align:left;">Week</th>
				        <td width="80px"><input type="text" style="width:62px;" class="input2" readonly="readonly" name="pln_yrwk"></td>
				        <th width="50px" style="text-align:left;">From</th>
				        <td width="75"><input type="text" style="width:52px;" class="input2" readonly="readonly" name="fm_yd"><input type="text" style="width:122px;" class="input2" readonly="readonly" name="fm_dt"></td>
				      </tr>
				      <tr class="h23">
				        <th style="text-align:left;">EQR Ref. No</th>
				        <td style="padding-left:2"><input type="text" style="width:117px;" class="input2" readonly="readonly" name="ref_id"></td>
				        <th style="text-align:left;">Type</th>
				        <td><input type="text" style="width:62px;" class="input2" readonly="readonly" name="eq_type"></td>
				        <th style="text-align:left;">To</th>
				        <td><input type="text" style="width:52px;" class="input2" readonly="readonly" name="to_yd"><input type="text" style="width:122px;" class="input2" readonly="readonly" name="to_dt"></td>
				      </tr>
				      <tr class="h23">
				        <th style="text-align:left;">W/O No</th>
				        <td> <script type="text/javascript">ComComboObject("wo_no", 2, 117, 1, 3)</script></td>
				        <th style="text-align:left;">Item</th>
				        <td><input type="text" style="width:62px;" class="input2" readonly="readonly" name="item"></td>
				        <th style="text-align:left;">Volume</th>
				        <td style="padding-left:2"><script type="text/javascript">ComComboObject("eq_tpsz_cd", 1, 100, 1, 3)</script></td>
				      </tr>
				    </table>
	    
	    		</div>	
	    	</div>
	    </div>
	</div>	
    
</div>
</div>
<!-- 검색영역 -->


<div class="wrap_result">
<!-- 시트영역 -->
<div class="opus_design_grid">  
    <h3 class="title_design mar_btm_8">Container Information</h3>
    <br/>    
    <script type="text/javascript">ComSheetObject('sheet1');</script>
</div>
<!-- 시트영역 -->
</div>
<% if (popMode.equals("Y")) { %>
</div>
<!-- popup_contens_area(E) -->
<% } %>

</form>
