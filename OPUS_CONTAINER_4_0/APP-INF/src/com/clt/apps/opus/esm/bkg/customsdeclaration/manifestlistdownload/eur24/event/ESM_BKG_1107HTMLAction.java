/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_1107HTMLAction.java
 *@FileTitle : ESM_BKG_1107HTMLAction
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010.09.29
 *@LastModifier : 계기훈
 *@LastVersion : 1.0
 * 2010.09.29 계기훈
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.event;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ContainerListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo.ChinaBlInfoListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo.ChinaManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo.TransKeyVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eur24BlCntrListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eur24BlCntrMFListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eur24BlCntrSealNoListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eur24BlCustVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eur24BlDangerCntrListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eur24BlGeneralInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eur24BlInfoCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eur24BlInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eur24VesselArrivalCondVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.bkg.customsdeclaration 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CustomsDeclarationSC로 실행요청<br>
 * - CustomsDeclarationSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * 
 * @author 계기훈
 * @see EsmBkg1107Event 참조
 * @since J2EE 1.6
 */
public class ESM_BKG_1107HTMLAction extends HTMLActionSupport{
	private static final long serialVersionUID = 1L;
	public ESM_BKG_1107HTMLAction() {}
	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 CustomsDeclarationEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	@Override
	public Event perform(HttpServletRequest request) throws HTMLActionException{
		FormCommand command = FormCommand.fromRequest(request);
		EsmBkg1107Event event = new EsmBkg1107Event();

		if (command.isCommand(FormCommand.SEARCH)) {
			// 조회
			Eur24BlInfoCondVO eur24BlInfoCondVO = (Eur24BlInfoCondVO)getVO(request, Eur24BlInfoCondVO.class);
			event.setEur24BlInfoCondVO(eur24BlInfoCondVO);
		}else if (command.isCommand(FormCommand.MULTI)) {

			// SAVE
			Eur24BlGeneralInfoVO eur24BlGeneralInfoVO = (Eur24BlGeneralInfoVO)getVO(request, Eur24BlGeneralInfoVO.class);
			Eur24BlCustVO eur24BlCustVO = (Eur24BlCustVO)getVO(request, Eur24BlCustVO.class);
			Eur24BlCntrListVO[] eur24BlCntrListVOs = (Eur24BlCntrListVO[])getVOs(request, Eur24BlCntrListVO.class, "t3_");
			List<Eur24BlCntrListVO> cntr = new ArrayList<Eur24BlCntrListVO>();
			for(int i=0; eur24BlCntrListVOs != null && i<eur24BlCntrListVOs.length; i++){

				cntr.add(eur24BlCntrListVOs[i]);
			}
			Eur24BlCntrMFListVO[] eur24BlCntrMFListVOs = (Eur24BlCntrMFListVO[])getVOs(request, Eur24BlCntrMFListVO.class, "t5_");
			List<Eur24BlCntrMFListVO> mf = new ArrayList<Eur24BlCntrMFListVO>();
			for (int i = 0; eur24BlCntrMFListVOs!= null && i < eur24BlCntrMFListVOs.length; i++) {

				mf.add(eur24BlCntrMFListVOs[i]);
			}
			Eur24BlDangerCntrListVO[] eur24BlDangerCntrListVOs = (Eur24BlDangerCntrListVO[])getVOs(request, Eur24BlDangerCntrListVO.class, "t4_");
			List<Eur24BlDangerCntrListVO> danger = new ArrayList<Eur24BlDangerCntrListVO>();
			for (int i = 0; eur24BlDangerCntrListVOs!= null && i < eur24BlDangerCntrListVOs.length; i++) {

				danger.add(eur24BlDangerCntrListVOs[i]);
			}
			
			Eur24BlCntrSealNoListVO[] eur24BlCntrSealNoListVOs = (Eur24BlCntrSealNoListVO[])getVOs(request, Eur24BlCntrSealNoListVO.class, "t6_");
			List<Eur24BlCntrSealNoListVO> seal = new ArrayList<Eur24BlCntrSealNoListVO>();
			for (int i = 0; eur24BlCntrSealNoListVOs!= null && i < eur24BlCntrSealNoListVOs.length; i++) {
				seal.add(eur24BlCntrSealNoListVOs[i]);
			}
			
			Eur24BlInfoVO eur24BlInfoVO = new Eur24BlInfoVO();
			eur24BlInfoVO.setEur24BlGeneralInfoVO(eur24BlGeneralInfoVO);
			eur24BlInfoVO.setEur24BlCustVO(eur24BlCustVO);
			eur24BlInfoVO.setEur24BlCntrListVOs(cntr);
			eur24BlInfoVO.setEur24BlCntrMFListVOs(mf);
			eur24BlInfoVO.setEur24BlDangerCntrListVOs(danger);
			eur24BlInfoVO.setEur24BlCntrSealNoListVOs(seal);
			event.setEur24BlInfoVO(eur24BlInfoVO);
		}else if(command.isCommand(FormCommand.SEARCH01)) {
			ContainerListCondVO[] condVOs = (ContainerListCondVO[])getVOs(request, ContainerListCondVO.class);
			for (int i=0; i<condVOs.length; i++) {
				if("I".equals(condVOs[i].getIbflag()) || "U".equals(condVOs[i].getIbflag())){
					event.setContainerListCondVO(condVOs[i]);
				}
			}
		}else if(command.isCommand(FormCommand.SEARCH02)) {
			//BL No값에 따라 VVD를 조회해 오는 부분 추가 - 2010.10.11
			Eur24VesselArrivalCondVO vesselArrivalCondVO =(Eur24VesselArrivalCondVO)getVO(request, Eur24VesselArrivalCondVO.class);
			event.setVesselArrivalCondVO(vesselArrivalCondVO);
		}else if(command.isCommand(FormCommand.SEARCH03)){
			event.setContainerListCondVO((ContainerListCondVO)getVO(request, ContainerListCondVO.class));
		}else if(command.isCommand(FormCommand.SEARCH04)){
			String custType = request.getParameter("cust_type").toLowerCase();
			event.setCustCntCd(request.getParameter(custType + "_cust_cnt_cd"));
			event.setCustSeq(request.getParameter(custType + "_cust_seq"));		
			event.setCustType(custType);
		}else if(command.isCommand(FormCommand.MULTI01)) {
			ChinaManifestTransmitVO transmitVO = new ChinaManifestTransmitVO();
			ChinaBlInfoListVO[] chinaBlInfoListVOs = new ChinaBlInfoListVO[1];
			ChinaBlInfoListVO blInfoVO = new ChinaBlInfoListVO();
			blInfoVO.setBlNo(request.getParameter("bl_no"));
			chinaBlInfoListVOs[0] = blInfoVO;
			
			transmitVO.setChinaBlInfoListVOs(chinaBlInfoListVOs);
			transmitVO.setTransKeyVO((TransKeyVO)getVO(request, TransKeyVO.class));
            //event.setManifestTransmitVO(transmitVO);
		}else if(command.isCommand(FormCommand.MULTI02)) {
			Eur24BlInfoCondVO eur24BlInfoCondVO = (Eur24BlInfoCondVO)getVO(request, Eur24BlInfoCondVO.class);
			event.setEur24BlInfoCondVO(eur24BlInfoCondVO);
		}else if(command.isCommand(FormCommand.MULTI03)) {
			Eur24BlInfoCondVO eur24BlInfoCondVO = (Eur24BlInfoCondVO)getVO(request, Eur24BlInfoCondVO.class);
			event.setEur24BlInfoCondVO(eur24BlInfoCondVO);
		}
		request.setAttribute("Event", event);
		return event;
	}
}