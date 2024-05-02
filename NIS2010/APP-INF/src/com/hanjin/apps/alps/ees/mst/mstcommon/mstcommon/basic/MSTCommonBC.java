/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MSTCommonBC.java
*@FileTitle : MST COMMON PAGE
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.27
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.06.18 이호선
* 1.0 Creation
*  
* History
* 2010.12.27 진마리아 [CHM-201007809-01] OWN CNTR Creation화면에서 Unit Type에 DF/UF추가 및 Full Name 표기
=========================================================*/
package com.hanjin.apps.alps.ees.mst.mstcommon.mstcommon.basic;

import java.util.List;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.apps.alps.ees.mst.mstcommon.mstcommon.vo.AgmtInfoVO;
import com.hanjin.apps.alps.ees.mst.mstcommon.mstcommon.vo.CommonListVO;

/**
 * ALPS-Mstcommon Business Logic Command Interface<br>
 * - ALPS-Mstcommon에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Lee Ho Sun
 * @see Mst_comEventResponse 참조
 * @since J2EE 1.6
 */

public interface MSTCommonBC {
	/**
	 * Manufacturer List를 조회합니다.<br>
	 * 
	 * @param CommonListVO commonListVO
	 * @return List<CommonListVO>
	 * @exception EventException
	 */
	public List<CommonListVO> searchManufacturerListBasic(CommonListVO commonListVO) throws EventException;
	/**                       
	 * Eq Type Size List를 조회합니다.<br>
	 * 
	 * @param CommonListVO commonListVO
	 * @return List<CommonListVO>
	 * @exception EventException
	 */
	public List<CommonListVO> searchEqTypeSizeListBasic(CommonListVO commonListVO) throws EventException;
	/**                       
	 * Manufacture Place List를 조회합니다.<br>
	 * 
	 * @param CommonListVO commonListVO
	 * @return List<CommonListVO>
	 * @exception EventException
	 */	
	public List<CommonListVO> searchManufacturePlaceListBasic(CommonListVO commonListVO) throws EventException;

	/**
	 * EES_MST_0014 : retrieve<br>
	 * Lease Agreement List 조회<br>
	 * 
	 * @param AgmtInfoVO agmtInfoVO
	 * @return List<AgmtInfoVO>
	 * @exception EventException
	 */
	public List<AgmtInfoVO> searchAgmtBasic(AgmtInfoVO agmtInfoVO) throws EventException;
	
	/**
	 * EES_MST_0014, EES_MST_0024 : retrieve<br>
	 * MSTCommon화면에 대한 조회 이벤트 처리<br>
	 * @param CommonListVO   commonListVO
	 * @return CommonListVO
	 * @exception EventException
	 */		
	public CommonListVO searchYardCodeBasic(CommonListVO commonListVO) throws EventException;
	
	/**
	 * Lessor 코드명을 조회합니다.<br>
	 * 
	 * @param CommonListVO   commonListVO
	 * @return String
	 * @exception EventException
	 */		
	public String searchLessorCodeBasic(CommonListVO commonListVO) throws EventException;
	
	/**
	 * EES_MST_0016 : retrieve<br>
	 * Reefer Type Code를 조회합니다.<br>
	 * @return List<CommonListVO>
	 * @exception EventException
	 */	
	public List<CommonListVO> searchReeferTypeCodeListBasic() throws EventException;
	
	/**
	 * COM_INTG_CD를 조회합니다.<br>
	 * @param String   intgCdId
	 * @param String   intgCdVal
	 * @return List<CommonListVO>
	 * @exception EventException
	 */	
	public List<CommonListVO> searchComIntgCdListBasic(String intgCdId, String intgCdVal) throws EventException;
	
	/**
	 * EDI 메시지를 송신합니다.<br>
	 * @param String   flatFile
	 * @return String
	 * @exception EventException
	 */	
	public String sendEdiToFleet(String flatFile) throws EventException; 
}