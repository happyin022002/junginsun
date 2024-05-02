/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InsuranceBC.java
*@FileTitle : Insurance Main
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.13
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.11.13 윤세영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.insurance.vesselstatus.basic;

import java.util.List;

import com.clt.apps.opus.cps.cni.insurance.vesselstatus.vo.CondSearchVesselStatusListVO;
import com.clt.apps.opus.cps.cni.insurance.vesselstatus.vo.CustomVesselStatusVO;
import com.clt.apps.opus.cps.cni.insurance.vesselstatus.vo.SearchInsuranceVesselDataVO;
import com.clt.apps.opus.cps.cni.insurance.vesselstatus.vo.SearchVesselStatusListVO;
import com.clt.framework.core.layer.event.EventException;

/**
 * OPUS-Insurance Business Logic Command Interface<br>
 * - OPUS-Insurance에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Yoon, Seyeong
 * @see Cps_cni_0401EventResponse 참조
 * @since J2EE 1.6
 */

public interface VesselStatusBC {

	
	/**
	 * Vessel Status Entry를 조회한다.<br>
	 * 
	 * @param CondSearchVesselStatusListVO condSearchVesselStatusListVO
	 * @return List<SearchVesselStatusListVO>
	 * @exception EventException
	 */
	public List<SearchVesselStatusListVO> searchVesselStatusList(CondSearchVesselStatusListVO condSearchVesselStatusListVO) throws EventException ;
	
	/**
	 * 국가명을 조회한다
	 * 
	 * @param String flag
	 * @return String
	 * @exception EventException
	 */
	public String searchInsuranceFlag(String flag) throws EventException ;

	/**
	 * 선박명을 조회한다
	 * 
	 * @param String vslCd
	 * @return String
	 * @exception EventException
	 */
	public String searchInsuranceVessel(String vslCd) throws EventException ;

	/**
	 * Vessel Status Entry를 생성 및 변경한다.<br>
	 * 
	 * @param CustomVesselStatusVO[] customVesselStatusVOs
	 * @param String usrId 
	 * @exception EventException
	 */
	public void manageVesselStatus(CustomVesselStatusVO[] customVesselStatusVOs, String usrId) throws EventException;

	/**
	 * Vessel Status의 선박 관련 항목 조회한다.<br>
	 * 
	 * @param String vslCd
	 * @return SearchInsuranceVesselDataVO
	 * @exception EventException
	 */
	public SearchInsuranceVesselDataVO searchInsuranceVesselData(String vslCd) throws EventException ;
}