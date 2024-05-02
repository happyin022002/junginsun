<%--=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESD_PRD_0054.jsp
*@FileTitle : Inland Route Multi Creation 정보관리화면
*Open Issues :
*Change history :
*@LastModifyDate : 2010-02-10
*@LastModifier : noh seung bae
*@LastVersion : 1.0
* 2010-02-10 noh seung bae
* 1.0 최초 생성
* 새로 변경된 프레웍및 디자인적용
*
=========================================================--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandmulticreation.event.EsdPrd0054Event"%>
<%
	EsdPrd0054Event  event = null;                //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;            //서버에서 발생한 에러
    String strErrMsg = "";                                 //에러메세지
    String selInvCodeNoSort ="";
    String selPlanCodeNoSort = "";
    String selWRSFullCode = "";
    String selWRSEmptyCode = "";
    String optStr = "000010::";

    try {
        event = (EsdPrd0054Event)request.getAttribute("Event");
 		
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        selInvCodeNoSort = JSPUtil.getCodeCombo("i_inv", "01", "width='144' onChange='setCombindMode();'", "CD00126", 0, optStr);
        selPlanCodeNoSort = JSPUtil.getCodeCombo("i_rout_pln_cd", "01", "width='140'", "CD00127", 0, optStr);
        selWRSFullCode = JSPUtil.getCodeCombo("i_wrs_fl_cd", "01", "width='140'", "CD00862", 0, optStr);
        selWRSEmptyCode = JSPUtil.getCodeCombo("i_wrs_mt_cd", "01", "width='140'", "CD00863", 0, optStr);
       
    }catch(Exception e) {
        out.println(e.toString());
    }
%>
<html>
<head>
<title>Inland Route 정보관리화면</title>

<script type="text/javascript">
	<%= JSPUtil.getIBCodeCombo("inlnd_rout_inv_bil_patt_cd", "01", "CD00126", 0, optStr)%>
	<%= JSPUtil.getIBCodeCombo("rout_pln_cd", "01", "CD00127", 0, optStr)%>
	<%= JSPUtil.getIBCodeCombo("trsp_mod_cd", "01", "CD00997", 0, "")%>
	<%= JSPUtil.getIBCodeCombo("rail_crr_tp_cd", "01", "CD00287", 0, "|000010: : ")%>
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        }
        loadPage();
    }
</script>

</head>


<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<!-- if(!checkMandatory() ) return; // 여기서 실제 서버로 보낼 HIDDEN(조회 조건 인 from , to)의 i_ord_cd,i_dest_cd 를 셋팅한다.동적으로 inputbox를 변경하지않고 바로 가져감   -->


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
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5px;">
				<tr><td class="btn1_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<!-- Repeat Pattern -->
							<td class="btn1_left"></td><td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td><td class="btn1_right"></td>
							<td class="btn1_left"></td><td class="btn1" name="btn_new" id="btn_new">New</td><td class="btn1_right"></td>
							<td class="btn1_line"></td>
							<td class="btn1_left"></td><td class="btn1" name="btn_save" id="btn_save">Save</td><td class="btn1_right"></td>
							<td class="btn1_left"></td><td class="btn1" name="btn_loadexcel" id="btn_loadexcel">Load Excel</td><td class="btn1_right"></td>
							<td class="btn1_left"></td><td class="btn1" name="btn_downexcel" id="btn_downexcel">Down Excel</td><td class="btn1_right"></td>
							<!-- Repeat Pattern -->

						</tr></table>
				</td></tr>
		</table>
		<!-- TABLE '#D' : ( Button : Main ) (E) -->



		<!-- TABLE '#D' : ( Search Options ) (S) -->
		<table class="search">
			<tr>
				<td class="bg">
					<table class="search">
					<tr>
					    <td width="30%">
					        <!--IB (S)-->
					        <table  class="search">
					            <tr class="h23">
					                <td width="65">Origin CD</td>
					                <td width="150"><input class="input1" name="org_node" type="text" required caption="ORG CD" maxlength="7" tabIndex="1" style="width:60"  dataformat="engup" value="">
					                	<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="org_node_pop" ></td>
					                <td width="60">Dest CD</td>
					                <td width="150"><input class="input1" name="dest_node" type="text" required caption="DEST CD" maxlength="7" tabIndex="2" style="width:60" dataformat="engup" value="" >
					                	<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="dest_node_pop"></td>
					            </tr>
					        </table>
					        <!--IB (E)-->

					    </td>

						<td width="33%">
					       <table border="0" style="height:20; background-color: #E9E9E9;">
					            <tr>
					                <td class="stm" align="center">
						            	<input type="radio" name='io_type' value='I' class="trans" checked>IB
						                <input type="radio" name='io_type' value='O' class="trans" >OB
									</td>
					                <td style="width: 40px;"></td>
					                <td class="stm" align="center">
										<input type="radio" name='node_type' value='Y' class="trans" checked>Yard
										<input type="radio" name='node_type' value='Z' class="trans" >Zone
									</td>
					                <td></td>
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

		<!-- TABLE '#D' : ( Grid BG Box ) (S) -->
		<table class="search" border="0">
			<tr><td class="bg">

					<!-- Grid : Week (S) -->
					<table width="100%" id="mainTable">
				              <tr><td>
				                     <script type="text/javascript">ComSheetObject('sheet1');</script>
				              </td></tr>
					</table>
					<!-- Grid : Week (E) -->

<!-- : ( Button_ Sub ) (S) -->
					<table width="100%" class="button">
				       	<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<!-- Repeat Pattern -->
							<td class="btn2_left"></td><td class="btn2" name="btng_rowadd" id="btng_rowadd">Row Add</td><td class="btn2_right"></td>
							<td class="btn2_left"></td><td class="btn2" name="btng_rowcopy" id="btng_rowcopy">Row Copy</td><td class="btn2_right"></td>
							<!-- Repeat Pattern -->
						</tr></table>
					</td></tr>
					</table>
					<!-- : ( Button_ Sub ) (E) -->
					</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Grid BG Box ) (E) -->

		<table class="height_10"><tr><td></td></tr></table>
    </td></tr>
</table>
<!-- Outer Table (E)-->
</form>
</body>
</html>
