/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_0216HTMLAction.java
 *@FileTitle : ESM_BKG_0216HTMLAction
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.25
 *@LastModifier : 이수빈
 *@LastVersion : 1.0
 * 2009.08.25 이수빈
 * 1.0 Creation
 * 
 * 2011.07.20 민정호 [CHM-201112024] Split 01-China 24hr Manifest 관련 화면보완 및 추가
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.china.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.china.vo.ChinaManifestListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.china.vo.ChinaManifestListDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.CommonWebKeys;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.bkg.customsdeclaration 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CustomsDeclarationSC로 실행요청<br>
 * - CustomsDeclarationSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * 
 * @author 이수빈
 * @see EsmBkg0216Event 참조
 * @since J2EE 1.6
 */
public class ESM_BKG_0216HTMLAction extends HTMLActionSupport 
{
	private static final long serialVersionUID = 1L;

	public ESM_BKG_0216HTMLAction() {}
	
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
		EsmBkg0216Event event = new EsmBkg0216Event();

		if (command.isCommand(FormCommand.SEARCH)) {
			// Retrieve
            event.setManifestListCondVO((ManifestListCondVO)getVO(request, ChinaManifestListCondVO.class));
		}
		else if (command.isCommand(FormCommand.SEARCH01)) {
			// Retrieve CSV Count
            event.setManifestListCondVO((ManifestListCondVO)getVO(request, ChinaManifestListCondVO.class));
		}
		else if (command.isCommand(FormCommand.COMMAND01)) {
			// Save CSV
            event.setManifestListCondVO((ManifestListCondVO)getVO(request, ChinaManifestListCondVO.class));
		}
		else if (command.isCommand(FormCommand.MULTI)) {
			// Download
            ManifestListDetailVO[] detailVOs = (ManifestListDetailVO[])getVOs(request, ChinaManifestListDetailVO.class);
            event.setManifestListDetailVOs(detailVOs);
		}
		else if (command.isCommand(FormCommand.MULTI01)) {
			//BackEndJob 으로 돌린 후 결과코드 조회
			event.setKey(request.getParameter("key"));
		}
		else{
		   	SignOnUserAccount account = (SignOnUserAccount)request.getSession().getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
			String strCntCd = account.getCnt_cd();
			String strOffCd = account.getOfc_cd();
			
            String pgmNo = request.getParameter("pgmNo"); 
            
    		// ESM_BKG_0216-1 = ESM_BKG_0216-T
            // ESM_BKG_0216-1 = ESM_BKG_0216-U
            
            // China POL & POD Office 메뉴
            if(pgmNo.endsWith("1") || pgmNo.endsWith("T")){
            	if(strCntCd.startsWith("CN")){  // 중국 내 지역 (홍콩 제외)
            	    if(strOffCd.startsWith("HKG")){
                    	event.setTransMode("O");
            		}else{ 
                    	event.setTransMode("D");
            		}
            	}
            	else{   // 중국 외 지역         
                	event.setTransMode("O");
            	}
            }
            // China Office O/B Only 메뉴
            else if(pgmNo.endsWith("2") || pgmNo.endsWith("U")){
            	event.setTransMode("P");
            }
		}
			
		request.setAttribute("Event", event);

		return event;
	}
}
