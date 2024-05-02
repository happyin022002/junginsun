<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_BKG_0393.jsp
*@FileTitle  : House B/L Data Input Checklist 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/02
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.event.EsmBkg0393Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0393Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from the server
	String strErrMsg = "";						//error messege
	int rowCount	 = 0;						//the number of DB ResultSet List
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strCnt_cd        = "";
    String strPgmNo         = "";
    String strCustoms       = "";
	Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.ManifestListDownload");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strCnt_cd = account.getCnt_cd();
	   	   
		event = (EsmBkg0393Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// extract additional data obtained from the server during Initial loading ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		strPgmNo = request.getParameter("pgmNo");
        if("ESM_BKG_0393".equals(strPgmNo)) strCustoms = "US";
        if("ESM_BKG_0393_3".equals(strPgmNo)) strCustoms = "CA";
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript" src="rpt/script/common_rd.js"></script>
<script type="text/javascript">
    var strCntCd = "<%=strCnt_cd%>";
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form" method="post">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="customs" value="<%=strCustoms%>" id="customs" />
<input type="hidden" name="filer" id="filer" />
<input type="hidden" name="err_flg" id="err_flg" />

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
			--><button type="button" class="btn_normal" name="btn_DownExcel" id="btn_DownExcel">Down Excel</button><!--						
			--><button type="button" class="btn_normal" name="btn_Print" id="btn_Print">Print</button>
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

	<!-- wrap_search_tab(S) -->
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry">
			<!--  MiniLayer (S) -->
			<table>
				<colgroup>
		            <col width="60" />
		            <col width="140" />
		            <col width="50" />
		            <col width="140" />
		            <col width="30" />
		            <col width="100" />
		            <col width="100" />	            
		            <col width="10" />                
		            <col width="20" />
		            <col width="20" />
		            <col width="" />
				</colgroup>
				<tbody>
					<tr>
						<th title="Vessel Voyage Direction">VVD</th>
						<td><input type="text" name="vvd" style="width:105px; ime-mode: disabled;"  class="input1"dataformat="engup" maxlength="9" required fullfill caption="VVD"></td>
						<th title="Port of Loading">POL</th>
						<td><input type="text" name="pol_cd" style="width:80px; ime-mode: disabled;" class="input1"dataformat="engup" maxlength="5" required caption="POL"></td>
						<th title="Port of Discharging">POD</th>
						<td><input type="text" name="pod_cd" style="width:80px; ime-mode: disabled;" class="input"dataformat="engup" maxlength="5" fullfill caption="POD"></td>
						<th>Destined to</th>
						<td><input type="text" name="conti_cd" style="width:20px; ime-mode: disabled; text-align:center" value="M" class="input"dataformat="engup" maxlength="1" fullfill caption="">&nbsp;(Continent)</td>
						<td></td>
						<td rowspan="2">
							<div class="sm">
								<table>
									<tr>
										<td>
											<input type="radio" id="chk_err_all" name="chk_err" value="all" checked><label for="chk_err_all">All</label>
										</td>
									</tr>
									<tr>
										<td>
											<input type="radio" id="chk_err_err" name="chk_err" value="err"><label for="chk_err_err">Error</label>
										</td>
									</tr>
								</table>
							</div>
						</td>
						<td></td>										
					</tr>
					<tr>
						<th>BKG OFC</th>
						<td><input type="text" name="bkg_ofc_cd" style="width:105px; ime-mode: disabled;" class="input"dataformat="engup" maxlength="5" caption="BKG OFC"></td>
						<th>L.REP</th>
						<td colspan="3"><input type="text" name="ob_srep_cd" style="width:80px; ime-mode: disabled;" class="input" dataformat="eng" maxlength="5" caption="L.REP"></td>
						<th><%=strCustoms%> Filer</th>					
						<td><script type="text/javascript">ComComboObject('mbl_filer', 2, 60, 1, 0);</script></td>	
						<td></td>				
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	
	<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">		
			<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
		    <script type="text/javascript">ComSheetObject('sheet1');</script>
		    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
		</div>  
		<div class="opus_design_inquiry">
	    	<table> 
				<tr>
					<th width="40">Total</th>
					<td width="120"><input type="text" name="tot_bkg" class="input" style="width:105px" readonly></td>
					<td width="40">&nbsp;</td>
					<td colspan="2"><input type="text" name="tot_mbl_ttl" style="width:400px" class="input" readonly></td>
					<td width=""><input type="text" name="tot_bl" style="width:150; font-weight:bold;" class="input" readonly></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td><input type="text" name="tot_mbl" class="input" style="width:105px" readonly></td>
					<th align="right"><%=strCustoms%> Filer 01 : </th>
					<td width="300px"><input type="text" name="tot_hbl" style="width:150px" class="input" readonly>&nbsp;<input type="text" name="tot_fileno" style="width:100px" class="input" readonly></td>
					<th width="100px" align="right"> Other : </th>
					<td width="*"><input type="text" name="tot_hbl_etc" style="width:150px" class="input" readonly>&nbsp;<input type="text" name="tot_fileno_etc" style="width:100px" class="input" readonly></td>
				</tr>
			</table>
		</div>
		<!-- opus_design_grid(E) -->
	</div>
	
	<!--biz page 2 (E)-->
	<div class="opus_design_RD" style="display:inline;height:0px!important;position:absolute;">
		<script type="text/javascript">rdViewerObject('report1');</script>
	</div>
	<!--biz page 2 (E)-->
</form>
