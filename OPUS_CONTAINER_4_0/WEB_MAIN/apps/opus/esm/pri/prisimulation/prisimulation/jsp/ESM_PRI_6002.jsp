<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_6002.jsp
*@FileTitle  : Verify Rate
*@author     : CLT
*@version    : 1.0
*@since      : 2014/11/26
=========================================================
--%> 

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.prisimulation.prisimulation.event.EsmPri6002Event"%>
<%@ page import="com.clt.framework.component.util.code.CodeInfo"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="java.util.List"%>
<%@ page import="com.clt.framework.component.util.StringUtil"%>
<%@ page import="com.clt.framework.core.view.template.Screen"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmPri6002Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //error from server
    String strErrMsg = "";                      //error message
    int rowCount     = 0;                       //count of DB resultSET list

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    String screen_name = "";
    String popup_flag = "N"; 

    String[] cgoTpCdList = null;	//cargo type
    String[] eqtTpCdList = null;	//equipt type
    String[] gohCdList = null;	//equipt type
    String[] trnsModCd = null; 
    
    Logger log = Logger.getLogger("com.clt.apps.PRISimulation.PRISimulation");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();


        event = (EsmPri6002Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        screen_name = ((Screen)(request.getAttribute("com.clt.framework.core.comm.CURRENT_SCREEN"))).getName();
        
        if( screen_name.indexOf("POP") > 0){
            popup_flag = "Y";   
        }

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // adding logic to get data from server when first loading
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

        //COMMBO LIST       
        cgoTpCdList 	= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("cgoTpCdList"), true, "|", "\t", "getCode", "getName");
        eqtTpCdList 	= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("eqtTpCdList"));
        gohCdList		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("gohCdList"), true, "|", "\t", "getCode", "getName");
        trnsModCd       = PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("trnsModCdList"), true, "|", "\t", "getCode", "getName");
        
    }catch(Exception e) {
        out.println(e.toString());
    }
%>
    
<script language="javascript">
    var cgoTpCdListComboValue = "|<%=cgoTpCdList[0]%>";
    var cgoTpCdListComboText = "|<%=cgoTpCdList[1]%>";
    
    var eqtTpCdListComboValue = "|<%=eqtTpCdList[0]%>";
    var eqtTpCdListComboText = "|<%=eqtTpCdList[1]%>";
    
    var gohCdListComboValue = "|<%=gohCdList[0]%>";
    var gohCdListComboText = "|<%=gohCdList[1]%>";
    
    var trnsModComboValue = "|<%=trnsModCd[0]%>";  
    var trnsModComboText = "|<%=trnsModCd[1]%>";

    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if
        loadPage();
    }
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="ctrt_tp">
<input type="hidden" name="backendjob_key">
<input type="hidden" name="f_pctl_no" value="<%=StringUtil.xssFilter(request.getParameter("pctl_no")) %>">
<input type="hidden" name="r_por" value="<%=StringUtil.xssFilter(request.getParameter("por")) %>">
<input type="hidden" name="r_rcv_t" value="<%=StringUtil.xssFilter(request.getParameter("rcv_t")) %>">
<input type="hidden" name="r_del_t" value="<%=StringUtil.xssFilter(request.getParameter("del_t")) %>">
<input type="hidden" name="r_dep_lane" value="<%=StringUtil.xssFilter(request.getParameter("dep_lane")) %>">
<input type="hidden" name="r_arv_lane" value="<%=StringUtil.xssFilter(request.getParameter("arv_lane")) %>">
<input type="hidden" name="r_del" value="<%=StringUtil.xssFilter(request.getParameter("del")) %>">
<input type="hidden" name="r_pol" value="<%=StringUtil.xssFilter(request.getParameter("pol")) %>">
<input type="hidden" name="r_pod" value="<%=StringUtil.xssFilter(request.getParameter("pod")) %>">
<input type="hidden" name="r_cgo_tp_cd" value="<%=StringUtil.xssFilter(request.getParameter("cgo_tp_cd")) %>">
<input type="hidden" name="r_eq_tp_cd" value="<%=StringUtil.xssFilter(request.getParameter("eq_tp_cd")) %>">
<input type="hidden" name="r_sub_trd_cd" value="<%=StringUtil.xssFilter(request.getParameter("sub_trd_cd")) %>">
<input type="hidden" name="r_ld_dt" value="<%=StringUtil.xssFilter(request.getParameter("ld_dt")) %>">
<input type="hidden" name="r_soc_flg" value="<%=StringUtil.xssFilter(request.getParameter("soc_flg")) %>">
<input type="hidden" name="r_goh_cd" value="<%=StringUtil.xssFilter(request.getParameter("goh_cd")) %>">
<input type="hidden" name="r_classId" value="<%=StringUtil.xssFilter(request.getParameter("classId")) %>">
<input type="hidden" name="r_ttl_rt2" value="<%=StringUtil.xssFilter(request.getParameter("ttl_rt2")) %>">
<input type="hidden" name="r_ttl_rt4" value="<%=StringUtil.xssFilter(request.getParameter("ttl_rt4")) %>">
<input type="hidden" name="r_ttl_rt5" value="<%=StringUtil.xssFilter(request.getParameter("ttl_rt5")) %>">
<input type="hidden" name="r_ttl_rt7" value="<%=StringUtil.xssFilter(request.getParameter("ttl_rt7")) %>">
<input type="hidden" name="f_count" value="1">



<!-- developer performance  -->


<!-- page_title_area(S) -->

<%if(popup_flag=="Y"){%>
<div class="layer_popup_title">
     <div class="page_title_area clear">
         <h2 class="page_title"><span>Pricing Simulation</span></h2>
         <div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button>
            <button type="button" class="btn_accent" name="btn_cost_calc" id="btn_cost_calc">Next Calculation</button><!--
            --><button type="button" class="btn_normal" name="btn_new"   id="btn_new">New</button>
            <button type="button" class="btn_normal" name="btn_excel" id="btn_excel">Down Excel</button>
          </div>
     </div>
</div>
<%}else{%>
<div class="page_title_area clear ">
    <!-- page_title(S) -->
    <h2 class="page_title"><button type="button"><span id="title"></span></button>
    </h2>
    <!-- page_title(E) -->

        <!-- opus_design_btn(S) -->
        <div class="opus_design_btn">
            <!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
            <button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button>
            <button type="button" class="btn_accent" name="btn_cost_calc" id="btn_cost_calc">Next Calculation</button><!--
            --><button type="button" class="btn_normal" name="btn_new"   id="btn_new">New</button>
            <button type="button" class="btn_normal" name="btn_excel" id="btn_excel">Down Excel</button>
        </div>
        <!-- opus_design_btn(E) -->
    
    <!-- page_location(S) -->
    <div class="location">
        <!-- location 내용 동적생성 (별도 코딩 불필요) -->
        <span id="navigation"></span>
    </div>
    <!-- page_location(E) -->

</div>
<%}%>




<!-- page_title_area(E) -->

<div class="wrap_search">   
    <!-- opus_design_inquiry(S) -->
    <div class="opus_design_inquiry wFit">
        <!--biz page (S)-->
        <table>
            <colgroup>
                <col width="80"  />
                <col width="120" />
                <col width="60"  />
                <col width="60" />
                <col width="60"  />
                <col width="60" />
                <col width="110"  />
                <col width="100" />
                <col width="110"  />     
                <col width="120" />
                <col width="130"  />     
                <col width="120" />
                <col width="130"  />     
                <col width="120" />
                <col width="130" />
                <col width="" />
            </colgroup>
            <tbody>
                <tr>
                    <th>POR</th>
                    <td><input type="text" name="por" style="width:80px;ime-mode:disabled;text-align:center" class="input1" dataformat="engup" maxlength="5" minlength="5" required caption="POR"><!-- 
                	 --><button type="button" class="input_seach_btn" name="btn_por" id="btn_por"></button></td>
                    <th>R term</th>
					<td><select name="rcv_t" id="rcv_t" class="input1" required style="width:50px" >
								<option value="D">D</option>
								<option value="Y" selected>Y</option>
					</select></td>
					<th>D term</th>
					<td><select name="del_t" id="del_t" class="input1" required style="width:50px">
							<option value="D">D</option>
							<option value="Y" selected>Y</option>
					</select></td>
                    <th>Dep. Svc</th>
                    <td><input type="text" name="dep_lane" style="width:80px;text-align: center;ime-mode:disabled;" class="input" dataformat="engup" maxlength="3"><!-- 
                	 --><button type="button" class="input_seach_btn" name="btn_dep_lane" id="btn_dep_lane"></button></td>
                    <th>Arv. Svc</td>
                    <td><input type="text" name="arv_lane" style="width:80px;text-align: center;ime-mode:disabled;" class="input" dataformat="engup" maxlength="3"><!-- 
                	 --><button type="button" class="input_seach_btn" name="btn_arv_lane" id="btn_arv_lane"></button></td>
                	<th>Org Trans Mode</th>
                    <td><script type="text/javascript" >ComComboObject('org_trns_mod_cd', 2, 80, 0, 0, 0)</script></td>
                    <th>M'ty Pick Up Loc</td>
                    <td><input type="text" name="f_mty_pkup_yd_cd" style="width:80px;text-align: center;ime-mode:disabled;" class="input" dataformat="engup" maxlength="5"><!-- 
                	 --><button type="button" class="input_seach_btn" name="btn_mty_pkup" id="btn_mty_pkup"></button></td>
                    <th>BKG Ofc</td>
                    <td><input type="text" name="f_agn_bkg_ofc_cd" style="width:80px;text-align: center;ime-mode:disabled;" value=""class="input" dataformat="engup" maxlength="5"><!-- 
                	 --><button type="button" class="input_seach_btn" name="btn_agn_bkg_ofc" id="btn_agn_bkg_ofc"></button></td>
                    <td></td>
                </tr>
                <tr>
                	<th>DEL</th>
                	<td colspan="5"><input type="text" name="del" style="width:80px;ime-mode:disabled;text-align:center" class="input1" dataformat="engup" maxlength="5" minlength="5" required caption="DEL"><!-- 
                	 --><button type="button" class="input_seach_btn" name="btn_del" id="btn_del"></button></td>
                    <th>POL</th>
                    <td><input type="text" name="pol" style="width:80px;text-align: center;ime-mode:disabled;" class="input" dataformat="engup" maxlength="5"><!-- 
                	 --><button type="button" class="input_seach_btn" name="btn_pol" id="btn_pol"></button></td>
                    <th>POD</td>
                    <td><input type="text" name="pod" style="width:80px;text-align: center;ime-mode:disabled;" class="input" dataformat="engup" maxlength="5"><!-- 
                	 --><button type="button" class="input_seach_btn" name="btn_pod" id="btn_pod"></button></td>
                	<th>Dest Trans Mode</th>
                    <td><script type="text/javascript" >ComComboObject('dest_trns_mod_cd', 2, 80, 0, 0, 0)</script></td>
                    <th>M'ty Return Loc</td>
                    <td><input type="text" name="f_mty_rtn_yd_cd" style="width:80px;text-align: center;ime-mode:disabled;" class="input" dataformat="engup" maxlength="5"><!-- 
                	 --><button type="button" class="input_seach_btn" name="btn_mty_rtn" id="btn_mty_rtn"></button></td>
                    <th>SC/RFA CTRT Ofc</td>
                    <td><input type="text" name="f_agn_ctrt_ofc_cd" style="width:80px;text-align: center;ime-mode:disabled;" value=""class="input" dataformat="engup" maxlength="5"><!-- 
                	 --><button type="button" class="input_seach_btn" name="btn_agn_ctrt_ofc" id="btn_agn_ctrt_ofc"></button></td>
                    <td></td>
            <tbody>
        </table>
        <table>
            <colgroup>
                <col width="80"/>
                <col width="120"/>
                <col width="60"/>
                <col width="60"/>
                <col width="60"/>
                <col width="80"/>
                <col width="80"/>     
                <col width="170"/>
                <col width="40"/>
                <col width="65"/>
                <col width="170"/>
                <col width="170"/>
                <col width="" />
            </colgroup>
            <tbody>
                <tr>
                    <th>Cargo Type</th>
                    <td><script type="text/javascript" >ComComboObject('cgo_tp_cd', 2, 80, 0, 1, 0)</script></td>
                    <th>Eqt Type</th>
                    <td><script type="text/javascript" >ComComboObject('eq_tp_cd', 1, 40, 0, 1, 0)</script></td>
                    <th>Sub Trade</th>
                    <td><input type="text" name="sub_trd_cd" style="width:30px;text-align: center;ime-mode:disabled;" class="input" dataformat="engup" maxlength="2"><!-- 
                	 --><button type="button" class="input_seach_btn" name="btn_sub_trd" id="btn_sub_trd"></button></td>
                    <th>Effective Date</th>
                    <td><input type="text" style="width:80px;text-align:center;" class="input1" name="ld_dt" id="ld_dt" dataformat="ymd" maxLength="10" minlength="8" required caption="Effective Date"><!-- 
                    --><button type="button" class="calendar ir" name="btn_calendar" id="btn_calendar"></button></td>
                    <th><input type="checkbox" name="soc_flg" value="Y">&nbsp; SOC</th>
                    <th>GOH</th>
                    <td><script type="text/javascript" >ComComboObject('goh_cd', 2, 50, 0, 0, 0)</script></td>
                    <th>FF/Customer</td>
                    <td><input type="text" name="f_agn_ff_cust" style="width:80px;text-align: center;ime-mode:disabled;" value=""class="input" dataformat="engup" maxlength="8"><!-- 
                	 --><button type="button" class="input_seach_btn" name="btn_cust" id="btn_cust"></button></td>
                    <td></td>
                </tr>
            <tbody>
        </table>
    </div>
</div>

<div class="wrap_result">

	<div class="opus_design_data">
		<table style="height:35px">
			<colgroup>
               <col width="570"/>
               <col width="100"/>
               <col width="130"/>
               <col width="220"/>
               <col width="*" />
           </colgroup>
		<tr>
			<td>
			<table class="sm mar_top_4">
				<colgroup>
	               <col width="105"/>
	               <col width="90"/>
	               <col width="30"/>
	               <col width="90"/>
	               <col width="30"/>     
	               <col width="90" />
	               <col width="30"/>     
	               <col width="*" />
	           </colgroup>
				<tbody>
					<tr>
						<th>Revenue &nbsp; 2 :</th>
						<td><input type="text" name="f_rv_20" style="width:70px;text-align: center;ime-mode:disabled;" class="input" dataformat="singledFloat"></td>
						<th> 4 :</th>
						<td><input type="text" name="f_rv_40" style="width:70px;text-align: center;ime-mode:disabled;" class="input" dataformat="singledFloat"></td>
						<th> 5 :</th>
						<td><input type="text" name="f_rv_45" style="width:70px;text-align: center;ime-mode:disabled;" class="input" dataformat="singledFloat"></td>
						<th> 7 :</th>
						<td><input type="text" name="f_rv_70" style="width:70px;text-align: center;ime-mode:disabled;" class="input" dataformat="singledFloat"></td>
					</tr>
				</tbody>
			</table>
			</td>
			<th>Service Scope</th>
                  <td>
                  <select style="width: 122px;" name ="svc_scp_cd" class="input" readonly></select>
			</td>
			<th><input type="checkbox" name="trf_schg_chk" value="Y" id="chk_chg">&nbsp; Subject To Tariff Surcharge</th>
			<td>
				<button type="button" class="btn_etc" name="btn_schg_pop" id="btn_schg_pop"><span id="all_charge_btn"></span></button>
			</td>
			</tr>
		</table>
	</div>
    <!-- opus_design_inquiry(S) -->
    <div class="opus_design_grid">
    	<table style="width:979"> 
			<tr>
				<td align="left" style="color: red;">&nbsp;*Red font indicates cost items for which vendor rates cannot be found (historical average is applied).</td>
				<td>
				    <div class="opus_design_btn">
						<button type="button" class="btn_normal" name="btn_cm_dtl" id="btn_cm_dtl">CM Detail</button>
					    <button type="button" class="btn_normal btn_up" name="btn_up" id="btn_up"></button>
						<button type="button" class="btn_normal btn_down" name="btn_down" id="btn_down"></button>
					</div>
				</td>
			</tr>
		</table>
		
	    <div class="opus_design_grid" id="mainTable" >                                  
	        <!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	        <script language="javascript">ComSheetObject('sheet1');</script>
	        <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    </div>
	    <div class="layout_wrap">
		    <div class="layout_vertical_2 pad_rgt_12" style="width:800px">
			    <div class="opus_design_btn">
					
				</div>
				<div class="opus_design_grid" id="mainTable">
		        <script language="javascript">ComSheetObject('sheet2');</script>
		        </div>
		    </div>
		    
			<div class="layout_vertical_2" style="width:100px">
			&nbsp;
			</div>
			<div class="layout_vertical_2" style="width:300px;display:none" id="all_charge">
				<div class="opus_design_grid" >
			        <script language="javascript">ComSheetObject('sheet3');</script>
			    </div>
			    <div class="opus_design_btn">
					<button type="button" class="btn_normal" name="btn_apply" id="btn_apply">APPLY</button>
				</div>
			</div>
		</div>
		<div class="opus_design_grid" style="display:none">                                  
	        <!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	        <script language="javascript">ComSheetObject('sheet4');</script>
	        <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	    </div>
    </div>
    <!-- opus_design_inquiry(E) --> 
</div>
<!-- developer performance  end -->
</form>
