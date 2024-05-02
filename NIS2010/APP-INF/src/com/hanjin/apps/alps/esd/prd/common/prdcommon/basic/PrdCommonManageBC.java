/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : PrdCommonManageBC.java
*@FileTitle : PRD 공통관리
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-16
*@LastModifier : jungsunyoung
*@LastVersion : 1.0
* 2006-10-16 jungsunyoung
* 1.0 최초 생성
* 2009.08.03 NohSeungBae alps f/w 변경 
* 2012.05.31 박만건 [CHM-201217633] 구주 Hinterland
=========================================================*/
package com.hanjin.apps.alps.esd.prd.common.prdcommon.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.prd.common.prdcommon.vo.ContinentVO;
import com.hanjin.apps.alps.esd.prd.common.prdcommon.vo.ServiceProviderVO;
import com.hanjin.apps.alps.esd.prd.common.prdcommon.vo.ValidationVO;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;

/**
 * alps-PRD Business Logic Command Interface<br>
 * - alps-PRD에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author jungsunyoung
 * @see EventResponse 참조
 * @since J2EE 1.4
 */
public interface PrdCommonManageBC  {

	/**
	 * @param validationVO
	 * @return List
	 * @throws EventException
	 */
	public List validationPort(ValidationVO validationVO) throws EventException;

	/**
	 * @param validationVO
	 * @return List
	 * @throws EventException
	 */
	public List validationLocation(ValidationVO validationVO) throws EventException;

	/**
	 * @param validationVO
	 * @return List
	 * @throws EventException
	 */
	public List validationNode(ValidationVO validationVO) throws EventException;

	/**
	 * @param validationVO
	 * @return List
	 * @throws EventException
	 */
	public List validationTerminal(ValidationVO validationVO) throws EventException;

	/**
	 * @param validationVO
	 * @return List
	 * @throws EventException
	 */
	public List validationCountry(ValidationVO validationVO) throws EventException;

	/**
	 * Continent List 조회
	 * 
	 * @return EventResponse
	 * @throws List
	 */
	public List searchContinent()throws EventException;
	
	/**
	 * Sub-Continent List 조회
	 * 
	 * @param continentVO
	 * @return List
	 * @throws EventException
	 */
	public List searchSubContinent(ContinentVO continentVO)throws EventException;

	/**
	 * @param validationVO
	 * @return List
	 * @throws EventException
	 */
	public List validationLane(ValidationVO validationVO)throws EventException;
	
	/**
	 * @param validationVO
	 * @return List
	 * @throws EventException
	 */
	public List searchContinentCode(ValidationVO validationVO)throws EventException;

	/**
	 * PrdCommonManageBC's validationFdrLane
	 * @param validationVO
	 * @return List
	 * @throws EventException
	 */
	public List validationFdrLane(ValidationVO validationVO)throws EventException;
	
	/**
	 * PrdCommonManageBC's validationCallingTmlMtxLane
	 * @param validationVO
	 * @return List
	 * @throws EventException
	 */
	public List validationCallingTmlMtxLane(ValidationVO validationVO)throws EventException;
	
	/**
	 * @param validationVO
	 * @return List
	 * @throws EventException
	 */
	public List validationVendor(ValidationVO validationVO)throws EventException;

	/**
	 * PrdCommonManageBC's searchServiceProviderList
	 * @param vo
	 * @return List
	 * @throws EventException
	 */
	public List<ServiceProviderVO> searchServiceProviderList(ServiceProviderVO vo) throws EventException;

	/**
	 * PrdCommonManageBC's getPrdPgmRole
	 * @param pgmId
	 * @param usrId
	 * @return
	 * @throws EventException String
	 */
	public String getPrdPgmRole(String programId, String userId ) throws EventException;
	
	/**
	 * PrdCommonManageBC's validationCallingTmlMtxTmlCd
	 * @param validationVO
	 * @return List
	 * @throws EventException
	 */
	public List validationCallingTmlMtxTmlCd(ValidationVO validationVO)throws EventException;
	
	/**
	 * PrdCommonManageBC's isDoorTml
	 * @param check_data
	 * @return boolean
	 * @throws EventException
	 */
	public boolean isDoorTerminal(String check_data) throws EventException ;

	/**
	 * @param pgmId
	 * @param usrId
	 * @return
	 * @throws EventException
	 */
	public DBRowSet getRowSetPrdPgmRole(String pgmId, String usrId) throws EventException;
	
	/**
	 * @param contiCd
	 * @return String[]
	 * @throws EventException
	 */
	public String[] searchCntOfConti(String contiCd) throws EventException;
	
    /**
     * validationLaneVvd
     * 
	 * @param ValidationVO vo
	 * @return List
     * @tnhrows EventException
     */
    public List validationLaneVvd(ValidationVO vo) throws EventException;

}