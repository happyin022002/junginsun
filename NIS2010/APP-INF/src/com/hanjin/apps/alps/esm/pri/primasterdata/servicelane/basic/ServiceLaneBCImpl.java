/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ServiceLaneBCImpl.java
*@FileTitle : Lane Code Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.26
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.05.26 문동규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.primasterdata.servicelane.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.primasterdata.servicelane.integration.ServiceLaneDBDAO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.syscommon.common.table.MdmVslSvcLaneVO;

/**
 * NIS2010-PRIMasterData Business Logic Basic Command implementation<br>
 * - NIS2010-PRIMasterData에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Moon Dong Gyu
 * @see ESM_PRI_4012EventResponse,ServiceLaneBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class ServiceLaneBCImpl extends BasicCommandSupport implements ServiceLaneBC {

	// Database Access Object
	private transient ServiceLaneDBDAO dbDao = null;

	/**
	 * ServiceLaneBCImpl 객체 생성<br>
	 * ServiceLaneDBDAO를 생성한다.<br>
	 */
	public ServiceLaneBCImpl() {
		dbDao = new ServiceLaneDBDAO();
	}
	/**
	 * Lane Code 를 조회합니다.<br>
	 * 
	 * @param MdmVslSvcLaneVO mdmVslSvcLaneVO
	 * @return List<MdmVslSvcLaneVO>
	 * @exception EventException
	 */
	public List<MdmVslSvcLaneVO> searchServiceLaneList(MdmVslSvcLaneVO mdmVslSvcLaneVO) throws EventException {
		try {
			return dbDao.searchServiceLaneList(mdmVslSvcLaneVO);
		} catch (DAOException ex) {
		    throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
		    throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}
	
}