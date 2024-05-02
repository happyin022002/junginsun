<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_BKG_0111.jsp
*@FileTitle  : booking report
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/29
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingreport.statusreport.event.EsmBkg0111Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmBkg0111Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //error from server
    String strErrMsg = "";                      //error message
    int rowCount     = 0;                       //count of DB resultSET list

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    Logger log = Logger.getLogger("com.clt.apps.BookingReport.StatusReport");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();


        event = (EsmBkg0111Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // getting data from server when load the initial screen
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

    }catch(Exception e) {
        out.println(e.toString());
    }
%>

<script language="javascript">
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if
        loadPage();
    }
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<input type="hidden" name="vsl_cd">
<input type="hidden" name="skd_voy_no">
<input type="hidden" name="skd_dir_cd">
<input type="hidden" name="tab_item">
<input type="hidden" name="pol_yd_cd">
<input type="hidden" name="pod_yd_cd">
<input type="hidden" name="master_tot">
<input type="hidden" name="houser_tot">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
    
    <!-- page_title(S) -->
    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
    <h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
    <!-- page_title(E) -->
         
   
    <!-- opus_design_btn(S) -->
    <div class="opus_design_btn">
        <!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
        <button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--  
        --><button type="button" class="btn_normal" name="btn_New" id="btn_New">New</button><!--                    
        --><button type="button" class="btn_normal" name="btn_SaveExcel" id="btn_SaveExcel">Down Excel</button>
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

<div class="wrap_search_tab">
	<div class="opus_design_inquiry opus_design_inquiryTab">
	    <table>
	        <tbody>
	            <tr>
	                <th width="90">VVD</th>
	                <td width="90">
	                    <input type="text" name="vvd" style="width:80px;" value="" dataformat="engup" maxlength="9" class="input1">
	                </td>
	                <th width="80">POL</th>
	                <td width="80">
	                    <input type="text" name="pol_cd" style="width:50px;" value="" dataformat="engup" maxlength="5"><!--
	                    --><input type="text" name="pol_nod_cd" style="width:20px;" value="" dataformat="engup" maxlength="2" class="input">
	                </td>
	                <th width="35">POD</th>
	                <td width="30">
	                    <input type="text" name="pod_cd" style="width:50px;" value="" dataformat="engup" maxlength="5"><!--
	                    --><input type="text" name="pod_nod_cd" style="width:20px;" value="" dataformat="engup" maxlength="2" class="input">
	                </td>
	                <th width="60">Shipper</th>
	                <td width="120">
	                    <input type="text" name="cust_cnt_cd" style="width:30px;" value="" dataformat="enguponly" maxlength="2"><!--
	                    --><input type="text" name="cust_seq" style="width:80px;" value="" dataformat="num" maxlength="6">
	                </td>
	                <th width="60">US Filer</th>
	                <td width="80">
	                    <script language="javascript">ComComboObject('usa_cstms_file_cd', 2, 70, true, '');</script>
	                </td>
	                <th width="55">CA Filer</th>
	                <td width="83">
	                    <script language="javascript">ComComboObject('cnd_cstms_file_cd', 2, 70, true, '');</script>
	                </td>
	                <td>
						<div class="sm" style="width: 95px;">
							<table>
								<tr>
									<td>
										<input type="radio" name="chk_err" id="chk_err_1" value="1" checked><label for="chk_err_1">All</label><!--
	                                 --><input type="radio" name="chk_err" id="chk_err_0" value="0" ><label for="chk_err_0">Error</label>
									</td>
								</tr>
							</table>
						</div>
					</td>
	            </tr>
	            <tr>
	                <th>Booking Office</th>
	                <td>
	                    <input type="text" name="bkg_ofc_cd" style="width:60px;" value="" dataformat="enguponly" maxlength="6">
	                </td>
	                <th>Booking Staff</th>
	                <td>
	                    <input type="text" name="cre_usr_id" style="width:60px;" value="" maxlength="20">
	                </td>
	                <th>B/L Office</th>
	                <td>
	                    <input type="text" name="obl_iss_ofc_cd" style="width:60px;" value="" dataformat="enguponly" maxlength="6">
	                </td>
	                <th>B/L Staff</th>
	                <td>
	                    <input type="text" name="obl_iss_usr_id" style="width:70px;" value="" maxlength="20">
	                </td>
	                <th>Sales Rep.</th>
	                <td>
	                    <input name="ob_srep_cd" type="text" style="width:70px;" value="" dataformat="engup" maxlength="5">
	                </td>   
	            </tr>
	        </tbody>
	    </table>                
	</div>
</div>

<div class="wrap_result">
	<div class="opus_design_tab">
    	<script language="javascript">ComTabObject('tab1')</script>
	</div> 
	<!--TAB Master B/L (S) -->
	<div class="opus_design_grid" name="tabLayer" id="tabLayer">
	    <div class="grid_option_left" id="t1sheet1_tot"></div>
	    <script language="javascript">ComSheetObject('t1sheet1');</script>
	</div>
	<div class="opus_design_grid" name="tabLayer" id="tabLayer">
	    <div class="grid_option_left" id="t2sheet1_tot"></div>
	    <script language="javascript">ComSheetObject('t2sheet1');</script>
	</div>
</div>
</form>