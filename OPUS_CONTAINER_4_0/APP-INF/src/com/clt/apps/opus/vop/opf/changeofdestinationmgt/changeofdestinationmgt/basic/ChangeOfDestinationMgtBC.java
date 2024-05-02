/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChangeOfDestinationMgtBC.java
*@FileTitle : COD Approve Main Screen
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion :
*=========================================================*/
package com.clt.apps.opus.vop.opf.changeofdestinationmgt.changeofdestinationmgt.basic;

import java.util.List;

import com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.vo.CodAuthVO;
import com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.vo.CodRehandlingInfoVO;
import com.clt.apps.opus.vop.opf.changeofdestinationmgt.changeofdestinationmgt.vo.ApprovalInformationVO;
import com.clt.apps.opus.vop.opf.changeofdestinationmgt.changeofdestinationmgt.vo.BkgCodCostListVO;
import com.clt.apps.opus.vop.opf.changeofdestinationmgt.changeofdestinationmgt.vo.CODRequestInformationVO;
import com.clt.apps.opus.vop.opf.changeofdestinationmgt.changeofdestinationmgt.vo.CODRequestListVO;
import com.clt.apps.opus.vop.opf.changeofdestinationmgt.changeofdestinationmgt.vo.ChangeOfDestinationMgtConditionVO;
import com.clt.apps.opus.vop.opf.changeofdestinationmgt.changeofdestinationmgt.vo.OpfCodDvsFeeViewVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgCodCostVO;
import com.clt.syscommon.common.table.ComIntgCdDtlVO;
import com.clt.syscommon.common.table.MdmCurrencyVO;
import com.clt.syscommon.common.table.OpfCodDvsFeeVO;
import com.clt.syscommon.common.table.OpfCodRjctCdVO;
import com.clt.syscommon.common.table.ScgRgnShpOprCdVO;

/**
 * OPUS-Changeofdestinationmgt Business Logic Command Interface<br>
 *
 * @author 
 * @see Reference Vop_opf_0033EventResponse 
 * @since J2EE 1.6
 */

public interface ChangeOfDestinationMgtBC {

	/**
	 * Retrieve COD Approval<br>
	 * 
	 * @param ChangeOfDestinationMgtConditionVO	changeOfDestinationMgtConditionVO
	 * @return List<CODRequestListVO>
	 * @exception EventException
	 */
	public List<CODRequestListVO> searchCODRequestList(ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO) throws EventException;
	
	 /**
	 * Retrieve EMAIL by RSO, LANE <br>
	 * 
	 * @param ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO
	 * @return List<CODRequestInformationVO>
	 * @exception EventException
	 */
	public List<CODRequestInformationVO> searchCODEmailsendList(ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO) throws EventException;

	 /**
	 * Retrieve CARRIER CODE of VVD chosen<br>
	 * 
	 * @param ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO
	 * @return List<CODRequestInformationVO>
	 * @exception EventException
	 */
	public List<CODRequestInformationVO> searchCODCarrierCd(ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO) throws EventException;

	 /**
	 * Retrieve NEW,OLD POD CODE of BKG chosen<br>
	 * 
	 * @param ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO
	 * @return List<CODRequestInformationVO>
	 * @exception EventException
	 */
	public List<CODRequestInformationVO> searchCODNewOldPODCd(ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO) throws EventException;

	/**
	 * Retrieve creating Combo of RSO<br>
	 * 
	 * @param ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO
	 * @return List<ScgRgnShpOprCdVO>
	 * @exception EventException
	 */
	public List<ScgRgnShpOprCdVO> searchRsoCombo(ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO) throws EventException;

	/**
	 * Retrieve creating Combo of CUR in Freight & Charges for COD<br>
	 * 
	 * @param ChangeOfDestinationMgtConditionVO   changeOfDestinationMgtConditionVO
	 * @return List<MdmCurrencyVO>
	 * @exception EventException
	 */
	public List<MdmCurrencyVO> searchCurrCdCombo(ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO) throws EventException;
	
	
	/**
	 * Retrieve creating Combo of COD Condition <br>
	 * 
	 * @param ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO
	 * @return List<ComIntgCdDtlVO>
	 * @exception EventException
	 */
	public List<ComIntgCdDtlVO> searchCodCombo(ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO) throws EventException;
	
	/**
	 * Retrieve creating Combo of Auth Result 
	 * 
	 * @return List<ComIntgCdDtlVO>
	 * @exception EventException
	 */
	public List<ComIntgCdDtlVO> searchAuthCombo() throws EventException;
	
	/**
	 * Retrieve creating Combo of COD Reason 
	 * 
	 * @return List<ComIntgCdDtlVO>
	 * @exception EventException
	 */
	public List<ComIntgCdDtlVO> searchCodRsnCombo() throws EventException;

	/**
	 * Search RSO corresponding to office of login user 
	 * 
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String searchOfcRso(SignOnUserAccount account) throws EventException;

	/**
	 * Retrieve creating Combo of Reject Reason <br>
	 * 
	 * @param ChangeOfDestinationMgtConditionVO   changeOfDestinationMgtConditionVO
	 * @return List<OpfCodRjctCdVO>
	 * @exception EventException
	 */
	public List<OpfCodRjctCdVO> searchCODRejectCodeList(ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO) throws EventException;

	
	/**
	 * Retrieve COD Request Information .<br>
	 * 
	 * @param ChangeOfDestinationMgtConditionVO	changeOfDestinationMgtConditionVO
	 * @return List<CODRequestInformationVO>
	 * @exception EventException
	 */
	public List<CODRequestInformationVO> searchCODDetail(ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO) throws EventException;

	/**
	 * Retrieve Approval Information .<br>
	 * 
	 * @param ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO
	 * @return List<ApprovalInformationVO>
	 * @exception EventException
	 */
	public List<ApprovalInformationVO> searchRsoDetail(ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO) throws EventException;
	
	/**
	 * Retrieve Freight & Charges for COD .<br>
	 * 
	 * @param ChangeOfDestinationMgtConditionVO	changeOfDestinationMgtConditionVO
	 * @return List<BkgCodCostVO>
	 * @exception EventException
	 */
	public List<BkgCodCostVO> searchRehandlingList(ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO) throws EventException;	

	/**
	 * Retrieve CHR, CUR, Rate in case of Row Add <br>
	 * 
	 * @param ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO
	 * @param CodRehandlingInfoVO codRehandlingInfoVO
	 * @return List<BkgCodCostListVO>
	 * @exception EventException
	 */
	public List<BkgCodCostListVO> searchRehandlingQTY(ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO, CodRehandlingInfoVO codRehandlingInfoVO) throws EventException;

	/**
	 * Retrieve Container List in case of CNTR Q'ty .<br>
	 * 
	 * @param ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO
	 * @param CodRehandlingInfoVO codRehandlingInfoVO
	 * @return List<BkgCodCostListVO>
	 * @exception EventException
	 */
	public List<BkgCodCostListVO> searchRehandlingContainerList(ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO, CodRehandlingInfoVO codRehandlingInfoVO) throws EventException;
	
	/**
	 * Check validation in case of CNTR Type/SIZE<br>
	 * 
	 * @param ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO
	 * @return List<BkgCodCostVO>
	 * @exception EventException
	 */
	public List<BkgCodCostVO> searchRatUtCdCheck(ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO) throws EventException;	
	
	/**
	 * Retrieve CHR, CUR, Rate .<br>
	 * 
	 * @param ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO
	 * @param String strCurrCd
	 * @param String strRate
	 * @return List<BkgCodCostVO>
	 * @exception EventException
	 */
	public List<BkgCodCostVO> searchRehandlingRate(ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO, String strCurrCd, String strRate) throws EventException;	
	
	/**
	 * Retrieve Bay Plan .<br>
	 * 
	 * @param ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO
	 * @return List<ChangeOfDestinationMgtConditionVO>
	 * @exception EventException
	 */
	public List<ChangeOfDestinationMgtConditionVO> searchBayPlanCheck(ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO) throws EventException;

	/**
	 *Retrieve Region COD MIN. Tariff .<br>
	 * 
	 * @param ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO
	 * @return List<OpfCodDvsFeeVO>
	 * @exception EventException
	 */
	public List<OpfCodDvsFeeVO> searchDiversionList(ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO) throws EventException;

	/**
	 * Retrieve Region COD MIN. Tariff View .<br>
	 * 
	 * @param ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO	
	 * @return List<OpfCodDvsFeeViewVO>
	 * @exception EventException
	 */
	public List<OpfCodDvsFeeViewVO> searchDiversionViewList(ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO) throws EventException;
	
	/**
	 * Save Region COD MIN. Tariff <br>
	 * 
	 * @param OpfCodDvsFeeVO[] opfCodDvsFeeVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCodDivFee(OpfCodDvsFeeVO[] opfCodDvsFeeVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * COD Diversion Rate 을 조회 합니다.<br>
	 * 
	 * @param ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO
	 * @return List<BkgCodCostVO>
	 * @exception EventException
	 */ 
	public List<BkgCodCostVO> searchCODDiversionChargeCalc(ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO) throws EventException;
	
	/**
	 * Remark정보를 저장합니다.<br>
	 * 
	 * @param CodAuthVO codAuthVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */ 
	public void saveRemark(CodAuthVO codAuthVO, SignOnUserAccount account) throws EventException;
	
	
}