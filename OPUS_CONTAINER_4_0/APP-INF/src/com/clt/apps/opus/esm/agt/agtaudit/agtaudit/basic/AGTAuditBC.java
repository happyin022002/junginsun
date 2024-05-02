/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AGTAuditBC.java
*@FileTitle : Agent Commission Audit Management Service Command
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.06
*@LastModifier : 이호진
*@LastVersion : 1.0
* 2009.08.06 이호진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.agt.agtaudit.agtaudit.basic;

import java.util.List;

import com.clt.apps.opus.esm.agt.agtaudit.agtaudit.vo.AGTCommInfoForPrint2VO;
import com.clt.apps.opus.esm.agt.agtaudit.agtaudit.vo.AGTCommInfoForPrintVO;
import com.clt.apps.opus.esm.agt.agtaudit.agtaudit.vo.AGTVVDRateVO;
import com.clt.apps.opus.esm.agt.agtaudit.agtaudit.vo.APActualInterfaceDetailVO;
import com.clt.apps.opus.esm.agt.agtaudit.agtaudit.vo.APActualInterfaceMasterVO;
import com.clt.apps.opus.esm.agt.agtaudit.agtaudit.vo.AgtApPayInvVO;
import com.clt.apps.opus.esm.agt.agtaudit.agtaudit.vo.AgtCommBasicInformationVO;
import com.clt.apps.opus.esm.agt.agtaudit.agtaudit.vo.AgtCommListVO;
import com.clt.apps.opus.esm.agt.agtaudit.agtaudit.vo.AgtRptItmInfoMstDtlVO;
import com.clt.apps.opus.esm.agt.agtaudit.agtaudit.vo.BkgAgnCommDeductionRatingVO;
import com.clt.apps.opus.esm.agt.agtaudit.agtaudit.vo.BkgAgtChgDdctVO;
import com.clt.apps.opus.esm.agt.agtaudit.agtaudit.vo.CSRDetailforCommissionDtrbVO;
import com.clt.apps.opus.esm.agt.agtaudit.agtaudit.vo.CSRDetailforCommissionHdrVO;
import com.clt.apps.opus.esm.agt.agtaudit.agtaudit.vo.DeductionChargeVO;
import com.clt.apps.opus.esm.agt.agtaudit.agtaudit.vo.GrsNetCDVO;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.AgtAgnCommDtlVO;
import com.clt.syscommon.common.table.AgtAgnCommVO;
import com.clt.syscommon.common.table.AgtCommBkgInfoVO;
import com.clt.syscommon.common.table.AgtRptItmInfoDtlVO;
import com.clt.syscommon.common.table.ApPayInvDtlVO;
import com.clt.syscommon.common.table.ApPayInvVO;
import com.clt.syscommon.common.table.BkgQuantityVO;
import com.clt.syscommon.common.table.COM_APRO_RQST_ROUT;
import com.clt.syscommon.common.table.ComAproRqstRoutVO;
import com.clt.syscommon.common.table.TesTmlSoHdrVO;
import com.clt.irep.enis.FNS0080003Document;

/**
 * OPUS-Agtaudit Business Logic Command Interface<br>
 * - OPUS-Agtaudit에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Lee Ho Jin
 * @see Esmagt016EventResponse 참조
 * @since J2EE 1.6
 */

public interface AGTAuditBC {
	/**
	 * (ESM_AGT_010) Other Commission Approval retrieve event process<br>
	 * 
	 * @param AgtCommListVO agtCommListVO
	 * @return List<AgtCommListVO>
	 * @exception EventException
	 */
	public List<AgtCommListVO> searchAGTCommForRequest(AgtCommListVO agtCommListVO) throws EventException;
	/**
	 * (ESM_AGT_010) Other Commission Approval retrieve event process<br>
	 * @param AgtCommListVO[] agtCommListVOs
	 * @param SignOnUserAccount account
	 * @return DBRowSet
	 * @exception EventException
	 */
	public DBRowSet modifyAGTCommForRequest(AgtCommListVO[] agtCommListVOs, SignOnUserAccount account) throws EventException;
	/**
	 * (ESM_AGT_010) Other Commission Approval retrieve event process<br>
	 * 
	 * @param DBRowSet dRs
	 * @exception EventException
	 */
	public void sendChnPantoEDIIF(DBRowSet dRs) throws EventException;
	/**
	 * ex.Rate/Local Amount recalculation event process<br>
	 * ESM_AGT_010  ex.Rate/Local Amount calculation event process<br>
	 * @param AgtCommListVO[] agtCommListVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyAGTCommExRateByRequest(AgtCommListVO[] agtCommListVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_AGT_0010 Agreement Commission recalculate event process<br>
	 * 
	 * @param AgtCommListVO[] agtCommListVOs
	 * @exception EventException
	 */
	public void createAGTCommByRequest(AgtCommListVO[] agtCommListVOs) throws EventException;
	
	/**
	 * ESM_AGT_0011 Calculation History event process<br>
	 * @param AgtAgnCommVO agtAgnCommVO
	 * @return List<AgtAgnCommVO>
	 * @throws EventException
	 */
	public List<AgtAgnCommVO> searchAGTCommCalculationHistory(AgtAgnCommVO agtAgnCommVO) throws EventException;
	/**
	 * ESM_AGT_0011 Commission Detail Amount event process<br>
	 * @param AgtAgnCommVO agtAgnCommVO
	 * @return List<AgtAgnCommVO>
	 * @throws EventException
	 */
	public List<AgtAgnCommVO> searchAGTCommCommissionDetailAmount(AgtAgnCommVO agtAgnCommVO) throws EventException;
	/**
	 * ESM_AGT_0011 Basic Information event process<br>
	 * @param AgtAgnCommVO agtAgnCommVO
	 * @return List<AgtCommBasicInformationVO>
	 * @throws EventException
	 */
	public List<AgtCommBasicInformationVO> searchAGTCommBasicInformation(AgtAgnCommVO agtAgnCommVO) throws EventException;
	/**
	 * ESM_AGT_0011 TP/SZ QTY retrieve event process<br>
	 * @param AgtAgnCommVO agtAgnCommVO
	 * @return List<BkgQuantityVO>
	 * @throws EventException
	 */
	public List<BkgQuantityVO> searchAGTCommDetailTypeSizeQty(AgtAgnCommVO agtAgnCommVO) throws EventException;
	/**
	 * ESM_AGT_0012 Rating retrieve event process
	 * @param AgtAgnCommVO agtAgnCommVO
	 * @return List<BkgAgnCommDeductionRatingVO>
	 * @throws EventException
	 */
	public List<BkgAgnCommDeductionRatingVO> searchAGTCommDeductionRating(AgtAgnCommVO agtAgnCommVO) throws EventException;
	/**
	 * ESM_AGT_0012 Total retrieve event process
	 * @param AgtAgnCommVO agtAgnCommVO
	 * @return List<BkgAgnCommDeductionRatingVO>
	 * @throws EventException
	 */
	public List<BkgAgnCommDeductionRatingVO> searchAGTCommDeductionTotal(AgtAgnCommVO agtAgnCommVO) throws EventException;
	/**
	 * ESM_AGT_0012 Total info retrieve event process
	 * @param AgtAgnCommVO agtAgnCommVO
	 * @return List<BkgAgnCommDeductionRatingVO>
	 * @throws EventException
	 */
	public List<BkgAgnCommDeductionRatingVO> searchAGTCommDeductionTotalInfo(AgtAgnCommVO agtAgnCommVO) throws EventException;
	/**
	 * ESM_AGT_0012  Deducted Charge retrieve event process
	 * @param AgtAgnCommVO agtAgnCommVO
	 * @return List<BkgAgtChgDdctVO>
	 * @throws EventException
	 */
	public List<BkgAgtChgDdctVO> searchAGTCommDeductionCharge(AgtAgnCommVO agtAgnCommVO) throws EventException;
	/**
	 * ESM_AGT_0012 Deducted Transportation Cost retrieve event process
	 * @param AgtAgnCommVO agtAgnCommVO
	 * @return List<DeductionChargeVO>
	 * @throws EventException
	 */
	public List<DeductionChargeVO> searchAGTCommDeductionTrspCost(AgtAgnCommVO agtAgnCommVO) throws EventException;

	/**
	 * ESM_AGT_0012 Gross / Net, Net Ocean Revenue retrieve event process
	 * @param AgtAgnCommVO agtAgnCommVO
	 * @return List<GrsNetCDVO>
	 * @throws EventException
	 */
	public List<GrsNetCDVO> searchAGTCommGrsNetCD(AgtAgnCommVO agtAgnCommVO) throws EventException;

	/**
	 * (ESM_AGT_0016) Other Commission Approval retrieve event process<br>
	 * @param AgtAgnCommVO agtAgnCommVO
	 * @return List<AgtAgnCommVO>
	 * @exception EventException
	 */
	public List<AgtAgnCommVO> searchOtherCommforApproval(AgtAgnCommVO agtAgnCommVO) throws EventException;

	/**
	 * (ESM_AGT_0016) Other Commission Approval multi event process<br>
	 * @param AgtAgnCommVO[] agtAgnCommVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void multiOtherCommforApproval(AgtAgnCommVO[] agtAgnCommVOs, SignOnUserAccount account) throws EventException;

	/**
	 * (ESM_AGT_0016) Other Commission Approval Detail modify event process<br>
	 * @param AgtAgnCommVO[] agtAgnCommVOs
	 * @param AgtAgnCommDtlVO[] agtAgnCommDtlVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void multiOtherCommforApprovalDtl(AgtAgnCommVO[] agtAgnCommVOs, AgtAgnCommDtlVO[] agtAgnCommDtlVOs, SignOnUserAccount account) throws EventException;

	/**
	 * (ESM_AGT_0016) Other Commission Approval Reject event process<br>
	 * @param AgtAgnCommVO[] agtAgnCommVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void multiOtherCommforApprovalReject(AgtAgnCommVO[] agtAgnCommVOs, SignOnUserAccount account) throws EventException;

	/**
	 * (ESM_AGT_0016) Other Commission Approval Cancel event process<br>
	 * @param AgtAgnCommVO[] agtAgnCommVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void multiOtherCommforApprovalCancel(AgtAgnCommVO[] agtAgnCommVOs, SignOnUserAccount account) throws EventException;
	/**
	 * (ESM_AGT_017) Agent Commission AP Interface retrieve event process<br>
	 * 
	 * @param APActualInterfaceMasterVO apActualInterfaceMasterVO
	 * @return List<APActualInterfaceMasterVO>
	 * @exception EventException
	 */
	public List<APActualInterfaceMasterVO> searchAPActualInterfaceMaster(APActualInterfaceMasterVO apActualInterfaceMasterVO) throws EventException;
	/**
	 * (ESM_AGT_017) Agent Commission AP Interface retrieve event process<br>
	 * 
	 * @param APActualInterfaceDetailVO apActualInterfaceDetailVO
	 * @return List<APActualInterfaceDetailVO>
	 * @exception EventException
	 */
	public List<APActualInterfaceDetailVO> searchAPActualInterfaceDetail(APActualInterfaceDetailVO apActualInterfaceDetailVO) throws EventException;
	/**
	 * (ESM_AGT_017) Agent Commission AP Interface list Interface event process<br>
	 * 
	 * @param APActualInterfaceMasterVO[] apActualInterfaceMasterVOs
	 * @param APActualInterfaceMasterVO apActualInterfaceMasterVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createAgentActualINFtoAP(APActualInterfaceMasterVO[] apActualInterfaceMasterVOs, APActualInterfaceMasterVO apActualInterfaceMasterVO, SignOnUserAccount account) throws EventException;
	/**
     * ESM_AGT_017 AP Interface event process : EP Approval receive + CSR I/F<br>
     * 
     * @param  String result
     * @param String csrNo
     * @param ComAproRqstRoutVO model
     * @return FNS0080003Document[] 
     * @throws EventException
     */
	public FNS0080003Document[] transferAgentActualINFtoAP1(String result, String csrNo, ComAproRqstRoutVO model) throws EventException;
	/**
     * ESM_AGT_017 AP Interface event process : EP Approval receive + CSR I/F<br>
     * 
     * @param  String result
     * @param String csrNo
     * @param ComAproRqstRoutVO model
     * @return String
     * @throws EventException   
     */
	public String transferAgentActualINFtoAP2(String result, String csrNo, ComAproRqstRoutVO model) throws EventException;

	/**
	 * (ESM_AGT_017) Agent Commission AP Interface Cancel event process<br>
	 * 
	 * @param APActualInterfaceMasterVO apActualInterfaceMasterVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createCancelAgentActualINFtoAP(APActualInterfaceMasterVO apActualInterfaceMasterVO, SignOnUserAccount account) throws EventException;
	/**
	 * ESM_AGT_017 Report print event process<br>
	 * @param AGTCommInfoForPrintVO agtCommInfoForPrintVO
	 * @return List<AGTCommInfoForPrintVO>
	 * @throws EventException
	 */
	public List<AGTCommInfoForPrintVO> searchAGTCommInfoForPrint1(AGTCommInfoForPrintVO agtCommInfoForPrintVO) throws EventException;
	/**
	 * ESM_AGT_017 Report print event process<br>
	 * @param AGTCommInfoForPrint2VO agtCommInfoForPrint2VO
	 * @return List<AGTCommInfoForPrint2VO>
	 * @throws EventException
	 */
	public List<AGTCommInfoForPrint2VO> searchAGTCommInfoForPrint2(AGTCommInfoForPrint2VO agtCommInfoForPrint2VO) throws EventException;
	/**
	 * (ESM_AGT_0036) Agent Commission Approval No retrieve event process<br>
	 * @param AgtAgnCommVO agtAgnCommVO
	 * @return List<AgtAgnCommVO>
	 * @throws EventException
	 */
	public List<AgtAgnCommVO> searchAGTCommApprovalNo(AgtAgnCommVO agtAgnCommVO) throws EventException;

	/**
	 * (ESM_AGT_0036) Agent Commission Approval retrieve event process<br>
	 * @param AgtAgnCommVO agtAgnCommVO
	 * @return List<AgtAgnCommVO>
	 * @throws EventException
	 */
	public List<AgtAgnCommVO> searchAGTCommTobeApproved(AgtAgnCommVO agtAgnCommVO) throws EventException;
	/**
	 * (ESM_AGT_0036) Agent Commission Approval Confirm event process<br>
	 * @param AgtAgnCommVO[] agtAgnCommVOS
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void modifyAGTCommTobeApproved(AgtAgnCommVO[] agtAgnCommVOS, SignOnUserAccount account) throws EventException;

	/** (ESM_AGT_0039) Agent Commission Maintenance & Audit retrieve event process<br>
	 * 
	 * @param AgtCommListVO agtCommListVO
	 * @return List<AgtCommListVO>
	 * @exception EventException
	 */
	public List<AgtCommListVO> searchAGTCommForAudit(AgtCommListVO agtCommListVO) throws EventException;


	/** (ESM_AGT_0039) Agent Commission Maintenance & Audit retrieve event process<br>
	 * 
	 * @param AgtCommListVO[] agtCommListVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyAGTCommForAudit(AgtCommListVO[] agtCommListVOs, SignOnUserAccount account) throws EventException;


	/** (ESM_AGT_0039) Agent Commission Maintenance & Audit retrieve event process<br>
	 * 
	 * @param AgtCommListVO[] agtCommListVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyCancelAGTCommForAudit(AgtCommListVO[] agtCommListVOs, SignOnUserAccount account) throws EventException;


	/** (ESM_AGT_0039) Agent Commission Maintenance & Audit retrieve event process<br>
	 * 
	 * @param AgtCommListVO[] agtCommListVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyRejectAGTCommForAudit(AgtCommListVO[] agtCommListVOs, SignOnUserAccount account) throws EventException;
	/**
	 * (ESM_AGT_0042) Other Commission Request retrieve event process<br>
	 * 
	 * @param AgtAgnCommVO agtAgnCommVO
	 * @return List<AgtAgnCommVO>
	 * @exception EventException
	 */
	public List<AgtAgnCommVO> searchOtherCommForRequest(AgtAgnCommVO agtAgnCommVO) throws EventException;
	/**
	 * ESM_AGT_0042) Other Commission Maintenance & Request Master information Request event process<br> 
	 * @param AgtAgnCommVO[] agtAgnCommVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void modifyOtherCommForRequest(AgtAgnCommVO[] agtAgnCommVOs, SignOnUserAccount account) throws EventException;

	/**
	 * ESM_AGT_0042) Other Commission Maintenance & Request multi event process<br> 
	 * @param AgtAgnCommVO[] agtAgnCommVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void multiOtherCommForRequest(AgtAgnCommVO[] agtAgnCommVOs, SignOnUserAccount account) throws EventException;
	/**
	 * ESM_AGT-0043 retrieve event process
	 * @param CSRDetailforCommissionHdrVO csrDetailforCommissionHdrVO
	 * @return List<CSRDetailforCommissionHdrVO>
	 * @throws EventException
	 */
	public List<CSRDetailforCommissionHdrVO> searchCSRDetailforCommissionHdr(CSRDetailforCommissionHdrVO csrDetailforCommissionHdrVO) throws EventException;
	/**
	 * ESM_AGT-0043 retrieve event process
	 * @param CSRDetailforCommissionDtrbVO csrDetailforCommissionDtrbVO
	 * @return List<CSRDetailforCommissionDtrbVO>
	 * @throws EventException
	 */
	public List<CSRDetailforCommissionDtrbVO> searchCSRDetailforCommissionDtrb(CSRDetailforCommissionDtrbVO csrDetailforCommissionDtrbVO) throws EventException;
	/**
	 * (ESM_AGT_0051) Other Commission Approval retrieve event process<br>
	 * @param AgtCommListVO agtCommListVO
	 * @return List<AgtCommListVO>
	 * @exception EventException
	 */
	public List<AgtCommListVO> searchBKGList(AgtCommListVO agtCommListVO) throws EventException;
	/**
	 * (ESM_AGT_0051) Other Commission Approval retrieve event process.<br>
	 * @param AgtCommListVO agtCommListVO
	 * @return List<AgtCommListVO>
	 * @exception EventException
	 */
	public List<AgtCommListVO> searchAGTCommList(AgtCommListVO agtCommListVO) throws EventException;
	
	/**
	 * (ESM_AGT_0047) Agent Commission Approval No retrieve event process<br>
	 * @param AGTVVDRateVO agtVVDRateVO
	 * @return List<AGTVVDRateVO>
	 * @throws EventException
	 */
	public List<AGTVVDRateVO> searchVVDRateList(AGTVVDRateVO agtVVDRateVO) throws EventException;
	/**
	 * When I/F Fail, RollBacke event process<br>
	 * ESM_AGT_0017 RollBacke event process<br>
	 * 
	 * @param csr_no String
	 * @exception EventException
	 */	
	public void modifyAGTCommIFBack(String csr_no) throws EventException;
	
	
	/**
	 * (ESM_AGT_017) Agent Commission AP Interface retrieve event process<br>
	 * 
	 * @param AgtApPayInvVO agtApPayInvVO
	 * @exception EventException
	 */	
	public ApPayInvVO searchAgtApPayInv(APActualInterfaceMasterVO aPActualInterfaceMasterVO) throws EventException;
	
	/**
	 * (ESM_AGT_017) Agent Commission AP Interface retrieve event process<br>
	 * 
	 * @param AgtApPayInvVO agtApPayInvVO, ApPayInvVO apPayInvVO	
	 * @exception EventException
	 */	
	public ApPayInvDtlVO[] searchAgtApPayInvDtl(APActualInterfaceMasterVO aPActualInterfaceMasterVO) throws EventException;

	/**
	 * (ESM_AGT_017) Agent Commission status event process<br>
	 * 
	 * @param String string , SignOnUserAccount account	
	 * @exception EventException
	 */
	public void modifyAGTCommProcStsCd( ApPayInvVO apPayInvVO) throws EventException ;

	
}