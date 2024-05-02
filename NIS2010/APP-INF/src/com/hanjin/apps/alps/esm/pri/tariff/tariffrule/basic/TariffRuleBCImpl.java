/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TariffRuleBCImpl.java
*@FileTitle : Tariff Rule Creation &amp; Amendment
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.06
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2010.10.06 최성민
* 1.0 Creation
=========================================================
* History
* 2011.04.19 이행지 [CHM-201110201-01] Tariff Rule 관련 Status 변경 관리자 기능 추가 요청
*                                  - SuperUser일 경우 Publish Cacel권한 부여
* 2011.05.16 이행지 [CHM-201110773-01] [PRI] Tariff Rule - Publish Cancel 기능 보완
=========================================================*/
package com.hanjin.apps.alps.esm.pri.tariff.tariffrule.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.pri.common.diff.DiffList;
import com.hanjin.apps.alps.esm.pri.common.diff.DiffListGenerator;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.tariff.tariffrule.integration.TariffRuleDBDAO;
import com.hanjin.apps.alps.esm.pri.tariff.tariffrule.vo.InPriTrfRuleDiffVO;
import com.hanjin.apps.alps.esm.pri.tariff.tariffrule.vo.PriTrfRuleDiffInquiryVO;
import com.hanjin.apps.alps.esm.pri.tariff.tariffrule.vo.PriTrfRuleHistoryVO;
import com.hanjin.apps.alps.esm.pri.tariff.tariffrule.vo.PriTrfRuleListVO;
import com.hanjin.apps.alps.esm.pri.tariff.tariffrule.vo.RsltPriTrfRuleVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.object.ObjectCloner;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriTrfRuleProgVO;
import com.hanjin.syscommon.common.table.PriTrfRuleVO;

/**
 * ALPS-Tariff Business Logic Command Interface<br>
 * - ALPS-Tariff에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author CHOI SUNGMIN
 * @since J2EE 1.6
 */
public class TariffRuleBCImpl extends BasicCommandSupport implements TariffRuleBC {

	// Database Access Object
	private transient TariffRuleDBDAO dbDao = null;

	/**
	 * TariffRuleBCImpl 객체 생성<br>
	 * TariffRuleDBDAO를 생성한다.<br>
	 */
	public TariffRuleBCImpl() {
		dbDao = new TariffRuleDBDAO();
	}
	/**
	 * [Tariff Rule Creation & Amendment 정보]을 [조회] 합니다.<br>
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
	 * [Tariff Rule 정보]을 [조회] 합니다.<br>
	 * 
	 * @param PriTrfRuleVO priTrfRuleVO
	 * @return List<RsltPriTrfRuleVO>
	 * @exception EventException
	 */
	public List<RsltPriTrfRuleVO> searchTariffRuleInquiryList(PriTrfRuleVO priTrfRuleVO) throws EventException {
		try {
			priTrfRuleVO.setTrfRuleCtnt(priTrfRuleVO.getTrfRuleCtnt()
					.replaceAll("(\\^|\\[|\\.|\\$|\\{|\\*|\\(|\\)|\\|\\+|\\||\\?|\\<|\\>)", "\\\\$1"));
			return dbDao.searchTariffRuleInquiryList(priTrfRuleVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}		
	}
		
	/**
	 * [Tariff Rule History 정보]을 [조회] 합니다.<br>
	 * 
	 * @param PriTrfRuleHistoryVO priTrfRuleHistoryVO
	 * @return List<RsltPriTrfRuleVO>
	 * @exception EventException
	 */
	public List<RsltPriTrfRuleVO> searchTariffRuleHistoryList(PriTrfRuleHistoryVO priTrfRuleHistoryVO) throws EventException {
		try {
			priTrfRuleHistoryVO.setRuleNm(priTrfRuleHistoryVO.getRuleNm()
					.replaceAll("(\\^|\\[|\\.|\\$|\\{|\\*|\\(|\\)|\\|\\+|\\||\\?|\\<|\\>)", "\\\\$1"));
			return dbDao.searchTariffRuleHistoryList(priTrfRuleHistoryVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}		
	}
	
	/**
	 * [Tariff Rule Amend History 정보]을 [조회] 합니다.<br>
	 * 
	 * @param PriTrfRuleHistoryVO priTrfRuleHistoryVO
	 * @return List<RsltPriTrfRuleVO>
	 * @exception EventException
	 */
	public List<RsltPriTrfRuleVO> searchTariffRuleAmendHistoryList(PriTrfRuleHistoryVO priTrfRuleHistoryVO) throws EventException {
		try {
			priTrfRuleHistoryVO.setRuleNm(priTrfRuleHistoryVO.getRuleNm()
					.replaceAll("(\\^|\\[|\\.|\\$|\\{|\\*|\\(|\\)|\\|\\+|\\||\\?|\\<|\\>)", "\\\\$1"));
			return dbDao.searchTariffRuleAmendHistoryList(priTrfRuleHistoryVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}		
	}

	/**
	 * [Tariff Rule 중복데이터]을 [조회] 합니다.<br>
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
	 * [Tariff Rule Creation & Amendment 정보]을 [저장] 합니다.<br>
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
				//CLOB 데이터는 executeBatch()를 사용할 수 없기 때문에 executeUpdate()를 사용함.
				for(int i=0; i<insertVoList.size(); i++){
					dbDao.addTariffRule(insertVoList.get(i));
										
					ObjectCloner.build(insertVoList.get(i), priTrfRuleProgVO);
					priTrfRuleProgVO.setProgUsrId(account.getUsr_id());
					priTrfRuleProgVO.setProgOfcCd(account.getOfc_cd());
					priTrfRuleProgVO.setCreUsrId(account.getUsr_id());
					dbDao.addTariffRuleProgress(priTrfRuleProgVO);
				}				
			}
			
			if ( updateVoList.size() > 0 ) {
				//CLOB 데이터는 executeBatch()를 사용할 수 없기 때문에 executeUpdate()를 사용함.
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
	 * [Tariff Rule Creation & Amendment 정보]을 [Amend] 합니다.<br>
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
	 * [Tariff Rule Creation & Amendment 정보]을 [Amend Cancel] 합니다.<br>
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
	 * [Tariff Rule Creation & Amendment 정보]을 [Request] 합니다.<br>
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
	 * [Tariff Rule Creation & Amendment 정보]을 [Approve] 합니다.<br>
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
	 * [Tariff Rule Creation & Amendment 정보]을 [publish] 합니다.<br>
	 * 
	 * @param PriTrfRuleVO priTrfRuleVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void publishTariffRule(PriTrfRuleVO priTrfRuleVO,SignOnUserAccount account)  throws EventException{
		try {
			PriTrfRuleProgVO priTrfRuleProgVO = new PriTrfRuleProgVO();
			
			// Publish 처리
			priTrfRuleVO.setUpdUsrId(account.getUsr_id());			
			dbDao.modifyTariffRulesStatus(priTrfRuleVO);
							
			// 이전SEQ의 EXP_DT를 현재SEQ의 EFF_DT -1 로 수정
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
	 * [Tariff Rule Creation & Amendment 상태정보]을 [수정] 합니다.<br>
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
	 * [Tariff Rule Diff 정보]을 [조회] 합니다.<br>
	 * 
	 * @param InPriTrfRuleDiffVO inPriTrfRuleDiffVO
	 * @param SignOnUserAccount account
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
	 * [Tariff Code List 정보]을 [조회] 합니다.<br>
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
	
	/**
	 * [Tariff Rule Creation & Amendment 정보]을 [Publish Cancel] 합니다.<br>
	 * 
	 * @param PriTrfRuleVO priTrfRuleVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelPublishTariffRuleBySuperUser(PriTrfRuleVO priTrfRuleVO,SignOnUserAccount account)  throws EventException{
		try {
			if(priTrfRuleVO != null) {
				PriTrfRuleProgVO priTrfRuleProgVO = new PriTrfRuleProgVO();
				priTrfRuleVO.setUpdUsrId(account.getUsr_id());
				
				// 이전 데이터의 EXP_DT와 현 CANCEL하려고 하는 데이터의 EFF_DT 차이 구하기
				String diff = dbDao.searchTariffRuleExperationDate(priTrfRuleVO);
				int diffDate = (diff != null && diff != "") ? Integer.parseInt(diff) : 0;
				String amdtSeq = priTrfRuleVO.getAmdtSeq();
				int prevAmdtSeq = -1;
				
				if( diffDate == 1){
					PriTrfRuleVO prevPriTrfRuleVO = new PriTrfRuleVO();
					ObjectCloner.build(priTrfRuleVO, prevPriTrfRuleVO);
					
					// diffDate == 1로서 연속된 날짜이면 이전 data의 EXP_DT를 null로 바꿔준다.
					prevAmdtSeq = Integer.parseInt(amdtSeq) -1;
					prevPriTrfRuleVO.setExpDt(null);
					prevPriTrfRuleVO.setAmdtSeq(String.valueOf(prevAmdtSeq));
					dbDao.modifyTariffRuleExperationDate(prevPriTrfRuleVO);
				}
				
				// main 정보 update 상태를 A로 변경하고 pub_dt를 null로 바꾼다.
				priTrfRuleVO.setRqstOfcCd(account.getOfc_cd());
				dbDao.modifyTariffRulePublishDate(priTrfRuleVO);

				
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
	 * [Tariff Rule Publish Cancel 정보]을 [조회] 합니다.<br>
	 * 
	 * @param PriTrfRuleVO priTrfRuleVO
	 * @return List<RsltPriTrfRuleVO>
	 * @exception EventException
	 */
	public List<RsltPriTrfRuleVO> searchTariffRulePublishCancelList(PriTrfRuleVO priTrfRuleVO) throws EventException {
		try {
			return dbDao.searchTariffRulePublishCancelList(priTrfRuleVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		
	}
	
	/**
	 * [Tariff Rule Creation & Amendment 정보]을 [Publish Cancel] 합니다.<br>
	 * 
	 * @param PriTrfRuleVO[] priTrfRuleVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelPublishTariffRule(PriTrfRuleVO[] priTrfRuleVOs,SignOnUserAccount account)  throws EventException{
		try {
			if(priTrfRuleVOs != null) {
				
				int rowCount = priTrfRuleVOs.length;				

				for (int i=0; i < rowCount; i++){
					priTrfRuleVOs[i].setUpdUsrId(account.getUsr_id());
				}
				
				// AMD SEQ 0이상일 경우 화면에서 Expiration Date를 수정했을 경우 반영하기 위한 로직.
				if( rowCount > 1 ){
					dbDao.modifyTariffRuleExperationDate(priTrfRuleVOs[0]);
				}
				
				// Publish Cancel할 Amend Data를 상태를 A로 변경하고 pub_dt를 null로 바꾼다.
				priTrfRuleVOs[rowCount-1].setRqstOfcCd(account.getOfc_cd());
				priTrfRuleVOs[rowCount-1].setPubDt(null);
				dbDao.modifyCancelPublishTariffRule(priTrfRuleVOs[rowCount-1]);
			
				PriTrfRuleProgVO priTrfRuleProgVO = new PriTrfRuleProgVO();
				ObjectCloner.build(priTrfRuleVOs[rowCount-1], priTrfRuleProgVO);
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
}