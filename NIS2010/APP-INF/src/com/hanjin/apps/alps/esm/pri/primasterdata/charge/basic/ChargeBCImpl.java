/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChargeBCImpl.java
*@FileTitle : Charge Code Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.25
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.08.25 김재연
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.primasterdata.charge.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.primasterdata.charge.integration.ChargeDBDAO;
import com.hanjin.apps.alps.esm.pri.primasterdata.charge.vo.MdmChgVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * ALPS-PRIMasterData Business Logic Command Interface<br>
 * - ALPS-PRIMasterData에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author JaeYeon Kim
 * @see Esm_pri_4025EventResponse,ChargeBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class ChargeBCImpl extends BasicCommandSupport implements ChargeBC {

	// Database Access Object
	private transient ChargeDBDAO dbDao = null;

	/**
	 * ChargeBCImpl 객체 생성<br>
	 * ChargeDBDAO를 생성한다.<br>
	 */
	public ChargeBCImpl() {
		dbDao = new ChargeDBDAO();
	}
	/**
	 * Charge Code List를 조회합니다.<br>
	 * 
	 * @param MdmChgVO	mdmChgVO
	 * @return List<MdmChgVO>
	 * @exception EventException
	 */
	public List<MdmChgVO> searchChargeList(MdmChgVO mdmChgVO) throws EventException {
		try {
			return dbDao.searchChargeList(mdmChgVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		}
		
	}
	
}