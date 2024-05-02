<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_SCG_0013.jsp
*@FileTitle : SPCL CGO Irregular Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.29
*@LastModifier : 김현욱
*@LastVersion : 1.0
* 2009.05.29 김현욱
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.scg.vesseloperationirregularmgt.specialcargoirregularmgt.event.VopScg0013Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopScg0013Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd        = "";
	Logger log = Logger.getLogger("com.hanjin.apps.VesselOperationIrregularMgt.SpecialCargoIrregularMgt");
	
	String vsl_cd           = "";
	String skd_voy_no       = "";
	String skd_dir_cd       = "";
	String spcl_cgo_irr_seq = "";
	String authYn           = "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

		event = (VopScg0013Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		vsl_cd           = StringUtil.xssFilter(request.getParameter("vsl_cd"))==null?"":StringUtil.xssFilter(request.getParameter("vsl_cd"));
		skd_voy_no       = StringUtil.xssFilter(request.getParameter("skd_voy_no"));
		skd_dir_cd       = StringUtil.xssFilter(request.getParameter("skd_dir_cd"));
		spcl_cgo_irr_seq = StringUtil.xssFilter(request.getParameter("spcl_cgo_irr_seq"));
		authYn           = StringUtil.xssFilter(request.getParameter("ofc_cd"))==null?"":StringUtil.xssFilter(request.getParameter("ofc_cd"));
		authYn           = authYn.equals(strOfc_cd)?"Y":"N";
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>SPCL CGO Irregular Creation</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	var userId = '<%=strUsr_id%>';
	var curDate = '<%=DateTime.getFormatDate(new java.util.Date(),"yyyy-MM-dd")%>';
	
	//초기조회조건
	var preConds = {
		vsl_cd            : "<%=vsl_cd%>",
		skd_voy_no        : "<%=skd_voy_no%>",
		skd_dir_cd        : "<%=skd_dir_cd%>",
		spcl_cgo_irr_seq  : "<%=spcl_cgo_irr_seq%>"
	}
	
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		
		var preCondition = new Array();
		
		preCondition[0] = ["vsl_cd","<%=vsl_cd%>"];    
		preCondition[1] = ["skd_voy_no","<%=skd_voy_no%>"]; 
		preCondition[2] = ["skd_dir_cd","<%=skd_dir_cd%>"]; 
		preCondition[3] = ["spcl_cgo_irr_seq","<%=spcl_cgo_irr_seq%>"];  
		
		if(preCondition[0][1] != '') {		
			
			//닫기버튼 보이기
			document.all.popLayer.style.display = "";
			
			//버튼 비활성화
			var authYn = "<%=authYn%>";
			if(authYn == 'N') {
				ComBtnDisable("btn_RowAdd");
				ComBtnDisable("btn_RowInsert");
				ComBtnDisable("btn_RowCopy");
				ComBtnDisable("btn_Delete");
				ComBtnDisable("btn_Delete2");
				ComBtnDisable("btn_Save");
			}
			
			//Set title of page
			var titleStr = "SPCL CGO Irregular Inquiry";
			if(authYn == 'Y') titleStr = "SPCL CGO Irregular Creation";
			try {
				var appName = navigator.appName;
			 	if (appName.indexOf("Netscape") == -1) {
			  		document.all.pophistory.innerHTML = "";
			  		document.all.title.innerHTML = '&nbsp; '+titleStr;
			  		document.title = titleStr;
			 	} else {
			  		document.getElementById("pophistory").innerHTML = "";
			  		document.getElementById("title").innerHTML = '&nbsp; '+titleStr;
			  		document.title = titleStr;
			 	}
			 	document.getElementById("mainTbl1").className   = "popup";
			 	document.getElementById("mainTbl2").cellPadding = "10";
			 	document.getElementById("topLine").className    = "top";
			}catch(err) {
			 	ComShowMessage(err);
			}
		}
		
		loadPage(preCondition);
	}
</script>
</head>

<body  onLoad="setupPage();">

<!-- 개발자 작업	-->
<table id="mainTbl1" width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
    <tr><td id="topLine"></td></tr>  
	<tr height="100%">
		<td valign="top" height="100%">
		
			<form name="form">
			<input type="hidden" name="f_cmd">
			
			<input type="hidden" name="set_vsl_cd">
			<input type="hidden" name="set_skd_voy_no">
			<input type="hidden" name="set_skd_dir_cd">
			<input type="hidden" name="set_irr_occr_dt">
			<input type="hidden" name="set_cgo_opr_cd">
			<input type="hidden" name="set_bkg_no">
			<input type="hidden" name="set_bkg_no_split">
			<input type="hidden" name="set_bl_no">
			<input type="hidden" name="set_cntr_no">
			
			<input type="hidden" name="set_spcl_cgo_cate_cd">
			
			<input type="hidden" name="spcl_cgo_irr_seq" value="">
			
			<input type="hidden" name="dcgo_flg">
			<input type="hidden" name="rc_flg">
			<input type="hidden" name="awk_cgo_flg">
			<input type="hidden" name="bb_cgo_flg">
			
			<input type="hidden" name="pagerows">
			
			<table id="mainTbl2" width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
				<tr height="100%">
					<td valign="top" height="100%">
						<!--top menu (S)-->
						<!--Page Title, Historical (S)-->
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
							<tr><td class="history" id="pophistory"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
							<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
						</table>
						<!--Page Title, Historical (E)-->
						<!--Button (S) -->
						<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
					       	<tr>
						       	<td class="btn1_bg">
								    <table border="0" cellpadding="0" cellspacing="0">
								    	<tr>
								    		<!-- 
								    		<td>
											    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn1_left"></td>
														<td class="btn1" name="btn_Retrieve">Retrieve</td>
														<td class="btn1_right"></td>
													</tr>
												</table>
											</td>
											-->
											<td>
												<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn1_left"></td>
														<td class="btn1" name="btn_New">New</td>
														<td class="btn1_right"></td>
													</tr>
												</table>
											</td>
											<td class="btn1_line"></td>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn1_left"></td>
														<td class="btn1" name="btn_Delete2">Delete</td>
														<td class="btn1_right"></td>
													</tr>
												</table>
											</td>
											<td>
												<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn1_left"></td>
														<td class="btn1" name="btn_Save">Save</td>
														<td class="btn1_right"></td>
													</tr>
												</table>
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
						<!--Button (E) -->
						<!--biz page (S)-->
						<table class="search"> 
			       			<tr>
			       				<td class="bg">
									<!--  biz_1  (S) -->				
									<table class="search" border="0" style="width:979;"> 
										<tr class="h23">
											<td width="50">&nbsp;VVD CD</td>
											<td width="320">&nbsp;<input name="vsl_cd" required fullfill type="text" style="width:40;" class="input1" value="" caption="Vessel Code" maxlength="4" dataformat="engup"  style="ime-mode:disabled">
															<input name="skd_voy_no" required fullfill type="text" style="width:40;" class="input1" value="" caption="Schedule Voyage Number" maxlength="4" dataformat="engup" style="ime-mode:disabled">
															<input name="skd_dir_cd" required fullfill type="text" style="width:20;" class="input1" value="" caption="Schedule Direction Code" maxlength="1" dataformat="engup" style="ime-mode:disabled">
															<img name="btn_VVDpop" class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">
															<input name="vsl_eng_nm" type="text" style="width:150;" class="input2" value="" readOnly></td>
											<td width="40">Lane</td>
											<td width="315">&nbsp;<input name="vsl_slan_cd" type="text" style="width:40;" class="input2" value="" readOnly>
															<input name="vsl_slan_nm" type="text" style="width:233;" class="input2" value="" readOnly></td>
											<td width="120">Irregular Occurred</td>
											<td width="">&nbsp;<input name="irr_occr_dt" required type="text" style="width:80;" class="input1" dataformat="ymd" caption="Irregular Occurred Date" maxlength="8" size="10" value="">&nbsp;<img name="btn_calendar" class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"></td>
										</tr>
									</table>
									<table class="search" border="0" style="width:979;"> 
										<tr class="h23">
											<td width="100">&nbsp;Vessel Operator</td>
											<td width="270">&nbsp;<input name="vsl_opr_tp_cd" required type="text" style="width:40;" class="input1" value="" caption="Vessel Operator" maxlength="4" dataformat="engup" style="ime-mode:disabled">
															<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" name='btn_vslopr' id='btn_vslopr' align="absmiddle">
															<input name="vsl_opr_tp_nm" type="text" style="width:168;" class="input2" value="" readonly="readonly"></td>
											<td width="100">Cargo Operator</td>
											<td width="">&nbsp;<input name="cgo_opr_cd" required type="text" style="width:40;" class="input1" value="" caption="Cargo Operator" maxlength="4" dataformat="engup" style="ime-mode: disabled">
														 <img name="btn_carrier" class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" maxlength="3">
														 <input name="cgo_opr_nm" type="text" style="width:150;" class="input2" value="" readonly="readonly"></td>
										</tr>
									</table>
							
									<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
							
									<table  class="search_sm2" border="0" style="width:330;" >
										<tr class="h23">
											<td width="60">Option</td>
											<td class="stm"><input name="spcl_cgo_cate_cd" type="radio" value="DG" class="trans">Dangerous Goods&nbsp;&nbsp;<input name="spcl_cgo_cate_cd" type="radio" value="AC" class="trans" >Awkward Cargo</td>
										</tr>
									</table>
									<table class="search" border="0" style="width:979;"> 
										<tr class="h23">
											<td width="60">&nbsp;Subject</td>
											<td width="">&nbsp;<input name="irr_subj_nm" type="text" style="width:625;" class="input" value="" caption="Subject" maxlength="500"></td>
										</tr>
									</table>
									<table class="search" border="0" style="width:979;"> 
										<tr class="h23">
											<td width="60">&nbsp;Place</td>
											<td width="140">
												<%=JSPUtil.getCodeCombo("spcl_cgo_irr_plc_cd", "S", "", "CD02118", 0, " ")%>
											</td>
											<td width="80">Place Details</td>
											<td width="">&nbsp;<input name="irr_plc_desc" type="text" style="width:405;" class="input" value="" caption="Place Details" maxlength="500"></td>
										</tr>
									</table>
									<table class="search" border="0" style="width:979;"> 
										<tr class="h23">
											<td width="100">&nbsp;Irregulars Type</td>
											<td width="620" colspan="2">&nbsp;
												<script language="javascript">ComComboObject('spcl_cgo_irr_tp_cd', 3, 400, 1, 1, 0, false);</script>
											</td>
											<td width="66">Update By</td>
											<td width="">&nbsp;<input name="upd_usr_id" type="text" style="width:90;text-align:center" class="input2" value="" readonly="readonly">
														 &nbsp;<input name="upd_dt" type="text" style="width:90;text-align:center" class="input2" value="" readonly="readonly"></td>
										</tr>
									</table>
							<!--  biz_1   (E) -->
			
								</td>
							</tr>
						</table>
						<table class="height_8"><tr><td></td></tr></table>			
					
						<!-- Grid BG Box  (S) -->
			     		<table class="search">
			       			<tr>
			       				<td class="bg">
									<!--  biz_2  (S) -->					
									<table class="search" border="0" style="width:979;"> 
										<tr class="h23">
											<td width="90">&nbsp;BKG Ref. No.</td>
											<td width="165">&nbsp;<input name="bkg_no" type="text" style="width:130;" class="input" value="" caption="BKG No." maxlength="13" dataformat="engup" style="ime-mode: disabled"></td>
											<td width="50">B/L No.</td>
											<td width="207">&nbsp;<input name="bl_no" type="text" style="width:120;" class="input" value="" caption="B/L No." maxlength="12" dataformat="engup" style="ime-mode: disabled"></td>
											<td width="36">POR</td>
											<td width="100">&nbsp;<input name="por_cd" type="text" style="width:50;" class="input2" value="" caption="POR" readonly="readonly" dataformat="engup" style="ime-mode: disabled"></td>
											<td width="25">POL</td>
											<td width="100">&nbsp;<input name="pol_cd" type="text" style="width:50;" class="input2" value="" caption="POL" readonly="readonly" dataformat="engup" style="ime-mode: disabled"></td>
											<td width="25">POD</td>
											<td width="100">&nbsp;<input name="pod_cd" type="text" style="width:50;" class="input2" value="" caption="POD" readonly="readonly" dataformat="engup" style="ime-mode: disabled"></td>
											<td width="25">Delivery</td>
											<td width="">&nbsp;<input name="del_cd" type="text" style="width:50;" class="input2" value="" caption="Delivery" readonly="readonly" dataformat="engup" style="ime-mode: disabled"></td>
										</tr>
									</table>
												
									<table class="search" border="0" style="width:979;"> 
										<tr class="h23">
											<td width="499" rowspan="3">&nbsp;</td>
											<td width="36">SHPR</td>
											<td width="">&nbsp;<input name="s_cust_nm" type="text" style="width:440;" class="input2" value="" caption="SHPR" readonly="readonly"></td>
										</tr>
										<tr class="h23">
											<td>FWDR</td>
											<td width="">&nbsp;<input name="f_cust_nm" type="text" style="width:440;" class="input2" value="" caption="FWDR" readonly="readonly"></td>
										</tr>
										<tr class="h23">
											<td>CNEE</td>
											<td width="">&nbsp;<input name="c_cust_nm" type="text" style="width:440;" class="input2" value="" caption="CNEE" readonly="readonly"></td>
										</tr>
									</table>
							
									<table class="height_8"><tr><td></td></tr></table>	
						
									<!-- Grid  (S) -->
									<table width="100%"  id="mainTable">
										<tr>
											<td width="100%">
												<script language="javascript">ComSheetObject('sheet1');</script>
											</td>
										</tr>
									</table>
									<!-- Grid (E) -->
									<!--  Button_Sub (S) -->
									<table width="100%" class="button"> 
							       		<tr>
							       			<td class="btn2_bg">
											<table border="0" cellpadding="0" cellspacing="0">
												<tr>
													<td>
														<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
															<tr>
																<td class="btn2_left"></td>
																<td class="btn2" name="btn_RowAdd">Row&nbsp;Add</td>
																<td class="btn2_right"></td>
															</tr>
														</table>
													</td>
													<td>
														<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
															<tr>
																<td class="btn2_left"></td>
																<td class="btn2" name="btn_RowInsert">Row&nbsp;Insert</td>
																<td class="btn2_right"></td>
															</tr>
														</table>
													</td>
													<td>
														<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
															<tr>
																<td class="btn2_left"></td>
																<td class="btn2" name="btn_RowCopy" id="btn_RowCopy">Row&nbsp;Copy</td>
																<td class="btn2_right"></td>
															</tr>
														</table>
													</td>
													<td>
														<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
															<tr>
																<td class="btn2_left"></td>
																<td class="btn2" name="btn_Delete">Row Delete</td>
																<td class="btn2_right"></td>
															</tr>
														</table>
													</td>
												</tr>
											</table>
										</td>
									</tr>
									</table>
					    			<!-- Button_Sub (E) -->
					    			
								</td>
							</tr>
						</table>
						<!-- Grid BG Box  (S) -->
						<table class="height_8"><tr><td></td></tr></table>	
					
						<!-- Grid BG Box  (S) -->
					    <table class="search">
					      	<tr>
					      		<td class="bg">
									<!--  biz_2  (S) -->			
									<table class="search" border="0">
										<tr>
											<td class="title_h"></td>
											<td class="title_s">Irregulars Summary</td></tr>
									</table>
									<table class="search" border="0">
										<tr>
											<td><textarea name="irr_smry_rmk" style="width:100%;" rows="5" caption="Irregulars Summary"></textarea></td>
										</tr>
									</table>
							
									<table class="height_8"><tr><td></td></tr></table>	
								
									<table class="search" border="0">
										<tr>
											<td class="title_h"></td>
											<td class="title_s">Reason</td>
										</tr>
									</table>
									<table class="search" border="0">
										<tr>
											<td><textarea name="irr_rsn_rmk" style="width:100%" rows="3" caption="Reason"></textarea></td>
										</tr>
									</table>
							
									<table class="height_8"><tr><td></td></tr></table>	
								
									<table class="search" border="0">
										<tr>
										<td class="title_h"></td>
											<td class="title_s">Countermeasure to prevent a recurrence </td></tr>
									</table>
									<table class="search" border="0">
										<tr>
											<td><textarea name="cmsr_desc" style="width:100%" rows="3" caption="Countermeasure to prevent a recurrence"></textarea></td>
										</tr>
									</table>
							
									<table class="height_8"><tr><td></td></tr></table>			
							
									<table class="search" border="0">
										<tr>
											<td class="title_h"></td>
											<td class="title_s" width="220">Supporting Documents or Pictures</td>
											<td width="30">&nbsp;<img name="btn_file" class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
											<td class="stm"><input name="file_cnt" type="text" style="width:40;" class="input2" value="0" caption="Supporting Documents or Pictures">&nbsp;(s)</td>
										</tr>
										<tr>
											<td class="height_5"></td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
						<!-- Grid BG Box  (S) -->
				
						<!--biz page (E)-->
					</td>
				</tr>
			</table>	
			<!--IBUpload Component (S) -->
			<script language="javascript">ComUploadObject('upload1', '<=session.getId()%>');</script>
			<!--IBUpload Component (E) -->
			<!--IBUpload Component (S) -->
			<script language="javascript">ComSheetObject('sheet2');</script>
			<!--IBUpload Component (E) -->	
			
			</form>			
		</td>
	</tr>
	<tr>
		<td valign="bottom">
			<div id="popLayer" style="display:none">
				<!-- : ( Button : pop ) (S) -->
				<table width="100%" class="sbutton">
					<tr>
						<td height="71" class="popup">	
							<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:0;"> 
				       			<tr>
				       				<td class="btn3_bg">
						    			<table border="0" cellpadding="0" cellspacing="0">
						    				<tr>
												<td>
													<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
														<tr>
															<td class="btn1_left"></td>
															<td class="btn1" name="btn_Close">Close</td>
															<td class="btn1_right"></td>
														</tr>
													</table>
												</td>
											</tr>
										</table>
				    					<!--Button (E) -->
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
				<!-- : ( Button : pop ) (E) -->
			</div>
		</td>
	</tr>
</table>
<!-- 개발자 작업  끝 -->

</body>
</html>