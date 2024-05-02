/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ACMSetupBC.java
*@FileTitle : Charge Deduction User Setting
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.14
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.03.14 김상수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmsetup.acmsetup.basic;

import java.util.List;

import com.clt.apps.opus.esm.acm.acmsetup.acmsetup.vo.ChargeDdtSetVO;
import com.clt.apps.opus.esm.acm.acmsetup.acmsetup.vo.CntrTpSzGrpVO;
import com.clt.apps.opus.esm.acm.acmsetup.acmsetup.vo.FinanceOfficeInfoVO;
import com.clt.apps.opus.esm.acm.acmsetup.acmsetup.vo.CntrTpSelectVO;
import com.clt.apps.opus.esm.acm.acmsetup.acmsetup.vo.RevenueStrcSetVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-ACMSetup Business Logic Command Interface<br>
 * - OPUS-ACMSetup에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author KIM, Sang-Soo
 * @see Esm_Acm_0003EventResponse 참조
 * @since J2EE 1.6
 */

public interface ACMSetupBC {

	/**
	 * [ESM_ACM_0003]
	 * User Set List 목록을 조회<br>
	 *
	 * @return List<ChargeDdtSetVO>
	 * @exception EventException
	 */
	public List<ChargeDdtSetVO> searchChargeDdtSet() throws EventException;

	/**
	 * [ESM_ACM_0003]
	 * Rep.Charge 목록을 조회<br>
	 *
	 * @return List<ChargeDdtSetVO>
	 * @exception EventException
	 */
	public List<ChargeDdtSetVO> searchRepCharge() throws EventException;

	/**
	 * [ESM_ACM_0003]
	 * Charge Code 목록을 조회<br>
	 *
	 * @return List<ChargeDdtSetVO>
	 * @exception EventException
	 */
	public List<ChargeDdtSetVO> searchChargeCode() throws EventException;

	/**
	 * [ESM_ACM_0003]
	 * Charge Deduction Group Name 단건을 조회 (Validation)<br>
	 *
	 * @param ChargeDdtSetVO chargeDdtSetVO
	 * @exception EventException
	 */
	public void getChargeDdtNmInfo(ChargeDdtSetVO chargeDdtSetVO) throws EventException;

	/**
	 * [ESM_ACM_0003]
	 * Charge Code 목록을 저장<br>
	 *
	 * @param ChargeDdtSetVO[] chargeDdtSetVOs
	 * @param ChargeDdtSetVO[] chargeDdtSetRepChgVOs
	 * @param ChargeDdtSetVO[] chargeDdtSetChargeVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageChargeDdtSet(ChargeDdtSetVO[] chargeDdtSetVOs, ChargeDdtSetVO[] chargeDdtSetRepChgVOs, ChargeDdtSetVO[] chargeDdtSetChargeVOs, SignOnUserAccount account) throws EventException;

	/**
	 * [ESM_ACM_0002]
	 * User Set List 목록을 조회<br>
	 *
	 * @return List<CntrTpSzGrpVO>
	 * @exception EventException
	 */
	public List<CntrTpSzGrpVO> searchCntrTpSzGrp() throws EventException;

	/**
	 * [ESM_ACM_0002]
	 * Container TP/SZ Code 목록을 조회<br>
	 *
	 * @return List<CntrTpSzGrpVO>
	 * @exception EventException
	 */
	public List<CntrTpSzGrpVO> searchCntrTpSzList() throws EventException;

	/**
	 * [ESM_ACM_0002]
	 * Container TP/SZ Group Name 단건을 조회 (Validation)<br>
	 *
	 * @param CntrTpSzGrpVO cntrTpSzGrpVO
	 * @exception EventException
	 */
	public void getCntrTpSzGrpNmInfo(CntrTpSzGrpVO cntrTpSzGrpVO) throws EventException;

	/**
	 * [ESM_ACM_0002]
	 * Container TP/SZ Code 목록을 저장<br>
	 *
	 * @param CntrTpSzGrpVO[] cntrTpSzGrpVOs
	 * @param CntrTpSzGrpVO[] cntrTpSzGrpCodeSlctVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCntrTpSzGrp(CntrTpSzGrpVO[] cntrTpSzGrpVOs, CntrTpSzGrpVO[] cntrTpSzGrpCodeSlctVOs, SignOnUserAccount account) throws EventException;

	/**
	 * [ESM_ACM_0004]
	 * Finance Office Info 목록을 조회<br>
	 *
	 * @param FinanceOfficeInfoVO financeOfficeInfoVO
	 * @return List<FinanceOfficeInfoVO>
	 * @exception EventException
	 */
	public List<FinanceOfficeInfoVO> searchFinanceOfficeInfo(FinanceOfficeInfoVO financeOfficeInfoVO) throws EventException;

	/**
	 * [ESM_ACM_0004]
	 * Finance Office Info 목록을 저장<br>
	 *
	 * @param FinanceOfficeInfoVO[] financeOfficeInfoVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageFinanceOfficeInfo(FinanceOfficeInfoVO[] financeOfficeInfoVOs, SignOnUserAccount account) throws EventException;

	/**
	 * [ESM_ACM_0026]
	 * Revenue 인식 Charge Code 목록을 조회<br>
	 *
	 * @param RevenueStrcSetVO revenueStrcSetVO
	 * @return List<FinanceOfficeInfoVO>
	 * @exception EventException
	 */
	public List<RevenueStrcSetVO> searchRevenueStrcSet(RevenueStrcSetVO revenueStrcSetVO) throws EventException;

	/**
	 * [ESM_ACM_0026]
	 * Revenue 인식 Charge Code 목록을 저장<br>
	 *
	 * @param RevenueStrcSetVO[] revenueStrcSetVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageRevenueStrcSet(RevenueStrcSetVO[] revenueStrcSetVOs, SignOnUserAccount account) throws EventException;

	/**
	 * [ESM_ACM_0104]
	 * Container Type Selection 목록을 조회<br>
	 *
	 * @param CntrTpSelectVO mdmCntrTpVO
	 * @return List<CntrTpSelectVO>
	 * @exception EventException
	 */
	public List<CntrTpSelectVO> searchCntrTpSelect(CntrTpSelectVO mdmCntrTpVO) throws EventException;
}