/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChassisMgsetOnOffhireBC.java
*@FileTitle : Chassis Specification Creation
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.basic;

import java.util.List;

import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.CHSTermStatusINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.MGSTermStatusINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSEqPoolInfoINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSEqPoolInfoMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSEqSpecINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSEqSpecMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSEqTpSzINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSEqTpSzMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSEquipmentINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSEquipmentMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSFoundAutoMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSFoundLostINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSFoundLostMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSLostResultINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSLostResultMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSMasterInfoINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSMasterInfoMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSMasterMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSOffHireINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSOffHireMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSOnHireINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSOnHireMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSOnOffhireSummaryINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSOnOffhireSummaryMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSSpecINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSSpecMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSStatusInfoINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSStatusInfoMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.ErpFaInterfaceINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.ErpFaInterfaceMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSAtdtHistoryMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSEqSpecINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSEqSpecMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSEqTpSzINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSEqTpSzMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSEquipmentINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSEquipmentMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSFoundLostINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSFoundLostMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSLostResultINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSLostResultMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSOffHireINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSOffHireMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSOnHireINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSOnHireMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSOnOffhireSummaryINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSOnOffhireSummaryMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSSpecINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSSpecMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSStatusInfoINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSStatusInfoMGTVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.vo.IFMnrFlagVO;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.vo.CntrMasterUpdateIFVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-Chassismgsetmgt Business Logic Command Interface<br>
 * - OPUS-Chassismgsetmgt Business Logic Interface<br>
 *
 * @author 
 * @see ees_cgm_1002EventResponse reference
 * @since J2EE 1.4
 */

public interface ChassisMgsetOnOffhireBC {

	/**
	 * chassis Eq Type Size List  retrieve. Retrieve [EES_CGM_1001]<br>
	 *
	 * @param cHSEqTpSzINVO CHSEqTpSzINVO
	 * @return List<CHSEqTpSzMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<CHSEqTpSzMGTVO> searchCHSEqTypeSizeListBasic(CHSEqTpSzINVO cHSEqTpSzINVO) throws EventException;

	/**
	 * chassis Eq Type Size를 수정한다. Manage [EES_CGM_1001]<br>
	 *
	 * @param CHSEqTpSzINVOs CHSEqTpSzINVO[]
	 * @param account SignOnUserAccount
	 * @exception DAOException
	 * @exception Exception
	 */
	public void manageCHSEqTypeSizeBasic(CHSEqTpSzINVO[] CHSEqTpSzINVOs, SignOnUserAccount account) throws EventException;

	/**
	 * M.G.Set Eq Type Size List  retrieve. Retrieve [EES_CGM_2083]<br>
	 *
	 * @param mGSEqTpSzINVO MGSEqTpSzINVO
	 * @return List<MGSEqTpSzMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<MGSEqTpSzMGTVO> searchMGSEqTypeSizeListBasic(MGSEqTpSzINVO mGSEqTpSzINVO) throws EventException;


	/**
	 * Retrieve existing equipment that same Type Size of chassis and M.G.Set (CGM_EQUIPMENT). Retrieve [EES_CGM_1001]<br>
	 *
	 * @param cHSEqTpSzINVO CHSEqTpSzINVO
	 * @return List<CHSEqTpSzMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<CHSEqTpSzMGTVO> searchCHSEqTypeSizeInEqChkBasic(CHSEqTpSzINVO cHSEqTpSzINVO) throws EventException;

	/**
	 * Retrieve existing equipment that same Type Size of chassis and M.G.Set (CGM_EQUIPMENT). Retrieve [EES_CGM_2083]<br>
	 *
	 * @param mGSEqTpSzINVO MGSEqTpSzINVO
	 * @return List<MGSEqTpSzMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<MGSEqTpSzMGTVO> searchMGSEqTypeSizeInEqChkBasic(MGSEqTpSzINVO mGSEqTpSzINVO) throws EventException;

	/**
	 * M.G.Set Eq Type Size modification. Manage [EES_CGM_2083]<br>
	 *
	 * @param mGSEqTpSzINVOs MGSEqTpSzINVO[]
	 * @param account SignOnUserAccount
	 * @exception DAOException
	 * @exception Exception
	 */
	public void manageMGSEqTypeSizeBasic(MGSEqTpSzINVO[] mGSEqTpSzINVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Retrieve Eq spec information of chassis. Retrieve [EES_CGM_1002]<br>
	 *
	 * @param cHSEqSpecINVO CHSEqSpecINVO
	 * @return List<CHSEqSpecMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<CHSEqSpecMGTVO> searchCHSEqSpecBasic(CHSEqSpecINVO cHSEqSpecINVO) throws EventException;

	/**
	 * Retrieve existing equipment that match to Eq sper of chassis. Retrieve [EES_CGM_1002]<br>
	 *
	 * @param cHSEqSpecINVO CHSEqSpecINVO
	 * @return List<CHSEqSpecMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<CHSEqSpecMGTVO> searchCHSEqInEqSpecBasic(CHSEqSpecINVO cHSEqSpecINVO) throws EventException;

	/**
	 * Eq spec information of chassis creation/modification. Manage [EES_CGM_1002]<br>
	 *
	 * @param cHSEqSPECINVOs CHSEqSpecINVO[]
	 * @param account SignOnUserAccount
	 * @exception DAOException
	 * @exception Exception
	 */
	public void modifyCHSEqSpecBasic(CHSEqSpecINVO[] cHSEqSPECINVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Eq spec information of chassis deleting. Remove [EES_CGM_1002]<br>
	 *
	 * @param cHSEqSPECINVOs CHSEqSpecINVO[]
	 * @param account SignOnUserAccount
	 * @exception DAOException
	 * @exception Exception
	 */
	public void removeCHSEqSpecBasic(CHSEqSpecINVO[] cHSEqSPECINVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Retrieve Information of Eq Master. Retrieve. [EES_CGM_1009]<br>
	 *
	 * @param chsOffHireINVO CHSOffHireINVO
	 * @return List<CHSOffHireMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<CHSOffHireMGTVO> searchCHSOffhireInfoBasic(CHSOffHireINVO chsOffHireINVO) throws EventException;


	/**
	 * Verify for Eq Off-hire action [EES_CGM_1009]<br>
	 *
	 * @param cHSOffHireMGTVOs CHSOffHireMGTVO[]
	 * @return List<CHSOffHireMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<CHSOffHireMGTVO> verifyCHSOffhireBasic(CHSOffHireMGTVO[] cHSOffHireMGTVOs) throws EventException;

	/**
	 * Eq Offhire action. Off-Hire Confim [EES_CGM_1009]<br>
	 *
	 * @param cHSOffHireMGTVOs CHSOffHireMGTVO[]
	 * @param account SignOnUserAccount
	 * @exception DAOException
	 * @exception Exception
	 */
    public void manageCHSOffhireEquipmentBasic(CHSOffHireMGTVO[] cHSOffHireMGTVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Retrieve Information of Eq Master. Retrieve. [EES_CGM_2011]<br>
	 *
	 * @param mgsOffHireINVO MGSOffHireINVO
	 * @return List<MGSOffHireMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<MGSOffHireMGTVO> searchMGSOffhireInfoBasic(MGSOffHireINVO mgsOffHireINVO) throws EventException;

	/**
	 * Verify for Eq Off-hire action [EES_CGM_2011]<br>
	 *
	 * @param mgsOffHireINVOs MGSOffHireMGTVO[]
	 * @return  List<MGSOffHireMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<MGSOffHireMGTVO> verifyMGSOffhireBasic(MGSOffHireMGTVO[] mgsOffHireINVOs) throws EventException;

	/**
	 * Eq Offhire action. Off-Hire Confim [EES_CGM_2011]<br>
	 *
	 * @param mGSOffHireMGTVOs MGSOffHireMGTVO[]
     * @param account SignOnUserAccount
	 * @exception DAOException
	 * @exception Exception
	 */
    public void manageMGSOffhireEquipmentBasic(MGSOffHireMGTVO[] mGSOffHireMGTVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Retrieve Eq spec informatio of M.G.Set. Retrieve [EES_CGM_2001]<br>
	 *
	 * @param mGSEqSpecINVO MGSEqSpecINVO
	 * @return List<MGSEqSpecMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<MGSEqSpecMGTVO> searchMGSEqSpecBasic(MGSEqSpecINVO mGSEqSpecINVO) throws EventException;

	/**
	 * M.G.Set Eq Eq spec information duplication checking. Retrieve [EES_CGM_2001]<br>
	 *
	 * @param mGSEqSpecINVO MGSEqSpecINVO
	 * @return List<MGSEqSpecMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<MGSEqSpecMGTVO> searchMGSEqSpecDupBasic(MGSEqSpecINVO mGSEqSpecINVO) throws EventException;

	/**
	 * M.G.Set Eq spec information creation/modification. Manage [EES_CGM_2001]<br>
	 *
	 * @param mGSEqSPECINVOs MGSEqSpecINVO[]
	 * @param account SignOnUserAccount
	 * @exception DAOException
	 * @exception Exception
	 */
	public void modifyMGSEqSpecBasic(MGSEqSpecINVO[] mGSEqSPECINVOs, SignOnUserAccount account) throws EventException;

	/**
	 * M.G.Set Eq spec information deleting. Remove [EES_CGM_2001]<br>
	 *
	 * @param mGSEqSPECINVOs MGSEqSpecINVO[]
	 * @param account SignOnUserAccount
	 * @exception DAOException
	 * @exception Exception
	 */
	public void removeMGSEqSpecBasic(MGSEqSpecINVO[] mGSEqSPECINVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Eq On-hire, Off-hire Retrieve. [EES_CGM_1010]<br>
	 *
	 * @param cHSOnOffhireSummaryINVO CHSOnOffhireSummaryINVO
	 * @return List<CHSOnOffhireSummaryMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public  List<CHSOnOffhireSummaryMGTVO> searchCHSOnOffhireBasic(CHSOnOffhireSummaryINVO cHSOnOffhireSummaryINVO) throws EventException;

	/**
	 * Retrieve Chassis Registration information. Retrieve [EES_CGM_1006]<br>
	 *
	 * @param cHSEquipmentINVO CHSEquipmentINVO
	 * @return List<CHSEquipmentMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<CHSEquipmentMGTVO> searchCHSEqRegistrationBasic(CHSEquipmentINVO cHSEquipmentINVO) throws EventException;

	/**
	 * Retrieve duplication of Alias No. Retrieve [EES_CGM_1006]<br>
	 *
	 * @param cHSEquipmentINVO CHSEquipmentINVO
	 * @return List<CHSEquipmentMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<CHSEquipmentMGTVO> searchCHSAliasNoBasic(CHSEquipmentINVO cHSEquipmentINVO) throws EventException;

	/**
	 * Chassis Registration information creation/modification. Manage [EES_CGM_1006]<br>
	 *
	 * @param cHSEquipmentINVOs CHSEquipmentINVO[]
	 * @param account SignOnUserAccount
	 * @exception DAOException
	 * @exception Exception
	 */
	public void modifyCHSEqRegistrationBasic(CHSEquipmentINVO[] cHSEquipmentINVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Retrieve Eq On-hire, Off-hire list Retrieve. [EES_CGM_2012]<br>
	 *
	 * @param mgsOnOffhireSummaryINVO MGSOnOffhireSummaryINVO
	 * @return List<MGSOnOffhireSummaryMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public  List<MGSOnOffhireSummaryMGTVO> searchMGSOnOffhireBasic(MGSOnOffhireSummaryINVO mgsOnOffhireSummaryINVO) throws EventException;



//	public void createMNRStatusBasic(List<IFMnrFlagVO> IFMnrFlagVOs) throws EventException;

	/**
	 * Retrieve chassis Pool. Retrieve [EES_CGM_1007]<br>
	 *
	 * @param cHSEqPoolInfoINVO CHSEqPoolInfoINVO
	 * @return List<CHSEqPoolInfoMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<CHSEqPoolInfoMGTVO> searchCHSEqiPoolListBasic(CHSEqPoolInfoINVO cHSEqPoolInfoINVO) throws EventException;

	/**
	 * chassis Pool Manage. Manage [EES_CGM_1007]<br>
	 *
	 * @param cHSEquPoolInfoINVOs CHSEqPoolInfoINVO[]
	 * @param account SignOnUserAccount
	 * @exception DAOException
	 * @exception Exception
	 */
	public void modifyCHSEqPoolListBasic(CHSEqPoolInfoINVO[] CHSEquPoolInfoINVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Eq Master information retrieve Retrieve. [EES_CGM_1017]<br>
	 *
	 * @param cHSFoundLostINVO CHSFoundLostINVO
	 * @return List<CHSFoundLostMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<CHSFoundLostMGTVO> searchCHSInfoBasic(CHSFoundLostINVO cHSFoundLostINVO) throws EventException;

	/**
	 * Lost handling.. SAVE. [EES_CGM_1017]<br>
	 *
	 * @param cHSFoundLostMGTVO CHSFoundLostMGTVO
	 * @param account SignOnUserAccount
	 * @exception DAOException
	 * @exception Exception
	 */
	public void manageCHSLostBasic(CHSFoundLostMGTVO cHSFoundLostMGTVO, SignOnUserAccount account)throws EventException;

	/**
	 * Found handling lose Eq. SAVE. [EES_CGM_1017]<br>
	 *
	 * @param chsEqFoundLostMGTVO CHSFoundLostMGTVO
     * @param account SignOnUserAccount
	 * @exception DAOException
	 * @exception Exception
	 */
	public void manageCHSFoundBasic(CHSFoundLostMGTVO chsEqFoundLostMGTVO, SignOnUserAccount account)throws EventException;

	/**
	 * Eq Master information retrieve Retrieve. [EES_CGM_2019]<br>
	 *
	 * @param mGSFoundLostINVO MGSFoundLostINVO
	 * @return List<MGSFoundLostMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<MGSFoundLostMGTVO> searchMGSInfoBasic(MGSFoundLostINVO mGSFoundLostINVO) throws EventException;

	/**
	 * Lost handling.. SAVE. [EES_CGM_2019]<br>
	 *
	 * @param mgsEqFoundLostMGTVO MGSFoundLostMGTVO
	 * @param account SignOnUserAccount
	 * @exception DAOException
	 * @exception Exception
	 */
	public void manageMGSLostBasic(MGSFoundLostMGTVO mgsEqFoundLostMGTVO, SignOnUserAccount account)throws EventException;

	/**
	 * Found handling lose Eq. SAVE. [EES_CGM_2019]<br>
	 *
	 * @param mgsEqFoundLostMGTVO MGSFoundLostMGTVO
	 * @param account SignOnUserAccount
	 * @exception DAOException
	 * @exception Exception
	 */
	public void manageMGSFoundBasic(MGSFoundLostMGTVO mgsEqFoundLostMGTVO, SignOnUserAccount account)throws EventException;

	/**
	 * Chassis Retrieve Information of Eq Master. Retrieve [EES_CGM_1003]<br>
	 *
	 * @param cHSMasterInfoINVO CHSMasterInfoINVO
	 * @return List<CHSMasterInfoMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<CHSMasterInfoMGTVO> searchCHSMasterInfoBasic(CHSMasterInfoINVO cHSMasterInfoINVO) throws EventException;

	/**
	 * Retrieve summary of Eq lost list.. Retrieve. [EES_CGM_1019]<br>
	 *
	 * @param chsLostResultINVO CHSLostResultINVO
	 * @return List<CHSLostResultMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<CHSLostResultMGTVO> searchCHSLostResultBasic(CHSLostResultINVO chsLostResultINVO) throws EventException;

	/**
	 * M.G.Set Retrieve Information of Eq Master. Retrieve [EES_CGM_2006]<br>
	 *
	 * @param mGSEquipmentINVO MGSEquipmentINVO
	 * @return List<MGSEquipmentMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<MGSEquipmentMGTVO> searchMGSEquipmentBasic(MGSEquipmentINVO mGSEquipmentINVO) throws EventException;


	/**
	 * M.G.Set Eq Master At/Dt information retrieve. Retrieve [EES_CGM_2006]<br>
	 *
	 * @param mGSEquipmentINVO MGSEquipmentINVO
	 * @return List<MGSAtdtHistoryMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<MGSAtdtHistoryMGTVO> searchMGSAtdtHistoryBasic(MGSEquipmentINVO mGSEquipmentINVO) throws EventException;


	/**
	 * Retrieve chassis that ATTACHED to MGSET in ChassisMgsetOnOffhire. Retrieve [EES_CGM_2006]<br>
	 *
	 * @param mGSEquipmentINVO MGSEquipmentINVO
	 * @return List<MGSEquipmentMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<MGSEquipmentMGTVO> searchMGSEquipmentAtChssBasic(MGSEquipmentINVO mGSEquipmentINVO) throws EventException;

	/**
	 * M.G.Set Eq Master information modification. Manage [EES_CGM_2006]<br>
	 *
	 * @param mGSEquipmentINVOs MGSEquipmentINVO[]
	 * @param account SignOnUserAccount
	 * @exception DAOException
	 * @exception Exception
	 */
	public void modifyMGSEquipmentBasic(MGSEquipmentINVO[] mGSEquipmentINVOs, SignOnUserAccount account)throws EventException;

	/**
	 * Retrieve summary of Eq lost list.. Retrieve. [EES_CGM_2020]<br>
	 *
	 * @param mGSLostResultINVO MGSLostResultINVO
	 * @return List<MGSLostResultMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<MGSLostResultMGTVO> searchMGSLostResultBasic(MGSLostResultINVO mGSLostResultINVO) throws EventException;


	/**
	 * Spec info Valiation Check. [EES_CGM_1005]<br>
	 *
	 * @param cHSSpecINVO CHSSpecINVO
	 * @return List<CHSSpecMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<CHSSpecMGTVO> searchEqSpecChkBasic(CHSSpecINVO cHSSpecINVO) throws EventException;

	/**
	 * chassis and M.G.Set  SerialNo FM-TO duplication checking. Retrieve [EES_CGM_1005]<br>
	 *
	 * @param cHSSpecINVO CHSSpecINVO
	 * @return List<CHSSpecMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<CHSSpecMGTVO> searchEqSpecChkFmToBasic(CHSSpecINVO cHSSpecINVO) throws EventException;


	/**
	 * Eq spec information retrieve. [EES_CGM_1005]<br>
	 *
	 * @param cHSSpecINVO CHSSpecINVO
	 * @return List<CHSSpecMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<CHSSpecMGTVO> searchCHSSpecBasic(CHSSpecINVO cHSSpecINVO) throws EventException;

	/**
	 * Retrieve Eq Own Master(LOT) list.[EES_CGM_1005]<br>
	 *
	 * @param cHSSpecINVO CHSSpecINVO
	 * @return List<CHSSpecMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<CHSSpecMGTVO> searchCHSOwnMasterListBasic(CHSSpecINVO cHSSpecINVO) throws EventException;

	/**
	 * Own Master(Lot information) creation -> LOT information creation and Updating. [UI_CGM_1005, UI_CGM_2004]<br>
	 *
	 * @param cHSSpecINVOs CHSSpecINVO[]
	 * @param account SignOnUserAccount
	 * @exception DAOException
	 * @exception Exception
	 */
	public void  manageCHSOwnMasterBasic(CHSSpecINVO[] cHSSpecINVOs, SignOnUserAccount account) throws EventException;

	/**
	 *  Retrieve Eq status History. Retrieve. [EES_CGM_1016]<br>
	 *
	 * @param chsStatusInfoINVO CHSStatusInfoINVO
	 * @return List<CHSStatusInfoMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<CHSStatusInfoMGTVO> searchCHSStatusBasic(CHSStatusInfoINVO chsStatusInfoINVO) throws EventException;

	/**
	 *  Eq Status modification/deleting. Found Creation. [EES_CGM_1016]<br>
	 *
	 * @param cHSStatusInfoMGTVOs CHSStatusInfoMGTVO[]
	 * @param account SignOnUserAccount
	 * @exception DAOException
	 * @exception Exception
	 */
	public void modifyCHSStatusBasic(CHSStatusInfoMGTVO[] cHSStatusInfoMGTVOs, SignOnUserAccount account) throws EventException;

	/**
	 *  Eq Status modification/deleting. Delete [EES_CGM_1016]<br>
	 *
	 * @param cHSStatusInfoMGTVOs CHSStatusInfoMGTVO[]
	 * @param account SignOnUserAccount
	 * @return CHSStatusInfoMGTVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public CHSStatusInfoMGTVO removeCHSStatusBasic(CHSStatusInfoMGTVO[] cHSStatusInfoMGTVOs, SignOnUserAccount account) throws EventException;

	/**
	 *  Retrieve Eq status History. Retrieve. [EES_CGM_2018]<br>
	 *
	 * @param mGSStatusInfoINVO MGSStatusInfoINVO
	 * @return List<MGSStatusInfoMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<MGSStatusInfoMGTVO> searchMGSStatusBasic(MGSStatusInfoINVO mGSStatusInfoINVO) throws EventException;

	/**
	 *  Eq Status modification/deleting. Found Creation. [EES_CGM_2018]<br>
	 *
	 * @param mGSStatusInfoMGTVOs MGSStatusInfoMGTVO[]
     * @param account SignOnUserAccount
	 * @exception DAOException
	 * @exception Exception
	 */
	public void modifyMGSStatusBasic(MGSStatusInfoMGTVO[] mGSStatusInfoMGTVOs, SignOnUserAccount account) throws EventException;

	/**
	 *  Eq Status modification/deleting. Delete [EES_CGM_2018]<br>
	 *
	 * @param mGSStatusInfoMGTVOs MGSStatusInfoMGTVO[]
	 * @param account SignOnUserAccount
	 * @exception DAOException
	 * @exception Exception
	 */
	public void removeMGSStatusBasic(MGSStatusInfoMGTVO[] mGSStatusInfoMGTVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Retrieve duplication of M.G.Set Eq spec. Retrieve [EES_CGM_2004]<br>
	 *
	 * @param mGSSpecINVO MGSSpecINVO
	 * @return List<MGSSpecMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<MGSSpecMGTVO> searchMGSSpecChkBasic(MGSSpecINVO mGSSpecINVO) throws EventException;

	/**
	 * M.G.Set Retrieve Eq Own Master(LOT) list. Retrieve [EES_CGM_2004]<br>
	 *
	 * @param mGSSpecINVO MGSSpecINVO
	 * @return List<MGSSpecMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<MGSSpecMGTVO> searchMGSOwnMasterListBasic(MGSSpecINVO mGSSpecINVO) throws EventException;

	/**
	 * Retrieve Eq spec informatio of M.G.Set. Retrieve [EES_CGM_2004]<br>
	 *
	 * @param mGSSpecINVO MGSSpecINVO
	 * @return List<MGSSpecMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<MGSSpecMGTVO> searchMGSSpecBasic(MGSSpecINVO mGSSpecINVO) throws EventException;

	/**
	 * M.G.Set Eq spec information creation/modification. Manage [EES_CGM_2004]<br>
	 *
	 * @param mGSSpecINVO MGSSpecINVO[]
	 * @param account SignOnUserAccount
	 * @exception DAOException
	 * @exception Exception
	 */
	public void manageMGSOwnMasterBasic(MGSSpecINVO[] mGSSpecINVO, SignOnUserAccount account) throws EventException;

	/**
	 *  Retrieve On-Hire Chassis No info and status.. [EES_CGM_1008]<br>
	 *
	 * @param cHSOnHireINVO CHSOnHireINVO
	 * @return List<CHSOnHireMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<CHSOnHireMGTVO> searchCHSOnHireStatusChkBasic(CHSOnHireINVO cHSOnHireINVO) throws EventException;

	/**
	 *  Check chss_veh_id_no, chss_tit_no, chss_als_no of chassis in case of On-Hire. [EES_CGM_1008]<br>
	 *
	 * @param cHSOnHireINVO CHSOnHireINVO
	 * @return List<CHSOnHireMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<CHSOnHireMGTVO> searchCHSOnHireDupChkBasic(CHSOnHireINVO cHSOnHireINVO) throws EventException;

	/**
	 *  Lease Eq checking method. [EES_CGM_1008]<br>
	 *
	 * @param cHSOnHireINVO CHSOnHireINVO
	 * @return List<CHSOnHireMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<CHSOnHireMGTVO> searchCHSOwnLeaseChkBasic(CHSOnHireINVO cHSOnHireINVO) throws EventException;

	/**
	 * Eq Onhire action. [EES_CGM_1008]<br>
	 *
	 * @param cHSOnHireINVOs CHSOnHireMGTVO[]
	 * @return List<CHSOnHireMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<CHSOnHireMGTVO> verifyCHSOnhireBasic(CHSOnHireMGTVO[] cHSOnHireINVOs) throws EventException;

	/**
	 *  Verify handling for Eq On-hire action. [EES_CGM_1008]<br>
	 *
	 * @param cHSOnHireINVOs CHSOnHireMGTVO[]
	 * @param account SignOnUserAccount
	 * @exception DAOException
	 * @exception Exception
	 */
	public void manageCHSOnhireBasic(CHSOnHireMGTVO[] cHSOnHireINVOs, SignOnUserAccount account) throws EventException;

	/**
	 *  Retrieve On-Hire M.GSET No info and status... [EES_CGM_2007]<br>
	 *
	 * @param mGSOnHireINVO MGSOnHireINVO
	 * @return List<MGSOnHireMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<MGSOnHireMGTVO> searchMGSOnHireStatusChkBasic(MGSOnHireINVO mGSOnHireINVO) throws EventException;


	/**
	 *  On-Hire Retrieve  Model No. voltage, fuel capacity in case of On-Hire  retrieve. [EES_CGM_2007]<br>
	 *
	 * @param mGSOnHireINVO MGSOnHireINVO
	 * @return List<MGSOnHireMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<MGSOnHireMGTVO> searchMGSOnHireEqSpecNoChkBasic(MGSOnHireINVO mGSOnHireINVO) throws EventException;

	/**
	 *  Verify handling for Eq On-hire action. [EES_CGM_2007]<br>
	 *
	 * @param mGSOnHireMGTVOs MGSOnHireMGTVO[]
	 * @return List<MGSOnHireMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<MGSOnHireMGTVO> verifyMGSOnhireBasic(MGSOnHireMGTVO[] mGSOnHireMGTVOs) throws EventException;

	/**
	 * Eq Onhire action.  [EES_CGM_2007]<br>
	 *
	 * @param mGSOnHireINVOs MGSOnHireMGTVO[]
     * @param account SignOnUserAccount
	 * @exception DAOException
	 * @exception Exception
	 */
    public void manageMGSOnhireBasic(MGSOnHireMGTVO[] mGSOnHireINVOs, SignOnUserAccount account) throws EventException;

	
	/**
	 * ERP FA I/F event list. FNS026-R001 Receive. [IF_CGM_003]<br>
	 * @param cntrMasterUpdateIFVOs		CntrMasterUpdateIFVO[]
	 * @param account	SignOnUserAccount
	 * @exception DAOException
	 * @exception Exception
	 */
    public void receiveFABasic(CntrMasterUpdateIFVO[] cntrMasterUpdateIFVOs, SignOnUserAccount account) throws EventException;

	/**
	 *  Retrieve for found handling in case of Lost Chassis Movement -> EDI. Retrieve [EES_CGM_1018]<br>
	 *
	 * @param cHSFoundAutoMGTVO CHSFoundAutoMGTVO
	 * @return List<CHSFoundAutoMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<CHSFoundAutoMGTVO> searchCHSFoundAutoBasic(CHSFoundAutoMGTVO cHSFoundAutoMGTVO) throws EventException;

	/**
	 *  Retrieve for found handling in case of Lost Chassis Movement -> EDI. Delete [EES_CGM_1018]<br>
	 *
	 * @param cHSFoundAutoMGTVOs CHSFoundAutoMGTVO[]
	 * @param account SignOnUserAccount
	 * @exception DAOException
	 * @exception Exception
	 */
	public void manageCHSFoundAutoBasic(CHSFoundAutoMGTVO[] cHSFoundAutoMGTVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Lease Term Change (Chassis) - information save Manage [EES_CGM_1026]<br>
	 *
	 * @param cHSTermStatusINVOS CHSTermStatusINVO[]
	 * @param cHSTermStatusINVO CHSTermStatusINVO
	 * @param account SignOnUserAccount
	 * @exception DAOException
	 * @exception Exception
	 */
	public void manageCHSTermChangeBasic(CHSTermStatusINVO[] cHSTermStatusINVOS, CHSTermStatusINVO cHSTermStatusINVO, SignOnUserAccount account) throws EventException;

	/**
	 * Lease Term Change (Mgset) information save Manage [EES_CGM_2026]<br>
	 *
	 * @param mGSTermStatusINVOs MGSTermStatusINVO[]
	 * @param mGSTermStatusINVO MGSTermStatusINVO
	 * @param account SignOnUserAccount
	 * @exception DAOException
	 * @exception Exception
	 */
	public void manageMGSTermChangeBasic(MGSTermStatusINVO[] mGSTermStatusINVOs, MGSTermStatusINVO mGSTermStatusINVO, SignOnUserAccount account) throws EventException;


	/**
	 *  Eq Master information editing. Chassis Master Data Update<br>
	 *
	 * @param cHSMasterMGTVO CHSMasterMGTVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void modifyCHSCgmEquipmentBasic(CHSMasterMGTVO cHSMasterMGTVO) throws EventException;

	/**
	 *  LEq Damage, disposal Flagging management.. SAVE  [MNR call]<br>
	 *  Eq Retirement handling. SAVE  [MNR call]<br>
	 *
	 * @param iFMnrFlagVOs List<IFMnrFlagVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public void createMNRStatusBasic(List<IFMnrFlagVO> iFMnrFlagVOs) throws EventException;

	/**
	 * Lease Term Change (Chassis) - information save(BackEndJob) Manage [EES_CGM_1026]<br>
	 *
	 * @param  CHSTermStatusINVO[] cHSTermStatusINVOs
	 * @param  CHSTermStatusINVO cHSTermStatusINVO
	 * @param  SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String backEndCHSTermChangeListBasic(CHSTermStatusINVO[] cHSTermStatusINVOs, CHSTermStatusINVO cHSTermStatusINVO, SignOnUserAccount account) throws EventException;

	/**
	 * retrieving status value for BackEndJob result.<br>
	 *
	 * @param String key
	 * @return List<String>
	 * @exception EventException
	 */
	public List<String> searchComBackEndJobStatusBasic(String key) throws EventException;
	
	/**
	 *  Eq Master information editing. Mgset Master Data Update<br>
	 *
	 * @param cHSMasterMGTVO CHSMasterMGTVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void modifyMGSCgmEquipmentBasic(CHSMasterMGTVO cHSMasterMGTVO) throws EventException;
}
