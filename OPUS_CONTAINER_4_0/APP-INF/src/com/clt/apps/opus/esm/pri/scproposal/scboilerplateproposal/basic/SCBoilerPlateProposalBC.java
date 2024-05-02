/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCBoilerPlateProposalBC.java
*@FileTitle : Bolier Plate Creation
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scboilerplateproposal.basic;

import java.util.List;

import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.clt.apps.opus.esm.pri.scproposal.scboilerplateproposal.vo.BlplPropVO;
import com.clt.apps.opus.esm.pri.scproposal.scboilerplateproposal.vo.CstBlplCopyVO;
import com.clt.apps.opus.esm.pri.scproposal.scboilerplateproposal.vo.CstBlplSearchVO;
import com.clt.apps.opus.esm.pri.scproposal.scboilerplateproposal.vo.CstPriSpBlplVO;
import com.clt.apps.opus.esm.pri.scproposal.scboilerplateproposal.vo.RsltPriSpBlplCtntInqVO;
import com.clt.apps.opus.esm.pri.scproposal.scboilerplateproposal.vo.RsltPriSpBlplCtntVO;
import com.clt.apps.opus.esm.pri.scproposal.scboilerplateproposal.vo.RsltPriSpBlplExcelVO;
import com.clt.apps.opus.esm.pri.scproposal.scboilerplateproposal.vo.RsltPriSpBlplHeaderVO;
import com.clt.apps.opus.esm.pri.scproposal.scboilerplateproposal.vo.RsltPriSpBlplInqVO;
import com.clt.apps.opus.esm.pri.scproposal.scboilerplateproposal.vo.RsltPriSpBlplVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.RsltPropCopyVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriSpBlplCtntVO;
import com.clt.syscommon.common.table.PriSpBlplVO;
import com.clt.syscommon.common.table.PriSpMnVO;

/**
 * Scproposal Business Logic Command Interface<br>
 * - interface about Scproposal biz logic<br>
 *
 * @author 
 * @see Esm_pri_0023EventResponse 
 * @since J2EE 1.6
 */

public interface SCBoilerPlateProposalBC {
	/**
	 * retrieving Boiler Plate List <br>
	 * 
	 * @param CstBlplSearchVO cstBlplSearchVO
	 * @return List<RsltPriSpBlplVO>
	 * @exception EventException
	 */
	public List<RsltPriSpBlplVO> searchBoilerPlateList(CstBlplSearchVO cstBlplSearchVO) throws EventException;
	/**
	 * retrieving Boiler Plate Detail List <br>
	 * 
	 * @param PriSpBlplCtntVO priSpBlplCtntVO
	 * @return List<RsltPriSpBlplCtntVO>
	 * @exception EventException
	 */
	public List<RsltPriSpBlplCtntVO> searchBoilerPlateDetailList(PriSpBlplCtntVO priSpBlplCtntVO) throws EventException;	
	/**
	 * saving Boiler Plate data<br>
	 * 
	 * @param BlplPropVO blplPropVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageBoilerPlate(BlplPropVO blplPropVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * retrieving Boiler Plate Header <br>
	 * 
	 * @param RsltPriSpBlplHeaderVO rsltPriSpBlplHeaderVO
	 * @return List<RsltPriSpBlplHeaderVO>
	 * @exception EventException
	 */
	public List<RsltPriSpBlplHeaderVO> searchBoilerPlateHeader(RsltPriSpBlplHeaderVO rsltPriSpBlplHeaderVO) throws EventException;
	
	/**
	 * Copying GuideLine data<br>
	 * 
	 * @param CstBlplCopyVO cstBlplCopyVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String copyGuidelineBoilerPlate(CstBlplCopyVO cstBlplCopyVO,SignOnUserAccount account) throws EventException;	
	
	/**
	 * retrieving Boiler Plate Title and Content for sending Boiler Plate data Excel file <br>
	 * 
	 * @param PriSpBlplVO priSpBlplVO
	 * @return List<RsltPriSpBlplExcelVO>
	 * @exception EventException
	 */
	public List<RsltPriSpBlplExcelVO> searchBoilerPlateListExcel(PriSpBlplVO priSpBlplVO) throws EventException;	
	
	/**
	 * Accepting Boiler Plate Title data<br>
	 * 
	 * @param PriSpBlplVO[] priSpBlplVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptBoilerPlate(PriSpBlplVO[] priSpBlplVO,SignOnUserAccount account) throws EventException;
	/**
	 * Boiler Plate Title data Accept Canceling<br>
	 * 
	 * @param PriSpBlplVO[] priSpBlplVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelBoilerPlate(PriSpBlplVO[] priSpBlplVO,SignOnUserAccount account) throws EventException;	
	
	/**
	 * Boiler Plate Content data Accepting<br>
	 * 
	 * @param PriSpBlplCtntVO[] priSpBlplCtntVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptBoilerPlateContent(PriSpBlplCtntVO[] priSpBlplCtntVO,SignOnUserAccount account) throws EventException;
	/**
	 * Boiler Plate Content data Accept Canceling<br>
	 * 
	 * @param PriSpBlplCtntVO[] priSpBlplCtntVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelBoilerPlateContent(PriSpBlplCtntVO[] priSpBlplCtntVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * all data Accepting except for already Accepted data in Boiler Plate<br>
	 * 
	 * @param CstPriSpBlplVO cstPriSpBlplVO
	 * @param SignOnUserAccount account
	 * @return int
	 * @exception EventException
	 */
	public int acceptAllBoilerPlate(CstPriSpBlplVO cstPriSpBlplVO,SignOnUserAccount account) throws EventException;

	/**
	 * already Accepted data in Boiler Plate all Accept Canceling<br>
	 * 
	 * @param CstPriSpBlplVO cstPriSpBlplVO
	 * @param SignOnUserAccount account
	 * @return int
	 * @exception EventException
	 */
	public int cancelAllBoilerPlate(CstPriSpBlplVO cstPriSpBlplVO,SignOnUserAccount account) throws EventException;		

	/**
	 * Amend Request<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void amendProposal(PriSpMnVO priSpMnVO,SignOnUserAccount account) throws EventException;

    /**
     * Proposal Boiler Plate Copying<br>
     * 
     * @param RsltPropCopyVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalBoilerPlate(RsltPropCopyVO vo, SignOnUserAccount account) throws EventException;
    
    /**
	 * saving Excel Uploaded data to Boiler Plate<br>
	 * 
	 * @param BlplPropVO getBlplPropVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageBoilerPlateExl(BlplPropVO getBlplPropVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * when Canceling Main's init state, deleting all this Amend Seq NO. data <br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeProposal(PriSpMnVO priSpMnVO, SignOnUserAccount account) throws EventException;	
	
	/**
	 * when Canceling Main's init state, deleting all this Amend Seq NO. data <br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void addProposalBlplMigHis(PriSpMnVO priSpMnVO, SignOnUserAccount account) throws EventException;	
	
	/**
	 * when canceling Request, setting Accepted data with Init state<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalRequestCancel(PriSpMnVO priSpMnVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * returning Boiler Plate Record Count<br>
	 * 
	 * @param BlplPropVO blplPropVO
	 * @param SignOnUserAccount account
	 * @return returnCnt int
	 * @exception EventException
	 */
	public int searchBoilerPlateCount(BlplPropVO blplPropVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Boiler Plate Amend History Title retrieving<br>
	 * 
	 * @param RsltPriSpBlplHeaderVO rsltPriSpBlplHeaderVO
	 * @return List<RsltPriSpBlplHeaderVO>
	 * @exception EventException
	 */
	public List<RsltPriSpBlplHeaderVO> searchBoilerPlateTitle(RsltPriSpBlplHeaderVO rsltPriSpBlplHeaderVO)	throws EventException;
	/**
	 * Boiler Plate Amend History Content retrieving<br>
	 * 
	 * @param PriSpBlplCtntVO priSpBlplCtntVO
	 * @return List<RsltPriSpBlplCtntVO>
	 * @exception EventException
	 */
	public List<RsltPriSpBlplCtntVO> searchBoilerPlateDetailHistoryList(PriSpBlplCtntVO priSpBlplCtntVO) throws EventException;	
	/**
	 * Boiler Plate Amend History List retrieving<br>
	 * 
	 * @param CstBlplSearchVO cstBlplSearchVO
	 * @return List<RsltPriSpBlplVO>
	 * @exception EventException
	 */
	public List<RsltPriSpBlplVO> searchBoilerPlateHistoryList(CstBlplSearchVO cstBlplSearchVO) throws EventException;
	
	/**
	 *Inquiry - retrieving Boiler Plate Header <br>
	 * 
	 * @param RsltPriSpBlplHeaderVO rsltPriSpBlplHeaderVO
	 * @return List<RsltPriSpBlplHeaderVO>
	 * @exception EventException
	 */
	public List<RsltPriSpBlplHeaderVO> searchBoilerPlateHeaderInquiry(RsltPriSpBlplHeaderVO rsltPriSpBlplHeaderVO) throws EventException;	
	
	/**
	 *Inquiry - retrieving Boiler Plate Title <br>
	 * 
	 * @param CstBlplSearchVO cstBlplSearchVO
	 * @return List<RsltPriSpBlplInqVO>
	 * @exception EventException
	 */
	public List<RsltPriSpBlplInqVO> searchBoilerPlateInquiryList(CstBlplSearchVO cstBlplSearchVO) throws EventException;
	
	/**
	 * Inquiry - retrieving Boiler Plate Contents <br>
	 * 
	 * @param PriSpBlplCtntVO priSpBlplCtntVO
	 * @return List<RsltPriSpBlplCtntInqVO>
	 * @exception EventException
	 */
	public List<RsltPriSpBlplCtntInqVO> searchBoilerPlateDetailInquiryList(PriSpBlplCtntVO priSpBlplCtntVO) throws EventException;
	
	/**
     * when deleting Master, checking existence of accepted data in detail<br>
     * can not deleting when accepted data exist<br>
	 * 
	 * @param PriSpBlplVO[] priSpBlplVOs
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchDetailAccept(PriSpBlplVO[] priSpBlplVOs) throws EventException;	
	/**
	 * automatically Accepting, when all SRC_INFO_CD = GC and deleted data doesn't exist<br>
	 * 
	 * @param PriSpBlplvo priSpBlplvo
	 * @param SignOnUserAccount account
	 * @return int
	 * @exception EventException
	 */
	public int autoAcceptProposalBoilerPlate(PriSpBlplVO priSpBlplVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * automatically Canceling, when all SRC_INFO_CD = GC and deleted data doesn't exist<br>
	 * 
	 * @param PriSpBlplvo priSpBlplvo
	 * @param SignOnUserAccount account
	 * @return int
	 * @exception EventException
	 */
	public int autoCancelProposalBoilerPlate(PriSpBlplVO priSpBlplVO, SignOnUserAccount account) throws EventException;
}