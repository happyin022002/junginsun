<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_SCE_0915.jsp
*@FileTitle  : BKG Info
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/31
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="java.util.List"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.apps.opus.esd.sce.copmanage.copsearch.event.EsdSce0915Event"%>
<%//@ page import="com.clt.apps.opus.esd.sce.copmanage.copsearch.event.EsdSce0915EventResponse"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.apps.opus.esd.sce.copmanage.copsearch.vo.BookingInfoVO"%>

<%
    EsdSce0915Event			event			= null; //PDTO(Data Transfer Object including Parameters)
    //EsdSce0915EventResponse	eventResponse	= null;	//RDTO(Data Transfer Object including DB ResultSet)
    GeneralEventResponse        eventResponse   = null;
	Exception					serverException = null;	//
    DBRowSet					rowSet			= null; //DB ResultSet
	//DBRowSet					rowSetVVD		= null; //VVD
	List<BookingInfoVO> 		listVVD         = null;

	String strErrMsg	= "";
    int rowCount		= 0;
    int rowCountVVD     = 0;

    //String successFlag	= "";
    //String codeList		= "";
    //String pageRows		= "100";

	String bkgNo			= "";
	String bkgNoSplit		= "";

	String bl_no			= "";
	String bkg_ref_no		= "";
	String bkg_date			= "";
	String por				= "";
	String pol				= "";
	String pod				= "";
	String del				= "";
	String rd_term			= "";
	String cntr_ts			= "";
	String weight			= "";
	String measure			= "";
	String hot_delivery		= "";
	String lcl				= "";
	String special_cargo	= "";
	String commodity_cd		= "";
	String commodity_nm		= "";
	String shipper_cd		= "";
	String shipper_nm		= "";
	String consignee_cd		= "";
	String consignee_nm		= "";
	String notify_cd		= "";
	String notify_nm		= "";
	String bkg_office		= "";
	String bkg_staff		= "";
	String sales_office		= "";
	String sales_staff		= "";
	String vvd_1			= "";
	String vvd_2			= "";
	String vvd_3			= "";
	String vvd_4			= "";
	String[] vvd_01			= null;
	String[] vvd_02			= null;
	String[] vvd_03			= null;
	String[] vvd_04			= null;

    try {
        event = (EsdSce0915Event)request.getAttribute("Event");
		//bkgNo = event.getSCE_COP_HDR().getBkg_no();
		bkgNo = event.getCopInquiryVO().getBkgNo();
		//bkgNoSplit = event.getSCE_COP_HDR().getBkg_no_split();

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }else{
            eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");
            if (eventResponse != null) {
                rowSet = eventResponse.getRs();
                if(rowSet != null){
					rowCount = rowSet.getRowCount();
					rowSet. beforeFirst();
		 			if (rowSet.next()) {
						//bl_no			= JSPUtil.getNull(rowSet.getString("bl_no")) + JSPUtil.getNull(rowSet.getString("bl_no_tp")) + JSPUtil.getNull(rowSet.getString("bl_no_chk"));
						bl_no			= JSPUtil.getNull(rowSet.getString("bl_no"));
						bkg_ref_no		= JSPUtil.getNull(rowSet.getString("ref_no"));
						bkg_date		= JSPUtil.getNull(rowSet.getString("bkg_cre_dt"));
						por				= JSPUtil.getNull(rowSet.getString("por_cd"));
						pol				= JSPUtil.getNull(rowSet.getString("pol_cd"));
						pod				= JSPUtil.getNull(rowSet.getString("pod_cd"));
						del				= JSPUtil.getNull(rowSet.getString("del_cd"));
						rd_term			= JSPUtil.getNull(rowSet.getString("rcv_term_cd")) + "/" + JSPUtil.getNull(rowSet.getString("de_term_cd"));

						cntr_ts			= JSPUtil.getNull(rowSet.getString("cntr_tpsz_cd"));
						weight			= JSPUtil.getNull(rowSet.getString("ACT_BKG_WGT")) + JSPUtil.getNull(rowSet.getString("ACT_BKG_WGT_TP_CD"));
						measure			= JSPUtil.getNull(rowSet.getString("BKG_MEAS_QTY")) + JSPUtil.getNull(rowSet.getString("BKG_MEAS_TP_CD"));
						hot_delivery	= ("1".equals(JSPUtil.getNull(rowSet.getString("BKG_HOT_DE_FLG"))) ) ? "Y" : "N";
						lcl				= "";
						special_cargo	=
							JSPUtil.getNull(rowSet.getString("dcgo_flg")) + "/" + JSPUtil.getNull(rowSet.getString("awk_cgo_flg")) + "/" + JSPUtil.getNull(rowSet.getString("bb_cgo_flg")) + "/" + JSPUtil.getNull(rowSet.getString("rd_cgo_flg"));
						commodity_cd	= "";
						commodity_nm	= JSPUtil.getNull(rowSet.getString("REP_CMDT_CD"));




						shipper_cd		= JSPUtil.getNull(rowSet.getString("sh_cust_cnt_cd")) + JSPUtil.customString((String)rowSet.getString("sh_cust_seq"),6);
						shipper_nm		= JSPUtil.getNull(rowSet.getString("sh_cust_nm"));
						consignee_cd	= JSPUtil.getNull(rowSet.getString("cn_cust_cnt_cd")) + JSPUtil.getNull(rowSet.getString("cn_cust_seq"));
						consignee_cd	= ("0".equals(consignee_cd)) ? "" : consignee_cd;
						consignee_nm	= JSPUtil.getNull(rowSet.getString("cn_cust_nm"));
						notify_cd		= JSPUtil.getNull(rowSet.getString("nf_cust_cnt_cd")) + JSPUtil.getNull(rowSet.getString("nf_cust_seq"));
						notify_cd		= ("0".equals(notify_cd)) ? "" : notify_cd;
						notify_nm		= JSPUtil.getNull(rowSet.getString("nf_cust_nm"));

						bkg_office		= JSPUtil.getNull(rowSet.getString("BKG_OFC_CD"));
						bkg_staff		= JSPUtil.getNull(rowSet.getString("doc_usr_id"));
						sales_office	= JSPUtil.getNull(rowSet.getString("ob_sls_ofc_cd"));
						sales_staff		= JSPUtil.getNull(rowSet.getString("ob_srep_cd"));

					}

                } // end if

			    //rowSetVVD = eventResponse.getRsVVD();
			    listVVD = (List<BookingInfoVO>)eventResponse.getRsVoList();

                if(listVVD != null){
					rowCountVVD = listVVD != null ? listVVD.size() : 0; //rowSetVVD.getRowCount();
					//rowSetVVD.beforeFirst();
					//out.println("rowCountVVD="+rowCountVVD);
					if(rowCountVVD > 0){
						vvd_01 = new String[rowCountVVD];
						vvd_02 = new String[rowCountVVD];
						vvd_03 = new String[rowCountVVD];
						vvd_04 = new String[rowCountVVD];
						int vv = 0;
						//while (rowSetVVD.next()) {
						for(int i=1; i<rowCountVVD; i++){

						/*
							vvd_01[vv] = JSPUtil.getNull(vo.getString("VSL_PRE_PST_CD"));
							vvd_02[vv] = JSPUtil.getNull(vo.getString("vsl_cd"));
							vvd_03[vv] = JSPUtil.getNull(vo.getString("skd_voy_no"));
							vvd_04[vv] = JSPUtil.getNull(vo.getString("skd_dir_cd"));
							vv++;
							*/

							BookingInfoVO vo = (BookingInfoVO)listVVD.get(i);
							vvd_01[vv] = JSPUtil.getNull(vo.getVslPrePstCd());
							vvd_02[vv] = JSPUtil.getNull(vo.getVslCd());
							vvd_03[vv] = JSPUtil.getNull(vo.getSkdVoyNo());
							vvd_04[vv] = JSPUtil.getNull(vo.getSkdDirCd());	

							vv++;											

						}

						vvd_1 = vvd_02[0] + vvd_03[0] + vvd_04[0];

						if(rowCountVVD > 2) {
							vvd_2 = vvd_02[1] + vvd_03[1] + vvd_04[1];
						}
						if(rowCountVVD > 3) {
							vvd_3 = vvd_02[2] + vvd_03[2] + vvd_04[2];
						}
						if(rowCountVVD > 4) {
							vvd_4 = vvd_02[3] + vvd_03[3] + vvd_04[3];
						}

					} // end if

				} // end if

            } // end if

		} // end else
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
	}

</script>

	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>BKG Information</span></h2>
		<!-- page_title(E) -->

		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_close" id="btn_close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->	
	</div>
	<!-- page_title_area(E) -->


	<!-- wrap_result(S) -->
	<div class="wrap_result">
		<!-- opus_design_grid (S) -->
		<div class="opus_design_data">
			<table class="grid2">
				<colgroup>
					<col width="85">
					<col width="115">
					<col width="80">
					<col width="100">
					<col width="90">
					<col width="100">
					<col width="85">
					<col width="*">
				</colgroup>
				<tbody>
					<tr>
						<th>Booking No. </th>
						<td><input name="bkg_no" type="text" class="noinput" style="width:110px;" value="<%=bkgNo%>" id="bkg_no" /></td>
						<th>BL No. </th>
						<td><input name="bl_no" type="text" class="noinput" style="width:95px;" value="<%=bl_no%>" id="bl_no" /> </td>
						<th>Reference No. </th>
						<td><input name="bkg_ref_no" type="text" class="noinput" style="width:95px;" value="<%=bkg_ref_no%>" id="bkg_ref_no" /> </td>
						<th>Booking Date </th>
						<td><input name="bkg_date" type="text" class="noinput" style="width:80px;" value="<%=bkg_date%>" id="bkg_date" /> </td>
					</tr>
				</tbody>
			</table>
			<table class="grid2">
				<colgroup>
					<col width="85">
					<col width="115">
					<col width="80">
					<col width="100">
					<col width="90">
					<col width="100">
					<col width="85">
					<col width="*">
				</colgroup>
				<tbody>
					<tr>
					<th title="Place of Receipt">POR</th>
					<td><input name="por" type="text" class="noinput" style="width:110px;" value="<%=por%>" id="por" /> </td>
					<th title="Port of Loading">POL</th>
					<td><input name="pol" type="text" class="noinput" style="width:95px;" value="<%=pol%>" id="pol" /> </td>
					<th title="Port of Discharging">POD</th>
					<td><input name="pod" type="text" class="noinput" style="width:95px;" value="<%=pod%>" id="pod" /> </td>
					<th title="Place of Delivery">DEL</th>
					<td><input name="del" type="text" class="noinput" style="width:80px;" value="<%=del%>" id="del" /> </td>
					</tr>
				</tbody>
			</table>
			<table class="grid2">
				<colgroup>
					<col width="85">
					<col width="115">
					<col width="80">
					<col width="100">
					<col width="90">
					<col width="100">
					<col width="85">
					<col width="*">
				</colgroup>
				<tbody>
					<tr>
						<th>VVD 1 </th>
						<td><input name="vvd_01" type="text" class="noinput" style="width:110px;" value="<%=vvd_1%>" id="vvd_01" /> </td>
						<th>VVD 2 </th>
						<td><input name="vvd_02" type="text" class="noinput" style="width:95px;" value="<%=vvd_2%>" id="vvd_02" /> </td>
						<th>VVD 3 </th>
						<td><input name="vvd_03" type="text" class="noinput" style="width:95px;" value="<%=vvd_3%>" id="vvd_03" /> </td>
						<th>VVD 4 </th>
						<td><input name="vvd_04" type="text" class="noinput" style="width:80px;" value="<%=vvd_4%>" id="vvd_04" /> </td>
					</tr>
				</tbody>
			</table>

			<table class="grid2">
				<colgroup>
					<col width="85">
					<col width="115">
					<col width="80">
					<col width="100">
					<col width="90">
					<col width="100">
					<col width="85">
					<col width="*">
				</colgroup>
				<tbody>
					<tr>
						<th>R/D Term </th>
						<td><input name="text2227172222" type="text" class="noinput" style="width:110px;" value="<%=rd_term%>" id="text2227172222" /> </td>
						<th>CNTR T/S </th>
						<td><input name="cntr_ts" type="text" class="noinput" style="width:95px;" value="<%=cntr_ts%>" id="cntr_ts" /> </td>
						<th>Weight</th>
						<td><input name="weight" type="text" class="noinput" style="width:95px;" value="<%=weight%>" id="weight" /> </td>
						<th>Measure</th>
						<td><input name="measure" type="text" class="noinput" style="width:80px;" value="<%=measure%>" id="measure" /> </td>
					</tr>
				</tbody>
			</table>

			<table class="grid2">
				<colgroup>
					<col width="85">
					<col width="115">
					<col width="80">
					<col width="100">
					<col width="90">
					<col width="*">
				</colgroup>
				<tbody>
					<tr>
						<th>HOT Delivery </th>
						<td><input name="hot_delivery" type="text" class="noinput" style="width:110px;" value="<%=hot_delivery%>" id="hot_delivery" /> </td>
						<th>LCL</th>
						<td><input name="lcl" type="text" class="noinput" style="width:95px;" value="<%=lcl%>" id="lcl" /> </td>
						<th>Special Cargo </th>
						<td><input name="special_cargo" type="text" class="noinput" style="width:250px;" value="<%=special_cargo%>" id="special_cargo" /> </td>
					</tr>
				</tbody>
			</table>
			<table class="grid2">
				<colgroup>
					<col width="85">
					<col width="115">
					<col width="*">
				</colgroup>
				<tbody>
					<tr>
						<th>Commodity</th>
						<td><input name="commodity_cd" type="text" class="noinput" style="width:110px;" value="<%=commodity_nm%>" id="commodity_cd" /> </td>
						<td><input name="commodity_nm" type="text" class="noinput" style="width:500px;" value="<%=commodity_cd%>" id="commodity_nm" /> </td>
					</tr>
				</tbody>
			</table>

			<table class="grid2">
				<colgroup>
					<col width="85">
					<col width="115">
					<col width="*">
				</colgroup>
				<tbody>
					<tr>
						<th>Shipper</th>
						<td><input name="shipper_cd" type="text" class="noinput" style="width:110px;" value="<%=shipper_cd%>" id="shipper_cd" /> </td>
						<td><input name="shipper_nm type=" text"="" class="noinput" style="width:500px;" value="<%=shipper_nm%>" id="shipper_nm type=" /> </td>
					</tr>
				</tbody>
			</table>

			<table class="grid2">
				<colgroup>
					<col width="85">
					<col width="115">
					<col width="*">
				</colgroup>
				<tbody>
                  	<tr>
                  		<th>Consignee</th>
                  		<td><input name="consignee_cd" type="text" class="noinput" style="width:110px;" value="<%=consignee_cd%>" id="consignee_cd" /> </td>
                  		<td><input name="consignee_nm" type="text" class="noinput" style="width:500px;" value="<%=consignee_nm%>" id="consignee_nm" /> </td>
               		</tr>
               	</tbody>
             </table>

			<table class="grid2">
				<colgroup>
					<col width="85">
					<col width="115">
					<col width="*">
				</colgroup>
				<tbody>
					<tr>
						<th>Notify</th>
						<td><input name="notify_cd" type="text" class="noinput" style="width:110px;" value="<%=notify_cd%>" id="notify_cd" /> </td>
						<td><input name="notify_cd" type="text" class="noinput" style="width:500px;" value="<%=notify_nm%>" id="notify_cd" /> </td>
					</tr>
				</tbody>
			</table>

			<table class="grid2">
				<colgroup>
					<col width="85">
					<col width="115">
					<col width="80">
					<col width="100">
					<col width="90">
					<col width="100">
					<col width="85">
					<col width="*">
				</colgroup>
				<tbody>
					<tr>
						<th>Booking Office </th>
						<td><input name="bkg_office" type="text" class="noinput" style="width:110px;" value="<%=bkg_office%>" id="bkg_office" /> </td>
						<th>Booking Staff</th>
						<td><input name="bkg_staff" type="text" class="noinput" style="width:95px;" value="<%=bkg_staff%>" id="bkg_staff" /> </td>
						<th>Sales Office</th>
						<td><input name="sales_office" type="text" class="noinput" style="width:95px;" value="<%=sales_office%>" id="sales_office" /> </td>
						<th>Sales Staff</th>
						<td><input name="sales_staff" type="text" class="noinput" style="width:80px;" value="<%=sales_staff%>" id="sales_staff" /> </td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- opus_design_grid (E) -->
	</div>
	<!-- wrap_result(E) -->
