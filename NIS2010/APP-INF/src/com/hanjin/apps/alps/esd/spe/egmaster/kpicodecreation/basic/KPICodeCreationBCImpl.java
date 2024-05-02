/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : KPICodeCreationBCImpl.java
*@FileTitle : KPI Code Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.09
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.02.09 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.egmaster.kpicodecreation.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.spe.egmaster.kpicodecreation.integration.KPICodeCreationDBDAO;
import com.hanjin.apps.alps.esd.spe.egmaster.kpicodecreation.vo.KPICodeCreVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-EGMaster Business Logic Command Interface<br>
 * - ALPS-EGMaster에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author HI
 * @see
 * @since J2EE 1.6
 */
public class KPICodeCreationBCImpl extends BasicCommandSupport implements KPICodeCreationBC {

	// Database Access Object
	private transient KPICodeCreationDBDAO dbDao = null;

	/**
	 * KPICodeCreationBCImpl 객체 생성<br>
	 * KPICodeCreationDBDAO를 생성한다.<br>
	 */
	public KPICodeCreationBCImpl() {
		dbDao = new KPICodeCreationDBDAO();
	}


	/**
	 * KPI Code Creation 데이터를 입력/수정/삭제 한다.<br>
	 * 
	 * @param KPICodeCreVO[] kpiCodeCreVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiKPICodeCre(KPICodeCreVO[] kpiCodeCreVOs,SignOnUserAccount account) throws EventException {
		try {
			
			if(null != kpiCodeCreVOs){
				for(int i=0;i<kpiCodeCreVOs.length;i++){
					kpiCodeCreVOs[i].setCreUsrId(account.getUsr_id());				 
					kpiCodeCreVOs[i].setUpdUsrId(account.getUsr_id());				 
					if(kpiCodeCreVOs[i].getIbflag().equals("I")){
						dbDao.addKPICodeCre(kpiCodeCreVOs[i]);  // 저장
					}else if(kpiCodeCreVOs[i].getIbflag().equals("U")){
						dbDao.modifyKPICodeCre(kpiCodeCreVOs[i]);  // 수정
					}else if(kpiCodeCreVOs[i].getIbflag().equals("D")){
						dbDao.removeKPICodeCre(kpiCodeCreVOs[i]);  // 삭제
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
	 * KPI Code Creation 데이터를 조회한다.<br>
	 * 
	 * @param KPICodeCreVO kpiCodeCreVO
	 * @return List<KPICodeCreVO> 
	 * @exception EventException
	 */
	public List<KPICodeCreVO> searchKPICodeCre(KPICodeCreVO kpiCodeCreVO) throws EventException {
		try {
			return dbDao.searchKPICodeCre(kpiCodeCreVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}		
	}		
	
}