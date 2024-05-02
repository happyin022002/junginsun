/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCRoutePointProposalBCImpl.java
*@FileTitle : S/C Proposal Org/Dst Location Information - Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.21
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.05.21 최성민
* 1.0 Creation
=========================================================
* History
* 2011.03.29 김민아 [CHM-201109656-01] Scope별 Partial Accept All 기능 추가 - Ori/Dest Terms의 Quick Accept할 데이터 조회 추가.
* 2012.02.23 이석준[CHM-201216153-01] S/C Amendment History 화면 기능 개선 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scroutepointproposal.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPropCopyVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scroutepointproposal.integration.SCRoutePointProposalDBDAO;
import com.hanjin.apps.alps.esm.pri.scproposal.scroutepointproposal.vo.RsltRoutPntLocListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriSpMnVO;
import com.hanjin.syscommon.common.table.PriSpScpMnVO;
import com.hanjin.syscommon.common.table.PriSpScpRoutPntVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.PriSpHistoryInquiryParamVO;

/**
 * NIS2010-SCProposal Business Logic Basic Command implementation<br>
 * - NIS2010-SCProposal에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author CHOI SUNG MIN
 * @see ESM_PRI_0003_01EventResponse,SCRoutePointProposalBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class SCRoutePointProposalBCImpl extends BasicCommandSupport implements SCRoutePointProposalBC {

	// Database Access Object
	private transient SCRoutePointProposalDBDAO dbDao = null;

	/**
	 * SCRoutePointProposalBCImpl 객체 생성<br>
	 * SCRoutePointProposalDBDAO를 생성한다.<br>
	 */ 
	public SCRoutePointProposalBCImpl() {
		dbDao = new SCRoutePointProposalDBDAO();
	} 
	/**
	 * Org/Dst Location 정보를 조회합니다.<br>
	 * 
	 * @param RsltRoutPntLocListVO rsltRoutPntLocListVO  
	 * @return List<RsltRoutPntLocListVO>
	 * @exception EventException
	 */
	public List<RsltRoutPntLocListVO> searchRoutePointLocationList(RsltRoutPntLocListVO rsltRoutPntLocListVO) throws EventException {
		try {
			return dbDao.searchRoutePointLocationList(rsltRoutPntLocListVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * ROUTE TYPE별로 데이터가 존재하는지 체크하기 위하여 조회한다.<br>
	 * 
	 * @param RsltRoutPntLocListVO rsltRoutPntLocListVO  
	 * @return List<RsltRoutPntLocListVO>
	 * @exception EventException
	 */
	public List<RsltRoutPntLocListVO> searchRoutePointLocationType(RsltRoutPntLocListVO rsltRoutPntLocListVO) throws EventException {
		try {
			return dbDao.searchRoutePointLocationType(rsltRoutPntLocListVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Org/Dst Location 정보를 ACCEPT CANCEL합니다.<br>
	 * 
	 * @param PriSpScpRoutPntVO[] priSpScpRoutPntVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelRoutePointLocation(PriSpScpRoutPntVO[] priSpScpRoutPntVO, SignOnUserAccount account) throws EventException{
		try {
			List<PriSpScpRoutPntVO> updateVoList = new ArrayList<PriSpScpRoutPntVO>();
			for ( int i=0; i<priSpScpRoutPntVO .length; i++ ) {
				if ( priSpScpRoutPntVO[i].getIbflag().equals("U")){
					priSpScpRoutPntVO[i].setUpdUsrId(account.getUsr_id());
									
					priSpScpRoutPntVO[i].setAcptOfcCd(null);
					priSpScpRoutPntVO[i].setAcptUsrId(null);	
					priSpScpRoutPntVO[i].setAcptDt(null);
										
					updateVoList.add(priSpScpRoutPntVO[i]);
				}
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyRoutePointLocation(updateVoList, "Y");
			}
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	

	/**
	 * Org/Dst Location 정보를 ALL ACCEPT CANCEL합니다.<br>
	 * 
	 * @param PriSpScpRoutPntVO[] priSpScpRoutPntVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelAllRoutePoint(PriSpScpRoutPntVO[] priSpScpRoutPntVO, SignOnUserAccount account) throws EventException{
		try {
			List<PriSpScpRoutPntVO> updateVoList = new ArrayList<PriSpScpRoutPntVO>();
			for ( int i=0; i<priSpScpRoutPntVO .length; i++ ) {
				if ( priSpScpRoutPntVO[i].getIbflag().equals("U")){
					priSpScpRoutPntVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(priSpScpRoutPntVO[i]);
					
					priSpScpRoutPntVO[i].setAcptOfcCd(null);
					priSpScpRoutPntVO[i].setAcptUsrId(null);	
					priSpScpRoutPntVO[i].setAcptDt(null);
				}
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyRoutePointLocation(updateVoList, "Y");
			}
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Org/Dst Location 정보를 ACCEPT합니다.<br>
	 * 
	 * @param PriSpScpRoutPntVO[] priSpScpRoutPntVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptRoutePointLocation(PriSpScpRoutPntVO[] priSpScpRoutPntVO, SignOnUserAccount account) throws EventException{
		try {		
			List<PriSpScpRoutPntVO> updateVoList = new ArrayList<PriSpScpRoutPntVO>();
			for ( int i=0; i<priSpScpRoutPntVO .length; i++ ) {
				if ( priSpScpRoutPntVO[i].getIbflag().equals("U")){
					priSpScpRoutPntVO[i].setUpdUsrId(account.getUsr_id());					
					priSpScpRoutPntVO[i].setAcptOfcCd(account.getOfc_cd());
					priSpScpRoutPntVO[i].setAcptUsrId(account.getUsr_id());	
					priSpScpRoutPntVO[i].setAcptDt("1"); //'1'이면 SYSDATE	
					updateVoList.add(priSpScpRoutPntVO[i]);				
				}
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyRoutePointLocation(updateVoList, "Y");
			}
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Main의 Init 상태를 Cancel시 해당 Amend Seq NO.의 모든 데이터를 삭제합니다.<br>
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
	 * Org/Dst Location 정보를 저장합니다.<br>
	 * 
	 * @param PriSpScpRoutPntVO[] priSpScpRoutPntVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageRoutePointLocation(PriSpScpRoutPntVO[] priSpScpRoutPntVO, SignOnUserAccount account) throws EventException{
		try {
			List<PriSpScpRoutPntVO> insertVoList = new ArrayList<PriSpScpRoutPntVO>();
			List<PriSpScpRoutPntVO> updateVoList = new ArrayList<PriSpScpRoutPntVO>();
			List<PriSpScpRoutPntVO> deleteVoList = new ArrayList<PriSpScpRoutPntVO>();
			for ( int i=0; i<priSpScpRoutPntVO .length; i++ ) {
				if ( priSpScpRoutPntVO[i].getIbflag().equals("I")){
					priSpScpRoutPntVO[i].setCreUsrId(account.getUsr_id());
					priSpScpRoutPntVO[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(priSpScpRoutPntVO[i]);
				} else if ( priSpScpRoutPntVO[i].getIbflag().equals("U")){
					priSpScpRoutPntVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(priSpScpRoutPntVO[i]);
				} else if ( priSpScpRoutPntVO[i].getIbflag().equals("D")){
					deleteVoList.add(priSpScpRoutPntVO[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addRoutePointLocation(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyRoutePointLocation(updateVoList, "N");
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeRoutePointLocation(deleteVoList);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Org/Dst Location 정보를 ALL ACCEPT 합니다.<br>
	 * 
	 * @param PriSpScpRoutPntVO[] priSpScpRoutPntVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptAllRoutePoint(PriSpScpRoutPntVO[] priSpScpRoutPntVO, SignOnUserAccount account) throws EventException{
		try {			
			List<PriSpScpRoutPntVO> updateVoList = new ArrayList<PriSpScpRoutPntVO>();
			
			for ( int i=0; i<priSpScpRoutPntVO .length; i++ ) {
				if ( priSpScpRoutPntVO[i].getIbflag().equals("U")){
					priSpScpRoutPntVO[i].setUpdUsrId(account.getUsr_id());				
					priSpScpRoutPntVO[i].setAcptOfcCd(account.getOfc_cd());
					priSpScpRoutPntVO[i].setAcptUsrId(account.getUsr_id());
					priSpScpRoutPntVO[i].setAcptDt("1"); //'1'이면 SYSDATE	
					updateVoList.add(priSpScpRoutPntVO[i]);
				}
			}
						
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyRoutePointLocation(updateVoList, "Y");
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
// pri_sp_scp_rout_pnt)
			dbDao.addRoutePointAmend (insertVoList);
				
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}

    /**
     * Proposal Scope Route Point 정보를 Copy 합니다.<br>
     * 
     * @param RsltPropCopyVO rsltPropCopyVO
	 * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalScopeRoute(RsltPropCopyVO rsltPropCopyVO, SignOnUserAccount account) throws EventException{
        try {
        	rsltPropCopyVO.setCreUsrId(account.getUsr_id());
        	rsltPropCopyVO.setUpdUsrId(account.getUsr_id());
        	rsltPropCopyVO.setOfcCd(account.getOfc_cd());
            // PRI_SP_SCP_ROUT_PNT COPY
            dbDao.addCopyProposalScopeRoute(rsltPropCopyVO);
        } catch (DAOException ex) {
            //log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            //log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }
    

	/**
	 * Request Cancel시 Main Duration의 Accepted 데이터를 일괄 Init 으로 변경합니다.<br>
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
	 * Org/Dst Location 정보를 조회합니다.<br>
	 * 
	 * @param PriSpScpRoutPntVO priSpScpRoutPntVO
	 * @param PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO
	 * @return List<RsltRoutPntLocListVO>
	 * @exception EventException
	 */
	public List<RsltRoutPntLocListVO> searchRoutePointLocationHistoryList(PriSpScpRoutPntVO priSpScpRoutPntVO,PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO) throws EventException {
		try {
			return dbDao.searchRoutePointLocationHistoryList(priSpScpRoutPntVO,priSpHistoryInquiryParamVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * ROUTE TYPE별로 데이터가 존재하는지 체크하기 위하여 조회한다.<br>
	 * 
	 * @param PriSpScpRoutPntVO priSpScpRoutPntVO
	 * @param PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO  
	 * @return List<RsltRoutPntLocListVO>
	 * @exception EventException
	 */
	public List<RsltRoutPntLocListVO> searchRoutePointLocationHistoryType(PriSpScpRoutPntVO priSpScpRoutPntVO,PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO) throws EventException {
		try {
			return dbDao.searchRoutePointLocationHistoryType(priSpScpRoutPntVO,priSpHistoryInquiryParamVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Org/Dst Location 정보를 조회합니다.<br>
	 * 
	 * @param PriSpScpRoutPntVO priSpScpRoutPntVO
	 * @return List<RsltRoutPntLocListVO>
	 * @exception EventException
	 */
	public List<RsltRoutPntLocListVO> searchRoutePointLocationInquiryList(PriSpScpRoutPntVO priSpScpRoutPntVO) throws EventException {
		try {
			return dbDao.searchRoutePointLocationInquiryList(priSpScpRoutPntVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * ROUTE TYPE별로 데이터가 존재하는지 체크하기 위하여 조회한다.<br>
	 * 
	 * @param PriSpScpRoutPntVO priSpScpRoutPntVO  
	 * @return List<RsltRoutPntLocListVO>
	 * @exception EventException
	 */
	public List<RsltRoutPntLocListVO> searchRoutePointLocationInquiryType(PriSpScpRoutPntVO priSpScpRoutPntVO) throws EventException {
		try {
			return dbDao.searchRoutePointLocationInquiryType(priSpScpRoutPntVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * Org/Dst Location 정보를 QUICK ACCEPT ALL 처리 합니다.<br>
	 * 
	 * @param PriSpScpRoutPntVO priSpScpRoutPntVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String quickAcceptAllRoutePoint(PriSpScpRoutPntVO priSpScpRoutPntVO, SignOnUserAccount account) throws EventException{
		String result = "FAIL";
		try {			
			List<PriSpScpRoutPntVO> updateVoList = new ArrayList<PriSpScpRoutPntVO>();
			
			priSpScpRoutPntVO.setUpdUsrId(account.getUsr_id());
			priSpScpRoutPntVO.setAcptOfcCd(account.getOfc_cd());
			priSpScpRoutPntVO.setAcptUsrId(account.getUsr_id());
			priSpScpRoutPntVO.setAcptDt("1"); //'1'이면 SYSDATE
			
			updateVoList = dbDao.searchRoutePointLocationDetailList(priSpScpRoutPntVO);
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyRoutePointLocation(updateVoList, "Y");
				result = "OK";
			}
			
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
		return result;
	}
	
}