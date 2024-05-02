/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AgreementRegistrationBC.java
*@FileTitle : Lease Agreement Creation & Update
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.22
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.05.22 노정용
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleaseagreementregistration.agreementregistration.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.lse.containerleaseagreementregistration.agreementregistration.vo.AgreementListVO;
import com.hanjin.apps.alps.ees.lse.containerleaseagreementregistration.agreementregistration.vo.AgreementRegistrationVO;
import com.hanjin.apps.alps.ees.lse.containerleaseagreementregistration.agreementregistration.vo.AgreementVO;
import com.hanjin.apps.alps.ees.lse.containerleaseagreementregistration.agreementregistration.vo.InInterrstServiceVO;
import com.hanjin.apps.alps.ees.lse.containerleaseagreementregistration.agreementregistration.vo.InterrstServiceVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * NIS2010-Containerleaseagreementregistration Business Logic Command Interface<br>
 * - NIS2010-Containerleaseagreementregistration에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Nho Jung Yong
 * @see Ees_lse_0001EventResponse 참조
 * @since J2EE 1.6
 */

public interface AgreementRegistrationBC {
	/**
	 * Lease Agreement List 조회<br>
	 * 
	 * @param  AgreementVO searchAgreementVO
	 * @return List<AgreementVO>
	 * @exception EventException
	 */
	public List<AgreementVO> searchAgreementListBrieflyBasic(AgreementVO searchAgreementVO) throws EventException;

	/**
	 * Lease Agreement Master Data 조회<br>
	 * 
	 * @param AgreementRegistrationVO agreementRegistrationVO
	 * @return AgreementRegistrationVO
	 * @exception EventException
	 */
	public AgreementRegistrationVO searchAgreementBasic(AgreementRegistrationVO agreementRegistrationVO) throws EventException;

	/**
	 * Lease Agreement General Data 조회<br>
	 * 
	 * @param AgreementRegistrationVO agreementRegistrationVO
	 * @return AgreementRegistrationVO
	 * @exception EventException
	 */
	public AgreementRegistrationVO searchAgreementGeneralBasic(AgreementRegistrationVO agreementRegistrationVO) throws EventException;
	
	/**
	 * Lease Agreement Per-diem Data 조회<br>
	 * 
	 * @param AgreementRegistrationVO agreementRegistrationVO
	 * @return AgreementRegistrationVO
	 * @exception EventException
	 */
	public AgreementRegistrationVO searchAgreementPerDiemBasic(AgreementRegistrationVO agreementRegistrationVO) throws EventException;

	/**
	 * Lease Agreement Lifting Charge Data 조회<br>
	 * 
	 * @param AgreementRegistrationVO agreementRegistrationVO
	 * @return AgreementRegistrationVO
	 * @exception EventException
	 */
	public AgreementRegistrationVO searchAgreementLiftChargeBasic(AgreementRegistrationVO agreementRegistrationVO) throws EventException;

	/**
	 * Lease Agreement DOL/DOC Data 조회<br>
	 * 
	 * @param AgreementRegistrationVO agreementRegistrationVO
	 * @return AgreementRegistrationVO
	 * @exception EventException
	 */
	public AgreementRegistrationVO searchAgreementDolDocBasic(AgreementRegistrationVO agreementRegistrationVO) throws EventException;

	/**
	 * Lease Agreement Drop Office Data 조회<br>
	 * 
	 * @param AgreementRegistrationVO agreementRegistrationVO
	 * @return AgreementRegistrationVO
	 * @exception EventException
	 */
	public AgreementRegistrationVO searchAgreementDropOfficeDescBasic(AgreementRegistrationVO agreementRegistrationVO) throws EventException;

	/**
	 * Lease Agreement Penalty Data 조회<br>
	 * 
	 * @param AgreementRegistrationVO agreementRegistrationVO
	 * @return AgreementRegistrationVO
	 * @exception EventException
	 */
	public AgreementRegistrationVO searchAgreementPenaltyBasic(AgreementRegistrationVO agreementRegistrationVO) throws EventException;
	
	/**
	 * Lease Agreement DPP Data 조회<br>
	 * 
	 * @param AgreementRegistrationVO agreementRegistrationVO
	 * @return AgreementRegistrationVO
	 * @exception EventException
	 */
	public AgreementRegistrationVO searchAgreementDppBasic(AgreementRegistrationVO agreementRegistrationVO) throws EventException;
	
	/**
	 * Lease Agreement Master 및 Tab Data 신규 저장<br>
	 * 
	 * @param AgreementRegistrationVO agreementRegistrationVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String createAgreementBasic(AgreementRegistrationVO agreementRegistrationVO, SignOnUserAccount account) throws EventException;

	/**
	 * Lease Agreement Master 및 Tab Data 수정 저장<br>
	 * 
	 * @param AgreementRegistrationVO agreementRegistrationVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyAgreementBasic(AgreementRegistrationVO agreementRegistrationVO, SignOnUserAccount account) throws EventException;

	/**
	 * Lease Agreement Version Up 처리<br>
	 * 
	 * @param AgreementRegistrationVO agreementRegistrationVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String createAgreementNewVersionBasic(AgreementRegistrationVO agreementRegistrationVO, SignOnUserAccount account) throws EventException;

	/**
	 * Lease Agreement Version List 조회<br>
	 * 
	 * @param AgreementVO searchAgreementVO
	 * @return List<AgreementVO>
	 * @exception EventException
	 */
	public List<AgreementVO> searchAgreementVersionListBasic(AgreementVO searchAgreementVO) throws EventException;

	/**
	 * Lease Agreement Term & Condition Lists 조회<br>
	 * 
	 * @param String expFromDt
	 * @param String expToDt
	 * @param String vndrSeq
	 * @param String lstmCd
	 * @param String orgCntrTpszCd
	 * @param String ofcCd
	 * @return List<AgreementListVO>
	 * @exception EventException
	 */
	public List<AgreementListVO> searchAgreementListBasic(String expFromDt, String expToDt, String vndrSeq, String lstmCd, String orgCntrTpszCd, String ofcCd) throws EventException;
	
	/**
	 * EES_LSE_0102 : caculation Click <br>
	 * Interest calculation 조회 <br>
	 * @param     InInterrstServiceVO inInterrstServiceVO
	 * @return    List<InterrstServiceVO>
	 * @exception EventException
	 */
	public List<InterrstServiceVO> calculationInterrstBasic(InInterrstServiceVO inInterrstServiceVO) throws EventException;

	/**
	 * Lease Agreement Pic Data 조회<br>
	 * 
	 * @param AgreementRegistrationVO agreementRegistrationVO
	 * @return AgreementRegistrationVO
	 * @exception EventException
	 */
	public AgreementRegistrationVO searchAgreementPicBasic(AgreementRegistrationVO agreementRegistrationVO) throws EventException;
	/**
	 * Lease Agreement File Upload 처리<br> 
	 * 
	 * @param AgreementRegistrationVO agreementRegistrationVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public void makeAgreementFileUpLseAgmtRt(AgreementRegistrationVO agreementRegistrationVO,SignOnUserAccount account) throws EventException ;

}