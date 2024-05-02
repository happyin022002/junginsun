/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCDurationProposalBCImpl.java
*@FileTitle : Duration
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaproposal.rfadurationproposal.basic;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfadurationproposal.integration.RFADurationProposalDBDAO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfadurationproposal.vo.CstAuthorityVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfadurationproposal.vo.CstPriRpDurVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfadurationproposal.vo.CstPriRpScpDurCntVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfadurationproposal.vo.CstPriRpScpDurVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfadurationproposal.vo.GrpDurVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfadurationproposal.vo.RsltPriRpDurHisVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfadurationproposal.vo.RsltPriRpDurVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RfaPropMnVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RsltRfaPropCopyVO;
//import com.clt.apps.opus.esm.pri.rfaquotation.rfaquotationmain.vo.RsltCopyToProposalVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.object.ObjectCloner;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriRpDurVO;
import com.clt.syscommon.common.table.PriRpMnVO;
import com.clt.syscommon.common.table.PriRpScpDurVO;
import com.clt.syscommon.common.table.PriRpScpMnVO;

/**
 * SCProposal Business Logic Basic Command implementation<br>
 * - Handling a biz logic about SCProposal<br>
 *
 * @author 
 * @see ESM_PRI_0020EventResponse,SCDurationProposalBC - Refer to each DAO class
 * @since J2EE 1.4
 */
public class RFADurationProposalBCImpl extends BasicCommandSupport implements RFADurationProposalBC {

	// Database Access Object
	private transient RFADurationProposalDBDAO dbDao = null;

	/**
	 * Creating SCDurationProposalBCImpl object<br>
	 * Creating SCDurationProposalDBDAO<br>
	 */
	public RFADurationProposalBCImpl() {
		dbDao = new RFADurationProposalDBDAO();
	}

	/**
	 * Modifying RFA Duration information.
	 * 
	 * @param RfaPropMnVO rfaPropMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposal(RfaPropMnVO rfaPropMnVO, SignOnUserAccount account) throws EventException{
		try {
			
			PriRpDurVO[] durVo = rfaPropMnVO.getPriRpDurVOs();
			PriRpScpDurVO[] scpDurVo = rfaPropMnVO.getPriRpScpDurVOs();
			PriRpMnVO[] mnVo = rfaPropMnVO.getPriRpMnVOs();
			List<PriRpDurVO> insertDurVoList = new ArrayList<PriRpDurVO>();
			List<PriRpScpDurVO> insertScpDurVoList = new ArrayList<PriRpScpDurVO>();
		
			List<PriRpScpDurVO> updateDurVoList = new ArrayList<PriRpScpDurVO>();
			
			List<PriRpScpDurVO> updateScpDurVoList = new ArrayList<PriRpScpDurVO>();
		
			List<PriRpScpDurVO> deleteScpDurVoList = new ArrayList<PriRpScpDurVO>();
			
			String propNo = dbDao.searchCreationProposalNo(mnVo[0].getPropOfcCd());
			for ( int i = 0; durVo != null && i < durVo.length; i++ ) {
				if ( durVo[i].getIbflag().equals("I")){
					durVo[i].setPropNo(propNo);
					durVo[i].setCreUsrId(account.getUsr_id());
					durVo[i].setUpdUsrId(account.getUsr_id());					
					insertDurVoList.add(durVo[i]);
				} else if ( durVo[i].getIbflag().equals("U")){
					durVo[i].setUpdUsrId(account.getUsr_id());
					PriRpScpDurVO vo = new PriRpScpDurVO();
					vo.setCtrtEffDt(durVo[i].getCtrtEffDt());
					vo.setCtrtExpDt(durVo[i].getCtrtExpDt());
					vo.setAmdtSeq(durVo[i].getAmdtSeq());
					vo.setPropNo(durVo[i].getPropNo());
					vo.setUpdUsrId(durVo[i].getUpdUsrId());
					updateDurVoList.add(vo);
				} 
			}
			
			for ( int i = 0; scpDurVo != null && i < scpDurVo.length; i++ ) {
				if ( scpDurVo[i].getIbflag().equals("I")){
					if(scpDurVo[i].getPropNo().equals("")){
						scpDurVo[i].setPropNo(propNo);
						scpDurVo[i].setAmdtSeq("0");
					}					
					scpDurVo[i].setCreUsrId(account.getUsr_id());
					scpDurVo[i].setUpdUsrId(account.getUsr_id());					
					insertScpDurVoList.add(scpDurVo[i]);
				} else if ( scpDurVo[i].getIbflag().equals("U")){
					scpDurVo[i].setUpdUsrId(account.getUsr_id());
					updateScpDurVoList.add(scpDurVo[i]);
				} else if ( scpDurVo[i].getIbflag().equals("D")){
					deleteScpDurVoList.add(scpDurVo[i]);					
				} 
			}	
			
			if ( insertDurVoList.size() > 0 ) {
				dbDao.addProposalDuration (insertDurVoList);
			}
			if ( updateDurVoList.size() > 0 ) {
				dbDao.modifyProposalDuration (updateDurVoList);
			}
			if ( insertScpDurVoList.size() > 0 ) {
				dbDao.addProposalScopeDuration (insertScpDurVoList);
			}
			if ( updateScpDurVoList.size() > 0 ) {
				dbDao.modifyProposalScopeDuration (updateScpDurVoList);
			}
//			if ( deleteScpDurVoList.size() > 0 ) {
//				dbDao.removeProposalScopeDuration (deleteScpDurVoList);
//			}			
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
	}	
	
	
	/**
	 * Deleting RFA Scope Duration information
	 * 
	 * @param RfaPropMnVO rfaPropMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalScopeDurationRemove(RfaPropMnVO rfaPropMnVO, SignOnUserAccount account) throws EventException{
		try {		
			PriRpScpDurVO[] scpDurVo = rfaPropMnVO.getPriRpScpDurVOs();	
			List<PriRpScpDurVO> deleteScpDurVoList = new ArrayList<PriRpScpDurVO>();			
			for ( int i = 0; scpDurVo != null && i < scpDurVo.length; i++ ) {
				if ( scpDurVo[i].getIbflag().equals("D")){
					deleteScpDurVoList.add(scpDurVo[i]);					
				} 
			}	
			if ( deleteScpDurVoList.size() > 0 ) {
				dbDao.removeProposalScopeDuration (deleteScpDurVoList);
			}			
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
	}		
	
	
	
	/**
	 * Changing Accepted data of Main duration to "init" status when cancelling request<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalRequestCancel(PriRpMnVO priRpMnVO,SignOnUserAccount account) throws EventException{
		try {
			if (priRpMnVO != null  ) {
				priRpMnVO.setUpdUsrId(account.getUsr_id());	
				dbDao.modifyProposalRequestCancel(priRpMnVO);
			}
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
	}		
	
	/**
	 * Changing Accepted data of Scope Duration to "init" status when cancelling request<br>
	 * 
	 * @param PriRpScpMnVO[] priRpScpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalRequestCancelScope(PriRpScpMnVO[] priRpScpMnVO,SignOnUserAccount account) throws EventException{
		try {
			List<PriRpScpMnVO> updateVoList = new ArrayList<PriRpScpMnVO>();
			
			for ( int i = 0; priRpScpMnVO != null && i < priRpScpMnVO.length; i++ ) {
				priRpScpMnVO[i].setUpdUsrId(account.getUsr_id());
				updateVoList.add(priRpScpMnVO[i]);
			}
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyProposalRequestCancelScope(updateVoList);
			}
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
	}		
	
	/**
	 * Deleting data of Main duration when cancelling "Init" status.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeProposal(PriRpMnVO priRpMnVO, SignOnUserAccount account) throws EventException{
		try {
			if (priRpMnVO != null){
				dbDao.removeProposal(priRpMnVO);
			}
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
	}	
	
	/**
	 * Deleting Scope duration's datas when cancelling "Init"<br>
	 * 
	 * @param PriRpScpMnVO priRpScpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeProposalScope(PriRpScpMnVO priRpScpMnVO, SignOnUserAccount account) throws EventException{
		try {
			if (priRpScpMnVO != null){
				dbDao.removeProposalScope(priRpScpMnVO);
			}
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
	}	
	
	/**
	 * Modifying request status of Main,Scope Duration to "Accept"<br>
	 * 
	 * @param PriRpScpDurVO priRpScpDurVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptProposalDuration(PriRpScpDurVO priRpScpDurVO, SignOnUserAccount account) throws EventException{
		try {
		
			List<PriRpScpDurVO> updateVoList = new ArrayList<PriRpScpDurVO>();
			
			priRpScpDurVO.setUpdUsrId(account.getUsr_id());	
			priRpScpDurVO.setAcptUsrId(account.getUsr_id());
			priRpScpDurVO.setAcptOfcCd(account.getOfc_cd());			
			String currentDate = new SimpleDateFormat("yyyyMMdd").format(new Date());			
			priRpScpDurVO.setAcptDt(currentDate);
			String svcScpCd = priRpScpDurVO.getSvcScpCd();

			updateVoList.add(priRpScpDurVO);

			if (svcScpCd.equals("")){
				dbDao.modifyProposalDuration (updateVoList);
			}else{
				dbDao.modifyProposalScopeDuration (updateVoList);
			}			
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
	}		
	
    /**
     *  Retrieving Main,Scope Duration data.<br>
     * 
     * @param CstAuthorityVO cstAuthorityVO
     * @return GrpDurVO
     * @exception EventException
     */
	public GrpDurVO searchProposalDurationList(CstAuthorityVO cstAuthorityVO) throws EventException {
		try {
			List<RsltPriRpDurVO> rsltPriRpDurVO =  new ArrayList<RsltPriRpDurVO>();			
			GrpDurVO grpDurVO = new GrpDurVO();			
			
			if (cstAuthorityVO.getSvcScpCd().equals("")){
				rsltPriRpDurVO = dbDao.searchProposalDurationList(cstAuthorityVO);
			}else{
				rsltPriRpDurVO = dbDao.searchProposalScopeDurationList(cstAuthorityVO);
			}
			
			grpDurVO.setRsltPriRpDurVOS(rsltPriRpDurVO);
			
			return grpDurVO;
			
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}		
	
	/**
     * Adding/Modifying/Deleting Duration <br>
     * @param CstPriRpScpDurVO[] cstPriRpScpDurVO
	 * @param SignOnUserAccount account
     * @exception EventException
     */
	public void manageProposalDuration(CstPriRpScpDurVO[] cstPriRpScpDurVO, SignOnUserAccount account) throws EventException{
		try {
			String svcScpCd = cstPriRpScpDurVO[0].getSvcScpCd();
			String scpSave = cstPriRpScpDurVO[0].getScpSave();;
			List<PriRpScpDurVO> insertVoList = new ArrayList<PriRpScpDurVO>();
			List<PriRpScpDurVO> updateVoList = new ArrayList<PriRpScpDurVO>();
			List<PriRpScpDurVO> deleteVoList = new ArrayList<PriRpScpDurVO>();
	
			
			for ( int i=0; i<cstPriRpScpDurVO.length; i++ ) {
				if ( cstPriRpScpDurVO[i].getIbflag().equals("I")){
					cstPriRpScpDurVO[i].setUpdUsrId(account.getUsr_id());					
					cstPriRpScpDurVO[i].setCreUsrId(account.getUsr_id());
					PriRpScpDurVO priRpScpDurVO = new PriRpScpDurVO();					
					ObjectCloner.build(cstPriRpScpDurVO[i], priRpScpDurVO );					
					insertVoList.add(priRpScpDurVO);
				} else if ( cstPriRpScpDurVO[i].getIbflag().equals("U")){
					cstPriRpScpDurVO[i].setUpdUsrId(account.getUsr_id());
					PriRpScpDurVO priRpScpDurVO = new PriRpScpDurVO();
					ObjectCloner.build(cstPriRpScpDurVO[i], priRpScpDurVO );
					updateVoList.add(priRpScpDurVO);
				} else if ( cstPriRpScpDurVO[i].getIbflag().equals("D")){
					PriRpScpDurVO priRpScpDurVO = new PriRpScpDurVO();
					ObjectCloner.build(cstPriRpScpDurVO[i], priRpScpDurVO );
					deleteVoList.add(priRpScpDurVO);
				}
				
			}
			if ( insertVoList.size() > 0 ) {
				dbDao.addProposalScopeDuration (insertVoList);
			}
			if ( updateVoList.size() > 0 ) {
				if (svcScpCd.equals("")){
					if (scpSave.equals("true")){
						dbDao.modifyProposalScopeDurationChange (updateVoList);
					}
					dbDao.modifyProposalDuration (updateVoList);
				}else{
					dbDao.modifyProposalScopeDuration (updateVoList);
				}	
			}
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeProposalScopeDuration (deleteVoList);
			}

        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
	}	
	
	/**
	 * Cancelling Accepted Main,Scope Duration<br>
	 * 
	 * @param PriRpScpDurVO priRpScpDurVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelProposalDuration(PriRpScpDurVO priRpScpDurVO, SignOnUserAccount account) throws EventException{
		try {		
			List<PriRpScpDurVO> updateVoList = new ArrayList<PriRpScpDurVO>();			
			priRpScpDurVO.setUpdUsrId(account.getUsr_id());	
			//cancel 
			priRpScpDurVO.setAcptUsrId("C");
			priRpScpDurVO.setAcptOfcCd("C");		
			priRpScpDurVO.setAcptDt("C");
			String svcScpCd = priRpScpDurVO.getSvcScpCd();
			updateVoList.add(priRpScpDurVO);
			if (svcScpCd.equals("")){
				dbDao.modifyProposalDuration (updateVoList);
			}else{
				dbDao.modifyProposalScopeDuration (updateVoList);
			}			
				
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
	}	
	
	/**
     * Retrieving scope duration when saving Main duration<br>
	 * 
	 * @param PriRpScpDurVO priRpScpDurVO
	 * @return List<CstPriRpDurVO>
	 * @exception EventException
	 */
	public List<CstPriRpDurVO> searchProposalScopeCheckList(PriRpScpDurVO priRpScpDurVO) throws EventException {
		try {
			return dbDao.searchProposalScopeCheckList(priRpScpDurVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}   	
	
	/**
     * Retrieving whether amended data of scope duration exists or not when amending Main Duration<br>
	 * 
	 * @param PriRpScpDurVO priRpScpDurVO
	 * @return List<PriRpScpDurVO>
	 * @exception EventException
	 */
	public List<PriRpScpDurVO> searchProposalDurationAmendCheckList(PriRpScpDurVO priRpScpDurVO) throws EventException {
		try {
			return dbDao.searchProposalDurationAmendCheckList(priRpScpDurVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	} 	
	
	/**
     * Checking Main's duration is under scope duration when saving main duration<br>
	 * 
	 * @param PriRpScpDurVO priRpScpDurVO
	 * @return List<CstPriRpScpDurCntVO>
	 * @exception EventException
	 */
	public List<CstPriRpScpDurCntVO> searchProposalDurationScopeCount(PriRpScpDurVO priRpScpDurVO) throws EventException {
		try {
			return dbDao.searchProposalDurationScopeCount(priRpScpDurVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}   	
	
	/**
	 * Amending Main,Scope Duration<br>
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
	
			dbDao.addProposalDurationAmend (insertVoList);
			dbDao.addProposalScopeDurationAmend (insertVoList);
			if (!priRpMnVO.getExpDt().equals("")){
				log.debug("amendProposal==exp_dt==dur"+priRpMnVO.getExpDt());
				dbDao.modifyProposalScopeDurationAmd(insertVoList);	
				log.debug("exp_dt==============duration="+priRpMnVO.getExpDt());
			}
			
				//modifyProposalScopeDurationAmd
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
	}	
	
	/**
	 * Retrieving scope with same or previous expire data of main duration with expire date of scope when modifying main duration
	 * 
	 * @param CstPriRpScpDurVO cstPriRpScpDurVO
	 * @return List<PriRpScpDurVO>
	 * @exception DAOException
	 */
	public List<PriRpScpDurVO> searchProposalScope(CstPriRpScpDurVO cstPriRpScpDurVO) throws EventException {
		try {
			return dbDao.searchProposalScope(cstPriRpScpDurVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}   
	
	/**
	 * Retrieving Duration Amend History <br>
	 * 
	 * @param PriRpScpDurVO priRpScpDurVO
	 * @return List<RsltPriRpDurHisVO>
	 * @exception EventException
	 */
	public List<RsltPriRpDurHisVO> searchProposalDurationHistoryList(PriRpScpDurVO priRpScpDurVO) throws EventException {
		try {

			if (priRpScpDurVO.getSvcScpCd().equals("")){
				return  dbDao.searchProposalDurationMainHistoryList(priRpScpDurVO);
			}else{
				return dbDao.searchProposalDurationScopeHistoryList(priRpScpDurVO);
			}
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}

    /**
     * Copying RFA Proposal Main Duration<br>
     * 
     * @param RsltRfaPropCopyVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalDuration(RsltRfaPropCopyVO vo, SignOnUserAccount account) throws EventException{
        try {
            vo.setCreUsrId(account.getUsr_id());
            vo.setUpdUsrId(account.getUsr_id());
            vo.setOfcCd(account.getOfc_cd());
            // PRI_RP_DUR COPY
            dbDao.addCopyProposalDuration(vo);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }

    /**
     * Copying RFA Proposal Scope Duration <br>
     * 
     * @param RsltRfaPropCopyVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalScopeDuration(RsltRfaPropCopyVO vo, SignOnUserAccount account) throws EventException{
        try {
            vo.setCreUsrId(account.getUsr_id());
            vo.setUpdUsrId(account.getUsr_id());
            vo.setOfcCd(account.getOfc_cd());
            // PRI_RP_SCP_DUR COPY
            dbDao.addCopyProposalScopeDuration(vo);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }
    
	/**
	 * Retrieving scope with same expire data with main's when accepting Main Duration<br>
	 * 
	 * @param PriRpDurVO priRpDurVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchProposalDurationAcceptCount(PriRpDurVO priRpDurVO) throws EventException {
		try {
			log.debug("searchProposalDurationAcceptCount=======================bc ");
			return dbDao.searchProposalDurationAcceptCount(priRpDurVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}	 
	
	/**
	 * Chaning requested data of scope to "Accept" when accepting Main<br>
	 * 
	 * @param PriRpScpDurVO priRpScpDurVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptAutoProposalScopeDuration(PriRpScpDurVO priRpScpDurVO,SignOnUserAccount account) throws EventException{
		try {
		
			priRpScpDurVO.setAcptUsrId(account.getUsr_id());
			priRpScpDurVO.setUpdUsrId(account.getUsr_id());
			priRpScpDurVO.setAcptOfcCd(account.getOfc_cd());

            dbDao.modifyAcceptAutoProposalScopeDuration(priRpScpDurVO);	
				
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
	}	
	
	/**
	 * Retrieving scope with same Expire date with main when accepting Main duration<br>
	 * 
	 * @param PriRpScpDurVO priRpScpDurVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchProposalDurationAcceptList(PriRpScpDurVO priRpScpDurVO) throws EventException {
		try {
			log.debug("searchProposalDurationAcceptList=======================bc ");
			return dbDao.searchProposalDurationAcceptList(priRpScpDurVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}	    
}