/*=========================================================
*Copyright(c) 2016 CyberLogitec

*@FileName       : ESM_BKG_0684HTMLAction.java
*@FileTitle      : Bangladesh Cargo Release (D/O)
*Open Issues     :
*Change history  :
*@LastModifyDate : 2016-04-21
*@LastModifier   : 김수현
*@LastVersion    : 1.0
* 2016.04.21 김수현
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.BlIssVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoBlInfoVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoCancelVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoCntrVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EuCstmsVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EuDoCntrRlseStsVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EuDoRlseStsVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EuDoRlseVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EuDoSaveVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.util.object.ObjectCloner;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.BkgDoRefVO;

/**
 * HTTP Parser<br>
 * - EU Cargo Release (D/O) 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CargoReleaseOrderMgtSC로 실행요청<br>
 * - CargoReleaseOrderMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author An Jin Eung
 * @see EsmBkg0684Event 참조
 * @since J2EE 1.4
 */

public class ESM_BKG_0684HTMLAction extends HTMLActionSupport {

    /**
     *
     */
    private static final long serialVersionUID = -3889119389133086344L;

    /**
     * ESM_BKG_0684HTMLAction 객체를 생성
     */
    public ESM_BKG_0684HTMLAction() {}

    /**
     * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
     * HttpRequst의 정보를 EsmBkg0684Event로 파싱하여 request에 셋팅<br>
     * @param request HttpServletRequest HttpRequest
     * @return Event Event interface를 구현한 객체
     * @exception HTMLActionException
     */
    public Event perform(HttpServletRequest request) throws HTMLActionException {

        FormCommand command = FormCommand.fromRequest(request);
        EsmBkg0684Event event = new EsmBkg0684Event();

        log.debug("===================================");
        log.debug("    ESM_BKG_0684HTMLAction Start   ");
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

            //EU D/O는 무조건 1값임
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

            String splitFlg = request.getParameter("refInfo_do_split_flg");
            String interRmk = request.getParameter("refInfo_inter_rmk");

            if (splitFlg.length() == 0) {
                splitFlg = "N";
            }

            event.setDoSplitFlg(splitFlg);

            if (interRmk.length() == 0) {
                interRmk = "";
            }

            String refNm     = request.getParameter("euCstmsInfo_cstms_ref_nm");
            String refCtnt   = request.getParameter("euCstmsInfo_cstms_ref_ctnt");
            String asgnNm    = request.getParameter("euCstmsInfo_cstms_asgn_nm");
            String asgnCtnt  = request.getParameter("euCstmsInfo_cstms_asgn_ctnt");
            String evntFlag  = request.getParameter("evnt_flag");
            String hldFlg    = "";

            if ("R".equals(evntFlag)) {
                hldFlg = "Y";
            } else {
                hldFlg = "N";
            }


            event.setRefInfos((BkgDoRefVO[])getVOs(request, BkgDoRefVO.class,"refInfo_"));
            event.setBlIssVOs((BlIssVO[])getVOs(request, BlIssVO.class,"blIss_"));
            event.setEuCstms((EuCstmsVO[])getVOs(request, EuCstmsVO.class,"euCstmsInfo_"));

            EuDoSaveVO euDoSave = new EuDoSaveVO();

            if(null != event.getRefInfos()){
                ObjectCloner.build(event.getRefInfos()[0], euDoSave);

            }

            euDoSave.setBkgNo(event.getBkgNo());
            euDoSave.setCstmsRefNm(refNm);
            euDoSave.setCstmsRefCtnt(refCtnt);
            euDoSave.setCstmsAsgnNm(asgnNm);
            euDoSave.setCstmsAsgnCtnt(asgnCtnt);
            euDoSave.setInterRmk(interRmk);
            euDoSave.setDoSplitFlg(event.getDoSplitFlg());
            euDoSave.setDoHldFlg(hldFlg);

            event.setEuDoSave(euDoSave);

            if(null != event.getRefInfos()){
                event.getRefInfos()[0].setBkgNo(bkgNo);
            }

            if(null != event.getBlIssVOs()){
                event.getBlIssVOs()[0].setBkgNo(bkgNo);
            }

        }else if(command.isCommand(FormCommand.MULTI01)) {

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

            String attrCtnt1 = request.getParameter("refInfo_attr_ctnt1");
            String attrCtnt2 = request.getParameter("refInfo_attr_ctnt2");
            String attrCtnt3 = request.getParameter("refInfo_attr_ctnt3");
            String attrCtnt4 = request.getParameter("refInfo_attr_ctnt4");
            String attrCtnt5 = request.getParameter("refInfo_attr_ctnt5");
            String attrCtnt6 = request.getParameter("refInfo_attr_ctnt6");

            String splitFlg = request.getParameter("refInfo_do_split_flg");
            String interRmk = request.getParameter("refInfo_inter_rmk");
            String releaseRemark = request.getParameter("releaseRemark");

            if (splitFlg.length() == 0) {
                splitFlg = "N";
            }

            event.setDoSplitFlg(splitFlg);

            if (interRmk.length() == 0) {
                interRmk = " ";
            }


            String refNm     = request.getParameter("euCstmsInfo_cstms_ref_nm");
            String refCtnt   = request.getParameter("euCstmsInfo_cstms_ref_ctnt");
            String asgnNm    = request.getParameter("euCstmsInfo_cstms_asgn_nm");
            String asgnCtnt  = request.getParameter("euCstmsInfo_cstms_asgn_ctnt");

            EuDoRlseVO euDoRlse = new EuDoRlseVO();

            euDoRlse.setBkgNo(event.getBkgNo());
            euDoRlse.setBlNo(event.getBlNo());
            euDoRlse.setDoSplitFlg(splitFlg);

            euDoRlse.setAttrCtnt1(attrCtnt1);
            euDoRlse.setAttrCtnt2(attrCtnt2);
            euDoRlse.setAttrCtnt3(attrCtnt3);
            euDoRlse.setAttrCtnt4(attrCtnt4);
            euDoRlse.setAttrCtnt5(attrCtnt5);
            euDoRlse.setAttrCtnt6(attrCtnt6);

            euDoRlse.setCstmsRefNm(refNm);
            euDoRlse.setCstmsRefCtnt(refCtnt);
            euDoRlse.setCstmsAsgnNm(asgnNm);
            euDoRlse.setCstmsAsgnCtnt(asgnCtnt);
            euDoRlse.setInterRmk(interRmk);
            euDoRlse.setCgorRmk(releaseRemark);

            event.setEuDoRlse(euDoRlse);
            event.setDoCntrs((DoCntrVO[])getVOs(request, DoCntrVO.class,"euDoRlseStsCntr_"));

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

            event.setBkgNo(bkgNo);
            event.setBlNo(blNo);

            String splitFlg = request.getParameter("refInfo_do_split_flg");

            String doNo = "";

            DoCancelVO doCancel = new DoCancelVO();

            if ("Y".equals(splitFlg)) {
                event.setEuDoCntrRlseSts((EuDoCntrRlseStsVO[])getVOs(request, EuDoCntrRlseStsVO.class,"euDoRlseStsCntr_"));

                doNo = event.getEuDoCntrRlseSts()[0].getDoNo();
            } else {
                event.setEuDoRlseSts((EuDoRlseStsVO[])getVOs(request, EuDoRlseStsVO.class,"euDoRlseStsBl_"));

                doNo = event.getEuDoRlseSts()[0].getDoNo();
            }


            doCancel.setBkgNo(bkgNo);
            doCancel.setDoNo(doNo);
            doCancel.setResetFlg("N");
            doCancel.setRlseStsCd("'R','C'");
            doCancel.setSplitFlg(splitFlg);

            event.setDoCancel(doCancel);

        }else if(command.isCommand(FormCommand.COMMAND03)) {

            log.debug("===================================");
            log.debug("    DOR/IF EVENT                   ");
            log.debug("===================================");

            event.setBlIssVOs((BlIssVO[])getVOs(request, BlIssVO.class,"blIss_"));
            event.setEuDoRlseSts((EuDoRlseStsVO[])getVOs(request, EuDoRlseStsVO.class,"euDoRlseSts_"));

        }else if(command.isCommand(FormCommand.MULTI03)) {

            log.debug("===================================");
            log.debug("    HOLD EVENT                     ");
            log.debug("===================================");

            event.setEvntFlag(request.getParameter("evnt_flag"));
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