<%
    /*=========================================================
     *Copyright(c) 2009 CyberLogitec
     *@FileName : esm_bkg_0909.jsp
     *@FileTitle : Inbound Cargo Release Order for POD Office(US)
     *Open Issues :
     *Change history :
     *@LastModifyDate : 2009.09.21
     *@LastModifier : 곽영범
     *@LastVersion : 1.0
     * 2009.09.21 곽영범
     * 1.0 Creation
     =========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg0909Event"%>
<%@ page import="org.apache.log4j.Logger"%>
<%
    EsmBkg0909Event event = null; //PDTO(Data Transfer Object including Parameters)
    Exception serverException = null; //서버에서 발생한 에러
    String strErrMsg = ""; //에러메세지
    int rowCount = 0; //DB ResultSet 리스트의 건수

    String successFlag = "";
    String codeList = "";
    String pageRows = "100";

    String strUsr_id = "";
    String strUsr_nm = "";
    String strUsr_email = "";
    String strOfc_cd = "";

    Logger log = Logger.getLogger("com.hanjin.apps.InboundBLMgt.CargoReleaseOrder");

    try {
        SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        strUsr_email = account.getUsr_eml();
        strOfc_cd = account.getOfc_cd();

        event = (EsmBkg0909Event) request.getAttribute("Event");
        serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

    } catch (Exception e) {
        out.println(e.toString());
    }
%>
<html>
<head>
<title>Inbound Cargo Release Order for POD Office(US)</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
    function setupPage(){  
        loadPage();
    }
</script>
</head>
<body onLoad="setupPage();">

<!-- 개발자 작업  -->
<form name="form">
    <input name="f_cmd" type="hidden" /> 
    <input type="hidden" name="pagerows" value="<%=pageRows%>"> 
    <input type="hidden" name="keys" value="">
    <input type="hidden" name="bkg_no" value=""> <!-- 선택한 BKG_NO -->
    <input type="hidden" name="req_pod_cd" value=""> <!-- 선택한 POD_CD -->
    <input type="hidden" name="blInfo_por_cd" value=""> <!-- 조회한 POR_CD -->
<!-- TPB Status -->
<input type='hidden' name ='tpb_status'>    

<%@include file="../../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_TOP.jsp"%>
        
        <!--Page Title, Historical (E)--> <!--biz page (S)-->
        <table class="search">
            <tr>
                <td class="bg">
                    <!--  biz_1  (S) -->
                    <table class="search" border="0" style="width: 979;">
                        <tr class="h23">
                            <td width="20"><input type="radio" name="sch_tp" class="trans" checked="checked" /></td>
                            <td width="50">B/L No.</td>
                            <td width="">
                                <input type="text" style="width: 95;" class="input1" value="" name="bl_no" id="bl_no"                                    
                                    maxlength="12" style="ime-mode:disabled"
                                    onKeyPress="ComKeyOnlyAlphabet('uppernum');" 
                                    onKeyDown="ComKeyEnter(this)"
                                    onFocus="sch_tp[0].checked=true;" />
                            </td>
                            
                            <td width="20"><input type="radio" name="sch_tp" class="trans" /></td>
                            <td width="145">Latest Update Date</td>
                            <td width="">
                                <input type="text" style="width: 75" dataformat="ymd" minlength="8" maxlength="8" value=""
                                    class="input1" caption="Duration Start Date" name="start_date"  style="width:100;ime-mode:disabled"
                                    onKeyPress="ComKeyOnlyNumber(this);" onKeyDown="ComKeyEnter(this)" onFocus="sch_tp[1].checked=true;" />&nbsp;
                                <input type="text" style="width: 44" class="input1" name="start_time" dataformat="hm" minlength="4" maxlength="4" value=""
                                    onKeyPress="ComKeyOnlyNumber(this);" onKeyDown="ComKeyEnter(this)" onFocus="sch_tp[1].checked=true;"/>&nbsp;&nbsp;~&nbsp;
                                <input type="text" style="width: 75" dataformat="ymd" minlength="8" maxlength="8" value="" class="input1" caption="Duration End Date"
                                    name="end_date" style="width:100;ime-mode:disabled" onKeyPress="ComKeyOnlyNumber(this);" onKeyDown="ComKeyEnter(this)" onFocus="sch_tp[1].checked=true;"/>&nbsp;
                                <input type="text" style="width: 44" class="input1" name="end_time" dataformat="hm" minlength="4" maxlength="4" value=""
                                    onKeyPress="ComKeyOnlyNumber(this);" onKeyDown="ComKeyEnter(this)" onFocus="sch_tp[1].checked=true;" />&nbsp;
                                <img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_end_date" />
                            </td>
                            
                        </tr>
                    </table>
                    <table class="search" border="0" style="width: 979;">
                        <tr class="h23">                            
                            <td width="42">Freight</td>
                            <td width="60">
                                <select style="width: 50;" class="input1" name="frt_clt_flg" onKeyDown="ComKeyEnter(this)">                    
                                    <option value="">All</option>
                                    <option value="Y">Y</option>
                                    <option value="N">N</option>
                                </select>
                            </td>
                            <td width="30">B/L</td>
                            <td width="60">
                                <select style="width: 50;" class="input1" name="obl_rdem_flg" onKeyDown="ComKeyEnter(this)">
                                    <option value="">All</option>
                                    <option value="Y">Y</option>
                                    <option value="N">N</option>
                                </select>
                            </td>
                            <td width="42">Customs</td>
                            <td width="60">
                                <select style="width: 50;" class="input1" name="cstms_clr_cd" onKeyDown="ComKeyEnter(this)">
                                    <option value="">All</option>
                                    <option value="Y">Y</option>
                                    <option value="J">J</option>
                                    <option value="N">N</option>
                                </select>
                            </td>
                            <td width="42">Release</td>
                            <td width="60">
                                <select style="width: 50;" class="input1" name="mrn_tml_edi_snd_cd" onKeyDown="ComKeyEnter(this)">
                                    <option value="">All</option>
                                    <option value="Y">Y</option>
                                    <option value="N">N</option>
                                </select>
                            </td>                            
                            
                            <td width="25">VVD</td>
                            <td width="90">
                                <input type="text" style="width: 80" class="input" name="vvd" value="" maxlength="9" 
                                    onKeyPress="ComKeyOnlyAlphabet('uppernum');" onKeyDown="ComKeyEnter(this)" />
                            </td>
                            <td width="25">POD</td>
                            <td width="70">
                                <input type="text" style="width: 60" class="input" name="pod_cd" value="" maxlength="5" 
                                    onKeyPress="ComKeyOnlyAlphabet('uppernum');" onKeyDown="ComKeyEnter(this)" />
                            </td>
                            <td width="25">DEL</td>
                            <td width="70">
                                <input type="text" style="width: 60" class="input" name="del_cd" value="" maxlength="5" 
                                    onKeyPress="ComKeyOnlyAlphabet('uppernum');" onKeyDown="ComKeyEnter(this)" />
                            </td>
                            <td width="25">HUB</td>
                            <td width="">
                                <input type="text" style="width: 67" class="input" name="hub_loc_cd" value="" maxlength="5" 
                                    onKeyPress="ComKeyOnlyAlphabet('uppernum');" onKeyDown="ComKeyEnter(this)" />
                            </td>
                                
                        </tr>
                    </table>
                    <!--  biz_1   (E) -->
                </td>
            </tr>
        </table>
                
        <table class="height_8"><tr><td></td></tr></table>
                
        <table class="search">
            <tr>
                <td class="bg">
                    <!-- Grid  (S) -->
                    <table width="100%" id="mainTable">
                        <tr>
                            <td width="100%">
                                <script language="javascript">ComSheetObject('master');</script>                            
                            </td>
                        </tr>
                    </table>
                    <!-- Grid (E) -->
                    <table class="height_5"><tr><td></td></tr></table>
                
                
                    <table class="search" border="0" style="width: 979;">
                        <tr>
                            <td width="650">
                        
                                <table class="search" border="0" width="100%">
                                    <tr class="h23">
                                        <td width="60">&nbsp;B/L No.</td>
                                        <td width="435">
                                            <input type="text" style="width: 110; weight: bold" class="input2" name="curr_bl_no" readonly="readonly" />
                                            <input type="text" style="width: 45; color: red;" class="input2" name="do_hld_flg" value="" readonly="readonly" />
                                            Partial
                                            <input type="text" style="width: 45; color: red;" class="input2" name="prt_ind" value="" readonly="readonly" />
                                        </td>
                                        <td width="90">
                                            <table class="search" border="0">
                                                <tr>
                                                    <td class="title_h"></td>
                                                    <td class="title_s" width="">TPB status</td>
                                                </tr>
                                            </table>
                                        </td>
                                        <td>
                                            <img class="cursor" src="img/btng_icon_g.gif" width="13" height="13" border="0" align="absmiddle" id="tpb_icon" />&nbsp;
                                            <input type="text" style="width:20;;text-align:center;" name='tpb_cd' class="input2" readonly="readonly" />
                                            <img class="cursor" name="btn_tpb" id="btn_tpb" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" />
                                        </td>
                                    </tr>
                                </table>
                            
                                <table class="height_5"><tr><td></td></tr></table>
                                <table class="search_sm" border="0" width="100%">
                                    <tr class="h23">
                                        <td width="140">
                                            <table class="search" border="0">
                                                <tr>
                                                    <td class="title_h"></td>
                                                    <td class="title_s" width="">Freight Receive</td>
                                                </tr>
                                            </table>
                                        </td>
                                        <td width="70">
                                            <select style="width: 50;" name="info_frt_clt_flg">
                                                <option value="Y">Y</option>
                                                <option value="N">N</option>
                                            </select>
                                        </td>
                                        <td width="90"></td>
                                    
                                        <td width="280">
                                            Outstanding&nbsp;
                                            <select class="input2" style="width:175; font-weight: bold;" id="tot_ots_amt" name='tot_ots_amt'>
                                            </select>
                                        </td>
                                        <td width="" align="right">
                                            <table width="70" border="0" cellpadding="0" cellspacing="0" class="button">
                                                <tr>
                                                    <td class="btn2_left"></td>
                                                    <td class="btn2" name="btn_erp">ERP</td>
                                                    <td class="btn2_right"></td>
                                                </tr>
                                            </table>
                                        </td>                               
                                    </tr>
                                    
                                    <tr class="h23">
                                        <td width="140">
                                            <table class="search" border="0">
                                                <tr>
                                                    <td class="title_h"></td>
                                                    <td class="title_s" width="">Customs Clearance</td>
                                                </tr>
                                            </table>
                                        </td>
                                        <td>
                                            <select style="width: 50;" id="info_cstms_clr_cd" name="info_cstms_clr_cd">
                                                <option value="Y">Y</option>
                                                <option value="N">N</option>
                                                <option value="J">J</option>                                                
                                                <option value="D">D</option>
                                                <option value="E">E</option>
                                                <option value="H">H</option>
                                                <option value="I">I</option>
                                                <option value="P">P</option>
                                                <option value="T">T</option>                                    
                                                <option value="W">W</option>
                                                <option value="V">V</option>
                                            </select>
                                        </td>
                                        <td width="" colspan="3"></td>
                                    </tr>
                                    <tr class="h23">
                                        <td>
                                            <table class="search" border="0" width="">
                                                <tr>
                                                    <td class="title_h"></td>
                                                    <td class="title_s" width="">Demurrage Status</td>
                                                </tr>
                                            </table>
                                        </td>
                                        <td width="">
                                            <input type="text" style="width: 50; color: red;" class="input2" value="" id="dem_status" name="dem_status" readonly="readonly" />
                                        </td>
                                        <td width="90">
                                            Type&nbsp;
                                            <input type="text" style="width: 40;"class="input2" value="" name="demur_type" readonly="readonly" />
                                        </td>
                                        <td width="280">Outstanding&nbsp;
                                            <select style="width:175;font-weight:bold;" class="input2" id="tot_bil_amt" name='tot_bil_amt'>
                                            </select>
                                        </td>
                                        <td align="right">
                                            <table width="70" border="0" cellpadding="0" cellspacing="0" class="button">
                                                <tr>
                                                    <td class="btn2_left"></td>
                                                    <td class="btn2" name="btn_dmdt">DMDT</td>
                                                    <td class="btn2_right"></td>
                                                </tr>
                                            </table>
                                        </td>
                                    </tr>
                                </table>
                            </td>   
                
                            <td width="15"></td>
                            
                            <td width="" valign="top">
                
                        
                                <!-- Grid  (S) -->
                                <table width="100%" id="mainTable">
                                    <tr>
                                        <td width="100%">
                                            <script language="javascript">ComSheetObject('container');</script>                                
                                        </td>
                                    </tr>
                                </table>

                                <!-- bkg_do_ref 저장용 -->
                                <table width="220" id="mainTable" style="display: none">
                                    <tr>
                                        <td width="100%">
                                            <script language="javascript">ComSheetObject('bkg_do_ref');</script>                                
                                        </td>
                                    </tr>
                                </table>

                                <!-- BKG_CGO_RLSE 저장용 -->
                                <table width="220" id="mainTable" style="display: none">
                                    <tr>
                                        <td width="100%">
                                            <script language="javascript">ComSheetObject('bkg_cgo_rlse');</script>
                                        </td>
                                    </tr>
                                </table>
                                
                                <!-- otsRcvInfo 조회용 -->
                                <table width="220" id="mainTable" style="display: none">
                                    <tr>
                                        <td width="100%">
                                            <script language="javascript">ComSheetObject('otsRcvInfo');</script>
                                        </td>
                                    </tr>
                                </table>
                                
                                <!-- 테스트데이터 저장용 -->
                                <table width="220" id="mainTable" style="display: none">
                                    <tr>
                                        <td width="100%">
                                            <script language="javascript">ComSheetObject('test_foc');</script>
                                        </td>
                                    </tr>
                                </table>                                
                                
                                
                                <!-- BL Status 조회,저장용 -->
                                <table width="500" id="mainTable_sheet_bl_status" style="display: none" bgcolor="blue">
                                    <tr>
                                        <td width="100%">
                                            <script language="javascript">ComSheetObject('sheet_bl_status');</script>
                                        </td>
                                    </tr>
                                </table>                        
                        
                                                
                                <!-- Grid (E) -->
                                <table class="height_5"><tr><td></td></tr></table>
                                
                                <table border="0" style="width:100%; background-color: white;" class="grid2">
                                    <tr class="h23" align="center">
                                        <td width="100%" class="tr2_head">O/B Remark(s)</td>
                                    </tr>
                                    <tr class="h23" align="center">
                                        <td width="" class="noinput2"><textarea style="width: 100%; height:18" name="obl_iss_rmk" class="noinput2" readonly="readonly"></textarea></td>
                                    </tr>
                                </table>
                        
                            </td>
                        </tr>
                    </table>
                    
                    <table class="height_8"><tr><td></td></tr></table>
                
                    <!--  biz_4  (S) -->
                    <table class="search" border="0" style="width:979;">
                        <tr class="h23">
                            <td width="650" valign="top">
                    
                                <!--  biz_4 _1 (S) -->
                                
                                <table class="search_sm" border="0" style="width:100%">
                                    <tr class="h23">
                                        <td>
                                            <table class="search" border="0" width="100">
                                                <tr>
                                                    <td class="title_h"></td>
                                                    <td class="title_s" width="">B/L Issue</td>
                                                </tr>
                                            </table>
                                        </td>
                                        <td width="65">
                                            <input type="text" name="bl_status" style="width:50; text-align: center"class="input2" readonly="readonly" />
                                        </td>
                                        <td width="25">No.</td>
                                        <td width="59">
                                            <input type="text" name="bl_cpy_knt" style="width:44;" class="input2" style="text-align:right" readonly="readonly" />
                                        </td>
                                        <td width="25">OFC</td>
                                        <td width="80">
                                            <input type="text" name="bl_rlse_ofc_cd" style="width:60;" class="input2" readonly="readonly" />
                                        </td>
                                        <td width="15">ID</td>
                                        <td width="90">
                                            <input type="text" name="bl_rlse_usr_id" style="width:80;" class="input2" readonly="readonly" />
                                        </td>
                                        <td width="20">DT</td>
                                        <td width="">
                                            <input type="text" name="bl_rlse_dt" style="width:120;" class="input2" readonly="readonly" />
                                        </td>
                                    </tr>
                                    <tr class="h23">
                                        <td width="100">
                                            <table class="search" border="0">
                                                <tr>
                                                    <td class="title_h"></td>
                                                    <td class="title_s" width="">B/L Receive</td>
                                                </tr>
                                            </table>
                                        </td>
                                        <td width="">
                                            <select style="width: 50;"  name="info_obl_rdem_flg" onchange="blStatusInitByObl()">
                                                <option value="Y">Y</option>
                                                <option value="N">N</option>
                                            </select>
                                            <input type="hidden" style="width: 20; color: blue;" class="input2" name="obl_ttl_knt" value="" />
                                        </td>
                                        <td width="">No.</td>
                                        <td width="">
                                            <input type="text" name="obl_rdem_knt" style="width:44;" class="input" style="text-align:right" onKeyPress="ComKeyOnlyNumber(this)" maxlength="1" />
                                        </td>
                                        <td width="">OFC</td>
                                        <td width="">
                                            <input type="text" name="obl_rdem_ofc_cd" style="width:60;" class="input2" readonly="readonly" />
                                        </td>
                                        <td width="">ID</td>
                                        <td width="">
                                            <input type="text" name="obl_rdem_usr_id" style="width:80;" class="input2" readonly="readonly" />
                                        </td>
                                        <td width="">DT</td>
                                        <td width="">
                                            <input type="text" name="obl_rdem_dt" style="width:120;" class="input2" readonly="readonly" />                            
                                            <img class="cursor" name="btn_srnd" id="btn_srnd" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" />
                                        </td>
                                    </tr>
                                    <tr class="h23">
                                        <td width="" colspan="2">&nbsp;</td>
                                        <td width="">No.</td>
                                        <td width="">
                                            <input type="text" name="bl_ibd" style="width:44;" class="input" style="text-align:right" onKeyPress="ComKeyOnlyNumber(this)" maxlength="1" />
                                        </td>
                                        <td width="">OFC</td>
                                        <td width="">
                                            <input type="text" name="bl_ibd_ofc_cd" style="width:60;" class="input2" readonly="readonly" />
                                        </td>
                                        <td width="">ID</td>
                                        <td width="">
                                            <input type="text" name="bl_ibd_usr_id" style="width:80;" class="input2" readonly="readonly" />
                                        </td>
                                        <td width="">DT</td>
                                        <td width="">
                                            <input type="text" name="bl_ibd_dt" style="width:120;" class="input2" readonly="readonly" />
                                        </td>
                                    </tr>
                                    <tr class="h23">
                                        <td colspan="2">
                                            <table class="search" border="0" width="100">
                                                <tr>
                                                    <td class="title_h"></td>
                                                    <td class="title_s" width="">Other Doc RCV</td>
                                                </tr>
                                            </table>
                                        </td>
                                        <td width=""></td>
                                        <td width="">
                                            <select style="width: 44;" name="bl_otr_doc_rcv_cd">
                                                <option value=""></option>
                                                <option value="LG">LG</option>
                                                <option value="LI">LI</option>
                                            </select>
                                        </td>
                                        <td width="">OFC</td>
                                        <td width="">
                                            <input type="text" name="otr_doc_rcv_ofc_cd" style="width:60;" class="input2" readonly="readonly" />
                                        </td>
                                        <td width="">ID</td>
                                        <td width="">
                                            <input type="text" name="otr_doc_rcv_usr_id" style="width:80;" class="input2" readonly="readonly" />
                                        </td>
                                        <td width="">DT</td>
                                        <td width="">
                                            <input type="text" name="otr_doc_rcv_dt" style="width:120;" class="input2" readonly="readonly" />
                                        </td>
                                    </tr>
			                        <tr class="h23" id="web_print">
			                            <td >
											<table class="search" border="0" width="100">
												<tr>
													<td class="title_h"></td>
													<td class="title_s" width="">OB/L Serial No.</td>
												</tr>
											</table>
										</td>
			                            <td width="" align="center" colspan="6"><script language="javascript">ComComboObject('obl_inter_ser_no', 3, 250, 1, 0);</script></td>
                                        <td  width="" align="left" colspan="3" id="obl_inter_ser_no_chk_title" height="30"></td>
			                        </tr> 
			                      </table>                              
                                <!--  biz_4 _1 (E) -->
                            </td>
                            <td width="15"></td>
                        
                            <td width="" valign="top">
                                <table border="0" style="width:100%; background-color: white;" class="grid2">
                                    <tr class="h23" align="center">
                                        <td width="80%" class="tr2_head">Hold / Internal Remark(s)</td>
                                        <td align="center">
                                            <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">                           
                                                <tr>
                                                    <td class="btn2_left" style="border;0 !important; padding:0 !important;"></td>
                                                    <td class="btn2" name="btn_remark" style="border;0 !important; padding:0 !important;">Save</td>
                                                    <td class="btn2_right" style="border;0 !important; padding:0 !important;"></td>
                                                </tr>
                                            </table>
                                        </td>
                                    </tr>
                                    <tr class="h23" align="center">
                                        <td width="" colspan="2"><textarea style="width: 100%; height: 78" name="inter_rmk" class="noinput"></textarea>
                                        </td>
                                    </tr>
                                </table>
                            </td>
                    
                        </tr>
                    </table>                    
                    
                    <!-- Original Bill of Lading Status 끝 -->                               
                
                
                    <!-- 데이터 테스트 시작-->
                    
                    <table class="height_8"><tr><td></td></tr></table>               
                
                
                    <!-- 데이터 테스트 시작-->
                    <table class="search" border="0" style="display: none">
                        <tr>
                            <td width="680">
                                <table class="search" border="0">
                                    <tr>
                                        <td class="title_h"></td>
                                        <td class="title_s" width="">I/F</td>
                                    </tr>
                                </table>
                                <table class="search_sm" border="0" width="680">
                                    <tr class="h23">
                                        <td width="40">BL_NO</td>
                                        <td width="80">
                                            <input type="text" style="width: 100;" class="input2" value="" name="test_bl_no" />
                                        </td>
                                        <td width="40">F/O/C</td>
                                        <td width="80">
                                            <input type="text" style="width: 30;" class="input2" value="" name="test_foc" />
                                        </td>                              
                                        <td width="40">evntOfcCd</td>
                                        <td width="80">
                                            <input type="text" style="width: 50;" class="input2" value="" name="test_evnt_ofc_cd" />
                                        </td>      
                                        <td width="40">evntUsrId</td>
                                        <td width="80">
                                            <input type="text" style="width: 100;" class="input2" value="" name="test_evnt_usr_id" />
                                        </td>     
                                        
                                    </tr>
                                    <tr class="h23">            
                                        <td width="40">evntDt</td>
                                        <td width="80">
                                            <input type="text" style="width: 100;" class="input2" value="" name="test_evnt_dt" />
                                        </td>
                                        <td width="40">cgorTeamCd</td>
                                        <td width="80">
                                            <input type="text" style="width: 50;" class="input2" value="" name="test_cgor_team_cd" />
                                        </td>     
                                        <td width="40">cgorEvntNm</td>
                                        <td width="80">
                                            <input type="text" style="width: 100;" class="input2" value="" name="test_cgor_evnt_nm" />
                                        </td>
                                        <td width="40">cstmsLocCd</td>
                                        <td width="80">
                                            <input type="text" style="width: 50;" class="input2" value="" name="test_cstms_loc_cd" />
                                        </td>
                                        <td width="40">cstmsDsPoCd</td>
                                        <td width="80">
                                            <input type="text" style="width: 50;" class="input2" value="" name="test_cstms_ds_po_cd" />
                                        </td>
                                    </tr>
                                </table>
                            
                                <table>
                                    <tr>
                                        <td>
                                            <table width="70" border="0" cellpadding="0" cellspacing="0" class="button">
                                                <tr>
                                                    <td class="btn1_left"></td>
                                                    <td class="btn1" name="btn_test_frt" id="btn_test_frt">FRT</td>
                                                    <td class="btn1_right"></td>
                                                </tr>
                                            </table>
                                        </td>
                                        <td>
                                            <table width="70" border="0" cellpadding="0" cellspacing="0" class="button">
                                                <tr>
                                                    <td class="btn1_left"></td>
                                                    <td class="btn1" name="btn_test_obl" id="btn_test_obl">OBL</td>
                                                    <td class="btn1_right"></td>
                                                </tr>
                                            </table>
                                        </td>
                                        <td>
                                            <table width="70" border="0" cellpadding="0" cellspacing="0" class="button">
                                                <tr>
                                                    <td class="btn1_left"></td>
                                                    <td class="btn1" name="btn_test_cstms" id="btn_test_cstms">CSTMS</td>
                                                    <td class="btn1_right"></td>
                                                </tr>
                                            </table>
                                        </td>
                                    </tr>
                                </table>
                            </td>
                            <td width="20"></td>
                            
                        </tr>
                    </table>
                    
                    <!-- 데이터 테스트 끝  -->

                </td>
            </tr>
        </table>
    
        <!-- Grid BG Box  (S) --> <!--biz page (E)--> <!--Button (S) -->
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">
            <tr>
                <td class="btn1_bg">
                    <table border="0" cellpadding="0" cellspacing="0">
                        <tr>
                            <td>
                                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                    <tr>
                                        <td class="btn1_left"></td>
                                        <td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
                                        <td class="btn1_right"></td>
                                    </tr>
                                </table>
                            </td>
                            <td class="btn1_line"></td>
                            <td style="display:none">
                                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                    <tr>
                                        <td class="btn1_left"></td>
                                        <td class="btn1" name="btn_Transmit" id="btn_Transmit">Transmit</td>
                                        <td class="btn1_right"></td>
                                    </tr>
                                </table>
                            </td>
                            <td>
                                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                    <tr>
                                        <td class="btn1_left"></td>
                                        <td class="btn1" name="btn_History">History</td>
                                        <td class="btn1_right"></td>
                                    </tr>
                                </table>
                            </td>
                            <td>
                                <table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
                                    <tr>
                                        <td class="btn1_left"></td>
                                        <td class="btn1" name="btn_Save">Save</td>
                                        <td class="btn1_right"></td>
                                    </tr>
                                </table>
                            </td>
                            <td>
                                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                    <tr>
                                        <td class="btn1_left"></td>
                                        <td class="btn1" id="btn_Hold" name="btn_Hold">Hold</td>
                                        <td class="btn1_right"></td>
                                    </tr>
                                </table>
                            </td>
                            <td>
                                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                    <tr>
                                        <td class="btn1_left"></td>
                                        <td class="btn1" name="btn_Hold_History">Hold History</td>
                                        <td class="btn1_right"></td>
                                    </tr>
                                </table>
                            </td>
                            <td>
                                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                    <tr>
                                        <td class="btn1_left"></td>
                                        <td class="btn1" name="btn_DownExcel">Down Excel</td>
                                        <td class="btn1_right"></td>
                                    </tr>
                                </table>
                            </td>
                             
                            <td>
                                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                    <tr>
                                        <td class="btn1_left"></td>
                                        <td class="btn1" name="btn_CFlag" style="color:red">C flag / CNTR</td>
                                        <td class="btn1_right"></td>
                                    </tr>
                                </table>
                            </td>
                    
                        </tr>
                    </table>
                </td>
            </tr>
        </table>
        <!--Button (E) -->
        </td>
    </tr>
</table>
<%@include file="../../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_CLOSE.jsp"%>
</form>
 <!-- 개발자 작업  끝 -->
</body>
</html>
