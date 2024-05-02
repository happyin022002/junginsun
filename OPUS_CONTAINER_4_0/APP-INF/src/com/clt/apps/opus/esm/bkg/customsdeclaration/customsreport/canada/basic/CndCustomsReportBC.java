/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CustomsTransmissionBC.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.21
*@LastModifier : 김승민
*@LastVersion : 1.0
* 2009.04.21 김승민
* 1.0 Creation
* 
* 2011.07.06 민정호 [CHM-201111866] US AMS : AMS Report 의 general의 조회 기능 보완
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.canada.basic;

import java.util.List;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.canada.vo.ACIMonitorCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.canada.vo.ACIMonitorListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.canada.vo.CndCstmsReportVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.CstmsReportCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.CstmsReportVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.EAIException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgNtcHisVO;

/**
 * ALPS-CustomsTransmission Business Logic Command Interface<br>
 * - ALPS-CustomsTransmission에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author KIM SEUNG MIN
 * @see 
 * @since J2EE 1.4
 */
public interface CndCustomsReportBC {

	/**
	 * 세관 신고와 관련된 각종 Report를 처리
	 * 
	 * @param cstmsReportCondVO 조회조건
	 * @return List<CstmsReportVO>
	 * @throws EventException
	 */
	public List<CstmsReportVO> searchCstmsReport(CstmsReportCondVO cstmsReportCondVO) throws EventException;

	 /**
	 * FAX : Rd Fax 를 전송한다.
	 * 
	 * @param cstmsReportVOs Advice Note 조회결과
	 * @param account 세션정보
	 * @return List<BkgNtcHisVO>
	 * @throws Exception
	 */
	public List<BkgNtcHisVO> sendAvcNoteFax(CstmsReportVO[] cstmsReportVOs, SignOnUserAccount account)
			throws EventException;

	 /**
	 * Mail : RDMail을 전송한다.
	 * 
	 * @param cstmsReportVOs Advice Note 조회결과
	 * @param account 세션정보
	 * @return List<BkgNtcHisVO>
	 * @throws EAIException
	 */
	public List<BkgNtcHisVO> sendAvcNoteEmail(CstmsReportVO[] cstmsReportVOs, SignOnUserAccount account)
			throws EventException;

	 /**
	 * 메일, 팩스 보내기 위한 기본정보 세팅
	 * 
	 * @param cndCstmsReportVO 조회결과VO
	 * @param sNtcViaCd 팩스, 메일 flag
	 * @param sValue 팩스, 메일값
	 * @param sCustCntcTpCd Customer타입
	 * @return CndCstmsReportVO
	 */
	public CndCstmsReportVO setCndCstmsReportVO(CndCstmsReportVO cndCstmsReportVO, String sNtcViaCd, String sValue,
			String sCustCntcTpCd);

	 /**
	 * CANADA ACI : ACI Monitoring 조회<br>
	 * 
	 * @param ACIMonitorCondVO aCIMonitorCondVO
	 * @return List<ACIMonitorCondVO>
	 * @throws EventException 
	 */
	public List<ACIMonitorListVO> searchACIMonitor(ACIMonitorCondVO aCIMonitorCondVO) throws EventException;
	
}