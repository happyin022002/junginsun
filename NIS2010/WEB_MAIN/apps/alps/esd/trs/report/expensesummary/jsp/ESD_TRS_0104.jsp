<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_0104.jsp
*@FileTitle : Expense Summary by Office
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.20
*@LastModifier : 금병주
*@LastVersion : 1.6
* 2009.01.08 한아영
* 1.0 최초 생성
*----------------------------------------------------------
* History
* 2009.02.27 조풍연 1.1 [N200901080024] 'Report(Expense Summary by Office) 메뉴 개발 요청 '
* 2009.04.14 조풍연 1.2 [R200904140001] 검색 조건 오류 수정(BKG_TERM 그룹핑)
* 2010.10.08 최 선     1.3 [CHM-201006411] S/O DOOR NODE 팝업창의 RETURN VALUE 오류 수정
* 2010.10.27 최 선     1.4 [CHM-201006612] Expense Summary 조회 항목 추가 개발 요청
* 2011.07.20 민정호 1.5 [CHM-201112196] Expense Summary Report에 Invoice 상태코드를 조회조건에 추가
* 2012.02.15 금병주 1.6 [CHM-201216258] [TRS] Expense Summary Excel Down 버튼 추가
* 2013.04.12 조인영 [CHM-201323766] Report Multiple select 조회 기능 추가
* 2013.08.22 조인영 [CHM-201326241] [TRS] Report data 개수 표시
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.trs.report.expensesummary.event.EsdTrs0104Event"%>

<%
  SignOnUserAccount account = null; //Session 정보
  EsdTrs0104Event  event = null;       //PDTO(Data Transfer Object including Parameters)
  Exception serverException   = null;     //서버에서 발생한 에러
  DBRowSet rowSet   = null;                //DB ResultSet
  String strErrMsg = "";                 //에러메세지
  int rowCount   = 0;                 //DB ResultSet 리스트의 건수
  String successFlag = "";
  String codeList  = "";
  String pageRows  = "100";

	String userId = "";
	String ofcId = "";

	String optionStr = "000020:ALL:ALL";

	try {
	  	  account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);

	      userId=account.getUsr_id();
	      ofcId=account.getOfc_cd();

      	event = (EsdTrs0104Event)request.getAttribute("Event");

     	  serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

    	  if (serverException != null) {
     		 	strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
   			}
  	}catch(Exception e) {
    	out.println(e.toString());
  	}
%>

<html>
<head>
<title>Expense Summary by Office</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
  function setupPage(){
    var errMessage = "";
    if (errMessage.length >= 1) {
      ComShowMessage(errMessage);
    } // end if
    loadPage();
  }
</script>
</head>



<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input  type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="old_ofc_cd" value="<%=ofcId%>">
<input type="hidden" name="hid_period" value="S">
<input type="hidden" name="hid_from_date" >
<input type="hidden" name="hid_to_date" >
<input type="hidden" name="hid_from_node">
<input type="hidden" name="hid_via_node">
<input type="hidden" name="hid_to_node">
<input type="hidden" name="hid_door_node">
<input type="hidden" name="hid_io_bnd">

<!-- xls 다운 구분용 flag 2012.02.15 kbj -->
<input type="hidden" name="hid_grid_flg">

<!-- RD에서 출력용 파라메터 필드-->
<input type="hidden" name="row_wo_ofc_cd">
<input type="hidden" name="row_inv_ofc_cd">
<input type="hidden" name="row_costmode">
<input type="hidden" name="row_transmode">
<input type="hidden" name="row_sotype">
<input type="hidden" name="row_sotype_nm">
<input type="hidden" name="row_bkg_term_cd">
<input type="hidden" name="row_bkg_term_nm">
<input type="hidden" name="row_fm_loc">
<input type="hidden" name="row_via_loc">
<input type="hidden" name="row_to_loc">
<input type="hidden" name="row_door_loc">
<input type="hidden" name="row_status_cd">
<input type="hidden" name="row_inv_curr">
<input type="hidden" name="cnt">

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>



		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->




		<!-- TABLE '#D' : ( Button : Main ) (S) -->
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
		       	<tr><td class="btn1_bg">

					<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<!-- Repeat Pattern -->
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td><td class="btn1"  id="btn_retrieve" name="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>

						<td class="btn1_line"></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td><td class="btn1"  id="btng_rtv_downxls" name="btng_rtv_downxls">Down Excel</td><td class="btn1_right"></td></tr></table>
						</td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td><td class="btn1"  id="btn_reset" name="btn_reset">Reset</td><td class="btn1_right"></td></tr></table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td><td class="btn1"  id="btn_minimize" name="btn_minimize">Minimize</td><td class="btn1_right"></td></tr></table></td>
						<!-- Repeat Pattern -->

					</tr></table>

				</td></tr>
			</table>
		<!-- TABLE '#D' : ( Button : Main ) (E) -->



<div id="showMin" style="display:inline">

		<!-- TABLE '#D' : ( Search Options ) (S) -->
		<table class="search">
			<tr><td class="bg">
				<!-- 검색조건 1행 Start--->
					<table class="search_in" border="0">
						<tr class="h23">
							<td width="82">Date</td>
							<td width="330">
								<table border="0" style="height:15;">
                 				<tr>
										<td width="112"><SELECT style = "width:110" name = "sel_period"  onChange='change_period();;'>
										<OPTION  value="S">S/O Creation</OPTION>
										<OPTION  value="W">W/O Creation</OPTION>
										<OPTION  value="I">Invoice Confirm</OPTION>
										<OPTION  value="G">G/L Date</OPTION>
										</SELECT></td>
										<td><input name="from_date" type="text" style="width:77;"  value=""  onFocus='fun_Focus_del(this)'  onBlur='BlurDate(this);addBar_from(this);' >&nbsp;~&nbsp;<input name="to_date" type="text" style="width:77;"  value=""     onFocus='fun_Focus_del(this)'  onBlur='BlurDate(this);addBar_to(this);'  ><img src="/hanjin/img/blank.gif" width="2" height="1" border="0"><img class="cursor" img src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"  name="btns_calendar"></td>
									</tr>
                				</table>
							</td>
							<td width="80">Office Code</td>
	                        <td>

								<table border="0" style="height:15; width:100%; background-color: #E9E9E9;">
	                            <tr><td class="sm" width="145" style="padding-left:4;">
	                        			<input name="radio_office"  type="radio" value="WO" class="trans" checked>Work Order
	                        			<input name="radio_office"  type="radio" value="IV" class="trans" >Invoice</td>
	                        		<td class="sm"><input name="input_office" type="text" style="width:70;" onkeyup="upper(this)" value="<%=ofcId%>"><img src="/hanjin/img/blank.gif" width="2" height="1" border="0"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_office">&nbsp;<input type="checkbox" name="chk_office" value="Y" class="trans" onClick="javascript:fun_chkOffice();">Incl. Sub OFC</td>
	                          	</tr>
	                          	</table>


	                        </td>
	                        <td width="46">Bound</td>
							<td width="75"><select name="io_bound" style="width:70;" >
							<option value="A" selected>ALL</option>
							<option value="I">IN</option>
							<option value="O">OUT</option>
							<option value="T">TS</option>
							<option value="P">IN+OUT</option>
							</select></td>
					   </tr>
					   <tr style="height:1;"><td></tr></td>
					  </table>
				 <!-- 검색조건 1행 end--->


				 <!-- 검색조건 2행 Start--->
					<table class="search_in" border="0">
						<tr class="h23">
							<td width="82">Cost Mode</td>
							<td width="183"><script language="javascript">ComComboObject('sel_costmode', 1, 160, 1)</script></td>
							<td width="72">Trans Mode</td>
							<td width="118"><script language="javascript">ComComboObject('sel_transmode', 1, 90, 1)</script></td>
							<td width="125">Service Order Type</td>
							<td width="164"><script language="javascript">ComComboObject('sel_sotype', 1, 130, 1)</script></td>
							<td width="138">Volume by Type/Size</td>
							<td class="sm" align="right">
								<table border="0" style="height:15;background-color: #E9E9E9; width:100%;">
									<tr>
										<td class="sm">
											<input type="radio" value="" class="trans" name="vol_size" Onclick='change_volume();' checked>Show<input type="radio" value="" class="trans" name="vol_size" Onclick='change_volume();' >Hide</td>
									</tr>
								</table>
							</td>
						</tr>
		  	  </table>
			    <!-- 검색조건 2행 end--->
			    <!-- 검색조건 3행 Start--->
					<table class="search_in" border="0" >
						<tr class="h23">
							<td width="32">From</td>
							<td width="52"><input name="search_fm_loc" type="text" style="width:48;" maxlength="5" onFocus='fun_Focus(this)' onChange="getComboList(this, document.form.search_fm_yard, 'F');" onBlur=""  ></td>
							<td width="74"><script language="javascript">ComComboObject('search_fm_yard', 1, 44, 0)</script><img src="/hanjin/img/blank.gif" width="2" hight="1"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_frmnode"></td>

							<td width="19">Via</td>
							<td width="52"><input name="search_via_loc" type="text" style="width:48;" maxlength="5" onFocus='fun_Focus(this)' onChange="getComboList(this, document.form.search_via_yard, 'V');" onBlur=""></td>
							<td width="76"><script language="javascript">ComComboObject('search_via_yard', 1, 44, 0)</script><img src="/hanjin/img/blank.gif" width="2" hight="1"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"  name="btns_vianode"></td>

							<td width="22">To</td>
							<td width="52"><input name="search_to_loc" type="text" style="width:48;" maxlength="5" onFocus='fun_Focus(this)' onChange="getComboList(this, document.form.search_to_yard, 'T');"  onBlur=""></td>
							<td width="76"><script language="javascript">ComComboObject('search_to_yard', 1, 47, 0)</script><img src="/hanjin/img/blank.gif" width="2" hight="1"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"  name="btns_tonode"></td>

							<td width="32">Door</td>
							<td width="52"><input name="search_door_loc" type="text" style="width:48;" maxlength="5" onFocus='fun_Focus(this)' onChange="getComboList(this, document.form.search_door_yard, 'D');"  onBlur=""></td>
							<td width="76"><script language="javascript">ComComboObject('search_door_yard', 1, 44, 0)</script><img src="/hanjin/img/blank.gif" width="2" hight="1"><img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"  name="btns_dorloc"></td>
							<td width="60">BKG Term</td>
							<td width="107"><select name="sel_bkgterm" style="width:95;">
								<option value="ALL" selected>ALL</option>
								<option value="Y">CY</option>
								<option value="D">Door</option>
								<option value="S">CFS</option>
								<option value="H">C'Haul on CY</option>
								<option value="T">Trackle</option>
								<option value="I">Free In</option>
								<option value="O">Free Out</option>
								<option value="M">Mixed</option>
								</select>
							</td>
							<td width="19">By</td>
							<td align="right">
								<table border="0" style="height:15;background-color: #E9E9E9; width:100%">
									<tr><td class="sm">
										<input type="radio" name="node_div" value="2"  class="trans"   Onclick="distance_col_control();"  checked>Country
										<input type="radio" name="node_div" value="5"  class="trans"   Onclick="distance_col_control();" >Location&nbsp;
										<input type="radio" name="node_div" value="7"  class="trans"   Onclick="distance_col_control();" >Yard&nbsp;
									</td></tr></table>
							</td>
						</tr>
		  	  		</table>						
					<table class="search_in" border="0" >						
						<tr class="h23">
							<td width="90">Invoice Status</td>
							<td width="150"><script language="javascript">ComComboObject('status_cd', 1, 130, 1)</script></td>
							<td width="40">ETS</td>
							<td>
								<table border="0">
									<tr>
										<td>
											<select name="ets_yn" style="width:95;">
												<option value="" selected>ALL</option>
												<option value="Y">Y</option>
												<option value="N">N</option>
											</select>
										</td>
									</tr>
								</table>
							</td>							
						</tr>						
		  	  		</table>
			    <!-- 검색조건 3행 end--->
			    </td>
		     </tr>
		  </table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->

		<table class="height_10"><tr><td></td></tr></table>
	</div>

		<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
		<table class="search" border="0">
			<tr>
				<td class="bg">
					<table class="height_10"><tr><td></td></tr></table>

					<!-- 'HEAD1-BGCOLOR : 203 240 169' , 'HEAD2-BGCOLOR : 222 251 248' , 'BORDER 1-outside : 88 152 164' ,'BORDER 2-inside : 202 226 233' , 'HEAD-FONT : 39 95 101' , 'SELETED ROW BG : 252 255 233' -->
					      <table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet1');</script>
                        </td></tr>
		            </table>
					<!-- : ( Grid ) (E) -->

							 <!-- 'HEAD1-BGCOLOR : 203 240 169' , 'HEAD2-BGCOLOR : 222 251 248' , 'BORDER 1-outside : 88 152 164' ,'BORDER 2-inside : 202 226 233' , 'HEAD-FONT : 39 95 101' , 'SELETED ROW BG : 252 255 233' -->
					      <table width="100%" border="0">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet2');</script>
                        </td></tr>
		            </table>
					<!-- : ( Grid ) (E) -->



				<!-- : ( Button : Grid ) (S) -->
				<table width="100%" class="button" BORDER="0">
			     <tr>
			     	<td class="title_s">
					* For more detailed information over additional column, please use "Down Excel" function on top-right side 
					</td>
			       	<td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<!-- Repeat Pattern -->
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2"  id="btng_downexcel" name="btng_downexcel">Down Excel</td><td class="btn2_right"></td></tr></table></td>
	
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td><td class="btn2"  id="btng_detailinquiry" name="btng_detailinquiry">Detail Inquiry</td><td class="btn2_right"></td></tr></table></td>
							<!-- Repeat Pattern -->
	
	
						</tr>
						</table>
					</td>
				</tr>
				</table>
					<!-- : ( Button : Grid ) (E) -->
			</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Tab BG Box ) (E) -->



</td></tr>
</table>
<!-- Outer Table (E)-->


</form>
</body>
</html>
