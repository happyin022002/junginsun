<%
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_SCE_0006.jsp
*@FileTitle : COP Detail Search
*Open Issues :
*Change history :
*@LastModifyDate : 2006-08-30
*@LastModifier : Seong-mun Kang
*@LastVersion : 1.0
* 2006-08-29 Seong-mun Kang
* 1.0 최초 생성
* 2009-06-15 [SCE]An Jeong-Seon [Project# S1L-09U-003] Rail Export Cargo Available Return Time 개발
* 2012-04-26 [CHM-201217462]
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.List"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.controller.html.FormCommand"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.copmanage.copsearch.event.EsdSce0006Event"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.copmanage.copsearch.vo.COPDetailVO"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.copmanage.copsearch.vo.SearchSceCopHdrInfoVO"%>

<%
	//RequestDataSetBC         dataSet         = null;
	EsdSce0006Event         event           = null;
	GeneralEventResponse eventResponse   = null;
	Exception                serverException = null;
	//DBRowSet                 rowSet          = null;
	String                   strErrMsg       = "";
	int                      rowCount         = 0;

    //SEARCHLIST
	List<SearchSceCopHdrInfoVO> bookingList = null;	
	String cop_no       = null ;
	String bkg_no       = null ;
	//String bkg_no_split = null ;
	String cntr_no      = null ;
	String cop_sts      = null ;
	String cntr_no_v    = "";
	String cop_mst_bkg	= null;
	String tpszCd		= "";
	String adm_flg 		= "";
	Map map = null;
	COPDetailVO inqVO = null;

	int    command      = -1 ;

	try {
		event   = (EsdSce0006Event)request.getAttribute("Event");
		command      = event.getFormCommand().getCommand() ;
		adm_flg = request.getParameter("adm_flg");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        } else {
			//eventResponse = (EsdSce0006EventResponse)request.getAttribute("EventResponse");
			eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
					
			bookingList  = (List<SearchSceCopHdrInfoVO>)eventResponse.getRsVoList();
			
			inqVO = event.getCOPDetailVO();
			if(inqVO != null){
				cop_no       = inqVO.getCopNo();
				bkg_no       = inqVO.getBkgNo();
				cntr_no      = inqVO.getCntrNo();
				cop_sts      = inqVO.getCopSts();
				cop_mst_bkg	 = inqVO.getCopMstBkg();				
			}
		
		/*
			if( eventResponse != null ) {
				rowSet = eventResponse.getRs();
				if(rowSet != null) {
					rowCount = rowSet.getRowCount();
				} // end if
			} // end if
			*/
		}
	} catch(Exception e) {
		out.println(e.toString());
    }
	
	cntr_no_v = cntr_no;
	if(cntr_no != null &&  !cntr_no.equals("") ) {
		if(cntr_no.substring(4).equals("0000000")){
			cntr_no_v = "";
		}
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
<%		if(cop_no != null && !cop_no.equals("")){ %>
			var formObject = document.form ;
			doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
	       	//doActionIBSheet(sheetObjects[1],formObject,IBSEARCH);
	       	doActionIBSheet(sheetObjects[1],formObject,IBSEARCH);
	       	doActionIBSheet(sheetObjects[2],formObject,IBSEARCH);
<%		} %>
    }

</script>

<body onLoad="setupPage();">

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>


		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
			</table>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->



		<!-- TABLE '#D' : ( Button : Main ) (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
		<form name="form" method="post">
		<input type="hidden" name="f_cmd">
		<input type='hidden' name='pgmNo' value='ESD_SCE_0006'>		
		<input type="hidden" name="cop_grp_seq">
		<input type="hidden" name="cop_dtl_seq">
		<input type="hidden" name="bkg_no" value="<%=bkg_no%>">
		<input type="hidden" name="cntr_no" value="<%=cntr_no_v%>">
		<input type="hidden" name="estm_act_dt">
		<input type="hidden" name="clickBtnNm">
		<input type="hidden" name="cop_sts_cd">
		<input type="hidden" name="cop_sub_sts_cd">				
		<input type="hidden" name="act_cd">	
		<input type="hidden" name="adm_flg" value="<%=adm_flg%>">
	
				<tr><td class="btn1_bg">

						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<!-- Repeat Pattern -->
<%
	if("Y".equals(adm_flg)) {//* 2012-12-05 [CHM-201433023]
%>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_so_cnddt_creation" id="btn_so_cnddt_creation" alt="test">S/O Candidate Creation</td><td class="btn1_right"></td></tr></table></td>
<% } %>								
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_new" id="btn_new">New</td><td class="btn1_right"></td></tr></table></td>
							<td class="btn1_line"></td>
<%
	if("Y".equals(adm_flg)) {//* 2012-04-26 [CHM-201217462]
%>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_copchange" id="btn_copchange">COP Change</td><td class="btn1_right"></td></tr></table></td>
<% } %>								
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_bkginfo" id="btn_bkginfo">BKG Info</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_history" id="btn_history">COP History</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="t1btng_save" id="t1btng_save">Save</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_clm" id="btn_clm">CLM</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_downexcel" id="btn_downexcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>
							<!-- Repeat Pattern -->

						</tr></table>

				</td></tr>
		</table>
		<!-- TABLE '#D' : ( Button : Main ) (E) -->
		<!-- TABLE '#D' : ( Search Options ) (S) -->
		<table class="search">
			<tr>
				<td class="bg">
					<table class="search_in" border="0">
						<tr class="h23">
							<td width="100"><img class="nostar">Container No. </td>
							<!-- <td width=""><input class="input1" name="cntr_no_v" type="text" style="width:100; text-transform:uppercase;" value="<%=JSPUtil.getNull(cntr_no_v)%>" maxlength="11" onKeyUp="this.value=this.value.toUpperCase();" onBlur='javascript:this.value=this.value.toUpperCase();'   ></td> -->
							<td width="110"><input class="input1" name="cntr_no_v" type="text" style="width:100; text-transform:uppercase;" value="<%=JSPUtil.getNull(cntr_no_v)%>" onChange="CheckDigit(this);keyAction();this.value=ComGetMaskedValue(this, 'engup', '');" Onkeydown="onEnterKey(this)" ></td>							
							<td width="80">Booking No. </td>
							<td width="130"><script language="javascript">ComComboObject("bkg_no_tmp", 1,120, 0, 0, 0, false);</script></td>
							<td width="55">COP No.</td>
							<td width="120"><input name="cop_no" type="text" value="<%=JSPUtil.getNull(cop_no)%>" style="width:110px" readOnly></td>
							<td width="160"><input type="checkbox" name="chk_inland_plan" value="" class="trans" onClick="javascript:fun_chkInlandPlan();">Inland Planned Date</td>
							<td width="80">COP Status</td>
							<td width="75"><input name="cop_sts" type="text" value="" style="width:60px" readOnly></td>
							<td width="55">Master </td>
							<td><input name="cop_mst_bkg" type="text" value="<%=cop_mst_bkg %>" style="width:15px" readOnly></td>
							<!-- <td width="13%"><input name="cop_sts" type="text" value="" style="width:80" readOnly></td>-->
							<input type="hidden" name="cntr_tpsz_cd" value="<%=tpszCd%>">
						</tr>
					</table></td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->

		<table class="height_10"><tr><td></td></tr></table>

		<!-- TABLE '#D' : ( Search Options : Total Transit Time  ) (S) -->
		<table class="search">
			<tr>
				<td class="bg">

					<table>
						<tr>
							<td width="300" valign="top">
								<table border="0" class="search">
									<tr>
										<td class="title_h"></td>
										<td class="title_s"> &nbsp;Delivery Time Info. </td>
									</tr>
									<tr><td class="height_5"></td></tr>
								</table>
								<table style="width:400" background-color:white;" class="grid2">
									<tr>
										<td width="" class="tr2_head">Delivery Due Date </td>
										<td width="" class="tr2_head">O/B Door Arrival </td>
										<td width="" class="tr2_head">I/B Door Arrival </td>
										<td width="" class="tr2_head">Planned</td>
										<td width="" class="tr2_head">Estimated</td>
									</tr>
									<tr>
										<td width=""><input name="de_due_dt" type="text" class="noinput" style="width:110;text-align:center;" readOnly></td>
										<td width=""><input name="ob_dor_arr_dt" type="text" class="noinput" style="width:110;text-align:center;" readOnly></td>
										<td width=""><input name="apnt_dt" type="text" class="noinput" style="width:110;text-align:center;" readOnly></td>
										<td width=""><input name="dlv_pln_date" type="text" class="noinput" style="width:110;text-align:center;" readOnly></td>
										<td width=""><input name="dlv_estm_date" type="text" class="noinput" style="width:110;text-align:center;" readOnly></td>
									</tr>
								</table>
							</td>
							<td width="" valign="top">
								<table class="search" border="0">
									<tr>
										<td class="title_h"></td>
										<td class="title_s">&nbsp;Total Transit Time Info.</td>
									</tr>
									<tr><td class="height_5"></td></tr></table>

								<table border="0"" style="width:200" class="grid2" background-color:white;>
									<tr>
										<td width="" class="tr2_head">Planned</td>
										<td width="" class="tr2_head">Estimated/Actual</td>
									</tr>
									<tr>
										<td width=""><input name="tot_trans_pln_date" type="text" class="noinput" style="width:100;text-align:center;" readOnly></td>
										<td width=""><input name="tot_trans_estm_date" type="text" class="noinput" style="width:100;text-align:center;" readOnly></td>
									</tr>
								</table>
							</td>

							<td width="" valign="top">
								<table class="search" border="0">
									<tr>
										<td class="title_h"></td>
										<td class="title_s">&nbsp;Rail Available Return Info.</td>
									</tr>
									<tr><td class="height_5"></td></tr></table>

								<table border="0"" style="width:180" class="grid2" background-color:white;>
									<tr>
										<td width="" class="tr2_head">Rail Receiving date </td>
									</tr>
									<tr>
										<td width=""><input name="rail_rcv_coff_fm_dt" type="text"  class="noinput" style="width:180;text-align:center;" readOnly></td>
									</tr>
								</table>
							</td>

						</tr>
					</table>
				</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Search Options : Speed ) (E) -->





		<table class="height_10"><tr><td></td></tr></table>

		<!-- TABLE '#D' : ( Tab ) (S) -->
		<table class="tab">
       	                <tr><td><script language="javascript">ComTabObject('tab1' )</script>
			<!--tr>
				<td><img src="/hanjin/img/enis/sub_tab.gif" alt="" width="755" height="23" border="0"--></td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Tab ) (E) -->

		<div id="tabLayer" style="display:inline">

		<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
		<table class="search" border="0">
			<tr>
				<td class="bg">
					<table class="height_10"><tr><td></td></tr></table>

					<!-- TABLE '#D' : ( Grid ) (S) -->
					<!-- 'HEAD1-BGCOLOR : 192 235 163' , 'HEAD2-BGCOLOR : 231 250 249' , 'BORDER : 90 138 158' , 'HEAD1-FONT : 0 83 116' , 'DATA GRID BG (2 colors) : 255 255 255, 249 249 249 ' -->
					<table width="100%" id="mainTable">
					<tr><td>
					   <script language="javascript">ComSheetObject('t1sheet1');</script>
					</td></tr>
					</table>
					<!-- TABLE '#D' : ( Grid ) (E) -->
					<!-- : ( Button : Grid ) (S) -->
                    <table style="width:737" class="sbutton">
                    	<tr>
                    		<td class="align">
                    			<table class="sbutton">
                    				<tr>
                    				    <!-- <td class="bt"><img class="cursor" src="/hanjin/img/enis/button/btng_save.gif" width="65" height="19" border="0" name="t1btng_save"></td>-->
                    					<!--td class="bt"><img class="cursor" src="/hanjin/img/enis/button/btng_rowadd.gif" width="65" height="19" border="0" name="t1btng_rowadd"></td>
                    					<td class="bt"><img class="cursor" src="/hanjin/img/enis/button/btng_downexcel.gif" width="81" height="19" border="0" name="t1btng_downexcel"></td-->
                    					</tr>
                    				</table></td>
                    		</tr>
                    	</table>
                    <!-- : ( Button : Grid ) (E) --></td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Tab BG Box ) (E) -->
        </div>

		<!-- 
		    2010-03-26 documentation tab 주석처리
		<div id="tabLayer" style="display:none">
		-->
		<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
		<!--		
		<table class="search" border="0">
			<tr>
				<td class="bg">
					<table class="height_10"><tr><td></td></tr></table>
		-->
					<!-- TABLE '#D' : ( Grid ) (S) -->
					<!-- 'HEAD1-BGCOLOR : 192 235 163' , 'HEAD2-BGCOLOR : 231 250 249' , 'BORDER : 90 138 158' , 'HEAD1-FONT : 0 83 116' , 'DATA GRID BG (2 colors) : 255 255 255, 249 249 249 ' -->
		<!--					
					<table width="100%" id="mainTable">
					<tr><td>
					   <script language="javascript">//ComSheetObject('t2sheet1');</script>
					</td></tr>
					</table>
		-->					
					<!-- TABLE '#D' : ( Grid ) (E) -->
		<!--
					</td>
					
			</tr>
		</table>
		-->		
		<!-- TABLE '#D' : ( Tab BG Box ) (E) -->
		<!--
		</div>
		-->
		
		<div id="tabLayer" style="display:none">
		<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
		<table class="search" border="0">
			<tr>
				<td class="bg">
					<table class="height_10"><tr><td></td></tr></table>

					<!-- TABLE '#D' : ( Grid ) (S) -->
					<!-- 'HEAD1-BGCOLOR : 192 235 163' , 'HEAD2-BGCOLOR : 231 250 249' , 'BORDER : 90 138 158' , 'HEAD1-FONT : 0 83 116' , 'DATA GRID BG (2 colors) : 255 255 255, 249 249 249 ' -->
					<table width="100%" id="mainTable">
					<tr><td>
					   <script language="javascript">ComSheetObject('t3sheet1');</script>
					</td></tr>
					</table>
					<!-- TABLE '#D' : ( Grid ) (E) -->
				</td>
			</tr>
		</form>			
		</table>
		<!-- TABLE '#D' : ( Tab BG Box ) (E) -->
		</div>

		<div id="tabLayer" style="display:none">
		<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
		<table class="search" border="0">
			<tr>
				<td class="bg">
					<table class="height_10"><tr><td></td></tr></table>

					<!-- TABLE '#D' : ( Grid ) (S) -->
					<!-- 'HEAD1-BGCOLOR : 192 235 163' , 'HEAD2-BGCOLOR : 231 250 249' , 'BORDER : 90 138 158' , 'HEAD1-FONT : 0 83 116' , 'DATA GRID BG (2 colors) : 255 255 255, 249 249 249 ' -->
					<table width="100%" id="mainTable">
					<tr><td>
					   <script language="javascript">ComSheetObject('t4sheet1');</script>
					</td></tr>
					</table>
					<!-- TABLE '#D' : ( Grid ) (E) -->
				</td>
			</tr>
		</form>
		<span id="new_form"></span>
		</table>
		<!-- TABLE '#D' : ( Tab BG Box ) (E) -->
		</div>
		


<table class="height_10"><tr><td></td></tr></table>

    </td></tr>
</table>
<!-- Outer Table (E)-->


</body>
</html>

