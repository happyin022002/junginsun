/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCAffiliateProposalBCImpl.java
*@FileTitle : Proposal Affiliate Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.02
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.06.02 공백진
* 1.0 Creation
* 
* 2012.02.23 이석준[CHM-201216153-01] S/C Amendment History 화면 기능 개선 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scaffiliateproposal.basic;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hanjin.apps.alps.esm.pri.scproposal.scaffiliateproposal.integration.SCAffiliateProposalDBDAO;
import com.hanjin.apps.alps.esm.pri.scproposal.scaffiliateproposal.vo.CstPriSpAfilVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scaffiliateproposal.vo.RsltAfilListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scaffiliateproposal.vo.RsltPriSpAfilInqVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scaffiliateproposal.vo.RsltPriSpAfilVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPropCopyVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriSpAfilVO;
import com.hanjin.syscommon.common.table.PriSpMnVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.PriSpHistoryInquiryParamVO;

/**
 * NIS2010-SCProposal Business Logic Basic Command implementation<br>
 * - NIS2010-SCProposal에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Kong Back Jin
 * @see ESM_PRI_0025EventResponse,SCAffiliateProposalBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */ 
public class SCAffiliateProposalBCImpl extends BasicCommandSupport implements SCAffiliateProposalBC {

	// Database Access Object
	private transient SCAffiliateProposalDBDAO dbDao = null;

	/** 
	 * SCAffiliateProposalBCImpl 객체 생성<br>
	 * SCAffiliateProposalDBDAO를 생성한다.<br>
	 */
	public SCAffiliateProposalBCImpl() {
		dbDao = new SCAffiliateProposalDBDAO();
	}
	/**
	 * Affiliate Company 리스트를 조회합니다.<br>
	 * 
	 * @param PriSpAfilVO priSpAfilVO
	 * @return List<RsltPriSpAfilVO>
	 * @exception EventException
	 */
	public List<RsltPriSpAfilVO> searchAffiliateList(PriSpAfilVO priSpAfilVO) throws EventException {
		try {
			return dbDao.searchAffiliateList(priSpAfilVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Amendment History Inquiry - Affiliate Company 리스트를 조회한다. <br>
	 * 
	 * @param RsltAfilListVO pVo
	 * @param PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO
	 * @return List<RsltAfilListVO>
	 * @exception EventException
	 */
	public List<RsltAfilListVO> searchAffiliateHistoryList(RsltAfilListVO pVo,PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO) throws EventException {
		try {
			return dbDao.searchAffiliateHistoryList(pVo,priSpHistoryInquiryParamVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * Affiliate Company에서 manual 입력이 가능한 Scope이 있는지 조회합니다.<br>
	 * 
	 * @param PriSpAfilVO priSpAfilVO
	 * @return List<PriSpAfilVO>
	 * @exception EventException
	 */
	public List<PriSpAfilVO> searchManualCheck(PriSpAfilVO priSpAfilVO) throws EventException {
		try {
			return dbDao.searchManualCheck(priSpAfilVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}	
	
	/**
	 * Affiliate Company  데이터를 저장합니다.<br>
	 * 
	 * @param PriSpAfilVO[] priSpAfilVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageAffiliate(PriSpAfilVO[] priSpAfilVO, SignOnUserAccount account) throws EventException{
		try {
			List<PriSpAfilVO> insertVoList = new ArrayList<PriSpAfilVO>();
			List<PriSpAfilVO> updateVoList = new ArrayList<PriSpAfilVO>();
			List<PriSpAfilVO> deleteVoList = new ArrayList<PriSpAfilVO>();
			for ( int i=0; i<priSpAfilVO .length; i++ ) {
				if ( priSpAfilVO[i].getIbflag().equals("I")){
					priSpAfilVO[i].setCreUsrId(account.getUsr_id());
					priSpAfilVO[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(priSpAfilVO[i]);
				} else if ( priSpAfilVO[i].getIbflag().equals("U")){
					priSpAfilVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(priSpAfilVO[i]);
				} else if ( priSpAfilVO[i].getIbflag().equals("D")){
					deleteVoList.add(priSpAfilVO[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addAffiliateS(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyAffiliateS(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeAffiliateS(deleteVoList);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Affiliate Company  데이터를 Accept 합니다.<br>
	 * 
	 * @param PriSpAfilVO[] priSpAfilVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptAffiliate(PriSpAfilVO[] priSpAfilVO, SignOnUserAccount account) throws EventException{
		try {
			List<PriSpAfilVO> updateVoList = new ArrayList<PriSpAfilVO>();
			String currentDate = new SimpleDateFormat("yyyyMMdd").format(new Date());
			
			for ( int i=0; i<priSpAfilVO .length; i++ ) {
				if ( priSpAfilVO[i].getIbflag().equals("U")){
					priSpAfilVO[i].setUpdUsrId(account.getUsr_id());
					priSpAfilVO[i].setAcptUsrId(account.getUsr_id());
					priSpAfilVO[i].setAcptOfcCd(account.getOfc_cd());								
					priSpAfilVO[i].setAcptDt(currentDate);						
					updateVoList.add(priSpAfilVO[i]);
				}
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyAffiliateS(updateVoList);
			}

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}	
	/**
	 * Affiliate Company  데이터를 Accept Cancel 합니다.<br>
	 * 
	 * @param PriSpAfilVO[] priSpAfilVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelAffiliate(PriSpAfilVO[] priSpAfilVO, SignOnUserAccount account) throws EventException{
		try {
			List<PriSpAfilVO> updateVoList = new ArrayList<PriSpAfilVO>();

			for ( int i=0; i<priSpAfilVO .length; i++ ) {
				if ( priSpAfilVO[i].getIbflag().equals("U")){
					priSpAfilVO[i].setUpdUsrId(account.getUsr_id());
					priSpAfilVO[i].setAcptUsrId("");
					priSpAfilVO[i].setAcptOfcCd("");								
					priSpAfilVO[i].setAcptDt(null);							
					updateVoList.add(priSpAfilVO[i]);
				}
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyAffiliateS(updateVoList);
			}

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}		
	
	/**
	 * Affiliate Company  데이터 중 이미 Accept된 데이터를 제외한 모든 데이터를 Accept 합니다.<br>
	 * 
	 * @param CstPriSpAfilVO cstPriSpAfilVO
	 * @param SignOnUserAccount account
	 * @return int
	 * @exception EventException
	 */
	public int acceptAllAffiliate(CstPriSpAfilVO cstPriSpAfilVO, SignOnUserAccount account) throws EventException{
		int rValue = 0;
		try {

			String currentDate = new SimpleDateFormat("yyyyMMdd").format(new Date());
			if (cstPriSpAfilVO != null  ) {
				cstPriSpAfilVO.setUpdUsrId(account.getUsr_id());					
				cstPriSpAfilVO.setAcptUsrId(account.getUsr_id());
				cstPriSpAfilVO.setAcptOfcCd(account.getOfc_cd());
				cstPriSpAfilVO.setPrcProgStsCd(cstPriSpAfilVO.getStsCd());
				cstPriSpAfilVO.setAcptDt(currentDate);
			}

			rValue = dbDao.modifyAcceptAllAffiliate (cstPriSpAfilVO);	

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
		return rValue;
	}		
	/**
	 * Affiliate Company  데이터를 모두 Accept Cancel 합니다.<br>
	 * 
	 * @param CstPriSpAfilVO cstPriSpAfilVO
	 * @param SignOnUserAccount account
	 * @return int
	 * @exception EventException
	 */
	public int cancelAllAffiliate(CstPriSpAfilVO cstPriSpAfilVO, SignOnUserAccount account) throws EventException{
		int rValue = 0;
		try {
			if (cstPriSpAfilVO != null  ) {
				cstPriSpAfilVO.setUpdUsrId(account.getUsr_id());					
				cstPriSpAfilVO.setAcptUsrId("");
				cstPriSpAfilVO.setAcptOfcCd("");								
				cstPriSpAfilVO.setAcptDt(null);	
				cstPriSpAfilVO.setPrcProgStsCd(cstPriSpAfilVO.getStsCd());
			}	
			rValue = dbDao.modifyAcceptAllAffiliate (cstPriSpAfilVO);	

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
		return rValue;
	}			
	
	/**
	 * Amend Request를 처리합니다.<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void amendProposal(PriSpMnVO priSpMnVO, SignOnUserAccount account) throws EventException{
		try {

			List<PriSpMnVO> insertVoList = new ArrayList<PriSpMnVO>();
			
			priSpMnVO.setCreUsrId(account.getUsr_id());
			priSpMnVO.setUpdUsrId(account.getUsr_id());					
			insertVoList.add(priSpMnVO);
// pri_sp_afil 생성
			dbDao.addAffiliateAmend (insertVoList);
				
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}	

    /**
     * Proposal Affiliate 정보를 Copy 합니다.<br>
     * 
     * @param RsltPropCopyVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalAffiliate (RsltPropCopyVO vo, SignOnUserAccount account) throws EventException {
        try {
            vo.setCreUsrId(account.getUsr_id());
            vo.setUpdUsrId(account.getUsr_id());
            vo.setOfcCd(account.getOfc_cd());
            // PRI_SP_AFIL COPY
            dbDao.addCopyProposalAffiliate(vo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
    }
	    
	/**
	 * Main의 Init 상태를 Cancel시 해당 Amend Seq NO.의 모든 데이터를 삭제합니다.<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposal(PriSpMnVO priSpMnVO, SignOnUserAccount account) throws EventException{
		try {
			dbDao.removeProposal(priSpMnVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}	
	/**
	 * Request Cancel시 Accepted 데이터를 일괄 Init 으로 변경합니다.<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalRequestCancel(PriSpMnVO priSpMnVO,SignOnUserAccount account) throws EventException{
		try {
			if (priSpMnVO != null  ) {
				priSpMnVO.setUpdUsrId(account.getUsr_id());	
				
			}
			
			dbDao.modifyProposalRequestCancel(priSpMnVO);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}	
	
	/**
	 * Inquiry - Affiliate Company 리스트를 조회합니다.<br>
	 * 
	 * @param PriSpAfilVO priSpAfilVO
	 * @return List<RsltPriSpAfilInqVO>
	 * @exception EventException
	 */
	public List<RsltPriSpAfilInqVO> searchAffiliateInquiryList(PriSpAfilVO priSpAfilVO) throws EventException {
		try {
			return dbDao.searchAffiliateInquiryList(priSpAfilVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}	
	

	/**
	 * Inquiry - Affiliate Company에서 manual 입력이 가능한 Scope이 있는지 조회합니다.<br>
	 * 
	 * @param PriSpAfilVO priSpAfilVO
	 * @return List<PriSpAfilVO>
	 * @exception EventException
	 */
	public List<PriSpAfilVO> searchManualCheckInquiry(PriSpAfilVO priSpAfilVO) throws EventException {
		try {
			return dbDao.searchManualCheckInquiry(priSpAfilVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}		
}