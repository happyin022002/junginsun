/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCLoadingAgentProposalBCImpl.java
*@FileTitle : S/C Proposal Loading Agent Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.01
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.06.01 최성민
* 1.0 Creation
* 
* 2012.02.23 이석준[CHM-201216153-01] S/C Amendment History 화면 기능 개선 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scloadingagentproposal.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.pri.scproposal.scloadingagentproposal.integration.SCLoadingAgentProposalDBDAO;
import com.hanjin.apps.alps.esm.pri.scproposal.scloadingagentproposal.vo.RsltLodgAgnListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scloadingagentproposal.vo.RsltSvcScpCdCntVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPropCopyVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriSpMnVO;
import com.hanjin.syscommon.common.table.PriSpScpLodgAgnVO;
import com.hanjin.syscommon.common.table.PriSpScpMnVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.PriSpHistoryInquiryParamVO;

/**
 * NIS2010-SCProposal Business Logic Basic Command implementation<br>
 * - NIS2010-SCProposal에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author CHOI SUNG MIN 
 * @see ESM_PRI_0003_07EventResponse,SCLoadingAgentProposalBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */ 
public class SCLoadingAgentProposalBCImpl extends BasicCommandSupport implements SCLoadingAgentProposalBC {

	// Database Access Object
	private transient SCLoadingAgentProposalDBDAO dbDao = null;

	/**
	 * SCLoadingAgentProposalBCImpl 객체 생성<br>
	 * SCLoadingAgentProposalDBDAO를 생성한다.<br>
	 */
	public SCLoadingAgentProposalBCImpl() {
		dbDao = new SCLoadingAgentProposalDBDAO();
	}
	/**
	 * S/C Proposal Loading Agent 정보를 조회합니다.<br>
	 * 
	 * @param PriSpScpLodgAgnVO priSpScpLodgAgnVO  
	 * @return List<PriSpScpLodgAgnVO>
	 * @exception EventException
	 */
	public List<RsltLodgAgnListVO> searchLoadingAgentList(PriSpScpLodgAgnVO priSpScpLodgAgnVO) throws EventException {
		try {
			return dbDao.searchLoadingAgentList(priSpScpLodgAgnVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	
	
	/**
	 * SCOPE 삭제 이벤트 처리<br>
	 * SCOPE에 해당하는 모든 데이터를 삭제처리한다.<br>
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposal(PriSpScpMnVO priSpScpMnVO, SignOnUserAccount account) throws EventException{
		try {
			dbDao.removeProposal(priSpScpMnVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * S/C Proposal Loading Agent 정보를 저장합니다.<br>
	 * 
	 * @param PriSpScpLodgAgnVO[] priSpScpLodgAgnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageLoadingAgent(PriSpScpLodgAgnVO[] priSpScpLodgAgnVO, SignOnUserAccount account) throws EventException{
		try {
			List<PriSpScpLodgAgnVO> insertVoList = new ArrayList<PriSpScpLodgAgnVO>();
			List<PriSpScpLodgAgnVO> updateVoList = new ArrayList<PriSpScpLodgAgnVO>();
			List<PriSpScpLodgAgnVO> deleteVoList = new ArrayList<PriSpScpLodgAgnVO>();
			for ( int i=0; i<priSpScpLodgAgnVO .length; i++ ) {
				if ( priSpScpLodgAgnVO[i].getIbflag().equals("I")){
					priSpScpLodgAgnVO[i].setCreUsrId(account.getUsr_id());
					priSpScpLodgAgnVO[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(priSpScpLodgAgnVO[i]);
				} else if ( priSpScpLodgAgnVO[i].getIbflag().equals("U")){
					priSpScpLodgAgnVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(priSpScpLodgAgnVO[i]);
				} else if ( priSpScpLodgAgnVO[i].getIbflag().equals("D")){
					deleteVoList.add(priSpScpLodgAgnVO[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addManageLoadingAgentS(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyManageLoadingAgentS(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeManageLoadingAgentS(deleteVoList);
			}
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * S/C Proposal Loading Agent 정보를 ALL ACCEPT 합니다.<br>
	 * 
	 * @param PriSpScpLodgAgnVO[] priSpScpLodgAgnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptAllLoadingAgent(PriSpScpLodgAgnVO[] priSpScpLodgAgnVO, SignOnUserAccount account) throws EventException{
		try {
			List<PriSpScpLodgAgnVO> updateVoList = new ArrayList<PriSpScpLodgAgnVO>();
			for ( int i=0; i<priSpScpLodgAgnVO .length; i++ ) {
				if ( priSpScpLodgAgnVO[i].getIbflag().equals("U")){
					priSpScpLodgAgnVO[i].setUpdUsrId(account.getUsr_id());			
					priSpScpLodgAgnVO[i].setAcptOfcCd(account.getOfc_cd());
					priSpScpLodgAgnVO[i].setAcptUsrId(account.getUsr_id());
					priSpScpLodgAgnVO[i].setAcptDt("1"); //'1'이면 SYSDATE											
					updateVoList.add(priSpScpLodgAgnVO[i]);
				}
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyAcceptAllLoadingAgentS(updateVoList);
			}
			
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * S/C Proposal Loading Agent 정보를 ACCEPT CANCEL 합니다.<br>
	 * 
	 * @param PriSpScpLodgAgnVO[] priSpScpLodgAgnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelLoadingAgent(PriSpScpLodgAgnVO[] priSpScpLodgAgnVO, SignOnUserAccount account) throws EventException{
		try {
			List<PriSpScpLodgAgnVO> updateVoList = new ArrayList<PriSpScpLodgAgnVO>();
			for ( int i=0; i<priSpScpLodgAgnVO .length; i++ ) {
				if ( priSpScpLodgAgnVO[i].getIbflag().equals("U")){
					priSpScpLodgAgnVO[i].setUpdUsrId(account.getUsr_id());
					
					priSpScpLodgAgnVO[i].setAcptOfcCd(null);
					priSpScpLodgAgnVO[i].setAcptUsrId(null);	
					priSpScpLodgAgnVO[i].setAcptDt(null);
					
					updateVoList.add(priSpScpLodgAgnVO[i]);
				}
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyCancelLoadingAgentS(updateVoList);
			}
			
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * S/C Proposal Loading Agent 정보를 ACCEPT 합니다.<br>
	 * 
	 * @param PriSpScpLodgAgnVO[] priSpScpLodgAgnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptLoadingAgent(PriSpScpLodgAgnVO[] priSpScpLodgAgnVO, SignOnUserAccount account) throws EventException{
		try {
			List<PriSpScpLodgAgnVO> updateVoList = new ArrayList<PriSpScpLodgAgnVO>();
			for ( int i=0; i<priSpScpLodgAgnVO .length; i++ ) {
				if ( priSpScpLodgAgnVO[i].getIbflag().equals("U")){
					priSpScpLodgAgnVO[i].setUpdUsrId(account.getUsr_id());
					priSpScpLodgAgnVO[i].setAcptOfcCd(account.getOfc_cd());
					priSpScpLodgAgnVO[i].setAcptUsrId(account.getUsr_id());	
					priSpScpLodgAgnVO[i].setAcptDt("1"); //'1'이면 SYSDATE	
					updateVoList.add(priSpScpLodgAgnVO[i]);
				}
			}			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyAcceptLoadingAgentS(updateVoList);
			}			
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * S/C Proposal Loading Agent 정보를 ALL ACCEPT CANCEL 합니다.<br>
	 * 
	 * @param PriSpScpLodgAgnVO[] priSpScpLodgAgnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelAllLoadingAgent(PriSpScpLodgAgnVO[] priSpScpLodgAgnVO, SignOnUserAccount account) throws EventException{
		try {
			List<PriSpScpLodgAgnVO> updateVoList = new ArrayList<PriSpScpLodgAgnVO>();
			for ( int i=0; i<priSpScpLodgAgnVO .length; i++ ) {
				if ( priSpScpLodgAgnVO[i].getIbflag().equals("U")){
					priSpScpLodgAgnVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(priSpScpLodgAgnVO[i]);
					
					priSpScpLodgAgnVO[i].setAcptOfcCd(null);
					priSpScpLodgAgnVO[i].setAcptUsrId(null);	
					priSpScpLodgAgnVO[i].setAcptDt(null);
				}
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyCancelAllLoadingAgentS(updateVoList);
			}			
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * SCOPE에 'TAW','TAE','ASE','ASW' 코드가 존재하는지 조회한다.<br>
	 * 
	 * @param PriSpScpLodgAgnVO priSpScpLodgAgnVO  
	 * @return List<PriSpScpLodgAgnVO>
	 * @exception EventException
	 */
	public List<RsltSvcScpCdCntVO> searchSvcScpCdCount(PriSpScpLodgAgnVO priSpScpLodgAgnVO) throws EventException {
		try {
			return dbDao.searchSvcScpCdCount(priSpScpLodgAgnVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
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
// (pri_sp_scp_lodg_agn)
			dbDao.addLoadingAgentAmend (insertVoList);
				
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}	

    /**
     * Proposal Scope Loading Agent 정보를 Copy 합니다.<br>
     * 
     * @param RsltPropCopyVO vo
	 * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalScopeLoading(RsltPropCopyVO vo, SignOnUserAccount account) throws EventException{
        try {
            vo.setCreUsrId(account.getUsr_id());
            vo.setUpdUsrId(account.getUsr_id());
            vo.setOfcCd(account.getOfc_cd());
            // PRI_SP_SCP_LODG_AGN COPY
            dbDao.addCopyProposalScopeLoading(vo);
        } catch (DAOException ex) {
            //log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            //log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }

	/**
	 * TERMS가  모두 ACCEPT되었는지 확인한다.<br>
	 * 
	 * @param PriSpScpMnVO priSpScpMn
	 * @return int
	 * @exception EventException
	 */
	public int searchProposalScopeDeleteCheck(PriSpScpMnVO  priSpScpMn) throws EventException {
		try {
			return dbDao.searchProposalScopeDeleteCheck(priSpScpMn);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}  
	/**
	 * Request Cancel시 Accepted 데이터를 일괄 Init 으로 변경합니다.<br>
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
	 * S/C Proposal Loading Agent History 정보를 조회합니다.<br>
	 * 
	 * @param PriSpScpLodgAgnVO priSpScpLodgAgnVO
	 * @param PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO  
	 * @return List<PriSpScpLodgAgnVO>
	 * @exception EventException
	 */
	public List<RsltLodgAgnListVO> searchLoadingAgentHistoryList(PriSpScpLodgAgnVO priSpScpLodgAgnVO,PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO) throws EventException {
		try {
			return dbDao.searchLoadingAgentHistoryList(priSpScpLodgAgnVO,priSpHistoryInquiryParamVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	
	/**
	 * S/C Proposal Loading Agent History 정보를 조회합니다.<br>
	 * 
	 * @param PriSpScpLodgAgnVO priSpScpLodgAgnVO  
	 * @return List<PriSpScpLodgAgnVO>
	 * @exception EventException
	 */
	public List<RsltLodgAgnListVO> searchLoadingAgentInquiryList(PriSpScpLodgAgnVO priSpScpLodgAgnVO) throws EventException {
		try {
			return dbDao.searchLoadingAgentInquiryList(priSpScpLodgAgnVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
}