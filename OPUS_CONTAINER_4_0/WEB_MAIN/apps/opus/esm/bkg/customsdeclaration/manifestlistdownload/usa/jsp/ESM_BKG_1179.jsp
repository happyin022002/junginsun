<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1179.jsp
*@FileTitle : Manual BDR
*Open Issues :
*Change history :
*@LastModifyDate : * 2014.06.02
*@LastModifier : 신규정
*@LastVersion : 1.0
* 2014.06.02 신규정
* 1.0 Creation 
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="java.util.List"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.framework.core.controller.util.WebKeys"%>
<%@ page import="com.clt.framework.core.view.template.Screen"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.event.EsmBkg1179Event"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsCustomsStatusNoticeVO"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.core.controller.DefaultViewAdapter"%>

<%
    EsmBkg1179Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //서버에서 발생한 에러
    String strErrMsg = "";                      //에러메세지
    int rowCount     = 0;                       //DB ResultSet 리스트의 건수

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    String hndl_ofc_cd      = "";
    Logger log = Logger.getLogger("com.clt.opus.BookingMasterData.BookingMasterMgt");

    List<UsCustomsStatusNoticeVO> list = null;
    String hndlOfcCd  = "";
    String autoSndFlg  = "";
    String hndlOfcAddr  = "";
    String hndlOfcEml  = "";
    String cstmsNtcMsg1r = "";
    String cstmsNtcMsg1s = "";
    UsCustomsStatusNoticeVO vo = null;

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();


        event = (EsmBkg1179Event)request.getAttribute("Event");
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
<input type="hidden" name="hndl_ofc_cd" value="" >
<input type="hidden" name="frm_auto_snd_flg" value="Y" ><!-- 기본값 -->
<input type="hidden" name="frm_ntc_msg_tp_cd_1r" value="1R" ><!-- 기본값 -->
<input type="hidden" name="frm_ntc_msg_tp_cd_1s" value="" >

<div class="page_title_area clear">
    <h2 class="page_title">
        <button type="button"><span id="title"></span></button>
    </h2>
    <div class="opus_design_btn">
        <button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button>
        <button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button>
    </div>
   <div class="location">
        <span id="navigation"></span>
   </div>
</div>

<div class="wrap_search">
    <div class="opus_design_inquiry">
        <table>
            <colgroup>
                <col width="100px">
                <col width="*">
            </colgroup>
            <tbody>
                <tr>
                    <th>Handling Office</th>
                    <td><input type="text" name="frm_hndl_ofc_cd" style="width:80px;" class="input1" value="PHXSC" style="ime-mode:disabled; text-transform:uppercase;" dataformat="uppernum" caption="Handling Office" maxlength="6" fullfill></td>
                </tr>
            </tbody>
        </table>

        <table class="line_bluedot" style="width:100%"><tr><td></td></tr></table>

        <table>
            <colgroup>
                <col width="100px">
                <col width="*">
            </colgroup>
            <tbody>
                <tr>
                    <th>Auto Send</th>
                    <td><input type="radio" name="frm_auto_snd_flg_radio" value="Y" class="trans" checked>&nbsp;&nbsp;Yes&nbsp;&nbsp;&nbsp;
                        <input type="radio" name="frm_auto_snd_flg_radio" value="N" class="trans">&nbsp;&nbsp;No
                    </td>
                </tr>
            </tbody>
        </table>

        <table class="line_bluedot" style="width:100%;"><tr><td></td></tr></table>

        <table>
            <colgroup>
                <col width="100px">
                <col width="*">
            </colgroup>
            <tbody>
                <tr>
                    <th>Address</th>
                    <td><input type="text" style="width:100%;" class="noinput" name="frm_hndl_ofc_addr" format="" maxlength="200" />
                    </td>
                </tr>
            </tbody>
        </table>

        <table class="line_bluedot" style="width:100%;"><tr><td></td></tr></table>

        <table>
            <colgroup>
                <col width="100px">
                <col width="*">
            </colgroup>
            <tbody>
                <tr>
                    <th>From</th>
                    <td><input type="text" style="width:100%;" class="noinput" name="frm_hndl_ofc_eml" format="" maxlength="200" />
                    </td>
                </tr>
            </tbody>
        </table>
    </div>

	<div class="opus_design_tab">
	    <script type="text/javascript">ComTabObject('tab1')</script>
	</div>
	
	<div class="wrap_result">
	    <div class="opus_design_grid" name="tabLayer" id="tabLayer" style="display:inline;">
	        <table>
	            <tbody>
	                <colgroup>
	                    <col width="100%">
	                </colgroup>
	                <tr class="tr2_head">
	                    <td><textarea style="width:100%; ime-mode:disabled;"  rows="10" dataformat="exceptengdn" maxlength="3000" name="frm_cstms_ntc_msg_1r" value="" ></textarea></td>
	                </tr>
	            </tbody>
	        </table>
	    </div>
	    <!-- Tab_Layer_2 (S) -->
	    <div class="opus_design_grid" name="tabLayer" id="tabLayer" style="display:none">
	        <table>
	            <tbody>
	                <colgroup>
	                    <col width="100%">
	                </colgroup>
	                <tr class="tr2_head">
	                   <td><textarea style="width:100%; ime-mode:disabled;" rows="10" dataformat="exceptengdn" maxlength="3000" name="frm_cstms_ntc_msg_1s" value=""></textarea></td>
	                </tr>
	            </tbody>
	        </table>
	    </div>
    </div>
</div>


<div class="wrap_result">
    <div class="opus_design_grid" style="display:none">
        <script language="javascript">ComSheetObject('sheet1');</script>
    </div>
</div>
</form>