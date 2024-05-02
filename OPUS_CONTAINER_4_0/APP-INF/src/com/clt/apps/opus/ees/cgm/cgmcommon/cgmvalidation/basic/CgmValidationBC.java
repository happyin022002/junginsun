/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CgmValidationBC.java
 *@FileTitle : cgm_validation
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 
=========================================================*/
package com.clt.apps.opus.ees.cgm.cgmcommon.cgmvalidation.basic;

import java.util.List;

import com.clt.apps.opus.ees.cgm.cgmcommon.cgmvalidation.vo.AgrementINVO;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgmvalidation.vo.AgrementMGTVO;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgmvalidation.vo.CgmChssPoolINVO;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgmvalidation.vo.CgmChssPoolMGTVO;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgmvalidation.vo.ChsMasterMGTVO;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgmvalidation.vo.LocationMGTVO;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgmvalidation.vo.MdmCurrencyMGTVO;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgmvalidation.vo.MdmVendorMGTVO;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgmvalidation.vo.OfficeINVO;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgmvalidation.vo.OfficeMGTVO;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgmvalidation.vo.TpSzDupChkINVO;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgmvalidation.vo.TpSzDupChkMGTVO;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgmvalidation.vo.YardINVO;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgmvalidation.vo.YardMGTVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-Cgmcommon Business Logic Command Interface<br>
 * - OPUS-Cgmcommon Business Logic Interface<br>
 * 
 * @author KIM CHANG SIK
 * @see Cgm_validationEventResponse reference
 * @since J2EE 1.6
 */

public interface CgmValidationBC {

	/**
	 * Office code check . Retrieve. <br>
	 * 
	 * @param officeINVO
	 *            OfficeINVO
	 * @return List<OfficeMGTVO>
	 * @exception EventException
	 */
	public List<OfficeMGTVO> checkOfficeBasic(OfficeINVO officeINVO) throws EventException;

	/**
	 * yard code valid check . Retrieve. <br>
	 * 
	 * @param yardINVO
	 *            YardINVO
	 * @return List<YardMGTVO>
	 * @exception EventException
	 */
	public List<YardMGTVO> checkYardBasic(YardINVO yardINVO) throws EventException;

	/**
	 * available yard code valid check . Retrieve. <br>
	 * 
	 * @param yardINVO
	 *            YardINVO
	 * @return List<YardMGTVO>
	 * @exception EventException
	 */
	public List<YardMGTVO> checkYardAvailableYardBasic(YardINVO yardINVO) throws EventException;

	/**
	 * Agreement existing check . Retrieve. <br>
	 * 
	 * @param agrementINVO
	 *            AgrementINVO
	 * @return List<AgrementMGTVO>
	 * @exception EventException
	 */
	public List<AgrementMGTVO> checkAgreementBasic(AgrementINVO agrementINVO) throws EventException;

	/**
	 * CGM EQUIPMENT table Chassis master information retrieve . Retrieve. <br>
	 * 
	 * @param chsMasterMGTVO
	 *            ChsMasterMGTVO
	 * @return List<ChsMasterMGTVO>
	 * @exception EventException
	 */
	public List<ChsMasterMGTVO> searchCGMMasterBasic(ChsMasterMGTVO chsMasterMGTVO) throws EventException;

	/**
	 * Retrieve DM_VENDOR table Vendor information . Retrieve. <br>
	 * 
	 * @param mdmVendorMGTVO
	 *            MdmVendorMGTVO
	 * @return List<MdmVendorMGTVO>
	 * @exception EventException
	 */
	public List<MdmVendorMGTVO> searchVendorListBasic(MdmVendorMGTVO mdmVendorMGTVO) throws EventException;

	/**
	 * CGM_EQ_TP_SZ table information retrieve . Retrieve. <br>
	 * 
	 * @param tpSzDupChkINVO
	 *            TpSzDupChkINVO
	 * @return List<TpSzDupChkMGTVO>
	 * @exception EventException
	 */
	public List<TpSzDupChkMGTVO> searchEqTpSzDupChkBasic(TpSzDupChkINVO tpSzDupChkINVO) throws EventException;

	/**
	 * MST_CONTAINER information retrieve . Retrieve. <br>
	 * 
	 * @param chsMasterMGTVO
	 *            ChsMasterMGTVO
	 * @return List<ChsMasterMGTVO>
	 * @exception EventException
	 */
	public List<ChsMasterMGTVO> searchCNTRMasterBasic(ChsMasterMGTVO chsMasterMGTVO) throws EventException;

	/**
	 * Location Code check . Retrieve. <br>
	 * 
	 * @param locationMGTVO
	 *            LocationMGTVO
	 * @return List<LocationMGTVO>
	 * @exception EventException
	 */
	public List<LocationMGTVO> checkLocationBasic(LocationMGTVO locationMGTVO) throws EventException;

	/**
	 * CGM_CHSS_POOL table information retrieve Retrieve. <br>
	 * 
	 * @param cgmChssPoolINVO
	 *            CgmChssPoolINVO
	 * @return List<CgmChssPoolMGTVO>
	 * @exception EventException
	 */
	public List<CgmChssPoolMGTVO> seachChssPoolListBasic(CgmChssPoolINVO cgmChssPoolINVO) throws EventException;

	/**
	 * MDM_CURRENCY table information retrieve Retrieve. <br>
	 * 
	 * @param mdmCurrencyMGTVO
	 *            MdmCurrencyMGTVO
	 * @return List<MdmCurrencyMGTVO>
	 * @exception EventException
	 */
	public List<MdmCurrencyMGTVO> searchMDMCurrencyBasic(MdmCurrencyMGTVO mdmCurrencyMGTVO) throws EventException;

	/**
	 * Location Code check . Retrieve. <br>
	 * 
	 * @param locationMGTVO
	 *            LocationMGTVO
	 * @return List<LocationMGTVO>
	 * @exception EventException
	 */
	public List<LocationMGTVO> searchOfficeYardControlOfficeMatchBasic(LocationMGTVO locationMGTVO) throws EventException;
}