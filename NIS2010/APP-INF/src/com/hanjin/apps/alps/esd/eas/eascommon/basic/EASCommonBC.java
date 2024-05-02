/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EASCommonBC.java
*@FileTitle : EAS_Common
*Open Issues :
*Change history :
*@LastModifyDate : 2015-05-13
*@LastModifier : Jong-Ock Kim
*@LastVersion : 1.0
* 2015-05-13 Jong-Ock Kim
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.eascommon.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.eas.eascommon.vo.EasCommonVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.syscommon.common.table.MdmVendorVO;
import com.hanjin.syscommon.common.table.MdmYardVO;

/**
 * ALPS-EASCommon Business Logic Command Interface<br>
 * - ALPS-EASCommon에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Jong-Ock Kim
 * @see Esd_Eas_CommonEventResponse 참조
 * @since J2EE 1.6
 */
public interface EASCommonBC { 

	/**
	 * 공통 : Yard에 Loc_cd 해당하는 Nod_code 조회<br>
	 *
	 * @param EasCommonVO easCommonVO
	 * @return List<EasCommonVO>
	 * @exception EventException
	 */
	public List<EasCommonVO> getYardLocCdNodCdList(EasCommonVO easCommonVO) throws EventException;
	

	/**
	 * 공통 : Yard에 기항하는 Lane 조회<br>
	 *
	 * @param EasCommonVO easCommonVO
	 * @return List<EasCommonVO>
	 * @exception EventException
	 */
	public List<EasCommonVO> getYardByLaneList(EasCommonVO easCommonVO) throws EventException;

	/**
	 * 공통 : Vessel Class에 기항하는 Vessel 조회<br>
	 *
	 * @param EasCommonVO easCommonVO
	 * @return List<EasCommonVO>
	 * @exception EventException
	 */
	public List<EasCommonVO> getVesselClassByVesselList(EasCommonVO easCommonVO) throws EventException;

	/**
	 * 공통 : Yard 정보 조회<br>
	 *
	 * @param EasCommonVO easCommonVO
	 * @return List<MdmYardVO>
	 * @exception EventException
	 */
	public List<MdmYardVO> getYardNameList(MdmYardVO mdmYardVO) throws EventException;
	
	/**
	 * 공통 : VENDOR 정보 조회<br>
	 *
	 * @param MdmVendorVO mdmVendorV
	 * @return List<MdmVendorVO>
	 * @exception EventException
	 */
	public List<MdmVendorVO> getVendorNameList(MdmVendorVO mdmVendorVO) throws EventException;
}