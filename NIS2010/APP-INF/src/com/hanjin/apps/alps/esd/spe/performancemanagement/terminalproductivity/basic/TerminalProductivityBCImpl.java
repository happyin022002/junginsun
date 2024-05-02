/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : TerminalProductivityBCImpl.java
*@FileTitle : Terminal Productivity Target Input
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.09
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.02.09 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.performancemanagement.terminalproductivity.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.spe.performancemanagement.terminalproductivity.integration.TerminalProductivityDBDAO;
import com.hanjin.apps.alps.esd.spe.performancemanagement.terminalproductivity.vo.TmlProdTgtInpVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-PerformanceManagement Business Logic Command Interface<br>
 * - ALPS-PerformanceManagement에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author HI
 * @see
 * @since J2EE 1.6
 */
public class TerminalProductivityBCImpl extends BasicCommandSupport implements TerminalProductivityBC {

	// Database Access Object
	private transient TerminalProductivityDBDAO dbDao = null;

	/**
	 * TerminalProductivityBCImpl 객체 생성<br>
	 * TerminalProductivityDBDAO를 생성한다.<br>
	 */
	public TerminalProductivityBCImpl() {
		dbDao = new TerminalProductivityDBDAO();
	}



	/**
	 * Terminal Productivity Target Input 을 조회한다.<br>
	 * 
	 * @param TmlProdTgtInpVO	tmlProdTgtInpVO
	 * @return List<TmlProdTgtInpVO>
	 * @exception EventException
	 */
	public List<TmlProdTgtInpVO> selectTmlProdTgtInp(TmlProdTgtInpVO tmlProdTgtInpVO) throws EventException {
		try {
			return dbDao.selectTmlProdTgtInp(tmlProdTgtInpVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	/**
	 * Terminal Productivity 데이터를 입력/수정/삭제 한다.<br>
	 * 
	 * @param TmlProdTgtInpVO[]	tmlProdTgtInpVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiTmlProdTgtInp(TmlProdTgtInpVO[] tmlProdTgtInpVOs,SignOnUserAccount account) throws EventException {
		try {
			
			if(null != tmlProdTgtInpVOs){
				for(int i=0;i<tmlProdTgtInpVOs.length;i++){
					tmlProdTgtInpVOs[i].setCreUsrId(account.getUsr_id());				 
					tmlProdTgtInpVOs[i].setUpdUsrId(account.getUsr_id());

					if(tmlProdTgtInpVOs[i].getIbflag().equals("I")){
						dbDao.addEGTmlProdTgtInp(tmlProdTgtInpVOs[i]);  //  저장	
						
					}else if(tmlProdTgtInpVOs[i].getIbflag().equals("U")){
						
						if(tmlProdTgtInpVOs[i].getIsflag().equals("N")){
							dbDao.addEGTmlProdTgtInp(tmlProdTgtInpVOs[i]);  //  저장	
						}else{
							dbDao.modifyTmlProdTgtInp(tmlProdTgtInpVOs[i]);  // 수정							
						}
						
					}else if(tmlProdTgtInpVOs[i].getIbflag().equals("D")){
						dbDao.removeTmlProdTgtInp(tmlProdTgtInpVOs[i]);  // 삭제
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