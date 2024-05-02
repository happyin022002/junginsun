<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_LSE_0091.jsp
*@FileTitle  : Agreement No. Selection 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/10
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.StringUtil"%>
<%
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.ContainerLeaseAgreementRegistration.AgreementRegistration");
	String returnval = ((request.getParameter("returnval")==null )?"":request.getParameter("returnval"));
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		//getting data from server when load the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
	
	// bkgBl
	  String bkgBl = (request.getParameter("bkgBl") == null)? "": request.getParameter("bkgBl");
	  // pCntrno
	  String pCntrno = (request.getParameter("pCntrno") == null)? "": request.getParameter("pCntrno");
	  // checkDigit
	  String checkDigit = (request.getParameter("checkDigit") == null)? "": request.getParameter("checkDigit");
	  // pYard1
	  String pYard1 = (request.getParameter("pYard1") == null)? "": request.getParameter("pYard1");
	  // tmlNm
	  String tmlNm = (request.getParameter("tmlNm") == null)? "": request.getParameter("tmlNm");
	  // lccCd
	  String lccCd = (request.getParameter("lccCd") == null)? "": request.getParameter("lccCd");
	  // rccCd
	  String rccCd = (request.getParameter("rccCd") == null)? "": request.getParameter("rccCd");
	  // vvdCombo
	  String vvdCombo = (request.getParameter("vvdCombo") == null)? "VVD_CD": request.getParameter("vvdCombo");
	  // vvdValue
	  String vvdValue = (request.getParameter("vvdValue") == null)? "": request.getParameter("vvdValue");
	  // cntrTpszCd
	  String cntrTpszCd = (request.getParameter("cntrTpszCd") == null)? "": request.getParameter("cntrTpszCd");
	  // cntrFullStsCd
	  String cntrFullStsCd = (request.getParameter("cntrFullStsCd") == null)? "": request.getParameter("cntrFullStsCd");
	  // mvmtEdiMsgAreaCd
	  String mvmtEdiMsgAreaCd = (request.getParameter("mvmtEdiMsgAreaCd") == null)? "": request.getParameter("mvmtEdiMsgAreaCd");
	  // mvmtEdiMsgTpId
	  String mvmtEdiMsgTpId = (request.getParameter("mvmtEdiMsgTpId") == null)? "ALL": request.getParameter("mvmtEdiMsgTpId");
	  // mvmtEdiRsltCd
	  String mvmtEdiRsltCd = (request.getParameter("mvmtEdiRsltCd") == null)? "N": request.getParameter("mvmtEdiRsltCd");
	  // ediMvmtStsCd
	  String ediMvmtStsCd = (request.getParameter("ediMvmtStsCd") == null)? "": "'" + request.getParameter("ediMvmtStsCd") + "'";
	  // rtyKnt
	  String rtyKnt = (request.getParameter("rtyKnt") == null)? "": request.getParameter("rtyKnt");
	  // ediGateIoCd
	  String ediGateIoCd = (request.getParameter("ediGateIoCd") == null)? "": "'" + request.getParameter("ediGateIoCd") + "'";

	  // Duration start date (today in case of no request)
	  String pDate1 = (request.getParameter("pDate1") == null)? DateTime.getFormatDate(new java.util.Date(), "yyyy-MM-dd"): request.getParameter("pDate1");
	  // Duration end date (today in case of no request)
	  String pDate2 = (request.getParameter("pDate2") == null)? DateTime.getFormatDate(new java.util.Date(), "yyyy-MM-dd"): request.getParameter("pDate2");

	  String requestYN = "";
	  if (request.getParameter("pDate1") != null && request.getParameter("pDate2") != null) requestYN = "Y";

	  // pop_mode
	  String popMode = (request.getParameter("pop_mode") == null)? "N": "Y";
%>

<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>


<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="returnval" value="<%=returnval%>" id="returnval" />
<input type="hidden" name="user_svr_id" id="user_svr_id">
<input type="hidden" value="<%=requestYN%>" name="requestYN">
<input type="hidden" name="org_vvd_cd" id="org_vvd_cd">

<div class="layer_popup_title">
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<h2 class="page_title"><span>Search EDI Error</span></h2>
			<div class="opus_design_btn">
				<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--
				--><button type="button" class="btn_normal" name="btn_New"  	id="btn_New">New</button><!-- 
				--><button type="button" class="btn_normal" name="btn_OK"  	id="btn_OK">Ok</button><!-- 
				--><button type="button" class="btn_normal" name="btn_Close"  	id="btn_Close">Close</button> 
			</div>
	</div>
</div>
	
<div class="layer_popup_contents">
	<!-- <div class="wrap_search">
		<div class="opus_design_inquiry">
			<table>
			<tbody>
			
	              <tr>
	                <th width="90">Receiving Date</th>
	                <td  width="180"><input type="text" style="width:80px;" class="input1" name="idx_cre_locl_fm_dt" value="" maxlength="10" dataformat="ymd" id="idx_cre_locl_fm_dt" />~ <input type="text" style="width:80px;" class="input1" name="idx_cre_locl_to_dt" value="" maxlength="10" dataformat="ymd" id="idx_cre_locl_to_dt" /><button type="button" id="btns_Calendar" name="btns_Calendar" class="calendar ir"></button></td>
	                <th width="50">Area </th>
	                <td width="100"><script type="text/javascript">ComComboObject('mvmt_edi_msg_area_cd', 1, 100, 0);</script></td>
	                <th width="50">Result</th>
	                <td width="100">
	                	<select name="mvmt_edi_rslt_cd" id="mvmt_edi_rslt_cd"  caption="Active Flag" style="width:75px;">
							<option value="A" selected>ALL</option> 
							<option value="N">Error</option> 
							<option value="I">Ignored</option> 
						</select>
					</td>
					<th width="50">Message</th>
					<td><input type="text" style="width:150px;" class="input" name="s_message" id="s_message" value="" maxlength="100"  /></td>
	              </tr>
	              
	              </tbody>
	            </table>
	     </div>
	</div> -->
	
	
	<div class="wrap_search">
    <div class="opus_design_inquiry wFit">
        <div class="layout_wrap">
            <!-- layout_vertical_2(S) -->
            <div class="layout_vertical_2" style="width: 170px;">
                <table class="grid_2">
                    <tr>
                      <th colspan="2"><!--  
                        --><input type="radio" name="event_receive" id="event_receive1" value="EVENT" class="trans" checked><label for="event_receive1">Event</label><!--  
                        --><input type="radio" name="event_receive" id="event_receive2" value="RECEIVE" class="trans"><label for="event_receive1">Receiving</label>
                      </th>
                    </tr>
                    <tr>
                        <th>From</th>
                        <td class="noinput1"><input type="text" style="width:75px;ime-mode:disabled;" class="input1" value="<%=pDate1%>" tabindex="1" name="p_date1" id="p_date1" dataformat ="ymd"></td>
                    </tr>
                    <tr>
                        <th>To</th>
                        <td class="noinput1"><!--  
                        --><input type="text" style="width:75px;ime-mode:disabled;" class="input1" value="<%=pDate2%>" tabindex="2" name="p_date2" id="p_date2" dataformat ="ymd"><!--  
                        --><button type="button" class="calendar ir" name="btn_Calendar" id="btn_Calendar"></button><!--  
                        --><input type="hidden" name="p_date3" id="p_date3"></td>
                    </tr>
                </table>
            </div>
            <!-- layout_vertical_2(E) -->

            <!-- layout_vertical_2(S) -->
            <div class="layout_vertical_2 pad_left_8">
                <table>
                    <colgroup>
                        <col width="60">
                        <col width="130">
                        <col width="70">
                        <col width="130">
                        <col width="90">
                        <col width="90">
                        <col width="70">
                        <col width="90">
                        <col width="90">
                        <col width="90">
                        <col width="90">
                        <col width="*">
                    </colgroup>
                    <tr>
                        <th>BKG or B/L No.</th>
                        <td><input type="text" style="width:110px;ime-mode:disabled;" class="input" dataformat="engup" maxlength="13" tabindex="3" value="<%=bkgBl%>" name="bkg_bl" id="bkg_bl"></td>
                        <th>Terminal</th>
                        <td><input type="text" style="width:125px;ime-mode:disabled;" class="input" maxlength="20" tabindex="7" value="<%=tmlNm%>" name="tml_nm" id="tml_nm"></td>
                        <th>TP/SZ</th>
                        <td><script type="text/javascript">ComComboObject("tpszCombo", 1, 65, 1, 0, 0, 0, 11);</script><!--  
                        --><input type="hidden" value="<%=cntrTpszCd%>" name="cntr_tpsz_cd" id="cntr_tpsz_cd"></td>
                        <th>Area</th>
                        <td>
                            <select style="width:80px;" tabindex="14" name="mvmt_edi_msg_area_cd" id="mvmt_edi_msg_area_cd">
                                <option value="KOR">KR / JP</option>
                                <option value="CHN">CHN</option>
                                <option value="SWA">SWA</option>
                                <option value="EUR">EUR</option>
                                <option value="USA">USA</option>
                                <option value="">ALL</option>
                            </select><!--
                            --><input type="hidden" value="<%=mvmtEdiMsgAreaCd%>" name="mvmtEdiMsgAreaCd">
                        </td>
                        <th>Status</th>
                        <td><script type="text/javascript">ComComboObject("statusCombo", 1, 70, 1, 0, 0, 0, 17);</script><!--  
                        --><input type="hidden" value="<%=ediMvmtStsCd%>" name="edi_mvmt_sts_cd" id="edi_mvmt_sts_cd"></td>
                        <th>MSG TP</th>
                        <td>
							<select style="width:70px;" tabindex="15" name="flt_file_ref_no" id="flt_file_ref_no">
                                <option value="">ALL</option>
                                <option value="EDI">EDI</option>
                                <option value="IEM">IEM</option>
                            </select>                        
                        </td>                        
                    </tr>
                    
                    <tr>
                        <th>Container No.</th>
                        <td><input type="text" style="width:85px; ime-mode:disabled;" class="input" maxlength="10" tabindex="4" value="<%=pCntrno%>" name="cntrno_disp" id="cntrno_disp"><input type="hidden" value="<%=pCntrno%>" name="p_cntrno"><!-- 
                           --><input type="text" style="width:20px;" class="input" readonly="true" value="<%=checkDigit%>" name="check_digit" id="check_digit"></td>
                        <th>LCC</th>
                        <td><input type="text" style="width:50px; ime-mode:disabled;" class="input" maxlength="5" tabindex="8" value="<%=lccCd%>" name="lcc_cd" id="lcc_cd" dataformat ="engup"></td>
                        <th>RCC</th>
                        <td><input type="text" style="width:65px; ime-mode:disabled;" class="input" maxlength="5" tabindex="12" value="<%=rccCd%>" name="rcc_cd" id="rcc_cd" dataformat ="engup"></td>
                        <th>MSG ID</th>
                        <td><script type="text/javascript">ComComboObject("mvmt_edi_msg_tp_id", 1, 80, 1, 0, 0, 0, 15);</script><!--  
                        --><input type="hidden" value="<%=mvmtEdiMsgTpId%>" name="mvmtEdiMsgTpId" id="mvmtEdiMsgTpId"></td>
                        <th>Retry</th>
                        <td colspan=3>
                            <select style="width:70px;" tabindex="18" name="rty_knt" id="rty_knt">
                                <option value="" selected>ALL</option>
                                <option value="0">0</option>
                                <option value="1">More</option>
                            </select><!--  
                            --><input type="hidden" value="<%=rtyKnt%>" name="rtyKnt" id="rtyKnt">
                        </td>
                    </tr>
                    
                    <tr>
                        <th>Origin Yard</th>
                        <td><input type="text" style="width:60px; ime-mode:disabled;" class="input" maxlength="5" tabindex="5" value="<%=pYard1%>" name="yd_cd_disp" id="yd_cd_disp" dataformat ="engup"><!--  
                            --><input type="hidden" value="<%=pYard1%>" name="p_yard1" id="p_yard1"><!-- 
                           --><script type="text/javascript">ComComboObject("p_yard2", 2, 45, 0, 0, 0, 0, 6);</script></td>
                        <td>
                            <select style="width:70px; font-weight:bold; color:#000000;" tabindex="9" name="vvd_combo" id="vvd_combo" OnChange="vvd_combo_onchange();">
                                <option value="VVD_CD">VVD</option>
                                <option value="CALL_SGN_NO">Call Sign</option>
                                <option value="LLOYD_NO">Lloyd</option>
                            </select><!--  
                            --><input type="hidden" value="<%=vvdCombo%>" name="vvdCombo" id="vvdCombo">
                        </td>
                        <td><input type="text" style="width:125px; ime-mode:disabled;" class="input" maxlength="20" tabindex="10" value="<%=vvdValue%>" name="vvd_value" id="vvd_value"></td>
                        <th>F/M</th>
                        <td>
                            <select style="width:65px;" tabindex="13" name="cntr_full_sts_cd" id="cntr_full_sts_cd">
                                <option value="" selected>ALL</option>
                                <option value="F">F</option>
                                <option value="M">M</option>
                            </select><!--
                            --><input type="hidden" value="<%=cntrFullStsCd%>" name="cntrFullStsCd" id="cntrFullStsCd">
                        </td>
                        <th>Result</th>
                        <td><select style="width:80px;" tabindex="16" name="mvmt_edi_rslt_cd" id="mvmt_edi_rslt_cd">
                                <option value="ALL">ALL</option>
                                <option value="N" selected>Error</option>
                                <option value="Y">OK</option>
                                <option value="X">Ignored</option>
                                <option value="D">Deleted</option>
                            </select><!--
                            --><input type="hidden" value="<%=mvmtEdiRsltCd%>" name="mvmtEdiRsltCd" id="mvmtEdiRsltCd">
                        </td>
                        <th>I/O Status</th>
                        <td><script type="text/javascript">ComComboObject("ioStatusCombo", 2, 70, 1, 0, 0, 0, 19);</script><!--  
                        --><input type="hidden" value="<%=ediGateIoCd%>" name="edi_gate_io_cd" id="edi_gate_io_cd">
                        </td>
                        <th>Message</th>
						<td><input type="text" style="width:150px;" class="input" name="s_message" id="s_message" value="" maxlength="100"  /></td>
                    </tr>
                    
                </table>
            </div>
        </div>
    </div>
</div>
	<div class="wrap_result">
		<div class="opus_design_grid">
		<div class="opus_design_btn"><!--  
			--><button type="button" class="btn_accent" name="btn_more" id="btn_more">More</button><!--
			--></div>
		    <script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
</div>

</form>
