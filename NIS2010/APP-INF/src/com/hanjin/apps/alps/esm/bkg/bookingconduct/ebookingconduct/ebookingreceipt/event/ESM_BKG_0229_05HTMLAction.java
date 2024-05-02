/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0229_05HTMLAction.java
*@FileTitle : e-Booking & SI Process Detail(C/M)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.17
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.06.17 전용진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterRqstNoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CmBkgInfoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CmVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.BkgCntrMfDescVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 EBookingConductSC로 실행요청<br>
 * - EBookingConductSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Jun Yong Jin
 * @see EBookingConductEvent 참조
 * @since J2EE 1.6
 */

public class ESM_BKG_0229_05HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BKG_0229_05HTMLAction 객체를 생성
	 */
	public ESM_BKG_0229_05HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EBookingConductEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

    	FormCommand command = FormCommand.fromRequest(request);
		EsmBkg022905Event event = new EsmBkg022905Event();


		if(command.isCommand(FormCommand.DEFAULT)) {
			event.setXterRqstNoVO((XterRqstNoVO)getVO(request, XterRqstNoVO .class));
		} else if(command.isCommand(FormCommand.SEARCH)) {
			event.setXterRqstNoVO((XterRqstNoVO)getVO(request, XterRqstNoVO .class));
        } else if(command.isCommand(FormCommand.MULTI)) {
            CmBkgInfoVO vo1 = (CmBkgInfoVO) getVO(request, CmBkgInfoVO.class);
            log.debug("======================================================\n" + vo1.getColumnValues());
//            CmCntrInfoVO[] vo2 = (CmCntrInfoVO[]) getVOs(request, CmCntrInfoVO.class, "sheet1_");
//            BkgCntrMfDescVO[] vo3 = (BkgCntrMfDescVO[]) getVOs(request, BkgCntrMfDescVO.class, "sheet2_");
            BkgCntrMfDescVO[] vo3 = (BkgCntrMfDescVO[]) getVOs(request, BkgCntrMfDescVO.class, "sheet1_");

            CmVO cmVO = new CmVO();
            cmVO.setCmBkgInfoVO(vo1);
//            cmVO.setCmCntrInfoVOs(getCmCntrInfoVOList(vo2));
            cmVO.setCntrMfDescVOs(getBkgCntrMfDescVOList(vo3));

            event.setCmVO(cmVO);
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


    /**
     *
     * @param vos
     * @return
     */
/*    private List<CmCntrInfoVO> getCmCntrInfoVOList(CmCntrInfoVO[] vos){
        List<CmCntrInfoVO> list = new ArrayList<CmCntrInfoVO>();
        int len = (vos == null) ? 0 : vos.length;
        for(int i=0;i<len; i++){
            list.add(vos[i]);
        }
        return list;
    }*/

    /**
     *
     * @param vos
     * @return
     */
    private List<BkgCntrMfDescVO> getBkgCntrMfDescVOList(BkgCntrMfDescVO[] vos){
        List<BkgCntrMfDescVO> list = new ArrayList<BkgCntrMfDescVO>();
        int len = (vos == null) ? 0 : vos.length;
        for(int i=0;i<len; i++){
            list.add(vos[i]);
        }
        return list;
    }
}