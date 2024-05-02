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
package com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.vo.AGTCommInfoForPrint2VO;
import com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.vo.AGTCommInfoForPrintVO;
import com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.vo.AGTVVDRateVO;
import com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.vo.APActualInterfaceDetailVO;
import com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.vo.APActualInterfaceMasterVO;
import com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.vo.AgtCommBasicInformationVO;
import com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.vo.AgtCommListVO;
import com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.vo.AgtRptItmInfoMstDtlVO;
import com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.vo.BkgAgnCommDeductionRatingVO;
import com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.vo.BkgAgtChgDdctVO;
import com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.vo.CSRDetailforCommissionDtrbVO;
import com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.vo.CSRDetailforCommissionHdrVO;
import com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.vo.DeductionChargeVO;
import com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.vo.GrsNetCDVO;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.irep.enis.FNS0080003Document;
import com.hanjin.syscommon.common.table.AgtAgnCommDtlVO;
import com.hanjin.syscommon.common.table.AgtAgnCommVO;
import com.hanjin.syscommon.common.table.AgtCommBkgInfoVO;
import com.hanjin.syscommon.common.table.AgtRptItmInfoDtlVO;
import com.hanjin.syscommon.common.table.BkgQuantityVO;
import com.hanjin.syscommon.common.table.COM_APRO_RQST_ROUT;
import com.hanjin.syscommon.common.table.ComAproRqstRoutVO;

/**
 * ALPS-Agtaudit Business Logic Command Interface<br>
 * - ALPS-Agtaudit에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Lee Ho Jin
 * @see Esmagt016EventResponse 참조
 * @since J2EE 1.6
 */

public interface AGTAuditBC {
	/**
	 * (ESM_AGT_010) Other Commission Approval의 정보를 조회한다.<br>
	 * 
	 * @param AgtCommListVO agtCommListVO
	 * @return List<AgtCommListVO>
	 * @exception EventException
	 */
	public List<AgtCommListVO> searchAGTCommForRequest(AgtCommListVO agtCommListVO) throws EventException;
	/**
	 * (ESM_AGT_010) Other Commission Approval의 정보를 조회한다.<br>
	 * @param AgtCommListVO[] agtCommListVOs
	 * @param SignOnUserAccount account
	 * @return DBRowSet
	 * @exception EventException
	 */
	public DBRowSet modifyAGTCommForRequest(AgtCommListVO[] agtCommListVOs, SignOnUserAccount account) throws EventException;
	/**
	 * (ESM_AGT_010) Other Commission Approval의 정보를 조회한다.<br>
	 * 
	 * @param DBRowSet dRs
	 * @exception EventException
	 */
	public void sendChnPantoEDIIF(DBRowSet dRs) throws EventException;
	/**
	 * ex.Rate/Local Amount 재계산 이벤트 처리<br>
	 * ESM_AGT_010 화면에 대한 ex.Rate/Local Amount 재계산 이벤트 처리<br>
	 * @param AgtCommListVO[] agtCommListVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyAGTCommExRateByRequest(AgtCommListVO[] agtCommListVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_AGT_0010 화면에서 Agreement Commission recalculate버튼 클릭시 처리 한다.<br>
	 * 
	 * @param AgtCommListVO[] agtCommListVOs
	 * @exception EventException
	 */
	public void createAGTCommByRequest(AgtCommListVO[] agtCommListVOs) throws EventException;
	
	/**
	 * ESM_AGT_0011 화면 대한 Calculation History 정보<br>
	 * @param AgtAgnCommVO agtAgnCommVO
	 * @return List<AgtAgnCommVO>
	 * @throws EventException
	 */
	public List<AgtAgnCommVO> searchAGTCommCalculationHistory(AgtAgnCommVO agtAgnCommVO) throws EventException;
	/**
	 * ESM_AGT_0011 화면 대한 Commission Detail Amount 정보<br>
	 * @param AgtAgnCommVO agtAgnCommVO
	 * @return List<AgtAgnCommVO>
	 * @throws EventException
	 */
	public List<AgtAgnCommVO> searchAGTCommCommissionDetailAmount(AgtAgnCommVO agtAgnCommVO) throws EventException;
	/**
	 * ESM_AGT_0011 화면 대한 Basic Information 정보<br>
	 * @param AgtAgnCommVO agtAgnCommVO
	 * @return List<AgtCommBasicInformationVO>
	 * @throws EventException
	 */
	public List<AgtCommBasicInformationVO> searchAGTCommBasicInformation(AgtAgnCommVO agtAgnCommVO) throws EventException;
	/**
	 * ESM_AGT_0011 화면 대한 TP/SZ QTY 정보<br>
	 * @param AgtAgnCommVO agtAgnCommVO
	 * @return List<BkgQuantityVO>
	 * @throws EventException
	 */
	public List<BkgQuantityVO> searchAGTCommDetailTypeSizeQty(AgtAgnCommVO agtAgnCommVO) throws EventException;
	/**
	 * ESM_AGT_0012 화면 대한 Rating 정보
	 * @param AgtAgnCommVO agtAgnCommVO
	 * @return List<BkgAgnCommDeductionRatingVO>
	 * @throws EventException
	 */
	public List<BkgAgnCommDeductionRatingVO> searchAGTCommDeductionRating(AgtAgnCommVO agtAgnCommVO) throws EventException;
	/**
	 * ESM_AGT_0012 화면 대한 Total 정보
	 * @param AgtAgnCommVO agtAgnCommVO
	 * @return List<BkgAgnCommDeductionRatingVO>
	 * @throws EventException
	 */
	public List<BkgAgnCommDeductionRatingVO> searchAGTCommDeductionTotal(AgtAgnCommVO agtAgnCommVO) throws EventException;
	/**
	 * ESM_AGT_0012 화면 대한 Total info 정보
	 * @param AgtAgnCommVO agtAgnCommVO
	 * @return List<BkgAgnCommDeductionRatingVO>
	 * @throws EventException
	 */
	public List<BkgAgnCommDeductionRatingVO> searchAGTCommDeductionTotalInfo(AgtAgnCommVO agtAgnCommVO) throws EventException;
	/**
	 * ESM_AGT_0012 화면 대한 Deducted Charge 조회
	 * @param AgtAgnCommVO agtAgnCommVO
	 * @return List<BkgAgtChgDdctVO>
	 * @throws EventException
	 */
	public List<BkgAgtChgDdctVO> searchAGTCommDeductionCharge(AgtAgnCommVO agtAgnCommVO) throws EventException;
	/**
	 * ESM_AGT_0012 화면 대한 Deducted Transportation Cost 조회
	 * @param AgtAgnCommVO agtAgnCommVO
	 * @return List<DeductionChargeVO>
	 * @throws EventException
	 */
	public List<DeductionChargeVO> searchAGTCommDeductionTrspCost(AgtAgnCommVO agtAgnCommVO) throws EventException;

	/**
	 * ESM_AGT_0012 화면 대한 Gross / Net, Net Ocean Revenue 조회
	 * @param AgtAgnCommVO agtAgnCommVO
	 * @return List<GrsNetCDVO>
	 * @throws EventException
	 */
	public List<GrsNetCDVO> searchAGTCommGrsNetCD(AgtAgnCommVO agtAgnCommVO) throws EventException;

	/**
	 * (ESM_AGT_0016) Other Commission Approval의 정보를 조회한다.<br>
	 * @param AgtAgnCommVO agtAgnCommVO
	 * @return List<AgtAgnCommVO>
	 * @exception EventException
	 */
	public List<AgtAgnCommVO> searchOtherCommforApproval(AgtAgnCommVO agtAgnCommVO) throws EventException;

	/**
	 * (ESM_AGT_0016) Other Commission Approval의 정보를 수정 한다.<br>
	 * @param AgtAgnCommVO[] agtAgnCommVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void multiOtherCommforApproval(AgtAgnCommVO[] agtAgnCommVOs, SignOnUserAccount account) throws EventException;

	/**
	 * (ESM_AGT_0016) Other Commission Approval의 Detail 정보를 수정 한다.<br>
	 * @param AgtAgnCommVO[] agtAgnCommVOs
	 * @param AgtAgnCommDtlVO[] agtAgnCommDtlVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void multiOtherCommforApprovalDtl(AgtAgnCommVO[] agtAgnCommVOs, AgtAgnCommDtlVO[] agtAgnCommDtlVOs, SignOnUserAccount account) throws EventException;

	/**
	 * (ESM_AGT_0016) Other Commission Approval의 정보를 Reject 한다.<br>
	 * @param AgtAgnCommVO[] agtAgnCommVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void multiOtherCommforApprovalReject(AgtAgnCommVO[] agtAgnCommVOs, SignOnUserAccount account) throws EventException;

	/**
	 * (ESM_AGT_0016) Other Commission Approval의 정보를 Cancel 한다.<br>
	 * @param AgtAgnCommVO[] agtAgnCommVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void multiOtherCommforApprovalCancel(AgtAgnCommVO[] agtAgnCommVOs, SignOnUserAccount account) throws EventException;
	/**
	 * (ESM_AGT_017) Agent Commission AP Interface 대상리스트를 가져온다.<br>
	 * 
	 * @param APActualInterfaceMasterVO apActualInterfaceMasterVO
	 * @return List<APActualInterfaceMasterVO>
	 * @exception EventException
	 */
	public List<APActualInterfaceMasterVO> searchAPActualInterfaceMaster(APActualInterfaceMasterVO apActualInterfaceMasterVO) throws EventException;
	/**
	 * (ESM_AGT_017) Agent Commission AP Interface 대상리스트를 가져온다.<br>
	 * 
	 * @param APActualInterfaceDetailVO apActualInterfaceDetailVO
	 * @return List<APActualInterfaceDetailVO>
	 * @exception EventException
	 */
	public List<APActualInterfaceDetailVO> searchAPActualInterfaceDetail(APActualInterfaceDetailVO apActualInterfaceDetailVO) throws EventException;
	/**
	 * (ESM_AGT_017) Agent Commission AP Interface 대상리스트를 Interface한다.<br>
	 * 
	 * @param APActualInterfaceMasterVO[] apActualInterfaceMasterVOs
	 * @param APActualInterfaceMasterVO apActualInterfaceMasterVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createAgentActualINFtoAP(APActualInterfaceMasterVO[] apActualInterfaceMasterVOs, APActualInterfaceMasterVO apActualInterfaceMasterVO, SignOnUserAccount account) throws EventException;
	/**
     * ESM_AGT_017 화면에 대한 AP Interface 이벤트 처리(1) : EP결재 수신 + CSR I/F<br>
     * 
     * @param  String result
     * @param String csrNo
     * @param ComAproRqstRoutVO model
     * @return FNS0080003Document[] 
     * @throws EventException
     */
	public FNS0080003Document[] transferAgentActualINFtoAP1(String result, String csrNo, ComAproRqstRoutVO model) throws EventException;
	/**
     * ESM_AGT_017 화면에 대한 AP Interface 이벤트 처리(1) : EP결재 수신 + CSR I/F<br>
     * 
     * @param  String result
     * @param String csrNo
     * @param ComAproRqstRoutVO model
     * @return String
     * @throws EventException   
     */
	public String transferAgentActualINFtoAP2(String result, String csrNo, ComAproRqstRoutVO model) throws EventException;

	/**
	 * (ESM_AGT_017) Agent Commission AP Interface 대상리스트를 취소한다.<br>
	 * 
	 * @param APActualInterfaceMasterVO apActualInterfaceMasterVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createCancelAgentActualINFtoAP(APActualInterfaceMasterVO apActualInterfaceMasterVO, SignOnUserAccount account) throws EventException;
	/**
	 * ESM_AGT_017 화면에 대한 보고서 출력 이벤트 처리<br>
	 * @param AGTCommInfoForPrintVO agtCommInfoForPrintVO
	 * @return List<AGTCommInfoForPrintVO>
	 * @throws EventException
	 */
	public List<AGTCommInfoForPrintVO> searchAGTCommInfoForPrint1(AGTCommInfoForPrintVO agtCommInfoForPrintVO) throws EventException;
	/**
	 * ESM_AGT_017 화면에 대한 보고서 출력 이벤트 처리<br>
	 * @param AGTCommInfoForPrint2VO agtCommInfoForPrint2VO
	 * @return List<AGTCommInfoForPrint2VO>
	 * @throws EventException
	 */
	public List<AGTCommInfoForPrint2VO> searchAGTCommInfoForPrint2(AGTCommInfoForPrint2VO agtCommInfoForPrint2VO) throws EventException;
	/**
	 * (ESM_AGT_0036) Agent Commission Approval No 를 생성한다.<br>
	 * @param AgtAgnCommVO agtAgnCommVO
	 * @return List<AgtAgnCommVO>
	 * @throws EventException
	 */
	public List<AgtAgnCommVO> searchAGTCommApprovalNo(AgtAgnCommVO agtAgnCommVO) throws EventException;

	/**
	 * (ESM_AGT_0036) Agent Commission Approval 를 조회한다.<br>
	 * @param AgtAgnCommVO agtAgnCommVO
	 * @return List<AgtAgnCommVO>
	 * @throws EventException
	 */
	public List<AgtAgnCommVO> searchAGTCommTobeApproved(AgtAgnCommVO agtAgnCommVO) throws EventException;
	/**
	 * (ESM_AGT_0036) Agent Commission Approval 를 Confirm 한다.<br>
	 * @param AgtAgnCommVO[] agtAgnCommVOS
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void modifyAGTCommTobeApproved(AgtAgnCommVO[] agtAgnCommVOS, SignOnUserAccount account) throws EventException;
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param AgtCommBkgInfoVO agtCommBkgInfoVO
	 * @return List<AgtCommBkgInfoVO>
	 * @exception EventException
	 */
	public List<AgtCommBkgInfoVO> searchAGTCommforReportbyCustomizedOption(AgtCommBkgInfoVO agtCommBkgInfoVO) throws EventException;
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * ESM_AGT_0040
	 * @param AgtRptItmInfoDtlVO agtRptItmInfoDtlVO
	 * @return List<AgtRptItmInfoDtlVO>
	 * @exception EventException
	 */
	public List<AgtRptItmInfoDtlVO> searchRptItem(AgtRptItmInfoDtlVO agtRptItmInfoDtlVO) throws EventException;

	/** (ESM_AGT_0039) Agent Commission Maintenance & Audit의 정보를 조회한다.<br>
	 * 
	 * @param AgtCommListVO agtCommListVO
	 * @return List<AgtCommListVO>
	 * @exception EventException
	 */
	public List<AgtCommListVO> searchAGTCommForAudit(AgtCommListVO agtCommListVO) throws EventException;


	/** (ESM_AGT_0039) Agent Commission Maintenance & Audit의 정보를 조회한다.<br>
	 * 
	 * @param AgtCommListVO[] agtCommListVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyAGTCommForAudit(AgtCommListVO[] agtCommListVOs, SignOnUserAccount account) throws EventException;


	/** (ESM_AGT_0039) Agent Commission Maintenance & Audit의 정보를 조회한다.<br>
	 * 
	 * @param AgtCommListVO[] agtCommListVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyCancelAGTCommForAudit(AgtCommListVO[] agtCommListVOs, SignOnUserAccount account) throws EventException;


	/** (ESM_AGT_0039) Agent Commission Maintenance & Audit의 정보를 조회한다.<br>
	 * 
	 * @param AgtCommListVO[] agtCommListVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyRejectAGTCommForAudit(AgtCommListVO[] agtCommListVOs, SignOnUserAccount account) throws EventException;
	/**
	 * ESM_AGT_0041 화면에서 기본 컬럼 정보를 조회<br>
	 * @param AgtRptItmInfoMstDtlVO agtRptItmInfoMstDtlVO
	 * @param SignOnUserAccount account
	 * @return List<AgtRptItmInfoMstDtlVO>
	 * @throws EventException
	 * @author Ho-Jin Lee
	 */
	public List<AgtRptItmInfoMstDtlVO> searchAGTDimensionReportbyMultiOption(AgtRptItmInfoMstDtlVO agtRptItmInfoMstDtlVO, SignOnUserAccount account) throws EventException;
	/**
	 * ESM_AGT_0041 화면에서 RPT Form 선택시 컬럼 정보를 조회<br>
	 * @param AgtRptItmInfoMstDtlVO agtRptItmInfoMstDtlVO
	 * @param SignOnUserAccount account
	 * @return List<AgtRptItmInfoMstDtlVO>
	 * @throws EventException
	 */
	public List<AgtRptItmInfoMstDtlVO> searchAGTDimensionReportbyMultiOption1(AgtRptItmInfoMstDtlVO agtRptItmInfoMstDtlVO, SignOnUserAccount account) throws EventException;
	/**
	 * ESM_AGT_0041 화면에서 Save
	 * @param AgtRptItmInfoMstDtlVO[] agtRptItmInfoMstDtlVOS
	 * @param AgtRptItmInfoMstDtlVO agtRptItmInfoMstDtlVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void multiAGTDimensionReportbyMultiOption(AgtRptItmInfoMstDtlVO[] agtRptItmInfoMstDtlVOS, AgtRptItmInfoMstDtlVO agtRptItmInfoMstDtlVO, SignOnUserAccount account) throws EventException;
	/**
	 * (ESM_AGT_0042) Other Commission Request의 정보를 조회한다.<br>
	 * 
	 * @param AgtAgnCommVO agtAgnCommVO
	 * @return List<AgtAgnCommVO>
	 * @exception EventException
	 */
	public List<AgtAgnCommVO> searchOtherCommForRequest(AgtAgnCommVO agtAgnCommVO) throws EventException;
	/**
	 * ESM_AGT_0042) Other Commission Maintenance & Request 의 Master 정보를 Request한다.<br> 
	 * @param AgtAgnCommVO[] agtAgnCommVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void modifyOtherCommForRequest(AgtAgnCommVO[] agtAgnCommVOs, SignOnUserAccount account) throws EventException;

	/**
	 * ESM_AGT_0042) Other Commission Maintenance & Request 의 정보를 추가,수정, 삭제한다.<br> 
	 * @param AgtAgnCommVO[] agtAgnCommVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void multiOtherCommForRequest(AgtAgnCommVO[] agtAgnCommVOs, SignOnUserAccount account) throws EventException;
	/**
	 * ESM_AGT-0043 화면 조회
	 * @param CSRDetailforCommissionHdrVO csrDetailforCommissionHdrVO
	 * @return List<CSRDetailforCommissionHdrVO>
	 * @throws EventException
	 */
	public List<CSRDetailforCommissionHdrVO> searchCSRDetailforCommissionHdr(CSRDetailforCommissionHdrVO csrDetailforCommissionHdrVO) throws EventException;
	/**
	 * ESM_AGT-0043 화면 조회
	 * @param CSRDetailforCommissionDtrbVO csrDetailforCommissionDtrbVO
	 * @return List<CSRDetailforCommissionDtrbVO>
	 * @throws EventException
	 */
	public List<CSRDetailforCommissionDtrbVO> searchCSRDetailforCommissionDtrb(CSRDetailforCommissionDtrbVO csrDetailforCommissionDtrbVO) throws EventException;
	/**
	 * (ESM_AGT_0051) Other Commission Approval의 정보를 조회한다.<br>
	 * @param AgtCommListVO agtCommListVO
	 * @return List<AgtCommListVO>
	 * @exception EventException
	 */
	public List<AgtCommListVO> searchBKGList(AgtCommListVO agtCommListVO) throws EventException;

	/**
	 * (ESM_AGT_0051) Other Commission Approval의 정보를 조회한다.<br>
	 * @param AgtCommListVO agtCommListVO
	 * @return List<AgtCommListVO>
	 * @exception EventException
	 */
	public List<AgtCommListVO> searchAGTCommList(AgtCommListVO agtCommListVO) throws EventException;
	
	/**
	 * (ESM_AGT_0047) Agent Commission Approval No 를 생성한다.<br>
	 * @param AGTVVDRateVO agtVVDRateVO
	 * @return List<AGTVVDRateVO>
	 * @throws EventException
	 */
	public List<AGTVVDRateVO> searchVVDRateList(AGTVVDRateVO agtVVDRateVO) throws EventException;
	/**
	 * I/F 실패 시 RollBacke 처리<br>
	 * ESM_AGT_0017 화면에서 조회되도록 처리<br>
	 * 
	 * @param csr_no String
	 * @exception EventException
	 */	
	public void modifyAGTCommIFBack(String csr_no) throws EventException;	
}