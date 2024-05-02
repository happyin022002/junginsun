<%/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESM_COA_0174.jsp
*@FileTitle : Average U/C(OP fixed/variable cost, SPC CHT Rev/Charterage) 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.23
*@LastModifier : 최인경
*@LastVersion : 1.0
* 2010.02.01 최인경
* 1.0 Creation
=========================================================
History
2009.12.23 최인경  ALPS FrameWork 적용
2010.02.11 이행지 Ticket ID:CHM-201002397 Vessel Pool 및 OP4 logic 보완 요청
2010.06.10 송호진 [Legacy전환] UI 표준안 적용 요청 관련 수정 : 
	             CHM-200901714, CHM-200901715, CHM-200901716, CHM-200901717, CHM-200901718, CHM-200901719
2010.12.01 김기종 Ticket ID:CHM-201004982-01 COA Architecture 위배사항 수정
2011.09.15 최성민 [CHM-201113373-01] AES Trade VSL Pool노선의 OP1 및 OP4 산출 로직 변경
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%
    Exception serverException   = null;             //서버에서 발생한 에러
    String ibRlane      = "";
	String ibTrade      = "";
	String ibStCostNm	= "";
	String ibStCostCd   = "";
	String strErrMsg    = ""; 
    String prevWeek = "";
    Logger log = Logger.getLogger("com.hanjin.alps.esm.coa.ESM_COA_0174");
    try {
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        //추가----------------------------------------------------------------------------------------- START
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

    }catch(Exception e) {
        log.error("ESM_COA_0174 Exception : "+e.toString());
    }
%>

<html>
<head>
<title>Average U/C(OP fixed/variable cost,SPC CHT Rev/Chraterage)</title>
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

<body onload="javascript:setupPage();">
<iframe height="0" width="0" name="frmHidden"></iframe>
<form method="post" name="form"  onKeyDown="ComKeyEnter();">
<input type="hidden" name="f_cmd">
<input type='hidden' name='f_cost_use_tp_cd' value='A'>
<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
  <tr>
    <td>
      <!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
        <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
      </table>
      <!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->


      <!--Button_L (S) -->
      <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
        <tr>
          <td class="btn1_bg">
            <table border="0" cellpadding="0" cellspacing="0">
              <tr>
                <!-- Repeat Pattern -->
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" id="btn_Retrieve" name="btn_Retrieve">Retrieve</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td class="btn1_line"></td>
                <!-- 
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" id="btn_Save" name="btn_Save">Save</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" id="btn_Create" name="btn_Create">Create</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" id="btn_Month_Copy" name="btn_Month_Copy">Month Copy</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                 -->
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" id="btn_Downexcel" name="btn_Downexcel">Down Excel</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <!-- Repeat Pattern -->

              </tr>
            </table>
          </td>
        </tr>
      </table>
      <!--Button_L (E) -->


      <!-- TABLE '#D' : ( Search Options ) (S) -->
      <table class="search">
        <tr>
          <td class="bg">
            <!-- : ( Year ) (S) -->
            <table class="search_in" border="0">
              <tr class="h23">
                <td width="75">YYYY-MM</td>
				<td width="150">&nbsp;<input type="text" class="input1" name="f_cost_yrmon" style="width:70;text-align:center;" maxlength="7" 
				onKeyPress="ComKeyOnlyNumber(window)" onFocus="this.value=ComReplaceStr(this.value, '-', '');" 
				onBlur="this.value=ComGetMaskedValue(this.value,'ym');" onChange="setPeriod(this);"></td>
				<td width="55">Source </td>
                <td width="180"><input type="text" class="input2"  name="f_fm_yrwk" style="width:60;text-align:center;" maxlength="7" readonly>
                ~ <input type="text" class="input2" name="f_to_yrwk" style="width:60;text-align:center;" maxlength="7" readonly></td>
                <td width="100">Creation Date </td>
                <td width="160"><input type="text" class="input2" name="f_upd_dt" style="width:150;text-align:center;" maxlength="7" readonly></td>
              </tr>
              <tr><td class="line_bluedot" colspan="10"></td></tr>
              <tr class="h23">
                <td width="75">Trade</td>
                <td width="80">
                	<script language="javascript">ComComboObject('f_trd_cd',1, 80 , 1 )</script>
                </td>
                <td width="40">Lane</td>
                <td width="80">
                	<script language="javascript">ComComboObject('f_rlane_cd',1, 80 , 0 )</script>
                </td>
                <td width="40">Bound</td>
                <td width="80">
                	<script language="javascript">ComComboObject('f_dir_cd',1, 80 , 1 )</script>
                </td>
                <td width="300">&nbsp; </td>
            </table>
            <!-- : ( Year ) (E) -->
          </td>
        </tr>
      </table>
      <!-- TABLE '#D' : ( Search Options ) (E) -->
        
            
        <table class="height_8"><tr><td></td></tr></table>
		<!-- Tab ) (S) -->
		<table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%>
			<tr><td width="100%"><script language="javascript">ComTabObject('tab1')</script>
				</td>
			</tr>
		</table>
		<!-- Tab ) (E) --> <!-- iFrame (S) -->
		<div id="tabLayer" style="display:inline">		   
			<table class="search" border="0">
				<tr>
					<td class="bg">
						  <table class="search" border="0">
					    	<tr>
				         	 <td align="right">
				            	<img class="cursor" src="/hanjin/img/alps/ico_newwin.gif" width="11" height="12" align="absmiddle" hspace="">
				            	<a href="javascript:openLaneDetail();"  class="purple">Lane Detail</a> &nbsp;  
				          	</td>
				        	</tr>
				            <tr><td class="height_5"></td></tr>
				        </table>
			       		<table width="100%"  id="mainTable">
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet1');</script>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			
	<!--  Button_Sub (S) -->
            <table width="100%" class="button">
              <tr>
                <td class="btn2_bg">
                  <table border="0" cellpadding="0" cellspacing="0">
                    <tr>

                      <!-- Repeat Pattern -->
                      <!-- 
                      <td>
                        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                          <tr>
                            <td class="btn2_left"></td>
                            <td class="btn2" id="btn_rowadd" name="btn_rowadd">Row Add</td>
                            <td class="btn2_right"></td>
                          </tr>
                        </table>
                      </td>
                       -->
                      <!-- Repeat Pattern -->
                    </tr>
                  </table>
                </td>
              </tr>
            </table>
            <!-- Button_Sub (E) -->
		</div>
		<div id="tabLayer" style="display: none">		    
			<table class="search" border="0">
				<tr>
					<td class="bg">					
						  <table class="search" border="0">
					    	<tr>
				         	 <td align="right">
				            	<img class="cursor" src="/hanjin/img/alps/ico_newwin.gif" width="11" height="12" align="absmiddle" hspace="">
				            	<a href="javascript:openLaneDetail();"  class="purple">Lane Detail</a> &nbsp;  
				          	</td>
				        	</tr>
				            <tr><td class="height_5"></td></tr>
				        </table>
			       		<table width="100%"  id="mainTable">
							<tr>
								<td width="100%">
									<script language="javascript">ComSheetObject('sheet2');</script>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</div>
		
             
            <!-- : ( POR ) (E) -->
<!--           </td>
        </tr>
      </table> -->
      <!-- TABLE '#D' : ( Search Options ) (E) -->
      

    </td>
  </tr>
</table>
<!-- Outer Table (E)-->

</form>
</body>
</html>
