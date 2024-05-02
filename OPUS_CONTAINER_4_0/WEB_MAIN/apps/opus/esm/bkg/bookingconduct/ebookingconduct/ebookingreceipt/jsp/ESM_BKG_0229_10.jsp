<%
/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : ESM_BKG_0229_10.jsp
 *@FileTitle : e-Booking & SI Process Detail(HBL 1)
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/06/17
 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil" %>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event.EsmBkg022910Event"%>
<%@ page import="com.clt.framework.core.controller.DefaultViewAdapter"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO" %>
<%@ page import="java.util.List" %>

<%
	EsmBkg022910Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //error from server
	String strErrMsg = ""; //error message
	int rowCount = 0; //count of DB resultSET list
	String successFlag = "";
	String codeList = "";
	String pageRows = "100";
	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.clt.apps.EBookingConduct.EBookingReceipt");
	String sXml = null;
	List<BkgComboVO> wgt_cd = null;
	List<BkgComboVO> meas_cd = null;
	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (EsmBkg022910Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		DefaultViewAdapter adapter = new DefaultViewAdapter();
		sXml = adapter.makeXML(request, response);
		wgt_cd = (List<BkgComboVO>) eventResponse.getCustomData("wgt_cd");
		meas_cd = (List<BkgComboVO>) eventResponse.getCustomData("meas_cd");
	} catch (Exception e) {
		out.println(e.toString());
	}
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
<input type="hidden" name="xter_si_no" value="<%=StringUtil.xssFilter(request.getParameter("xter_si_no")) %>" id="xter_si_no" />
<input type="hidden" name="rqst_seq" value="<%=StringUtil.xssFilter(request.getParameter("rqst_seq")) %>" id="rqst_seq" />
<input type="hidden" name="sender_id" value="<%=StringUtil.xssFilter(request.getParameter("sender_id")) %>" id="sender_id" />
<input type="hidden" name="hbl1_opus" value="" id="hbl1_opus" />
<input type="hidden" name="hbl1_esvc" value="" id="hbl1_esvc" />
<input type="hidden" name="sXml" value="<%=JSPUtil.replace(sXml, "\"", "&quot;")%>" id="sXml" />

<!-- wrap_result(S) -->
	<!-- layout_wrap(S) -->
	<div class="layout_wrap">
		<!-- layout_vertical_2(S) -->
		<div class="layout_vertical_2" >
		
			<table>
				<tr>
					<td style="text-align: left;"><h3 class="title_design">Booking Data OPUS</h3></td>
					<td style="text-align: right;"><button type="button" class="btn_etc" name="btn_cancelcopydata" id="btn_cancelcopydata">Cancel Copy Data</button></td>
				</tr>
			</table>
			
			<!-- opus_design_inquiry(S) -->
			<div class="opus_design_inquiry">
				<table>
					<tbody>
						<colgroup>
							<col width="75" />
							<col width="10" />
							<col width="100" />
							<col width="100" />
							<col width="*" />
						</colgroup>
						<tr>
							<th>Seq.</th>
							<td>
								<select name="opus_seq" id="opus_seq" style="width: 40px;" onChange="javascript:change_seq('sheet1', this)" onClick="javascript:click_seq(this)"></select>
							</td>
							<td>of <span id="opus_seq_tot"></span></td>
							<th>Booking No.</th>
							<td><input type="text" name="bkg_no" style="width: 105px;" class="input2" value="<%=StringUtil.xssFilter(request.getParameter("bkg_no")) %>" id="bkg_no" readOnly></td>
						</tr>
					</tbody>
				</table>
				<table>
					<tbody>
						<colgroup>
							<col width="75" />
							<col width="*" />
						</colgroup>
						<tr>
							<th>Request No.</th>
							<td><input type="text" name="xter_si_no1" dataformat="engup" style="width: 120px;" class="input" value="" id="xter_si_no1" /> </td>
						</tr>
						<tr>
							<th>House B/L No.</th>
							<td><input type="text" name="hbl_no" dataformat="engup" style="width: 120px;" class="input" value="" id="hbl_no" /> </td>
						</tr>
						<tr>
							<th rowspan="2" valign="top">Actual Shipper</th>
							<td><textarea type="text" name="shpr_nm" id="shpr_nm" dataformat="engup" otherchar="<%=getSpecialChars()%>" style="width: 367px;" class="input" rows="2" value=""></textarea></td>
						</tr>
						<tr>
							<td><textarea type="text" name="shpr_addr" id="shpr_addr" dataformat="engup" otherchar="<%=getSpecialChars()%>" style="width: 367px;" class="input" rows="2" value=""></textarea></td>
						</tr>
						<tr>
							<th rowspan="2" valign="top">Actual<br>Consignee</th>
							<td><textarea type="text" name="cnee_nm" id="cnee_nm" dataformat="engup" otherchar="<%=getSpecialChars()%>" style="width: 367px;" class="input" rows="2" value=""></textarea></td>
						</tr>
						<tr>
							<td><textarea type="text" name="cnee_addr" id="cnee_addr" dataformat="engup" otherchar="<%=getSpecialChars()%>" style="width: 367px;" class="input" rows="2" value=""></textarea></td>
						</tr>
						<tr>
							<th rowspan="2" valign="top">Actual Notify</th>
							<td><textarea type="text" name="noti_nm" id="noti_nm" dataformat="engup" otherchar="<%=getSpecialChars()%>" style="width: 367px;" class="input" rows="2" value=""></textarea></td>
						</tr>
						<tr>
							<td><textarea type="text" name="noti_addr" id="noti_addr" dataformat="engup" otherchar="<%=getSpecialChars()%>" style="width: 367px;" class="input" rows="2" value=""></textarea></td>
						</tr>
						<tr>
							<th>Weight</th>
							<td><input type="text" name="hbl_wgt" id="hbl_wgt" dataformat="float" pointcount="3" caption="Weight"  onBlur="makeComma2(this)" style="width: 100px; text-align: right;" class="input" value="" id="hbl_wgt" /><script type="text/javascript">ComComboObject('wgt_ut_cd', 1, 55, 1,"")</script></td>
						</tr>
						<tr>
							<th>Package</th>
							<td><input type="text" name="pck_qty" id="pck_qty" dataformat="num" caption="Package" style="width: 100px; text-align: right;" class="input" value="" id="pck_qty" /><input type="text" align="right" dataformat="engup"  maxlength="2" otherchar="<%=getSpecialChars()%>" name="pck_tp_cd" style="width: 32px;  class="input" value="" id="pck_tp_cd" /><button type="button" id="btn_package" name="btn_package" class="input_seach_btn"></button></td>
						</tr>
						<tr>
							<th>Measure</th>
							<td><input type="text" name="cmdt_meas_qty" id="cmdt_meas_qty" dataformat="float" pointcount="3" caption="Measure"  onBlur="makeComma2(this)" style="width: 100px; text-align: right;" class="input" value="" id="cmdt_meas_qty" /><script type="text/javascript">ComComboObject('cmdt_meas_ut_cd', 1, 55, 1, "")</script></td>
						</tr>
						<tr>
							<th>Mark & NOS</th>
							<td><textarea dataformat="engup" otherchar="<%=getSpecialChars()%>" cols="69" rows="3" name="bl_mk_desc" id="bl_mk_desc" style="width: 500px;" ></textarea></td>
						</tr>
						<tr>
							<th>Description</th>
							<td><textarea dataformat="engup" otherchar="<%=getSpecialChars()%>" cols="69" rows="3" name="bl_gds_desc" id="bl_gds_desc" style="width: 500px;" ></textarea></td>
						</tr>
					</tbody>
				</table>
				
			</div>
			<!-- opus_design_inquiry(E) -->
		</div>
		<!-- layout_vertical_2(E) -->
	
		<!-- layout_vertical_2(S) -->
		<div class="layout_vertical_2 pad_left_8" >
		
			<table>
				<tr>
					<td style="text-align: left;"><h3 class="title_design">From e- Service</h3></td>
					<td style="text-align: right;"><button type="button" class="btn_etc" name="btn_datacopytoopus" id="btn_datacopytoopus">Data Copy to OPUS</button></td>
				</tr>
			</table>
		
			<!-- opus_design_inquiry(S) -->
			<div class="opus_design_inquiry">
				<table>
					<tbody>
						<colgroup>
							<col width="75" />
							<col width="*" />
						</colgroup>
						<tr>
							<td>Seq. <select name="xter_seq" id="xter_seq" style="width: 40px;" onchange="javascript:change_seq('sheet2', this)"></select></td>
							<td>of <span id="xter_seq_tot"></span></td>
						</tr>
					</tbody>
				</table>
				<table>
					<tbody>
						<colgroup>
							<col width="75" />
							<col width="*" />
						</colgroup>
						<tr>
							<th>Request No.</th>
							<td><input type="text" name="xter_si_no2" style="width: 120px;" class="input2" value="" readonly id="xter_si_no2" /></td>
						</tr>
						<tr>
							<th>House B/L No.</th>
							<td><input type="text" name="hbl_no2" style="width: 120px;" class="input2" value="" readonly id="hbl_no2" /> </td>
						</tr>
						<tr>
							<th rowspan="2" valign="top">Actual Shipper</th>
							<td><textarea type="text" name="shpr_nm2" id="shpr_nm2" style="width: 367px;" rows="2" class="textarea2" value="" readonly="readonly"></textarea></td>
						</tr>
						<tr>
							<td><textarea type="text" name="shpr_addr2" id="shpr_addr2" style="width: 367px;" rows="2" class="textarea2" value="" readonly="readonly"></textarea></td>
						</tr>
						<tr>
							<th rowspan="2" valign="top">Actual<br>Consignee</th>
							<td><textarea type="text" name="cnee_nm2" id="cnee_nm2" style="width: 367px;" rows="2" class="textarea2" value="" readonly="readonly"></textarea></td>
						</tr>
						<tr>
							<td><textarea type="text" name="cnee_addr2" id="cnee_addr2" style="width: 367px;" rows="2" class="textarea2" value="" readonly="readonly"></textarea></td>
						</tr>
						<tr>
							<th rowspan="2" valign="top">Actual Notify</th>
							<td><textarea type="text" name="noti_nm2" id="noti_nm2" style="width: 367px;" rows="2" class="textarea2" value="" readonly="readonly"></textarea></td>
						</tr>
						<tr>
							<td><textarea type="text" name="noti_addr2" id="noti_addr2" style="width: 367px;" rows="2" class="textarea2" value="" readonly="readonly"></textarea></td>
						</tr>
						<tr>
							<th>Weight</th>
							<td><input type="text" name="hbl_wgt2" id="hbl_wgt2" style="width: 100px; text-align: right;" class="input2" value="" readonly="readonly" id="hbl_wgt2" /><input type="text" name="wgt_ut_cd2" style="width: 55px; class="input2" value="" readonly="readonly" id="wgt_ut_cd2" /></td>
						</tr>
						<tr>
							<th>Package</th>
							<td><input type="text" name="pck_qty2" id="pck_qty2" style="width: 100px; text-align: right;" class="input2" value="" readonly="readonly" id="pck_qty2" /><input type="text" name="pck_tp_cd2" style="width: 55px; class="input2" value="" readonly="readonly" id="pck_tp_cd2" /></td>
						</tr>
						<tr>
							<th>Measure</th>
							<td><input type="text" name="cmdt_meas_qty2" id="cmdt_meas_qty2" style="width: 100px; text-align: right;" class="input2" value="" readonly="readonly" id="cmdt_meas_qty2" /><input type="text" name="cmdt_meas_ut_cd2" style="width: 55px; class="input2" value="" readonly="readonly" id="cmdt_meas_ut_cd2" /></td>
						</tr>
						<tr>
							<th valign="top">Mark & NOS</th>
							<td><textarea cols="69" rows="3" class="textarea2" name="bl_mk_desc2" id="bl_mk_desc2" readonly="readonly"  style="width: 500px;"></textarea></td>
						</tr>
						<tr>
							<th valign="top">Description</th>
							<td><textarea cols="69" rows="3" class="textarea2" name="bl_gds_desc2" id="bl_gds_desc2" readonly="readonly"  style="width: 500px;"></textarea></td>
						</tr>
					</tbody>
				</table>
				
			</div>
			<!-- opus_design_inquiry(E) -->
		</div>
		<!-- layout_vertical_2(E) -->
	
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
</div>
<!-- wrap_result(E) -->
</form>
<%!
	public String getSpecialChars() {
		return " ~!@#$%^&*()`_+-={}|[]\\\"\\':;,./?"; 
	}
%>