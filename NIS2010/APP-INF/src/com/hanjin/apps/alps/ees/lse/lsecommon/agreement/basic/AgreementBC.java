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
package com.hanjin.apps.alps.ees.lse.lsecommon.agreement.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.lse.containerleaseagreementregistration.agreementregistration.vo.AgreementVO;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * NIS2010-LseCommon Business Logic Command Interface<br>
 * - NIS2010-LseCommon에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Nho Jung Yong
 * @see Ees_lse_0001EventResponse 참조
 * @since J2EE 1.6
 */

public interface AgreementBC {

	/**
	 *Lease Agreement No. 로 Lease Agreement 조회<br>
	 * 
	 * @param String agmtCytCd
	 * @param String agmtSeq  
	 * @return List<AgreementVO>
	 * @exception EventException
	 */
	public List<AgreementVO> searchAgreementListBrieflyBasic(String agmtCytCd, String agmtSeq) throws EventException;

	/**
	 * Vendor 가 해당하는 Term의 Lease Agreement 조회<br>
	 * 
	 * @param String vndrSeq
	 * @param String lstmCd
	 * @return List<AgreementVO>
	 * @exception EventException
	 */
	public List<AgreementVO> searchAgreementLessorListBrieflyBasic(String vndrSeq, String lstmCd) throws EventException;

	/**
	 * Vendor 의 Lease Agreement 조회<br>
	 * 
	 * @param String vndrSeq
	 * @return List<AgreementVO>
	 * @exception EventException
	 */
	public List<AgreementVO> searchAgreementByVendorListBrieflyBasic(String vndrSeq) throws EventException;
}