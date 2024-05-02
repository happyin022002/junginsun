<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESS_DMT_3004.jsp
*@FileTitle  : Charge Inquiry by Office Or VVD
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/03
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.event.EesDmt3004Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesDmt3004Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//DB ResultSet Count of list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_ofc		= "";
	String strUsr_Cnt_cd	= "";
	String strRhq_ofc_cd	= "";
	Logger log = Logger.getLogger("com.clt.apps.DMTClosing.ChargeCalculation");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id		= account.getUsr_id();
		strUsr_nm		= account.getUsr_nm();
		strUsr_ofc		= account.getOfc_cd();
		strUsr_Cnt_cd	= account.getCnt_cd();
		strRhq_ofc_cd	= account.getRhq_ofc_cd();

		event = (EesDmt3004Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// in loading page, Get data from server
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
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<input type="hidden" name="usr_ofc_cd"			value="<%=strUsr_ofc%>">
<input type="hidden" name="usr_cnt_cd"			value="<%=strUsr_Cnt_cd%>">
<input type="hidden" name="usr_rhq_ofc_cd"		value="<%=strRhq_ofc_cd%>">
<input type="hidden" name="usr_trf_tp">
<input type="hidden" name="ofc_cd">
<input type="hidden" name="tmp_ofc_cd">
<input type="hidden" name="dmdt_trf_cd">
<input type="hidden" name="dmdt_chg_sts_cd">
<input type="hidden" name="fm_mvmt_yd_cd">
<input type="hidden" name="to_mvmt_yd_cd">
<input type="hidden" name="pol_cd">
<input type="hidden" name="pod_cd">
<input type="hidden" name="fm_mvmt_dt">
<input type="hidden" name="to_mvmt_dt">
<input type="hidden" name="yd_cd1">
<input type="hidden" name="loc_cd">
<input type="hidden" name="chk_yd_cd" value="Y">
<input type="hidden" name="chk_loc_cd" value="Y">

<!-- Parameters for checking authority  -->
<input type="hidden" name="role_permit">
<input type="hidden" name="role_auth">
<input type="hidden" name="status">

	<!-- page(S) -->
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		
		<!-- page_title(S) -->
	    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->
	
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--
			--><button type="button" class="btn_normal" name="btn_New" id="btn_New">New</button><!--			
			--><button type="button" class="btn_normal" name="btn_Minimize" id="btn_Minimize">Minimize</button><!--			
			--><button type="button" class="btn_normal" name="btn_DELCancel" id="btn_DELCancel">DEL Cancel</button><!--
			--><button type="button" class="btn_normal" name="btn_ByBKG" id="btn_ByBKG">by BKG</button><!--
			--><button type="button" class="btn_normal" name="btn_ByCNTR" id="btn_ByCNTR">by CNTR</button><!--			
			--><button type="button" class="btn_normal" name="btn_MVMTInq" id="btn_MVMTInq">MVMT Inq.</button><!--
			--><button type="button" class="btn_normal" name="btn_DownExcel" id="btn_DownExcel">Down Excel</button>
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
	<!--Page Title, Historical (E)-->
	
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit"  id="sch_cond_div">
			<!--  MiniLayer (S) -->
			<table>
				<tr>
					<td>
						<table>
							<colgroup>
					            <col width="40px" />
					            <col width="220px" />
					            <col width="75px" />
					            <col width="145px" />
					            <col width="45px" />
					            <col width="160px" />
					            <col width="30px" />
					            <col width="90px" />
					            <col width="80px" />
					            <col width="30px" />	            
					            <col width="" />
							</colgroup>
							<tbody>
								<tr>
									<th>Office</th>
									<td>
										<script type="text/javascript">ComComboObject('office', 2, 80, 0, 1, 0, true);</script><!--									
										--><button type="button" class="multiple_inq"></button><!--
										--><input type="checkbox" name="chk_sub_ofc" value="Y" onClick="doInclSubOfc()" class="trans">Incl. Sub Office
									</td>
									<th>Tariff Type</th>
									<td>									
										<script type="text/javascript">ComComboObject('tariff_type',2,100, 0, 1, 0);</script><!--									
										--><button type="button" class="multiple_inq"></button>
									</td>
									<th>Status</th>
									<td>
										<script type="text/javascript">ComComboObject('status_combo', 2, 110, 0, 1, 0);</script><!--									
										--><button type="button" class="multiple_inq"></button>
									</td>
									<th>G/B</th>
									<td>
										<select name="chg_type" id="chg_type" style="width:70px;" class="input">
											<option value="" selected>All</option>
											<option value="G">General</option>
											<option value="B">Balance</option>
										</select>
									</td>
									<th>F/T Over Day</th>
									<td>
										<input type="text" name="fx_ft_ovr_dys" dataformat="int" maxlength="3" minnum='0' caption='F/Time Over Day'  style="width:30px;text-align:right" class="input" value="0">
									</td>
									<td></td>
								</tr>
							</tbody>					
						</table>
					</td>
				</tr>
				<tr>
					<td>
						<table>
							<colgroup>
					            <col width="80px" />
					            <col width="50px" />
					            <col width="245px" />
					            <col width="45px" />
					            <col width="*" />				           	            
							</colgroup>
							<tbody>
								<tr>
									<td><input type="radio" name="cond_type" id="cond_type" value="date" class="trans" OnClick="condType_click()" checked="true"><strong>Date</strong></td>
									<td>Period</td>
									<td>
										<input type="text" style="width:80px;text-align:center;ime-mode:disabled" class="input1" name="fm_mvmt_dt1" id="fm_mvmt_dt1" dataformat="ymd"  caption="Period From Date">~&nbsp;<!--
										--><input type="text" style="width:80px;text-align:center;ime-mode:disabled" class="input1" name="to_mvmt_dt1" id="to_mvmt_dt1" dataformat="ymd"  caption="Period To Date" ><!--
										--><button type="button" class="calendar" name="btns_calendar" id="btns_calendar"></button>									
									</td>
									<td>Yard</td>								
									<td colspan="2">
										<input type="radio" name="yard_fmto" value="yard_fm" checked class="trans">From&nbsp;&nbsp;
										<input type="radio" name="yard_fmto" value="yard_to" class="trans">To&nbsp;&nbsp;
										<input type="text" name="yd_cd" dataformat="engup" maxlength="5" OnKeyUp="obj_keyup()" style="width:49px;" class="input"><!--
										--><script language="javascript">ComComboObject('yd_cd2', 2, 45 , 0);</script>
									</td>
								</tr>
							</tbody>
						</table>
					</td>
				</tr>
				<tr>
					<td>
						<table>
							<colgroup>
					            <col width="80px" />
					            <col width="50px" />
					            <col width="245px" />
					            <col width="45px" />
					            <col width="140px" />
					            <col width="62px" />
					            <col width="*" />				            
							</colgroup>
							<tbody>
								<tr>
									<td><input type="radio" name="cond_type" id="cond_type" value="vvd_cd" class="trans" OnClick="condType_click()"><strong>VVD CD</strong></td>
									
									<td>VVD CD</td>
									<td>
										<input type="text" name="vvd_cd" dataformat="engup"  maxlength="9"  style="width:80px;" class="input" value="">
									</td>
									<td>Port</td>
									<td>
										<input type="text" name="tmnl_cd" dataformat="engup" maxlength="5" OnKeyUp="obj_keyup()" style="width:50px;" class="input" value="">&nbsp;
										<!--<script language="javascript">ComComboObject('tmnl_cd2', 2, 60 , 0);</script>-->
									</td>
									<td>DEM Type</td>
									<td colspan="2">
										<select name="dem_type" style="width:98px;" class="input">
											<option value="" selected>All</option>
											<option value="I">Intransit </option>
											<option value="L">Local</option>
										</select>
									</td>
								</tr>
							</tbody>
						</table>
					</td>
				</tr>
				<tr>
					<td>
						<table>
							<colgroup>
					            <col width="80px" />
					            <col width="50px" />
					            <col width="245px" />
					            <col width="45px" />
					            <col width="140px" />
					            <col width="62px" />
					            <col width="*" />				            
							</colgroup>
							<tbody>
								<tr>
									<td><input type="radio" name="cond_type" id="cond_type" value="cntr" class="trans" OnClick="condType_click()"><strong>CNTR</strong></td>
									<td>BKG No.</td>
									<td>
										<input type="text" name="bkg_no" dataformat="engup" maxlength="12" style="width:100px;" class="input" value=""><!--
										--><button type="button" class="multiple_inq" id="btns_multisearch1" name="btns_multisearch1" onClick="doProcessPopup('m_bkg_no')"></button>									
									</td>
									<td>B/L No.</td>
									<td>
										<input type="text" name="bl_no" dataformat="engup" maxlength="12" style="width:100px;" class="input" value=""><!--
										--><button type="button" class="multiple_inq" id="btns_multisearch2" name="btns_multisearch2" onClick="doProcessPopup('m_bl_no')"></button>									
									</td>
									<td>CNTR No.</td>
									<td colspan="2">
										<input type="text" name="cntr_no" dataformat="engup" maxlength="11"  style="width:98px;" class="input" value=""><!--
										--><button type="button" class="multiple_inq" id="btns_multisearch3" name="btns_multisearch3" onClick="doProcessPopup('m_cntr_no')"></button>
									</td>
								</tr>
							</tbody>
						</table>					
					</td>
				</tr>
				<tr>
					<td>
						<table>
							<colgroup>
					            <col width="60px" />
					            <col width="245px" />
					            <col width="114px" />
					            <col width="140px" />
					            <col width="62px" />
					            <col width="130px" />				            				            
					            <col width="55px" />
					            <col width="*" />
							</colgroup>
							<tbody>
								<tr>
									<th>Customer</th>
									<td>
										<select name="cust_type" id="cust_type" style="width:56px;" class="input">
											<option value="" selected>ALL</option>
											<option value="P">Payer</option>
											<option value="S">SHPR</option>
											<option value="C">CNEE</option>
											<option value="N">NTFY</option>
											<option value="A">A/R</option>
										</select><!--
										--><input type="text" name="cust_cd"  dataformat="engup"  maxlength=8  style="width:100px;" class="input" caption="Customer Code"><!--
										--><button type="button" class="input_seach_btn" name="btns_search1" id="btns_search1" onClick="doProcessPopup('cust_cd')"></button>									
									</td>
									<th>Service Provider</th>
									<td>
										<input type="text" name="svc_provdr" maxlength="6"  dataformat="int" fulfill style="width:100px;"  class="input" value="" caption="Service Provider"><!--
										--><button type="button" class="input_seach_btn" name="btns_search2" id="btns_search2" onClick="doProcessPopup('svc_provdr')"></button>									
									</td>
									<th>S/C No.</th>
									<td>
										<input type="text" name="sc_no" dataformat="engup" maxlength=20  style="width:98px;"  class="input" value="" caption="S/C No.">
									</td>
									<th>RFA No.</th>
									<td colspan="2">
										<input type="text" name="rfa_no"  dataformat="engup" maxlength=11  style="width:105px;" class="input" value="" caption="RFA No.">
									</td>
								</tr>
							</tbody>
						</table>							
					</td>
				</tr>
			</table>
		</div>
	</div>
	
	<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid"  id="mainTable">
			<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
		    <script type="text/javascript">ComSheetObject('sheet1');</script>
		    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
		</div>
		<!-- opus_design_grid(E) -->
	</div>
</form>
