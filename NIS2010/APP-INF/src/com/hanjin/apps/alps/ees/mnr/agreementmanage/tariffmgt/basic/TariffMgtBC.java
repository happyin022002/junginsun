/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TariffMgtBC.java
*@FileTitle : MNR Tariff No Inquiry_Pop Up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.02
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2009.06.02 김완규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.agreementmanage.tariffmgt.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.mnr.agreementmanage.tariffmgt.vo.DisposalTariffEffDtGRPVO;
import com.hanjin.apps.alps.ees.mnr.agreementmanage.tariffmgt.vo.DisposalTariffGRPVO;
import com.hanjin.apps.alps.ees.mnr.agreementmanage.tariffmgt.vo.DisposalTariffQuarterGRPVO;
import com.hanjin.apps.alps.ees.mnr.agreementmanage.tariffmgt.vo.DisposalTariffQuarterVO;
import com.hanjin.apps.alps.ees.mnr.agreementmanage.tariffmgt.vo.DisposalTariffRegionVO;
import com.hanjin.apps.alps.ees.mnr.agreementmanage.tariffmgt.vo.RepairTariffMgtGRPVO;
import com.hanjin.apps.alps.ees.mnr.agreementmanage.tariffmgt.vo.TariffApprovalGRPVO;
import com.hanjin.apps.alps.ees.mnr.agreementmanage.tariffmgt.vo.TariffPopupGRPVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * alps-Agreementmanage Business Logic Command Interface<br>
 * - alps-Agreementmanage에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author WanGyu Kim
 * @see Ees_mnr_0188EventResponse 참조
 * @since J2EE 1.6
 */

public interface TariffMgtBC {
	/**
	 * [EES_MNR_0188]M&R Tariff No Inquiry_Pop Up의 정보를 조회 합니다. <br>
	 *
	 * @param TariffPopupGRPVO tariffPopupGRPVO
	 * @param SignOnUserAccount account
	 * @return TariffPopupGRPVO
	 * @exception EventException
	 */
	public TariffPopupGRPVO searchRepairTariffPopUpListBasic(TariffPopupGRPVO tariffPopupGRPVO, SignOnUserAccount account) throws EventException;
	/**
	 * [EES_MNR_0015]M&R Tariff No Combolist의 정보를 조회 합니다. <br>
	 *
	 * @param TariffPopupGRPVO tariffPopupGRPVO
	 * @return TariffPopupGRPVO
	 * @exception EventException
	 */
	public TariffPopupGRPVO searchRepairTariffComboListBasic(TariffPopupGRPVO tariffPopupGRPVO) throws EventException;
	/**
	 * [EES_MNR_0215]Tariff Detail Information_Pop_Up의 정보를 조회 합니다. <br>
	 *
	 * @param RepairTariffMgtGRPVO repairTariffMgtGRPVO
	 * @param SignOnUserAccount account
	 * @return RepairTariffMgtGRPVO
	 * @exception EventException
	 */
	public RepairTariffMgtGRPVO searchRepairTariffBasic(RepairTariffMgtGRPVO repairTariffMgtGRPVO,SignOnUserAccount account) throws EventException;
	/**
	 * [EES_MNR_0014]M&R Standard Tariff Creation & Inquiry의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param RepairTariffMgtGRPVO repairTariffMgtGRPVO
	 * @param SignOnUserAccount account
	 * @return RepairTariffMgtGRPVO
	 * @exception EventException
	 */
	public RepairTariffMgtGRPVO manageRepairTariffBasic(RepairTariffMgtGRPVO repairTariffMgtGRPVO,SignOnUserAccount account) throws EventException;

	/**
	 * [EES_MNR_0154]Disposal Tariff by Region의 정보를 조회 합니다. <br>
	 *
	 * @param DisposalTariffGRPVO disposalTariffGRPVO
	 * @param SignOnUserAccount account
	 * @return DisposalTariffGRPVO
	 * @exception EventException
	 */
	public DisposalTariffGRPVO searchDisposalTariffBasic(DisposalTariffGRPVO disposalTariffGRPVO,SignOnUserAccount account) throws EventException;

	/**
	 * [EES_MNR_0232]Disposal Tariff by Region의 정보를 조회 합니다. <br>
	 *
	 * @param DisposalTariffGRPVO disposalTariffGRPVO
	 * @param SignOnUserAccount account
	 * @return DisposalTariffGRPVO
	 * @exception EventException
	 */
	public DisposalTariffGRPVO searchDisposalTariffInqueryListBasic(DisposalTariffGRPVO disposalTariffGRPVO, SignOnUserAccount account) throws EventException;

	/**
	 * [EES_MNR_0154]Disposal Tariff by Region의 정보를 조회 합니다. <br>
	 *
	 * @param DisposalTariffEffDtGRPVO disposalTariffEffDtGRPVO
	 * @param SignOnUserAccount account
	 * @return DisposalTariffEffDtGRPVO
	 * @exception EventException
	 */
	public DisposalTariffEffDtGRPVO searchDisposalTariffEffDtListBasic(DisposalTariffEffDtGRPVO disposalTariffEffDtGRPVO,SignOnUserAccount account) throws EventException;

	/**
	 * [EES_MNR_0232]Disposal Tariff by Region의 정보를 조회 합니다. <br>
	 *
	 * @param DisposalTariffEffDtGRPVO disposalTariffEffDtGRPVO
	 * @param SignOnUserAccount account
	 * @return DisposalTariffEffDtGRPVO
	 * @exception EventException
	 */
	public DisposalTariffEffDtGRPVO searchDisposalTariffInqueryEffDtListBasic(DisposalTariffEffDtGRPVO disposalTariffEffDtGRPVO, SignOnUserAccount account) throws EventException;

	/**
	 * [EES_MNR_0154]Disposal Tariff by Region의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param DisposalTariffGRPVO disposalTariffGRPVO
	 * @param SignOnUserAccount account
	 * @return DisposalTariffGRPVO
	 * @exception EventException
	 */
	public DisposalTariffGRPVO manageDisposalTariffBasic(DisposalTariffGRPVO disposalTariffGRPVO,SignOnUserAccount account) throws EventException;


	/**
	 * [EES_MNR_0011]M&R Local Tariff Creation & Verify의 정보를 조회 합니다. <br>
	 *
	 * @param RepairTariffMgtGRPVO repairTariffMgtGRPVO
	 * @param SignOnUserAccount account
	 * @return RepairTariffMgtGRPVO
	 * @exception EventException
	 */
	public RepairTariffMgtGRPVO searchDefaultRepairTariffDetailBasic(RepairTariffMgtGRPVO repairTariffMgtGRPVO,SignOnUserAccount account) throws EventException;
	/**
	 * [EES_MNR_0171]M&R Tariff Inquiry의 정보를 조회 합니다. <br>
	 *
	 * @param TariffApprovalGRPVO tariffApprovalGRPVO
	 * @param SignOnUserAccount account
	 * @return TariffApprovalGRPVO
	 * @exception EventException
	 */
	public TariffApprovalGRPVO searchRepairTariffApprovalListBasic(TariffApprovalGRPVO tariffApprovalGRPVO,SignOnUserAccount account) throws EventException;
	/**
	 * [EES_MNR_0136]M&R Regional Tariff Approval의 정보를 수정 합니다. <br>
	 *
	 * @param TariffApprovalGRPVO tariffApprovalGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyRepairTariffStatusBasic(TariffApprovalGRPVO tariffApprovalGRPVO,SignOnUserAccount account) throws EventException;

	/**
	 * [EES_MNR_0154] 분기별 매각기준 가격정보 현황을 조회합니다. <br>
	 *
	 * @param DisposalTariffRegionVO disposalTariffRegionVO
	 * @return List<DisposalTariffRegionVO>
	 * @exception EventException
	 */
	public List<DisposalTariffRegionVO> searchDisposalTariffRegionListBasic(DisposalTariffRegionVO disposalTariffRegionVO) throws EventException;

	/**
	 * [EES_MNR_0154] 분기별 매각기준 가격정보 일괄 저장합니다.<br>
	 *
	 * @param DisposalTariffRegionVO[] disposalTariffRegionVOs
	 * @param SignOnUserAccount userAccount
	 * @exception EventException
	 */
	public void manageDisposalTariffRegionListBasic(DisposalTariffRegionVO[] disposalTariffRegionVOs, SignOnUserAccount userAccount) throws EventException;

	/**
	 * [EES_MNR_0154] 분기별 매각기준 가격정보 일괄 저장합니다.<br>
	 *
	 * @param  DisposalTariffRegionVO[] disposalTariffRegionVOs
	 * @param  SignOnUserAccount userAccount
	 * @return String
	 * @throws EventException
	 */
	public String backEndDisposalTariffRegionListBasic(DisposalTariffRegionVO[] disposalTariffRegionVOs, SignOnUserAccount userAccount) throws EventException;

	/**
	 * BackEndJob의 실행결과에 대한 상태값을 조회합니다.<br>
	 *
	 * @param String key
	 * @return String
	 * @exception EventException
	 */
	public String searchComBackEndJobStatusBasic(String key) throws EventException;

	/**
	 * [EES_MNR_0232] 분기별 지역별 매각기준 가격정보 현황을 조회합니다. <br>
	 *
	 * @param DisposalTariffQuarterVO disposalTariffQuarterVO
	 * @return DisposalTariffQuarterGRPVO
	 * @exception EventException
	 */
	public DisposalTariffQuarterGRPVO searchDisposalTariffQuarterListBasic(DisposalTariffQuarterVO disposalTariffQuarterVO) throws EventException;
}