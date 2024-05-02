/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_PRD_0080HTMLAction.java
*@FileTitle : ProductCatalogCreate
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.22
*@LastModifier : 정선용
*@LastVersion : 1.0
* 2009.08.22 정선용
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdCreateParamVO;
import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdQuantityVO;
import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdSearchParamVO;
import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdSubQuantityVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import java.util.Enumeration;
import java.util.Map;
import org.apache.log4j.Priority;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.prd.productcatalogcreate 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ProductCatalogCreateSC로 실행요청<br>
 * - ProductCatalogCreateSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author sun yong Jung
 * @see ProductCatalogCreateEvent 참조
 * @since J2EE 1.6
 */

public class ESD_PRD_0080HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESD_PRD_0080HTMLAction 객체를 생성
	 */
	public ESD_PRD_0080HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ProductCatalogCreateEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsdPrd0080Event event = new EsdPrd0080Event();
		event.setAttribute("pgmNo", request.getServletPath().substring(1,13));
		log.debug("\n\n ESD_PRD_0080HTMLAction-------------------------------------------------------");
		log.debug("\n\n f_cmf:");

//		if(command.isCommand(FormCommand.SEARCHLIST)) {
			event.setPrdCreateParamVO ((PrdCreateParamVO)getVO(request, PrdCreateParamVO.class ));
			event.setPrdQuantityVOs((PrdQuantityVO[])getVOs(request, PrdQuantityVO.class ,"") );
			event.setPrdSubQuantityVOs((PrdSubQuantityVO[])getVOs(request, PrdSubQuantityVO.class ,"") );
			

			if(log.isDebugEnabled()){
				StringBuilder sb = new StringBuilder();
				Map vo1 = event.getPrdCreateParamVO().getColumnValues();
				sb.append("\r▶ ▶▶▶ bkg parameter ▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶");
				sb.append("\r▶ noh prdCreateParamVO ▶ "+vo1.toString());
				sb.append("\r▶ ");

				PrdQuantityVO[] vo2s = event.getPrdQuantityVOs();
				if(vo2s != null ){
					for (int i = 0; i < vo2s.length; i++) {
						Map vo2 = vo2s[i].getColumnValues();
						sb.append("\r▶ noh prdQuantityVO ▶ "+vo2.toString());
					}					
				}

				sb.append("\r▶ ");

				log.debug(sb.toString());
			}


			//PrdCreateManageBCImpl.setPrdCreateParam 에도 같은 로직 추가 
			double sumBkgQty = 0;
			String sumCTpSz="";
			PrdQuantityVO[] prdQuantityVoList = event.getPrdQuantityVOs();
			if(prdQuantityVoList != null){
				for (int i = 0; i < prdQuantityVoList.length; i++) {
					sumBkgQty = sumBkgQty +  Double.parseDouble( prdQuantityVoList[i].getCQty());
					String tpSz = prdQuantityVoList[i].getCTpsz().substring(0, 1);
					sumCTpSz = sumCTpSz + (sumCTpSz.indexOf(tpSz) > 0 ? "":tpSz);
					log.debug("\n 0080 htmlaction sumCTpSz:"+sumCTpSz);
					log.debug("\n 0080 htmlaction sumBkgQty :"+sumBkgQty );
				}				
			}

			
			event.getPrdCreateParamVO().setSumBkgQty(Double.toString(sumBkgQty));
			event.getPrdCreateParamVO().setSumCTpSz( sumCTpSz);
			
			event.setAttribute("request", request);
			log.debug("\n\n getPrdCreateParamVO-------------------------------------------------------"+ event.getPrdCreateParamVO().getPor());
			log.debug("\n\n getPrdCreateParamVO getDelT-------------------------------------------------------"+ event.getPrdCreateParamVO().getDelT());
			log.debug("\n\n setPrdQuantityVOs-------------------------------------------------------"+(event.getPrdQuantityVOs()!= null? event.getPrdQuantityVOs().toString(): ""));
			
//			String[] cTpsz= (String[])request.getParameterValues("c_tpsz"   );
//		    String[] cQty= (String[])request.getParameterValues("c_qty"   );
		    
//		}
		if(command.isCommand(FormCommand.SEARCH01)||command.isCommand(FormCommand.SEARCH02) ) {
//			event.setPRD_PROD_CTL_DTL((PRD_PROD_CTL_DTL)getVO(request, PRD_PROD_CTL_DTL .class));
			event.setPrdSearchParamVO ((PrdSearchParamVO)getVO(request, PrdSearchParamVO.class ));
			log.debug("\n\n =====PrdSearchParamVO::"+event.getPrdSearchParamVO().toString());
			log.debug("\n\n =====request::"+JSPUtil.getParameter(request, "m_pu_dt", ""));
		}

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