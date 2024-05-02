/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LeaseTermBC.java
*@FileTitle : Agreement No. Selection
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.lse.lsecommon.vendor.basic;

import java.util.List;

import com.clt.framework.core.layer.event.EventException;
import com.clt.syscommon.common.table.MdmVendorVO;

/**
 * LeaseTerm Business Logic Command Interface<br>
 *
 * @author 
 * @see Ui_lse_0091EventResponse
 * @since J2EE 1.4
 */

public interface VendorBC {

	/**
	 * retrieving for Vendor<br>
	 * 
	 * @param String vndrSeq
	 * @return List<MdmVendorVO>
	 * @exception EventException
	 */
	public List<MdmVendorVO> searchVendorBasic(String vndrSeq) throws EventException;
	
	/**
   * retrieving for Manufacturer Vendor code list<br>
	 *  
	 * @return List<MdmVendorVO>
	 * @exception EventException
	 */
	public List<MdmVendorVO> searchManufacturerVendorListBasic() throws EventException;
}