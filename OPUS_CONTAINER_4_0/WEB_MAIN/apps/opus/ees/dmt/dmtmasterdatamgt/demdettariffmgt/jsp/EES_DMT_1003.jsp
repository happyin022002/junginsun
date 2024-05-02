<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_1003.jsp
*@FileTitle : Basic Tariff Summary Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.20
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009.05.20 김태균
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.event.EesDmt1003Event"%>
<%@ page import="com.clt.apps.opus.bcm.sup.valuemanage.util.OfficeCodeMgr"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@ page import="java.util.List"%>

<%
   EesDmt1003Event  event = null;               //PDTO(Data Transfer Object including Parameters)
   Exception serverException   = null;         //error from server
   String strErrMsg = "";                  //error message
   int rowCount    = 0;                  //count of DB resultSET list

   String successFlag = "";
   String codeList  = "";
   String pageRows  = "100";

   String strUsr_id      = "";
   String strUsr_nm      = "";
   Logger log = Logger.getLogger("com.clt.apps.DMTMasterDataMgt.DemDetTariffMgt");
   String rhqOfcList = "";

   try {
         SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
      strUsr_id =   account.getUsr_id();
      strUsr_nm = account.getUsr_nm();
      rhqOfcList = account.getRhq_ofc_cd();

      event = (EesDmt1003Event)request.getAttribute("Event");
      serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

      if (serverException != null) {
         strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
      }

      // Retrieving the parameter values ​​for calls to pop-up page ..
      GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
      
      //rhqOfcList = OfficeCodeMgr.getOfficeCodeList("000004","COM");//RHQ_OFC_LIST

   }catch(Exception e) {
      out.println(e.toString());
   }
%>
<script language="javascript">
   function setupPage(){
      var errMessage = "<%=strErrMsg%>";
      if (errMessage.length >= 1) {
         showErrMessage(errMessage);
      } // end if
      loadPage();
   }
</script>
<form name="form">
<input type="hidden" name="f_cmd"> 
<input type="hidden" name="pagerows"> 
<input type="hidden" name="cnt_cd">
<input type="hidden" name="conti_cd">
<input type="hidden" name="svr_id">
<input type="hidden" name="dmdt_trf_cd_list">
<input type="hidden" name="dmdt_trf_cd_in"> 
<input type="hidden" name="usr_rhq_ofc_cd"		value="<%=rhqOfcList%>">
      
            
<!-- page_title_area(S) -->
   <div class="page_title_area clear">
       
       <!-- page_title(S) -->
       <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
       <h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
       <!-- page_title(E) -->
       
       <!-- opus_design_btn(S) -->
      <div class="opus_design_btn">
         <!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
         <button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
         --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!-- 
         --><button type="button" class="btn_normal" name="btn_minimize" id="btn_minimize">Minimize</button><!-- 
         --><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button>
      </div>
      <!-- opus_design_btn(E) -->
       
       <!-- page_location(S) -->
       <div class="location">
           <!-- location 내용 동적생성 (별도 코딩 불필요) -->
           <span id="navigation"></span>
       </div>
       <!-- page_location(E) -->
   </div>
   <!-- page_title_area(E) -->
   
   <div class="wrap_search">
   <!-- opus_design_inquiry(S) -->
   <div class="opus_design_inquiry wFit" id="MiniLayer">
       <!-- 조회영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
       <div id="showMin" style="display: inline">
       <table>
           <colgroup>
               <col width="95px" />
               <col width="140px" />
               <col width="127px" />
               <col width="130px" />
               <col width="120px" />
               <col width="399px" />
               <col width="" />
           </colgroup>
           <tbody>
            <tr class="h23">
               <th>RHQ</th>
               <td>
               <!-- 
               <select name="rhqCd" style="width:80px;" class="input1" onchange="searchCountryByRHQ()">
                  &nbsp;
                  <option value="" selected>All</option>
                  <%--
                     String rhqOfc = "";
                     for(int i = 0 ; i < rhqOfcList.size() ; i++) {
                        rhqOfc = (String)rhqOfcList.get(i);
                  --%>
                  <option value="<%--=rhqOfc --%>"><%--=rhqOfc --%></option>
                  <%--
                     }
                  --%>
               </select> -->
               <script type="text/javascript">ComComboObject('rhqCd', 1 ,80 , 0 , 1 , 0, true);</script>
               </td>
               <th>Coverage Country</th>
               <td>&nbsp;<script language="javascript">ComComboObject('combo1', 2, 58 , 0)</script></td>
               <th>Origin/Destination</th>
               <td>&nbsp;<script language="javascript">ComComboObject('combo2', 2, 60 , 0)</script></td>
               <td></td>
            </tr>
            <tr class="h23">
               <th>Tariff Type</th>
               <td colspan="5"><script language="javascript">ComComboObject('combo3', 2, 299 , 0, 1)</script><button type="button" class="multiple_inq"></button></td>
               <td>
               		<div style="display:none;">
						<script type="text/javascript">ComComboObject('sys_area_grp_id', 1 ,80 , 0 , 1 , 0, true);</script>
					</div>
               </td>
            </tr>
         </tbody>
      </table>
      
       <table>
           <colgroup>
              <col width="10px" />
               <col width="85px" />
               <col width="100px" />
               <col width="100px" />
               <col width="100px" />
               <col width="" />
           </colgroup>
           <tbody>
            <tr>
               <td></td>
               <th class="h23" class="bg" style="height:25px;background-color: #E9E9E9;padding-left:10">&nbsp;Group Type</th>
               <td class="h23" class="bg" style="height:25px;background-color: #E9E9E9;padding-left:10"><input type="checkbox" id="dmdt_trf_grp_tp_cd1" name="dmdt_trf_grp_tp_cd1" value="B" class="trans" checked><label for="dmdt_trf_grp_tp_cd1">Billable</label></td>
               <td class="h23" class="bg" style="height:25px;background-color: #E9E9E9;padding-left:10"><input type="checkbox" id="dmdt_trf_grp_tp_cd2" name="dmdt_trf_grp_tp_cd2" value="N" class="trans" checked><label for="dmdt_trf_grp_tp_cd2">Exempted</label></td>
               <td class="h23" class="bg" style="height:25px;background-color: #E9E9E9;padding-left:10"></td>
               <td></td>
            </tr>
         </tbody>
      </table>
      
      <table>
           <colgroup>
              <col width="10px" />
               <col width="85px" />
               <col width="100px" />
               <col width="100px" />
               <col width="100px" />
               <col width="" />
           </colgroup>
           <tbody>
            <tr>
               <td></td>
               <th class="h23" class="bg" style="height:25px;background-color: #E9E9E9;padding-left:10">&nbsp;Validity</th>
               <td class="h23" class="bg" style="height:25px;background-color: #E9E9E9;padding-left:10"><input type="checkbox" id="validity1" name="validity1" value="Y" class="trans" checked><label for="validity1">Current</label></td>
               <td class="h23" class="bg" style="height:25px;background-color: #E9E9E9;padding-left:10"><input type="checkbox" id="validity2" name="validity2" value="Y" class="trans" checked><label for="validity2">To-be</label></td>
               <td class="h23" class="bg" style="height:25px;background-color: #E9E9E9;padding-left:10"><input type="checkbox" id="validity3" name="validity3" value="Y" class="trans"><label for="validity3">Expired</label></td>
               <td></td>
            </tr>
         </tbody>
      </table>
      </div>
   </div>
   </div>
   
   <div class="wrap_result">
   <!-- opus_design_grid(S) -->
   <div class="opus_design_grid" >      
      
      <script language="javascript">ComSheetObject('sheet1');</script>
      
      <!-- opus_grid_design_btn(E) -->
   </div>
   <!-- opus_design_grid(E) -->
   </div>
</form>