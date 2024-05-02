<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_PRD_0020.jsp
*@FileTitle : Product Catalog 생성결과 조회 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.12
*@LastModifier : 노승배
*@LastVersion : 1.0
* 2009.10.12 노승배
* 1.0 최초 생성
=========================================================*/ 
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.event.EsdPrd0080Event"%>
<%

	EsdPrd0080Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지

	try {
		event = (EsdPrd0080Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

	}catch(Exception e) {
		out.println(e.toString());
	}

	/*
	PrdCreateEvent  event = null;				//PDTO(Data Transfer Object including Parameters)
	ESD_PRD_0020EventResponse eventResponse = null;	//RDTO(Data Transfer Object including DB ResultSet)
	Exception serverException   = null;			//서버에서 발생한 에러
	DBRowSet rowSet	  = null;							   //DB ResultSet
	String strErrMsg = "";								 //에러메세지
	int rowCount	 = 0;								  //DB ResultSet 리스트의 건수


	try {

	   //SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   //userId=account.getUsr_id();
	   //userAuth=account.getAuth(); 
	   

		event = (ESD_PRD_0020Event)request.getAttribute("Event");

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}else{
			eventResponse = (ESD_PRD_0020EventResponse)request.getAttribute("EventResponse");
			if (eventResponse != null) {
				rowSet = eventResponse.getRs();
				if(rowSet != null){
					 rowCount = rowSet.getRowCount();
				} // end if
			} // end if
		} // end else
	}catch(Exception e) {
		out.println(e.toString());
	}
  */
%>
<%@include file="/apps/alps/esd/prd/common/prdcommon/jsp/ESD_PRD_AUTH.jsp"%>
<html>
<head>
<title>Product Catalog 생성결과 조회 화면</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if

		loadPage();
	}
</script>
<!-- script language="javascript">balloonHint("balloonHint")</script -->

</head>


<body onload="javascript:setupPage();">
<form method="post" name="form" action="">
<input type="hidden" name="f_cmd">
<input type="hidden" name="ld_dt">
<input type="hidden" name="iPage"> 
<input type="hidden" name="search_pctl_no">
<input type="hidden" name="por_n">
<input type="hidden" name="del_n">
<input type="hidden" name="rf_f">
<!-- OUTER FRAME : "to make sum of components' HEIGHTS 100%" (S)tart -->
<table width="100%" border="0" cellpadding="0" cellspacing="0">
<tr><td valign="top">

<!-- ################# PART 'A' ::: 'TOP' FRAME (START) ################## -->

<!-- ################# TABLE '#A' ::: 'TOP' FRAME (END) ################## -->

<!-- ################# TABLE '#B' ::: 'LEFT + RIGHT' FRAME (START) ################## -->
<!-- TABLE '#B' : 'Left + Right Body' Table (S)tart -->
<table width="100%" border="0" cellpadding="0" cellspacing="0">
<tr>
	<td class="bodyright">

        <!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr>
				<td class="history"><img src="/hanjin/img/icon_history_dot.gif"	align="absmiddle"><span id="navigation"></span></td>
			</tr>
			<tr>
				<td class="title"><img src="/hanjin/img/icon_title_dot.gif"	align="absmiddle"><span id="title"></span></td>
			</tr>
		</table>
        <!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) --> <!-- TABLE '#D' : ( Button : Main ) (S) -->

		<!-- ####### PART 'D' ::: 'RIGHT' FRAME (START) ####### -->

        <!-- TABLE '#D' : ( Button : Main ) (S) -->
        <table width="100%" class="button" style="padding-bottom:5px;">
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0"  class="button">
				<tr>
					<td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					<td class="btn1_left"></td>
					<td class="btn1" name="btn_new" id="btn_new">New</td>
					<td class="btn1_right"></td>
				</tr>
			</table>
		</td></tr>
		</table>
    	<!-- TABLE '#D' : ( Button : Main ) (E) -->



		<!-- TABLE '#D' : ( Search Options ) (S) -->
		<table class="search">
       	<tr>
			<td class="bg">
				<table class="search" border="0">
					<tr class="h23">
						<td width="11%">POR</td>
						<td width="20%"><input type="text" name="por" class="input1" required dataformat="engup" caption="POR" maxlength="5" style="width:50px" value="" tabIndex="1" >
						<!-- <input name="por_n" type="text" dataformat="engup" maxlength="2" style="width:20px" value="" tabIndex="2"> -->
							<input name="por_yd_cd" type="text" dataformat="engup" maxlength="2" style="width:20px" value="" tabIndex="2" >
							<img class="cursor" src="/hanjin/img/alps/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_por"></td>
						<td width="9%">POL</td>
						<td width="13%"><input name="pol" type="text" class="input1" required dataformat="engup" caption="POL" maxlength="5" style="width:50px" value="" tabIndex="2" >
							<img class="cursor" src="/hanjin/img/alps/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_pol"></td>
						<td width="8%">POD</td>
						<td width="13%"><input name="pod" type="text" dataformat="engup" maxlength="5" style="width:50px" value="" tabIndex="3" >
							<img class="cursor" src="/hanjin/img/alps/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_pod"></td>
						<td width="10%">DEL</td>
						<td><input name="del" type="text" class="input1" required dataformat="engup" caption="DEL" maxlength="5" style="width:50px" value="" tabIndex="4" >
						<!-- <input name="del_n" type="text" dataformat="engup" maxlength="2" style="width:20px" value="" tabIndex="5"> -->
							<input name="del_yd_cd" type="text" dataformat="engup" maxlength="2" style="width:20px" value="" tabIndex="5" >
							<img class="cursor" src="/hanjin/img/alps/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_del"></td>
					</tr>

					<tr class="h23">
						<td>R term</td>
						<td>
							<select name="rcv_t" class="input1" required style="width:50px" tabIndex="6" >
								<option value="D">D</option>
								<option value="Y" selected>Y</option>
							</select>
						</td>
						<td>D term</td>
						<td>
							<select name="del_t" class="input1" required style="width:50px"  tabIndex="7">
							<option value="D">D</option>
							<option value="Y" selected>Y</option>
							</select>
						</td>
						<td>TP/SZ</td>
						<td><input name="c_tpsz" type="text" class="input1" required caption="TP/SZ" dataformat="engup" maxlength="2" style="width:50px" tabIndex="8"></td>
						<td>Qty</td>
						<td><input name="c_qty" type="text" class="input1" required caption="Qty" dataformat="float" maxlength="3" style="width:73px" value=""  tabIndex="9" ></td>
					</tr>

					<tr class="h23">
						<!-- td>Sailing Due Date</td-->
						<td><select style="width:120;" class="input1" name="inquiryLevel">
									  <option value="L" selected>Sailing Due Date</option>
									  <option value="V" >VVD</option>
									  </select>&nbsp;</td>
						<td>
							<span id="skd_type_0" style="display:block">
							<input name="skd_date_fm" type="text" style="width:73px" dataformat="engup" maxlength="10" tabIndex="10" onKeyUp="chkField(this, 'date', false, null, null, '-')" onBlur="chkField(this, 'date', false, null, null, '-')"> <img class="cursor" src="/hanjin/img/alps/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_calendar">
							</span>
							<span id="skd_type_1" style="display:none">
							<input name="t_vvd" type="text" style="width:75px" dataformat="engup" maxlength="9" tabIndex="10" > <img class="cursor" src="/hanjin/img/alps/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_vvd">
							</span>
						</td>
						<td>BKG OFC</td>
						<td><input name="bkg_ofc" type="text" style="width:50px" dataformat="engup" maxlength="5" value="" tabIndex="11" ></td>
						<td>SLS OFC</td>
						<td><input name="sc_ofc" type="text" style="width:50px" dataformat="engup" maxlength="5" value=""  tabIndex="12" ></td>
						<td>Commodity</td>
						<td><input name="com" type="text" style="width:73px" dataformat="engup" maxlength="6" value="" tabIndex="13" >
						<img class="cursor" src="/hanjin/img/alps/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_com"></td>
					</tr>

					<!-- tr class="h23">
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>Pre Simulation</td>
						<td><input name="precmChk" type="checkbox" value="Y" unchecked /></td>
					</tr -->
				</table>
			</td>
       	</tr>
		</table>		
		<!-- TABLE '#D' : ( Search Options ) (E) -->

		<table class="height_10"><tr><td></td></tr></table>
        <table class="search" border="0">
	       	<tr><td class="bg_b1">


			<!-- Grid : Week (S) -->
			<!-- 'HEAD1-BGCOLOR : 192 235 163' , 'HEAD2-BGCOLOR : 231 250 249' , 'BORDER : 90 138 158' , 'HEAD1-FONT : 0 83 116' , 'DATA GRID BG (2 colors) : 255 255 255, 249 249 249 ' -->
			<table width="100%" id="mainTable">
				<tr><td>
				    <script type="text/javascript">ComSheetObject('sheet1');</script>
				</td></tr>
			</table>
			<!-- Grid : Week (E) -->
			
			</td>
       	</tr>
		</table>

		<table class="height_10"><tr><td></td></tr></table>

		<table class="search" border="0">
        	<tr>
        		<td class="bg_b1">

					<!-- Grid : Week (S) -->
        			<!-- 'HEAD1-BGCOLOR : 192 235 163' , 'HEAD2-BGCOLOR : 231 250 249' , 'BORDER : 90 138 158' , 'HEAD1-FONT : 0 83 116' , 'DATA GRID BG (2 colors) : 255 255 255, 249 249 249 ' -->
        			<table width="100%" id="mainTable">
					<tr><td>
					    <script type="text/javascript">ComSheetObject('sheet2');</script>
					</td></tr>
			        </table>

					<table width="100%" class="total" border="0" style="border-top:#a28792 1px solid">
						<tr>
							<td align="right">
								<table border="0">
									<tr class="h23">
										<td width=20>&nbsp;</td>
										<td>ETA(P/F)</td>
										<td width="110"><input type="text" name="init_eta" style="width:130px;text-align:right;" class="input2" readOnly></td>
										<td>ETA(Coastal)</td>
										<td width="150"><input type="text" name="vps_eta" style="width:130px;text-align:right;" class="input2" readOnly></td>
										<td>PORT ERD</td>
										<td width="150"><input type="text" name="erd" style="width:130px;text-align:right;" class="input2" readOnly></td>
									</tr>
									<tr class="h23">
										<td width=20>&nbsp;</td>
										<td>Rail ERD</td>
										<td width="150"><input type="text" name="rail_erd" style="width:130px;text-align:right;" class="input2" readOnly></td>
										<td>Rail LRD</td>
										<td width="150"><input type="text" name="rail_lrd" style="width:130px;text-align:right;" class="input2" readOnly></td>
										<td>PORT Cut Off</td>
										<td width="150"><input type="text" name="port_cct" style="width:130px;text-align:right;" class="input2" readOnly></td>
									 </tr>									 
								</table>				
							</td>
						 </tr>
					</table>			        
        			<!-- Grid : Week (E) -->
        			<!-- : ( Button : Sub ) (S) -->
				    <table width="100%" class="sbutton"> 
	       			<tr><td class="align">
	
			   		 	<table class="sbutton"> 
			    			<!--  tr><td class="bt"><img class="cursor" src="/hanjin/img/alps/button/btng_costdetail.gif" width="90" height="19" border="0"></td></tr-->
			    			<tr><td class="bt"><img class="cursor" src="/hanjin/img/alps/button/btng_costdetail.gif" width="90" height="19" border="0" name="btng_costdetail"></td></tr>
						</table>
	    
					</td></tr>
					</table>
	    			<!-- : ( Button : Sub ) (E) -->
        			</td>
        		</tr>
        	</table>
			<!-- ####### PART 'D' ::: 'RIGHT' FRAME (END) ####### -->


	</td>
</tr>
</table>
<!-- TABLE '#B' : 'Left + Right Body' Table (E)nd -->
<!-- ################# PART B ::: 'LEFT + RIGHT' FRAME (END) ################## -->

</td></tr>

</table>
<!-- OUTER FRAME : "to make sum of components' HEIGHTS 100%" (E)nd -->
</form>
</body>
</html>

