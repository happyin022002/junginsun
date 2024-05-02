/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EvaluationGroupBCImpl.java
*@FileTitle : Evaluation Group Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.09
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.02.09 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.egmaster.evaluationgroup.basic;

import java.util.ArrayList;
import java.util.List;
import com.hanjin.apps.alps.esd.spe.egmaster.evaluationgroup.integration.EvaluationGroupDBDAO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.apps.alps.esd.spe.egmaster.evaluationgroup.vo.SpeEGCreVO;

/**
 * ALPS-EGMaster Business Logic Command Interface<br>
 * ALPS-EGMaster에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author HI
 * @see
 * @since J2EE 1.6
 */
public class EvaluationGroupBCImpl extends BasicCommandSupport implements EvaluationGroupBC {

	// Database Access Object
	private transient EvaluationGroupDBDAO dbDao = null;

	/**
	 * EvaluationGroupBCImpl 객체 생성<br>
	 * EvaluationGroupDBDAO를 생성한다.<br>
	 */
	public EvaluationGroupBCImpl() {
		dbDao = new EvaluationGroupDBDAO();
	}


	/**
	 * EG 데이터를 입력/수정/삭제 한다.<br>
	 * 
	 * @param SpeEGCreVO[] speEGCreVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiEGCre(SpeEGCreVO[] speEGCreVOs,SignOnUserAccount account) throws EventException {
		try {
			
			if(null != speEGCreVOs){
				for(int i=0;i<speEGCreVOs.length;i++){
					speEGCreVOs[i].setCreUsrId(account.getUsr_id());				 
					speEGCreVOs[i].setUpdUsrId(account.getUsr_id());				 
					if(speEGCreVOs[i].getIbflag().equals("I")){
						dbDao.addEGCre(speEGCreVOs[i]);  // 저장
					}else if(speEGCreVOs[i].getIbflag().equals("U")){
						dbDao.modifyEGCre(speEGCreVOs[i]);  // 수정
					}else if(speEGCreVOs[i].getIbflag().equals("D")){
						dbDao.removeEGCre(speEGCreVOs[i]);  // 삭제
					}
				}
			}
				
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	
	
	/**
	 * EG 데이터를 조회한다.<br>
	 * 
	 * @param SpeEGCreVO speEGCreVO
	 * @return List<SpeEGCreVO>
	 * @exception EventException
	 */
	public List<SpeEGCreVO> searchEGData(SpeEGCreVO speEGCreVO) throws EventException {
		try {
			return dbDao.searchEGData(speEGCreVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	/**
	 * 저장전 저장할수 있는 데이터 인지 확인한다..<br>
	 * 
	 * @param SpeEGCreVO speEGCreVO
	 * @return List<SpeEGCreVO>
	 * @exception EventException
	 */
	public List<SpeEGCreVO> searchEGDataChk(SpeEGCreVO speEGCreVO) throws EventException {
		try {
			return dbDao.searchEGDataChk(speEGCreVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}	
	
}