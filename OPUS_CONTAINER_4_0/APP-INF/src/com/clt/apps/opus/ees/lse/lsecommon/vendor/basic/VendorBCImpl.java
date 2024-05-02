/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LeaseTermBCImpl.java
*@FileTitle : Lease Term Search
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.lse.lsecommon.vendor.basic;

import java.util.List;

import com.clt.apps.opus.ees.lse.lsecommon.vendor.integration.VendorDBDAO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.syscommon.common.table.MdmVendorVO;

/**
 * LeaseTerm Business Logic Basic Command implementation<br>
 *
 * @author 
 * @see LeaseTermBC 
 * @since J2EE 1.4
 */

public class VendorBCImpl extends BasicCommandSupport implements VendorBC {

	// Database Access Object
	private transient VendorDBDAO dbDao = null;

	/**
	 * creating LeaseTermBCImpl object<br>
	 * creating LeaseTermDBDAO<br>
	 */
	public VendorBCImpl() {
		dbDao = new VendorDBDAO();
	}

	/**
	 * retrieving for Vendor<br>
	 * 
	 * @param String vndrSeq
	 * @return List<MdmVendorVO>
	 * @exception EventException
	 */
	public List<MdmVendorVO> searchVendorBasic(String vndrSeq) throws EventException {
		List<MdmVendorVO> list = null;
		try {
			list = dbDao.searchVendorData(vndrSeq);

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
	 * retrieving for Manufacturer Vendor code list<br>
	 * 
	 * @return List<MdmVendorVO>
	 * @exception EventException
	 */
	public List<MdmVendorVO> searchManufacturerVendorListBasic() throws EventException {
		List<MdmVendorVO> list = null;
		try {
			list = dbDao.searchManufacturerVendorListData();
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
}