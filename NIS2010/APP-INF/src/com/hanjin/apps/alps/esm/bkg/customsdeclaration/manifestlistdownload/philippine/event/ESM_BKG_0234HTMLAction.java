/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0234HTMLAction.java
*@FileTitle : ESM_BKG-0234
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.19
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.05.19 임재택
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.philippine.event;

import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.philippine.vo.ManilaContainerSaveVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.philippine.vo.ManilaManifestListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.philippine.vo.ManilaSearchBlInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.philippine.vo.ManilaSearchBolVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.philippine.vo.ManilaSearchCtnVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.philippine.vo.ManilaSearchGenVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.philippine.vo.ManilaSearchPkgDescVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.philippine.vo.ManilaSearchPkgMarkVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.philippine.vo.ManilaSearchVvdDtlVO;
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

public class ESM_BKG_0234HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BKG_0234HTMLAction 객체를 생성 
	 */
	public ESM_BKG_0234HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 CustomsDeclarationEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
    	EsmBkg0234Event event = new EsmBkg0234Event();
    			
		if(command.isCommand(FormCommand.SEARCH)) {
			event.setManilaManifestListCondVO((ManilaManifestListCondVO)getVO(request, ManilaManifestListCondVO.class));
		} else if(command.isCommand(FormCommand.MULTI01)) { 	
			ManilaContainerSaveVO saveVO = new ManilaContainerSaveVO();
			
		   	String sheetgubun = request.getParameter("sheetgubun");
		   	String sheetdata = request.getParameter("sheetdata");
		   			   	
		   	StringTokenizer lines = new StringTokenizer(sheetdata, ";");
		   	StringTokenizer datas = null;
		   	String[] strArr = new String[2];
		   	int voCnt = 0;

		   	if(sheetgubun.equalsIgnoreCase("sheet1_")) {
		   		saveVO.setManilaSearchBolVOs((ManilaSearchBolVO[])getVOs(request, ManilaSearchBolVO.class, "t1sheet1_"));
		   	} else if(sheetgubun.equalsIgnoreCase("sheet2_")) {
		   		saveVO.setManilaSearchGenVOs((ManilaSearchGenVO[])getVOs(request, ManilaSearchGenVO.class, "t2sheet1_"));
		   	} else if(sheetgubun.equalsIgnoreCase("sheet3_")) {
		   		saveVO.setManilaSearchCtnVOs((ManilaSearchCtnVO[])getVOs(request, ManilaSearchCtnVO.class, "t3sheet1_"));
		   	} else if(sheetgubun.equalsIgnoreCase("sheet4_")) {
		   		ManilaSearchVvdDtlVO[] manilasearchVvdDtlVOs = new ManilaSearchVvdDtlVO[lines.countTokens()];
		   		ManilaSearchVvdDtlVO vo = null;
		   		
			   	while(lines.hasMoreElements()){
			   		vo = new ManilaSearchVvdDtlVO();
				   	datas = new StringTokenizer((String)lines.nextToken(), "&");
				   	
				   	while(datas.hasMoreElements()){
				   		strArr = ((String)datas.nextElement()).split("=");
				   		if(strArr.length == 2) {
					   		if(strArr[0].equals("ibflag")) 			{ vo.setIbflag(strArr[1]);
				   			}else if(strArr[0].equals("seq")) 		{ vo.setSeq(strArr[1]);
					   		}else if(strArr[0].equals("discharge")) { vo.setDischarge(strArr[1]);
					   		}
				   		}
				   	}
			   		manilasearchVvdDtlVOs[voCnt] = vo;
				   	if(voCnt < manilasearchVvdDtlVOs.length-1) voCnt++;
			   	}
			   	saveVO.setManilasearchVvdDtlVO(manilasearchVvdDtlVOs);
		   	} else if(sheetgubun.equalsIgnoreCase("sheet5_")) {
		   		ManilaSearchBlInfoVO[] manilaSearchBlInfoVOs = new ManilaSearchBlInfoVO[lines.countTokens()];
		   		ManilaSearchBlInfoVO vo = null;
		   		
			   	while(lines.hasMoreElements()){
			   		vo = new ManilaSearchBlInfoVO();
				   	datas = new StringTokenizer((String)lines.nextToken(), "&");
				   	
				   	while(datas.hasMoreElements()){
				   		strArr = ((String)datas.nextElement()).split("=");
				   		if(strArr.length == 2) {
				   			if(strArr[0].equals("ibflag")) 			 { vo.setIbflag(strArr[1]);
				   			}else if(strArr[0].equals("seq")) 		 { vo.setSeq(strArr[1]);
				   			}else if(strArr[0].equals("cargo_type")) { vo.setCargoType(strArr[1]);
				   			}else if(strArr[0].equals("pod")) 		 { vo.setPod(strArr[1]);
					   		}
				   		}
				   	}
			   		manilaSearchBlInfoVOs[voCnt] = vo;
				   	if(voCnt < manilaSearchBlInfoVOs.length-1) voCnt++;
			   	}
			   	saveVO.setManilaSearchBlInfoVO(manilaSearchBlInfoVOs);
		   	} else if(sheetgubun.equalsIgnoreCase("sheet7_")) {
		   		ManilaSearchPkgDescVO[] manilaSearchPkgDescVOs = new ManilaSearchPkgDescVO[lines.countTokens()];
		   		ManilaSearchPkgDescVO vo = null;
		   		
			   	while(lines.hasMoreElements()){
			   		vo = new ManilaSearchPkgDescVO();
				   	datas = new StringTokenizer((String)lines.nextToken(), "&");
				   	
				   	while(datas.hasMoreElements()){
				   		strArr = ((String)datas.nextElement()).split("=");
				   		if(strArr.length == 2) {
					   		if(strArr[0].equals("ibflag")) 			{ vo.setIbflag(strArr[1]);
				   			}else if(strArr[0].equals("seq")) 		{ vo.setSeq(strArr[1]);
				   			}else if(strArr[0].equals("seq2")) 		{ vo.setSeq2(strArr[1]);
					   		}else if(strArr[0].equals("desc_good"))	{ vo.setDescGood(strArr[1]);
					   		}
				   		}
				   	}
			   		manilaSearchPkgDescVOs[voCnt] = vo;
				   	if(voCnt < manilaSearchPkgDescVOs.length-1) voCnt++;
			   	}
			   	saveVO.setManilaSearchPkgDescVO(manilaSearchPkgDescVOs);
			} else if(sheetgubun.equalsIgnoreCase("sheet8_")) {
		   		ManilaSearchPkgMarkVO[] manilaSearchPkgMarkVOs = new ManilaSearchPkgMarkVO[lines.countTokens()];
		   		ManilaSearchPkgMarkVO vo = null;

		   		while(lines.hasMoreElements()){
			   		vo = new ManilaSearchPkgMarkVO();
				   	datas = new StringTokenizer((String)lines.nextToken(), "&");
				   	
				   	while(datas.hasMoreElements()){
				   		strArr = ((String)datas.nextElement()).split("=");
				   		if(strArr.length == 2) {
					   		if(strArr[0].equals("ibflag")) 			 { vo.setIbflag(strArr[1]);
				   			}else if(strArr[0].equals("seq")) 		 { vo.setSeq(strArr[1]);
					   		}else if(strArr[0].equals("desc_good2")) { vo.setDescGood2(strArr[1]);
					   		}
				   		}
				   	}
			   		manilaSearchPkgMarkVOs[voCnt] = vo;
				   	if(voCnt < manilaSearchPkgMarkVOs.length-1) voCnt++;
			   	}
		   		saveVO.setManilaSearchPkgMarkVO(manilaSearchPkgMarkVOs);
			}

			saveVO.setManilaManifestListCondVO((ManilaManifestListCondVO)getVO(request, ManilaManifestListCondVO.class));
			
		   	event.setManifestListDetailVO(saveVO);
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
