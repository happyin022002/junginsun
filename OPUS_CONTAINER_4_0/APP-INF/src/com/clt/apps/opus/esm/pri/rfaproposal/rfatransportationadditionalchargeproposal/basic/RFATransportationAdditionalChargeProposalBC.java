/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFATransportationAdditionalChargeProposalBC.java
*@FileTitle : RFA Proposal Origin/Destination Arbitrary Charge Creation
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.basic;

import java.util.List;

import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RpScpGlineCopyVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RsltRfaPropCopyVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.vo.ChkFontStyleVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.vo.CstPriRpScpTrspAddChgVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.vo.RsltArbChgListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.vo.RsltPriRpScpTrspAddChgVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriRpMnVO;
import com.clt.syscommon.common.table.PriRpScpMnVO;
import com.clt.syscommon.common.table.PriRpScpTrspAddChgVO;

/**
 * RFAproposal Business Logic Command Interface<br>
 * - interface about RFAproposal biz logic<br>
 *
 * @author 
 * @see Esm_pri_2003_04EventResponse 
 * @since J2EE 1.4
 */

public interface RFATransportationAdditionalChargeProposalBC {
	
	/**
	 * retrieving Arbitrary List <br>
	 * 
	 * @param PriRpScpTrspAddChgVO priRpScpTrspAddChgVO
	 * @return List<RsltArbChgListVO>
	 * @exception EventException
	 */
	public List<RsltArbChgListVO> searchArbitraryChargeList(PriRpScpTrspAddChgVO priRpScpTrspAddChgVO) throws EventException;
	
	/**
	 * modifying Arbitrary <br>
	 * 
	 * @param PriRpScpTrspAddChgVO[] priRpScpTrspAddChgVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageArbitraryCharge(PriRpScpTrspAddChgVO[] priRpScpTrspAddChgVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * accepting Arbitrary <br>
	 * 
	 * @param PriRpScpTrspAddChgVO[] priRpScpTrspAddChgVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptArbitraryCharge(PriRpScpTrspAddChgVO[] priRpScpTrspAddChgVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * accept canceling Arbitrary <br>
	 * 
	 * @param PriRpScpTrspAddChgVO[] priRpScpTrspAddChgVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelArbitraryCharge(PriRpScpTrspAddChgVO[] priRpScpTrspAddChgVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * accepting all Arbitrary <br>
	 * 
	 * @param PriRpScpTrspAddChgVO[] priRpScpTrspAddChgVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptAllArbitraryCharge(PriRpScpTrspAddChgVO[] priRpScpTrspAddChgVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * accept canceling Arbitrary <br>
	 * 
	 * @param PriRpScpTrspAddChgVO[] priRpScpTrspAddChgVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelAllArbitraryCharge(PriRpScpTrspAddChgVO[] priRpScpTrspAddChgVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * Copying Arbitrary's Guideline <br>
	 * 
	 * @param CstPriRpScpTrspAddChgVO cstPriRpScpTrspAddChgVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void copyGuidelineArbitraryCharge(CstPriRpScpTrspAddChgVO cstPriRpScpTrspAddChgVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * creating Amend Data<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void amendProposal(PriRpMnVO priRpMnVO,SignOnUserAccount account) throws EventException;			

    /**
     * Copying RFA Proposal Scope Transportation Additional Charge<br>
     * 
     * @param RsltRfaPropCopyVO rsltRfaPropCopyVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalScopeTransport(RsltRfaPropCopyVO rsltRfaPropCopyVO, SignOnUserAccount account) throws EventException;

    /**
     * Copying Guideline Origin/Destination Arbitrary to Proposal <br>
     * 
     * @param RpScpGlineCopyVO rpScpGlineCopyVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyScopeGuidelineArbitrary(RpScpGlineCopyVO rpScpGlineCopyVO, SignOnUserAccount account) throws EventException;

	/**
     * checking existence of data to Guideline Copy <br>
     * 
     * @param CstPriRpScpTrspAddChgVO cstPriRpScpTrspAddChgVO
     * @return boolean
     * @exception EventException
     */
	public boolean checkGuidelineArbitraryChargeExist(CstPriRpScpTrspAddChgVO cstPriRpScpTrspAddChgVO) throws EventException;
	
	/**
     * checking existence of GROUP LOCATION to Guideline Copy<br>
     * 
     * @param CstPriRpScpTrspAddChgVO cstPriRpScpTrspAddChgVO
     * @return boolean
     * @exception EventException
     */
	public boolean checkGuidelineArbitraryChargeGroupLocationExist(CstPriRpScpTrspAddChgVO cstPriRpScpTrspAddChgVO) throws EventException;
	
	/**
	 * when Request Cancel, setting Main Duration's Accepted data with Init<br>
	 * 
	 * @param PriRpScpMnVO[] priRpScpMnVOs
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalRequestCancel(PriRpScpMnVO[] priRpScpMnVOs,SignOnUserAccount account) throws EventException;	
	
	/**
	 * when main's init state cancel, deleting this Amend Seq NO. all data<br>
	 * 
	 * @param PriRpScpMnVO priRpScpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposal(PriRpScpMnVO priRpScpMnVO, SignOnUserAccount account) throws EventException;
	
	
	/**
	 * uploading excel file<br>
	 * 
	 * @param PriRpScpTrspAddChgVO[] priRpScpTrspAddChgVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void uploadArbitraryChargeProposal(PriRpScpTrspAddChgVO[] priRpScpTrspAddChgVOs,SignOnUserAccount account) throws EventException;
	
	/**
	 * checking excel file
	 * 
	 * @param RsltPriRpScpTrspAddChgVO[] rsltPriRpScpTrspAddChgVOs
	 * @return List<RsltPriRpScpTrspAddChgVO>
	 * @exception EventException
	 */
	public List<RsltPriRpScpTrspAddChgVO> searchCodeCheckResult(RsltPriRpScpTrspAddChgVO[] rsltPriRpScpTrspAddChgVOs) throws EventException;
	
	/**
	 * retrieving Arbitrary's ORIGIN and DESTINATION's FONT STYLE <br>
	 * 
	 * @param CstPriRpScpTrspAddChgVO cstPriRpScpTrspAddChgVO
	 * @return List<ChkFontStyleVO>
	 * @exception EventException
	 */
	public List<ChkFontStyleVO> checkFontStyle(CstPriRpScpTrspAddChgVO cstPriRpScpTrspAddChgVO) throws EventException;
	
	/**
	 * Arbitrary Amend History List retrieving <br>
	 * 
	 * @param PriRpScpTrspAddChgVO priRpScpTrspAddChgVO
	 * @return List<RsltArbChgListVO>
	 * @exception EventException
	 */
	public List<RsltArbChgListVO> searchArbitraryChargeHistoryList(PriRpScpTrspAddChgVO priRpScpTrspAddChgVO) throws EventException;
	
	/**
	 * retrieving Arbitrary's ORIGIN and DESTINATION's FONT STYLE <br>
	 * 
	 * @param CstPriRpScpTrspAddChgVO cstPriRpScpTrspAddChgVO
	 * @return List<ChkFontStyleVO>
	 * @exception EventException
	 */
	public List<ChkFontStyleVO> checkHistoryFontStyle(CstPriRpScpTrspAddChgVO cstPriRpScpTrspAddChgVO) throws EventException;
	
	/**
	 * Arbitrary Inquiry List retrieving <br>
	 * 
	 * @param PriRpScpTrspAddChgVO priRpScpTrspAddChgVO
	 * @return List<RsltArbChgListVO>
	 * @exception EventException
	 */
	public List<RsltArbChgListVO> searchArbitraryChargeInquiryList(PriRpScpTrspAddChgVO priRpScpTrspAddChgVO) throws EventException;
	
	/**
	 * Retrieving Arbitrary note and content distinctly in curret amendment<br>
	 * 
	 * @param RsltPriRpScpTrspAddChgVO[] rsltPriRpScpTrspAddChgVOs
	 * @return List<RsltAddChgListVO>
	 * @exception EventException
	 */
	public List<RsltPriRpScpTrspAddChgVO> searchCurrentNoteSeqContent(RsltPriRpScpTrspAddChgVO[] rsltPriRpScpTrspAddChgVOs) throws EventException;
}