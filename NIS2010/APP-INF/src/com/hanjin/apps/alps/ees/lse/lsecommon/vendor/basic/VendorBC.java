/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LeaseTermBC.java
*@FileTitle : Agreement No. Selection
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
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.syscommon.common.table.MdmVendorVO;

/**
 * ALPS-LeaseTerm Business Logic Command Interface<br>
 * - ALPS-LeaseTerm에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Nho Jung Yong
 * @see Ui_lse_0091EventResponse 참조
 * @since J2EE 1.4
 */

public interface VendorBC {

	/**
	 * Vendor에 대한 데이타 모델목록을 조회합니다.<br>
	 * 
	 * @param String vndrSeq
	 * @return List<MdmVendorVO>
	 * @exception EventException
	 */
	public List<MdmVendorVO> searchVendorBasic(String vndrSeq) throws EventException;
	
	/**
	 * Manufacturer Vendor 코드목록을 조회합니다.<br>
	 *  
	 * @return List<MdmVendorVO>
	 * @exception EventException
	 */
	public List<MdmVendorVO> searchManufacturerVendorListBasic() throws EventException;
}