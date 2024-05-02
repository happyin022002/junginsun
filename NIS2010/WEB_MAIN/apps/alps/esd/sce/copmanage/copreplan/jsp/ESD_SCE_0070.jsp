<%
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_SCE_0070.jsp
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

<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.copmanage.copreplan.event.EsdSce0070Event"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.copmanage.copreplan.vo.ManualReplanInfoVO"%>
<%
	EsdSce0070Event			event			= null; //PDTO(Data Transfer Object including Parameters)
	//EsdSce0070EventResponse	eventResponse	= null;	//RDTO(Data Transfer Object including DB ResultSet)
	GeneralEventResponse     eventResponse	= null;
	Exception					serverException = null;	//
    DBRowSet					rowSet			= null; //DB ResultSet


	String strErrMsg	= "";
    int rowCount		= 0;



    String bkg_rcv_dt  = "";
    String cop_no = "";
    String bkg_no = "";
    String bkg_no_split = "";
    String cntr_no = "";
    String cntr_tpsz_cd = "";
    String cop_sts_cd = "";
    String office_cd = "";
    String sts = "";
    String route_pc = "";
    String route_cop = "";
    String route_so = "";
    String rmk= "";
    String bkg_rcv_no  = "";

    //추가 yjlee
    String sub_sts_cd = "";
    String pnd = "";
    String rpln_man = "";
    String rpln_cnfm = "";


    try {
        event = (EsdSce0070Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }else{

            //eventResponse = (EsdSce0070EventResponse)request.getAttribute("EventResponse");
            if (eventResponse != null) {
            	ManualReplanInfoVO vo = event.getManualReplanInfoVO();
                //rowSet = eventResponse.getRs();
                if(vo != null){
	 				bkg_rcv_no		= vo.getBkgRcvNo();
	 				bkg_rcv_dt  	= vo.getBkgRcvDt();
	 				cop_no  		= vo.getCopNo();
	 				bkg_no  		= vo.getBkgNo();
	 				cntr_no  		= vo.getCntrNo();
	 				cntr_tpsz_cd  	= vo.getCntrTpszCd();
	 				cop_sts_cd  	= vo.getCopStsCd();
	 				sub_sts_cd  	= vo.getSubStsCd();
	 				office_cd  		= vo.getOfficeCd();
	 				sts  			= vo.getSts();

	 				pnd  			= vo.getPnd();
	 				rpln_man  		= vo.getRplnMan();
	 				rpln_cnfm  		= vo.getRplnCnfm();

	 				route_pc  		= vo.getRoutePc();
	 				route_cop  		= vo.getRouteCop();
	 				route_so  		= vo.getRouteSo();
	 				rmk 			= vo.getRmk();
	 				
					//rowCount = rowSet.getRowCount();
					//rowSet. beforeFirst();
		 			//if (rowSet.next()) {
		 				/*
		 				bkg_rcv_no		= JSPUtil.getNull(rowSet.getString("bkg_rcv_no"));
		 				bkg_rcv_dt  	= JSPUtil.getNull(rowSet.getString("bkg_rcv_dt"));
		 				cop_no  		= JSPUtil.getNull(rowSet.getString("cop_no"));
		 				bkg_no  		= JSPUtil.getNull(rowSet.getString("bkg_no"));
		 				bkg_no_split  	= JSPUtil.getNull(rowSet.getString("bkg_no_split"));
		 				cntr_no  		= JSPUtil.getNull(rowSet.getString("cntr_no"));
		 				cntr_tpsz_cd  	= JSPUtil.getNull(rowSet.getString("cntr_tpsz_cd"));
		 				cop_sts_cd  	= JSPUtil.getNull(rowSet.getString("cop_sts_cd"));
		 				sub_sts_cd  	= JSPUtil.getNull(rowSet.getString("cop_sub_sts_cd"));
		 				office_cd  		= JSPUtil.getNull(rowSet.getString("office_cd"));
		 				sts  			= JSPUtil.getNull(rowSet.getString("sts"));

		 				pnd  			= JSPUtil.getNull(rowSet.getString("pnd"));
		 				rpln_man  		= JSPUtil.getNull(rowSet.getString("rpln_man"));
		 				rpln_cnfm  		= JSPUtil.getNull(rowSet.getString("rpln_cnfm"));

		 				route_pc  		= JSPUtil.getNull(rowSet.getString("route_pc"));
		 				route_cop  		= JSPUtil.getNull(rowSet.getString("route_cop"));
		 				route_so  		= JSPUtil.getNull(rowSet.getString("route_so"));
		 				rmk 			= JSPUtil.getNull(rowSet.getString("rmk"));
		 				*/
					//}

                } // end if

            } // end if

		} // end else
    }catch(Exception e) {
        out.println(e.toString());
    }

%>


<html>
<head>
<title>Welcome to NMS!</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">





</head>
<script language="javascript">
    function setupPage(){
        loadPage();
    }

</script>


<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="cop_no" value="<%=cop_no%>">
<input type="hidden" name="bkg_rcv_no" value="<%=bkg_rcv_no%>">
<input type="hidden" name="bkg_rcv_dt" value="<%=bkg_rcv_dt%>">


<!-- OUTER - POPUP (S)tart -->
<table width="800" class="popup" cellpadding="10">
<tr><td class="top"></td></tr>
<tr><td valign="top">



		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
			<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp;COP Manual Replan</td></tr>
		</table>
		<!-- : ( Title ) (E) -->

		<!-- TABLE '#D' : ( Search Options : BKG Information ) (S) -->
		<table class="search" width="755">
			<tr>
				<td class="bg">
					<table border="0" style="width:100%; background-color:white;" class="grid2">
						<tr class="tr2_head_l">
							<td width="60"  align="center">Date</td>
							<td width="115" align="center">COP No.</td>
							<td width="120" align="center">BKG No.</td>
							<td width="85"  align="center">Container No.</td>
							<td width="40"  align="center">TP/SZ</td>
							<td width="70"  align="center">COP Status</td>
							<td width="70"  align="center">SUB Status</td>
							<td width="50"  align="center">Office</td>
							<td width="55"  align="center">Status</td>
							<td width="50"  align="center">Pended</td>
							<td width="55"  align="center">replaned</td>
							<td width="75"  align="center">comfirmed</td>
						</tr>
							<!-- 
						<tr class="tr2_head_l">
							<td width="90" align="center">No</td>
							<td width="30" align="center">Split</td>
						</tr>
						-->
						<tr class="noinput">
							<td width=""><input name="text22271722" type="text" class="noinput" style="width:60"  value=<%=bkg_rcv_dt%>></td>
							<td width=""><input name="text22271722" type="text" class="noinput" style="width:115" value=<%=cop_no%>></td>
							<td width=""><input name="text22271722" type="text" class="noinput" style="width:120"  value=<%=bkg_no%>></td>
							<td width=""><input name="text22271722" type="text" class="noinput" style="width:85"  value=<%=cntr_no%>></td>
							<td width=""><input name="text22271722" type="text" class="noinput" style="width:40"  value=<%=cntr_tpsz_cd%>></td>
							<td width=""><input name="text22271722" type="text" class="noinput" style="width:70"  value=<%=cop_sts_cd%>></td>
							<td width=""><input name="text22271722" type="text" class="noinput" style="width:70"  value=<%=sub_sts_cd%>></td>
							<td width=""><input name="text22271722" type="text" class="noinput" style="width:50"  value=<%=office_cd%>></td>
							<td width=""><input name="text22271722" type="text" class="noinput" style="width:55"  value=<%=sts%>></td>
							<td width=""><input name="text22271722" type="text" class="noinput" style="width:50"  value=<%=pnd%>></td>
							<td width=""><input name="text22271722" type="text" class="noinput" style="width:55"  value=<%=rpln_man%>></td>
							<td width=""><input name="text22271722" type="text" class="noinput" style="width:75"  value=<%=rpln_cnfm%>></td>
						</tr>
				</table>

				<table class="height_10"><tr><td></td></tr></table>

				<table border="0" style="width:100%; background-color:white;" class="grid2">
				<tr>
					<td width="12%" class="tr_head">BKG Route</td>
					<td width="" class="noinput"><%=route_pc%></td>
				</tr>
				<tr>
					<td width="12%" class="tr_head">COP Route</td>
					<td width="" class="noinput"><%=route_cop%></td>
				</tr>
				<tr>
					<td width="12%" class="tr_head">S/O Route</td>
					<td width="" class="noinput"><%=route_so%></td>
				</tr>
				</table>

			<table class="height_10"><tr><td></td></tr></table>

			<table border="0" style="width:100%; background-color:white;" class="grid2">
				<tr>
					<td width="12%"class="tr_head">Remarks</td>
					<td width=""><textarea class="noinput"name= "rmk" style="width:100%;height:50;" ><%=rmk%></textarea></td>
				</tr>
			</table>

			</tr>
		</table>
		<!-- TABLE '#D' : ( Search Options : Speed ) (E) -->
</td>
</tr>
</table>
<!-- OUTER - POPUP (E)nd -->


<table class="height_10"><tr><td></td></tr></table>

<!-- : ( grid ) (S) -->
               <table width="100%" id="mainTable">
                   <tr><td>
                        <script language="javascript">ComSheetObject('sheet');</script>
                   </td></tr>
               </table>

<!-- : ( grid ) (E) -->
<!-- : ( Button : Sub ) (S) -->
<table width="100%" class="sbutton">
		<tr><td height="71" class="popup">

			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
	       		<tr><td class="btn3_bg">
			    <table border="0" cellpadding="0" cellspacing="0">
			    <tr>

					<!-- Repeat Pattern -->
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" name="btn_save" id="btn_save">Save</td><td class="btn1_right"></td></tr></table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" name="btn_close" id="btn_close">Close</td><td class="btn1_right"></td></tr></table></td>
					<!-- Repeat Pattern -->

				</tr>
			</table>

		</td></tr>
</table>
<!-- : ( Button : Sub ) (E) -->
</form>
</body>
</html>
