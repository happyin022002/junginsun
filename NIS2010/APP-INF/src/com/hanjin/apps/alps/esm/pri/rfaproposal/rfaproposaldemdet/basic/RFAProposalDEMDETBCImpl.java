/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RfaProposalDEMDETBCImpl.java
*@FileTitle : RFA Proposal Creation [Amend] (DEM&DET)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.18
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.08.18 김재연
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposaldemdet.basic;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposaldemdet.integration.RFAProposalDEMDETDBDAO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposaldemdet.vo.RsltDmdtExptHisListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposaldemdet.vo.RsltDmdtExptListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RfaPropMnVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltRfaPropCopyVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltRoutHdrSmryListVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaquotationmain.vo.RsltCopyToProposalVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriRpDmdtVO;
import com.hanjin.syscommon.common.table.PriRpMnVO;

/**
 * ALPS-RFAProposal Business Logic Basic Command implementation<br>
 * - ALPS-RFAProposal에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author JaeYeon Kim
 * @see ESM_PRI_2058EventResponse,RfaProposalDEMDETBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class RFAProposalDEMDETBCImpl extends BasicCommandSupport implements RFAProposalDEMDETBC {

	// Database Access Object
	private transient RFAProposalDEMDETDBDAO dbDao = null;

	/**
	 * RfaProposalDEMDETBCImpl 객체 생성<br>
	 * RfaProposalDEMDETDBDAO를 생성한다.<br>
	 */
	public RFAProposalDEMDETBCImpl() {
		dbDao = new RFAProposalDEMDETDBDAO();
	}
	/**
	 * DEM&DET 조회를 실행한다.<br>
	 * 
	 * @param PriRpDmdtVO priRpDmdtVO
	 * @return List<RsltDmdtExptListVO>
	 * @exception EventException
	 */
	public List<RsltDmdtExptListVO> searchDEMDETExceptionList(PriRpDmdtVO priRpDmdtVO) throws EventException {
		try {
			return dbDao.searchDEMDETExceptionList(priRpDmdtVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}
	
	/**
	 * DEM&DET 수정을 실행한다.<br>
	 * 
	 * @param PriRpDmdtVO[] priRpDmdtVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageDEMDETException(PriRpDmdtVO[] priRpDmdtVOs, SignOnUserAccount account) throws EventException{
		try {
			List<PriRpDmdtVO> insertVoList = new ArrayList<PriRpDmdtVO>();
			List<PriRpDmdtVO> updateVoList = new ArrayList<PriRpDmdtVO>();
			List<PriRpDmdtVO> deleteVoList = new ArrayList<PriRpDmdtVO>();
			for ( int i=0; i<priRpDmdtVOs .length; i++ ) {
				if ( priRpDmdtVOs[i].getIbflag().equals("I")){
					priRpDmdtVOs[i].setCreUsrId(account.getUsr_id());
					priRpDmdtVOs[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(priRpDmdtVOs[i]);
				} else if ( priRpDmdtVOs[i].getIbflag().equals("U")){
					priRpDmdtVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(priRpDmdtVOs[i]);
				} else if ( priRpDmdtVOs[i].getIbflag().equals("D")){
					priRpDmdtVOs[i].setUpdUsrId(account.getUsr_id());
					deleteVoList.add(priRpDmdtVOs[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addDEMDETExceptionList(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyDEMDETExceptionList(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeDEMDETExceptionList(deleteVoList);
			}
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
	}
	
	/**
	 * DEM&DET Accept를 실행한다<br>
	 * 
	 * @param PriRpDmdtVO[] priRpDmdtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptDEMDETException(PriRpDmdtVO[] priRpDmdtVO, SignOnUserAccount account) throws EventException {
		try {
			List<PriRpDmdtVO> updateVoList = new ArrayList<PriRpDmdtVO>();
			
			for(int i=0; priRpDmdtVO != null && i < priRpDmdtVO.length; i++) {
				if(priRpDmdtVO[i].getIbflag().equals("U")) {
					priRpDmdtVO[i].setUpdUsrId(account.getUsr_id());
					priRpDmdtVO[i].setAcptUsrId(account.getUsr_id());
					priRpDmdtVO[i].setAcptOfcCd(account.getOfc_cd());			
					String currentDate = new SimpleDateFormat("yyyyMMdd").format(new Date());			
					priRpDmdtVO[i].setAcptDt(currentDate);
					updateVoList.add(priRpDmdtVO[i]);
				}
			}

			if(updateVoList.size() > 0)	{
				dbDao.modifyDEMDETExceptionList(updateVoList);
			}
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
	}
	
	/**
	 * DEM&DET Accept cancel을 실행한다<br>
	 * 
	 * @param PriRpDmdtVO[] priRpDmdtVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelDEMDETException(PriRpDmdtVO[] priRpDmdtVOs, SignOnUserAccount account) throws EventException {
		try {
		
			List<PriRpDmdtVO> updateVoList = new ArrayList<PriRpDmdtVO>();
			
			for(int i=0; priRpDmdtVOs != null && i < priRpDmdtVOs.length; i++) {
				if(priRpDmdtVOs[i].getIbflag().equals("U")) {
					priRpDmdtVOs[i].setUpdUsrId(account.getUsr_id());
					priRpDmdtVOs[i].setAcptUsrId("");
					priRpDmdtVOs[i].setAcptOfcCd("");			
					priRpDmdtVOs[i].setAcptDt(null);
					updateVoList.add(priRpDmdtVOs[i]);
				}
			}
			
			if(updateVoList.size() > 0)	{
				dbDao.modifyDEMDETExceptionList(updateVoList);
			}
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
	}

	
	/**
	 * DEM&DET 을 추가/수정한다.<br>
	 * 
	 * @param RfaPropMnVO rfaPropMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposal(RfaPropMnVO rfaPropMnVO, SignOnUserAccount account) throws EventException{
		try {
			
			PriRpDmdtVO[] dmdtVo = rfaPropMnVO.getPriRpDmdtVOs();
			PriRpMnVO[] mnVo = rfaPropMnVO.getPriRpMnVOs();
			
			List<PriRpDmdtVO> insertVoList = new ArrayList<PriRpDmdtVO>();
			List<PriRpDmdtVO> updateVoList = new ArrayList<PriRpDmdtVO>();
			
			String propNo = dbDao.searchCreationProposalNo(mnVo[0].getPropOfcCd());
			for ( int i = 0; dmdtVo != null && i < dmdtVo.length; i++ ) {
				if ( dmdtVo[i].getIbflag().equals("I")){
					dmdtVo[i].setPropNo(propNo);
					dmdtVo[i].setAmdtSeq("0");
					dmdtVo[i].setCreUsrId(account.getUsr_id());
					dmdtVo[i].setUpdUsrId(account.getUsr_id());	
					
					dmdtVo[i].setPrcProgStsCd("I");
					dmdtVo[i].setSrcInfoCd("NW");
					dmdtVo[i].setN1stCmncAmdtSeq("0");
					insertVoList.add(dmdtVo[i]);
				} else if ( dmdtVo[i].getIbflag().equals("U")){
					dmdtVo[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(dmdtVo[i]);
				} 
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addDEMDETExceptionList (insertVoList);
			}
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyProposalDEMDETException (updateVoList);
			}
		
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
	}	
	
	/**
	 * Request Cancel시 Accepted 데이터 일괄 Init 으로 변경<br>
	 * 해당 회차의 모든데이터가 대상이다.<br>
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
	 * Main의 Init 상태를 Cancel시 해당 Amend Seq NO.의 모든 데이터를 삭제합니다.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO 
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeProposal(PriRpMnVO priRpMnVO, SignOnUserAccount account) throws EventException{
		try {
			if (priRpMnVO != null){
				dbDao.removeProposalDmdt(priRpMnVO);
			}
			
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
	}	
	
	/**
	 * Main Request 할때 자동으로 Accept를 합니다.<br>
	 * 
	 * @param PriRpDmdtVO priRpDmdtVO 
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptProposalDEMDETException(PriRpDmdtVO priRpDmdtVO, SignOnUserAccount account) throws EventException{
		try {
			if (priRpDmdtVO != null  ) {
				priRpDmdtVO.setUpdUsrId(account.getUsr_id());	
				priRpDmdtVO.setAcptUsrId(account.getUsr_id());
				priRpDmdtVO.setAcptOfcCd(account.getOfc_cd());

			}			
			dbDao.modifyProposalAutoAccept(priRpDmdtVO);			
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
// pri_sp_afil 생성
			dbDao.addProposalDmdtAmend (insertVoList);
				
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
	}		
	
	   /**
     * Basic Data Amend Request를 처리합니다.<br>
     * 
     * @param PriRpMnVO priRpMnVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void amendProposalBasic(PriRpMnVO priRpMnVO, RsltRoutHdrSmryListVO amdBasicVo, SignOnUserAccount account) throws EventException{
        try {
 
            List<RsltRoutHdrSmryListVO> copyMasterVoList = new ArrayList<RsltRoutHdrSmryListVO>();
            
            amdBasicVo.setCreUsrId(account.getUsr_id());
            amdBasicVo.setUpdUsrId(account.getUsr_id());                 
            copyMasterVoList.add(amdBasicVo);
 
            dbDao.addProposalDmdtAmendBasic (copyMasterVoList);
                
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }   
    
	
	/**
	 * DEM&DET Amendment History 조회를 실행한다.<br>
	 * 
	 * @param PriRpDmdtVO priRpScpDmdtVO
	 * @return List<RsltDmdtExptHisListVO>
	 * @exception EventException
	 */
	public List<RsltDmdtExptHisListVO> searchDEMDETExceptionHistoryList(PriRpDmdtVO priRpScpDmdtVO) throws EventException {
		try {
			return dbDao.searchDEMDETExceptionHistoryList(priRpScpDmdtVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}	

    /**
     * RFA Proposal DEM/DET 정보를 Copy 합니다.<br>
     * 
     * @param RsltRfaPropCopyVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalDemDet(RsltRfaPropCopyVO vo, SignOnUserAccount account) throws EventException{
        try {
            vo.setCreUsrId(account.getUsr_id());
            vo.setUpdUsrId(account.getUsr_id());
            vo.setOfcCd(account.getOfc_cd());
            // PRI_RP_DMDT COPY
            dbDao.addCopyProposalDemDet(vo);
        } catch (DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
        } catch (Exception de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
        }
    }
    
    
    /**
     * PRS 정보를 Copy 하여 RFA Proposal DEM/DET 정보를 생성합니다.<br>
     * 
     * @param RsltCopyToProposalVO vo 
     * @param SignOnUserAccount account
     * @throws DAOException
     */
    public void copyToProposalRqDmdt(RsltCopyToProposalVO vo, SignOnUserAccount account) throws EventException{
       try {
    	    vo.setCreUsrId(account.getUsr_id());
    	    vo.setUpdUsrId(account.getUsr_id());
			//office
    	    vo.setQttnOfcCd(account.getOfc_cd());
			
    	    int chk = 0;
    	    
			//PRI_RP_DMDT
			chk = dbDao.addCopyRfaQuotationPriRqCpPriRpDmdt(vo);
			if (chk < 1) {
				throw new EventException(new ErrorHandler("PRI03016").getMessage());
			}
       } catch(EventException ex) {
			throw ex;		
       } catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
       } catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
       }
    }
    
}