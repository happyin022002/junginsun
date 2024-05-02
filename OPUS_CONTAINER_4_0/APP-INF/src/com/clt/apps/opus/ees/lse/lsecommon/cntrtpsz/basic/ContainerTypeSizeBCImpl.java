/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrTpSzBCImpl.java
*@FileTitle : Container Type/Size Search
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 
=========================================================*/
package com.clt.apps.opus.ees.lse.lsecommon.cntrtpsz.basic;

import java.util.List;

import com.clt.apps.opus.ees.lse.lsecommon.cntrtpsz.integration.ContainerTypeSizeDBDAO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.syscommon.common.table.MdmCntrTpSzVO;

/**
 * CntrTpSz Business Logic Basic Command implementation<br>
 * - Handling a business transaction about CntrTpSz<br>
 *
 * @author
 * @see ContainerTypeSizeBC - refer to each DAO class
 * @since J2EE 1.4
 */

public class ContainerTypeSizeBCImpl extends BasicCommandSupport implements ContainerTypeSizeBC {

	// Database Access Object
	private transient ContainerTypeSizeDBDAO dbDao = null;

	/**
	 * Creating CntrTpSzBCImpl object<br>
	 * Creating CntrTpSzDBDAO<br>
	 */
	public ContainerTypeSizeBCImpl() {
		dbDao = new ContainerTypeSizeDBDAO();
	}

	/**
	 * Retrieving list for Container Type/Size<br>
	 *
	 * @return List<MdmCntrTpSzVO>
	 * @exception EventException
	 */
	public List<MdmCntrTpSzVO> searchCntrTpSzListBasic() throws EventException {
		List<MdmCntrTpSzVO> list = null;
		try {
			list = dbDao.searchContainerTypeSizeListData();

			if ( list.size() < 1 ) {
				throw new EventException(new ErrorHandler("LSE01048").getMessage());
			}
		} catch (EventException ex) {
			throw ex;
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return list;
	}

	/**
	 * Retrieving variable header for Container Type Size<br>
	 *
	 * @return String
	 * @exception EventException
	 */
	public String searchContainerTypeSizeDynamicHeaderBasic() throws EventException {
		String cntrTpszHd = null;

		try {
			cntrTpszHd = dbDao.searchContainerTypeSizeDynamicHeaderData();
			if ( cntrTpszHd == null ) {
				throw new EventException(new ErrorHandler("LSE01048").getMessage());
			}
		} catch (EventException ex) {
			throw ex;
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return cntrTpszHd;
	}
}