/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LeaseTermBCImpl.java
*@FileTitle : Lease Term Search
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.27
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.04.27 노정용
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.lsecommon.vendor.basic;

import java.util.List;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.syscommon.common.table.MdmVendorVO;
import com.hanjin.apps.alps.ees.lse.lsecommon.vendor.integration.VendorDBDAO;

/**
 * ALPS-LeaseTerm Business Logic Basic Command implementation<br>
 * - ALPS-LeaseTerm 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Nho Jung Yong
 * @see LeaseTermBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class VendorBCImpl extends BasicCommandSupport implements VendorBC {

	// Database Access Object
	private transient VendorDBDAO dbDao = null;

	/**
	 * LeaseTermBCImpl 객체 생성<br>
	 * LeaseTermDBDAO를 생성한다.<br>
	 */
	public VendorBCImpl() {
		dbDao = new VendorDBDAO();
	}

	/**
	 * Vendor에 대한 데이타 모델목록을 조회합니다.<br>
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
	 * Manufacturer Vendor 코드목록을 조회합니다.<br>
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