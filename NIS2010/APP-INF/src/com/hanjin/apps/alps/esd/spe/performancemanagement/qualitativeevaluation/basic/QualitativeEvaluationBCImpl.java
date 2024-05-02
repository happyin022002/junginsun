/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : QualitativeEvaluationBCImpl.java
*@FileTitle : Qualitative Evaluation Sheet Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.09
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.02.09 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.performancemanagement.qualitativeevaluation.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esd.spe.performancemanagement.qualitativeevaluation.integration.QualitativeEvaluationDBDAO;
import com.hanjin.apps.alps.esd.spe.performancemanagement.qualitativeevaluation.vo.SpeQECreVO;
import com.hanjin.apps.alps.esd.spe.performancemanagement.qualitativeevaluation.vo.SpeSpQualEvVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-PerformanceManagement Business Logic Command Interface<br>
 * ALPS-PerformanceManagement에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author HI
 * @see
 * @since J2EE 1.6
 */
public class QualitativeEvaluationBCImpl extends BasicCommandSupport implements QualitativeEvaluationBC {

	// Database Access Object
	private transient QualitativeEvaluationDBDAO dbDao = null;

	/**
	 * QualitativeEvaluationBCImpl 객체 생성<br>
	 * QualitativeEvaluationDBDAO를 생성한다.<br>
	 */
	public QualitativeEvaluationBCImpl() {
		dbDao = new QualitativeEvaluationDBDAO();
	}
	
	/**
	 * QE 데이터를 입력/수정/삭제 한다.<br>
	 * 
	 * @param SpeQECreVO[] speQECreVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiQualitativeEvaluationCreation(SpeQECreVO[] speQECreVOs, SignOnUserAccount account) throws EventException {
		try {
			
			if(null != speQECreVOs){

				dbDao.removeQECre(speQECreVOs[0]);  // 삭제
				
				for(int i=0;i<speQECreVOs.length;i++){
					
					speQECreVOs[i].setCreUsrId(account.getUsr_id());				 
					speQECreVOs[i].setUpdUsrId(account.getUsr_id());
					speQECreVOs[i].setEvYr(speQECreVOs[0].getEvYr());
					speQECreVOs[i].setEvSvcCateCd(speQECreVOs[0].getEvSvcCateCd());

					dbDao.addQECre(speQECreVOs[i]);  // 저장
					
				}
			}
				
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * QE 데이터를 조회한다.<br>
	 * 
	 * @param SpeQECreVO speQECreVO
	 * @return List<SpeQECreVO>
	 * @exception EventException
	 */
	public List<SpeQECreVO> searchQualitativeEvaluationCreation(SpeQECreVO speQECreVO) throws EventException {
		try {
			return dbDao.searchQEData(speQECreVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}

	
	/**
	 * Qualitative Evaluation 목록 조회
	 * @param SpeSpQualEvVO speSpQualEvVO
	 * @param SignOnUserAccount account
	 * @return List<SpeSpQualEvVO>
	 * @throws EventException
	 */
	public List<SpeSpQualEvVO> searchQualitativeEvaluation(SpeSpQualEvVO speSpQualEvVO,SignOnUserAccount account) throws EventException {
		try {
				speSpQualEvVO.setCreUsrId(account.getUsr_id());
				speSpQualEvVO.setUpdUsrId(account.getUsr_id());  
				// 값이 0 이면 저장된적이 없는 데이터 이다.
				if(dbDao.searchQualitativeEvaluationChk(speSpQualEvVO).equals("0")){
					//Qualitative Evaluation 저장전 데이터 목록 조회
					return dbDao.searchQualitativeEvaluationOrg(speSpQualEvVO);
				}else{
					// Qualitative Evaluation 저장후 데이터 목록 조회
					return dbDao.searchQualitativeEvaluation(speSpQualEvVO);
					
				}
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
	}
	
	/**
	 * S/P Qualitative Evaulation Inquiry 조회
	 * @param SpeSpQualEvVO speSpQualEvVO
	 * @param SignOnUserAccount account
	 * @return List<SpeSpQualEvVO>
	 * @throws EventException
	 */
	public List<SpeSpQualEvVO> searchSPQualitativeEv(SpeSpQualEvVO speSpQualEvVO, SignOnUserAccount account) throws EventException {
		try {
			
			    speSpQualEvVO.setCreUsrId(account.getUsr_id());
 			    speSpQualEvVO.setUpdUsrId(account.getUsr_id());  
				return dbDao.searchSPQualitativeEv(speSpQualEvVO);
				
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
	}
	
	/**
	 * Qualitative Evaluation 을 수정한다.<br>
	 * @param SpeSpQualEvVO[] speSpQualEvVOs
	 * @param SignOnUserAccount account
	 * @return String
	 */
	@Override
	public String multiQualitativeEvaluation(SpeSpQualEvVO[] speSpQualEvVOs,SignOnUserAccount account) throws EventException {
		try {
			String saveAvgScore = "";
			if(null != speSpQualEvVOs){
				speSpQualEvVOs[0].setCreUsrId(account.getUsr_id());
				speSpQualEvVOs[0].setUpdUsrId(account.getUsr_id());  
				// 값이 0 이면 저장된적이 없는 데이터 이다.
				if(dbDao.searchQualitativeEvaluationChk(speSpQualEvVOs[0]).equals("0")){
					// 신규 데이터 INSERT 해야한다.
					
					dbDao.addQualitativeEvaluation(speSpQualEvVOs[0]);  // KPI Performance 저장					
				}
				
				
				for ( int i=0; i<speSpQualEvVOs .length; i++ ) {
					speSpQualEvVOs[i].setCreUsrId(account.getUsr_id());
					speSpQualEvVOs[i].setUpdUsrId(account.getUsr_id());
					dbDao.multiQualitativeEvaluation(speSpQualEvVOs[i]);//저장된 데이터 UPDATE 해야한다.
					
				}
				// 저장후 score 를 리턴한다.
				 saveAvgScore = dbDao.searchQualitativeEvaluationAvgScore(speSpQualEvVOs[0]);
			}
			
			
			return saveAvgScore;
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
}