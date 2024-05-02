<%
/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ESD_SCE_0050.js
*@FileTitle : Rail Transit Report Summary
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 2013-05-02 Poong-yeon Cho
* 1.0 최초생성
=========================================================*/
%> 
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.event.EsdSce0045Event"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.common.util.basic.CodeUtilBC" %>
<%@ page import="com.hanjin.apps.alps.esd.sce.common.util.basic.CodeUtilBCImpl" %>

<%
		EsdSce0045Event  event        = null;                		
		Exception serverException     = null;            		

		String strErrMsg              = "";                              
		DBRowSet rowSet               = null;                        
		int rowCount                  = 0;                               
		SignOnUserAccount account     =(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    	String userId                 = account.getUsr_id();

    	try{
	    	serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
	    	if (serverException != null) {
	            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
	        }else{
	        	event = (EsdSce0045Event)request.getAttribute("Event");
	        }
		} catch(Exception e) {
	        out.println(e.toString());
	    }
%>

<html>
<head>
<title>Welcome to alps!</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            showErrMessage(errMessage);
        } // end if
        loadPage();
    }
</script>
</head>

<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="row_size">
<input type="hidden" name="fm_date" value="">
<input type="hidden" name="to_date" value="">

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
											<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
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
							<td width=120>
								<select name="date_kind" style="width:120;">
								<option value="" selected="selected"></option>
								<option value="S">S/O Creation DT.</option>
								<option value="A">DEST. Available DT.</option>
								<option value="O">DEST. Out-Gate DT.</option>
								<option value="I">Origin In-Gate DT.</option>
								<option value="D">Vessel Discharge DT.</option>
								<option value="P">Origin Departure</option>
								</select>
							</td>
							<td width='50'>&nbsp;&nbsp;W/M</td>
                            <td width='130'>
                                <div id='div_wm' style='display:inline;border:solid 0;'>
                                <input type='radio' value='W' name='f_chkprd' class='trans' onClick="javascript:chkWM('W');" checked>&nbsp;Week
                                <input type='radio' value='M' name='f_chkprd' class='trans' onClick="javascript:chkWM('M');">&nbsp;Month
                                </div>
                            </td>
                            <td width='240' class='sm'>
                                <div id='div_month' style='display:none;border:solid 0;width:230;height:16'>
                                Month&nbsp;(YYYYMM)&nbsp;
                                <input type='text' style='width:60;text-align:center;' class='input1' name='f_fm_mon' maxlength='6' style='ime-mode:disabled' onKeyPress="keyCheck(this);" onKeyUp="checkLength(this);" onBlur="if(this.value!=''){check_format(this);}" >&nbsp;&nbsp;~&nbsp;
                                <input type='text' style='width:60;text-align:center;' class='input1' name='f_to_mon' maxlength='6' style='ime-mode:disabled' onKeyPress="keyCheck(this);" onKeyUp="checkLength(this);" onBlur="if(this.value!=''){check_format(this);}" >
                                </div>
                                <div id='div_week' style='display:inline;border:solid 0;width:230;height:16'>
                                Week&nbsp;(YYYYWW)&nbsp;
                                <input type='text' style='width:60;text-align:center;' class='input1' name='f_fm_wk' maxlength='6' style='ime-mode:disabled' onKeyPress="keyCheck(this);" onKeyUp="checkLength(this);" onBlur="if(this.value!=''){check_format(this);}" >&nbsp;&nbsp;~&nbsp;
                                <input type='text' style='width:60;text-align:center;' class='input1' name='f_to_wk' maxlength='6' style='ime-mode:disabled' onKeyPress="keyCheck(this);" onKeyUp="checkLength(this);" onBlur="if(this.value!=''){check_format(this);}" >
                                </div>
                            </td>
                            <!-- <td class='sm' width='300' ><div id='div_period' ></div></td> -->
                            <td class='sm' width='150' ><div id='div_period' ></div></td>
                            <td width="60">S/C No.</td>
                            <td width="135"><input onKeyUp="ComChkObjValid(this)" onBlur="ComChkObjValid(this)" name="sc_no" type="text" class="input" dataformat="engup" style="width:95; text-transform:uppercase;"></td>
                        </tr>
					</table>
					<table class="search_in" border="0">
                        <tr class="h23">
                            <td width="150">&nbsp;</td>
                            <td width="80">Route&nbsp;<input type="checkbox" name="p_rout_1" onClick="checkRoute(this)"></td>
                            <td width="40">Origin</td>
                            <td width="120"><input disabled onKeyUp="ComChkObjValid(this)" onBlur="ComChkObjValid(this)" name="fm_nod_cd1" type="text" class="input" dataformat="engup" style="width:60; text-transform:uppercase;"> <img onClick="openNode('fm_nod_cd1')" class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
                            <td width="35">DEST</td>
                            <td width="120"><input disabled onKeyUp="ComChkObjValid(this)" onBlur="ComChkObjValid(this)" name="to_nod_cd1" type="text" class="input" dataformat="engup" style="width:60; text-transform:uppercase;"> <img onClick="openNode('to_nod_cd1')" class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
                            <td width="60">Full / MT</td>
                            <td width="100"><select disabled name="cgo_tp_cd1"  onChange="chgBound(this)" style="width:48;">
                            <option value="">ALL</option>
                            <option value="F" selected>Full</option>
                            <option value="M">MT</option>
                            </select></td>
                            <td width="45">Bound</td>
                            <td width=""><select disabled name="trsp_bnd_cd1" style="width:51;">
                            <option value="" selected>ALL</option>
                            <option value="I" selected>In</option>
                            <option value="O">Out</option>
                            </select></td>
                        </tr>
                    </table>
                    <table class="search_in" border="0">
                        <tr class="h23">
                            <td width="150">&nbsp;</td>
                            <td width="80">Route&nbsp;<input type="checkbox" name="p_rout_2" onClick="checkRoute(this)"></td>
                            <td width="40">Origin</td>
                            <td width="120"><input disabled onKeyUp="ComChkObjValid(this)" onBlur="ComChkObjValid(this)" name="fm_nod_cd2" type="text" class="input" dataformat="engup" style="width:60; text-transform:uppercase;"> <img onClick="openNode('fm_nod_cd2')" class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
                            <td width="35">DEST</td>
                            <td width="120"><input disabled onKeyUp="ComChkObjValid(this)" onBlur="ComChkObjValid(this)" name="to_nod_cd2" type="text" class="input" dataformat="engup" style="width:60; text-transform:uppercase;"> <img onClick="openNode('to_nod_cd2')" class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
                            <td width="60">Full / MT</td>
                            <td width="100"><select disabled name="cgo_tp_cd2"  onChange="chgBound(this)" style="width:48;">
                            <option value="">ALL</option>
                            <option value="F" selected>Full</option>
                            <option value="M">MT</option>
                            </select></td>
                            <td width="45">Bound</td>
                            <td width=""><select disabled name="trsp_bnd_cd2" style="width:51;">
                            <option value="" selected>ALL</option>
                            <option value="I" selected>In</option>
                            <option value="O">Out</option>
                            </select></td>
                        </tr>
                    </table>
                    <table class="search_in" border="0">
                        <tr class="h23">
                            <td width="150">&nbsp;</td>
                            <td width="80">Route&nbsp;<input type="checkbox" name="p_rout_3" onClick="checkRoute(this)"></td>
                            <td width="40">Origin</td>
                            <td width="120"><input disabled onKeyUp="ComChkObjValid(this)" onBlur="ComChkObjValid(this)" name="fm_nod_cd3" type="text" class="input" dataformat="engup" style="width:60; text-transform:uppercase;"> <img onClick="openNode('fm_nod_cd3')" class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
                            <td width="35">DEST</td>
                            <td width="120"><input disabled onKeyUp="ComChkObjValid(this)" onBlur="ComChkObjValid(this)" name="to_nod_cd3" type="text" class="input" dataformat="engup" style="width:60; text-transform:uppercase;"> <img onClick="openNode('to_nod_cd3')" class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
                            <td width="60">Full / MT</td>
                            <td width="100"><select disabled name="cgo_tp_cd3"  onChange="chgBound(this)" style="width:48;">
                            <option value="">ALL</option>
                            <option value="F" selected>Full</option>
                            <option value="M">MT</option>
                            </select></td>
                            <td width="45">Bound</td>
                            <td width=""><select disabled name="trsp_bnd_cd3" style="width:51;">
                            <option value="" selected>ALL</option>
                            <option value="I" selected>In</option>
                            <option value="O">Out</option>
                            </select></td>
                        </tr>
                    </table>
                    <table class="search_in" border="0">
                        <tr class="h23">
                            <td width="150">&nbsp;</td>
                            <td width="80">Route&nbsp;<input type="checkbox" name="p_rout_4" onClick="checkRoute(this)"></td>
                            <td width="40">Origin</td>
                            <td width="120"><input disabled onKeyUp="ComChkObjValid(this)" onBlur="ComChkObjValid(this)" name="fm_nod_cd4" type="text" class="input" dataformat="engup" style="width:60; text-transform:uppercase;"> <img onClick="openNode('fm_nod_cd4')" class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
                            <td width="35">DEST</td>
                            <td width="120"><input disabled onKeyUp="ComChkObjValid(this)" onBlur="ComChkObjValid(this)" name="to_nod_cd4" type="text" class="input" dataformat="engup" style="width:60; text-transform:uppercase;"> <img onClick="openNode('to_nod_cd4')" class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
                            <td width="60">Full / MT</td>
                            <td width="100"><select disabled name="cgo_tp_cd4"  onChange="chgBound(this)" style="width:48;">
                            <option value="">ALL</option>
                            <option value="F" selected>Full</option>
                            <option value="M">MT</option>
                            </select></td>
                            <td width="45">Bound</td>
                            <td width=""><select disabled name="trsp_bnd_cd4" style="width:51;">
                            <option value="" selected>ALL</option>
                            <option value="I" selected>In</option>
                            <option value="O">Out</option>
                            </select></td>
                        </tr>
                    </table>
                    <table class="search_in" border="0">
                        <tr class="h23">
                            <td width="150">&nbsp;</td>
                            <td width="80">Route&nbsp;<input type="checkbox" name="p_rout_5" onClick="checkRoute(this)"></td>
                            <td width="40">Origin</td>
                            <td width="120"><input disabled onKeyUp="ComChkObjValid(this)" onBlur="ComChkObjValid(this)" name="fm_nod_cd5" type="text" class="input" dataformat="engup" style="width:60; text-transform:uppercase;"> <img onClick="openNode('fm_nod_cd5')" class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
                            <td width="35">DEST</td>
                            <td width="120"><input disabled onKeyUp="ComChkObjValid(this)" onBlur="ComChkObjValid(this)" name="to_nod_cd5" type="text" class="input" dataformat="engup" style="width:60; text-transform:uppercase;"> <img onClick="openNode('to_nod_cd5')" class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
                            <td width="60">Full / MT</td>
                            <td width="100"><select disabled name="cgo_tp_cd5"  onChange="chgBound(this)" style="width:48;">
                            <option value="">ALL</option>
                            <option value="F" selected>Full</option>
                            <option value="M">MT</option>
                            </select></td>
                            <td width="45">Bound</td>
                            <td width=""><select disabled name="trsp_bnd_cd5" style="width:51;">
                            <option value="" selected>ALL</option>
                            <option value="I" selected>In</option>
                            <option value="O">Out</option>
                            </select></td>
                        </tr>
                    </table>
				</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->


		<table class="height_10"><tr><td></td></tr></table>


		<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
     	<table class="search" border="0">
			<tr>
				<td class="bg">
					<table class="height_10"><tr><td></td></tr></table>

					<!-- : ( grid ) (S) -->
                    <table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet1');</script>
                        </td></tr>
                    </table>
                    <table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet2');</script>
                        </td></tr>
                    </table>
                    <table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet3');</script>
                        </td></tr>
                    </table>
					<!-- : ( grid ) (E) -->
					<!-- : ( Button : Sub ) (S) -->
            <table width="100%" class="button">
            <tr><td class="btn2_bg">
                <table border="0" cellpadding="0" cellspacing="0">
                    <tr>
                        <!-- Repeat Pattern -->
                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn2_left"></td><td class="btn2" name="dbtn_excel" id="dbtn_excel">Down Excel</td>
                        <td class="btn2_right"></td></tr></table></td>
                        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn2_left"></td><td class="btn2" name="dbtn_detailInquiry" id="dbtn_detailInquiry">Detail Inquiry</td>
                        <td class="btn2_right"></td></tr></table></td>
                        <!-- Repeat Pattern -->
                    </tr></table>
            </td></tr>
        </table>
            <!-- : ( Button : Sub ) (E) -->
			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Tab BG Box ) (E) -->
		<!-- ####### TABLE '#D' ::: 'RIGHT' FRAME (END) ####### -->


	</td></tr>
</table>
</form>
<!-- TABLE '#B' : 'Left + Right Body' Table (E)nd -->
    </td></tr>
</table>
<!-- Outer Table (E)-->
</body>
</html>
  
