/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EGandEvaluatorBCImpl.java
*@FileTitle : EG vs Evaluator Mapping
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.09
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.02.09 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.egmapping.egandevaluator.basic;

import java.util.ArrayList;
import java.util.List;
import com.hanjin.apps.alps.esd.spe.egmapping.egandevaluator.integration.EGandEvaluatorDBDAO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.apps.alps.esd.spe.egmapping.egandevaluator.vo.SpeEGEVMappingVO;

/**
 * ALPS-EGMapping Business Logic Command Interface<br>
 * ALPS-EGMapping에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author HI
 * @see
 * @since J2EE 1.6
 */
public class EGandEvaluatorBCImpl extends BasicCommandSupport implements EGandEvaluatorBC {

	// Database Access Object
	private transient EGandEvaluatorDBDAO dbDao = null;

	/**
	 * EGandEvaluatorBCImpl 객체 생성<br>
	 * EGandEvaluatorDBDAO를 생성한다.<br>
	 */
	public EGandEvaluatorBCImpl() {
		dbDao = new EGandEvaluatorDBDAO();
	}


	/**
	 * Basic Evaluator 를 조회한다..<br>
	 * 
	 * @param SpeEGEVMappingVO SpeEGEVMappingVO
	 * @return List<SpeEGEVMappingVO>
	 * @exception EventException
	 */
	public List<SpeEGEVMappingVO> searchEGEVBasic(SpeEGEVMappingVO speEGEVMappingVO)throws EventException {
		try {
			return dbDao.searchEGEVBasic(speEGEVMappingVO);
		} catch(DAOException ex) {
 			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}		
	}		
	
	/**
	 * KPI Code Creation 데이터를 조회한다.<br>
	 * 
	 * @param SpeEGEVMappingVO SpeEGEVMappingVO
	 * @return List<SpeEGEVMappingVO>
	 * @exception EventException
	 */
	public List<SpeEGEVMappingVO> searchEGEVPerformance(SpeEGEVMappingVO speEGEVMappingVO)throws EventException {
		try {
			return dbDao.searchEGEVPerformance(speEGEVMappingVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}		
	}		
	
	
	/**
	 * EG vs Evalulator Mapping 데이터를 입력/수정/삭제 한다.<br>
	 * 
	 * @param SpeEGEVMappingVO[] speEGEVMappingVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiEGEVMapping(SpeEGEVMappingVO[] speEGEVMappingVOs,SignOnUserAccount account)  throws EventException {
		try {
			
			if(null != speEGEVMappingVOs){
				for(int i=0;i<speEGEVMappingVOs.length;i++){
					String chk = "";
					speEGEVMappingVOs[i].setCreUsrId(account.getUsr_id());				 
					speEGEVMappingVOs[i].setUpdUsrId(account.getUsr_id());
					// Basic Evaluator ID 를 조회 하여 기 입력된 데이터 인지 확인한다.
					// 기입력된 데이터라면 Performance Evaluator ID 만 입력한다.
					chk = dbDao.searchEGEVMChking(speEGEVMappingVOs[i]);
					if(speEGEVMappingVOs[i].getIbflag().equals("I")){
						if(speEGEVMappingVOs[i].getEvKndCd().equals("B")){
							speEGEVMappingVOs[i].setEvrUsrId(speEGEVMappingVOs[i].getBzcEvrUsrId());
							dbDao.addEGEVMapping(speEGEVMappingVOs[i]);  // 저장
						}else {
							speEGEVMappingVOs[i].setEvrUsrId(speEGEVMappingVOs[i].getPerEvrUsrId());
							dbDao.addEGEVMapping(speEGEVMappingVOs[i]);  // 저장							
						}
						speEGEVMappingVOs[i].setDeltFlg("N");
						dbDao.addEGEVMappingHis(speEGEVMappingVOs[i]);  // History 저장	
						
					}else if(speEGEVMappingVOs[i].getIbflag().equals("U")){
						if(speEGEVMappingVOs[i].getEvKndCd().equals("B")){							
							speEGEVMappingVOs[i].setEvrUsrId(speEGEVMappingVOs[i].getBzcEvrUsrId());
							
							if(speEGEVMappingVOs[i].getIsinput().equals("I")){
								dbDao.addEGEVMapping(speEGEVMappingVOs[i]);  // 저장	
							}else{
								dbDao.modifyEGEVMapping(speEGEVMappingVOs[i]);  // 수정
							}
						}else {
							speEGEVMappingVOs[i].setEvrUsrId(speEGEVMappingVOs[i].getPerEvrUsrId());
							dbDao.modifyEGEVMapping(speEGEVMappingVOs[i]);  // 수정							
						}
						speEGEVMappingVOs[i].setDeltFlg("N");
						dbDao.addEGEVMappingHis(speEGEVMappingVOs[i]);  // History 저장	
						
					}else if(speEGEVMappingVOs[i].getIbflag().equals("D")){
						dbDao.removeEGEVMapping(speEGEVMappingVOs[i]);  // 삭제
						speEGEVMappingVOs[i].setDeltFlg("Y");
						speEGEVMappingVOs[i].setEvrUsrId(speEGEVMappingVOs[i].getPerEvrUsrId());
						dbDao.addEGEVMappingHis(speEGEVMappingVOs[i]);  // History 저장	
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