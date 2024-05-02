/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCMQCProposalBCImpl.java
*@FileTitle : MQC
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.13
*@LastModifier : 변영주
*@LastVersion : 1.0
* 2009.05.13 변영주
* 1.0 Creation
* 
* 2012.02.23 이석준[CHM-201216153-01] S/C Amendment History 화면 기능 개선 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scmqcproposal.basic;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scmqcproposal.integration.SCMQCProposalDBDAO;
import com.hanjin.apps.alps.esm.pri.scproposal.scmqcproposal.vo.CstAcceptMqcVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scmqcproposal.vo.CstMqcVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scmqcproposal.vo.GrpMqcVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scmqcproposal.vo.RsltPriSpMqcHisVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scmqcproposal.vo.RsltPriSpScpMqcVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scmqcproposal.vo.RsltPriSpSubMqcHisVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scmqcproposal.vo.RsltPriSpSubMqcVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scmqcproposal.vo.SchPriSpScpMqcVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPropCopyVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.ScPropMnVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scquotationmain.vo.RsltCopyToProposalVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.PriSpHistoryInquiryParamVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.object.ObjectCloner;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriSpMnVO;
import com.hanjin.syscommon.common.table.PriSpMqcVO;
import com.hanjin.syscommon.common.table.PriSpScpMnVO;
import com.hanjin.syscommon.common.table.PriSpScpMqcVO;
import com.hanjin.syscommon.common.table.PriSpSubMqcVO;

/**
 * NIS2010-SCProposal Business Logic Basic Command implementation<br>
 * - NIS2010-SCProposal에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Byeon Young Joo
 * @see ESM_PRI_0020EventResponse,SCMQCProposalBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class SCMQCProposalBCImpl extends BasicCommandSupport implements SCMQCProposalBC {

	// Database Access Object 
	private transient SCMQCProposalDBDAO dbDao = null;

	/**
	 * SCMQCProposalBCImpl 객체 생성<br>
	 * SCMQCProposalDBDAO를 생성한다.<br> 
	 */
	public SCMQCProposalBCImpl() {
		dbDao = new SCMQCProposalDBDAO();
	}

	
	/**
	 * Proposal Main에서 MQC를 저장합니다.<br>
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
	 * Proposal Main에서 MQC를 삭제합니다.<br>
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
	 * Amend Request를 처리합니다.<br>
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
	 * Main MQC,Scope MQC 데이터를 조회합니다.<br>
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
	 * Main,Scope MQC를 Accept 합니다.<br>
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
	 * Main,Scope MQC를 Accept Cancel 합니다.<br>
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
	 * MQC화면 에서 MQC를 수정,삭제 합니다.<br>
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
	 * Sub MQC 데이터를 조회합니다.<br>
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
	 * Sub MQC를 Accept 합니다.<br>
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
	 * Sub MQC를 Accept Cancel 합니다.<br>
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
	 * Sub MQC를 저장합니다.<br>
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
	 * 선택된 Scope의 값을 제외한 Scope 의 MQC합을 조회합니다.<br>
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
	 * 모든 Scope 의 MQC합을 조회합니다.<br>
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
     * Proposal MQC 정보를 Copy 합니다.<br>
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
     * Proposal Scope MQC 정보를 Copy 합니다.<br>
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
	 * S/C MQC Main 정보를 삭제합니다.<br>
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
	 * S/C MQC Scope 정보를 삭제합니다.<br>
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
	 * Request Cancel시 Main Duration의 Accepted 데이터를 일괄 Init 으로 변경합니다.<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalRequestCancel(PriSpMnVO priSpMnVO,SignOnUserAccount account) throws EventException{
		try {
			if (priSpMnVO != null  ) {
				priSpMnVO.setUpdUsrId(account.getUsr_id());					
			}
			dbDao.modifyProposalSubMQCRequestCancel(priSpMnVO);
			dbDao.modifyProposalMQCRequestCancel(priSpMnVO);
        } catch (DAOException ex) {
            //log.error("err " + ex.toString(), ex);
        	throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            //log.error("err " + ex.toString(), ex);
        	throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
	}	
	
	/**
	 * Request Cancel시 Scope Duration의 Accepted 데이터를 일괄 Init 으로 변경합니다.<br>
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalRequestCancelScope(PriSpScpMnVO priSpScpMnVO,SignOnUserAccount account) throws EventException{
		try {
			if (priSpScpMnVO != null  ) {
				priSpScpMnVO.setUpdUsrId(account.getUsr_id());					
			}
			dbDao.modifyProposalRequestCancelScope(priSpScpMnVO);
        } catch (DAOException ex) {
            //log.error("err " + ex.toString(), ex);
        	throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            //log.error("err " + ex.toString(), ex);
        	throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
	}	
		
	
	/**
	 * S/C Proposal을 Request 할때 자동으로 Accept를 한다.<br>
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
	 * MQC(Main,Scope) Amend History 를 조회한다.<br>
	 * 
	 * @param PriSpScpMqcVO priSpScpMqcVO 
	 * @param PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO
	 * @return List<RsltPriSpMqcHisVO>
	 * @exception EventException
	 */
	public List<RsltPriSpMqcHisVO> searchProposalMQCHistoryList(PriSpScpMqcVO priSpScpMqcVO,PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO) throws EventException {
		try {
	
			if (priSpScpMqcVO.getSvcScpCd().equals("")){
				return dbDao.searchProposalMQCHistoryList(priSpScpMqcVO,priSpHistoryInquiryParamVO);
			}else{
				return dbDao.searchProposalScopeMQCHistoryList(priSpScpMqcVO,priSpHistoryInquiryParamVO);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}		
	
	/**
	 * Sub MQC Amend History 를 조회한다.<br>
	 * 
	 * @param PriSpScpMqcVO priSpScpMqcVO
	 * @param PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO 
	 * @return List<RsltPriSpSubMqcHisVO>
	 * @exception EventException
	 */
	public List<RsltPriSpSubMqcHisVO> searchProposalSubMQCHistoryList(PriSpScpMqcVO priSpScpMqcVO,PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO) throws EventException {
		try {
			return  dbDao.searchProposalSubMQCHistoryList(priSpScpMqcVO,priSpHistoryInquiryParamVO);					
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}	
	
	/**
	 * Quotation 에서 proposal로 데이터를 copy한다.<br>
	 * COPY TO PROPOSAL - 대상테이블 : PRI_SP_MQC, PRI_SP_SCP_MQC<br>
	 * 
	 * @param RsltCopyToProposalVO rsltCopyToProposalVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void copyToProposalMqc(RsltCopyToProposalVO rsltCopyToProposalVO, SignOnUserAccount account) 
		throws EventException{
		try {
			rsltCopyToProposalVO.setCreUsrId(account.getUsr_id());
			rsltCopyToProposalVO.setUpdUsrId(account.getUsr_id());
			//office
			rsltCopyToProposalVO.setQttnOfcCd(account.getOfc_cd());
			
			int chk = 0;
			
			//PRI_SP_MQC
			chk = dbDao.addCopyToProposalSpMqc(rsltCopyToProposalVO);
			if (chk < 1) {
				throw new EventException(new ErrorHandler("PRI03016").getMessage());
			}
			//PRI_SP_SCP_MQC
			chk = dbDao.addCopyToProposalSpScpMqc(rsltCopyToProposalVO);
			if (chk < 1) {
				throw new EventException(new ErrorHandler("PRI03016").getMessage());
			}
		} catch(EventException ex) {
			throw ex;	
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}
	
	/**
	 * Main,Scope MQC 의 Request 데이터를 모두 Accept 로 수정합니다.<br>
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
			}

			rValue = dbDao.modifyAcceptAllProposalMqc (cstAcceptMqcVO);
			rValue += dbDao.modifyAcceptAllProposalScopeMqc (cstAcceptMqcVO);	
			rValue += dbDao.modifyAcceptAllProposalSubMqc (cstAcceptMqcVO);	
				
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
	 * Main,Scope MQC 의 Accept된 데이터를 모두 Accept Cancel 합니다.<br>
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
			}	

			rValue = dbDao.modifyAcceptAllProposalMqc (cstAcceptMqcVO);	
			rValue += dbDao.modifyAcceptAllProposalScopeMqc (cstAcceptMqcVO);		
			rValue += dbDao.modifyAcceptAllProposalSubMqc (cstAcceptMqcVO);
				
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
	 * Sub MQC를 자동 Accept 합니다.<br>
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
     * 저장시 Main과 Scope의 동시 저장 여부를 체크 하기 위하여 Scope의 Count를 조회한다.<br>
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