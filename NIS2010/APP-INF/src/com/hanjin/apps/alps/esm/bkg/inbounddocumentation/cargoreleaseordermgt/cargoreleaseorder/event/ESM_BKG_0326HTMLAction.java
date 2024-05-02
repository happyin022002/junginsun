/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : ESM_BKG_0326HTMLAction.java
*@FileTitle      : Japan Cargo Release (D/O)
*Open Issues     :
*Change history  :
*@LastModifyDate : 2009-09-08
*@LastModifier   : 임진영
*@LastVersion    : 1.0
* 2009-09-08 임진영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.BlIssVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoBlInfoVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoRlseStsVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.JapDoSaveVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.JapDorStatusVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.BkgDoRefVO;

/**
 * HTTP Parser<br>
 * - Japan Cargo Release (D/O) 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CargoReleaseOrderMgtSC로 실행요청<br>
 * - CargoReleaseOrderMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Lim Jin Young
 * @see EsmBkg0326Event 참조
 * @since J2EE 1.4
 */

public class ESM_BKG_0326HTMLAction extends HTMLActionSupport {

    /**
     *
     */
    private static final long serialVersionUID = -3889119389133086344L;

    /**
     * ESM_BKG_0326HTMLAction 객체를 생성
     */
    public ESM_BKG_0326HTMLAction() {}

    /**
     * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
     * HttpRequst의 정보를 EsmBkg0682Event로 파싱하여 request에 셋팅<br>
     * @param request HttpServletRequest HttpRequest
     * @return Event Event interface를 구현한 객체
     * @exception HTMLActionException
     */
    public Event perform(HttpServletRequest request) throws HTMLActionException {

        FormCommand command = FormCommand.fromRequest(request);
        EsmBkg0326Event event = new EsmBkg0326Event();

        log.debug("===================================");
        log.debug("    ESM_BKG_0326HTMLAction Start   ");
        log.debug("===================================");

        // 변수 선언
        String bkgNo     = request.getParameter("bkg_no");      //선적예약 요청 번호
        String blNo      = request.getParameter("bl_no");       //선화증권 번호
        String demurType = request.getParameter("demur_type");  //Demurrage Type
        String expDelDt  = JSPUtil.getNullNoTrim(request.getParameter("exp_del_dt")).replaceAll("-", ""); //Expect Delivery Date
        String oblCngFlg = request.getParameter("obl_cng_flg"); //OBL 변경 여부
        String doNo      = request.getParameter("do_no");       //do_no
        String doNoSplit = request.getParameter("do_no_split"); //do_no_split
        String svcCd     = request.getParameter("svc_cd");      //Japan D/O 에서 DOR 버튼 클릭시 'D' 값

        event.setBkgNo(bkgNo);
        event.setBlNo(blNo);
        event.setDemurType(demurType);
        event.setExpDelDt(expDelDt);
        event.setOblCngFlg(oblCngFlg);
        event.setDoNo(doNo);
        event.setDoNoSplit(doNoSplit);
        event.setSvcCd(svcCd);

        //O/BL 회수 여부 체크를 위한 값 세팅
        event.setOriOblRdemFlg(request.getParameter("h_ori_obl_rdem_flg"));
        event.setAftOblRdemFlg(request.getParameter("h_aft_obl_rdem_flg"));

        event.setCntrPrtFlg(request.getParameter("blInfo_cntr_prt_flg"));   //partial 여부

        event.setRlseStsCd(request.getParameter("rlse_sts_cd"));            //D/O의 진행 상태 코드
        event.setLastRlseStsCd(request.getParameter("last_rlse_sts_cd"));   //D/O의 최종 진행 상태 코드

        event.setDoCngEvntCd(request.getParameter("do_cng_evnt_cd"));       //D/O 관련업무에서 발생하는 주요 EVENT
        event.setPreCtnt(request.getParameter("pre_ctnt"));                 //D/O EVENT에서 변경되기 전의 값

        event.setOldOblRdemKnt(request.getParameter("old_obl_rdem_knt"));
        event.setNewOblRdemKnt(request.getParameter("new_obl_rdem_knt"));

        //DOR /IF 관련 값 세팅
        event.setSvcCd(request.getParameter("svc_cd"));
        event.setEvntFlag(request.getParameter("evnt_flag"));

        if(command.isCommand(FormCommand.SEARCH)) {
            log.debug("===================================");
            log.debug("    SEARCH EVENT                   ");
            log.debug("===================================");

        }else if(command.isCommand(FormCommand.MODIFY)) {

            log.debug("===================================");
            log.debug("    MODIFY EVENT                   ");
            log.debug("===================================");

            JapDoSaveVO[] refInfo   = ((JapDoSaveVO[])getVOs(request, JapDoSaveVO.class,"refInfo_"));
            JapDoSaveVO[] cstmsInfo = ((JapDoSaveVO[])getVOs(request, JapDoSaveVO.class,"cstmsInfo_"));

            refInfo[0].setCyOpCd(cstmsInfo[0].getCyOpCd());
            refInfo[0].setInfoCgoFlg(cstmsInfo[0].getInfoCgoFlg());
            event.setJapDoSave(refInfo);

            event.setBlIssVOs((BlIssVO[])getVOs(request, BlIssVO.class,"blIss_"));

            if(null != event.getJapDoSave()){
                event.getJapDoSave()[0].setBkgNo(bkgNo);
            }

            if(null != event.getBlIssVOs()){
                event.getBlIssVOs()[0].setBkgNo(bkgNo);
            }

            //BKG_DO_HIT 에 입력 할 파라메터 세팅
            //event.setCrntCtnt(request.getParameter("blIss_obl_rdem_flg")); //Original B/L회수여부
        }else if(command.isCommand(FormCommand.MULTI01)) {

            log.debug("===================================");
            log.debug("    ASSIGN / ISSUE EVENT           ");
            log.debug("===================================");

          //  event.setBlIssVOs((BlIssVO[])getVOs(request, BlIssVO.class,"blIss_"));            
            
            event.setReleaseRemark(request.getParameter("releaseRemark"));
            event.setDoRlseSts((DoRlseStsVO[])getVOs(request, DoRlseStsVO.class,"doRlseSts_"));
            event.setRefInfos((BkgDoRefVO[])getVOs(request, BkgDoRefVO.class,"refInfo_"));

        }else if(command.isCommand(FormCommand.MULTI02)) {

            log.debug("===================================");
            log.debug("    CANCEL EVENT                   ");
            log.debug("===================================");

            event.setDoRlseSts((DoRlseStsVO[])getVOs(request, DoRlseStsVO.class,"doRlseSts_"));

        }else if(command.isCommand(FormCommand.MULTI03)) {

            log.debug("===================================");
            log.debug("    DOR/IF EVENT                   ");
            log.debug("===================================");

            event.setBlIssVOs((BlIssVO[])getVOs(request, BlIssVO.class,"blIss_"));
            event.setDoRlseSts((DoRlseStsVO[])getVOs(request, DoRlseStsVO.class,"doRlseSts_"));

        }else if(command.isCommand(FormCommand.MULTI06)) {

            log.debug("===================================");
            log.debug("    DOR CANCEL EVENT               ");
            log.debug("===================================");

            event.setBlIssVOs((BlIssVO[])getVOs(request, BlIssVO.class,"blIss_"));
            event.setDoRlseSts((DoRlseStsVO[])getVOs(request, DoRlseStsVO.class,"doRlseSts_"));
        }else if(command.isCommand(FormCommand.MULTI05)) {

            log.debug("===================================");
            log.debug("    JP DO ID Save                  ");
            log.debug("===================================");
            event.setJapDorStatus((JapDorStatusVO[])getVOs(request, JapDorStatusVO.class,"japDoInfo_"));
        }else if(command.isCommand(FormCommand.MULTI04)) {

            log.debug("===================================");
            log.debug("    HOLD EVENT                     ");
            log.debug("===================================");

            event.setDoBlInfo((DoBlInfoVO[])getVOs(request, DoBlInfoVO.class,"blInfo_"));
        }
        request.setAttribute("Event", event);
        return  event;
    }

    /**
     * HttpRequest의 attribute에 업무시나리오 수행결과 값 저장<br>
     * ServiceCommand에서 View(JSP)로 실행결과를 전송하는 ResultSet을 request에 셋팅<br>
     *
     * @param request HttpServletRequest HttpRequest
     * @param eventResponse EventResponse interface를 구현한 객체
     */
    public void doEnd(HttpServletRequest request, EventResponse eventResponse) {
        request.setAttribute("EventResponse", eventResponse);
    }

    /**
     * HttpRequest의 attribute에 HttpRequest 파싱 수행결과 값 저장<br>
     * HttpRequest 파싱 수행결과 값 request에 셋팅<br>
     *
     * @param request HttpServletRequest HttpRequest
     * @param event Event interface를 구현한 객체
     */
    public void doEnd(HttpServletRequest request, Event event) {
        request.setAttribute("Event", event);
    }
}