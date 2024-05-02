/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCMQCProposalBCImpl.java
*@FileTitle : MQC
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scmqcproposal.basic;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.clt.apps.opus.esm.pri.scproposal.scmqcproposal.integration.SCMQCProposalDBDAO;
import com.clt.apps.opus.esm.pri.scproposal.scmqcproposal.vo.CstAcceptMqcVO;
import com.clt.apps.opus.esm.pri.scproposal.scmqcproposal.vo.CstMqcVO;
import com.clt.apps.opus.esm.pri.scproposal.scmqcproposal.vo.GrpMqcVO;
import com.clt.apps.opus.esm.pri.scproposal.scmqcproposal.vo.RsltPriSpMqcHisVO;
import com.clt.apps.opus.esm.pri.scproposal.scmqcproposal.vo.RsltPriSpScpMqcVO;
import com.clt.apps.opus.esm.pri.scproposal.scmqcproposal.vo.RsltPriSpSubMqcHisVO;
import com.clt.apps.opus.esm.pri.scproposal.scmqcproposal.vo.RsltPriSpSubMqcVO;
import com.clt.apps.opus.esm.pri.scproposal.scmqcproposal.vo.SchPriSpScpMqcVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.RsltPropCopyVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.ScPropMnVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.object.ObjectCloner;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriSpMnVO;
import com.clt.syscommon.common.table.PriSpMqcVO;
import com.clt.syscommon.common.table.PriSpScpMnVO;
import com.clt.syscommon.common.table.PriSpScpMqcVO;
import com.clt.syscommon.common.table.PriSpSubMqcVO;

/**
 * SCProposal Business Logic Basic Command implementation<br>
 * - Handling a biz logic about SCProposal<br>
 *
 * @author 
 * @see ESM_PRI_0020EventResponse,SCMQCProposalBC - refer to each DAO class
 * @since J2EE 1.4
 */
public class SCMQCProposalBCImpl extends BasicCommandSupport implements SCMQCProposalBC {

	// Database Access Object
	private transient SCMQCProposalDBDAO dbDao = null;

	/**
	 * Creating SCMQCProposalBCImpl object<br>
	 * Creating SCMQCProposalDBDAO<br>
	 */
	public SCMQCProposalBCImpl() {
		dbDao = new SCMQCProposalDBDAO();
	}

	
	/**
	 * Saving MQC from Proposal Main.<br>
	 * 
	 * @param ScPropMnVO scPropMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposal(ScPropMnVO scPropMnVO, SignOnUserAccount account) throws EventException{
		try {
			
			PriSpMqcVO[] mqcVo = scPropMnVO.getPriSpMqcVOs();
			PriSpScpMqcVO[] scpMqcVo = scPropMnVO.getPriSpScpMqcVOs();
			PriSpMnVO[] mnVo = scPropMnVO.getPriSpMnVOs();
			List<PriSpMqcVO> insertMqcVoList = new ArrayList<PriSpMqcVO>();
			List<PriSpScpMqcVO> insertScpMqcVoList = new ArrayList<PriSpScpMqcVO>();
			List<SchPriSpScpMqcVO> updateMqcVoList = new ArrayList<SchPriSpScpMqcVO>();
			List<PriSpScpMqcVO> updateScpMqcVoList = new ArrayList<PriSpScpMqcVO>();
//			List<PriSpScpMqcVO> deleteScpMqcVoList = new ArrayList<PriSpScpMqcVO>();			
			
			String propNo = dbDao.searchCreationProposalNo(mnVo[0].getPropOfcCd());

			for ( int i = 0; mqcVo != null && i < mqcVo.length; i++ ) {
				if ( mqcVo[i].getIbflag().equals("I")){
					mqcVo[i].setPropNo(propNo);
					mqcVo[i].setCreUsrId(account.getUsr_id());
					mqcVo[i].setUpdUsrId(account.getUsr_id());					
					insertMqcVoList.add(mqcVo[i]);
				} else if ( mqcVo[i].getIbflag().equals("U")){
					SchPriSpScpMqcVO sMqcVO = new SchPriSpScpMqcVO();
					mqcVo[i].setUpdUsrId(account.getUsr_id());
					ObjectCloner.build( mqcVo[i], sMqcVO);						
					updateMqcVoList.add(sMqcVO);
				} 
			}
			
			for ( int i = 0; scpMqcVo != null && i < scpMqcVo.length; i++ ) {
				if ( scpMqcVo[i].getIbflag().equals("I")){
					if(scpMqcVo[i].getPropNo().equals("")){
						scpMqcVo[i].setPropNo(propNo);
						scpMqcVo[i].setAmdtSeq("0");
					}							
					scpMqcVo[i].setCreUsrId(account.getUsr_id());
					scpMqcVo[i].setUpdUsrId(account.getUsr_id());					
					insertScpMqcVoList.add(scpMqcVo[i]);
				} else if ( scpMqcVo[i].getIbflag().equals("U")){
					scpMqcVo[i].setUpdUsrId(account.getUsr_id());
					updateScpMqcVoList.add(scpMqcVo[i]);
//				} else if ( scpMqcVo[i].getIbflag().equals("D")){
//					deleteScpMqcVoList.add(scpMqcVo[i]);					
				} 
			}		
//			if ( deleteScpMqcVoList.size() > 0 ) {
//				dbDao.removeProposalScopeMQC(deleteScpMqcVoList);
//			}
			
			if ( insertMqcVoList.size() > 0 ) {
				dbDao.addProposalMQC(insertMqcVoList);
			}
			
			if ( updateMqcVoList.size() > 0 ) {
				dbDao.modifyProposalMQC(updateMqcVoList);
			}
			
			if ( insertScpMqcVoList.size() > 0 ) {
				dbDao.addProposalScopeMQC(insertScpMqcVoList);
			}
			
			if ( updateScpMqcVoList.size() > 0 ) {
				dbDao.modifyProposalScopeMQC(updateScpMqcVoList);
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
	 * Deleting MQC from Proposal Main<br>
	 * 
	 * @param ScPropMnVO scPropMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalScopeMqcRemove(ScPropMnVO scPropMnVO, SignOnUserAccount account) throws EventException{
		try {
			PriSpScpMqcVO[] scpMqcVo = scPropMnVO.getPriSpScpMqcVOs();
			List<PriSpScpMqcVO> deleteScpMqcVoList = new ArrayList<PriSpScpMqcVO>();			
			
			for ( int i = 0; scpMqcVo != null && i < scpMqcVo.length; i++ ) {
				if ( scpMqcVo[i].getIbflag().equals("D")){
					deleteScpMqcVoList.add(scpMqcVo[i]);					
				} 
			}		
			if ( deleteScpMqcVoList.size() > 0 ) {
				dbDao.removeProposalScopeMQC(deleteScpMqcVoList);
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
	 * Request Amendment<br>
	 * 
	 * @param PriSpMnVO piSpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void amendProposal(PriSpMnVO piSpMnVO, SignOnUserAccount account) throws EventException{
		try {
			
			List<PriSpMnVO> insertVoList = new ArrayList<PriSpMnVO>();
			 
			piSpMnVO.setCreUsrId(account.getUsr_id());
			piSpMnVO.setUpdUsrId(account.getUsr_id());					
			insertVoList.add(piSpMnVO);
 
			dbDao.addProposalMQCAmend(insertVoList);
			dbDao.addProposalScopeMQCAmend(insertVoList);
			dbDao.addProposalSubMQCAmend(insertVoList);				
			
        } catch (DAOException ex) {
        	throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
        	throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
	}	
	
	/**
	 * Retrieving Main MQC,Scope MQC data.<br>
	 * 
	 * @param CstMqcVO cstMqcVO
	 * @return GrpMqcVO
	 * @exception EventException 
	 */
	public GrpMqcVO searchProposalMQCList(CstMqcVO cstMqcVO) throws EventException {
		try {
			List<RsltPriSpScpMqcVO> rsltPriSpScpMqcVO =  new ArrayList<RsltPriSpScpMqcVO>();			
			GrpMqcVO grpMqcVO = new GrpMqcVO();			

			if (cstMqcVO.getSvcScpCd().equals("")){
				rsltPriSpScpMqcVO =  dbDao.searchProposalMQCList(cstMqcVO);
			}else{				
				rsltPriSpScpMqcVO = dbDao.searchProposalScopeMQCList(cstMqcVO);
			}			
			grpMqcVO.setRsltPriSpScpMqcVOS(rsltPriSpScpMqcVO);
			return grpMqcVO;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}	
	
	
	/**
	 * Accepting Main,Scope MQC<br>
	 * 
	 * @param SchPriSpScpMqcVO schPriSpScpMqcVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptProposalMQC(SchPriSpScpMqcVO schPriSpScpMqcVO, SignOnUserAccount account) throws EventException{
		try {
		
			List<SchPriSpScpMqcVO> updateVoList = new ArrayList<SchPriSpScpMqcVO>();
			
			schPriSpScpMqcVO.setUpdUsrId(account.getUsr_id());	
			schPriSpScpMqcVO.setAcptUsrId(account.getUsr_id());
			schPriSpScpMqcVO.setAcptOfcCd(account.getOfc_cd());	
			schPriSpScpMqcVO.setPropMqcQty(schPriSpScpMqcVO.getPropScpMqcQty());
			String currentDate = new SimpleDateFormat("yyyyMMdd").format(new Date());			
			schPriSpScpMqcVO.setAcptDt(currentDate);
			String svcScpCd = schPriSpScpMqcVO.getSvcScpCd();

			updateVoList.add(schPriSpScpMqcVO);

			if (svcScpCd.equals("")){
				dbDao.modifyProposalMQC (updateVoList);
			}else{
				dbDao.modifyProposalScpMQC (updateVoList);
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
	 * Canceling an acceptance of Main,Scope MQC.<br>
	 * 
	 * @param SchPriSpScpMqcVO schPriSpScpMqcVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelProposalMQC(SchPriSpScpMqcVO schPriSpScpMqcVO, SignOnUserAccount account) throws EventException{
		try {
		
			List<SchPriSpScpMqcVO> updateVoList = new ArrayList<SchPriSpScpMqcVO>();
			
			schPriSpScpMqcVO.setUpdUsrId(account.getUsr_id());	
			//cancel 
			schPriSpScpMqcVO.setAcptUsrId("C");
			schPriSpScpMqcVO.setAcptOfcCd("C");		
			schPriSpScpMqcVO.setAcptDt("C");	
			schPriSpScpMqcVO.setPropMqcQty(schPriSpScpMqcVO.getPropScpMqcQty());

			String svcScpCd = schPriSpScpMqcVO.getSvcScpCd();
			updateVoList.add(schPriSpScpMqcVO);
			
			if (svcScpCd.equals("")){
				dbDao.modifyProposalMQC (updateVoList);
			}else{
				dbDao.modifyProposalScpMQC (updateVoList);
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
	 * Modifying and deleting MQC from MQC screen<br>
	 * 
	 * @param SchPriSpScpMqcVO[] schPriSpScpMqcVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalMQC(SchPriSpScpMqcVO[] schPriSpScpMqcVO, SignOnUserAccount account) throws EventException{
		try {
			String svcScpCd = schPriSpScpMqcVO[0].getSvcScpCd();

			List<SchPriSpScpMqcVO> updateVoList = new ArrayList<SchPriSpScpMqcVO>();
			List<SchPriSpScpMqcVO> deleteVoList = new ArrayList<SchPriSpScpMqcVO>();
			for ( int i = 0; i < schPriSpScpMqcVO.length; i++ ) {

				if ( schPriSpScpMqcVO[i].getIbflag().equals("U")){
					schPriSpScpMqcVO[i].setUpdUsrId(account.getUsr_id());
					schPriSpScpMqcVO[i].setPropMqcQty(schPriSpScpMqcVO[i].getPropScpMqcQty());
					updateVoList.add(schPriSpScpMqcVO[i]);
				} else if ( schPriSpScpMqcVO[i].getIbflag().equals("D")){
					deleteVoList.add(schPriSpScpMqcVO[i]);
				}
			}

			if ( updateVoList.size() > 0 ) {
				if (svcScpCd.equals("")){
					dbDao.modifyProposalMQC (updateVoList);	
					dbDao.modifyProposalUnitMQC (updateVoList);	
				}else{
					dbDao.modifyProposalScpMQC (updateVoList);
				}	
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeProposalMQC (deleteVoList);
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
	 * Retrieving Sub MQC data<br>
	 * 
	 * @param PriSpSubMqcVO priSpSubMqcVO
	 * @return List<RsltPriSpSubMqcVO>
	 * @exception EventException
	 */
	public List<RsltPriSpSubMqcVO> searchProposalSubMQCList(PriSpSubMqcVO priSpSubMqcVO) throws EventException {
		try {
			return dbDao.searchProposalSubMQCList(priSpSubMqcVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}	
	
	
	/**
	 * Accept Sub MQC<br>
	 * 
	 * @param PriSpSubMqcVO priSpSubMqcVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptProposalSubMQC(PriSpSubMqcVO priSpSubMqcVO, SignOnUserAccount account) throws EventException{
		try {
			List<PriSpSubMqcVO> updateVoList = new ArrayList<PriSpSubMqcVO>();			
			priSpSubMqcVO.setUpdUsrId(account.getUsr_id());	
			priSpSubMqcVO.setAcptUsrId(account.getUsr_id());
			priSpSubMqcVO.setAcptOfcCd(account.getOfc_cd());			
			String currentDate = new SimpleDateFormat("yyyyMMdd").format(new Date());			
			priSpSubMqcVO.setAcptDt(currentDate);
			updateVoList.add(priSpSubMqcVO);
			dbDao.modifyProposalSubMQC (updateVoList);
        } catch (DAOException ex) {
            //log.error("err " + ex.toString(), ex);
        	throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            //log.error("err " + ex.toString(), ex);
        	throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
	}	
	/**
	 * Canceling an acceptance of Sub MQC.<br>
	 * 
	 * @param PriSpSubMqcVO priSpSubMqcVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelProposalSubMQC(PriSpSubMqcVO priSpSubMqcVO, SignOnUserAccount account) throws EventException{
		try {
		
			List<PriSpSubMqcVO> updateVoList = new ArrayList<PriSpSubMqcVO>();
			
			priSpSubMqcVO.setUpdUsrId(account.getUsr_id());	
			priSpSubMqcVO.setAcptUsrId("");
			priSpSubMqcVO.setAcptOfcCd("");			
		
			priSpSubMqcVO.setAcptDt(null);

			updateVoList.add(priSpSubMqcVO);
			dbDao.modifyProposalSubMQC (updateVoList);
		
				
        } catch (DAOException ex) {
            //log.error("err " + ex.toString(), ex);
        	throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            //log.error("err " + ex.toString(), ex);
        	throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
	}		
	/**
	 * Saving Sub MQC<br>
	 * 
	 * @param PriSpSubMqcVO[] priSpSubMqcVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalSubMQC(PriSpSubMqcVO[] priSpSubMqcVO, SignOnUserAccount account) throws EventException{
		try {
			List<PriSpSubMqcVO> insertVoList = new ArrayList<PriSpSubMqcVO>();
			List<PriSpSubMqcVO> updateVoList = new ArrayList<PriSpSubMqcVO>();
			List<PriSpSubMqcVO> deleteVoList = new ArrayList<PriSpSubMqcVO>();
			for ( int i = 0; i < priSpSubMqcVO.length; i++ ) {
				if ( priSpSubMqcVO[i].getIbflag().equals("I")){
					priSpSubMqcVO[i].setUpdUsrId(account.getUsr_id());					
					priSpSubMqcVO[i].setCreUsrId(account.getUsr_id());
					insertVoList.add(priSpSubMqcVO[i]);
				} else if ( priSpSubMqcVO[i].getIbflag().equals("U")){
					priSpSubMqcVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(priSpSubMqcVO[i]);
				} else if ( priSpSubMqcVO[i].getIbflag().equals("D")){
					deleteVoList.add(priSpSubMqcVO[i]);
				}
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeProposalSubMQC (deleteVoList);
			}
			if ( insertVoList.size() > 0 ) {
				dbDao.addProposalSubMQC(insertVoList);
			}
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyProposalSubMQC (updateVoList);
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
	 * Retrieving MQC sum of scope except selected scope
	 * 
	 * @param PriSpScpMqcVO priSpScpMqcVO
	 * @return List<RsltPriSpScpMqcVO>
	 * @exception EventException
	 */
	public List<RsltPriSpScpMqcVO> searchSumScopeMqc(PriSpScpMqcVO priSpScpMqcVO) throws EventException {
		try {
			return dbDao.searchSumScopeMqc(priSpScpMqcVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}	
	
	/**
	 * Retrieving MQC sum of all scope <br>
	 * 
	 * @param PriSpScpMqcVO priSpScpMqcVO
	 * @return List<RsltPriSpScpMqcVO>
	 * @exception EventException
	 */
	public List<RsltPriSpScpMqcVO> searchSumScopeAllMqc(PriSpScpMqcVO priSpScpMqcVO) throws EventException {
		try {
			return dbDao.searchSumScopeAllMqc(priSpScpMqcVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}		


    /**
     * Copying Proposal MQC information<br>
     * 
     * @param RsltPropCopyVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalMqc(RsltPropCopyVO vo, SignOnUserAccount account) throws EventException{
        try {
            vo.setCreUsrId(account.getUsr_id());
            vo.setUpdUsrId(account.getUsr_id());
            vo.setOfcCd(account.getOfc_cd());

            dbDao.addCopyProposalMqc(vo);
        } catch (DAOException ex) {
            //log.error("err " + ex.toString(), ex);
        	throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            //log.error("err " + ex.toString(), ex);
        	throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }

    /**
     * Copying Proposal Scope MQC information.<br>
     * 
     * @param RsltPropCopyVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalScopeMqc(RsltPropCopyVO vo, SignOnUserAccount account) throws EventException{
        try {
            vo.setCreUsrId(account.getUsr_id());
            vo.setUpdUsrId(account.getUsr_id());
            vo.setOfcCd(account.getOfc_cd());

            dbDao.addCopyProposalScopeMqc(vo);
        } catch (DAOException ex) {
            //log.error("err " + ex.toString(), ex);
        	throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            //log.error("err " + ex.toString(), ex);
        	throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }
    
	/**
	 * Deleting S/C MQC Main information.<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeProposal(PriSpMnVO priSpMnVO, SignOnUserAccount account) throws EventException{
		try {
			dbDao.removeProposalMQC(priSpMnVO);
			dbDao.removeProposalSubMQC(priSpMnVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00202",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00202",new String[]{}).getMessage(), ex);
		}
	}	       
	
	/**
	 * Deleting S/C MQC Scope information<br>
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeProposalScope(PriSpScpMnVO priSpScpMnVO, SignOnUserAccount account) throws EventException{
		try {
			dbDao.removeProposalScope(priSpScpMnVO);
        } catch (DAOException ex) {
            //log.error("err " + ex.toString(), ex);
        	throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            //log.error("err " + ex.toString(), ex);
        	throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
	}	   
	/**
	 * Modifying accepted data of main duration to "init" at one time when canceling request<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalRequestCancel(PriSpMnVO priSpMnVO,SignOnUserAccount account) throws EventException{
		try {
			if (priSpMnVO != null  ) {
				priSpMnVO.setUpdUsrId(account.getUsr_id());	
				dbDao.modifyProposalSubMQCRequestCancel(priSpMnVO);
				dbDao.modifyProposalMQCRequestCancel(priSpMnVO);
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
	 * Modifying accepted data of scope duration to "init" at one time when canceling request.<br>
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
	 * Accepting automatically when requesting S/C Proposal<br>
	 * @param PriSpScpMqcVO priSpScpMqcVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void autoAcceptProposalScpMqc(PriSpScpMqcVO priSpScpMqcVO,SignOnUserAccount account) throws EventException{
		try {		
			if (priSpScpMqcVO != null){
				priSpScpMqcVO.setUpdUsrId(account.getUsr_id());	
				priSpScpMqcVO.setAcptUsrId(account.getUsr_id());
				dbDao.modifyAutoAcceptProposalScpMqc (priSpScpMqcVO);
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
	 * Retrieving MQC(Main,Scope) Amend History <br>
	 * 
	 * @param PriSpScpMqcVO priSpScpMqcVO 
	 * @return List<RsltPriSpMqcHisVO>
	 * @exception EventException
	 */
	public List<RsltPriSpMqcHisVO> searchProposalMQCHistoryList(PriSpScpMqcVO priSpScpMqcVO) throws EventException {
		try {
	
			if (priSpScpMqcVO.getSvcScpCd().equals("")){
				return  dbDao.searchProposalMQCHistoryList(priSpScpMqcVO);
			}else{
				return dbDao.searchProposalScopeMQCHistoryList(priSpScpMqcVO);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}		
	
	/**
	 * Retrieving Sub MQC Amend History <br>
	 * 
	 * @param PriSpScpMqcVO priSpScpMqcVO 
	 * @return List<RsltPriSpSubMqcHisVO>
	 * @exception EventException
	 */
	public List<RsltPriSpSubMqcHisVO> searchProposalSubMQCHistoryList(PriSpScpMqcVO priSpScpMqcVO) throws EventException {
		try {
			return  dbDao.searchProposalSubMQCHistoryList(priSpScpMqcVO);					
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}	
	
	/**
	 * Change Main,Scope MQC 's Request data to "accept"<br>
	 * 
	 * @param CstAcceptMqcVO cstAcceptMqcVO
	 * @param SignOnUserAccount account
	 * @return int
	 * @exception EventException
	 */
	public int acceptAllProposalMqc(CstAcceptMqcVO cstAcceptMqcVO,SignOnUserAccount account) throws EventException{
		int rValue = 0;
		try {
			String currentDate = new SimpleDateFormat("yyyyMMdd").format(new Date());
			if  (cstAcceptMqcVO != null){
				cstAcceptMqcVO.setUpdUsrId(account.getUsr_id());	
				cstAcceptMqcVO.setAcptUsrId(account.getUsr_id());
				cstAcceptMqcVO.setAcptOfcCd(account.getOfc_cd());				
				cstAcceptMqcVO.setAcptDt(currentDate);
				cstAcceptMqcVO.setPrcProgStsCd(cstAcceptMqcVO.getStsCd());
				
				rValue = dbDao.modifyAcceptAllProposalMqc (cstAcceptMqcVO);
				rValue += dbDao.modifyAcceptAllProposalScopeMqc (cstAcceptMqcVO);	
				rValue += dbDao.modifyAcceptAllProposalSubMqc (cstAcceptMqcVO);	
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
	 * Canceling all acceptance of Main,Scope MQC<br>
	 * 
	 * @param CstAcceptMqcVO cstAcceptMqcVO
	 * @param SignOnUserAccount account
	 * @return int
	 * @exception EventException
	 */
	public int cancelAllProposalMqc(CstAcceptMqcVO cstAcceptMqcVO,SignOnUserAccount account) throws EventException{
		int rValue = 0;
		try {			
			if (cstAcceptMqcVO != null  ) {
				cstAcceptMqcVO.setUpdUsrId(account.getUsr_id());					
				cstAcceptMqcVO.setAcptUsrId("");
				cstAcceptMqcVO.setAcptOfcCd("");								
				cstAcceptMqcVO.setAcptDt(null);	
				cstAcceptMqcVO.setPrcProgStsCd(cstAcceptMqcVO.getStsCd());
				
				
				rValue = dbDao.modifyAcceptAllProposalMqc (cstAcceptMqcVO);	
				rValue += dbDao.modifyAcceptAllProposalScopeMqc (cstAcceptMqcVO);		
				rValue += dbDao.modifyAcceptAllProposalSubMqc (cstAcceptMqcVO);
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
	 * Accepting Sub MQC automatically<br>
	 * 
	 * @param PriSpSubMqcVO priSpSubMqcVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void autoAcceptProposalSubMQC(PriSpSubMqcVO priSpSubMqcVO, SignOnUserAccount account) throws EventException{
		try {
			
			priSpSubMqcVO.setUpdUsrId(account.getUsr_id());	
			priSpSubMqcVO.setAcptUsrId(account.getUsr_id());
			priSpSubMqcVO.setAcptOfcCd(account.getOfc_cd());			
			String currentDate = new SimpleDateFormat("yyyyMMdd").format(new Date());			
			priSpSubMqcVO.setAcptDt(currentDate);

			dbDao.modifyProposalSubMQCAutoAccept (priSpSubMqcVO);
        } catch (DAOException ex) {
            //log.error("err " + ex.toString(), ex);
        	throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            //log.error("err " + ex.toString(), ex);
        	throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
	}		
	
    /**
     * retrieving count of scope to check silutaneous saving for main and scope on saving time<br>
     *
     * @param PriSpMnVO priSpMnVO
     * @return List<RsltCdListVO>
     * @exception EventException
     */
	public List<RsltCdListVO> searchScopeCount(PriSpMnVO priSpMnVO) throws EventException{
		try {
			log.debug("searchScopeCount=======================bc ");
			return dbDao.searchScopeCount(priSpMnVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}   	
	
}