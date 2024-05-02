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
package com.clt.apps.opus.esm.pri.scproposal.scdurationproposal.basic;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.clt.apps.opus.esm.pri.scproposal.scdurationproposal.integration.SCDurationProposalDBDAO;
import com.clt.apps.opus.esm.pri.scproposal.scdurationproposal.vo.CstAcceptDurVO;
import com.clt.apps.opus.esm.pri.scproposal.scdurationproposal.vo.CstAuthorityVO;
import com.clt.apps.opus.esm.pri.scproposal.scdurationproposal.vo.CstPriSpDurVO;
import com.clt.apps.opus.esm.pri.scproposal.scdurationproposal.vo.CstPriSpScpDurCntVO;
import com.clt.apps.opus.esm.pri.scproposal.scdurationproposal.vo.CstPriSpScpDurVO;
import com.clt.apps.opus.esm.pri.scproposal.scdurationproposal.vo.GrpDurVO;
import com.clt.apps.opus.esm.pri.scproposal.scdurationproposal.vo.RsltPriSpDurHisVO;
import com.clt.apps.opus.esm.pri.scproposal.scdurationproposal.vo.RsltPriSpDurVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.RsltPropCopyVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.ScPropMnVO;
//import com.clt.apps.opus.esm.pri.scquotation.scquotationmain.vo.RsltCopyToProposalVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.object.ObjectCloner;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriSpDurVO;
import com.clt.syscommon.common.table.PriSpMnVO;
import com.clt.syscommon.common.table.PriSpScpDurVO;
import com.clt.syscommon.common.table.PriSpScpMnVO;

/**
 * SCProposal Business Logic Basic Command implementation<br>
 * - Handling a biz logic about SCProposal<br>
 *
 * @author 
 * @see ESM_PRI_0020EventResponse,SCDurationProposalBC  - refer to each DAO class
 * @since J2EE 1.4
 */
public class SCDurationProposalBCImpl extends BasicCommandSupport implements SCDurationProposalBC {

	// Database Access Object
	private transient SCDurationProposalDBDAO dbDao = null;

	/**
	 * Creating SCDurationProposalBCImpl object<br>
	 * Creating SCDurationProposalDBDAO<br>
	 */
	public SCDurationProposalBCImpl() {
		dbDao = new SCDurationProposalDBDAO();
	}

	
	/**
	 *  Adding/modifying/deletingSC Duration information.<br>
	 * 
	 * @param ScPropMnVO scPropMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposal(ScPropMnVO scPropMnVO, SignOnUserAccount account) throws EventException{
		try {
			
			PriSpDurVO[] durVo = scPropMnVO.getPriSpDurVOs();
			PriSpScpDurVO[] scpDurVo = scPropMnVO.getPriSpScpDurVOs();
			PriSpMnVO[] mnVo = scPropMnVO.getPriSpMnVOs();
			List<PriSpDurVO> insertDurVoList = new ArrayList<PriSpDurVO>();
			List<PriSpScpDurVO> insertScpDurVoList = new ArrayList<PriSpScpDurVO>();
		
//			List<PriSpDurVO> updateDurVoList = new ArrayList<PriSpDurVO>();
			List<PriSpScpDurVO> updateDurVoList = new ArrayList<PriSpScpDurVO>();
			
			List<PriSpScpDurVO> updateScpDurVoList = new ArrayList<PriSpScpDurVO>();
		
//			List<PriSpScpDurVO> deleteScpDurVoList = new ArrayList<PriSpScpDurVO>();
			
			String propNo = dbDao.searchCreationProposalNo(mnVo[0].getPropOfcCd());
//			String propNo = scPropMnVO.getPropNo();
			for ( int i = 0; durVo != null && i < durVo.length; i++ ) {
				if ( durVo[i].getIbflag().equals("I")){
					durVo[i].setPropNo(propNo);
					durVo[i].setCreUsrId(account.getUsr_id());
					durVo[i].setUpdUsrId(account.getUsr_id());					
					insertDurVoList.add(durVo[i]);
				} else if ( durVo[i].getIbflag().equals("U")){
					durVo[i].setUpdUsrId(account.getUsr_id());
					PriSpScpDurVO vo = new PriSpScpDurVO();
					vo.setCtrtEffDt(durVo[i].getCtrtEffDt());
					vo.setCtrtExpDt(durVo[i].getCtrtExpDt());
					vo.setAmdtSeq(durVo[i].getAmdtSeq());
					vo.setPropNo(durVo[i].getPropNo());
//					vo.setN1stCmncDt(durVo[i].getN1stCmncDt());
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
//				} else if ( scpDurVo[i].getIbflag().equals("D")){
//					deleteScpDurVoList.add(scpDurVo[i]);					
				} 
			}	
//			if ( deleteScpDurVoList.size() > 0 ) {
//				dbDao.removeProposalScopeDuration (deleteScpDurVoList);
//			}
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
			
        } catch (DAOException ex) {
            //log.error("err " + ex.toString(), ex);
        	throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            //log.error("err " + ex.toString(), ex);
        	throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
	}
	
	/**
	 *  Deleting SC Duration information<br>
	 * 
	 * @param ScPropMnVO scPropMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalScopeDurationRemove(ScPropMnVO scPropMnVO, SignOnUserAccount account) throws EventException{
		try {
			PriSpScpDurVO[] scpDurVo = scPropMnVO.getPriSpScpDurVOs();		
			List<PriSpScpDurVO> deleteScpDurVoList = new ArrayList<PriSpScpDurVO>();
			
			for ( int i = 0; scpDurVo != null && i < scpDurVo.length; i++ ) {
				if ( scpDurVo[i].getIbflag().equals("D")){
					deleteScpDurVoList.add(scpDurVo[i]);					
				} 
			}	
			if ( deleteScpDurVoList.size() > 0 ) {
				dbDao.removeProposalScopeDuration (deleteScpDurVoList);
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
	 * Amending Main,Scope Duration.<br>
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
	
			dbDao.addProposalDurationAmend (insertVoList);
			dbDao.addProposalScopeDurationAmend (insertVoList);
				
        } catch (DAOException ex) {
            //log.error("err " + ex.toString(), ex);
        	throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            //log.error("err " + ex.toString(), ex);
        	throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
	}	
	
	

    /**
     *  Retrieving Main,Scope Duration data<br>
     * 
     * @param CstAuthorityVO cstAuthorityVO
     * @return GrpDurVO
     * @exception EventException
     */
	public GrpDurVO searchProposalDurationList(CstAuthorityVO cstAuthorityVO) throws EventException {
		try {
			List<RsltPriSpDurVO> rsltPriSpDurVO =  new ArrayList<RsltPriSpDurVO>();			
			GrpDurVO grpDurVO = new GrpDurVO();			
			
			if (cstAuthorityVO.getSvcScpCd().equals("")){
				rsltPriSpDurVO = dbDao.searchProposalDurationList(cstAuthorityVO);
			}else{
				rsltPriSpDurVO = dbDao.searchProposalScopeDurationList(cstAuthorityVO);
			}
			
			grpDurVO.setRsltPriSpDurVOS(rsltPriSpDurVO);
			
			return grpDurVO;
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}		
	
	/**
	 * Changing Main,Scope Duration's Request data to Accept<br>
	 * 
	 * @param PriSpScpDurVO priSpScpDurVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptProposalDuration(PriSpScpDurVO priSpScpDurVO, SignOnUserAccount account) throws EventException{
		try {
		
			List<PriSpScpDurVO> updateVoList = new ArrayList<PriSpScpDurVO>();
			
			priSpScpDurVO.setUpdUsrId(account.getUsr_id());	
			priSpScpDurVO.setAcptUsrId(account.getUsr_id());
			priSpScpDurVO.setAcptOfcCd(account.getOfc_cd());			
			String currentDate = new SimpleDateFormat("yyyyMMdd").format(new Date());			
			priSpScpDurVO.setAcptDt(currentDate);
			String svcScpCd = priSpScpDurVO.getSvcScpCd();

			updateVoList.add(priSpScpDurVO);

			if (svcScpCd.equals("")){
				dbDao.modifyProposalDuration (updateVoList);
			}else{
				dbDao.modifyProposalScopeDuration (updateVoList);
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
	 * Changing Scope's Request data to Accept  when accepting main.<br>
	 * 
	 * @param PriSpScpDurVO priSpScpDurVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void autoAcceptProposalScopeDuration(PriSpScpDurVO priSpScpDurVO, SignOnUserAccount account) throws EventException{
		try {		
			if (priSpScpDurVO != null){
				priSpScpDurVO.setUpdUsrId(account.getUsr_id());	
				priSpScpDurVO.setAcptUsrId(account.getUsr_id());
				priSpScpDurVO.setAcptOfcCd(account.getOfc_cd());			
				dbDao.modifyAutoAcceptProposalScopeDuration (priSpScpDurVO);
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
	 * Canceling an acceptance of Main,Scope Duration .<br>
	 * 
	 * @param PriSpScpDurVO priSpScpDurVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelProposalDuration(PriSpScpDurVO priSpScpDurVO, SignOnUserAccount account) throws EventException{
		try {
		
			List<PriSpScpDurVO> updateVoList = new ArrayList<PriSpScpDurVO>();
			
			priSpScpDurVO.setUpdUsrId(account.getUsr_id());	
			//cancel 
			priSpScpDurVO.setAcptUsrId("C");
			priSpScpDurVO.setAcptOfcCd("C");		
			priSpScpDurVO.setAcptDt("C");
			String svcScpCd = priSpScpDurVO.getSvcScpCd();

			updateVoList.add(priSpScpDurVO);

			if (svcScpCd.equals("")){
				dbDao.modifyProposalDuration (updateVoList);
			}else{
				dbDao.modifyProposalScopeDuration (updateVoList);
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
     * Managing Duration <br>
	 * 
	 * @param CstPriSpScpDurVO[] cstPriSpScpDurVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */

	public void manageProposalDuration(CstPriSpScpDurVO[] cstPriSpScpDurVO, SignOnUserAccount account) throws EventException{
		try {
			String svcScpCd = cstPriSpScpDurVO[0].getSvcScpCd();
			String scpSave = cstPriSpScpDurVO[0].getScpSave();;
			List<PriSpScpDurVO> insertVoList = new ArrayList<PriSpScpDurVO>();
			List<PriSpScpDurVO> updateVoList = new ArrayList<PriSpScpDurVO>();
			List<PriSpScpDurVO> deleteVoList = new ArrayList<PriSpScpDurVO>();
	
			
			for ( int i=0; i<cstPriSpScpDurVO.length; i++ ) {
				if ( cstPriSpScpDurVO[i].getIbflag().equals("I")){
					cstPriSpScpDurVO[i].setUpdUsrId(account.getUsr_id());					
					cstPriSpScpDurVO[i].setCreUsrId(account.getUsr_id());
					PriSpScpDurVO priSpScpDurVO = new PriSpScpDurVO();					
					ObjectCloner.build(cstPriSpScpDurVO[i], priSpScpDurVO );					
					insertVoList.add(priSpScpDurVO);
				} else if ( cstPriSpScpDurVO[i].getIbflag().equals("U")){
					cstPriSpScpDurVO[i].setUpdUsrId(account.getUsr_id());
					PriSpScpDurVO priSpScpDurVO = new PriSpScpDurVO();
					ObjectCloner.build(cstPriSpScpDurVO[i], priSpScpDurVO );

					updateVoList.add(priSpScpDurVO);
				} else if ( cstPriSpScpDurVO[i].getIbflag().equals("D")){
					PriSpScpDurVO priSpScpDurVO = new PriSpScpDurVO();
					ObjectCloner.build(cstPriSpScpDurVO[i], priSpScpDurVO );
					deleteVoList.add(priSpScpDurVO);
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
            //log.error("err " + ex.toString(), ex);
        	throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            //log.error("err " + ex.toString(), ex);
        	throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
	}
	
    /**
     * Copying S/C Proposal Main Duration information.<br>
     * 
     * @param RsltPropCopyVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalDuration(RsltPropCopyVO vo, SignOnUserAccount account) throws EventException{
        try {
            vo.setCreUsrId(account.getUsr_id());
            vo.setUpdUsrId(account.getUsr_id());
            vo.setOfcCd(account.getOfc_cd());
            // PRI_SP_DUR COPY
            dbDao.addCopyProposalDuration(vo);
        } catch (DAOException ex) {
            //log.error("err " + ex.toString(), ex);
        	throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            //log.error("err " + ex.toString(), ex);
        	throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }

    /**
     * Copying S/C Proposal Scope Duration information<br>
     * 
     * @param RsltPropCopyVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalScopeDuration(RsltPropCopyVO vo, SignOnUserAccount account) throws EventException{
        try {
            vo.setCreUsrId(account.getUsr_id());
            vo.setUpdUsrId(account.getUsr_id());
            vo.setOfcCd(account.getOfc_cd());
            // PRI_SP_SCP_DUR COPY
            dbDao.addCopyProposalScopeDuration(vo);
        } catch (DAOException ex) {
            //log.error("err " + ex.toString(), ex);
        	throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            //log.error("err " + ex.toString(), ex);
        	throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }
    
	/**
     * Retrieving  Scope Duration when saving Main Duration<br>
	 * 
	 * @param PriSpScpDurVO priSpScpDurVO
	 * @return List<CstPriSpDurVO>
	 * @exception EventException
	 */
	public List<CstPriSpDurVO> searchProposalScopeCheckList(PriSpScpDurVO priSpScpDurVO) throws EventException {
		try {
			return dbDao.searchProposalScopeCheckList(priSpScpDurVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}    
    
	/**
	 * Deleting S/C Proposal Main Duration information<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeProposal(PriSpMnVO priSpMnVO, SignOnUserAccount account) throws EventException{
		try {
			if (priSpMnVO != null){
				dbDao.removeProposal(priSpMnVO);
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
	 * Deleting  Scope Duration's data when canceling Init <br>
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeProposalScope(PriSpScpMnVO priSpScpMnVO, SignOnUserAccount account) throws EventException{
		try {
			if (priSpScpMnVO != null){
				dbDao.removeProposalScope(priSpScpMnVO);
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
	 * changing accepted data of main duration to "init" at one time when canceling Request<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalRequestCancel(PriSpMnVO priSpMnVO,SignOnUserAccount account) throws EventException{
		try {
			if (priSpMnVO != null  ) {
				priSpMnVO.setUpdUsrId(account.getUsr_id());	
				dbDao.modifyProposalRequestCancel(priSpMnVO);
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
	 * changing accepted data of scope duration to "init" at one time when canceling Request.<br>
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalRequestCancelScope(PriSpScpMnVO priSpScpMnVO,SignOnUserAccount account) throws EventException{
		try {
			if (priSpScpMnVO != null  ) {
				priSpScpMnVO.setUpdUsrId(account.getUsr_id());	
				dbDao.modifyProposalRequestCancelScope(priSpScpMnVO);
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
	 * Modifying effective data of duration in case filing date is before when Filing<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalTerms(PriSpMnVO priSpMnVO, SignOnUserAccount account) throws EventException{
		try {
			if (priSpMnVO != null  ) {
				priSpMnVO.setUpdUsrId(account.getUsr_id());	
				dbDao.modifyProposalTerms (priSpMnVO);
				dbDao.modifyProposalScpTerms (priSpMnVO);
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
     * Retrieving amend data of scope duration when canceling amendment of Main Duration<br>
	 * @param PriSpScpDurVO PriSpScpDurVO
	 * @return List<PriSpScpDurVO>
	 * @throws DAOException
	 */
	public List<PriSpScpDurVO> searchProposalDurationAmendCheckList(PriSpScpDurVO priSpScpDurVO) throws EventException {
		try {
			return dbDao.searchProposalDurationAmendCheckList(priSpScpDurVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}  	
	
	/**
     * Retrieving whether main duration is before scope duration when saving main duration
	 * 
	 * @param PriSpScpDurVO priSpScpDurVO
	 * @return List<CstPriSpScpDurCntVO>
	 * @exception EventException
	 */
	public List<CstPriSpScpDurCntVO> searchProposalDurationScopeCount(PriSpScpDurVO priSpScpDurVO) throws EventException {
		try {
			return dbDao.searchProposalDurationScopeCount(priSpScpDurVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}   	
	
	/**
	 * Retrieving Scope.<br>
	 * 
	 * @param CstPriSpScpDurVO cstPriSpScpDurVO
	 * @return List<PriSpScpDurVO>
	 * @exception DAOException
	 */
	public List<PriSpScpDurVO> searchProposalScope(CstPriSpScpDurVO cstPriSpScpDurVO) throws EventException {
		try {
			return dbDao.searchProposalScope(cstPriSpScpDurVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}   		
	
	/**
	 * Retrieving Duration Amend History <br>
	 * 
	 * @param PriSpScpDurVO priSpScpDurVO
	 * @return List<RsltPriSpDurHisVO>
	 * @exception EventException
	 */
	public List<RsltPriSpDurHisVO> searchProposalDurationHistoryList(PriSpScpDurVO priSpScpDurVO) throws EventException {
		try {

			if (priSpScpDurVO.getSvcScpCd().equals("")){
				return  dbDao.searchProposalDurationMainHistoryList(priSpScpDurVO);
			}else{
				return dbDao.searchProposalDurationScopeHistoryList(priSpScpDurVO);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}		
    
	/**
	 * Modifying Main,Scope Duration's Request data to Accept <br>
	 * 
	 * @param CstAcceptDurVO cstAcceptDurVO
	 * @param SignOnUserAccount account
	 * @return int
	 * @exception EventException
	 */
	public int acceptAllProposalDuration(CstAcceptDurVO cstAcceptDurVO, SignOnUserAccount account) throws EventException{
		int rValue = 0;
		try {
			String currentDate = new SimpleDateFormat("yyyyMMdd").format(new Date());
			if  (cstAcceptDurVO != null){
				cstAcceptDurVO.setUpdUsrId(account.getUsr_id());	
				cstAcceptDurVO.setAcptUsrId(account.getUsr_id());
				cstAcceptDurVO.setAcptOfcCd(account.getOfc_cd());				
				cstAcceptDurVO.setAcptDt(currentDate);
				cstAcceptDurVO.setPrcProgStsCd(cstAcceptDurVO.getStsCd());
				rValue = dbDao.modifyAcceptAllProposalDuration (cstAcceptDurVO);
				rValue += dbDao.modifyAcceptAllProposalScopeDuration (cstAcceptDurVO);	
			}

				
        } catch (DAOException ex) {
            //log.error("err " + ex.toString(), ex);
        	throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            //log.error("err " + ex.toString(), ex);
        	throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
		return rValue;
	}	
	
	/**
	 * Canceling all acceptance of Main,Scope Duration data<br>
	 * 
	 * @param CstAcceptDurVO cstAcceptDurVO
	 * @param SignOnUserAccount account
	 * @return int
	 * @exception EventException
	 */
	public int cancelAllProposalDuration(CstAcceptDurVO cstAcceptDurVO, SignOnUserAccount account) throws EventException{
		int rValue = 0;
		try {			
			if (cstAcceptDurVO != null  ) {
				cstAcceptDurVO.setUpdUsrId(account.getUsr_id());					
				cstAcceptDurVO.setAcptUsrId("");
				cstAcceptDurVO.setAcptOfcCd("");								
				cstAcceptDurVO.setAcptDt(null);	
				cstAcceptDurVO.setPrcProgStsCd(cstAcceptDurVO.getStsCd());
				rValue = dbDao.modifyAcceptAllProposalDuration (cstAcceptDurVO);	
				rValue += dbDao.modifyAcceptAllProposalScopeDuration (cstAcceptDurVO);	
			}	
		
				
        } catch (DAOException ex) {
            //log.error("err " + ex.toString(), ex);
        	throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            //log.error("err " + ex.toString(), ex);
        	throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
		return rValue;
	}	
	
	

    /**
     * Retrieving count of scope to check saving main and scope simutaneously when saving<br>
     *
     * @param PriSpMnVO priSpMnVO
     * @return List<RsltCdListVO>
     * @exception EventException
     */
	public List<RsltCdListVO> searchDurScopeCount(PriSpMnVO priSpMnVO) throws EventException{
		try {
			return dbDao.searchDurScopeCount(priSpMnVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}  	
	
    /**
     * Checking modified scope duration is between main duration after main duration when saving<br>
     *
     * @param PriSpScpDurVO priSpScpDurVO
     * @return List<RsltCdListVO>
     * @exception EventException
     */
    public List<RsltCdListVO> searchMainDuration(PriSpScpDurVO priSpScpDurVO) throws EventException{
		try {
			return dbDao.searchMainDuration(priSpScpDurVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	} 	
	
    /**
     * Checking modified scope duration is between main duration after main duration when saving.<br>
     *
     * @param PriSpScpDurVO priSpScpDurVO
     * @return List<RsltCdListVO>
     * @exception EventException
     */
    public List<RsltCdListVO> searchScopeDuration(PriSpScpDurVO priSpScpDurVO) throws EventException{
		try {
			return dbDao.searchScopeDuration(priSpScpDurVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}     
}