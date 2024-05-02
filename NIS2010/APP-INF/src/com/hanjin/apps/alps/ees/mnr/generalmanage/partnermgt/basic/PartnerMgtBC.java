/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PartnerMgtBC.java
*@FileTitle :RepairPartner
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.21
*@LastModifier : 박명신 
*@LastVersion : 1.0
* 2009.05.21 박명신
* 1.0 Creation  
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.generalmanage.partnermgt.basic;

import com.hanjin.apps.alps.ees.mnr.generalmanage.partnermgt.vo.RepairPartnerGRPVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.partnermgt.vo.DisposalPartnerGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo.DisposalGRPVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
 
/** 
 * RepairPartner Business Logic Command Interface<br>
 * - alps-partnermgt에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author park myoung sin 
 * @see EventResponse 참조
 * @since J2EE 1.6 
 */

public interface PartnerMgtBC {
	/**
	 * [EES_MNR_0156]Disposal Request의 정보를 조회 합니다. <br>
	 *
	 * @param DisposalGRPVO disposalGRPVO
	 * @return DisposalGRPVO
	 * @exception EventException
	 */
	public DisposalGRPVO searchDSPPartnerBasic(DisposalGRPVO disposalGRPVO) throws EventException;
	 
	/**
	 * [EES_MNR_0218]Tariff Detail Information_Pop_Up의 정보를 조회 합니다. <br>
	 *
	 * @param RepairPartnerGRPVO repairPartnerGRPVO
	 * @return RepairPartnerGRPVO
	 * @exception EventException
	 */  
	public RepairPartnerGRPVO searchRepairPartnerBasic(RepairPartnerGRPVO repairPartnerGRPVO) throws EventException;
	 
	/**
	 * [EES_MNR_0015]M&R Agreement의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param RepairPartnerGRPVO repairPartnerGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageRepairPartnerBasic(RepairPartnerGRPVO repairPartnerGRPVO,SignOnUserAccount account) throws EventException;
		
	/**
	 * [EES_MNR_0155]Disposal Buyer Management의 정보를 조회 합니다. <br>
	 *
	 * @param DisposalPartnerGRPVO disposalPartnerGRPVO
	 * @param SignOnUserAccount account
	 * @return DisposalPartnerGRPVO
	 * @exception EventException
	 */  
	public DisposalPartnerGRPVO searchDisposalPartnerListBasic(DisposalPartnerGRPVO disposalPartnerGRPVO,SignOnUserAccount account) throws EventException;
	 
	/**
	 * [EES_MNR_0155]Disposal Buyer Management의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param DisposalPartnerGRPVO disposalPartnerGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageDisposalPartnerBasic(DisposalPartnerGRPVO disposalPartnerGRPVO,SignOnUserAccount account) throws EventException; 
	
	/**
	 * [EES_MNR_0155]Disposal Buyer Management의 정보를 삭제 합니다. <br>
	 *
	 * @param DisposalPartnerGRPVO disposalPartnerGRPVO
	 * @exception EventException
	 */
	public void removeDisposalPartnerBasic(DisposalPartnerGRPVO disposalPartnerGRPVO) throws EventException; 
}