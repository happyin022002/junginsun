/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UI_GEM_0010HTMLAction.java
*@FileTitle : Expense Code Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.21
*@LastModifier : 최정미
*@LastVersion : 1.0
* 2009.04.21 최정미
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.vo.GemXchRtVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * [CPS_GEM-0009] Foreign Exchange Rate Maintenance
 * HTTP Parser<br>
 * - com.hanjin.apps.nis2010.esm.gae.gaecommon 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 GEMCommonSC로 실행요청<br>
 * - GEMCommonSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author choijungmi
 * @see GEMCommonEvent 참조
 * @since J2EE 1.4
 */

public class CPS_GEM_0009HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	
	/**
	 * CPS_GEM_0009HTMLAction 객체를 생성
	 */
	public CPS_GEM_0009HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 GEMCommonEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		FormCommand command = FormCommand.fromRequest(request);
		CpsGem0009Event event = new CpsGem0009Event();
		
		
		if(command.isCommand(FormCommand.SEARCHLIST) ||
				command.isCommand(FormCommand.SEARCHLIST01) ) {			
			GemXchRtVO vo = (GemXchRtVO)getVO(request, GemXchRtVO.class);
			
			String deltFlg = vo.getDeltFlg();			
			if (deltFlg == null || deltFlg.equals("")) {
				vo.setDeltFlg("N");
			}			
			event.setGemXchRtVO(vo);
		} else if(command.isCommand(FormCommand.MULTI)) {
			
			GemXchRtVO vo = (GemXchRtVO)getVO(request, GemXchRtVO.class);
			vo.onDataFormat();
			
			String year = vo.getAcctXchRtYrmon();			
			year = year + "00";
			
			String usdKrwXchRt  = vo.getUsdKrwXchRt();

			//삭제 인경우   Deleted Data가 체크되어 있는경우 N 그외의 경우 Y으로 설정 토글 기능  
			String deltFlg = vo.getDeltFlg();			
			if (deltFlg == null || deltFlg.equals("")) {
				deltFlg = "Y";
			} else {
				deltFlg = "N";
			}
			
			//년도  설정 
			GemXchRtVO[] vos = (GemXchRtVO[])getVOs(request, GemXchRtVO.class,"");			
			for (int i = 0; i < vos.length; i++) {
				GemXchRtVO gemXchRtVO = vos[i];
				gemXchRtVO.setAcctXchRtYrmon(year);
				gemXchRtVO.setUsdKrwXchRt(usdKrwXchRt);
				gemXchRtVO.setDeltFlg(deltFlg);
			}
			
			event.setGemXchRtVOs(vos);
			
		//엑셀업로드 후 	
		} else if(command.isCommand(FormCommand.SEARCHLIST02) ) {
			String inCurrCd = request.getParameter("inCurrCd");
			event.setInCurrCd(inCurrCd);
		// curr_cd check 	
		} else if(command.isCommand(FormCommand.SEARCHLIST03) ) {
			GemXchRtVO vo = (GemXchRtVO)getVO(request, GemXchRtVO.class);			
			event.setGemXchRtVO(vo);
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