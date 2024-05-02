/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CgmCodeMgtBC.java
*@FileTitle : CgmCodeMgt
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 
=========================================================*/
package com.clt.apps.opus.ees.cgm.cgmcommon.cgmcodemgt.basic;

import java.util.List;

import com.clt.apps.opus.ees.cgm.cgmcommon.cgmcodemgt.vo.AgreementINVO;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgmcodemgt.vo.AgreementMGTVO;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgmcodemgt.vo.ComboINVO;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgmcodemgt.vo.ComboMGTVO;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgmcodemgt.vo.EqOrzChtINVO;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgmcodemgt.vo.EqOrzChtMGTVO;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgmcodemgt.vo.MdmOrganizationINVO;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgmcodemgt.vo.MdmOrganizationMGTVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-Cgmcommon Business Logic Command Interface<br>
 * - OPUS-Cgmcommon Business Logic Interface<br>
 * 
 * @author KIM CHANG SIK
 * @see CgmcodemgtEventResponse reference
 * @since J2EE 1.4
 */

public interface CgmCodeMgtBC {

	/**
	 * Chassis Pool Agreement information retrieve. Retrieve. <br>
	 * 
	 * @param comboINVO
	 *            ComboINVO
	 * @return List<ComboMGTVO>
	 * @exception EventException
	 */
	public List<ComboMGTVO> searchAgreementByPoolBasic(ComboINVO comboINVO) throws EventException;

	/**
	 * Chassis Pool list retrieve. Retrieve. <br>
	 * 
	 * @param comboINVO
	 *            ComboINVO
	 * @return List<ComboMGTVO>
	 * @exception EventException
	 */
	public List<ComboMGTVO> searchPoolListBasic(ComboINVO comboINVO) throws EventException;

	/**
	 * CGM_EQ_SPEC table Spec No list retrieve. [NO_ID]<br>
	 * 
	 * @param comboINVO
	 *            ComboINVO
	 * @return List<ComboMGTVO>
	 * @exception EventException
	 */
	public List<ComboMGTVO> searchSpecListBasic(ComboINVO comboINVO) throws EventException;

	/**
	 * Retrieve Chassis or M.G.Set Type Size list. Retrieve. <br>
	 * 
	 * @param comboINVO
	 *            ComboINVO
	 * @return List<ComboMGTVO>
	 * @exception EventException
	 */
	public List<ComboMGTVO> searchEqTpszListBasic(ComboINVO comboINVO) throws EventException;

	/**
	 * MDM table Manufacture list retrieve. Retrieve. <br>
	 * 
	 * @param comboINVO
	 *            ComboINVO
	 * @return List<ComboMGTVO>
	 * @exception EventException
	 */
	public List<ComboMGTVO> searchManuListBasic(ComboINVO comboINVO) throws EventException;

	/**
	 * Neutral Pool Agreement list retrieve. Retrieve. <br>
	 * 
	 * @param comboINVO
	 *            ComboINVO
	 * @return List<ComboMGTVO>
	 * @exception EventException
	 */
	public List<ComboMGTVO> searchMgsetNoFindBasic(ComboINVO comboINVO) throws EventException;

	/**
	 * CGM common code list retrieve. Retrieve. <br>
	 * 
	 * @param comboINVO
	 *            ComboINVO
	 * @return List<ComboMGTVO>
	 * @exception EventException
	 */
	public List<ComboMGTVO> searchCommonCodeListBasic(ComboINVO comboINVO) throws EventException;

	/**
	 * MDM_VENDOR table Vendor Code and Name retrieve. Retrieve. <br>
	 * 
	 * @param comboINVO
	 *            ComboINVO
	 * @return List<ComboMGTVO>
	 * @exception EventException
	 */
	public List<ComboMGTVO> searchVendorCodeListBasic(ComboINVO comboINVO) throws EventException;

	/**
	 * MDM_STATE table State information retrieve. Retrieve. <br>
	 * 
	 * @param comboINVO
	 *            ComboINVO
	 * @return List<ComboMGTVO>
	 * @exception EventException
	 */
	public List<ComboMGTVO> searchStateCodeListBasic(ComboINVO comboINVO) throws EventException;

	/**
	 * MDM_ORGANIZATION 테이블 information retrieve. Retrieve. <br>
	 * 
	 * @param mdmOrganizationINVO
	 *            MdmOrganizationINVO
	 * @return MdmOrganizationMGTVO
	 * @exception EventException
	 */
	public MdmOrganizationMGTVO searchOrganizationBasic(MdmOrganizationINVO mdmOrganizationINVO) throws EventException;

	/**
	 * CGM_EQ_LOT Cert No list retrieve. [EES_CGM_1005]<br>
	 * 
	 * @param comboINVO
	 *            ComboINVO
	 * @return List<ComboMGTVO>
	 * @exception EventException
	 */
	public List<ComboMGTVO> searchCertChassisListBasic(ComboINVO comboINVO) throws EventException;

	/**
	 * MDM table Financing Company list retrieve. [NO_ID]<br>
	 * 
	 * @param comboINVO
	 *            ComboINVO
	 * @return List<ComboMGTVO>
	 * @exception EventException
	 */
	public List<ComboMGTVO> searchFinancingCoBasic(ComboINVO comboINVO) throws EventException;

	/**
	 * Agreement No check and retrieve. [NO_ID] <br>
	 * 
	 * @param agreementINVO
	 *            AgreementINVO
	 * @return List<AgreementMGTVO>
	 * @exception EventException
	 */
	public List<AgreementMGTVO> searchAgreementMainBasic(AgreementINVO agreementINVO) throws EventException;

	/**
	 * mdm_mvmt_sts table information retrieve. Retrieve. <br>
	 * 
	 * @param comboINVO
	 *            ComboINVO
	 * @return List<ComboMGTVO>
	 * @exception EventException
	 */
	public List<ComboMGTVO> searchMovementStatusListBasic(ComboINVO comboINVO) throws EventException;

	/**
	 * Neutral Pool Agreement list retrieve. Retrieve. <br>
	 * 
	 * @param comboINVO
	 *            ComboINVO
	 * @return List<ComboMGTVO>
	 * @exception EventException
	 */
	public List<ComboMGTVO> searchNuPoolListBasic(ComboINVO comboINVO) throws EventException;

	/**
	 * WEEK, FROM DATE, TO DATE  retrieve. Retrieve. <br>
	 * 
	 * @param comboINVO
	 *            ComboINVO
	 * @return List<ComboMGTVO>
	 * @exception EventException
	 */
	public List<ComboMGTVO> searchWeekFmToDateBasic(ComboINVO comboINVO) throws EventException;

	/**
	 * YEAR-WEEK로 WEEK, FROM DATE, TO DATE  retrieve. Retrieve. <br>
	 * 
	 * @param comboINVO
	 *            ComboINVO
	 * @return List<ComboMGTVO>
	 * @exception EventException
	 */
	public List<ComboMGTVO> searchWeekFmToDateByWeekBasic(ComboINVO comboINVO) throws EventException;

	/**
	 * RCC,LCC,SCC retrieve and Validation check. Retrieve. <br>
	 * 
	 * @param eqOrzChtINVO
	 *            EqOrzChtINVO
	 * @return List<EqOrzChtMGTVO>
	 * @exception EventException
	 */
	public List<EqOrzChtMGTVO> searchEqOrzChtBasic(EqOrzChtINVO eqOrzChtINVO) throws EventException;

	/**
	 * COST COFFICE CODE  retrieve. Retrieve. <br>
	 * 
	 * @param comboINVO
	 *            ComboINVO
	 * @return List<ComboMGTVO>
	 * @exception EventException
	 */
	public List<ComboMGTVO> searchCostOfficeBasic(ComboINVO comboINVO) throws EventException;

	/**
	 * Invoice Service Provier retrieve. Retrieve. <br>
	 * 
	 * @param comboINVO
	 *            ComboINVO
	 * @return List<ComboMGTVO>
	 * @exception EventException
	 */
	public List<ComboMGTVO> searchInvSerProviderBasic(ComboINVO comboINVO) throws EventException;

	/**
	 * Retrieve Local Time by Office Code. Retrieve. <br>
	 * 
	 * @param comboINVO
	 *            ComboINVO
	 * @return List<ComboMGTVO>
	 * @exception EventException
	 */
	public List<ComboMGTVO> searchLocalTimeByOfficeBasic(ComboINVO comboINVO) throws EventException;

	/**
	 * 
	 * @param ComboINVO comboINVO
	 * @return
	 * @throws EventException
	 */
	public List<ComboMGTVO> searchChssPoolCoListBasic(ComboINVO comboINVO) throws EventException;

	/**
	 * 
	 * @param ComboMGTVO[] comboMGTVOS
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageChssPoolCoListBasic(ComboMGTVO[] comboMGTVOS, SignOnUserAccount account) throws EventException;

	/**
	 * Local Time Retrieve. <br>
	 * 
	 * @param String ofcCd
	 * @return String
	 * @exception EventException
	 */
	public String searchLocalTimeBasic(String ofcCd) throws EventException;
}
