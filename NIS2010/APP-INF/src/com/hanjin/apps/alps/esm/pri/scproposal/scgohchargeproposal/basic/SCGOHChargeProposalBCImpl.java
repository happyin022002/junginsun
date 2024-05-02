/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCGOHChargeProposalBCImpl.java
*@FileTitle : S/C Proposal 및 Amendment시  GOH 생성/수정하는 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.26
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.05.26 김재연
* 1.0 Creation
=========================================================
* History
* 2011.03.29 김민아 [CHM-201109656-01] Scope별 Partial Accept All 기능 추가 - GOH Terms의 Quick Accept할 데이터 조회 추가.
* 2012.02.23 이석준[CHM-201216153-01] S/C Amendment History 화면 기능 개선 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scgohchargeproposal.basic;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hanjin.apps.alps.esm.pri.scproposal.scgohchargeproposal.integration.SCGOHChargeProposalDBDAO;
import com.hanjin.apps.alps.esm.pri.scproposal.scgohchargeproposal.vo.CstPriSpScpGohChgVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scgohchargeproposal.vo.RsltGohChgListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPropCopyVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.SpScpGlineCopyVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriSpMnVO;
import com.hanjin.syscommon.common.table.PriSpScpGohChgVO;
import com.hanjin.syscommon.common.table.PriSpScpMnVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.PriSpHistoryInquiryParamVO;

/**
 * NIS2010-SCProposal Business Logic Basic Command implementation<br>
 * - NIS2010-SCProposal에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author JaeYeon Kim
 * @see ESM_PRI_0003_06EventResponse,SCGOHChargeProposalBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */ 
public class SCGOHChargeProposalBCImpl extends BasicCommandSupport implements SCGOHChargeProposalBC {

	// Database Access Object
	private transient SCGOHChargeProposalDBDAO dbDao = null;

	/**
	 * SCGOHChargeProposalBCImpl 객체 생성<br>
	 * SCGOHChargeProposalDBDAO를 생성한다.<br>
	 */
	public SCGOHChargeProposalBCImpl() {
		dbDao = new SCGOHChargeProposalDBDAO();
	}
	
	/**
	 * S/C Proposal Creation - GOH List를 조회합니다. <br>
	 *  
	 * @param PriSpScpGohChgVO priSpScpGohChgVO
	 * @return List<RsltGohChgListVO>
	 * @exception EventException
	 */
	public List<RsltGohChgListVO> searchGOHChargeList(PriSpScpGohChgVO priSpScpGohChgVO) throws EventException {
		try {
			return dbDao.searchGOHChargeList(priSpScpGohChgVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * S/C Proposal Creation - GOH List를 수정합니다. <br>
	 * 
	 * @param PriSpScpGohChgVO[] priSpScpGohChgVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageGOHCharge(PriSpScpGohChgVO[] priSpScpGohChgVO, SignOnUserAccount account) throws EventException{
		try {
			List<PriSpScpGohChgVO> insertVoList = new ArrayList<PriSpScpGohChgVO>();
			List<PriSpScpGohChgVO> updateVoList = new ArrayList<PriSpScpGohChgVO>();
			List<PriSpScpGohChgVO> deleteVoList = new ArrayList<PriSpScpGohChgVO>();
			for ( int i=0; i<priSpScpGohChgVO .length; i++ ) {
				if ( priSpScpGohChgVO[i].getIbflag().equals("I")){
					priSpScpGohChgVO[i].setCreUsrId(account.getUsr_id());
					priSpScpGohChgVO[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(priSpScpGohChgVO[i]);
				} else if ( priSpScpGohChgVO[i].getIbflag().equals("U")){
					priSpScpGohChgVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(priSpScpGohChgVO[i]);
				} else if ( priSpScpGohChgVO[i].getIbflag().equals("D")){
					deleteVoList.add(priSpScpGohChgVO[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addProposalGOHCharge(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyProposalGOHCharge(updateVoList, "N");
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeProposalGOHCharge(deleteVoList);
			}
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}
	
	/**
	 * S/C Proposal Creation - GOH를 accept 합니다. <br>
	 * 
	 * @param PriSpScpGohChgVO priSpScpGohChgVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptGOHCharge(PriSpScpGohChgVO[] priSpScpGohChgVO, SignOnUserAccount account) throws EventException {
		try {
		
			List<PriSpScpGohChgVO> updateVoList = new ArrayList<PriSpScpGohChgVO>();
			
			for(int i=0; priSpScpGohChgVO != null && i < priSpScpGohChgVO.length; i++) {
				if(priSpScpGohChgVO[i].getIbflag().equals("U")) {
					priSpScpGohChgVO[i].setUpdUsrId(account.getUsr_id());	
					priSpScpGohChgVO[i].setAcptUsrId(account.getUsr_id());
					priSpScpGohChgVO[i].setAcptOfcCd(account.getOfc_cd());			
					String currentDate = new SimpleDateFormat("yyyyMMdd").format(new Date());			
					priSpScpGohChgVO[i].setAcptDt(currentDate);
					updateVoList.add(priSpScpGohChgVO[i]);
				}	
			}
			
			if(updateVoList.size() > 0) {
				dbDao.modifyProposalGOHCharge(updateVoList, "Y");
			}
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}
	
	/**
	 * S/C Proposal Creation - GOH 를 Accept Cancel 처리합니다. <br>
	 * 
	 * @param PriSpScpGohChgVO priSpScpGohChgVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelGOHCharge(PriSpScpGohChgVO[] priSpScpGohChgVO, SignOnUserAccount account) throws EventException {
		try {
		
			List<PriSpScpGohChgVO> updateVoList = new ArrayList<PriSpScpGohChgVO>();
			
			for(int i=0; priSpScpGohChgVO != null && i < priSpScpGohChgVO.length; i++) {
				if(priSpScpGohChgVO[i].getIbflag().equals("U")) {
					priSpScpGohChgVO[i].setUpdUsrId(account.getUsr_id());	
					priSpScpGohChgVO[i].setAcptUsrId("");
					priSpScpGohChgVO[i].setAcptOfcCd("");			
					priSpScpGohChgVO[i].setAcptDt(null);
		
					updateVoList.add(priSpScpGohChgVO[i]);
				}
			}
			
			if(updateVoList.size() > 0) {
				dbDao.modifyProposalGOHCharge(updateVoList, "Y");
			}
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}
	
	/**
	 * S/C Proposal Creation - GOH 를 Accept All 처리합니다. <br>
	 * 
	 * @param PriSpScpGohChgVO[] priSpScpGohChgVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptAllGOHCharge(PriSpScpGohChgVO[] priSpScpGohChgVO, SignOnUserAccount account) throws EventException {
		try {
		
			List<PriSpScpGohChgVO> updateVoList = new ArrayList<PriSpScpGohChgVO>();
			
			for(int i=0; priSpScpGohChgVO != null && i < priSpScpGohChgVO.length; i++) {
				if(priSpScpGohChgVO[i].getIbflag().equals("U")) {
					priSpScpGohChgVO[i].setUpdUsrId(account.getUsr_id());
					priSpScpGohChgVO[i].setAcptUsrId(account.getUsr_id());
					priSpScpGohChgVO[i].setAcptOfcCd(account.getOfc_cd());			
					String currentDate = new SimpleDateFormat("yyyyMMdd").format(new Date());			
					priSpScpGohChgVO[i].setAcptDt(currentDate);
					updateVoList.add(priSpScpGohChgVO[i]);
				}
			}
			
			if(updateVoList.size() > 0)	{
				dbDao.modifyProposalGOHCharge(updateVoList, "Y");
			}
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}
	
	/**
	 * S/C Proposal Creation - GOH 를 Accept Cancel All 처리합니다. <br>
	 * 
	 * @param PriSpScpGohChgVO[] priSpScpGohChgVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelAllGOHCharge(PriSpScpGohChgVO[] priSpScpGohChgVO, SignOnUserAccount account) throws EventException {
		try {
		
			List<PriSpScpGohChgVO> updateVoList = new ArrayList<PriSpScpGohChgVO>();
			
			for(int i=0; priSpScpGohChgVO != null && i < priSpScpGohChgVO.length; i++) {
				if(priSpScpGohChgVO[i].getIbflag().equals("U")) {
					priSpScpGohChgVO[i].setUpdUsrId(account.getUsr_id());
					priSpScpGohChgVO[i].setAcptUsrId("");
					priSpScpGohChgVO[i].setAcptOfcCd("");			
					priSpScpGohChgVO[i].setAcptDt(null);
					updateVoList.add(priSpScpGohChgVO[i]);
				}
			}
			
			if(updateVoList.size() > 0)	{
				dbDao.modifyProposalGOHCharge(updateVoList, "Y");
			}
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}
	
	/**
	 * S/C Proposal Creation - GOH Cuideline을 Copy합니다. <br>
	 * 
	 * @param CstPriSpScpGohChgVO cstPriSpScpGohChgVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void copyGuidelineGOHCharge(CstPriSpScpGohChgVO cstPriSpScpGohChgVO, SignOnUserAccount account) throws EventException {
		try {
			cstPriSpScpGohChgVO.setCreUsrId(account.getUpd_usr_id());
			cstPriSpScpGohChgVO.setUpdUsrId(account.getUpd_usr_id());
			
			dbDao.addCopyGuidelineGOHCharge(cstPriSpScpGohChgVO, account);

		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}
	
	/**
	 * 데이터를 Amend 한다.<br>
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
			
			dbDao.addProposalGOHChargeAmend (insertVoList);
				
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
	}	

    /**
     * Proposal Scope GOH Charge 정보를 Copy 합니다.<br>
     * 
     * @param RsltPropCopyVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalScopeGohChg(RsltPropCopyVO vo, SignOnUserAccount account) throws EventException{
        try {
            vo.setCreUsrId(account.getUsr_id());
            vo.setUpdUsrId(account.getUsr_id());
            vo.setOfcCd(account.getOfc_cd());
            // PRI_SP_SCP_GOH_CHG COPY
            dbDao.addCopyProposalScopeGohChg(vo);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }

    /**
     * Guideline GOH Charge 를 Proposal Scope 으로 Copy 합니다.<br>
     * 
     * @param SpScpGlineCopyVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyScopeGuidelineGohChg(SpScpGlineCopyVO vo, SignOnUserAccount account) throws EventException{
        try {
            vo.setCreUsrId(account.getUsr_id());
            vo.setUpdUsrId(account.getUsr_id());
            // PRI_SP_SCP_GOH_CHG COPY
            dbDao.addCopyScopeGuidelineGohChg(vo);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }

	
	/**
     * Guideline Copy할 데이터가 있는지 확인한다.<br>
     * 
     * @param CstPriSpScpGohChgVO cstPriSpScpGohChgVO
     * @return boolean
     * @exception EventException
     */
	public boolean checkGuidelineGOHChargeExist(CstPriSpScpGohChgVO cstPriSpScpGohChgVO) throws EventException {
		try {
			return dbDao.searchCheckGuidelineGOHChargeExist(cstPriSpScpGohChgVO);			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Request Cancel시 Accepted 데이터 일괄 Init 으로 변경<br>
	 * 해당 회차의 모든데이터가 대상이다.<br>
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO
     * @param SignOnUserAccount account 
	 * @exception EventException
	 */
	public void manageProposalRequestCancel(PriSpScpMnVO priSpScpMnVO,SignOnUserAccount account) throws EventException{
		try {
			if (priSpScpMnVO != null  ) {
				priSpScpMnVO.setUpdUsrId(account.getUsr_id());					
			}
			dbDao.modifyProposalRequestCancel(priSpScpMnVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
	}
	
	/**
	 * SCOPE에 해당하는 모든 데이터를 삭제처리한다.<br>
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO
	 * @param SignOnUserAccount account 
	 * @exception EventException
	 */
	public void manageProposal(PriSpScpMnVO priSpScpMnVO, SignOnUserAccount account) throws EventException {
		try {
			dbDao.removeProposal(priSpScpMnVO);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
	}
	
	/**
	 * S/C Proposal Creation - GOH Amend History List를 조회합니다. <br>
	 * 
	 * @param PriSpScpGohChgVO priSpScpGohChgVO
	 * @param PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO
	 * @return List<RsltGohChgListVO>
	 * @exception EventException
	 */
	public List<RsltGohChgListVO> searchGOHChargeHistoryList(PriSpScpGohChgVO priSpScpGohChgVO,PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO) throws EventException {
		try {
			return dbDao.searchGOHChargeHistoryList(priSpScpGohChgVO,priSpHistoryInquiryParamVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * SC GOH Inquiry List를 조회합니다. <br>
	 * 
	 * @param PriSpScpGohChgVO priSpScpGohChgVO
	 * @return List<RsltGohChgListVO>
	 * @exception EventException
	 */
	public List<RsltGohChgListVO> searchGOHChargeInquiryList(PriSpScpGohChgVO priSpScpGohChgVO) throws EventException {
		try {
			return dbDao.searchGOHChargeInquiryList(priSpScpGohChgVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * S/C Proposal Creation - GOH 를 Quick Accept All 처리합니다. <br>
	 * 
	 * @param PriSpScpGohChgVO priSpScpGohChgVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String quickAcceptAllGOHCharge(PriSpScpGohChgVO priSpScpGohChgVO, SignOnUserAccount account) throws EventException {
		
		String result = "FAIL";
		
		try {
			List<PriSpScpGohChgVO> updateVoList = new ArrayList<PriSpScpGohChgVO>();
			
			priSpScpGohChgVO.setUpdUsrId(account.getUsr_id());
			priSpScpGohChgVO.setAcptOfcCd(account.getOfc_cd());
			priSpScpGohChgVO.setAcptUsrId(account.getUsr_id());
			String currentDate = new SimpleDateFormat("yyyyMMdd").format(new Date());			
			priSpScpGohChgVO.setAcptDt(currentDate);
			
			updateVoList = dbDao.searchGOHChargeQuickList(priSpScpGohChgVO);
			if(updateVoList.size() > 0)	{				
				dbDao.modifyProposalGOHCharge(updateVoList, "Y");
				result = "OK";
			}
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
		return result;
	}
}