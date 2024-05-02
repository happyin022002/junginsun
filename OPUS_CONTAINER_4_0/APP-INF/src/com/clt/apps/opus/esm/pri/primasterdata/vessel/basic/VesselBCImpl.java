/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VesselBCImpl.java
*@FileTitle : Vessel Code Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.primasterdata.vessel.basic;

import java.util.List;

import com.clt.apps.opus.esm.pri.primasterdata.vessel.integration.VesselDBDAO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.syscommon.common.table.MdmVslCntrVO;

/**
 * PRIMasterData Business Logic Basic Command implementation<br>
 *
 * @author 
 * @see ESM_PRI_4013EventResponse,VesselBC - refer to each DAO clas
 * @since J2EE 1.6
 */
public class VesselBCImpl extends BasicCommandSupport implements VesselBC {

	// Database Access Object
	private transient VesselDBDAO dbDao = null;

	/**
	 * Creating VesselBCImpl object<br>
	 * CreatingVesselDBDAO<br>
	 */
	public VesselBCImpl() {
		dbDao = new VesselDBDAO();
	}
	/**
	 * Retrieving Vessel Code<br>
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