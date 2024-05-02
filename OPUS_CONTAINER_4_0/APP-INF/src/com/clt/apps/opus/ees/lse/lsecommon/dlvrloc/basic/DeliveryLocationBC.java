/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DlvrLocBC.java
*@FileTitle : Container Type/Size Search
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.27
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.04.27 노정용
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.lsecommon.dlvrloc.basic;

import java.util.List;

import com.clt.framework.core.layer.event.EventException;
import com.clt.syscommon.common.table.MdmEqOrzChtVO;
import com.clt.syscommon.common.table.MdmLocationVO;
import com.clt.syscommon.common.table.MdmYardVO;

/**
 * DlvrLoc Business Logic Command Interface<br>
 * DlvrLoc에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Nho Jung Yong
 * @see
 * @since J2EE 1.4
 */

public interface DeliveryLocationBC {

	/**
	 * Delivery Location 코드목록을 조회합니다.<br>
	 *
	 * @param String locCd
	 * @return List<MdmLocationVO>
	 * @exception EventException
	 */
	public List<MdmLocationVO> searchDeliveryLocationBrieflyBasic(String locCd) throws EventException;

	/**
	 * 유형별 Delivery Location 코드목록을 조회합니다.<br>
	 *
	 * @param String locCd
	 * @param String locTp
	 * @return List<MdmEqOrzChtVO>
	 * @exception EventException
	 */
	public List<MdmEqOrzChtVO> searchLocationBrieflyBasic(String locCd, String locTp) throws EventException;
	
	/**
	 * 유형별 Delivery Location 코드목록을 조회합니다.<br>
	 *
	 * @param String locCd
	 * @param String locTp
	 * @param String sheetIdx
	 * @return List<MdmEqOrzChtVO>
	 * @exception EventException
	 */
	public List<MdmEqOrzChtVO> searchLocationBasic(String locCd, String locTp, String sheetIdx) throws EventException;

	/**
	 * Delivery Location - RCC 코드목록을 조회합니다.<br>
	 *
	 * @return List<MdmEqOrzChtVO>
	 * @exception EventException
	 */
	public List<MdmEqOrzChtVO> searchDeliveryLocationRCCListBasic() throws EventException;

	/**
	 * Delivery Location - Country 코드목록을 조회합니다.<br>
	 *
	 * @param String locCd
	 * @return List<MdmLocationVO>
	 * @exception EventException
	 */
	public List<MdmLocationVO> searchDeliveryLocationCountryBasic(String locCd) throws EventException;

	/**
	 * Delivery Location - Off-Hire Yard 코드목록을 조회합니다.<br>
	 *
	 * @param String ydCd
	 * @return List<MdmYardVO>
	 * @exception EventException
	 */
	public List<MdmYardVO> searchOffHireYardListBasic(String ydCd) throws EventException;
}