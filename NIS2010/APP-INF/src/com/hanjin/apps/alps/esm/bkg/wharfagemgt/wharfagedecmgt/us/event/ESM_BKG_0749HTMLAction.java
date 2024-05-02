/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_0749HTMLAction.java
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
 * @see EsmBkg0749Event 참조
 * @since J2EE 1.4
 */
public class ESM_BKG_0749HTMLAction extends HTMLActionSupport {
	private static final long serialVersionUID = 1L;

	/**
	 * ESM_BKG_0749HTMLAction 객체를 생성
	 */
	public ESM_BKG_0749HTMLAction() {
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
		EsmBkg0749Event event = new EsmBkg0749Event();
		if (command.isCommand(FormCommand.SEARCH) || command.isCommand(FormCommand.COMMAND01))
		{
			event.setUsWhfSendCondVO((UsWhfSendCondVO) getVO(request, UsWhfSendCondVO.class));
		}
		else if (command.isCommand(FormCommand.SEARCH02))
		{
			event.setKey(request.getParameter("key"));
		}
		else if (command.isCommand(FormCommand.MULTI) || command.isCommand(FormCommand.MODIFY01)
				|| command.isCommand(FormCommand.MODIFY02))
		{
			// BKG_USA_WHF_SND
			BkgUsaWhfSndVO bkgUsaWhfSndVO = (BkgUsaWhfSndVO) getVO(request, BkgUsaWhfSndVO.class);
			// BKG_USA_WHF_BLK_CGO
			BkgUsaWhfBlkCgoVO[] bkgUsaWhfBlkCgoVOs = (BkgUsaWhfBlkCgoVO[]) getVOs(request, BkgUsaWhfBlkCgoVO.class);
			List<BkgUsaWhfBlkCgoVO> listBkgUsaWhfBlkCgoVO = new ArrayList<BkgUsaWhfBlkCgoVO>();
			// BKG_USA_WHF_SND_HIS
			BkgUsaWhfSndHisVO[] bkgUsaWhfSndHisVOs = (BkgUsaWhfSndHisVO[]) getVOs(request, BkgUsaWhfSndHisVO.class,
					"sheet4_");
			List<BkgUsaWhfSndHisVO> listBkgUsaWhfSndHisVO = new ArrayList<BkgUsaWhfSndHisVO>();
			if (bkgUsaWhfBlkCgoVOs != null && bkgUsaWhfBlkCgoVOs.length > 0)
			{
				for (int i = 0; i < bkgUsaWhfBlkCgoVOs.length; i++)
				{
					bkgUsaWhfBlkCgoVOs[i].setVslCd(bkgUsaWhfSndVO.getVslCd());
					bkgUsaWhfBlkCgoVOs[i].setSkdVoyNo(bkgUsaWhfSndVO.getSkdVoyNo());
					bkgUsaWhfBlkCgoVOs[i].setSkdDirCd(bkgUsaWhfSndVO.getSkdDirCd());
					bkgUsaWhfBlkCgoVOs[i].setIoBndCd(bkgUsaWhfSndVO.getIoBndCd());
					bkgUsaWhfBlkCgoVOs[i].setPortCd(bkgUsaWhfSndVO.getPortCd());
					listBkgUsaWhfBlkCgoVO.add(bkgUsaWhfBlkCgoVOs[i]);
				}
			}
			if (bkgUsaWhfSndHisVOs != null && bkgUsaWhfSndHisVOs.length > 0)
			{
				for (int i = 0; i < bkgUsaWhfSndHisVOs.length; i++)
				{
					bkgUsaWhfSndHisVOs[i].setVslCd(bkgUsaWhfSndVO.getVslCd());
					bkgUsaWhfSndHisVOs[i].setSkdVoyNo(bkgUsaWhfSndVO.getSkdVoyNo());
					bkgUsaWhfSndHisVOs[i].setSkdDirCd(bkgUsaWhfSndVO.getSkdDirCd());
					bkgUsaWhfSndHisVOs[i].setIoBndCd(bkgUsaWhfSndVO.getIoBndCd());
					bkgUsaWhfSndHisVOs[i].setPortCd(bkgUsaWhfSndVO.getPortCd());
					if (bkgUsaWhfSndHisVOs[i].getNtcViaCd().startsWith("F"))
					{
						bkgUsaWhfSndHisVOs[i].setCntcFaxNo(bkgUsaWhfSndHisVOs[i].getCntcEml());
						bkgUsaWhfSndHisVOs[i].setCntcEml("");
						bkgUsaWhfSndHisVOs[i].setNtcViaCd("F");
					}
					else
					{
						bkgUsaWhfSndHisVOs[i].setCntcFaxNo("");
						bkgUsaWhfSndHisVOs[i].setCntcEml(bkgUsaWhfSndHisVOs[i].getCntcEml());
						bkgUsaWhfSndHisVOs[i].setNtcViaCd("M");
					}
					// 조회조건 rail include를 담을 곳이 마땅치 않음.
					bkgUsaWhfSndHisVOs[i].setIbflag(request.getParameter("type_rail"));
					listBkgUsaWhfSndHisVO.add(bkgUsaWhfSndHisVOs[i]);
				}
			}
			UsWhfSendVO usWhfSendVO = new UsWhfSendVO();
			usWhfSendVO.setBkgUsaWhfSndVO(bkgUsaWhfSndVO);
			usWhfSendVO.setBkgUsaWhfBlkCgoVOs(listBkgUsaWhfBlkCgoVO);
			usWhfSendVO.setBkgUsaWhfSndHisVOs(listBkgUsaWhfSndHisVO);
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
