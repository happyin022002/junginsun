<%
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_SCE_0915.jsp
*@FileTitle : BKG Info
*Open Issues :
*Change history :
*@LastModifyDate : 2006-09-13
*@LastModifier : Se-Hoon Park
*@LastVersion : 1.0
* 2006-09-13 Se-Hoon Park
* 1.0 최초 생성
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="java.util.List"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.copmanage.copsearch.event.EsdSce0915Event"%>
<%//@ page import="com.hanjin.apps.alps.esd.sce.copmanage.copsearch.event.EsdSce0915EventResponse"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.copmanage.copsearch.vo.BookingInfoVO"%>

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


<html>
<head>
<title>Bkg Info 데이터 조회</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

<body>
<!-- OUTER - POPUP (S)tart -->
<table width="810" class="popup" cellpadding="10">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
			<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp;BKG Information</td></tr>
		</table>
		<!-- : ( Title ) (E) -->

		<!-- TABLE '#D' : ( Search Options : BKG Information ) (S) -->
		<table class="search">
			<tr>
				<td class="bg">
					<table border="0" style="width:100%; background-color:white;" class="grid2">
						<tr>
							<td width="85" class="tr2_head_l">Booking No. </td>
							<td width="115" ><input name="bkg_no" type="text" class="noinput" style="width:110" value="<%=bkgNo%>"> <!-- <input name="bkg_no_split" type="text" class="noinput" style="width:20" value="<%=bkgNoSplit%>"> --></td>
							<td width="80" class="tr2_head_l">BL No. </td>
							<td width="100" ><input name="bl_no" type="text" class="noinput" style="width:95" value="<%=bl_no%>"></td>
							<td width="90" class="tr2_head_l">Reference No. </td>
							<td width="100" ><input name="bkg_ref_no" type="text" class="noinput" style="width:95" value="<%=bkg_ref_no%>"></td>
							<td width="85"  class="tr2_head_l">Booking Date </td>
							<td width=""><input name="bkg_date" type="text" class="noinput" style="width:80" value="<%=bkg_date%>"></td>
							</tr>
						</table>
					<table class="height_2">
						<tr>
							<td></td>
							</tr>
					</table>
					<table border="0" style="width:100%; background-color:white;" class="grid2">
						<tr>
							<td width="85" class="tr2_head_l">POR</td>
							<td width="115" ><input name="por" type="text" class="noinput" style="width:110" value="<%=por%>"></td>
							<td width="80" class="tr2_head_l">POL</td>
							<td width="100" ><input name="pol" type="text" class="noinput" style="width:95" value="<%=pol%>"></td>
							<td width="90" class="tr2_head_l">POD</td>
							<td width="100" ><input name="pod" type="text" class="noinput" style="width:95" value="<%=pod%>"></td>
							<td width="85"  class="tr2_head_l">DEL</td>
							<td width=""><input name="del" type="text" class="noinput" style="width:80" value="<%=del%>"></td>
							</tr>
					</table>
					<table class="height_2"><tr><td></td></tr></table>

					<table border="0" style="width:100%; background-color:white;" class="grid2">
						<tr>
							<td width="85" class="tr2_head_l">VVD 1 </td>
							<td width="115" ><input name="vvd_01" type="text" class="noinput" style="width:110" value="<%=vvd_1%>"></td>
							<td width="80" class="tr2_head_l">VVD 2 </td>
							<td width="100" ><input name="vvd_02" type="text" class="noinput" style="width:95" value="<%=vvd_2%>"></td>
							<td width="90" class="tr2_head_l">VVD 3 </td>
							<td width="100" ><input name="vvd_03" type="text" class="noinput" style="width:95" value="<%=vvd_3%>"></td>
							<td width="85"  class="tr2_head_l">VVD 4 </td>
							<td width=""><input name="vvd_04" type="text" class="noinput" style="width:80" value="<%=vvd_4%>"></td>
							</tr>
					</table>

					<table class="height_2"><tr><td></td></tr></table>

					<table border="0" style="width:100%; background-color:white;" class="grid2">
						<tr>
							<td width="85" class="tr2_head_l">R/D Term </td>
							<td width="115" ><input name="text2227172222" type="text" class="noinput" style="width:110" value="<%=rd_term%>"></td>
							<td width="80" class="tr2_head_l">CNTR T/S </td>
							<td width="100" ><input name="cntr_ts" type="text" class="noinput" style="width:95" value="<%=cntr_ts%>"></td>
							<td width="90" class="tr2_head_l">Weight</td>
							<td width="100" ><input name="weight" type="text" class="noinput" style="width:95" value="<%=weight%>"></td>
							<td width="85"  class="tr2_head_l">Measure</td>
							<td width=""><input name="measure" type="text" class="noinput" style="width:80" value="<%=measure%>"></td>
							</tr>
					</table>

					<table class="height_2"><tr><td></td></tr></table>

						<table border="0" style="width:100%; background-color:white;" class="grid2">
							<tr>
								<td width="85" class="tr2_head_l">HOT Delivery </td>
								<td width="115" ><input name="hot_delivery" type="text" class="noinput" style="width:110" value="<%=hot_delivery%>"></td>
								<td width="80" class="tr2_head_l">LCL</td>
								<td width="100" ><input name="lcl" type="text" class="noinput" style="width:95" value="<%=lcl%>"></td>
								<td width="90" class="tr2_head_l">Special Cargo </td>
								<td width="" ><input name="special_cargo" type="text" class="noinput" style="width:250" value="<%=special_cargo%>"></td>
							</tr>
						</table>
					<table class="height_2"><tr><td></td></tr></table>

					<table border="0" style="width:100%; background-color:white;" class="grid2">
						<tr>
							<td width="85" class="tr2_head_l">Commodity</td>
							<td width="115" ><input name="commodity_cd" type="text" class="noinput" style="width:110" value="<%=commodity_nm%>"></td>
							<td ><input name="commodity_nm" type="text" class="noinput" style="width:500" value="<%=commodity_cd%>"></td>
							</tr>
					</table>

					<table class="height_2"><tr><td></td></tr></table>

					<table border="0" style="width:100%; background-color:white;" class="grid2">
						<tr>
							<td width="85" class="tr2_head_l">Shipper</td>
							<td width="115" ><input name="shipper_cd" type="text" class="noinput" style="width:110" value="<%=shipper_cd%>"></td>
							<td ><input name="shipper_nm type="text" class="noinput" style="width:500" value="<%=shipper_nm%>"></td>
							</tr>
					</table>

					<table class="height_2">
						<tr>
							<td></td>
						</tr>
					</table>
					<table border="0" style="width:100%; background-color:white;" class="grid2">
                    	<tr>
                    		<td width="85" class="tr2_head_l">Consignee</td>
                    		<td width="115" ><input name="consignee_cd" type="text" class="noinput" style="width:110" value="<%=consignee_cd%>"></td>
                    		<td ><input name="consignee_nm" type="text" class="noinput" style="width:500" value="<%=consignee_nm%>"></td>
                    		</tr>
                    	</table>
					<table class="height_2"><tr><td></td></tr></table>

					<table border="0" style="width:100%; background-color:white;" class="grid2">
						<tr>
							<td width="85" class="tr2_head_l">Notify</td>
							<td width="115" ><input name="notify_cd" type="text" class="noinput" style="width:110" value="<%=notify_cd%>"></td>
							<td ><input name="notify_cd" type="text" class="noinput" style="width:500" value="<%=notify_nm%>"></td>
							</tr>
					</table>

					<table class="height_2"><tr><td></td></tr></table>


					<table border="0" style="width:100%; background-color:white;" class="grid2">
						<tr>
							<td width="85" class="tr2_head_l">Booking Office </td>
							<td width="115" ><input name="bkg_office" type="text" class="noinput" style="width:110" value="<%=bkg_office%>"></td>
							<td width="80" class="tr2_head_l">Booking Staff</td>
							<td width="100" ><input name="bkg_staff" type="text" class="noinput" style="width:95" value="<%=bkg_staff%>"></td>
							<td width="90" class="tr2_head_l">Sales Office</td>
							<td width="100" ><input name="sales_office" type="text" class="noinput" style="width:95" value="<%=sales_office%>"></td>
							<td width="85"  class="tr2_head_l">Sales Staff</td>
							<td width=""><input name="sales_staff" type="text" class="noinput" style="width:80" value="<%=sales_staff%>"></td>
						</tr>
					</table></td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Search Options : Speed ) (E) -->
</td>
</tr>
</table>
<!-- OUTER - POPUP (E)nd -->


<table class="height_10"><tr><td></td></tr></table>


<!-- : ( Button : Sub ) (S) -->
<table width="100%" class="sbutton">
		<tr><td height="71" class="popup">

			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
	       		<tr><td class="btn3_bg">
			    <table border="0" cellpadding="0" cellspacing="0">
			    <tr>

					<!-- Repeat Pattern -->
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" name="btn_close" id="btn_close">Close</td><td class="btn1_right"></td></tr></table></td>
					<!-- Repeat Pattern -->

				</tr>
			</table>

		</td></tr>
</table>
<!-- : ( Button : Sub ) (E) -->
</body>
</html>
