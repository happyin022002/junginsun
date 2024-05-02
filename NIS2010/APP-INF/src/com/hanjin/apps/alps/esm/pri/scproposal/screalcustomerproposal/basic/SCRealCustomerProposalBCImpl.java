/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SCRealCustomerProposalBCImpl.java
*@FileTitle : Real Customer Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2011.09.23
*@LastModifier : 서미진
*@LastVersion : 1.0
* 2011.09.23 
* 1.0 Creation
=========================================================
* History
* 2011.11.11 서미진 [CHM-201114405] Location 정보 추가로 입력할 수 있도록 처리
* =========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.screalcustomerproposal.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPropCopyVO;
import com.hanjin.apps.alps.esm.pri.scproposal.screalcustomerproposal.integration.SCRealCustomerProposalDBDAO;
import com.hanjin.apps.alps.esm.pri.scproposal.screalcustomerproposal.vo.PriSpRealCustVO;
import com.hanjin.apps.alps.esm.pri.scproposal.screalcustomerproposal.vo.RsltRealCustInquiryVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriSpMnVO;

/**
 * ALPS-SCProposal Business Logic Command Interface<br>
 * - ALPS-SCProposal에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author SEO MI JIN
 * @see SCRealCustomerProposalBC 참조
 * @since J2EE 1.6
 */
public class SCRealCustomerProposalBCImpl extends BasicCommandSupport implements SCRealCustomerProposalBC {

	// Database Access Object
	private transient SCRealCustomerProposalDBDAO dbDao = null;

	/**
	 * SCRealCustomerProposalBCImpl 객체 생성<br>
	 * SCRealCustomerProposalDBDAO를 생성한다.<br>
	 */
	public SCRealCustomerProposalBCImpl() {
		dbDao = new SCRealCustomerProposalDBDAO();
	}
	
	/**
	 * ESM_PRI_0040 : RETRIEVE 
	 * Real Customer 정보를 조회 합니다.<br>
	 * 
	 * @param RsltRealCustInquiryVO rsltRealCustInquiryVO
	 * @return List<RsltRealCustInquiryVO>
	 * @exception DAOException
	 */
	public List<RsltRealCustInquiryVO> searchRealCustomerList(RsltRealCustInquiryVO rsltRealCustInquiryVO) throws EventException {
		try {
			return dbDao.searchRealCustomerList(rsltRealCustInquiryVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * ESM_PRI_0040 : SAVE 
	 * Real Customer 정보를 관리 합니다.<br>
	 * 
	 * @param PriSpRealCustVO[] priSpRealCustVOs 
	 * @param SignOnUserAccount account 
	 * @exception EventException
	 */
	public void manageRealCustomer(PriSpRealCustVO[] priSpRealCustVOs, SignOnUserAccount account) throws EventException {
		// TODO Auto-generated method stub
			try {			
			List<PriSpRealCustVO> insertSheetVoList = new ArrayList<PriSpRealCustVO>();
			List<PriSpRealCustVO> updateSheetVoList = new ArrayList<PriSpRealCustVO>();
			List<PriSpRealCustVO> deleteSheetVoList = new ArrayList<PriSpRealCustVO>();			
				
				if(priSpRealCustVOs != null)	{
					for ( int i=0; i<priSpRealCustVOs .length; i++ ) {
						if ( priSpRealCustVOs[i].getIbflag().equals("D")){
							deleteSheetVoList.add(priSpRealCustVOs[i]);						
						}else if ( priSpRealCustVOs[i].getIbflag().equals("I")){
							priSpRealCustVOs[i].setCreUsrId(account.getUsr_id());
							priSpRealCustVOs[i].setUpdUsrId(account.getUsr_id());
							insertSheetVoList.add(priSpRealCustVOs[i]);					
							dbDao.addRealCustomer(priSpRealCustVOs[i]);
						}else if ( priSpRealCustVOs[i].getIbflag().equals("U")){
							priSpRealCustVOs[i].setUpdUsrId(account.getUsr_id());
							updateSheetVoList.add(priSpRealCustVOs[i]);
						}
					}	
				}

				if ( deleteSheetVoList.size() > 0 ) {
					dbDao.removeRealCustomer(deleteSheetVoList);
				}		
				
				if ( updateSheetVoList.size() > 0 ) {						
					dbDao.modifyRealCustomer(updateSheetVoList);
				}	
			
		}catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * ESM_PRI_0040 : SAVE 
	 * Proposal No. AMD NO.에 해당하는 Real Customer를 모두 삭제 합니다. <br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @exception EventException
	 */
	public void removeAllRealCustomer(PriSpMnVO priSpMnVO) throws EventException {
		// TODO Auto-generated method stub
		try {
			dbDao.removeAllRealCustomer(priSpMnVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI06004",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI06004",new String[]{}).getMessage(), ex);
		}
	}	
	
	/**
	 * Real Customer를 COPY 합니다. <br>
	 * 
	 * @param RsltPropCopyVO vo
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void copyRealCustomer(RsltPropCopyVO vo, SignOnUserAccount account) throws EventException {
		// TODO Auto-generated method stub
		try {
			List<RsltPropCopyVO> insertVoList = new ArrayList<RsltPropCopyVO>();
			
			vo.setCreUsrId(account.getUsr_id());
			vo.setUpdUsrId(account.getUsr_id());
			insertVoList.add(vo);
			
			dbDao.addcopyRealCustomer(insertVoList);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI06004",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI06004",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * 해당 조건의 Real Customer 데이터를 Amend Seq + 1하여 추가합니다.
	 * 
	 * @param PriSpMnVO priSpMnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void copyAmendRealCustomer(PriSpMnVO priSpMnVO,SignOnUserAccount account) throws EventException {
		// TODO Auto-generated method stub
		try {
			List<PriSpMnVO> insertVoList = new ArrayList<PriSpMnVO>();
			
			priSpMnVO.setCreUsrId(account.getUsr_id());
			priSpMnVO.setUpdUsrId(account.getUsr_id());
			insertVoList.add(priSpMnVO);
			
			dbDao.addcopyAmendRealCustomer(insertVoList);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI06004",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI06004",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
     * ESM_PRI_0040 : OPEN<br>
     * Affiliate와 Loading Agent 의 cust 정보를 조회합니다.<br>
	 * 
	 * @param PriSpRealCustVO priSpRealCustVO
     * @return List<PriSpRealCustVO>
	 * @exception EventException
	 */
	public List<PriSpRealCustVO> searchAffiliateLoadingagentInfo(PriSpRealCustVO priSpRealCustVO) throws EventException {
		try {
			return dbDao.searchAffiliateLoadingagentInfo(priSpRealCustVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
}