/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0680HTMLAction.java
*@FileTitle : Korea Cargo Release (D/O)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.12
*@LastModifier : 임진영
*@LastVersion : 1.0
* 2009.05.12 임진영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.BlIssVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoCntrVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoRlseStsVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.IdaDoRlseVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.IdaDoSaveVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.util.object.ObjectCloner;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.BkgDoRefVO;
import com.hanjin.syscommon.common.table.BkgDoVO;

/**
 * HTTP Parser<br>
 * - Korea Cargo Release (D/O) 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 InboundBLMgtSC로 실행요청<br>
 * - InboundBLMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Lim Jin Young
 * @see EsmBkg0680Event 참조
 * @since J2EE 1.4
 */

public class ESM_BKG_0680HTMLAction extends HTMLActionSupport {

    /**
     *
     */
    private static final long serialVersionUID = -3889119389133086344L;

    /**
     * ESM_BKG_0680HTMLAction 객체를 생성
     */
    public ESM_BKG_0680HTMLAction() {}

    /**
     * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
     * HttpRequst의 정보를 EsmBkg0680Event로 파싱하여 request에 셋팅<br>
     * @param request HttpServletRequest HttpRequest
     * @return Event Event interface를 구현한 객체
     * @exception HTMLActionException
     */
    public Event perform(HttpServletRequest request) throws HTMLActionException {

        FormCommand command = FormCommand.fromRequest(request);
        EsmBkg0680Event event = new EsmBkg0680Event();

        log.debug("===================================");
        log.debug("    ESM_BKG_0326HTMLAction Start   ");
        log.debug("===================================");

        /*****************************************************************
            변수 선언
        *****************************************************************/
        String bkgNo     = request.getParameter("bkg_no");     //선적예약 요청 번호
        String blNo      = request.getParameter("bl_no");      //선화증권 번호
        String demurType = request.getParameter("demur_type"); //Demurrage Type
	    String expDelDt  = JSPUtil.getNullNoTrim(request.getParameter("exp_del_dt")).replaceAll("-", ""); //Expect Delivery Date
        String oblCngFlg = request.getParameter("obl_cng_flg"); //OBL 변경 여부

        event.setBkgNo(bkgNo);
        event.setBlNo(blNo);
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

        event.setEvntFlag(request.getParameter("evnt_flag"));

        if(command.isCommand(FormCommand.SEARCH)) {
            log.debug("===================================");
            log.debug("    SEARCH EVENT                   ");
            log.debug("===================================");

        }else if(command.isCommand(FormCommand.MODIFY)) {

            log.debug("===================================");
            log.debug("    MODIFY EVENT                   ");
            log.debug("===================================");


            // added by Park mangeon
            IdaDoSaveVO idaDoSaveVO = new IdaDoSaveVO();

            event.setRefInfos((BkgDoRefVO[])getVOs(request, BkgDoRefVO.class,"refInfo_"));
            event.setBlIssVOs((BlIssVO[])getVOs(request, BlIssVO.class,"blIss_"));

            //BKG_DO_HIT 에 입력 할 파라메터 세팅
            event.setCrntCtnt(request.getParameter("blIss_obl_rdem_flg")); //Original B/L회수여부

            if(null != event.getRefInfos()){
                ObjectCloner.build(event.getRefInfos()[0], idaDoSaveVO);

            }

            if(null != event.getBlIssVOs()){
                event.getBlIssVOs()[0].setBkgNo(bkgNo);
            }

            idaDoSaveVO.setBkgNo(bkgNo);
//            idaDoSaveVO.setIdaDoYdCd(request.getParameter("ida_do_yd_cd"));
//            idaDoSaveVO.setIdaDoYdCd(event.getRefInfos()[0].getIdaDoYdCd());
            event.setIdaDoSave(idaDoSaveVO);


        }else if(command.isCommand(FormCommand.MULTI01)) {

            log.debug("===================================");
            log.debug("    Release                        ");
            log.debug("===================================");

            event.setBlIssVOs((BlIssVO[])getVOs(request, BlIssVO.class,"blIss_"));
            event.setDoRlseSts((DoRlseStsVO[])getVOs(request, DoRlseStsVO.class,"doRlseSts_"));
            event.setDoCntrs((DoCntrVO[])getVOs(request, DoCntrVO.class, "cntrRlseSts_"));
       
            IdaDoRlseVO idaDoRlse = new IdaDoRlseVO();
            ObjectCloner.build(event.getBlIssVOs()[0], idaDoRlse);
            // Cargo Release 시 F/O/C가 Clear 되지않은 상태일경우 별도 Remark를 입력한다. 
            idaDoRlse.setCgorRmk(request.getParameter("releaseRemark"));
  
            BkgDoRefVO[] bkgDoRefVOs = (BkgDoRefVO[])getVOs(request, BkgDoRefVO.class,"refInfo_");
            BkgDoVO[] bkgDoVO = (BkgDoVO[])getVOs(request, BkgDoVO.class,"refInfo_");  // refInfo_ida_do_vty_dt, refInfo_ida_do_dmdt_pay_tp_cd
            if (null != bkgDoRefVOs) {
            	idaDoRlse.setDoSplitFlg(bkgDoRefVOs[0].getDoSplitFlg());
            	idaDoRlse.setIdaImpGenMfNo(bkgDoRefVOs[0].getIdaImpGenMfNo());
            	idaDoRlse.setIdaCstmsAsgnLineNo(bkgDoRefVOs[0].getIdaCstmsAsgnLineNo());
            	idaDoRlse.setIdaCgorOrdYr(bkgDoRefVOs[0].getIdaCgorOrdYr());
            	idaDoRlse.setInterRmk(bkgDoRefVOs[0].getInterRmk());
            	idaDoRlse.setDoSplitFlg(bkgDoRefVOs[0].getDoSplitFlg());  // 20091125 mgpark
            	idaDoRlse.setDoHldFlg(bkgDoRefVOs[0].getDoHldFlg()); // 20091125 mgpark
            	idaDoRlse.setIdaDoYdCd(bkgDoRefVOs[0].getIdaDoYdCd()); //2011.08.02
            	event.setRefInfos(bkgDoRefVOs);

            }
           
            if (null != bkgDoVO) {
            	idaDoRlse.setIdaDoVtyDt(bkgDoVO[0].getIdaDoVtyDt());
            	idaDoRlse.setIdaDoDmdtPayTpCd(bkgDoVO[0].getIdaDoDmdtPayTpCd());
            }

           	idaDoRlse.setDoCngEvntCd(event.getDoCngEvntCd());

            idaDoRlse.setBkgNo(bkgNo);
            idaDoRlse.setBlNo(blNo);
            event.setIdaDoRlse(idaDoRlse);

        }else if(command.isCommand(FormCommand.MULTI02)) {

            log.debug("===================================");
            log.debug("    Hold                           ");
            log.debug("===================================");

            //event.setDoEventVOs((DoEventVO[])getVOs(request, DoEventVO.class,"blInfo_"));
            //event.setEvntFlag("H");
        }else if(command.isCommand(FormCommand.MULTI03)) {

            log.debug("===================================");
            log.debug("    Un- Hold                       ");
            log.debug("===================================");

            //event.setDoEventVOs((DoEventVO[])getVOs(request, DoEventVO.class,"blInfo_"));
            //event.setEvntFlag("R");
	    }else if(command.isCommand(FormCommand.REMOVE)) {
	    	
	    	log.debug("===================================");
	    	log.debug("    D/O Release 내역을 삭제 처리한다.  ");
	    	log.debug("===================================");
	    	
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