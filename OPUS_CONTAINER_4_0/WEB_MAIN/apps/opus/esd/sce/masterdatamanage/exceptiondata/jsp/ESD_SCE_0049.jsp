<%--
/*=========================================================
*Copyright(c) 2007 CyberLogitec
*@FileName : ESD_SCE_0049.jsp
*@FileTitle : Exception Type & Subscriber Group Mapping
*Open Issues :
*Change history :
*@LastModifyDate : 2007-03-21
*@LastModifier : JeongSeon An
*@LastVersion : 1.0
* 2007-03-21 JeongSeon An
* 1.0 최초 생성
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.sce.masterdatamanage.exceptiondata.event.EsdSce0049Event"%>
<%@ page import="com.clt.apps.opus.esd.sce.common.util.basic.CodeUtilBC" %>
<%@ page import="com.clt.apps.opus.esd.sce.common.util.basic.CodeUtilBCImpl" %>

<%
		CodeUtilBC codeUtil = new CodeUtilBCImpl() ;
		EsdSce0049Event  event = null;                		
		Exception serverException   = null;            			//???밿?????? 뮿?????? ??????

		String strErrMsg = "";                                  //?????￢???¸꽿
		DBRowSet rowSet      = null;                            //DB ResultSet
		int rowCount     = 0;                                   //DB ResultSet 리꿤뿸꽿 건꽿
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    	String userId=account.getUsr_id();

    	try{
	    	serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
	    	if (serverException != null) {
	            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
	        }else{
	        	event = (EsdSce0049Event)request.getAttribute("Event");
	        }
		} catch(Exception e) {
	        out.println(e.toString());
	    }
%>

<html>
<head>
<title>Subscriber Group Mapping</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">

    function setupPage(){

        loadPage();


    }

	<%=codeUtil.searchCodeComboSheet("r_expt_tp", "sce_expt_cd", "distinct EXPT_CD", "EXPT_CD_NM",  "substr(EXPT_CD, 2, length(EXPT_CD) ) = '0000000' and ACT_FLG = 'Y'", "EXPT_CD_NM")%>
	<%=codeUtil.searchCodeComboSheet("r_expt_tp_dtl", "sce_expt_cd", "distinct EXPT_CD", "EXPT_CD_NM",  "substr(EXPT_CD, 4, length(EXPT_CD) ) = '00000' and ACT_FLG = 'Y' and substr(EXPT_CD, 2, length(EXPT_CD) ) <> '0000000'", "EXPT_CD_NM")%>
	<%=codeUtil.searchCodeComboSheet("r_fm_act", "sce_expt_cd", "distinct EXPT_CD", "EXPT_CD_NM",  "substr(EXPT_CD, 4, 1 ) = '1' and ACT_FLG = 'Y'", "EXPT_CD_NM")%>
	<%=codeUtil.searchCodeComboSheet("r_to_act", "sce_expt_cd", "distinct EXPT_CD", "EXPT_CD_NM",  "substr(EXPT_CD, 4, 1 ) = '2' and ACT_FLG = 'Y'", "EXPT_CD_NM")%>
	<%=codeUtil.searchCodeComboSheet("r_subseq_grp", "COM_INTG_CD_DTL", "INTG_CD_VAL_CTNT", "INTG_CD_VAL_DP_DESC", "INTG_CD_ID = 'CD00956'", "INTG_CD_VAL_CTNT")%>

</script>




</head>
<body onLoad="setupPage();">
<form name="form" method="POST">
<input type="hidden" name="f_cmd">
<input type="hidden" name="cust_sts" value = ''>
<input type="hidden" name="load_chk" value = 'FAIL'>
<input type="hidden" name="cust_st">
<input type="hidden" name="usr_id" value = "<%=account.getUsr_id()%>">
<input type="hidden" name="tp_nm">

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
							<td width="100">Exception Type</td>
							<td width="250">
			                    <DIV id="ExptTPDiv" >
			                      <select style="width:150;" name='h_expt_tp' disabled>&nbsp;
			                        <option value="" selected>ALL</option>
			                      </select>
			                    </DIV>
							</td>
							<td width="140">&nbsp;Exception Type Detail</td>
							<td>
			                    <DIV id="ExptDTLTPDiv" >
			                      <select style="width:150;" name='h_expt_tp_dtl' disabled>&nbsp;
			                        <option value="" selected>ALL</option>
			                      </select>
			                    </DIV>
							</td>

						</tr>
					</table>

				</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->

		<table class="height_10"><tr><td></td></tr></table>

		<!-- TABLE '#D' : ( Search Options : Speed ) (S) -->
     	<table class="search">
       	<tr><td class="bg">

				<!-- : ( Speed ) (S) -->
				<table width="100%" id="mainTable">
				<tr><td>
					<script language="javascript">ComSheetObject('sheet');</script>
				</td></tr>
				</table>
				<!-- : ( Speed ) (E) -->
				<!-- : ( Button : Sub ) (S) -->
				<!-- : ( Button : Sub ) (S) -->
					<table width="100%" class="sbutton">
	       				<tr><td class="align">
                        <!-- adding 20061228 (s) -->
			    		<table width="100%" class="button">
						<tr><td class="btn2_bg">
							<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<!-- Repeat Pattern -->
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" name="btng_rowadd" id="btng_rowadd">Row Add</td>
								<td class="btn2_right"></td></tr></table></td>
								<!-- Repeat Pattern -->
							</tr></table>
						</td></tr>
					</table>
                        <!-- adding 20061228 (e) -->
						</td></tr>
					</table>
	    		<!-- : ( Button : Sub ) (E) -->
	    		<!-- : ( Button : Sub ) (E) -->
			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options : Speed ) (E) -->
		<!-- ####### TABLE '#D' ::: 'RIGHT' FRAME (END) ####### -->




	</td></tr>
</table>
<!-- TABLE '#B' : 'Left + Right Body' Table (E)nd -->
    </td></tr>
</table>
<!-- Outer Table (E)-->
</form>
</body>
</html>
