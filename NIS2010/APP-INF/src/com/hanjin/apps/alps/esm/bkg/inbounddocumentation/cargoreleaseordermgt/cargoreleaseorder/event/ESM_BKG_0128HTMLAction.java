/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : ESM_BKG_0128HTMLAction.java
*@FileTitle      : Cargo Release (D/O)
*Open Issues     :
*Change history  :
*@LastModifyDate : 2009-09-16
*@LastModifier   : 안진응
*@LastVersion    : 1.0
* 2009-09-16 안진응
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.BlIssVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoBlInfoVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoRlseStsVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoSaveVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.GenDoBlInfoVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.PsaDoEdiTransVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - Cargo Release (D/O) 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CargoReleaseOrderMgtSC로 실행요청<br>
 * - CargoReleaseOrderMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author An Jin Eung
 * @see EsmBkg0128Event 참조
 * @since J2EE 1.4
 */

public class ESM_BKG_0128HTMLAction extends HTMLActionSupport {

    /**
     *
     */
    private static final long serialVersionUID = -3889119389133086344L;

    /**
     * ESM_BKG_0128HTMLAction 객체를 생성
     */
    public ESM_BKG_0128HTMLAction() {}

    /**
     * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
     * HttpRequst의 정보를 EsmBkg0128Event로 파싱하여 request에 셋팅<br>
     * @param request HttpServletRequest HttpRequest
     * @return Event Event interface를 구현한 객체
     * @exception HTMLActionException
     */
    public Event perform(HttpServletRequest request) throws HTMLActionException {

        FormCommand command = FormCommand.fromRequest(request);
        EsmBkg0128Event event = new EsmBkg0128Event();

        log.debug("===================================");
        log.debug("    ESM_BKG_0128HTMLAction Start   ");
        log.debug("===================================");

        /*****************************************************************
            변수 선언
        *****************************************************************/
        String bkgNo     = request.getParameter("bkg_no");     //선적예약 요청 번호
        String blNo      = request.getParameter("bl_no");      //선화증권 번호
        String demurType = request.getParameter("demur_type"); //Demurrage Type
        String expDelDt  = JSPUtil.getNullNoTrim(request.getParameter("exp_del_dt")).replaceAll("-", ""); //Expect Delivery Date
        String oblCngFlg = request.getParameter("obl_cng_flg"); //OBL 변경 여부
        String vtyCngFlg = request.getParameter("vty_cng_flg");//validity date 변경 여부
        event.setDemurType(demurType);
        event.setExpDelDt(expDelDt);
        event.setOblCngFlg(oblCngFlg);
        event.setVtyCngFlg(vtyCngFlg);
        //O/BL 회수 여부 체크를 위한 값 세팅
        event.setOriOblRdemFlg(request.getParameter("h_ori_obl_rdem_flg"));
        event.setAftOblRdemFlg(request.getParameter("h_aft_obl_rdem_flg"));

        event.setCntrPrtFlg(request.getParameter("blInfo_cntr_prt_flg"));   //partial 여부

        event.setRlseStsCd(request.getParameter("rlse_sts_cd"));            //D/O의 진행 상태 코드
        event.setLastRlseStsCd(request.getParameter("last_rlse_sts_cd"));   //D/O의 최종 진행 상태 코드

        event.setDoCngEvntCd(request.getParameter("do_cng_evnt_cd"));       //D/O 관련업무에서 발생하는 주요 EVENT
        event.setPreCtnt(request.getParameter("pre_ctnt"));                 //D/O EVENT에서 변경되기 전의 값

        //DOR /IF 관련 값 세팅
        event.setSvcCd(request.getParameter("svc_cd"));

        //  Event Type : RL (Release), CC(Cancel), AT(Amendment Transmit)
        event.setEventTp(request.getParameter("event_tp"));

        String strTemp  = "";

        if(command.isCommand(FormCommand.SEARCH)) {
            if (blNo.isEmpty() == false) {
                strTemp = blNo.substring(blNo.length()-1);

                if (strTemp.equals("W") || strTemp.equals("S")) {
                    blNo = blNo.substring(0, blNo.length()-1);
                }
            }

            event.setBkgNo(bkgNo);
            event.setBlNo(blNo);

            log.debug("===================================");
            log.debug("    SEARCH EVENT                   ");
            log.debug("===================================");

            //D/O는 무조건 1값임
            //event.setRlseSeq("1"); 2009-08-18 윤윤환 수석 모델링 검토 후 파라메터 안넘기기로 결정
        }else if(command.isCommand(FormCommand.MODIFY)) {
            if (blNo.isEmpty() == false) {
                strTemp = blNo.substring(blNo.length()-1);

                if (strTemp.equals("W") || strTemp.equals("S")) {
                    blNo = blNo.substring(0, blNo.length()-1);
                }
            }

            event.setBkgNo(bkgNo);
            event.setBlNo(blNo);

            log.debug("===================================");
            log.debug("    MODIFY EVENT                   ");
            log.debug("===================================");

            String splitFlg = request.getParameter("blInfo_do_split_flg");
            String interRmk = request.getParameter("blInfo_inter_rmk");

            if (splitFlg.length() == 0) {
                splitFlg = "N";
            }

            event.setDoSplitFlg(splitFlg);

            if (interRmk.length() == 0) {
                interRmk = "";
            }

            event.setGenBlInfos((GenDoBlInfoVO[])getVOs(request, GenDoBlInfoVO.class,"blInfo_"));
//            event.setRefInfos((BkgDoRefVO[])getVOs(request, BkgDoRefVO.class,"refInfo_"));
            event.setBlIssVOs((BlIssVO[])getVOs(request, BlIssVO.class,"blInfo_"));

            String refNm      = event.getGenBlInfos()[0].getCstmsRefNm();
            String refCtnt    = event.getGenBlInfos()[0].getCstmsRefCtnt();
            String asgnNm     = event.getGenBlInfos()[0].getCstmsAsgnNm();
            String asgnCtnt   = event.getGenBlInfos()[0].getCstmsAsgnCtnt();
            String doVtyDt    = event.getGenBlInfos()[0].getDoVtyDt();
            String evntFlag   = request.getParameter("evnt_flag");
            String hldFlg     = "";

            if ("R".equals(evntFlag)) {
                hldFlg = "Y";
            } else {
                hldFlg = "N";
            }

            DoSaveVO doSave = new DoSaveVO();

            doSave.setBkgNo(event.getBkgNo());
            doSave.setCstmsRefNm(refNm);
            doSave.setCstmsRefCtnt(refCtnt);
            doSave.setCstmsAsgnNm(asgnNm);
            doSave.setCstmsAsgnCtnt(asgnCtnt);
            doSave.setInterRmk(interRmk);
            doSave.setDoSplitFlg(event.getDoSplitFlg());
            doSave.setDoHldFlg(hldFlg);
            doSave.setDoVtyDt(doVtyDt);

            event.setDoSave(doSave);

            //BKG_DO_HIT 에 입력 할 파라메터 세팅
            //event.setCrntCtnt(request.getParameter("blIss_obl_rdem_flg")); //Original B/L회수여부

            if(null != event.getGenBlInfos()){
                event.getGenBlInfos()[0].setBkgNo(bkgNo);
            }

            if(null != event.getBlIssVOs()){
                event.getBlIssVOs()[0].setBkgNo(bkgNo);
                event.getBlIssVOs()[0].setIbflag("U");
            }
        }else if(command.isCommand(FormCommand.MULTI01) || command.isCommand(FormCommand.MULTI05)) {
            log.debug("===================================");
            log.debug("    Release EVENT                  ");
            log.debug("===================================");

            if (blNo.isEmpty() == false) {
                strTemp = blNo.substring(blNo.length()-1);

                if (strTemp.equals("W") || strTemp.equals("S")) {
                    blNo = blNo.substring(0, blNo.length()-1);
                }
            }

            event.setBkgNo(bkgNo);
            event.setBlNo(blNo);
            event.setRlseStsCd(request.getParameter("rlse_sts_cd"));
            // Cargo Release 시 F/O/C가 Clear 되지않은 상태일경우 별도 Remark를 입력한다. 
            event.setReleaseRemark(request.getParameter("releaseRemark"));        
            event.setGenBlInfos((GenDoBlInfoVO[])getVOs(request, GenDoBlInfoVO.class,"blInfo_"));            
            event.setDoRlseSts((DoRlseStsVO[])getVOs(request, DoRlseStsVO.class,"doRlseSts_"));

        }else if(command.isCommand(FormCommand.MULTI02)) {

            log.debug("===================================");
            log.debug("    CANCEL EVENT                   ");
            log.debug("===================================");

            if (blNo.isEmpty() == false) {
                strTemp = blNo.substring(blNo.length()-1);

                if (strTemp.equals("W") || strTemp.equals("S")) {
                    blNo = blNo.substring(0, blNo.length()-1);
                }
            }

            String rlse_sts_cd = request.getParameter("rlse_sts_cd");

            event.setBkgNo(bkgNo);
            event.setBlNo(blNo);
            event.setRlseStsCd(rlse_sts_cd);
            if ("R".equals(rlse_sts_cd)) {
                event.setResetFlg("N");
            } else {
                event.setResetFlg("Y");
//              event.setResetFlg("N");
            }

            event.setDoRlseSts((DoRlseStsVO[])getVOs(request, DoRlseStsVO.class,"doRlseSts_"));


        }else if(command.isCommand(FormCommand.MULTI04)) {

            log.debug("===================================");
            log.debug("    HOLD EVENT                     ");
            log.debug("===================================");

            event.setEvntFlag(request.getParameter("evnt_flag"));
//            event.setDoBlInfo((DoBlInfoVO[])getVOs(request, DoBlInfoVO.class,"blInfo_"));
            event.setGenBlInfos((GenDoBlInfoVO[])getVOs(request, GenDoBlInfoVO.class,"blInfo_"));            
            
        }else if(command.isCommand(FormCommand.MULTI05)) {
        	
        	event.setPsaDoEdi((PsaDoEdiTransVO)getVO(request,PsaDoEdiTransVO.class,""));
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