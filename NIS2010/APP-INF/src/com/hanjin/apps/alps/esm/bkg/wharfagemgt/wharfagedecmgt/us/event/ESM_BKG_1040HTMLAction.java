/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_1040HTMLAction.java
 *@FileTitle : UsWharfageDecMgt
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.31
 *@LastModifier : 김민정
 *@LastVersion : 1.0
 * 2009.05.20 김민정
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.us.event;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.us.vo.UsWhfSendCondVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.us.vo.UsWhfSendQtyVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.us.vo.UsWhfSendVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.BkgUsaWhfBlkCgoVO;
import com.hanjin.syscommon.common.table.BkgUsaWhfSndHisVO;
import com.hanjin.syscommon.common.table.BkgUsaWhfSndVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.bkg.wharfagemgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 WharFageMgtSC로 실행요청<br>
 * - WharfageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * 
 * @author Kim Min Jeong
 * @see EsmBkg1040Event 참조
 * @since J2EE 1.4
 */
public class ESM_BKG_1040HTMLAction extends HTMLActionSupport {
	private static final long serialVersionUID = 1L;

	/**
	 * ESM_BKG_1040HTMLAction 객체를 생성
	 */
	public ESM_BKG_1040HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 WharfageEvent로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		FormCommand command = FormCommand.fromRequest(request);
		EsmBkg1040Event event = new EsmBkg1040Event();
		if (command.isCommand(FormCommand.SEARCH) || command.isCommand(FormCommand.COMMAND01))
		{
			event.setUsWhfSendCondVO((UsWhfSendCondVO) getVO(request, UsWhfSendCondVO.class));
		}
		else if (command.isCommand(FormCommand.SEARCH02))
		{
			event.setKey(request.getParameter("key"));
		}
		else if (command.isCommand(FormCommand.MULTI) || command.isCommand(FormCommand.MODIFY01))
		{
			// BKG_USA_WHF_SND
			BkgUsaWhfSndVO bkgUsaWhfSndVO = (BkgUsaWhfSndVO) getVO(request, BkgUsaWhfSndVO.class);
			// BKG_USA_WHF_SND_HIS
			BkgUsaWhfSndHisVO[] bkgUsaWhfSndHisVOs = (BkgUsaWhfSndHisVO[]) getVOs(request, BkgUsaWhfSndHisVO.class,
					"sheet2_");
			List<BkgUsaWhfSndHisVO> listBkgUsaWhfSndHisVO = new ArrayList<BkgUsaWhfSndHisVO>();
			if (bkgUsaWhfSndHisVOs != null && bkgUsaWhfSndHisVOs.length > 0)
			{
				for (int i = 0; i < bkgUsaWhfSndHisVOs.length; i++)
				{
					bkgUsaWhfSndHisVOs[i].setVslCd(bkgUsaWhfSndVO.getVslCd());
					bkgUsaWhfSndHisVOs[i].setSkdVoyNo(bkgUsaWhfSndVO.getSkdVoyNo());
					bkgUsaWhfSndHisVOs[i].setSkdDirCd(bkgUsaWhfSndVO.getSkdDirCd());
					bkgUsaWhfSndHisVOs[i].setIoBndCd(bkgUsaWhfSndVO.getIoBndCd());
					bkgUsaWhfSndHisVOs[i].setPortCd(bkgUsaWhfSndVO.getPortCd());
					bkgUsaWhfSndHisVOs[i].setNtcViaCd("E");
					listBkgUsaWhfSndHisVO.add(bkgUsaWhfSndHisVOs[i]);
				}
			}
			// BKG_USA_WHF_SND_QTY
			UsWhfSendQtyVO[] usWhfSendQtyVOs = (UsWhfSendQtyVO[]) getVOs(request, UsWhfSendQtyVO.class, "sheet1_");
			List<UsWhfSendQtyVO> listUsWhfSendQtyVO = new ArrayList<UsWhfSendQtyVO>();
			if (usWhfSendQtyVOs != null && usWhfSendQtyVOs.length > 0)
			{
				for (int i = 0; i < usWhfSendQtyVOs.length; i++)
				{
					listUsWhfSendQtyVO.add(usWhfSendQtyVOs[i]);
				}
			}
			UsWhfSendVO usWhfSendVO = new UsWhfSendVO();
			usWhfSendVO.setBkgUsaWhfSndVO(bkgUsaWhfSndVO);
			usWhfSendVO.setBkgUsaWhfSndHisVOs(listBkgUsaWhfSndHisVO);
			usWhfSendVO.setUsWhfSendQtyVOs(listUsWhfSendQtyVO);
			usWhfSendVO.setBkgUsaWhfBlkCgoVOs(new ArrayList<BkgUsaWhfBlkCgoVO>());
			event.setUsWhfSendVO(usWhfSendVO);
		}
		request.setAttribute("Event", event);
		return event;
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