/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0210HTMLAction.java
*@FileTitle : Customs Data Download
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.19
*@LastModifier : 이수빈
*@LastVersion : 1.0
* 2009.05.19 이수빈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.CndCstmsMfListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.CndManifestModificationVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaDownloadSummaryVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaManifestListDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.clt.framework.component.util.JSPUtil;
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
 * @author Lee Subin
 * @see CustomsDeclarationEvent 참조
 * @since J2EE 1.4
 */

public class ESM_BKG_0210HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BKG_0210HTMLAction 객체를 생성
	 */
	public ESM_BKG_0210HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 CustomsDeclarationEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmBkg0210Event event = new EsmBkg0210Event();
		
		//US와 CA가 같은 화면을 사용하기때문에 나라세팅 SC에서 분기해서 비지니스로직 수행
		event.setCustoms(request.getParameter("customs"));
		if(command.isCommand(FormCommand.SEARCH)) {
			ManifestListCondVO condVO = new ManifestListCondVO();
			if (event.getCustoms().endsWith("CA")) {
				condVO = (ManifestListCondVO)getVO(request, CndCstmsMfListCondVO.class);	
			} else {
				condVO = (ManifestListCondVO)getVO(request, UsaManifestListCondVO.class);
			}
			condVO.setPgmNo("ESM_BKG_0210");
			event.setManifestListCondVO(condVO);

		}
		else if(command.isCommand(FormCommand.ADD)||command.isCommand(FormCommand.MULTI05)) {
			ManifestListDetailVO[] detailVOs = null;			
			if (event.getCustoms().endsWith("CA")) {
				detailVOs = (ManifestListDetailVO[])getVOs(request, CndManifestModificationVO.class);
			} else {
				UsaManifestListDetailVO[] usVO = (UsaManifestListDetailVO[]) getVOs(request,
						UsaManifestListDetailVO.class);
				for (int i = 0; i < usVO.length; i++)
				{
					usVO[i].setIbflag(JSPUtil.getNull(request.getParameter("act_file_skd_dir_cd")));
				}
				detailVOs = usVO;
			}
			detailVOs[0].setPgmNo("ESM_BKG_0210");
			event.setManifestListDetailVOs(detailVOs);
		}
		else if(command.isCommand(FormCommand.MULTI)) {			
//			if (event.getCustoms().endsWith(CountryCode.US)) {
				UsaDownloadSummaryVO[] summaryVOs = (UsaDownloadSummaryVO[])getVOs(request, UsaDownloadSummaryVO.class);
				UsaManifestListDetailVO[] detailVOs = new UsaManifestListDetailVO[1];
				detailVOs[0] = new UsaManifestListDetailVO();
				detailVOs[0].setUsaDownloadSummaryVOs(summaryVOs);
				event.setManifestListDetailVOs(detailVOs);
//			}
		}
		else if (command.isCommand(FormCommand.SEARCH03)) {
			//BackEndJob 으로 돌린 후 결과코드 조회
			event.setKey(request.getParameter("key"));
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