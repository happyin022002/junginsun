/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCTransportationAdditionalChargeProposalBC.java
*@FileTitle : S/C Proposal Origin/Destination Arbitrary Charge Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.18
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.05.18 김재연
* 1.0 Creation
* 
* 2012.02.23 이석준[CHM-201216153-01] S/C Amendment History 화면 기능 개선 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.sctransportationadditionalchargeproposal.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scgricalculationproposal.vo.PriSpScpTrspAddChgGriArbOKCLListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPropCopyVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.SpScpGlineCopyVO;
import com.hanjin.apps.alps.esm.pri.scproposal.sctransportationadditionalchargeproposal.vo.ArbitraryExcelDupCheckVO;
import com.hanjin.apps.alps.esm.pri.scproposal.sctransportationadditionalchargeproposal.vo.ChkFontStyleVO;
import com.hanjin.apps.alps.esm.pri.scproposal.sctransportationadditionalchargeproposal.vo.CstArbAcceptVO;
import com.hanjin.apps.alps.esm.pri.scproposal.sctransportationadditionalchargeproposal.vo.CstPriSpScpTrspAddChgVO;
import com.hanjin.apps.alps.esm.pri.scproposal.sctransportationadditionalchargeproposal.vo.IHCExcelDupCheckVO;
import com.hanjin.apps.alps.esm.pri.scproposal.sctransportationadditionalchargeproposal.vo.RsltAddChgListVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriSpMnVO;
import com.hanjin.syscommon.common.table.PriSpScpMnVO;
import com.hanjin.syscommon.common.table.PriSpScpTrspAddChgVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.PriSpHistoryInquiryParamVO;

/**
 * NIS2010-Scproposal Business Logic Command Interface<br>
 * - NIS2010-Scproposal에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author JaeYeon Kim
 * @see Esm_pri_0003_04EventResponse 참조
 * @since J2EE 1.4
 */

public interface SCTransportationAdditionalChargeProposalBC {
	
	/** 
	 * Arbitrary List를 조회한다. <br>
	 * 
	 * @param PriSpScpTrspAddChgVO priSpScpTrspAddChgVO
	 * @return List<RsltArbChgListVO>
	 * @exception EventException
	 */
	public List<RsltAddChgListVO> searchArbitraryChargeList(PriSpScpTrspAddChgVO priSpScpTrspAddChgVO) throws EventException;
	 
	/**
	 * Arbitrary List를 수정한다. <br>
	 * 
	 * @param PriSpScpTrspAddChgVO[] priSpScpTrspAddChgVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageArbitraryCharge(PriSpScpTrspAddChgVO[] priSpScpTrspAddChgVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Arbitrary Accept를 진행한다. <br>
	 * 
	 * @param PriSpScpTrspAddChgVO[] priSpScpTrspAddChgVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptArbitraryCharge(PriSpScpTrspAddChgVO[] priSpScpTrspAddChgVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Arbitrary Accept Cancel을 진행한다. <br>
	 * 
	 * @param PriSpScpTrspAddChgVO[] priSpScpTrspAddChgVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelArbitraryCharge(PriSpScpTrspAddChgVO[] priSpScpTrspAddChgVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Arbitrary Accept All을 진행한다. <br>
	 * 
	 * @param PriSpScpTrspAddChgVO[] priSpScpTrspAddChgVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptAllArbitraryCharge(PriSpScpTrspAddChgVO[] priSpScpTrspAddChgVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Arbitrary Accept All을 진행한다. <br>
	 * 
	 * @param CstArbAcceptVO cstArbAcceptVO
	 * @param SignOnUserAccount account
	 * @return int
	 * @exception EventException
	 */
	public int acceptAllArbitraryChargeFast(CstArbAcceptVO cstArbAcceptVO, SignOnUserAccount account) throws EventException;	
	
	
	/**
	 * Arbitrary Accept Cancel All을 진행한다. <br>
	 * 
	 * @param PriSpScpTrspAddChgVO[] priSpScpTrspAddChgVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelAllArbitraryCharge(PriSpScpTrspAddChgVO[] priSpScpTrspAddChgVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Arbitrary Accept Cancel All을 진행한다. <br>
	 * 
	 * @param CstArbAcceptVO cstArbAcceptVO
	 * @param SignOnUserAccount account
	 * @return int
	 * @exception EventException
	 */
	public int cancelAllArbitraryChargeFast(CstArbAcceptVO cstArbAcceptVO, SignOnUserAccount account) throws EventException;	
	/**
	 * IHC List를 조회한다. <br>
	 * 
	 * @param PriSpScpTrspAddChgVO priSpScpTrspAddChgVO
	 * @return List<RsltArbChgListVO>
	 * @exception EventException
	 */
	public List<RsltAddChgListVO> searchIHCChargeList(PriSpScpTrspAddChgVO priSpScpTrspAddChgVO) throws EventException;
	
	/**
	 * IHC List를 수정한다. <br>
	 * 
	 * @param PriSpScpTrspAddChgVO[] priSpScpTrspAddChgVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageIHCCharge(PriSpScpTrspAddChgVO[] priSpScpTrspAddChgVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * IHC Accept를 진행한다. <br>
	 * 
	 * @param PriSpScpTrspAddChgVO[] priSpScpTrspAddChgVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptIHCCharge(PriSpScpTrspAddChgVO[] priSpScpTrspAddChgVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * IHC Accept Cancel 진행한다. <br>
	 * 
	 * @param PriSpScpTrspAddChgVO[] priSpScpTrspAddChgVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelIHCCharge(PriSpScpTrspAddChgVO[] priSpScpTrspAddChgVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * IHC Accept All을 진행한다. <br>
	 * 
	 * @param PriSpScpTrspAddChgVO[] priSpScpTrspAddChgVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptAllIHCCharge(PriSpScpTrspAddChgVO[] priSpScpTrspAddChgVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * IHC Accept Cancel All을 진행한다. <br>
	 * 
	 * @param PriSpScpTrspAddChgVO[] priSpScpTrspAddChgVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelAllIHCCharge(PriSpScpTrspAddChgVO[] priSpScpTrspAddChgVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Arbitrary Cuideline Copy를 진행한다. <br>
	 * 
	 * @param CstPriSpScpTrspAddChgVO cstPriSpScpTrspAddChgVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void copyGuidelineArbitraryCharge(CstPriSpScpTrspAddChgVO cstPriSpScpTrspAddChgVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Amend Request를 처리합니다.<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void amendProposal(PriSpMnVO priSpMnVO,SignOnUserAccount account) throws EventException;			

    /**
     * S/C Proposal Scope Transportation Additional Charge 데이터를 Copy 합니다.<br>
     * 
     * @param RsltPropCopyVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalScopeTransport(RsltPropCopyVO vo, SignOnUserAccount account) throws EventException;

    /**
     * Guideline Origin/Destination Arbitrary 를 Proposal 로 Copy 합니다.<br>
     * 
     * @param SpScpGlineCopyVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyScopeGuidelineArbitrary(SpScpGlineCopyVO vo, SignOnUserAccount account) throws EventException;
    

	/**
     * Guideline Copy 시 Copy할 Guideline이 존재하는지 확인한다. <br>
     * 
     * @param CstPriSpScpTrspAddChgVO cstPriSpScpTrspAddChgVO
     * @return boolean
     * @exception EventException
     */
	public boolean checkGuidelineArbitraryChargeExist(CstPriSpScpTrspAddChgVO cstPriSpScpTrspAddChgVO) throws EventException;
	
	/**
     * Guideline Copy 시 Copy할 Guideline의 Gruop Location이 존재하는지 확인한다. <br>
     * 
     * @param CstPriSpScpTrspAddChgVO cstPriSpScpTrspAddChgVO
     * @return boolean
     * @exception EventException
     */
	public boolean checkGuidelineArbitraryChargeGroupLocationExist(CstPriSpScpTrspAddChgVO cstPriSpScpTrspAddChgVO) throws EventException;
	
	/**
	 * Request Cancel시 Main Duration의 Accepted 데이터를 일괄 Init 으로 변경합니다.<br>
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalRequestCancel(PriSpScpMnVO priSpScpMnVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * Main의 Init 상태를 Cancel시 해당 Amend Seq NO.의 모든 데이터를 삭제합니다.<br>
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposal(PriSpScpMnVO priSpScpMnVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Arbitrary의 ORIGIN과 DESTINATION의 FONT STYLE를 조회한다. <br>
	 * 
	 * @param CstPriSpScpTrspAddChgVO cstPriRpScpTrspAddChgVO
	 * @return List<ChkFontStyleVO>
	 * @exception EventException
	 */
	public List<ChkFontStyleVO> checkFontStyle(CstPriSpScpTrspAddChgVO cstPriRpScpTrspAddChgVO) throws EventException;
	
	/**
	 * Arbitrary Amend History List를 조회한다. <br>
	 * 
	 * @param PriSpScpTrspAddChgVO priSpScpTrspAddChgVO
	 * @param PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO
	 * @return List<RsltAddChgListVO>
	 * @exception EventException
	 */
	public List<RsltAddChgListVO> searchArbitraryChargeHistoryList(PriSpScpTrspAddChgVO priSpScpTrspAddChgVO,PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO) throws EventException;
	
	/**
	 * Arbitrary Amend History의 ORIGIN과 DESTINATION의 FONT STYLE를 조회한다. <br>
	 * 
	 * @param CstPriSpScpTrspAddChgVO cstPriRpScpTrspAddChgVO
	 * @return List<ChkFontStyleVO>
	 * @exception EventException
	 */
	public List<ChkFontStyleVO> checkHistoryFontStyle(CstPriSpScpTrspAddChgVO cstPriRpScpTrspAddChgVO) throws EventException;
	
	/**
	 * IHC Amend History List를 조회한다. <br>
	 * 
	 * @param PriSpScpTrspAddChgVO priSpScpTrspAddChgVO
	 * @param PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO
	 * @return List<RsltAddChgListVO>
	 * @exception EventException
	 */
	public List<RsltAddChgListVO> searchIHCChargeHistoryList(PriSpScpTrspAddChgVO priSpScpTrspAddChgVO,PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO) throws EventException;
	
	/**
	 * Arbitrary Inquiry List를 조회한다. <br>
	 * 
	 * @param PriSpScpTrspAddChgVO priSpScpTrspAddChgVO
	 * @return List<RsltAddChgListVO>
	 * @exception EventException
	 */
	public List<RsltAddChgListVO> searchArbitraryChargeInquiryList(PriSpScpTrspAddChgVO priSpScpTrspAddChgVO) throws EventException;
	
	/**
	 * IHC Inquiry List를 조회한다. <br>
	 * 
	 * @param PriSpScpTrspAddChgVO priSpScpTrspAddChgVO
	 * @return List<RsltAddChgListVO>
	 * @exception EventException
	 */
	public List<RsltAddChgListVO> searchIHCChargeInquiryList(PriSpScpTrspAddChgVO priSpScpTrspAddChgVO) throws EventException;
	
	/**
	 * GRI Calculation - Arbitrary 화면에서 GRI 적용한다. <br>
	 * 
	 * @param PriSpScpTrspAddChgGriArbOKCLListVO[] pVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyProposalGRICalculationArbOK(PriSpScpTrspAddChgGriArbOKCLListVO[] pVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * GRI Calculation - Arbitrary 화면에서 GRI 적용 취소를 한다. <br>
	 * 
	 * @param PriSpScpTrspAddChgGriArbOKCLListVO[] pVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyProposalGRICalculationArbCancle(PriSpScpTrspAddChgGriArbOKCLListVO[] pVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Arbitrary와 IHC에서 중복을 확인합니다. <br>
	 * 
	 * @param PriSpScpTrspAddChgVO[] PriSpScpTrspAddChgVOs
	 * @return String
	 * @exception EventException
	 */
	public String checkArbitraryChargeDuplicate(PriSpScpTrspAddChgVO[] PriSpScpTrspAddChgVOs) throws EventException;
	
	/**
	 * Load Excel시 기존 데이터와의 중복 체크를 위하여 db에 저장되어 있는 <br>
	 * Arbitrary List를 조회한다. <br>
	 * 
	 * @param PriSpScpTrspAddChgVO priSpScpTrspAddChgVO
	 * @return List<ArbitraryExcelDupCheckVO>
	 * @exception EventException
	 */
	public List<ArbitraryExcelDupCheckVO> searchArbitraryLoadExcelDupList(PriSpScpTrspAddChgVO priSpScpTrspAddChgVO) throws EventException;
	
	/**
	 * Arbitrary 엑셀파일 데이터를 VALIDATION 체크한다.<br>
	 * 
	 * @param PriSpScpTrspAddChgVO[] priSpScpTrspAddChgVOs
	 * @return List<PriSpScpTrspAddChgVO>
	 * @exception EventException
	 */
	public List<PriSpScpTrspAddChgVO> searchCodeCheckResult(PriSpScpTrspAddChgVO[] priSpScpTrspAddChgVOs) throws EventException;
	/**
	 * Load Excel시 기존 데이터와의 중복 체크를 위하여 db에 저장되어 있는 <br>
	 * IHC Charge List를 조회한다. <br>
	 * 
	 * @param PriSpScpTrspAddChgVO priSpScpTrspAddChgVO
	 * @return List<IHCExcelDupCheckVO>
	 * @exception EventException
	 */
	public List<IHCExcelDupCheckVO> searchIHCLoadExcelDupList(PriSpScpTrspAddChgVO priSpScpTrspAddChgVO) throws EventException;
	
	/**
	 * IHC 엑셀파일 데이터를 VALIDATION 체크한다.<br>
	 * 
	 * @param PriSpScpTrspAddChgVO[] priSpScpTrspAddChgVOs
	 * @return List<PriSpScpTrspAddChgVO>
	 * @exception EventException
	 */
	public List<PriSpScpTrspAddChgVO> searchIhcCodeCheckResult(PriSpScpTrspAddChgVO[] priSpScpTrspAddChgVOs) throws EventException;	
	
	/**
	 * Init이외의 상태를 가지고 있는 데이터를 조회합니다.<br>
	 * 	 * 
	 * @param PriSpScpTrspAddChgVO priSpScpTrspAddChgVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchArbGriCheck(PriSpScpTrspAddChgVO priSpScpTrspAddChgVO) throws EventException;
}