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
package com.hanjin.apps.alps.cps.cni.insurance.insurance.basic;

import com.hanjin.apps.alps.cps.cni.insurance.insurance.vo.ContainerPremiumVO;
import com.hanjin.apps.alps.cps.cni.insurance.insurance.vo.CustomInsuranceVO;
import com.hanjin.apps.alps.cps.cni.insurance.insurance.vo.CustomPremiumInstallmentVO;
import com.hanjin.apps.alps.cps.cni.insurance.insurance.vo.CustomPremiumVO;
import com.hanjin.apps.alps.cps.cni.insurance.insurance.vo.SearchInsuranceVO;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * ALPS-Insurance Business Logic Command Interface<br>
 * - ALPS-Insurance에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Yoon, Seyeong
 * @see Cps_cni_0401EventResponse 참조
 * @since J2EE 1.6
 */

public interface InsuranceBC {

	
	/**
	 * Main Insurance를 조회한다.<br>
	 * 
	 * @param String insurTpCd
	 * @param String insurPlcyYr
	 * @param String insurClmPtyNo
	 * @return SearchInsuranceVO
	 * @exception EventException
	 */
	public SearchInsuranceVO searchInsurance(String insurTpCd, String insurPlcyYr, String insurClmPtyNo) throws EventException ;
	
	
	/**
	 * Main Insurance를 생성 및 변경한다.<br>
	 * 
	 * @param CustomInsuranceVO customInsuranceVO
	 * @param String usrId 
	 * @exception EventException
	 */
	public void manageInsurance(CustomInsuranceVO customInsuranceVO, String usrId) throws EventException;

	/**
	 * Premium를 생성 및 변경한다.<br>
	 * 
	 * @param CustomPremiumVO customPremiumVO
	 * @param CustomPremiumInstallmentVO[] customPremiumtInstallmentVOs
	 * @param String usrId 
	 * @exception EventException
	 */
	public void managePremium(CustomPremiumVO customPremiumVO, CustomPremiumInstallmentVO[] customPremiumtInstallmentVOs, String usrId) throws EventException;

	/**
	 * Premium를 조회한다.<br>
	 * 
	 * @param String insurTpCd
	 * @param String insurPlcyYr
	 * @param String insurClmPtyNo
	 * @param String insurPrmTpCd
	 * @return ContainerPremiumVO
	 * @exception EventException
	 */
	public ContainerPremiumVO searchPremium(String insurTpCd, String insurPlcyYr, String insurClmPtyNo, String insurPrmTpCd) throws EventException ;

	/**
	 * Insurance 보험 등록 되어있는지 검사한다
	 * 
	 * @param String insurTpCd
	 * @param String insurPlcyYr
	 * @return String
	 * @exception EventException
	 */
	public String searchCheckInsurance(String insurTpCd, String insurPlcyYr) throws EventException ;

	/**
	 * Insurance 삭제한다
	 * 
	 * @param String insurTpCd
	 * @param String insurPlcyYr
	 * @param String insurClmPtyNo
	 * @exception EventException
	 */
	public void removeInsurance(String insurTpCd, String insurPlcyYr, String insurClmPtyNo) throws EventException ;

	/**
	 * Insurance Premium 삭제한다
	 * 
	 * @param String insurTpCd
	 * @param String insurPlcyYr
	 * @param String insurClmPtyNo
	 * @param String insurPrmTpCd
	 * @exception EventException
	 */
	public void removePremium(String insurTpCd, String insurPlcyYr, String insurClmPtyNo, String insurPrmTpCd) throws EventException ;

	/**
	 * Insurance 보험 Premium 등록 되어있는지 검사한다
	 * 
	 * @param String insurTpCd
	 * @param String insurPlcyYr
	 * @param String insurPrmTpCd
	 * @return String
	 * @exception EventException
	 */
	public String searchCheckPremium(String insurTpCd, String insurPlcyYr, String insurPrmTpCd) throws EventException ;
}