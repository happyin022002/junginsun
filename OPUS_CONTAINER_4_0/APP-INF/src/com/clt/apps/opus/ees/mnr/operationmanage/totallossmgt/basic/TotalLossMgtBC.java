/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TotalLossMgtBC.java
*@FileTitle : Total Loss No Inquiry_Pop Up
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.mnr.operationmanage.totallossmgt.basic;

import java.util.List;

import com.clt.apps.opus.ees.mnr.operationmanage.totallossmgt.vo.CustomMnrTtlLssRqstDtlVO;
import com.clt.apps.opus.ees.mnr.operationmanage.totallossmgt.vo.TotalLossGRPVO;
import com.clt.apps.opus.ees.mnr.operationmanage.totallossmgt.vo.TotalLossInfoGRPVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.apps.opus.ees.mnr.operationmanage.totallossmgt.vo.TotalLossLessorReportINVO;
import com.clt.apps.opus.ees.mnr.operationmanage.totallossmgt.vo.TotalLossLessorReportVO;

/**
 * COM-GeneralManage Business Logic Command Interface<br>
 * - COM-GeneralManage interface of business logic<br>
 *
 * @author
 * @see 	Ees_mnr_0195EventResponse
 * @since 	J2EE 1.4
 */
public interface TotalLossMgtBC {

	/**
	 * [EES_MNR_0098]Retrieving "Total Loss Collection & Inquiry" data<br>
	 *
	 * @param TotalLossGRPVO totalLossGRPVO
	 * @param SignOnUserAccount account
	 * @return TotalLossGRPVO
	 * @exception EventException
	 */
	public TotalLossGRPVO searchTotalLossWithCLTBasic(TotalLossGRPVO totalLossGRPVO, SignOnUserAccount account) throws EventException;

	/**
	 * [EES_MNR_0098]Deleting "Total Loss Collection & Inquiry" data<br>
	 *
	 * @param TotalLossGRPVO totalLossGRPVO
	 * @param SignOnUserAccount account
	 * @return TotalLossGRPVO
	 * @exception EventException
	 */
	public TotalLossGRPVO removeTotalLossBasic(TotalLossGRPVO totalLossGRPVO, SignOnUserAccount account) throws EventException;

	/**
	 * [EES_MNR_0098]Deleting "Total Loss Request" data<br>
	 *
	 * @param TotalLossGRPVO totalLossGRPVO
	 * @param SignOnUserAccount account
	 * @return TotalLossGRPVO
	 * @exception EventException
	 */
	public TotalLossGRPVO removeTotalLossGRPBasic(TotalLossGRPVO totalLossGRPVO, SignOnUserAccount account) throws EventException;

	/**
	 * [EES_MNR_0098]Retrieving "Total Loss Request" data<br>
	 *
	 * @param TotalLossGRPVO totalLossGRPVO
	 * @param SignOnUserAccount account
	 * @return TotalLossGRPVO
	 * @exception EventException
	 */
	public TotalLossGRPVO searchTotalLossListBasic(TotalLossGRPVO totalLossGRPVO, SignOnUserAccount account) throws EventException;

	/**
	 * [EES_MNR_0195]Retrieving "Total Loss No Inquiry_Pop Up" data<br>
	 *
	 * @param TotalLossInfoGRPVO totalLossInfoGRPVO
	 * @param SignOnUserAccount account
	 * @return TotalLossInfoGRPVO
	 * @exception EventException
	 */
	public TotalLossInfoGRPVO searchTotalLossInfoByOFCListBasic(TotalLossInfoGRPVO totalLossInfoGRPVO, SignOnUserAccount account) throws EventException;

	/**
	 * [EES_MNR_0098]Retrieving "Total Loss Request" data<br>
	 *
	 * @param TotalLossGRPVO totalLossGRPVO
	 * @param SignOnUserAccount account
	 * @return TotalLossGRPVO
	 * @exception EventException
	 */
	public TotalLossGRPVO searchTotalLossBasic(TotalLossGRPVO totalLossGRPVO,SignOnUserAccount account) throws EventException;

	/**
	 * [EES_MNR_0098]Adding, modifying, deleting "Total Loss Request" data<br>
	 *
	 * @param TotalLossGRPVO totalLossGRPVO
	 * @param SignOnUserAccount account
	 * @return TotalLossGRPVO
	 * @exception EventException
	 */
	public TotalLossGRPVO manageTotalLossBasic(TotalLossGRPVO totalLossGRPVO,SignOnUserAccount account) throws EventException;

	/**
	 * [EES_MNR_0105]Retrieving "Total Loss Payment to Lessor Report" data<br>
	 *
	 * @param TotalLossLessorReportINVO totalLossLessorReportINVO
	 * @return List<TotalLossLessorReportVO>
	 * @exception EventException
	 */
	public List<TotalLossLessorReportVO> searchTotalLossLessorReportListBasic(TotalLossLessorReportINVO totalLossLessorReportINVO) throws EventException;

	/**
	 * [EES_MNR_0096]Modifying "Total Loss Management" data<br>
	 *
	 * @param TotalLossGRPVO totalLossGRPVO
	 * @param SignOnUserAccount account
	 * @return TotalLossGRPVO
	 * @exception EventException
	 */
	public TotalLossGRPVO modifyTotalLossDetailBasic(TotalLossGRPVO totalLossGRPVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * [EES_MNR_0096]Modifying "Total Loss Management" data<br>
	 *
	 * @param CustomMnrTtlLssRqstDtlVO customMnrTtlLssRqstDtlVO
	 * @param String ttlLssDt
	 * @param SignOnUserAccount account
	 * @return TotalLossGRPVO
	 * @exception EventException
	 */
	public TotalLossGRPVO modifyTotalLossRevVvdBasic(CustomMnrTtlLssRqstDtlVO customMnrTtlLssRqstDtlVO, String ttlLssDt, SignOnUserAccount account) throws EventException;
}
