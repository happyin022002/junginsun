/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_0371HTMLAction.java
 *@FileTitle : ESM_BKG_0371HTMLAction
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.11
 *@LastModifier : 박상훈
 *@LastVersion : 1.0
 * 2009.06.11 박상훈
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorMrnCreateInfoCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorMrnCreateInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorMrnMsnCreateCondVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.bkg.customsdeclaration 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CustomsDeclarationSC로 실행요청<br>
 * - CustomsDeclarationSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * 
 * @author Kyoung Jong Yun
 * @see EsmBkg0371Event 참조
 * @since J2EE 1.6
 */
public class ESM_BKG_0371HTMLAction extends HTMLActionSupport 
{

	private static final long serialVersionUID = 1L;

	public ESM_BKG_0371HTMLAction() {}
	
	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 CustomsDeclarationEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	@Override
	public Event perform(HttpServletRequest request) throws HTMLActionException 
	{
		FormCommand command = FormCommand.fromRequest(request);
		EsmBkg0371Event event = new EsmBkg0371Event();

		if (command.isCommand(FormCommand.SEARCH)) 
		{
			// MRN 조회
			KorMrnCreateInfoCondVO mrnCreateInfoCondVO = (KorMrnCreateInfoCondVO)getVO(request, KorMrnCreateInfoCondVO.class);
			event.setKorMrnCreateInfoCondVO(mrnCreateInfoCondVO);
		}else if (command.isCommand(FormCommand.MULTI))
		{
			// MRN SAVE
			KorMrnCreateInfoVO[] mrnCreateInfoVOs = (KorMrnCreateInfoVO[])getVOs(request, KorMrnCreateInfoVO.class);
			event.setKorMrnCreateInfoVOs(mrnCreateInfoVOs);
		}else if (command.isCommand(FormCommand.REMOVE))
		{
			// MRN DELETE
			KorMrnCreateInfoVO[] korMrnMsnCreateVOs = (KorMrnCreateInfoVO[])getVOs(request, KorMrnCreateInfoVO.class);
			event.setKorMrnCreateInfoVOs(korMrnMsnCreateVOs);
		}else if (command.isCommand(FormCommand.COMMAND01)){
			KorMrnCreateInfoVO mrnCreateInfoVO = (KorMrnCreateInfoVO)getVO(request,KorMrnCreateInfoVO.class);
			event.setKorMrnCreateInfoVO(mrnCreateInfoVO);
		}else if (command.isCommand(FormCommand.COMMAND02))
		{
			// MRN SAVE
			KorMrnCreateInfoVO[] mrnCreateInfoVOs = (KorMrnCreateInfoVO[])getVOs(request, KorMrnCreateInfoVO.class);
			event.setKorMrnCreateInfoVOs(mrnCreateInfoVOs);
		}
		
		
		request.setAttribute("Event", event);

		return event;
	}
}
