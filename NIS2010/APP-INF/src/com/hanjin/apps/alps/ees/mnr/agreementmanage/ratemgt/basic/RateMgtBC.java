/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RateMgtBC.java
*@FileTitle : Rate 관련 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.18
*@LastModifier : Chang Young Kim
*@LastVersion : 1.0
* 2009.05.12 박명신
* 1.0 Creation
* 2014-12-18 Chang Young Kim [CHM-201433304] CSR 승인 강화에 따른 ALPS MNR-AGMT에 GW Document Contract Link 관련 추가 요청 사항
=========================================================*/	
package com.hanjin.apps.alps.ees.mnr.agreementmanage.ratemgt.basic;
	
import java.util.List;

import com.hanjin.apps.alps.ees.mnr.agreementmanage.ratemgt.vo.AgmtAtchDataVO;
import com.hanjin.apps.alps.ees.mnr.agreementmanage.ratemgt.vo.AgreementGRPVO;
import com.hanjin.apps.alps.ees.mnr.agreementmanage.ratemgt.vo.AgreementInfoListGRPVO;
import com.hanjin.framework.core.layer.event.EventException; 
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
 
/**  
 * Rate Business Logic Command Interface<br>
 *
 * @author 	park myoung sin 
 * @see 	RateMgtBCImpl 참조
 * @since 	J2EE 1.4  
 */  
 	
public interface RateMgtBC { 
	/**
	 * [EES_MNR_0218]M&R Agreement의 정보를 조회 합니다. <br>
	 *
	 * @param AgreementGRPVO agreementGRPVO
	 * @return AgreementGRPVO
	 * @exception EventException
	 */
	public AgreementGRPVO searchAgreementMenuBasic(AgreementGRPVO agreementGRPVO) throws EventException;
	
	/**
	 * [EES_MNR_0218]M&R Agreement의 정보를 조회 합니다. <br>
	 *
	 * @param AgreementGRPVO agreementGRPVO
	 * @return AgreementGRPVO
	 * @exception EventException
	 */ 	
	public AgreementGRPVO searchAgreementBasic(AgreementGRPVO agreementGRPVO) throws EventException;
	
	/**
	 * [EES_MNR_0015]M&R Agreement의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param AgreementGRPVO agreementGRPVO
	 * @exception EventException
	 */ 
	public void removeAgreementBasic(AgreementGRPVO agreementGRPVO) throws EventException;  
	 
	/**
	 * [EES_MNR_0218]M&R Agreement의 정보를 조회 합니다. <br>
	 *
	 * @param AgreementGRPVO agreementGRPVO
	 * @return AgreementGRPVO
	 * @exception EventException
	 */	
	public AgreementGRPVO manageAgreementBasic(AgreementGRPVO agreementGRPVO) throws EventException;  

	/**
	 * [EES_MNR_0018]M&R Agreement List의 정보를 조회 합니다. <br>
	 *
	 * @param AgreementInfoListGRPVO agreementInfoListGRPVO
	 * @return AgreementInfoListGRPVO
	 * @exception EventException
	 */
	public AgreementInfoListGRPVO searchAgreementInfoListBasic(AgreementInfoListGRPVO agreementInfoListGRPVO) throws EventException;  
		
	/**
	 * [EES_MNR_0226]W/O Creation의 정보를 조회 합니다. <br>
	 *
	 * @param AgreementGRPVO agreementGRPVO
	 * @return AgreementGRPVO 
	 * @exception EventException
	 */
	public AgreementGRPVO searchAgreementComboListBasic(AgreementGRPVO agreementGRPVO) throws EventException;
	
	/**
	 * [EES_MNR_0017]M&R Agreement Attach의 정보를 조회 합니다. <br>
	 *
	 * @param AgmtAtchDataVO agmtAtchDataVO
	 * @return List<AgmtAtchDataVO>
	 * @exception EventException
	 */
	public List<AgmtAtchDataVO> searchAgreementAttachInfoListBasic(AgmtAtchDataVO agmtAtchDataVO) throws EventException;
	
	/**
	 * [EES_MNR_0018] M&R Agreement Attach List의 정보를 저장 합니다. <br>
	 * 
	 * @param AgmtAtchDataVO[] agmtAtchDataVOs
	 * @param AgmtAtchDataVO agmtAtchDataVO
	 * @param SignOnUserAccount account
	 * @return int insCnt
	 * @exception EventException
	 */
	public int manageAgreementAttachInfoBasic(AgmtAtchDataVO[] agmtAtchDataVOs, AgmtAtchDataVO agmtAtchDataVO, SignOnUserAccount account) throws EventException;
}