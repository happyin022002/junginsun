/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChassisMovementHistoryBCImpl.java
*@FileTitle : test
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.03
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.06.03 최민회
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.movementmnrhistory.mgsetmovementhistory.basic;

import java.util.List;

import com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismovementhistory.integration.ChassisMovementHistoryDBDAO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CusCtmMovementVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.layer.backend.BackEndCommandSupport;

/**
 * OPUS-MovementMnrHistory Business Logic Basic Command implementation<br>
 * - OPUS-MovementMnrHistory에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author CHOI MIN HOI
 * @see testEventResponse,ChassisMovementHistoryBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class MgsetMovementHistoryMGSMovementByCtmBackEndJob extends BackEndCommandSupport {
	
	private static final long serialVersionUID = -8569053557386320221L;
	// Database Access Object
	private transient ChassisMovementHistoryDBDAO dbDao = null;


 

	private List<CusCtmMovementVO>  cusCtmMovementVOs; 

	/**
	 * ChassisMovementHistoryBCImpl 객체 생성<br>
	 * ChassisMovementHistoryDBDAO를 생성한다.<br>
	 */
	public MgsetMovementHistoryMGSMovementByCtmBackEndJob() {
		dbDao = new ChassisMovementHistoryDBDAO();
	}
	
	/**
	 * Chassis Movement 를 수정하는 오퍼레이션 BackEndJob Start
	 * @return List<CusCtmMovementVO>
	 * @throws Exception
	 */
	public String doStart() throws Exception {
		log.debug("manageCHSMovementByCtmBasic==BackEndJob  doStart ");
		String result = "";
		MgsetMovementHistoryBC command = new MgsetMovementHistoryBCImpl();
		try {
			command.manageMGSMovementByCtmBatchBasic(this.cusCtmMovementVOs);
	    } catch (Exception e) {
	        log.error("err " + e.toString(), e);
	        throw new EventException(new ErrorHandler("CTM00001", new String[] {}).getMessage());
	    }
		return result;
	}
	
	/**
	 * 다운로드 할 데이터 세팅
	 * 
	 * CusCtmMovementVO
	 */
	public void setSearchEDIErrorVO(List<CusCtmMovementVO>  cusCtmMovementVOs) {
		this.cusCtmMovementVOs = cusCtmMovementVOs;
	}
	
}