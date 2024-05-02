/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0229_08HTMLAction.java
*@FileTitle : e-Booking & SI Process Detail(DANGER)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.25
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.06.25 전용진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.OpusDgVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterRqstNoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.DgCgoListVO;
import com.clt.framework.component.util.object.ObjectCloner;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 EBookingConductSC로 실행요청<br>
 * - EBookingConductSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Jun Yong Jin
 * @see EBookingConductEvent 참조
 * @since J2EE 1.6
 */

public class ESM_BKG_0229_08HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BKG_0229_08HTMLAction 객체를 생성
	 */
	public ESM_BKG_0229_08HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EBookingConductEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

    	FormCommand command = FormCommand.fromRequest(request);
		EsmBkg022908Event event = new EsmBkg022908Event();
		if (command.isCommand(FormCommand.DEFAULT))
		{
			event.setXterRqstNoVO((XterRqstNoVO) getVO(request, XterRqstNoVO.class));
		}
		else if (command.isCommand(FormCommand.SEARCH))
		{
			event.setXterRqstNoVO((XterRqstNoVO) getVO(request, XterRqstNoVO.class));
		}
		else if (command.isCommand(FormCommand.MULTI03))
		{
			// DG
			boolean bCntrCgoSeq = false;
			int iMaxDgCntrSeq = 0;
			OpusDgVO[] opusDgVOs = (OpusDgVO[]) getVOs(request, OpusDgVO.class, "t8sheet1_");
			int iDataCnt = 0;
			for (int i = 0; i < opusDgVOs.length; i++)
			{
				// 신규일때
				if ("I".equals(opusDgVOs[i].getIbflag()) || "U".equals(opusDgVOs[i].getIbflag()))
				{
					//
					if (!"".equals(opusDgVOs[i].getCntrNo()))
					{
						for (int j = 0; j < opusDgVOs.length; j++)
						{
							if (opusDgVOs[i].getCntrNo().equals(opusDgVOs[j].getCntrNo()))
							{
								opusDgVOs[i].setCntrCgoSeq((Integer.parseInt(opusDgVOs[j].getMaxCntrCgoSeq()) + 1) + "");
								opusDgVOs[j].setMaxCntrCgoSeq((Integer.parseInt(opusDgVOs[j].getMaxCntrCgoSeq()) + 1)
										+ "");
								opusDgVOs[i].setDgCntrSeq(opusDgVOs[j].getDgCntrSeq());
								bCntrCgoSeq = true;
								break;
							}
						}
						if (!bCntrCgoSeq)
						{
							opusDgVOs[i].setCntrCgoSeq("1");
							for (int j = 0; j < opusDgVOs.length; j++)
							{
								if (iMaxDgCntrSeq < Integer.parseInt(opusDgVOs[j].getMaxDgCntrSeq()))
								{
									iMaxDgCntrSeq = Integer.parseInt(opusDgVOs[j].getMaxDgCntrSeq());
								}
							}
							opusDgVOs[i].setDgCntrSeq((iMaxDgCntrSeq + 1) + "");
							bCntrCgoSeq = false;
						}
					}
					else
					{
						opusDgVOs[i].setCntrCgoSeq("1");
						for (int j = 0; j < opusDgVOs.length; j++)
						{
							if (!"".equals(opusDgVOs[j].getMaxDgCntrSeq())
									&& iMaxDgCntrSeq < Integer.parseInt(opusDgVOs[j].getMaxDgCntrSeq()))
							{
								iMaxDgCntrSeq = Integer.parseInt(opusDgVOs[j].getMaxDgCntrSeq());
								opusDgVOs[j].setMaxDgCntrSeq((iMaxDgCntrSeq + 1) + "");
							}
						}
						opusDgVOs[i].setDgCntrSeq((iMaxDgCntrSeq + 1) + "");
					}
					iDataCnt++;
				}
				else if ("D".equals(opusDgVOs[i].getIbflag()))
				{
					iDataCnt++;
				}
				if ("".equals(opusDgVOs[i].getGrsWgt()))
				{
					opusDgVOs[i].setGrsWgt("0");
				}
			}
			DgCgoListVO[] dgCgoListVOs = new DgCgoListVO[iDataCnt];
			for (int i = 0, j = 0; i < opusDgVOs.length; i++)
			{
				if (!"R".equals(opusDgVOs[i].getIbflag()))
				{
					dgCgoListVOs[j] = new DgCgoListVO();
					ObjectCloner.build(opusDgVOs[i], dgCgoListVOs[j]);
					dgCgoListVOs[j].setInImdgPckCd1("");
					dgCgoListVOs[j].setInImdgPckCd2("");
					dgCgoListVOs[j].setOutImdgPckCd1("");
					dgCgoListVOs[j].setOutImdgPckCd2("");
					j++;
				}
			}
			event.setDgCgoListVOs(dgCgoListVOs);
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