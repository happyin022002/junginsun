/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ESM_BKG_1168HTMLAction.java
*@FileTitle : ESM_BKG_1168
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.11
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2013.08.11 김보배
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.israel.event;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.israel.vo.IsraelManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.israel.vo.IsraelManifestListCondVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;
 
/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.bkg.customsdeclaration 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CustomsDeclarationSC로 실행요청<br>
 * - CustomsDeclarationSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author BOBAE KIM
 * @see CustomsDeclarationEvent 참조
 * @since J2EE 1.4
 */

public class ESM_BKG_1168HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BKG_1141HTMLAction 객체를 생성 
	 */
	public ESM_BKG_1168HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 CustomsDeclarationEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		FormCommand command = FormCommand.fromRequest(request);
    	EsmBkg1168Event event = new EsmBkg1168Event();
		 
		if( command.isCommand(FormCommand.SEARCH) 
				|| command.isCommand(FormCommand.SEARCH01)
				){
			event.setManifestListCondVO((IsraelManifestListCondVO) getVO(request, IsraelManifestListCondVO.class));
		} else if( command.isCommand(FormCommand.MULTI) ){
			
			event.setIsraelManifestTransmitVOs((IsraelManifestTransmitVO[])getVOs(request, IsraelManifestTransmitVO.class));
			
//			MalaysiaManifestListCondVO malaysiaManifestListCondVO = (MalaysiaManifestListCondVO) getVO(request,MalaysiaManifestListCondVO.class);
//			MalaysiaManifestListBlInfoVO[] malaysiaManifestListBlInfoVOs = (MalaysiaManifestListBlInfoVO[]) getVOs(request,MalaysiaManifestListBlInfoVO.class, "sheet1_");
//			MalaysiaManifestListCntrInfoVO[] malaysiaManifestListCntrInfoVOs = (MalaysiaManifestListCntrInfoVO[]) getVOs(request,MalaysiaManifestListCntrInfoVO.class, "sheet2_");
//			
//			List<MalaysiaManifestListBlInfoVO> MalaysiaBlList = new ArrayList<MalaysiaManifestListBlInfoVO>();
//			List<MalaysiaManifestListCntrInfoVO> MalaysiaCntrList = new ArrayList<MalaysiaManifestListCntrInfoVO>();
//			
//			if( malaysiaManifestListBlInfoVOs != null )
//			{
//				for( int i = 0; i < malaysiaManifestListBlInfoVOs.length; i++ )
//				{
//					MalaysiaBlList.add(malaysiaManifestListBlInfoVOs[i]);
//				}
//			}
//			if( malaysiaManifestListCntrInfoVOs != null )
//			{
//				for( int i = 0; i < malaysiaManifestListCntrInfoVOs.length; i++ )
//				{
//					MalaysiaCntrList.add(malaysiaManifestListCntrInfoVOs[i]);
//				}
//			}
//			MalaysiaManifestTransmitVO malaysiaManifestTransmitVOs[] = new MalaysiaManifestTransmitVO[1];
//			malaysiaManifestTransmitVOs[0] = new MalaysiaManifestTransmitVO();
//			
//			malaysiaManifestTransmitVOs[0].setMalaysiaManifestListCondVO(malaysiaManifestListCondVO);
//			malaysiaManifestTransmitVOs[0].setMalaysiaManifestListBlInfoVOs(MalaysiaBlList);
//			malaysiaManifestTransmitVOs[0].setMalaysiaManifestListCntrInfoVOs(MalaysiaCntrList);
//			event.setManifestTransmitVOs(malaysiaManifestTransmitVOs);
			
//			//event.setManifestTransmitVOs((MalaysiaManifestTransmitVO[]) getVOs(request, MalaysiaManifestTransmitVO.class,""));

		} else if( command.isCommand(FormCommand.SEARCH02) ){
			// BackEndJob 으로 돌린 후 결과코드 조회
			event.setKey(request.getParameter("key"));
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
