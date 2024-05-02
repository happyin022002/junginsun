/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCRoutePointProposalBCImpl.java
*@FileTitle : S/C Proposal Org/Dst Location Information - Creation
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0

=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scroutepointproposal.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.RsltPropCopyVO;
import com.clt.apps.opus.esm.pri.scproposal.scroutepointproposal.integration.SCRoutePointProposalDBDAO;
import com.clt.apps.opus.esm.pri.scproposal.scroutepointproposal.vo.RsltRoutPntLocListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriSpMnVO;
import com.clt.syscommon.common.table.PriSpScpMnVO;
import com.clt.syscommon.common.table.PriSpScpRoutPntVO;

/**
 * SCProposal Business Logic Basic Command implementation<br>
 *
 * @author
 * @see ESM_PRI_0003_01EventResponse,SCRoutePointProposalBC
 * @since J2EE 1.6
 */
public class SCRoutePointProposalBCImpl extends BasicCommandSupport implements SCRoutePointProposalBC {

	// Database Access Object
	private transient SCRoutePointProposalDBDAO dbDao = null;

	/**
	 * creating the object of SCRoutePointProposalBCImpl<br>
	 * cerating SCRoutePointProposalDBDAO<br>
	 */
	public SCRoutePointProposalBCImpl() {
		dbDao = new SCRoutePointProposalDBDAO();
	}
	/**
	 * Retrieving Org/Dst Location<br>
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
	 * Checking whether data by ROUTE TYPE exists or not<br>
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
	 * Cancelling acceptance ofOrg/Dst Location<br>
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
	 * Cancelling all acceptance of Org/Dst Location information<br>
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
	 * Accepting Org/Dst Location information<br>
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
	 * Deleting all datas with related Amend seq no when Cancelling init status of Main<br>
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
	 * Saving Org/Dst Location information<br>
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
	 * Accepting all of Org/Dst Location information<br>
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
	 * handling Amend Request<br>
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
     * copying Proposal Scope Route Point information<br>
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
	 * Modifying accepted data of main duration to "Init" at once when cancelling request<br>
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalRequestCancel(PriSpScpMnVO priSpScpMnVO,SignOnUserAccount account) throws EventException{
		try {
			if (priSpScpMnVO != null  ) {
				priSpScpMnVO.setUpdUsrId(account.getUsr_id());	
				dbDao.modifyProposalRequestCancel(priSpScpMnVO);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}	
	
	
	/**
	 * Retrieving Org/Dst Location information<br>
	 * 
	 * @param PriSpScpRoutPntVO priSpScpRoutPntVO
	 * @return List<RsltRoutPntLocListVO>
	 * @exception EventException
	 */
	public List<RsltRoutPntLocListVO> searchRoutePointLocationHistoryList(PriSpScpRoutPntVO priSpScpRoutPntVO) throws EventException {
		try {
			return dbDao.searchRoutePointLocationHistoryList(priSpScpRoutPntVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Checking whether data by ROUTE TYPE exists or not<br>
	 * 
	 * @param PriSpScpRoutPntVO priSpScpRoutPntVO  
	 * @return List<RsltRoutPntLocListVO>
	 * @exception EventException
	 */
	public List<RsltRoutPntLocListVO> searchRoutePointLocationHistoryType(PriSpScpRoutPntVO priSpScpRoutPntVO) throws EventException {
		try {
			return dbDao.searchRoutePointLocationHistoryType(priSpScpRoutPntVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving Org/Dst Location information<br>
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
	 *  Checking whether data by ROUTE TYPE exists or not<br>
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

}