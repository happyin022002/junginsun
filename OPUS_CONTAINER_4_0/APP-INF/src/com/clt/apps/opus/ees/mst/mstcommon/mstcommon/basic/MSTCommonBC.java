/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MSTCommonBC.java
*@FileTitle : MST COMMON PAGE
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.mst.mstcommon.mstcommon.basic;

import java.util.List;

import com.clt.apps.opus.ees.mst.mstcommon.mstcommon.vo.AgmtInfoVO;
import com.clt.apps.opus.ees.mst.mstcommon.mstcommon.vo.CommonListVO;
import com.clt.apps.opus.ees.mst.mstcommon.mstcommon.vo.GeneralCodeSearchGRPVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * Mstcommon Business Logic Command Interface<br>
 *
 * @author
 * @see Mst_comEventResponse 
 * @since J2EE 1.6
 */

public interface MSTCommonBC {
	/**
	 * retrieving for Manufacturer List<br>
	 * 
	 * @param CommonListVO commonListVO
	 * @return List<CommonListVO>
	 * @exception EventException
	 */
	public List<CommonListVO> searchManufacturerListBasic(CommonListVO commonListVO) throws EventException;
	/**                       
	 * retrieving for Eq Type Size List<br>
	 * 
	 * @param CommonListVO commonListVO
	 * @return List<CommonListVO>
	 * @exception EventException
	 */
	public List<CommonListVO> searchEqTypeSizeListBasic(CommonListVO commonListVO) throws EventException;
	/**                       
	 * retrieving for Manufacture Place List<br>
	 * 
	 * @param CommonListVO commonListVO
	 * @return List<CommonListVO>
	 * @exception EventException
	 */	
	public List<CommonListVO> searchManufacturePlaceListBasic(CommonListVO commonListVO) throws EventException;

	/**
	 * EES_MST_0014 : retrieve<br>
	 * retrieving for Lease Agreement List<br>
	 * 
	 * @param AgmtInfoVO agmtInfoVO
	 * @return List<AgmtInfoVO>
	 * @exception EventException
	 */
	public List<AgmtInfoVO> searchAgmtBasic(AgmtInfoVO agmtInfoVO) throws EventException;
	
	/**
	 * EES_MST_0014, EES_MST_0024 : retrieve<br>
	 * retrieving for MSTCommon<br>
	 * @param CommonListVO   commonListVO
	 * @return CommonListVO
	 * @exception EventException
	 */		
	public CommonListVO searchYardCodeBasic(CommonListVO commonListVO) throws EventException;
	
	/**
	 * retrieving for Lessor code name<br>
	 * 
	 * @param CommonListVO   commonListVO
	 * @return String
	 * @exception EventException
	 */		
	public String searchLessorCodeBasic(CommonListVO commonListVO) throws EventException;
	
	/**
	 * EES_MST_0016 : retrieve<br>
	 * retrieving for Reefer Type Code<br>
	 * @return List<CommonListVO>
	 * @exception EventException
	 */	
	public List<CommonListVO> searchReeferTypeCodeListBasic() throws EventException;
	
	 
	/**
	 * EES_MST_0016 : retrieve<br>
	 * retrieving for Humidity Control Code<br>
	 * @return List<CommonListVO>
	 * @exception EventException
	 */	
	public List<CommonListVO> searchHumidityControlCodeListBasic() throws EventException;
	
	/**
	 * retrieving for COM_INTG_CD<br>
	 * @param String   intgCdId
	 * @param String   intgCdVal
	 * @return List<CommonListVO>
	 * @exception EventException
	 */	
	public List<CommonListVO> searchComIntgCdListBasic(String intgCdId, String intgCdVal) throws EventException;
	
	/**
	 * EDI msssage Send.<br>
	 * @param String   flatFile
	 * @return String
	 * @exception EventException
	 */	
	public String sendEdiToFleet(String flatFile) throws EventException;
	

	/**
	 * EDI EquipmentFleetInfo Send.<br>
	 * @param String   flatFile
	 * @return String
	 * @exception EventException
	 */	
	public String sendEquipmentFleetInfo(String flatFile) throws EventException;
	
	/**
	 * [MNR_COMMON] retrieving common combo.<br>
	 * 
	 * @param GeneralCodeSearchGRPVO generalCodeSearchGRPVO
	 * @param SignOnUserAccount 	 account
	 * @return GeneralCodeSearchGRPVO 
	 * @exception EventException
	 */  
	public GeneralCodeSearchGRPVO searchComboInitDataListBasic(GeneralCodeSearchGRPVO generalCodeSearchGRPVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * retrieving for USER_INFO_SEARCH<br>
	 * @param String   inputUser
	 * @return String
	 * @exception EventException
	 */	
	public String searchUserInfoBasic(String inputUser) throws EventException;
	
	
	/**
	 * retrieving for SAKURA INFO<br>
	 * @return List<CommonListVO>
	 * @exception EventException
	 */	
	public List<CommonListVO> searchSakuraCdListBasic() throws EventException;
	
}