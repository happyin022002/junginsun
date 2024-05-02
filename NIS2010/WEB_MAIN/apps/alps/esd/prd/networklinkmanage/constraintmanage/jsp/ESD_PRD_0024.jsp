<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_PRD_024.jsp
*@FileTitle : Constraint Manage
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-16
*@LastModifier : kimyoungchul
*@LastVersion : 1.0
* 2006-10-16 kimyoungchul
* 1.0 최초 생성
* csr: N200903120250 20090428 [PRD] Network Constraint 기능보완
* 2011.10.31  이수진 [CHM-201113877-01] Constraint 기능상에 Update 이력 관리 
=========================================================*/
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.prd.networklinkmanage.constraintmanage.event.EsdPrd0024Event"%>

<%
	EsdPrd0024Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	
	Exception serverException   = null;			//서버에서 발생한 에러
	DBRowSet rowSet	  = null;							   //DB ResultSet
	String strErrMsg = "";								 //에러메세지
	int rowCount	 = 0;								  //DB ResultSet 리스트의 건수
	//String successFlag = "";
	//String codeList  = "";
	//String pageRows  = "100";
	//node inquery에서 넘어올때
	String nodeCd = JSPUtil.getNull(request.getParameter("node_cd"));
	String mode = JSPUtil.getNull(request.getParameter("mode"));
	
	String link_flg=JSPUtil.getNull(request.getParameter("link_flg"));
	String fromNd = JSPUtil.getNull(request.getParameter("fromNd"));
	String toNd = JSPUtil.getNull(request.getParameter("toNd"));
	
	SignOnUserAccount account = null;
	try {

	   account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   //userId=account.getUsr_id();
	   //userAuth=account.getAuth();
	//System.out.println(account.getOfc_cd());

		event = (EsdPrd0024Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		
	}catch(Exception e) {
		out.println(e.toString());
	}

%>
<%@include file="/apps/alps/esd/prd/common/prdcommon/jsp/ESD_PRD_AUTH.jsp"%>

<html>
<head>
<title>Welcome to enis!</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	<%= JSPUtil.getIBCodeCombo("trsp_mod_cd", "01", "CD00997", 0, "")%>
	<%= JSPUtil.getIBCodeCombo("cnst_cd", "01", "CD01386", 0, "")%>

	function setupPage(){
		link_flag = "<%= link_flg%>"  ;
		var errMessage = "<%=strErrMsg%>";
		
		nodeCd = "<%=nodeCd%>";
		mode = "<%=mode%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
<script language="javascript">
var CRUD = "<%=JSPUtil.getParameter(request, "CRUD", retCRUD)%>";
var OFC_CD = "<%=account.getOfc_cd()%>";
</script>
</head>


<body  onload="javascript:setupPage();">
<form method="post" name="form" >
<input	type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="vvd">
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
				<tr><td class="btn1_bg">

						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_new" id="btn_new">New</td><td class="btn1_right"></td></tr></table></td>
							<td class="btn1_line"></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_save" id="btn_save">Save</td><td class="btn1_right"></td></tr></table></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_loadexcel" id="btn_loadexcel">Load Excel</td><td class="btn1_right"></td></tr></table></td>
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
							<td>
								<table class="search" style="width:100%"  border="0">
									<tr class="h23">
										<td width="27">
											<input type="radio" name ="radioGubun" class="trans"  value="" onClick="changeSelection(0);" <%=(mode.equals("pop"))?"checked=true":"" %> >
										</td>
										<td width="100">Location/Node</td>
										<td width=""><input name="loc" type="text" maxlength="7" style="width:59"   value="<%=nodeCd%>" dataformat="engup" tabIndex="1">
											<img name="btn_node_cd" class="cursor" src="img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
										<td width="" colspan="2">
											ALL<input type="radio" class="trans" name="point_code" value="ALL" checked/>&nbsp;&nbsp;
											POR<input type="radio" class="trans" name="point_code" value="POR"/>&nbsp;&nbsp;
											POL<input type="radio" class="trans" name="point_code" value="POL"/>&nbsp;&nbsp;
											T/S<input type="radio" class="trans" name="point_code" value="TS"/>&nbsp;&nbsp;
											POD<input type="radio" class="trans" name="point_code" value="POD"/>&nbsp;&nbsp;
											DEL<input type="radio" class="trans" name="point_code" value="DEL"/>&nbsp;&nbsp;
										</td>
									</tr>
								</table>
							</td>
						</tr>
						<tr class="h23">
							<td>
								<table class="search" style="width:100%;"  border="0">
									<tr class="h23">
										<td width="27">
											<input type="radio" value="1" name ="radioGubun" class="trans" onClick="changeSelection(1);" <%=(!mode.equals("pop") && link_flg.equals("Y"))?"checked=true":"" %> >
										</td>
										<td width="100">Link</td>
										<td width="91"><input name="from_nd" type="text" maxlength="7"  style="width:59" value="<%=fromNd %>" dataformat="engup" tabIndex="2">
											<img name="btn_from_cd" class="cursor" src="img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
										<td>~&nbsp;<input name="to_nd" type="text" maxlength="7" style="width:59" value="<%=toNd %>"  dataformat="engup" tabIndex="3">
											<img name="btn_to_cd" class="cursor" src="img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
									</tr>
								</table>
							</td>
						</tr>
						<tr class="h23">
							<td>
								<table class="search" style="width:100%"  border="0">
									<tr class="h23">
										<td width="27">
											<input type="radio" class="trans" name ="radioGubun" value=""  onClick="changeSelection(2);" <%=(!mode.equals("pop") && !link_flg.equals("Y"))?"checked=true":"" %> >
										</td>
										<td width="100">Route</td>
										<td width="45">T.Lane</td>
										<td width="80"><input name="tlane" type="text" maxlength="3"  style="width:41"  dataformat="engup" tabIndex="4">
											<img name="btn_tnk_lane_cd" class="cursor" src="img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
										<td width="25">BD</td>
										<td width="70">
											<input type="hidden" name="dir_cd" value="<%=event.getConstraintVO().getDirCd()%>" >
											<select name="s_dir_cd" id="s_dir_cd" style="width:50" onChange="changeDirection()" tabIndex="5">
												<option value="0" selected>ALL</option>
												<option value="E">E</option>
												<option value="W">W</option>
												<option value="S">S</option>
												<option value="N">N</option>
											</select>
										</td>
										<td width="30">POL</td>
										<td width="100"><input name="pol" type="text" maxlength="7"  style="width:58"   dataformat="engup" tabIndex="6">
											<img name="btn_pol_port_cd" class="cursor" src="img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
										<td width="30">T/S</td>
										<td width="100"><input name="tsport" type="text" maxlength="7" style="width:58"  dataformat="engup" tabIndex="7">
											<img name="btn_ts_port_cd" class="cursor" src="img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
										<td width="30">POD</td>
										<td width="100"><input name="pod" type="text" maxlength="7"  style="width:58"  dataformat="engup" tabIndex="8">
											<img name="btn_pod_port_cd" class="cursor" src="img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
										<td width="30">DEL</td>
										<td width="100"><input name="del" type="text" maxlength="7"  style="width:58"  dataformat="engup" tabIndex="9">
											<img name="btn_del_port_cd" class="cursor" src="img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
										<td width="30">SVC</td>
										<td width="">
											<select name="svc"  style="width:50" tabIndex="10">
												<option value="A" >All</option>
												<option value="Y" >Y</option>
												<option value="N" >N</option>
											</select>
										</td>
									</tr>
								</table>
							</td>
						</tr>
						<tr><td colspan="9" class="line_bluedot" style="height:15;"></td></tr>
		                <tr>
							<td>
								<table class="bg" style="width:100%; height:20; border:0px solid #A3A4C7;" >
									<tr class="h23">
										<td width="170"><input type="checkbox"  name="general_opt_chk" value="Y" checked=true class="trans">Common Inquiry Option</td>
										<td width="25">Lane</td>
										<td width="70"><input name="vsl_slan_cd" type="text" maxlength="3" style="width:38"  dataformat="engup" tabIndex="11">
											<img name="btn_slan_cd" class="cursor" src="img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
										<td width="25">VVD</td>
										<td width="140">
											<input name="vsl_cd" type="text" maxlength="4" style="width:38"  dataformat="engup" tabIndex="12">
											<input name="skd_voy_no" type="text" maxlength="4" style="width:38"  dataformat="engup" tabIndex="13">
											<input name="skd_dir_cd" type="text" maxlength="1" style="width:18"  dataformat="engup" tabIndex="14">
											<img name="btn_vvd" class="cursor" src="img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle">
										</td>
										<td width="65">Commodity</td>
										<td width="260">
							  				<input name="cmdt_cd" type="text" maxlength="6" style="width:53"  dataformat="engup" tabIndex="15">
											<input name="cmdt_nm" type="text" maxlength="200" style="width:150"  dataformat="engup" tabIndex="16">
											<img name="btn_cmdt" class="cursor" src="img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle">
										</td>
										<td width=""></td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->

		<table class="height_10"><tr><td></td></tr></table>
		<div id="tabLayer" style="display:none">
		<!-- TABLE '#D' : ( Grid BG Box1 ) (S) -->
		<table class="search" border="0">
			<tr>
				<td height="148" class="bg">
					<table class="height_10"><tr><td></td></tr></table>

					<!-- Grid : Week (S) -->
					<!-- 'HEAD1-BGCOLOR : 192 235 163' , 'HEAD2-BGCOLOR : 231 250 249' , 'BORDER : 90 138 158' , 'HEAD1-FONT : 0 83 116' , 'DATA GRID BG (2 colors) : 255 255 255, 249 249 249 ' -->

					<table width="100%" id="mainTable">
						<tr><td>
                             <script language="javascript">ComSheetObject('sheet1');</script>
                        </td></tr>
					</table>

					<table class="search" border="0" style="width:100%"><tr><td>

					<table class="search" border="0" style="width:433;">
						<tr class="h23">
							<td>
							Creation staff should fill in the "remarks" with full detail.</td></tr></table>
							</td>
					<!-- Grid : Week (E) -->
					<!-- Button : Sub (S) -->


							<td><table width="300" class="button" border="0" align="right">
								<tr>
								<td class="btn2_bg">
									<table class="sbutton">
										<tr>
										<!-- Repeat Pattern -->
										<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn2_left"></td><td class="btn2" name="btng_rowadd" id="btng_rowadd">Row Add</td><td class="btn2_right"></td></tr></table></td>
										<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn2_left"></td><td class="btn2" name="btng_rowcopy" id="btng_rowcopy">Row Copy</td><td class="btn2_right"></td></tr></table></td>
										<!-- Repeat Pattern -->
										</tr>
									</table>
								</td>
								</tr>
							</table>
					</td></tr></table>
					<!-- Button : Sub (E) --></td>
			</tr>
		</table>
		</div>
		<!-- TABLE '#D' : ( Grid BG Box1 ) (E) -->


		<!-- TABLE '#D' : ( Grid BG Box2 ) (S) -->
		<div id="tabLayer" style="display:none">
		<table class="search" border="0">
			<tr>
				<td height="148" class="bg">
					<table class="height_10"><tr><td></td></tr></table>

					<!-- Grid : Week (S) -->
					<!-- 'HEAD1-BGCOLOR : 192 235 163' , 'HEAD2-BGCOLOR : 231 250 249' , 'BORDER : 90 138 158' , 'HEAD1-FONT : 0 83 116' , 'DATA GRID BG (2 colors) : 255 255 255, 249 249 249 ' -->

					<table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet2');</script>
                        </td></tr>
					</table>

					<table class="search" border="0" style="width:100%"><tr><td>

					<table class="search" border="0" style="width:433;">
						<tr class="h23">
							<td>
							Creation staff should fill in the "remarks" with full detail.</td></tr></table>
							</td>
					<!-- Grid : Week (E) -->
					<!-- Button : Sub (S) -->


							<td><table width="300" class="button" border="0" align="right">
								<tr>
								<td class="btn2_bg">
									<table class="sbutton">
										<tr>
										<!-- Repeat Pattern -->
										<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn2_left"></td><td class="btn2" name="btng_rowadd" id="btng_rowadd">Row Add</td><td class="btn2_right"></td></tr></table></td>
										<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn2_left"></td><td class="btn2" name="btng_rowcopy" id="btng_rowcopy">Row Copy</td><td class="btn2_right"></td></tr></table></td>
										<!-- Repeat Pattern -->
										</tr>
									</table>
								</td>
								</tr>
							</table>
					</td></tr></table>
					<!-- Button : Sub (E) --></td>
			</tr>
		</table>
		</div>
		<!-- TABLE '#D' : ( Grid BG Box2 ) (E) -->

		<!-- TABLE '#D' : ( Grid BG Box3 ) (S) -->
		<div id="tabLayer" style="display:inline">
		<table class="search" border="0">
			<tr>
				<td height="148" class="bg">
					<table class="height_10"><tr><td></td></tr></table>

					<!-- Grid : Week (S) -->
					<!-- 'HEAD1-BGCOLOR : 192 235 163' , 'HEAD2-BGCOLOR : 231 250 249' , 'BORDER : 90 138 158' , 'HEAD1-FONT : 0 83 116' , 'DATA GRID BG (2 colors) : 255 255 255, 249 249 249 ' -->

					<table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet3');</script>
                        </td></tr>
					</table>

					<table class="search" border="0" style="width:100%"><tr><td>

					<table class="search" border="0" style="width:433;">
						<tr class="h23">
							<td>
							Creation staff should fill in the "remarks" with full detail.</td></tr></table>
							</td>
					<!-- Grid : Week (E) -->
					<!-- Button : Sub (S) -->


							<td><table width="300" class="button" border="0" align="right">
								<tr>
								<td class="btn2_bg">
									<table class="sbutton">
										<tr>
										<!-- Repeat Pattern -->
										<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn2_left"></td><td class="btn2" name="btng_rowadd" id="btng_rowadd">Row Add</td><td class="btn2_right"></td></tr></table></td>
										<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn2_left"></td><td class="btn2" name="btng_rowcopy" id="btng_rowcopy">Row Copy</td><td class="btn2_right"></td></tr></table></td>
										<!-- Repeat Pattern -->
										</tr>
									</table>
								</td>
								</tr>
							</table>
					</td></tr></table>
					<!-- Button : Sub (E) --></td>
			</tr>
		</table>
		</div>
		</td>
		</tr>
		</table>
		<!-- TABLE '#D' : ( Grid BG Box3 ) (E) -->
<!-- Outer Table (E)-->
</form>
</body>
</html>
