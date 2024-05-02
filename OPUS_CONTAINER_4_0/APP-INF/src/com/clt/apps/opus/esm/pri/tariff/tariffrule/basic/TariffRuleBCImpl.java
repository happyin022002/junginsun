/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TariffRuleBCImpl.java
*@FileTitle : Tariff Rule Creation &amp; Amendment
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.tariff.tariffrule.basic;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.clt.apps.opus.esm.pri.common.diff.DiffList;
import com.clt.apps.opus.esm.pri.common.diff.DiffListGenerator;
import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.clt.apps.opus.esm.pri.tariff.tariffrule.integration.TariffRuleDBDAO;
import com.clt.apps.opus.esm.pri.tariff.tariffrule.vo.InPriTrfRuleDiffVO;
import com.clt.apps.opus.esm.pri.tariff.tariffrule.vo.PriTrfRuleDiffInquiryVO;
import com.clt.apps.opus.esm.pri.tariff.tariffrule.vo.PriTrfRuleHistoryVO;
import com.clt.apps.opus.esm.pri.tariff.tariffrule.vo.PriTrfRuleListVO;
import com.clt.apps.opus.esm.pri.tariff.tariffrule.vo.RsltPriTrfRuleVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.object.ObjectCloner;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriTrfRuleProgVO;
import com.clt.syscommon.common.table.PriTrfRuleVO;

/**
 * Tariff Business Logic Command Interface<br>
 *
 * @author SHKIM
 * @see EsmPri3507EventResponse,TariffRuleBC - Refer to each DAO class
 * @since J2EE 1.6
 */
public class TariffRuleBCImpl extends BasicCommandSupport implements TariffRuleBC {

	// Database Access Object
	private transient TariffRuleDBDAO dbDao = null;

	/**
	 * Creating TariffRuleBCImpl object<br>
	 * Creating TariffRuleDBDAO <br>
	 */
	public TariffRuleBCImpl() {
		dbDao = new TariffRuleDBDAO();
	}
	/**
	 * Retrieving [Tariff Rule Creation & Amendment information]<br>
	 * 
	 * @param PriTrfRuleVO priTrfRuleVO
	 * @return List<RsltPriTrfRuleVO>
	 * @exception EventException
	 */
	public List<RsltPriTrfRuleVO> searchTariffRuleList(PriTrfRuleVO priTrfRuleVO) throws EventException {
		try {
			return dbDao.searchTariffRuleList(priTrfRuleVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		
	}
	
	/**
	 * Retrieving [Tariff Rule information]<br>
	 * 
	 * @param PriTrfRuleVO priTrfRuleVO
	 * @return List<RsltPriTrfRuleVO>
	 * @exception EventException
	 */
	public List<RsltPriTrfRuleVO> searchTariffRuleInquiryList(PriTrfRuleVO priTrfRuleVO) throws EventException {
		try {
			priTrfRuleVO.setTrfRuleCtnt(priTrfRuleVO.getTrfRuleCtnt());
					//.replaceAll("(\\^|\\[|\\.|\\$|\\{|\\*|\\(|\\)|\\|\\+|\\||\\?|\\<|\\>)", "\\\\$1"));
			return dbDao.searchTariffRuleInquiryList(priTrfRuleVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}		
	}
		
	/**
	 * Retrieving [Tariff Rule History information].<br>
	 * 
	 * @param PriTrfRuleHistoryVO priTrfRuleHistoryVO
	 * @return List<RsltPriTrfRuleVO>
	 * @exception EventException
	 */
	public List<RsltPriTrfRuleVO> searchTariffRuleHistoryList(PriTrfRuleHistoryVO priTrfRuleHistoryVO) throws EventException {
		try {
			priTrfRuleHistoryVO.setRuleNm(priTrfRuleHistoryVO.getRuleNm());
					//.replaceAll("(\\^|\\[|\\.|\\$|\\{|\\*|\\(|\\)|\\|\\+|\\||\\?|\\<|\\>)", "\\\\$1"));
			return dbDao.searchTariffRuleHistoryList(priTrfRuleHistoryVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}		
	}
	
	/**
	 * Retrieving [Tariff Rule Amend History information]<br>
	 * 
	 * @param PriTrfRuleHistoryVO priTrfRuleHistoryVO
	 * @return List<RsltPriTrfRuleVO>
	 * @exception EventException
	 */
	public List<RsltPriTrfRuleVO> searchTariffRuleAmendHistoryList(PriTrfRuleHistoryVO priTrfRuleHistoryVO) throws EventException {
		try {
			priTrfRuleHistoryVO.setRuleNm(priTrfRuleHistoryVO.getRuleNm());
					//.replaceAll("(\\^|\\[|\\.|\\$|\\{|\\*|\\(|\\)|\\|\\+|\\||\\?|\\<|\\>)", "\\\\$1"));
			return dbDao.searchTariffRuleAmendHistoryList(priTrfRuleHistoryVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}		
	}

	/**
	 * Retrieving [Tariff Rule duplication data]<br>
	 * 
	 * @param PriTrfRuleVO	priTrfRuleVO
	 * @return String
	 * @exception EventException
	 */
	public String checkTariffRuleNumber(PriTrfRuleVO priTrfRuleVO) throws EventException {
		try {
			return dbDao.searchTariffRuleDuplicate(priTrfRuleVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}		
	}
	
	/**
	 * Saving [Tariff Rule Creation & Amendment information]<br>
	 * 
	 * @param PriTrfRuleListVO priTrfRuleListVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageTariffRule(PriTrfRuleListVO priTrfRuleListVO, SignOnUserAccount account) throws EventException{
		try {
			PriTrfRuleVO[] priTrfRuleVO = priTrfRuleListVO.getPriTrfRuleVOs();
			String trfRuleCtnt = priTrfRuleListVO.getTrfRuleCtnt();
			
			PriTrfRuleProgVO priTrfRuleProgVO = new PriTrfRuleProgVO();
			List<PriTrfRuleVO> insertVoList = new ArrayList<PriTrfRuleVO>();
			List<PriTrfRuleVO> updateVoList = new ArrayList<PriTrfRuleVO>();
			List<PriTrfRuleVO> deleteVoList = new ArrayList<PriTrfRuleVO>();
			for ( int i=0; i<priTrfRuleVO .length; i++ ) {
				if ( priTrfRuleVO[i].getIbflag().equals("I")){
					priTrfRuleVO[i].setCreUsrId(account.getUsr_id());
					priTrfRuleVO[i].setTrfRuleCtnt(trfRuleCtnt);
					insertVoList.add(priTrfRuleVO[i]);
				} else if ( priTrfRuleVO[i].getIbflag().equals("U")){
					priTrfRuleVO[i].setUpdUsrId(account.getUsr_id());
					priTrfRuleVO[i].setTrfRuleCtnt(trfRuleCtnt);
					updateVoList.add(priTrfRuleVO[i]);
				} else if ( priTrfRuleVO[i].getIbflag().equals("D")){
					deleteVoList.add(priTrfRuleVO[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				//Using  executeUpdate() because executeBatch() is not available for CLOB data
				for(int i=0; i<insertVoList.size(); i++){
					dbDao.addTariffRule(insertVoList.get(i));
										
					ObjectCloner.build(insertVoList.get(i), priTrfRuleProgVO);
					priTrfRuleProgVO.setTrfRuleNo(insertVoList.get(i).getTrfRuleNo());
					priTrfRuleProgVO.setProgUsrId(account.getUsr_id());
					priTrfRuleProgVO.setProgOfcCd(account.getOfc_cd());
					priTrfRuleProgVO.setCreUsrId(account.getUsr_id());
					dbDao.addTariffRuleProgress(priTrfRuleProgVO);
				}				
			}
			
			if ( updateVoList.size() > 0 ) {
				//Using  executeUpdate() because executeBatch() is not available for CLOB data
				for(int i=0; i<updateVoList.size(); i++){
					dbDao.modifyTariffRule(updateVoList.get(i));
				}
			}
			
			if ( deleteVoList.size() > 0 ) {
				for(int i=0; i<deleteVoList.size(); i++){
					ObjectCloner.build(deleteVoList.get(i), priTrfRuleProgVO);					
					dbDao.removeTariffRuleProgress(priTrfRuleProgVO);
					
					dbDao.removeTariffRule(deleteVoList.get(i));					
				}				
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * Amending [Tariff Rule Creation & Amendment information].<br>
	 * 
	 * @param PriTrfRuleVO priTrfRuleVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void amendTariffRule(PriTrfRuleVO priTrfRuleVO,SignOnUserAccount account)  throws EventException{
		try {
			PriTrfRuleProgVO priTrfRuleProgVO = new PriTrfRuleProgVO();
			
			priTrfRuleVO.setCreUsrId(account.getUsr_id());
			priTrfRuleVO.setRqstOfcCd(account.getOfc_cd());
			dbDao.addTariffRuleAmend(priTrfRuleVO);
			
			ObjectCloner.build(priTrfRuleVO, priTrfRuleProgVO);
			priTrfRuleProgVO.setProgUsrId(account.getUsr_id());
			priTrfRuleProgVO.setProgOfcCd(account.getOfc_cd());
			priTrfRuleProgVO.setCreUsrId(account.getUsr_id());
			dbDao.addTariffRuleProgress(priTrfRuleProgVO);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Canceling an amendment of [Tariff Rule Creation & Amendment information].<br>
	 * 
	 * @param PriTrfRuleVO priTrfRuleVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelAmendTariffRule(PriTrfRuleVO priTrfRuleVO,SignOnUserAccount account)  throws EventException{
		try {
			PriTrfRuleProgVO priTrfRuleProgVO = new PriTrfRuleProgVO();
			
			if ( priTrfRuleVO.getIbflag().equals("D")){
				ObjectCloner.build(priTrfRuleVO, priTrfRuleProgVO);
				dbDao.removeTariffRuleProgress(priTrfRuleProgVO);
				
				dbDao.removeTariffRule(priTrfRuleVO);
			}
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Requesting [Tariff Rule Creation & Amendment information].<br>
	 * 
	 * @param PriTrfRuleVO priTrfRuleVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void requestTariffRule(PriTrfRuleVO priTrfRuleVO,SignOnUserAccount account)  throws EventException{
		try {
			PriTrfRuleProgVO priTrfRuleProgVO = new PriTrfRuleProgVO();
			
			if(priTrfRuleVO != null) {
				priTrfRuleVO.setUpdUsrId(account.getUsr_id());
				priTrfRuleVO.setRqstOfcCd(account.getOfc_cd());				
				dbDao.modifyTariffRulesStatus(priTrfRuleVO);
								
				ObjectCloner.build(priTrfRuleVO, priTrfRuleProgVO);
				priTrfRuleProgVO.setCreUsrId(account.getUsr_id());
				priTrfRuleProgVO.setProgUsrId(account.getUsr_id());
				priTrfRuleProgVO.setProgOfcCd(account.getOfc_cd());
				dbDao.addTariffRuleProgress(priTrfRuleProgVO);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}	

	/**
	 * Approving [Tariff Rule Creation & Amendment information]<br>
	 * 
	 * @param PriTrfRuleVO priTrfRuleVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void approveTariffRule(PriTrfRuleVO priTrfRuleVO,SignOnUserAccount account)  throws EventException{
		try {
			PriTrfRuleProgVO priTrfRuleProgVO = new PriTrfRuleProgVO();
			
			if(priTrfRuleVO != null) {
				priTrfRuleVO.setUpdUsrId(account.getUsr_id());
				priTrfRuleVO.setRqstOfcCd(account.getOfc_cd());				
				dbDao.modifyTariffRulesStatus(priTrfRuleVO);
								
				ObjectCloner.build(priTrfRuleVO, priTrfRuleProgVO);
				priTrfRuleProgVO.setCreUsrId(account.getUsr_id());
				priTrfRuleProgVO.setProgUsrId(account.getUsr_id());
				priTrfRuleProgVO.setProgOfcCd(account.getOfc_cd());
				dbDao.addTariffRuleProgress(priTrfRuleProgVO);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * Publishing [Tariff Rule Creation & Amendment information]<br>
	 * 
	 * @param PriTrfRuleVO priTrfRuleVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void publishTariffRule(PriTrfRuleVO priTrfRuleVO,SignOnUserAccount account)  throws EventException{
		try {
			PriTrfRuleProgVO priTrfRuleProgVO = new PriTrfRuleProgVO();
			
			// Publish Handling
			priTrfRuleVO.setUpdUsrId(account.getUsr_id());			
			dbDao.modifyTariffRulesStatus(priTrfRuleVO);
							
			// Changing EXP_DT with previous SEQ to EFF_DT of current SEQ -1
			dbDao.modifyTariffRulesPublish(priTrfRuleVO);
			
			// PROGRESS
			ObjectCloner.build(priTrfRuleVO, priTrfRuleProgVO);
			priTrfRuleProgVO.setCreUsrId(account.getUsr_id());
			priTrfRuleProgVO.setProgUsrId(account.getUsr_id());
			priTrfRuleProgVO.setProgOfcCd(account.getOfc_cd());
			dbDao.addTariffRuleProgress(priTrfRuleProgVO);
		
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Saving [Tariff Rule Creation & Amendment status information].<br>
	 * 
	 * @param PriTrfRuleVO priTrfRuleVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelStatusTariffRule(PriTrfRuleVO priTrfRuleVO,SignOnUserAccount account)  throws EventException{
		try {
			PriTrfRuleProgVO priTrfRuleProgVO = new PriTrfRuleProgVO();
			
			if(priTrfRuleVO != null) {
				priTrfRuleVO.setUpdUsrId(account.getUsr_id());
				priTrfRuleVO.setRqstOfcCd(account.getOfc_cd());				
				dbDao.modifyTariffRulesStatus(priTrfRuleVO);
				
				//2016.04.06
				//exception when update status
				String pubDt = priTrfRuleVO.getPubDt();
				String trfRuleStsCd = priTrfRuleVO.getTrfRuleStsCd();
				String amdtSeq = priTrfRuleVO.getAmdtSeq();
				if(Integer.parseInt(amdtSeq) > 0 && !StringUtils.isEmpty(pubDt) && trfRuleStsCd.equals("I")){
					//only cancel when the status is published
					dbDao.cancelPublishedTariffRules(priTrfRuleVO);
				} 
								
				ObjectCloner.build(priTrfRuleVO, priTrfRuleProgVO);
				priTrfRuleProgVO.setCreUsrId(account.getUsr_id());
				priTrfRuleProgVO.setProgUsrId(account.getUsr_id());
				priTrfRuleProgVO.setProgOfcCd(account.getOfc_cd());
				dbDao.addTariffRuleProgress(priTrfRuleProgVO);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	
	
	/**
	 * Retrieving [Tariff Rule Diff information]<br>
	 * 
	 * @param InPriTrfRuleDiffVO inPriTrfRuleDiffVO
	 * @return DiffList
	 * @exception EventException
	 */
	public DiffList searchTariffRuleDiff(InPriTrfRuleDiffVO inPriTrfRuleDiffVO) throws EventException {
		try {
			List<PriTrfRuleDiffInquiryVO> list = dbDao.searchTariffRuleDiff(inPriTrfRuleDiffVO);	
			DiffList diffList = null;
			
			if( list.size() == 2 ){
				String original = list.get(0).getTrfRuleCtnt();   
				String revised  = list.get(1).getTrfRuleCtnt();
				DiffListGenerator generator = new DiffListGenerator();
				diffList = generator.generateMergeList(original, revised);
//				int size = diffList.size();
//				for(int i = 0 ; i < size ; i++){
//					log.debug(" Tag      :"+diffList.getTag(i));
//					log.debug(" Old Line :"+diffList.getOldLine(i));
//					log.debug(" New Line :"+diffList.getNewLine(i));
//					
//				}
			}else{
				diffList = new DiffList();
				
			}
			
			return diffList;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}		
	}
	
	
	/**
	 * Retrieving [Tariff Code List information]<br>
	 * 
	 * @param RsltCdListVO rsltCdListVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchTariffCodeList(RsltCdListVO rsltCdListVO) throws EventException {
		try {
			return dbDao.searchTariffCodeList(rsltCdListVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}		
	}
}