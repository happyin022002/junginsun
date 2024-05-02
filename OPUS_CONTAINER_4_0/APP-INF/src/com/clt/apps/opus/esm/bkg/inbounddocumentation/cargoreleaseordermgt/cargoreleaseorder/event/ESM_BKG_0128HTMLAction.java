/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : ESM_BKG_0128HTMLAction.java
*@FileTitle      : Cargo Release (D/O)
*Open Issues     :
*Change history  :
*@LastModifyDate : 2009-09-16
*@LastModifier   : 
*@LastVersion    : 1.0
* 2009-09-16 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.BlIssVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoCntrVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoRlseStsVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoRlseVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoSaveVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EuDoCntrRlseStsVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EuDoRlseStsVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.GenDoBlInfoVO;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - Cargo Release (D/O) 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CargoReleaseOrderMgtSC로 실행요청<br>
 * - CargoReleaseOrderMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author
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

        event.setDemurType(demurType);
        event.setExpDelDt(expDelDt);
        event.setOblCngFlg(oblCngFlg);

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
            //모델링 검토 후 파라메터 안넘기기로 결정
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

            String splitFlg = request.getParameter("refInfo_do_split_flg");
            String interRmk = request.getParameter("blInfo_inter_rmk");

            if (splitFlg.length() == 0) {
                splitFlg = "N";
            }

            event.setDoSplitFlg(splitFlg);

            if (interRmk.length() == 0) {
                interRmk = "";
            }

            event.setGenBlInfos((GenDoBlInfoVO[])getVOs(request, GenDoBlInfoVO.class,"blInfo_"));
            event.setBlIssVOs((BlIssVO[])getVOs(request, BlIssVO.class,"blInfo_"));

            String refNm      = event.getGenBlInfos()[0].getCstmsRefNm();
            String refCtnt    = event.getGenBlInfos()[0].getCstmsRefCtnt();
            String asgnNm     = event.getGenBlInfos()[0].getCstmsAsgnNm();
            String asgnCtnt   = event.getGenBlInfos()[0].getCstmsAsgnCtnt();
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
        }else if(command.isCommand(FormCommand.MULTI01)) {
            log.debug("===================================");
            log.debug("    Release EVENT                  ");
            log.debug("===================================");

//            if (blNo.isEmpty() == false) {
//                strTemp = blNo.substring(blNo.length()-1);
//
//                if (strTemp.equals("W") || strTemp.equals("S")) {
//                    blNo = blNo.substring(0, blNo.length()-1);
//                }
//            }
//
//            event.setBkgNo(bkgNo);
//            event.setBlNo(blNo);
//            event.setRlseStsCd(request.getParameter("rlse_sts_cd"));
//            // Cargo Release 시 F/O/C가 Clear 되지않은 상태일경우 별도 Remark를 입력한다. 
//            event.setReleaseRemark(request.getParameter("releaseRemark"));        
//            event.setGenBlInfos((GenDoBlInfoVO[])getVOs(request, GenDoBlInfoVO.class,"blInfo_"));            
//            event.setDoRlseSts((DoRlseStsVO[])getVOs(request, DoRlseStsVO.class,"doRlseSts_"));
            
            if (blNo.isEmpty() == false) {
                strTemp = blNo.substring(blNo.length()-1);

                if (strTemp.equals("W") || strTemp.equals("S")) {
                    blNo = blNo.substring(0, blNo.length()-1);
                }
            }

            event.setBkgNo(bkgNo);
            event.setBlNo(blNo);

            String splitFlg = request.getParameter("refInfo_do_split_flg");         
            String interRmk = request.getParameter("blInfo_inter_rmk");
            String releaseRemark = request.getParameter("releaseRemark");

            if (splitFlg.length() == 0) {
                splitFlg = "N";
            }

            event.setDoSplitFlg(splitFlg);

            if (interRmk.length() == 0) {
                interRmk = " ";
            }

            
            String refNm     = request.getParameter("blInfo_cstms_ref_nm");
            String refCtnt   = request.getParameter("blInfo_cstms_ref_ctnt");
            String asgnNm    = request.getParameter("blInfo_cstms_asgn_nm");
            String asgnCtnt  = request.getParameter("blInfo_cstms_asgn_ctnt");
            String evntFlag  = request.getParameter("evnt_flag");
            String hldFlg    = "";

            if ("R".equals(evntFlag)) {
                hldFlg = "Y";
            } else {
                hldFlg = "N";
            }          
            DoRlseVO doRlse = new DoRlseVO();

            doRlse.setBkgNo(event.getBkgNo());
//            doRlse.setBlNo(event.getBlNo());
            doRlse.setDoSplitFlg(splitFlg);
       
         
            doRlse.setCstmsRefNm(refNm);
            doRlse.setCstmsRefCtnt(refCtnt);
            doRlse.setCstmsAsgnNm(asgnNm);
            doRlse.setCstmsAsgnCtnt(asgnCtnt);
    
            doRlse.setInterRmk(interRmk);
            doRlse.setCgorRmk(releaseRemark);   
            doRlse.setDoHldFlg(hldFlg);
            
            event.setGenDoRlse(doRlse);
       
            event.setDoCntrs((DoCntrVO[])getVOs(request, DoCntrVO.class,"doRlseStsCntr_"));
//            event.setDoRlseSts((DoRlseStsVO[])getVOs(request, DoRlseStsVO.class,"doRlseStsBl_"));
            event.setGenBlInfos((GenDoBlInfoVO[])getVOs(request, GenDoBlInfoVO.class,"blInfo_"));
            

        }else if(command.isCommand(FormCommand.MULTI02)) {

            log.debug("===================================");
            log.debug("    CANCEL EVENT                   ");
            log.debug("===================================");

//            if (blNo.isEmpty() == false) {
//                strTemp = blNo.substring(blNo.length()-1);
//
//                if (strTemp.equals("W") || strTemp.equals("S")) {
//                    blNo = blNo.substring(0, blNo.length()-1);
//                }
//            }
//
//            String rlse_sts_cd = request.getParameter("rlse_sts_cd");
//
//            event.setBkgNo(bkgNo);
//            event.setBlNo(blNo);
//            event.setRlseStsCd(rlse_sts_cd);
//            if ("R".equals(rlse_sts_cd)) {
//                event.setResetFlg("N");
//            } else {
//                event.setResetFlg("Y");
//            }
//
//            event.setDoRlseSts((DoRlseStsVO[])getVOs(request, DoRlseStsVO.class,"doRlseSts_"));
            
            if (blNo.isEmpty() == false) {
                strTemp = blNo.substring(blNo.length()-1);

                if (strTemp.equals("W") || strTemp.equals("S")) {
                    blNo = blNo.substring(0, blNo.length()-1);
                }
            }



            String splitFlg = request.getParameter("refInfo_do_split_flg");

            String doNo = "";

//            DoCancelVO doCancel = new DoCancelVO();

            if ("Y".equals(splitFlg)) {
                event.setdoCntrRlseSts((EuDoCntrRlseStsVO[])getVOs(request, EuDoCntrRlseStsVO.class,"doRlseStsCntr_"));

                doNo = event.getdoCntrRlseSts()[0].getDoNo();
            } else {
                event.setEuDoRlseSts((EuDoRlseStsVO[])getVOs(request, EuDoRlseStsVO.class,"doRlseStsBl_"));

                doNo = event.getEuDoRlseSts()[0].getDoNo();
            }

            event.setBkgNo(bkgNo);
            event.setBlNo(blNo);
            event.setDoNo(doNo);
            event.setResetFlg("N");
            event.setRlseStsCd("'R','C'");
            event.setSplitFlg(splitFlg);

        }else if(command.isCommand(FormCommand.MULTI04)) {

            log.debug("===================================");
            log.debug("    HOLD EVENT                     ");
            log.debug("===================================");

            event.setEvntFlag(request.getParameter("evnt_flag"));
            event.setGenBlInfos((GenDoBlInfoVO[])getVOs(request, GenDoBlInfoVO.class,"blInfo_"));            
            
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