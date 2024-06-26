/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_0030HTMLAction.java
 *@FileTitle : ESM_BKG_0030HTMLAction
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

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorAmdFormVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorManifestListCondVO;
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
 * @see EsmBkg0030Event 참조
 * @since J2EE 1.6
 */
public class ESM_BKG_0030HTMLAction extends HTMLActionSupport 
{

	private static final long serialVersionUID = 1L;

	public ESM_BKG_0030HTMLAction() {}
	
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
		EsmBkg0030Event event = new EsmBkg0030Event();

		if (command.isCommand(FormCommand.SEARCH)) 
		{
			// 조회
			KorManifestListCondVO korManifestListCondVO = (KorManifestListCondVO)getVO(request, KorManifestListCondVO.class);
			event.setKorManifestListCondVO(korManifestListCondVO);
		}else if (command.isCommand(FormCommand.SEARCH03)) {
    		// Print 를 위한 조회
    		KorAmdFormVO[] condVOs = (KorAmdFormVO[])getVOs(request, KorAmdFormVO.class);
    		event.setKorAmdFormVOs(condVOs);
    	}
		
		request.setAttribute("Event", event);

		return event;
	}
}
