/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChargeBCImpl.java
*@FileTitle : Charge Code Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.primasterdata.charge.basic;

import java.util.List;

import com.clt.apps.opus.esm.pri.primasterdata.charge.integration.ChargeDBDAO;
import com.clt.apps.opus.esm.pri.primasterdata.charge.vo.MdmChgVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * PRIMasterData Business Logic Command Interface<br>
 * - handling biz logic about PRIMasterData<br>
 *
 * @author 
 * @see Esm_pri_4025EventResponse,ChargeBC reference each DAO class 
 * @since J2EE 1.6
 */
public class ChargeBCImpl extends BasicCommandSupport implements ChargeBC {

	// Database Access Object
	private transient ChargeDBDAO dbDao = null;

	/**
	 * ChargeBCImpl object creation<br>
	 * creating ChargeDBDAO<br>
	 */
	public ChargeBCImpl() {
		dbDao = new ChargeDBDAO();
	}
	/**
	 * Retrieving Charge Code List<br>
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