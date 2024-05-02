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
package com.clt.apps.opus.ees.lse.lsecommon.agreement.basic;

import java.util.List;

import com.clt.apps.opus.ees.lse.containerleaseagreementregistration.agreementregistration.vo.AgreementVO;
import com.clt.framework.core.layer.event.EventException;

/**
 * LseCommon Business Logic Command Interface<br>
 *
 * @author 
 * @see Ees_lse_0001EventResponse 
 * @since J2EE 1.6
 */

public interface AgreementBC {

	/**
	 * retrieving for Lease Agreement with Lease Agreement No.<br>
	 * 
	 * @param String agmtCytCd
	 * @param String agmtSeq  
	 * @return List<AgreementVO>
	 * @exception EventException
	 */
	public List<AgreementVO> searchAgreementListBrieflyBasic(String agmtCytCd, String agmtSeq) throws EventException;

	/**
	 * retrieving for Lease Agreement by Vendor term<br>
	 * 
	 * @param String vndrSeq
	 * @param String lstmCd
	 * @return List<AgreementVO>
	 * @exception EventException
	 */
	public List<AgreementVO> searchAgreementLessorListBrieflyBasic(String vndrSeq, String lstmCd) throws EventException;

	/**
	 * retrieving for Lease Agreement by Vendor <br>
	 * 
	 * @param String vndrSeq
	 * @return List<AgreementVO>
	 * @exception EventException
	 */
	public List<AgreementVO> searchAgreementByVendorListBrieflyBasic(String vndrSeq) throws EventException;
}