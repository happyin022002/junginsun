/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_024HTMLAction.java
*@FileTitle : W/O 발행화면
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-06
*@LastModifier : poong_yeon
*@LastVersion : 1.0
* 2006-12-06 poong_yeon
* 1.0 최초 생성
* 1.13 2011.02.08 이재위 [CHM-201108673-01] [TRS] Work Order Issue(ESD_TRS_0023) : W/O Preview per B/L 기능 개발
* 2015.07.20 9014787 [CHM-201536387] ALPS Auth 사후 결재 기능 개발
=========================================================*/
package com.hanjin.apps.alps.esd.trs.workordermanage.workorderpreview.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esd.trs.workordermanage.workorderpreview.vo.WorkOrderPreviewVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.TrsTrspSvcOrdVO;
import com.hanjin.syscommon.common.table.TrsTrspWrkOrdPrvTmpVO;
import com.hanjin.syscommon.common.table.TrsTrspWrkOrdVO;


/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.trs.workordermanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 WorkOrderManageSC로 실행요청<br>
 * - WorkOrderManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author poong_yeon
 * @see EsdTrs0024Event , ESD_TRS_024EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_TRS_0024HTMLAction extends HTMLActionSupport {

	/**
	 * ESD_TRS_024HTMLAction 객체를 생성
	 */
	public ESD_TRS_0024HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESD_TRS_0024Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException { 
		
		FormCommand command = FormCommand.fromRequest(request);
		EsdTrs0024Event event = new EsdTrs0024Event();
		
		event.setFormCreUsrId(JSPUtil.getParameter(request, "FORM_CRE_USR_ID", ""));
		event.setFormUsrOfcCd(JSPUtil.getParameter(request, "FORM_USR_OFC_CD", ""));
		event.setWoPrvGrpBlFlg(JSPUtil.getParameter(request, "wo_prv_grp_bl_flg", ""));
		// CHM-201536387 ALPS Auth 사후 결재 기능 개발
		event.setScgGrpSeq(JSPUtil.getParameter(request, "SCG_GRP_SEQ", ""));
		event.setAuthAproRqstNo(JSPUtil.getParameter(request, "AUTH_APRO_RQST_NO", ""));
		
 		if(command.isCommand(FormCommand.SEARCH01)|| command.isCommand(FormCommand.SEARCH02)){  	
		   	event.setTrsTrspWrkOrdPrvTmpVOs((TrsTrspWrkOrdPrvTmpVO[])getVOs(request, TrsTrspWrkOrdPrvTmpVO.class, ""));
 		}
 		else if(command.isCommand(FormCommand.SEARCH03)){  	
 			event.setTrsTrspWrkOrdVO((TrsTrspWrkOrdVO)getVO(request, TrsTrspWrkOrdVO.class));
		}
 		else if(command.isCommand(FormCommand.SEARCH)||command.isCommand(FormCommand.SEARCH04)|| command.isCommand(FormCommand.SEARCH05)){  	
 			event.setTrsTrspSvcOrdVOs((TrsTrspSvcOrdVO[])getVOs(request, TrsTrspSvcOrdVO.class, ""));
 			event.setTrsTrspSvcOrdVO((TrsTrspSvcOrdVO)getVO(request, TrsTrspSvcOrdVO.class));
			event.setTrsTrspWrkOrdVO((TrsTrspWrkOrdVO)getVO(request, TrsTrspWrkOrdVO.class));
			event.setTrsTrspWrkOrdPrvTmpVO((TrsTrspWrkOrdPrvTmpVO)getVO(request, TrsTrspWrkOrdPrvTmpVO.class));
			event.setWorkOrderPreviewVO((WorkOrderPreviewVO)getVO(request, WorkOrderPreviewVO.class));
 			getValuesFromRequest(event, request);
		}
		else if(command.isCommand(FormCommand.ADD) || command.isCommand(FormCommand.MULTI01)){
			event.setTrsTrspSvcOrdVO((TrsTrspSvcOrdVO)getVO(request, TrsTrspSvcOrdVO.class));
			event.setTrsTrspWrkOrdVO((TrsTrspWrkOrdVO)getVO(request, TrsTrspWrkOrdVO.class));
			event.setTrsTrspWrkOrdPrvTmpVO((TrsTrspWrkOrdPrvTmpVO)getVO(request, TrsTrspWrkOrdPrvTmpVO.class));
			//event.setWorkOrderPreviewVO((WorkOrderPreviewVO)getVO(request, WorkOrderPreviewVO.class));
			getValuesFromRequest(event, request);
		}
		
		return  event;
	}
	
	private EsdTrs0024Event getValuesFromRequest(EsdTrs0024Event event, HttpServletRequest request){
		
		WorkOrderPreviewVO wrkOrdPrvVO = new WorkOrderPreviewVO();
		
		wrkOrdPrvVO.setContiCd(JSPUtil.getParameter(request, "CONTI_CD", ""));
		wrkOrdPrvVO.setWoCxlFlg(JSPUtil.getParameter(request, "WO_CXL_FLG", ""));
		wrkOrdPrvVO.setWoIssNo(JSPUtil.getParameter(request, "WO_ISS_NO", ""));
		wrkOrdPrvVO.setWoPrvGrpSeq(JSPUtil.getParameter(request, "WO_PRV_GRP_SEQ", ""));
		wrkOrdPrvVO.setTrspCrrModCd(JSPUtil.getParameter(request, "TRSP_CRR_MOD_CD", ""));
		wrkOrdPrvVO.setTrspCostDtlModCd(JSPUtil.getParameter(request, "TRSP_COST_DTL_MOD_CD", ""));
		wrkOrdPrvVO.setScgGrpSeq(JSPUtil.getParameter(request, "SCG_GRP_SEQ", ""));
		wrkOrdPrvVO.setWoFmtTpCd(JSPUtil.getParameter(request, "WO_FMT_TP_CD", ""));
		wrkOrdPrvVO.setWoVndrSeq(JSPUtil.getParameter(request, "WO_VNDR_SEQ", ""));
		wrkOrdPrvVO.setWoIssStsCd(JSPUtil.getParameter(request, "WO_ISS_STS_CD", ""));
		wrkOrdPrvVO.setTrspWoOfcCtyCd(JSPUtil.getParameter(request, "TRSP_WO_OFC_CTY_CD", ""));
		wrkOrdPrvVO.setTrspWoSeq(JSPUtil.getParameter(request, "TRSP_WO_SEQ", ""));
		wrkOrdPrvVO.setRdCgo(JSPUtil.getParameter(request, "RD_CGO", ""));
		wrkOrdPrvVO.setWoPrnUseFlg(JSPUtil.getParameter(request, "WO_PRN_USE_FLG", ""));
		wrkOrdPrvVO.setWoEmlUseFlg(JSPUtil.getParameter(request, "WO_EML_USE_FLG", ""));
		wrkOrdPrvVO.setWoFaxUseFlg(JSPUtil.getParameter(request, "WO_FAX_USE_FLG", ""));
		wrkOrdPrvVO.setWoEdiUseFlg(JSPUtil.getParameter(request, "WO_EDI_USE_FLG", ""));
		wrkOrdPrvVO.setWoDtlUseFlg(JSPUtil.getParameter(request, "WO_DTL_USE_FLG", ""));
		wrkOrdPrvVO.setInterUseFlg(JSPUtil.getParameter(request, "INTER_USE_FLG", ""));
		wrkOrdPrvVO.setRtDpUseFlg(JSPUtil.getParameter(request, "RT_DP_USE_FLG", ""));
		wrkOrdPrvVO.setCmdtDpUseFlg(JSPUtil.getParameter(request, "CMDT_DP_USE_FLG", ""));
		wrkOrdPrvVO.setPreDisUseFlg(JSPUtil.getParameter(request, "PRE_DIS_USE_FLG", ""));
		wrkOrdPrvVO.setWoRmk(JSPUtil.getParameter(request, "WO_RMK", ""));
		wrkOrdPrvVO.setWoN1stEml(JSPUtil.getParameter(request, "WO_N1ST_EML", ""));
		wrkOrdPrvVO.setWoN2ndEml(JSPUtil.getParameter(request, "WO_N2ND_EML", ""));
		wrkOrdPrvVO.setWoN3rdEml(JSPUtil.getParameter(request, "WO_N3RD_EML", ""));
		wrkOrdPrvVO.setWoN1stFaxNo(JSPUtil.getParameter(request, "WO_N1ST_FAX_NO", ""));
		wrkOrdPrvVO.setWoN2ndFaxNo(JSPUtil.getParameter(request, "WO_N2ND_FAX_NO", ""));
		wrkOrdPrvVO.setWoN3rdFaxNo(JSPUtil.getParameter(request, "WO_N3RD_FAX_NO", ""));
		wrkOrdPrvVO.setEmailTitle(JSPUtil.getParameter(request, "EMAIL_TITLE", ""));
		wrkOrdPrvVO.setEmailContents(JSPUtil.getParameter(request, "EMAIL_CONTENTS", ""));
		wrkOrdPrvVO.setFaxTitle(JSPUtil.getParameter(request, "FAX_TITLE", ""));
		wrkOrdPrvVO.setFaxBatchInd(JSPUtil.getParameter(request, "FAX_BATCH_IND", ""));
		wrkOrdPrvVO.setFaxParam(JSPUtil.getParameter(request, "FAX_PARAM", ""));
		wrkOrdPrvVO.setFaxSysCd(JSPUtil.getParameter(request, "FAX_SYS_CD", ""));
		wrkOrdPrvVO.setFaxAppCd(JSPUtil.getParameter(request, "FAX_APP_CD", ""));
		wrkOrdPrvVO.setFaxRcvInfo(JSPUtil.getParameter(request, "FAX_RCV_INFO", ""));
		wrkOrdPrvVO.setWoCntcPsonNm(JSPUtil.getParameter(request, "WO_CNTC_PSON_NM", ""));
		
		event.setWorkOrderPreviewVO(wrkOrdPrvVO);
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