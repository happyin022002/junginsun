/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCTransportationAdditionalChargeProposalBC.java
*@FileTitle : S/C Proposal Origin/Destination Arbitrary Charge Creation
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0

=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.sctransportationadditionalchargeproposal.basic;

import java.util.List;

import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.clt.apps.opus.esm.pri.scproposal.scgricalculationproposal.vo.PriSpScpTrspAddChgGriArbOKCLListVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.RsltPropCopyVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.SpScpGlineCopyVO;
import com.clt.apps.opus.esm.pri.scproposal.sctransportationadditionalchargeproposal.vo.ArbitraryExcelDupCheckVO;
import com.clt.apps.opus.esm.pri.scproposal.sctransportationadditionalchargeproposal.vo.ChkFontStyleVO;
import com.clt.apps.opus.esm.pri.scproposal.sctransportationadditionalchargeproposal.vo.CstArbAcceptVO;
import com.clt.apps.opus.esm.pri.scproposal.sctransportationadditionalchargeproposal.vo.CstPriSpScpTrspAddChgVO;
import com.clt.apps.opus.esm.pri.scproposal.sctransportationadditionalchargeproposal.vo.IHCExcelDupCheckVO;
import com.clt.apps.opus.esm.pri.scproposal.sctransportationadditionalchargeproposal.vo.RsltAddChgListVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriSpMnVO;
import com.clt.syscommon.common.table.PriSpScpMnVO;
import com.clt.syscommon.common.table.PriSpScpTrspAddChgVO;

/**
 * Scproposal Business Logic Command Interface<br>
 * - Handling a biz logic about Scproposal<br>
 *
 * @author
 * @see Esm_pri_0003_04EventResponse 
 * @since J2EE 1.4
 */

public interface SCTransportationAdditionalChargeProposalBC {
	
	/**
	 * Retrieving Arbitrary List <br>
	 * 
	 * @param PriSpScpTrspAddChgVO priSpScpTrspAddChgVO
	 * @return List<RsltArbChgListVO>
	 * @exception EventException
	 */
	public List<RsltAddChgListVO> searchArbitraryChargeList(PriSpScpTrspAddChgVO priSpScpTrspAddChgVO) throws EventException;
	
	/**
	 * Modifying Arbitrary List <br>
	 * 
	 * @param PriSpScpTrspAddChgVO[] priSpScpTrspAddChgVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageArbitraryCharge(PriSpScpTrspAddChgVO[] priSpScpTrspAddChgVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Accepting Arbitrary Accept <br>
	 * 
	 * @param PriSpScpTrspAddChgVO[] priSpScpTrspAddChgVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptArbitraryCharge(PriSpScpTrspAddChgVO[] priSpScpTrspAddChgVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Cancelling Arbitrary Accept <br>
	 * 
	 * @param PriSpScpTrspAddChgVO[] priSpScpTrspAddChgVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelArbitraryCharge(PriSpScpTrspAddChgVO[] priSpScpTrspAddChgVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Accepting all of Arbitrary <br>
	 * 
	 * @param PriSpScpTrspAddChgVO[] priSpScpTrspAddChgVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptAllArbitraryCharge(PriSpScpTrspAddChgVO[] priSpScpTrspAddChgVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Accepting all of Arbitrary <br>
	 * 
	 * @param CstArbAcceptVO cstArbAcceptVO
	 * @param SignOnUserAccount account
	 * @return int
	 * @exception EventException
	 */
	public int acceptAllArbitraryChargeFast(CstArbAcceptVO cstArbAcceptVO, SignOnUserAccount account) throws EventException;	
	
	
	/**
	 *  Cancelling all acceptance of Arbitrary<br>
	 * 
	 * @param PriSpScpTrspAddChgVO[] priSpScpTrspAddChgVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelAllArbitraryCharge(PriSpScpTrspAddChgVO[] priSpScpTrspAddChgVO, SignOnUserAccount account) throws EventException;
	
	/**
	 *  Cancelling all aceeptance of Arbitrary<br>
	 * 
	 * @param CstArbAcceptVO cstArbAcceptVO
	 * @param SignOnUserAccount account
	 * @return int
	 * @exception EventException
	 */
	public int cancelAllArbitraryChargeFast(CstArbAcceptVO cstArbAcceptVO, SignOnUserAccount account) throws EventException;	
	/**
	 * Retrieving IHC List <br>
	 * 
	 * @param PriSpScpTrspAddChgVO priSpScpTrspAddChgVO
	 * @return List<RsltArbChgListVO>
	 * @exception EventException
	 */
	public List<RsltAddChgListVO> searchIHCChargeList(PriSpScpTrspAddChgVO priSpScpTrspAddChgVO) throws EventException;
	
	/**
	 * Modifying IHC List <br>
	 * 
	 * @param PriSpScpTrspAddChgVO[] priSpScpTrspAddChgVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageIHCCharge(PriSpScpTrspAddChgVO[] priSpScpTrspAddChgVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Accepting IHC Accept <br>
	 * 
	 * @param PriSpScpTrspAddChgVO[] priSpScpTrspAddChgVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptIHCCharge(PriSpScpTrspAddChgVO[] priSpScpTrspAddChgVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Cancelling a acceptance of IHC<br>
	 * 
	 * @param PriSpScpTrspAddChgVO[] priSpScpTrspAddChgVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelIHCCharge(PriSpScpTrspAddChgVO[] priSpScpTrspAddChgVO, SignOnUserAccount account) throws EventException;
	
	/**
	 *  Accepting all of IHC<br>
	 * 
	 * @param PriSpScpTrspAddChgVO[] priSpScpTrspAddChgVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptAllIHCCharge(PriSpScpTrspAddChgVO[] priSpScpTrspAddChgVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Cancelling all acceptance of IHC<br>
	 * 
	 * @param PriSpScpTrspAddChgVO[] priSpScpTrspAddChgVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelAllIHCCharge(PriSpScpTrspAddChgVO[] priSpScpTrspAddChgVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Copying Arbitrary Cuideline<br>
	 * 
	 * @param CstPriSpScpTrspAddChgVO cstPriSpScpTrspAddChgVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void copyGuidelineArbitraryCharge(CstPriSpScpTrspAddChgVO cstPriSpScpTrspAddChgVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Requesting Amend Request<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void amendProposal(PriSpMnVO priSpMnVO,SignOnUserAccount account) throws EventException;			

    /**
     * S/C Proposal Scope Transportation Additional Charge data <br>
     * 
     * @param RsltPropCopyVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalScopeTransport(RsltPropCopyVO vo, SignOnUserAccount account) throws EventException;

    /**
     * Copying Guideline Origin/Destination Arbitrary to Proposal <br>
     * 
     * @param SpScpGlineCopyVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyScopeGuidelineArbitrary(SpScpGlineCopyVO vo, SignOnUserAccount account) throws EventException;
    

	/**
     *Checking whether Guideline to be copied exists or not when copying Guideline<br>
     * 
     * @param CstPriSpScpTrspAddChgVO cstPriSpScpTrspAddChgVO
     * @return boolean
     * @exception EventException
     */
	public boolean checkGuidelineArbitraryChargeExist(CstPriSpScpTrspAddChgVO cstPriSpScpTrspAddChgVO) throws EventException;
	
	/**
     *  Checking whether group location of guideline to be copied exists or not when copying guideline<br>
     * 
     * @param CstPriSpScpTrspAddChgVO cstPriSpScpTrspAddChgVO
     * @return boolean
     * @exception EventException
     */
	public boolean checkGuidelineArbitraryChargeGroupLocationExist(CstPriSpScpTrspAddChgVO cstPriSpScpTrspAddChgVO) throws EventException;
	
	/**
	 * Changing accepted datas of Main duration to "init" at one time when cancelling rquest<br>
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalRequestCancel(PriSpScpMnVO priSpScpMnVO,SignOnUserAccount account) throws EventException;
	
	/**
	 *Deleting all datas of related Amend Seq No when cancelling "Init" status of Main<br>
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposal(PriSpScpMnVO priSpScpMnVO, SignOnUserAccount account) throws EventException;
	
	/**
	 *  Retrieving font style of Arbitrary's ORIGIN& DESTINATION<br>
	 * 
	 * @param CstPriSpScpTrspAddChgVO cstPriRpScpTrspAddChgVO
	 * @return List<ChkFontStyleVO>
	 * @exception EventException
	 */
	public List<ChkFontStyleVO> checkFontStyle(CstPriSpScpTrspAddChgVO cstPriRpScpTrspAddChgVO) throws EventException;
	
	/**
	 * Retrieving Arbitrary Amend History List <br>
	 * 
	 * @param PriSpScpTrspAddChgVO priSpScpTrspAddChgVO
	 * @return List<RsltAddChgListVO>
	 * @exception EventException
	 */
	public List<RsltAddChgListVO> searchArbitraryChargeHistoryList(PriSpScpTrspAddChgVO priSpScpTrspAddChgVO) throws EventException;
	
	/**
	 * Retrieving  Arbitrary Amend History's ORIGIN& DESTINATION<br>
	 * 
	 * @param CstPriSpScpTrspAddChgVO cstPriRpScpTrspAddChgVO
	 * @return List<ChkFontStyleVO>
	 * @exception EventException
	 */
	public List<ChkFontStyleVO> checkHistoryFontStyle(CstPriSpScpTrspAddChgVO cstPriRpScpTrspAddChgVO) throws EventException;
	
	/**
	 * Retrieving IHC Amend History List<br>
	 * 
	 * @param PriSpScpTrspAddChgVO priSpScpTrspAddChgVO
	 * @return List<RsltAddChgListVO>
	 * @exception EventException
	 */
	public List<RsltAddChgListVO> searchIHCChargeHistoryList(PriSpScpTrspAddChgVO priSpScpTrspAddChgVO) throws EventException;
	
	/**
	 * Retrieving Arbitrary Inquiry List<br>
	 * 
	 * @param PriSpScpTrspAddChgVO priSpScpTrspAddChgVO
	 * @return List<RsltAddChgListVO>
	 * @exception EventException
	 */
	public List<RsltAddChgListVO> searchArbitraryChargeInquiryList(PriSpScpTrspAddChgVO priSpScpTrspAddChgVO) throws EventException;
	
	/**
	 *Retrieving  IHC Inquiry List<br>
	 * 
	 * @param PriSpScpTrspAddChgVO priSpScpTrspAddChgVO
	 * @return List<RsltAddChgListVO>
	 * @exception EventException
	 */
	public List<RsltAddChgListVO> searchIHCChargeInquiryList(PriSpScpTrspAddChgVO priSpScpTrspAddChgVO) throws EventException;
	
	/**
	 * Applying GRI on GRI Calculation - Arbitrary screen <br>
	 * 
	 * @param PriSpScpTrspAddChgGriArbOKCLListVO[] pVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyProposalGRICalculationArbOK(PriSpScpTrspAddChgGriArbOKCLListVO[] pVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Cancelling applied GRI on GRI Calculation - Arbitrary screen <br>
	 * 
	 * @param PriSpScpTrspAddChgGriArbOKCLListVO[] pVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyProposalGRICalculationArbCancle(PriSpScpTrspAddChgGriArbOKCLListVO[] pVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Checking duplication of Arbitrary& IHC<br>
	 * 
	 * @param PriSpScpTrspAddChgVO[] PriSpScpTrspAddChgVOs
	 * @return String
	 * @exception EventException
	 */
	public String checkArbitraryChargeDuplicate(PriSpScpTrspAddChgVO[] PriSpScpTrspAddChgVOs) throws EventException;
	
	/**
	 * Retrieving Arbitrary list to check duplicating with existing data when loading excel file<br>
	 * 
	 * @param PriSpScpTrspAddChgVO priSpScpTrspAddChgVO
	 * @return List<ArbitraryExcelDupCheckVO>
	 * @exception EventException
	 */
	public List<ArbitraryExcelDupCheckVO> searchArbitraryLoadExcelDupList(PriSpScpTrspAddChgVO priSpScpTrspAddChgVO) throws EventException;
	
	/**
	 *  Checking a validation of uploaded Arbitrary excel data<br>
	 * 
	 * @param PriSpScpTrspAddChgVO[] priSpScpTrspAddChgVOs
	 * @return List<PriSpScpTrspAddChgVO>
	 * @exception EventException
	 */
	public List<PriSpScpTrspAddChgVO> searchCodeCheckResult(PriSpScpTrspAddChgVO[] priSpScpTrspAddChgVOs) throws EventException;
	/**
	 * Retrieving IHC Charge List to check duplicating with existing data when loading excel file<br>
	 * 
	 * @param PriSpScpTrspAddChgVO priSpScpTrspAddChgVO
	 * @return List<IHCExcelDupCheckVO>
	 * @exception EventException
	 */
	public List<IHCExcelDupCheckVO> searchIHCLoadExcelDupList(PriSpScpTrspAddChgVO priSpScpTrspAddChgVO) throws EventException;
	
	/**
	 * Checking validation of IHC upload Excel file data.<br>
	 * 
	 * @param PriSpScpTrspAddChgVO[] priSpScpTrspAddChgVOs
	 * @return List<PriSpScpTrspAddChgVO>
	 * @exception EventException
	 */
	public List<PriSpScpTrspAddChgVO> searchIhcCodeCheckResult(PriSpScpTrspAddChgVO[] priSpScpTrspAddChgVOs) throws EventException;	
	
	/**
	 *  Retrieving datas without INIT status<br>
	 * 	 * 
	 * @param PriSpScpTrspAddChgVO priSpScpTrspAddChgVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchArbGriCheck(PriSpScpTrspAddChgVO priSpScpTrspAddChgVO) throws EventException;	
	
	/**
	 * Retrieving note sequence and content distinctly in current amend<br>
	 * 
	 * @param PriSpScpTrspAddChgVO[] priSpScpTrspAddChgVOs
	 * @return List<RsltAddChgListVO>
	 * @exception EventException
	 */
	public List<RsltAddChgListVO>searchCurrentNoteSeqContent(PriSpScpTrspAddChgVO[] priSpScpTrspAddChgVOs) throws EventException;
}