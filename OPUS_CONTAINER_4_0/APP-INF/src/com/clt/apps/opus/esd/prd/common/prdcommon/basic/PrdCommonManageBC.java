/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : PrdCommonManageBC.java
 *@FileTitle : PRD Common Management
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.prd.common.prdcommon.basic;

import java.util.List;

import com.clt.apps.opus.bcm.ccd.commoncode.location.vo.YardVO;
import com.clt.apps.opus.bcm.ccd.commoncode.location.vo.ZoneVO;
import com.clt.apps.opus.esd.prd.common.prdcommon.vo.ContinentVO;
import com.clt.apps.opus.esd.prd.common.prdcommon.vo.ServiceProviderVO;
import com.clt.apps.opus.esd.prd.common.prdcommon.vo.ValidationVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.syscommon.common.table.ComIntgCdDtlVO;

/**
 * PRD Business Logic Command Interface<br>
 * 
 * @author jungsunyoung
 * @see EventResponse
 * @since J2EE 1.4
 */
public interface PrdCommonManageBC {

	/**
	 * @param validationVO
	 * @return List
	 * @throws EventException
	 */
	@SuppressWarnings("rawtypes")
	public List validationPort(ValidationVO validationVO) throws EventException;

	/**
	 * @param validationVO
	 * @return List
	 * @throws EventException
	 */
	@SuppressWarnings("rawtypes")
	public List validationLocation(ValidationVO validationVO) throws EventException;

	/**
	 * @param validationVO
	 * @return List
	 * @throws EventException
	 */
	@SuppressWarnings("rawtypes")
	public List validationNode(ValidationVO validationVO) throws EventException;

	/**
	 * @param validationVO
	 * @return List
	 * @throws EventException
	 */
	@SuppressWarnings("rawtypes")
	public List validationTerminal(ValidationVO validationVO) throws EventException;

	/**
	 * @param validationVO
	 * @return List
	 * @throws EventException
	 */
	@SuppressWarnings("rawtypes")
	public List validationCountry(ValidationVO validationVO) throws EventException;

	/**
	 * retrieving Continent List
	 * 
	 * @return EventResponse
	 * @throws List
	 */
	@SuppressWarnings("rawtypes")
	public List searchContinent() throws EventException;

	/**
	 * retrieving Sub-Continent List
	 * 
	 * @param continentVO
	 * @return List
	 * @throws EventException
	 */
	@SuppressWarnings("rawtypes")
	public List searchSubContinent(ContinentVO continentVO) throws EventException;

	/**
	 * @param validationVO
	 * @return List
	 * @throws EventException
	 */
	@SuppressWarnings("rawtypes")
	public List validationLane(ValidationVO validationVO) throws EventException;

	/**
	 * PrdCommonManageBC's validationFdrLane
	 * 
	 * @param validationVO
	 * @return List
	 * @throws EventException
	 */
	@SuppressWarnings("rawtypes")
	public List validationFdrLane(ValidationVO validationVO) throws EventException;

	/**
	 * PrdCommonManageBC's validationCallingTmlMtxLane
	 * 
	 * @param validationVO
	 * @return List
	 * @throws EventException
	 */
	@SuppressWarnings("rawtypes")
	public List validationCallingTmlMtxLane(ValidationVO validationVO) throws EventException;

	/**
	 * @param validationVO
	 * @return List
	 * @throws EventException
	 */
	@SuppressWarnings("rawtypes")
	public List validationVendor(ValidationVO validationVO) throws EventException;

	/**
	 * PrdCommonManageBC's searchServiceProviderList
	 * 
	 * @param vo
	 * @return List
	 * @throws EventException
	 */
	public List<ServiceProviderVO> searchServiceProviderList(ServiceProviderVO vo) throws EventException;

	/**
	 * PrdCommonManageBC's validationCallingTmlMtxTmlCd
	 * 
	 * @param validationVO
	 * @return List
	 * @throws EventException
	 */
	@SuppressWarnings("rawtypes")
	public List validationCallingTmlMtxTmlCd(ValidationVO validationVO) throws EventException;

	/**
	 * PrdCommonManageBC's isDoorTml
	 * 
	 * @param check_data
	 * @return boolean
	 * @throws EventException
	 */
	public boolean isDoorTerminal(String check_data) throws EventException;

	/**
	 * PrdCommonManageBC's multiPrdNode
	 * 
	 * @param YardVO ydVO
	 * @return boolean
	 * @throws EventException
	 */
	public boolean multiPrdNodeByYard(YardVO ydVO) throws EventException;

	/**
	 * PrdCommonManageBC's multiPrdNode
	 * 
	 * @param ZoneVO zoneVO
	 * @return boolean
	 * @throws EventException
	 */
	public boolean multiPrdNodeByZone(ZoneVO zoneVO) throws EventException;

	/**
	 * @param contiCd
	 * @return String[]
	 * @throws EventException
	 */
	public String[] searchCntOfConti(String contiCd) throws EventException;

	/**
	 * 
	 * @param comIntgCdDtlVO
	 * @return
	 * @throws EventException
	 */
	public List<ComIntgCdDtlVO> searchComIntgCdDtl(ComIntgCdDtlVO comIntgCdDtlVO) throws EventException;
	
	/**
	 * retrieving Continent List
	 * 
	 * @param validationVO
	 * @return List<ValidationVO>
	 * @throws boolean
	 */
	@SuppressWarnings("rawtypes")
	public boolean isFullCargoCutOffInThePast(ValidationVO validationVO) throws EventException;

}