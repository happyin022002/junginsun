/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : BRKGAuditBC.java
*@FileTitle : Brokerage Maintenance & Approval Management
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.basic;

import java.util.List;

import com.clt.apps.opus.esm.agt.agtaudit.AGTAuditSC;
import com.clt.apps.opus.esm.agt.agtaudit.agtaudit.vo.AgtApPayInvVO;
import com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.vo.AGTBRKGRateInfoVO;
import com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.vo.APActualInterfaceDetailForBRKGVO;
import com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.vo.APActualInterfaceMasterForBRKGVO;
import com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.vo.APActualInterfaceVO;
import com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.vo.BRKGCommDetailBasicbyBLVO;
import com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.vo.BRKGCommDetailChargebyBLVO;
import com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.vo.BRKGCommDetailHistorybyBLVO;
import com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.vo.BRKGInfoForPrint2VO;
import com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.vo.BRKGInfoForPrintVO;
import com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.vo.BRKGInfoListForPrintVO;
import com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.vo.BrkgCommVO;
import com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.vo.BrogApPayInvVO;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.ApPayInvDtlVO;
import com.clt.syscommon.common.table.ApPayInvVO;
import com.clt.syscommon.common.table.ComAproRqstRoutVO;
import com.clt.irep.enis.FNS0080003Document;

/**
 * OPUS-AGT Business Logic Command Interface<br>
 * - OPUS-AGT handling Business Logic Command Interface<br>
 *
 * @author 
 * @see AGTAuditSC 
 * @since J2EE 1.4
 */
public interface BRKGAuditBC  {
	/**
	 * ESM_AGT_0013 Brokerage Commission recalculate event process<br>
	 * 
	 * @param BrkgCommVO[] brkgCommVOs
	 * @exception EventException
	 */
	public void createBRKGCommByRequest(BrkgCommVO[] brkgCommVOs) throws EventException;
	/**
	 * ESM_AGT_0013 Agreement Commission recalculate event process<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse reCalcBRKGComm(Event e) throws EventException;

	/**
	 * ESM_AGT_0013 modify/delete event process<br>
	 * 
	 * @param BrkgCommVO[] brkgCommVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyBRKGCommforAudit(BrkgCommVO[] brkgCommVOs, SignOnUserAccount account) throws EventException; //public EventResponse modifyBRKGCommInfo(Event e) throws EventException;
	
	/**
	 * retrieve event process<br>
	 * ESM_AGT_0013 retrieve event process<br>
	 * 
	 * @param BrkgCommVO brkgCommVO
	 * @return List<BrkgCommVO>
	 * @exception EventException
	 */
	public List<BrkgCommVO> searchBRKGCommforAudit(BrkgCommVO brkgCommVO) throws EventException;

	/**
	 * (ESM_AGT_0014) Brokerage Commission Basic information retrieve event process<br>
	 * @param BRKGCommDetailBasicbyBLVO brkgCommDetailBasicbyBLVO
	 * @return List<BRKGCommDetailBasicbyBLVO>
	 * @throws EventException
	 */
	public List<BRKGCommDetailBasicbyBLVO> searchBRKGCommDetailBasicbyBL(BRKGCommDetailBasicbyBLVO brkgCommDetailBasicbyBLVO) throws EventException;
	/**
	 * (ESM_AGT_0014) Charge Detail information retrieve event process<br>
	 * @param BRKGCommDetailChargebyBLVO brkgCommDetailChargebyBLVO
	 * @return List<BRKGCommDetailChargebyBLVO>
	 * @throws EventException
	 */
	public List<BRKGCommDetailChargebyBLVO> searchBRKGCommDetailChargebyBL(BRKGCommDetailChargebyBLVO brkgCommDetailChargebyBLVO) throws EventException;
	/**
	 * (ESM_AGT_0014) Brokerage Commission History Detail information retrieve event process<br>
	 * 
	 * @param BRKGCommDetailHistorybyBLVO brkgCommDetailHistorybyBLVO
	 * @return List<BRKGCommDetailHistorybyBLVO>
	 * @exception EventException
	 */
	public List<BRKGCommDetailHistorybyBLVO> searchBRKGCommDetailHistorybyBL(BRKGCommDetailHistorybyBLVO brkgCommDetailHistorybyBLVO) throws EventException;
	/**
	 * ESM_AGT_0014 rate information retrieve event process<br>
	 * 
	 * @param AGTBRKGRateInfoVO agtBRKGRateInfoVO
	 * @return List<AGTBRKGRateInfoVO>
	 * @exception EventException
	 */
	public List<AGTBRKGRateInfoVO> searchAGTBRKGRateInfo(AGTBRKGRateInfoVO agtBRKGRateInfoVO) throws EventException;

	/**
	 * ESM_AGT_018 Brokerage Approval & Request List retrieve event process<br>
	 * 
	 * @param APActualInterfaceMasterForBRKGVO apActualInterfaceMasterForBRKGVO
	 * @return List<APActualInterfaceMasterForBRKGVO>
	 * @exception EventException
	 */
	public List<APActualInterfaceMasterForBRKGVO> searchAPActualInterfaceMasterForBRKG(APActualInterfaceMasterForBRKGVO apActualInterfaceMasterForBRKGVO) throws EventException;


	/**
	 * ESM_AGT_018 Brokerage Approval & Request List retrieve event process<br>
	 * 
	 * @param APActualInterfaceDetailForBRKGVO apActualInterfaceDetailForBRKGVO
	 * @return List<APActualInterfaceDetailForBRKGVO>
	 * @exception EventException
	 */
	public List<APActualInterfaceDetailForBRKGVO> searchAPActualInterfaceDetailForBRKG(APActualInterfaceDetailForBRKGVO apActualInterfaceDetailForBRKGVO) throws EventException;
	/**
	 * ESM_AGT_018 Brokerage Approval & Request List retrieve event process for Excel<br>
	 * 
	 * @param APActualInterfaceVO apActualInterfaceVO
	 * @return List<APActualInterfaceVO>
	 * @exception EventException
	 */
	public List<APActualInterfaceVO> searchAPActualInterfaceMasterDetailDownExcel(APActualInterfaceVO apActualInterfaceVO) throws EventException;
	
	/**
	 * ESM_AGT_018 Brokerage Approval & Request Cancel event process<br>
	 * 
	 * @param APActualInterfaceMasterForBRKGVO apActualInterfaceMasterForBRKGVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createCancelBRKGActualINFtoAP(APActualInterfaceMasterForBRKGVO apActualInterfaceMasterForBRKGVO, SignOnUserAccount account) throws EventException;

	/**
	 * ESM_AGT_0018 Print event process
	 * @param BRKGInfoListForPrintVO brgkInfoListForPrintVO
	 * @return List<BRKGInfoListForPrintVO>
	 * @throws EventException
	 */
	public List<BRKGInfoListForPrintVO> searchBRKGInfoListForPrint(BRKGInfoListForPrintVO brgkInfoListForPrintVO) throws EventException;

	/**
	 * ESM_AGT_0018 CSR Print event process
	 * @param BRKGInfoForPrintVO brkgInfoForPrintVO
	 * @return List<BRKGInfoForPrintVO>
	 * @throws EventException
	 */
	public List<BRKGInfoForPrintVO> searchBRKGInfoForPrint1(BRKGInfoForPrintVO brkgInfoForPrintVO)throws EventException;
	/**
	 * ESM_AGT_0018 CSR Print event process
	 * @param BRKGInfoForPrint2VO brkgInfoForPrint2VO
	 * @return List<BRKGInfoForPrint2VO>
	 * @throws EventException
	 */
	public List<BRKGInfoForPrint2VO> searchBRKGInfoForPrint2(BRKGInfoForPrint2VO brkgInfoForPrint2VO) throws EventException;
	/**
	 *  ESM_AGT_018 Brokerage Approval & Request List Interface event process<br>
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
	 * ESM_AGT_0018 Interface event process : EP Approval receive + CSR I/F<br>
	 * @param String result
	 * @param String csrNo
	 * @param ComAproRqstRoutVO model
	 * @return FNS0080003Document[]
	 * @throws EventException
	 */
	public FNS0080003Document[] transferBRKGActualINFtoAP1(String result,
			String csrNo, ComAproRqstRoutVO model) throws EventException;
	/**
	 * ESM_AGT_0018 Interface event process : EP Approval receive + CSR I/F<br>
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
	 * (ESM_AGT_018) BRKG Commission AP Interface List retrieve event process<br>
	 * 
	 * @param BrogApPayInvVO brogApPayInvVO
	 * @exception EventException
	 */	
	public ApPayInvVO searchBrogApPayInv(APActualInterfaceMasterForBRKGVO aPActualInterfaceMasterForBRKGVO, String usrId) throws EventException;
	
	/**
	 * (ESM_AGT_018) BRKG Commission AP Interface List retrieve event process<br>
	 * 
	 * @param BrogApPayInvVO brogApPayInvVO, ApPayInvVO apPayInvVO	
	 * @exception EventException
	 */	
	public ApPayInvDtlVO[] searchBrogApPayInvDtl(APActualInterfaceMasterForBRKGVO aPActualInterfaceMasterForBRKGVO) throws EventException;

	/**
	 * (ESM_AGT_018) Agent Commission status code update<br>
	 * 
	 * @param String string , SignOnUserAccount account	
	 * @exception EventException
	 */
	public void modifyBrogCommProcStsCd( ApPayInvVO apPayInvVO) throws EventException ;
	
}