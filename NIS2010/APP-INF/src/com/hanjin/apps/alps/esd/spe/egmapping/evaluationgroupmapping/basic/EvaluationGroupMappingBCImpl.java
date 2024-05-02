/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EvaluationGroupMappingBCImpl.java
*@FileTitle : Evaluation Group Mapping & Basic Evaluation
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.09
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.02.09 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.egmapping.evaluationgroupmapping.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.spe.egmapping.egandevaluator.vo.SpeEGEVMappingVO;
import com.hanjin.apps.alps.esd.spe.egmapping.evaluationgroupmapping.integration.EvaluationGroupMappingDBDAO;
import com.hanjin.apps.alps.esd.spe.egmapping.evaluationgroupmapping.vo.EGAndBEMappingVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-EGMapping Business Logic Command Interface<br>
 * - ALPS-EGMapping에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author HI
 * @see
 * @since J2EE 1.6
 */
public class EvaluationGroupMappingBCImpl extends BasicCommandSupport implements EvaluationGroupMappingBC {

	// Database Access Object
	private transient EvaluationGroupMappingDBDAO dbDao = null;

	/**
	 * EvaluationGroupMappingBCImpl 객체 생성<br>
	 * EvaluationGroupMappingDBDAO를 생성한다.<br>
	 */
	public EvaluationGroupMappingBCImpl() {
		dbDao = new EvaluationGroupMappingDBDAO();
	}

	/**
	 * Evaluation Group Mapping & Basic Evaluation 화면을 조회한다.<br>
	 * 
	 * @param EGAndBEMappingVO	egAndBEMappingVO
	 * @return List<EGAndBEMappingVO>
	 * @exception EventException
	 */
	public List<EGAndBEMappingVO> searchEGBEMapping(EGAndBEMappingVO egAndBEMappingVO) throws EventException {
		try {
			return dbDao.searchEGBEMapping(egAndBEMappingVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	/**
	 * Basic Evaluation 데이터가 저장가능 한지 확인한다.<br>
	 * 
	 * @param EGAndBEMappingVO	egAndBEMappingVO
	 * @return List<EGAndBEMappingVO>
	 * @exception EventException
	 */
	public List<EGAndBEMappingVO> searchEGBEMappingChk(EGAndBEMappingVO egAndBEMappingVO) throws EventException {
		try {
			return dbDao.searchEGBEMappingChk(egAndBEMappingVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	/**
	 * Basic Evaluation 데이터를 조회한다.<br>
	 * 
	 * @param EGAndBEMappingVO	egAndBEMappingVO
	 * @return List<EGAndBEMappingVO>
	 * @exception EventException
	 */
	public List<EGAndBEMappingVO> searchBECode(EGAndBEMappingVO egAndBEMappingVO) throws EventException {
		try {
			return dbDao.searchBECode(egAndBEMappingVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	
	/**
	 * Basic Evaluation 데이터를 입력/수정/삭제 한다.<br>
	 * 
	 * @param EGAndBEMappingVO[] egAndBEMappingVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiEGBEMapping(EGAndBEMappingVO[] egAndBEMappingVOs,SignOnUserAccount account)  throws EventException {
		try {
			
			if(null != egAndBEMappingVOs){
				for(int i=0;i<egAndBEMappingVOs.length;i++){
					egAndBEMappingVOs[i].setCreUsrId(account.getUsr_id());				 
					egAndBEMappingVOs[i].setUpdUsrId(account.getUsr_id());
					egAndBEMappingVOs[i].setEvrUsrId(account.getUsr_id());;
				
					if(egAndBEMappingVOs[i].getIbflag().equals("I")){
						dbDao.addEGBEMapping(egAndBEMappingVOs[i]);  // 저장							
						
					}else if(egAndBEMappingVOs[i].getIbflag().equals("U")){
						dbDao.modifyEGBEMapping(egAndBEMappingVOs[i]);  // 수정							
						
					}else if(egAndBEMappingVOs[i].getIbflag().equals("D")){
						dbDao.removeEGBEMapping(egAndBEMappingVOs[i]);  // 삭제
					}
				}
			}
				
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}		
	
}