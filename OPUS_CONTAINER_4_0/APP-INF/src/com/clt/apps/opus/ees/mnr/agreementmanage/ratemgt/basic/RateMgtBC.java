/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RateMgtBC.java
*@FileTitle : Rate
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/	
package com.clt.apps.opus.ees.mnr.agreementmanage.ratemgt.basic;
	
import com.clt.apps.opus.ees.mnr.agreementmanage.ratemgt.vo.AgreementGRPVO;
import com.clt.apps.opus.ees.mnr.agreementmanage.ratemgt.vo.AgreementInfoListGRPVO;
import com.clt.framework.core.layer.event.EventException;
 
/**  
 * Rate Business Logic Command Interface<br>
 *
 * @author 
 * @see		RateMgtBCImpl
 * @since 	J2EE 1.4  
 */  
 	
public interface RateMgtBC {

	/**
	 * [EES_MNR_0218]Retrieving "M&R Agreement" data<br>
	 *
	 * @param AgreementGRPVO agreementGRPVO
	 * @return AgreementGRPVO
	 * @exception EventException
	 */
	public AgreementGRPVO searchAgreementMenuBasic(AgreementGRPVO agreementGRPVO) throws EventException;
	
	/**
	 * [EES_MNR_0218]Retrieving "M&R Agreement" data<br>
	 *
	 * @param AgreementGRPVO agreementGRPVO
	 * @return AgreementGRPVO
	 * @exception EventException
	 */
	public AgreementGRPVO searchAgreementBasic(AgreementGRPVO agreementGRPVO) throws EventException;
	
	/**
	 * [EES_MNR_0015]Deleting "M&R Agreement" data<br>
	 *
	 * @param AgreementGRPVO agreementGRPVO
	 * @exception EventException
	 */
	public void removeAgreementBasic(AgreementGRPVO agreementGRPVO) throws EventException;  
	 
	/**
	 * [EES_MNR_0218]Adding, modifying, deleting "M&R Agreement" data<br>
	 *
	 * @param AgreementGRPVO agreementGRPVO
	 * @return AgreementGRPVO
	 * @exception EventException
	 */
	public AgreementGRPVO manageAgreementBasic(AgreementGRPVO agreementGRPVO) throws EventException;  

	/**
	 * [EES_MNR_0018]Retrieving "M&R Agreement List" data<br>
	 *
	 * @param AgreementInfoListGRPVO agreementInfoListGRPVO
	 * @return AgreementInfoListGRPVO
	 * @exception EventException
	 */
	public AgreementInfoListGRPVO searchAgreementInfoListBasic(AgreementInfoListGRPVO agreementInfoListGRPVO) throws EventException;  
		
	/**
	 * [EES_MNR_0226]Retrieving "W/O Creation" data<br>
	 *
	 * @param AgreementGRPVO agreementGRPVO
	 * @return AgreementGRPVO 
	 * @exception EventException
	 */
	public AgreementGRPVO searchAgreementComboListBasic(AgreementGRPVO agreementGRPVO) throws EventException;
	
	/**
	 * [EES_MNR_0015]Checking Duplicate Agreement Data<br>
	 *
	 * @param AgreementGRPVO agreementGRPVO
	 * @return String 
	 * @exception EventException
	 */
	public String searchAgmtDupInfoBasic(AgreementGRPVO agreementGRPVO) throws EventException;
}