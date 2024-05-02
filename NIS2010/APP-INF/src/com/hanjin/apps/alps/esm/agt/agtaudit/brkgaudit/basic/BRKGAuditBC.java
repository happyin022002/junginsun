/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : BRKGAuditBC.java
*@FileTitle : Brokerage Maintenance & Approval Management
*Open Issues :
*Change history :
*@LastModifyDate : 2007-01-22
*@LastModifier : Jung-Hyung, Kim
*@LastVersion : 1.0
* 2007-01-22 Jung-Hyung, Kim
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtaudit.brkgaudit.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.agt.agtaudit.AGTAuditSC;
import com.hanjin.apps.alps.esm.agt.agtaudit.brkgaudit.vo.AGTBRKGRateInfoVO;
import com.hanjin.apps.alps.esm.agt.agtaudit.brkgaudit.vo.APActualInterfaceDetailForBRKGVO;
import com.hanjin.apps.alps.esm.agt.agtaudit.brkgaudit.vo.APActualInterfaceMasterForBRKGVO;
import com.hanjin.apps.alps.esm.agt.agtaudit.brkgaudit.vo.APActualInterfaceVO;
import com.hanjin.apps.alps.esm.agt.agtaudit.brkgaudit.vo.BRKGCommDetailBasicbyBLVO;
import com.hanjin.apps.alps.esm.agt.agtaudit.brkgaudit.vo.BRKGCommDetailChargebyBLVO;
import com.hanjin.apps.alps.esm.agt.agtaudit.brkgaudit.vo.BRKGCommDetailHistorybyBLVO;
import com.hanjin.apps.alps.esm.agt.agtaudit.brkgaudit.vo.BRKGInfoForPrint2VO;
import com.hanjin.apps.alps.esm.agt.agtaudit.brkgaudit.vo.BRKGInfoForPrintVO;
import com.hanjin.apps.alps.esm.agt.agtaudit.brkgaudit.vo.BRKGInfoListForPrintVO;
import com.hanjin.apps.alps.esm.agt.agtaudit.brkgaudit.vo.BrkgCommVO;
import com.hanjin.apps.alps.esm.agt.agtaudit.brkgaudit.vo.CmpnCommVO;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.irep.enis.FNS0080003Document;
import com.hanjin.syscommon.common.table.ComAproRqstRoutVO;

/**
 * eNIS-AGT Business Logic Command Interface<br>
 * - eNIS-AGT에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Junghyung_kim
 * @see AGTAuditSC 참조
 * @since J2EE 1.4
 */
public interface BRKGAuditBC  {
	/**
	 * ESM_AGT_0013 화면에서 Brokerage Commission recalculate버튼 클릭시 처리 한다.<br>
	 * 
	 * @param BrkgCommVO[] brkgCommVOs
	 * @exception EventException
	 */
	public void createBRKGCommByRequest(BrkgCommVO[] brkgCommVOs) throws EventException;
	/**
	 * ESM_AGT_0013 화면에서 Agreement Commission recalculate버튼 클릭시 처리 한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse reCalcBRKGComm(Event e) throws EventException;

	/**
	 * ESM_AGT_0013 화면에 대한 수정/삭제 처리 한다.<br>
	 * 
	 * @param BrkgCommVO[] brkgCommVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyBRKGCommforAudit(BrkgCommVO[] brkgCommVOs, SignOnUserAccount account) throws EventException; //public EventResponse modifyBRKGCommInfo(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * ESM_AGT_0013 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param BrkgCommVO brkgCommVO
	 * @return List<BrkgCommVO>
	 * @exception EventException
	 */
	public List<BrkgCommVO> searchBRKGCommforAudit(BrkgCommVO brkgCommVO) throws EventException;

	/**
	 * (ESM_AGT_0014) Brokerage Commission의 Basic 정보를 조회<br>
	 * @param BRKGCommDetailBasicbyBLVO brkgCommDetailBasicbyBLVO
	 * @return List<BRKGCommDetailBasicbyBLVO>
	 * @throws EventException
	 */
	public List<BRKGCommDetailBasicbyBLVO> searchBRKGCommDetailBasicbyBL(BRKGCommDetailBasicbyBLVO brkgCommDetailBasicbyBLVO) throws EventException;
	/**
	 * (ESM_AGT_0014) Charge Detail 목록 조회<br>
	 * @param BRKGCommDetailChargebyBLVO brkgCommDetailChargebyBLVO
	 * @return List<BRKGCommDetailChargebyBLVO>
	 * @throws EventException
	 */
	public List<BRKGCommDetailChargebyBLVO> searchBRKGCommDetailChargebyBL(BRKGCommDetailChargebyBLVO brkgCommDetailChargebyBLVO) throws EventException;
	/**
	 * (ESM_AGT_0014) Brokerage Commission의 History Detail 목록 조회<br>
	 * 
	 * @param BRKGCommDetailHistorybyBLVO brkgCommDetailHistorybyBLVO
	 * @return List<BRKGCommDetailHistorybyBLVO>
	 * @exception EventException
	 */
	public List<BRKGCommDetailHistorybyBLVO> searchBRKGCommDetailHistorybyBL(BRKGCommDetailHistorybyBLVO brkgCommDetailHistorybyBLVO) throws EventException;
	/**
	 * ESM_AGT_0014 화면 요율 정보 조회 이벤트 처리<br>
	 * 
	 * @param AGTBRKGRateInfoVO agtBRKGRateInfoVO
	 * @return List<AGTBRKGRateInfoVO>
	 * @exception EventException
	 */
	public List<AGTBRKGRateInfoVO> searchAGTBRKGRateInfo(AGTBRKGRateInfoVO agtBRKGRateInfoVO) throws EventException;

	/**
	 * ESM_AGT_018 화면에 대한 Brokerage Approval & Request 대상리스트를 가져온다.<br>
	 * 
	 * @param APActualInterfaceMasterForBRKGVO apActualInterfaceMasterForBRKGVO
	 * @return List<APActualInterfaceMasterForBRKGVO>
	 * @exception EventException
	 */
	public List<APActualInterfaceMasterForBRKGVO> searchAPActualInterfaceMasterForBRKG(APActualInterfaceMasterForBRKGVO apActualInterfaceMasterForBRKGVO) throws EventException;


	/**
	 * ESM_AGT_0018 화면에 대한 Brokerage Approval & Request 대상리스트를 가져온다.<br>
	 * 
	 * @param APActualInterfaceDetailForBRKGVO apActualInterfaceDetailForBRKGVO
	 * @return List<APActualInterfaceDetailForBRKGVO>
	 * @exception EventException
	 */
	public List<APActualInterfaceDetailForBRKGVO> searchAPActualInterfaceDetailForBRKG(APActualInterfaceDetailForBRKGVO apActualInterfaceDetailForBRKGVO) throws EventException;
	/**
	 * ESM_AGT_018 화면에 대한 엑셀저장용 Brokerage Approval & Request 대상리스트를 가져온다.<br>
	 * 
	 * @param APActualInterfaceVO apActualInterfaceVO
	 * @return List<APActualInterfaceVO>
	 * @exception EventException
	 */
	public List<APActualInterfaceVO> searchAPActualInterfaceMasterDetailDownExcel(APActualInterfaceVO apActualInterfaceVO) throws EventException;
	
	/**
	 * ESM_AGT_018 화면에 대한 Brokerage Approval & Request 대상리스트를 취소한다.<br>
	 * 
	 * @param APActualInterfaceMasterForBRKGVO apActualInterfaceMasterForBRKGVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createCancelBRKGActualINFtoAP(APActualInterfaceMasterForBRKGVO apActualInterfaceMasterForBRKGVO, SignOnUserAccount account) throws EventException;

	/**
	 * ESM_AGT_0018 화면의 Print 이벤트
	 * @param BRKGInfoListForPrintVO brgkInfoListForPrintVO
	 * @return List<BRKGInfoListForPrintVO>
	 * @throws EventException
	 */
	public List<BRKGInfoListForPrintVO> searchBRKGInfoListForPrint(BRKGInfoListForPrintVO brgkInfoListForPrintVO) throws EventException;

	/**
	 * ESM_AGT_0018 화면의 CSR Print 이벤트
	 * @param BRKGInfoForPrintVO brkgInfoForPrintVO
	 * @return List<BRKGInfoForPrintVO>
	 * @throws EventException
	 */
	public List<BRKGInfoForPrintVO> searchBRKGInfoForPrint1(BRKGInfoForPrintVO brkgInfoForPrintVO)throws EventException;
	/**
	 * ESM_AGT_0018 화면의 CSR Print 이벤트
	 * @param BRKGInfoForPrint2VO brkgInfoForPrint2VO
	 * @return List<BRKGInfoForPrint2VO>
	 * @throws EventException
	 */
	public List<BRKGInfoForPrint2VO> searchBRKGInfoForPrint2(BRKGInfoForPrint2VO brkgInfoForPrint2VO) throws EventException;
	/**
	 *  ESM_AGT_018 화면에 대한 Brokerage Approval & Request 대상리스트를 Interface한다.<br>
	 * @param APActualInterfaceMasterForBRKGVO[] actualInterfaceMasterForBRKGVOs
	 * @param APActualInterfaceMasterForBRKGVO actualInterfaceMasterForBRKGVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void createBRKGActualRequestINFtoAP(
			APActualInterfaceMasterForBRKGVO[] actualInterfaceMasterForBRKGVOs,
			APActualInterfaceMasterForBRKGVO actualInterfaceMasterForBRKGVO,
			SignOnUserAccount account) throws EventException;
	/**
	 * ESM_AGT_0018 화면에 대한 인터페이스 이벤트 처리(1) : EP결재 수신 + CSR I/F<br>
	 * @param String result
	 * @param String csrNo
	 * @param ComAproRqstRoutVO model
	 * @return FNS0080003Document[]
	 * @throws EventException
	 */
	public FNS0080003Document[] transferBRKGActualINFtoAP1(String result,
			String csrNo, ComAproRqstRoutVO model) throws EventException;
	/**
	 * ESM_AGT_0018 화면에 대한 인터페이스 이벤트 처리(2) : EP결재 수신 + CSR I/F<br>
	 * @param String result
	 * @param String csrNo
	 * @param ComAproRqstRoutVO model
	 * @return String
	 * @throws EventException
	 * @throws DAOException 
	 */
	public String transferBRKGActualINFtoAP2(String result, String csrNo,
			ComAproRqstRoutVO model) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * ESM_AGT_0059 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param CmpnCommVO cmpnCommVO
	 * @return List<CmpnCommVO>
	 * @exception EventException
	 */
	public List<CmpnCommVO> searchBRKGCommSAmericaForAudit(CmpnCommVO cmpnCommVO) throws EventException;
	/**
	 * ESM_AGT_0059 화면에 대한 수정/삭제 처리 한다.<br>
	 * 
	 * @param CmpnCommVO[] cmpnCommVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyBRKGCommSAmericaForAudit(CmpnCommVO[] cmpnCommVOs, SignOnUserAccount account) throws EventException; //public EventResponse modifyBRKGCommInfo(Event e) throws EventException;
	/**
	 * ESM_AGT_0059 화면에서 Brokerage Maintenance & Audit for S.America recalculate버튼 클릭시 처리 한다.<br>
	 * 
	 * @param CmpnCommVO[] cmpnCommVOs
	 * @exception EventException
	 */
	public void createBRKGCommSAmericaByRequest(CmpnCommVO[] cmpnCommVOs) throws EventException;

	/**
	 * ESM_AGT_060 화면에 대한 Brokerage Approval & Request 대상리스트를 가져온다.<br>
	 * 
	 * @param APActualInterfaceMasterForBRKGVO apActualInterfaceMasterForBRKGVO
	 * @return List<APActualInterfaceMasterForBRKGVO>
	 * @exception EventException
	 */
	public List<APActualInterfaceMasterForBRKGVO> searchAPActualInterfaceMasterSAmericaForBRKG(APActualInterfaceMasterForBRKGVO apActualInterfaceMasterForBRKGVO) throws EventException;

	/**
	 * ESM_AGT_0018 화면에 대한 Brokerage Approval & Request 대상리스트를 가져온다.<br>
	 * 
	 * @param APActualInterfaceDetailForBRKGVO apActualInterfaceDetailForBRKGVO
	 * @return List<APActualInterfaceDetailForBRKGVO>
	 * @exception EventException
	 */
	public List<APActualInterfaceDetailForBRKGVO> searchAPActualInterfaceDetailSAmericaForBRKG(APActualInterfaceDetailForBRKGVO apActualInterfaceDetailForBRKGVO) throws EventException;

	/**
	 *  ESM_AGT_0060 화면에 대한 Brokerage Approval & Request 대상리스트를 Interface한다.<br>
	 * @param APActualInterfaceMasterForBRKGVO[] actualInterfaceMasterForBRKGVOs
	 * @param APActualInterfaceMasterForBRKGVO actualInterfaceMasterForBRKGVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void createBRKGActualRequestSAmericaINFtoAP(
			APActualInterfaceMasterForBRKGVO[] actualInterfaceMasterForBRKGVOs,
			APActualInterfaceMasterForBRKGVO actualInterfaceMasterForBRKGVO,
			SignOnUserAccount account) throws EventException;
	/**
	 * ESM_AGT_0060 화면에 대한 Brokerage Approval & Request 대상리스트를 취소한다.<br>
	 * 
	 * @param APActualInterfaceMasterForBRKGVO apActualInterfaceMasterForBRKGVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createCancelBRKGSAmericaActualINFtoAP(APActualInterfaceMasterForBRKGVO apActualInterfaceMasterForBRKGVO, SignOnUserAccount account) throws EventException;

	/**
	 * ESM_AGT_0060 화면의 Print 이벤트
	 * @param BRKGInfoListForPrintVO brgkInfoListForPrintVO
	 * @return List<BRKGInfoListForPrintVO>
	 * @throws EventException
	 */
	public List<BRKGInfoListForPrintVO> searchBRKGSAmericaInfoListForPrint(BRKGInfoListForPrintVO brgkInfoListForPrintVO) throws EventException;

	/**
	 * ESM_AGT_0060 화면에 대한 엑셀저장용 Brokerage Approval & Request 대상리스트를 가져온다.<br>
	 * 
	 * @param APActualInterfaceVO apActualInterfaceVO
	 * @return List<APActualInterfaceVO>
	 * @exception EventException
	 */
	public List<APActualInterfaceVO> searchAPActualInterfaceMasterDetailSAmericaDownExcel(APActualInterfaceVO apActualInterfaceVO) throws EventException;
	
	
}