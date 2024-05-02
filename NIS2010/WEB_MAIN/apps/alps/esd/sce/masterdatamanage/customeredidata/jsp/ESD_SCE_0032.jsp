<%
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_SCE_0032.jsp
*@FileTitle : EDI Search
*Open Issues :
*Change history :
*   - 2006-10-12 : UI 변경으로 인한 수정
*@LastModifyDate : 2006-10-12
*@LastModifier : Seong-mun Kang
*@LastVersion : 2.0
* 2006-08-29 yong cheon shin
* 1.0 최초 생성
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.event.EsdSce0032Event"%>
<%@ page import="com.hanjin.apps.alps.esd.sce.common.util.basic.CodeUtilBC" %>
<%@ page import="com.hanjin.apps.alps.esd.sce.common.util.basic.CodeUtilBCImpl" %>

<%
			CodeUtilBC codeUtil = new CodeUtilBCImpl() ;
            EsdSce0032Event  event = null;                		//PDTO(Data Transfer Object including Parameters)
			Exception serverException   = null;            			//서버에서 발생한 에러

			String strErrMsg = "";                                  //에러메세지
			DBRowSet rowSet      = null;                            //DB ResultSet
			int rowCount     = 0;                                   //DB ResultSet 리스트의 건수


    try {

    	serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }else{
        	event = (EsdSce0032Event)request.getAttribute("Event");
            
        }//if
    }catch(Exception e) {
        out.println(e.toString());
    }
%>
<html>
<head>
<title>Welcome to enis!</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if
        loadPage();
    }
</script>

</head>


<body onLoad="setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input    type="hidden" name="f_cmd">
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
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_downexcel" id="btn_downexcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>
							<!-- Repeat Pattern -->

						</tr></table>

				</td></tr>
		</table>
		<!-- TABLE '#D' : ( Button : Main ) (E) -->



		<!-- TABLE '#D' : ( Search Options ) (S) -->
		<!-- TABLE '#D' : ( Search Options ) (S) -->
		<table class="search">
			<tr>
				<td class="bg">
					<table class="search_in" border="0">
						<tr class="h23">
							<td width="130">EDI Customer Group</td>
							<td width="71"><input type="text" name="cs_grp_id" style="width:267;  text-transform:uppercase;" onfocusout="javascript:onObjectFocusout('cs_grp_id','grp_nm',this.form)"></td>
							<td width=""><input class="input0" name="tp_id" type="text"  class="input" style="width:471; text-transform:uppercase;" value="" >
							<img onClick="openCustomer()" class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle">
							<input name="grp_nm" type="hidden">
							</td>
						<!--  	<td width=""><%=codeUtil.searchCodeCombo("cs_grp_id"," (select edi_grp_cd a,  edi_grp_desc from edi_group order by a) "
							        ,"a edi_grp_cd"
							        ,"'('||a||') '||edi_grp_desc "," a"," onChange=javascript:onValueChange('cs_grp_id',this.form) style=\"width:760;\"","1:: ")%></td>-->
						</tr>
					</table>
					<!--  <table class="search_in" border="0">
						<tr class="h23">
							<td width="130">Customer TP ID</td>
							<td width="270"><%=codeUtil.searchCodeCombo("cs_tp_id"," edi_group e"
							        ,"distinct(cust_trd_prnr_id)"
							        ,"cust_trd_prnr_id","trim(cust_trd_prnr_id) is not null","e.cust_trd_prnr_id"," onChange=javascript:onValueChange('cs_tp_id',this.form) style=\"width:145;\"","1::ALL")%></td>
							<td width="85">Hanjin TP ID</td>
							<td width="271"><%=codeUtil.searchCodeCombo("hj_tp_id"," edi_group e"
							        ,"distinct(prov_trd_prnr_id)"
							        ,"prov_trd_prnr_id","trim(prov_trd_prnr_id) is not null","e.prov_trd_prnr_id"," onChange=javascript:onValueChange('hj_tp_id',this.form)  style=\"width:145;\"","1::ALL")%></td>
							<td width="55">S/C No.</td>
							<td><%=codeUtil.searchCodeCombo("sc_no"," edi_grp_cust c"
							        ,"distinct(sc_no)"
							        ,"sc_no","trim(sc_no) is not null","c.sc_no"," onChange=javascript:onValueChange('sc_no',this.form) style=\"width:150;\"","1::ALL")%></td>
						</tr>
					</table>
					<table class="search_in" border="0">
						<tr class="h23">
							<td width="130">Customer Code</td>
							<td width="71"><input type="text" name='cs_nm' style="width:67;  text-transform:uppercase;" onfocusout="javascript:onObjectFocusout('cs_nm','cs_cd',this.form)"></td>
							<td width=""><%=codeUtil.searchCodeCombo("cs_cd"," edi_grp_cust egc, mdm_customer mc "
							        ,"distinct(egc.cust_cnt_cd || egc.cust_seq)"
							        ,"'('||egc.cust_cnt_cd || egc.cust_seq||')'||mc.cust_lgl_eng_nm","egc.cust_cnt_cd = mc.cust_cnt_cd and  egc.cust_seq = mc.cust_seq",""," onChange=javascript:onValueChange('cs_cd',this.form) style=\"width:760;\"","1::ALL")%></td>
						</tr>
					</table> -->

				</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->


		<table class="height_10"><tr><td></td></tr></table>

		<!-- TABLE '#D' : ( Tab ) (S) -->
     	<table class="tab">
       		<tr><td><script language="javascript">ComTabObject('tab1')</script></td></tr>
	</table>
		<!-- TABLE '#D' : ( Tab ) (E) -->

        <div id="tabLayer" style="display:inline">
		<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
     	<table class="search" border="0">
			<tr>
				<td class="bg_b1">
				<table class="height_10"><tr><td></td></tr></table>

		                    <table width="100%" id="mainTable">
		                        <tr><td>
		                             <script language="javascript">ComSheetObject('t1sheet');</script>
		                        </td></tr>
		                    </table>
				<!-- : ( Speed ) (E) -->

			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Tab BG Box ) (E) -->
        </div>

        <div id="tabLayer" style="display:none">
		<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
     		<table class="search" border="0">
			<tr>
				<td class="bg">
					<table class="height_10"><tr><td></td></tr></table>

		                    <table width="100%" id="mainTable">
		                        <tr><td>
		                             <script language="javascript">ComSheetObject('t2sheet');</script>
		                        </td></tr>
		                    </table>
				<!-- : ( Speed ) (E) -->
				</td>
			</tr>
		</table>
		<!-- TABLE '#D' : ( Tab BG Box ) (E) -->
        </div>
<table class="height_10"><tr><td></td></tr></table>

    </td></tr>
</table>
<!-- Outer Table (E)-->
</form>
</body>
</html>

