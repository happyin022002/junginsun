/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : AwkwardCargoCommonBCImpl.java
*@FileTitle :  TES의 Awkward Cargo 공용 작업
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 2013-03-21 
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargocommon.basic;

import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

import com.hanjin.apps.alps.esd.tes.specialcargoquotationmanage.awkwardcargocommon.integration.AwkwardCargoCommonDBDAO;

import com.hanjin.syscommon.common.table.TesAwkCgoErrLogVO;

/**
 * ALPS-ESD Business Logic Basic Command implementation<br>
 * - ALPS-ESD에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author 
 * @see AwkwardCargoCommonBCImpl 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class AwkwardCargoCommonBCImpl extends BasicCommandSupport implements AwkwardCargoCommonBC {

	/**
	 * 공통 CSR의 Approval Step I/F 처리용 DBDAO
	 */
	private transient AwkwardCargoCommonDBDAO awkCgoCommDbDao = null;
	
	public AwkwardCargoCommonBCImpl(){
		this.awkCgoCommDbDao = new AwkwardCargoCommonDBDAO();
	}

	/**
	 * Awk Cargo 공통 Error 남기기
	 * @param actCostErrLogVO
	 * @throws EventException
	 */
	public void logAwkCgoCommErrMsg(TesAwkCgoErrLogVO actCostErrLogVO) throws EventException {
		log.debug("\n  ActualCostCalcManageBCImpl - logAwkCgoCommErrMsg~~~~~BBBB \n");
		
		try {
			awkCgoCommDbDao.logAwkCgoCommErrMsg(actCostErrLogVO);
		} catch(DAOException ex){
			ex.getMessage();
			throw new EventException(ex.getMessage());
		} catch(Exception ex){
			ex.getMessage();
			throw new EventException(ex.getMessage());
		}
		log.debug("\n  ActualCostCalcManageBCImpl - logAwkCgoCommErrMsg~~~~~EEEE \n");
	}
	
	/**
	 * ESD 업무 시나리오 마감작업<br>
	 * ActualCostCalcManageBCImpl 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		awkCgoCommDbDao = null;
	}
}