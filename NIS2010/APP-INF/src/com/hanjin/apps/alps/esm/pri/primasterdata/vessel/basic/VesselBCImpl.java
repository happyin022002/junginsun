/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VesselBCImpl.java
*@FileTitle : Vessel Code Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.27
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.05.27 문동규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.primasterdata.vessel.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.primasterdata.vessel.integration.VesselDBDAO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.syscommon.common.table.MdmVslCntrVO;

/**
 * NIS2010-PRIMasterData Business Logic Basic Command implementation<br>
 * - NIS2010-PRIMasterData에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Moon Dong Gyu
 * @see ESM_PRI_4013EventResponse,VesselBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class VesselBCImpl extends BasicCommandSupport implements VesselBC {

	// Database Access Object
	private transient VesselDBDAO dbDao = null;

	/**
	 * VesselBCImpl 객체 생성<br>
	 * VesselDBDAO를 생성한다.<br>
	 */
	public VesselBCImpl() {
		dbDao = new VesselDBDAO();
	}
	/**
	 * Vessel Code 를 조회합니다.<br>
	 * 
	 * @param MdmVslCntrVO mdmVslCntrVO
	 * @return List<MdmVslCntrVO>
	 * @exception EventException
	 */
	public List<MdmVslCntrVO> searchVesselList(MdmVslCntrVO mdmVslCntrVO) throws EventException {
		try {
			return dbDao.searchVesselList(mdmVslCntrVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		}
	}
	
}