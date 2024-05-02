/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0490HTMLAction.java
*@FileTitle : ESM_BKG-0490
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.03
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.05.27 임재택
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.srilanka.vo.SriLankaManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.vo.SriLankaManifestListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.hanjin.framework.component.util.object.ObjectCloner;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
 
/**
 * HTTP Parser<br>
 * - com.hanjin.apps.nis2010.esm.bkg.customsdeclaration 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CustomsDeclarationSC로 실행요청<br>
 * - CustomsDeclarationSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author LIM JAE TAEK
 * @see CustomsDeclarationEvent 참조
 * @since J2EE 1.4
 */

public class ESM_BKG_0490HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BKG_0490HTMLAction 객체를 생성 
	 */
	public ESM_BKG_0490HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 CustomsDeclarationEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		FormCommand command = FormCommand.fromRequest(request);
		EsmBkg0490Event event = new EsmBkg0490Event();
		
		ManifestListCondVO manifestListCondVO = new SriLankaManifestListCondVO(); 
		 
		
		if(command.isCommand(FormCommand.SEARCH)) 
		{
			manifestListCondVO = (SriLankaManifestListCondVO)getVO(request, SriLankaManifestListCondVO.class);
			event.setPgNO(request.getParameter("pgNo"));
			event.setSriLankaManifestListCondVO((SriLankaManifestListCondVO)manifestListCondVO);
		} 
		if(command.isCommand(FormCommand.MULTI)) 
		{ 	
			//manifestListCondVOs = (SrilankaManifestTransmitVO[])getVOs(request, SrilankaManifestTransmitVO.class,"sheet1_");
			
			if ( "0".equals(request.getParameter("beforetab"))) {
				manifestListCondVO = (SriLankaManifestListCondVO)getVO(request, SriLankaManifestListCondVO.class);
				event.setSriLankaManifestTransmitVOS((SriLankaManifestTransmitVO[])getVOs(request, SriLankaManifestTransmitVO.class,"sheet1_"));
				event.setSriLankaManifestListCondVO((SriLankaManifestListCondVO)manifestListCondVO);
			} else {
				SriLankaManifestTransmitVO[] sriLankaManifestTransmitVO = (SriLankaManifestTransmitVO[])getVOs(request, SriLankaManifestTransmitVO.class,"sheet1_");
				manifestListCondVO = (SriLankaManifestListCondVO)getVO(request, SriLankaManifestListCondVO.class);
				event.setSriLankaManifestListCondVO((SriLankaManifestListCondVO)manifestListCondVO);
		        SriLankaManifestTransmitVO[] SriLankaList = new SriLankaManifestTransmitVO[sriLankaManifestTransmitVO.length];
		           SriLankaManifestTransmitVO sriLankaVo = null;
		           
		           StringBuffer cntrNo = new StringBuffer();
		           StringBuffer blNo = new StringBuffer();
		           int k = 0 ;
		           String beforeBlNo = "";
		           
		           for (int i=0; i<sriLankaManifestTransmitVO.length; i++) {

		                     if ( "".equals(beforeBlNo)) blNo.append(sriLankaManifestTransmitVO[i].getBlNo());
		                                
		                     if ( !"".equals(beforeBlNo) && !beforeBlNo.equals(sriLankaManifestTransmitVO[i].getBlNo())) {
		                                k = k + 1;
		                                cntrNo = new StringBuffer();
		                                blNo = new StringBuffer();
		                                blNo.append(sriLankaManifestTransmitVO[i].getBlNo());
		                     }
		                     cntrNo.append(sriLankaManifestTransmitVO[i].getCntrNo()+",");
		                     
		                     sriLankaVo = new SriLankaManifestTransmitVO();
		                     
		                     ObjectCloner.build(sriLankaManifestTransmitVO[i], sriLankaVo);
		                     
		                     sriLankaVo.setCntrNo(cntrNo.toString());
//		                     sriLankaVo.setBlNo(blNo.toString());
//		                     sriLankaVo.setEdiMtRemoval(sriLankaManifestTransmitVO[i].getEdiMtRemoval());
//		                     sriLankaVo.setVslCd(sriLankaManifestTransmitVO[i].getEdiMtRemoval());
//		                     sriLankaVo.setSkdVoyNo(sriLankaManifestTransmitVO[i].getSkdVoyNo());
//		                     sriLankaVo.setSkdDirCd(sriLankaManifestTransmitVO[i].getSkdDirCd());
//		                     sriLankaVo.setVvdNumber(sriLankaManifestTransmitVO[i].getVvdNumber());
		                     
		                     beforeBlNo = sriLankaManifestTransmitVO[i].getBlNo();
		                     
		                     SriLankaList[k] = sriLankaVo;
		           }
		           event.setSriLankaManifestTransmitVOS(SriLankaList);

			}
			
			
			//event.setSrilankaManifestTransmitVOS(manifestListCondVOs);
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
