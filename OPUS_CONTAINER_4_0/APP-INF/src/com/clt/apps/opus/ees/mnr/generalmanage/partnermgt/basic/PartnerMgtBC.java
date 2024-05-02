/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PartnerMgtBC.java
*@FileTitle :RepairPartner
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.mnr.generalmanage.partnermgt.basic;

import com.clt.apps.opus.ees.mnr.generalmanage.partnermgt.vo.DisposalPartnerGRPVO;
import com.clt.apps.opus.ees.mnr.generalmanage.partnermgt.vo.RepairPartnerGRPVO;
import com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.vo.DisposalGRPVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.view.signon.SignOnUserAccount;
 
/** 
 * RepairPartner Business Logic Command Interface<br>
 *
 * @author  
 * @see EventResponse reference
 * @since J2EE 1.6 
 */

public interface PartnerMgtBC {
	/**
	 * [EES_MNR_0156] retrieving Disposal Request. <br>
	 *
	 * @param DisposalGRPVO disposalGRPVO
	 * @return DisposalGRPVO
	 * @exception EventException
	 */
	public DisposalGRPVO searchDSPPartnerBasic(DisposalGRPVO disposalGRPVO) throws EventException;
	 
	/**
	 * [EES_MNR_0218] retrieving Tariff Detail Information_Pop_Up. <br>
	 *
	 * @param RepairPartnerGRPVO repairPartnerGRPVO
	 * @return RepairPartnerGRPVO
	 * @exception EventException
	 */  
	public RepairPartnerGRPVO searchRepairPartnerBasic(RepairPartnerGRPVO repairPartnerGRPVO) throws EventException;
	 
	/**
	 * [EES_MNR_0015] adding/modification/deletion M&R Agreement. <br>
	 *
	 * @param RepairPartnerGRPVO repairPartnerGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageRepairPartnerBasic(RepairPartnerGRPVO repairPartnerGRPVO,SignOnUserAccount account) throws EventException;
		
	/**
	 * [EES_MNR_0155] retrieving Disposal Buyer Management. <br>
	 *
	 * @param DisposalPartnerGRPVO disposalPartnerGRPVO
	 * @param SignOnUserAccount account
	 * @return DisposalPartnerGRPVO
	 * @exception EventException
	 */  
	public DisposalPartnerGRPVO searchDisposalPartnerListBasic(DisposalPartnerGRPVO disposalPartnerGRPVO,SignOnUserAccount account) throws EventException;
	 
	/**
	 * [EES_MNR_0155] adding/modification/deletion Disposal Buyer Management. <br>
	 *
	 * @param DisposalPartnerGRPVO disposalPartnerGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageDisposalPartnerBasic(DisposalPartnerGRPVO disposalPartnerGRPVO,SignOnUserAccount account) throws EventException; 
	
	/**
	 * [EES_MNR_0155] deleting Disposal Buyer Management. <br>
	 *
	 * @param DisposalPartnerGRPVO disposalPartnerGRPVO
	 * @exception EventException
	 */
	public void removeDisposalPartnerBasic(DisposalPartnerGRPVO disposalPartnerGRPVO) throws EventException; 
	
	/**
	 * [EES_MNR_0155] searching duplicated buyer <br>
	 *
	 * @param DisposalPartnerGRPVO disposalPartnerGRPVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String searchDupDSPBuyerBasic(DisposalPartnerGRPVO disposalPartnerGRPVO,SignOnUserAccount account) throws EventException;
}