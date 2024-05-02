/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_0217HTMLAction.java
 *@FileTitle : ESM_BKG_0217HTMLAction
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.25
 *@LastModifier : 이수빈
 *@LastVersion : 1.0
 * 2009.08.25 이수빈
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo.ChinaBlCntrListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo.ChinaBlDangerCntrListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo.ChinaBlGeneralListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo.ChinaBlInfoCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo.ChinaBlInfoListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo.ChinaBlInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo.ChinaContainerCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo.ChinaManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo.TransKeyVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.ContainerCondVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.CommonWebKeys;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgCstmsChnCustVO;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.bkg.customsdeclaration 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CustomsDeclarationSC로 실행요청<br>
 * - CustomsDeclarationSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author 이수빈
 * @see EsmBkg0217Event 참조
 * @since J2EE 1.6
 */
public class ESM_BKG_0217HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;

	public ESM_BKG_0217HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 CustomsDeclarationEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	@Override
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		FormCommand command = FormCommand.fromRequest(request);
		EsmBkg0217Event event = new EsmBkg0217Event();

		if (command.isCommand(FormCommand.SEARCH)) {
			// 조회
			ChinaBlInfoCondVO blInfoCondVO = (ChinaBlInfoCondVO)getVO(request, ChinaBlInfoCondVO.class);
			event.setChinaBlInfoCondVO(blInfoCondVO);

		} else if (command.isCommand(FormCommand.MULTI)) {
			// SAVE
			ChinaBlGeneralListVO generalVO = (ChinaBlGeneralListVO)getVO(request, ChinaBlGeneralListVO.class);
			ChinaBlCntrListVO[] cntrVOs = (ChinaBlCntrListVO[])getVOs(request, ChinaBlCntrListVO.class, "t1_");
			BkgCstmsChnCustVO[] custVOs = (BkgCstmsChnCustVO[])getVOs(request, BkgCstmsChnCustVO.class, "t2_");
			ChinaBlDangerCntrListVO[] dgCntrVOs = (ChinaBlDangerCntrListVO[])getVOs(request, ChinaBlDangerCntrListVO.class, "t3_");

			ChinaBlInfoVO chinaBlInfoVO = new ChinaBlInfoVO();
			chinaBlInfoVO.setChinaBlGeneralListVO(generalVO);
			chinaBlInfoVO.setBkgCstmsChnCustVOs(custVOs);
			chinaBlInfoVO.setBlCntrListVOs(cntrVOs);
			chinaBlInfoVO.setBlDangerCntrListVOs(dgCntrVOs);

			event.setChinaBlInfoVO(chinaBlInfoVO);

		} else if (command.isCommand(FormCommand.SEARCH01)) {
			ContainerCondVO containerCondVO = (ContainerCondVO)getVO(request, ChinaContainerCondVO.class);
			event.setContainerCondVO(containerCondVO);

		} else if (command.isCommand(FormCommand.MULTI01)) {
			ChinaManifestTransmitVO transmitVO = new ChinaManifestTransmitVO();
			ChinaBlInfoListVO[] chinaBlInfoListVOs = new ChinaBlInfoListVO[1];
			ChinaBlInfoListVO blInfoVO = new ChinaBlInfoListVO();
			blInfoVO.setBlNo(request.getParameter("bl_no"));
			chinaBlInfoListVOs[0] = blInfoVO;

			transmitVO.setChinaBlInfoListVOs(chinaBlInfoListVOs);
			transmitVO.setTransKeyVO((TransKeyVO)getVO(request, TransKeyVO.class));
			event.setChinaManifestTransmitVO(transmitVO);

		} else {
			SignOnUserAccount account = (SignOnUserAccount)request.getSession().getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
			String strCntCd = account.getCnt_cd();
			String strOffCd = account.getOfc_cd();
			String pgmNo = request.getParameter("pgmNo");

			// China POL & POD Office 메뉴
			if (pgmNo.endsWith("1")) {
				if (strCntCd.startsWith("CN")) {  // 중국 내 지역 (홍콩 제외)
					if(strOffCd.startsWith("HKG")){
						event.setTransMode("O");
					} else {
						event.setTransMode("D");
					}
				} else {   // 중국 외 지역
					event.setTransMode("O");
				}
			} else if(pgmNo.endsWith("2")) {
				// China Office O/B Only 메뉴
				event.setTransMode("P");
			}
		}

		request.setAttribute("Event", event);
		return event;
	}
}
