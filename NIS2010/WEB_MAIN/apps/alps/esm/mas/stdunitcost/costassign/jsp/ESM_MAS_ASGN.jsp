<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_MAS_9999.jsp
*@FileTitle : Batch Test Page
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.25
*@LastModifier : 임옥영
*@LastVersion : 1.0
* 2009.09.25 임옥영
* 1.0 Creation
* 2010.09.29 박은주 비용생성 단계추가(디버깅을 위해서 소스 변경)
*                  화면에 level 인자추가

=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.mas.stdunitcost.costassign.event.EsmMasAssignEvent"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmMasAssignEvent  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	Logger log = Logger.getLogger("com.hanjin.apps.STDUnitCost.CostAssign");

	try {
		event = (EsmMasAssignEvent)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Batch Test Page</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script>
	function doProcess(pageNo){
		try {
			//var srcName = window.event.srcElement.getAttribute("name");
			// form 이름에 주의하시기 바랍니다.
			with(document.form) {
				switch (pageNo) {
					// BT_SCM_MAS_021
					case 21:
						f_cmd.value = COMMAND21;
						action = "ESM_MAS_ASGN.do";
						target = "frmHidden";
						submit();
						break;

					// BT_SCM_MAS_022
					case 22:
						f_cmd.value = COMMAND22;
						action = "ESM_MAS_ASGN.do";
						target = "frmHidden";
						submit();
						break;

					// 
					case 23:
						f_cmd.value = COMMAND23;
						action = "ESM_MAS_ASGN.do";
						target = "frmHidden";
						submit();
						break;
						
					case 24:
						f_cmd.value = COMMAND24;
						antion = "ESM_MAS_ASGN.do";
						target = "frmHidden";
						submit();
						break;
					
				} // end switch
			}// end with
		} catch(e) {
			if( e == "[object Error]") {
				ComShowCodeMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e);
			}
		}
	}
</script>
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

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<br>
<tr><td>
		<table border="0" style="width:737; background-color:white;" class="grid2">
			<tr>
				<td width="85%" class="tr2_head">Pane Name</td>
				<td width="15%" class="tr2_head">Do Process</td>
			</tr>
			<tr>
			<td class="con" bgcolor="#FFFFFF" style="height:70; padding-left:30; ">
					<b>PRD (createCostAssignPrd)</b>&nbsp;&nbsp;&nbsp;&nbsp;
					start_pctl_no&nbsp;&nbsp;<input name="f_start_pctl_no" id="start_pctl_no" value="B0702160000000690002">&nbsp;&nbsp;
					end_pctl_no&nbsp;&nbsp;<input name="f_end_pctl_no" id="end_pctl_no" value="B0702160000000690002">
				</td>
				<td class="con" bgcolor="#FFFFFF" align="center"><a href="javascript:doProcess(21)" class="purple">Execute</a></td>
			</tr>
			<tr>
				<td class="con" bgcolor="#FFFFFF" style="height:70; padding-left:30;">
					<b>COP (createCostAssignCop)</b>&nbsp;&nbsp;&nbsp;&nbsp;
					 bkg_no&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					 <input name="f_bkg_no" " id="f_bkg_no" value="HKGY6050197"  maxlength="13" ><!-- SGN73060004 -->
					 <input type="checkbox" name="f_del_para" value="T"  class="trans"  checked>&nbsp;PARA 삭제
					 <input name="f_level" " id="f_level" value="6"  maxlength="1" ><!-- SGN73060004 -->
				</td>
				<td class="con" bgcolor="#FFFFFF" align="center" ><a href="javascript:doProcess(22)" class="purple">Execute</a></td>
			</tr>
		</table>

		<br>
                <!-- TABLE '#D' : ( Search Options ) (S) -->
                <table class="search" border="0" style="width:737;">
                    <tr style="height:23; font-weight:bold; color: #313131; ">
                        <td class="bg">
                            <!-- : ( Select 'Simulation No' ) (S) -->
                            <table >
                                <tr>
									<td class="con"  width="100">MAS_BAT_CD</td>
									<td><input type="text" class="input1" name="f_mas_bat_cd"style="width:150;text-align:center;" maxlength="15"></td>
									<td width="500"></td>
									<!-- Repeat Pattern -->
									<td width="100" align="rignt"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr ><td class="btn1_left"></td><td class="btn1" id="btn_retrieve" name="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
									<!-- Repeat Pattern -->
								</tr>
							</table>
                            <!-- : ( Select 'Simulation No' ) (E) -->
						</td></tr>
				</table>
				<!-- TABLE '#D' : ( Search Options ) (E) -->

				<table class="height_10"><tr><td></td></tr></table>

				<!-- TABLE '#D' : ( Search Options ) (S) -->
				<table  width="737" border="0">
					<tr>
						<td class="bg">
						<!-- : ( Option ) (S) --> <!-- : ( Option ) (S) END -->
						<table width="100%" id="mainTable">
							<tr>
								<td><script language="javascript">ComSheetObject('sheet1');</script></td>
							</tr>
						</table>
						</td>
					</tr>
				</table>
				<!-- TABLE '#D' : ( Search Options ) (E) -->



</td></tr>
</table>
<!-- Outer Table (E)-->
<!-- 개발자 작업  끝 -->
</form>
<iframe heigth="0" width="0" name="frmHidden" ></iframe>
</body>
</html>