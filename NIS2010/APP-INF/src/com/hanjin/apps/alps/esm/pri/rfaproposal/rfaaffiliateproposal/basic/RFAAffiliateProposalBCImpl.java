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
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfaaffiliateproposal.basic;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaaffiliateproposal.integration.RFAAffiliateProposalDBDAO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaaffiliateproposal.vo.CstPriRpAfilVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaaffiliateproposal.vo.PriRpAfilInqVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaaffiliateproposal.vo.RsltAfilListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaaffiliateproposal.vo.RsltPriRpAfilHdrVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaaffiliateproposal.vo.RsltPriRpAfilVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltRfaPropCopyVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriRpAfilVO;
import com.hanjin.syscommon.common.table.PriRpMnVO;

/**
 * NIS2010-SCProposal Business Logic Basic Command implementation<br>
 * - NIS2010-SCProposal에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Kong Back Jin
 * @see ESM_PRI_0025EventResponse,SCAffiliateProposalBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class RFAAffiliateProposalBCImpl extends BasicCommandSupport implements RFAAffiliateProposalBC {

	// Database Access Object
	private transient RFAAffiliateProposalDBDAO dbDao = null;

	/**
	 * SCAffiliateProposalBCImpl 객체 생성<br>
	 * SCAffiliateProposalDBDAO를 생성한다.<br>
	 */
	public RFAAffiliateProposalBCImpl() {
		dbDao = new RFAAffiliateProposalDBDAO();
	}
	
	/**
	 * Affiliate List를 조회한다. <br>
	 * 
	 * @param PriRpAfilVO priRpAfilVO
	 * @return List<RsltPriRpAfilVO>
	 * @exception EventException
	 */
	public List<RsltPriRpAfilVO> searchAffiliateList(PriRpAfilVO priRpAfilVO) throws EventException {
		try {
			return dbDao.searchAffiliateList(priRpAfilVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}
	
	/**
	 *  Manual check를 하기위한 조건을 조회한다. <br>
	 * 
	 * @param PriRpAfilVO priRpAfilVO 
	 * @return List<PriRpAfilVO>
	 * @exception EventException
	 */
	public List<PriRpAfilVO> searchManualCheck(PriRpAfilVO priRpAfilVO) throws EventException {
		try {
			return dbDao.searchManualCheck(priRpAfilVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}	
	
	/**
	 * Affiliate List를 수정한다. <br>
	 * 
	 * @param PriRpAfilVO[] priRpAfilVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageAffiliate(PriRpAfilVO[] priRpAfilVO, SignOnUserAccount account) throws EventException{
		try {
			List<PriRpAfilVO> insertVoList = new ArrayList<PriRpAfilVO>();
			List<PriRpAfilVO> updateVoList = new ArrayList<PriRpAfilVO>();
			List<PriRpAfilVO> deleteVoList = new ArrayList<PriRpAfilVO>();
			for ( int i=0; i<priRpAfilVO .length; i++ ) {
				if ( priRpAfilVO[i].getIbflag().equals("I")){
					priRpAfilVO[i].setCreUsrId(account.getUsr_id());
					priRpAfilVO[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(priRpAfilVO[i]);
				} else if ( priRpAfilVO[i].getIbflag().equals("U")){
					priRpAfilVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(priRpAfilVO[i]);
				} else if ( priRpAfilVO[i].getIbflag().equals("D")){
					deleteVoList.add(priRpAfilVO[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addmanageAffiliateS(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifymanageAffiliateS(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removemanageAffiliateS(deleteVoList);
			}
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
	}
	
	/**
	 * Affiliate를 Accept을 실행한다. <br>
	 * 
	 * @param PriRpAfilVO[] priRpAfilVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptAffiliate(PriRpAfilVO[] priRpAfilVO, SignOnUserAccount account) throws EventException{
		try {
			List<PriRpAfilVO> updateVoList = new ArrayList<PriRpAfilVO>();
			String currentDate = new SimpleDateFormat("yyyyMMdd").format(new Date());
			
			for ( int i=0; i<priRpAfilVO .length; i++ ) {
				if ( priRpAfilVO[i].getIbflag().equals("U")){
					priRpAfilVO[i].setUpdUsrId(account.getUsr_id());
					priRpAfilVO[i].setAcptUsrId(account.getUsr_id());
					priRpAfilVO[i].setAcptOfcCd(account.getOfc_cd());								
					priRpAfilVO[i].setAcptDt(currentDate);						
					updateVoList.add(priRpAfilVO[i]);
				}
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifymanageAffiliateS(updateVoList);
			}

        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
	}	
	/**
	 * Affiliate를 Accept Cancel을 실행한다. <br>
	 * 
	 * @param PriRpAfilVO[] priRpAfilVO 
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelAffiliate(PriRpAfilVO[] priRpAfilVO, SignOnUserAccount account) throws EventException{
		try {
			List<PriRpAfilVO> updateVoList = new ArrayList<PriRpAfilVO>();

			for ( int i=0; i<priRpAfilVO .length; i++ ) {
				if ( priRpAfilVO[i].getIbflag().equals("U")){
					priRpAfilVO[i].setUpdUsrId(account.getUsr_id());
					priRpAfilVO[i].setAcptUsrId("");
					priRpAfilVO[i].setAcptOfcCd("");								
					priRpAfilVO[i].setAcptDt(null);							
					updateVoList.add(priRpAfilVO[i]);
				}
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifymanageAffiliateS(updateVoList);
			}

        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
	}		
	
	/**
	 * Affiliate를 Accept All을 실행한다. <br>
	 * 
	 * @param CstPriRpAfilVO cstPriRpAfilVO 
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptAllAffiliate(CstPriRpAfilVO cstPriRpAfilVO, SignOnUserAccount account) throws EventException{
		try {

			String currentDate = new SimpleDateFormat("yyyyMMdd").format(new Date());
			if (cstPriRpAfilVO != null  ) {
				cstPriRpAfilVO.setUpdUsrId(account.getUsr_id());					
				cstPriRpAfilVO.setAcptUsrId(account.getUsr_id());
				cstPriRpAfilVO.setAcptOfcCd(account.getOfc_cd());
				cstPriRpAfilVO.setPrcProgStsCd(cstPriRpAfilVO.getStsCd());
				cstPriRpAfilVO.setAcptDt(currentDate);					

			}

			dbDao.modifyAcceptAllAffiliate (cstPriRpAfilVO);	

        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
	}		
	/**
	 * Affiliate를 Accept Cancel All을 실행한다. <br>
	 * 
	 * @param CstPriRpAfilVO cstPriRpAfilVO 
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelAllAffiliate(CstPriRpAfilVO cstPriRpAfilVO, SignOnUserAccount account) throws EventException{
		try {
			if (cstPriRpAfilVO != null  ) {
				cstPriRpAfilVO.setUpdUsrId(account.getUsr_id());					
				cstPriRpAfilVO.setAcptUsrId("");
				cstPriRpAfilVO.setAcptOfcCd("");								
				cstPriRpAfilVO.setAcptDt(null);	
				cstPriRpAfilVO.setPrcProgStsCd(cstPriRpAfilVO.getStsCd());
			}	
			dbDao.modifyAcceptAllAffiliate (cstPriRpAfilVO);	

        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
	}			
	
	/**
	 * Amend Request를 처리합니다.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void amendProposal(PriRpMnVO priRpMnVO, SignOnUserAccount account) throws EventException{
		try {

			List<PriRpMnVO> insertVoList = new ArrayList<PriRpMnVO>();
			
			priRpMnVO.setCreUsrId(account.getUsr_id());
			priRpMnVO.setUpdUsrId(account.getUsr_id());					
			insertVoList.add(priRpMnVO);

			dbDao.addAffiliateAmend (insertVoList);
				
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
	}	

    /**
     * RFA Proposal Affiliate 정보를 Copy 합니다.<br>
     * 
     * @param RsltRfaPropCopyVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalAffiliate (RsltRfaPropCopyVO vo, SignOnUserAccount account) throws EventException {
        try {
            vo.setCreUsrId(account.getUsr_id());
            vo.setUpdUsrId(account.getUsr_id());
            vo.setOfcCd(account.getOfc_cd());
            // PRI_RP_AFIL COPY
            dbDao.addCopyProposalAffiliate(vo);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }
    

	/**
	 * 해당 Amend seq에 해당하는 모든 데이터를 삭제처리한다.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO 
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposal(PriRpMnVO priRpMnVO, SignOnUserAccount account) throws EventException{
		try {
			dbDao.removeProposal(priRpMnVO);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
	}	
	/**
	 * Request Cancel시 Main Duration의 Accepted 데이터를 일괄 Init 으로 변경합니다.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO 
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalRequestCancel(PriRpMnVO priRpMnVO,SignOnUserAccount account) throws EventException{
		try {
			if (priRpMnVO != null  ) {
				priRpMnVO.setUpdUsrId(account.getUsr_id());					
			}			
			dbDao.modifyProposalRequestCancel(priRpMnVO);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
	}		
	
	/**
	 * affiliate Amend History를 조회한다.<br>
	 * 
	 * @param PriRpAfilVO priRpAfilVO
     * @return List<RsltAfilListVO>
	 * @exception EventException
	 */
	public List<RsltAfilListVO> searchAffiliateHistoryList(PriRpAfilVO priRpAfilVO) throws EventException {
		try {
			return dbDao.searchAffiliateHistoryList(priRpAfilVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}	
	
	/**
	 * Affiliate Inquiry 를 조회한다.<br>
	 * 
	 * @param PriRpAfilVO priRpAfilVO 
	 * @return List<PriRpAfilInqVO>
	 * @exception EventException
	 */
	public List<PriRpAfilInqVO> searchAffiliateInquiryList(PriRpAfilVO priRpAfilVO) throws EventException {
		try {
			return dbDao.searchAffiliateInquiryList(priRpAfilVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}	
	
	/**
	 * DEM/DET 에서 호출하면 Proposal No.로 Affiliate 의 기본정보를 조회한다. <br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @return List<RsltPriRpAfilHdrVO>
	 * @exception EventException
	 */
	public List<RsltPriRpAfilHdrVO> searchAffiliateHeader(PriRpMnVO priRpMnVO) throws EventException {
		try {
			return dbDao.searchAffiliateHeader(priRpMnVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}	
}