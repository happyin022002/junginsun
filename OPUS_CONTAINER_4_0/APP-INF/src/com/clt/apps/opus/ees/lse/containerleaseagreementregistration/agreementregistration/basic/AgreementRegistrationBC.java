/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AgreementRegistrationBC.java
*@FileTitle : Lease Agreement Creation & Update
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.lse.containerleaseagreementregistration.agreementregistration.basic;

import java.util.List;

import com.clt.apps.opus.ees.lse.containerleaseagreementregistration.agreementregistration.vo.AgreementListVO;
import com.clt.apps.opus.ees.lse.containerleaseagreementregistration.agreementregistration.vo.AgreementRegistrationVO;
import com.clt.apps.opus.ees.lse.containerleaseagreementregistration.agreementregistration.vo.AgreementVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * Containerleaseagreementregistration Business Logic Command Interface<br>
 * Interface for Biz Logic of Containerleaseagreementregistration<br>
 *
 * @author 
 * @see Ees_lse_0001EventResponse 
 * @since J2EE 1.6
 */

public interface AgreementRegistrationBC {
	/**
	 * Retrieving Lease Agreement List<br>
	 * 
	 * @param  AgreementVO searchAgreementVO
	 * @return List<AgreementVO>
	 * @exception EventException
	 */
	public List<AgreementVO> searchAgreementListBrieflyBasic(AgreementVO searchAgreementVO) throws EventException;

	/**
	 * Retrieving Lease Agreement Master Data <br>
	 * 
	 * @param AgreementRegistrationVO agreementRegistrationVO
	 * @return AgreementRegistrationVO
	 * @exception EventException
	 */
	public AgreementRegistrationVO searchAgreementBasic(AgreementRegistrationVO agreementRegistrationVO) throws EventException;

	/**
	 * Retrieving Lease Agreement General Data <br>
	 * 
	 * @param AgreementRegistrationVO agreementRegistrationVO
	 * @return AgreementRegistrationVO
	 * @exception EventException
	 */
	public AgreementRegistrationVO searchAgreementGeneralBasic(AgreementRegistrationVO agreementRegistrationVO) throws EventException;
	
	/**
	 * Retrieving Lease Agreement Per-diem Data <br>
	 * 
	 * @param AgreementRegistrationVO agreementRegistrationVO
	 * @return AgreementRegistrationVO
	 * @exception EventException
	 */
	public AgreementRegistrationVO searchAgreementPerDiemBasic(AgreementRegistrationVO agreementRegistrationVO) throws EventException;

	/**
	 * Retrieving Lease Agreement Lifting Charge Data <br>
	 * 
	 * @param AgreementRegistrationVO agreementRegistrationVO
	 * @return AgreementRegistrationVO
	 * @exception EventException
	 */
	public AgreementRegistrationVO searchAgreementLiftChargeBasic(AgreementRegistrationVO agreementRegistrationVO) throws EventException;

	/**
	 * Retrieving Lease Agreement DOL/DOC Data <br>
	 * 
	 * @param AgreementRegistrationVO agreementRegistrationVO
	 * @return AgreementRegistrationVO
	 * @exception EventException
	 */
	public AgreementRegistrationVO searchAgreementDolDocBasic(AgreementRegistrationVO agreementRegistrationVO) throws EventException;

	/**
	 * Retrieving Lease Agreement Drop Office Data <br>
	 * 
	 * @param AgreementRegistrationVO agreementRegistrationVO
	 * @return AgreementRegistrationVO
	 * @exception EventException
	 */
	public AgreementRegistrationVO searchAgreementDropOfficeDescBasic(AgreementRegistrationVO agreementRegistrationVO) throws EventException;

	/**
	 * Retrieving Lease Agreement Penalty Data <br>
	 * 
	 * @param AgreementRegistrationVO agreementRegistrationVO
	 * @return AgreementRegistrationVO
	 * @exception EventException
	 */
	public AgreementRegistrationVO searchAgreementPenaltyBasic(AgreementRegistrationVO agreementRegistrationVO) throws EventException;
	
	/**
	 * Retrieving Lease Agreement DPP Data <br>
	 * 
	 * @param AgreementRegistrationVO agreementRegistrationVO
	 * @return AgreementRegistrationVO
	 * @exception EventException
	 */
	public AgreementRegistrationVO searchAgreementDppBasic(AgreementRegistrationVO agreementRegistrationVO) throws EventException;
	
	/**
	 * New Saving Lease Agreement Master and Tab Data <br>
	 * 
	 * @param AgreementRegistrationVO agreementRegistrationVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String createAgreementBasic(AgreementRegistrationVO agreementRegistrationVO, SignOnUserAccount account) throws EventException;

	/**
	 * Modifying and Saving Lease Agreement Master and Tab Data <br>
	 * 
	 * @param AgreementRegistrationVO agreementRegistrationVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyAgreementBasic(AgreementRegistrationVO agreementRegistrationVO, SignOnUserAccount account) throws EventException;

	/**
	 * Handling Lease Agreement Version Up <br>
	 * 
	 * @param AgreementRegistrationVO agreementRegistrationVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String createAgreementNewVersionBasic(AgreementRegistrationVO agreementRegistrationVO, SignOnUserAccount account) throws EventException;

	/**
	 * Retrieving Lease Agreement Version List <br>
	 * 
	 * @param AgreementVO searchAgreementVO
	 * @return List<AgreementVO>
	 * @exception EventException
	 */
	public List<AgreementVO> searchAgreementVersionListBasic(AgreementVO searchAgreementVO) throws EventException;

	/**
	 * Retrieving Lease Agreement Term & Condition Lists <br>
	 * 
	 * @param String expFromDt
	 * @param String expToDt
	 * @param String vndrSeq
	 * @param String lstmCd
	 * @param String orgCntrTpszCd
	 * @param String ofcCd
	 * @param String allLstmCd
	 * @param String lsePayTpCd
	 * @return List<AgreementListVO>
	 * @exception EventException
	 */
	public List<AgreementListVO> searchAgreementListBasic(String expFromDt, String expToDt, String vndrSeq, String lstmCd, String orgCntrTpszCd, String ofcCd, String allLstmCd, String lsePayTpCd) throws EventException;
}